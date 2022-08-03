package clock;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Shape;
import javax.swing.JPanel;


public class Field extends JPanel
{
    private Shape shape;
    private Color fg, bg;

    public Field()
    {
        init();
    }
    
    private void init(){
        this.setOpaque(true);
        this.setBackground(bg);
    }

    public Shape getShape()
    {
        return shape;
    }

    public void setShape(Shape shape)
    {
        this.shape = shape;
    }

    public Color getFg()
    {
        return fg;
    }

    public void setFg(Color fg)
    {
        this.fg = fg;
    }

    public Color getBg()
    {
        return bg;
    }

    public void setBg(Color bg)
    {
        this.bg = bg;
    }
    
    
    
    
    
    
    private Graphics2D g2d;
    
    @Override
    protected void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        g2d = (Graphics2D) g;
        g2d.setPaint(fg);
        g2d.draw(shape);
    }
    
}
