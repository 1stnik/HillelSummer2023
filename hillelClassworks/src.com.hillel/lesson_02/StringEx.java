package lesson_02;

public class StringEx {
    public static void main(String[] args) {
//        String str1 = "Hello world";
//        System.out.println(str1.length());
//        str1 = "    Hello world      ";
//        System.out.println(str1.length());
//        str1 = str1.trim();
//        System.out.println(str1.length());
//
//
//        System.out.println();
//        String str2 = "a\nb";
//        System.out.println(str2);
//        System.out.println(str2.length()); // 4
//        System.out.println(str2.isBlank()); // true
//        System.out.println(str2.isEmpty()); // false

        String str1 = "";
        String str2 = "";


//        str1 = "one";
//        str2 = "two";
//
//        str1 = str1.concat(str2).concat(str2);
//
//        System.out.println(str1);
//
//        str1 = String.valueOf(100);
//        System.out.println(str1);
//
//        str1 = String.join("<->",str1, str2, str1, str2, "_");
//        System.out.println(str1);


        str1 = "eone";
        str2 = "onE";
//        String str3 = "two";
//
//        System.out.println(str1.compareTo(str2));
//        System.out.println(str1.compareTo(str3));
//
//        System.out.println(str1.equals(str2));
//        System.out.println(str1.equalsIgnoreCase(str2));
//
//        System.out.println(str2.charAt(2));
//
//
//        System.out.println(str1.indexOf('d'));
//        System.out.println(str1.indexOf('e'));
//        System.out.println(str1.lastIndexOf('d'));
//        System.out.println(str1.lastIndexOf('e'));
//
//
//
        String fileName = "pic.jpg";

        System.out.println(fileName.endsWith(".jpg"));
        System.out.println(fileName.startsWith(".jpg"));

        fileName = fileName.replaceFirst("p", "P");
        System.out.println(fileName);

//
//        str1 = "  _   _  ";
//        System.out.println(str1.length());
//        System.out.println(str1.trim().length());
//        System.out.print(str1);
//        System.out.println("|");
//        System.out.print(str1.trim());System.out.println("|");
//
        System.out.println("HellO WoRlD".toLowerCase());
        System.out.println("HellO WoRlD".toUpperCase());


    }
}
