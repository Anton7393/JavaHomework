package Application;

import Writer.WriteToFile;
import Writer.WriteToConsole;
import Writer.Writer;

import java.util.Arrays;
import java.util.List;

public class Driver {
    private String text;
    private Integer command;
    private Writer writer;
    private List<String> arguments;

    private final Integer IN_FILE = 1;
    private final Integer IN_CONSOLE = 0;
    private final Integer TEXT_POSITION = 1;
    private final Integer COMMAND_POSITION = 0;
    private final String INVALID_COMMAND_MESSAGE = "Invalid command, the command must be 0 or 1!";


    public Driver(String [] _arguments) {
        arguments = Arrays.asList(_arguments);
    }

    public void run() {
        parseCommandFromArguments();
        parseTextFromArguments();
        validateWriter();
        print();
    }

    private void parseCommandFromArguments() {
        command = Integer.parseInt(arguments.get(COMMAND_POSITION));
    }
    private void parseTextFromArguments() {
        text = arguments.get(TEXT_POSITION);
    }

    private void validateWriter() {
        try {
            selectWriter();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private void selectWriter() throws Exception {
        if (isOnFile()) {
            writer = new WriteToFile();
        } else if (isOnConsole()) {
            writer = new WriteToConsole();
        } else {
            writer = new WriteToConsole();
            text = INVALID_COMMAND_MESSAGE;
        }
    }

    private boolean isOnFile() {
        return IN_FILE.equals(command);
    }

    private boolean isOnConsole() {
        return IN_CONSOLE.equals(command);
    }

    private void print() {
        writer.print(text);
    }
}
