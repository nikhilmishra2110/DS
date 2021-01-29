package OOPS.basics;

//https://www.youtube.com/watch?v=a199KZGMNxk

//TODO:  In this file there can only one public class and
// the name of that public class should match the file name(MainClass here)
// we can create multiple classes say person class
// When we create a class no space is taken up at runtime - if we create remote class it is not instantiated
// We have to create object for it to materialize
// As such class is nothing -its just a blueprint - object is what takes up space
// Object has 2 things = properties and bheavior
// Remote properties: colr, shape
// Behavior - turn on, volumn increase


import OOPS.encapsulation.EncapsulationIntro;

public class MainClass {
    public static void main(String[] args) {
        //>>>>>>>>>
        //Lets create a new person object - we can make thousands of such objects
        Person p1 = new Person(); // person class ka new object -- it has properties name and age --> // calls the constructor
        p1.age = 24;
        p1.name = "Roshan";
        System.out.println(p1.age); // object banake uski data mebers ko print kara rahe hai
        System.out.println(p1.name);

        //>>>>>>>>>
        Person p2 = new Person(); // calls the constructor
        p2.name ="Jetha";
        p2.age = 23;
        System.out.println(p2.age); // object banake uski data mebers ko print kara rahe hai
        System.out.println(p2.name);

        //>>>>>>>>>
        p1.eat();// eat method is called
        p2.walk();//while p1 is eating p2 is walking

        //>>>>>>>>>
        p2.walk(500); // this will take walk method with arguments - this is polymorphism
        // Compile time polymorphism -  it knows whoch fucntion to call before running

        //>>>>>>>>>
        // Constructor: If we do  not create one then default constructor is created by Java
        // Why constructor? If we want to have class level features to be present in all the objects
        // Constructore create a new objects and returns a new object
        // To initialize porperty we can use constructor - instead of defining like above
        //

        // Helps  in counting the number of pbjects creted
        // No need to create objects to access class level parameters --> we have to use static keyword for this
        System.out.println(Person.count); // have to use Person class to get count not p1 or p2(objects)

        //>>>>>>>>>
        Person p3 = new Person(31, "Daya"); // calls the different constructor
        System.out.println(p3.name);
        System.out.println(p3.age);
        System.out.println(Person.count); // count does not increase -- if we add this() to this constructor then count will increment
        //>>>>>>>>>
        // two uses of this

        //>>>>>>>>>
        // Inheritance
        // Normal class can inherit properties of parent class - so that children do not have to make their own properties
        Developer d1 = new Developer(21, "Tappu");
        d1.walk(); // inherits all the properties of parent keyword - even though  we did not define any property in this class
        // if walk function is not found in developer class it will go to its nearest class and see if this function exists or not
        // keeps going up and up
        // runtime polymorphism

        d1.walk(10);
        d1.eat();

        //>>>>>>>>>
        // Encapsulation: data hiding
        // packages and access modifiers?
        EncapsulationIntro e1 = new EncapsulationIntro();
        e1.doWork();
//        e1.doWorkPrivate(); not accessible
        //>>>>>>>>>
        //>>>>>>>>>
        //>>>>>>>>>
    }
}

//Inheritance - lets make a child class - in office we have developer and manager
class Developer extends Person{
    public Developer(int age, String name){
        super(age, name);
        //TODO: Super keyword - this calls the constructor of parent class - developer is a person
    }

    // What if we want to imlement a new walk function for a develeoper
    void walk(){
        System.out.println("develeloper named " + name +" is walkking");
    }
}


class Person{ // we can have muliple classes in a file
    //>>>>>>>>>
    String name; // this is a property
    int age; // this is a property

    //>>>>>>>>>
    static int count; // this is to count the number of objects created by our program
    //TODO: as soon as we make it staticit becomes a class level property - not anymore a of object level property

    //>>>>>>>>>
    // Constructor - strart with public
    public Person(){
        count++;
        System.out.println("Creating an object!");
    }

    //>>>>>>>>>
    // Let us overload a constructor
    public Person(int age, String name){
        //TODO: if we can call another constructor from this constructor we can do that
        // what if we want to call teh implementation of default comstrctor-we can do that here

        //We want purana constructor to handle count incrementv
        //this(); // this will call the default constructor (above) and will increment the count
        this.name = name;
        this.age = age; // this mean is class ki age me ye age daalo //
        //TODO: two uses of this
    }

    //>>>>>>>>>
    // Lets as some behaviors
    void walk(){// this is method
        System.out.println(name+ " walked!");
    }

    //>>>>>>>>>
    void eat(){
        System.out.println(name + " is eating!");
    }

    //>>>>>>>>>
    // method can take argument and have a return type
    void walk(int steps){
        System.out.println(name + " walked "+ steps + " steps!");
    }
}


