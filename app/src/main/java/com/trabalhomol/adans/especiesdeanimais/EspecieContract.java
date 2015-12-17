package com.trabalhomol.adans.especiesdeanimais;

import android.provider.BaseColumns;

/**
 * Created by Adans on 13/12/2015.
 */
public final class EspecieContract {


    public static abstract class EspecieEntry implements BaseColumns {
        public static final String TABLE_NAME = "especie";
        public static final String COLUMN_ID = "animalID";
        public static final String COLUMN_NOME = "nome";
        public static final String COLUMN_NOME_CIENTIFICO = "nomecientifico";
    }


}
