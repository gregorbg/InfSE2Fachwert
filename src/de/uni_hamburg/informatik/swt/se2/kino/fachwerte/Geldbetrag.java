package de.uni_hamburg.informatik.swt.se2.kino.fachwerte;

import java.text.NumberFormat;
import java.util.Locale;

public final class Geldbetrag
{
    private static final NumberFormat currencyFormat = NumberFormat.getCurrencyInstance(
            Locale.getDefault());

    public static Geldbetrag fromInt(int betrag) {
        return new Geldbetrag(betrag);
    }

    public static Geldbetrag fromString(String formatBetrag) {
        //TODO implement
        return new Geldbetrag(0);
    }

    private int _betrag;

    private Geldbetrag(int betrag) {
        _betrag = betrag;
    }

    public String getFormatiertenString() {
        return currencyFormat.format(_betrag);
    }

    public Geldbetrag add(Geldbetrag other) {
        return new Geldbetrag(_betrag + other._betrag);
    }

    public Geldbetrag sub(Geldbetrag other) {
        return new Geldbetrag(_betrag - other._betrag);
    }

    public Geldbetrag scale(int scalar) {
        return new Geldbetrag(_betrag * scalar);
    }
}
