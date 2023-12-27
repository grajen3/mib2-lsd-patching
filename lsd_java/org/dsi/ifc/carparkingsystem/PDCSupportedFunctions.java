/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.carparkingsystem;

public class PDCSupportedFunctions {
    public boolean pla;
    public boolean ipa;
    public boolean pp;
    public boolean gp;

    public PDCSupportedFunctions() {
        this.pla = false;
        this.ipa = false;
        this.pp = false;
        this.gp = false;
    }

    public PDCSupportedFunctions(boolean bl, boolean bl2, boolean bl3, boolean bl4) {
        this.pla = bl;
        this.ipa = bl2;
        this.pp = bl3;
        this.gp = bl4;
    }

    public boolean isPla() {
        return this.pla;
    }

    public boolean isIpa() {
        return this.ipa;
    }

    public boolean isPp() {
        return this.pp;
    }

    public boolean isGp() {
        return this.gp;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(150);
        stringBuffer.append("PDCSupportedFunctions");
        stringBuffer.append('(');
        stringBuffer.append("pla");
        stringBuffer.append('=');
        stringBuffer.append(this.pla);
        stringBuffer.append(',');
        stringBuffer.append("ipa");
        stringBuffer.append('=');
        stringBuffer.append(this.ipa);
        stringBuffer.append(',');
        stringBuffer.append("pp");
        stringBuffer.append('=');
        stringBuffer.append(this.pp);
        stringBuffer.append(',');
        stringBuffer.append("gp");
        stringBuffer.append('=');
        stringBuffer.append(this.gp);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

