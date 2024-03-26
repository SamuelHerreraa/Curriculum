/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package colasprioritaria;

/**
 *
 * @author Fairoox
 * @param <AnyData>
 */
public class PriorityQueue <AnyData> {
    
    PriorityNode<AnyData>[] myArreglo = new PriorityNode[100];
    int size=0;
    
public void push(int priority, AnyData data){
    PriorityNode<AnyData> newNodeToInsert = new PriorityNode<>(data, priority);
    size++;
    if (size == 1)
        myArreglo[size] = newNodeToInsert;
    else {
        int myPosition = size;
        myArreglo[myPosition] = newNodeToInsert;
        int myDadPosition = myPosition / 2;
        
        while (myPosition > 1 && myArreglo[myDadPosition].priority > priority) {
            myArreglo[myPosition] = myArreglo[myDadPosition];
            myPosition = myDadPosition;
            myDadPosition = myPosition / 2;
        }
        myArreglo[myPosition] = newNodeToInsert; // Se agrega el nuevo nodo en su posición correcta
    }
}
    
    public AnyData pop(){
        AnyData result=null;
        
        result= myArreglo[1].Dato;
        
        myArreglo[1]=myArreglo[size];
        myArreglo[size]=null;
        size--;
        int myDadPosition=1;
        int lukePosition=2*myDadPosition;
        int leaPosition=2*myDadPosition+1;
        
        PriorityNode luke = myArreglo[lukePosition];
        PriorityNode lea = myArreglo[leaPosition];
        
        if(size>=3){
        while(myArreglo[lukePosition].priority < myArreglo[myDadPosition].priority || myArreglo[leaPosition].priority < myArreglo[myDadPosition].priority){
            PriorityNode temporal = new PriorityNode ();
            temporal=myArreglo[myDadPosition];
            
            if(myArreglo[lukePosition].priority < myArreglo[myDadPosition].priority){  
            myArreglo[myDadPosition]=myArreglo[lukePosition];
            myArreglo[lukePosition]=temporal;
            myDadPosition=lukePosition;
            lukePosition=2*myDadPosition;
            leaPosition=2*myDadPosition+1;   
            }
            else if(myArreglo[leaPosition].priority < myArreglo[myDadPosition].priority){ 
            myArreglo[myDadPosition]=myArreglo[leaPosition];
            myArreglo[leaPosition]=temporal;    
            myDadPosition=leaPosition;
            lukePosition=2*myDadPosition;
            leaPosition=2*myDadPosition+1;
            }
            if(myArreglo[leaPosition] == null){
                break;                
            } 
          }
        }else if(size ==2){
            while(myArreglo[lukePosition].priority < myArreglo[myDadPosition].priority){
            PriorityNode temporal = new PriorityNode ();
            temporal=myArreglo[myDadPosition]; 
            if(myArreglo[lukePosition].priority < myArreglo[myDadPosition].priority){  
            myArreglo[myDadPosition]=myArreglo[lukePosition];
            myArreglo[lukePosition]=temporal;  
            myDadPosition=lukePosition;
            lukePosition=2*myDadPosition;
            leaPosition=2*myDadPosition+1;
            }
            else if(size==1){
                System.out.println(myDadPosition);
                break;
            }  
            
            if(myArreglo[size]==null);{
                System.out.println("Lista vacia");
            break;
         }    
        }
    }
        
        return result;
    }

    @Override
    public String toString (){
        String result = new String("[");
        for (int i=1; i<=this.size; i++){
            result += "Prioridad: " + myArreglo[i].priority + ", ";
        }        
        result +="]";
        return result;
    }
    
}
