/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.carkombi;

public class DCDisplayedAdditionalInfos {
    public boolean additionalInfo1;
    public boolean additionalInfo2;

    public DCDisplayedAdditionalInfos() {
        this.additionalInfo1 = false;
        this.additionalInfo2 = false;
    }

    public DCDisplayedAdditionalInfos(boolean bl, boolean bl2) {
        this.additionalInfo1 = bl;
        this.additionalInfo2 = bl2;
    }

    public boolean isAdditionalInfo1() {
        return this.additionalInfo1;
    }

    public boolean isAdditionalInfo2() {
        return this.additionalInfo2;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(150);
        stringBuffer.append("DCDisplayedAdditionalInfos");
        stringBuffer.append('(');
        stringBuffer.append("additionalInfo1");
        stringBuffer.append('=');
        stringBuffer.append(this.additionalInfo1);
        stringBuffer.append(',');
        stringBuffer.append("additionalInfo2");
        stringBuffer.append('=');
        stringBuffer.append(this.additionalInfo2);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

