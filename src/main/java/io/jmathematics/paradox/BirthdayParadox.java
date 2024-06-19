package io.jmathematics.paradox;


import io.jmathematics.Paradox;

/**
 * Implementation for <a href="https://en.wikipedia.org/wiki/Birthday_problem">Birthday problem</a>
 */
public class BirthdayParadox implements Paradox {

  /**
   * From <a href="https://en.wikipedia.org/wiki/Pigeonhole_principle">Pigeonhole principle</a> and
   * p(a`)=1-p(a) we find probability of no collision.
   *
   * @param k number of persons
   * @param d number of days
   * @return probability of no collisions found.
   */
  public static double pNone(int k, int d) {
    double p = 1;
    for (int i = 0; i < k; i++) {
      p = p * (1 - ((double) i / d));
    }
    return p;
  }

  /**
   * From <a href="https://en.wikipedia.org/wiki/Pigeonhole_principle">Pigeonhole principle</a> and
   * p(a`)=1-p(a) using exponential function we find probability of no collision. Using e natural
   * number.
   *
   * @param k number of persons
   * @param d number of days
   * @return probability of no collisions found.
   */
  public static double pNoneExp(int k, int d) {
    double p = 1;
    for (int i = 0; i < k; i++) {
      p = p * Math.pow(Math.E, -((double) i / d));
    }
    return p;
  }

  /**
   * P(A)=1-P(A`)
   *
   * @param k number of persons
   * @param d number of days
   * @return probability of collision
   */
  public static double pCollision(int k, int d) {
    return 1 - pNone(k, d);
  }

  /**
   * P(A)=1-P(A`)
   *
   * @param k number of persons
   * @param d number of days
   * @return probability of collision
   */
  public static double pCollisionExp(int k, int d) {
    return 1 - pNoneExp(k, d);
  }

  /**
   * @param p probability
   * @param d number of days
   * @return number of persons
   */
  public static double k(double p, int d) {
    return Math.log(p) / Math.log(1 - 1 / d);
  }
}
