package WordCounting;

import java.io.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;
import java.util.stream.Collectors;

public class Main {
    private static Scanner scanner = null;
    private  static final Map<String, Integer > words = new HashMap<>();
    private static Writer writer = null;
    public static void main(String[] args) throws IOException {
        scanner = new Scanner(new FileInputStream("D:\\ModisJavaAcademy\\git\\modis-java-spring\\homeworks\\src\\WordCounting\\wiki_java.txt"));
        writer = new FileWriter("D:\\ModisJavaAcademy\\git\\modis-java-spring\\homeworks\\src\\WordCounting\\result.txt");
        replaceSeparatorSymbols();
        countWords();
        sortWords();

    }

    private static void sortWords() {
        words.entrySet().stream().sorted(Collections.reverseOrder(Map.Entry.comparingByValue())).limit(20).forEach(entry -> System.out.println(entry.getKey() + " -> " + entry.getValue()));

    }

    private static void countWords() throws FileNotFoundException {
        scanner = new Scanner(new FileInputStream("D:\\ModisJavaAcademy\\git\\modis-java-spring\\homeworks\\src\\WordCounting\\result.txt"));
        while (scanner.hasNextLine()){
            String[] currentRowWords = scanner.nextLine().split("\\s+");
            Arrays.stream(currentRowWords).forEach(word -> {
                words.putIfAbsent(word, 0);
                words.put(word, words.get(word) +1);
            });
        }

    }

    private static void replaceSeparatorSymbols() throws IOException {

        Pattern pattern = Pattern.compile("[0-9;()\\[\\]\\{\\}\\/*,.:\\<?!>\"'=~`!@  –$%]+");
        Matcher matcher = null;
        while (scanner.hasNextLine()){
            String currentLine = scanner.nextLine();
            matcher = pattern.matcher(currentLine);

            if (matcher.find()){
                currentLine = matcher.replaceAll(" ").trim();
            }
            if(!currentLine.isEmpty()) {
                writer.write(currentLine + System.lineSeparator());
            }
        }
        writer.close();
    }

}
