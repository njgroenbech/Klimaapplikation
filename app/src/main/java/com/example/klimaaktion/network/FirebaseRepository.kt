package com.example.klimaaktion.network

import com.example.klimaaktion.model.firebasemodel.Group
import com.example.klimaaktion.model.firebasemodel.SchoolClass
import com.example.klimaaktion.model.firebasemodel.Student
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FieldValue
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.tasks.await


// Repository skrevet af Nicholas, brugt AI som hjælpemiddel til løsningsforslag + YouTube

class FirebaseRepository(
    private val authentication: FirebaseAuth = FirebaseAuth.getInstance(),
    private val db: FirebaseFirestore = FirebaseFirestore.getInstance()
) {

    suspend fun getAllClasses(): List<SchoolClass> {
        val query = db.collection("classes")
            .get()
            .await()
        return query.documents.mapNotNull {
            it.toObject(SchoolClass::class.java)?.copy(id = it.id)
        }
    }

    suspend fun registerStudent(
        username: String,
        password: String,
        classId: String,
        groupId: String?
    ): Result<Student> {
        return try {
            val fakeEmail = "${username}@ignorethis.local"
            val result = authentication
                .createUserWithEmailAndPassword(fakeEmail, password)
                .await()

            val firebaseUser = result.user!!

            val student = Student(
                id = firebaseUser.uid,
                username= username,
                classId = classId,
                groupId = groupId
            )

            // Hvis der ikke er valgt en gruppe, kan man ikke registrere
            if (groupId != null) {
                // Tilføj student til student collection
                db.collection("students")
                    .document(student.id)
                    .set(student)
                    .await()

                // Tilføj gruppe til gruppe collection og opdater med student ID
                db.collection("groups")
                    .document(groupId)
                    .update("students", FieldValue.arrayUnion(student.id))
                    .await()

                // Tilføj til classes og opdater classes til at indholde student ID
                db.collection("classes")
                    .document(classId)
                    .update("students", FieldValue.arrayUnion(student.id))
                    .await()
            }

            Result.success(student)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    suspend fun createGroup(group: Group): Group {
        // Laver vores gruppe dokument i db
        val docRef = db.collection("groups").document()
        val newGroup = group.copy(id = docRef.id)
        docRef.set(newGroup).await()

        // Tilføjer gruppeId til den specifikke klasse
        db.collection("classes")
            .document(newGroup.classId)
            .update("groups", FieldValue.arrayUnion(newGroup.id))
            .await()
        return newGroup
    }

    suspend fun loginStudent(
        username: String,
        password: String
    ): Result<Student> {
        return try {
            // samme trick som før
            val fakeEmail = "$username@ignorethis.local"
            val result = authentication.signInWithEmailAndPassword(fakeEmail, password).await()


            val uid = result.user!!.uid
            val studentData = db.collection("students").document(uid).get().await()

            val studentObjectCopy = studentData.toObject(Student::class.java)
                ?.copy(id = studentData.id)
                ?: throw Exception ("Student data not found")

            Result.success(studentObjectCopy)
        } catch(e: Exception) {
            Result.failure(e)
        }
    }

    suspend fun getGroupsForClass(classId: String): List<Group> {
        val query = db.collection("groups")
            .whereEqualTo("classId", classId)
            .get()
            .await()
        return query.documents.mapNotNull {
            it.toObject(Group::class.java)?.copy(id = it.id)
        }
    }

}