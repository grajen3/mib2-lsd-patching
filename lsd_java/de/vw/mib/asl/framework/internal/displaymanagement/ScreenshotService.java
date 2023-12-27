/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.displaymanagement;

import de.vw.mib.debug.screenshot.ScreenshotProvider;

public interface ScreenshotService
extends ScreenshotProvider {
    default public void setExternalScreenshotPaths(String[] stringArray) {
    }
}

