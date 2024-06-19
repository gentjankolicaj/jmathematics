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
public class Rectangle extends Shape2D {

  private ShapeInfo shapeInfo;

  private Point pointA;
  private Point pointB;
  private Point pointC;
  private Point pointD;

  private double length;
  private double width;

  public Rectangle(Point pointA, Point pointB, Point pointC, Point pointD) {
    super();
    this.pointA = pointA;
    this.pointB = pointB;
    this.pointC = pointC;
    this.pointD = pointD;
    this.shapeInfo = ShapeInfo.POINT;
  }

  public Rectangle(double length, double width) {
    super();
    this.length = length;
    this.width = width;
    this.shapeInfo = ShapeInfo.COMMON_MEASURE;
  }

  @Override
  public Map<DetailType, Object> getDetails() {
    Double[] commonMeasure = {Double.valueOf(length), Double.valueOf(width)};
    Point[] points = {pointA, pointB, pointC, pointD};
    Map<DetailType, Object> map = new HashMap<>();
    map.put(DetailType.POINT, points);
    map.put(DetailType.COMMON_MEASURE, commonMeasure);
    return map;
  }

  public ShapeInfo getShapeInfo() {
    return shapeInfo;
  }


}
