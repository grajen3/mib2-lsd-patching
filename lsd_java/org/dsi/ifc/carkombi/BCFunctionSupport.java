/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.carkombi;

public class BCFunctionSupport {
    public boolean resetTrip;

    public BCFunctionSupport() {
        this.resetTrip = false;
    }

    public BCFunctionSupport(boolean bl) {
        this.resetTrip = bl;
    }

    public boolean isResetTrip() {
        return this.resetTrip;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(50);
        stringBuffer.append("BCFunctionSupport");
        stringBuffer.append('(');
        stringBuffer.append("resetTrip");
        stringBuffer.append('=');
        stringBuffer.append(this.resetTrip);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

