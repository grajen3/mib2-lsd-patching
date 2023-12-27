/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.swap;

public class ConfigInfo {
    public String componentName;
    public String[] packets;
    public String[] configs;

    public ConfigInfo() {
        this.componentName = null;
        this.packets = null;
        this.configs = null;
    }

    public ConfigInfo(String string, String[] stringArray, String[] stringArray2) {
        this.componentName = string;
        this.packets = stringArray;
        this.configs = stringArray2;
    }

    public String getComponentName() {
        return this.componentName;
    }

    public String[] getPackets() {
        return this.packets;
    }

    public String[] getConfigs() {
        return this.configs;
    }

    public String toString() {
        int n;
        int n2;
        int n3;
        StringBuffer stringBuffer = new StringBuffer(200);
        stringBuffer.append("ConfigInfo");
        stringBuffer.append('(');
        stringBuffer.append("componentName");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.componentName);
        stringBuffer.append('\"');
        stringBuffer.append(',');
        stringBuffer.append("packets");
        stringBuffer.append('[');
        if (this.packets != null) {
            stringBuffer.append(this.packets.length);
        }
        stringBuffer.append(']');
        stringBuffer.append('=');
        stringBuffer.append('{');
        if (this.packets != null) {
            n3 = this.packets.length;
            n2 = n3 - 1;
            for (n = 0; n < n3; ++n) {
                stringBuffer.append('\"');
                stringBuffer.append(this.packets[n]);
                stringBuffer.append('\"');
                if (n >= n2) continue;
                stringBuffer.append(',');
            }
        } else {
            stringBuffer.append(this.packets);
        }
        stringBuffer.append('}');
        stringBuffer.append(',');
        stringBuffer.append("configs");
        stringBuffer.append('[');
        if (this.configs != null) {
            stringBuffer.append(this.configs.length);
        }
        stringBuffer.append(']');
        stringBuffer.append('=');
        stringBuffer.append('{');
        if (this.configs != null) {
            n3 = this.configs.length;
            n2 = n3 - 1;
            for (n = 0; n < n3; ++n) {
                stringBuffer.append('\"');
                stringBuffer.append(this.configs[n]);
                stringBuffer.append('\"');
                if (n >= n2) continue;
                stringBuffer.append(',');
            }
        } else {
            stringBuffer.append(this.configs);
        }
        stringBuffer.append('}');
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

