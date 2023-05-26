package spacechallenge;

public class U1 extends Rocket {

    // Rocket cost = $100 Million
    // Rocket weight = 10 Tonnes
    // Max weight (with cargo) = 18 Tonnes
    // Chance of launch explosion = 5% * (cargo carried / cargo limit)
    // Chance of landing crash = 1% * (cargo carried / cargo limit)
    
    public U1() {
        this.cost = 100;
        this.rocketWeight = 10;
        this.maxWeight = 18;
        this.launchExplosionProbability = 0.05f;
        this.landingCrashProbability = 0.01f;
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
