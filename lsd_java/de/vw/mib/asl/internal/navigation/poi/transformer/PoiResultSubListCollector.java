/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.poi.transformer;

import org.dsi.ifc.global.ResourceLocator;

public class PoiResultSubListCollector {
    public ResourceLocator resourceLocator;
    public String subPoiName;
    public int distance;
    public int directionIndex;
    public boolean insideRange;

    public PoiResultSubListCollector(ResourceLocator resourceLocator, String string, int n, int n2, boolean bl) {
        this.resourceLocator = resourceLocator;
        this.subPoiName = string;
        this.distance = n;
        this.directionIndex = n2;
        this.insideRange = bl;
    }
}

