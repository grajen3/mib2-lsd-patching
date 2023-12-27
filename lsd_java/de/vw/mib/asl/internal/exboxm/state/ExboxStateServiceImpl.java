/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.exboxm.state;

import de.vw.mib.asl.ASLPropertyManager;
import de.vw.mib.asl.api.exboxm.guidance.ExboxGuidanceListener;
import de.vw.mib.asl.api.exboxm.guidance.GuidanceState;
import de.vw.mib.asl.framework.api.dsiproxy.DSIProxy;
import de.vw.mib.asl.internal.exboxm.IntIntMiniMap;
import de.vw.mib.asl.internal.exboxm.services.StartupListener;
import de.vw.mib.asl.internal.exboxm.state.ExboxOperationStateListener;
import de.vw.mib.asl.internal.exboxm.state.ExboxSpeechListener;
import de.vw.mib.asl.internal.exboxm.state.ExboxStateService;
import de.vw.mib.asl.internal.exboxm.state.MobileDeviceLinkStatusHelper;
import de.vw.mib.asl.internal.exboxm.util.AbstractExboxListener;
import de.vw.mib.asl.internal.exboxm.util.ExboxLogger;
import de.vw.mib.asl.internal.exboxm.util.Preconditions;
import de.vw.mib.log4mib.Logger;
import java.util.HashSet;
import java.util.Iterator;
import org.dsi.ifc.base.DSIBase;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.exboxm.DSIExBoxM;
import org.dsi.ifc.exboxm.ExBoxState;
import org.dsi.ifc.exboxm.MobileDeviceLinkStatus;

public class ExboxStateServiceImpl
extends AbstractExboxListener
implements ExboxStateService,
StartupListener {
    private static final IntIntMiniMap OPERATIONSTATE_DSI2ASL = new IntIntMiniMap(15, "NORMAL|INITIALIZING|DEFECT|BAPERROR", new int[]{0, 0, 3, 3, 15, 15, -1, 15});
    private final ExboxLogger exboxLogger;
    private final DSIProxy dsiProxy;
    private final ASLPropertyManager aslPropertyManager;
    private final HashSet exboxOperationStateListeners;
    private ExboxGuidanceListener exboxGuidanceListener;
    private ExboxSpeechListener exboxSpeechListener;
    private GuidanceState lastReportedExboxGuidanceState;
    private boolean lastReportedExboxSpeechActiveState;
    private int currentOperationState;
    private MobileDeviceLinkStatus lastRequestedMobileDeviceLinkStatus;
    private DSIBase dsiExBoxM;
    private static final boolean TELEPHONE_ACTIVE;
    static /* synthetic */ Class class$org$dsi$ifc$exboxm$DSIExBoxM;

    public ExboxStateServiceImpl(Logger logger, DSIProxy dSIProxy, ASLPropertyManager aSLPropertyManager) {
        Preconditions.checkArgumentNotNull(logger, "EX: Logger must not be null.");
        Preconditions.checkArgumentNotNull(dSIProxy, "EX: DSIProxy must not be null.");
        Preconditions.checkArgumentNotNull(aSLPropertyManager, "EX: ASLPropertyManager must not be null.");
        this.exboxLogger = new ExboxLogger(logger, super.getClass());
        this.dsiProxy = dSIProxy;
        this.aslPropertyManager = aSLPropertyManager;
        this.exboxOperationStateListeners = new HashSet();
        this.exboxGuidanceListener = null;
        this.exboxSpeechListener = null;
        this.lastReportedExboxGuidanceState = GuidanceState.INACTIVE;
        this.lastReportedExboxSpeechActiveState = false;
        this.lastRequestedMobileDeviceLinkStatus = null;
        this.currentOperationState = 3;
    }

    @Override
    public void addExboxOperationStateListener(ExboxOperationStateListener exboxOperationStateListener) {
        if (exboxOperationStateListener == null) {
            throw new IllegalArgumentException("EX: Incoming ExboxOperationStateListener must not be null.");
        }
        if (this.exboxOperationStateListeners.contains(exboxOperationStateListener)) {
            throw new IllegalArgumentException("EX: Incoming ExboxOperationStateListener already registered.");
        }
        this.exboxOperationStateListeners.add(exboxOperationStateListener);
    }

    @Override
    public boolean isExboxOperationStateNormal() {
        return this.currentOperationState == 0;
    }

    @Override
    public GuidanceState getExboxGuidanceState() {
        return this.lastReportedExboxGuidanceState;
    }

    @Override
    public void notifyPowerOnEvent() {
        this.dsiExBoxM = this.dsiProxy.getService(null, class$org$dsi$ifc$exboxm$DSIExBoxM == null ? (class$org$dsi$ifc$exboxm$DSIExBoxM = ExboxStateServiceImpl.class$("org.dsi.ifc.exboxm.DSIExBoxM")) : class$org$dsi$ifc$exboxm$DSIExBoxM);
        this.dsiExBoxM.setNotification(new int[]{7, 4}, (DSIListener)this);
    }

    @Override
    public void removeOperationStateListener(ExboxOperationStateListener exboxOperationStateListener) {
        this.exboxOperationStateListeners.remove(exboxOperationStateListener);
    }

    @Override
    public void setGuidanceListener(ExboxGuidanceListener exboxGuidanceListener) {
        this.exboxGuidanceListener = exboxGuidanceListener;
    }

    @Override
    public void setSmartphoneGuidanceState(GuidanceState guidanceState) {
        if (guidanceState == null) {
            throw new IllegalArgumentException("EX: Incoming GuidanceState must not be null.");
        }
        if (this.dsiExBoxM == null) {
            this.exboxLogger.warn("No power on received, yet, no DSI call possible.");
            return;
        }
        this.sendNewSmartphoneGuidanceState(guidanceState);
    }

    @Override
    public void setSpeechListener(ExboxSpeechListener exboxSpeechListener) {
        this.exboxSpeechListener = exboxSpeechListener;
    }

    @Override
    public void updateMobileDeviceLinkStatus(MobileDeviceLinkStatus mobileDeviceLinkStatus, ExBoxState exBoxState, int n) {
        if (n != 1) {
            this.exboxLogger.warn(new StringBuffer().append("Incoming data not processed. Parameter validFlag is not DSIListener.ATTRVALIDFLAG_VALID=1, but is equal to ").append(n).append(".").toString());
            return;
        }
        if (this.isExboxOperationStateNormal()) {
            this.updateSpeechState(exBoxState.isExBoxSpeechActive());
            this.updateMobileDeviceLinkState(mobileDeviceLinkStatus, exBoxState);
        } else {
            this.exboxLogger.warn("Operation state is not normal, no callback, since it would be meaningless.");
        }
    }

    @Override
    public void updateOperationState(int n, int n2) {
        if (n2 != 1) {
            this.exboxLogger.warn(new StringBuffer().append("Incoming data not processed. Parameter validFlag is not DSIListener.ATTRVALIDFLAG_VALID=1, but is equal to ").append(n2).append(".").toString());
            return;
        }
        String string = OPERATIONSTATE_DSI2ASL.getName(n);
        this.exboxLogger.trace(new Object[]{"updateOperationState called. Operation state is ", new Integer(n), "(", string, ")."});
        this.updateOperationState(n);
        this.processOperationState();
    }

    boolean isLastExboxSpeechActiveState() {
        return this.lastReportedExboxSpeechActiveState;
    }

    private void processOperationState() {
        if (!this.isExboxOperationStateNormal()) {
            this.exboxLogger.warn("Operation state is not normal, resetting guidance and speech to inactive.");
            this.updateGuidanceState(GuidanceState.INACTIVE);
            this.updateSpeechState(false);
        } else if (this.lastRequestedMobileDeviceLinkStatus != null) {
            this.exboxLogger.trace(new Object[]{"Flushing mobile device link status cache. ", this.lastRequestedMobileDeviceLinkStatus, " will be sent to DSI."});
            this.sendNewMobileDeviceLinkStatus(this.lastRequestedMobileDeviceLinkStatus);
        }
    }

    private void updateOperationState(int n) {
        this.currentOperationState = n;
        this.notifyModel();
        this.notifyListeners(this.isExboxOperationStateNormal());
    }

    private void notifyListeners(boolean bl) {
        if (this.exboxOperationStateListeners.isEmpty()) {
            this.exboxLogger.warn("No instances of ExboxOperationStateListener registered.");
            return;
        }
        Iterator iterator = this.exboxOperationStateListeners.iterator();
        while (iterator.hasNext()) {
            ExboxOperationStateListener exboxOperationStateListener = (ExboxOperationStateListener)iterator.next();
            exboxOperationStateListener.onExboxStateChange(bl);
        }
    }

    private void notifyModel() {
        int n = OPERATIONSTATE_DSI2ASL.get(this.currentOperationState);
        this.aslPropertyManager.valueChangedInteger(3228, n);
    }

    private void updateGuidanceState(GuidanceState guidanceState) {
        if (this.exboxGuidanceListener == null) {
            this.exboxLogger.warn("No ExboxGuidanceListener registered!");
            return;
        }
        if (guidanceState == this.lastReportedExboxGuidanceState) {
            this.exboxLogger.trace(new Object[]{"No change in GuidanceState: lastReportedGuidanceState: ", this.lastReportedExboxGuidanceState, ", currently received from DSI: ", guidanceState});
            return;
        }
        this.exboxGuidanceListener.onExboxGuidanceStateChanged(guidanceState);
        this.lastReportedExboxGuidanceState = guidanceState;
    }

    private void updateMobileDeviceLinkState(MobileDeviceLinkStatus mobileDeviceLinkStatus, ExBoxState exBoxState) {
        if (this.lastRequestedMobileDeviceLinkStatus == null || MobileDeviceLinkStatusHelper.areEqual(this.lastRequestedMobileDeviceLinkStatus, mobileDeviceLinkStatus)) {
            this.updateGuidanceState(exBoxState.isExBoxNavigationActive() ? GuidanceState.ACTIVE : GuidanceState.INACTIVE);
        } else {
            this.exboxLogger.warn(new StringBuffer().append("Received ").append(mobileDeviceLinkStatus).append(" did not match previously sent one. Sending again this: ").append(this.lastRequestedMobileDeviceLinkStatus).toString());
            this.sendNewMobileDeviceLinkStatus(this.lastRequestedMobileDeviceLinkStatus);
        }
    }

    private void updateSpeechState(boolean bl) {
        if (this.exboxSpeechListener == null) {
            this.exboxLogger.warn("No ExboxSpeechListener registered!");
            return;
        }
        if (bl == this.lastReportedExboxSpeechActiveState) {
            this.exboxLogger.trace(new Object[]{"No change in speech active state: lastReportedExboxSpeechActiveState: ", this.lastReportedExboxSpeechActiveState, ", currently received from DSI: ", bl});
            return;
        }
        this.exboxSpeechListener.onSpeechStateChange(bl);
        this.lastReportedExboxSpeechActiveState = bl;
    }

    private void sendNewSmartphoneGuidanceState(GuidanceState guidanceState) {
        boolean bl = guidanceState == GuidanceState.ACTIVE;
        MobileDeviceLinkStatus mobileDeviceLinkStatus = new MobileDeviceLinkStatus(255, bl, false);
        if (!MobileDeviceLinkStatusHelper.areEqual(this.lastRequestedMobileDeviceLinkStatus, mobileDeviceLinkStatus)) {
            this.sendNewMobileDeviceLinkStatus(mobileDeviceLinkStatus);
        } else {
            this.exboxLogger.warn(new StringBuffer().append(mobileDeviceLinkStatus).append(" already sent to DSI, not sending again.").toString());
        }
    }

    private void sendNewMobileDeviceLinkStatus(MobileDeviceLinkStatus mobileDeviceLinkStatus) {
        this.lastRequestedMobileDeviceLinkStatus = mobileDeviceLinkStatus;
        if (this.isExboxOperationStateNormal()) {
            ((DSIExBoxM)this.dsiExBoxM).setMobileDeviceLink(this.lastRequestedMobileDeviceLinkStatus);
        } else {
            this.exboxLogger.warn(new StringBuffer().append("Operation state is not normal, requested ").append(this.lastRequestedMobileDeviceLinkStatus).append(" will be cached and sent later.").toString());
        }
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }
}

