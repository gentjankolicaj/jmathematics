package io.jmathematics.modular;


import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class ModIntTest {

  @Test
  void residueSystemSize() {
    ModInt mod13 = new ModInt(13);
    assertThat(mod13.residueSystemSize()).isEqualTo(13);
  }

  @Test
  void residueSystem() {
    ModInt mod13 = new ModInt(13);
    assertThat(mod13.residueSystem()).contains(0, 1, 2, 3, 4, 5, 6, 7, 9, 10, 11, 12);
  }

  @Test
  void equivClasses() {
    ModInt mod5 = new ModInt(5);
    int[][] equivClasses = mod5.equivClasses(5);
    assertThat(equivClasses).hasDimensions(5, 5);
    assertThat(equivClasses[0]).contains(-10, -5, 0, 5, 10);
    assertThat(equivClasses[4]).contains(-6, -1, 4, 9, 14);
  }

  @Test
  void isCongruent() {
    ModInt mod13 = new ModInt(13);
    assertThat(mod13.isCongruent(11, 24)).isTrue();
    assertThat(mod13.isCongruent(-2, 11, 24)).isTrue();
    assertThat(mod13.isCongruent(-1, -14)).isTrue();
    ModInt mod5 = new ModInt(5);
    assertThat(mod5.isCongruent(2, -3)).isTrue();
    assertThat(mod5.isCongruent(-8, 7)).isTrue();
    assertThat(mod5.isCongruent(-3, -8)).isTrue();

    assertThat((new ModInt(1247290)).isCongruent(-77761, 1169529)).isTrue();
  }

  @Test
  void add() {
    ModInt mod13 = new ModInt(13);
    assertThat(mod13.add(6, 6)).isEqualTo(12);
    assertThat(mod13.add(6, 7)).isZero();
    assertThat(mod13.add(7, 7)).isEqualTo(1);
    assertThat(mod13.add(-2, 11, 24)).isEqualTo(7);
  }

  @Test
  void sub() {
    ModInt mod13 = new ModInt(13);
    assertThat(mod13.sub(6, 6)).isZero();
    assertThat(mod13.sub(6, 7)).isEqualTo(-1);
    assertThat(mod13.sub(7, 7)).isZero();
    assertThat(mod13.sub(-2, 11, 24)).isEqualTo(-7);
  }

  @Test
  void mul() {
    ModInt mod13 = new ModInt(13);
    assertThat(mod13.mul(6, 6)).isEqualTo(10);
    assertThat(mod13.mul(6, 7)).isEqualTo(3);
    assertThat(mod13.mul(7, 7)).isEqualTo(10);
    assertThat(mod13.mul(-2, 11, 24)).isEqualTo(-8);
  }

  @Test
  void pos() {
    ModInt mod13 = new ModInt(13);
    assertThat(mod13.pos(-12)).isEqualTo(1);
    assertThat(mod13.pos(-2)).isEqualTo(11);
  }

  @Test
  void mod() {
    ModInt mod13 = new ModInt(13);
    assertThat(mod13.mod(-2)).isEqualTo(-2);
    assertThat(mod13.mod(-12)).isEqualTo(-12);
  }

  @Test
  void commonResidue() {
    ModInt mod13 = new ModInt(13);
    assertThat(mod13.commonResidue(-168)).isEqualTo(1);
    assertThat(mod13.commonResidue(-40)).isEqualTo(12);
  }


}