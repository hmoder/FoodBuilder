import java.awt.Color;
import java.awt.Graphics;
import java.awt.BasicStroke;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import javax.swing.JPanel;

public class DishJPanel extends JPanel {

	public void paintComponent(Graphics g) {
		
		super.paintComponent(g);
		
		// Cast to 2D
		Graphics2D g2d = (Graphics2D) g;
		
		// Draw ellipse
		g2d.setPaint(Color.WHITE);
		g2d.fillOval(133, 16, 250, 250);
		g2d.setPaint(Color.ORANGE);
		g2d.setStroke(new BasicStroke(2.0f));
		g2d.draw(new Ellipse2D.Double(133, 16, 250, 250));
		
		// Draw first line
		g2d.draw(new Line2D.Double(258, 16, 258, 140));
		
		// Draw second line
		g2d.draw(new Line2D.Double(133, 140, 383, 140));
	}
}
