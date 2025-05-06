package tkachuk.products;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.net.URL;

public class ProductDisplayFrame extends JFrame
{
    public ProductDisplayFrame(URL imageURL)
    {
        setTitle("Product Display");
        setSize(700, 700);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        try
        {
            Image image = ImageIO.read(imageURL);
            ImageIcon icon = new ImageIcon(image.getScaledInstance(400,400, Image.SCALE_SMOOTH));

            JLabel label = new JLabel(icon);
            label.setHorizontalAlignment(JLabel.LEFT);
            add(new JScrollPane(label));
        }
        catch (IOException e)
        {
            add(new JLabel("Failed to load."));
        }

        setVisible(true);
    }
}
