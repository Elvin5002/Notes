package com.elvin.notes.dao

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.elvin.notes.model.Note
import kotlin.concurrent.Volatile

@Database(entities = [Note::class], version = 1)
abstract class NoteDatabase : RoomDatabase() {
    abstract fun getNoteDao(): NoteDao

    companion object{
        @Volatile //diger class tarafindan hemen gorulmesini saglar
        private var instance: NoteDatabase? = null
        private val LOCK =  Any() //sync security ucun istifade ol (asagi bi defe calisma saglar)

        operator fun invoke(context: Context) = instance?: //nesne cagir database yarat
            synchronized(LOCK){ //yaranib yaranmadigini yoxla
                instance?: //security icin 2 defe yoxla
                createDatabase(context).also{
                    instance = it
                }
            }

        private fun createDatabase(context: Context) =
            Room.databaseBuilder(
                context.applicationContext,
                NoteDatabase::class.java,
                "note_db"
            ).build()

    }

}