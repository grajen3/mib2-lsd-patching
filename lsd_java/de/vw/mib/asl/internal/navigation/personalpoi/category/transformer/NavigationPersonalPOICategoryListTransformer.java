/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.personalpoi.category.transformer;

import de.vw.mib.asl.internal.navigation.personalpoi.transformer.PPoiCatListCollector;
import generated.de.vw.mib.asl.internal.navigation.personalpoi.category.transformer.AbstractNavigationPersonalPOICategoryListTransformer;
import org.dsi.ifc.global.ResourceLocator;

public class NavigationPersonalPOICategoryListTransformer
extends AbstractNavigationPersonalPOICategoryListTransformer {
    @Override
    public ResourceLocator getResourceLocator(int n, Object object) {
        switch (n) {
            case 1: {
                return ((PPoiCatListCollector)object).resourceLocator;
            }
        }
        return null;
    }

    @Override
    public String getString(int n, Object object) {
        switch (n) {
            case 0: {
                return ((PPoiCatListCollector)object).catName;
            }
        }
        return null;
    }
}

