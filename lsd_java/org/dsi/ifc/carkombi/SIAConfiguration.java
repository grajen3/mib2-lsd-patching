/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.carkombi;

import org.dsi.ifc.global.CarArrayListTransmittableElements;

public class SIAConfiguration {
    public CarArrayListTransmittableElements historyListTransmittableElements;
    public int[] historyListRAConfig;

    public SIAConfiguration() {
        this.historyListTransmittableElements = null;
        this.historyListRAConfig = null;
    }

    public SIAConfiguration(CarArrayListTransmittableElements carArrayListTransmittableElements, int[] nArray) {
        this.historyListTransmittableElements = carArrayListTransmittableElements;
        this.historyListRAConfig = nArray;
    }

    public CarArrayListTransmittableElements getHistoryListTransmittableElements() {
        return this.historyListTransmittableElements;
    }

    public int[] getHistoryListRAConfig() {
        return this.historyListRAConfig;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(1150);
        stringBuffer.append("SIAConfiguration");
        stringBuffer.append('(');
        stringBuffer.append("historyListTransmittableElements");
        stringBuffer.append('=');
        stringBuffer.append(this.historyListTransmittableElements);
        stringBuffer.append(',');
        stringBuffer.append("historyListRAConfig");
        stringBuffer.append('[');
        if (this.historyListRAConfig != null) {
            stringBuffer.append(this.historyListRAConfig.length);
        }
        stringBuffer.append(']');
        stringBuffer.append('=');
        stringBuffer.append('{');
        if (this.historyListRAConfig != null) {
            int n = this.historyListRAConfig.length;
            int n2 = n - 1;
            for (int i2 = 0; i2 < n; ++i2) {
                stringBuffer.append(this.historyListRAConfig[i2]);
                if (i2 >= n2) continue;
                stringBuffer.append(',');
            }
        } else {
            stringBuffer.append(this.historyListRAConfig);
        }
        stringBuffer.append('}');
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

