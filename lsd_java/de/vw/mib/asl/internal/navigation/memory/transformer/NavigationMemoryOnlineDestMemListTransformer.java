/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.memory.transformer;

import generated.de.vw.mib.asl.internal.navigation.memory.transformer.AbstractNavigationMemoryOnlineDestMemListTransformer;
import org.dsi.ifc.organizer.AdbEntry;
import org.dsi.ifc.organizer.DataSet;

public class NavigationMemoryOnlineDestMemListTransformer
extends AbstractNavigationMemoryOnlineDestMemListTransformer {
    @Override
    public long getLong(int n, Object object) {
        if (n == 1) {
            if (object instanceof AdbEntry) {
                return ((AdbEntry)object).getEntryId();
            }
            if (object instanceof DataSet) {
                return ((DataSet)object).getEntryId();
            }
        }
        throw new IllegalArgumentException();
    }

    @Override
    public String getString(int n, Object object) {
        if (n == 0) {
            if (object instanceof AdbEntry) {
                return ((AdbEntry)object).getCombinedName();
            }
            if (object instanceof DataSet) {
                return ((DataSet)object).getGeneralDescription1();
            }
        }
        throw new IllegalArgumentException();
    }
}

