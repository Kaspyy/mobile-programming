package com.example.studentlist

import android.annotation.SuppressLint
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
        val cv = android.content.ContentValues()

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

    @SuppressLint("Recycle")
    fun readAllData(): android.database.Cursor {
        val query = "SELECT * FROM $TABLE_NAME"
        val db = this.readableDatabase
        var cursor: android.database.Cursor? = null

        if (db != null) {
            cursor = db.rawQuery(query, null)
        }
        return cursor!!
    }

    fun updateData(id: String?, name: String?) {
        val db = this.writableDatabase
        val cv = android.content.ContentValues()

        cv.put(COLUMN_NAME, name)

        val result = db.update(TABLE_NAME, cv, "ID=?", arrayOf(id))
        if (result == -1) {
            android.widget.Toast.makeText(context, "Failed", android.widget.Toast.LENGTH_SHORT)
                .show()
        } else {
            android.widget.Toast.makeText(
                context,
                "Updated successfully!",
                android.widget.Toast.LENGTH_SHORT
            ).show()
        }
    }

    companion object {
        private const val DATABASE_NAME = "Student.db"
        private const val DATABASE_VERSION = 1
        private const val TABLE_NAME = "my_students"
        private const val COLUMN_ID = "_id"
        private const val COLUMN_NAME = "student_name"
    }
}