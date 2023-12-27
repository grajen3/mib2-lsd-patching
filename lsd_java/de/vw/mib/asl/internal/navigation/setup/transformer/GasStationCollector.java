/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.setup.transformer;

import org.dsi.ifc.global.ResourceLocator;

public class GasStationCollector {
    public int brandUid;
    public ResourceLocator resourceLocator;
    public String description;
    public boolean selected;

    public GasStationCollector(int n, ResourceLocator resourceLocator, String string, boolean bl) {
        this.brandUid = n;
        this.resourceLocator = resourceLocator;
        this.description = string;
        this.selected = bl;
    }
}

