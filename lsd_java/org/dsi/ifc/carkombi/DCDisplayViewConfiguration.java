/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.carkombi;

public class DCDisplayViewConfiguration {
    public int activeDisplayView;

    public DCDisplayViewConfiguration() {
        this.activeDisplayView = 0;
    }

    public DCDisplayViewConfiguration(int n) {
        this.activeDisplayView = n;
    }

    public int getActiveDisplayView() {
        return this.activeDisplayView;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(100);
        stringBuffer.append("DCDisplayViewConfiguration");
        stringBuffer.append('(');
        stringBuffer.append("activeDisplayView");
        stringBuffer.append('=');
        stringBuffer.append(this.activeDisplayView);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

