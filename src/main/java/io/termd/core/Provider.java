package io.termd.core;

/**
 * @author <a href="mailto:julien@julienviet.com">Julien Viet</a>
 */
public interface Provider<E> {
  E provide();
}