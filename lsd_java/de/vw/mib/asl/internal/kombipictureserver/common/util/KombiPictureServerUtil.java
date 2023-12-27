/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.kombipictureserver.common.util;

import org.dsi.ifc.global.ResourceLocator;

public class KombiPictureServerUtil {
    public static boolean compareResourceLocator(ResourceLocator resourceLocator, ResourceLocator resourceLocator2) {
        return resourceLocator2 == resourceLocator || resourceLocator2 != null && resourceLocator != null && resourceLocator2.url != null && resourceLocator.url != null && resourceLocator2.url.compareTo(resourceLocator.url) == 0;
    }
}

