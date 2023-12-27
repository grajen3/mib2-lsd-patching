/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.debuginterface.target.screenshot;

import de.vw.mib.codec.ByteArrayReader;
import de.vw.mib.debug.service.debuginterface.screenshot.ScreenshotTargetCodec;
import de.vw.mib.debug.service.debuginterface.screenshot.ScreenshotTargetCodecListener;
import de.vw.mib.debuginterface.internal.ServiceManager;
import de.vw.mib.debuginterface.target.AbstractDebugTarget;
import java.io.IOException;

public class ScreenShotTarget
extends AbstractDebugTarget
implements ScreenshotTargetCodecListener {
    private final ScreenshotTargetCodec codec = new ScreenshotTargetCodec();

    public ScreenShotTarget() {
        super((short)106);
    }

    @Override
    public void close() {
        super.close();
    }

    @Override
    public void takingScreenshot() {
        if (ServiceManager.screenshotProvider == null) {
            this.logger.warn(1, "[ScreenShotTarget] No screen shot provider available!");
            return;
        }
        this.logger.trace(1, "[ScreenShotTarget] Take screenshot");
        ServiceManager.screenshotProvider.takeScreenshot();
    }

    @Override
    public void takingScreenshot(String string) {
        if (ServiceManager.screenshotProvider == null) {
            this.logger.warn(1, "[ScreenShotTarget] No screen shot provider available!");
            return;
        }
        if (this.logger.isTraceEnabled(1)) {
            this.logger.trace(1).append("[ScreenShotTarget] Take screenshot - filename: ").append(string).log();
        }
        ServiceManager.screenshotProvider.takeScreenshot(string);
    }

    @Override
    public void messageDecoded(short s, ByteArrayReader byteArrayReader) {
        try {
            this.codec.decode(byteArrayReader, this);
        }
        catch (IOException iOException) {
            this.logger.error(1).append("[ScreenShotTarget] Error reading message").append(iOException).log();
        }
    }
}

