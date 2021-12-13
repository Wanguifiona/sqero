import models.Hero;
import models.Squad;
import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static spark.Spark.*;

public class App {
    public static void main(String[] args) { //type “psvm + tab” to autocreate this :)
        staticFileLocation("/public");


        get("/", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            return new ModelAndView(model, "index.hbs");
        }, new HandlebarsTemplateEngine());

        post("/hero/new", (request, response) -> { //URL to make new post on POST route
            Map<String, Object> model = new HashMap<String, Object>();
            String name = request.queryParams("name");
            Hero newHero = new Hero(name);
            model.put("newHero", newHero);
            return new ModelAndView(model, "success.hbs");
        }, new HandlebarsTemplateEngine());


        get("/hero-form", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            return new ModelAndView(model, "hero-form.hbs");
        }, new HandlebarsTemplateEngine());

        get("/hero-detail",(req, res) ->{
            Map<String, Object> model = new HashMap<>();
            ArrayList<Hero> hero = Hero.getAll();
            model.put("hero",hero);
            return new ModelAndView(model, "hero-detail.hbs");
        }, new HandlebarsTemplateEngine());

        get("/squad-form", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            return new ModelAndView(model, "squad-form.hbs");
        }, new HandlebarsTemplateEngine());

        get("/squad-detail",(req, res) ->{
            Map<String, Object> model = new HashMap<>();
            ArrayList<Squad> squad = Squad.getAll();
            model.put("squad",squad);
            return new ModelAndView(model, "squad-detail.hbs");
        }, new HandlebarsTemplateEngine());

        post("/squad/new", (request, response) -> { //URL to make new post on POST route
            Map<String, Object> model = new HashMap<String, Object>();
            String name = request.queryParams("name");
            Squad newSquad = new Squad(name);
            model.put("newSquad", newSquad);
            return new ModelAndView(model, "success.hbs");
        }, new HandlebarsTemplateEngine());

    }
}
