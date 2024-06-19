package io.jmathematics.algebra;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author gentjan kolicaj
 */
@Getter
@Setter
@ToString
public class Point {

  private Dimension dimension;
  private double x;
  private double y;
  private double z;
  private double w;

  public Point() {
    super();
    this.dimension = Dimension.D0;
  }

  public Point(double x) {
    super();
    this.x = x;
    this.dimension = Dimension.D1;
  }

  public Point(double x, double y) {
    super();
    this.x = x;
    this.y = y;
    this.dimension = Dimension.D2;
  }

  public Point(double x, double y, double z) {
    super();
    this.x = x;
    this.y = y;
    this.z = z;
    this.dimension = Dimension.D3;
  }

  public Point(double x, double y, double z, double w) {
    super();
    this.x = x;
    this.y = y;
    this.z = z;
    this.w = w;
    this.dimension = Dimension.D4;
  }


}
