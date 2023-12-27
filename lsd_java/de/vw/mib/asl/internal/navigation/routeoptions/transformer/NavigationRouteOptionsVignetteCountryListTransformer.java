/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.routeoptions.transformer;

import de.vw.mib.asl.internal.navigation.routeoptions.transformer.VignetteCountryListCollector;
import generated.de.vw.mib.asl.internal.navigation.routeoptions.transformer.AbstractNavigationRouteOptionsVignetteCountryListTransformer;

public class NavigationRouteOptionsVignetteCountryListTransformer
extends AbstractNavigationRouteOptionsVignetteCountryListTransformer {
    @Override
    public boolean getBoolean(int n, Object object) {
        boolean bl = false;
        VignetteCountryListCollector vignetteCountryListCollector = (VignetteCountryListCollector)object;
        switch (n) {
            case 1: {
                bl = vignetteCountryListCollector.isCountrySelected;
                break;
            }
            default: {
                throw new IllegalArgumentException();
            }
        }
        return bl;
    }

    @Override
    public String getString(int n, Object object) {
        String string = null;
        VignetteCountryListCollector vignetteCountryListCollector = (VignetteCountryListCollector)object;
        switch (n) {
            case 0: {
                string = vignetteCountryListCollector.countryName;
                break;
            }
            default: {
                throw new IllegalArgumentException();
            }
        }
        return string;
    }
}

