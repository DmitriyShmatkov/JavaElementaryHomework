package homework17;

import com.google.gson.Gson;
import org.yaml.snakeyaml.Yaml;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;
import java.util.stream.Stream;

public class Converter {
    public void convertJsonToYaml(String path) {
        if (!path.matches(".+\\.json")) {
            throw new IllegalArgumentException("Not a .json file");
        }
        String content = getFileContent(path);
        Map map = new Gson().fromJson(content, Map.class);
        content = new Yaml().dump(map);
        path = path.substring(0, path.length() - 4) + "yml";
        try (FileWriter fileWriter = new FileWriter(path)) {
            fileWriter.write(content);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void convertYamlToJson(String path) {
        if (!path.matches(".+\\.yml")) {
            throw new IllegalArgumentException("Not a .yml file");
        }
        String content = getFileContent(path);
        Map map = new Yaml().load(content);
        content = new Gson().toJson(map);
        path = path.substring(0, path.length() - 3) + "json";
        try (FileWriter fileWriter = new FileWriter(path)) {
            fileWriter.write(content);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

        private String getFileContent(String path) {
        StringBuilder content = new StringBuilder();

        try (Stream<String> linesStream = Files.lines(Paths.get(path))) {
            linesStream.forEach(s -> content.append(s).append("\n"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return content.toString();
    }
}
