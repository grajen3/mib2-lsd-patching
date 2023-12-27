/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets.controller;

import de.vw.mib.widgets.controller.WidgetController;

public interface PictureViewerController
extends WidgetController {
    public static final String OUT_REQUESTNEXTIMAGE_NAME;
    public static final String OUT_REQUESTPREVIMAGE_NAME;
    public static final String OUT_LOADINGSTARTED_NAME;
    public static final String OUT_LOADINGFINISHED_NAME;
    public static final String IN_SETNEXTIMAGE_NAME;
    public static final String IN_SETPREVIMAGE_NAME;
    public static final String IN_INCREASEZOOM_NAME;
    public static final String IN_DECREASEZOOM_NAME;
    public static final String IN_RESETZOOM_NAME;
    public static final String IN_ROTATECLOCKWISE_NAME;
    public static final String IN_ROTATECOUNTERCLOCKWISE_NAME;

    default public void selectNextImageDelayed(int n) {
    }

    default public void cancelSelectNextImageDelayed() {
    }

    default public void fire_requestNextImage() {
    }

    default public void fire_requestPrevImage() {
    }

    default public void fire_loadingStarted() {
    }

    default public void fire_loadingFinished() {
    }
}

