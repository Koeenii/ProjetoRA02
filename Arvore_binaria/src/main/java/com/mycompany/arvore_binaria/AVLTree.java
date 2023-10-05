/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.arvore_binaria;

/**
 *
 * @author alves
 */
public class AVLTree {
    public Node root;
    
    public AVLTree() {
        this.root = null;
    }
    
    public void insert(int data) {
        Node node = new Node();
        node.setData(data);
        
        if (this.root == null) { // Caso não tenha raiz, adiciona uma raiz
            this.root = node;
        } else {
            Node currentNode = this.root;
            
            while (currentNode != null) { // Navega através da arvore procurando onde colocar o nodo
                if (data >= currentNode.getData()) {
                    if (currentNode.getRight() != null) {
                        currentNode = currentNode.getRight();
                    } else {
                        currentNode.setRight(node);
                        break;
                    }
                } else {
                    if (currentNode.getLeft() != null) {
                        currentNode = currentNode.getLeft();
                    } else {
                        currentNode.setLeft(node);
                        break;
                    }
                }
            }
        }
        
        this.root = this.rebalance(this.root); // Rebalancear após inserção
    }
    
    public Node search(int elemento) {
        Node curr = this.root;
        
        while (curr != null && curr.getData() != elemento) { // Busca o Elemento Desejado
            if (curr.getData() > elemento) {
                curr = curr.getLeft();
            }  else {
                curr = curr.getRight();
            }
        }
        
        return curr;
    }
    
    public Node remove(int elemento) {
        Node curr = this.root;
        Node prev = this.root;
        
        while (curr != null && curr.getData() != elemento) { // Realiza a busca pelo elemento desejado
            if (curr.getData() > elemento) {
                prev = curr;
                curr = curr.getLeft();
            }  else {
                prev = curr;
                curr = curr.getRight();
            }
        }
        
        if (prev != null && curr != null) {
            if (prev.getRight() == curr) { // Caso Elemento a ser removido esteja a direita do Anterior
                if (curr.getLeft() != null) { // Caso tenha um elemento a Esquerda
                    prev.setRight(curr.getLeft());
                    
                } else {  // Caso não tenha um elemento a Esquerda
                    Node temp = curr.getRight();
                    
                    while (temp != null && temp.getRight() != null && temp.getData() > temp.getRight().getData()) {
                        temp = temp.getRight();
                    }
                    
                    prev.setRight(temp);
                }
            } else { // Caso Elemento a ser removido esteja a esquerda do Anterior
                if (curr.getLeft() != null) { // Caso tenha um elemento a Esquerda
                    prev.setLeft(curr.getLeft());
                    
                } else {  // Caso não tenha um elemento a Esquerda
                    Node temp = curr.getRight();
                    
                    while (temp != null && temp.getRight() != null && temp.getData() > temp.getRight().getData()) {
                        temp = temp.getRight();
                    }
                    
                    prev.setLeft(temp);
                }
            }
        }
        
        this.root = this.rebalance(this.root); // Rebalancear após remoção
        
        return curr;
    }
    
    public void printPreOrdem(Node currentNode) {
        if (currentNode == null) {
            currentNode = this.root;
        }
        
        System.out.println("----------------------------------");
        currentNode.print();
        System.out.println(this.getAltura(currentNode));
        System.out.println(this.getBalance(currentNode));
        System.out.println("----------------------------------");
        
        if (currentNode.getLeft() != null) {
            this.printPreOrdem(currentNode.getLeft());
        }
        
        if (currentNode.getRight() != null) {
            this.printPreOrdem(currentNode.getRight());
        }
    }
    
    public void printInOrdem(Node currentNode) {
        if (currentNode == null) {
            currentNode = this.root;
        }
        
        if (currentNode.getLeft() != null) {
            this.printInOrdem(currentNode.getLeft());
        }
        
        currentNode.print();
        
        if (currentNode.getRight() != null) {
            this.printInOrdem(currentNode.getRight());
        }
    }
    
    public void printPosOrdem(Node currentNode) {
        if (currentNode == null) {
            currentNode = this.root;
        }
        
        if (currentNode.getLeft() != null) {
            this.printPosOrdem(currentNode.getLeft());
        }
        
        if (currentNode.getRight() != null) {
            this.printPosOrdem(currentNode.getRight());
        }
        
        currentNode.print();
    }
    
    public int getAltura(Node node) { // Pegar Altura de um nodo especifico de maneira recursiva
        if (node == null) 
            return -1;
        
        if (this.getAltura(node.getLeft()) >= this.getAltura(node.getRight())) {
            return this.getAltura(node.getLeft()) + 1;
        } else {
            return this.getAltura(node.getRight()) + 1;
        }
    }
    
    public int getBalance(Node node) { // Pegar Balanceamento de um nodo especifico
        if (node == null) 
            return 0;
        
        return this.getAltura(node.getRight()) - this.getAltura(node.getLeft());
    }
    
    public Node rebalance(Node node) {
        if (this.getBalance(node) <= -2) {
            if (this.getBalance(node.getLeft()) >= 1) {// Caso Especial Rotação Dupla
                node.setLeft(rotLeft(node.getLeft()));
                node = rotRight(node);
                
            } else {
                node = rotRight(node);
                
            }
        } else if (this.getBalance(node) >= 2) {
            if (this.getBalance(node.getRight()) <= -1) { // Caso Especial Rotação Dupla
                node.setRight(rotRight(node.getRight()));
                node = rotLeft(node);
                
            } else {
                node = rotLeft(node);
                
            }
        }
        
        return node;
    }
    
    public Node rotRight(Node node) {
        Node newNode = node.getLeft();
        node.setLeft(newNode.getRight());
        newNode.setRight(node);
        
        return newNode;
    }
    
    public Node rotLeft(Node node) {
        Node newNode = node.getRight();
        node.setRight(newNode.getLeft());
        newNode.setLeft(node);
        
        return newNode;
    }
 }
