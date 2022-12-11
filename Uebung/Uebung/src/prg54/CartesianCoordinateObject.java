package prg54;

import de.hans.wif.lectures.prog1.support.GraphicsPanel;

import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.geom.Point2D;

public class CartesianCoordinateObject extends GraphicsPanel.GraphicObject {
  private double xMin;
  private double xMax;
  private double yMin;
  private double yMax;

  public double getxMin() {
    return xMin;
  }

  public void setxMin(double xMin) {
    this.xMin = xMin;
  }

  public double getxMax() {
    return xMax;
  }

  public void setxMax(double xMax) {
    this.xMax = xMax;
  }

  public double getyMin() {
    return yMin;
  }

  public void setyMin(double yMin) {
    this.yMin = yMin;
  }

  public double getyMax() {
    return yMax;
  }

  public void setyMax(double yMax) {
    this.yMax = yMax;
  }
  public CartesianCoordinateObject(int xMin, int xMax, int yMin, int yMax){
    this.setxMin(xMin);
    this.setxMax(xMax);
    this.setyMin(yMin);
    this.setyMax(yMax);
  }
  protected Point mapCoordinates(double cartesianX, double cartesianY){

    double rangeX = Math.abs(getxMax() - getxMin());
    double rangeY = Math.abs(getyMax() - getyMin());
    double unitsPerPixelX = getSize().getWidth() / rangeX;
    double unitsPerPixelY = getSize().getHeight() / rangeY;

    AffineTransform transform = AffineTransform.getTranslateInstance(getSize().width /
        2, getSize().height / 2);

    transform.scale(unitsPerPixelX, -unitsPerPixelY);

    transform.translate(-(getxMax() - (rangeX / 2)), -(getyMax() - (rangeY / 2)));

    Point2D ptSrc = new Point2D.Double(cartesianX, cartesianY);
    Point2D ptDst = new Point2D.Double();
    transform.transform(ptSrc, ptDst);

    Point point = new Point();
    point.setLocation(
        ptDst.getX(),
        ptDst.getY()
    );
    return point;
  }
  @Override
  public void draw(Graphics g) {
    Point middle = mapCoordinates(0, 0);
    Point maxX = mapCoordinates(getxMax(), 0);
    Point minX = mapCoordinates(getxMin(), 0);
    Point maxY = mapCoordinates(0, getyMax());
    Point minY = mapCoordinates(0, getyMin());
    int lengthOneStepX = (maxX.x - minX.x) / (int)(getxMax() - getxMin());
    int lengthOneStepY = (minY.y - maxY.y) / (int)(getyMax() - getyMin());
    g.fillRect(minX.x, middle.y, maxX.x - minX.x, 3);
    g.fillRect(middle.x, maxY.y, 3, minY.y - maxY.y);

    for (int x = minX.x; x < maxX.x; x = x + lengthOneStepX){
      g.fillRect(x, middle.y - 5, 3, 13);
    }
    for(int y = maxY.y; y < minY.y; y = y + lengthOneStepY){
      g.fillRect(middle.x - 5, y, 13, 3);
    }
  }
}
class FunctionPlotter extends CartesianCoordinateObject{
  private double xStep;

  public double getxStep() {
    return xStep;
  }

  public void setxStep(double xStep) {
    this.xStep = xStep;
  }

  public FunctionPlotter(int xMin, int xMax, int yMin, int yMax, double xStep) {
    super(xMin, xMax, yMin, yMax);
    this.xStep = xStep;
  }
  @Override
  public void draw(Graphics g){
    super.draw(g);
    for (double x = getxMin(); x < getxMax(); x = x + getxStep()){
      Point point = mapCoordinates(x, computeValue(x));
      g.setColor(Color.red);
      g.fillRect(point.x, point.y, 1, 1);
    }
  }
  protected double computeValue(double x){

    return 1 / x;
  }
}
class SinFunctionPlotter extends FunctionPlotter{

  public SinFunctionPlotter(int xMin, int xMax, int yMin, int yMax, double xStep) {
    super(xMin, xMax, yMin, yMax, xStep);
  }
  @Override
  protected double computeValue(double x){
    return Math.sin(x);
  }
}