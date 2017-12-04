package game.network;

class TankMeta {
    private String name;
    private int posx;
    private int posy;

    public TankMeta(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getPosx() {
        return posx;
    }

    public int getPosy() {
        return posy;
    }

    public void setPosition(int posx, int posy) {
        this.posx = posx;
        this.posy = posy;
    }
}
