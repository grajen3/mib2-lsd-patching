/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.memory.sd.transformer;

import de.vw.mib.asl.internal.navigation.memory.sd.transformer.NavigationMemorySDImportSDEntryListCollector;
import generated.de.vw.mib.asl.internal.navigation.memory.sd.transformer.AbstractNavigationMemorySDImportSDEntryListTransformer;

public class NavigationMemorySDImportSDEntryListTransformer
extends AbstractNavigationMemorySDImportSDEntryListTransformer {
    @Override
    public boolean getBoolean(int n, Object object) {
        if (n == 1) {
            return ((NavigationMemorySDImportSDEntryListCollector)object).isSelected();
        }
        throw new IllegalArgumentException();
    }

    @Override
    public String getString(int n, Object object) {
        if (n == 0) {
            return ((NavigationMemorySDImportSDEntryListCollector)object).getName();
        }
        throw new IllegalArgumentException();
    }
}

