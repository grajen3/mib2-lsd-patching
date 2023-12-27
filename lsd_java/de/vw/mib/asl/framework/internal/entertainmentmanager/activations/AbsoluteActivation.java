/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.entertainmentmanager.activations;

import de.vw.mib.asl.framework.internal.entertainmentmanager.activations.AbstractActivation;

public class AbsoluteActivation
extends AbstractActivation {
    public static final AbsoluteActivation INVALID = new AbsoluteActivation(-1, -1, false);
    public static final AbsoluteActivation LAST_RESORT = new AbsoluteActivation(1, 1);
    private AbsoluteActivation nextInserted = null;
    private int callId;

    private AbsoluteActivation(int n, int n2, boolean bl) {
        super(n, n2, bl);
    }

    public AbsoluteActivation(int n, int n2) {
        this(n, n2, true);
    }

    public AbsoluteActivation getNextInserted() {
        return this.nextInserted;
    }

    public void setNextInserted(AbsoluteActivation absoluteActivation) {
        this.nextInserted = absoluteActivation;
    }

    public boolean isValid() {
        return this != INVALID;
    }

    public int getCallId() {
        return this.callId;
    }

    public void setCallId(int n) {
        this.callId = n;
    }
}

