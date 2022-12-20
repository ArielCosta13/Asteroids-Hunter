/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.game.asteroids.utils;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.utils.JsonReader;
import com.badlogic.gdx.utils.JsonValue;


/**
 *
 * @author Ariel Costa
 */
public class JsonUtils {
    
    /**
     * Return a json value from a file located in the URL passed as parameter
     * @param jsonfile string with the URL of the json file
     * @return 
     */
    public static JsonValue returnJsonvalue(String jsonfile){ 
        JsonReader json = new JsonReader();
        JsonValue base = json.parse(Gdx.files.internal(jsonfile));
        System.out.println(base);
        return(base); 
    }
   
  
}
