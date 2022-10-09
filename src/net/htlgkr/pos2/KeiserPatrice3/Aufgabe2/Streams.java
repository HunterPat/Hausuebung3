
package net.htlgkr.pos2.KeiserPatrice3.Aufgabe2;

import java.io.IOException;
import java.lang.reflect.Array;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Streams {
    int[] randomNumbers = new int[10000];
    String[] randomStrings = new String[10];
    List<Weapon> weapons = new ArrayList<>();

    public Streams() {
        int max = 100;
        int min = 0;

        for (int i = 0; i < randomNumbers.length; i++) {
            randomNumbers[i] = (int) (Math.random() * (max - min + 1) + min);
        }
        byte[] array = new byte[10]; // length is bounded by 7

        for (int i = 0; i < randomStrings.length; i++) {
            new Random().nextBytes(array);
            randomStrings[i] = new String(array, Charset.forName("UTF-8"));
        }
    }

    public double average(int[] numbers) {
        return Arrays.stream(numbers).asDoubleStream().average().getAsDouble();
    }

    public List<String> upperCase(String[] strings) {
        return Arrays.stream(strings).map(s -> s.toUpperCase()).collect(Collectors.toList());
    }

    public Weapon findWeaponWithLowestDamage(List<Weapon> weapons) {
        Stream stream = weapons.stream().sorted(Comparator.comparing(Weapon::getDamage).reversed());
        return (Weapon) stream.toList().get(0);
    }

    public Weapon findWeaponWithHighestStrength(List<Weapon> weapons) {
        Stream stream = weapons.stream().sorted(Comparator.comparing(Weapon::getMinStrength).reversed());
        return (Weapon) stream.toList().get(0);
    }

    public List<Weapon> collectMissileWeapons(List<Weapon> weapons) {
        return weapons.stream().filter(weapon -> weapon.getDamageType() == DamageType.MISSILE).collect(Collectors.toList());
    }

    public Weapon findWeaponWithLongestName(List<Weapon> weapons) {
        Stream stream = weapons.stream().sorted(Comparator.comparing(Weapon::getName).reversed()); //Das Problem: wird nach dem Alphabet und nicht nach der länge der strings sortiert
        return (Weapon) stream.toList().get(0);
    }

    public List<String> toNameList(List<Weapon> weapons) {
        return weapons.stream().map(weapon -> new String(weapon.getName())).collect(Collectors.toList());
    }

    public int[] toSpeedArray(List<Weapon> weapons) {
        Streams streams = new Streams();
        return streams.toSpeedArray((LinkedList) weapons); // Habe leider nichts dazu im Internet gefunden -> Keine Ahnung
    }
    public int sumUpValues(List<Weapon> weapons) {
        return weapons.stream().map((w) -> w.getValue()).reduce(0, Integer::sum);
    }

    public long sumUpHashCodes(List<Weapon> weapons) {
        return weapons.stream().collect(Collectors.summingInt(Weapon::hashCode));
    }

    public List<Weapon> removeDuplicates(List<Weapon> weapons) {
        final Weapon[] tempWeapon = {null};
        weapons.stream().forEach(weapon -> {
            if(tempWeapon[0] == null);
            else if(weapon.getName() == tempWeapon[0].getName()){
                weapons.remove(weapon);
            }
            tempWeapon[0] = weapon;
        });
        return weapons;
    }

    public void increaseValuesByTenPercent(List<Weapon> weapons) {
        weapons.stream().forEach(weapon -> weapon.setValue((int) (weapon.getValue()*1.1)));
    }
}
