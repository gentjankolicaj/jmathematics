package io.jmathematics.modular;


import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class CommonResidueTest {

  @Test
  void convert() {
    assertThat(CommonResidue.convert(-1, 220)).isEqualTo(219);
    assertThat(CommonResidue.convert(-356, 2017)).isEqualTo(1661);
  }

  @Test
  void mod() {
    assertThat(CommonResidue.mod(-1, 220)).isEqualTo(219);
    assertThat(CommonResidue.mod(-356, 2017)).isEqualTo(1661);
    assertThat(CommonResidue.mod(-77761, 1247290)).isEqualTo(1169529);
  }
}