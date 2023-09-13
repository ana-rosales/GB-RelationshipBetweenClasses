package russianroulette.entities;

import java.util.Objects;

public class Player {

    private int ID;

    private String name;

    private boolean dipped;

    public Player(String name) {
        this.ID = Math.toIntExact(Math.round(Math.random() * 100 + 1));
        this.name = name + "#" + ID;
    }

    public Player() {
        this.ID = Math.toIntExact(Math.round(Math.random() * 100 + 1));
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = Math.toIntExact(Math.round(Math.random() * 100 + 1));
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name + "#" + ID;
    }

    public boolean isDipped() {
        return dipped;
    }

    public void setDipped(boolean dipped) {
        this.dipped = dipped;
    }

    /**
     * Returns true if the person got wet with the water gun.
     * @param gun
     * @return if the person is wet or not
     */
    public boolean shot(Revolver gun) {
        if(gun.toDip()){
            dipped = true;
        }
        if(dipped){
            return true;
        } else {
            gun.nextWaterJet();
            return false;
        }
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 17 * hash + this.ID;
        hash = 17 * hash + Objects.hashCode(this.name);
        hash = 17 * hash + (this.dipped ? 1 : 0);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Player other = (Player) obj;
        if (this.ID != other.ID) {
            return false;
        }
        if (this.dipped != other.dipped) {
            return false;
        }
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Player{" + "ID=" + ID + ", name=" + name + ", dipped=" + dipped + '}';
    }
}
