package ExtraUtilities.worlds.blocks.turret;

import arc.math.Angles;
import arc.math.Mathf;
import arc.util.Interval;
import arc.util.Time;
import mindustry.entities.bullet.BulletType;
import mindustry.entities.pattern.ShootPattern;
import mindustry.world.blocks.defense.turrets.Turret;

public class Surge extends Turret {
    public BulletType[] overrideShoots;
    public ShootPattern overrideShoot;
    public Surge(String name) {
        super(name);
        //canOverdrive = false;

        overrideShoot = new ShootPattern();
        overrideShoot.shots = 180;
        overrideShoot.shotDelay = 1;
    }

    public class SurgeBuild extends TurretBuild{
        private final transient Interval newTimer = new Interval(6);

        @Override
        public void applyBoost(float intensity, float duration) {

        }

        @Override
        public void applySlowdown(float intensity, float duration) {

        }

        @Override
        protected void shoot(BulletType type) {
            super.shoot(type);
        }

        public void shootOverride(BulletType[] types){
            int len = overrideShoots.length;

            float
                    bulletX = x + Angles.trnsx(rotation - 90, shootX, shootY),
                    bulletY = y + Angles.trnsy(rotation - 90, shootX, shootY);

            
            if(consumeAmmoOnce){
                useAmmo();
            }
        }

        @Override
        protected void updateShooting() {
            if(reloadCounter >= reload && !charging() && shootWarmup >= minWarmup){
                BulletType type = peekAmmo();

                shoot(type);

                reloadCounter %= reload;
            }
        }
    }
}
