/*
 * Decompiled with CFR 0.152.
 */
package java.util;

import com.ibm.oti.util.ExtendedResourceBundle;
import com.ibm.oti.util.Msg;
import java.io.Serializable;
import java.util.Hashtable;
import java.util.Locale;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

public final class Currency
implements Serializable {
    private static final long serialVersionUID;
    private static Hashtable codesToCurrencies;
    private String currencyCode;
    private static String currencyVars;
    private transient int defaultFractionDigits;

    static {
        codesToCurrencies = new Hashtable();
        currencyVars = "EURO, HK, PREEURO";
    }

    private Currency(String string) {
        this.currencyCode = string;
    }

    public static Currency getInstance(String string) {
        Currency currency = (Currency)codesToCurrencies.get(string);
        if (currency == null) {
            ResourceBundle resourceBundle = Locale.getBundle("ISO4CurrenciesToDigits", Locale.getDefault());
            currency = new Currency(string);
            String string2 = null;
            try {
                string2 = resourceBundle.getString(string);
            }
            catch (MissingResourceException missingResourceException) {
                throw new IllegalArgumentException(Msg.getString("K0322", string));
            }
            currency.defaultFractionDigits = Integer.parseInt(string2);
            codesToCurrencies.put(string, currency);
        }
        return currency;
    }

    public static Currency getInstance(Locale locale) {
        String string = locale.getCountry();
        String string2 = locale.getVariant();
        if (!string2.equals("") && currencyVars.indexOf(string2) > -1) {
            string = new StringBuffer(String.valueOf(string)).append("_").append(string2).toString();
        }
        ResourceBundle resourceBundle = Locale.getBundle("ISO4Currencies", Locale.getDefault());
        String string3 = null;
        try {
            string3 = resourceBundle.getString(string);
        }
        catch (MissingResourceException missingResourceException) {
            if (string2.equals("EURO")) {
                return Currency.getInstance("EUR");
            }
            throw new IllegalArgumentException(Msg.getString("K0323", locale.toString()));
        }
        if (string3.equals("None")) {
            return null;
        }
        return Currency.getInstance(string3);
    }

    public String getCurrencyCode() {
        return this.currencyCode;
    }

    public String getSymbol() {
        return this.getSymbol(Locale.getDefault());
    }

    public String getSymbol(Locale locale) {
        if (locale.getCountry().equals("")) {
            return this.currencyCode;
        }
        ExtendedResourceBundle extendedResourceBundle = (ExtendedResourceBundle)Locale.getBundle("Locale", locale);
        if (((String)extendedResourceBundle.getObject(com.ibm.oti.locale.Locale.INTL_CURRENCY_SYMBOL)).equals(this.currencyCode)) {
            return (String)extendedResourceBundle.getObject(com.ibm.oti.locale.Locale.CURRENCY_SYMBOL);
        }
        ResourceBundle resourceBundle = null;
        try {
            resourceBundle = Locale.getBundle("Currency", locale);
        }
        catch (MissingResourceException missingResourceException) {
            return this.currencyCode;
        }
        if (!resourceBundle.getLocale().getCountry().equals(locale.getCountry())) {
            return this.currencyCode;
        }
        String string = (String)resourceBundle.handleGetObject(this.currencyCode);
        if (string != null) {
            return string;
        }
        return this.currencyCode;
    }

    public int getDefaultFractionDigits() {
        return this.defaultFractionDigits;
    }

    public String toString() {
        return this.currencyCode;
    }

    private Object readResolve() {
        return Currency.getInstance(this.currencyCode);
    }
}

