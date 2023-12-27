/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.destinput.transformer;

import de.vw.mib.asl.internal.list.ItemTransformer;
import generated.de.vw.mib.asl.internal.navigation.destinput.transformer.AbstractNavigationDestInputCityCenterListTransformer;
import org.dsi.ifc.navigation.LIValueListElement;

public class NavigationDestInputCityCenterListTransformer
extends AbstractNavigationDestInputCityCenterListTransformer
implements ItemTransformer {
    @Override
    public boolean getBoolean(int n, Object object) {
        throw new IllegalArgumentException();
    }

    @Override
    public int getInt(int n, Object object) {
        throw new IllegalArgumentException();
    }

    @Override
    public String getString(int n, Object object) {
        if (n == 0) {
            return ((LIValueListElement)object).data;
        }
        throw new IllegalArgumentException();
    }
}

