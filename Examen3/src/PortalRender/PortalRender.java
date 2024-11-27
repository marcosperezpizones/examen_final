package PortalRender;

// Importar las clases necesarias
import javax.swing.*; // Para JFrame, JPanel, JLabel, JButton, JTextField, JOptionPane
import java.awt.*; // Para BorderLayout, GridLayout, Color, Graphics
import java.awt.event.*; // Para ActionListener, ActionEvent

public class PortalRender {
    public static void main(String[] args) {
        // Crear la ventana principal
        JFrame frame = new JFrame("Portal de Render (Tu Nombre)");
        frame.setSize(600, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        // Panel para las entradas RGB y botones
        JPanel controlPanel = new JPanel(new GridLayout(4, 2, 5, 5));
        JLabel labelR = new JLabel("R:");
        JTextField textR = new JTextField("255");
        JLabel labelG = new JLabel("G:");
        JTextField textG = new JTextField("255");
        JLabel labelB = new JLabel("B:");
        JTextField textB = new JTextField("255");

        JButton buttonSquare = new JButton("Cuadrado");
        JButton buttonCircle = new JButton("Círculo");

        controlPanel.add(labelR);
        controlPanel.add(textR);
        controlPanel.add(labelG);
        controlPanel.add(textG);
        controlPanel.add(labelB);
        controlPanel.add(textB);
        controlPanel.add(buttonSquare);
        controlPanel.add(buttonCircle);

        // Añadir el panel de control a la parte superior
        frame.add(controlPanel, BorderLayout.NORTH);

        // Canvas para dibujar las figuras
        JPanel canvas = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                setBackground(Color.WHITE);
            }
        };
        frame.add(canvas, BorderLayout.CENTER);

        // Acción para dibujar un cuadrado
        buttonSquare.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int r = Integer.parseInt(textR.getText());
                    int g = Integer.parseInt(textG.getText());
                    int b = Integer.parseInt(textB.getText());

                    Color color = new Color(r, g, b);

                    Graphics graphics = canvas.getGraphics();
                    graphics.setColor(color);
                    graphics.fillRect(100, 100, 200, 200);
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame, "Introduce valores válidos para R, G y B (0-255).");
                }
            }
        });

        // Acción para dibujar un círculo
        buttonCircle.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int r = Integer.parseInt(textR.getText());
                    int g = Integer.parseInt(textG.getText());
                    int b = Integer.parseInt(textB.getText());

                    Color color = new Color(r, g, b);

                    Graphics graphics = canvas.getGraphics();
                    graphics.setColor(color);
                    graphics.fillOval(100, 100, 200, 200);
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame, "Introduce valores válidos para R, G y B (0-255).");
                }
            }
        });

        // Mostrar la ventana
        frame.setVisible(true);
    }
}
