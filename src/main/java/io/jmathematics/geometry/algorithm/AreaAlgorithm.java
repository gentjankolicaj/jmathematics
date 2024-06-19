package io.jmathematics.geometry.algorithm;

import io.jmathematics.Algorithm;
import io.jmathematics.algebra.ShapeInfo;
import io.jmathematics.algorithm.Heron;
import io.jmathematics.exception.AreaException;
import io.jmathematics.exception.ShapeException;
import io.jmathematics.geometry.shapes._2d.Circle;
import io.jmathematics.geometry.shapes._2d.Hexagram;
import io.jmathematics.geometry.shapes._2d.Line;
import io.jmathematics.geometry.shapes._2d.Parallelogram;
import io.jmathematics.geometry.shapes._2d.Pentagram;
import io.jmathematics.geometry.shapes._2d.Rectangle;
import io.jmathematics.geometry.shapes._2d.Shape2D;
import io.jmathematics.geometry.shapes._2d.Square;
import io.jmathematics.geometry.shapes._2d.Trapezoid;
import io.jmathematics.geometry.shapes._2d.Triangle;
import io.jmathematics.utils.DistanceUtils;

/**
 * @author gentjan kolicaj
 */
public class AreaAlgorithm implements Algorithm {

  private AreaAlgorithm() {
  }


  public static double apply(Shape2D t) throws RuntimeException {
    if (t instanceof Line) {
      return 0.0;
    } else if (t instanceof Triangle) {
      Triangle tr = (Triangle) t;
      if (tr.getShapeInfo().equals(ShapeInfo.COMMON_MEASURE)) {
        return tr.getBase() * tr.getHeight() / 2;

      } else if (tr.getShapeInfo().equals(ShapeInfo.SIDE_MEASURE)) {
        return Heron.triangleArea(tr.getSide1(), tr.getSide2(), tr.getSide3());

      } else {
        double s1 = DistanceUtils.distance(tr.getPointA(), tr.getPointB());
        double s2 = DistanceUtils.distance(tr.getPointB(), tr.getPointC());
        double s3 = DistanceUtils.distance(tr.getPointC(), tr.getPointA());
        return Heron.triangleArea(s1, s2, s3);

      }
    } else if (t instanceof Square) {
      Square s = (Square) t;
      if (s.getShapeInfo().equals(ShapeInfo.COMMON_MEASURE)) {
        return s.getBase() * s.getBase();
      } else {
        double s1 = DistanceUtils.distance(s.getPointA(), s.getPointB());
        return s1 * s1;
      }
    } else if (t instanceof Rectangle) {
      Rectangle r = (Rectangle) t;
      if (r.getShapeInfo().equals(ShapeInfo.COMMON_MEASURE)) {
        return r.getLength() + r.getWidth();
      } else {
        throw new AreaException(
            "For rectangle shapes,only formula with base x height is implemented.");
      }

    } else if (t instanceof Parallelogram) {
      Parallelogram p = (Parallelogram) t;
      if (p.getShapeInfo().equals(ShapeInfo.COMMON_MEASURE)) {
        return p.getBase() * p.getHeight();
      } else {
        throw new AreaException(
            "For parallelogram shapes,only formula with base x height is implemented.");
      }

    } else if (t instanceof Trapezoid) {
      Trapezoid tp = (Trapezoid) t;
      if (tp.getShapeInfo().equals(ShapeInfo.COMMON_MEASURE)) {
        double avgBase = (tp.getBase1() + tp.getBase2()) / 2;
        return avgBase * tp.getHeight();
      } else {
        throw new AreaException(
            "For trapezoid shapes,only formula with 1/2(base1 x base2) x height is implemented.");
      }

    } else if (t instanceof Pentagram) {
      throw new AreaException(
          "For Pentagram shapes,the formula for calculating area isn't implemented.");

    } else if (t instanceof Hexagram) {
      throw new AreaException(
          "For hexagram shapes,the formula for calculating area isn't implemented.");

    } else if (t instanceof Circle) {
      Circle c = (Circle) t;
      if (c.getShapeInfo().equals(ShapeInfo.COMMON_MEASURE)) {
        return Math.PI * c.getRadius() * c.getRadius();
      } else {
        double radius = DistanceUtils.distance(c.getPointO(), c.getPointA());
        return Math.PI * radius * radius;
      }

    } else {
      throw new ShapeException(
          "Shape unknown : " + t + ".Formula for finding area of this shape not found !!!");
    }

  }

}
