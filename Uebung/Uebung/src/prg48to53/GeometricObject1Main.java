package prg48to53;

import de.hans.wif.lectures.prog1.support.GraphicsPanel;

public class GeometricObject1Main {
  public static void main(String[] args) {
    /*Circle c = new Circle(5, 5, 10);
    Rectangle r= new Rectangle(15, 15, 10, 5);

    System.out.println(new StringBuilder(r.toString())
        .append(", area = ").append(r.getArea())
        .append(", circumference = ").append(r.getCircumference())
        .toString()
    );
    System.out.println(new StringBuilder(c.toString())
        .append(", area = ").append(c.getArea())
        .append(", circumference = ").append(c.getCircumference())
        .toString()
    );*/

    GraphicsPanel graphicsPanel = new GraphicsPanel(640, 480, "Übungsblatt 7, Aufgabe 5");
    PartialCircle sun = new PartialCircle(540, -100, 200, 180, 90);
    PartialCircle treeCrown = new PartialCircle(220, 200, 200, 0, 180);
    Circle treeTip = new Circle(283, 170, 75);
    Rectangle treeLog = new Rectangle(295, 300, 50, 400);
    graphicsPanel.addGraphicObject(treeLog);
    graphicsPanel.addGraphicObject(treeTip);
    graphicsPanel.addGraphicObject(treeCrown);
    graphicsPanel.addGraphicObject(sun);

  }


}
