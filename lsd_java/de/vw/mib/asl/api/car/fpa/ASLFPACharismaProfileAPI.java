/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.api.car.fpa;

import de.vw.mib.asl.api.car.fpa.FPACharismaProfileService;
import de.vw.mib.asl.api.car.fpa.FPACharismaProfileServiceListener;

public interface ASLFPACharismaProfileAPI {
    default public FPACharismaProfileService getFPACharismaProfileService() {
    }

    default public void addFPAServiceListener(FPACharismaProfileServiceListener fPACharismaProfileServiceListener) {
    }

    default public void removeFPAServiceListener(FPACharismaProfileServiceListener fPACharismaProfileServiceListener) {
    }
}

