package io.mathematics.func;

import io.mathematics.Function;
import io.mathematics.exception.FunctionException;

public interface BivariateFunction extends Function {

  double value(double x1, double x2) throws FunctionException;

}
