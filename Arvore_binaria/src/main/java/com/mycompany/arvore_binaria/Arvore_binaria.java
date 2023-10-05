/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.arvore_binaria;
import java.util.Scanner;
import java.util.Random;

/**
 *
 * @author alves
 */
public class Arvore_binaria {

    public static void main(String[] args) {
        // Criar Randomizador
        Random randomizer;
        
        // Criar Scanner para input
        Scanner scanner = new Scanner(System.in);
        
        // Criar as Arvores para Teste
        AVLTree avlTree = new AVLTree();
        Tree tree = new Tree();
        
        // Criar as variaveis auxiliares
        int item;
        
        // Selecionar Tamanho das Arvores
        while (true) {
            System.out.println("\nSelecione o Tamanho das Arvoresx:");
            System.out.println("\n (1) - 100");
            System.out.println("\n (2) - 500");
            System.out.println("\n (3) - 1.000");
            System.out.println("\n (4) - 10.000");
            System.out.println("\n (5) - 20.000");
            
            item = scanner.nextInt();
            
            if (item < 1 || item > 5) {
                System.out.println("Opção invalida.");
                continue;
            }
            
            switch (item) {
                case 1:
                    item = 100;
                    break;
                case 2:
                    item = 500;
                    break;
                case 3:
                    item = 1000;
                    break;
                case 4:
                    item = 10000;
                    break;
                case 5:
                    item = 20000;
                    break;
            }
            
            break;
        }
        
        // Popular as Arvores [Arvore Binaria]
        long treeInsertTime = System.currentTimeMillis();
        
        randomizer = new Random(101);
        
        for (int i = 0; i < item; i++) {
            int randNum = randomizer.nextInt(10000);
            tree.insert(randNum);
        }
        
        treeInsertTime = System.currentTimeMillis() - treeInsertTime;
        
        // Popular as Arvores [Arvore AVL]
        long avlTreeInsertTime = System.currentTimeMillis();
        randomizer = new Random(101);
        
        for (int i = 0; i < item; i++) {
            int randNum = randomizer.nextInt(10000);
            avlTree.insert(randNum);
        }
        
        avlTreeInsertTime = System.currentTimeMillis() - avlTreeInsertTime;
        
        // Teste de Search [Arvore Binaria]
        long treeSearchTime = System.nanoTime();
        tree.search(710);
        treeSearchTime = System.nanoTime() - treeSearchTime;
        
        // Teste de Search [Arvore AVL]
        long avlTreeSearchTime = System.nanoTime();
        avlTree.search(710);
        avlTreeSearchTime = System.nanoTime() - avlTreeSearchTime;
        
        // Teste de Delete [Arvore Binaria]
        long treeDeleteTime = System.nanoTime();
        tree.remove(710);
        treeDeleteTime = System.nanoTime() - treeDeleteTime;
        
        // Teste de Delete [Arvore AVL]
        long avlTreeDeleteTime = System.nanoTime();
        avlTree.remove(710);
        avlTreeDeleteTime = System.nanoTime() - avlTreeDeleteTime;
        
        // Resultados
        System.out.println("TAMANHO:" + item + "\n");
        System.out.println("ARVORE BINARIA:\n");
        System.out.println("INSERT:" + treeInsertTime + "ms\n");
        System.out.println("SEARCH:" + treeSearchTime + "ns\n");
        System.out.println("DELETE:" + treeDeleteTime + "ns\n");
        System.out.println("------------------\n");
        System.out.println("ARVORE AVL:\n");
        System.out.println("INSERT:" + avlTreeInsertTime + "ms\n");
        System.out.println("SEARCH:" + avlTreeSearchTime + "ns\n");
        System.out.println("DELETE:" + avlTreeDeleteTime + "ns\n");
    }
}
