package org.example;

public class Cat {
    private String name = "Мурзик";  // свойство общее для класса

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void printName() {  // метод
        System.out.println("Имя котика: " + name);
    }

    public static void sayMeow(int n) {
        for (int i=0; i<n; i++) {
            System.out.println("Мяу !!");
        }
    }
}
