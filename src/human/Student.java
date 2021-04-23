package human;

import java.util.Comparator;

public class Student {

    private String name;
    private String surname;
    private int age;

    public Student(String name, String surname, int age) {
        this.name = name;
        this.surname = surname;
        this.age = age;
    }

    public static Comparator<Student> ComparatorByName() {
        return new ComparatorByName();
    }

    public static Comparator<Student> ComparatorByAge() {
        return new ComparatorByAge();
    }

    public static Comparator<Student> DefaultComparator() {
        return new DefaultComparator();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    private static class ComparatorByName implements Comparator<Student> {

        @Override
        public int compare(Student o1, Student o2) {
            return o1.name.compareTo(o2.name);
        }
    }

    private static class ComparatorByAge implements Comparator<Student> {

        @Override
        public int compare(Student o1, Student o2) {
            return Integer.compare(o1.age, o2.age);
        }
    }

    private static class DefaultComparator implements Comparator<Student> {

        @Override
        public int compare(Student o1, Student o2) {
            if (o1.name.compareTo(o2.name) == 0) {
                return Integer.compare(o1.age, o2.age);
            } else return o1.name.compareTo(o2.name);
        }
    }
}
