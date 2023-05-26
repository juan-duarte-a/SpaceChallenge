package spacechallenge;

public abstract class Rocket implements SpaceShip {

    protected int cost;
    protected int rocketWeight;
    protected int maxWeight;
    protected float launchExplosionProbability;
    protected float landingCrashProbability;

    private int cargoWeight;

    @Override
    abstract public boolean launch();

    @Override
    abstract public boolean land();

    public int getCargoWeight() {
        return cargoWeight;
    }

    @Override
    public boolean canCarry(Item item) {
        return rocketWeight + cargoWeight + item.getWeight() < maxWeight;
    }

    @Override
    public void carry(Item item) {
        cargoWeight += item.getWeight();
    }
    
}
