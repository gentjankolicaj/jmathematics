package io.mathematics.func;

import io.mathematics.Function;
import io.mathematics.exception.FunctionException;

public interface UnivariateFunction extends Function {

  double value(double x) throws FunctionException;

}
