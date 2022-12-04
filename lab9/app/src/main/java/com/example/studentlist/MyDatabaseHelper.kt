package com.example.studentlist

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class MyDatabaseHelper(private val context: Context?) : SQLiteOpenHelper(
    context, DATABASE_NAME, null, DATABASE_VERSION
) {
    override fun onCreate(db: SQLiteDatabase) {
        val query = "CREATE TABLE " + TABLE_NAME +
                " (" + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_NAME + " TEXT);"
        db.execSQL(query)
    }

    override fun onUpgrade(db: SQLiteDatabase, i: Int, i1: Int) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME)
        onCreate(db)
    }

    fun addStudent(name: String) {
        val db = this.writableDatabase
        val cv = ContentValues()

        cv.put(COLUMN_NAME, name)

        val result = db.insert(TABLE_NAME, null, cv)
        if (result == (-1).toLong()) {
            android.widget.Toast.makeText(context, "Failed", android.widget.Toast.LENGTH_SHORT)
                .show()
        } else {
            android.widget.Toast.makeText(
                context,
                "Added successfully!",
                android.widget.Toast.LENGTH_SHORT
            ).show()
        }
    }

    fun readData(): android.database.Cursor? {
        val db = this.readableDatabase
        val query = "SELECT * FROM " + TABLE_NAME
        return db.rawQuery(query, null)
    }

    fun deleteOneRow(name: String) {
        val db = this.writableDatabase
        val query = "DELETE FROM " + TABLE_NAME + " WHERE " + COLUMN_NAME + " = '" + name + "'"
        db.execSQL(query)
    }

    companion object {
        private const val DATABASE_NAME = "Student1.db"
        private const val DATABASE_VERSION = 1
        private const val TABLE_NAME = "my_students"
        private const val COLUMN_ID = "_id"
        private const val COLUMN_NAME = "student_name"
    }
}