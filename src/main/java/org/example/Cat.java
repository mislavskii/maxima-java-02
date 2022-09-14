package org.example;

public class Cat {
    public String name = "Мурзик";  // свойство общее для класса

    public void printName() {  // метод
        String name = "Барсик";  // только внутри этого метода
        System.out.println("Имя кота: " + name);
    }
}
