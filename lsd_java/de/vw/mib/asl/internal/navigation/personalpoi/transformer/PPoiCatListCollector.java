/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.personalpoi.transformer;

import org.dsi.ifc.global.ResourceLocator;

public class PPoiCatListCollector {
    public ResourceLocator resourceLocator;
    public String catName;

    public PPoiCatListCollector(ResourceLocator resourceLocator, String string) {
        this.resourceLocator = resourceLocator;
        this.catName = string;
    }
}

