/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.global;

import java.io.StringWriter;

public class CharacterInfo {
    public int value;
    public int index;

    public CharacterInfo() {
        this.value = 0;
        this.index = 0;
    }

    public CharacterInfo(int n, int n2) {
        this.value = n;
        this.index = n2;
    }

    public int getValue() {
        return this.value;
    }

    public int getIndex() {
        return this.index;
    }

    public String toString() {
        StringWriter stringWriter = new StringWriter();
        stringWriter.write("CharacterInfo(");
        stringWriter.write(String.valueOf(this.value));
        stringWriter.write(",");
        stringWriter.write(String.valueOf(this.index));
        stringWriter.write(")");
        return stringWriter.toString();
    }
}

