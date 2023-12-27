/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.car.fpa.service;

import de.vw.mib.asl.api.car.fpa.FPACharismaProfileFunctionAvailability;
import de.vw.mib.asl.api.car.fpa.FPACharismaProfileState;
import de.vw.mib.asl.internal.car.fpa.service.FPACharismaProfileStateImpl;
import edu.emory.mathcs.backport.java.util.Arrays;

public class FPACharismaProfileFunctionAvailabilityImpl
implements FPACharismaProfileFunctionAvailability {
    private FPACharismaProfileState[] functionStates = new FPACharismaProfileState[12];
    private boolean[] profilesAvailable = new boolean[12];

    public FPACharismaProfileFunctionAvailabilityImpl() {
        this.initDefault();
    }

    public void setFunctionStates(FPACharismaProfileState[] fPACharismaProfileStateArray) {
        this.functionStates = fPACharismaProfileStateArray;
    }

    public void setProfilesAvailable(boolean[] blArray) {
        this.profilesAvailable = blArray;
    }

    @Override
    public FPACharismaProfileState[] getFunctionStates() {
        return this.functionStates;
    }

    @Override
    public boolean[] getProfilesAvailable() {
        return this.profilesAvailable;
    }

    private void initDefault() {
        this.functionStates[0] = new FPACharismaProfileStateImpl(false, false, 0);
        this.functionStates[1] = new FPACharismaProfileStateImpl(false, false, 0);
        this.functionStates[2] = new FPACharismaProfileStateImpl(false, false, 0);
        this.functionStates[3] = new FPACharismaProfileStateImpl(false, false, 0);
        this.functionStates[4] = new FPACharismaProfileStateImpl(false, false, 0);
        this.functionStates[5] = new FPACharismaProfileStateImpl(false, false, 0);
        this.functionStates[6] = new FPACharismaProfileStateImpl(false, false, 0);
        this.functionStates[7] = new FPACharismaProfileStateImpl(false, false, 0);
        this.functionStates[8] = new FPACharismaProfileStateImpl(false, false, 0);
        this.functionStates[9] = new FPACharismaProfileStateImpl(false, false, 0);
        this.functionStates[10] = new FPACharismaProfileStateImpl(false, false, 0);
        Arrays.fill(this.profilesAvailable, false);
    }

    @Override
    public void setFunctionStateAt(FPACharismaProfileState fPACharismaProfileState, int n) {
        if (n >= 0 && n <= 11) {
            this.functionStates[n] = fPACharismaProfileState;
        }
    }
}

