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
public class Cone extends Shape3D {

  private ShapeInfo shapeInfo;

  private Point pointO;
  private Point pointA;
  private Point pointH;

  private double radius;
  private double height;

  public Cone(Point pointO, Point pointA, Point pointH) {
    super();
    this.pointO = pointO;
    this.pointA = pointA;
    this.pointH = pointH;
    this.shapeInfo = ShapeInfo.POINT;
  }

  public Cone(double radius, double height) {
    super();
    this.radius = radius;
    this.height = height;
    this.shapeInfo = ShapeInfo.COMMON_MEASURE;
  }


  @Override
  public Map<DetailType, Object> getDetails() {
    Double[] measure = {Double.valueOf(radius), Double.valueOf(height)};
    Point[] points = {pointO, pointA, pointH};
    Map<DetailType, Object> map = new HashMap<>();
    map.put(DetailType.POINT, points);
    map.put(DetailType.COMMON_MEASURE, measure);
    return map;
  }

  @Override
  public ShapeInfo getShapeInfo() {
    return shapeInfo;
  }


}
