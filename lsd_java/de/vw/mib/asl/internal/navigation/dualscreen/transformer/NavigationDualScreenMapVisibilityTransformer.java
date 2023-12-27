/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.dualscreen.transformer;

import generated.de.vw.mib.asl.internal.navigation.dualscreen.transformer.AbstractNavigationDualScreenMapVisibilityTransformer;

public class NavigationDualScreenMapVisibilityTransformer
extends AbstractNavigationDualScreenMapVisibilityTransformer {
    @Override
    public int getInt(int n, Object object) {
        switch (n) {
            case 0: {
                return (Integer)object;
            }
        }
        throw new IllegalArgumentException();
    }
}

