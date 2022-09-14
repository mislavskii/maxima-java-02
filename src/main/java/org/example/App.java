package org.example;

public class App {
    public static void main( String[] args ) {
        Cat murzik = new Cat("Мурзик");
        System.out.println(murzik.getName());
        System.out.println("Angry? " + murzik.isAngry());

        Cat barsik = new Cat("Барсик");
        // barsik.setName("Барсик");

        barsik.printName();

        Cat.sayMeow(3);  // static can invoke for class with no object created
    }
}
