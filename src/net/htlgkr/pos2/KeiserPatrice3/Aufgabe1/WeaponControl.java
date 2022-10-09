package net.htlgkr.pos2.KeiserPatrice3.Aufgabe1;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
import java.util.stream.Collectors;

public class WeaponControl {


    public void readFile(String fileName) {
        List<Weapon> weapons = null;
        Printable printable = new Printable() {
            @Override
            public void print(List<Weapon> weapons) {
                weapons.forEach(weapon -> System.out.println(weapon.toString()));
            }
        };

        try {
            weapons = Files.lines(Path.of(fileName)).skip(1).map(s -> s.split(";")).map(strings -> new Weapon(strings[0], CombatType.valueOf(strings[1]), DamageType.valueOf(strings[2]), Integer.parseInt(strings[3]), Integer.parseInt(strings[4]), Integer.parseInt(strings[5]), Integer.parseInt(strings[6]))).collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
        }
        //TODO: Übung 1.6 und 1.7 nicht verstanden
        System.out.println("Sorted to highest damage: \n");
        sortList(weapons, "damage");
        printable.print(weapons);
        System.out.println("\n-----------------------------------------------------\n");
        System.out.println("Sorted combatType alphabetically: \n");
        sortList(weapons, "combatType");
        printable.print(weapons);
        System.out.println("\n-----------------------------------------------------\n");
        System.out.println("Sorted damageType alphabetically: \n");
        sortList(weapons, "damageType");
        printable.print(weapons);
        System.out.println("\n-----------------------------------------------------\n");
        System.out.println("Sorted name alphabetically: \n");
        sortList(weapons, "name");
        printable.print(weapons);
    }
    public void sortList(List<Weapon> weapons, String sortOperation)
    {
        if(sortOperation.equals("damage"))
        {
            weapons.sort(Comparator.comparing(Weapon::getDamage).reversed());
        } else if(sortOperation.equals("combatType"))
        {
            weapons.sort(Comparator.comparing(Weapon::getCombatType));
        }else if(sortOperation.equals("damageType"))
        {
            weapons.sort(Comparator.comparing(Weapon::getDamageType));
        }else if(sortOperation.equals("name"))
        {
            weapons.sort(Comparator.comparing(Weapon::getName));
        }
    }
}
