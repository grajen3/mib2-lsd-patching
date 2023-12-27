/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.memory.sd.transformer;

import generated.de.vw.mib.asl.internal.navigation.memory.sd.transformer.AbstractNavigationMemorySDGpsPicThumbnailTransformer;
import org.dsi.ifc.global.ResourceLocator;

public class NavigationMemorySDGpsPicThumbnailTransformer
extends AbstractNavigationMemorySDGpsPicThumbnailTransformer {
    @Override
    public boolean getBoolean(int n, Object object) {
        return true;
    }

    @Override
    public String getString(int n, Object object) {
        return "TestEN";
    }

    @Override
    public ResourceLocator getResourceLocator(int n, Object object) {
        return (ResourceLocator)object;
    }
}

