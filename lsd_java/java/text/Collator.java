/*
 * Decompiled with CFR 0.152.
 */
package java.text;

import com.ibm.oti.locale.Locale;
import com.ibm.oti.util.ExtendedResourceBundle;
import com.ibm.oti.util.PriviAction;
import java.security.AccessController;
import java.text.CollationKey;
import java.text.CollationRules;
import java.text.Format;
import java.text.ParseException;
import java.text.RuleBasedCollator;
import java.util.Comparator;
import java.util.MissingResourceException;
import java.util.Vector;

public abstract class Collator
implements Comparator,
Cloneable {
    static final int EQUAL;
    static final int GREATER;
    static final int LESS;
    public static final int NO_DECOMPOSITION;
    public static final int CANONICAL_DECOMPOSITION;
    public static final int FULL_DECOMPOSITION;
    public static final int PRIMARY;
    public static final int SECONDARY;
    public static final int TERTIARY;
    public static final int IDENTICAL;
    private static int CACHE_SIZE;
    private static Vector cache;
    private int strength = 2;
    private int decomposition = 1;

    static {
        cache = new Vector();
        String string = (String)AccessController.doPrivileged(new PriviAction("collator.cache"));
        if (string != null) {
            try {
                CACHE_SIZE = Integer.parseInt(string);
            }
            catch (NumberFormatException numberFormatException) {
                CACHE_SIZE = 6;
            }
        } else {
            CACHE_SIZE = 6;
        }
    }

    protected Collator() {
    }

    public Object clone() {
        try {
            return super.clone();
        }
        catch (CloneNotSupportedException cloneNotSupportedException) {
            return null;
        }
    }

    @Override
    public int compare(Object object, Object object2) {
        return this.compare((String)object, (String)object2);
    }

    public abstract int compare(String string, String string2) {
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Collator)) {
            return false;
        }
        Collator collator = (Collator)object;
        return this.strength == collator.strength && this.decomposition == collator.decomposition;
    }

    public boolean equals(String string, String string2) {
        return this.compare(string, string2) == 0;
    }

    public static java.util.Locale[] getAvailableLocales() {
        return java.util.Locale.getAvailableLocales();
    }

    public abstract CollationKey getCollationKey(String string) {
    }

    public int getDecomposition() {
        return this.decomposition;
    }

    public static Collator getInstance() {
        return Collator.getInstance(java.util.Locale.getDefault());
    }

    public static Collator getInstance(java.util.Locale locale) {
        String string = locale.toString();
        int n = cache.size() - 1;
        while (n >= 0) {
            if (cache.elementAt(n).equals(string)) {
                return (Collator)((Collator)cache.elementAt(n - 1)).clone();
            }
            n -= 2;
        }
        ExtendedResourceBundle extendedResourceBundle = (ExtendedResourceBundle)Format.getCollationBundle(locale);
        String string2 = (String)extendedResourceBundle.getObject(Locale.COLLATION);
        try {
            Object object;
            int n2 = 1;
            try {
                object = extendedResourceBundle.getObject(Locale.COLLATIONDECOMP);
                n2 = (Integer)object;
            }
            catch (MissingResourceException missingResourceException) {}
            object = new RuleBasedCollator(new StringBuffer(String.valueOf(CollationRules.DEFAULTRULES)).append(string2).toString(), n2);
            ((Collator)object).setDecomposition(0);
            if (CACHE_SIZE > 0) {
                if (cache.size() >= CACHE_SIZE) {
                    cache.removeElementAt(0);
                    cache.removeElementAt(0);
                }
                cache.addElement(((Collator)object).clone());
                cache.addElement(string);
            }
            return object;
        }
        catch (ParseException parseException) {
            throw new IllegalArgumentException(parseException.getMessage());
        }
    }

    public int getStrength() {
        return this.strength;
    }

    public abstract int hashCode() {
    }

    public void setDecomposition(int n) {
        switch (n) {
            case 0: 
            case 1: 
            case 2: {
                break;
            }
            default: {
                throw new IllegalArgumentException();
            }
        }
        this.decomposition = n;
    }

    public void setStrength(int n) {
        switch (n) {
            case 0: 
            case 1: 
            case 2: 
            case 3: {
                break;
            }
            default: {
                throw new IllegalArgumentException();
            }
        }
        this.strength = n;
    }
}

