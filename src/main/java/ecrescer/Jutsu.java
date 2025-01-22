package ecrescer;

public class Jutsu {
    private int chakraConsumido;
    private int dano;

    public Jutsu(int chakraConsumido, int dano) {
        this.chakraConsumido = chakraConsumido;
        this.dano = dano;
    }

    public int getChakraConsumido() {
        return chakraConsumido;
    }

    public int getDano() {
        return dano;
    }
}
