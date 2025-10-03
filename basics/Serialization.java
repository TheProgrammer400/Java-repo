package basics;
import java.io.*;

class Person{
    String name;
    int age;

    Person(String name, int age){
        this.name = name;
        this.age = age;
    }
}

public class Serialization{
    public static void main(String []args){
        Person p1 = new Person("Unknown", 23);

        try{
            FileOutputStream fileOut = new FileOutputStream("person.ser");
            ObjectOutputStream out =  new ObjectOutputStream(fileOut);
            out.writeObject(p1);
            out.close();
            fileOut.close();
        } catch (IOException e){
            e.printStackTrace();
        }

        Person p2 = null;

        try{
            FileInputStream fileIn = new FileInputStream("person.ser");
            ObjectInputStream in = new ObjectInputStream(fileIn);

            p2 = (Person) in.readObject();
            in.close();
            fileIn.close();
        } catch (IOException e){
            e.printStackTrace();
        } catch (ClassNotFoundException e){
            e.printStackTrace();
        }

        System.out.println(p2.name);
        System.out.println(p2.age);
    }
}