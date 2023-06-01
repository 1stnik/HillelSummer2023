package lesson_11.exception;

public class ThrowsException {
    public static void main(String[] args)  {
        try {
            new People().print();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        System.out.println("ssss");
    }
}

class People {
    void print() throws Exception {
        throw new BussinesException("Business exception ");
    }
}

