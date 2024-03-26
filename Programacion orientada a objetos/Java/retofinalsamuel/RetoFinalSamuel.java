
package retofinalsamuel;
import java.io.*;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

/**
 * @author Samuel Herrera 2679928
 */
public class RetoFinalSamuel {
    
    public static void main(String[] args) throws IOException, InterruptedException {
    // TODO code application logic here    
    
        //Añadir nuestra clase y constructores//
        Easy battle = new Easy();

//Lectura del teclado        
Scanner sn = new Scanner(System.in);
int opcion; //Guardaremos la opcion del usuario
//Iniciar con el turno 1
int turno=1;    



    //Ciclio do para iniciar el juego//
    do{    
        //Si turno es igual a 1, es turno del jugador//
        if(turno==1){
            //Mientras sea el turno 1 podra ver el menu de opciones//
            while (turno==1) {  
            //Llamar a la variable de datos//    
            battle.Show(); 
            System.out.println("# 1. Recolectar matariales " + "\t\t\t\t#");
            System.out.println("# 2. Construir una casa" + "\t\t\t\t\t#");
            System.out.println("# 3. Salir del juego" + "\t\t\t\t\t#");
            System.out.println("#########################################################");
            System.out.println("");
        
            //Para evitar errores de teclado//
        try {
            System.out.print("Que vas hacer?: ");
            //Guardar el numero que eligio el usuario en la variable opcion
            opcion = sn.nextInt();
             
                //Inicia el switch e ifs segun la opcion del usuario//
                switch (opcion) {
                    
                    case 1 -> 
                    {
                        //Recolectar un numero aleatorio de madera//
                        int wood=(int)(Math.random()*10);
                        //Si obtienes 0 en el numero aleatorio sale este mensaje//
                        if (wood==0){
                            System.out.println("");
                            System.out.println("---------------------------------------------");
                            System.out.println("|Lamentablemente has conseguido " + wood + " de madera |");
                            System.out.println("---------------------------------------------");
                            System.out.println("");
                        }
                        //Si obtienes mas de 1 madera se suma//
                        else{
                            System.out.println("");
                            System.out.println("--------------------------------------");
                            System.out.println("|Felicidades conseguiste " + wood + " de madera |");
                            System.out.println("--------------------------------------");
                            battle.Materiales+=wood;
                            System.out.println("");
                        }
                        //Cambiar al turno del mago//
                        turno=0;
                    }                      
                        
                    case 2 -> 
                    {
                        //Si tienes mas de 10 de materiales//
                        if (battle.Materiales>=10){
                            //Llamar funcion para construir casa//
                            battle.ConstruirCasa();
                            //Turno del mago//
                            turno=0;
                        }
                        //Si no tienes suficientes materiales te dice esto, pero sigue siendo tu turno//
                        else{
                            System.out.println("");
                            System.out.println(">Necesitas 10 de madera para construir una casa");
                            System.out.println(">No tienes materiales suficientes.");
                            System.out.println("");
                        }
                    }
                    
                    case 3 -> 
                        //Para salir del juego//
                    {
                        System.out.println("");
                        System.out.println(">El mago te ha derrotado.");
                        System.out.println(">JUEGO TERMINADO.");
                        System.out.println("");
                        System.exit(0);
                    }
                    
                    default -> 
                    {
                            System.out.println("");
                            System.out.println(">Solo números entre 1 y 2");
                            System.out.println("");
                    }
                }
                
                //Parte del try y catch + excepcion//
            } catch (InputMismatchException e) {
                System.out.println("");
                System.out.println(">Solo números entre 1 y 2");
                sn.next();
                System.out.println("");
            }
        }                  
    }
        
        //Si turno ya no es 1 entonces le va al mago
        else{
            System.out.println(">Turno del Mago<");
            System.out.println(">El mago esta pensando que hacer...");
            TimeUnit.SECONDS.sleep(1);
            
            
            //Numero aleatorio para saber que movida hara el mago//
            int hechizo=(int)(Math.random()*10);

            //Mago Captura 10 Hadas//
                //Si el numero aleatorio es 1 y 2//
            if (hechizo==1 || hechizo ==2){
                System.out.println();
                //Jugador pirede 1 de vida//
                battle.VidaUser=battle.VidaUser-1;
                    //Si el jugador 0 hadas entonces://
                    if (battle.UserHada==0){
                        //Mago captura de la villa//
                        battle.MagoCaptura();
                    }
                    else{
                        //Si usuario tiene hadas entonces destruye una casa y te las quita//
                        battle.MagoDestruyeCasa();
                    }
                
                //El mago gana 1 de poder//    
                battle.MagoPoder=battle.MagoPoder+1;
                //EL Mago suma 10 hadas//
                battle.MagoHada=battle.MagoHada+10; 
                //Cambiar de turno
                turno=1;
            }
                //Si el numero aleatorio es 3 y 4 entonces:
            else if(hechizo==3 || hechizo ==4){
                System.out.println();
                System.out.println(">El Mago ha enviado a su Ogro a golpearte");
                System.out.println();
                //Si tienes 0 casas el otro te olpea directo//
                if (battle.Casa==0){
                    battle.OgroGolpeDirecto();
                    }
                else{
                    //Generar numero aleatorio
                    int tumbar=(int)(Math.random()*3);
                    
                    //Si el numero es 0 o 1 entonces el ogro falla el golpe
                    if(tumbar==0 || tumbar==1){
                        System.out.println(">El ogro ha fallado su golpe.");
                    }
                    //Si cae otro diferente te destruye una casa//
                    else{
                    battle.OgroDestryeCasa();
                    }
                    
                }
                System.out.println("");
                //Cambiar turno//
                turno=1;
            }
            //Si es otro numero entonces el mago no hace nada//
            else{
                System.out.println();
                System.out.println(">El mago continua recuperando energias");
                System.out.println();
                //Cambiar turno//
                turno=1;
            }     
        }
        
     //Salir del ciclo do, cuando mago poder o vida del usuario sea 0   
    }while(battle.MagoPoder>=1 && battle.VidaUser>=1);
    
    
    //Si el poder del mago es 0 - ganas//
    if (battle.MagoPoder<=0){

        battle.Show();
        System.out.println("#########################################################");
        System.out.println("");
        System.out.println("FELICIDADES HAS GANADO");
    }
    
    //Si el jugador tiene 0 de vida pierdes//
    else{
        battle.Show();
        System.out.println("#########################################################");
        System.out.println("");
        System.out.println("TE HAN DERROTADO");
    }
  }
}