/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.poi.transformer;

import org.dsi.ifc.global.ResourceLocator;

public class PoiCatListCollector {
    public String catName;
    public int uid;
    public int iconId;
    public boolean isIconAvailable;
    public boolean isRefinable;
    public ResourceLocator resourceLocator;

    public PoiCatListCollector(ResourceLocator resourceLocator, String string, int n, int n2, boolean bl, boolean bl2) {
        this.resourceLocator = resourceLocator;
        this.catName = string;
        this.uid = n;
        this.iconId = n2;
        this.isIconAvailable = bl;
        this.isRefinable = bl2;
    }
}

