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
public class PriorityNode<AnyData> {
    AnyData Dato;
    int priority;

    public PriorityNode(AnyData Dato, int priority) {
        this.Dato = Dato;
        this.priority = priority;
    }

    public PriorityNode() {
    }
    
}
