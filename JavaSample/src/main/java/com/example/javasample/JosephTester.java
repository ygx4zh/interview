package com.example.javasample;

import java.util.ArrayList;
import java.util.List;

/**
 * 约瑟夫环, 正确:
 *
 * Node{index=6, value=7}
 Node{index=3, value=4}
 Node{index=1, value=2}
 Node{index=0, value=1}
 Node{index=2, value=3}
 Node{index=5, value=6}
 Node{index=9, value=10}
 Node{index=4, value=5}
 Node{index=7, value=8}
 haha: Node{index=8, value=9}
 */
public class JosephTester {

    public static void main(String[] args) {
        List<Node> nodes = new ArrayList<>();

        final int count = 10;
        final int num = 7;

        // init
        init(nodes,count);

        int index = 1;
        Node cur = nodes.get(0);
        while (nodes.size() > 1){

            if(index % num == 0){
                nodes.remove(cur);
                Node pre = cur.pre;
                Node next = cur.next;
                if(pre != null && next != null){
                    pre.next = next;
                    next.pre = pre;
                }else if(pre != null)
                    pre.next = null;
                else if(next != null)
                    next.pre = null;

                System.out.println(cur.toString());
                index = 0;
            }

            index ++;
            if(cur.next == null){
                cur = nodes.get(0);
            }else{
                cur = cur.next;
            }
        }
        System.out.println("haha: "+cur.toString());
    }

    private static void init(List<Node> list, int count){
        for (int i = 0; i < count; i++) {
            if(i > 0) {
                Node pre = list.get(i - 1);

                Node e = new Node(i, i+1, null, pre);
                pre.next = e;
                list.add(e);
            }else{
                list.add(new Node(i,i+1,null,null));
            }
        }
    }

    static class Node{
        private int index;
        private int value;
        private Node next;
        private Node pre;

        public Node() {
        }

        public Node(int index, int value, Node next, Node pre) {
            this.index = index;
            this.value = value;
            this.next = next;
            this.pre = pre;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "index=" + index +
                    ", value=" + value +
                    '}';
        }
    }
}
