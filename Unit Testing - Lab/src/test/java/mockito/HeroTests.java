package mockito;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;
import skeleton.editedClasses.Axe;
import skeleton.editedClasses.Dummy;
import skeleton.editedClasses.Hero;
import skeleton.editedClasses.interfaces.Target;
import skeleton.editedClasses.interfaces.Weapon;

public class HeroTests {

    private static final int TARGET_EXPERIENCE = 69;
    private static final int ATTACK_POINTS = 69;

    @Test
    public void attackGainsExperienceIfTargetIsDead(){

        Weapon weapon = Mockito.mock(Axe.class);

        Target dummy = Mockito.mock(Dummy.class);

        Mockito.when(dummy.isDead()).thenReturn(true);
        Mockito.when(dummy.giveExperience()).thenReturn(ATTACK_POINTS);

        Hero hero = new Hero("Hero",weapon);

        hero.attack(dummy);

        Assert.assertEquals("Wrong experience",TARGET_EXPERIENCE,hero.getExperience());
    }

}
