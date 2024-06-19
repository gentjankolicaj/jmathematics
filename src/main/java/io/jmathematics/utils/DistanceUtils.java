package io.jmathematics.utils;

import io.jmathematics.algebra.Dimension;
import io.jmathematics.algebra.Point;
import io.jmathematics.exception.DimensionException;

/**
 * @author gentjan kolicaj
 */
public class DistanceUtils {

  public static double distance(double x1, double x2) {
    return Math.abs(x2 - x1);
  }

  public static double distance(double x1, double x2, double y1, double y2) {
    double x = x2 - x1;
    double y = y2 - y1;
    return Math.sqrt(x * x + y * y);
  }

  public static double distance(double x1, double x2, double y1, double y2, double z1, double z2) {
    double x = x2 - x1;
    double y = y2 - y1;
    double z = z2 - z1;
    return Math.sqrt(x * x + y * y + z * z);
  }

  public static double distance(double x1, double x2, double y1, double y2, double z1, double z2,
      double w1,
      double w2) {
    double x = x2 - x1;
    double y = y2 - y1;
    double z = z2 - z1;
    double w = w2 - w1;
    return Math.sqrt(x * x + y * y + z * z + w * w);
  }

  public static double distance(Point point1, Point point2) {
    int dimIndex1 = point1.getDimension().getIndex();
    int dimIndex2 = point2.getDimension().getIndex();
    Dimension contextDimension =
        dimIndex1 >= dimIndex2 ? point1.getDimension() : point2.getDimension();

    if (contextDimension.equals(Dimension.D4)) {
      return distance(point1.getX(), point2.getX(), point1.getY(), point2.getY(), point1.getZ(),
          point2.getZ(),
          point1.getW(), point2.getW());

    } else if (contextDimension.equals(Dimension.D3)) {
      return distance(point1.getX(), point2.getX(), point1.getY(), point2.getY(), point1.getZ(),
          point2.getZ());

    } else if (contextDimension.equals(Dimension.D2)) {
      return distance(point1.getX(), point2.getX(), point1.getY(), point2.getY());

    } else if (contextDimension.equals(Dimension.D1)) {
      return distance(point1.getX(), point2.getX());

    } else if (contextDimension.equals(Dimension.D0)) {
      return 0.0;

    } else {
      throw new DimensionException(
          "Dimension unknown.Max dimension supported is 4.If you wish to continue you must implement it.");
    }
  }
}
