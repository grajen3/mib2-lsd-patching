/*
 * Decompiled with CFR 0.152.
 */
package java.lang;

import java.io.Serializable;

public final class Boolean
implements Serializable {
    private static final long serialVersionUID;
    private final boolean value;
    public static final Class TYPE;
    public static final Boolean TRUE;
    public static final Boolean FALSE;

    static {
        TYPE = super.getClass().getComponentType();
        TRUE = new Boolean(true);
        FALSE = new Boolean(false);
    }

    public Boolean(String string) {
        this(Boolean.toBoolean(string));
    }

    public Boolean(boolean bl) {
        this.value = bl;
    }

    public boolean booleanValue() {
        return this.value;
    }

    public boolean equals(Object object) {
        return object == this || object instanceof Boolean && this.value == ((Boolean)object).value;
    }

    public static boolean getBoolean(String string) {
        if (string == null || string.length() == 0) {
            return false;
        }
        return Boolean.toBoolean(System.getProperty(string));
    }

    public int hashCode() {
        return this.value ? 1231 : 1237;
    }

    static boolean toBoolean(String string) {
        return string != null && string.toLowerCase().equals("true");
    }

    public String toString() {
        return String.valueOf(this.value);
    }

    public static String toString(boolean bl) {
        return String.valueOf(bl);
    }

    public static Boolean valueOf(String string) {
        return Boolean.toBoolean(string) ? TRUE : FALSE;
    }

    public static Boolean valueOf(boolean bl) {
        return bl ? TRUE : FALSE;
    }
}

