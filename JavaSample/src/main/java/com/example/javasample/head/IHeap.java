package com.example.javasample.head;

/**
 * 堆数据结构;
 *
 * @author YGX
 */

public interface IHeap<T> {

    /**
     * 构建一个二叉堆
     */
    void build();

    /**
     * 二叉堆进行排序
     */
    void sort();

    /**
     * 追加一个元素
     */
    void append(T element);

    /**
     * 删除一个元素
     * @param element
     */
    void delete(T element);

    void delete(int index);

    /**
     * 获取堆
     * @return 堆数组
     */
    String toHeapString();
}
