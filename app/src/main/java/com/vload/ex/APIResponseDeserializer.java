package com.vload.ex;

import com.google.gson.Gson;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;

import java.lang.reflect.Type;
import java.util.List;

class APIResponseDeserializer implements JsonDeserializer<RoyListItems>
{
    @Override
    public RoyListItems deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {

        JsonElement content = json.getAsJsonObject().get("items");

        return new Gson().fromJson(content, RoyListItems.class);

    }

}