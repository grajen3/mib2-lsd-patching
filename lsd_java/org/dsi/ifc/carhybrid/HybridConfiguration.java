/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.carhybrid;

public class HybridConfiguration {
    public boolean ice;
    public boolean ee1;
    public boolean ee2;

    public HybridConfiguration() {
        this.ice = false;
        this.ee1 = false;
        this.ee2 = false;
    }

    public HybridConfiguration(boolean bl, boolean bl2, boolean bl3) {
        this.ice = bl;
        this.ee1 = bl2;
        this.ee2 = bl3;
    }

    public boolean isIce() {
        return this.ice;
    }

    public boolean isEe1() {
        return this.ee1;
    }

    public boolean isEe2() {
        return this.ee2;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(100);
        stringBuffer.append("HybridConfiguration");
        stringBuffer.append('(');
        stringBuffer.append("ice");
        stringBuffer.append('=');
        stringBuffer.append(this.ice);
        stringBuffer.append(',');
        stringBuffer.append("ee1");
        stringBuffer.append('=');
        stringBuffer.append(this.ee1);
        stringBuffer.append(',');
        stringBuffer.append("ee2");
        stringBuffer.append('=');
        stringBuffer.append(this.ee2);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

