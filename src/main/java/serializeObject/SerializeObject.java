package serializeObject;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import league.LeagueModel;

import java.io.FileWriter;
import java.io.IOException;

public class SerializeObject {
    public void serializeLeagueObject(LeagueModel leagueModel) {

        Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().setPrettyPrinting().create();
        try (FileWriter writer = new FileWriter("C:\\Users\\AVuser\\Desktop\\test.JSON")) {
            gson.toJson(leagueModel, writer);
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }
}
