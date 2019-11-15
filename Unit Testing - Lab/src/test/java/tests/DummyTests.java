package tests;

import org.junit.Assert;
import org.junit.Test;
import skeleton.Axe;
import skeleton.Dummy;

public class DummyTests {

    @Test
    public void dummyLosesHealthIfAttacked(){

        Dummy dummy = new Dummy(69,69);
        Axe axe = new Axe(68,69);

        axe.attack(dummy);

        Assert.assertEquals(1,dummy.getHealth());
    }

    @Test(expected = IllegalStateException.class)
    public void deadDummyThrowsExceptionIfAttacked(){
        Dummy dummy = new Dummy(69,69);
        Axe axe = new Axe(69,69);

        axe.attack(dummy);
        axe.attack(dummy);
    }

    @Test
    public void deadDummyCanGiveXP(){

        Dummy dummy = new Dummy(69,69);
        Axe axe = new Axe(69,69);

        axe.attack(dummy);

        int exp = dummy.giveExperience();

        Assert.assertEquals(69,exp);
    }

    @Test(expected = IllegalStateException.class)
    public void aliveDummyCantGiveXP(){

        Dummy dummy = new Dummy(69,69);
        Axe axe = new Axe(68,69);

        axe.attack(dummy);

        dummy.giveExperience();
    }

}
