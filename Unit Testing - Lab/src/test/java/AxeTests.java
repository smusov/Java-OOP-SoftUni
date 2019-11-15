import org.junit.Assert;
import org.junit.Test;

public class AxeTests {

    @Test
    public void weaponAttackLosesDurability() {
        Axe axe = new Axe(50, 50);

        axe.attack(new Dummy(50, 50));

        Assert.assertEquals(49, axe.getDurabilityPoints());
    }

    @Test(expected = IllegalStateException.class)
    public void brokenWeaponCantAttack() {

        Axe axe = new Axe(50, 0);

        axe.attack(new Dummy(69, 69));
    }
}
