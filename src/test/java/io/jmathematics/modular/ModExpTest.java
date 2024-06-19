package io.jmathematics.modular;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class ModExpTest {

  @Test
  void multiplyReduce() {
    assertThat(ModExp.multiplyReduce(47, 69, 143)).isEqualTo(125);
    assertThat(ModExp.multiplyReduce(3, 1000, 26)).isEqualTo(3);
    assertThat(ModExp.multiplyReduce(3, 94, 17)).isEqualTo(2);
    assertThat(ModExp.multiplyReduce(40, 110, 37)).isEqualTo(9);
    assertThat(ModExp.multiplyReduce(9, 12345, 9)).isZero();
    assertThat(ModExp.multiplyReduce(12345, 6789, 143)).isEqualTo(125);
  }

  @Test
  void squareMultiply() {
    assertThat(ModExp.squareMultiply(47, 69, 143)).isEqualTo(125);
    assertThat(ModExp.squareMultiply(3, 1000, 26)).isEqualTo(3);
    assertThat(ModExp.squareMultiply(3, 94, 17)).isEqualTo(2);
    assertThat(ModExp.squareMultiply(40, 110, 37)).isEqualTo(9);
    assertThat(ModExp.squareMultiply(9, 12345, 9)).isZero();
    assertThat(ModExp.squareMultiply(12345, 6789, 143)).isEqualTo(125);
  }

}