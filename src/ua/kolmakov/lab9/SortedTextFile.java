package ua.kolmakov.lab9;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Kolmakov Alexey on 23.06.2015.
 */
//    1) Написать программу, которая читает текстовый файл, состоящий из нескольких строк,
//    и записывает эти строки в отсортированном по длине порядке в другой текстовый файл.
//    http://tutorials.jenkov.com/java-io/pipes.html

public class SortedTextFile {

    private static final File SOURCE = new File("save.txt");
    private static final File DESTINATION = new File("dest.txt");
    private static BufferedReader reader;
    private static BufferedWriter writer;
    private static List<String> strings = new ArrayList();

    public static void main(String[] args) throws IOException {

        reader = new BufferedReader(new FileReader(SOURCE));
        String line = reader.readLine();
        while (line != null) {
            strings.add(line.concat("\n"));
            line = reader.readLine();
        }
        reader.close();
        Collections.sort(strings, (o1, o2) -> o2.length() - o1.length());

        StringBuilder sb = new StringBuilder();
        strings.forEach(sb::append);

        writer = new BufferedWriter(new FileWriter(DESTINATION));
        writer.write(sb.toString());
        writer.close();
    }
}
