package OOPS.basics;

public class Abstraction {
    //TODO: abstraction : to reduce complexity we hide data
    // Hide complexity from the user - button press only -
    // not need to usderstand everthing happening inside
    // In java abstraction is achieved using abstract keyword and interface

    public static void main(String[] args) {
        // Car is just a concept even if we intialize it - we do not get anything useful out of it in this context
        /*Car c1 = new Car();
        c1.start(); <-- this did not help us- we make a car for a particular brand */
        // TODO: we can add abstract keyword and then Car class can not be instantiated - no object can be creted
        // only its cahild can be intitiated
        Audi a1 = new Audi();
        a1.start();



    }
}

class Audi extends Car{
    @Override
    void start() {
        System.out.println("BMW starting");
    } // since car has an abstract methid we need to define it here

}

class BMW extends Car{
    @Override
    void start() {
        System.out.println("BMW starting");
    }// since car has an abstract methid we need to define it here
}


abstract class Car{
    int price;
    /*void start(){
        System.out.println("Car is starting!");
    }*/
    // we change above to ==>
    abstract void start(); // this cannot be defined
    // whoever extends it will have to implement it
    // TODO: if we are having abstract method here the class also needs to be abstract
    // TODO: Cannot create children out of abstract class

    static void brake(){
        System.out.println("Brake applied");
    }


}
