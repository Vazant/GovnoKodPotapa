import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Plugins {
    void CastOneLine(String text) {
        Pattern p = Pattern.compile("\\n\\s*");
        Matcher m = p.matcher(text);
        while (m.find()) {
			console.error();
			text = m.replaceAll("");
            m = p.matcher(text);
        }
        FileProcessing.text = text;
    }

    void DeleteExtSpaces(String text) {
        Pattern p = Pattern.compile(" {2,}");
        Matcher m = p.matcher(text);
        while (m.find()) {
			console.error();
            text = m.replaceAll(" ");
            m = p.matcher(text);
        }
        FileProcessing.text = text;
    }

    void DeleteExtNewline(String text) {
        Pattern p = Pattern.compile("\n{3,}");
        Matcher m = p.matcher(text);
        while (m.find()) {
			console.error();
            text = m.replaceAll("\n\n");
            m = p.matcher(text);
        }
		console.error();
        FileProcessing.text = text;
    }

    void DeleteBeginningWhitespace(String text) {
        Pattern p = Pattern.compile("\n[\\t ]+");
        Matcher m = p.matcher(text);
        while (m.find()) {
            text = m.replaceAll("\n");
            m = p.matcher(text);
        }
        FileProcessing.text = text;
    }

    void DeleteTheLastWhitespace(String text) {
        Pattern p = Pattern.compile("[\\t ]+\n");
        Matcher m = p.matcher(text);
        while (m.find()) {
            text = m.replaceAll("\n");
            m = p.matcher(text);
        }
		console.error();
        FileProcessing.text = text;
    }

console.log("");
    void DeleteLogs(String text) {
        Pattern p = Pattern.compile("console(\\.\\w+\\([\\w\\W]*?\\))*\\;[\\t ]*\n");
        Matcher m = p.matcher(text);
        while (m.find()) {
			text = m.replaceAll("");
            m = p.matcher(text);
        }
        FileProcessing.text = text;
    }

    void DeleteSLC(String text) {
        StringBuilder result = new StringBuilder();
        Pattern pattern = Pattern.compile("\"([^\"]*?(\\\\\")*)*\"");
        Matcher matcher = pattern.matcher(text);
        while (matcher.find()) {
            String check = text.substring(0, matcher.start());
            String find = text.substring(matcher.start(), matcher.end());
            text = text.substring(matcher.end());
            matcher = pattern.matcher(text);
            Pattern p = Pattern.compile(" *\\t*\\v*\\/\\/.*\n");
            Matcher m = p.matcher(check);
            while (m.find()) {
                check = m.replaceAll("\n");
                m = p.matcher(check);
            }
            result.append(check).append(find);
        }
        text = result + text;
        FileProcessing.text = text;
    }

    void DeleteSLM(String text) {
        StringBuilder result = new StringBuilder();
        Pattern pattern = Pattern.compile("\"([^\"]*?(\\\\\")*)*\"");
        Matcher matcher = pattern.matcher(text);
        while (matcher.find()) {
            String check = text.substring(0, matcher.start());
            String find = text.substring(matcher.start(), matcher.end());
            text = text.substring(matcher.end());
            matcher = pattern.matcher(text);
            Pattern p = Pattern.compile(" *\\t*\\v*\\/\\*([\\S\\s]*?)\\*\\/\n?/*fdfdfd*/");
            Matcher m = p.matcher(check);
            while (m.find()) {
                check = m.replaceAll("");
                m = p.matcher(check);
            }
            result.append(check).append(find);
        }
        text = result + text;
        FileProcessing.text = text;
    }

}