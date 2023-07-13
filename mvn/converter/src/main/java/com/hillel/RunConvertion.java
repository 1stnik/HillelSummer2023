package com.hillel;
/*
    Написать приложение которое производит конвертацию форматов Json <--> Yaml:

    на вход приложения в виде аргумента программы принимаем расположение директории
    где находятся файлы, если аргумент отсутствует то происходит анализ текущей папки
    валидируем формат (YAML, JSON)
    сохраняем полученный файл в папке converted (старое имя + новое расширение)
    результаты конвертации сохраняем в файле result.log в формате
    имя_файла -> новое_имя_файла, длительность конвертации, старый размер -> новый размер

    если конвертация не возможно надо записать что файл не сконвертировался

    работа с файлами
    конвертация

 */

import com.hillel.service.ConverterService;
import com.hillel.service.FileService;


import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class RunConvertion {
    private final static String JSON = "json";
    private final static String YAML = "yaml";

    public static void main(String[] args) throws IOException {
//        Path path = Path.of(System.getProperty("user.dir"));
//        if (args.length > 0) {
//            path = Path.of(args[0]);
//        }
//        System.out.println(path);
//
//        FileService fs ;
//
//        List<File> filesList = fs.getFiles(path);
//
//        System.out.println(filesList);
//
//        ConverterService json = new JsonConverterServiceImpl();
//        ConverterService yaml = new YamlConverterServiceImpl();
//
//        File fileDir = new File(path.toString(), "/covert");
//
//        fileDir.mkdir();
//
//        for (File file : filesList){
//            if (fs.isFileFormat(file, YAML)) {
//                long startTime = System.nanoTime();
//                Long yamlSize = Files.size(file.toPath());
//                String str = yaml.convert(fs.readFromFile(file.toPath()));
//                File destinationFile = new File(fileDir, fs.getFileName(file)+".json");
//                Long jsonSize = Files.size(destinationFile.toPath());
//                fs.saveToFile(destinationFile, false, str);
//                Long duration = System.nanoTime() - startTime;
//                String result = file.getName()
//                        .concat(" -> ")
//                        .concat(destinationFile.getName()).concat(" , ")
//                        .concat(duration.toString()).concat(" , ")
//                        .concat(yamlSize.toString()).concat(" , ")
//                        .concat(jsonSize.toString()).concat("\n");
//                System.out.println(result);
//
//                fs.saveToFile(new File(path.toString(), "log.txt"), true, result);
//
//            } else if (fs.isFileFormat(file, JSON)){
//                String str = json.convert(fs.readFromFile(file.toPath()));
//                fs.saveToFile(new File(fileDir, fs.getFileName(file)+".yaml"), false, str);
//            }
//        }
    }
}
