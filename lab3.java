import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class lab3 {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Color Selector");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setLayout(new BorderLayout());

        JPanel panel = new JPanel();
        String[] colors = {"Red", "Blue", "Green"};
        JComboBox<String> colorDropdown = new JComboBox<>(colors);
        JLabel outputLabel = new JLabel("Selected Color: None");
        CirclePanel circle = new CirclePanel();

        colorDropdown.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedColor = (String) colorDropdown.getSelectedItem();
                outputLabel.setText("Selected Color: " + selectedColor);
                switch (selectedColor) {
                    case "Red" -> circle.setColor(Color.RED);
                    case "Blue" -> circle.setColor(Color.BLUE);
                    case "Green" -> circle.setColor(Color.GREEN);
                }
            }
        });

        panel.add(new JLabel("Choose a color:"));
        panel.add(colorDropdown);
        panel.add(outputLabel);
        frame.add(panel, BorderLayout.SOUTH);
        frame.add(circle, BorderLayout.CENTER);

        frame.setVisible(true);
    }
}

class CirclePanel extends JPanel {
    private Color color = null;

    public void setColor(Color color) {
        this.color = color;
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(color != null ? color : getBackground());
        g.fillOval(100, 50, 200, 200);
    }
}
