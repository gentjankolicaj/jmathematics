package io.jmathematics.func;


import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class FactorialTest {

  @Test
  void calcL() {
    assertThat(Factorial.valueL(5)).isEqualTo(120);
    assertThat(Factorial.valueL(7.0)).isEqualTo(5040);
  }

  @Test
  void calcR() {
    assertThat(Factorial.valueR(5)).isEqualTo(120);
    assertThat(Factorial.valueR(7.0)).isEqualTo(5040);
  }

  @Test
  void value() {
    Factorial factorial = new Factorial();
    assertThat(factorial.value(5)).isEqualTo(120);
    assertThat(factorial.value(7.0)).isEqualTo(5040);
    assertThat(factorial.value(10)).isEqualTo(3628800);
    assertThat(factorial.value(15)).isEqualTo(1.307674368E+12);
  }
}