package HomeWork6;

public class NoteBook {
    private int ram;
    private int hdd;
    private String os;
    private String color;

    public NoteBook(int ram, int hdd, String os, String color) {
        this.ram = ram;
        this.hdd = hdd;
        this.os = os;
        this.color = color;
    }

    public int getRam() {
        return ram;
    }

    public void setRam(int ram) {
        this.ram = ram;
    }

    public int getHdd() {
        return hdd;
    }

    public void setHdd(int hdd) {
        this.hdd = hdd;
    }

    public String getOs() {
        return os;
    }

    public void setOs(String os) {
        this.os = os;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "RAM: " + getRam() + "Gb\n" + "HDD: " + getHdd() + "Gb\n" +
                "Operation System: " + getOs() + "\n" +
                "Color: " + getColor() + "\n";
    }
}
