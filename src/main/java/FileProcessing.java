import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FileProcessing {
    StringBuffer inputBuffer = null;
    StringBuffer text;
    File file = null;
    FileReader fR = null;
    BufferedReader bR = null;
    BufferedWriter bW = null;

    StringBuffer readText(String path) throws IOException {
        String line;
        try {
            file = new File(path);
            fR = new FileReader(file);
            System.out.println("The file " + file + " was found and read");
        } catch (FileNotFoundException e) {
            System.out.println("File not found at: " + path);
        }

        bR = new BufferedReader(fR);
        inputBuffer = new StringBuffer();

        try {
            while ((line = bR.readLine()) != null) {
                inputBuffer.append(line);
                inputBuffer.append('\n');
            }

        } catch (IOException e) {
            System.out.println("Input/Output error: " + e.toString());
        }
        fR.close();
        bR.close();
        return inputBuffer;
    }

    void saveFile(String[] args) throws IOException {
        if (args.length == 1){
            bW = new BufferedWriter(new FileWriter(args[0]));
            System.out.println("The file is saved to the folder: " + args[0]);
        }else {
            bW = new BufferedWriter(new FileWriter(args[0] + File.separator + args[1]));
            System.out.println("The file is saved to the folder: " + args[0] + File.separator + args[1]);
        }
        bW.write(text.toString());
        bW.close();
    }


    void createNewFile(File file) {
        if (!file.exists()) {
            try {
                Pattern p = Pattern.compile("\\w+\\.\\w+");
                Matcher m = p.matcher(file.getAbsolutePath());
                if (m.find()) {
                    String dirName = file.getAbsolutePath().substring(0, file.getAbsolutePath().lastIndexOf(File.separator));
                    File dir = new File(dirName);
                    dir.mkdirs();
                    file.createNewFile();
                } else file.mkdirs();
            } catch (SecurityException ignored) {
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
