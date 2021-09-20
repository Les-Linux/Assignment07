//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.elbicon.coderscampus;

import java.util.ArrayList;
import java.util.List;

public class Main {
    static CustomList<List<Users>> custUserList = new CustomArrayList();
    static List<Users> randomUserList = new ArrayList();
    static PopulateUserList userList = new PopulateUserList();

    public Main() {
    }

    public static void main(String[] args) {
        startTest();
    }

    public static void startTest() {
        try {
            randomUserList = userList.createUserList(10);
            System.out.println("Update Succeeded? - " + custUserList.add(randomUserList) + "\n");
            randomUserList = userList.createUserList(2);
            System.out.println("Update Succeeded? - " + custUserList.add(randomUserList) + "\n");
            randomUserList = userList.createUserList(2);
            System.out.println("Update Succeeded? - " + custUserList.add(randomUserList) + "\n");
            randomUserList = userList.createUserList(2);
            System.out.println("Update Succeeded? - " + custUserList.add(randomUserList) + "\n");
            System.out.println("Total Size=" + custUserList.getSize());
            randomUserList = userList.createUserList(1);
            System.out.println("Update Succeeded? - " + custUserList.add(2, randomUserList));
            System.out.println("Updated Total Size=" + custUserList.getSize());
            System.out.println("Update Succeeded? - " + custUserList.remove(2));
            System.out.println("Updated Total Size=" + custUserList.getSize());

            /*randomUserList = userList.createUserList(10000);
            CustomList<List<Users>> newCustomList = new CustomArrayList<>();
            newCustomList.add(randomUserList);
            System.out.println("New Custom List Size: " + newCustomList.getSize());*/
        } catch (Exception var1) {
            System.out.println("Exception Caught:" + var1.getMessage());
        }

    }
}
