//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.elbicon.coderscampus;

import java.util.ArrayList;
import java.util.List;

public class Main {
    static CustomList<List<List<Users>>> custUserList = new CustomArrayList();
    static List<List<Users>> randomUserList = new ArrayList();
    static PopulateUserList userList = new PopulateUserList();

    public Main() {
    }

    public static void main(String[] args) {
        startTest();
    }

    public static void startTest() {
        try {
            randomUserList = userList.createUserList(12);
            System.out.println("Update Succeeded? - " + custUserList.add(randomUserList) + "\n");
            randomUserList = userList.createUserList(9);
            System.out.println("Update Succeeded? - " + custUserList.add(randomUserList) + "\n");
            randomUserList = userList.createUserList(8);
            System.out.println("Update Succeeded? - " + custUserList.add(randomUserList) + "\n");
            randomUserList = userList.createUserList(13);
            System.out.println("Update Succeeded? - " + custUserList.add(randomUserList) + "\n");
            System.out.println("Total Size=" + custUserList.getSize());
            randomUserList = userList.createUserList(1);
            System.out.println("Update Succeeded? - " + custUserList.add(2, randomUserList));
            System.out.println("Updated Total Size=" + custUserList.getSize());
            System.out.println("Update Succeeded? - " + custUserList.remove(5));
            System.out.println("Updated Total Size=" + custUserList.getSize());
        } catch (Exception var1) {
            System.out.println("Exception Caught:" + var1.getMessage());
        }

    }
}
