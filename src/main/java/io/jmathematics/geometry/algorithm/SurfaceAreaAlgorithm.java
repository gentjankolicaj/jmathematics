package io.jmathematics.geometry.algorithm;

import io.jmathematics.algebra.ShapeInfo;
import io.jmathematics.algorithm.Pythagoras;
import io.jmathematics.exception.ShapeException;
import io.jmathematics.exception.SurfaceAreaException;
import io.jmathematics.geometry.shapes._3d.Cone;
import io.jmathematics.geometry.shapes._3d.Cube;
import io.jmathematics.geometry.shapes._3d.Cuboid;
import io.jmathematics.geometry.shapes._3d.Cylinder;
import io.jmathematics.geometry.shapes._3d.Ellipsoid;
import io.jmathematics.geometry.shapes._3d.Shape3D;
import io.jmathematics.geometry.shapes._3d.Sphere;
import io.jmathematics.geometry.shapes._3d.SquarePyramid;
import io.jmathematics.utils.DistanceUtils;

/**
 * @author gentjan kolicaj
 */
public class SurfaceAreaAlgorithm {

  public SurfaceAreaAlgorithm() {
  }


  public static double apply(Shape3D t) throws RuntimeException {
    if (t instanceof Cone) {
      Cone c = (Cone) t;
      if (c.getShapeInfo().equals(ShapeInfo.COMMON_MEASURE)) {
        return Math.PI * c.getRadius() * c.getRadius() + Math.PI * c.getRadius()
            * Math.sqrt(c.getRadius() * c.getRadius() + c.getHeight() * c.getHeight());
      } else {
        double r = DistanceUtils.distance(c.getPointO(), c.getPointA());
        double h = DistanceUtils.distance(c.getPointO(), c.getPointH());
        return Math.PI * r * r + Math.PI * r * Math.sqrt(r * r + h * h);
      }
    } else if (t instanceof Cube) {
      Cube c = (Cube) t;
      if (c.getShapeInfo().equals(ShapeInfo.COMMON_MEASURE)) {
        return 6 * c.getSide() * c.getSide();
      } else {
        double side = DistanceUtils.distance(c.getPointA(), c.getPointB());
        return 6 * side * side;
      }
    } else if (t instanceof Cuboid) {
      Cuboid c = (Cuboid) t;
      if (c.getShapeInfo().equals(ShapeInfo.COMMON_MEASURE)) {
        return 2 * (c.getLength() * c.getWidth() + c.getLength() * c.getHeight()
            + c.getWidth() * c.getHeight());
      } else {
        double length = DistanceUtils.distance(c.getPointA(), c.getPointB());
        double width = DistanceUtils.distance(c.getPointB(), c.getPointC());
        double height = DistanceUtils.distance(c.getPointA(), c.getPointE());
        return 2 * (length * width + length * height + width * length);
      }
    } else if (t instanceof Cylinder) {
      Cylinder c = (Cylinder) t;
      if (c.getShapeInfo().equals(ShapeInfo.COMMON_MEASURE)) {
        return 2 * Math.PI * c.getRadius() * c.getHeight()
            + 2 * Math.PI * c.getRadius() * c.getRadius();
      } else {
        double radius = DistanceUtils.distance(c.getPointO(), c.getPointA());
        double height = DistanceUtils.distance(c.getPointO(), c.getPointH());
        return 2 * Math.PI * radius * height + 2 * Math.PI * radius * radius;
      }

    } else if (t instanceof Ellipsoid) {
      throw new SurfaceAreaException(
          "For shapes of type elipsoid formula for calculation of SA not implemented yet !!!");

    } else if (t instanceof SquarePyramid) {
      SquarePyramid s = (SquarePyramid) t;
      if (s.getShapeInfo().equals(ShapeInfo.COMMON_MEASURE)) {
        double baseArea = s.getBaseSideLength() * s.getBaseSideLength();
        double slantHeightOfPyramid = Pythagoras.hypotenuse(s.getBaseSideLength() / 2,
            s.getHeight());
        double basePerimeter = 4 * s.getBaseSideLength();
        return (slantHeightOfPyramid * basePerimeter) / 2 + baseArea;
      } else {
        double baseLength = DistanceUtils.distance(s.getPointO(), s.getPointA());
        double height = DistanceUtils.distance(s.getPointO(), s.getPointH());
        double baseArea = baseLength * baseLength;
        double slantHeightOfPyramid = Pythagoras.hypotenuse(baseLength / 2, height);
        double basePerimeter = 4 * baseLength;
        return (slantHeightOfPyramid * basePerimeter) / 2 + baseArea;
      }

    } else if (t instanceof Sphere) {
      Sphere s = (Sphere) t;
      if (s.getShapeInfo().equals(ShapeInfo.COMMON_MEASURE)) {
        return 4 * Math.PI * s.getRadius() * s.getRadius();
      } else {
        double radius = DistanceUtils.distance(s.getPointO(), s.getPointA());
        return 4 * Math.PI * radius * radius;
      }

    } else {
      throw new ShapeException(
          "Shape unknown : " + t + ".Formula for finding surface area of this shape not found !!!");
    }

  }


}
