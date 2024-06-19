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
public class Cube extends Shape3D {

  private ShapeInfo shapeInfo;

  private Point pointA;
  private Point pointB;
  private Point pointE;

  private double side;

  public Cube(Point pointA, Point pointB, Point pointE) {
    super();
    this.pointA = pointA;
    this.pointB = pointB;
    this.pointE = pointE;
    this.shapeInfo = ShapeInfo.POINT;
  }

  public Cube(double side) {
    super();
    this.side = side;
    this.shapeInfo = ShapeInfo.COMMON_MEASURE;
  }

  @Override
  public Map<DetailType, Object> getDetails() {
    Double[] measure = {Double.valueOf(side)};
    Point[] points = {pointA, pointB, pointE};
    Map<DetailType, Object> map = new HashMap<>();
    map.put(DetailType.POINT, points);
    map.put(DetailType.COMMON_MEASURE, measure);
    return map;
  }

  public ShapeInfo getShapeInfo() {
    return shapeInfo;
  }


}
