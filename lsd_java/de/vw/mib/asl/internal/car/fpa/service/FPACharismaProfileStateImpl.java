/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.car.fpa.service;

import de.vw.mib.asl.api.car.fpa.FPACharismaProfileState;

public class FPACharismaProfileStateImpl
implements FPACharismaProfileState {
    private boolean isFunctionExistent = false;
    private boolean functionState = false;
    private int profileFunctionAvailabilityReason = 0;

    public FPACharismaProfileStateImpl(boolean bl, boolean bl2, int n) {
        this.isFunctionExistent = bl;
        this.functionState = bl2;
        this.profileFunctionAvailabilityReason = n;
    }

    @Override
    public boolean isFunctionExistent() {
        return this.isFunctionExistent;
    }

    @Override
    public boolean getProfileFunctionState() {
        return this.functionState;
    }

    @Override
    public int getProfileFunctionAvailabilityReason() {
        return this.profileFunctionAvailabilityReason;
    }
}

