/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.has;

import org.dsi.ifc.global.ResourceLocator;

public class HASDataElement {
    public int elementId;
    public int elementType;
    public long numericData;
    public String stringData;
    public double doubleData;
    public byte[] binaryData;
    public ResourceLocator resourceLocator;

    public HASDataElement() {
        this.elementId = 0;
        this.elementType = -1;
        this.numericData = 0L;
        this.stringData = null;
        this.doubleData = 0.0;
        this.binaryData = null;
        this.resourceLocator = null;
    }

    public HASDataElement(int n, int n2, long l, String string, double d2, byte[] byArray, ResourceLocator resourceLocator) {
        this.elementId = n;
        this.elementType = n2;
        this.numericData = l;
        this.stringData = string;
        this.doubleData = d2;
        this.binaryData = byArray;
        this.resourceLocator = resourceLocator;
    }

    public int getElementId() {
        return this.elementId;
    }

    public int getElementType() {
        return this.elementType;
    }

    public long getNumericData() {
        return this.numericData;
    }

    public String getStringData() {
        return this.stringData;
    }

    public double getDoubleData() {
        return this.doubleData;
    }

    public byte[] getBinaryData() {
        return this.binaryData;
    }

    public ResourceLocator getResourceLocator() {
        return this.resourceLocator;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(1400);
        stringBuffer.append("HASDataElement");
        stringBuffer.append('(');
        stringBuffer.append("elementId");
        stringBuffer.append('=');
        stringBuffer.append(this.elementId);
        stringBuffer.append(',');
        stringBuffer.append("elementType");
        stringBuffer.append('=');
        stringBuffer.append(this.elementType);
        stringBuffer.append(',');
        stringBuffer.append("numericData");
        stringBuffer.append('=');
        stringBuffer.append(this.numericData);
        stringBuffer.append(',');
        stringBuffer.append("stringData");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.stringData);
        stringBuffer.append('\"');
        stringBuffer.append(',');
        stringBuffer.append("doubleData");
        stringBuffer.append('=');
        stringBuffer.append(this.doubleData);
        stringBuffer.append(',');
        stringBuffer.append("binaryData");
        stringBuffer.append('[');
        if (this.binaryData != null) {
            stringBuffer.append(this.binaryData.length);
        }
        stringBuffer.append(']');
        stringBuffer.append('=');
        stringBuffer.append('{');
        if (this.binaryData != null) {
            int n = this.binaryData.length;
            int n2 = n - 1;
            for (int i2 = 0; i2 < n; ++i2) {
                stringBuffer.append(this.binaryData[i2]);
                if (i2 >= n2) continue;
                stringBuffer.append(',');
            }
        } else {
            stringBuffer.append(this.binaryData);
        }
        stringBuffer.append('}');
        stringBuffer.append(',');
        stringBuffer.append("resourceLocator");
        stringBuffer.append('=');
        stringBuffer.append(this.resourceLocator);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

