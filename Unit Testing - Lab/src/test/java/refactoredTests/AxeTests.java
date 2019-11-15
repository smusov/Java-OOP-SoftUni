package refactoredTests;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import skeleton.baseClasses.Axe;
import skeleton.baseClasses.Dummy;


public class AxeTests {

    private static final int AXE_ATTACK = 50;
    private static final int AXE_DURABILITY = 50;
    private static final int AXE_ZERO_DURABILITY = 0;

    private static final int DUMMY_HEALTH = 50;
    private static final int DUMMY_HP = 50;

    private static final int WEAPON_ATTACK_LOSES_DURABILITY_TEST_EXPECTED_VALUE = 49;

    private Axe axe;
    private Dummy dummy;

    @Before
    public void initializeObjects() {
        this.dummy = new Dummy(DUMMY_HEALTH, DUMMY_HP);
        this.axe = new Axe(AXE_ATTACK, AXE_DURABILITY);
    }

    @Test
    public void weaponAttackLosesDurability() {

        this.axe.attack(this.dummy);

        Assert.assertEquals("Weapon no lose durability at attack: ",WEAPON_ATTACK_LOSES_DURABILITY_TEST_EXPECTED_VALUE, axe.getDurabilityPoints());
    }

    @Test(expected = IllegalStateException.class)
    public void brokenWeaponCantAttack() {

        this.axe = new Axe(AXE_ATTACK, AXE_ZERO_DURABILITY);

        this.axe.attack(this.dummy);
    }
}
