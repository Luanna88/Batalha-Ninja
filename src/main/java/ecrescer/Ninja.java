package ecrescer;

public class Ninja {

    private String nome;
    private Jutsu jutsu;
    private Integer chakra;

    public Ninja(String nome, Jutsu jutsu) {
        this.nome = nome;
        this.jutsu = jutsu;
        this.chakra = 100;
    }

    public String getNome() {
        return nome;
    }

    public Jutsu getJutsu() {
        return jutsu;
    }

    public Integer getChakra() {
        return chakra;
    }

    public void setChakra(Integer chakra) {
        this.chakra = chakra;
    }

    public void atacar(Ninja oponente) {
        if (this.jutsu == null || oponente == null || oponente.getChakra() == null || this.chakra == null || this.chakra < 0) {
            return;
        }

        int dano = this.jutsu.getDano();

        if (oponente.getChakra() > 0) {
            int novoChakra = oponente.getChakra() - dano;
            oponente.setChakra(Math.max(novoChakra, 0));
        }
    }
}
