package com.iflytek.com.util;

import org.springframework.util.StringUtils;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Stream;

/**
 * 按行读取某个文件夹中所有的文件，写入到目标文件中
 * 用于编写软著代码文档
 */
public class CopyFiles {
    public static void main(String[] args) {
        String sourceFolderPath = "D:\\Develop\\yth-cm-database\\src\\main\\java\\com\\iflytek\\mcmp\\paas\\move";
        String targetFilePath = "D:\\IFlyDoc\\云纳管\\架构\\333.txt";
        try (Stream<Path> paths = Files.walk(Paths.get(sourceFolderPath))){
            List<Path> fileNames = paths
                    .filter(Files::isRegularFile).toList();

            for (Path fileName : fileNames) {
                System.out.println(fileName);

                String path = fileName.toFile().getPath();

                try (BufferedReader br = new BufferedReader(new FileReader(path))) {
                    String line;
                    while ((line = br.readLine()) != null) {

                        if (line.startsWith("package")) {
                            continue;
                        }

                        if (line.startsWith("import")) {
                            continue;
                        }

                        if (!StringUtils.hasText(line)) {
                            continue;
                        }

                        try (FileWriter fw = new FileWriter(targetFilePath, true)) {
                            fw.write(line + "\r\n");
                        } catch (IOException e) {
                            e.printStackTrace();
                        }

                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }

        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}