/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.memory.transformer;

import generated.de.vw.mib.asl.internal.navigation.memory.transformer.AbstractNavigationMemoryContactListTransformer;
import org.dsi.ifc.organizer.DataSet;

public class NavigationMemoryContactListTransformer
extends AbstractNavigationMemoryContactListTransformer {
    @Override
    public boolean getBoolean(int n, Object object) {
        switch (n) {
            case 2: {
                return ((DataSet)object).getNavigable() > 0;
            }
        }
        throw new UnsupportedOperationException();
    }

    @Override
    public String getString(int n, Object object) {
        switch (n) {
            case 0: {
                DataSet dataSet = (DataSet)object;
                return dataSet.getGeneralDescription1();
            }
        }
        throw new UnsupportedOperationException();
    }

    @Override
    public long getLong(int n, Object object) {
        switch (n) {
            case 1: {
                return ((DataSet)object).getEntryId();
            }
        }
        throw new UnsupportedOperationException();
    }
}

