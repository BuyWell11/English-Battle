package com.example.myapplication.database

import android.provider.BaseColumns

object DatabaseNames : BaseColumns {
    const val DATABASE_NAME = "eng_app.db"
    const val DATABASE_VERSION = 23


    //Table "users"
    const val USER_TABLE_NAME = "users"
    const val USER_COLUMN_ID = "user_id"
    const val USER_COLUMN_NAME = "user_name"
    const val USER_COLUMN_PASSWORD = "user_password"
    const val USER_COLUMN_EMAIL = "user_email"

    const val USER_CREATE_TABLE =
        "CREATE TABLE IF NOT EXISTS $USER_TABLE_NAME(" +
                "$USER_COLUMN_ID INTEGER PRIMARY KEY," +
                "$USER_COLUMN_NAME TEXT NOT NULL," +
                "$USER_COLUMN_PASSWORD TEXT NOT NULL," +
                "$USER_COLUMN_EMAIL TEXT NOT NULL);"

    const val USER_DELETE_TABLE = "DROP TABLE IF EXISTS $USER_TABLE_NAME ;"


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
            "VALUES(1, 'Собака', 'dog', 'cat dog rat house')," +
            "(2, 'Кот', 'cat', 'cat tiger mouse horse')," +
            "(3, 'Одежда', 'clothes', 'close clothes duck trade')," +
            "(4, 'Город', 'city', 'country sign road city')," +
            "(5, 'Мечта', 'dream', 'sun son dream cream')," +
            "(6, 'Планета', 'planet', 'planet Earth ground world')," +
            "(7, 'Работа', 'work', 'word wolf work world')," +
            "(8, 'Улица', 'street', 'air start beat street')," +
            "(9, 'Огонь', 'fire', 'flier crowd mine fire')," +
            "(10, 'Воздух', 'air', 'horse open air chair')," +
            "(11, 'Мясо', 'meat', 'meat meet matt egg')," +
            "(12, 'Книга', 'book', 'grave back book block')," +
            "(13, 'Настенные часы', 'clock', 'watch mark clock wash')," +
            "(14, 'Машина', 'car', 'cat car rock put')," +
            "(15, 'Волк', 'wolf', 'done dog pet wolf')," +
            "(16, 'Автобус', 'bus', 'bus grass glass zero')," +
            "(17, 'Цветок', 'flower', 'flower, father, lover, daisy')," +
            "(18, 'Мама', 'mother', 'might figure mother brother')," +
            "(19, 'Любовь', 'love', 'fame love life live')," +
            "(20, 'Солнце', 'sun', 'son sam light sun');"


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
            "VALUES(1, 'https://images.pexels.com/photos/1454806/pexels-photo-1454806.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=750&w=1260', 'bed', 'monster bed sky city')," +
            "(2, 'https://images.pexels.com/photos/416160/pexels-photo-416160.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=750&w=1260', 'cat', 'cat cut cot dog')," +
            "(3, 'https://images.pexels.com/photos/1396122/pexels-photo-1396122.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=750&w=1260', 'house', 'bridge world house row')," +
            "(4, 'https://images.pexels.com/photos/1146706/pexels-photo-1146706.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=750&w=1260', 'tree', 'mouse tree sky forest')," +
            "(5, 'https://images.pexels.com/photos/4048081/pexels-photo-4048081.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=750&w=1260', 'bath', 'street water path bath')," +
            "(6, 'https://images.pexels.com/photos/773253/pexels-photo-773253.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=750&w=1260', 'cheese', 'cheese eat food apple')," +
            "(7, 'https://images.pexels.com/photos/367915/pexels-photo-367915.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=750&w=1260', 'pizza', 'pasta tomato pie pizza')," +
            "(8, 'https://images.pexels.com/photos/7223322/pexels-photo-7223322.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=750&w=1260', 'cucumber', 'cucumber voice roll tea')," +
            "(9, 'https://images.pexels.com/photos/302899/pexels-photo-302899.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=750&w=1260', 'coffee', 'tea coffee camp woods')," +
            "(10, 'https://images.pexels.com/photos/47344/dollar-currency-money-us-dollar-47344.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=750&w=1260', 'money', 'wallet ring rank money');"


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
            "VALUES(1, 'friend doctor is My a', 'Myfriendisadoctor')," +
            "(2, '7 shop The at closes', 'Theshopclosesat7')," +
            "(3, 'me to introduced sister He her', 'Heintroducedhersistertome')," +
            "(4, 'need I to homework my do', 'Ineedtodomyhomework')," +
            "(5, 'to wants go He her with out', 'Hewontstogooutwithher')," +
            "(6, 'imagine she You was happy cannot how', 'Youcannotimaginehowhappyshewas')," +
            "(7, 'bit He father is his a like', 'Heisabitlikehisfather')," +
            "(8, 'game will exciting think be the I', 'Ithinkthegamewillbeexciting')," +
            "(9, 'is It to too him late visit', 'Itistoolatetovisithim')," +
            "(10, 'You can just press the button :)', 'Youcanjustpressthebutton:)')," +
            "(11, 'to off where I get know the bus', 'Iknowwheretogetoffthebus')," +
            "(12, 'not has That in happened years', 'Thathasnothappenedinyears')," +
            "(13, 'not opportunity miss this Do', 'Donotmissthisopportunity')," +
            "(14, 'He away from stayed for a school week', 'Hestayedawayfromschoolforaweek')," +
            "(15, 'should said not I that have', 'Ishouldnothavesaidthat')," +
            "(16, 'arrived this early Tom morning', 'Tomarrivedearlythismorning')," +
            "(17, 'seems That enough reasonable', 'Thatseemsreasonableenough')," +
            "(18, 'could put I not laugh but at joke the', 'Icouldnotbutlaughatthejoke')," +
            "(19, 'Tom to I ready Tell am go', 'TellTomIamreadytogo')," +
            "(20, 'wants to Jack a be designer', 'Jackwantstobeadesigner');"


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
            "VALUES(1, 'Выбор', 'c o e h c i', 'choice')," +
            "(2, 'Голубь', 'p e o n g i', 'pigeon')," +
            "(3, 'Страхование', 's u r i c n a n e', 'insurance')," +
            "(4, 'Шаблон', 't e n r t p a', 'pattern')," +
            "(5, 'Обои', 'a p l r l e p w a', 'wallpaper')," +
            "(6, 'Психология', 's y p l o o c h y g', 'psychology')," +
            "(7, 'Голос', 'i c v o e', 'voice')," +
            "(8, 'Изумруд', 'm e e a r l d', 'emerald')," +
            "(9, 'Рецепт', 'c r e p i e', 'recipe')," +
            "(10, 'Личность', 'r e s p o i y l t n a', 'personality')," +
            "(11, 'Коллега', 'l o c l g u a e e', 'colleague')," +
            "(12, 'Пример', 'x a m l p e e', 'example')," +
            "(13, 'Индивидуальный', 'v i d i i n a u l d', 'individual')," +
            "(14, 'Запрос', 'q e r e u t s', 'request')," +
            "(15, 'Украшать', 'c a e d t e o r', 'decorate')," +
            "(16, 'Верить', 'e l e v i e b', 'believe')," +
            "(17, 'Енот', 'o n c c r o a', 'raccoon')," +
            "(18, 'Конкурент', 'p c o m i o r e t t', 'competitor')," +
            "(19, 'Клавиатура', 'b e k y r o a d', 'keyboard')," +
            "(20, 'Удалить', 'm e r e v o', 'remove');"


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
            "VALUES(1, 'Have you ever been __ London?', 'to', 'in from at to')," +
            "(2, 'Let us __ a picnic at the weekend', 'make', 'miss make stay do')," +
            "(3, 'Unfortunately, she __ play the piano', 'cannot', 'cannot can should have')," +
            "(4, 'I will __ next year', 'come', 'come came coming comed')," +
            "(5, 'I am blinded __ the lights', 'by', 'at from by of')," +
            "(6, 'Save your tears __ another day', 'for', 'for at from on')," +
            "(7, 'We will meet __ Tuesday', 'on', 'at in for on')," +
            "(8, 'If you __ the water, it boils', 'heat', 'heat burn paint drink')," +
            "(9, 'She never listens __ music', 'to', 'for to at on')," +
            "(10, 'He is a friend of __', 'mine', 'me my mine am');"


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
            "VALUES(1, 'Аномальный', 'abnormal')," +
            "(2, 'Обмен', 'exchange')," +
            "(3, 'Преобладать', 'prevail')," +
            "(4, 'Нюхать', 'sniff')," +
            "(5, 'Выставка', 'exhibition')," +
            "(6, 'Форма', 'shape')," +
            "(7, 'Поколение', 'generation')," +
            "(8, 'Существовать', 'exist')," +
            "(9, 'Отвлечение', 'distraction')," +
            "(10, 'Воспитание', 'upbringing');"


    //Table "history"
    const val HISTORY_TABLE_NAME = "history"
    const val HISTORY_COLUMN_ID = "history_id"
    const val HISTORY_COLUMN_LDS_PICTURE_HISTORY = "lds_picture_history"
    const val HISTORY_COLUMN_LDS_WORD_HISTORY = "lds_word_history"
    const val HISTORY_COLUMN_MDS_SENTENCE_HISTORY = "mds_make_sentence_history"
    const val HISTORY_COLUMN_MDS_WORD_HISTORY = "mds_make_word_history"
    const val HISTORY_COLUMN_HDS_WORD_HISTORY = "hds_choose_word_history"
    const val HISTORY_COLUMN_HDS_TRANSLATION_HISTORY = "hds_translation_history"
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
                "$HISTORY_COLUMN_CURRENT_LEVEL INTEGER DEFAULT 0," +
                "FOREIGN KEY ($HISTORY_COLUMN_ID) REFERENCES $USER_TABLE_NAME($USER_COLUMN_ID)," +
                "FOREIGN KEY ($HISTORY_COLUMN_LDS_PICTURE_HISTORY) REFERENCES $LDS_PICTURE_TABLE_NAME($LDS_PICTURE_COLUMN_ID)," +
                "FOREIGN KEY ($HISTORY_COLUMN_LDS_WORD_HISTORY) REFERENCES $LDS_WORD_TABLE_NAME($LDS_WORD_COLUMN_ID)," +
                "FOREIGN KEY ($HISTORY_COLUMN_MDS_SENTENCE_HISTORY) REFERENCES $MDS_MAKE_SENTENCE_TABLE_NAME($MDS_MAKE_SENTENCE_COLUMN_ID)," +
                "FOREIGN KEY ($HISTORY_COLUMN_MDS_WORD_HISTORY) REFERENCES $MDS_MAKE_WORD_TABLE_NAME($MDS_MAKE_WORD_COLUMN_ID)," +
                "FOREIGN KEY ($HISTORY_COLUMN_HDS_WORD_HISTORY) REFERENCES $HDS_CHOOSE_WORD_TABLE_NAME($HDS_CHOOSE_WORD_COLUMN_ID)," +
                "FOREIGN KEY ($HISTORY_COLUMN_HDS_TRANSLATION_HISTORY) REFERENCES $HDS_TRANSLATION_TABLE_NAME($HDS_TRANSLATION_COLUMN_ID));"

    const val HISTORY_DELETE_TABLE = "DROP TABLE IF EXISTS $HISTORY_TABLE_NAME ;"
}