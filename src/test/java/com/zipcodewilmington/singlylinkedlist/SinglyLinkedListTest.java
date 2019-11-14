package com.zipcodewilmington.singlylinkedlist;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by leon on 1/10/18.
 */
public class SinglyLinkedListTest {

    SinglyLinkedList<Integer> sLL;

    @Before
    public void doThisFirst(){
        sLL = new SinglyLinkedList<>();
        sLL.add(1);
        sLL.add(2);
        sLL.add(3);
    }

    @Test
    public void instantiateTest1(){
        SinglyLinkedList<Integer> newSLL = new SinglyLinkedList<Integer>();
        Assert.assertTrue(newSLL instanceof SinglyLinkedList);
        Assert.assertEquals(0, newSLL.size());
    }

    @Test
    public void ContainsTest(){
        Assert.assertEquals(3, sLL.size());
        Assert.assertTrue(sLL.contains(1));
        Assert.assertTrue(sLL.contains(2));
        Assert.assertTrue(sLL.contains(3));
    }

    @Test
    public void addTest(){

        sLL.add(4);
        Assert.assertEquals(4, sLL.size());
        Assert.assertTrue(sLL.contains(4));
    }


    @Test
    public void findTest(){
        Assert.assertEquals(0, sLL.find(1));
        Assert.assertEquals(1, sLL.find(2));
        Assert.assertEquals(2, sLL.find(3));
    }

    @Test
    public void getTest(){
        Assert.assertEquals(1, sLL.get(0),0.0);
        Assert.assertEquals(2, sLL.get(1),0.0);
        Assert.assertEquals(3, sLL.get(2),0.0);
    }

    @Test
    public void cloneTest(){
        SinglyLinkedList<Integer> sLL2 = sLL.copy();
        Assert.assertEquals(sLL.get(0), sLL2.get(0),0.0);
        Assert.assertEquals(sLL.get(1), sLL2.get(1),0.0);
        Assert.assertEquals(sLL.get(2), sLL2.get(2),0.0);

        sLL2.add(4);
        Assert.assertFalse(sLL.contains(4));
        Assert.assertTrue(sLL2.contains(4));

        sLL2.remove(1);
        Assert.assertTrue(sLL.contains(2));
        Assert.assertFalse(sLL2.contains(2));

    }
}
