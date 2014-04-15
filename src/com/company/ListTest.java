package com.company;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by benf on 3/23/14.
 */
public class ListTest {

    @Test
    public void test_push_back() {
        List testList = new List();

        final int total = 21;
        Object testArray[] = new Object[total];
        for (int i = 0; i < total; i++) {
            Object firstObject = new Object();
            testList.push_back(firstObject);
            testArray[i] = firstObject;
        }

        Assert.assertEquals(testArray[0], testList.firstObject());
        for (int i = 1; i < total; i++) {
            Assert.assertEquals(testArray[i], testList.nextObject());
        }

        Assert.assertEquals(testList.count(), total);
        Assert.assertFalse(testList.hasMoreElements());
    }

    @Test
    public void test_push_front() {
        List testList = new List();

        final int total = 21;
        Object testArray[] = new Object[total];
        for (int i = 0; i < total; i++) {
            Object firstObject = new Object();
            testList.push_front(firstObject);
            testArray[i] = firstObject;
        }

        Assert.assertEquals(testList.firstObject(), testArray[total - 1]);
        for (int i = total - 2; i > -1; i--) {
            Assert.assertEquals(testList.nextObject(), testArray[i]);
        }

        Assert.assertEquals(testList.count(), total);
    }

    @Test
    public void test_previous_node_push_back() {
        List testList = new List();

        Object firstObject = new Object();
        testList.push_back(firstObject);
        Object nextObject = new Object();
        testList.push_back(nextObject);
        Object lastObject = new Object();
        testList.push_back(lastObject);

        Assert.assertEquals(testList.firstObject(), firstObject);
        Assert.assertEquals(testList.nextObject(), nextObject);
        Assert.assertEquals(testList.nextObject(), lastObject);
        Assert.assertEquals(testList.previousObject(), nextObject);
        Assert.assertEquals(testList.previousObject(), firstObject);
        Assert.assertEquals(testList.previousObject(), null);

    }

    @Test
    public void test_previous_node_push_front() {
        List testList = new List();

        Object lastObject = new Object();
        testList.push_front(lastObject);
        Object nextObject = new Object();
        testList.push_front(nextObject);
        Object firstObject = new Object();
        testList.push_front(firstObject);

        Assert.assertEquals(testList.firstObject(), firstObject);
        Assert.assertEquals(testList.nextObject(), nextObject);
        Assert.assertEquals(testList.nextObject(), lastObject);
        Assert.assertEquals(testList.previousObject(), nextObject);
        Assert.assertEquals(testList.previousObject(), firstObject);
        Assert.assertEquals(testList.previousObject(), null);


    }

    @Test
    public void test_get_at_index() {
        List testList = new List();

        final int total = 14;
        Object testArray[] = new Object[total];
        for (int i = 0; i < total; i++) {
            Object firstObject = new Object();
            testList.push_back(firstObject);
            testArray[i] = firstObject;
        }

        Assert.assertEquals(testList.at(0), testArray[0]);
        Assert.assertEquals(testList.at(1), testArray[1]);
        Assert.assertEquals(testList.at(2), testArray[2]);
        Assert.assertEquals(testList.at(3), testArray[3]);
        Assert.assertEquals(testList.at(4), testArray[4]);
        Assert.assertEquals(testList.at(5), testArray[5]);
        Assert.assertEquals(testList.at(6), testArray[6]);
        Assert.assertEquals(testList.at(12), testArray[12]);
        Assert.assertEquals(testList.at(13), testArray[13]);



    }
}
