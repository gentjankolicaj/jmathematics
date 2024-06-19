package io.jmathematics.geometry.shapes._2d;

import io.jmathematics.algebra.DetailType;
import io.jmathematics.algebra.Point;
import io.jmathematics.algebra.ShapeInfo;
import java.util.HashMap;
import java.util.Map;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author gentjan kolicaj
 */
@Getter
@Setter
@ToString
public class Trapezoid extends Shape2D {

  private ShapeInfo shapeInfo;

  private Point pointA;
  private Point pointB;
  private Point pointC;
  private Point pointD;

  private double side1;
  private double side2;
  private double side3;
  private double side4;

  private double base1;
  private double base2;
  private double height;

  public Trapezoid(Point pointA, Point pointB, Point pointC, Point pointD) {
    super();
    this.pointA = pointA;
    this.pointB = pointB;
    this.pointC = pointC;
    this.pointD = pointD;
    this.shapeInfo = ShapeInfo.POINT;
  }

  public Trapezoid(double side1, double side2, double side3, double side4) {
    super();
    this.side1 = side1;
    this.side2 = side2;
    this.side3 = side3;
    this.side4 = side4;
    this.shapeInfo = ShapeInfo.SIDE_MEASURE;
  }

  public Trapezoid(double base1, double base2, double height) {
    super();
    this.base1 = base1;
    this.base2 = base2;
    this.height = height;
    this.shapeInfo = ShapeInfo.COMMON_MEASURE;
  }

  @Override
  public Map<DetailType, Object> getDetails() {
    Double[] sideMeasure = {Double.valueOf(side1), Double.valueOf(side2), Double.valueOf(side3),
        Double.valueOf(side4)};
    Double[] commonMeasure = {Double.valueOf(base1), Double.valueOf(base2), Double.valueOf(height)};
    Point[] points = {pointA, pointB, pointC, pointD};
    Map<DetailType, Object> map = new HashMap<>();
    map.put(DetailType.POINT, points);
    map.put(DetailType.SIDE_MEASURE, sideMeasure);
    map.put(DetailType.COMMON_MEASURE, commonMeasure);
    return map;
  }

  public ShapeInfo getShapeInfo() {
    return shapeInfo;
  }


}
