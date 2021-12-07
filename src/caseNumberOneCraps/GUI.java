package PACKAGE_NAME;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.text.AttributeSet;
import java.awt.*;
import java.awt.event.*;

public class GUI PRESENTATION  extends JFrame {
    // Atributos
    private JButton miFoto, miHobby, misExpectativas;
    private Titulos titulo;
    private JPanel panelBotones, panelDatos;
    private Escucha escucha;
    private JLabel labelImage;
    private JTextArea textoExpectativas;

    // Metodos
    public GUI PRESENTATION() {
        initGUI();
        this.setTitle("Mi Presentacion");
        this.setSize(600, 540);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void initGUI() {
        escucha = new Escucha();
        titulo = new Titulos("Hola soy Ervin,oprime los botones...", Color.BLACK);
        this.add(titulo, BorderLayout.NORTH);
        panelDatos = new JPanel();
        panelDatos.addMouseListener(escucha);
        panelDatos.addKeyListener(escucha);
        panelDatos.setFocusable(true);

        panelDatos.setBorder(BorderFactory.createTitledBorder(null, "Un poco mas de mi...",
                TitledBorder.CENTER, TitledBorder.DEFAULT_POSITION,
                new Font("Calibri", Font.PLAIN, 30), Color.BLACK));
        this.add(panelDatos, BorderLayout.CENTER);
        miFoto = new JButton("Este soy yo");
        miFoto.addMouseListener(escucha);
        miHobby = new JButton("Este es mi Hobby");
        miHobby.addMouseListener(escucha);
        misExpectativas = new JButton("Creo que...");
        misExpectativas.addKeyListener(escucha);
        panelBotones = new JPanel();
        panelBotones.add(miFoto);
        panelBotones.add(miHobby);
        panelBotones.add(misExpectativas);
        this.add(panelBotones, BorderLayout.SOUTH);
        labelImage = new JLabel();
        textoExpectativas = new JTextArea(10, 12);
        Font textoExpectativas = new Font("Calibri", 3, 30);

    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                GUI PRESENTATION miGUIPrentacion = new GUI PRESENTATION();
            }
        });
    }

    private class Escucha implements MouseListener, KeyListener {

        private ImageIcon image;

        @Override
        public void mouseClicked(MouseEvent e) {
            panelDatos.removeAll();
            if(e.getSource()==miHobby&&e.getClickCount()==2){

                image= new ImageIcon(getClass().getResource("/recursos/LecturaGusto.png"));
                labelImage.setIcon(image);
                panelDatos.add(labelImage);

            }else{
                if((e.getSource()==miFoto)&&e.getClickCount()==1){
                    image= new ImageIcon(getClass().getResource("/recursos/ErvinCaravali.jpg"));
                    labelImage.setIcon(image);
                    panelDatos.add(labelImage);

                }
            }
            revalidate();

        }

        @Override
        public void mousePressed(MouseEvent e) {



        }


        @Override
        public void mouseReleased(MouseEvent e) {

        }

        @Override
        public void mouseEntered(MouseEvent e) {

        }

        @Override
        public void mouseExited(MouseEvent e) {

        }

        @Override
        public void keyTyped(KeyEvent e) {



        }

        @Override
        public void keyPressed(KeyEvent e) {

            if(e.getKeyCode()==KeyEvent.VK_M) {
                textoExpectativas.setText("no tengo conocimientos amplios en java, me gustaria crear GUI's");
                panelDatos.add(textoExpectativas);

            }
            revalidate();

        }

        @Override
        public void keyReleased(KeyEvent e) {

        }
    }
}



