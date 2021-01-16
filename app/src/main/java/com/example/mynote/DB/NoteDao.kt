package com.example.mynote.DB

import androidx.room.*

/*
    ***************************************** For Learning *************************************************
    *
      What is DAO -    DAOs are responsible for defining the methods that access the database.
       In the initial SQLite, we use the Cursor objects.
       With Room, we don’t need all the Cursor related code and can simply define our queries using annotations in the Dao class.
 */

@Dao
interface NoteDao {

    @Insert
    suspend fun addNote(note: Note)

    @Query("SELECT * FROM note ORDER BY id DESC")
    suspend fun getAllNotes() : List<Note>

    @Insert
    suspend fun addMultipleNotes(vararg note: Note)

    @Update
    suspend fun updateNote(note: Note)

    @Delete
    suspend fun deleteNote(note: Note)
}