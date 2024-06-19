package io.jmathematics.geometry.shapes._2d;

import io.jmathematics.algebra.DetailType;
import io.jmathematics.algebra.Point;
import io.jmathematics.algebra.ShapeInfo;
import java.util.HashMap;
import java.util.Map;
import lombok.Getter;
import lombok.Setter;

/**
 * @author gentjan kolicaj
 */
@Getter
@Setter
public class Circle extends Shape2D {

  private ShapeInfo shapeInfo;

  private Point pointA;
  private Point pointO;

  private double radius;

  public Circle(Point pointA, Point pointO) {
    super();
    this.pointA = pointA;
    this.pointO = pointO;
    this.shapeInfo = ShapeInfo.POINT;
  }

  public Circle(double radius) {
    super();
    this.radius = radius;
    this.shapeInfo = ShapeInfo.COMMON_MEASURE;
  }


  @Override
  public Map<DetailType, Object> getDetails() {
    Double[] measure = {Double.valueOf(radius)};
    Point[] points = {pointA, pointO};
    Map<DetailType, Object> map = new HashMap<>();
    map.put(DetailType.POINT, points);
    map.put(DetailType.COMMON_MEASURE, measure);
    return map;
  }

  public ShapeInfo getShapeInfo() {
    return shapeInfo;
  }


}
