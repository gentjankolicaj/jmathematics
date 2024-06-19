package io.jmathematics.modular;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class CRTTest {

  @Test
  void residues() {
    assertThat(CRT.residues(394, new long[]{4, 9, 25})).containsAnyOf(2, 7, 19);
  }

  @Test
  void x() {
    assertThat(CRT.x(new long[]{2, 7, 19}, new long[]{4, 9, 25})).isEqualTo(394);
  }

  @Test
  void coefficient() {
    assertThat(CRT.coefficient(new long[]{3, 4, 5})).containsAnyOf(20, 0, 0);
    assertThat(CRT.coefficient(new long[]{2, 7, 19}, new long[]{4, 9, 25})).containsAnyOf(225, 100,
        576);
  }

  @Test
  void add() {
    assertThat(
        CRT.add(new long[]{2, 3, 4}, new long[]{1, 2, 1}, new long[]{3, 4, 5})).containsAnyOf(0L,
        1L, 0L);
    assertThat(
        CRT.add(new long[]{2, 3, 4}, new long[]{2, 2, 3}, new long[]{3, 4, 5})).containsAnyOf(1L,
        1L, 2L);

    assertThat(CRT.add(new long[]{1, 2, 1}, 4, new long[]{3, 4, 5})).containsAnyOf(2L, 2L, 0L);
    assertThat(CRT.add(new long[]{2, 2, 3}, 4, new long[]{3, 4, 5})).containsAnyOf(0L, 2L, 2L);
  }

  @Test
  void sub() {
    assertThat(
        CRT.sub(new long[]{2, 3, 4}, new long[]{1, 2, 1}, new long[]{3, 4, 5})).containsAnyOf(0L,
        1L, 0L);
    assertThat(
        CRT.sub(new long[]{2, 3, 4}, new long[]{2, 2, 3}, new long[]{3, 4, 5})).containsAnyOf(1L,
        1L, 2L);

    assertThat(CRT.sub(new long[]{1, 2, 1}, 3, new long[]{3, 4, 5})).containsAnyOf(-2L, -1L, -2L);
    assertThat(CRT.sub(new long[]{2, 2, 3}, 3, new long[]{3, 4, 5})).containsAnyOf(-1L, -1L, 0L);
  }

  @Test
  void mul() {
    assertThat(
        CRT.mul(new long[]{2, 3, 4}, new long[]{1, 2, 1}, new long[]{3, 4, 5})).containsAnyOf(2L,
        2L, 4L);
    assertThat(
        CRT.mul(new long[]{2, 3, 4}, new long[]{2, 2, 3}, new long[]{3, 4, 5})).containsAnyOf(1L,
        2L, 2L);

    assertThat(CRT.mul(new long[]{1, 2, 1}, 3, new long[]{3, 4, 5})).containsAnyOf(0L, 2L, 3L);
    assertThat(CRT.mul(new long[]{2, 2, 3}, 3, new long[]{3, 4, 5})).containsAnyOf(0L, 2L, 4L);
  }

  @Test
  void exp() {
    assertThat(
        CRT.exp(new long[]{2, 3, 4}, new long[]{1, 2, 1}, new long[]{3, 4, 5})).containsAnyOf(2L,
        1L, 4L);
    assertThat(CRT.exp(new long[]{2, 3, 4}, new long[]{2, 2, 3}, new long[]{3, 4, 5})).contains(1L,
        1L, 4L);

    assertThat(CRT.exp(new long[]{2, 3, 4}, 3, new long[]{3, 4, 5})).containsAnyOf(2L, 3L, 4L);
    assertThat(CRT.exp(new long[]{2, 3, 4}, 3, new long[]{3, 4, 5})).contains(2L, 3L, 4L);
  }


  @Test
  void assessmentExpMI() {
    ModLong modN = new ModLong(7 * 8 * 9);
    System.out.println(modN.mulInv(46189));
    System.out.println(9806 % 7);
    System.out.println(9806 % 8);
    System.out.println(9806 % 9);
  }

  @Test
  void assessmentExp() {
    ModLong modN = new ModLong(7 * 8 * 9);
    System.out.println(modN.exp(12345, 5));
    System.out.println(modN.exp(12345, 5) % 7);
    System.out.println(modN.exp(12345, 5) % 8);
    System.out.println(modN.exp(12345, 5) % 9);
  }


}