/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.poi.setup.transformer;

import org.dsi.ifc.global.ResourceLocator;

public class PoiSetupShortCutListCollector {
    public int index;
    public ResourceLocator icon;

    public PoiSetupShortCutListCollector(int n, ResourceLocator resourceLocator) {
        this.index = n;
        this.icon = resourceLocator;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("Index=");
        stringBuffer.append(this.index);
        stringBuffer.append(" ResourceLocator=");
        if (this.icon != null) {
            stringBuffer.append(this.icon.toString());
        } else {
            stringBuffer.append("null");
        }
        return stringBuffer.toString();
    }
}

