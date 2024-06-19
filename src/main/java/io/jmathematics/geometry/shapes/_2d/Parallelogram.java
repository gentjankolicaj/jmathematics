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
public class Parallelogram extends Shape2D {

  private ShapeInfo shapeInfo;

  private Point pointA;
  private Point pointB;
  private Point pointC;
  private Point pointD;

  private double height;
  private double base;

  public Parallelogram(Point pointA, Point pointB, Point pointC, Point pointD) {
    super();
    this.pointA = pointA;
    this.pointB = pointB;
    this.pointC = pointC;
    this.pointD = pointD;
    this.shapeInfo = ShapeInfo.POINT;
  }

  public Parallelogram(double height, double base) {
    super();
    this.height = height;
    this.base = base;
    this.shapeInfo = ShapeInfo.COMMON_MEASURE;
  }


  @Override
  public Map<DetailType, Object> getDetails() {
    Double[] commonMeasure = {Double.valueOf(height), Double.valueOf(base)};
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
