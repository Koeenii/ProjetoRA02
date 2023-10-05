/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.arvore_binaria;

import org.graphstream.graph.*;
import org.graphstream.graph.implementations.*;

/**
 *
 * @author alves
 */
public class Tree {
    private Node root;
    private Graph graph;
    
    public Tree() {
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
        
        return curr;
    }
    
    public void printPreOrdem(Node currentNode) {
        if (currentNode == null) {
            currentNode = this.root;
        }
        
        currentNode.print();
        
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
    
    public void createGraphNode(Node parent, Node current) {  // Não Finalizado
        if (current != null) {
            graph.addNode(Integer.toString(current.getData())).setAttribute("ui.label", "S");
            
            
            if (parent != null) {
                graph.addEdge(Integer.toString(parent.getData()) + Integer.toString(current.getData()), Integer.toString(parent.getData()), Integer.toString(current.getData()));
            }
            
            createGraphNode(current, current.getLeft());
            createGraphNode(current, current.getRight());
        }
    } 
    
    public void displayGraph() { // Não Finalizado
        System.setProperty("org.graphstream.ui", "swing");
		
        this.graph = new SingleGraph("Grafico");
        
        this.createGraphNode(null, root);
        
        graph.display();
    }
 }
