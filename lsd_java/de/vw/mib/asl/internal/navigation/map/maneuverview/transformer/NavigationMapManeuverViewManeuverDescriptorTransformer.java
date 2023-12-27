/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.map.maneuverview.transformer;

import de.vw.mib.asl.framework.internal.framework.GenericCollector;
import generated.de.vw.mib.asl.internal.navigation.map.maneuverview.transformer.AbstractNavigationMapManeuverViewManeuverDescriptorTransformer;

public class NavigationMapManeuverViewManeuverDescriptorTransformer
extends AbstractNavigationMapManeuverViewManeuverDescriptorTransformer {
    @Override
    public int getInt(int n, Object object) {
        return ((GenericCollector)object).getIntItem(n);
    }

    @Override
    public String getString(int n, Object object) {
        return ((GenericCollector)object).getStringItem(n);
    }
}

