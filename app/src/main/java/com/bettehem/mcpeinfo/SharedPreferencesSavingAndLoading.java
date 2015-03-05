package com.bettehem.mcpeinfo;

/*
    Copyright 2015  Chris Mustola

    This program is free software: you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation, either version 3 of the License, or
    (at your option) any later version.

    This program is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with this program.  If not, see http://www.gnu.org/licenses/.
 */

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;

public class SharedPreferencesSavingAndLoading extends Activity{

    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;


    public class Saving{

        public void saveString(Context context,String valueName, String value){
            sharedPreferences = context.getSharedPreferences("Settings", MODE_PRIVATE);
            editor = sharedPreferences.edit();

            editor.putString(valueName, value);

            editor.apply();

        }


        public void saveInt(Context context,String valueName, int value){
            sharedPreferences = context.getSharedPreferences("Settings", MODE_PRIVATE);
            editor = sharedPreferences.edit();

            editor.putInt(valueName, value);

            editor.apply();

        }

        public void saveBoolean(Context context,String valueName, boolean value){
            sharedPreferences = context.getSharedPreferences("Settings", MODE_PRIVATE);
            editor = sharedPreferences.edit();

            editor.putBoolean(valueName, value);

            editor.apply();

        }

        public void saveFloat(Context context,String valueName, float value){
            sharedPreferences = context.getSharedPreferences("Settings", MODE_PRIVATE);
            editor = sharedPreferences.edit();

            editor.putFloat(valueName, value);

            editor.apply();

        }

        public void saveLong(Context context,String valueName, long value){
            sharedPreferences = context.getSharedPreferences("Settings", MODE_PRIVATE);
            editor = sharedPreferences.edit();

            editor.putLong(valueName, value);

            editor.apply();

        }

    }


    public class Loading{

        public String loadString(Context context, String valueName){

            sharedPreferences = context.getSharedPreferences("Settings", MODE_PRIVATE);

            String loadedValue, defaultvalue;

            defaultvalue = getString(R.string.shared_preferences_loading_error);

            loadedValue = sharedPreferences.getString(valueName, defaultvalue);

            return loadedValue;
        }

        public int loadInt(Context context, String valueName){

            sharedPreferences = context.getSharedPreferences("Settings", MODE_PRIVATE);

            int loadedValue, defaultvalue;

            defaultvalue = 0;

            loadedValue = sharedPreferences.getInt(valueName, defaultvalue);

            return loadedValue;
        }

        public boolean loadBoolean(Context context, String valueName){

            sharedPreferences = context.getSharedPreferences("Settings", MODE_PRIVATE);

            boolean loadedValue, defaultvalue;

            defaultvalue = false;

            loadedValue = sharedPreferences.getBoolean(valueName, defaultvalue);

            return loadedValue;
        }

        public float loadFloat(Context context, String valueName){

            sharedPreferences = context.getSharedPreferences("Settings", MODE_PRIVATE);

            float loadedValue, defaultvalue;

            defaultvalue = 0;

            loadedValue = sharedPreferences.getFloat(valueName, defaultvalue);

            return loadedValue;
        }

        public long loadLong(Context context, String valueName){

            sharedPreferences = context.getSharedPreferences("Settings", MODE_PRIVATE);

            long loadedValue, defaultvalue;

            defaultvalue = 0;

            loadedValue = sharedPreferences.getLong(valueName, defaultvalue);

            return loadedValue;
        }

    }

}
