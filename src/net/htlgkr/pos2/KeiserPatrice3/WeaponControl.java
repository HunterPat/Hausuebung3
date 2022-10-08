package net.htlgkr.pos2.KeiserPatrice3;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class WeaponControl {


    public void readFile(String fileName) {
        List<Weapon> weapons = null;
        Printable printable = new Printable() {
            @Override
            public void print(List<Weapon> weapons) {
                System.out.println("name"+ "combatType" + "damageType" + "damage" + "speed" + "strength" + "value");
                weapons.forEach(weapon -> System.out.println(weapon.toString()));
            }
        };

        try {
            weapons = Files.lines(Path.of(fileName)).skip(1).map(s -> s.split(";")).map(strings -> new Weapon(strings[0], CombatType.valueOf(strings[1]), DamageType.valueOf(strings[2]), Integer.parseInt(strings[3]), Integer.parseInt(strings[4]), Integer.parseInt(strings[5]), Integer.parseInt(strings[6]))).collect(Collectors.toList());
            weapons.forEach(weapon -> System.out.println(weapon.toString()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("\n-----------------------------------------------------\n");
        System.out.println("Sorted to highest damage: \n");
        weapons.sort(Comparator.comparingInt(Weapon::getDamage).reversed());
        printable.print(weapons);
        System.out.println("\n-----------------------------------------------------\n");
        System.out.println("Sorted combatType alphabetically: \n");
        weapons.sort(Comparator.comparing(Weapon::getCombatType));
        printable.print(weapons);
        System.out.println("\n-----------------------------------------------------\n");
        weapons.sort(Comparator.comparing(Weapon::getDamageType));
        System.out.println("Sorted damageType alphabetically: \n");
        printable.print(weapons);
        System.out.println("\n-----------------------------------------------------\n");
        weapons.sort(Comparator.comparing(Weapon::getName));
        System.out.println("Sorted name alphabetically: \n");
        printable.print(weapons);
    }
}
