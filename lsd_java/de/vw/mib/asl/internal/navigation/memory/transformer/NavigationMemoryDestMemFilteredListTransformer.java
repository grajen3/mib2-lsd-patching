/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.memory.transformer;

import generated.de.vw.mib.asl.internal.navigation.memory.transformer.AbstractNavigationMemoryDestMemFilteredListTransformer;
import org.dsi.ifc.navigation.LDListElement;
import org.dsi.ifc.organizer.DataSet;

public class NavigationMemoryDestMemFilteredListTransformer
extends AbstractNavigationMemoryDestMemFilteredListTransformer {
    @Override
    public String getString(int n, Object object) {
        if (n == 0) {
            if (object instanceof DataSet) {
                return ((DataSet)object).getGeneralDescription1();
            }
            if (object instanceof LDListElement) {
                return ((LDListElement)object).getTitle();
            }
        }
        throw new IllegalArgumentException();
    }

    @Override
    public long getLong(int n, Object object) {
        if (n == 1) {
            if (object instanceof DataSet) {
                return ((DataSet)object).getEntryId();
            }
            if (object instanceof LDListElement) {
                return ((LDListElement)object).getId();
            }
        }
        throw new IllegalArgumentException();
    }

    @Override
    public boolean getBoolean(int n, Object object) {
        if (n == 2) {
            if (object instanceof DataSet) {
                return ((DataSet)object).getNavigable() != 0;
            }
            if (object instanceof LDListElement) {
                return true;
            }
        }
        throw new IllegalArgumentException();
    }

    @Override
    public int getInt(int n, Object object) {
        if (n == 3) {
            return 1;
        }
        if (n == 4) {
            if (object instanceof DataSet) {
                if (((DataSet)object).getNavigable() == 0) {
                    return 4;
                }
                if (((DataSet)object).getTopDestination() != 0) {
                    return 1;
                }
                return 3;
            }
            if (object instanceof LDListElement) {
                return 2;
            }
        }
        throw new IllegalArgumentException();
    }
}

