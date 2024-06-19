package io.jmathematics.algebra;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * @author gentjan kolicaj
 */

@Getter
@RequiredArgsConstructor
public enum Dimension {

  D0(0), D1(1), D2(2), D3(3), D4(4);
  private final int index;

}
