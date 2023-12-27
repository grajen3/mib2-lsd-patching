/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.memory.transformer;

import generated.de.vw.mib.asl.internal.navigation.memory.transformer.AbstractNavigationMemoryTopDestMemListTransformer;
import org.dsi.ifc.organizer.DataSet;

public class NavigationMemoryTopDestMemListTransformer
extends AbstractNavigationMemoryTopDestMemListTransformer {
    @Override
    public String getString(int n, Object object) {
        if (0 == n) {
            return ((DataSet)object).getGeneralDescription1();
        }
        throw new IllegalArgumentException();
    }

    @Override
    public long getLong(int n, Object object) {
        if (1 == n) {
            return ((DataSet)object).getEntryId();
        }
        throw new IllegalArgumentException();
    }

    @Override
    public int getInt(int n, Object object) {
        if (2 == n) {
            return 1;
        }
        throw new IllegalArgumentException();
    }
}

