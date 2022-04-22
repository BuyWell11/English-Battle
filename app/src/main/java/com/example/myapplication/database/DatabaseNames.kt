package com.example.myapplication.database

import android.provider.BaseColumns

object DatabaseNames : BaseColumns {
    const val DATABASE_NAME = "eng_app.db"
    const val DATABASE_VERSION = 12


    //Table "users"
    const val USER_TABLE_NAME = "users"
    const val USER_COLUMN_ID = "user_id"
    const val USER_COLUMN_NAME = "user_name"
    const val USER_COLUMN_PASSWORD = "user_password"
    const val USER_COLUMN_EMAIL = "user_email"
    const val USER_COLUMN_AVATAR = "user_avatar"
    const val USER_COLUMN_HISTORY = "user_history_id"

    const val USER_CREATE_TABLE =
        "CREATE TABLE IF NOT EXISTS $USER_TABLE_NAME(" +
                "$USER_COLUMN_ID INTEGER PRIMARY KEY," +
                "$USER_COLUMN_NAME TEXT NOT NULL," +
                "$USER_COLUMN_PASSWORD TEXT NOT NULL," +
                "$USER_COLUMN_EMAIL TEXT NOT NULL," +
                "$USER_COLUMN_AVATAR TEXT NOT NULL," +
                "$USER_COLUMN_HISTORY INTEGER NOT NULL);"

    const val USER_DELETE_TABLE = "DROP TABLE IF EXISTS $USER_TABLE_NAME ;"


    //Table "history"
    const val HISTORY_TABLE_NAME = "history"
    const val HISTORY_COLUMN_ID = "history_id"
    const val HISTORY_COLUMN_LDS_PICTURE_HISTORY = "lds_picture_history"
    const val HISTORY_COLUMN_LDS_WORD_HISTORY = "lds_word_history"
    const val HISTORY_COLUMN_MDS_SENTENCE_HISTORY = "mds_make_sentence_history"
    const val HISTORY_COLUMN_MDS_WORD_HISTORY = "mds_make_word_history"
    const val HISTORY_COLUMN_HDS_WORD_HISTORY = "hds_choose_word_history"
    const val HISTORY_COLUMN_HDS_TRANSLATION_HISTORY = "hds_translation_history"
    const val HISTORY_COLUMN_TOTAL_COMPLETED_LVLS = "total_completed_lvls"
    const val HISTORY_COLUMN_CURRENT_LEVEL = "current_level"

    const val HISTORY_CREATE_TABLE =
        "CREATE TABLE IF NOT EXISTS $HISTORY_TABLE_NAME(" +
                "$HISTORY_COLUMN_ID INTEGER PRIMARY KEY," +
                "$HISTORY_COLUMN_LDS_PICTURE_HISTORY INTEGER DEFAULT 1," +
                "$HISTORY_COLUMN_LDS_WORD_HISTORY INTEGER DEFAULT 1," +
                "$HISTORY_COLUMN_MDS_SENTENCE_HISTORY INTEGER DEFAULT 1," +
                "$HISTORY_COLUMN_MDS_WORD_HISTORY INTEGER DEFAULT 1," +
                "$HISTORY_COLUMN_HDS_WORD_HISTORY INTEGER DEFAULT 1," +
                "$HISTORY_COLUMN_HDS_TRANSLATION_HISTORY INTEGER DEFAULT 1," +
                "$HISTORY_COLUMN_TOTAL_COMPLETED_LVLS INTEGER," +
                "$HISTORY_COLUMN_CURRENT_LEVEL INTEGER DEFAULT 1);"

    const val HISTORY_DELETE_TABLE = "DROP TABLE IF EXISTS $HISTORY_COLUMN_ID ;"


    //Table "lds_word"
    const val LDS_WORD_TABLE_NAME = "lds_word"
    const val LDS_WORD_COLUMN_ID = "skill_id"
    const val LDS_WORD_COLUMN_TASK = "skill_task"
    const val LDS_WORD_COLUMN_RIGHT_ANSWER = "right_answer"
    const val LDS_WORD_COLUMN_ANSWERS = "answer_options"

    const val LDS_WORD_CREATE_TABLE =
        "CREATE TABLE IF NOT EXISTS $LDS_WORD_TABLE_NAME(" +
                "$LDS_WORD_COLUMN_ID INTEGER PRIMARY KEY," +
                "$LDS_WORD_COLUMN_TASK TEXT NOT NULL," +
                "$LDS_WORD_COLUMN_RIGHT_ANSWER TEXT NOT NULL," +
                "$LDS_WORD_COLUMN_ANSWERS TEXT NOT NULL);"

    const val LDS_WORD_DELETE_TABLE = "DROP TABLE IF EXISTS $LDS_WORD_TABLE_NAME ;"
    const val LDS_WORD_INSERT = "INSERT INTO $LDS_WORD_TABLE_NAME ($LDS_WORD_COLUMN_ID , $LDS_WORD_COLUMN_TASK ," +
            "$LDS_WORD_COLUMN_RIGHT_ANSWER , $LDS_WORD_COLUMN_ANSWERS )" +
            "VALUES(1, 'Собака', 'dog', 'cat dog rat house');"


    //Table "lds_picture"
    const val LDS_PICTURE_TABLE_NAME = "lds_picture"
    const val LDS_PICTURE_COLUMN_ID = "skill_id"
    const val LDS_PICTURE_COLUMN_TASK = "task_picture"
    const val LDS_PICTURE_COLUMN_RIGHT_ANSWER = "right_answer"
    const val LDS_PICTURE_COLUMN_ANSWERS = "answer_options"

    const val LDS_PICTURE_CREATE_TABLE =
        "CREATE TABLE IF NOT EXISTS $LDS_PICTURE_TABLE_NAME(" +
                "$LDS_PICTURE_COLUMN_ID INTEGER PRIMARY KEY," +
                "$LDS_PICTURE_COLUMN_TASK TEXT NOT NULL," +
                "$LDS_PICTURE_COLUMN_RIGHT_ANSWER TEXT NOT NULL," +
                "$LDS_PICTURE_COLUMN_ANSWERS TEXT NOT NULL);"

    const val LDS_PICTURE_DELETE_TABLE = "DROP TABLE IF EXISTS $LDS_PICTURE_TABLE_NAME ;"
    const val LDS_PICTURE_INSERT = "INSERT INTO $LDS_PICTURE_TABLE_NAME ($LDS_PICTURE_COLUMN_ID , $LDS_PICTURE_COLUMN_TASK ," +
            "$LDS_PICTURE_COLUMN_RIGHT_ANSWER , $LDS_PICTURE_COLUMN_ANSWERS )" +
            "VALUES(1, 'https://clipart-best.com/img/table/table-clip-art-4.png', 'table', 'monster table sky city');"


    //Table "mds_make_sentence"
    const val MDS_MAKE_SENTENCE_TABLE_NAME = "mds_make_sentence"
    const val MDS_MAKE_SENTENCE_COLUMN_ID = "skill_id"
    const val MDS_MAKE_SENTENCE_COLUMN_WORD_LIST = "word_list"
    const val MDS_MAKE_SENTENCE_COLUMN_RIGHT_ANSWER = "right_answer"

    const val MDS_MAKE_SENTENCE_CREATE_TABLE =
        "CREATE TABLE IF NOT EXISTS $MDS_MAKE_SENTENCE_TABLE_NAME(" +
                "$MDS_MAKE_SENTENCE_COLUMN_ID INTEGER PRIMARY KEY," +
                "$MDS_MAKE_SENTENCE_COLUMN_WORD_LIST TEXT NOT NULL," +
                "$MDS_MAKE_SENTENCE_COLUMN_RIGHT_ANSWER TEXT NOT NULL);"

    const val MDS_MAKE_SENTENCE_DELETE_TABLE = "DROP TABLE IF EXISTS $MDS_MAKE_SENTENCE_TABLE_NAME ;"
    const val MDS_MAKE_SENTENCE_INSERT = "INSERT INTO $MDS_MAKE_SENTENCE_TABLE_NAME ($MDS_MAKE_SENTENCE_COLUMN_ID , $MDS_MAKE_SENTENCE_COLUMN_WORD_LIST ," +
            "$MDS_MAKE_SENTENCE_COLUMN_RIGHT_ANSWER )" +
            "VALUES(1, 'friend doctor is my a', 'myfriendisadoctor');"


    //Table "mds_make_word"
    const val MDS_MAKE_WORD_TABLE_NAME = "mds_make_word"
    const val MDS_MAKE_WORD_COLUMN_ID = "skill_id"
    const val MDS_MAKE_WORD_COLUMN_SKILL_TASK = "skill_task"
    const val MDS_MAKE_WORD_COLUMN_LETTER_LIST = "letter_list"
    const val MDS_MAKE_WORD_COLUMN_RIGHT_ANSWER = "right_answer"

    const val MDS_MAKE_WORD_CREATE_TABLE =
        "CREATE TABLE IF NOT EXISTS $MDS_MAKE_WORD_TABLE_NAME(" +
                "$MDS_MAKE_WORD_COLUMN_ID INTEGER PRIMARY KEY," +
                "$MDS_MAKE_WORD_COLUMN_SKILL_TASK TEXT NOT NULL," +
                "$MDS_MAKE_WORD_COLUMN_LETTER_LIST TEXT NOT NULL," +
                "$MDS_MAKE_WORD_COLUMN_RIGHT_ANSWER TEXT NOT NULL);"

    const val MDS_MAKE_WORD_DELETE_TABLE = "DROP TABLE IF EXISTS $MDS_MAKE_WORD_TABLE_NAME ;"
    const val MDS_MAKE_WORD_INSERT = "INSERT INTO $MDS_MAKE_WORD_TABLE_NAME ($MDS_MAKE_WORD_COLUMN_ID , $MDS_MAKE_WORD_COLUMN_SKILL_TASK ," +
            "$MDS_MAKE_WORD_COLUMN_LETTER_LIST, $MDS_MAKE_WORD_COLUMN_RIGHT_ANSWER )" +
            "VALUES(1, 'Выбор', 'c o e h c i', 'choice');"


    //Table "hds_choose_word"
    const val HDS_CHOOSE_WORD_TABLE_NAME = "hds_choose_word"
    const val HDS_CHOOSE_WORD_COLUMN_ID = "skill_id"
    const val HDS_CHOOSE_WORD_COLUMN_TASK = "skill_task"
    const val HDS_CHOOSE_WORD_COLUMN_RIGHT_ANSWER = "right_answer"
    const val HDS_CHOOSE_WORD_COLUMN_ANSWERS = "answer_options"

    const val HDS_CHOOSE_WORD_CREATE_TABLE =
        "CREATE TABLE IF NOT EXISTS $HDS_CHOOSE_WORD_TABLE_NAME(" +
                "$HDS_CHOOSE_WORD_COLUMN_ID INTEGER PRIMARY KEY," +
                "$HDS_CHOOSE_WORD_COLUMN_TASK TEXT NOT NULL," +
                "$HDS_CHOOSE_WORD_COLUMN_RIGHT_ANSWER TEXT NOT NULL," +
                "$HDS_CHOOSE_WORD_COLUMN_ANSWERS TEXT NOT NULL);"

    const val HDS_CHOOSE_WORD_DELETE_TABLE = "DROP TABLE IF EXISTS $HDS_CHOOSE_WORD_TABLE_NAME ;"
    const val HDS_CHOOSE_WORD_INSERT = "INSERT INTO $HDS_CHOOSE_WORD_TABLE_NAME ($HDS_CHOOSE_WORD_COLUMN_ID , $HDS_CHOOSE_WORD_COLUMN_TASK ," +
            "$HDS_CHOOSE_WORD_COLUMN_RIGHT_ANSWER , $HDS_CHOOSE_WORD_COLUMN_ANSWERS )" +
            "VALUES(1, 'Have you ever been __ London?', 'to', 'in from at to');"


    //Table "hds_translation"
    const val HDS_TRANSLATION_TABLE_NAME = "hds_translation"
    const val HDS_TRANSLATION_COLUMN_ID = "skill_id"
    const val HDS_TRANSLATION_COLUMN_TASK = "skill_task"
    const val HDS_TRANSLATION_COLUMN_RIGHT_ANSWER = "right_answer"

    const val HDS_TRANSLATION_CREATE_TABLE =
        "CREATE TABLE IF NOT EXISTS $HDS_TRANSLATION_TABLE_NAME(" +
                "$HDS_TRANSLATION_COLUMN_ID INTEGER PRIMARY KEY," +
                "$HDS_TRANSLATION_COLUMN_TASK TEXT NOT NULL," +
                "$HDS_TRANSLATION_COLUMN_RIGHT_ANSWER TEXT NOT NULL);"

    const val HDS_TRANSLATION_DELETE_TABLE = "DROP TABLE IF EXISTS $HDS_TRANSLATION_TABLE_NAME ;"
    const val HDS_TRANSLATION_INSERT = "INSERT INTO $HDS_TRANSLATION_TABLE_NAME ($HDS_TRANSLATION_COLUMN_ID , $HDS_TRANSLATION_COLUMN_TASK ," +
            "$HDS_TRANSLATION_COLUMN_RIGHT_ANSWER )" +
            "VALUES(1, 'Аномальный', 'abnormal');"
}