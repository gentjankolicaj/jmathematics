package io.mathematics.func;

import io.mathematics.exception.FunctionException;
import org.apache.commons.lang3.ArrayUtils;

public class Max implements BivariateFunction, MultivariateFunction {

  @Override
  public double value(double x1, double x2) throws FunctionException {
    return x1 <= x2 ? x2 : x1;
  }

  @Override
  public double value(double... set) throws FunctionException {
    if (ArrayUtils.isEmpty(set)) {
      throw new FunctionException("Argument array can't be empty.");
    }
    double max = Double.MIN_VALUE;
    for (double x : set) {
      if (x > max) {
        max = x;
      }
    }
    return max;
  }
}
