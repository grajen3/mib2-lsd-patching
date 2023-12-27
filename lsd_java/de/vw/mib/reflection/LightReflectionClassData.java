/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.reflection;

public class LightReflectionClassData {
    private final String fullClassName;
    private final String shortClassName;
    private final byte[] byteCode;

    public LightReflectionClassData(String string, String string2, byte[] byArray) {
        this.fullClassName = string;
        this.shortClassName = string2;
        this.byteCode = byArray;
    }

    public String getFullClassName() {
        return this.fullClassName;
    }

    public String getShortClassName() {
        return this.shortClassName;
    }

    public byte[] getByteCode() {
        return this.byteCode;
    }

    public String toString() {
        return new StringBuffer().append("LightReflectionClassData [fullClassName=").append(this.fullClassName).append("]").toString();
    }
}

