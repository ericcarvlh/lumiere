package com.lumiere.boot.api.viaCEP;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.json.JSONObject;

import com.lumiere.boot.api.jsonHandler.JsonHandler;
import com.lumiere.boot.api.viaCEP.domain.Endereco;

public class ViaCEP {
	static String webService = "http://viacep.com.br/ws/";

    public static Endereco buscaEnderecoPeloCEP(String cep) throws Exception {
        String enderecoURL = webService + cep + "/json/";
        
    	URL url = new URL(enderecoURL);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        
        try {
            InputStream inputStream = connection.getInputStream();
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);

            JsonHandler jsonHandler = new JsonHandler();
            JSONObject jsonObject = jsonHandler.converteParaJson(inputStreamReader);
            
            Endereco endereco = new Endereco();
            endereco.setLogradouro(jsonObject.getString("logradouro"));
            endereco.setBairro(jsonObject.getString("bairro"));
            endereco.setLocalidade(jsonObject.getString("localidade"));
            endereco.setUFEstado(jsonObject.getString("uf"));
            
            return endereco;
        } catch (Exception msgErro) {
            throw  new Exception("Erro de conexão- status Code [" + connection.getResponseCode() + "]. " + msgErro.toString()); 
        }
    }
}
