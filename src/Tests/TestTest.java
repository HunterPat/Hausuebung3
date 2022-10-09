package Tests;

import net.htlgkr.pos2.KeiserPatrice3.Aufgabe1.CombatType;
import net.htlgkr.pos2.KeiserPatrice3.Aufgabe1.DamageType;
import net.htlgkr.pos2.KeiserPatrice3.Aufgabe1.Weapon;
import net.htlgkr.pos2.KeiserPatrice3.Aufgabe1.WeaponControl;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TestTest {

    @org.junit.jupiter.api.Test
    void testSortedList() {
        WeaponControl weaponControl = new WeaponControl();
        List<Weapon> weaponList = new ArrayList<>();
        List<Weapon> testingWeaponList = new ArrayList<>();
        weaponList.add(new Weapon("HullBreaker", CombatType.MELEE, DamageType.SLASHING, 30, 1, 50, 10));
        weaponList.add(new Weapon("Sword", CombatType.MELEE, DamageType.NONE, 13, 2, 5, 20));

        testingWeaponList.add(new Weapon("Sword", CombatType.MELEE, DamageType.NONE, 13, 2, 5, 20));
        testingWeaponList.add(new Weapon("HullBreaker", CombatType.MELEE, DamageType.SLASHING, 30, 1, 50, 10));

        weaponControl.sortList(testingWeaponList, "damage");
        assertEquals(weaponList.size(), testingWeaponList.size());

        for (int i = 0; i < weaponList.size(); i++) {
            assertEquals(weaponList.get(i).toString(), testingWeaponList.get(i).toString());
        }

    }
}