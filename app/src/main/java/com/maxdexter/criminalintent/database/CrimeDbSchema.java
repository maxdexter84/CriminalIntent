package com.maxdexter.criminalintent.database;

public class CrimeDbSchema {
    public static final class CrimeTable{ //Внутренний класс для описания таблици
        public static final String NAME = "crimes"; //название таблицы

        public static final class Cols{
            //Название столбцов в таблице
            public static final String UUID = "uuid";
            public static final String TITLE = "title";
            public static final String DATE = "date";
            public static final String SOLVED = "solved";
        }
    }
}
