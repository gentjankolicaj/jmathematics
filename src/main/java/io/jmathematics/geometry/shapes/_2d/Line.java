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
public class Line extends Shape2D {

  private ShapeInfo shapeInfo;

  private Point pointA;
  private Point pointB;

  private double a;
  private double b;

  private double length;

  public Line(Point pointA, Point pointB) {
    super();
    this.pointA = pointA;
    this.pointB = pointB;
    this.shapeInfo = ShapeInfo.POINT;
  }

  public Line(double a, double b) {
    super();
    this.a = a;
    this.b = b;
    this.shapeInfo = ShapeInfo.SIDE_MEASURE;
  }

  public Line(double length) {
    super();
    this.length = length;
    this.shapeInfo = ShapeInfo.COMMON_MEASURE;
  }


  @Override
  public Map<DetailType, Object> getDetails() {
    Double[] measures = {Double.valueOf(a), Double.valueOf(b)};
    Point[] points = {pointA, pointB};
    Map<DetailType, Object> map = new HashMap<>();
    map.put(DetailType.POINT, points);
    map.put(DetailType.COMMON_MEASURE, measures);
    return map;
  }

  public ShapeInfo getShapeInfo() {
    return shapeInfo;
  }


}
