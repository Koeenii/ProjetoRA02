/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.arvore_binaria;

/**
 *
 * @author alves
 */
public class Node {
    private Node left;
    private Node right;
    private int data;
    
    public Node() {
        this.left = null;
        this.right = null;
        this.data = 0;
    }
    
    public void setData(int data) {
        this.data = data;
    }
    
    public int getData() {
        return this.data;
    }
    
    public void setLeft(Node node) {
        this.left = node;
    }
    
    public Node getLeft() {
        return this.left;
    }
    
    public void setRight(Node node) {
        this.right = node;
    }
    
    public Node getRight() {
        return this.right;
    }
    
    public void print() {
        System.out.println(this.data);
    }
}
