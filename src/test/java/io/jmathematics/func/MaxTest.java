package io.jmathematics.func;


import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import io.jmathematics.exception.FunctionException;
import org.junit.jupiter.api.Test;

public class MaxTest {

  @Test
  void value() {
    Max max = new Max();
    assertThatThrownBy(() -> max.value(new double[0])).isInstanceOf(FunctionException.class);
    assertThat(max.value(1.0, -0.1)).isEqualTo(1.0);
    assertThat(max.value(1.0, 0.9991)).isEqualTo(1.0);
    assertThat(max.value(0.0001, 0.111, -0.0001, -0.1)).isEqualTo(0.111);
  }


}