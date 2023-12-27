/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets.controller;

import de.vw.mib.event.HMIEvent;
import de.vw.mib.widgets.controller.CanvasController;
import de.vw.mib.widgets.controller.DefaultTouchAreaController;
import de.vw.mib.widgets.models.CanvasModel;

public final class DefaultCanvasController
extends DefaultTouchAreaController
implements CanvasController {
    @Override
    protected void reset() {
        super.reset();
    }

    @Override
    public void init() {
        super.init();
    }

    @Override
    public void deInit() {
        super.deInit();
    }

    @Override
    public void activate() {
        super.activate();
    }

    @Override
    public void deActivate() {
        super.deActivate();
    }

    @Override
    public boolean consumeHMIEvent(HMIEvent hMIEvent, String string) {
        if ("updateScreenshot" == string) {
            CanvasModel canvasModel = (CanvasModel)this.getWidget();
            canvasModel.requestScreenshotUpdate();
        } else if ("screenshotPrepared" == string) {
            CanvasModel canvasModel = (CanvasModel)this.getWidget();
            canvasModel.screenshotPreparationFinished();
        }
        return super.consumeHMIEvent(hMIEvent, string);
    }

    @Override
    public void fire_screenshotCreated() {
        this.fireHMIEvent("screenshotCreated");
    }

    @Override
    public void fire_prepareScreenshot() {
        this.fireHMIEvent("prepareScreenshot");
    }
}

