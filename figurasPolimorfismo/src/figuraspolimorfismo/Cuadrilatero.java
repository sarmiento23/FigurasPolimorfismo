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
public class Cuadrilatero extends FigurasGeometricas {


    /**
     * las variables coordenada4X y coordenada4Y almacenan los valores de  X y Y de la cuarta coordenada
     */
    private double coordenada4X,coordenada4Y;
    /**
     *  la variable coordenada4 almacena el valor de la cuarta coordenda
     */
    private String coordenada4;
    /**
     * Constructor que recibe los valores de las cuatro coordendas en X y Y 
     * @param coordenada1X valor de X de la primera coordenda
     * @param coordenada1Y valor de Y de la primera coordenda
     * @param coordenada2X valor de X de la segunda coordenda
     * @param coordenada2Y valor de Y de la segunda coordenda
     * @param coordenada3X valor de X de la tercera coordenda
     * @param coordenada3Y valor de Y de la tercera coordenda
     * @param coordenada4X valor de X de la cuarta coordenda
     * @param coordenada4Y valor de Y de la cuarta coordenda
     */
    public Cuadrilatero(double coordenada1X, double coordenada1Y, double coordenada2X, double coordenada2Y, double coordenada3X, double coordenada3Y,double coordenada4X, double coordenada4Y ) {

        super(coordenada1X, coordenada1Y, coordenada2X, coordenada2Y, coordenada3X, coordenada3Y);
        this.coordenada4X = coordenada4X;
        this.coordenada4Y = coordenada4Y;
        
        setLado1(hallarLado(coordenada1X,coordenada1Y,coordenada2X,coordenada2Y));
        setLado2(hallarLado(coordenada3X,coordenada3Y,coordenada2X,coordenada2Y));
    }
     /**
      * Metodo para verificar si la figura es un cuadrado ó un rectangulo
      * @param tipoCuadrado identificar que tipo de figura es 
      * @return verificar retorna un false si ninguna de las condiciones se cumple
      */
    public boolean verificarCuadrilatero(String tipoCuadrado) {
//        boolean verificarCoord=verificarCoordenadas();
        boolean verificar = false;
        if (tipoCuadrado.equals("Cuadrado")) {
            if (getLado1() == getLado2()) {
                System.out.print("Entro al If ladoIgual \n");
                return verificar = true;
            } else {
                return verificar = false;
            }
        } else if (tipoCuadrado.equals("Rectangulo")) {
            if (getLado1() == getLado2()) {
                System.out.print("Entro al If ladoIgual \n");
                return verificar = false;
            } else {
                return verificar = true;
            }
        } else {
            return verificar = false;
        }
    }

    
    /**
     * Metodo para verificar  que no se dibuje un rombo ó un romboide
     * @return verificar devuelve un true si la condicion se cumple
     */

    @Override
    public boolean verificarCoordenadas() {
        boolean verificar = false;
        if (getCoordenada1Y() == getCoordenada2Y() && getCoordenada2X() == getCoordenada3X() && getCoordenada3Y() == this.coordenada4Y && this.coordenada4X == getCoordenada1X()) {
            verificar = true;
        }
        return verificar;
    }
    /**
     * Metodo que calcula  las cuatro cordenadas en X para graficar 
     * @return  puntosEnX retorna un array 
     */
    @Override
    public int[] arrayPuntosEnX() {
        int coordenadaX1 = (int) getCoordenada1X();
        int coordenadaX2 = (int) getCoordenada2X();
        int coordenadaX3 = (int) getCoordenada3X();
        int coordenadaX4 = (int) this.coordenada4X;
        coordenadaX1 = 450 + (coordenadaX1 * 10);
        coordenadaX2 = 450 + (coordenadaX2 * 10);
        coordenadaX3 = 450 + (coordenadaX3 * 10);
        coordenadaX4 = 450 + (coordenadaX4 * 10);
        int puntosEnX[] = {coordenadaX1, coordenadaX2, coordenadaX3, coordenadaX4};
        // hacer logica segun el trinagulo , reescribir en cuadrilatero 
        return puntosEnX;
    }
     /**
     * Metodo que calcula  las cuatro cordenadas en Y para graficar 
     * @return  puntosEnY retorna un array 
     */
    @Override
    public int[] arrayPuntosEnY() {
        int coordenadaY1 = (int) getCoordenada1Y();
        int coordenadaY2 = (int) getCoordenada2Y();
        int coordenadaY3 = (int) getCoordenada3Y();
        int coordenadaY4 = (int) this.coordenada4Y;
        coordenadaY1 = 290 - (coordenadaY1 * 10);
        coordenadaY2 = 290 - (coordenadaY2 * 10);
        coordenadaY3 = 290 - (coordenadaY3 * 10);
        coordenadaY4 = 290 - (coordenadaY4 * 10);
        int puntosEnY[] = {coordenadaY1, coordenadaY2, coordenadaY3, coordenadaY4};
        // hacer logica segun el trinagulo , reescribir en cuadrilatero 
        return puntosEnY;
    }
     /**
       * Metodo para mostrar el valor de X  de la cuarta coordenda
       * @return coordenada3X retorna el valor de X de la cuarta coordenda
      */
    public double getCoordenada4X() {
        return coordenada4X;
    }
    /**
     * Metodo para modificar el valor de X de la cuarta coordenda  
     * @param coordenada4X valor a modificar en X  de la cuarta coordenda
     */
    public void setCoordenada4X(short coordenada4X) {
        this.coordenada4X = coordenada4X;
    }
    /**
     * Metodo para mostrar el valor de Y  de la cuarta coordenda
     * @return retorna el valor de Y de la cuarta coordenda
     */
    public double getCoordenada4Y() {
        return coordenada4Y;
    }
    /**
     * Metodo para modificar el valor de Y de la cuarta coordenda  
     * @param coordenada4Y valor a modificar en Y  de la cuarta coordenda
     */
    public void setCoordenada4Y(short coordenada4Y) {
        this.coordenada4Y = coordenada4Y;
    }
     /**
     * Metodo para mostrar el valor de la cuarta coordenada
     * @return coordenada1 retorna el valor de la cuarta coordenada
     */
    public String getCoordenada4() {
        return coordenada4;
    }
    /**
     * Metodo para modificar el valor de la cuarta coordenda
     * @param coordenada4 valor a modificar en la cuarta coordenda
     */

    public void setCoordenada4(String coordenada4) {
        this.coordenada4 = coordenada4;
    }

   @Override
     public void hallarArea() {
       double resultadoArea =getLado1() * getLado1();
       setArea(resultadoArea);
    }

    /**
     * Metodo para hallar el perimetro de un cuadrado
     */
    @Override
    public void hallarPerimetro() {
        setPerimetro(getLado1() * 4);
    }

      /**
     * Metodo para hallar la distancia de cada uno de los lados
     */
    
    
    

}
