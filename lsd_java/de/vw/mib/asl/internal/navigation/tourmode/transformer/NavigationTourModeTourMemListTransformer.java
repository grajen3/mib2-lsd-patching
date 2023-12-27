/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.tourmode.transformer;

import generated.de.vw.mib.asl.internal.navigation.tourmode.transformer.AbstractNavigationTourModeTourMemListTransformer;
import org.dsi.ifc.navigation.NavRmRouteListData;

public class NavigationTourModeTourMemListTransformer
extends AbstractNavigationTourModeTourMemListTransformer {
    @Override
    public String getString(int n, Object object) {
        if (0 == n) {
            return ((NavRmRouteListData)object).getName();
        }
        throw new IllegalArgumentException();
    }
}

