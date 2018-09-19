package com.example.javasample.head;

import com.example.javasample.utils.ObjectUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

/**
 * 最大堆
 *
 * @author YGX
 */

public class MaxHeapWrapper<T> implements IHeap<T> {

    private final Comparator<T> cmptor;
    private ArrayList<T> mHeapArray;

    public MaxHeapWrapper(T[] array, Comparator<T> cmptor) {
        mHeapArray = new ArrayList<>();
        this.cmptor = cmptor;
        if (array != null) {
            mHeapArray.addAll(Arrays.asList(array));
        }
    }

    public MaxHeapWrapper(T[] array){
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
                    int max = ObjectUtils.max(lastLeafIndex, left, mHeapArray, cmptor);
                    if (max == left) {
                        ObjectUtils.swap(left, leafIndex, mHeapArray);
                    }
                    break;
                } else {
                    int maxChildIndex = ObjectUtils.max(right, left, mHeapArray, cmptor);
                    int max = ObjectUtils.max(maxChildIndex, lastLeafIndex, mHeapArray, cmptor);

                    if (max == maxChildIndex) {
                        ObjectUtils.swap(maxChildIndex, lastLeafIndex, mHeapArray);
                    }

                    lastLeafIndex = maxChildIndex;
                }
            }
        }

    }

    @Override
    public void sort() {

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
            int maxIndex = ObjectUtils.max(parentIndex, childIndex, mHeapArray, cmptor);
            if (maxIndex == parentIndex) {
                ObjectUtils.swap(parentIndex, childIndex, mHeapArray);
                childIndex = parentIndex;
            } else {
                break;
            }
        }
    }

    @Override
    public void delete(T element) {

    }

    @Override
    public void delete(int index) {

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
