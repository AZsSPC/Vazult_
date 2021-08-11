package com.azsspc.az_vault.game_comp;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;

import static com.azsspc.az_vault.MainActivity.getFromJSONArray;

public class Item {
    int weight;
    String id;
    String name;
    String sex;
    String[] abilities;

    Item(JSONObject data) throws JSONException {
        this.weight = data.getInt("weight");
        this.id = data.getString("id");
        this.name = data.getString("name");
        this.sex = data.getString("sex");
        this.abilities = getFromJSONArray(data.getJSONArray("abilities"));
    }

    public static HashMap<String, Item> createArray(JSONArray data) {
        int rel = data.length();
        HashMap<String, Item> ret = new HashMap<>();
        for (int i = 0; i < rel; i++)
            try {
                Item item = new Item(data.getJSONObject(i));
                ret.put(item.getId(), item);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        return ret;
    }

    public int getWeight() {
        return weight;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSex() {
        return sex;
    }

    public String[] getAbilities() {
        return abilities;
    }

}
