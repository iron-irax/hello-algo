/*
 * File: hash_map.java
 * Created Time: 2022-12-04
 * Author: Krahets (krahets@163.com)
 */

package chapter_hashing;
import java.util.*;

/* 键值对 int->String */
class Entry {
    public int key;
    public String val;
    public Entry(int key, String val) {
        this.key = key;
        this.val = val;
    }
}

/* 基于数组简易实现的哈希表 */
class ArrayHashMap {
    private List<Entry> bucket;
    public ArrayHashMap() {
        // 初始化一个长度为 10 的桶（数组）
        bucket = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            bucket.add(null);
        }
    }

    /* 哈希函数 */
    private int hashFunc(int key) {
        int index = key % 100;
        return index;
    }

    /* 查询操作 */
    public String get(int key) {
        int index = hashFunc(key);
        Entry pair = bucket.get(index);
        if (pair == null) return null;
        return pair.val;
    }

    /* 添加操作 */
    public void put(int key, String val) {
        Entry pair = new Entry(key, val);
        int index = hashFunc(key);
        bucket.set(index, pair);
    }

    /* 删除操作 */
    public void remove(int key) {
        int index = hashFunc(key);
        // 置为 null ，代表删除
        bucket.set(index, null);
    }

    /* 获取所有键值对 */
    public List<Entry> entrySet() {
        List<Entry> entrySet = new ArrayList<>();
        for (Entry pair : bucket) {
            if (pair != null)
                entrySet.add(pair);
        }
        return entrySet;
    }

    /* 获取所有键 */
    public List<Integer> keySet() {
        List<Integer> keySet = new ArrayList<>();
        for (Entry pair : bucket) {
            if (pair != null)
                keySet.add(pair.key);
        }
        return keySet;
    }

    /* 获取所有值 */
    public List<String> valueSet() {
        List<String> valueSet = new ArrayList<>();
        for (Entry pair : bucket) {
            if (pair != null)
                valueSet.add(pair.val);
        }
        return valueSet;
    }

    /* 打印哈希表 */
    public void print() {
        for (Entry kv: entrySet()) {
            System.out.println(kv.key + " -> " + kv.val);
        }
    }
}


public class array_hash_map {
    public static void main(String[] args) {
        /* 初始化哈希表 */
        ArrayHashMap map = new ArrayHashMap();

        /* 添加操作 */
        // 在哈希表中添加键值对 (key, value)
        map.put(12836, "小哈");   
        map.put(15937, "小啰");   
        map.put(16750, "小算");   
        map.put(13276, "小法");
        map.put(10583, "小鸭");
        System.out.println("\n添加完成后，哈希表为\nKey -> Value");
        map.print();

        /* 查询操作 */
        // 向哈希表输入键 key ，得到值 value
        String name = map.get(15937);
        System.out.println("\n输入学号 15937 ，查询到姓名 " + name);

        /* 删除操作 */
        // 在哈希表中删除键值对 (key, value)
        map.remove(10583);
        System.out.println("\n删除 10583 后，哈希表为\nKey -> Value");
        map.print();

        /* 遍历哈希表 */
        System.out.println("\n遍历键值对 Key->Value");
        for (Entry kv: map.entrySet()) {
            System.out.println(kv.key + " -> " + kv.val);
        }
        System.out.println("\n单独遍历键 Key");
        for (int key: map.keySet()) {
            System.out.println(key);
        }
        System.out.println("\n单独遍历值 Value");
        for (String val: map.valueSet()) {
            System.out.println(val);
        }
    }
}
