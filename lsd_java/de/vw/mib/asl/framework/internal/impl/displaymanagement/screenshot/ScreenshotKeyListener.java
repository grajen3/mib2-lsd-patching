/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.impl.displaymanagement.screenshot;

import de.vw.mib.asl.api.system.KeyAdapter;
import de.vw.mib.asl.framework.internal.displaymanagement.ScreenshotService;

public class ScreenshotKeyListener
extends KeyAdapter {
    private final ScreenshotService screenshotService;

    public ScreenshotKeyListener(ScreenshotService screenshotService) {
        this.screenshotService = screenshotService;
    }

    @Override
    public void onLongPressed(int n) {
        this.screenshotService.takeScreenshot();
    }
}

