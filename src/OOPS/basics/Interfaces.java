package OOPS.basics;

public class Interfaces implements Cara{
    public static void main(String[] args) {

    }

    @Override
    public void starta() {
        System.out.println("Chalu hui");
    }

    // todo: there cannot be mulpiple parents - there can be multiple level but not same child having multiple parents
    // Diamond problem - tackled using interfaces
}


interface Cara{
    void starta(); // these are by default public and abstract
    // they do not have a body
    // we cannot have function definition here - unlike in abstraction we have brake

}