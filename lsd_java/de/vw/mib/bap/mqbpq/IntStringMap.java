/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbpq;

import de.vw.mib.hmi.utils.Preconditions;

public class IntStringMap {
    private int[] keys;
    private String[] values;
    private String defaultValue;
    static /* synthetic */ Class class$java$lang$String;
    static /* synthetic */ Class array$I;
    static /* synthetic */ Class array$Ljava$lang$String;

    public IntStringMap(String string, int[] nArray, String[] stringArray) {
        Preconditions.checkNotNull(string, new StringBuffer().append("Incoming ").append((class$java$lang$String == null ? (class$java$lang$String = IntStringMap.class$("java.lang.String")) : class$java$lang$String).getName()).append(" must not be null!").toString());
        Preconditions.checkNotNull(nArray, new StringBuffer().append("Incoming ").append((array$I == null ? (array$I = IntStringMap.class$("[I")) : array$I).getName()).append(" must not be null!").toString());
        Preconditions.checkNotNull(stringArray, new StringBuffer().append("Incoming ").append((array$Ljava$lang$String == null ? (array$Ljava$lang$String = IntStringMap.class$("[Ljava.lang.String;")) : array$Ljava$lang$String).getName()).append(" must not be null!").toString());
        if (nArray.length == 0 || stringArray.length == 0) {
            throw new IllegalArgumentException("Length of arrays given as parameters must not be zero.");
        }
        if (nArray.length != stringArray.length) {
            throw new IllegalArgumentException("The keys and the values arrays do not have the same size.");
        }
        if (string.equals("")) {
            throw new IllegalArgumentException("The default value must not be empty.");
        }
        for (int i2 = 0; i2 < stringArray.length; ++i2) {
            if (stringArray[i2] != null) continue;
            throw new IllegalArgumentException("String values must not be null.");
        }
        this.defaultValue = string;
        this.keys = nArray;
        this.values = stringArray;
    }

    public String get(int n) {
        for (int i2 = 0; i2 < this.keys.length; ++i2) {
            if (this.keys[i2] != n) continue;
            return this.values[i2];
        }
        return this.defaultValue;
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }
}

