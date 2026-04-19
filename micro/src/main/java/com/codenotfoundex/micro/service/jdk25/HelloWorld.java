package com.codenotfoundex.micro.service.jdk25;

public class HelloWorld {
    static void main() {
        String name = IO.readln("Enter your name: ");
        IO.println("Hello, " + name);
        Integer userInputNumber = Integer.decode(IO.readln("Enter a number: "));
        IO.println("Iaka Double " + userInputNumber*2);
    }
}
