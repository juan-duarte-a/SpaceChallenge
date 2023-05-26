package spacechallenge;

public class U2 extends Rocket {
    
    // Rocket cost = $120 Million
    // Rocket weight = 18 Tonnes
    // Max weight (with cargo) = 29 Tonnes
    // Chance of launch explosion = 4% * (cargo carried / cargo limit)
    // Chance of landing crash = 8% * (cargo carried / cargo limit)

    public U2() {
        this.cost = 120;
        this.rocketWeight = 18;
        this.maxWeight = 29;
        this.launchExplosionProbability = 0.04f;
        this.landingCrashProbability = 0.08f;
    }
    
    @Override
    public boolean launch() {
        return Math.random() > launchExplosionProbability * getCargoWeight() / maxWeight;
    }

    @Override
    public boolean land() {
        return Math.random() > landingCrashProbability * getCargoWeight() / maxWeight;
    }
    
}
