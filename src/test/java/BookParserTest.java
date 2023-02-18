import org.example.BookParser;
import org.junit.Assert;
import org.junit.Test;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class BookParserTest {

    @Test
    public void getTextText() throws IOException {

        File file = new File("test.txt");

        BufferedWriter writer = new BufferedWriter(new FileWriter(file));
        writer.write("hello world!");
        writer.close();

        List<String> text = new BookParser().getText(file);
        System.out.println(text);
        Assert.assertEquals(2,text.size());
        file.delete();
    }

    @Test
    public void topWords() {
        List<String> text = List.of("hello", "hello", "hello", "world", "is", "is ");

        List<String> strings = new BookParser().popularWorld(text, 2);
        System.out.println(strings);
        Assert.assertEquals(2,strings.size());

    }
}
