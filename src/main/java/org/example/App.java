package org.example;

public class App {
    public static void main( String[] args ) {
        Cat murzik = new Cat("Мурзик", false);
        System.out.println(murzik.getName());
        System.out.println("Angry? " + murzik.isAngry());

        Cat barsik = new Cat("Барсик");
        barsik.printName();
        System.out.println("Angry? " + barsik.isAngry());

        Cat.sayMeow(3);  // static can invoke for class with no object created
    }
}
