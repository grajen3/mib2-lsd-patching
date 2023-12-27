/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.phone.call;

public class SpellerBlockItem {
    String text;
    boolean knownToApplication;

    public SpellerBlockItem(String string, boolean bl) {
        this.text = string;
        this.knownToApplication = bl;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("SpellerBlockItem [text=");
        stringBuffer.append(this.text);
        stringBuffer.append(", knownToApplication=");
        stringBuffer.append(this.knownToApplication);
        stringBuffer.append("]");
        return stringBuffer.toString();
    }
}

