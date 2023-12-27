/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.navigation;

public class Brand {
    public int brandUid;
    public int iconIndex;
    public int subIconIndex;
    public boolean visible;
    public boolean preferred;
    public String description;

    public Brand() {
        this.brandUid = 0;
        this.iconIndex = 0;
        this.subIconIndex = 0;
        this.description = "";
        this.visible = true;
        this.preferred = false;
    }

    public Brand(int n, int n2, int n3, boolean bl, boolean bl2, String string) {
        this.brandUid = n;
        this.iconIndex = n2;
        this.subIconIndex = n3;
        this.visible = bl;
        this.preferred = bl2;
        this.description = string;
    }

    public int getBrandUid() {
        return this.brandUid;
    }

    public int getIconIndex() {
        return this.iconIndex;
    }

    public int getSubIconIndex() {
        return this.subIconIndex;
    }

    public boolean isVisible() {
        return this.visible;
    }

    public boolean isPreferred() {
        return this.preferred;
    }

    public String getDescription() {
        return this.description;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(350);
        stringBuffer.append("Brand");
        stringBuffer.append('(');
        stringBuffer.append("brandUid");
        stringBuffer.append('=');
        stringBuffer.append(this.brandUid);
        stringBuffer.append(',');
        stringBuffer.append("iconIndex");
        stringBuffer.append('=');
        stringBuffer.append(this.iconIndex);
        stringBuffer.append(',');
        stringBuffer.append("subIconIndex");
        stringBuffer.append('=');
        stringBuffer.append(this.subIconIndex);
        stringBuffer.append(',');
        stringBuffer.append("visible");
        stringBuffer.append('=');
        stringBuffer.append(this.visible);
        stringBuffer.append(',');
        stringBuffer.append("preferred");
        stringBuffer.append('=');
        stringBuffer.append(this.preferred);
        stringBuffer.append(',');
        stringBuffer.append("description");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.description);
        stringBuffer.append('\"');
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

