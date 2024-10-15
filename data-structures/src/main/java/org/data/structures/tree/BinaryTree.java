package org.data.structures.tree;

public class BinaryTree<T extends Comparable<T>>{

    private Node<T> root;

    public BinaryTree(){
        root = null;
    }

    public void add(T value){
        root = addNode(root, value);
    }

    private Node<T> addNode(Node<T> node, T value){
        if (node == null){
            node = new Node<>(value);
            return node;
        }

        if(value.compareTo(node.value) < 0){
            node.left = addNode(node.left, value);
        }else if(value.compareTo(node.value) > 0){
            node.rigth = addNode(node.rigth, value);
        }
        return node;
    }

    private static class Node<T>{

        T value;
        Node<T> left;
        Node<T> rigth;

        public Node(T value){
            this.value = value;
            left = null;
            rigth = null;
        }

    }
}
