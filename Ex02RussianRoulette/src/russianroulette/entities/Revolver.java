package russianroulette.entities;

public class Revolver {

    private int currentDrum;
    private int loadOfWater;

    public Revolver(int currentDrum, int loadOfWater) {
        this.currentDrum = currentDrum;
        this.loadOfWater = loadOfWater;
    }

    public Revolver() {
        fillGun();
    }

    public int getCurrentDrum() {
        return currentDrum;
    }

    public void setCurrentDrum(int currentDrum) {
        this.currentDrum = currentDrum;
    }

    public int getLoadOfWater() {
        return loadOfWater;
    }

    public void setLoadOfWater(int loadOfWater) {
        this.loadOfWater = loadOfWater;
    }

    /**
     * Method that sets the initial values of currentDrum and loadOfWater, the
     * values must be random.
     */
    private void fillGun() {
        currentDrum = Math.toIntExact(Math.round(Math.random() * 10 + 1));
        loadOfWater = Math.toIntExact(Math.round(Math.random() * 10 + 1));
    }

    /**
     * Returns true if the position of the currentDrum matches the position of
     * loadOfWater.
     * @return boolean
     */
    public boolean toDip() {
        return currentDrum == loadOfWater;       
    }

    /**
     * Changes the position of the drum to the following position.
     */
    public void nextWaterJet() {
        currentDrum = (currentDrum<10)? currentDrum + 1: 0;
    }

    @Override
    public String toString() {
        return "Revolver{" + "currentDrum=" + currentDrum + ", loadOfWater=" + loadOfWater + '}';
    }
}
