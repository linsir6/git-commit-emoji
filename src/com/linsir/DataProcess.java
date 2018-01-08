package com.linsir;

import java.io.IOException;
import java.util.HashMap;

public class DataProcess {


    public static HashMap<String, String> getData() throws IOException {
        String material = NetWorkUtil.getURLResponse(Constant.BASE_URL);
        material= material.toLowerCase();
        material = material.replaceAll("\\r","");
        material = material.replaceAll("\\n","");

        String[] materials = material.split(";");
        HashMap<String, String> data = new HashMap<>();
        for (int i = 0; i < materials.length; i++) {
            for (int j = 0; j < materials[i].split("-")[0].split(",").length; j++) {
                data.put(materials[i].split("-")[0].split(",")[j], materials[i].split("-")[1]);
            }
        }
        return data;
    }


}
