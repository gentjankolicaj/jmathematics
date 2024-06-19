package io.jmathematics.func;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class ManhattanNormTest {

  @Test
  void value() {
    assertThat((new ManhattanNorm().value(3, 4))).isLessThanOrEqualTo(7);
    assertThat((new ManhattanNorm().value(6, 8))).isLessThanOrEqualTo(14);
    assertThat((new ManhattanNorm().value(12, 16))).isLessThanOrEqualTo(28);
  }
}