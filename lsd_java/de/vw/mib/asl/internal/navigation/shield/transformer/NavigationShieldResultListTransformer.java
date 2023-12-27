/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.shield.transformer;

import de.vw.mib.asl.internal.navigation.shield.transformer.ShieldCollector;
import de.vw.mib.properties.values.FixFormatterFieldData;
import generated.de.vw.mib.asl.internal.navigation.shield.transformer.AbstractNavigationShieldResultListTransformer;
import org.dsi.ifc.global.ResourceLocator;

public class NavigationShieldResultListTransformer
extends AbstractNavigationShieldResultListTransformer {
    @Override
    public FixFormatterFieldData getFixFormatterFieldData(int n, Object object) {
        return ((ShieldCollector)object).fieldData;
    }

    @Override
    public int getInt(int n, Object object) {
        switch (n) {
            case 0: {
                return ((ShieldCollector)object).id;
            }
            case 1: {
                return ((ShieldCollector)object).getIconId();
            }
            case 4: {
                return ((ShieldCollector)object).res.distanceMeters;
            }
            case 5: {
                return ((ShieldCollector)object).directionArrowIndex;
            }
        }
        return 0;
    }

    @Override
    public ResourceLocator getResourceLocator(int n, Object object) {
        ResourceLocator resourceLocator = null;
        ShieldCollector shieldCollector = (ShieldCollector)object;
        switch (n) {
            case 2: {
                resourceLocator = shieldCollector.resourceLocator;
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
        ShieldCollector shieldCollector = (ShieldCollector)object;
        switch (n) {
            case 6: {
                return shieldCollector.nearString;
            }
        }
        return null;
    }
}

