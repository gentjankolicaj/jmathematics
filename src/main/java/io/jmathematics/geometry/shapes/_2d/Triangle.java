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
public class Triangle extends Shape2D {

  private ShapeInfo shapeInfo;

  private Point pointA;
  private Point pointB;
  private Point pointC;

  private double side1;
  private double side2;
  private double side3;

  private double height;
  private double base;

  public Triangle(Point pointA, Point pointB, Point pointC) {
    super();
    this.pointA = pointA;
    this.pointB = pointB;
    this.pointC = pointC;
    this.shapeInfo = ShapeInfo.POINT;
  }

  public Triangle(double side1, double side2, double side3) {
    super();
    this.side1 = side1;
    this.side2 = side2;
    this.side3 = side3;
    this.shapeInfo = ShapeInfo.SIDE_MEASURE;
  }

  public Triangle(double height, double base) {
    super();
    this.height = height;
    this.base = base;
    this.shapeInfo = ShapeInfo.COMMON_MEASURE;
  }

  @Override
  public Map<DetailType, Object> getDetails() {
    Double[] sideMeasure = {Double.valueOf(side1), Double.valueOf(side2), Double.valueOf(side3)};
    Double[] commonMeasure = {Double.valueOf(base), Double.valueOf(height)};
    Point[] points = {pointA, pointB, pointC};
    Map<DetailType, Object> map = new HashMap<>();
    map.put(DetailType.POINT, points);
    map.put(DetailType.COMMON_MEASURE, commonMeasure);
    map.put(DetailType.SIDE_MEASURE, sideMeasure);
    return map;

  }

  public ShapeInfo getShapeInfo() {
    return shapeInfo;
  }

}
