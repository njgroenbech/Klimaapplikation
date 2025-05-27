package com.example.klimaaktion.network

import android.util.Log
import com.example.klimaaktion.model.firebasemodel.Group
import com.example.klimaaktion.model.firebasemodel.SchoolClass
import com.example.klimaaktion.model.firebasemodel.Student
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FieldValue
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
                studentId = firebaseUser.uid,
                username = username,
                classId = classId,
                groupId = null
            )

            // tilføj instance af student til database
            db.collection("students")
                .document(student.studentId)
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
                ?.copy(studentId = studentData.id)
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
            it.toObject(Group::class.java)?.copy(groupId = it.id)
        }
    }



    ////////



    /**
     * Opretter en ny gruppe under feltet "groups.<groupKey>" med point=0 og tom liste af students.
     * groupKey er den Map-nøgle du vil bruge (fx gruppe-navnet).
     */

    suspend fun createGroupInClass(
        classId:  String,
        groupKey: String,
        groupName:String
    ): Result<Unit> = runCatching {
        val newGroup = Group(
            name     = groupName,
            points    = 0,
            students = emptyList()
        )
        db.collection("classestest")
            .document(classId)
            .update("groups.$groupKey", newGroup)
            .await()
    }



    /**
     * Tilføjer pointsToAdd til den enkelte gruppes point-felt
     * og opdaterer samtidig classpoints for hele klassen.
     */
    suspend fun addPointsToGroup(
        classId:      String,
        groupKey:     String,
        pointsToAdd:  Int
    ): Result<Unit> = runCatching {
        val classRef = db.collection("classestest").document(classId)

        // 1) Atomic increment af netop den gruppes point
        classRef
            .update("groups.$groupKey.point", FieldValue.increment(pointsToAdd.toLong()))
            .await()

        classRef
            .update("classpoints", FieldValue.increment(pointsToAdd.toLong()))
            .await()

    }
}
