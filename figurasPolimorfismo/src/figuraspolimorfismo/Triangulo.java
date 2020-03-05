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
public class Triangulo extends FigurasGeometricas {
    /**
     *la variable lado3 almacena el valor del tercer lado del triangulo
     */
    private double lado3;
    /**
     * la variable tipoTriangulo almacena el tipo del triangulo
     */
    private String tipoTriangulo;
    /**
     * Constructor que recibe los valores de las tres coordendas en X y Y 
     * @param coordenada1X valor de X de la primera coordenda
     * @param coordenada1Y valor de Y de la primera coordenda
     * @param coordenada2X valor de X de la segunda coordenda
     * @param coordenada2Y valor de Y de la segunda coordenda
     * @param coordenada3X valor de X de la tercera coordenda
     * @param coordenada3Y valor de Y de la tercera coordenda
     */
    public Triangulo(double coordenada1X, double coordenada1Y, double coordenada2X, double coordenada2Y, double coordenada3X, double coordenada3Y) {
        super(coordenada1X, coordenada1Y, coordenada2X, coordenada2Y, coordenada3X, coordenada3Y);
        setLado1(hallarLado(coordenada1X,coordenada1Y,coordenada2X,coordenada2Y));
        setLado2(hallarLado(coordenada3X,coordenada3Y,coordenada2X,coordenada2Y));
        this.lado3=hallarLado(coordenada1X,coordenada1Y,coordenada3X,coordenada3Y);
    }
    /**
     * Metodo para hallar la distancia de cada uno de los lados del triangulo
     * 
     * Metodo hallar lado de ejercicio anterior 
   @Override
    public void hallarLado() {
        double raiz, raiz2;
        double potencia1, potencia2;

        potencia1 = Math.pow((getCoordenada2X() - getCoordenada1X()), 2);
        potencia2 = Math.pow((getCoordenada2Y() - getCoordenada1Y()), 2);
        raiz = Math.sqrt(potencia1 + potencia2);

        setLado1(raiz);

        potencia1 = Math.pow((getCoordenada3X() - getCoordenada2X()), 2);
        potencia2 = Math.pow((getCoordenada3Y() - getCoordenada2Y()), 2);
        raiz = Math.sqrt(potencia1 + potencia2);

        setLado2(raiz);

        potencia1 = Math.pow((getCoordenada1X() - getCoordenada3X()), 2);
        potencia2 = Math.pow((getCoordenada1Y() - getCoordenada3Y()), 2);
        raiz = Math.sqrt(potencia1 + potencia2);

        this.lado3 = raiz;
    }
    * 
    *  */
    
    /**
     * Metodo para identificar que tipo de triangulo es 
     */
    public void hallarTipoTriangulo() {
        if (getLado1() == getLado2() && getLado1() == this.lado3) {
            tipoTriangulo = "Equilatero";
        } else if (getLado1() == getLado2() || getLado1() == this.lado3 || getLado2() == this.lado3) {
            tipoTriangulo = "Isosceles";
        } else {
            tipoTriangulo = "Escaleno";
        }
    }
    /**
     * Metodo para hallar el area de un triangulo con la formula de Heron
     */
    @Override
    public void hallarArea() {
        double semiPerimetro;
        double raiz;

        semiPerimetro = (getLado1() + getLado2() + this.lado3) / 2;

        raiz = Math.sqrt((semiPerimetro*(semiPerimetro-getLado1()))*(semiPerimetro-getLado2())*(semiPerimetro-this.lado3));

        setArea(raiz);
    }
    /**
     * Metodo para hallar el perimetro de un triangulo según su tipo
     */

    @Override
    public void hallarPerimetro() {
        hallarTipoTriangulo();
        if (tipoTriangulo.equals("Equilatero")) {
            setPerimetro(getLado1() * 3);
        } else if (tipoTriangulo.equals("Isosceles")) {
            if (getLado1() == getLado2()) {
                setPerimetro((getLado1() * 2) + this.lado3);
            } else if (getLado1() == this.lado3) {
                setPerimetro((getLado1() * 2) + getLado2());
            } else {
                setPerimetro((getLado2() * 2) + getLado1());
            }
        } else {
            setPerimetro(getLado2() + getLado1() + this.lado3);
        }
    }
    /**
     * Metodo que muestra los resultados del area, perimetro y el tipo del triangulo
     * @return  resultado retorna el resultado del area,perimetro y tipo del triangulo
     */
    @Override
    public String resultadoOperaciones(){
        String resultado = "El area es: " + getArea() + "\n"+"El perimetro es: " + getPerimetro() +"\n"+"El tipo de triangulo es: "+tipoTriangulo;
        
        return resultado;
    }

    
    /**
     * Metodo para mostrar el valor del tercer lado
     * @return lado3 retorna el valor del tercer lado
     */
    public double getLado3() {
        return lado3;
    }
    /**
     * Metodo para modificar el valor del tercer lado
     * @param lado3 valor a modificar del tercer lado
     */
    public void setLado3(double lado3) {
        this.lado3 = lado3;
    }
    /**
     * Metodo para mostrar que tipo de triangulo se va a dibujas
     * @return tipoTriangulo retorna el tipo de triangulo
     */
    public String getTipoTriangulo() {
        return tipoTriangulo;
    }
    /**
     * Metodo para modificar el tipo del triangulo
     * @param tipoTriangulo modificar el tipo del triangulo
     */
    public void setTipoTriangulo(String tipoTriangulo) {
        this.tipoTriangulo = tipoTriangulo;
    }

    /**
     * Metodo que genera los arrays de los puntos x para graficar un poligono
     * @return puntoEnX retorna un array
     */
    @Override
    public int[] arrayPuntosEnX() {
        int coordenadaX1 = nuevosPuntosenX(getCoordenada1X());
        int coordenadaX2 = nuevosPuntosenX(getCoordenada2X());
        int coordenadaX3 = nuevosPuntosenX(getCoordenada3X());
        int puntosEnX[] = {coordenadaX1, coordenadaX2, coordenadaX3};
        // hacer logica segun el trinagulo , reescribir en cuadrilatero 
        return puntosEnX;
    }

    /**
     * Metodo que genera los arrays de los puntos y para graficar un poligono
     * @return puntoEnY retorna un array
     */
    @Override
    public int[] arrayPuntosEnY() {

        int coordenadaY1 = nuevosPuntosenY(getCoordenada1Y());
        int coordenadaY2 = nuevosPuntosenY(getCoordenada2Y());
        int coordenadaY3 = nuevosPuntosenY(getCoordenada3Y());
        int puntosEnY[] = {coordenadaY1, coordenadaY2, coordenadaY3};
        // hacer logica segun el trinagulo , reescribir en cuadrilatero 
        return puntosEnY;
    }

}
