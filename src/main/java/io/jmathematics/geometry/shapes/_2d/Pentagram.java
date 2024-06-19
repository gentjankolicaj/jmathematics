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
public class Pentagram extends Shape2D {

  private ShapeInfo shapeInfo;

  private Point pointA;
  private Point pointB;
  private Point pointC;
  private Point pointD;
  private Point pointE;

  private double side1;
  private double side2;
  private double side3;
  private double side4;
  private double side5;

  public Pentagram(Point pointA, Point pointB, Point pointC, Point pointD, Point pointE) {
    super();
    this.pointA = pointA;
    this.pointB = pointB;
    this.pointC = pointC;
    this.pointD = pointD;
    this.pointE = pointE;
    this.shapeInfo = ShapeInfo.POINT;
  }

  public Pentagram(double side1, double side2, double side3, double side4, double side5) {
    super();
    this.side1 = side1;
    this.side2 = side2;
    this.side3 = side3;
    this.side4 = side4;
    this.side5 = side5;
    this.shapeInfo = ShapeInfo.SIDE_MEASURE;
  }

  @Override
  public Map<DetailType, Object> getDetails() {
    Double[] sideMeasure = {Double.valueOf(side1), Double.valueOf(side2), Double.valueOf(side3),
        Double.valueOf(side4),
        Double.valueOf(side5)};
    Point[] points = {pointA, pointB, pointC, pointD, pointE};
    Map<DetailType, Object> map = new HashMap<>();
    map.put(DetailType.POINT, points);
    map.put(DetailType.SIDE_MEASURE, sideMeasure);
    return map;
  }

  public ShapeInfo getShapeInfo() {
    return shapeInfo;
  }


}
