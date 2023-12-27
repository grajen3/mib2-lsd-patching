/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.personalpoi.result.transformer;

import de.vw.mib.asl.internal.navigation.personalpoi.transformer.PPoiResultListCollector;
import generated.de.vw.mib.asl.internal.navigation.personalpoi.transformer.AbstractNavigationPersonalPOIResultListTransformer;
import org.dsi.ifc.global.ResourceLocator;

public class NavigationPersonalPOIResultListTransformer
extends AbstractNavigationPersonalPOIResultListTransformer {
    @Override
    public int getInt(int n, Object object) {
        PPoiResultListCollector pPoiResultListCollector = (PPoiResultListCollector)object;
        switch (n) {
            case 2: {
                return pPoiResultListCollector.distance;
            }
        }
        throw new IllegalArgumentException("The given columnID does not contain integer values.");
    }

    @Override
    public ResourceLocator getResourceLocator(int n, Object object) {
        ResourceLocator resourceLocator = null;
        PPoiResultListCollector pPoiResultListCollector = (PPoiResultListCollector)object;
        switch (n) {
            case 0: {
                resourceLocator = pPoiResultListCollector.resourceLocator;
                break;
            }
            default: {
                throw new IllegalArgumentException("The given columnID does not contain a ResourceLocator.");
            }
        }
        return resourceLocator;
    }

    @Override
    public String getString(int n, Object object) {
        String string = null;
        PPoiResultListCollector pPoiResultListCollector = (PPoiResultListCollector)object;
        switch (n) {
            case 1: {
                string = pPoiResultListCollector.poiName;
                break;
            }
            default: {
                throw new IllegalArgumentException();
            }
        }
        return string;
    }
}

