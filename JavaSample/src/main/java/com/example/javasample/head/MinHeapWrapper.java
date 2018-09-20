package com.example.javasample.head;

import com.example.javasample.utils.ObjectUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

/**
 * 最小堆
 *
 * @author YGX
 */

public class MinHeapWrapper<T> implements IHeap<T> {

    private final Comparator<T> cmptor;
    private ArrayList<T> mHeapArray;

    public MinHeapWrapper(T[] array, Comparator<T> cmptor) {
        mHeapArray = new ArrayList<>();
        this.cmptor = cmptor;
        if (array != null) {
            mHeapArray.addAll(Arrays.asList(array));
        }
    }

    public MinHeapWrapper(T[] array) {
        this(array, null);
    }

    /**
     * 构建二叉堆, 也就是把无无序的二叉树调整成有序的二叉树,
     * 本质上就是让所有非叶子节点下沉
     */
    @Override
    public void build() {

        // 从最后一个非叶子节点开始; 如果小于它的左右孩子节点, 则交换位置(和最小的进行交换)
        int size = mHeapArray.size();
        // 获取到最后一个叶子节点的索引
        int leafIndex = (size - 1 - 1) / 2;

        for (int i = leafIndex; i >= 0; i--) {

            int lastLeafIndex = i;

            while (lastLeafIndex < size) {
                // 先从右节点比较
                int right = lastLeafIndex * 2 + 2;
                int left = lastLeafIndex * 2 + 1;

                if (right >= size && left >= size) break;

                if (right >= size) {
                    int min = ObjectUtils.min(lastLeafIndex, left, mHeapArray, cmptor);
                    if (min == left) {
                        ObjectUtils.swap(left, leafIndex, mHeapArray);
                    }
                    break;
                } else {
                    int minChildIndex = ObjectUtils.min(right, left, mHeapArray, cmptor);
                    int min = ObjectUtils.min(minChildIndex, lastLeafIndex, mHeapArray, cmptor);

                    if (min == minChildIndex) {
                        ObjectUtils.swap(minChildIndex, lastLeafIndex, mHeapArray);
                        lastLeafIndex = minChildIndex;
                    } else {
                        break;
                    }

                }
            }
        }

    }

    @Override
    public void sort() {
        // 思想
        // 将构建好的二叉堆index=0的元素(这位通常都是最值)与最后一位元素交换
        if (mHeapArray.size() < 1) return;


        int index = mHeapArray.size() - 1;

        while (index > 0) {
            T first = mHeapArray.get(0);
            T tmp = mHeapArray.get(index);

            mHeapArray.set(index, first);
            mHeapArray.set(0, tmp);

            int parentIndex = 0;
            while (parentIndex < index) {
                int left, right;
                left = parentIndex * 2 + 1;
                right = parentIndex * 2 + 2;

                // System.out.println(parentIndex + " ~ " + left + " ~ " + right);

                if (left >= index && right >= index) break;

                if (right >= index) {
                    // 最小堆, 大的往下沉
                    int min = ObjectUtils.min(parentIndex, left, mHeapArray, cmptor);
                    // 当前最小元素为子节点元素
                    if (min == left) {
                        ObjectUtils.swap(left, parentIndex, mHeapArray);
                    }
                    break;
                } else {
                    int minChild = ObjectUtils.min(left, right, mHeapArray, cmptor);
                    int min = ObjectUtils.min(minChild, parentIndex, mHeapArray, cmptor);
                    // 当前最小元素为子节点元素
                    if (min == minChild) {
                        ObjectUtils.swap(minChild, parentIndex, mHeapArray);
                        parentIndex = minChild;
                    } else {
                        break;
                    }
                }
            }

            index--;
        }
    }

    @Override
    public void append(T element) {
        // 添加到最后一个
        mHeapArray.add(element);

        // 和父节点比较, parentIndex = (chindIndex - 1) / 2
        int childIndex = mHeapArray.size() - 1;
        int parentIndex;
        while (childIndex >= 0) {
            parentIndex = (childIndex - 1) / 2;
            int minIndex = ObjectUtils.min(parentIndex, childIndex, mHeapArray, cmptor);
            if (minIndex == childIndex) {
                ObjectUtils.swap(parentIndex, childIndex, mHeapArray);
                childIndex = parentIndex;
            } else {
                break;
            }
        }
    }

    @Override
    public void delete(T element) {
        int index = -1;
        int size = mHeapArray.size();
        for (int i = 0; i < size; i++) {
            T t = mHeapArray.get(i);
            if (t == element) {
                index = i;
                break;
            }
        }
        if (index == -1) {
            System.out.println("no this element");
        } else {
            delete(index);
        }
    }

    @Override
    public void delete(int index) {
        // 用最后一个元素替代删除的元素
        int lastIndex = mHeapArray.size() - 1;
        T t = mHeapArray.remove(lastIndex);
        mHeapArray.set(index, t);

        // 从删除的索引处开始, 和左右孩子进行比对
        int parentIndex = index;
        int newSize = mHeapArray.size();
        while (parentIndex < newSize) {
            int left, right;
            left = parentIndex * 2 + 1;
            right = parentIndex * 2 + 2;

            System.out.println(parentIndex + " ~ " + left + " ~ " + right);

            if (left >= newSize && right >= newSize) break;

            if (right >= newSize) {
                // 最小堆, 大的往下沉
                int min = ObjectUtils.min(parentIndex, left, mHeapArray, cmptor);
                // 当前最小元素为子节点元素
                if (min == left) {
                    ObjectUtils.swap(left, parentIndex, mHeapArray);
                }
                break;
            } else {
                int minChild = ObjectUtils.min(left, right, mHeapArray, cmptor);
                int min = ObjectUtils.min(minChild, parentIndex, mHeapArray, cmptor);
                // 当前最小元素为子节点元素
                if (min == minChild) {
                    ObjectUtils.swap(minChild, parentIndex, mHeapArray);
                    parentIndex = minChild;
                } else {
                    break;
                }
            }
        }
    }

    @Override
    public String toHeapString() {
        StringBuilder sBuf = new StringBuilder();
        int size = mHeapArray.size();
        int c = 0, num = 0;
        for (int i = 0; i < size; i++) {

            sBuf.append(mHeapArray.get(i)).append(" ");

            if (num == 0) {
                num = (int) (Math.pow(2, c++));
            }

            if (--num == 0) sBuf.append("\n");
        }
        sBuf.append("\n");

        return sBuf.toString();
    }


}
