package com.example.myapplication.database

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DatabaseHelper(context : Context) : SQLiteOpenHelper(context, DatabaseNames.DATABASE_NAME, null, DatabaseNames.DATABASE_VERSION) {
    override fun onCreate(db: SQLiteDatabase?) {
        //Table users
        db?.execSQL(DatabaseNames.USER_CREATE_TABLE)

        //Table history
        db?.execSQL(DatabaseNames.HISTORY_CREATE_TABLE)

        //Table lds_word
        db?.execSQL(DatabaseNames.LDS_WORD_CREATE_TABLE)
        db?.execSQL(DatabaseNames.LDS_WORD_INSERT)

        //Table lds_picture
        db?.execSQL(DatabaseNames.LDS_PICTURE_CREATE_TABLE)
        db?.execSQL(DatabaseNames.LDS_PICTURE_INSERT)

        //Table hds_choose_word
        db?.execSQL(DatabaseNames.HDS_CHOOSE_WORD_CREATE_TABLE)
        db?.execSQL(DatabaseNames.HDS_CHOOSE_WORD_INSERT)

        //Table hds_translation
        db?.execSQL(DatabaseNames.HDS_TRANSLATION_CREATE_TABLE)
        db?.execSQL(DatabaseNames.HDS_TRANSLATION_INSERT)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db?.execSQL(DatabaseNames.USER_DELETE_TABLE)
        db?.execSQL(DatabaseNames.HISTORY_DELETE_TABLE)
        db?.execSQL(DatabaseNames.LDS_WORD_DELETE_TABLE)
        db?.execSQL(DatabaseNames.LDS_PICTURE_DELETE_TABLE)
        db?.execSQL(DatabaseNames.HDS_CHOOSE_WORD_DELETE_TABLE)
        db?.execSQL(DatabaseNames.HDS_TRANSLATION_DELETE_TABLE)

        onCreate(db)
    }
}