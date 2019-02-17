import java.lang.reflect.Array;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Plugins {
    FileProcessing fp = new FileProcessing();

    void CastOneLine(StringBuffer text) {
        Pattern p = Pattern.compile("\\n\\s*");
        Matcher m = p.matcher(text);
        while (m.find()) {
            text.replace(m.start(), m.end(), "");
            m = p.matcher(text);
        }
        fp.text = text;
    }

    void DeleteExtSpaces(StringBuffer text) {
        Pattern p = Pattern.compile(" {2,}");
        Matcher m = p.matcher(text);
        while (m.find()) {
            text.replace(m.start(), m.end(), " ");
            m = p.matcher(text);
        }
        fp.text = text;
    }

    void DeleteExtNewline(StringBuffer text) {
        Pattern p = Pattern.compile("(\n[\t ]*){2,}\n");
        Matcher m = p.matcher(text);
        while (m.find()) {
            text.replace(m.start(), m.end(), "\n\n");
            m = p.matcher(text);
        }
        fp.text = text;
    }

    void DeleteBeginningWhitespace(StringBuffer text) {
        Pattern p = Pattern.compile("\\n[\\t ]+|^[\\t ]+");
        Matcher m = p.matcher(text);
        while (m.find()) {
            text.replace(m.start(), m.end(), "\n");
            m = p.matcher(text);
        }
        fp.text = text;
    }

    void DeleteTheLastWhitespace(StringBuffer text) {
        Pattern p = Pattern.compile("[\\t ]+\n");
        Matcher m = p.matcher(text);
        while (m.find()) {
            text.replace(m.start(), m.end(), "\n");
            m = p.matcher(text);
        }
        fp.text = text;
    }

    void DeleteLogs(StringBuffer text) {
        Pattern p = Pattern.compile("[ \\t]*console\\.\\w+\\([\\w\\W]*?\\)\\;[\\t ]*\n");
        Matcher m = p.matcher(text);
        while (m.find()) {
            text.replace(m.start(), m.end(), "");
            m = p.matcher(text);
        }
        fp.text = text;
    }

    void DeleteSLC(StringBuffer text) {
        StringBuffer result = new StringBuffer();
        List<String[]> regularsList = new ArrayList<>();
        List<String[]> textsList = new ArrayList<>();
        List<String[]> commentsList = new ArrayList<>();

        Pattern patternCwR = Pattern.compile("\\/\\*\\/(?!\\*)((([^\\/\\n\\[\\]\\\\])|(\\\\.)|(\\[([^\\n\\\\\\[\\]]|\\\\.)+\\]))+)\\/[gim]{0,3}([\\S\\s]*?)\\*\\/");
        Matcher matcherCwR = patternCwR.matcher(text);
        while (matcherCwR.find()){
            commentsList.add(new String[]{String.valueOf(matcherCwR.start()), String.valueOf(matcherCwR.end()), matcherCwR.group()});
            StringBuilder replace = new StringBuilder();
            for (int i = 0; i < matcherCwR.group().length(); i++) {
                replace.append("џ");
            }
            text.replace(matcherCwR.start(), matcherCwR.end(), replace.toString());
            matcherCwR = patternCwR.matcher(text);
        }

        Pattern patternR = Pattern.compile("(?<!\\/)(?<!\\*)\\/(?!\\*)((([^\\/\\n\\[\\]\\\\])|(\\\\.)|(\\[([^\\n\\\\\\[\\]]|\\\\.)+\\]))+)\\/[gim]{0,3}");
        Matcher matcherR = patternR.matcher(text);
        while (matcherR.find()){
            regularsList.add(new String[]{String.valueOf(matcherR.start()), String.valueOf(matcherR.end()), matcherR.group()});
            StringBuilder replace = new StringBuilder();
            for (int i = 0; i < matcherR.group().length(); i++) {
                replace.append("ў");
            }
            text.replace(matcherR.start(), matcherR.end(), replace.toString());
            matcherR = patternR.matcher(text);
        }

        Pattern patternT = Pattern.compile("(([\"'])(?:|(?:.*?)(?:[^\\n\\\\]|[^\\\\]?(?:\\\\{2})+))\\2)");
        Matcher matcherT = patternT.matcher(text);
        while (matcherT.find()){
            textsList.add(new String[]{String.valueOf(matcherT.start()), String.valueOf(matcherT.end()), matcherT.group()});
            StringBuilder replace = new StringBuilder();
            for (int i = 0; i < matcherT.group().length(); i++) {
                replace.append("Ў");
            }
            text.replace(matcherT.start(), matcherT.end(), replace.toString());
            matcherT = patternT.matcher(text);
        }

        Pattern patternC = Pattern.compile("\\/\\/.*(?=\\n)");
        Matcher matcherC = patternC.matcher(text);
        while (matcherC.find()){
            commentsList.add(new String[]{String.valueOf(matcherC.start()), String.valueOf(matcherC.end()), matcherC.group()});
            StringBuilder replace = new StringBuilder();
            for (int i = 0; i < matcherC.group().length(); i++) {
                replace.append("џ");
            }
            text.replace(matcherC.start(), matcherC.end(), replace.toString());
            matcherC = patternC.matcher(text);
        }
        int counter = 0;
        while (textsList.size() > counter){
            StringBuilder replace = new StringBuilder();
            for (int i = 0; i < textsList.get(counter)[2].length(); i++) {
                replace.append("Ў");
            }
            if(text.substring(Integer.valueOf(textsList.get(counter)[0]), Integer.valueOf(textsList.get(counter)[1])).equals(replace.toString())){
                text.replace(Integer.valueOf(textsList.get(counter)[0]), Integer.valueOf(textsList.get(counter)[1]), textsList.get(counter)[2]);
            }
            counter++;
        }

        counter = 0;
        while (regularsList.size() > counter){
            StringBuilder replace = new StringBuilder();
            for (int i = 0; i < regularsList.get(counter)[2].length(); i++) {
                replace.append("ў");
            }
            if(text.substring(Integer.valueOf(regularsList.get(counter)[0]), Integer.valueOf(regularsList.get(counter)[1])).equals(replace.toString())){
                text.replace(Integer.valueOf(regularsList.get(counter)[0]), Integer.valueOf(regularsList.get(counter)[1]), regularsList.get(counter)[2]);
            }
            counter++;
        }

        Pattern p = Pattern.compile("[џ]+");
        Matcher m = p.matcher(text);
        while (m.find()) {
            text.replace(m.start(), m.end(), "");
            m = p.matcher(text);
        }
        text = new StringBuffer( result.append(text));
        fp.text = text;
    }

    void DeleteMLC(StringBuffer text) {
        StringBuffer result = new StringBuffer();

        List<String[]> regularsList = new ArrayList<>();
        List<String[]> textsList = new ArrayList<>();
        List<String[]> commentsList = new ArrayList<>();

        Pattern patternCwR = Pattern.compile("\\/\\*\\/(?!\\*)((([^\\/\\n\\[\\]\\\\])|(\\\\.)|(\\[([^\\n\\\\\\[\\]]|\\\\.)+\\]))+)\\/[gim]{0,3}([\\S\\s]*?)\\*\\/");
        Matcher matcherCwR = patternCwR.matcher(text);
        while (matcherCwR.find()){
            commentsList.add(new String[]{String.valueOf(matcherCwR.start()), String.valueOf(matcherCwR.end()), matcherCwR.group()});
            StringBuilder replace = new StringBuilder();
            for (int i = 0; i < matcherCwR.group().length(); i++) {
                replace.append("џ");
            }
            text.replace(matcherCwR.start(), matcherCwR.end(), replace.toString());
            matcherCwR = patternCwR.matcher(text);
        }

        Pattern patternR = Pattern.compile("(?<!\\/)(?<!\\*)\\/(?!\\*)((([^\\/\\n\\[\\]\\\\])|(\\\\.)|(\\[([^\\n\\\\\\[\\]]|\\\\.)+\\]))+)\\/[gim]{0,3}");
        Matcher matcherR = patternR.matcher(text);
        while (matcherR.find()){
            regularsList.add(new String[]{String.valueOf(matcherR.start()), String.valueOf(matcherR.end()), matcherR.group()});
            StringBuilder replace = new StringBuilder();
            for (int i = 0; i < matcherR.group().length(); i++) {
                replace.append("ў");
            }
            text.replace(matcherR.start(), matcherR.end(), replace.toString());
            matcherR = patternR.matcher(text);
        }

        Pattern patternT = Pattern.compile("(([\"'])(?:|(?:.*?)(?:[^\\\\]|[^\\\\]))\\2)");
        Matcher matcherT = patternT.matcher(text);
        while (matcherT.find()){
            textsList.add(new String[]{String.valueOf(matcherT.start()), String.valueOf(matcherT.end()), matcherT.group()});
            StringBuilder replace = new StringBuilder();
            for (int i = 0; i < matcherT.group().length(); i++) {
                replace.append("Ў");
            }
            text.replace(matcherT.start(), matcherT.end(), replace.toString());
            matcherT = patternT.matcher(text);
        }


        Pattern patternC = Pattern.compile("\\/\\*([\\S\\s]*?)\\*\\/");
        Matcher matcherC = patternC.matcher(text);
        while (matcherC.find()){
            commentsList.add(new String[]{String.valueOf(matcherC.start()), String.valueOf(matcherC.end()), matcherC.group()});
            StringBuilder replace = new StringBuilder();
            for (int i = 0; i < matcherC.group().length(); i++) {
                replace.append("џ");
            }
            text.replace(matcherC.start(), matcherC.end(), replace.toString());
            matcherC = patternC.matcher(text);
        }
        int counter = 0;
        while (textsList.size() > counter){
            StringBuilder replace = new StringBuilder();
            for (int i = 0; i < textsList.get(counter)[2].length(); i++) {
                replace.append("Ў");
            }
            if(text.substring(Integer.valueOf(textsList.get(counter)[0]), Integer.valueOf(textsList.get(counter)[1])).equals(replace.toString())){
                text.replace(Integer.valueOf(textsList.get(counter)[0]), Integer.valueOf(textsList.get(counter)[1]), textsList.get(counter)[2]);
            }
            counter++;
        }
        counter = 0;
        while (regularsList.size() > counter){
            StringBuilder replace = new StringBuilder();
            for (int i = 0; i < regularsList.get(counter)[2].length(); i++) {
                replace.append("ў");
            }
            if(text.substring(Integer.valueOf(regularsList.get(counter)[0]), Integer.valueOf(regularsList.get(counter)[1])).equals(replace.toString())){
                text.replace(Integer.valueOf(regularsList.get(counter)[0]), Integer.valueOf(regularsList.get(counter)[1]), regularsList.get(counter)[2]);
            }
            counter++;
        }
        Pattern p = Pattern.compile("[џ]+");
        Matcher m = p.matcher(text);
        while (m.find()) {
            text.replace(m.start(), m.end(), "");
            m = p.matcher(text);
        }
        text = new StringBuffer( result.append(text));
        fp.text = text;

    }

}
