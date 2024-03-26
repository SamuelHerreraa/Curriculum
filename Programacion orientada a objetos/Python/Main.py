from Settings import Set
from Jugador import User
from Mago import Mage
import sys
import time
import random

#Guardar opcion del usuario
opcion=0
#Iniciar con turno 1, osea el del jugador
turno=1

#Instrucciones del juego
print("Existe una villa virtual que ha sido hechizada por un mago poderoso. Este mago obtiene su poder del polvo de hadas que mantiene en cautiverio y aumenta en una unidad por cada 10 hadas que capture.")
print("")
print("Tu labor principal es construir casas para rescatar un hada y llevarla a vivir ahí. Por cada 10 hadas que rescates, se resta una unidad de poder al mago.")
print("")
print("Tienes una vida que aumenta cada vez que rescatas 10 hadas y disminuye cuando te golpea el ogro que protege al mago.")
print("")
print("El juego termina cuando el mago o tú hayan perdido por completo su poder.")
print("Mucha suerte GUERRERO, que empiece el JUEGO!")
print("")
print("")


#Este while sirve para repetir el ciclo hasta que el jugador tenga 0 de vida o el mago 0 de poder
while (Set.MagoPoder>=1) and (Set.VidaUser>=1):
    
    #Comprobar si turno es 1, si lo es entonces empieza el turno del jugador
    if(turno==1): 
        
        #Va a repetir el ciclo mientras sea el turno del jugador
        while(turno==1):
            
            #Llamar a la funcion que muestra los datos
            Set.Show()
            
            #Imnprimir el menu para saber que opciones jugar
            print("# 1. Recolectar materiales " + "\t\t\t\t\t\t\t\t#")
            print("# 2. Construir una casa " + "\t\t\t\t\t\t\t\t#")
            print("# 3. Rescatar hada" + "\t\t\t\t\t\t\t\t\t\t#")
            print("#\t\t\t\t\t\t\t\t\t\t\t\t\t\t#")
            print("# 4. Salir del juego " + "\t\t\t\t\t\t\t\t\t#")  
            print("#########################################################")
            print()
            time.sleep(0.5) 
            
            #Va a repetir el ciclo mientras sea el turno del jugador
            while True and turno==1:
                
                #Para comprobrar si hay algun error en la digitacion
                try:
                    opcion = int(input("Que vas hacer?: "))
                    
                    #Si el usuario elige la opcion 1 entonces:
                    if opcion == 1:
                        User.ConseguirMaterial()
                        turno=0
                        
                        
                            
                    #Si el usuario elige la opcion 1 entonces:    
                    elif opcion == 2:
                        User.ConstruirCasa()
                        turno=0
                            
 
                    elif opcion == 3:
                        User.RescatarHada()
                        turno=0
                    
                    elif opcion == 4:
                        print()
                        print(">El mago te ha derrotado.")
                        print(">JUEGO TERMINADO.")
                        print()
                        sys.exit()    
                        
                    elif opcion <=0:
                        print("Solo números entre 1 al 4")
                        
                    elif opcion >=5:
                        print("Solo números entre 1 al 4")   
                        
                except ValueError:
                    print("Solo números del 1 al 4")
                    
    else: #SI TURNO NO ES UNO 
        
        turno=1 #Ahora indicamos que turno es 1 para que cuando termine el mago le toque al jugador
        print("-----------------------------------------------")
        print(">Turno del Mago")
        print(">El mago esta pensando que hacer...")
        print("-----------------------------------------------")               
        
        #Numero aleatorio para saber que movimiento hara el mago#
        numero=(random.randint(1, 9))

        #Si el numero aleatorio es 1 o 2 entonces:
        if (numero == 1 or numero == 2):
            
            Mage.MagoCapturarHada()
        
        #Si el numero aleatorio es 3 entonces:
        elif (numero == 3):     
            Mage.OgroAttack1()
                   
        else: #Si el numero es diferente a 1,2,3,4 entonces hace:
            print()
            print(">El mago continua preparando su hechizo energias.")
            print()
    time.sleep(0.5)       
            
    
#If que indica quien quien de los dos gano    
if Set.MagoPoder<=0:
    Set.Show()
    print()
    print("#########################################################")
    print()
    print("FELICIDADES HAS DERROTADO AL MAGO ")
    print("GANASTE")
else:
    Set.Show()
    print()
    print("#########################################################")
    print()
    print("TE HAN DERROTADO")
    print()