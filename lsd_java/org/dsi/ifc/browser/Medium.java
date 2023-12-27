/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.browser;

public class Medium {
    public int id;
    public int mediumType;
    public String name;
    public boolean updateMedium;
    public int mediumState;

    public Medium() {
        this.id = 0;
        this.mediumType = 0;
        this.name = null;
        this.updateMedium = false;
        this.mediumState = 0;
    }

    public Medium(int n, int n2, String string, boolean bl, int n3) {
        this.id = n;
        this.mediumType = n2;
        this.name = string;
        this.updateMedium = bl;
        this.mediumState = n3;
    }

    public int getId() {
        return this.id;
    }

    public int getMediumType() {
        return this.mediumType;
    }

    public String getName() {
        return this.name;
    }

    public boolean isUpdateMedium() {
        return this.updateMedium;
    }

    public int getMediumState() {
        return this.mediumState;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(300);
        stringBuffer.append("Medium");
        stringBuffer.append('(');
        stringBuffer.append("id");
        stringBuffer.append('=');
        stringBuffer.append(this.id);
        stringBuffer.append(',');
        stringBuffer.append("mediumType");
        stringBuffer.append('=');
        stringBuffer.append(this.mediumType);
        stringBuffer.append(',');
        stringBuffer.append("name");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.name);
        stringBuffer.append('\"');
        stringBuffer.append(',');
        stringBuffer.append("updateMedium");
        stringBuffer.append('=');
        stringBuffer.append(this.updateMedium);
        stringBuffer.append(',');
        stringBuffer.append("mediumState");
        stringBuffer.append('=');
        stringBuffer.append(this.mediumState);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

