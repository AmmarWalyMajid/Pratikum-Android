package com.pratikum.pratikummp.Data;

import android.content.Context;
import android.content.SharedPreferences;

public class SharedPrefeManager {

    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;

    public SharedPrefeManager(Context context){
        sharedPreferences = context.getSharedPreferences("latihan_shared_preferences", Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
    }

    public void saveString(String value){
        editor.putString("ini_string",value);
        editor.commit();
    }

    public String getString(){
        return sharedPreferences.getString("ini_string", "");
    }

}
