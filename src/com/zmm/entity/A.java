package com.zmm.entity;

public class A {
    void a(){
        this.b();
    }
    void b(){
        //输出Ab
        System.out.println("Ab");
    }

    public static void main(String[] args) {
        new C().a();
    }
}
class B extends A{
        //重载
        @Override
        void b(){
        //输出Bb
            System.out.println("Bb");
        }
        }
class C extends A{
        //重载
        @Override
        void a(){
        super.a();
        }
        //重载
        @Override
        void b(){
        //输出Cb
            System.out.println("Cb");
        }
        }
