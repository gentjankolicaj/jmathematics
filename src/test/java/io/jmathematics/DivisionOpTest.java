package io.jmathematics;

import static org.assertj.core.api.Assertions.assertThat;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class DivisionOpTest {

  @Test
  void floor() {
    Assertions.assertThat(DivisionOp.floor(-7, 5)).isEqualTo(3);
    assertThat(DivisionOp.floor(-7L, 5L)).isEqualTo(3L);
    assertThat(DivisionOp.floor(7, 5)).isEqualTo(2);
    assertThat(DivisionOp.floor(7L, 5L)).isEqualTo(2L);
  }

  @Test
  void truncate() {
    assertThat(DivisionOp.truncate(-7, 5)).isEqualTo(-2);
    assertThat(DivisionOp.truncate(-7L, 5L)).isEqualTo(-2L);
    assertThat(DivisionOp.truncate(7, 5)).isEqualTo(-3);
    assertThat(DivisionOp.truncate(7L, 5L)).isEqualTo(-3L);
  }

}