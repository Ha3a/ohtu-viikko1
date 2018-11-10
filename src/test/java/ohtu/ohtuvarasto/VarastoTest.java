package ohtu.ohtuvarasto;

import org.junit.*;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class VarastoTest {

    Varasto varasto;
    public final double vertailuTarkkuus = 0.0001;
    public final int kahdeksanInt = 8;
    public final int kymmenenInt = 10;
    public final double sata = 100.0;
    public final double kakskyt = 20.0;
    public final int kakskytInt = 20;
    public final double negaKymppi = -10;
    public final double negaKakskyt = -20.0;
    public final int ykstoista = 11;
    public final int kaksiInt = 2;
    public final int kakstoista = 12;
    public final int neljaInt = 4;
    

    @Before
    public void setUp() {
        varasto = new Varasto(kymmenenInt);
    }

    @Test
    public void konstruktoriLuoTyhjanVaraston() {
        assertEquals(0, varasto.getSaldo(), vertailuTarkkuus);
    }

    @Test
    public void uudellaVarastollaOikeaTilavuus() {
        assertEquals(kymmenenInt, varasto.getTilavuus(), vertailuTarkkuus);
    }

    @Test
    public void lisaysLisaaSaldoa() {
        varasto.lisaaVarastoon(kahdeksanInt);

        // saldon pitäisi olla sama kun lisätty määrä
        assertEquals(kahdeksanInt, varasto.getSaldo(), vertailuTarkkuus);
    }

    @Test
    public void lisaysLisaaPienentaaVapaataTilaa() {
        varasto.lisaaVarastoon(kahdeksanInt);

        // vapaata tilaa pitäisi vielä olla tilavuus-lisättävä määrä eli 2
        assertEquals(2, varasto.paljonkoMahtuu(), vertailuTarkkuus);
    }

    @Test
    public void ottaminenPalauttaaOikeanMaaran() {
        varasto.lisaaVarastoon(kahdeksanInt);

        double saatuMaara = varasto.otaVarastosta(kaksiInt);

        assertEquals(2, saatuMaara, vertailuTarkkuus);
    }

    @Test
    public void ottaminenLisääTilaa() {
        varasto.lisaaVarastoon(kahdeksanInt);

        varasto.otaVarastosta(kaksiInt);

        // varastossa pitäisi olla tilaa 10 - 8 + 2 eli 4
        assertEquals(neljaInt, varasto.paljonkoMahtuu(), vertailuTarkkuus);
    }

    @Test
    public void luodaanVarasto() {
        Varasto olutta = new Varasto(sata, kakskyt);

        assertEquals(kakskytInt, olutta.getSaldo(), vertailuTarkkuus);
    }

    @Test
    public void luodaanVarastoTyhja() {
        Varasto olutta = new Varasto(0.0, 0.0);

        assertEquals(0, olutta.getSaldo(), vertailuTarkkuus);
    }

    @Test
    public void luodaanVarastoNega() {
        Varasto olutta = new Varasto(negaKymppi, kakskyt);

        assertEquals(0, olutta.getTilavuus(), vertailuTarkkuus);
    }

    @Test
    public void luodaanVarastoNegaSaldo() {
        Varasto olutta = new Varasto(sata, negaKakskyt);

        assertEquals(0, olutta.getSaldo(), vertailuTarkkuus);
    }

    @Test
    public void luodaanVarastoTyhja1() {
        Varasto olutta = new Varasto(negaKakskyt);

        assertEquals(0, olutta.getTilavuus(), vertailuTarkkuus);
    }

    @Test
    public void otaVarasto() {

        double saatuMaara = varasto.otaVarastosta(-1);

        assertEquals(0, saatuMaara, vertailuTarkkuus);
    }

    @Test
    public void otaVarastoLiikaa() {

        varasto.lisaaVarastoon(ykstoista);

        double saatuMaara = varasto.otaVarastosta(kakstoista);

        assertEquals(kymmenenInt, saatuMaara, vertailuTarkkuus);
    }

    @Test
    public void lisaysNega() {
        varasto.lisaaVarastoon(1);
        varasto.lisaaVarastoon(-1);

        assertEquals(1, varasto.getSaldo(), vertailuTarkkuus);
    }

    //("saldo = " + saldo + ", vielä tilaa " + paljonkoMahtuu());
    @Test
    public void stringiTo() {

        String apu = varasto.toString();

        assertEquals("saldo = 0.0, vielä tilaa 10.0", apu);
    }
}
