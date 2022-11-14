import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

//reads a string from a file and returns the number of 0 scores reported from the file
public class LighthouseParse {
    public static int getScores(String json) {
        int count = 0;
        int index = 0;
        while (index < json.length()) {
            index = json.indexOf("score\": 0", index);
            if (index == -1) {
                break;
            }
            count++;
            index++;
        }
        return count;
    }

    public static void main(String[] args) throws IOException {

        if (args.length != 1) {
            System.out.println("Usage: java LighthouseParse <filename>");
            System.exit(1);
        }

        Path jsonFile = Path.of(args[0]);
        String contents = Files.readString(jsonFile);
        int zeroScores = getScores(contents);
        System.out.println(zeroScores + " zero scores found");
    }
}