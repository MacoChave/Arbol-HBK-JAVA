package io.github.macochave;

import AVLTree.AVLTree;
import TAD.TADTree;

import java.io.*;

public class Main {

    private static AVLTree<TADTree> tree = new AVLTree<TADTree>();
    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) {
        int opcion = 0;

        do {
            System.out.println(
                    "[0] Salir\n" +
                    "[1] Agregar\n" +
                    "[2] Graficar\n");
            try {
                opcion = Integer.parseInt(reader.readLine());

                switch (opcion)
                {
                    case 0:
                        System.out.println("Saliendo...");
                        break;
                    case 1:
                        System.out.print("Numero: ");
                        int data = Integer.parseInt(reader.readLine());
                        TADTree info = new TADTree(data);
                        tree.add(info);
                        break;
                    case 2:
                        graphTree("Arbolito");
                        break;
                    default:
                        System.out.println("No se puede procesar dicha opción.");
                        break;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        } while (opcion != 0);
    }

    private static void graphTree(String filename) {
        String text = String.format("digraph %s {\n",
                filename);
        text += "rankdir = TB\n";
        text += "node [shape = record]\n";
        text += tree.graph();
        text += "\n}";

        File file = new File(filename + ".dot");
        BufferedWriter writer;
        try {
            writer = new BufferedWriter(new FileWriter(file));
            writer.write(text);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        String cmd = String.format("dot -Tpng %s.dot -o %s.png",
                filename, filename);
        try {
            Runtime.getRuntime().exec(cmd);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}