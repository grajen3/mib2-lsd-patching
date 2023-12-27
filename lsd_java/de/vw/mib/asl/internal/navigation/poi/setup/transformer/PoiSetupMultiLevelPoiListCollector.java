/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.poi.setup.transformer;

import org.dsi.ifc.global.ResourceLocator;

public class PoiSetupMultiLevelPoiListCollector {
    public boolean selected;
    public ResourceLocator icon;
    public String catName;
    public int uniqueId;
    public boolean isParent;
    public int parentId;

    public PoiSetupMultiLevelPoiListCollector(boolean bl, ResourceLocator resourceLocator, String string, int n, boolean bl2, int n2) {
        this.selected = bl;
        this.icon = resourceLocator;
        this.catName = string;
        this.uniqueId = n;
        this.isParent = bl2;
        this.parentId = n2;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("CatName=");
        stringBuffer.append(this.catName);
        stringBuffer.append(" / uniqueId=");
        stringBuffer.append(this.uniqueId);
        stringBuffer.append(" / selected=");
        stringBuffer.append(this.selected);
        stringBuffer.append(" / isParent=");
        stringBuffer.append(this.isParent);
        stringBuffer.append(" / parentId=");
        stringBuffer.append(this.parentId);
        return stringBuffer.toString();
    }
}

