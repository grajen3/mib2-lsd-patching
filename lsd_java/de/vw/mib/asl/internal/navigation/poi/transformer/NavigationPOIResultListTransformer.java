/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.poi.transformer;

import de.vw.mib.asl.internal.navigation.poi.transformer.PoiResultListCollector;
import de.vw.mib.properties.values.FixFormatterFieldData;
import generated.de.vw.mib.asl.internal.navigation.poi.transformer.AbstractNavigationPOIResultListTransformer;
import org.dsi.ifc.global.ResourceLocator;

public class NavigationPOIResultListTransformer
extends AbstractNavigationPOIResultListTransformer {
    @Override
    public String getString(int n, Object object) {
        String string = null;
        PoiResultListCollector poiResultListCollector = (PoiResultListCollector)object;
        switch (n) {
            case 1: {
                string = poiResultListCollector.poiName;
                break;
            }
            default: {
                throw new IllegalArgumentException();
            }
        }
        return string;
    }

    @Override
    public boolean getBoolean(int n, Object object) {
        switch (n) {
            case 2: {
                return ((PoiResultListCollector)object).hasSubListItem;
            }
            case 5: {
                return ((PoiResultListCollector)object).insideRange;
            }
        }
        throw new IllegalArgumentException("The given columnID does not contain boolean values.");
    }

    @Override
    public int getInt(int n, Object object) {
        PoiResultListCollector poiResultListCollector = (PoiResultListCollector)object;
        switch (n) {
            case 3: {
                return poiResultListCollector.distance;
            }
            case 4: {
                return poiResultListCollector.directionIndex;
            }
        }
        throw new IllegalArgumentException("The given columnID does not contain integer values.");
    }

    @Override
    public ResourceLocator getResourceLocator(int n, Object object) {
        ResourceLocator resourceLocator = null;
        PoiResultListCollector poiResultListCollector = (PoiResultListCollector)object;
        switch (n) {
            case 0: {
                resourceLocator = poiResultListCollector.resourceLocator;
                break;
            }
            default: {
                throw new IllegalArgumentException("The given columnID does not contain a ResourceLocator.");
            }
        }
        return resourceLocator;
    }

    @Override
    public FixFormatterFieldData getFixFormatterFieldData(int n, Object object) {
        PoiResultListCollector poiResultListCollector = (PoiResultListCollector)object;
        switch (n) {
            case 19: {
                return poiResultListCollector.fieldData;
            }
        }
        throw new IllegalArgumentException("The given columnID does not contain a FixFormatterFieldData.");
    }
}

