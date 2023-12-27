/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.event.dispatcher;

public interface SystemEventDispatcher {
    default public void createAndSubmitDisplayEvent(int n) {
    }

    default public void createAndSubmitHardkeyEvent(int n) {
    }

    default public void createAndSubmitHMIEvent(int n) {
    }

    default public void createAndSubmitPowerStateEvent(int n) {
    }

    default public void createAndSubmitProximityEvent(boolean bl, int n) {
    }

    default public void createAndSubmitRestoreFactorySettingsEvent() {
    }

    default public void createAndSubmitRotationEvent(int n, int n2, int n3) {
    }

    default public void createAndSubmitSpeechCommandEvent(int n) {
    }

    default public void createAndSubmitSpeechEvent(int n, long l, int n2, String string, int n3) {
    }

    default public void createAndSubmitSpeechStateEvent(int n) {
    }

    default public void createAndSubmitTouchEventClick(int n, int n2, int n3, int n4) {
    }

    default public void createAndSubmitTouchEventDrag(int n, int n2, int n3, int n4, int n5) {
    }

    default public void createAndSubmitTouchEventDrag2(int n, int n2, int n3, int n4, int n5, int n6) {
    }

    default public void createAndSubmitTouchEventFlick(int n, int n2, int n3, int n4, int n5) {
    }

    default public void createAndSubmitTouchEventFlick2(int n, int n2, int n3, int n4, int n5, int n6) {
    }

    default public void createAndSubmitTouchEventMousePosition(int n, int n2, int n3) {
    }

    default public void createAndSubmitTouchEventPress(int n, int n2, int n3) {
    }

    default public void createAndSubmitTouchEventPress2(int n, int n2, int n3, int n4) {
    }

    default public void createAndSubmitTouchEventRelease(int n, int n2, int n3) {
    }

    default public void createAndSubmitTouchEventRightClick(int n, int n2, int n3) {
    }

    default public void createAndSubmitTouchEventRotation(int n, int n2) {
    }

    default public void createAndSubmitTouchEventZoom(int n, int n2, int n3, int n4, int n5) {
    }
}

