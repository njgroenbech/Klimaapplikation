package com.example.klimaaktion.network

import com.example.klimaaktion.model.firebasemodel.Group
import com.example.klimaaktion.model.firebasemodel.SchoolClass
import com.example.klimaaktion.model.firebasemodel.Student
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.tasks.await


// Repository skrevet af Nicholas
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
        classId: String
    ): Result<Student> {
        return try {
            // laver en fake email for at "bypasse" createUserWithEmailAndPassword funktionen
            // igennem firebase auth
            val fakeEmail = "${username}@ignorethis.local"
            val result = authentication.createUserWithEmailAndPassword(fakeEmail, password).await()


            val firebaseUser = result.user!! // lave non nullability af denne instance af result

            val student = Student(
                id = firebaseUser.uid,
                username = username,
                classId = classId,
                groupId = null
            )

            // tilføj instance af student til database
            db.collection("students")
                .document(student.id)
                .set(student)
                .await()
            Result.success(student)

        } catch (e: Exception) {
            Result.failure(e)
        }
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
            .whereEqualTo("classId", classId) // check if classId is correct
            .get()
            .await()
        return query.documents.mapNotNull {
            it.toObject(Group::class.java)?.copy(id = it.id)
        }
    }

}