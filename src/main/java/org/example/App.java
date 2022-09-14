package org.example;

public class App {
    public static void main( String[] args ) {
        Cat murzik = new Cat();

        Cat barsik = new Cat();
        barsik.name = "Барсик";

        System.out.println(murzik.name);
        barsik.printName();

        Cat.sayMeow(3);  // static can invoke for class with no object created
    }
}
