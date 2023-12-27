/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.memory.transformer;

import generated.de.vw.mib.asl.internal.navigation.memory.transformer.AbstractNavigationMemoryAddressbookDestMemListTransformer;
import org.dsi.ifc.organizer.DataSet;

public class NavigationMemoryAddressbookDestMemListTransformer
extends AbstractNavigationMemoryAddressbookDestMemListTransformer {
    @Override
    public boolean getBoolean(int n, Object object) {
        if (n == 3) {
            return ((DataSet)object).getProbNavigable() != 0;
        }
        throw new IllegalArgumentException();
    }

    @Override
    public int getInt(int n, Object object) {
        if (2 == n) {
            DataSet dataSet = (DataSet)object;
            if (dataSet.getTopDestination() != 0) {
                return 1;
            }
            if (dataSet.getNavigable() != 0) {
                return 3;
            }
            return 4;
        }
        throw new IllegalArgumentException();
    }

    @Override
    public String getString(int n, Object object) {
        if (n == 0) {
            return ((DataSet)object).getGeneralDescription1();
        }
        throw new IllegalArgumentException();
    }

    @Override
    public long getLong(int n, Object object) {
        if (n == 1) {
            return ((DataSet)object).getEntryId();
        }
        throw new IllegalArgumentException();
    }
}

