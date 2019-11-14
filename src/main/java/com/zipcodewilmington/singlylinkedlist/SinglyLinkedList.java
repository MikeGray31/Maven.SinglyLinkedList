package com.zipcodewilmington.singlylinkedlist;

import java.util.LinkedList;

/**
 * Created by leon on 1/10/18.
 */
public class SinglyLinkedList<E extends Comparable<E>>  implements Cloneable{

    // fields ------------------------------

    private int currentSize;
    private Node<E> lastNode;
    private Node<E> firstNode;


    // constructor -------------------------

    SinglyLinkedList(){
        currentSize = 0;
    }

    // Node class --------------------------

    private static class Node<E> implements Cloneable{
        E data;
        SinglyLinkedList.Node<E> next;
        SinglyLinkedList.Node<E> prev;

        Node(SinglyLinkedList.Node<E> prev, E data, SinglyLinkedList.Node<E> next) {
            this.data = data;
            this.next = next;
            this.prev = prev;
        }
    }

    // methods -----------------------------

    void add(E newData){

        if(currentSize == 0){
            Node<E> node = new Node<E>(null,newData,null);
            this.firstNode = node;
            this.lastNode = node;
            this.currentSize = 1;
        }
        else {
            Node<E> node = new Node<E>(this.lastNode, newData, null);
            node.prev.next = node;
            this.lastNode = node;
            this.currentSize++;
        }
    }

    void remove(int index){
        SinglyLinkedList.Node currentNode = this.firstNode;
        for(int i = 0; i < index; i++){
            currentNode = currentNode.next;
        }
        currentNode.next.prev = currentNode.prev;
        currentNode.prev.next = currentNode.next;
    }

    boolean contains(E dataToFind){
        return this.find(dataToFind) > -1;
    }

    int find(E dataToFind){

        int index = 0;
        SinglyLinkedList.Node currentNode;

        if (dataToFind == null) {
            for(currentNode = this.firstNode; currentNode != null; currentNode = currentNode.next) {
                if (currentNode.data == null) {
                    return index;
                }
                ++index;
            }
        }

        else {
            for(currentNode = this.firstNode; currentNode != null; currentNode = currentNode.next) {
                if (dataToFind.equals(currentNode.data)) {
                    return index;
                }
                ++index;
            }
        }

        return -1;
    }

    int size(){
        return this.currentSize;
    }

    E get(int index){
        SinglyLinkedList.Node getThis = this.firstNode;
        for(int i = 0; i < index; i++){
            getThis = getThis.next;
        }
        return (E) getThis.data;
    }

    SinglyLinkedList<E> copy(){

        SinglyLinkedList<E> newClone = new SinglyLinkedList<>();
        Node<E> currentNode = this.firstNode;

        for(int i = 0; i < this.size(); i++){
            newClone.add(currentNode.data);
            currentNode = currentNode.next;
        }
        return newClone;
    }

    private void sort(){
        Node<E> currentNode = this.firstNode;
        if (){

        }
    }

    private <E extends Comparable<E>> void swap( int i, int j) {
        if (i != j) {


        }
    }

    public <E extends Comparable<E>> void selectionSort() {
        for (int i = 0; i < this.size() - 1; i++) {
            // find index of smallest element
            int smallest = i;
            for (int j = i + 1; j < this.size(); j++) {
                if (this.get(j).compareTo(this.get(smallest)) <= 0) {
                    smallest = j;
                }
            }

            swap(i, smallest);  // swap smallest to front
        }
    }
}
