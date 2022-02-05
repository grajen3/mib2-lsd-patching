/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.androidauto.api.impl;

import de.vw.mib.asl.api.exboxm.guidance.ExboxGuidanceListener;
import de.vw.mib.asl.api.exboxm.guidance.ExboxGuidanceManager;
import de.vw.mib.asl.api.exboxm.guidance.GuidanceState;
import de.vw.mib.asl.internal.androidauto.target.NavigationListener;
import de.vw.mib.hmi.utils.Preconditions;

public class ExboxGuidanceListenerImpl
implements ExboxGuidanceListener {
    private /*final*/ ExboxGuidanceManager exBoxGuidanceManager;
    private /*final*/ NavigationListener androidautoListener;

    public ExboxGuidanceListenerImpl(NavigationListener navigationListener, ExboxGuidanceManager exboxGuidanceManager) {
        Preconditions.checkNotNull(navigationListener, "AndroidAutoListener must not be null!");
        Preconditions.checkNotNull(exboxGuidanceManager, "ExboxGuidanceManager must not be null!");
        this.exBoxGuidanceManager = exboxGuidanceManager;
        this.androidautoListener = navigationListener;
    }

    public void startup() {
        this.exBoxGuidanceManager.addListener(this);
    }

    public void shutdown() {
        this.exBoxGuidanceManager.removeListener(this);
    }

    public void setSmartphoneGuidanceActive() {
        System.out.println("AA ExboxGuidanceListenerImpl.setSmartphoneGuidanceActive()");
        new Exception("Stack trace").printStackTrace();
        this.exBoxGuidanceManager.changeSmartphoneGuidanceStateTo(GuidanceState.ACTIVE);
    }

    public void setSmartphoneGuidanceInactive() {
        System.out.println("AA ExboxGuidanceListenerImpl.setSmartphoneGuidanceInactive()");
        new Exception("Stack trace").printStackTrace();
        this.exBoxGuidanceManager.changeSmartphoneGuidanceStateTo(GuidanceState.INACTIVE);
    }

   // @Override
    public void onExboxGuidanceStateChanged(GuidanceState guidanceState) {
        System.out.println("AA ExboxGuidanceListenerImpl.onExboxGuidanceStateChanged(" + guidanceState + ")");
        new Exception("Stack trace").printStackTrace();

        if (guidanceState == GuidanceState.ACTIVE) {
            this.androidautoListener.updateGuidanceActive(true);
            this.exBoxGuidanceManager.changeSmartphoneGuidanceStateTo(GuidanceState.INACTIVE);
        }
    }
}

