package net.htlgkr.pos2.KeiserPatrice3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Weapons {


    public void readFile(String fileName) {
        List<Weapon> weapons = new ArrayList<>();
        try {
            Scanner scanner = new Scanner(new File(fileName));
            while (scanner.hasNextLine()) {
                weapons.stream().
                String line = scanner.nextLine();
                Comparator.
                if(line.startsWith("name"));
                else
                {
                    String[] strings = line.split(";");
                    weapons.add(new Weapon(strings[0],CombatType.valueOf(strings[1]), DamageType.valueOf(strings[2]), Integer.parseInt(strings[3]), Integer.parseInt(strings[4]), Integer.parseInt(strings[5]), Integer.parseInt(strings[6])));
                }
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }


    }
}
