/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package figuraspolimorfismo;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JOptionPane;

/**
 *
 * @author Luz
 */
public class Ventana extends javax.swing.JFrame {

    /**
     * la variable figura almacena el tipo de figura seleccionado en el menu
     * desplegable
     */
    private String figura;
    /**
     * la variable color almacena el color seleccionado en el menu desplegable
     */
    private String color;
    /**
     * la variable coordenada1 almacena el valor de la primera cordenda
     */
    private String coordenada1;
    /**
     * la variable coordenada2 almacena el valor de la segunda cordenda
     */
    private String coordenada2;
    /**
     * la variable coordenada3 almacena el valor de la tercera cordenda
     */
    private String coordenada3;
    /**
     * la variable coordenada4 almacena el valor de la cuarta cordenda
     */
    private String coordenada4;
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
     * las variables coordenada4X y coordenada4Y almacenan los valores de X y Y
     * de la cuarta coordenada
     */
    private double coordenada4X, coordenada4Y;
    /**
     *
     */
    IOperaciones operacion;
    /**
     * Indica el tamaño que va a tener el vector que se llena con objetos de la
     * clase FigurasGeometricas
     */
    byte tamanoVectorFiguras = 2;
    /**
     * Se instancia un vetor de la clase FigurasGeometricas
     */
    FigurasGeometricas[] vectorDeFiguras = new FigurasGeometricas[tamanoVectorFiguras];
    /**
     * variable que hace la funcion de un contador para saber cuantas figuras a
     * agregado
     */
    byte numeroFiguraAgregadas;

    /**
     * Metodo que crea la ventana del formulario
     */
    public Ventana() {
        initComponents();
        //le da color a la ventana 
        //this.getContentPane().setBackground(Color.white);
    }

    /*
     el metodo paint se sobreescribe de la clase JFrame
     para inicializar el plano cartesiano y hacer visible = false
     a los textFile
     */
    /**
     * Metodo para inicializar el plano cartesiano
     *
     * @param ventana dimensiones del plano cartesiano
     */
    @Override
    public void paint(Graphics ventana) {
        //llamamos al constructor 
        super.paint(ventana);
        //Dibujamos una linea para el eje X y Y
        //Y
        ventana.drawLine(450, 80, 450, 500);
        //X
        ventana.drawLine(250, 290, 650, 290);
        //Dibujamos la escala de los ejes
        //X
        for (int i = 251; i < 650; i += 10) {
            ventana.drawLine(i, 285, i, 295);
        }
        //Y
        for (int i = 79; i < 500; i += 10) {
            ventana.drawLine(445, i, 455, i);
        }

        //Igualamos componentes visible a false
        lbCoordenadas.setVisible(false);
        lbNumero1.setVisible(false);
        lbNumero2.setVisible(false);
        lbNumero3.setVisible(false);
        lbNumero4.setVisible(false);
        tfCoordenada1.setVisible(false);
        tfCoordenada2.setVisible(false);
        tfCoordenada3.setVisible(false);
        tfCoordenada4.setVisible(false);
        taResultados.setVisible(false);
        panelInformacionFiguras.setVisible(false);
        btGraficar.setVisible(false);
        btLimpiar.setVisible(false);
    }

    /**
     * Metodo que obtiene los datos ingresados en la interfaz
     */
    private void obtenerDatos() {
        //Para traer el valor del menu desplegable
        figura = cbSeleccionFigura.getSelectedItem().toString();
        color = cbSeleccionColor.getSelectedItem().toString();
        coordenada1 = tfCoordenada1.getText();
        coordenada2 = tfCoordenada2.getText();
        coordenada3 = tfCoordenada3.getText();
        coordenada4 = tfCoordenada4.getText();

    }

    /**
     * Metodo que obtiene las coordendas en la forma X,Y y los separa crear
     * variables independientes X y Y
     */
    private void seperarCoordenadas() {
        String puntoX, puntoY;
        String[] separacion;

        obtenerDatos();

        separacion = coordenada1.split(",");
        puntoX = separacion[0];
        puntoY = separacion[1];

        this.coordenada1X = Double.parseDouble(puntoX);
        this.coordenada1Y = Double.parseDouble(puntoY);

        separacion = coordenada2.split(",");
        puntoX = separacion[0];
        puntoY = separacion[1];
        this.coordenada2X = Double.parseDouble(puntoX);
        this.coordenada2Y = Double.parseDouble(puntoY);

        separacion = coordenada3.split(",");
        puntoX = separacion[0];
        puntoY = separacion[1];
        this.coordenada3X = Double.parseDouble(puntoX);
        this.coordenada3Y = Double.parseDouble(puntoY);

        if (figura.equals("Triangulo")) {
            coordenada4 = "0,0";
        }

        separacion = coordenada4.split(",");
        puntoX = separacion[0];
        puntoY = separacion[1];
        this.coordenada4X = Double.parseDouble(puntoX);
        this.coordenada4Y = Double.parseDouble(puntoY);

    }

    /**
     * Metodo que verifica las coordendas de cada una de las figuras
     *
     * @param operacion
     * @return
     */
    private boolean recibirVerificacion(IOperaciones operacion) {
        boolean poderGraficar = false;
        //   seperarCoordenadas();
        switch (figura) {
            case "Cuadrado":
                // operacion = new Cuadrado(coordenada1X, coordenada1Y, coordenada2X, coordenada2Y, coordenada3X, coordenada3Y, coordenada4X, coordenada4Y);
                poderGraficar = ((Cuadrado) operacion).verificarCuadrilatero("Cuadrado");
                if (poderGraficar == true) {
                    poderGraficar = ((Cuadrado) operacion).verificarCoordenadas();
                }
                break;
            case "Rectangulo":
                //  operacion = new Rectangulo(coordenada1X, coordenada1Y, coordenada2X, coordenada2Y, coordenada3X, coordenada3Y, coordenada4X, coordenada4Y);
                poderGraficar = ((Rectangulo) operacion).verificarCuadrilatero("Rectangulo");
                if (poderGraficar == true) {
                    poderGraficar = ((Rectangulo) operacion).verificarCoordenadas();
                }
                break;
            case "Triangulo":
                // operacion = new Triangulo(coordenada1X, coordenada1Y, coordenada2X, coordenada2Y, coordenada3X, coordenada3Y);
                poderGraficar = ((Triangulo) operacion).verificarCoordenadas();
                break;
            default:
                break;
        }
        //validar segun logica del cuadrado
        //System.out.print(poderGraficar);
        return poderGraficar;
    }

    /**
     * Metodo para graficar cada una de las figuras segun correspndan
     */
    private void graficar() {
        String resultados = "";
        double area;
        double perimetro;
        String resultadoMetodo;
        
        /*
            Retorna solo los datos de la segunda figura
            resultadoMetodo = ((FigurasGeometricas) operacion).resultadoOperaciones();
            resultados = resultados + "\nFigura "+(++numeroFigura)+": "+resultadoMetodo;
        */
                
        for (byte i = 0; i < vectorDeFiguras.length; i++) {
            byte numeroFigura = i; 
            if (vectorDeFiguras[i] instanceof Cuadrado) {
                pintarFigura(((Cuadrado) vectorDeFiguras[i]).arrayPuntosEnX(), ((Cuadrado) vectorDeFiguras[i]).arrayPuntosEnY(), ((Cuadrado) vectorDeFiguras[i]).getColor(),"Cuadrado");
                ((Cuadrilatero) vectorDeFiguras[i]).hallarArea();
                ((Cuadrilatero) vectorDeFiguras[i]).hallarPerimetro();
                resultados = resultados + "\nFigura "+(++numeroFigura)+" CUADRADO"+": "+"\nEl area es: " + ((Cuadrado) vectorDeFiguras[i]).getArea() + "\n" + "El perimetro es: " + ((Cuadrado) vectorDeFiguras[i]).getPerimetro();
            } else if (vectorDeFiguras[i] instanceof Rectangulo) {
                pintarFigura(((Rectangulo) vectorDeFiguras[i]).arrayPuntosEnX(), ((Rectangulo) vectorDeFiguras[i]).arrayPuntosEnY(), ((Rectangulo) vectorDeFiguras[i]).getColor(),"Rectangulo");
                ((Rectangulo) vectorDeFiguras[i]).hallarArea();
                ((Rectangulo) vectorDeFiguras[i]).hallarPerimetro();
                resultados = resultados + "\nFigura "+(++numeroFigura)+" RECTANGULO"+": "+"\nEl area es: " + ((Rectangulo) vectorDeFiguras[i]).getArea() + "\n" + "El perimetro es: " + ((Rectangulo) vectorDeFiguras[i]).getPerimetro();
            } else if (vectorDeFiguras[i] instanceof Triangulo) {
                pintarFigura(((Triangulo) vectorDeFiguras[i]).arrayPuntosEnX(), ((Triangulo) vectorDeFiguras[i]).arrayPuntosEnY(), ((Triangulo) vectorDeFiguras[i]).getColor(),"Triangulo");
                ((Triangulo) vectorDeFiguras[i]).hallarPerimetro();
                ((Triangulo) vectorDeFiguras[i]).hallarArea();
                resultados = resultados + "\nFigura "+(++numeroFigura)+" TRIANGULO"+": "+"\nEl area es: " + ((Triangulo) vectorDeFiguras[i]).getArea() + "\n" + "El perimetro es: " + ((Triangulo) vectorDeFiguras[i]).getPerimetro()+"\nTipo de triangulo :"+((Triangulo) vectorDeFiguras[i]).getTipoTriangulo();
            }
            
            resultados = resultados +"\n \n";
        }
        
        taResultados.setText(resultados);
    }

    /**
     * Metodo que pinta la figura en el plano cartesiano
     *
     * @param arrayPuntosEnX array de los puntos en X
     * @param arrayPuntosEnY array de los puntos en Y
     * @param ColorFigura color que se ha seleccionado
     */
    private void pintarFigura(int[] arrayPuntosEnX, int[] arrayPuntosEnY, String ColorFigura , String figura ) {
        Graphics ventana = getGraphics();

        System.out.print(ColorFigura);
        if (ColorFigura.equals("Azul")) {
            ventana.setColor(Color.BLUE);
        } else if (ColorFigura.equals("Verde")) {
            ventana.setColor(Color.GREEN);
        } else if (ColorFigura.equals("Cyan")) {
            ventana.setColor(Color.CYAN);
        } else {
            ventana.setColor(Color.RED);
        }

        switch (figura) {
            case "Cuadrado":
                // ventana.drawPolygon(arrayPuntosEnX, arrayPuntosEnY, 4);
                //fillPolygon Rellena la figura y drawPolygon solo dibuja el contorno
                ventana.drawPolygon(arrayPuntosEnX, arrayPuntosEnY, 4);
                break;
            case "Rectangulo":
                // ventana.drawPolygon(arrayPuntosEnX, arrayPuntosEnY, 4);
                ventana.drawPolygon(arrayPuntosEnX, arrayPuntosEnY, 4);
                break;
            case "Triangulo":
                // ventana.drawPolygon(arrayPuntosEnX, arrayPuntosEnY, 3);
                ventana.drawPolygon(arrayPuntosEnX, arrayPuntosEnY, 3);

                break;
            default:
                break;
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tituloVentana = new javax.swing.JLabel();
        lbSeleccionFigura = new javax.swing.JLabel();
        cbSeleccionFigura = new javax.swing.JComboBox();
        lbSeleccionColor = new javax.swing.JLabel();
        cbSeleccionColor = new javax.swing.JComboBox();
        lbCoordenadas = new javax.swing.JLabel();
        lbNumero1 = new javax.swing.JLabel();
        tfCoordenada1 = new javax.swing.JTextField();
        lbNumero2 = new javax.swing.JLabel();
        tfCoordenada2 = new javax.swing.JTextField();
        tfCoordenada3 = new javax.swing.JTextField();
        tfCoordenada4 = new javax.swing.JTextField();
        lbNumero3 = new javax.swing.JLabel();
        lbNumero4 = new javax.swing.JLabel();
        panelInformacionFiguras = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        taResultados = new javax.swing.JTextArea();
        btGraficar = new javax.swing.JButton();
        btLimpiar = new javax.swing.JButton();
        btAgregar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tituloVentana.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        tituloVentana.setForeground(new java.awt.Color(0, 0, 255));
        tituloVentana.setText("Figuras Geometricas");

        lbSeleccionFigura.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbSeleccionFigura.setText("Seleccione una figura");

        cbSeleccionFigura.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Seleccione una Figura", "Cuadrado", "Rectangulo", "Triangulo", " " }));
        cbSeleccionFigura.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbSeleccionFiguraActionPerformed(evt);
            }
        });

        lbSeleccionColor.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbSeleccionColor.setText("Seleccione un color ");

        cbSeleccionColor.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Rojo", "Verde", "Azul", "Cyan" }));

        lbCoordenadas.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbCoordenadas.setText("Ingrese las coordenadas");

        lbNumero1.setText("1.");

        tfCoordenada1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfCoordenada1ActionPerformed(evt);
            }
        });

        lbNumero2.setText("2.");

        lbNumero3.setText("3.");

        lbNumero4.setText("4.");

        panelInformacionFiguras.setBackground(new java.awt.Color(204, 255, 204));

        taResultados.setColumns(20);
        taResultados.setRows(5);
        jScrollPane1.setViewportView(taResultados);

        javax.swing.GroupLayout panelInformacionFigurasLayout = new javax.swing.GroupLayout(panelInformacionFiguras);
        panelInformacionFiguras.setLayout(panelInformacionFigurasLayout);
        panelInformacionFigurasLayout.setHorizontalGroup(
            panelInformacionFigurasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelInformacionFigurasLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(24, Short.MAX_VALUE))
        );
        panelInformacionFigurasLayout.setVerticalGroup(
            panelInformacionFigurasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelInformacionFigurasLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 168, Short.MAX_VALUE)
                .addContainerGap())
        );

        btGraficar.setText("Graficar ");
        btGraficar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btGraficarActionPerformed(evt);
            }
        });

        btLimpiar.setText("Limpiar");
        btLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btLimpiarActionPerformed(evt);
            }
        });

        btAgregar.setText("Agregar");
        btAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAgregarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(262, 262, 262)
                                .addComponent(tituloVentana))
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(panelInformacionFiguras, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 253, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbSeleccionColor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cbSeleccionColor, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lbCoordenadas)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(lbNumero1)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(tfCoordenada1, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(cbSeleccionFigura, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(lbSeleccionFigura, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btAgregar))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(lbNumero2)
                                            .addComponent(lbNumero3))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(tfCoordenada3, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(tfCoordenada2, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(btLimpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(lbNumero4)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(tfCoordenada4, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(btGraficar)))
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tituloVentana)
                .addGap(12, 12, 12)
                .addComponent(lbSeleccionFigura)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbSeleccionFigura, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btAgregar))
                .addGap(18, 18, 18)
                .addComponent(lbSeleccionColor)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbSeleccionColor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(58, 58, 58)
                .addComponent(lbCoordenadas)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbNumero1)
                    .addComponent(tfCoordenada1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbNumero2)
                            .addComponent(tfCoordenada2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btLimpiar)
                        .addGap(6, 6, 6)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfCoordenada3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbNumero3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbNumero4)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(tfCoordenada4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btGraficar)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelInformacionFiguras, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Metodo para seleccionar el tipo de figura y cambiar la visibilidad del
     * panel al graficar
     *
     * @param evt
     */
    private void cbSeleccionFiguraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbSeleccionFiguraActionPerformed
        // TODO add your handling code here:
        String figura2 = cbSeleccionFigura.getSelectedItem().toString();
        switch (figura2) {
            case "Seleccione una Figura":
                lbCoordenadas.setVisible(false);
                lbNumero1.setVisible(false);
                lbNumero2.setVisible(false);
                lbNumero3.setVisible(false);
                lbNumero4.setVisible(false);
                tfCoordenada1.setVisible(false);
                tfCoordenada2.setVisible(false);
                tfCoordenada3.setVisible(false);
                tfCoordenada4.setVisible(false);
                taResultados.setVisible(false);
                panelInformacionFiguras.setVisible(false);
                btGraficar.setVisible(false);
                btLimpiar.setVisible(false);
                JOptionPane.showMessageDialog(this, "Por favor seleccione una figura", "Error!", JOptionPane.WARNING_MESSAGE);
                break;
            case "Cuadrado":
                lbCoordenadas.setVisible(true);
                lbNumero1.setVisible(true);
                lbNumero2.setVisible(true);
                lbNumero3.setVisible(true);
                lbNumero4.setVisible(true);
                tfCoordenada1.setVisible(true);
                tfCoordenada2.setVisible(true);
                tfCoordenada3.setVisible(true);
                tfCoordenada4.setVisible(true);
                taResultados.setVisible(true);
                taResultados.setEditable(false);
                btGraficar.setVisible(false);
                panelInformacionFiguras.setVisible(true);
                break;
            case "Rectangulo":
                lbCoordenadas.setVisible(true);
                lbNumero1.setVisible(true);
                lbNumero2.setVisible(true);
                lbNumero3.setVisible(true);
                lbNumero4.setVisible(true);
                tfCoordenada1.setVisible(true);
                tfCoordenada2.setVisible(true);
                tfCoordenada3.setVisible(true);
                tfCoordenada4.setVisible(true);
                taResultados.setVisible(true);
                taResultados.setEditable(false);
                btGraficar.setVisible(false);
                panelInformacionFiguras.setVisible(true);
                break;
            case "Triangulo":
                lbCoordenadas.setVisible(true);
                lbNumero1.setVisible(true);
                lbNumero2.setVisible(true);
                lbNumero3.setVisible(true);
                lbNumero4.setVisible(false);
                tfCoordenada1.setVisible(true);
                tfCoordenada2.setVisible(true);
                tfCoordenada3.setVisible(true);
                tfCoordenada4.setVisible(false);
                taResultados.setVisible(true);
                taResultados.setEditable(false);
                btGraficar.setVisible(false);
                panelInformacionFiguras.setVisible(true);
                break;
            default:
                break;
        }
    }//GEN-LAST:event_cbSeleccionFiguraActionPerformed

    /**
     * Metodo que llama al metodo graficar
     *
     * @param evt
     */
    private void btGraficarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btGraficarActionPerformed
        // TODO add your handling code here:
        //obtenerDatos();
        // seperarCoordenadas();
        // recibirVerificacion();
        graficar();

    }//GEN-LAST:event_btGraficarActionPerformed

    private void tfCoordenada1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfCoordenada1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfCoordenada1ActionPerformed
    /**
     * Metodo que limpia la ventana
     *
     * @param evt
     */
    private void btLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btLimpiarActionPerformed
        Graphics ventana = getGraphics();
        super.paint(ventana);
        ventana.drawLine(450, 80, 450, 500);
        ventana.drawLine(250, 290, 650, 290);
        for (int i = 251; i < 650; i += 10) {
            ventana.drawLine(i, 285, i, 295);
        }
        for (int i = 79; i < 500; i += 10) {
            ventana.drawLine(445, i, 455, i);
        }

        numeroFiguraAgregadas = 0;
        for (int i = 0; i < vectorDeFiguras.length; i++) {
            vectorDeFiguras[i] = null;
        }
        
        lbCoordenadas.setVisible(false);
        lbNumero1.setVisible(false);
        lbNumero2.setVisible(false);
        lbNumero3.setVisible(false);
        lbNumero4.setVisible(false);
        tfCoordenada1.setVisible(false);
        tfCoordenada2.setVisible(false);
        tfCoordenada3.setVisible(false);
        tfCoordenada4.setVisible(false);
        taResultados.setVisible(false);
        tfCoordenada1.setText(null);
        tfCoordenada2.setText(null);
        tfCoordenada3.setText(null);
        tfCoordenada4.setText(null);
        panelInformacionFiguras.setVisible(false);
        btGraficar.setVisible(false);
        btLimpiar.setVisible(false);
    }//GEN-LAST:event_btLimpiarActionPerformed

    /**
     * Metodo que llena el vector segun la cantidad de clic que se hagan por el
     * evento
     *
     * @param evt
     */
    private void btAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAgregarActionPerformed
        boolean verificacion;
        String figura2 = cbSeleccionFigura.getSelectedItem().toString();
        seperarCoordenadas();
        if (numeroFiguraAgregadas == 1) {
           btGraficar.setVisible(true);
           btLimpiar.setVisible(true);  
        }
        
        if (numeroFiguraAgregadas < tamanoVectorFiguras) {
            switch (figura2) {
                case "Seleccione una Figura":
                    JOptionPane.showMessageDialog(this, "Por favor seleccione una figura", "Error!", JOptionPane.WARNING_MESSAGE);
                    break;
                case "Cuadrado":
                    operacion = new Cuadrado(coordenada1X, coordenada1Y, coordenada2X, coordenada2Y, coordenada3X, coordenada3Y, coordenada4X, coordenada4Y);
                    verificacion = recibirVerificacion(operacion);
                    if (verificacion == true) {
                        ((Cuadrado) operacion).setColor(color);
                        vectorDeFiguras[numeroFiguraAgregadas] = ((Cuadrado) operacion);
                        numeroFiguraAgregadas++;
                        JOptionPane.showMessageDialog(this, "Se agrego figura correctamente", "Agregada", JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(this, "Las coordenadas son incorrectas", "Error!", JOptionPane.ERROR_MESSAGE);
                    }
                    break;
                case "Rectangulo":
                    operacion = new Rectangulo(coordenada1X, coordenada1Y, coordenada2X, coordenada2Y, coordenada3X, coordenada3Y, coordenada4X, coordenada4Y);
                    verificacion = recibirVerificacion(operacion);
                    if (verificacion == true) {
                        ((Rectangulo) operacion).setColor(color);
                        vectorDeFiguras[numeroFiguraAgregadas] = ((Rectangulo) operacion);
                        numeroFiguraAgregadas++;
                        JOptionPane.showMessageDialog(this, "Se agrego figura correctamente", "Agregada", JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(this, "Las coordenadas son incorrectas", "Error!", JOptionPane.ERROR_MESSAGE);
                    }
                    break;
                case "Triangulo":
                    operacion = new Triangulo(coordenada1X, coordenada1Y, coordenada2X, coordenada2Y, coordenada3X, coordenada3Y);
                    verificacion = recibirVerificacion(operacion);
                    if (verificacion == true) {
                        ((Triangulo) operacion).setColor(color);
                        vectorDeFiguras[numeroFiguraAgregadas] = ((Triangulo) operacion);
                        numeroFiguraAgregadas++;
                        JOptionPane.showMessageDialog(this, "Se agrego figura correctamente", "Agregada", JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(this, "Las coordenadas son incorrectas", "Error!", JOptionPane.ERROR_MESSAGE);
                    }
                    break;
                default:
                    break;
            }
        } else {
            JOptionPane.showMessageDialog(this, "No puede agregar mas figuras", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_btAgregarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Ventana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Ventana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Ventana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Ventana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        /**
         * Metodo que crea y muestra el formulario
         */

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Ventana().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btAgregar;
    private javax.swing.JButton btGraficar;
    private javax.swing.JButton btLimpiar;
    private javax.swing.JComboBox cbSeleccionColor;
    private javax.swing.JComboBox cbSeleccionFigura;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbCoordenadas;
    private javax.swing.JLabel lbNumero1;
    private javax.swing.JLabel lbNumero2;
    private javax.swing.JLabel lbNumero3;
    private javax.swing.JLabel lbNumero4;
    private javax.swing.JLabel lbSeleccionColor;
    private javax.swing.JLabel lbSeleccionFigura;
    private javax.swing.JPanel panelInformacionFiguras;
    private javax.swing.JTextArea taResultados;
    private javax.swing.JTextField tfCoordenada1;
    private javax.swing.JTextField tfCoordenada2;
    private javax.swing.JTextField tfCoordenada3;
    private javax.swing.JTextField tfCoordenada4;
    private javax.swing.JLabel tituloVentana;
    // End of variables declaration//GEN-END:variables
}
