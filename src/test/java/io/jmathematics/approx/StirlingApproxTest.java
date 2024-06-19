package io.jmathematics.approx;

import static org.assertj.core.api.Assertions.assertThat;

import io.jmathematics.func.Factorial;
import org.junit.jupiter.api.Test;

public class StirlingApproxTest {

  @Test
  void ln() {
    double lnFactorial = StirlingApprox.ln(7);
    double factorial = Math.pow(Math.E, lnFactorial);
    assertThat(factorial).isLessThanOrEqualTo(Factorial.valueR(7))
        .isGreaterThan(Factorial.valueR(6));
  }

  @Test
  void lg() {
    //note: if factorial bigger than 12 , testcase fails
    double log2Factorial = StirlingApprox.lg(11);
    double factorial = Math.pow(2, log2Factorial);
    assertThat(factorial).isLessThanOrEqualTo(Factorial.valueR(11))
        .isGreaterThan(Factorial.valueR(10));
  }

  @Test
  void factorial() {
    //note: if factorial bigger than 12 , testcase fails
    double factorial = StirlingApprox.factorial(12);
    assertThat(factorial).isLessThanOrEqualTo(Factorial.valueR(12))
        .isGreaterThan(Factorial.valueR(10));
  }
}