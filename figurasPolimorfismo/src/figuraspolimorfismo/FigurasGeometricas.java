/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package figuraspolimorfismo;

/**
 * Clase padre
 *
 * @author Valentina Sarmiento
 */
public abstract class FigurasGeometricas implements IOperaciones {

    /**
     * la variable lado1 almacena el valor del primer lado de la figura
     */
    private double lado1;
    /**
     * la variable lado2 almacena el valor del segundo lado de la figura
     */
    private double lado2;
    /**
     * la variable area almacena el valor del area la figura
     */
    private double area;
    /**
     * la variable perimetro almacena el valor del periemetro de la figura
     */
    private double perimetro;
    /**
     * las variables coordenada1X y coordenada1Y almacenan los valores de X y Y
     * de la primera coordenada
     */
    private double coordenada1X, coordenada1Y;
    /**
     * las variables coordenada2X y coordenada2Y almacenan los valores de X y Y
     * de la segunda coordenada
     */
    private double coordenada2X, coordenada2Y;
    /**
     * las variables coordenada3X y coordenada3Y almacenan los valores de X y Y
     * de la tercera coordenada
     */
    private double coordenada3X, coordenada3Y;
    /**
     * la variable color almacena el color seleccionado
     */
    private String color;

    /*Quitar decimales alas variables doubles
     /DecimalFormat decimales = new DecimalFormat("#.0");*/
    /**
     * Constructor que recibe los valores de las tres coordendas en X y Y
     *
     * @param coordenada1X valor de X de la primera coordenda
     * @param coordenada1Y valor de Y de la primera coordenda
     * @param coordenada2X valor de X de la segunda coordenda
     * @param coordenada2Y valor de Y de la segunda coordenda
     * @param coordenada3X valor de X de la tercera coordenda
     * @param coordenada3Y valor de Y de la tercera coordenda
     */
    public FigurasGeometricas(double coordenada1X, double coordenada1Y, double coordenada2X, double coordenada2Y, double coordenada3X, double coordenada3Y) {
        this.coordenada1X = coordenada1X;
        this.coordenada1Y = coordenada1Y;
        this.coordenada2X = coordenada2X;
        this.coordenada2Y = coordenada2Y;
        this.coordenada3X = coordenada3X;
        this.coordenada3Y = coordenada3Y;

//        hallarLado();
    }

    /**
     * Metodo hallaLado() del ejercicio anterior
     */

    /* public void hallarLado() {
     double raiz, raiz2;
     double potencia1, potencia2;

     potencia1 = Math.pow((this.coordenada2X - this.coordenada1X), 2);
     potencia2 = Math.pow((this.coordenada2Y - this.coordenada1Y), 2);
     raiz = Math.sqrt(potencia1 + potencia2);

     this.lado1 = raiz;

     potencia1 = Math.pow((this.coordenada3X - this.coordenada2X), 2);
     potencia2 = Math.pow((this.coordenada3Y - this.coordenada2Y), 2);
     raiz = Math.sqrt(potencia1 + potencia2);

     this.lado2 = raiz;
     }*/
    /**
     * Metodo que recibe argumentos referentes a dos coordenadas para encontrar
     * la medida de un punto a otro retornando la medida del lado
     *
     * @param coordenada1X
     * @param coordenada1Y
     * @param coordenada2X
     * @param coordenada2Y
     * @return
     */
    public double hallarLado(double coordenada1X, double coordenada1Y, double coordenada2X, double coordenada2Y) {
        double raiz, potencia1, potencia2, lado;

        potencia1 = Math.pow((coordenada2X - coordenada1X), 2);
        potencia2 = Math.pow((coordenada2Y - coordenada1Y), 2);
        raiz = Math.sqrt(potencia1 + potencia2);

        lado = raiz;

        return lado;
    }

    /**
     * Metodo que calcula los puntos de X en cada una de las coordenadas
     *
     * @param coordenada valor del punto en X
     * @return valorCoordenada valor del punto X de cada una de las coordenadas
     */
    public int nuevosPuntosenX(double coordenada) {
        int valorCoordenada;

        int coordenadaX = (int) coordenada;
        valorCoordenada = 450 + (coordenadaX * 10);

        return valorCoordenada;

    }

    /**
     * Metodo que calcula los puntos de X en cada una de las coordenadas
     *
     * @param coordenada valor del punto en X
     * @return valorCoordenada valor del punto X de cada una de las coordenadas
     */
    public int nuevosPuntosenY(double coordenada) {
        int valorCoordenada;

        int coordenadaY = (int) coordenada;
        valorCoordenada = 290 - (coordenadaY * 10);

        return valorCoordenada;

    }

    /**
     * Metodo que recibe las coordenadas en pares , para validar si se puede
     * dibujar un triangulo
     *
     * @return verificar retorna un false si se cumplen las condiciones
     */
    public boolean verificarCoordenadas() {
        boolean verificar = true;

        if (this.coordenada1X == this.coordenada2X && this.coordenada2Y == this.coordenada3Y) {
            verificar = false;
        }
        return verificar;
    }

    /**
     * Metodo que muestra el mensaje con los resultados del area y parametro de
     * las figuras
     *
     * @return resultado string del mensaje
     */
    public String resultadoOperaciones() {
        String resultado = "El area es: " + area + "\n" + "El perimetro es: " + perimetro;
        return resultado;
    }

    /**
     * Metodo para mostrar el valor del primer lado
     *
     * @return lado1 retorna el valor del primer lado
     */
    public double getLado1() {
        return lado1;
    }

    /**
     * Metodo para modificar el valor del primer lado
     *
     * @param lado1 valor a modificar del primer lado
     */
    public void setLado1(double lado1) {
        this.lado1 = lado1;
    }

    /**
     * Metodo para mostrar el valor del segundo lado
     *
     * @return lado2 retorna el valor del segundo lado
     */
    public double getLado2() {
        return lado2;
    }

    /**
     * Metodo para modificar el valor del segundo lado
     *
     * @param lado2 valor a modificar del segundo lado
     */
    public void setLado2(double lado2) {
        this.lado2 = lado2;
    }

    /**
     * Metodo para mostrar el valor del area
     *
     * @return area retorna el valor del area
     */
    public double getArea() {
        return area;
    }

    /**
     * Metodo para modificar el valor del area
     *
     * @param area valor a modificar del area
     */
    public void setArea(double area) {
        this.area = area;
    }

    /**
     * Metodo para mostrar el valor del perimetro
     *
     * @return perimetro retorna el valor del perimetro
     */
    public double getPerimetro() {
        return perimetro;
    }

    /**
     * Metodo para modificar el valor del perimetro
     *
     * @param perimetro valor a modificar del perimetro
     */
    public void setPerimetro(double perimetro) {
        this.perimetro = perimetro;
    }

    /**
     * Metodo para mostrar el valor de X de la primera coordenada
     *
     * @return coordenada1X retorna el valor de X de la primera coordenda
     */
    public double getCoordenada1X() {
        return coordenada1X;
    }

    /**
     * Metodo para modificar el valor de X de la primera coordenda
     *
     * @param coordenada1X valor a modificar en X de la primera coordenda
     */
    public void setCoordenada1X(double coordenada1X) {
        this.coordenada1X = coordenada1X;
    }

    /**
     * Metodo para mostrar el valor de Y de la primera coordenada
     *
     * @return coordenada1Y retorna el valor de Y de la primera coordenda
     */
    public double getCoordenada1Y() {
        return coordenada1Y;
    }

    /**
     * Metodo para modificar el valor de Y de la primera coordenda
     *
     * @param coordenada1Y valor a modificar en Y de la primera coordenda
     */
    public void setCoordenada1Y(double coordenada1Y) {
        this.coordenada1Y = coordenada1Y;
    }

    /**
     * Metodo para mostrar el valor de X de la segunda coordenda
     *
     * @return coordenada2X retorna el valor de X de la segunda coordenda
     */
    public double getCoordenada2X() {
        return coordenada2X;
    }

    /**
     * Metodo para modificar el valor de X de la segunda coordenda
     *
     * @param coordenada2X valor a modificar en X de la segunda coordenda
     */
    public void setCoordenada2X(double coordenada2X) {
        this.coordenada2X = coordenada2X;
    }

    /**
     * Metodo para mostrar el valor de Y de la segunda coordenda
     *
     * @return coordenada2Y retorna el valor de Y de la segunda coordenda
     */
    public double getCoordenada2Y() {
        return coordenada2Y;
    }

    /**
     * Metodo para modificar el valor de Y de la segunda coordenda
     *
     * @param coordenada2Y valor a modificar en Y de la segunda coordenda
     */
    public void setCoordenada2Y(double coordenada2Y) {
        this.coordenada2Y = coordenada2Y;
    }

    /**
     * Metodo para mostrar el valor de X de la tercera coordenda
     *
     * @return coordenada3X retorna el valor de X de la tercera coordenda
     */
    public double getCoordenada3X() {
        return coordenada3X;
    }

    /**
     * Metodo para modificar el valor de X de la tercera coordenda
     *
     * @param coordenada3X valor a modificar en X de la tercera coordenda
     */
    public void setCoordenada3X(double coordenada3X) {
        this.coordenada3X = coordenada3X;
    }

    /**
     * Metodo para mostrar el valor de Y de la tercera coordenda
     *
     * @return coordenada3Y retorna el valor de Y de la tercera coordenda
     */
    public double getCoordenada3Y() {
        return coordenada3Y;
    }

    /**
     * Metodo para modificar el valor de X de la tercera coordenda
     *
     * @param coordenada3Y valor a modificar en Y de la tercera coordenda
     */
    public void setCoordenada3Y(double coordenada3Y) {
        this.coordenada3Y = coordenada3Y;
    }

    /**
     * Metodo para mostrar cual a sido el color que se ha escogido
     *
     * @return color retorna el color seleccionado
     */
    public String getColor() {
        return color;
    }

    /**
     * Metodo para modificar el color que se ha seleccionado
     *
     * @param color modificar el color seleccionado
     */
    public void setColor(String color) {
        this.color = color;
    }

}
