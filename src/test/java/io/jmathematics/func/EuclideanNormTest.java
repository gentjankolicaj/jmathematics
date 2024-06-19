package io.jmathematics.func;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class EuclideanNormTest {

  @Test
  void value() {
    assertThat((new EuclideanNorm().value(3, 4))).isLessThanOrEqualTo(5);
    assertThat((new EuclideanNorm().value(6, 8))).isLessThanOrEqualTo(10);
    assertThat((new EuclideanNorm().value(12, 16))).isLessThanOrEqualTo(20);
  }
}