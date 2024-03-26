/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package evidencia3ed;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 *
 * @author Fairoox
 */
public class Evidencia3ED {
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_RESET = "\u001B[0m";

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);

        char opcion;
        char eleccion;
        
        //variables time//
        long startTime;
        long endTime;
        long Time;
        
        //a. 100 elementos al azar//
        Integer[] newListA = new Integer[100];
        for (int i = 0; i < newListA.length; i++){
            newListA[i] = (int) (Math.random()*1000)+1; 
        }
       
        //b. 50,000 elementos al azar
        Integer[] newListB = new Integer[50000];
        for (int i = 0; i < newListB.length; i++){
            newListB[i] = (int) (Math.random()*50000)+1; 
        }
        
        //c. 100,000 elementos al azar
        Integer[] newListC = new Integer[10000];
        for (int i = 0; i < newListC.length; i++){
            newListC[i] = (int) (Math.random()*10000)+1; 
        }

        //d. 100,000 elementos ordenados en orden inverso
        Integer[] newListD = new Integer[10000];
        for (int i = 0; i < newListD.length; i++){
            newListD[i]= i + 1; 
        }
        Arrays.sort(newListD, Comparator.reverseOrder());
        
        //e. 100,000 elementos ordenados
        Integer[] newListE = new Integer[10000];
        for (int i = 0; i < newListE.length; i++){
            newListE[i]= i + 1; 
        }
        
        //f. 100,000 elementos que sólo pueden ser números entre el 1 y el 5
        Integer[] newListF = new Integer[10000];
        for (int i = 0; i < newListD.length; i++){
            newListF[i] = (int) (Math.random()*5)+1; 
        }
        
        do {
            System.out.println("Lista de elementos: ");
            System.out.println("a. 100 elementos al azar");
            System.out.println("b. 50,000 elementos al azar");
            System.out.println("c. 100,000 elementos al azar");
            System.out.println("d. 100,000 elementos ordenados en orden inverso");
            System.out.println("e. 100,000 elementos ordenados");
            System.out.println("f. 100,000 elementos que solo pueden ser numeros entre 1 y 5");
            System.out.println("z. Exit");
            System.out.print("Cual eliges?: ");
            opcion = sc.next().charAt(0);   
            
            switch(opcion){
                case 'a': case 'A': {
                
                System.out.println("\n[Tu Array es : ]");
                System.out.println(Arrays.toString(newListA));        
                    
                Integer[] destinoABubble = new Integer [100];
                System.arraycopy(newListA, 0, destinoABubble, 0, destinoABubble.length);                
                
                //ORDENAMIENTO BURBUJA
                    System.out.println();         
                    startTime = System.currentTimeMillis();     
                    for (int i = 0; i < destinoABubble.length-1; i++) {
                    destinoABubble = bubble(destinoABubble);
                    }
                    endTime = System.currentTimeMillis();
                //Impresion del arreglo acomodado
                    System.out.println(ANSI_BLUE + "[Metodo burbuja]" + ANSI_RESET);
                    System.out.println(Arrays.toString(destinoABubble));   
                    
                //Tiempo
                    Time = endTime-startTime;
                    System.out.println("Tiempo en milsegundos: " + Time );
                    Time = (Time/1000);
                    System.out.println("Tiempo en segundos: " + Time );
                    
                //ORDENAMIETO SELECCION
                Integer[] destinoASeleccion = new Integer [100];
                System.arraycopy(newListA, 0, destinoASeleccion, 0, destinoASeleccion.length);
                
                    System.out.println();
                    startTime = System.currentTimeMillis();
                    for (int i = 0; i < destinoASeleccion.length; i++) {
                        destinoASeleccion=seleccion(destinoASeleccion,i);
                    }
                    endTime = System.currentTimeMillis();
                //Impresion del arreglo acomodado
                    System.out.println(ANSI_RED + "[Metodo seleccion]" + ANSI_RESET);
                    System.out.println(Arrays.toString(destinoASeleccion));

                //Tiempo
                    Time = endTime-startTime;
                    System.out.println("Tiempo en milsegundos: " + Time );
                    Time = (Time/1000);
                    System.out.println("Tiempo en segundos: " + Time );
                    
                    
                //ORDENAMIENTO Inserción
                Integer[] destinoAInsercion = new Integer [100];
                System.arraycopy(newListA, 0, destinoAInsercion, 0, destinoAInsercion.length);
                
                    System.out.println(); 
                    startTime = System.currentTimeMillis();
                    for (int i = 0; i < destinoAInsercion.length; i++) {
                        destinoAInsercion = insercion (destinoAInsercion); 
                    }
                    endTime = System.currentTimeMillis();
                //Impresion del arreglo acomodado
                    System.out.println(ANSI_GREEN + "[Metodo insercion]" + ANSI_RESET);
                    System.out.println(Arrays.toString(destinoAInsercion));  
                    
                //TIME
                    Time = endTime-startTime;
                    System.out.println("Tiempo en milsegundos: " + Time );
                    Time = (Time/1000);
                    System.out.println("Tiempo en segundos: " + Time );
                    
                //Ordenamiento SHELL
                Integer[] destinoAShell = new Integer [100];
                System.arraycopy(newListA, 0, destinoAShell, 0, destinoAShell.length);
                
                    System.out.println(); 
                    startTime = System.currentTimeMillis();
                    for (int i = 0; i < destinoAShell.length; i++) {
                        destinoAShell = shell (destinoAShell); 
                    }
                    endTime = System.currentTimeMillis();
                //Impresion del arreglo acomodado
                    System.out.println(ANSI_YELLOW + "[Metodo shell]" + ANSI_RESET);
                    System.out.println(Arrays.toString(destinoAShell));  
                    
                //TIEMPO    
                    Time = endTime-startTime;
                    System.out.println("Tiempo en milsegundos: " + Time );
                    Time = (Time/1000);
                    System.out.println("Tiempo en segundos: " + Time );
                    
                //ORDENAMIENTO Union
                Integer[] destinoAUnion = new Integer [100];
                System.arraycopy(newListA, 0, destinoAUnion, 0, destinoAUnion.length);
                
                    System.out.println(); 
                    var listUnion = new ArrayList<>(Arrays.asList(destinoAUnion));
                    
                    startTime = System.currentTimeMillis();
                    listUnion = sort (listUnion);                    
                    endTime = System.currentTimeMillis();
                //Impresion del arreglo acomodado
                    System.out.println(ANSI_CYAN + "[Metodo union]" + ANSI_RESET);
                    System.out.println(listUnion);  
                    
                    Time = endTime-startTime;
                    System.out.println("Tiempo en milsegundos: " + Time );
                    Time = (Time/1000);
                    System.out.println("Tiempo en segundos: " + Time );
                                       
                //ORDENAMIENTO Quick
                Integer[] destinoAQuick = new Integer [100];
                System.arraycopy(newListA, 0, destinoAQuick, 0, destinoAQuick.length);
                
                    System.out.println(); 
                    int[] ListQuick = new int[destinoAQuick.length];

                    for(int ctr = 0; ctr < destinoAQuick.length; ctr++) {
                        ListQuick[ctr] = destinoAQuick[ctr]; // returns int value
                    }
                    
                    startTime = System.currentTimeMillis();
                    quicksort(ListQuick, 0, ListQuick.length-1);                   
                    endTime = System.currentTimeMillis();
                //Impresion del arreglo acomodad
                    System.out.println(ANSI_PURPLE + "[Metodo quick]" + ANSI_RESET);
                    System.out.println(Arrays.toString(ListQuick));  
                    
                //TIEMPO    
                    Time = endTime-startTime;
                    System.out.println("Tiempo en milsegundos: " + Time );
                    Time = (Time/1000);
                    System.out.println("Tiempo en segundos: " + Time );                    
                    
                break;   
                }
                
                case 'b': case 'B': {      
                    
                System.out.println("\n[Tu Array es : ]");
                System.out.println(Arrays.toString(newListB));        
                    
                Integer[] destinoBBubble = new Integer [50000];
                System.arraycopy(newListB, 0, destinoBBubble, 0, destinoBBubble.length);

                //ORDENAMIENTO BURBUJA
                    System.out.println();     
                    startTime = System.currentTimeMillis();     
                    for (int i = 0; i < destinoBBubble.length-1; i++) {
                    destinoBBubble = bubble(destinoBBubble);                   
                    }
                    endTime = System.currentTimeMillis();
                //Impresion del arreglo acomodado
                    System.out.println(ANSI_BLUE + "[Metodo burbuja]" + ANSI_RESET);
                    System.out.println(Arrays.toString(destinoBBubble));
                    
                    
                //Tiempo
                    Time = endTime-startTime;
                    System.out.println("Tiempo en milsegundos: " + Time );
                    Time = (Time/1000);
                    System.out.println("Tiempo en segundos: " + Time );
                    
                //ORDENAMIETO SELECCION
                Integer[] destinoBSeleccion = new Integer [50000];
                System.arraycopy(newListB, 0, destinoBSeleccion, 0, destinoBSeleccion.length);
                
                    System.out.println();
                    startTime = System.currentTimeMillis();
                    for (int i = 0; i < destinoBSeleccion.length; i++) {
                        destinoBSeleccion=seleccion(destinoBSeleccion,i);
                    }
                    endTime = System.currentTimeMillis();
                //Impresion del arreglo acomodado
                    System.out.println(ANSI_RED + "[Metodo seleccion]" + ANSI_RESET);
                    System.out.println(Arrays.toString(destinoBSeleccion));

                //Tiempo
                    Time = endTime-startTime;
                    System.out.println("Tiempo en milsegundos: " + Time );
                    Time = (Time/1000);
                    System.out.println("Tiempo en segundos: " + Time );
                    
                   
                //ORDENAMIENTO Inserción
                Integer[] destinoBInsercion = new Integer [50000];
                System.arraycopy(newListB, 0, destinoBInsercion, 0, destinoBInsercion.length);
                
                    System.out.println(); 
                    for (int i = 0; i < newListB.length; i++) {
                        destinoBInsercion = insercion (destinoBInsercion); 
                    }
                    endTime = System.currentTimeMillis();
                //Impresion del arreglo acomodado
                    System.out.println(ANSI_GREEN + "[Metodo insercion]" + ANSI_RESET);
                    System.out.println(Arrays.toString(destinoBInsercion));  
                    
                //TIME
                    Time = endTime-startTime;
                    System.out.println("Tiempo en milsegundos: " + Time );
                    Time = (Time/1000);
                    System.out.println("Tiempo en segundos: " + Time );
                    
                //Ordenamiento SHELL
                Integer[] destinoBShell = new Integer [50000];
                System.arraycopy(newListB, 0, destinoBShell, 0, destinoBShell.length);
                
                    System.out.println(); 
                    startTime = System.currentTimeMillis();
                    for (int i = 0; i < destinoBShell.length; i++) {
                        destinoBShell = shell (destinoBShell); 
                    }
                    endTime = System.currentTimeMillis();
                //Impresion del arreglo acomodado
                    System.out.println(ANSI_YELLOW + "[Metodo shell]" + ANSI_RESET);
                    System.out.println(Arrays.toString(destinoBShell));  
                    
                //TIEMPO    
                    Time = endTime-startTime;
                    System.out.println("Tiempo en milsegundos: " + Time );
                    Time = (Time/1000);
                    System.out.println("Tiempo en segundos: " + Time );
                    
                //ORDENAMIENTO Union
                Integer[] destinoBUnion = new Integer [50000];
                System.arraycopy(newListB, 0, destinoBUnion, 0, destinoBUnion.length);                
                
                    System.out.println(); 
                    var listUnion = new ArrayList<>(Arrays.asList(destinoBUnion));
                    
                    startTime = System.currentTimeMillis();
                    listUnion = sort (listUnion);                    
                    endTime = System.currentTimeMillis();
                //Impresion del arreglo acomodado
                    System.out.println(ANSI_CYAN + "[Metodo union]" + ANSI_RESET);
                    System.out.println(listUnion);  
                    
                    Time = endTime-startTime;
                    System.out.println("Tiempo en milsegundos: " + Time );
                    Time = (Time/1000);
                    System.out.println("Tiempo en segundos: " + Time );
                               
                //ORDENAMIENTO Quick
                Integer[] destinoBQuick = new Integer [50000];
                System.arraycopy(newListB, 0, destinoBQuick, 0, destinoBQuick.length);
                
                    System.out.println(); 
                    int[] ListQuick = new int[destinoBQuick.length];

                    for(int ctr = 0; ctr < destinoBQuick.length; ctr++) {
                        ListQuick[ctr] = destinoBQuick[ctr]; // returns int value
                    }
                    
                    startTime = System.currentTimeMillis();
                    quicksort(ListQuick, 0, ListQuick.length-1);                   
                    endTime = System.currentTimeMillis();
                //Impresion del arreglo acomodado
                    System.out.println(ANSI_PURPLE + "[Metodo quick]" + ANSI_RESET);
                    System.out.println(Arrays.toString(ListQuick));  
                    
                //TIEMPO    
                    Time = endTime-startTime;
                    System.out.println("Tiempo en milsegundos: " + Time );
                    Time = (Time/1000);
                    System.out.println("Tiempo en segundos: " + Time );                    
                    
                break;   
                }
                
                case 'c': case 'C': { 
                System.out.println("\n[Tu Array es : ]");
                System.out.println(Arrays.toString(newListC));        
                    
                Integer[] destinoCBubble = new Integer [10000];
                System.arraycopy(newListC, 0, destinoCBubble, 0, destinoCBubble.length);                    
                    
                //ORDENAMIENTO BURBUJA
                    System.out.println();         
                    startTime = System.currentTimeMillis();     
                    for (int i = 0; i < destinoCBubble.length-1; i++) {
                    destinoCBubble = bubble(destinoCBubble);
                    }
                    endTime = System.currentTimeMillis();
                //Impresion del arreglo acomodado
                    System.out.println(ANSI_BLUE + "[Metodo burbuja]" + ANSI_RESET);
                    System.out.println(Arrays.toString(destinoCBubble));   
                    
                //Tiempo
                    Time = endTime-startTime;
                    System.out.println("Tiempo en milsegundos: " + Time );
                    Time = (Time/1000);
                    System.out.println("Tiempo en segundos: " + Time );
                    
                //ORDENAMIETO SELECCION
                Integer[] destinoCSeleccion = new Integer [10000];
                System.arraycopy(newListC, 0, destinoCSeleccion, 0, destinoCSeleccion.length);
                
                    System.out.println();
                    startTime = System.currentTimeMillis();
                    for (int i = 0; i < destinoCSeleccion.length; i++) {
                        destinoCSeleccion=seleccion(destinoCSeleccion,i);
                    }
                    endTime = System.currentTimeMillis();
                //Impresion del arreglo acomodado
                    System.out.println(ANSI_RED + "[Metodo seleccion]" + ANSI_RESET);
                    System.out.println(Arrays.toString(destinoCSeleccion));

                //Tiempo
                    Time = endTime-startTime;
                    System.out.println("Tiempo en milsegundos: " + Time );
                    Time = (Time/1000);
                    System.out.println("Tiempo en segundos: " + Time );
                    
                    
                //ORDENAMIENTO Inserción
                Integer[] destinoCInsercion = new Integer [10000];
                System.arraycopy(newListC, 0, destinoCInsercion, 0, destinoCInsercion.length);
                
                    System.out.println(); 
                    startTime = System.currentTimeMillis();
                    for (int i = 0; i < destinoCInsercion.length; i++) {
                        destinoCInsercion = insercion (destinoCInsercion); 
                    }
                    endTime = System.currentTimeMillis();
                //Impresion del arreglo acomodado
                    System.out.println(ANSI_GREEN + "[Metodo insercion]" + ANSI_RESET);
                    System.out.println(Arrays.toString(destinoCInsercion));  
                    
                //TIME
                    Time = endTime-startTime;
                    System.out.println("Tiempo en milsegundos: " + Time );
                    Time = (Time/1000);
                    System.out.println("Tiempo en segundos: " + Time );
                    
                //Ordenamiento SHELL
                Integer[] destinoCShell = new Integer [10000];
                System.arraycopy(newListC, 0, destinoCShell, 0, destinoCShell.length);
                
                    System.out.println(); 
                    startTime = System.currentTimeMillis();
                    for (int i = 0; i < destinoCShell.length; i++) {
                        destinoCShell = shell (destinoCShell); 
                    }
                    endTime = System.currentTimeMillis();
                //Impresion del arreglo acomodado
                    System.out.println(ANSI_YELLOW + "[Metodo shell]" + ANSI_RESET);
                    System.out.println(Arrays.toString(destinoCShell));  
                    
                //TIEMPO    
                    Time = endTime-startTime;
                    System.out.println("Tiempo en milsegundos: " + Time );
                    Time = (Time/1000);
                    System.out.println("Tiempo en segundos: " + Time );
                    
                //ORDENAMIENTO Union
                Integer[] destinoCUnion = new Integer [10000];
                System.arraycopy(newListC, 0, destinoCUnion, 0, destinoCUnion.length);
                
                    System.out.println(); 
                    var listUnion = new ArrayList<>(Arrays.asList(destinoCUnion));
                    
                    startTime = System.currentTimeMillis();
                    listUnion = sort (listUnion);                    
                    endTime = System.currentTimeMillis();
                //Impresion del arreglo acomodado
                    System.out.println(ANSI_CYAN + "[Metodo union]" + ANSI_RESET);
                    System.out.println(listUnion);  
                    
                    Time = endTime-startTime;
                    System.out.println("Tiempo en milsegundos: " + Time );
                    Time = (Time/1000);
                    System.out.println("Tiempo en segundos: " + Time );
                                       
                //ORDENAMIENTO Quick
                Integer[] destinoCQuick = new Integer [10000];
                System.arraycopy(newListC, 0, destinoCQuick, 0, destinoCQuick.length);
                
                    System.out.println(); 
                    int[] ListQuick = new int[destinoCQuick.length];

                    for(int ctr = 0; ctr < destinoCQuick.length; ctr++) {
                        ListQuick[ctr] = destinoCQuick[ctr]; // returns int value
                    }
                    
                    startTime = System.currentTimeMillis();
                    quicksort(ListQuick, 0, ListQuick.length-1);                   
                    endTime = System.currentTimeMillis();
                //Impresion del arreglo acomodado
                    System.out.println(ANSI_PURPLE + "[Metodo quick]" + ANSI_RESET);
                    System.out.println(Arrays.toString(ListQuick));  
                    
                //TIEMPO    
                    Time = endTime-startTime;
                    System.out.println("Tiempo en milsegundos: " + Time );
                    Time = (Time/1000);
                    System.out.println("Tiempo en segundos: " + Time );                    
                    
                break;   
                }
                
                case 'd': case 'D': {
                System.out.println("\n[Tu Array es : ]");
                System.out.println(Arrays.toString(newListD));        
                    
                Integer[] destinoDBubble = new Integer [10000];
                System.arraycopy(newListD, 0, destinoDBubble, 0, destinoDBubble.length);
                    
                //ORDENAMIENTO BURBUJA
                    System.out.println();         
                    startTime = System.currentTimeMillis();     
                    for (int i = 0; i < destinoDBubble.length-1; i++) {
                    destinoDBubble = bubble(destinoDBubble);
                    }
                    endTime = System.currentTimeMillis();
                //Impresion del arreglo acomodado
                    System.out.println(ANSI_BLUE + "[Metodo burbuja]" + ANSI_RESET);
                    System.out.println(Arrays.toString(destinoDBubble));   
                    
                //Tiempo
                    Time = endTime-startTime;
                    System.out.println("Tiempo en milsegundos: " + Time );
                    Time = (Time/1000);
                    System.out.println("Tiempo en segundos: " + Time );
                    
                //ORDENAMIETO SELECCION
                Integer[] destinoDSeleccion = new Integer [10000];
                System.arraycopy(newListD, 0, destinoDSeleccion, 0, destinoDSeleccion.length);
                
                    System.out.println();
                    startTime = System.currentTimeMillis();
                    for (int i = 0; i < destinoDSeleccion.length; i++) {
                        destinoDSeleccion=seleccion(destinoDSeleccion,i);
                    }
                    endTime = System.currentTimeMillis();
                //Impresion del arreglo acomodado
                    System.out.println(ANSI_RED + "[Metodo seleccion]" + ANSI_RESET);
                    System.out.println(Arrays.toString(destinoDSeleccion));

                //Tiempo
                    Time = endTime-startTime;
                    System.out.println("Tiempo en milsegundos: " + Time );
                    Time = (Time/1000);
                    System.out.println("Tiempo en segundos: " + Time );
                    
                    
                //ORDENAMIENTO Inserción
                Integer[] destinoDInsercion = new Integer [10000];
                System.arraycopy(newListD, 0, destinoDInsercion, 0, destinoDInsercion.length);
                
                    System.out.println(); 
                    startTime = System.currentTimeMillis();
                    for (int i = 0; i < newListD.length; i++) {
                        newListD = insercion (newListD); 
                    }
                    endTime = System.currentTimeMillis();
                //Impresion del arreglo acomodado
                    System.out.println(ANSI_GREEN + "[Metodo insercion]" + ANSI_RESET);
                    System.out.println(Arrays.toString(newListD));  
                    
                //TIME
                    Time = endTime-startTime;
                    System.out.println("Tiempo en milsegundos: " + Time );
                    Time = (Time/1000);
                    System.out.println("Tiempo en segundos: " + Time );
                    
                //Ordenamiento SHELL
                Integer[] destinoDShell = new Integer [10000];
                System.arraycopy(newListD, 0, destinoDShell, 0, destinoDShell.length);
                
                    System.out.println(); 
                    startTime = System.currentTimeMillis();
                    for (int i = 0; i < destinoDShell.length; i++) {
                        destinoDShell = shell (destinoDShell); 
                    }
                    endTime = System.currentTimeMillis();
                //Impresion del arreglo acomodado
                    System.out.println(ANSI_YELLOW + "[Metodo shell]" + ANSI_RESET);
                    System.out.println(Arrays.toString(destinoDShell));  
                    
                //TIEMPO    
                    Time = endTime-startTime;
                    System.out.println("Tiempo en milsegundos: " + Time );
                    Time = (Time/1000);
                    System.out.println("Tiempo en segundos: " + Time );
                    
                //ORDENAMIENTO Union
                Integer[] destinoDUnion = new Integer [10000];
                System.arraycopy(newListD, 0, destinoDUnion, 0, destinoDUnion.length);
                
                    System.out.println(); 
                    var listUnion = new ArrayList<>(Arrays.asList(destinoDUnion));
                    
                    startTime = System.currentTimeMillis();
                    listUnion = sort (listUnion);                    
                    endTime = System.currentTimeMillis();
                //Impresion del arreglo acomodado
                    System.out.println(ANSI_CYAN + "[Metodo union]" + ANSI_RESET);
                    System.out.println(listUnion);  
                    
                    Time = endTime-startTime;
                    System.out.println("Tiempo en milsegundos: " + Time );
                    Time = (Time/1000);
                    System.out.println("Tiempo en segundos: " + Time );
                                       
                //ORDENAMIENTO Quick
                Integer[] destinoDQuick = new Integer [10000];
                System.arraycopy(newListD, 0, destinoDQuick, 0, destinoDQuick.length);
                
                    System.out.println(); 
                    int[] ListQuick = new int[destinoDQuick.length];

                    for(int ctr = 0; ctr < destinoDQuick.length; ctr++) {
                        ListQuick[ctr] = destinoDQuick[ctr]; // returns int value
                    }
                    
                    startTime = System.currentTimeMillis();
                    quicksort(ListQuick, 0, ListQuick.length-1);                   
                    endTime = System.currentTimeMillis();
                //Impresion del arreglo acomodado
                    System.out.println(ANSI_PURPLE + "[Metodo quick]" + ANSI_RESET);
                    System.out.println(Arrays.toString(ListQuick));  
                    
                //TIEMPO    
                    Time = endTime-startTime;
                    System.out.println("Tiempo en milsegundos: " + Time );
                    Time = (Time/1000);
                    System.out.println("Tiempo en segundos: " + Time );                    
                    
                break;   
                }
                
                case 'e': case 'E': {
                System.out.println("\n[Tu Array es : ]");
                System.out.println(Arrays.toString(newListE));        
                    
                Integer[] destinoEBubble = new Integer [10000];
                System.arraycopy(newListE, 0, destinoEBubble, 0, destinoEBubble.length); 
                    
                //ORDENAMIENTO BURBUJA
                    System.out.println();         
                    startTime = System.currentTimeMillis();     
                    for (int i = 0; i < destinoEBubble.length-1; i++) {
                    destinoEBubble = bubble(destinoEBubble);
                    }
                    endTime = System.currentTimeMillis();
                //Impresion del arreglo acomodado
                    System.out.println(ANSI_BLUE + "[Metodo burbuja]" + ANSI_RESET);
                    System.out.println(Arrays.toString(destinoEBubble));   
                    
                //Tiempo
                    Time = endTime-startTime;
                    System.out.println("Tiempo en milsegundos: " + Time );
                    Time = (Time/1000);
                    System.out.println("Tiempo en segundos: " + Time );
                    
                //ORDENAMIETO SELECCION
                Integer[] destinoESeleccion = new Integer [10000];
                System.arraycopy(newListE, 0, destinoESeleccion, 0, destinoESeleccion.length);
                
                    System.out.println();
                    startTime = System.currentTimeMillis();
                    for (int i = 0; i < destinoESeleccion.length; i++) {
                        destinoESeleccion=seleccion(destinoESeleccion,i);
                    }
                    endTime = System.currentTimeMillis();
                //Impresion del arreglo acomodado
                    System.out.println(ANSI_RED + "[Metodo seleccion]" + ANSI_RESET);
                    System.out.println(Arrays.toString(destinoESeleccion));

                //Tiempo
                    Time = endTime-startTime;
                    System.out.println("Tiempo en milsegundos: " + Time );
                    Time = (Time/1000);
                    System.out.println("Tiempo en segundos: " + Time );
                    
                    
                //ORDENAMIENTO Inserción
                Integer[] destinoEInsercion = new Integer [10000];
                System.arraycopy(newListE, 0, destinoEInsercion, 0, destinoEInsercion.length);
                
                    System.out.println(); 
                    startTime = System.currentTimeMillis();
                    for (int i = 0; i < destinoEInsercion.length; i++) {
                        destinoEInsercion = insercion (destinoEInsercion); 
                    }
                    endTime = System.currentTimeMillis();
                //Impresion del arreglo acomodado
                    System.out.println(ANSI_GREEN + "[Metodo insercion]" + ANSI_RESET);
                    System.out.println(Arrays.toString(destinoEInsercion));  
                    
                //TIME
                    Time = endTime-startTime;
                    System.out.println("Tiempo en milsegundos: " + Time );
                    Time = (Time/1000);
                    System.out.println("Tiempo en segundos: " + Time );
                    
                //Ordenamiento SHELL
                Integer[] destinoEShell = new Integer [10000];
                System.arraycopy(newListE, 0, destinoEShell, 0, destinoEShell.length);
                
                    System.out.println(); 
                    startTime = System.currentTimeMillis();
                    for (int i = 0; i < destinoEShell.length; i++) {
                        destinoEShell = shell (destinoEShell); 
                    }
                    endTime = System.currentTimeMillis();
                //Impresion del arreglo acomodado
                    System.out.println(ANSI_YELLOW + "[Metodo shell]" + ANSI_RESET);
                    System.out.println(Arrays.toString(destinoEShell));  
                    
                //TIEMPO    
                    Time = endTime-startTime;
                    System.out.println("Tiempo en milsegundos: " + Time );
                    Time = (Time/1000);
                    System.out.println("Tiempo en segundos: " + Time );
                    
                //ORDENAMIENTO Union
                Integer[] destinoEUnion = new Integer [10000];
                System.arraycopy(newListE, 0, destinoEUnion, 0, destinoEUnion.length);
                
                    System.out.println(); 
                    var listUnion = new ArrayList<>(Arrays.asList(destinoEUnion));
                    
                    startTime = System.currentTimeMillis();
                    listUnion = sort (listUnion);                    
                    endTime = System.currentTimeMillis();
                //Impresion del arreglo acomodado
                    System.out.println(ANSI_CYAN + "[Metodo union]" + ANSI_RESET);
                    System.out.println(listUnion);  
                    
                    Time = endTime-startTime;
                    System.out.println("Tiempo en milsegundos: " + Time );
                    Time = (Time/1000);
                    System.out.println("Tiempo en segundos: " + Time );
                                       
                //ORDENAMIENTO Quick
                Integer[] destinoEQuick = new Integer [10000];
                System.arraycopy(newListE, 0, destinoEQuick, 0, destinoEQuick.length);
                
                    System.out.println(); 
                    int[] ListQuick = new int[destinoEQuick.length];

                    for(int ctr = 0; ctr < destinoEQuick.length; ctr++) {
                        ListQuick[ctr] = destinoEQuick[ctr]; // returns int value
                    }
                    
                    startTime = System.currentTimeMillis();
                    quicksort(ListQuick, 0, ListQuick.length-1);                   
                    endTime = System.currentTimeMillis();
                //Impresion del arreglo acomodado
                    System.out.println(ANSI_PURPLE + "[Metodo quick]" + ANSI_RESET);
                    System.out.println(Arrays.toString(ListQuick));  
                    
                //TIEMPO    
                    Time = endTime-startTime;
                    System.out.println("Tiempo en milsegundos: " + Time );
                    Time = (Time/1000);
                    System.out.println("Tiempo en segundos: " + Time );                    
                    
                break;   
                }
                
                case 'f': case 'F': {
                    
                System.out.println("\n[Tu Array es : ]");
                System.out.println(Arrays.toString(newListF));        
                    
                Integer[] destinoFBubble = new Integer [10000];
                System.arraycopy(newListF, 0, destinoFBubble, 0, destinoFBubble.length);

                    
                //ORDENAMIENTO BURBUJA
                    System.out.println();         
                    startTime = System.currentTimeMillis();     
                    for (int i = 0; i < destinoFBubble.length-1; i++) {
                    destinoFBubble = bubble(destinoFBubble);
                    }
                    endTime = System.currentTimeMillis();
                //Impresion del arreglo acomodado
                    System.out.println(ANSI_BLUE + "[Metodo burbuja]" + ANSI_RESET);
                    System.out.println(Arrays.toString(destinoFBubble));   
                    
                //Tiempo
                    Time = endTime-startTime;
                    System.out.println("Tiempo en milsegundos: " + Time );
                    Time = (Time/1000);
                    System.out.println("Tiempo en segundos: " + Time );
                    
                //ORDENAMIETO SELECCION
                Integer[] destinoFSeleccion = new Integer [10000];
                System.arraycopy(newListF, 0, destinoFSeleccion, 0, destinoFSeleccion.length);
                
                    System.out.println();
                    startTime = System.currentTimeMillis();
                    for (int i = 0; i < destinoFSeleccion.length; i++) {
                        newListF=seleccion(destinoFSeleccion,i);
                    }
                    endTime = System.currentTimeMillis();
                //Impresion del arreglo acomodado
                    System.out.println(ANSI_RED + "[Metodo seleccion]" + ANSI_RESET);
                    System.out.println(Arrays.toString(destinoFSeleccion));

                //Tiempo
                    Time = endTime-startTime;
                    System.out.println("Tiempo en milsegundos: " + Time );
                    Time = (Time/1000);
                    System.out.println("Tiempo en segundos: " + Time );
                    
                    
                //ORDENAMIENTO Inserción
                Integer[] destinoFInsercion = new Integer [10000];
                System.arraycopy(newListF, 0, destinoFInsercion, 0, destinoFInsercion.length);
                
                    System.out.println(); 
                    startTime = System.currentTimeMillis();
                    for (int i = 0; i < destinoFInsercion.length; i++) {
                        destinoFInsercion = insercion (destinoFInsercion); 
                    }
                    endTime = System.currentTimeMillis();
                //Impresion del arreglo acomodado
                    System.out.println(ANSI_GREEN + "[Metodo insercion]" + ANSI_RESET);
                    System.out.println(Arrays.toString(destinoFInsercion));  
                    
                //TIME
                    Time = endTime-startTime;
                    System.out.println("Tiempo en milsegundos: " + Time );
                    Time = (Time/1000);
                    System.out.println("Tiempo en segundos: " + Time );
                    
                //Ordenamiento SHELL
                Integer[] destinoFShell = new Integer [10000];
                System.arraycopy(newListF, 0, destinoFShell, 0, destinoFShell.length);
                
                    System.out.println(); 
                    startTime = System.currentTimeMillis();
                    for (int i = 0; i < destinoFShell.length; i++) {
                        destinoFShell = shell (destinoFShell); 
                    }
                    endTime = System.currentTimeMillis();
                //Impresion del arreglo acomodado
                    System.out.println(ANSI_YELLOW + "[Metodo shell]" + ANSI_RESET);
                    System.out.println(Arrays.toString(destinoFShell));  
                    
                //TIEMPO    
                    Time = endTime-startTime;
                    System.out.println("Tiempo en milsegundos: " + Time );
                    Time = (Time/1000);
                    System.out.println("Tiempo en segundos: " + Time );
                    
                //ORDENAMIENTO Union
                Integer[] destinoFUnion = new Integer [10000];
                System.arraycopy(newListF, 0, destinoFUnion, 0, destinoFUnion.length);
                
                    System.out.println(); 
                    var listUnion = new ArrayList<>(Arrays.asList(destinoFUnion));
                    
                    startTime = System.currentTimeMillis();
                    listUnion = sort (listUnion);                    
                    endTime = System.currentTimeMillis();
                //Impresion del arreglo acomodado
                    System.out.println(ANSI_CYAN + "[Metodo union]" + ANSI_RESET);
                    System.out.println(listUnion);  
                    
                    Time = endTime-startTime;
                    System.out.println("Tiempo en milsegundos: " + Time );
                    Time = (Time/1000);
                    System.out.println("Tiempo en segundos: " + Time );
                                       
                //ORDENAMIENTO Quick
                Integer[] destinoFQuick = new Integer [10000];
                System.arraycopy(newListF, 0, destinoFQuick, 0, destinoFQuick.length);
                
                    System.out.println(); 
                    int[] ListQuick = new int[destinoFQuick.length];

                    for(int ctr = 0; ctr < destinoFQuick.length; ctr++) {
                        ListQuick[ctr] = destinoFQuick[ctr]; // returns int value
                    }
                    
                    startTime = System.currentTimeMillis();
                    quicksort(ListQuick, 0, ListQuick.length-1);                   
                    endTime = System.currentTimeMillis();
                //Impresion del arreglo acomodad
                    System.out.println(ANSI_PURPLE + "[Metodo quick]" + ANSI_RESET);
                    System.out.println(Arrays.toString(ListQuick));  
                    
                //TIEMPO    
                    Time = endTime-startTime;
                    System.out.println("Tiempo en milsegundos: " + Time );
                    Time = (Time/1000);
                    System.out.println("Tiempo en segundos: " + Time );                    
                    
                break; 
                }
                case 'z': case 'Z': {
                    System.exit(0);                 
                    break;
                }
                
                
            }
                    
            System.out.print("\nProbar otra lista? (s. Si - n. No): ");
            eleccion = sc.next().charAt(0);
            System.out.println();
        } while (eleccion == 's' || eleccion == 'S');

    
    }//Métodos//  

    //Método Burbuja
    public static Integer[] bubble (Integer[] myArray){
        
        for (int i = 0; i < myArray.length-1; i++) {
            if(myArray[i] > myArray[i+1]){
                int temp = myArray[i];
                myArray[i] = myArray[i+1];
                myArray[i+1]=temp;
            }            
        } 
        return myArray;
    }
    
    //Método Selecc
    public static Integer[] seleccion (Integer[] myArray, int punch){
        int myPivot = myArray[punch]; //Obtener el primer valor del array
        
        for (int i = punch + 1; i < myArray.length; i++) { //Comparar de la posicion 1 hasta el final del arreglo
            if(myPivot > myArray[i]){ //Si mi primer valor es mayor al siguiente
                myArray[punch] = myArray[i]; // Guardar el valor de array i en array mypunch 
                myArray[i] = myPivot; // El numero encontrado es igual a mi pivote
                myPivot = myArray[punch]; // Mi pivote ahora es igual al valor guardado
            }            
        } 
        return myArray;
    }
    
    //Méetodo de Inserción
        public static Integer[] insercion (Integer[] myArray){                                         
        int i, j, aux;
            for (i = 1; i < myArray.length; i++){ // desde el segundo elemento hasta
            aux = myArray[i]; // el final, guardamos el elemento y
            j = i - 1; // empezamos a comprobar con el anterior
                while ((j >= 0) && (aux < myArray[j])){ // mientras queden posiciones y el 
                                                        // valor de aux sea menor que los
                    myArray[j + 1] = myArray[j];        // de la izquierda, se desplaza a
                    j--;                                // la derecha
                }
            myArray[j + 1] = aux;                       // colocamos aux en su sitio
        }
        
        return myArray;
    }
        
    //Método por Shell
    public static Integer[] shell (Integer[] myArray){
    int j, aux, i;
    boolean change;  
    for (j = myArray.length / 2; j != 0; j /= 2) {
        change = true;
        while (change) {     // Mientras se intercambie algún elemento                                     
            change = false;
            for (i = j; i < myArray.length; i++) // se da una pasada
            {
                if (myArray[i - j] > myArray[i]) { // y si están desordenados
                    aux = myArray[i];              // se reordenan
                    myArray[i] = myArray[i - j];
                    myArray[i - j] = aux;
                    change = true;             // y se marca como cambio.                                 
                }
            }
        }           
    }
    return myArray;
    }
    
    //Método quick//
        public static void quicksort(int A[], int izq, int der) {

  int pivote=A[izq]; // tomamos primer elemento como pivote
  int i=izq;         // i realiza la búsqueda de izquierda a derecha
  int j=der;         // j realiza la búsqueda de derecha a izquierda
  int aux;
 
  while(i < j){                          // mientras no se crucen las búsquedas                                   
     while(A[i] <= pivote && i < j) i++; // busca elemento mayor que pivote
     while(A[j] > pivote) j--;           // busca elemento menor que pivote
     if (i < j) {                        // si no se han cruzado                      
         aux= A[i];                      // los intercambia
         A[i]=A[j];
         A[j]=aux;
     }
   }
   
   A[izq]=A[j];      // se coloca el pivote en su lugar de forma que tendremos                                    
   A[j]=pivote;      // los menores a su izquierda y los mayores a su derecha
   
   if(izq < j-1)
      quicksort(A,izq,j-1);          // ordenamos subarray izquierdo
   if(j+1 < der)
      quicksort(A,j+1,der);          // ordenamos subarray derecho
   
}

        //sort union//
    public static ArrayList<Integer> sort (ArrayList <Integer> data) {
    ArrayList<Integer> result =data;
        if (result.size()==1){ 
        result =data;
        } else {
    
    ArrayList<Integer> parcial1= new ArrayList<>(),
    parcial2= new ArrayList<>();
    int j=0;
        for (int i=0;i<(int)(result.size()/2);i++){
            parcial1.add(result.get(i));
            j++;  
        }
    
        for(int i=j;i<(result.size());i++){
            parcial2.add(result.get(i));
        }
        result  = union(sort(parcial1), sort(parcial2));
    }
        return result;
    }
    
    //sort union2//
    public static ArrayList<Integer> union (ArrayList<Integer> p1,ArrayList<Integer> p2) {
        ArrayList<Integer> result = new ArrayList<>();
        int index1=0,index2=0;
        int maxIndex1=p1!=null?p1.size():0,maxIndex2=p2!=null?p2.size():0;
        
        while(index1<maxIndex1 || index2<maxIndex2 ){        
            if (index1==maxIndex1){
                result.add(p2.get(index2++));
            } else if (index2==maxIndex2){
                result.add(p1.get(index1++));
            } else {
               result.add( (p1.get(index1)<p2.get(index2))?
                p1.get(index1++):p2.get(index2++)); 
            }
        }
        return result;
    }
        
}
