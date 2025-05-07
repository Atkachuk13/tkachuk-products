package tkachuk.products;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.net.URL;

public class ProductsDisplayFrame extends JFrame
{
    public ProductsDisplayFrame(URL imageURL, String title, String description)
    {
        setTitle("Product Display");
        setSize(900, 700);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        try
        {
            Image image = ImageIO.read(imageURL);
            ImageIcon icon = new ImageIcon(image.getScaledInstance(400, 400, Image.SCALE_SMOOTH));
            JLabel imageLabel = new JLabel(icon);
            imageLabel.setHorizontalAlignment(JLabel.LEFT);
            panel.add(imageLabel, BorderLayout.WEST);
        } catch (IOException e)
        {
            add(new JLabel("Failed to load."));
        }

        JLabel titleLabel = new JLabel("<html><h2>" + title + "</h2></html>");
        JLabel descriptionLabel = new JLabel("<html><p style='width:300px'>" + description + "</p></html>");

        JPanel textPanel = new JPanel();
        textPanel.setLayout(new BoxLayout(textPanel, BoxLayout.Y_AXIS));
        textPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        textPanel.add(titleLabel);
        textPanel.add(Box.createRigidArea(new Dimension(0, 10))); // Spacing
        textPanel.add(descriptionLabel);

        panel.add(textPanel, BorderLayout.CENTER);

        add(panel);
        setVisible(true);
    }
}
