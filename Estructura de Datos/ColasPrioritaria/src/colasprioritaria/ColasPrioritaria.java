/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package colasprioritaria;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author Fairoox
 */
public class ColasPrioritaria {

    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_BLUE = "\u001B[34m";

    public static final String ANSI_RESET = "\u001B[0m";

    /**
     * @param args the command line arguments
     * @throws java.lang.InterruptedException
     */
    public static void main(String[] args) throws InterruptedException {
        // TODO code application logic here
        // TODO code application logic here
        PriorityQueue pq = new PriorityQueue();
        // TODO code application logic here
        Scanner sn = new Scanner(System.in);
        int tope=-1;
        int size=0;
        int minimo = -1;
        int maximo = -1;
        int minimoS = -1;
        int maximoS = -1;
        boolean salir = false;
        int opcion;        

        while (!salir) {
            System.out.println("1. Establecer el tope de la cola");
            System.out.println("2. Establecer tiempo minimo y maximo llegada de elementos");
            System.out.println("3. Establecer el rango de tiempo de servicio del servidor");
            System.out.println("4. Iniciar Simulación");
            System.out.println("5. Salir");
 
            try {
 
                System.out.print("Escribe una de las opciones: ");
                opcion = sn.nextInt();
 
                switch (opcion) {
                    case 1:
                        System.out.println("(Tope maximo 100)");{
                            do {
                            tope = checkNumber();         
                            if(tope>100){
                                System.out.println("min 1 max 100");
                            }
                        } while (tope <= 0 || tope>100);
                        System.out.println("Tope MAXIMO asignado: "+tope);
                        System.out.println();
                        }

                        break;
                    case 2: //Rango minimo y maximo de tiempo de llegada de elementos//
                        do {
                            System.out.print("Minimo ");
                            minimo = checkNumber();
                        } while (minimo <= 0);
                        
                        do {
                            System.out.print("Maximo ");
                            maximo = checkNumber();
                            if(maximo<minimo){
                                System.out.println("Ingrese un numero mayor al minimo");
                            }
                        } while (maximo < minimo);
                        
                        System.out.println("Rango minimo de tiempo: "+minimo);
                        System.out.println("Rango MAXIMO de tiempo: "+maximo);
                        System.out.println();
                        break;
                    case 3:
                        do {
                            minimoS = checkNumber();
                        } while (minimoS <= 0);
                        
                        do {
                            maximoS = checkNumber();
                            if(maximoS<minimoS){
                                System.out.println("Ingrese un numero mayor al minimo");
                            }
                        } while (maximoS < minimoS);
                        
                        System.out.println("Rango minimo del servidor: "+minimoS);
                        System.out.println("Rango MAXIMO del servidor: "+maximoS);
                        System.out.println();
                        break;
                    case 4:
                        if (tope ==-1 || minimo ==-1 || maximo ==-1 || minimoS ==-1 || maximoS==-1){
                            System.out.println("\nTus valores actuales son: ");
                            System.out.println("Tope maximo: "+tope);
                            System.out.println("Rango minimo de llegada: "+minimo);
                            System.out.println("Rango maximo de llegada: "+maximo);
                            System.out.println("Rango minimo de servicio: "+minimoS);
                            System.out.println("Rango maximo de servicio: "+maximoS);
                            System.out.println("ASEGURA QUE SEAN VALORES MAYORES o IGUAL AL REQUIRIMIENTO MINIMO\n");
                        } else{                             
                            long t= System.currentTimeMillis();
                            long end = t+1800000;
                            while(System.currentTimeMillis() < end) {
                            
                            System.out.println();
                            System.out.println("Actulizacion: ");
                            System.out.println(pq); 
                            
                            int choose = (int)Math.floor(Math.random()*2+1);    
                            if(choose>=2){    
                                int date = (int) Math.floor(Math.random()*5+1);
                                if(size<=tope){
                                    System.out.println("\nPrioridad a agregar: " + date);
                                    int n = (int)(Math.random()*maximo+minimo);
                                    TimeUnit.SECONDS.sleep(n);
                                    pq.push(date, date);
                                    System.out.println(ANSI_GREEN + "Agregado correctamente" + ANSI_RESET);
                                    size++;
                                }
                                else{                                
                                    System.out.println();
                                    System.out.println("Prioridad a agregar: " + date);
                                    System.out.println(ANSI_RED + "Se RECHAZA porque esta lleno!" + ANSI_RESET);
                                    }
                            }else{    
                                if(size>=1){
                                int n2 = (int)(Math.random()*maximoS+minimoS);
                                    TimeUnit.SECONDS.sleep(n2);                               
                                    pq.pop();
                                    size--;
                                    System.out.println(ANSI_BLUE + "\nEl paciente con mayor prioridad ha sido atendido" + ANSI_RESET);
                                }
                                else{
                                    System.out.println("Lista vacia.");
                                }
                                }
                            }         
                        }       
                        break;             
                        
                    case 5:
                        salir = true;
                        break;
                        
                    default:
                        System.out.println("Solo números entre 1 y 5");
                }
            } catch (InputMismatchException e) {
                System.out.println("Debes insertar un número");
                sn.next();
            }
        }
 
    }
    
    public static int checkNumber() {
        Scanner entrada = new Scanner(System.in);
        int numero = 0;
            try {
                do{
                System.out.print("\nIngrese valor: ");
                numero = entrada.nextInt();
                if(numero<=0){
                    System.out.println("\nIngrese un numero mayor a 0");
                }
                }while(numero<=0);
                return numero;
                
            } catch (Exception e) {
                    System.out.print("\nIngrese un numero válido");
                    System.out.println();
                }
            return numero;
        } 
}
