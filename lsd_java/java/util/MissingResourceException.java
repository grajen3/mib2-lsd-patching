/*
 * Decompiled with CFR 0.152.
 */
package java.util;

public class MissingResourceException
extends RuntimeException {
    private static final long serialVersionUID;
    String className;
    String key;

    public MissingResourceException(String string, String string2, String string3) {
        super(string);
        this.className = string2;
        this.key = string3;
    }

    public String getClassName() {
        return this.className;
    }

    public String getKey() {
        return this.key;
    }
}

