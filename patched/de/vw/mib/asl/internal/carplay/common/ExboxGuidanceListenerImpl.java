/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.carplay.common;

import de.vw.mib.asl.api.exboxm.guidance.ExboxGuidanceListener;
import de.vw.mib.asl.api.exboxm.guidance.ExboxGuidanceManager;
import de.vw.mib.asl.api.exboxm.guidance.GuidanceState;
import de.vw.mib.asl.api.navigation.ASLNavigationServicesListener;
import de.vw.mib.hmi.utils.Preconditions;

public class ExboxGuidanceListenerImpl
implements ExboxGuidanceListener {
    private /*final*/ ExboxGuidanceManager exBoxGuidanceManager;
    private /*final*/ ASLNavigationServicesListener carplayListener;

    public ExboxGuidanceListenerImpl(ASLNavigationServicesListener aSLNavigationServicesListener, ExboxGuidanceManager exboxGuidanceManager) {
        Preconditions.checkNotNull(aSLNavigationServicesListener, "CarplayListener must not be null!");
        Preconditions.checkNotNull(exboxGuidanceManager, "ExboxGuidanceManager must not be null!");
        this.carplayListener = aSLNavigationServicesListener;
        this.exBoxGuidanceManager = exboxGuidanceManager;
    }

    public void startup() {
        this.exBoxGuidanceManager.addListener(this);
    }

    public void shutdown() {
        this.exBoxGuidanceManager.removeListener(this);
    }

    public void setSmartphoneGuidanceActive() {
        System.out.println("CP ExboxGuidanceListenerImpl.setSmartphoneGuidanceActive()");
        new Exception("Stack trace").printStackTrace();
        this.exBoxGuidanceManager.changeSmartphoneGuidanceStateTo(GuidanceState.ACTIVE);
    }

    public void setSmartphoneGuidanceInactive() {
        System.out.println("CP ExboxGuidanceListenerImpl.setSmartphoneGuidanceInactive()");
        new Exception("Stack trace").printStackTrace();
        this.exBoxGuidanceManager.changeSmartphoneGuidanceStateTo(GuidanceState.INACTIVE);
    }

   // @Override
    public void onExboxGuidanceStateChanged(GuidanceState guidanceState) {
        System.out.println("CP ExboxGuidanceListenerImpl.onExboxGuidanceStateChanged(" + guidanceState + ")");
        new Exception("Stack trace").printStackTrace();
        if (guidanceState == GuidanceState.ACTIVE) {
            this.carplayListener.updateGuidanceActive(true);
            this.exBoxGuidanceManager.changeSmartphoneGuidanceStateTo(GuidanceState.INACTIVE);
        }
    }
}

