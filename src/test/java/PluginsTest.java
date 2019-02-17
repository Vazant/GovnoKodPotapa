import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.io.IOException;


public class PluginsTest {
    Plugins plugins = new Plugins();
    FileProcessing fp = new FileProcessing();
    File testFile;
    File mainFile;
    String pathToTest = "src" + File.separator + "test" + File.separator + "TestFiles";

    @Test
    public void deleteBeginningWhitespace() throws IOException {
        testFile = new File(pathToTest + File.separator + "deleteBeginningWhitespace" + File.separator + "Test.java");
        mainFile = new File(pathToTest + File.separator + "deleteBeginningWhitespace" + File.separator + "Main.java");

        fp.text = fp.readText(testFile.getPath());
        plugins.DeleteBeginningWhitespace(fp.text);
        StringBuffer expected = fp.readText(mainFile.getPath());

        Assert.assertEquals(expected.toString(), fp.text.toString());
        System.out.println("\n");
    }

    @Test
    public void deleteExtNewline() throws IOException {
        testFile = new File(pathToTest + File.separator + "deleteExtNewline" + File.separator + "Test.java");
        mainFile = new File(pathToTest + File.separator + "deleteExtNewline" + File.separator + "Main.java");

        fp.text = fp.readText(testFile.getPath());
        plugins.DeleteExtNewline(fp.text);
        StringBuffer expected = fp.readText(mainFile.getPath());

        Assert.assertEquals(expected.toString(), fp.text.toString());
        System.out.println("\n");

    }

    @Test
    public void deleteExtSpaces() throws IOException {
        testFile = new File(pathToTest + File.separator + "deleteExtSpaces" + File.separator + "Test.java");
        mainFile = new File(pathToTest + File.separator + "deleteExtSpaces" + File.separator + "Main.java");

        fp.text = fp.readText(testFile.getPath());
        plugins.DeleteExtSpaces(fp.text);
        StringBuffer expected = fp.readText(mainFile.getPath());

        Assert.assertEquals(expected.toString(), fp.text.toString());
        System.out.println("\n");
    }

    @Test
    public void deleteLogs() throws IOException {
        testFile = new File(pathToTest + File.separator + "deleteLogs" + File.separator + "Test.java");
        mainFile = new File(pathToTest + File.separator + "deleteLogs" + File.separator + "Main.java");

        fp.text = fp.readText(testFile.getPath());
        plugins.DeleteLogs(fp.text);
        StringBuffer expected = fp.readText(mainFile.getPath());

        Assert.assertEquals(expected.toString(), fp.text.toString());
        System.out.println("\n");
    }

    @Test
    public void deleteSLC() throws IOException {
        testFile = new File(pathToTest + File.separator + "deleteSLC" + File.separator + "Test.java");
        mainFile = new File(pathToTest + File.separator + "deleteSLC" + File.separator + "Main.java");

        fp.text = fp.readText(testFile.getPath());
        plugins.DeleteSLC(fp.text);
        StringBuffer expected = fp.readText(mainFile.getPath());

        Assert.assertEquals(expected.toString(), fp.text.toString());
        System.out.println("\n");

    }

    @Test
    public void deleteMLC() throws IOException {
        testFile = new File(pathToTest + File.separator + "deleteMLC" + File.separator + "Test.java");
        mainFile = new File(pathToTest + File.separator + "deleteMLC" + File.separator + "Main.java");

        fp.text = fp.readText(testFile.getPath());
        plugins.DeleteMLC(fp.text);
        StringBuffer expected = fp.readText(mainFile.getPath());

        Assert.assertEquals(expected.toString(), fp.text.toString());
        System.out.println("\n");
    }

    @Test
    public void deleteTheLastWhitespace() throws IOException {
        testFile = new File(pathToTest + File.separator + "deleteTheLastWhitespace" + File.separator + "Test.java");
        mainFile = new File(pathToTest + File.separator + "deleteTheLastWhitespace" + File.separator + "Main.java");

        fp.text = fp.readText(testFile.getPath());
        plugins.DeleteTheLastWhitespace(fp.text);
        StringBuffer expected = fp.readText(mainFile.getPath());

        Assert.assertEquals(expected.toString(), fp.text.toString());
        System.out.println("\n");
    }

    @Test
    public void allTests() throws IOException {
        testFile = new File(pathToTest + File.separator + "allTests" + File.separator + "Test.java");
        mainFile = new File(pathToTest + File.separator + "allTests" + File.separator + "Main.java");

        fp.text = fp.readText(testFile.getPath());
        plugins.DeleteSLC(fp.text);
        plugins.DeleteMLC(fp.text);
        plugins.DeleteLogs(fp.text);
        plugins.DeleteExtSpaces(fp.text);
        plugins.DeleteExtNewline(fp.text);
        plugins.DeleteTheLastWhitespace(fp.text);
        plugins.DeleteBeginningWhitespace(fp.text);
        StringBuffer expected = fp.readText(mainFile.getPath());

        Assert.assertEquals(expected.toString(), fp.text.toString());
        System.out.println("\n");
    }

}