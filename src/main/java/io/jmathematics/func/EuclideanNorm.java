package io.jmathematics.func;

import io.jmathematics.exception.FunctionException;
import org.apache.commons.lang3.ArrayUtils;

/**
 * Euclidean norm implementation, <a
 * href="https://en.wikipedia.org/wiki/Norm_(mathematics)">link</a>
 */
public class EuclideanNorm implements MultivariateFunction {

  @Override
  public double value(double... set) throws FunctionException {
    if (ArrayUtils.isEmpty(set)) {
      throw new FunctionException("Argument array can't be empty.");
    }
    double sum = 0;
    for (double x : set) {
      sum = sum + x * x;
    }
    return Math.sqrt(sum);
  }
}
