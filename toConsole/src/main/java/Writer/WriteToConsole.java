package Writer;

public class WriteToConsole implements Writer{
    @Override
    public void print(String text) {
        System.out.println(text);
    }
}
