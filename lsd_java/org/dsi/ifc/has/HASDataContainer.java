/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.has;

import org.dsi.ifc.has.HASDataElement;

public class HASDataContainer {
    public int containerId;
    public int hierarchyId;
    public int parentId;
    public HASDataElement[] dataElements;
    public int elementId;

    public HASDataContainer() {
        this.containerId = 0;
        this.hierarchyId = 0;
        this.parentId = -1;
        this.dataElements = null;
        this.elementId = -1;
    }

    public HASDataContainer(int n, int n2, int n3, HASDataElement[] hASDataElementArray, int n4) {
        this.containerId = n;
        this.hierarchyId = n2;
        this.parentId = n3;
        this.dataElements = hASDataElementArray;
        this.elementId = n4;
    }

    public int getContainerId() {
        return this.containerId;
    }

    public int getHierarchyId() {
        return this.hierarchyId;
    }

    public int getParentId() {
        return this.parentId;
    }

    public HASDataElement[] getDataElements() {
        return this.dataElements;
    }

    public int getElementId() {
        return this.elementId;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(300);
        stringBuffer.append("HASDataContainer");
        stringBuffer.append('(');
        stringBuffer.append("containerId");
        stringBuffer.append('=');
        stringBuffer.append(this.containerId);
        stringBuffer.append(',');
        stringBuffer.append("hierarchyId");
        stringBuffer.append('=');
        stringBuffer.append(this.hierarchyId);
        stringBuffer.append(',');
        stringBuffer.append("parentId");
        stringBuffer.append('=');
        stringBuffer.append(this.parentId);
        stringBuffer.append(',');
        stringBuffer.append("dataElements");
        stringBuffer.append('[');
        if (this.dataElements != null) {
            stringBuffer.append(this.dataElements.length);
        }
        stringBuffer.append(']');
        stringBuffer.append('=');
        stringBuffer.append('{');
        if (this.dataElements != null) {
            int n = this.dataElements.length;
            int n2 = n - 1;
            for (int i2 = 0; i2 < n; ++i2) {
                stringBuffer.append(this.dataElements[i2]);
                if (i2 >= n2) continue;
                stringBuffer.append(',');
            }
        } else {
            stringBuffer.append(this.dataElements);
        }
        stringBuffer.append('}');
        stringBuffer.append(',');
        stringBuffer.append("elementId");
        stringBuffer.append('=');
        stringBuffer.append(this.elementId);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

