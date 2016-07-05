package de.uni_hamburg.informatik.swt.se2.kino.fachwerte;

import java.text.NumberFormat;
import java.util.Locale;

public final class Geldbetrag
{
    private static final NumberFormat currencyFormat = NumberFormat.getCurrencyInstance(
            Locale.getDefault());

    public static Geldbetrag fromInt(int betrag)
    {
        assert betrag >= 0 : "Nö";

        return new Geldbetrag(betrag);
    }

    public static Geldbetrag fromString(String formatBetrag)
    {
        //TODO better regEx
        String eurocent = formatBetrag.replaceAll("\\D", "");

        Geldbetrag betrag;
        if (eurocent.length() == 0)
        {
            betrag = fromInt(0);
        }
        else if (eurocent.length() > 10 || Long.parseLong(eurocent) > Integer.MAX_VALUE)
        {
            betrag = fromInt(Integer.MAX_VALUE);
        }
        else
        {
            betrag = fromInt(Integer.parseInt(eurocent));
        }

        return betrag;
    }

    private int _betrag;

    private Geldbetrag(int betrag)
    {
        _betrag = betrag;
    }

    public String getFormatiertenString()
    {
        return currencyFormat.format(_betrag / 100f);
    }

    public Geldbetrag add(Geldbetrag other)
    {
        return new Geldbetrag(_betrag + other._betrag);
    }

    public Geldbetrag sub(Geldbetrag other)
    {
        return new Geldbetrag(_betrag - other._betrag);
    }

    public Geldbetrag scale(int scalar)
    {
        return new Geldbetrag(_betrag * scalar);
    }

    @Override
    public boolean equals(Object obj)
    {
        return obj instanceof Geldbetrag && ((Geldbetrag) obj)._betrag == _betrag;
    }

    @Override
    public int hashCode()
    {
        return _betrag;
    }
}
