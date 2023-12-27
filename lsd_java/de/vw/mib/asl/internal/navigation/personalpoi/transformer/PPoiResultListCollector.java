/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.personalpoi.transformer;

import org.dsi.ifc.global.ResourceLocator;

public class PPoiResultListCollector {
    public ResourceLocator resourceLocator;
    public String poiName;
    public int distance;

    public PPoiResultListCollector(ResourceLocator resourceLocator, String string, int n) {
        this.resourceLocator = resourceLocator;
        this.poiName = string;
        this.distance = n;
    }
}

