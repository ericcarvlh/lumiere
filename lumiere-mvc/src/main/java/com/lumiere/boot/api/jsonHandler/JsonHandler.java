package com.lumiere.boot.api.jsonHandler;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.json.JSONObject;

public class JsonHandler {
	public JSONObject converteParaJson(InputStreamReader inputStreamReader) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        String linha = "", textoJson = "";
        
        while((linha = bufferedReader.readLine())!=null) {
            textoJson += linha;
        }

        return new JSONObject(textoJson);
	}
}
