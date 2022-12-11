package prg48to53;

import de.hans.wif.lectures.prog1.support.GraphicsPanel;

import java.awt.*;

public abstract class GeometricObject extends GraphicsPanel.GraphicObject{
  private int x;
  private int y;

  public int getX() {
    return x;
  }

  public void setX(int x) {
    this.x = x;
  }

  public int getY() {
    return y;
  }

  public void setY(int y) {
    this.y = y;
  }
  GeometricObject(int x, int y){
    this.x = x;
    this.y = y;
  }

  public abstract double getArea();
  public abstract double  getCircumference();
  @Override
  public abstract void draw(Graphics g);
}
class Rectangle extends GeometricObject {
  private int width;
  private int height;

  public int getWidth() {
    return width;
  }

  public void setWidth(int width) {
    this.width = width;
  }

  public int getHeight() {
    return height;
  }

  public void setHeight(int height) {
    this.height = height;
  }

  public Rectangle(int x, int y, int width, int height){
    super(x, y);
    this.setHeight(height);
    this.setWidth(width);
  }

  @Override
  public double getArea() {
    return this.getHeight() * this.getWidth();
  }

  @Override
  public double getCircumference() {
    return this.getHeight() * 2 + this.getWidth() * 2;
  }
  @Override
  public void draw(Graphics g){
    g.fillRect(this.getX(), this.getY(), this.getWidth(), this.getHeight());
  }

}
class Circle extends GeometricObject {
  private int radius;
  public int getRadius() {
    return radius;
  }

  public void setRadius(int radius) {
    this.radius = radius;
  }

  public Circle(int x, int y, int radius){
    super(x,y);
    this.radius = radius;
  }
  @Override
  public double getArea(){
    return Math.pow((double)this.getRadius(), 2) * Math.PI;
  }

  @Override
  public double getCircumference(){
    return this.getRadius() * 2 * Math.PI;
  }
  @Override
  public void draw(Graphics g){
    g.fillOval(this.getX(), this.getY(), this.getRadius(), this.getRadius());
  }
}
class PartialCircle extends Circle{

  private int endAngle;
  private int startAngle;

  public int getStartAngle() {
    return startAngle;
  }

  public void setStartAngle(int startAngle) {
    this.startAngle = startAngle;
  }

  public int getEndAngle() {
    return endAngle;
  }

  public void setEndAngle(int endAngle) {
    this.endAngle = endAngle;
  }

  public PartialCircle(int x, int y, int radius, int startAngle, int endAngle) {
    super(x, y, radius);
    this.setStartAngle(startAngle);
    this.setEndAngle(endAngle);
  }
  @Override
  public void draw(Graphics g){
    g.fillArc(this.getX(), this.getY(), this.getRadius(), this.getRadius(), this.getStartAngle(), this.getEndAngle());
  }
}
