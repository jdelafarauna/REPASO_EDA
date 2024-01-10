import java.util.HashSet;
import java.util.Set;
import java.util.Random;


/**
 * This class represents a player in a bingo game.
 */
class Card {

    private Set<Integer> numeros;


    public void Carton(){
        this.numeros = new HashSet<>();
        Llenar();
    }

    public void Llenar(){
        Random num = new Random();

        while(numeros.size() < 15){
            int aux = num.nextInt(91);
            numeros.add(aux);
        }
    }

    public boolean Vacio(){
        return this.numeros.size() == 0;
    }

    public boolean Contiene(int num){
        if (numeros.contains(num)){
            numeros.remove(num);
            return true;
        }else return false;
    }

    public void MostrarCarton(){
        for (int indide : numeros){
            System.out.print(numeros);
        }
    }
}