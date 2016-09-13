import java.util.HashMap;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;
import static spark.Spark.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class App {
  public static void main(String[] args) {
    staticFileLocation("/public");
    String layout = "templates/layout.vtl";

    get("/", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      model.put("compactDiscs", request.session().attribute("compactDiscs"));
      model.put("template", "templates/index.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    post("/CD", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();

      ArrayList<Organizer> compactDiscs = request.session().attribute("compactDiscs");
      if (compactDiscs == null){
        compactDiscs = new ArrayList<Organizer>();
        request.session().attribute("compactDiscs", compactDiscs);
      }

      String album = request.queryParams("album");
      String artist = request.queryParams("artist");
      String genre = request.queryParams("genre");

      Organizer newCD = new Organizer(album, artist, genre);
      compactDiscs.add(newCD);

      model.put("template", "templates/success.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

  }
}
