package com.elbicon.coderscampus;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CustomArrayListTest <T>{
    final Integer usersToBeCreated = 10;
    final Integer userIndexToBeRemoved = 1;
    Boolean updateSuccessful = false;
    List<List<Users>> randomUser;
    CustomList<List<List<Users>>> users = new CustomArrayList<>();

    @Test
    void should_add_item_to_array() {
        //ARRANGE
        List<Boolean> sut = new ArrayList<>();
        Integer successCount = 0;

        //ACT
        for (int i=0;i<usersToBeCreated;i++){
            randomUser = getRandomUser(i);
            sut.add(users.add(randomUser));
        }

        //ASSERT
        if (usersToBeCreated == sut.size()) {
            for ( Boolean updateSuccess : sut){
                if (updateSuccess){
                    successCount++;
                }
            }
            if(successCount == usersToBeCreated){
                System.out.println("** SUT Test Succeeded ** ");
            }
        } else {
            System.out.println("** SUT Test Failed ** ");
        }
    }

    @Test
    void  should_remove_item_from_array() {
        //ARRANGE
        T sut;

        //ACT
        for (int i=0;i<usersToBeCreated;i++){
            randomUser = getRandomUser(i);
            users.add(randomUser);
        }

        sut =  (T) users.remove(userIndexToBeRemoved);

        //ASSERT
        if ((Boolean) sut == true){
            System.out.println("** SUT Test Succeeded ** ");
        }else{
            System.out.println("** SUT Test Failed ** ");
        }
    }


    @Test
    void should_add_users_to_array_index() {
        //ARRANGE
        List<Boolean> sut = new ArrayList<>();
        Integer successCount = 0;
        Integer size = 0;
        Integer additionalUserCount=1;
        int insertAtIndex= 1;
        Boolean updateSuccessful = false;

        //ACT
        for (int i=0;i<usersToBeCreated;i++){
            randomUser = getRandomUser(i);
            sut.add(users.add(randomUser));
        }
        size = sut.size();
        randomUser = getRandomUser(additionalUserCount);
        sut.add(users.add(insertAtIndex,randomUser));

        //ASSERT
        if (sut.size() == (insertAtIndex + usersToBeCreated)){
            Boolean updateSuccess = sut.get(1);
            if (updateSuccess == Boolean.TRUE){
                System.out.println("** SUT Test Succeeded ** ");
            }else{
                System.out.println("** SUT Test Failed ** ");
            }
        } else{
            System.out.println("** SUT Test Failed ** ");
        }
    }


    @Test
    void should_get_array_size() {
        //ARRANGE
        List<Boolean> sut = new ArrayList<>();

        //ACT
        for (int i=0;i<usersToBeCreated;i++){
            randomUser = getRandomUser(i);
            sut.add(users.add(randomUser));
        }

        //ASSERT
        if(sut.size() == users.getSize()){
            System.out.println("** SUT Test Succeeded ** ");
        } else{
            System.out.println("** SUT Test Failed ** ");
        }

    }

    @Test
    void should_get_from_array_index() {
        //ARRANGE
        List<Boolean> sut = new ArrayList<>();
        Integer elementIndex = 1;

        //ACT
        for (int i=0;i<usersToBeCreated;i++){
            randomUser = getRandomUser(i);
            sut.add(users.add(randomUser));
        }

        List<List<Users>> userAtIndex = users.get(elementIndex);

        if (!(userAtIndex == null)){
            System.out.println("** SUT Test Succeeded ** ");
        } else{
            System.out.println("** SUT Test Failed ** ");
        }

    }


    List<List<Users>> getRandomUser(Integer userCount){
        CustomList<List<List<Users>>> randomUser = new CustomArrayList<>();

        List<List<Users>> randomUserList = new ArrayList<>();
        PopulateUserList userList = new PopulateUserList();

        try{
            randomUserList = userList.createUserList(userCount);
        } catch (Exception e){
            System.out.println("Exception Caught: " + e.getMessage());
        }
        return randomUserList;
    }
}