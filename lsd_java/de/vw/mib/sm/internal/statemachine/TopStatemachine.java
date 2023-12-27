/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.sm.internal.statemachine;

import de.vw.mib.log4mib.LogMessage;
import de.vw.mib.sm.AppHmiEnvironment;

public interface TopStatemachine {
    public static final byte KIND_MAIN_;
    public static final byte KIND_DYNAMIC_;
    public static final byte KIND_HAPTIC_;
    public static final byte KIND_SPEECH_;
    public static final byte KIND_MAIN_HAPTIC;
    public static final byte KIND_MAIN_SPEECH;
    public static final byte KIND_DYNAMIC_HAPTIC;
    public static final byte KIND_DYNAMIC_SPEECH;
    public static final int LIFECYCLE_INACTIVE;
    public static final int LIFECYCLE_ACTIVE;
    public static final int LIFECYCLE_SUSPEND;
    public static final int LIFECYCLE_FINISHING;

    default public AppHmiEnvironment getEnvironment() {
    }

    default public int getId() {
    }

    default public String getLayerLabel() {
    }

    default public int getPopupInfoId() {
    }

    default public int getPopupInfoId(int n, int n2) {
    }

    default public short getSpeechIndex() {
    }

    default public short getSpeechClientId() {
    }

    default public byte getKind() {
    }

    default public void start(AppHmiEnvironment appHmiEnvironment) {
    }

    default public void finish() {
    }

    default public void suspend() {
    }

    default public void resume() {
    }

    default public void focusGained() {
    }

    default public void focusLost() {
    }

    default public boolean livesIn(int n) {
    }

    default public boolean canResponseToHMIEvent() {
    }

    default public boolean handleHMIEvent() {
    }

    default public short getCurrentSubStatemachinePath() {
    }

    default public int getCurrentSubStatemachine() {
    }

    default public short getCurrentState() {
    }

    default public void restoreState(short s, short s2) {
    }

    default public void appendToLog(LogMessage logMessage) {
    }

    default public void enterIncludeDdpGroup(int n) {
    }

    default public void leaveIncludeDdpGroup() {
    }

    default public int getIncludeDdpGroupId() {
    }

    default public void enterWaitaphoreForProperty(int n, int n2, int n3, int n4, int n5) {
    }

    default public void enterWaitaphoreForAslList(int n, int n2, int n3, int n4, int n5) {
    }

    default public void enterWaitaphoreForAppAdapterList(int n, int n2, int n3, int n4, int n5) {
    }

    default public void enterWaitaphoreForNothing(int n) {
    }

    default public void leaveWaitaphore() {
    }
}

