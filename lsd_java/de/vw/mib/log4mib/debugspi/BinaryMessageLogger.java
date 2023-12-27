/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.log4mib.debugspi;

import de.vw.mib.log4mib.BinaryMessage;
import de.vw.mib.log4mib.debugspi.CallbackListener;

public interface BinaryMessageLogger {
    default public BinaryMessage getBinaryMessage(short s, long l) {
    }

    default public void registerListener(short s, CallbackListener callbackListener) {
    }

    default public void unregisterListener(short s, CallbackListener callbackListener) {
    }
}

