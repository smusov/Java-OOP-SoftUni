package anonymousClasses;

import org.junit.Assert;
import org.junit.Test;
import skeleton.editedClasses.Hero;
import skeleton.editedClasses.interfaces.Target;
import skeleton.editedClasses.interfaces.Weapon;

public class HeroTests {

    private static final int TARGET_EXPERIENCE = 69;
    private static final int ATTACK_POINTS = 69;

    @Test
    public void attackGainsExperienceIfTargetIsDead(){

        Target fakeTarget = new Target() {
            @Override
            public int getHealth() { return 0; }

            @Override
            public void takeAttack(int attackPoints) {}

            @Override
            public int giveExperience() {
                return TARGET_EXPERIENCE;
            }

            @Override
            public boolean isDead() { return true; }
        };

        Weapon fakeWeapon = new Weapon() {
            @Override
            public int getAttackPoints() { return ATTACK_POINTS; }

            @Override
            public int getDurabilityPoints() { return 0;}

            @Override
            public void attack(Target target) {}
        };

        Hero hero = new Hero("Hero",fakeWeapon);

        hero.attack(fakeTarget);

        Assert.assertEquals("Wrong experience",TARGET_EXPERIENCE,hero.getExperience());
    }

}
