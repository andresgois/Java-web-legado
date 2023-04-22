package br.com.livraria.webservices.rest.clients;

import java.io.StringReader;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonReader;

public class RestClient {
    
    public JsonObject stringToJsonObject(String header) {
        JsonReader jsonReader = Json.createReader(new StringReader(header));
        JsonObject jsonObject = jsonReader.readObject();
        jsonReader.close();
        return jsonObject;
    } 
}
