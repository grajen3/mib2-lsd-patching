/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.setup.transformer;

import de.vw.mib.asl.internal.navigation.setup.transformer.GasStationCollector;
import generated.de.vw.mib.asl.internal.navigation.setup.transformer.AbstractNavigationSetupGasStationListTransformer;
import org.dsi.ifc.global.ResourceLocator;

public class NavigationSetupGasStationListTransformer
extends AbstractNavigationSetupGasStationListTransformer {
    @Override
    public boolean getBoolean(int n, Object object) {
        GasStationCollector gasStationCollector = (GasStationCollector)object;
        if (n == 2) {
            if (gasStationCollector != null) {
                return gasStationCollector.selected;
            }
        } else {
            throw new IllegalArgumentException();
        }
        return false;
    }

    @Override
    public String getString(int n, Object object) {
        GasStationCollector gasStationCollector = (GasStationCollector)object;
        if (n == 1) {
            if (gasStationCollector != null) {
                return gasStationCollector.description;
            }
        } else {
            throw new IllegalArgumentException();
        }
        return null;
    }

    @Override
    public ResourceLocator getResourceLocator(int n, Object object) {
        ResourceLocator resourceLocator = null;
        GasStationCollector gasStationCollector = (GasStationCollector)object;
        switch (n) {
            case 0: {
                resourceLocator = gasStationCollector.resourceLocator;
                break;
            }
            default: {
                throw new IllegalArgumentException("The given columnID does not contain a ResourceLocator.");
            }
        }
        return resourceLocator;
    }
}

