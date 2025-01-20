package com.ginelmac.springbootredisbloom.test;

public class test {
    final Object obj = new Object();
    public void entry01(){
        new Thread(()->{
           synchronized (obj){
               System.out.println(Thread.currentThread().getName()+"外层调用");
               synchronized (obj){
                   System.out.println(Thread.currentThread().getName()+"中层调用");
                   synchronized (obj){
                       System.out.println(Thread.currentThread().getName()+"内层调用");
                   }
               }
           }
        },"t1").start();
    }
    public void entry03(){

    }
    public static void main(String[] args) {
        test t1 = new test();
        t1.entry01();
    }
}
