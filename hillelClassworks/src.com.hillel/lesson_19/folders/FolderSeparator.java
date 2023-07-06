package lesson_19.folders;

import java.io.File;

public class FolderSeparator {
    public static void main(String[] args) {
        String folder = "baseFolder";
        // dir1/dir2/ -linux
        // dir1\dir2\

        folder = folder.concat(File.separator).concat("1").concat(File.separator).concat("1").concat(File.separator).concat("1");

        System.out.println(folder);
    }
}
