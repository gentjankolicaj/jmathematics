package io.mathematics.algebra;
import java.util.Map;
/**
 * @author gentjan kolicaj
 */
public interface Shape<K,V> {

  Map<K, V> getDetails();

  ShapeInfo getShapeInfo();

}
