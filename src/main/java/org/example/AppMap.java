package org.example;

import java.util.*;

public class AppMap {
    public static void main(String[] args) {
        Person person1 = new Person("Alice Johnson", 28, 120);
        Person person2 = new Person("Michael Brown", 14, 150);
        Person person3 = new Person("Emma Wilson", 23, 110);
        Person person4 = new Person("James Smith", 40, 180);
        Person person5 = new Person("Olivia Davis", 17, 135);
        Person person6 = new Person("William Jones", 40, 125);
        Person person7 = new Person("Sophia Garcia", 29, 140);
        Person person8 = new Person("Benjamin Martinez", 15, 160);
        Person person9 = new Person("Isabella Hernandez", 26, 115);

        Person person10 = new Person("Lucas Thompson", 32, 145);

        List<Person> listGroup1 = new ArrayList<>(Arrays.asList(person1, person2, person3));
        List<Person> listGroup2 = new ArrayList<>(Arrays.asList(person4, person5, person6));
        List<Person> listGroup3 = new ArrayList<>(Arrays.asList(person7, person8, person9, person10));


        Person person11 = new Person("Anna", 26, 415);
        Person person12 = new Person("Lera", 26, 715);


        Map<String, List<Person>> map = new HashMap<>();
        map.put("A", listGroup1);
        map.put("B", listGroup2);
        map.put("C", listGroup3);

        List<Person> list = map.get("A");
        list.add(person11);

        List<Person> list2 = map.get("B");
        list2.add(person12);

        System.out.println(map);


        Set<Map.Entry<String, List<Person>>> entries = map.entrySet();
        for (Map.Entry<String, List<Person>> entry : entries) {
            System.out.println("Группа " + entry.getKey() + ":");

            int sumPoint = 0;
            for (Person person : entry.getValue()) {
                System.out.println(person);
                sumPoint += person.getPoints();
            }
            System.out.println("sumPoint: " + sumPoint + "\n");
        }
        System.out.println("-----");
        System.out.println(groupOverPoints(entries));

        System.out.println("-----");
        oldPerson(entries);

        System.out.println("-----");
        oldPeopleGroups(entries);




        System.out.println("-----");
        


    }


    // найти и вывести название группы у которой больше всего поинтов
    public static String groupOverPoints(Set<Map.Entry<String, List<Person>>> entries) {
        Map<String, Integer> map = new HashMap<>();
        String groupMaxPoints = "";
        int overPointsGroup = 0;

        for (Map.Entry<String, List<Person>> entry : entries) {


            int overPoints = 0;
            for (Person person : entry.getValue()) {
                overPoints += person.getPoints();
            }
            map.put(entry.getKey(), overPoints);
        }
        Set<Map.Entry<String, Integer>> setMaps = map.entrySet();


        for (Map.Entry<String, Integer> entry : setMaps) {
            if (entry.getValue() > overPointsGroup) {
                overPointsGroup = entry.getValue();
                groupMaxPoints = entry.getKey();
            }
        }
        return "Группа: " + groupMaxPoints + "\n" + "Сумма баллов группы: " + overPointsGroup;
    }

    // найти самого старшего в каждой группе участника и вывести его имя как старосты группы
    public static void oldPerson(Set<Map.Entry<String, List<Person>>> entries) {


        for (Map.Entry<String, List<Person>> entry : entries) {
            System.out.println("Группа " + entry.getKey() + ":");

            int oldAge = 0;
            String oldName = "";
            for (Person person : entry.getValue()) {
                if (person.getAge() > oldAge) {
                    oldAge = person.getAge();
                    oldName = person.getName();
                }
            }
            System.out.println("Староста: " + oldName + "\n" + "Возраст: " + oldAge + "\n");
        }

    }

    //найти самого старшего во всех группах а если их будет более 1 то вывести всех (имена)
    public static void oldPeopleGroups(Set<Map.Entry<String, List<Person>>> entries) {
        int oldAgeAllGroup = 0;

        List<Person> oldPeopleGroups = new ArrayList<>(); //список  самых старших  из каждой группы
        List<Person> oldPeopleGroupsFromBestOld = new ArrayList<>(); // список старших людей из всех групп


        for (Map.Entry<String, List<Person>> entry : entries) {


            int oldAgePeople = 0; //узнаю возраст самого старшего
            for (Person person : entry.getValue()) {
                if (person.getAge() > oldAgePeople) {
                    oldAgePeople = person.getAge();
                }
            }
            for (Person person : entry.getValue()) { // сравниваю список людей  с возрастом самого старшего и если возраст совпадает то добавляю в список
                if (person.getAge() == oldAgePeople) {
                    oldPeopleGroups.add(person); // добавил в лист для каждой группы старшего
                }
            }
        }
        for(Person person : oldPeopleGroups) { //нахожу возраст самого старшего  из всех групп
            if(person.getAge() >oldAgeAllGroup){
                oldAgeAllGroup = person.getAge();
            }
        }
        for(Person person : oldPeopleGroups) {
            if(person.getAge() == oldAgeAllGroup){ // сравниваю возраст и добавляю в лист
                oldPeopleGroupsFromBestOld.add(person);
            }
        }

        for(Person person : oldPeopleGroupsFromBestOld) {
            System.out.println("Самый старший их всех групп: "+person.getName());
        }



    }


    //прибавить каждому персону поинты по 250 если ему менее 18 лет
    public static void personPlusPoints250(Set<Map.Entry<String,List<Person>>> entries){
        for(Map.Entry<String, List<Person>> entry : entries) {
            for(Person person: entry.getValue()){
                if(person.getAge() < 18){
                    person.setPoints(person.getPoints()+250);
                }
            }
        }
    }
}

