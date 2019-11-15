package skeleton.editedClasses.interfaces;

import skeleton.editedClasses.Dummy;

public interface Weapon {

    int getAttackPoints();

    int getDurabilityPoints();

    void attack(Target target);
}
