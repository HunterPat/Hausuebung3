package net.htlgkr.pos2.KeiserPatrice3;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
import java.util.stream.Stream;

public class Weapons {


    public void readFile(String fileName) {





        List<Weapon> weapons = new ArrayList<>();

        try {
            Files.lines(Path.of(fileName)).filter(s -> (s.startsWith("name"))).;

        } catch (IOException e) {
            e.printStackTrace();
        }
        {

        }
        try {
            Scanner scanner = new Scanner(new File(fileName));
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
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
    public static Stream deserialize(String s)
    {
        Stream strings = Arrays.stream(s.split(";"));
        return strings;
    }
}
