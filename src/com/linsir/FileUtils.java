package com.linsir;

import java.io.*;

public class FileUtils {

    public static void WriteStringToFile5(String s, String filePath) {
        try {
            FileOutputStream fos = new FileOutputStream(filePath);
            fos.write(s.getBytes());
            fos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String readFileByLines(String fileName) {
        File file = new File(fileName);
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(file));
            String tempString = null;
            // 一次读入一行，直到读入null为文件结束
            String result = "";
            while ((tempString = reader.readLine()) != null) {
                result += tempString + "\n";
            }
            if (!result.equals(""))
                result = result.substring(0, result.length() - 1);
            reader.close();
            return result;
        } catch (IOException e) {
            e.printStackTrace();
            return "";
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        }
    }


}

