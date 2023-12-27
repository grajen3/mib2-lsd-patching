/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.poi.setup.transformer;

import org.dsi.ifc.global.ResourceLocator;

public class PoiSetupPoiListCollector {
    public boolean selected;
    public ResourceLocator icon;
    public String catName;
    public int uniqueId;

    public PoiSetupPoiListCollector(boolean bl, ResourceLocator resourceLocator, String string, int n) {
        this.selected = bl;
        this.icon = resourceLocator;
        this.catName = string;
        this.uniqueId = n;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("CatName=");
        stringBuffer.append(this.catName);
        stringBuffer.append(" / uniqueId=");
        stringBuffer.append(this.uniqueId);
        stringBuffer.append(" / selected=");
        stringBuffer.append(this.selected);
        return stringBuffer.toString();
    }
}

