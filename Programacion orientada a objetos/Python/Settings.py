class Set:
    #Variables
    VidaUser=5
    Materiales=0
    UserHada=0
    Casa=0
    MagoPoder=1
    MagoHada=10 
    Disponible=0
    
    #Constructores#
    def __init__(self, VidaUser, Materiales, UserHada, Casa, Disponible, MagoPoder, MagoHada):
        self.VidaUser=VidaUser
        self.Materiales=Materiales
        self.UserHada=UserHada
        self.Casa=Casa
        self.Disponible=Disponible
        self.MagoPoder=MagoPoder
        self.MagoHada=MagoHada
        
    #Funcion para mostrar los datos    
    def Show():
        print("#########################################################")
        print("#\t\t\t\t\t\t\t\t\t\t\t\t\t\t#")
        print("# Tienes " + str(Set.VidaUser) + " puntos de vida.\t\t\t\t\t\t\t\t#")
        print("# Tienes " + str(Set.Materiales) + " materiales." + "\t\t\tPoder del mago: "+ str(Set.MagoPoder) + "\t\t#")
        print("# Tienes " + str(Set.Casa) + " casas construidas." + "\tHadas capturadas: "+ str(Set.MagoHada) + "    #")
        print("# Tienes " + str(Set.UserHada) + " hadas rescatadas.\t\t\t\t\t\t\t#")
        print("#\t\t\t\t\t\t\t\t\t\t\t\t\t\t#")