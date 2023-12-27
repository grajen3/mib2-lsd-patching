/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.sm.internal.statemachine;

import de.vw.mib.log4mib.LogMessage;
import de.vw.mib.sm.AppHmiEnvironment;
import de.vw.mib.sm.internal.env.InactiveHmiEnvironment;
import de.vw.mib.sm.internal.statemachine.TopStatemachine;

public class InactiveDummyTopStatemachine
implements TopStatemachine {
    public static final TopStatemachine INSTANCE = new InactiveDummyTopStatemachine();

    @Override
    public AppHmiEnvironment getEnvironment() {
        return InactiveHmiEnvironment.INSTANCE;
    }

    @Override
    public int getId() {
        return -1;
    }

    @Override
    public String getLayerLabel() {
        throw new IllegalStateException("Statemachine is inactive.");
    }

    @Override
    public int getPopupInfoId() {
        return 0;
    }

    @Override
    public int getPopupInfoId(int n, int n2) {
        return 0;
    }

    @Override
    public short getSpeechIndex() {
        return 0;
    }

    @Override
    public short getSpeechClientId() {
        return 0;
    }

    @Override
    public byte getKind() {
        return 0;
    }

    @Override
    public void start(AppHmiEnvironment appHmiEnvironment) {
    }

    @Override
    public void finish() {
    }

    @Override
    public void suspend() {
    }

    @Override
    public void resume() {
    }

    @Override
    public void focusGained() {
    }

    @Override
    public void focusLost() {
    }

    @Override
    public boolean livesIn(int n) {
        return false;
    }

    @Override
    public boolean canResponseToHMIEvent() {
        return false;
    }

    @Override
    public boolean handleHMIEvent() {
        return false;
    }

    @Override
    public short getCurrentSubStatemachinePath() {
        return 0;
    }

    @Override
    public int getCurrentSubStatemachine() {
        return 0;
    }

    @Override
    public short getCurrentState() {
        return -1;
    }

    @Override
    public void restoreState(short s, short s2) {
    }

    @Override
    public void appendToLog(LogMessage logMessage) {
    }

    @Override
    public void enterIncludeDdpGroup(int n) {
    }

    @Override
    public void leaveIncludeDdpGroup() {
    }

    @Override
    public int getIncludeDdpGroupId() {
        return -1;
    }

    @Override
    public void enterWaitaphoreForProperty(int n, int n2, int n3, int n4, int n5) {
    }

    @Override
    public void enterWaitaphoreForAslList(int n, int n2, int n3, int n4, int n5) {
    }

    @Override
    public void enterWaitaphoreForAppAdapterList(int n, int n2, int n3, int n4, int n5) {
    }

    @Override
    public void enterWaitaphoreForNothing(int n) {
    }

    @Override
    public void leaveWaitaphore() {
    }
}

