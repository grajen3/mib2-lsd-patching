/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.api.phone.services.callstack;

import de.vw.mib.asl.api.phone.services.callstack.CallstackUpdates;

public interface CallstackService {
    default public void registerCallstackUpdates(CallstackUpdates callstackUpdates) {
    }
}

