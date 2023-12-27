/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechtuner.utils;

import de.vw.mib.asl.internal.list.ASLListManager;
import de.vw.mib.asl.internal.list.impl.GenericASLList;

public interface SpeechTunerModelServices {
    default public void writeIntegerToDatapool(int n, int n2) {
    }

    default public void sendEventToModel(int n) {
    }

    default public void sendUnexpectedErrorEventToModel() {
    }

    default public GenericASLList getGenericASLList(int n) {
    }

    default public ASLListManager getListManager() {
    }
}

