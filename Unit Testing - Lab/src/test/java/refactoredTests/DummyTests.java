package refactoredTests;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import skeleton.Axe;
import skeleton.Dummy;

public class DummyTests {

    private static final int AXE_ATTACK = 10;
    private static final int AXE_DURABILITY = 10;
    private static final int DUMMY_HEALTH = 30;
    private static final int DUMMY_HP = 30;

    private static final int DUMMY_LOSES_HEALTH_TEST_EXPECTED_VALUE = 20;
    private static final int DEAD_DUMMY_CAN_GIVE_XP_TEST_EXPECTED_VALUE = 30;

    private Dummy dummy;
    private Axe axe;

    @Before
    public void initializeObjects() {
        this.dummy = new Dummy(DUMMY_HEALTH, DUMMY_HP);
        this.axe = new Axe(AXE_ATTACK, AXE_DURABILITY);
    }

    @Test
    public void dummyLosesHealthIfAttacked() {

        this.axe.attack(this.dummy);

        Assert.assertEquals("Dummy no lose health at attacked: ",DUMMY_LOSES_HEALTH_TEST_EXPECTED_VALUE, this.dummy.getHealth());
    }

    @Test(expected = IllegalStateException.class)
    public void deadDummyThrowsExceptionIfAttacked() {
        this.axe.attack(this.dummy);
        this.axe.attack(this.dummy);
        this.axe.attack(this.dummy);
        this.axe.attack(this.dummy);
    }

    @Test
    public void deadDummyCanGiveXP() {

        this.axe.attack(this.dummy);
        this.axe.attack(this.dummy);
        this.axe.attack(this.dummy);

        int exp = dummy.giveExperience();

        Assert.assertEquals(DEAD_DUMMY_CAN_GIVE_XP_TEST_EXPECTED_VALUE, exp);
    }

    @Test(expected = IllegalStateException.class)
    public void aliveDummyCantGiveXP() {

        this.axe.attack(this.dummy);
        this.axe.attack(this.dummy);
        this.axe.attack(this.dummy);
        this.axe.attack(this.dummy);
        this.axe.attack(this.dummy);

        this.dummy.giveExperience();
    }

}
