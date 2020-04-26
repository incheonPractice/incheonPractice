import javax.swing.*;
import java.awt.*;

public class imgresize {
    public ImageIcon resize(ImageIcon icon){
            Image a = icon.getImage().getScaledInstance(110, 100, Image.SCALE_SMOOTH);
        return new ImageIcon(a);

        }
    }


