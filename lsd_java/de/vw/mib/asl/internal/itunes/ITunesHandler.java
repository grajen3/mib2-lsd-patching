/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.itunes;

import de.vw.mib.asl.internal.itunes.controller.ITunesController;
import de.vw.mib.asl.internal.itunes.state.ITunesTarget;

public final class ITunesHandler {
    private static ITunesTarget mTarget;
    private static ITunesController iTunesController;

    public static void setTarget(ITunesTarget iTunesTarget) {
        mTarget = iTunesTarget;
    }

    public static ITunesTarget getTarget() {
        return mTarget;
    }

    public static ITunesController getITunesController() {
        if (iTunesController == null) {
            iTunesController = new ITunesController();
        }
        return iTunesController;
    }

    public static void deInitialize() {
        mTarget = null;
        iTunesController.deinitialize();
        iTunesController = null;
    }
}

