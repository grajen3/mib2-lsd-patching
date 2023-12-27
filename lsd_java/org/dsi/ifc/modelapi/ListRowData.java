/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.modelapi;

import org.dsi.ifc.global.ResourceLocator;
import org.dsi.ifc.modelapi.ListCellData;
import org.dsi.ifc.modelapi.ListCellDataFixFormat;

public class ListRowData {
    public ListCellData[] listCellData;
    public ListCellDataFixFormat[] listCellDataFixFormat;
    public ResourceLocator[] resourceLocators;

    public ListRowData() {
        this.listCellData = null;
    }

    public ListRowData(ListCellData[] listCellDataArray, ListCellDataFixFormat[] listCellDataFixFormatArray, ResourceLocator[] resourceLocatorArray) {
        this.listCellData = listCellDataArray;
        this.listCellDataFixFormat = listCellDataFixFormatArray;
        this.resourceLocators = resourceLocatorArray;
    }

    public ListCellData[] getListCellData() {
        return this.listCellData;
    }

    public ListCellDataFixFormat[] getListCellDataFixFormat() {
        return this.listCellDataFixFormat;
    }

    public ResourceLocator[] getResourceLocators() {
        return this.resourceLocators;
    }

    public String toString() {
        int n;
        int n2;
        int n3;
        StringBuffer stringBuffer = new StringBuffer(200);
        stringBuffer.append("ListRowData");
        stringBuffer.append('(');
        stringBuffer.append("listCellData");
        stringBuffer.append('[');
        if (this.listCellData != null) {
            stringBuffer.append(this.listCellData.length);
        }
        stringBuffer.append(']');
        stringBuffer.append('=');
        stringBuffer.append('{');
        if (this.listCellData != null) {
            n3 = this.listCellData.length;
            n2 = n3 - 1;
            for (n = 0; n < n3; ++n) {
                stringBuffer.append(this.listCellData[n]);
                if (n >= n2) continue;
                stringBuffer.append(',');
            }
        } else {
            stringBuffer.append(this.listCellData);
        }
        stringBuffer.append('}');
        stringBuffer.append(',');
        stringBuffer.append("listCellDataFixFormat");
        stringBuffer.append('[');
        if (this.listCellDataFixFormat != null) {
            stringBuffer.append(this.listCellDataFixFormat.length);
        }
        stringBuffer.append(']');
        stringBuffer.append('=');
        stringBuffer.append('{');
        if (this.listCellDataFixFormat != null) {
            n3 = this.listCellDataFixFormat.length;
            n2 = n3 - 1;
            for (n = 0; n < n3; ++n) {
                stringBuffer.append(this.listCellDataFixFormat[n]);
                if (n >= n2) continue;
                stringBuffer.append(',');
            }
        } else {
            stringBuffer.append(this.listCellDataFixFormat);
        }
        stringBuffer.append('}');
        stringBuffer.append(',');
        stringBuffer.append("resourceLocators");
        stringBuffer.append('[');
        if (this.resourceLocators != null) {
            stringBuffer.append(this.resourceLocators.length);
        }
        stringBuffer.append(']');
        stringBuffer.append('=');
        stringBuffer.append('{');
        if (this.resourceLocators != null) {
            n3 = this.resourceLocators.length;
            n2 = n3 - 1;
            for (n = 0; n < n3; ++n) {
                stringBuffer.append(this.resourceLocators[n]);
                if (n >= n2) continue;
                stringBuffer.append(',');
            }
        } else {
            stringBuffer.append(this.resourceLocators);
        }
        stringBuffer.append('}');
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

