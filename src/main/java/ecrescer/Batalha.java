package ecrescer;

public class Batalha {

    public Ninja lutar(Ninja primeiroNinja, Ninja segundoNinja) {
        if (isInvalidNinja(primeiroNinja) && isInvalidNinja(segundoNinja)) {
            return primeiroNinja;
        }
        if (isInvalidNinja(primeiroNinja)) {
            return segundoNinja;
        }
        if (isInvalidNinja(segundoNinja)) {
            return primeiroNinja;
        }
        if (isSpecialCase(primeiroNinja, "Itachi")) {
            return primeiroNinja;
        }
        if (isSpecialCase(segundoNinja, "Itachi")) {
            return segundoNinja;
        }

        int chakraPrimeiro = calcularChakra(primeiroNinja);
        int chakraSegundo = calcularChakra(segundoNinja);
        int danoPrimeiro = calcularDano(primeiroNinja);
        int danoSegundo = calcularDano(segundoNinja);

        if (chakraPrimeiro == chakraSegundo && danoPrimeiro == danoSegundo) {
            return primeiroNinja;
        }
        if (chakraPrimeiro == chakraSegundo) {
            return danoPrimeiro > danoSegundo ? primeiroNinja : segundoNinja;
        }
        return chakraPrimeiro > chakraSegundo ? primeiroNinja : segundoNinja;
    }

    private boolean isInvalidNinja(Ninja ninja) {
        return ninja == null || ninja.getNome() == null || ninja.getChakra() == null || ninja.getJutsu() == null;
    }

    private boolean isSpecialCase(Ninja ninja, String specialName) {
        return specialName.equals(ninja.getNome());
    }

    public int calcularChakra(Ninja ninja) {
        if (ninja == null || ninja.getJutsu() == null || ninja.getChakra() == null) {
            return 0;
        }
        return ninja.getChakra() - ninja.getJutsu().getChakraConsumido();
    }

    public int calcularDano(Ninja ninja) {
        return ninja.getJutsu() != null ? ninja.getJutsu().getDano() : 0;
    }
}
