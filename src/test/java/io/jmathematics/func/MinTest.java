package io.jmathematics.func;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import io.jmathematics.exception.FunctionException;
import org.junit.jupiter.api.Test;

public class MinTest {


  @Test
  void value() {
    Min min = new Min();
    assertThatThrownBy(() -> min.value(new double[0])).isInstanceOf(FunctionException.class);
    assertThat(min.value(1.0, -0.1)).isEqualTo(-0.1);
    assertThat(min.value(1.0, 0.9991)).isEqualTo(0.9991);
    assertThat(min.value(0.0001, 0.111, -0.0001, -0.1)).isEqualTo(-0.1);
  }

}