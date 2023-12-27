/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.telephone;

public class ServiceProvider {
    public boolean displayConditionProviderName;
    public boolean displayConditionServiceProviderName;
    public String telServiceProviderName;

    public ServiceProvider() {
    }

    public ServiceProvider(boolean bl, boolean bl2, String string) {
        this.displayConditionProviderName = bl;
        this.displayConditionServiceProviderName = bl2;
        this.telServiceProviderName = string;
    }

    public boolean isDisplayConditionProviderName() {
        return this.displayConditionProviderName;
    }

    public boolean isDisplayConditionServiceProviderName() {
        return this.displayConditionServiceProviderName;
    }

    public String getTelServiceProviderName() {
        return this.telServiceProviderName;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(300);
        stringBuffer.append("ServiceProvider");
        stringBuffer.append('(');
        stringBuffer.append("displayConditionProviderName");
        stringBuffer.append('=');
        stringBuffer.append(this.displayConditionProviderName);
        stringBuffer.append(',');
        stringBuffer.append("displayConditionServiceProviderName");
        stringBuffer.append('=');
        stringBuffer.append(this.displayConditionServiceProviderName);
        stringBuffer.append(',');
        stringBuffer.append("telServiceProviderName");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.telServiceProviderName);
        stringBuffer.append('\"');
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

