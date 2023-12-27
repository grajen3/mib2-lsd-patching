/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.poi.onlineservices.transformer;

import de.vw.mib.asl.internal.navigation.poi.onlineservices.transformer.ResultListCollector;
import de.vw.mib.properties.values.FixFormatterFieldData;
import generated.de.vw.mib.asl.internal.navigation.poi.onlineservices.transformer.AbstractNavigationPOIOnlineServicesResultListTransformer;
import org.dsi.ifc.global.ResourceLocator;

public class NavigationPOIOnlineServicesResultListTransformer
extends AbstractNavigationPOIOnlineServicesResultListTransformer {
    @Override
    public boolean getBoolean(int n, Object object) {
        switch (n) {
            case 5: {
                return ((ResultListCollector)object).isInsideRange();
            }
            case 2: {
                return false;
            }
        }
        throw new UnsupportedOperationException();
    }

    @Override
    public int getInt(int n, Object object) {
        switch (n) {
            case 4: {
                return ((ResultListCollector)object).getDirectionArrow();
            }
            case 3: {
                return ((ResultListCollector)object).getDistance();
            }
        }
        throw new UnsupportedOperationException();
    }

    @Override
    public ResourceLocator getResourceLocator(int n, Object object) {
        if (n == 0) {
            return ((ResultListCollector)object).getIcon();
        }
        throw new UnsupportedOperationException();
    }

    @Override
    public String getString(int n, Object object) {
        if (n == 1) {
            return ((ResultListCollector)object).getName();
        }
        if (n == 6) {
            return ((ResultListCollector)object).getAdditionalData();
        }
        throw new UnsupportedOperationException();
    }

    @Override
    public FixFormatterFieldData getFixFormatterFieldData(int n, Object object) {
        ResultListCollector resultListCollector = (ResultListCollector)object;
        switch (n) {
            case 7: {
                return resultListCollector.getFixFormatterFieldData();
            }
        }
        throw new UnsupportedOperationException();
    }
}

