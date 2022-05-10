package com.example.myapplication.database

import android.annotation.SuppressLint
import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase

var currentUserID : Int = -1

class DatabaseManager(val context : Context) {
    val dbHelper = DatabaseHelper(context)
    var db : SQLiteDatabase? = null

    fun openDB()
    {
        db = dbHelper.writableDatabase
    }

    fun updateHistory(currentTask : Int, task_type : Int)
    {
        var columnName : String? = null

        when(task_type)
        {
            1 -> columnName = DatabaseNames.HISTORY_COLUMN_LDS_WORD_HISTORY
            2 -> columnName = DatabaseNames.HISTORY_COLUMN_LDS_PICTURE_HISTORY
            3 -> columnName = DatabaseNames.HISTORY_COLUMN_MDS_WORD_HISTORY
            4 -> columnName = DatabaseNames.HISTORY_COLUMN_MDS_SENTENCE_HISTORY
            5 -> columnName = DatabaseNames.HISTORY_COLUMN_HDS_WORD_HISTORY
            6 -> columnName = DatabaseNames.HISTORY_COLUMN_HDS_TRANSLATION_HISTORY
        }

        if (isTaskExist(currentTask+1, task_type)) {
            val values = ContentValues().apply {
                put(columnName, currentTask + 1)
            }

            val count = db?.update(
                DatabaseNames.HISTORY_TABLE_NAME,
                values,
                "${DatabaseNames.HISTORY_COLUMN_ID} = ?",
                arrayOf(currentUserID.toString()),
            )
        }
        else
        {
            val values = ContentValues().apply {
                put(columnName, 1)
            }

            val count = db?.update(
                DatabaseNames.HISTORY_TABLE_NAME,
                values,
                "${DatabaseNames.HISTORY_COLUMN_ID} = ?",
                arrayOf(currentUserID.toString()),
            )
        }
    }

    fun insertIntoUsersTable(user_name : String, user_password : String, user_email : String)
    {
        val values = ContentValues().apply {
            put(DatabaseNames.USER_COLUMN_NAME, user_name)
            put(DatabaseNames.USER_COLUMN_PASSWORD, user_password)
            put(DatabaseNames.USER_COLUMN_EMAIL, user_email)
        }

        db?.insert(DatabaseNames.USER_TABLE_NAME, null, values)
    }

    fun insertIntoHistoryTable(history_id : Int)
    {
        val values = ContentValues().apply {
            put(DatabaseNames.HISTORY_COLUMN_ID, history_id)
        }

        db?.insert(DatabaseNames.HISTORY_TABLE_NAME, null, values)
    }

    @SuppressLint("Range")
    fun isTaskExist(currentTask : Int, taskType: Int) : Boolean
    {
        var tableName : String? = null
        var taskID : String? = null

        when(taskType)
        {
            1 -> {
                tableName = DatabaseNames.LDS_WORD_TABLE_NAME
                taskID = DatabaseNames.LDS_WORD_COLUMN_ID
            }
            2 -> {
                tableName = DatabaseNames.LDS_PICTURE_TABLE_NAME
                taskID = DatabaseNames.LDS_PICTURE_COLUMN_ID
            }
            3 -> {
                tableName = DatabaseNames.MDS_MAKE_WORD_TABLE_NAME
                taskID = DatabaseNames.MDS_MAKE_WORD_COLUMN_ID
            }
            4 -> {
                tableName = DatabaseNames.MDS_MAKE_SENTENCE_TABLE_NAME
                taskID = DatabaseNames.MDS_MAKE_SENTENCE_COLUMN_ID
            }
            5 -> {
                tableName = DatabaseNames.HDS_CHOOSE_WORD_TABLE_NAME
                taskID = DatabaseNames.HDS_CHOOSE_WORD_COLUMN_ID
            }
            6 -> {
                tableName = DatabaseNames.HDS_TRANSLATION_TABLE_NAME
                taskID = DatabaseNames.HDS_TRANSLATION_COLUMN_ID
            }
        }

        val cursor = db?.query(
            tableName,
            null,
            "${taskID} = ?",
            arrayOf(currentTask.toString()),
            null,
            null,
            null
        )

        val dataList = ArrayList<String>()
        while (cursor?.moveToNext()!!)
        {
            val temp = cursor.getString(cursor.getColumnIndex(taskID))
            dataList.add(temp.toString())
        }

        if (dataList.size != 0) {
            cursor.close()
            return true
        }

        cursor.close()
        return false
    }

    @SuppressLint("Range")
    fun isUserExist(user_email : String, user_password : String): Boolean {
        val cursor = db?.query(
            DatabaseNames.USER_TABLE_NAME,
            null,
            "${DatabaseNames.USER_COLUMN_EMAIL} = ?",
            arrayOf(user_email),
            null,
            null,
            null
        )

        val dataList = ArrayList<String>()
        while (cursor?.moveToNext()!!)
        {
            var temp = cursor.getString(cursor.getColumnIndex(DatabaseNames.USER_COLUMN_PASSWORD))
            dataList.add(temp.toString())

            temp = cursor.getString(cursor.getColumnIndex(DatabaseNames.USER_COLUMN_ID))
            dataList.add(temp.toString())
        }

        if (dataList.size != 0 && dataList[0] == user_password) {
            currentUserID = dataList[1].toInt()
            insertIntoHistoryTable(currentUserID)
            cursor.close()
            return true
        }

        cursor.close()
        return false
    }

    @SuppressLint("Range")
    fun GetLdsWordInfo() : ArrayList<String>
    {
        val currentTask = GetCurrentTask(1)

        val dataList = ArrayList<String>()
        val cursor = db?.query(
            DatabaseNames.LDS_WORD_TABLE_NAME,
            null,
            "${DatabaseNames.LDS_WORD_COLUMN_ID} = ?",
            arrayOf(currentTask.toString()),
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

            temp = cursor.getString(cursor.getColumnIndex(DatabaseNames.LDS_WORD_COLUMN_ANSWERS))
            dataList.add(temp.toString())
        }

        cursor.close()

        updateHistory(currentTask, 1)

        return dataList
    }

    @SuppressLint("Range")
    fun GetLdsPictureInfo() : ArrayList<String>
    {
        val currentTask = GetCurrentTask(2)

        val dataList = ArrayList<String>()
        val cursor = db?.query(
            DatabaseNames.LDS_PICTURE_TABLE_NAME,
            null,
            "${DatabaseNames.LDS_PICTURE_COLUMN_ID} = ?",
            arrayOf(currentTask.toString()),
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

            temp = cursor.getString(cursor.getColumnIndex(DatabaseNames.LDS_PICTURE_COLUMN_ANSWERS))
            dataList.add(temp.toString())
        }

        cursor.close()

        updateHistory(currentTask, 2)

        return dataList
    }

    @SuppressLint("Range")
    fun GetMdsMakeWordInfo() : ArrayList<String>
    {
        val currentTask = GetCurrentTask(3)

        val dataList = ArrayList<String>()
        val cursor = db?.query(
            DatabaseNames.MDS_MAKE_WORD_TABLE_NAME,
            null,
            "${DatabaseNames.MDS_MAKE_WORD_COLUMN_ID} = ?",
            arrayOf(currentTask.toString()),
            null,
            null,
            null
        )

        while(cursor?.moveToNext()!!)
        {
            var temp = cursor.getString(cursor.getColumnIndex(DatabaseNames.MDS_MAKE_WORD_COLUMN_SKILL_TASK))
            dataList.add(temp.toString())

            temp = cursor.getString(cursor.getColumnIndex(DatabaseNames.MDS_MAKE_WORD_COLUMN_LETTER_LIST))
            dataList.add(temp.toString())

            temp = cursor.getString(cursor.getColumnIndex(DatabaseNames.MDS_MAKE_WORD_COLUMN_RIGHT_ANSWER))
            dataList.add(temp.toString())
        }

        cursor.close()

        updateHistory(currentTask, 3)

        return dataList
    }

    @SuppressLint("Range")
    fun GetMdsMakeSentenceInfo() : ArrayList<String>
    {
        val currentTask = GetCurrentTask(4)

        val dataList = ArrayList<String>()
        val cursor = db?.query(
            DatabaseNames.MDS_MAKE_SENTENCE_TABLE_NAME,
            null,
            "${DatabaseNames.MDS_MAKE_SENTENCE_COLUMN_ID} = ?",
            arrayOf(currentTask.toString()),
            null,
            null,
            null
        )

        while(cursor?.moveToNext()!!)
        {
            var temp = cursor.getString(cursor.getColumnIndex(DatabaseNames.MDS_MAKE_SENTENCE_COLUMN_WORD_LIST))
            dataList.add(temp.toString())

            temp = cursor.getString(cursor.getColumnIndex(DatabaseNames.MDS_MAKE_SENTENCE_COLUMN_RIGHT_ANSWER))
            dataList.add(temp.toString())
        }

        cursor.close()

        updateHistory(currentTask, 4)

        return dataList
    }

    @SuppressLint("Range")
    fun GetHdsChooseWordInfo() : ArrayList<String>
    {
        val currentTask = GetCurrentTask(5)

        val dataList = ArrayList<String>()
        val cursor = db?.query(
            DatabaseNames.HDS_CHOOSE_WORD_TABLE_NAME,
            null,
            "${DatabaseNames.HDS_CHOOSE_WORD_COLUMN_ID} = ?",
            arrayOf(currentTask.toString()),
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

            temp = cursor.getString(cursor.getColumnIndex(DatabaseNames.HDS_CHOOSE_WORD_COLUMN_ANSWERS))
            dataList.add(temp.toString())
        }

        cursor.close()

        updateHistory(currentTask, 5)

        return dataList
    }

    @SuppressLint("Range")
    fun GetHdsTranslationInfo() : ArrayList<String>
    {
        val currentTask = GetCurrentTask(6)

        val dataList = ArrayList<String>()
        val cursor = db?.query(
            DatabaseNames.HDS_TRANSLATION_TABLE_NAME,
            null,
            "${DatabaseNames.HDS_TRANSLATION_COLUMN_ID} = ?",
            arrayOf(currentTask.toString()),
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

        updateHistory(currentTask, 6)

        return dataList
    }

    @SuppressLint("Range")
    fun GetCurrentTask(task_type : Int) : Int
    {
        val dataList = ArrayList<String>()
        val cursor = db?.query(
            DatabaseNames.HISTORY_TABLE_NAME,
            null,
            "${DatabaseNames.HISTORY_COLUMN_ID} = ?",
            arrayOf(currentUserID.toString()),
            null,
            null,
            null
        )

        while(cursor?.moveToNext()!!)
        {
            var temp : String? = null

            when(task_type)
            {
                1 -> temp = cursor.getString(cursor.getColumnIndex(DatabaseNames.HISTORY_COLUMN_LDS_WORD_HISTORY))
                2 -> temp = cursor.getString(cursor.getColumnIndex(DatabaseNames.HISTORY_COLUMN_LDS_PICTURE_HISTORY))
                3 -> temp = cursor.getString(cursor.getColumnIndex(DatabaseNames.HISTORY_COLUMN_MDS_WORD_HISTORY))
                4 -> temp = cursor.getString(cursor.getColumnIndex(DatabaseNames.HISTORY_COLUMN_MDS_SENTENCE_HISTORY))
                5 -> temp = cursor.getString(cursor.getColumnIndex(DatabaseNames.HISTORY_COLUMN_HDS_WORD_HISTORY))
                6 -> temp = cursor.getString(cursor.getColumnIndex(DatabaseNames.HISTORY_COLUMN_HDS_TRANSLATION_HISTORY))
            }

            dataList.add(temp.toString())
        }

        cursor.close()
        return dataList[0].toInt()
    }

    fun closeDB()
    {
        dbHelper.close()
    }
}