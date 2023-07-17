package com.hillel.lesson_19.folders;

import java.io.File;
import java.io.IOException;

public class MakeDir {
    public static void main(String[] args) throws IOException {
        String baseName = "hillelClassworks/src.com.hillel/lesson_19/folders"; // base path

        String dirName = baseName + "/newDir"; // dir path
        String createFile = dirName + "/test.txt"; // file path
        String dirName1 = baseName + "/newDir/1/2/3/folder"; // dir paths

        File dir = new File(dirName);
        File dir1 = new File(dirName1);
        File file = new File(createFile);

        // create file
        if (!file.exists()) // check if exist
            System.out.println(file.createNewFile()); // create file

        // delete file
        if (file.exists()) // check if exist
            System.out.println(file.delete()); // delete file

        System.out.println(dir.mkdir());   // create one level directory
        System.out.println(dir1.mkdirs()); // create multi level directory


//        System.out.println(dir1.exists()); // check if path exist
//        System.out.println(dir1.isDirectory()); // if true directory, else file
//        System.out.println(dir1.isHidden()); // is hidden or not
//        System.out.println(dir1.isFile()); // if true file, else directory
//        System.out.println(dir1.canRead()); // available read
//        System.out.println(dir1.canWrite()); // available write
//        System.out.println(dir1.canExecute()); // available execute


        System.out.println(dir.getName());
        System.out.println(dir.getParent());
        System.out.println(dir.listFiles().length);
        System.out.println(dir.getParentFile().length());


    }
}
