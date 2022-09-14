package org.example;

public class App {
    public static void main( String[] args ) {
        Cat murzik = new Cat("Мурзик");

        Cat barsik = new Cat("Барсик");
        // barsik.setName("Барсик");

        System.out.println(murzik.getName());
        barsik.printName();

        Cat.sayMeow(3);  // static can invoke for class with no object created
    }
}
