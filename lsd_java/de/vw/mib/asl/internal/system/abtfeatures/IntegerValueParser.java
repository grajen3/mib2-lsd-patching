/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.system.abtfeatures;

public class IntegerValueParser {
    private final int maxValue;

    IntegerValueParser() {
        this(Short.MAX_VALUE);
    }

    IntegerValueParser(short s) {
        this.maxValue = s;
    }

    public int parse(byte[] byArray) {
        this.checkRawValue(byArray);
        int n = this.parseInt(byArray);
        this.checkValue(n);
        return n;
    }

    protected void checkValue(int n) {
        if (n < 0) {
            throw new IllegalArgumentException(new StringBuffer().append("Parsed value is lower than 0: ").append(n).toString());
        }
        if (n > this.maxValue) {
            throw new IllegalArgumentException(new StringBuffer().append("Parsed value exceeds the maximium of ").append(this.maxValue).append(": ").append(n).toString());
        }
    }

    protected void checkRawValue(byte[] byArray) {
        if (byArray == null) {
            throw new IllegalArgumentException("Given raw value must not be null.");
        }
        if (byArray.length != 2) {
            throw new IllegalArgumentException(new StringBuffer().append("Raw byte array value must have the size of 2. Size is ").append(byArray.length).toString());
        }
    }

    protected int parseInt(byte[] byArray) {
        int n = byArray[0] & 0xFF;
        int n2 = byArray[1] & 0xFF;
        return (short)((n << 8) + n2);
    }
}

