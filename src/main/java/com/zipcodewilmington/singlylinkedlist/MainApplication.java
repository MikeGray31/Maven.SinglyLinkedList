package com.zipcodewilmington.singlylinkedlist;

/**
 * Created by leon on 1/10/18.
 */
public class MainApplication {

    public static void main(String[] args){
        SinglyLinkedList<String> list = new SinglyLinkedList<>();
        list.add("Hi there");
        list.add("Always");
        list.add("Mike");
        list.add("Banana");
        list.add("Apple");
        list.add("Zebra");

        list.sort();

        for(int i = 0; i < list.size(); i++){
            System.out.println(i+ ". " + list.get(i));
        }

    }


}
