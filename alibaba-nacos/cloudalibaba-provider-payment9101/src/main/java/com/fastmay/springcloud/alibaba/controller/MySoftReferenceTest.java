package com.fastmay.springcloud.alibaba.controller;

import java.lang.ref.SoftReference;
import java.util.LinkedList;
import java.util.List;

/**
 * @ClassName MyReferenceTest$
 * @Description TODO
 * @Author  QQ号：48793696
 * @date 2019/5/15 19:03
 * @Version 1.0
 **/
public class MySoftReferenceTest {

    public static class Employee {
        public int salary = 0;
        public String name = "";


        public Employee(int salary, String name) {
            super();
            this.salary = salary;
            this.name = name;
        }

        @Override
        public String toString() {
            return "Empolyee [name = " + name + ",salary = " + salary + "]";
        }
    }

    //VM参数：-Xms10m -Xmx10m -XX:+PrintGC
    public static void main(String[] args) {
        Employee e = new Employee(100, "allen");
        //软引用包装
        SoftReference<Employee> eSoft = new SoftReference<Employee>(e);
        e = null;
        System.out.println("=======beforeGC=============" + eSoft.get());
        System.gc();//演示如果内存足够，是不会回收SoftReference对象
        System.out.println("=======AfterGC=============" + eSoft.get());

        //模拟一个内存溢出的场景
        List<byte[]> list = new LinkedList<byte[]>();

        try {
            for (int i = 0; i < 100; i++) {
                System.out.println("**********************" + eSoft.get());
                list.add(new byte[1024*1024*1]);
            }
        } catch (Throwable e1) {
            System.out.println("======throwable========"+eSoft.get());
        }
    }
}