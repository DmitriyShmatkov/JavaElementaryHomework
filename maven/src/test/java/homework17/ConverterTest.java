package homework17;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ConverterTest {

    @Test
    public void convertJsonToYamlTest() {
        String expected = """
                evidence:
                  careful: -4.15111778E8
                  hole: false
                  rest: {shirt: false, eight: hill, future: 6.877617137419505E8, knife: work, than: brought,
                    catch: them}
                  grass: probably
                  combine: tight
                  molecular: true
                silence: true
                weak: false
                teeth: true
                fill: true
                successful: underline
                """;
        Converter converter = new Converter();
        converter.convertJsonToYaml("src\\test\\java\\homework17\\jsonToYaml\\example.json");

        StringBuilder actual = new StringBuilder();

        try (Stream<String> linesStream = Files.lines(Paths.get("src\\test\\java\\homework17\\jsonToYaml\\example.yml"))) {
            linesStream.forEach(s -> actual.append(s).append("\n"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        assertEquals(expected, actual.toString());
    }

    @Test
    public void convertYamlToJsonTest() {
        String expected = """
                {"evidence":{"careful":-4.15111778E8,"hole":false,"rest":{"shirt":false,"eight":"hill","future":6.877617137419505E8,"knife":"work","than":"brought","catch":"them"},"grass":"probably","combine":"tight","molecular":true,"silence":true,"weak":false,"teeth":true,"fill":true,"successful":"underline"}}
                """;

        Converter converter = new Converter();
        converter.convertYamlToJson("src\\test\\java\\homework17\\yamlToJson\\example.yml");

        StringBuilder actual = new StringBuilder();

        try (Stream<String> linesStream = Files.lines(Paths.get("src\\test\\java\\homework17\\yamlToJson\\example.json"))) {
            linesStream.forEach(s -> actual.append(s).append("\n"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        assertEquals(expected, actual.toString());
    }
}
