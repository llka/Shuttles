package ru.ilka.shuttles.util;

import com.google.gson.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.ilka.shuttles.entity.Shuttle;

import java.util.ArrayList;

public class JsonUtil {

    private static Logger logger = LoggerFactory.getLogger(JsonUtil.class);

    public static JsonArray convertListToJson(ArrayList<Shuttle> shuttles) {
        Gson gson = new Gson();
        JsonElement element = gson.toJsonTree(shuttles);
        JsonArray jsonArray = element.getAsJsonArray();

        return jsonArray;
    }
}
