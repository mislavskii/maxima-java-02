package org.example;

public class Cat {
    private String name;  // свойство общее для класса
    private boolean isAngry;

    public Cat(String name) {  // constructor
        this(name,true);
    }

    public Cat(String name, boolean isAngry) {  // constructor 2
        this.name = name;
        this.isAngry = isAngry;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isAngry() {
        return isAngry;
    }

    public void setAngry(boolean angry) {
        isAngry = angry;
    }

    public void printName() {  // метод
        System.out.println("Имя кота: " + this.getName());
    }

    public static void sayMeow(int n) {
        for (int i=0; i<n; i++) {
            System.out.println("Мяу !!");
        }
    }
}
