package io.termd.core.io;

import javax.xml.ws.Service;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ServiceLoader;

/**
 * @author <a href="mailto:julien@julienviet.com">Julien Viet</a>
 */
public class CodePoint {

  /**
   * Convert the string to an array of codepoints.
   *
   * @param s the string to convert
   * @return the code points
   */
  public static int[] toCodePoints(String s) {
    int codePointLength = 0;
    for (int offset = 0;offset < s.length();) {
      int codePoint = s.codePointAt(offset);
      codePointLength++;
      offset += Character.charCount(codePoint);
    }
    int[] codePoints = new int[codePointLength];
    int index = 0;
    for (int offset = 0;offset < s.length();) {
      int codePoint = s.codePointAt(offset);
      offset += Character.charCount(codePoint);
      codePoints[index++] = codePoint;
    }
    return codePoints;
  }

  public static <S> List<S> loadServices(ClassLoader loader, Class<S> serviceClass) {
    ArrayList<S> services = new ArrayList<>();
    Iterator<S> i = ServiceLoader.load(serviceClass, loader).iterator();
    while (i.hasNext()) {
      try {
        S service = i.next();
        services.add(service);
      } catch (Exception ignore) {
        // Log me
      }
    }
    return services;
  }
}