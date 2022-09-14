package org.example;

public class Cat {
    String name = "Мурзик";  // свойство

    public static void printName() {  // метод
        String name = "Барсик";  // только внутри этого метода
        System.out.println("Имя кота: " + name);
    }
}
