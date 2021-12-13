package models;

import java.util.ArrayList;

public class Hero {
    private String name;
    private int id;


    private static ArrayList<Hero> instances = new ArrayList<>();
    public Hero(String name) {
        this.name = name;
        instances.add(this);
        this.id = instances.size();
    }

    public String getName() {
        return name;
    }
    public static ArrayList<Hero> getAll(){
        return instances;
    }

    public static void clearAllHeros(){
        instances.clear();
    }
    public int getId() {
        return id;
    }
    public static Hero findById(int id){
        return instances.get(id-1);
    }
}
