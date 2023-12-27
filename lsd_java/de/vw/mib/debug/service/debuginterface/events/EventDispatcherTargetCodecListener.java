/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.debug.service.debuginterface.events;

import java.util.Set;

public interface EventDispatcherTargetCodecListener {
    default public void sendHMIStatemachineEvent(int n) {
    }

    default public void sendHMISystemEvent(int n) {
    }

    default public void sendHardkeyEvent(int n) {
    }

    default public void sendDDSRotationEvent(int n, int n2) {
    }

    default public void sendViewchangeEvent(String string) {
    }

    default public void sendEventGeneric(int n, int n2, int n3, Set set) {
    }

    default public void answerSendHMIEvent(boolean bl, String string) {
    }

    default public void answerSendHardKeyEvent(boolean bl, String string) {
    }

    default public void answerSendRotationEvent(boolean bl, String string) {
    }

    default public void answerSendViewchangeEvent(boolean bl, String string) {
    }
}

