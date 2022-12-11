package de.hans.wif.lectures.prog1.support;

import de.hans.wif.lectures.prog1.support.GraphicsPanel.GraphicObject;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.BorderFactory;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.AffineTransform;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.util.List;

/**
 * Graphics Panel
 *
 * Represents a window in which one could draw.
 */
public class GraphicsPanel extends JFrame {

  private DrawingPanel drawingPanel;

  public GraphicsPanel(int width,
                       int height,
                       String title) {

    // parameterize JFrame (the window)
    setTitle(title);
    setSize(width, height);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setResizable(false);

    // create drwaing panel, enable doube buffer
    this.drawingPanel = new DrawingPanel(true);
    this.drawingPanel.setPreferredSize(new Dimension(width, height));
    this.drawingPanel.setBorder(BorderFactory.createLineBorder(Color.RED));
    getContentPane().add(this.drawingPanel, BorderLayout.CENTER);

    // register buttons at the bottom
    JPanel buttonPanel = new JPanel();
    getContentPane().add(buttonPanel, BorderLayout.PAGE_END);

    JButton btnRedraw = new JButton("Redraw");
    btnRedraw.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        drawingPanel.repaint();
      }
    });
    buttonPanel.add(btnRedraw);

    pack();
    setVisible(true);
  }

  public GraphicsPanel addGraphicObject(final GraphicObject graphicObject) {
    assert graphicObject != null : "Parameter may not be null!";
    graphicObject.setContainer(this.drawingPanel);              // set container
    this.drawingPanel.getGraphicObjects().add(graphicObject);   // add to drawing queue

    return this;
  }

  public void removeGraphicObject(final GraphicObject graphicObject) {
    assert graphicObject != null : "Parameter may not be null!";
    this.drawingPanel.getGraphicObjects().remove(graphicObject);
  }

  /**
   * Root class for the drawable object hierarchy
   */
  public static abstract class GraphicObject {

    private Sizeable container;

    void setContainer(final Sizeable container) {
      this.container = container;
    }

    public abstract void draw(Graphics g);

    public Dimension getSize() {
      return container.getSize();
    }

    public void drawCenteredString(String s, int x, int y, Graphics g) {
      FontMetrics fm = g.getFontMetrics();
      Rectangle2D sBounds = fm.getStringBounds(s, g);

      g.drawString(s,
          x - ((int) (sBounds.getWidth() / 2)),
          y - ((int) (sBounds.getHeight() / 2))
      );
    }
  }

  private static interface Sizeable {
    Dimension getSize();
  }

  private static class DrawingPanel extends JPanel implements Sizeable {
    private ArrayList<GraphicObject> graphicObjects = new ArrayList<GraphicObject>();

    public DrawingPanel(boolean isDoubleBuffered) {
      super(isDoubleBuffered);
    }

    public List<GraphicObject> getGraphicObjects() {
      return this.graphicObjects;
    }

    @Override
    protected void paintComponent(Graphics g) {
      super.paintComponent(g);

      // print out the size of the panel
      System.out.println(
          "size of content pane: " + getSize().width + " X " + getSize().height + " (px)"
      );

      // iterate over all graphic objects and draw them
      for (GraphicObject graphicObject : graphicObjects) {
        graphicObject.draw(g);
      }
    }
  }

  /**
   * Classical board which is divided into cells and which will scale depending on the dimensions of the window.
   */
  public static class Board extends GraphicObject implements Sizeable {

    private GraphicObject board[][];
    private int xCells;
    private int yCells;

    public Board(int xCells, int yCells) {
      this.xCells = xCells;
      this.yCells = yCells;

      this.board = new GraphicObject[xCells][yCells];
    }

    public int getXCells() {
      return xCells;
    }

    public int getYCells() {
      return yCells;
    }

    public <T> T getCell(int x, int y) {
      assert x >= 0 && x < xCells : "x is out of range!";
      assert y >= 0 && y < yCells : "y is out of range!";

      return (T) board[x][y];
    }

    public void setCell(int x, int y, final GraphicObject graphicObject) {
      assert x >= 0 && x < xCells : "x is out of range!";
      assert y >= 0 && y < yCells : "y is out of range!";
      assert graphicObject != null : "graphicsObject may not be null!";

      graphicObject.setContainer(this);

      board[x][y] = graphicObject;
    }

    @Override
    public Dimension getSize() {
      // return the dimension of a cell and not that of the whole board
      return new Dimension(
          super.getSize().width / this.xCells - 2,
          super.getSize().height / this.yCells - 2
      );
    }

    protected void prepareRedraw() {

    }

    @Override
    public void draw(Graphics g) {
      // prepare the redraw of the board
      prepareRedraw();

      // get graphics object for advanced calls ;-)
      Graphics2D graphics2D = (Graphics2D) g;

      int width = super.getSize().width;
      int height = super.getSize().height;

      // determine width and height of each cell
      int cWidth = width / this.xCells;
      int cHeight = height / this.yCells;

      int x = 0;
      int y = 0;

      for (int i = 0; i < xCells; ++i) {
        for (int j = 0; j < yCells; ++j) {
          x = i * cWidth;
          y = j * cHeight;

          g.setColor(Color.BLACK);
          g.drawRect(x, y, cWidth, cHeight);

          if (board[i][j] != null) {
            // save old transformation, need to restore it
            AffineTransform oldTransform = graphics2D.getTransform();

            // create a new transformation and apply it
            AffineTransform newTransform = graphics2D.getTransform();
            newTransform.concatenate(AffineTransform.getTranslateInstance(x + 1, y + 1));
            graphics2D.setTransform(newTransform);

            // draw element
            board[i][j].draw(graphics2D);

            // restore old transformation
            graphics2D.setTransform(oldTransform);
          }
        }
      }
    }
  }

  public static void main(String[] args) {

    Board board = new Board(3, 3);
    board.setCell(1, 1, new GraphicsDemo());

    GraphicsPanel graphicsPanel = new GraphicsPanel(640, 480, "Prog1 Simple Demo");
    graphicsPanel.addGraphicObject(board);
  }
}

class GraphicsDemo extends GraphicObject {

  private int counter = 0;
  private int x;
  private int y;

  @Override
  public void draw(Graphics g) {
    int x = getSize().width / 2;
    int y = getSize().height / 2;

    counter++;

    String text = "Hello, Ansbach! (" + counter + ")";

    g.setColor(Color.GREEN);
    g.drawRect(0, 0, getSize().width, getSize().height);
    drawCenteredString(text, x, y, g);
  }
}

