/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.picturehandling;

import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.global.ResourceLocator;

public interface DSIPictureHandlingListener
extends DSIListener {
    default public void indicatePicture(int n, int n2, ResourceLocator resourceLocator, ResourceLocator resourceLocator2) {
    }

    default public void finishPictureRequest(int n) {
    }
}

