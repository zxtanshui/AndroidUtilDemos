package com.example;

import java.util.ArrayList;
import java.util.List;

import javax.naming.InitialContext;

public class MyClass {

    public static void main(String args[]){


        List<String>  stringList1=new ArrayList<>();
        stringList1=getData();
        System.out.println(stringList1.toString());
        stringList1=getData();
        System.out.println(stringList1.toString());
    }
    public static  List<String>  getData(){
         List<String>  stringList=new ArrayList<>();
        for(int i=0;i<3;i++){
            stringList.add(i+i+"");
        }
        return stringList;
    }
}
