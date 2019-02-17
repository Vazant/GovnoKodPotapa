import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException, InvocationTargetException, IllegalAccessException, NoSuchMethodException {
        String firstPath = System.getProperty("firstPath");
        String secondPath = System.getProperty("secondPath");
        if (firstPath.substring(firstPath.length() - 1).equals("\\")) {
            firstPath = firstPath.substring(0, firstPath.length() - 1);

        }
        if (secondPath.substring(secondPath.length() - 1).equals("\\")) {
            secondPath = secondPath.substring(0, secondPath.length() - 1);
        }

        Plugins plugins = new Plugins();
        FileProcessing fp = new FileProcessing();

        File firstArg = new File(firstPath).getAbsoluteFile();
        File secondArg = new File(secondPath).getAbsoluteFile();

        String[] pathToFile;
        String[] cofigurations = {"DeleteSLC DeleteMLC",
                "DeleteExtNewline DeleteExtSpaces DeleteBeginningWhitespace DeleteTheLastWhitespace",
                "DeleteSLC DeleteMLC DeleteExtNewline DeleteExtSpaces DeleteBeginningWhitespace DeleteTheLastWhitespace",
                "DeleteSLC DeleteMLC DeleteExtNewline DeleteExtSpaces DeleteBeginningWhitespace " +
                        "DeleteTheLastWhitespace DeleteLogs CastOneLine"};


        Invoker invoker = new Invoker(
                new CastOneLineCommand(plugins),
                new DeleteExtSpacesCommand(plugins),
                new DeleteExtNewlineCommand(plugins),
                new DeleteBeginningWhitespaceCommand(plugins),
                new DeleteTheLastWhitespaceCommand(plugins),
                new DeleteLogsCommand(plugins),
                new DeleteSLCCommand(plugins),
                new DeleteMLCCommand(plugins)
        );

        fp.createNewFile(secondArg);

        if (firstArg.isFile() && secondArg.isFile()) {
            fp.text = fp.readText(firstArg.getPath());
            try {
                String[] conf = cofigurations[Integer.parseInt(System.getProperty("configType"))].split(" ");
                int i = 0;
                while (i < conf.length) {
                    Method method = Invoker.class.getMethod(conf[i]);
                    method.invoke(invoker);
                    System.out.println("Method: " + conf[i] + " complete");
                    i++;
                }
                pathToFile = new String[]{secondArg.getAbsolutePath()};
                fp.saveFile(pathToFile);
            } catch (ArrayIndexOutOfBoundsException exception) {
                System.out.println("You entered an invalid value for the \"Configuration\" argument. It takes values from 0 to 3");
            }

        } else if (firstArg.isFile() && secondArg.isDirectory()) {
            fp.text = fp.readText(firstArg.getPath());

            try {
                String[] conf = cofigurations[Integer.parseInt(System.getProperty("configType"))].split(" ");
                int i = 0;
                while (i < conf.length) {
                    Method method = Invoker.class.getMethod(conf[i]);
                    method.invoke(invoker);
                    System.out.println("Method: " + conf[i] + " complete");
                    i++;
                }
                pathToFile = new String[]{firstArg.getName(), secondArg.getPath()};
                fp.saveFile(pathToFile);

            } catch (ArrayIndexOutOfBoundsException exception) {
                System.out.println("You entered an invalid value for the \"Configuration\" argument. It takes values from 0 to 3");
            }

        } else if (firstArg.isDirectory() && secondArg.isDirectory()) {
            File[] filesToObfuscate = firstArg.listFiles();

            assert filesToObfuscate != null;

            for (File aFilesToObfuscate : filesToObfuscate) {
                if (aFilesToObfuscate.isFile()) {
                    fp.text = fp.readText(aFilesToObfuscate.getPath());
                    try {
                        String[] conf = cofigurations[Integer.parseInt(System.getProperty("configType"))].split(" ");
                        int i = 0;
                        while (i < conf.length) {
                            Method method = Invoker.class.getMethod(conf[i]);
                            method.invoke(invoker);
                            System.out.println("Method: " + conf[i] + " complete");
                            i++;
                        }

                        pathToFile = new String[]{secondArg.getPath(), aFilesToObfuscate.getName()};
                        fp.saveFile(pathToFile);
                    } catch (ArrayIndexOutOfBoundsException exception) {
                        System.out.println("You entered an invalid value for the \"Configuration\" argument. It takes values from 0 to 3");
                    }
                }
            }
        } else System.out.println("Check that the arguments are correct");
    }
}