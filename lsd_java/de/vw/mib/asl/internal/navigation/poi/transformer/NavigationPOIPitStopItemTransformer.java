/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.poi.transformer;

import de.vw.mib.asl.internal.navigation.poi.transformer.PoiPitStopItemCollector;
import generated.de.vw.mib.asl.internal.navigation.poi.transformer.AbstractNavigationPOIPitStopItemTransformer;
import org.dsi.ifc.global.ResourceLocator;

public class NavigationPOIPitStopItemTransformer
extends AbstractNavigationPOIPitStopItemTransformer {
    @Override
    public String getString(int n, Object object) {
        String string = null;
        PoiPitStopItemCollector poiPitStopItemCollector = (PoiPitStopItemCollector)object;
        switch (n) {
            case 1: {
                if (poiPitStopItemCollector != null && poiPitStopItemCollector.poiName != null) {
                    string = poiPitStopItemCollector.poiName;
                    break;
                }
                string = "";
                break;
            }
            default: {
                throw new IllegalArgumentException("The given columnID does not contain String values.");
            }
        }
        return string;
    }

    @Override
    public ResourceLocator getResourceLocator(int n, Object object) {
        ResourceLocator resourceLocator = null;
        PoiPitStopItemCollector poiPitStopItemCollector = (PoiPitStopItemCollector)object;
        switch (n) {
            case 0: {
                resourceLocator = poiPitStopItemCollector != null ? poiPitStopItemCollector.resourceLocator : null;
                break;
            }
            default: {
                throw new IllegalArgumentException("The given columnID does not contain a ResourceLocator.");
            }
        }
        return resourceLocator;
    }
}

