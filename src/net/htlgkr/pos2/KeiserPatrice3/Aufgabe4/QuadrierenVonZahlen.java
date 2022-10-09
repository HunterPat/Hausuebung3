package net.htlgkr.pos2.KeiserPatrice3.Aufgabe4;

import java.util.stream.IntStream;
import java.util.stream.Stream;

public class QuadrierenVonZahlen {

    final int result = IntStream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10).filter(number -> (number %2) != 0 && (number %3) != 0).map(number -> number*number).reduce(0, Integer::sum);
}
