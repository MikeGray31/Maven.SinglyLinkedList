package com.zipcodewilmington.singlylinkedlist;

/**
 * Created by leon on 1/10/18.
 */
public class SinglyLinkedList<E extends Comparable<E>>  implements Cloneable{

    // Fields ------------------------------

    private int currentSize;
    private Node<E> lastNode;
    private Node<E> firstNode;

    // Constructor -------------------------

    SinglyLinkedList(){
        currentSize = 0;
    }

    // Node class --------------------------

    private static class Node<E>{
        E data;
        SinglyLinkedList.Node<E> next;
        SinglyLinkedList.Node<E> prev;

        Node(SinglyLinkedList.Node<E> prev, E data, SinglyLinkedList.Node<E> next) {
            this.data = data;
            this.next = next;
            this.prev = prev;
        }
    }

    // Methods -----------------------------

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
        if(currentNode.equals(this.firstNode)){
            currentNode.next.prev = null;
            this.firstNode  = currentNode.next;
            currentSize--;
        }
        else if(currentNode.equals(this.lastNode)){
            currentNode.prev.next = null;
            this.lastNode = currentNode.prev;
            currentSize--;
        }
        else {
            currentNode.next.prev = currentNode.prev;
            currentNode.prev.next = currentNode.next;
            currentSize--;
        }
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
        return (E) getNode(index).data;
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

    private Node<E> getNode(int index){

        SinglyLinkedList.Node getThis = this.firstNode;
        for(int i = 0; i < index; i++){
            getThis = getThis.next;
        }
        return getThis;
    }

    private <E extends Comparable<E>> void swap( int i, int j) {

        if (i != j) {
            this.add(this.getNode(i).data);
            this.getNode(i).data = this.getNode(j).data;
            this.getNode(j).data = this.lastNode.data;
            this.remove(currentSize - 1);
        }
    }

    <E extends Comparable<E>> void sort() {

        for (int i = 0; i < this.size() - 1; i++) {
            int smallest = i;

            for (int j = i + 1; j < this.size(); j++) {
                if (this.get(j).compareTo(this.get(smallest)) <= 0) {
                    smallest = j;
                }
            }
            swap(i, smallest);
        }
    }
}
