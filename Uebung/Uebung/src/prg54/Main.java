package prg54;

import de.hans.wif.lectures.prog1.support.GraphicsPanel;

public class Main {
  public static void main(String[] args){
    GraphicsPanel graphicsPanel = new GraphicsPanel(600, 300, "Sinus Funktionsplotter");
    SinFunctionPlotter plot = new SinFunctionPlotter(-5, 15, -2, 2, 0.001);
    graphicsPanel.addGraphicObject(plot);
  }
}
