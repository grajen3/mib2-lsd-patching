/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.exboxm;

public class MobileDeviceLinkStatus {
    public int linkType;
    public boolean navigationActive;
    public boolean telephoneActive;

    public MobileDeviceLinkStatus() {
        this.linkType = 0;
        this.navigationActive = false;
        this.telephoneActive = false;
    }

    public MobileDeviceLinkStatus(int n, boolean bl, boolean bl2) {
        this.linkType = n;
        this.navigationActive = bl;
        this.telephoneActive = bl2;
    }

    public int getLinkType() {
        return this.linkType;
    }

    public boolean isNavigationActive() {
        return this.navigationActive;
    }

    public boolean isTelephoneActive() {
        return this.telephoneActive;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(200);
        stringBuffer.append("MobileDeviceLinkStatus");
        stringBuffer.append('(');
        stringBuffer.append("linkType");
        stringBuffer.append('=');
        stringBuffer.append(this.linkType);
        stringBuffer.append(',');
        stringBuffer.append("navigationActive");
        stringBuffer.append('=');
        stringBuffer.append(this.navigationActive);
        stringBuffer.append(',');
        stringBuffer.append("telephoneActive");
        stringBuffer.append('=');
        stringBuffer.append(this.telephoneActive);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

