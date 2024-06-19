package io.jmathematics.func;

import io.jmathematics.exception.FunctionException;
import org.apache.commons.lang3.ArrayUtils;

public class Min implements BivariateFunction, MultivariateFunction {

  @Override
  public double value(double x1, double x2) throws FunctionException {
    return x1 <= x2 ? x1 : x2;
  }

  @Override
  public double value(double... set) throws FunctionException {
    if (ArrayUtils.isEmpty(set)) {
      throw new FunctionException("Argument array can't be empty.");
    }
    double min = Double.MAX_VALUE;
    for (double x : set) {
      if (x < min) {
        min = x;
      }
    }
    return min;
  }
}
