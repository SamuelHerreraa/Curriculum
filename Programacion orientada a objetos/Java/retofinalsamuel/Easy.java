
package retofinalsamuel;


public class Easy {
    
    //Atributos o variables
    int MagoHada=30;
    int UserHada=0;
    int Materiales=0;
    int Casa=0;
    int MagoPoder=3;
    int VidaUser=2;
    
    ///>Metodos<///    
    //Mostrartabla//
    public void Show(){
        System.out.println("#########################################################");
        System.out.println("# Tienes " + VidaUser + " puntos de vida.\t\t\t\t#");    
        System.out.println("# Tienes " + Materiales + " de madera." + "\t\tPoder del mago: "+MagoPoder + "\t#");
        System.out.println("# Tienes " + Casa + " casas construidas." + "\tHadas capturadas: "+MagoHada + "\t#");
        System.out.println("# Tienes " + UserHada + " hadas rescatadas."+ "\t\t\t\t#");
        System.out.println("#\t\t\t\t\t\t\t#");
    }
    //Construccion de Casa//
    public void ConstruirCasa(){
        System.out.println("");
        System.out.println(">Has contruido 1 casa.");
        System.out.println(">Has rescatado 10 hadas.");
        System.out.println(">Has conseguido 1 punto de vida.");
        System.out.println(">El mago ha perdido 1 punto de poder.");
        Materiales=Materiales-10;
        UserHada=UserHada+10;
        MagoPoder=MagoPoder-1;
        MagoHada=MagoHada-10;
        VidaUser=VidaUser+1;
        System.out.println("");
        Casa++;        
    }
    
    //Metodo cuando el mago captura 10 hadas//
    public void MagoCaptura(){
        System.out.println(">El Mago ha capturado 10 hadas.");
        System.out.println(">Como no tienes hadas el mago ha capturado 10 hadas de la villa.");
        System.out.println(">Has perdido 1 punto de vida.");
        System.out.println(""); 
}
    //Metodo donde mago destruye 1 casa y captura 10 hadas//
    public void MagoDestruyeCasa(){
        UserHada=UserHada-10;
        Casa=Casa-1;
        System.out.println(">Ataque del mago con exito.");
        System.out.println(">El mago te ha destruido 1 casa.");
        System.out.println(">El Mago ha capturado 10 hadas.");
        System.out.println(">Has perdido 1 punto de vida.");
        System.out.println("");
    }
    //Metodo golpe directo del ogro al usuario//
    public void OgroGolpeDirecto(){
        System.out.println(">Ataque del ogro con exito.");
        System.out.println(">Como no tienes casas el ogro te ha golpeado directamente.");
        System.out.println(">Has perdido 1 punto de vida.");
        System.out.println("");
        VidaUser=VidaUser-1;
    }
    //Metodo Ogro destruye una casa//
    public void OgroDestryeCasa(){
        System.out.println(">Ataque del ogro con exito.");
        System.out.println(">El ogro ha destruido una casa.");
        System.out.println(">10 hadas asustadas volaron lejos.");
        Casa=Casa-1;
        VidaUser=VidaUser-1;
        UserHada=UserHada-10;   
    }    
}