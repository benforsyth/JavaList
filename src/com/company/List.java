package com.company;
import java.lang.Object;
import java.lang.System;



class ListNode {
    public Object m_currentObject;
    public ListNode m_nextNode;
    public ListNode m_previousNode;

    public ListNode() {

    }
}


/*
 *  List class
 *
 *  A doubly linked list with push_front and push_back to add objects
 *  and at() to access objects at a particular index
 *
 */
 
 
class List {
    private ListNode m_first;
    private ListNode m_currentNode;
    private ListNode m_last;

    private  int m_numberObjects;

    public List() {

    }

    private void create_first_node(Object ob) {
        m_first = m_last = new ListNode();
        m_first.m_currentObject = ob;
        m_first.m_nextNode = m_last;
        m_last = m_currentNode = m_first;
    }

    public void push_back(Object ob) {
        if (m_first == null) {
            create_first_node(ob);
        } else {
            ListNode temp = m_last;
            m_last.m_nextNode = new ListNode();
            m_last = m_last.m_nextNode;
            m_last.m_currentObject = ob;
            m_last.m_previousNode = temp;
        }

        m_numberObjects++;
    }


    public void push_front(Object ob) {
        if (m_first == null) {
            create_first_node(ob);
        } else {
            ListNode temp = m_first;
            m_first.m_previousNode = new ListNode();
            m_first = m_first.m_previousNode;
            m_first.m_currentObject = ob;
            m_first.m_nextNode = temp;
        }

        m_numberObjects++;
    }

    public void print() {

        System.out.print("[");
        while (hasMoreElements()) {
            System.out.println(nextObject());
        }
        System.out.println("]");
    }

    public Object firstObject() {
        m_currentNode = m_first;
        return m_first.m_currentObject;
    }

    public Object lastObject() {
        m_currentNode = m_last;
        return m_last.m_currentObject;
    }

    public Object nextObject() {
        if (!hasMoreElements())
            return null;

        m_currentNode = m_currentNode.m_nextNode;
        return m_currentNode.m_currentObject;

    }

    public Object previousObject() {
        if (m_currentNode == m_first)
            return null;

        m_currentNode = m_currentNode.m_previousNode;
        return m_currentNode.m_currentObject;
    }

    public boolean hasMoreElements() {
        return m_currentNode != m_last;
    }

    public int count() {
        return m_numberObjects;
    }

    public Object at(int i) {
        if (i > m_numberObjects / 2) {
            // start from back
            lastObject();
            for (int j = m_numberObjects - 2; j >= i; j--) {
                previousObject();
            }
        } else {
            // start from beginning
            firstObject();
            for (int j = 1; j <= i; j++) {
                nextObject();
            }
        }

        return m_currentNode.m_currentObject;

    }
}

class Main {
    public static void main(String args[]){
        List testList = new List();
        testList.push_back(new Object());
        testList.print();

        for (int x = 0; x < 10; x++) {
            testList.push_back(new Object());
        }
        
        testList.print();

        System.out.print("first object ");
        System.out.println(testList.firstObject());
        while (testList.hasMoreElements()) {
            System.out.print("next element ");
            System.out.println(testList.nextObject());
        }
    }
}