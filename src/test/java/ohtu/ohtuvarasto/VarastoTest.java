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
    double vertailuTarkkuus = 0.0001;

    @Before
    public void setUp() {
        varasto = new Varasto(10);
    }

    @Test
    public void konstruktoriLuoTyhjanVaraston() {
        assertEquals(0, varasto.getSaldo(), vertailuTarkkuus);
    }

    @Test
    public void uudellaVarastollaOikeaTilavuus() {
        assertEquals(10, varasto.getTilavuus(), vertailuTarkkuus);
    }

    @Test
    public void lisaysLisaaSaldoa() {
        varasto.lisaaVarastoon(8);

        // saldon pitäisi olla sama kun lisätty määrä
        assertEquals(8, varasto.getSaldo(), vertailuTarkkuus);
    }

    @Test
    public void lisaysLisaaPienentaaVapaataTilaa() {
        varasto.lisaaVarastoon(8);

        // vapaata tilaa pitäisi vielä olla tilavuus-lisättävä määrä eli 2
        assertEquals(2, varasto.paljonkoMahtuu(), vertailuTarkkuus);
    }

    @Test
    public void ottaminenPalauttaaOikeanMaaran() {
        varasto.lisaaVarastoon(8);

        double saatuMaara = varasto.otaVarastosta(2);

        assertEquals(2, saatuMaara, vertailuTarkkuus);
    }

    @Test
    public void ottaminenLisääTilaa() {
        varasto.lisaaVarastoon(8);

        varasto.otaVarastosta(2);

        // varastossa pitäisi olla tilaa 10 - 8 + 2 eli 4
        assertEquals(4, varasto.paljonkoMahtuu(), vertailuTarkkuus);
    }

    @Test
    public void luodaanVarasto() {
        Varasto olutta = new Varasto(100.0, 20.0);

        assertEquals(20, olutta.getSaldo(), vertailuTarkkuus);
    }

    @Test
    public void luodaanVarastoTyhja() {
        Varasto olutta = new Varasto(0.0, 0.0);

        assertEquals(0, olutta.getSaldo(), vertailuTarkkuus);
    }

    @Test
    public void luodaanVarastoNega() {
        Varasto olutta = new Varasto(-10.0, 20.0);

        assertEquals(0, olutta.getTilavuus(), vertailuTarkkuus);
    }

    @Test
    public void luodaanVarastoNegaSaldo() {
        Varasto olutta = new Varasto(100.0, -20.0);

        assertEquals(0, olutta.getSaldo(), vertailuTarkkuus);
    }

    @Test
    public void luodaanVarastoTyhja1() {
        Varasto olutta = new Varasto(-20.0);

        assertEquals(0, olutta.getTilavuus(), vertailuTarkkuus);
    }

    @Test
    public void otaVarasto() {

        double saatuMaara = varasto.otaVarastosta(-2);

        assertEquals(0, saatuMaara, vertailuTarkkuus);
    }

    @Test
    public void otaVarastoLiikaa() {

        varasto.lisaaVarastoon(11);

        double saatuMaara = varasto.otaVarastosta(12);

        assertEquals(10, saatuMaara, vertailuTarkkuus);
    }

    @Test
    public void lisaysNega() {
        varasto.lisaaVarastoon(1);
        varasto.lisaaVarastoon(-8);

        
        assertEquals(1, varasto.getSaldo(), vertailuTarkkuus);
    }

    
    //("saldo = " + saldo + ", vielä tilaa " + paljonkoMahtuu());
    
        @Test
    public void stringiTo() {
        
        String apu = varasto.toString();
                      
        assertEquals("saldo = 0.0, vielä tilaa 10.0", apu);
    }
}
