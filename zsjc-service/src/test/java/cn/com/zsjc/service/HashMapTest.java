package cn.com.zsjc.service;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

@SpringBootTest
public class HashMapTest {
    public static void main(String[] args) {
        HashMapThread thread0 = new HashMapThread("thread0 ");
        HashMapThread thread1 = new HashMapThread("thread1 ");
        HashMapThread thread2 = new HashMapThread("thread2 ");
        HashMapThread thread3 = new HashMapThread("thread3");
        HashMapThread thread4 = new HashMapThread("thread4 ");
        thread0.start();
        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
    }
}

class HashMapThread extends Thread {
    private static AtomicInteger ai = new AtomicInteger();
    private static Map map = new HashMap<Object,Object>();

    public HashMapThread(String name) {
        super(name);
    }

    @Override
    public void run() {
        while (ai.get() < 1000000) {
            map.put(ai.get(), ai.get());
            System.out.println(Thread.currentThread().getName()+"==="+ai.get());
            ai.incrementAndGet();
        }
    }
}
