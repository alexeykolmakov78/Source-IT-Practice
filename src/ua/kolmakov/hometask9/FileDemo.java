package ua.kolmakov.hometask9;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

/**
 * Created by Kolmakov Alexey on 23.06.2015.
 */
public class FileDemo {
// 1) Написать программу, которая создаст текстовый файл и запишет в него список файлов (путь, имя, дата создания) из заданного каталога.

    private static final String DIR = "F:\\Documents\\IdeaProjects\\Source-IT-Practice\\src";
//    private static final String DIR = "F:\\Documents\\IdeaProjects\\Source-IT-Practice\\src\\ua\\kolmakov\\logistic\\StartLogistic.java";
    private static File save = new File("save.txt");
    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        findAllFiles(DIR);
        Writer writer = new FileWriter(save);
        //debug info
        System.out.println("sb= " + sb);
        //
        writer.write(sb.toString());
        writer.flush();
        writer.close();
    }

    private static void findAllFiles(String dir) {
        File file = new File(dir);
        File[] list = file.listFiles();
        if (list != null) {
            for (File tmp : list) {
                if (tmp.isDirectory()) {
                    sb.append("<D>").append(tmp.getAbsolutePath()).append("\n");
                    findAllFiles(tmp.getAbsolutePath());
                } else if(tmp.isFile()){
                    sb.append("<F>").append(tmp.getAbsolutePath()).append("\n");
                }
            }
        }else{
            sb.append("empty\n");
        }
    }
}
