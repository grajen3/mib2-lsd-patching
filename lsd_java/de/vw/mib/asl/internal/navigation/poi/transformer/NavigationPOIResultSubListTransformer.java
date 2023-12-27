/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.poi.transformer;

import de.vw.mib.asl.internal.navigation.poi.transformer.PoiResultSubListCollector;
import generated.de.vw.mib.asl.internal.navigation.poi.transformer.AbstractNavigationPOIResultSubListTransformer;
import org.dsi.ifc.global.ResourceLocator;

public class NavigationPOIResultSubListTransformer
extends AbstractNavigationPOIResultSubListTransformer {
    @Override
    public String getString(int n, Object object) {
        String string = null;
        PoiResultSubListCollector poiResultSubListCollector = (PoiResultSubListCollector)object;
        switch (n) {
            case 1: {
                string = poiResultSubListCollector.subPoiName;
                break;
            }
            default: {
                throw new IllegalArgumentException();
            }
        }
        return string;
    }

    @Override
    public ResourceLocator getResourceLocator(int n, Object object) {
        ResourceLocator resourceLocator = null;
        PoiResultSubListCollector poiResultSubListCollector = (PoiResultSubListCollector)object;
        switch (n) {
            case 0: {
                resourceLocator = poiResultSubListCollector.resourceLocator;
                break;
            }
            default: {
                throw new IllegalArgumentException("The given columnID does not contain a ResourceLocator.");
            }
        }
        return resourceLocator;
    }

    @Override
    public int getInt(int n, Object object) {
        PoiResultSubListCollector poiResultSubListCollector = (PoiResultSubListCollector)object;
        switch (n) {
            case 2: {
                return poiResultSubListCollector.distance;
            }
            case 3: {
                return poiResultSubListCollector.directionIndex;
            }
        }
        throw new IllegalArgumentException("The given columnID does not contain integer values.");
    }

    @Override
    public boolean getBoolean(int n, Object object) {
        switch (n) {
            case 4: {
                return ((PoiResultSubListCollector)object).insideRange;
            }
        }
        throw new IllegalArgumentException("The given columnID does not contain boolean values.");
    }
}

