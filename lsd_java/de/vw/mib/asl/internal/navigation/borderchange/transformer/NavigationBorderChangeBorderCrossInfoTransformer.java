/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.borderchange.transformer;

import de.vw.mib.asl.internal.navigation.borderchange.transformer.BorderCrossingCollector;
import generated.de.vw.mib.asl.internal.navigation.borderchange.transformer.AbstractNavigationBorderChangeBorderCrossInfoTransformer;
import org.dsi.ifc.global.ResourceLocator;

public class NavigationBorderChangeBorderCrossInfoTransformer
extends AbstractNavigationBorderChangeBorderCrossInfoTransformer {
    @Override
    public int getInt(int n, Object object) {
        switch (n) {
            case 2: {
                return ((BorderCrossingCollector)object).myInfoSpeed;
            }
        }
        return 0;
    }

    @Override
    public ResourceLocator getResourceLocator(int n, Object object) {
        switch (n) {
            case 1: {
                return ((BorderCrossingCollector)object).mySpeedImage;
            }
            case 0: {
                return ((BorderCrossingCollector)object).myImage;
            }
        }
        return new ResourceLocator();
    }
}

