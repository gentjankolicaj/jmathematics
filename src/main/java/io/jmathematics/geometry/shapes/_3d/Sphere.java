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
public class Sphere extends Shape3D {

  private ShapeInfo shapeInfo;

  private Point pointO;
  private Point pointA;

  private double radius;

  public Sphere(Point pointO, Point pointA) {
    super();
    this.pointO = pointO;
    this.pointA = pointA;
    this.shapeInfo = ShapeInfo.POINT;
  }

  public Sphere(double radius) {
    super();
    this.radius = radius;
    this.shapeInfo = ShapeInfo.COMMON_MEASURE;
  }

  @Override
  public Map<DetailType, Object> getDetails() {
    Double[] measure = {Double.valueOf(radius)};
    Point[] points = {pointO, pointA};
    Map<DetailType, Object> map = new HashMap<>();
    map.put(DetailType.POINT, points);
    map.put(DetailType.COMMON_MEASURE, measure);
    return map;
  }

  public ShapeInfo getShapeInfo() {
    return shapeInfo;
  }

}
