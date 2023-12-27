/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.viewmanager.internal.popup;

public interface PopupInformationTable {
    default public int getPriority(int n) {
    }

    default public int getTimeout(int n) {
    }

    default public int getTimeMin(int n) {
    }

    default public int getTimeRestart(int n) {
    }

    default public boolean isGlobalPopup(int n) {
    }

    default public boolean shallMoveToHomeContext(int n) {
    }

    default public boolean shallCloseWhenMovedToHomeContext(int n) {
    }

    default public boolean shallCloseWhenSuperseded(int n) {
    }

    default public boolean isActiveInUserPerceivedOffMode(int n) {
    }

    default public boolean shallCloseOnTouch(int n) {
    }

    default public boolean shallCloseOnProximity(int n) {
    }

    default public boolean shallForwardTouchEvent(int n) {
    }

    default public boolean isActiveDuringSpeechDialog(int n) {
    }

    default public boolean isSpeakThrough(int n) {
    }

    default public boolean isStopsSpeech(int n) {
    }

    default public String getHomeContextId(int n) {
    }

    default public int getConsumeEventId(int n) {
    }

    default public int[] getConsumeEventIds(int n) {
    }

    default public boolean isConsumeEventId(int n, int n2) {
    }

    default public String[] getHomeContextIdsByEventId(int n) {
    }

    default public int getId4SdsNotifyViewManagerSdsOn() {
    }

    default public int getId4SdsNotifyViewManagerSdsOff() {
    }

    default public boolean shallCloseOnHk(int n, int n2) {
    }

    default public boolean isVisibleInUserPerceivedOffMode(int n) {
    }

    default public boolean hasInvisibleInactiveArea(int n) {
    }

    default public boolean shallShowDuringExBox(int n) {
    }
}

