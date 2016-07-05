package de.uni_hamburg.informatik.swt.se2.kino.fachwerte;

import org.junit.Test;

import static org.junit.Assert.*;

public class GeldbetragTest
{
    private Geldbetrag _betrag;

    public GeldbetragTest() {
        _betrag = Geldbetrag.fromInt(300);
    }

    @Test
    public void testFromInt()
    {
        assertEquals(_betrag, Geldbetrag.fromInt(300));

        assertNotEquals(_betrag, Geldbetrag.fromInt(123));
    }

    @Test
    public void testFromString()
    {
        assertEquals(_betrag, Geldbetrag.fromString("3,00"));
        assertEquals(_betrag, Geldbetrag.fromString("3.00"));
        assertEquals(_betrag, Geldbetrag.fromString("300"));

        assertNotEquals(_betrag, Geldbetrag.fromString(""));
        assertNotEquals(_betrag, Geldbetrag.fromString("db837dae7dg783"));
    }

    @Test
    public void testGetFormatiertenString()
    {
        assertEquals(_betrag.getFormatiertenString(), "3,00 €");
    }

    @Test
    public void testAdd()
    {
        assertEquals(_betrag.add(Geldbetrag.fromInt(123)), Geldbetrag.fromInt(423));
    }

    @Test
    public void testSub()
    {
        assertEquals(_betrag.sub(Geldbetrag.fromInt(123)), Geldbetrag.fromInt(177));
    }

    @Test
    public void testScale()
    {
        assertEquals(_betrag.scale(3), Geldbetrag.fromInt(900));
    }

    @Test
    public void testEquals()
    {
        assertEquals(_betrag, Geldbetrag.fromInt(300));
    }
}