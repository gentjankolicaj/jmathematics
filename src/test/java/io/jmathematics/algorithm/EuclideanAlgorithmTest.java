package io.jmathematics.algorithm;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class EuclideanAlgorithmTest {

  @Test
  void gcd() {
    assertThat(EuclideanAlgorithm.gcd(12, 24)).isEqualTo(12);
    assertThat(EuclideanAlgorithm.gcd(2017, 1024)).isOne();
    assertThat(EuclideanAlgorithm.gcd(2017L, 1024L)).isOne();
  }
}