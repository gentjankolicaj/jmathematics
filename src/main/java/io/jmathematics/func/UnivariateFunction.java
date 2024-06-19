package io.jmathematics.func;

import io.jmathematics.Function;
import io.jmathematics.exception.FunctionException;

public interface UnivariateFunction extends Function {

  double value(double x) throws FunctionException;

}
