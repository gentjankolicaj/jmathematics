package io.jmathematics.func;

import io.jmathematics.Function;
import io.jmathematics.exception.FunctionException;

public interface MultivariateFunction extends Function {

  double value(double... set) throws FunctionException;

}
