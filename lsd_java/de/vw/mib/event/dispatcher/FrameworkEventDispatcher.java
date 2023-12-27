/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.event.dispatcher;

import de.vw.mib.event.consumer.ViewAnimationEventConsumer;
import de.vw.mib.timer.Invoker;

public interface FrameworkEventDispatcher
extends Invoker {
    default public void createAndSubmitAnimationEvent(int n) {
    }

    default public void createAndSubmitDynamicStateEvent(int n, int n2) {
    }

    default public void createAndSubmitListReadoutEvent(int n, int n2, int n3) {
    }

    default public void createAndSubmitLSChangeEvent(int n) {
    }

    default public void createAndSubmitPopupStackChangeEvent(int n, int n2) {
    }

    default public void createAndSubmitReadoutSelectionEvent(int n, int[] nArray, int n2, int n3) {
    }

    default public void createAndSubmitRepaintEvent() {
    }

    default public void createAndSubmitStartupEvent(int n) {
    }

    default public void createAndSubmitViewAnimationEvent(ViewAnimationEventConsumer viewAnimationEventConsumer, int n) {
    }
}

