import model.Person;
import model.builder.PersonBuilder;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {


        PersonBuilder pb = new PersonBuilder();
        pb.setAge(26);
        pb.setName("John Doe");
        Person p1 = pb.setAge(26).setName("John Doe").build();
       //Person p1 = new Person(1L, "John", "Doe", 35);
        Person p2 = new Person(2L, "Jane", "Doe", 25);
        Person p3 = new Person(2L, "Jane", "Doe", 26);
        System.out.println(p1);
        System.out.println(p2);
        System.out.printf("Are p1 and p2 equal? -> %b%n", p1.equals(p2));
        System.out.printf("Are p2 and p3 equal? -> %b%n", p2.equals(p3));
        System.out.printf("Are p2.identityhashcodehashcode = %d and p3.hashcode = %d equal? -> %n", System.identityHashCode(p2),p3.hashCode() );
        System.out.printf("Are p2 == p3? -> %b%n", p2 == p3);

        Scanner scanner = new Scanner(System.in);

    }
}
