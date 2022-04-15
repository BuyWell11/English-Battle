package com.example.myapplication.database

import android.annotation.SuppressLint
import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase

class DatabaseManager(val context : Context) {
    val dbHelper = DatabaseHelper(context)
    var db : SQLiteDatabase? = null

    fun openDB()
    {
        db = dbHelper.writableDatabase
    }

    fun insertDB(insert_data1 : String, insert_data2 : String)
    {
        val values = ContentValues().apply {

        }
    }

    @SuppressLint("Range")
    fun GetLdsWordInfo() : ArrayList<String>
    {
        val dataList = ArrayList<String>()
        val cursor = db?.query(
            DatabaseNames.LDS_WORD_TABLE_NAME,
            null,
            "${DatabaseNames.LDS_WORD_COLUMN_ID} = 1",
            null,
            null,
            null,
            null
        )

        while(cursor?.moveToNext()!!)
        {
            var temp = cursor.getString(cursor.getColumnIndex(DatabaseNames.LDS_WORD_COLUMN_TASK))
            dataList.add(temp.toString())

            temp = cursor.getString(cursor.getColumnIndex(DatabaseNames.LDS_WORD_COLUMN_RIGHT_ANSWER))
            dataList.add(temp.toString())

            temp = cursor.getString(cursor.getColumnIndex(DatabaseNames.LDS_WORD_COLUMN_ANSWER1))
            dataList.add(temp.toString())

            temp = cursor.getString(cursor.getColumnIndex(DatabaseNames.LDS_WORD_COLUMN_ANSWER2))
            dataList.add(temp.toString())

            temp = cursor.getString(cursor.getColumnIndex(DatabaseNames.LDS_WORD_COLUMN_ANSWER3))
            dataList.add(temp.toString())

            temp = cursor.getString(cursor.getColumnIndex(DatabaseNames.LDS_WORD_COLUMN_ANSWER4))
            dataList.add(temp.toString())
        }

        cursor.close()

        return dataList
    }

    @SuppressLint("Range")
    fun GetLdsPictureInfo() : ArrayList<String>
    {
        val dataList = ArrayList<String>()
        val cursor = db?.query(
            DatabaseNames.LDS_PICTURE_TABLE_NAME,
            null,
            "${DatabaseNames.LDS_PICTURE_COLUMN_ID} = 1",
            null,
            null,
            null,
            null
        )

        while(cursor?.moveToNext()!!)
        {
            var temp = cursor.getString(cursor.getColumnIndex(DatabaseNames.LDS_PICTURE_COLUMN_TASK))
            dataList.add(temp.toString())

            temp = cursor.getString(cursor.getColumnIndex(DatabaseNames.LDS_PICTURE_COLUMN_RIGHT_ANSWER))
            dataList.add(temp.toString())

            temp = cursor.getString(cursor.getColumnIndex(DatabaseNames.LDS_PICTURE_COLUMN_ANSWER1))
            dataList.add(temp.toString())

            temp = cursor.getString(cursor.getColumnIndex(DatabaseNames.LDS_PICTURE_COLUMN_ANSWER2))
            dataList.add(temp.toString())

            temp = cursor.getString(cursor.getColumnIndex(DatabaseNames.LDS_PICTURE_COLUMN_ANSWER3))
            dataList.add(temp.toString())

            temp = cursor.getString(cursor.getColumnIndex(DatabaseNames.LDS_PICTURE_COLUMN_ANSWER4))
            dataList.add(temp.toString())
        }

        cursor.close()

        return dataList
    }

    @SuppressLint("Range")
    fun GetHdsChooseWordInfo() : ArrayList<String>
    {
        val dataList = ArrayList<String>()
        val cursor = db?.query(
            DatabaseNames.HDS_CHOOSE_WORD_TABLE_NAME,
            null,
            "${DatabaseNames.HDS_CHOOSE_WORD_COLUMN_ID} = 1",
            null,
            null,
            null,
            null
        )

        while(cursor?.moveToNext()!!)
        {
            var temp = cursor.getString(cursor.getColumnIndex(DatabaseNames.HDS_CHOOSE_WORD_COLUMN_TASK))
            dataList.add(temp.toString())

            temp = cursor.getString(cursor.getColumnIndex(DatabaseNames.HDS_CHOOSE_WORD_COLUMN_RIGHT_ANSWER))
            dataList.add(temp.toString())

            temp = cursor.getString(cursor.getColumnIndex(DatabaseNames.HDS_CHOOSE_WORD_COLUMN_ANSWER1))
            dataList.add(temp.toString())

            temp = cursor.getString(cursor.getColumnIndex(DatabaseNames.HDS_CHOOSE_WORD_COLUMN_ANSWER2))
            dataList.add(temp.toString())

            temp = cursor.getString(cursor.getColumnIndex(DatabaseNames.HDS_CHOOSE_WORD_COLUMN_ANSWER3))
            dataList.add(temp.toString())

            temp = cursor.getString(cursor.getColumnIndex(DatabaseNames.HDS_CHOOSE_WORD_COLUMN_ANSWER4))
            dataList.add(temp.toString())
        }

        cursor.close()

        return dataList
    }

    @SuppressLint("Range")
    fun GetHdsTranslationInfo() : ArrayList<String>
    {
        val dataList = ArrayList<String>()
        val cursor = db?.query(
            DatabaseNames.HDS_TRANSLATION_TABLE_NAME,
            null,
            "${DatabaseNames.HDS_TRANSLATION_COLUMN_ID} = 1",
            null,
            null,
            null,
            null
        )

        while(cursor?.moveToNext()!!)
        {
            var temp = cursor.getString(cursor.getColumnIndex(DatabaseNames.HDS_TRANSLATION_COLUMN_TASK))
            dataList.add(temp.toString())

            temp = cursor.getString(cursor.getColumnIndex(DatabaseNames.HDS_TRANSLATION_COLUMN_RIGHT_ANSWER))
            dataList.add(temp.toString())
        }

        cursor.close()

        return dataList
    }

    fun closeDB()
    {
        dbHelper.close()
    }
}