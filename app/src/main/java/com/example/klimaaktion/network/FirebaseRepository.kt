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

    /* mangler funktioner der returnerer "current student"

     */

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