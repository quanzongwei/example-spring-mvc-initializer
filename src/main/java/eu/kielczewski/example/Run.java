package eu.kielczewski.example;

import java.lang.reflect.Method;

/**
 * Created by quanzongwei(207127) on 2016/11/23 0023.
 */
public class Run {
//    -XX:+TraceClassLoading  -Dsun.reflect.inflationThreshold=0
    public static void main(String[] args) throws Exception {
        Class<?> clz = Class.forName("eu.kielczewski.example.A");
        Class<?> clzb = Class.forName("eu.kielczewski.example.B");
        Class<?> clzc = Class.forName("eu.kielczewski.example.C");

        A  a= new A();

        B b = new B();
        C c = new C();
//        for (int i = 0; i < 20; i++) {
//            Object o = clz.newInstance();
//           // Object o2 = clzb.newInstance();
//            //A a = new A();
//            //System.out.println(A.class.isInstance(a));
////            Field field = clz.getDeclaredField("name");
////            field.set(a,"string");
//            System.out.println("hello," + i);
//
//        }
//        for (int i = 0; i < 20; i++) {
//           // Object o = clz.newInstance();
//            Object o2 = clzb.newInstance();
//            //A a = new A();
//            //System.out.println(A.class.isInstance(a));
////            Field field = clz.getDeclaredField("name");
////            field.set(a,"string");
//            System.out.println("hello," + i);
//
//        }
//
//        for (int i = 0; i < 20; i++) {
//            // Object o = clz.newInstance();
//            Object o2 = clzb.getDeclaredField("name");
//            //A a = new A();
//            //System.out.println(A.class.isInstance(a));
//            //            Field field = clz.getDeclaredField("name");
//            //            field.set(a,"string");
//            System.out.println("hello," + i);
//
//        }
        Method m = clz.getMethod("foo", String.class);
        Method m1 = clz.getDeclaredMethod("foo2", String.class);
        Method m2 = clzb.getMethod("foo", String.class);
        Method m3 = clzc.getMethod("foo", String.class);
        for (int i = 0; i < 16; i++) {
            m.invoke(a, Integer.toString(i));
            m1.invoke(a, Integer.toString(i));

        }
//        for (int i = 0; i < 16; i++) {
//            m2.invoke(b, Integer.toString(i));
//
//        }
//
//        for (int i = 0; i < 16; i++) {
//            m3.invoke(c, Integer.toString(i));
//
//        }
    }

    // 结论是:invoke和new Instance 15次数就出问题,field.set19次后加载

        public void foo(String name) {
            System.out.println("Hello, " + name);
        }

}
