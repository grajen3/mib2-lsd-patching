/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.caching;

import org.dsi.ifc.global.ResourceLocator;
import org.dsi.ifc.iconhandling.TextRenderingInfo;

public final class IconDescriptor {
    private ResourceLocator resourceLocator;
    private TextRenderingInfo textRenderingInfo;

    public IconDescriptor(ResourceLocator resourceLocator, TextRenderingInfo textRenderingInfo) {
        this.resourceLocator = resourceLocator;
        this.textRenderingInfo = textRenderingInfo;
    }

    public ResourceLocator getResourceLocator() {
        return this.resourceLocator;
    }

    public TextRenderingInfo getTextRenderingInfo() {
        return this.textRenderingInfo;
    }
}

