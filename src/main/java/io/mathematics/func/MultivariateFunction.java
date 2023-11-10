package io.mathematics.func;

import io.mathematics.Function;
import io.mathematics.exception.FunctionException;

public interface MultivariateFunction extends Function {

  double value(double... set) throws FunctionException;

}
