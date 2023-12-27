/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.kombifastlist;

public class DataInitials {
    public String initial;
    public int occuranceCounter;

    public DataInitials() {
        this.initial = " ";
        this.occuranceCounter = 0;
    }

    public DataInitials(String string, int n) {
        this.initial = string;
        this.occuranceCounter = n;
    }

    public int getOccuranceCounter() {
        return this.occuranceCounter;
    }

    public String getInitial() {
        return this.initial;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(150);
        stringBuffer.append("DataInitials");
        stringBuffer.append('(');
        stringBuffer.append("initial");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.initial);
        stringBuffer.append('\"');
        stringBuffer.append(',');
        stringBuffer.append("occuranceCounter");
        stringBuffer.append('=');
        stringBuffer.append(this.occuranceCounter);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

