package configuration;

public enum Devices {
    PIXEL("PIXEL"),
    PIXE4("Pixel4"),
    PIXEL4Native("PixelNative");

    public String getName() {
        return name;
    }

    String name;

    Devices(String name) {
        this.name = name;
    }
}
