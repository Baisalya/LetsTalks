package com.passonatetech.letstalks;

import android.content.Context;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public class MemoryData {
    public static  void saveData(String data, Context context){
        try {
            FileOutputStream fileOutputStream=context.openFileOutput("datata.txt",context.MODE_PRIVATE);
            fileOutputStream.write(data.getBytes());
            fileOutputStream.close();
        }catch (IOException e){
            e.printStackTrace();
        }

    }
    public static String getData(Context context){
        String data="";
        try {
            FileInputStream fileInputStream=context.openFileInput("datata.txt");
            InputStreamReader inputStreamReader=new InputStreamReader(fileInputStream);
            BufferedReader bufferedReader=new BufferedReader(inputStreamReader);
            StringBuilder sb=new StringBuilder();
            String line;
            while ((line=bufferedReader.readLine()) !=null){
                sb.append(line);
            }
            data=sb.toString();
        }catch (IOException e){
            e.printStackTrace();
        }
        return data;
    }
}
