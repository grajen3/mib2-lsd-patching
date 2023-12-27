/*
 * Decompiled with CFR 0.152.
 */
package java.text;

import com.ibm.oti.util.Msg;
import java.io.InvalidObjectException;
import java.text.Format$Field;

public class NumberFormat$Field
extends Format$Field {
    public static final NumberFormat$Field SIGN = new NumberFormat$Field("sign");
    public static final NumberFormat$Field INTEGER = new NumberFormat$Field("integer");
    public static final NumberFormat$Field FRACTION = new NumberFormat$Field("fraction");
    public static final NumberFormat$Field EXPONENT = new NumberFormat$Field("exponent");
    public static final NumberFormat$Field EXPONENT_SIGN = new NumberFormat$Field("exponent sign");
    public static final NumberFormat$Field EXPONENT_SYMBOL = new NumberFormat$Field("exponent symbol");
    public static final NumberFormat$Field DECIMAL_SEPARATOR = new NumberFormat$Field("decimal separator");
    public static final NumberFormat$Field GROUPING_SEPARATOR = new NumberFormat$Field("grouping separator");
    public static final NumberFormat$Field PERCENT = new NumberFormat$Field("percent");
    public static final NumberFormat$Field PERMILLE = new NumberFormat$Field("per mille");
    public static final NumberFormat$Field CURRENCY = new NumberFormat$Field("currency");

    protected NumberFormat$Field(String string) {
        super(string);
    }

    @Override
    protected Object readResolve() {
        String string = this.getName();
        if (string == null) {
            throw new InvalidObjectException(Msg.getString("K0344", "NumberFormat.Field"));
        }
        if (string.equals(INTEGER.getName())) {
            return INTEGER;
        }
        if (string.equals(FRACTION.getName())) {
            return FRACTION;
        }
        if (string.equals(EXPONENT.getName())) {
            return EXPONENT;
        }
        if (string.equals(EXPONENT_SIGN.getName())) {
            return EXPONENT_SIGN;
        }
        if (string.equals(EXPONENT_SYMBOL.getName())) {
            return EXPONENT_SYMBOL;
        }
        if (string.equals(CURRENCY.getName())) {
            return CURRENCY;
        }
        if (string.equals(DECIMAL_SEPARATOR.getName())) {
            return DECIMAL_SEPARATOR;
        }
        if (string.equals(GROUPING_SEPARATOR.getName())) {
            return GROUPING_SEPARATOR;
        }
        if (string.equals(PERCENT.getName())) {
            return PERCENT;
        }
        if (string.equals(PERMILLE.getName())) {
            return PERMILLE;
        }
        if (string.equals(SIGN.getName())) {
            return SIGN;
        }
        throw new InvalidObjectException(Msg.getString("K0344", "NumberFormat.Field"));
    }
}

