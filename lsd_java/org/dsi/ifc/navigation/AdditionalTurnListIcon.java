/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.navigation;

public class AdditionalTurnListIcon {
    public int type;
    public int iconId;
    public int variant;

    public AdditionalTurnListIcon() {
        this.type = 0;
        this.iconId = 0;
        this.variant = 0;
    }

    public AdditionalTurnListIcon(int n, int n2, int n3) {
        this.type = n;
        this.iconId = n2;
        this.variant = n3;
    }

    public int getType() {
        return this.type;
    }

    public int getIconId() {
        return this.iconId;
    }

    public int getVariant() {
        return this.variant;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(150);
        stringBuffer.append("AdditionalTurnListIcon");
        stringBuffer.append('(');
        stringBuffer.append("type");
        stringBuffer.append('=');
        stringBuffer.append(this.type);
        stringBuffer.append(',');
        stringBuffer.append("iconId");
        stringBuffer.append('=');
        stringBuffer.append(this.iconId);
        stringBuffer.append(',');
        stringBuffer.append("variant");
        stringBuffer.append('=');
        stringBuffer.append(this.variant);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

