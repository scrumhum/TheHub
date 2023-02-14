public class GatheringManager extends User{

    /**
     *
     * Sudo Code:
     *
     * Constructor
     *
     * addGathering()
     *
     * removeGathering()
     *
     */

    public GatheringManager() {

    }

    public void addGathering() {
        setGathering(getGathering().add(new Gathering()));
    }

    public void removeGathering(Gathering gathering) {
        setGathering(getGathering().remove(gathering));
    }
}
