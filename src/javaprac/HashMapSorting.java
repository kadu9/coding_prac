package javaprac;

import java.util.*;

public class HashMapSorting {
    public static class Student {
        int age;
        String name;

        public Student(int age, String name) {
            this.age = age;
            this.name = name;
        }

        public String toString() {
            return "age:" + this.age + ",name:" + this.name;
        }

    }



        public static void main(String[] args){

        Map<Integer,Student> studentMap = new HashMap<>();

        Comparator<Student> ageComparator = new Comparator<Student>() {
            @Override
            public int compare(Student o2, Student o1) {
                if (o1.age > o2.age) {
                    return 1;
                } else if (o2.age > o1.age) {
                    return -1;
                } else {
                    return 0;
                }

            }
        };
        studentMap.put(100,new Student(8,"mayur"));
        studentMap.put(101,new Student(2,"pooja"));
        studentMap.put(102,new Student(3,"rohiti"));


        studentMap.entrySet()
                 .stream()
                 .sorted(Map.Entry.comparingByValue(ageComparator));
        System.out.println("printing hashmap after sorting");

//        for(Map.Entry<Integer,Student> m : studentMap.entrySet()){
//            System.out.println(m.getKey()+" "+m.getValue().toString());
//        }
        studentMap.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(ageComparator))
                .forEach(System.out::println);
        System.out.println("Printing Treemap before sorting");


        Map<Integer,Student> tMap = new TreeMap(new Comparator<Student>() {
            @Override
            public int compare(Student o2, Student o1) {
                if (o1.age > o2.age) {
                    return 1;
                } else if (o2.age > o1.age) {
                    return -1;
                } else {
                    return 0;
                }

            }
        });
        tMap.put(2,new Student(1,"mayur"));
        tMap.put(3,new Student(2,"pooja"));
        tMap.put(1,new Student(3,"rohiti"));



        for(Map.Entry<Integer,Student> m : tMap.entrySet()){
            System.out.println(m.getKey()+" "+m.getValue().toString());
        }
    }

}
