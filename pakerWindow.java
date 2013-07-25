
import java.awt.*;
import java.awt.image.BufferStrategy;
import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JComponent;
import java.awt.image.BufferedImage;
import java.awt.Toolkit;
import java.awt.event.KeyListener;
import java.awt.event.KeyListener.*;
import java.awt.event.*;

class pakerWindow extends JFrame implements KeyListener {

    BufferedImage bi;
    BufferStrategy buffer;
    public int x = 10, y = 100;
    public Color c = Color.red;
    gameLogic gl;

    public void keyPressed(KeyEvent k) {
        int c = k.getKeyCode();
        pakermanPlayer p = gl.getPlayer();
        //System.out.println(c);
        switch (c) {
            case KeyEvent.VK_UP:
                gl.setDeltaY(-1);
                p.facing(facing_dirs.UP);
                break;
            case KeyEvent.VK_DOWN:
                gl.setDeltaY(1);
                p.facing(facing_dirs.DOWN);
                break;
            case KeyEvent.VK_LEFT:
                gl.setDeltaX(-1);
                p.facing(facing_dirs.LEFT);
                break;
            case KeyEvent.VK_RIGHT:
                gl.setDeltaX(1);
                p.facing(facing_dirs.RIGHT);
                break;
            case KeyEvent.VK_ESCAPE:
                System.exit(0);
                break;
        }
    }

    public void keyReleased(KeyEvent k) {
    }

    public void keyTyped(KeyEvent k) {
    }

    public void render() {
        Graphics2D g = (Graphics2D) bi.createGraphics();
        g.setColor(Color.black);
        g.fillRect(0, 0, getWidth(), getHeight());
        gl.getPlayer().show(g);
        Graphics2D b = (Graphics2D) buffer.getDrawGraphics();
        b.drawImage(bi, 0, 0, null);
        buffer.show();
        b.dispose();
        g.dispose();
        Toolkit.getDefaultToolkit().sync();
    }

    public pakerWindow(gameLogic gl) {
        this.gl = gl;
        setIgnoreRepaint(true);
        setVisible(true);
        setSize(640, 480);
        JComponent c = (JComponent) getContentPane();
        c.setOpaque(false);
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        GraphicsDevice gd = ge.getDefaultScreenDevice();
        GraphicsConfiguration gc = gd.getDefaultConfiguration();
        Graphics g;
        createBufferStrategy(2);
        buffer = getBufferStrategy();
        bi = gc.createCompatibleImage(getWidth(), getHeight());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        addKeyListener(this);
        gl.start();
    }
}