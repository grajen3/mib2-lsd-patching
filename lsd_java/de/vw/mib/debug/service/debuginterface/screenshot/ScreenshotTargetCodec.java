/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.debug.service.debuginterface.screenshot;

import de.vw.mib.codec.ByteArrayReader;
import de.vw.mib.debug.service.debuginterface.screenshot.ScreenshotTargetCodecListener;

public class ScreenshotTargetCodec {
    private static final byte TAKE_SCREENSHOT;
    private static final byte TAKE_SCREENSHOT_FILENAME;

    public void decode(ByteArrayReader byteArrayReader, ScreenshotTargetCodecListener screenshotTargetCodecListener) {
        byte by = byteArrayReader.readByte();
        switch (by) {
            case 0: {
                screenshotTargetCodecListener.takingScreenshot();
                break;
            }
            case 1: {
                screenshotTargetCodecListener.takingScreenshot(byteArrayReader.readString());
                break;
            }
        }
    }
}

