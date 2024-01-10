/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

public class FloatLinkedList implements FloatList{

    private class FloatNode{
        private Float elem;   // elemento del nodo
        private FloatNode next;   // nodo que apunta al siguiente nodo de su mismo tipo
        public FloatNode(Float elem, FloatNode next){    // Función constructora
            this.elem = elem;
            this.next = next;
        }

        public FloatNode getNext() {    // devuelve el siguiente nodo a nuestro nodo
            return next;
        }
        public Float getElem(){       // devuelve el elemento del nodo
            return elem;
        }
        public void setElem (Float elem){    // modifica el valor del elemento del nodo
            this.elem = elem;
        }
        public void setNext(FloatNode next){    // modifica la dirección a la que apunta el nodo
            this.next = next;
        }
    }

    private FloatNode head;
    private int size;

    public FloatLinkedList(){      //Funcion constructora de una lista
        this.size = 0;
        this.head = null;
    }

    @Override
    public int size() {     // devuelve el tamaño
        return size;
    }

    @Override
    public boolean isEmpty() {     // devuelve el estado, si está vacía
        return (size == 0);
    }

    @Override
    public void add(Float value) {       // añade un nodo por cabecera
        this.head = new FloatNode( value , head);   // la cabecera apunta a un nuevo nodo,con elemento = value y apunta a donde apunta la cabecera.
        this.size ++;        // aumenta el tamaño de la lista
    }
    @Override
    public void add(int index, Float value) {

        FloatNode anterior = forward(index);    // Busca el nodo anterior al indice que queremos

        if(anterior == null) {     // Comprueba si la lista está vacía
            add(value);     // implementación como lista vacía sin importar el orden, por cabecera
        }else{
            FloatNode node = new FloatNode(value , anterior.getNext());     // Nodo con elem = value y que apunta a siguiente del anterior, el anterior nodo en la posicion index
            this.size++;    // aumentamos el tamaño de la lista
            anterior.setNext(node);    // el anterior ahora apunta al nuevo nodo en el index
        }
    }

    private FloatNode forward (int index) {


        if (index < 1 || index > size + 1) {    // Comprueba que el index está dentro del intervalo de opciones
            throw new RuntimeException("Index out of bounds");
        }
        FloatNode anterior = null;
        FloatNode actual = this.head; // nodo que apunta al siguiente de la lista

        for (int i = 1; i < index; i++) {    // se repite para i veces, hasta llegar al numero del indice
            anterior = actual;             // el anterior apunta al actual
            actual = actual.getNext();     // el actual apunta al siguiente del actual
            // va avanzando a través de la lista
        }
        return anterior;    // devuelve el puntero anterior
    }

    @Override
    public Float remove() {
        if (this.isEmpty()){     // si la lista está vacía
            throw new RuntimeException("List is empty");   // mensaje de error
        }else{
            FloatNode node = this.head;   //nodo auxiliar que apunta al primer elemento de la lista, la cabecera
            this.size--;    // disminuye el tamaño de la lista
            head = node.getNext();   // la cabecera apunta al siguiente del nodo, sacandolo de la lista
            return node.getElem();   // Devuelve el elemento borrado de la lista
        }
    }

    @Override
    public Float remove(int index) {
        if (this.isEmpty()){    // comprueba si está vacía
            throw new RuntimeException("List is empty");   //mensaje de error
        }else{
            if(index < 1 || index > size + 1){    // Comprueba que el indice sea correcto
                throw new RuntimeException("Index is out of bounds"); // mensaje de error
            }else{

                FloatNode anterior = forward(index);
                if(anterior == null) {     // Comprueba si la lista está vacía
                    return remove();    // Borramos como lista vacía sin importar el orden, por cabecera

                }else{
                    FloatNode NodoE = anterior.getNext();   // El siguiente al anterior, el nodo que eliminamos
                    this.size--;    // disminuimos el tamaño de la lista
                    anterior.setNext(NodoE.getNext());    // el anterior apunta al siguiente del nodo que eliminamos, se pasa por encima.
                    return NodoE.getElem();  // devuelve el elemento del nodo eliminado.
                }


            }
        }
    }

    @Override
    public Float get() {
        if( this.isEmpty()){
            throw new RuntimeException("Lista vacía");  // comprueba si esta vacía la lista
        }else{
            return head.getElem();    // devuelve el elemento del primer nodo
        }
    }

    @Override
    public Float get(int index) {
      if (this.isEmpty()){
          throw new RuntimeException("This list is empty");  // comprueba si esta vacía la lista
      }else{
          if (index < 1 || index > size + 1){
              throw new RuntimeException("Index out of bounds");  // comprueba si esta vacía la lista
          }else{
              FloatNode actual = head;
              for(int i = 1; i< index; i++){
                  actual = actual.getNext();        // actual = forward(index +1);
              }
              return actual.getElem();
          }
      }
    }

    @Override
    public int search(Float value) {
      if (this.isEmpty()){
          throw new RuntimeException("List is empty");   //comprueba si está vacía
      }else{
          FloatNode actual = head;     // apunta a la cabecera
          int i = 1;
          while (i < size && (! actual.getElem().equals(value) )){    // se repite mientras q la i sea mas pequeña q el tamaño y los elementos no sean iguales
              actual = actual.getNext();     // avanza a través de la lista
          }
          if (actual.getElem().equals(value)){     // comprueba si los elementos sn iguales  (objetivo)
              return i;      // si se cumple devuelve el indice
          }else{
              return 0;   // devuelve cero si no está contenido en la lista
          }
      }
    }

    @Override
    public boolean contains(Float value) {

      return this.search(value) != 0;    // busca el elemento en la lista, si devuelve algo q no sea cero entonces está contenido

    }
    
}
