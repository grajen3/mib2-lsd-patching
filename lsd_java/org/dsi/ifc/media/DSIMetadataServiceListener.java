/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.media;

import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.global.ResourceLocator;

public interface DSIMetadataServiceListener
extends DSIListener {
    default public void updateOnlineLookupStatus(int n, int n2) {
    }

    default public void responseCoverArt(int n, ResourceLocator resourceLocator) {
    }
}

