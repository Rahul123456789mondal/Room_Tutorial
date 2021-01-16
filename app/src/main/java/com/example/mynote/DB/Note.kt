package com.example.mynote.DB

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

/*
    **************************************** For Learning **********************************
        1. Entity - Represents a table within the database. Room creates a table for each class that has @Entity annotation, the fields in the class correspond to columns in the table. Therefore, the entity classes tend to be small model classes that don’t contain any logic.
                    Entities annotations
        Before we get started with modeling our entities, we need to know some useful annotations and their attributes.

        @Entity — every model class with this annotation will have a mapping table in DB
        foreignKeys — names of foreign keys
        indices — list of indicates on the table
        primaryKeys — names of entity primary keys
        tableName

        @PrimaryKey — as its name indicates, this annotation points the primary key of the entity. autoGenerate — if set to true, then SQLite will be generating a unique id for the column

        @PrimaryKey(autoGenerate = true)

        @ColumnInfo — allows specifying custom information about column

        @ColumnInfo(name = “column_name”)

        @Ignore — field will not be persisted by Room

        @Embeded — nested fields can be referenced directly in the SQL queries.
 */
@Entity
data class Note(
        @PrimaryKey(autoGenerate = true)
        val id : Int,
        @ColumnInfo(name = "Title")
        val title : String,
        val note : String

)
