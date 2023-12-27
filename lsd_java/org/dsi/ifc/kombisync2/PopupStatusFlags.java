/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.kombisync2;

public class PopupStatusFlags {
    public int statusFlags;

    public PopupStatusFlags() {
        this.statusFlags = 0;
    }

    public PopupStatusFlags(int n) {
        this.statusFlags = n;
    }

    public int getStatusFlags() {
        return this.statusFlags;
    }

    public boolean isRVCpossible() {
        return 0 != (this.statusFlags & 0x80);
    }

    public boolean isSDSpossible() {
        return 0 != (this.statusFlags & 0x40);
    }

    public boolean isWithoutFolder() {
        return 0 != (this.statusFlags & 4);
    }

    public boolean isBackgroundQuittAllowed() {
        return 0 != (this.statusFlags & 2);
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(100);
        stringBuffer.append("PopupStatusFlags");
        stringBuffer.append('(');
        stringBuffer.append("statusFlags");
        stringBuffer.append('=');
        stringBuffer.append(this.statusFlags);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

