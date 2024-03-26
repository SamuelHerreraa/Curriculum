from Settings import Set
import random
import time
class User:
    
    #Funcion para construir casa
    def ConstruirCasa():
        if Set.Materiales>=5:
            print()
            print(">Has construido 1 casa.") 
            print()
            Set.Materiales=Set.Materiales-5   
            Set.Casa+=1
            Set.Disponible+=1
        else:
            print()
            print(">Necesitas 5 de materiales para construir una casa.")
            print()
            
    #Funcion para conseguir material        
    def ConseguirMaterial():
    #Obtener un numero aleatorio de estos numeros:
        numero=(random.randint(5, 25))
        print()
        print("Talando arbol...")
        time.sleep(0.5)
        #Imprimir en pantalla que se han conseguido materiales
        print("-----------------------------------------------")
        print("|Felicidades conseguiste " + (str(numero)) + " materiales.    \t  |")
        print("-----------------------------------------------")
            
        #Sumar los materiales que se obtuvieron    
        Set.Materiales+=numero
        print("")
        time.sleep(0.5) 
            
    #Funcion para rescatar un hada    
    def RescatarHada():
        #Comprobacion si hay casa y espacios disponibles
        if Set.Casa>=1 and Set.Disponible>=1:
            numero=(random.randint(0, 4))
            if numero >=1:
                print()
                print(">Has resctado un hada.")
                print()
                Set.UserHada+=1
                Set.Disponible-=1
                #Cada 10 hadas que rescata el jugador gana 1 punto de vida y el mago pierde 1 punto de poder
                if Set.UserHada % 10 == 0:
                    print()
                    print(">Has conseguido 1 punto de vida")
                    print(">El mago ha perdido 1 punto de poder")
                    Set.MagoPoder-=1
                    Set.VidaUser+=1
            else:
                print()
                print(">No encontraste ningun hada.")
                print()
        else:
            print("No tienes casas o espacios disponibles")
                
                
                
                
                
                
                
                
            
        
