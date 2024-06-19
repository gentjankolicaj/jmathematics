package io.jmathematics.algorithm;


import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class EulerTest {

  @Test
  void totGCD() {
    assertThat(Euler.totGCD(1)).isEqualTo(1);
    assertThat(Euler.totGCD(2)).isEqualTo(1);
    assertThat(Euler.totGCD(3)).isEqualTo(2);
    assertThat(Euler.totGCD(4)).isEqualTo(2);
    assertThat(Euler.totGCD(5)).isEqualTo(4);
    assertThat(Euler.totGCD(6)).isEqualTo(2);
    assertThat(Euler.totGCD(7)).isEqualTo(6);
    assertThat(Euler.totGCD(8)).isEqualTo(4);
    assertThat(Euler.totGCD(9)).isEqualTo(6);
    assertThat(Euler.totGCD(10)).isEqualTo(4);
    assertThat(Euler.totGCD(21)).isEqualTo(12);
  }

  @Test
  void tot() {
    assertThat(Euler.tot(1)).isEqualTo(1);
    assertThat(Euler.tot(2)).isEqualTo(1);
    assertThat(Euler.tot(3)).isEqualTo(2);
    assertThat(Euler.tot(4)).isEqualTo(2);
    assertThat(Euler.tot(5)).isEqualTo(4);
    assertThat(Euler.tot(6)).isEqualTo(2);
    assertThat(Euler.tot(7)).isEqualTo(6);
    assertThat(Euler.tot(8)).isEqualTo(4);
    assertThat(Euler.tot(9)).isEqualTo(6);
    assertThat(Euler.tot(10)).isEqualTo(4);
    assertThat(Euler.tot(21)).isEqualTo(12);
  }
}