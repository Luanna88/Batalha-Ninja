import ecrescer.Batalha;
import ecrescer.Jutsu;
import ecrescer.Ninja;
import org.junit.Assert;
import org.junit.Test;
import static org.junit.Assert.fail;

public class NinjaTest {

    @Test
    public void deveRetornarNinjaComJutsuMaisForteSeOsDoisGastamOMesmoChakra() {
        Jutsu jutsuNinjaUm = new Jutsu(5, 10);
        Jutsu jutsuNinjaDois = new Jutsu(5, 8);
        Ninja ninjaUm = new Ninja("Naruto", jutsuNinjaUm);
        Ninja ninjaDois = new Ninja("Gaara", jutsuNinjaDois);
        Batalha batalha = new Batalha();
        Ninja ninjaVencedor = batalha.lutar(ninjaUm, ninjaDois);

        Assert.assertSame("O ninja com Jutsu mais forte deve vencer.", ninjaUm, ninjaVencedor);
    }

    @Test
    public void deveAtualizarOChakraDoOponenteDeAcordoComODanoDoJutsoQuandoAtacar() {
        Jutsu jutsuNinjaAtacante = new Jutsu(5, 10);
        Ninja ninjaAtacante = new Ninja("Naruto", jutsuNinjaAtacante);
        Jutsu jutsuNinjaOponente = new Jutsu(5, 8);
        Ninja ninjaOponente = new Ninja("Gaara", jutsuNinjaOponente);

        ninjaOponente.setChakra(100);
        Integer nivelChakraEsperado = 90;

        ninjaAtacante.atacar(ninjaOponente);

        Assert.assertEquals("O chakra do oponente deve ser reduzido conforme o dano do Jutsu.", nivelChakraEsperado, ninjaOponente.getChakra());
    }

    @Test
    public void deveRetornarPrimeiroNinjaComoVencedorQuandoONomeForItachi() {
        Jutsu jutsuNinjaUm = new Jutsu(5, 10);
        Ninja ninjaUm = new Ninja("Itachi", jutsuNinjaUm);
        Jutsu jutsuNinjaDois = new Jutsu(5, 10);
        Ninja ninjaDois = new Ninja("Naruto", jutsuNinjaDois);
        Batalha batalha = new Batalha();
        Ninja ninjaVencedor = batalha.lutar(ninjaUm, ninjaDois);

        Assert.assertSame("Itachi deve vencer automaticamente quando for o primeiro Ninja.", ninjaUm, ninjaVencedor);
    }

    @Test
    public void deveRetornarSegundoNinjaComoVencedorQuandoONomeForItachi() {
        Jutsu jutsuNinjaUm = new Jutsu(5, 10);
        Ninja ninjaUm = new Ninja("Naruto", jutsuNinjaUm);
        Jutsu jutsuNinjaDois = new Jutsu(5, 10);
        Ninja ninjaDois = new Ninja("Itachi", jutsuNinjaDois);
        Batalha batalha = new Batalha();
        Ninja ninjaVencedor = batalha.lutar(ninjaUm, ninjaDois);

        Assert.assertSame("Itachi deve vencer automaticamente quando for o segundo Ninja.", ninjaDois, ninjaVencedor);
    }

    @Test
    public void deveRetornarPrimeiroNinjaComoVencedorQuandoEmpatar() {
        Jutsu jutsuNinjaUm = new Jutsu(5, 10);
        Ninja ninjaUm = new Ninja("Naruto", jutsuNinjaUm);
        Jutsu jutsuNinjaDois = new Jutsu(5, 10);
        Ninja ninjaDois = new Ninja("Gaara", jutsuNinjaDois);
        Batalha batalha = new Batalha();
        Ninja ninjaVencedor = batalha.lutar(ninjaUm, ninjaDois);

        Assert.assertEquals("Em caso de empate, o primeiro Ninja deve vencer.", ninjaUm, ninjaVencedor);

    }

    @Test
    public void deveRetornarSegundoNinjaQuandoPrimeiroNinjaNaoTemNome() {
        Jutsu jutsuNinjaUm = new Jutsu(5, 10);
        Ninja ninjaUm = new Ninja(null, jutsuNinjaUm);

        Jutsu jutsuNinjaDois = new Jutsu(5, 8);
        Ninja ninjaDois = new Ninja("Naruto", jutsuNinjaDois);

        Batalha batalha = new Batalha();
        Ninja ninjaVencedor = batalha.lutar(ninjaUm, ninjaDois);

        Assert.assertSame("Caso o primeiro Ninja não tenha nome, o segundo Ninja deve vencer.", ninjaDois, ninjaVencedor);
    }

    @Test
    public void deveRetornarPrimeiroNinjaQuandoAmbosNaoPossuemNome() {
        Jutsu jutsuNinjaUm = new Jutsu(5, 10);
        Ninja ninjaUm = new Ninja(null, jutsuNinjaUm);
        Jutsu jutsuNinjaDois = new Jutsu(5, 8);
        Ninja ninjaDois = new Ninja(null, jutsuNinjaDois);
        Batalha batalha = new Batalha();
        Ninja ninjaVencedor = batalha.lutar(ninjaUm, ninjaDois);

        Assert.assertSame("Caso ambos não tenham nome, o primeiro Ninja deve vencer.", ninjaUm, ninjaVencedor);

    }

    @Test
    public void deveRetornarPrimeiroNinjaQuandoChakrasEDanosForemIguais() {
        Jutsu jutsuNinjaUm = new Jutsu(5, 10);
        Ninja ninjaUm = new Ninja("Naruto", jutsuNinjaUm);
        Jutsu jutsuNinjaDois = new Jutsu(5, 10);
        Ninja ninjaDois = new Ninja("Sasuke", jutsuNinjaDois);
        Batalha batalha = new Batalha();
        Ninja ninjaVencedor = batalha.lutar(ninjaUm, ninjaDois);

        Assert.assertSame("Caso os dois empatem em chakra e dano, o primeiro Ninja deve vencer.", ninjaUm, ninjaVencedor);

    }

    @Test
    public void deveRetornarOutroNinjaQuandoUmPossuiJutsuNulo() {
        Ninja ninjaUm = new Ninja("Naruto", null);
        Jutsu jutsuNinjaDois = new Jutsu(5, 10);
        Ninja ninjaDois = new Ninja("Gaara", jutsuNinjaDois);
        Batalha batalha = new Batalha();
        Ninja ninjaVencedor = batalha.lutar(ninjaUm, ninjaDois);

        Assert.assertSame("Caso o primeiro Ninja não tenha Jutsu, o segundo deve vencer.", ninjaDois, ninjaVencedor);
    }

    @Test
    public void deveRetornarPrimeiroNinjaQuandoAmbosPossuemJutsuNulo() {
        Ninja ninjaUm = new Ninja("Naruto", null);
        Ninja ninjaDois = new Ninja("Sasuke", null);
        Batalha batalha = new Batalha();
        Ninja ninjaVencedor = batalha.lutar(ninjaUm, ninjaDois);

        Assert.assertSame("Caso ambos os ninjas não possuam Jutsu, o primeiro deve vencer.", ninjaUm, ninjaVencedor);
    }

    @Test
    public void deveRetornarNinjaComMaiorDanoQuandoOsJutsusDiferem() {
        Jutsu jutsuNinjaUm = new Jutsu(5, 12);
        Ninja ninjaUm = new Ninja("Naruto", jutsuNinjaUm);
        Jutsu jutsuNinjaDois = new Jutsu(5, 10);
        Ninja ninjaDois = new Ninja("Gaara", jutsuNinjaDois);
        Batalha batalha = new Batalha();
        Ninja ninjaVencedor = batalha.lutar(ninjaUm, ninjaDois);

        Assert.assertSame("O ninja com maior dano deve vencer.", ninjaUm, ninjaVencedor);
    }

    @Test
    public void deveRetornarSegundoNinjaQuandoChakraDoPrimeiroForNulo() {
        Jutsu jutsuNinjaUm = new Jutsu(5, 10);
        Ninja ninjaUm = new Ninja("Naruto", jutsuNinjaUm);

        ninjaUm.setChakra(null);
        Jutsu jutsuNinjaDois = new Jutsu(5, 8);
        Ninja ninjaDois = new Ninja("Gaara", jutsuNinjaDois);

        ninjaDois.setChakra(100);

        Batalha batalha = new Batalha();
        Ninja ninjaVencedor = batalha.lutar(ninjaUm, ninjaDois);

        Assert.assertSame("Caso o chakra do primeiro Ninja seja nulo, o segundo deve vencer.", ninjaDois, ninjaVencedor);
    }

    @Test
    public void naoDeveAtacarQuandoOponenteForNulo() {
        Jutsu jutsu = new Jutsu(5, 10);
        Ninja ninja = new Ninja("Naruto", jutsu);
        ninja.atacar(null);

        Assert.assertTrue(true);
    }

    @Test
    public void naoDeveAtacarQuandoChakraOponenteForNulo() {
        Jutsu jutsu = new Jutsu(5, 10);
        Ninja ninja = new Ninja("Naruto", jutsu);
        Ninja oponente = new Ninja("Sasuke", jutsu);
        oponente.setChakra(null);
        ninja.atacar(oponente);

        Assert.assertNull(oponente.getChakra());
    }

    @Test
    public void deveRetornarPrimeiroNinjaQuandoAmbosSemJutsuESemNome() {
        Ninja ninjaUm = new Ninja(null, null);
        Ninja ninjaDois = new Ninja(null, null);
        Batalha batalha = new Batalha();
        Ninja ninjaVencedor = batalha.lutar(ninjaUm, ninjaDois);

        Assert.assertSame("Caso ambos os ninjas não tenham Jutsu e nome, o primeiro deve vencer.", ninjaUm, ninjaVencedor);
    }

    @Test
    public void deveRetornarPrimeiroNinjaQuandoAmbosComJutsuNulo() {
        Ninja ninjaUm = new Ninja("Naruto", null);
        Ninja ninjaDois = new Ninja("Sasuke", null);
        Batalha batalha = new Batalha();
        Ninja ninjaVencedor = batalha.lutar(ninjaUm, ninjaDois);

        Assert.assertSame("Caso ambos os ninjas tenham Jutsu nulo, o primeiro deve vencer.", ninjaUm, ninjaVencedor);
    }

    @Test
    public void deveRetornarNinjaComJutsuValidoQuandoOutroTemJutsuNulo() {
        Jutsu jutsuNinjaUm = new Jutsu(5, 10);
        Ninja ninjaUm = new Ninja("Naruto", jutsuNinjaUm);
        Ninja ninjaDois = new Ninja("Sasuke", null);
        Batalha batalha = new Batalha();
        Ninja ninjaVencedor = batalha.lutar(ninjaUm, ninjaDois);

        Assert.assertSame("Caso um ninja tenha Jutsu nulo, o ninja com Jutsu válido deve vencer.", ninjaUm, ninjaVencedor);
    }

    @Test
    public void naoDeveAtacarQuandoChakraForNegativo() {
        Jutsu jutsu = new Jutsu(5, 10);
        Ninja ninja = new Ninja("Naruto", jutsu);

        ninja.setChakra(-10); // Chakra negativo
        Ninja oponente = new Ninja("Sasuke", jutsu);

        oponente.setChakra(50);
        ninja.atacar(oponente);

        Assert.assertEquals("O chakra do oponente não deve ser alterado se o chakra do atacante for negativo.", Integer.valueOf(50), oponente.getChakra());
    }

    @Test
    public void deveReduzirChakraDoOponenteCorretamenteEmAtaquesConsecutivos() {
        Jutsu jutsu = new Jutsu(5, 10);
        Ninja ninja = new Ninja("Naruto", jutsu);
        Ninja oponente = new Ninja("Sasuke", jutsu);

        oponente.setChakra(50);
        ninja.atacar(oponente);
        ninja.atacar(oponente);

        Assert.assertEquals("O chakra do oponente deve ser reduzido corretamente após ataques consecutivos.", Integer.valueOf(30), oponente.getChakra());

    }

    @Test
    public void deveCalcularChakraCorretamente() {
        Jutsu jutsu = new Jutsu(30, 50);
        Ninja ninja = new Ninja("Naruto", jutsu);
        Batalha batalha = new Batalha();
        int chakra = batalha.calcularChakra(ninja);

        Assert.assertEquals(70, chakra);
    }

    @Test
    public void deveRetornarSegundoNinjaQuandoPrimeiroForNulo() {
        Ninja ninjaUm = null;
        Jutsu jutsuNinjaDois = new Jutsu(5, 8);
        Ninja ninjaDois = new Ninja("Gaara", jutsuNinjaDois);
        Batalha batalha = new Batalha();
        Ninja ninjaVencedor = batalha.lutar(ninjaUm, ninjaDois);

        Assert.assertSame("Caso o primeiro Ninja seja nulo, o segundo deve vencer.", ninjaDois, ninjaVencedor);

    }

    @Test
    public void deveRetornarPrimeiroNinjaQuandoSegundoForNulo() {
        Jutsu jutsuNinjaUm = new Jutsu(5, 8);
        Ninja ninjaUm = new Ninja("Naruto", jutsuNinjaUm);
        Ninja ninjaDois = null;
        Batalha batalha = new Batalha();
        Ninja ninjaVencedor = batalha.lutar(ninjaUm, ninjaDois);

        Assert.assertSame("Caso o segundo Ninja seja nulo, o primeiro deve vencer.", ninjaUm, ninjaVencedor);

    }

    @Test
    public void deveRetornarChakraZeroQuandoCalcularComNinjaInvalido() {
        Ninja ninjaInvalido = new Ninja(null, null);
        ninjaInvalido.setChakra(null);
        Batalha batalha = new Batalha();
        int chakra = batalha.calcularChakra(ninjaInvalido);

        Assert.assertEquals("O chakra deve ser zero quando o Ninja é inválido.", 0, chakra);

    }

    @Test
    public void testAtacarComValoresNulos() {
        Ninja ninja = new Ninja("Naruto", null);
        Ninja oponente = new Ninja("Sasuke", new Jutsu(20, 50));
        ninja.atacar(oponente);

        Assert.assertEquals((Integer) 100, oponente.getChakra());
    }

    @Test
    public void testAtacarComChakraNegativo() {
        Jutsu jutsuNaruto = new Jutsu(10, 40);
        Ninja ninja = new Ninja("Naruto", jutsuNaruto);
        ninja.setChakra(-10);

        Jutsu jutsuSasuke = new Jutsu(20, 50);
        Ninja oponente = new Ninja("Sasuke", jutsuSasuke);
        ninja.atacar(oponente);

        Assert.assertEquals((Integer) 100, oponente.getChakra());

    }

    @Test
    public void testAtacarComSucesso() {
        Jutsu jutsuNaruto = new Jutsu(10, 40);
        Jutsu jutsuSasuke = new Jutsu(20, 50);
        Ninja ninja = new Ninja("Naruto", jutsuNaruto);
        Ninja oponente = new Ninja("Sasuke", jutsuSasuke);
        ninja.atacar(oponente);

        Assert.assertEquals((Integer) 60, oponente.getChakra());

    }

    @Test
    public void deveCriarNinjaComNomeVazio() {
        Jutsu jutsu = new Jutsu(10, 20);
        Ninja ninja = new Ninja("", jutsu);

        Assert.assertEquals("", ninja.getNome());
    }

    @Test
    public void naoDeveModificarChakraDeOponenteComChakraZero() {
        Jutsu jutsu = new Jutsu(10, 20);
        Ninja ninja = new Ninja("Naruto", jutsu);
        Ninja oponente = new Ninja("Sasuke", jutsu);

        oponente.setChakra(0);
        ninja.atacar(oponente);

        Assert.assertEquals((Integer) 0, oponente.getChakra());
    }

    @Test
    public void naoDeveModificarChakraDoAtacante() {
        Jutsu jutsu = new Jutsu(10, 20);
        Ninja atacante = new Ninja("Naruto", jutsu);
        Ninja oponente = new Ninja("Sasuke", jutsu);

        oponente.setChakra(100);
        Integer chakraInicialAtacante = atacante.getChakra();
        atacante.atacar(oponente);

        Assert.assertEquals(chakraInicialAtacante, atacante.getChakra());
    }

    @Test
    public void naoDeveModificarChakraDeOponenteComDanoZero() {
        Jutsu jutsu = new Jutsu(0, 0);
        Ninja atacante = new Ninja("Naruto", jutsu);
        Ninja oponente = new Ninja("Sasuke", jutsu);

        oponente.setChakra(50);
        atacante.atacar(oponente);

        Assert.assertEquals((Integer) 50, oponente.getChakra());
    }

    @Test
    public void deveReduzirChakraAteZeroEmAtaquesConsecutivos() {
        Jutsu jutsu = new Jutsu(10, 20);
        Ninja atacante = new Ninja("Naruto", jutsu);
        Ninja oponente = new Ninja("Sasuke", jutsu);

        oponente.setChakra(30);
        atacante.atacar(oponente);
        atacante.atacar(oponente);
        atacante.atacar(oponente);

        Assert.assertEquals((Integer) 0, oponente.getChakra());
    }

    @Test
    public void testNinjaInitialization() {
        Jutsu jutsu = new Jutsu(20, 50);
        Ninja naruto = new Ninja("Naruto", jutsu);

        Assert.assertEquals("Naruto", naruto.getNome());
        Assert.assertEquals(jutsu, naruto.getJutsu());
        Assert.assertEquals((Integer) 100, naruto.getChakra());
    }

    @Test
    public void testJutsuInitialization() {
        Jutsu chidori = new Jutsu(30, 70);

        Assert.assertEquals(30, chidori.getChakraConsumido());
        Assert.assertEquals(70, chidori.getDano());
    }

    @Test
    public void testNinjaAttackReducesOpponentChakra() {
        Jutsu rasengan = new Jutsu(20, 50);
        Jutsu chidori = new Jutsu(30, 70);
        Ninja naruto = new Ninja("Naruto", rasengan);
        Ninja sasuke = new Ninja("Sasuke", chidori);
        naruto.atacar(sasuke);

        Assert.assertEquals((Integer) 50, sasuke.getChakra());
    }

    @Test
    public void testNinjaAttackDoesNotReduceChakraBelowZero() {
        Jutsu rasengan = new Jutsu(20, 150);
        Ninja naruto = new Ninja("Naruto", rasengan);
        Ninja sasuke = new Ninja("Sasuke", null);
        naruto.atacar(sasuke);

        Assert.assertEquals((Integer) 0, sasuke.getChakra());
    }

    @Test
    public void testNinjaAttackWithNullJutsu() {
        Ninja ninjaSemJutsu = new Ninja("Naruto", null);
        Ninja oponente = new Ninja("Sasuke", new Jutsu(30, 50));
        ninjaSemJutsu.atacar(oponente);

        Assert.assertEquals((Integer) 100, oponente.getChakra());
    }

    @Test
    public void testNinjaAttackWithInvalidChakra() {
        Jutsu rasengan = new Jutsu(20, 50);
        Ninja naruto = new Ninja("Naruto", rasengan);

        naruto.setChakra(-10);

        Ninja sasuke = new Ninja("Sasuke", new Jutsu(30, 70));
        naruto.atacar(sasuke);

        Assert.assertEquals((Integer) 100, sasuke.getChakra());
    }

    @Test
    public void testNinjaAttackWithNullOpponent() {
        Jutsu rasengan = new Jutsu(20, 50);
        Ninja naruto = new Ninja("Naruto", rasengan);

        try {
            naruto.atacar(null);
        } catch (Exception e) {
            fail("O ataque não deveria lançar uma exceção com oponente nulo.");
        }
    }

    @Test
    public void testAtacarComParametrosInvalidos() {
        Jutsu jutsu = new Jutsu(10, 20);
        Ninja atacante = new Ninja("Kakashi", jutsu);
        Ninja oponente = new Ninja("Zabuza", null);

        atacante = new Ninja("Kakashi", null);
        atacante.atacar(oponente);
        Assert.assertEquals("O chakra do oponente não deve ser alterado", Integer.valueOf(100), oponente.getChakra());

        atacante = new Ninja("Kakashi", jutsu);
        atacante.atacar(null);

        oponente.setChakra(null);
        atacante.atacar(oponente);
        Assert.assertNull("O chakra do oponente continua nulo", oponente.getChakra());

        atacante.setChakra(null);
        atacante.atacar(oponente);
        Assert.assertNull("O chakra do atacante continua nulo", atacante.getChakra());

        atacante.setChakra(-10);
        atacante.atacar(oponente);
        Assert.assertNull("O chakra do oponente não deve ser alterado", oponente.getChakra());
    }

    @Test
    public void testNaoReduzirChakraAbaixoDeZero() {

        Jutsu jutsu = new Jutsu(10, 50);
        Ninja atacante = new Ninja("Kakashi", jutsu);
        Ninja oponente = new Ninja("Zabuza", null);

        oponente.setChakra(40);

        atacante.atacar(oponente);
        Assert.assertEquals("O chakra do oponente não deve ser menor que zero", Integer.valueOf(0), oponente.getChakra());
    }

    @Test
    public void testNaoAtacarSemJutsu() {
        Ninja atacante = new Ninja("Kakashi", null);
        Ninja oponente = new Ninja("Zabuza", null);

        oponente.setChakra(50);

        atacante.atacar(oponente);
        Assert.assertEquals("O chakra do oponente não deve ser alterado", Integer.valueOf(50), oponente.getChakra());
    }

    @Test
    public void testAtacarComJutsuNulo() {
        Ninja atacante = new Ninja("Naruto", null);
        Ninja oponente = new Ninja("Sasuke", new Jutsu(10, 20));

        oponente.setChakra(100);
        atacante.atacar(oponente);

        Assert.assertEquals(Integer.valueOf(100), oponente.getChakra());
    }

    @Test
    public void testAtacarComOponenteNulo() {
        Ninja atacante = new Ninja("Naruto", new Jutsu(10, 20));

        atacante.atacar(null);

    }

    @Test
    public void testAtacarComChakraNuloNoAtacante() {
        Ninja atacante = new Ninja("Naruto", new Jutsu(10, 20));
        Ninja oponente = new Ninja("Sasuke", new Jutsu(10, 20));

        atacante.setChakra(null);
        oponente.setChakra(100);

        atacante.atacar(oponente);

        Assert.assertEquals(Integer.valueOf(100), oponente.getChakra());
    }

    @Test
    public void testAtacarComChakraNuloNoOponente() {
        Ninja atacante = new Ninja("Naruto", new Jutsu(10, 20));
        Ninja oponente = new Ninja("Sasuke", new Jutsu(10, 20));

        oponente.setChakra(null);

        atacante.atacar(oponente);

    }

    @Test
    public void testAtacarComChakraNegativoNoAtacante() {
        Ninja atacante = new Ninja("Naruto", new Jutsu(10, 20));
        Ninja oponente = new Ninja("Sasuke", new Jutsu(10, 20));

        atacante.setChakra(-10);
        oponente.setChakra(100);

        atacante.atacar(oponente);

        Assert.assertEquals(Integer.valueOf(100), oponente.getChakra());
    }

    @Test
    public void testAtacarComTodasCondicoesValidas() {
        Ninja atacante = new Ninja("Naruto", new Jutsu(10, 20));
        Ninja oponente = new Ninja("Sasuke", new Jutsu(10, 20));

        atacante.setChakra(50);
        oponente.setChakra(100);

        atacante.atacar(oponente);

        Assert.assertEquals(Integer.valueOf(80), oponente.getChakra());
    }

    @Test
    public void testLutar_QuandoChakraEDanoSaoIguais() {
        Jutsu jutsu1 = new Jutsu(30, 50);
        Jutsu jutsu2 = new Jutsu(30, 50);

        Ninja ninja1 = new Ninja("Naruto", jutsu1);
        Ninja ninja2 = new Ninja("Sasuke", jutsu2);

        ninja1.setChakra(80);
        ninja2.setChakra(80);

        Batalha batalha = new Batalha();

        Ninja vencedor = batalha.lutar(ninja1, ninja2);

        Assert.assertEquals("Naruto", vencedor.getNome());
    }

    @Test
    public void testLutar_ChakraIgual_DanoMaiorVence() {
        Jutsu jutsu1 = new Jutsu(10, 50);
        Ninja ninja1 = new Ninja("Naruto", jutsu1);
        ninja1.setChakra(100);

        Jutsu jutsu2 = new Jutsu(10, 30);
        Ninja ninja2 = new Ninja("Sasuke", jutsu2);
        ninja2.setChakra(100);

        Batalha batalha = new Batalha();
        Ninja vencedor = batalha.lutar(ninja1, ninja2);

        Assert.assertEquals(ninja1, vencedor);
    }

    @Test
    public void testLutar_ChakraMaiorVence() {
        Jutsu jutsu1 = new Jutsu(10, 20);
        Ninja ninja1 = new Ninja("Naruto", jutsu1);
        ninja1.setChakra(120);

        Jutsu jutsu2 = new Jutsu(10, 20);
        Ninja ninja2 = new Ninja("Sasuke", jutsu2);
        ninja2.setChakra(100);

        Batalha batalha = new Batalha();
        Ninja vencedor = batalha.lutar(ninja1, ninja2);

        Assert.assertEquals(ninja1, vencedor);
    }

    @Test
    public void testLutar_NinjasIguais() {
        Jutsu jutsu = new Jutsu(10, 30);
        Ninja ninja1 = new Ninja("Naruto", jutsu);
        ninja1.setChakra(100);

        Ninja ninja2 = new Ninja("Naruto", jutsu);
        ninja2.setChakra(100);

        Batalha batalha = new Batalha();
        Ninja vencedor = batalha.lutar(ninja1, ninja2);

        Assert.assertEquals(ninja1, vencedor);
    }

    @Test
    public void testLutar_NinjaEspecialItachi() {
        Jutsu jutsu1 = new Jutsu(10, 20);
        Ninja ninja1 = new Ninja("Itachi", jutsu1);

        Jutsu jutsu2 = new Jutsu(10, 50);
        Ninja ninja2 = new Ninja("Naruto", jutsu2);

        Batalha batalha = new Batalha();
        Ninja vencedor = batalha.lutar(ninja1, ninja2);

        Assert.assertEquals(ninja1, vencedor);
    }

    @Test
    public void testLutar_NinjaInvalido() {
        Jutsu jutsu = new Jutsu(10, 20);
        Ninja ninjaValido = new Ninja("Naruto", jutsu);
        ninjaValido.setChakra(100);

        Ninja ninjaInvalido = new Ninja(null, null);

        Batalha batalha = new Batalha();
        Ninja vencedor = batalha.lutar(ninjaValido, ninjaInvalido);

        Assert.assertEquals(ninjaValido, vencedor);
    }

    @Test
    public void testCalcularChakra() {
        Jutsu jutsu = new Jutsu(20, 50);
        Ninja ninja = new Ninja("Naruto", jutsu);
        ninja.setChakra(100);

        Batalha batalha = new Batalha();
        int chakraRestante = batalha.calcularChakra(ninja);

        Assert.assertEquals(80, chakraRestante);
    }

    @Test
    public void testCalcularDano() {
        Jutsu jutsu = new Jutsu(20, 50);
        Ninja ninja = new Ninja("Naruto", jutsu);

        Batalha batalha = new Batalha();
        int dano = batalha.calcularDano(ninja);

        Assert.assertEquals(50, dano);
    }

    @Test
    public void testLutar_ChakraIgual_DanoMenorPerde() {
        Jutsu jutsu1 = new Jutsu(10, 20);
        Ninja ninja1 = new Ninja("Naruto", jutsu1);
        ninja1.setChakra(100);

        Jutsu jutsu2 = new Jutsu(10, 40);
        Ninja ninja2 = new Ninja("Sasuke", jutsu2);
        ninja2.setChakra(100);

        Batalha batalha = new Batalha();
        Ninja vencedor = batalha.lutar(ninja1, ninja2);

        Assert.assertEquals(ninja2, vencedor);
    }

    @Test
    public void testLutar_ChakraMenorPerde() {
        Jutsu jutsu1 = new Jutsu(10, 20);
        Ninja ninja1 = new Ninja("Naruto", jutsu1);
        ninja1.setChakra(80);

        Jutsu jutsu2 = new Jutsu(10, 20);
        Ninja ninja2 = new Ninja("Sasuke", jutsu2);
        ninja2.setChakra(100);

        Batalha batalha = new Batalha();
        Ninja vencedor = batalha.lutar(ninja1, ninja2);

        Assert.assertEquals(ninja2, vencedor);
    }

    @Test
    public void testCalcularDano_NinjaInvalido() {
        Ninja ninjaSemJutsu = new Ninja("Naruto", null);

        Batalha batalha = new Batalha();
        int dano = batalha.calcularDano(ninjaSemJutsu);

        Assert.assertEquals(0, dano);
    }

    @Test(expected = NullPointerException.class)
    public void testCalcularDano_NinjaNulo() {

        Batalha batalha = new Batalha();

        batalha.calcularDano(null);

    }
}
