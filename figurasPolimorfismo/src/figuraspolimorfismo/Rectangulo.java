/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package figuraspolimorfismo;

/**
 *
 * @author Luz
 */
public class Rectangulo extends Cuadrilatero {
    /**
     * Constructor que recibe los valores de las cuatro coordendas en X y Y 
     * @param coordenada1X valor de X de la primera coordenda
     * @param coordenada1Y valor de Y de la primera coordenda
     * @param coordenada2X valor de X de la segunda coordenda
     * @param coordenada2Y valor de Y de la segunda coordenda
     * @param coordenada3X valor de X de la tercera coordenda
     * @param coordenada3Y valor de Y de la tercera coordenda
     * @param coordenada4X valor de X de la cuarta  coordenda
     * @param coordenada4Y valor de Y de la cuarta  coordenda
     */
    public Rectangulo(double coordenada1X, double coordenada1Y, double coordenada2X, double coordenada2Y, double coordenada3X, double coordenada3Y, double coordenada4X, double coordenada4Y) {
        super(coordenada1X, coordenada1Y, coordenada2X, coordenada2Y, coordenada3X, coordenada3Y, coordenada4X, coordenada4Y);
        
    }
    /**
     * Metodo para hallar el perimetro del rectangulo
     */
    @Override
    public void hallarArea() {
        setArea(getLado1() * getLado2());
        System.out.println("el area es " + getArea());
    }
    /**
     * Metodo para hallar el perimetro del rectangulo
     */
    @Override
    public void hallarPerimetro() {
        setPerimetro((getLado1() * 2) + (getLado2() * 2));
    }

}
