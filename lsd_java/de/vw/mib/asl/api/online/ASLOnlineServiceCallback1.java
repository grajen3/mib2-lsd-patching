/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.api.online;

import org.dsi.ifc.global.ResourceLocator;

public interface ASLOnlineServiceCallback1 {
    public static final int PROVIDERLOGO_IMAGE;
    public static final int PROVIDERLOGO_IMAGE_VOICE;
    public static final int PROVIDERLOGO_IMAGE_MAP;
    public static final int BRAND_ICON;

    default public void updateImageInfo(ResourceLocator resourceLocator) {
    }

    default public void updateImageInfo(int n, ResourceLocator resourceLocator) {
    }

    default public void getServiceURLResponse(String string, String string2) {
    }
}

