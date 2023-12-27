/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.poi.category.transformer;

import de.vw.mib.asl.internal.navigation.poi.transformer.PoiCatListCollector;
import generated.de.vw.mib.asl.internal.navigation.poi.category.transformer.AbstractNavigationPOICategoryListTransformer;

public class NavigationPOICategoryListTransformer
extends AbstractNavigationPOICategoryListTransformer {
    @Override
    public String getString(int n, Object object) {
        switch (n) {
            case 0: {
                return ((PoiCatListCollector)object).catName;
            }
        }
        return null;
    }

    @Override
    public boolean getBoolean(int n, Object object) {
        switch (n) {
            case 1: {
                return ((PoiCatListCollector)object).isIconAvailable;
            }
        }
        return false;
    }

    @Override
    public int getInt(int n, Object object) {
        switch (n) {
            case 2: {
                return ((PoiCatListCollector)object).iconId;
            }
            case 3: {
                return ((PoiCatListCollector)object).uid;
            }
        }
        return 0;
    }
}

