package io.jmathematics.prime;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class PNTTest {

  @Test
  void primes() {
    assertThat(PNT.primes(17)).isLessThanOrEqualTo(7);
    assertThat(PNT.primes(17L)).isLessThanOrEqualTo(7);
    assertThat(PNT.primes(3)).isLessThanOrEqualTo(2);
    assertThat(PNT.primes(2L)).isLessThanOrEqualTo(2);
  }

}