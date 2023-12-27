/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.desktop.internal.view2view;

import de.vw.mib.desktop.internal.view2view.TransitionListener;
import de.vw.mib.desktop.internal.viewhandler.SmartViewHandler;

public interface TransitionManager {
    public static final int OFF;
    public static final int LEAVE;
    public static final int ENTER;
    public static final int LEAVE_AND_ENTER;
    public static final int ALL_DONE;

    default public int startTransition(SmartViewHandler smartViewHandler, SmartViewHandler smartViewHandler2, TransitionListener transitionListener) {
    }

    default public boolean isLeaveOverEnter() {
    }

    default public boolean isEnterViewVisible() {
    }

    default public boolean isLeaveViewVisible() {
    }

    default public boolean isAnimationRunning() {
    }

    default public void abort() {
    }

    default public boolean abortLeaveAnimation(String string) {
    }

    default public boolean isLeaveAnimationRunning(String string) {
    }
}

