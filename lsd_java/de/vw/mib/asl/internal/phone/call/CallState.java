/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.phone.call;

import de.vw.mib.collections.ints.IntIntOptHashMap;

public class CallState {
    boolean allIdle = true;
    boolean ringtoneToBeActivated = false;
    boolean ringing = false;
    final IntIntOptHashMap lastCallStates = new IntIntOptHashMap(3);

    public void reset() {
        this.allIdle = true;
        this.ringtoneToBeActivated = false;
        this.ringing = false;
    }
}

