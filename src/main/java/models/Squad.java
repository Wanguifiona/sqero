package models;

import java.util.ArrayList;

public class Squad {
    private String name;
    private int id;


    private static ArrayList<Squad> instances = new ArrayList<>();
    public Squad(String name) {
        this.name = name;
        instances.add(this);
        this.id = instances.size();
    }

    public String getName() {
        return name;
    }
    public static ArrayList<Squad> getAll(){
        return instances;
    }

    public static void clearAllSquads(){
        instances.clear();
    }
    public int getId() {
        return id;
    }
    public static Squad findById(int id){
        return instances.get(id-1);
    }
}


