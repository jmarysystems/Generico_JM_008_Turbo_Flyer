/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package turbo_flyer;

import turbo_flyer_imagens.Imagens_EmailZap;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 *
 * @author NewUser
 */
public class ImagePanel extends JPanel {

    private Image image;

    public ImagePanel() {

        ImageIcon icon = new ImageIcon( Imagens_EmailZap.class.getResource("fundo.png") );
        image = icon.getImage();
    }
 
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g.create();
        g2d.drawImage(image, 0, 0, this.getWidth(), this.getHeight(), null);
        g2d.dispose();
    }
}
