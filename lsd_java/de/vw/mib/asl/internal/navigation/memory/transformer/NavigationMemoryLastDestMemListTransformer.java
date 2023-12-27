/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.memory.transformer;

import de.vw.mib.util.StringBuilder;
import generated.de.vw.mib.asl.internal.navigation.memory.transformer.AbstractNavigationMemoryLastDestMemListTransformer;
import org.dsi.ifc.navigation.LDListElement;

public class NavigationMemoryLastDestMemListTransformer
extends AbstractNavigationMemoryLastDestMemListTransformer {
    @Override
    public String getString(int n, Object object) {
        if (n == 0) {
            return ((LDListElement)object).getTitle();
        }
        throw new IllegalArgumentException(new StringBuilder("columnId ").append(n).toString());
    }

    @Override
    public long getLong(int n, Object object) {
        if (n == 3) {
            return ((LDListElement)object).id;
        }
        throw new IllegalArgumentException(new StringBuilder("columnId ").append(n).toString());
    }
}

