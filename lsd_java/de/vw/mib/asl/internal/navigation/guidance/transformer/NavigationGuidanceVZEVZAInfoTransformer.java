/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.guidance.transformer;

import de.vw.mib.asl.internal.navigation.guidance.transformer.VZACollector;
import generated.de.vw.mib.asl.internal.navigation.guidance.transformer.AbstractNavigationGuidanceVZEVZAInfoTransformer;

public class NavigationGuidanceVZEVZAInfoTransformer
extends AbstractNavigationGuidanceVZEVZAInfoTransformer {
    @Override
    public boolean getBoolean(int n, Object object) {
        boolean bl = false;
        VZACollector vZACollector = (VZACollector)object;
        switch (n) {
            case 3: {
                bl = vZACollector.isItemActive;
                break;
            }
            case 4: {
                bl = vZACollector.isAddItemActive;
                break;
            }
            default: {
                throw new IllegalArgumentException();
            }
        }
        return bl;
    }

    @Override
    public int getInt(int n, Object object) {
        int n2 = -1;
        VZACollector vZACollector = (VZACollector)object;
        switch (n) {
            case 0: {
                n2 = vZACollector.addIconType;
                break;
            }
            case 1: {
                n2 = vZACollector.iconType;
                break;
            }
            case 2: {
                n2 = vZACollector.speedLimitIndex;
                break;
            }
            default: {
                throw new IllegalArgumentException();
            }
        }
        return n2;
    }
}

