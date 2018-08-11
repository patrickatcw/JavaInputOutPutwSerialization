package com.me;

//https://www.mkyong.com/java/how-to-read-and-write-java-object-to-a-file/
/*
Java object Serialization is an API provided by Java Library stack as a means to serialize Java objects.
Serialization is a process to convert objects into a writable byte stream. Once converted into a byte-stream,
these objects can be written to a file. The reverse process of this is called de-serialization.
A Java object is serializable if its class or any of its superclasses implement either the java.io.Serializable
interface or its subinterface, java.io.Externalizable.
 */

import java.io.*;

public class WriterReader {

    public static void main(String[] args) {

        Person p1 = new Person("John", 30, "Male");
        Person p2 = new Person("Rachel", 25, "Female");

        try {
            FileOutputStream f = new FileOutputStream(new File("myObjects.txt"));
            ObjectOutputStream o = new ObjectOutputStream(f);

            // Write objects to file
            o.writeObject(p1);
            o.writeObject(p2);

            o.close();
            f.close();

            FileInputStream fi = new FileInputStream(new File("myObjects.txt"));
            ObjectInputStream oi = new ObjectInputStream(fi);

            // Read objects
            Person pr1 = (Person) oi.readObject();
            Person pr2 = (Person) oi.readObject();

            System.out.println(pr1.toString());
            System.out.println(pr2.toString());

            oi.close();
            fi.close();

        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        } catch (IOException e) {
            System.out.println("Error initializing stream");
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

}

//result in console
/*
Name:John
Age: 30
Gender: Male
Name:Rachel
Age: 25
Gender: Female

 */
