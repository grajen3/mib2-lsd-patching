/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets.controller;

import de.vw.mib.widgets.controller.ListController;

public interface TemplateListController
extends ListController {
    public static final String IN_RESTARTFOLLOWMODE_NAME;
    public static final String IN_TRIGGERINDEXRELATIVE_NAME;
    public static final String IN_TRIGGERINDEXABSOLUTE_NAME;
    public static final String OUT_ADJUSTMENTSTARTED_NAME;
    public static final String OUT_ADJUSTMENTSTOPPED_NAME;
    public static final String OUT_TRIGGERINDEXRELATIVEFAILED_NAME;
    public static final String OUT_TRIGGERINDEXABSOLUTEFAILED_NAME;

    default public void abortTouchActions() {
    }

    default public void fire_restartFollowMode() {
    }

    default public void fire_triggerIndexRelative(int n) {
    }

    default public void fire_triggerIndexAbsolute(int n) {
    }

    default public void fire_adjustmentStarted() {
    }

    default public void fire_adjustmentStopped() {
    }

    default public void fire_triggerIndexRelativeFailed() {
    }

    default public void fire_triggerIndexAbsoluteFailed() {
    }
}

