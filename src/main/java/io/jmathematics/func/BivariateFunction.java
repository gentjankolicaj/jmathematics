package io.jmathematics.func;

import io.jmathematics.Function;
import io.jmathematics.exception.FunctionException;

public interface BivariateFunction extends Function {

  double value(double x1, double x2) throws FunctionException;

}
