package io.jmathematics.algorithm;


import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import io.jmathematics.exception.OperationException;
import io.jmathematics.modular.ModInt;
import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

@Slf4j
class ExtendedEuclideanAlgorithmTest {


  @Test
  void bezoutCoefficients() {
    long[] bezoutCoefficients = ExtendedEuclideanAlgorithm.bezoutCoefficients(240, 46);
    assertThat(bezoutCoefficients[0]).isEqualTo(23);
    assertThat(bezoutCoefficients[1]).isEqualTo(-120);
  }


  @Test
  void mulInverse() {
    assertThat(ExtendedEuclideanAlgorithm.mulInv(2000, 2017)).isEqualTo(1661);
    assertThat(ExtendedEuclideanAlgorithm.mulInv(14019, 1247290)).isEqualTo(1169529);
    assertThat(ExtendedEuclideanAlgorithm.mulInv(219, 220)).isEqualTo(219);
    assertThatThrownBy(() -> ExtendedEuclideanAlgorithm.mulInv(240, 46)).isInstanceOf(
        OperationException.class);
    assertThatThrownBy(() -> ExtendedEuclideanAlgorithm.mulInv(22, 30)).isInstanceOf(
        OperationException.class);
    assertThatThrownBy(() -> ExtendedEuclideanAlgorithm.mulInv(30, 22)).isInstanceOf(
        OperationException.class);

    assertThat(ExtendedEuclideanAlgorithm.mulInv(2000L, 2017L)).isEqualTo(1661L);
    assertThat(ExtendedEuclideanAlgorithm.mulInv(14019L, 1247290L)).isEqualTo(1169529L);
    assertThat(ExtendedEuclideanAlgorithm.mulInv(219L, 220L)).isEqualTo(219L);
    assertThatThrownBy(() -> ExtendedEuclideanAlgorithm.mulInv(240L, 46L)).isInstanceOf(
        OperationException.class);
    assertThatThrownBy(() -> ExtendedEuclideanAlgorithm.mulInv(22L, 30L)).isInstanceOf(
        OperationException.class);
    assertThatThrownBy(() -> ExtendedEuclideanAlgorithm.mulInv(30L, 22L)).isInstanceOf(
        OperationException.class);

  }

  @Test
  void multiplyWithMulInverse() {
    Assertions.assertThat((new ModInt(1247290)).mul(1169529, 14019)).isOne();
    assertThat((new ModInt(2017)).mul(1661, 2000)).isOne();
    assertThat((new ModInt(240)).mul(120, 46)).isZero();
    assertThat((new ModInt(220)).mul(219, 219)).isOne();
  }

}