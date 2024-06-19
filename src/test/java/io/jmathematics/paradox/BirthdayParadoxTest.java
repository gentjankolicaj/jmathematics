package io.jmathematics.paradox;

import static org.assertj.core.api.Assertions.assertThat;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class BirthdayParadoxTest {

  @Test
  void pNone() {
    Assertions.assertThat(BirthdayParadox.pNone(23, 365)).isLessThanOrEqualTo(0.51);
  }

  @Test
  void pNoneExp() {
    assertThat(BirthdayParadox.pNoneExp(23, 365)).isLessThanOrEqualTo(0.51);
    assertThat(BirthdayParadox.pNoneExp(23, 365)).isGreaterThanOrEqualTo(
        BirthdayParadox.pNone(23, 365));
  }

  @Test
  void pCollision() {
    assertThat(BirthdayParadox.pCollision(23, 365)).isGreaterThanOrEqualTo(0.49);
  }

  @Test
  void pCollisionExp() {
    assertThat(BirthdayParadox.pCollisionExp(23, 365)).isGreaterThanOrEqualTo(0.49);
    assertThat(BirthdayParadox.pCollisionExp(23, 365)).isLessThanOrEqualTo(
        BirthdayParadox.pCollision(23, 365));
  }


  @Test
  void k() {
    assertThat(BirthdayParadox.k(0.50, 365)).isLessThan(256);
  }
}