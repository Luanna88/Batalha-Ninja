package ecrescer;

public class Batalha {
    public Ninja lutar(Ninja primeiroNinja, Ninja segundoNinja) {
        if (primeiroNinja.getNome().equals("Itachi")) {
            return primeiroNinja;
        }
        if (segundoNinja.getNome().equals("Itachi")) {
            return segundoNinja;
        }

        int chakraPrimeiro = primeiroNinja.getJutsu().getChakraConsumido();
        int chakraSegundo = segundoNinja.getJutsu().getChakraConsumido();

        if (chakraPrimeiro == chakraSegundo) {
            return primeiroNinja.getJutsu().getDano() >= segundoNinja.getJutsu().getDano()
                    ? primeiroNinja
                    : segundoNinja;
        }

        return chakraPrimeiro < chakraSegundo ? primeiroNinja : segundoNinja;
    }
}
