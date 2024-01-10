/** Nuesto primer programa: Hello World! */

public class Introduccion {
    public static void main(String[] args) {
        System.out.println("Hello World!");
    }
}


/**
 * 1. ¿Qué es una clase?
 *
 * Una clase es un modelo que se utiliza para crear objetos que comparten un mismo comportamiento, estado e identidad.
 *
 * 1.1. Modificadores:
 *    - public: se puede acceder desde cualquier clase.
 *    - private: solo se puede acceder desde la misma clase.
 *    - protected: se puede acceder desde la misma clase y desde las clases que heredan de ella.
 *    - default: se puede acceder desde la misma clase y desde las clases del mismo paquete.
 *
 *    - static: se puede acceder sin necesidad de crear un objeto de la clase.
 *    - final: no se puede heredar.
 *    - abstract: no se puede instanciar. Tiene metodos abstractos. Tiene que ser heredada.
 *    - interface: no se puede instanciar. Todos los métodos son abstractos. Tiene que ser implementada.
 *
 * 1.2. Atributos: son las características de la clase.
 *   - primitivos: int, double, float, char, boolean, byte, short, long.
 *   - objetos: String, Integer, Double, Float, Character, Boolean, Byte, Short, Long.
 *   - arrays: int[], double[], float[], char[], boolean[], byte[], short[], long[], String[], Integer[], Double[], Float[], Character[], Boolean[], Byte[], Short[], Long[].
 *
 *   Tienen modificadores de acceso: public, private, protected, default;
 *   y modificadores de comportamiento: static, final, abstract.
 *
 * 1.3. Métodos: son las acciones que puede realizar la clase.
 *    - constructores: inicializan los atributos de la clase.
 *    - setters: modifican los atributos de la clase.
 *    - getters: devuelven los atributos de la clase.
 *    - otros: realizan acciones sobre los atributos de la clase.
 *
 *    Tienen modificadores de acceso: public, private, protected, default;
 *    y modificadores de comportamiento: static, final, abstract.
 */


/**
 * 2. ¿Qué es un objeto?
 *
 * Un objeto es una entidad que tiene un estado y un comportamiento, está compuesto por atributos y métodos.
 *
 * Un objeto es una instancia de una clase. Cuando se crea un objeto, se crea una instancia de una clase.
 *
 */


/**
 * 3. Casting de tipos
 *
 * El casting de tipos es la conversión de un tipo de dato a otro.
 * (type) variable
 */


/**
 * 4. If-else
 */


/**
 * 5. Switch
 */


/**
 * 6. Bucles
 *
 * 6.1. for
 *
 * 6.2. while
 *
 * 6.3. do-while
 *
 * 6.4. break
 *
 * 6.5. continue
 *
 * 6.6. etiquetas
 *
 */


/**
 * 7. Programación orientada a objetos:
 *    - abstracción: capacidad de representar un objeto de la realidad en un programa.
 *    - encapsulación: capacidad de ocultar los detalles internos de un objeto.
 *    - modularidad: capacidad de dividir un programa en módulos.
 *
 *
 *  7.1. Herecia y polimorfismo
 *
 * La herencia es la capacidad de una clase de heredar los atributos y métodos de otra clase.
 * Clase base o superclase: clase de la que hereda.
 * Clase derivada o subclase: clase que hereda.
 *
 *
 * Polimosfismo es la capacidad de una clase de comportarse como otra clase. Por ejemplo, una clase derivada puede comportarse como su clase base.
 */


/**
 * 8. Excepciones
 *
 * Las excepciones son errores que se producen durante la ejecución de un programa.
 *
 * 8.1. Lanzar excepciones
 *
 * Lanzar excepciones es la capacidad de un método de devolver un error. Se usa la palabra reservada throw.
 *
 * 8.2. Capturar excepciones
 *
 * Capturar excepciones es la capacidad de un método de capturar un error. Se usa la palabra reservada try y catch (y opcionalmente finally).
 *
 * try : se ejecuta el código que puede lanzar una excepción.
 * catch : se captura la excepción.
 * finally : se ejecuta siempre.
 *
 * 8.3. Crear excepciones
 *
 * Crear excepciones es la capacidad de crear una clase que herede de Exception o RuntimeException.
 *
 */