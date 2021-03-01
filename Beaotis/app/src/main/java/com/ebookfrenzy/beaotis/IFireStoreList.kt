package com.ebookfrenzy.beaotis

import com.ebookfrenzy.beaotis.markyourheard.IAsyncFireHandler
import com.google.android.gms.tasks.Task
import com.google.firebase.firestore.DocumentSnapshot
import com.google.firebase.firestore.FirebaseFirestore

interface IFireStoreList:IAsyncFireHandler {
     fun getFirestoreList(task: Task<DocumentSnapshot>,string: String,asynchTask: IAsyncFireHandler) {
        val liste:MutableList<String>?= mutableListOf()
        task.addOnSuccessListener {
            if(it!=null){
                println("HEY")
                liste?.addAll(it.get(string) as MutableList<String>)
                println(liste)
                asynchTask.onCallBack(liste)
            }else
                println("NOOO")
        }

    }
    fun getGroupOne(db:FirebaseFirestore): MutableList<String>?{
        var liste:MutableList<String>?= mutableListOf()
        val groupOne =db.document("animal_voices/level_one")
        db.runTransaction {
            groupOne.get().addOnSuccessListener {
                if(it!=null) {
                    liste = it.get("first") as MutableList<String>
                    println("Neden çalışmıyosun")
                    println(liste)
                    //asynchTask.onCallBack(liste)
                }
            }.addOnFailureListener {
                println("FireStore bilgileri alınamadı. $it")
            }
        }
        println(liste)
        return liste
    }
    fun getFirestoreListSon(task: Task<DocumentSnapshot>,string: String,db:FirebaseFirestore,asynchTask:IAsyncFireHandler): MutableList<String>? {
        var liste:MutableList<String>?= mutableListOf()
        task.addOnCompleteListener {
            println("HEY")
            liste=it as MutableList<String>
            println(liste)
            asynchTask.onCallBack(liste)
        }
        println("liste= $liste")
        return liste
    }
}