/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.memory.sd.transformer;

import generated.de.vw.mib.asl.internal.navigation.memory.sd.transformer.AbstractNavigationMemorySDVCardListTransformer;
import org.dsi.ifc.filebrowser.BrowsedFile;

public class NavigationMemorySDVCardListTransformer
extends AbstractNavigationMemorySDVCardListTransformer {
    @Override
    public String getString(int n, Object object) {
        if (n == 0) {
            return ((BrowsedFile)object).getFilename();
        }
        throw new IllegalArgumentException();
    }
}

