package ecrescer;

public class Ninja {
    private String nome;
    private int chakra;
    private Jutsu jutsu;
    public Ninja(String nome, Jutsu jutsu) {
        this.nome = nome;
        this.jutsu = jutsu;
        this.chakra = 100;
    }
    public String getNome() {
        return nome;
    }
    public int getChakra() {
        return chakra;
    }
    public void setChakra(int chakra) {
        this.chakra = chakra;
    }
    public void atacar(Ninja oponente) {
        oponente.chakra -= jutsu.getDano();
    }
    public Jutsu getJutsu() {
        return jutsu;
    }
}
