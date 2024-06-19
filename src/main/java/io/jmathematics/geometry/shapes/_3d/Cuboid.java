package io.jmathematics.geometry.shapes._3d;

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
public class Cuboid extends Shape3D {

  private ShapeInfo shapeInfo;

  private Point pointA;
  private Point pointB;
  private Point pointC;
  private Point pointE;

  private double length;
  private double width;
  private double height;

  public Cuboid(Point pointA, Point pointB, Point pointC, Point pointE) {
    super();
    this.pointA = pointA;
    this.pointB = pointB;
    this.pointC = pointC;
    this.pointE = pointE;
    this.shapeInfo = ShapeInfo.POINT;
  }

  public Cuboid(double length, double width, double height) {
    super();
    this.length = length;
    this.width = width;
    this.height = height;
    this.shapeInfo = ShapeInfo.COMMON_MEASURE;
  }

  @Override
  public Map<DetailType, Object> getDetails() {
    Double[] measure = {Double.valueOf(length), Double.valueOf(width), Double.valueOf(height)};
    Point[] points = {pointA, pointB, pointC, pointE};
    Map<DetailType, Object> map = new HashMap<>();
    map.put(DetailType.POINT, points);
    map.put(DetailType.COMMON_MEASURE, measure);
    return map;
  }

  public ShapeInfo getShapeInfo() {
    return shapeInfo;
  }

}
