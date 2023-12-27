/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.smartphoneintegration.common;

public class SingleFeatureSupport {
    private boolean coded = true;
    private boolean swap = false;

    public void setCoded(boolean bl) {
        this.coded = bl;
    }

    public boolean isCoded() {
        return this.coded;
    }

    public void setSWAP(boolean bl) {
        this.swap = bl;
    }

    public boolean isSwap() {
        return this.swap;
    }

    public boolean isSupported() {
        return this.coded && this.swap;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(50);
        stringBuffer.append("Diag = ");
        stringBuffer.append(this.coded);
        stringBuffer.append(',');
        stringBuffer.append("SWAP = ");
        stringBuffer.append(this.swap);
        return stringBuffer.toString();
    }
}

