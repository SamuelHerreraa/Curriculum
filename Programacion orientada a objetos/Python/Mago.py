from Settings import Set
class Mage:
    
    #Funcion del mago para capturar hada
    def MagoCapturarHada():
        print()
        print(">El mago ha capturado una hada")
        print()
        Set.MagoHada+=1
        #Por cada 10 hadas que capture gana 1 punto de poder
        if Set.MagoHada % 10 == 0:
            Set.MagoPoder+=1
            
    #Funcion que te quita 1 de vida         
    def OgroAttack1():
        print()
        print(">El ogro te golpeo")
        print(">Pierdes 1 punto de vida")
        print()
        Set.VidaUser-=1