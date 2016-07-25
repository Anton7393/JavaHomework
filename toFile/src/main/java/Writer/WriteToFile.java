package Writer;

import java.io.FileWriter;
import java.io.IOException;

public class WriteToFile implements Writer {
    private final String path = "log.txt";

    @Override
    public void print(String text) {
        try(FileWriter writer = new FileWriter(path, false)) {
            writer.write(text);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}