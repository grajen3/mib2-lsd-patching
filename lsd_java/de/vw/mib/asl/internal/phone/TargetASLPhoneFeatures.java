/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.phone;

import de.vw.mib.asl.api.system.SystemFeaturesAndCodingConstants;
import de.vw.mib.asl.framework.api.diagnosis.config.Access;
import de.vw.mib.asl.framework.api.diagnosis.config.Adaptation;
import de.vw.mib.asl.framework.api.diagnosis.config.Coding;
import de.vw.mib.asl.framework.api.startupv7r.ASLStartupv7rFactory;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.phone.TargetASLPhoneFeatures$NadListener;
import de.vw.mib.asl.internal.phone.util.TripleMobileEquipment;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.GenericEventException;
import de.vw.mib.genericevents.GenericEvents;
import org.dsi.ifc.telephoneng.DSIMobileEquipmentListener;

public final class TargetASLPhoneFeatures
extends TripleMobileEquipment
implements SystemFeaturesAndCodingConstants {
    private static final String LOGGING_DELIM;
    private boolean isTableCodingAlreadyRead = false;
    private boolean isTableAdaptationAlreadyRead = false;
    private final boolean isIntPhoneActivationStateAlreadyReceived;
    private final boolean isInternalPhoneDetectedInSystem;
    private boolean isInternalPhoneCodedAvailable = false;
    private boolean isNadDetectedInSystem = false;
    private boolean isNadActivationStateAlreadyReceived = false;
    private boolean isNADCodedAvailable = false;
    private boolean isInternalPhoneAdaptationModuleActivated = false;
    private boolean isInternalPhoneFeatureFlagAlreadySet = false;
    private boolean internalPhoneFeatureFlagValue = false;

    public TargetASLPhoneFeatures(GenericEvents genericEvents, String string) {
        super(genericEvents, string);
        this.isIntPhoneActivationStateAlreadyReceived = false;
        this.isInternalPhoneDetectedInSystem = false;
    }

    @Override
    public void handleEvent(EventGeneric eventGeneric) {
        switch (eventGeneric.getReceiverEventId()) {
            case 1200004: {
                this.info().append("[TargetASLPhoneFeatures] ").append("ASLDiagnosisServiceIds.DIAG_MODE_PERSISTENT_VALUE_CHANGED received").log();
                this.requestDiagData(eventGeneric.getInt(2), eventGeneric.getLong(3));
                break;
            }
            case 100033: {
                this.processDiagData(eventGeneric);
                break;
            }
        }
    }

    @Override
    protected int[] getMobileEquipmentNotification() {
        return new int[]{4};
    }

    @Override
    protected DSIMobileEquipmentListener createNadListener() {
        return new TargetASLPhoneFeatures$NadListener(this, null);
    }

    @Override
    public int getDefaultTargetId() {
        return 1939411968;
    }

    private void requestDiagData(int n, long l) {
        int n2 = this.getTargetId();
        block0 : switch (n) {
            case -1: {
                ServiceManager.adaptionApi.requestConfigManagerPersCoding(n2, -1048182528);
                ServiceManager.adaptionApi.requestConfigManagerPersAdaptation(n2, -1048182528);
                break;
            }
            case 28180695: {
                if (l != 1L) break;
                ServiceManager.adaptionApi.requestConfigManagerPersCoding(n2, -1048182528);
                break;
            }
            case 28442848: {
                switch ((int)l) {
                    case 100: {
                        ServiceManager.adaptionApi.requestConfigManagerPersAdaptation(n2, -1048182528);
                        break block0;
                    }
                    case 101: {
                        ServiceManager.adaptionApi.requestConfigManagerPersCarFuncAdap(n2, -1048182528);
                        break block0;
                    }
                    case 103: {
                        ServiceManager.adaptionApi.requestConfigManagerPersCarFuncListBap(n2, -1048182528);
                        break block0;
                    }
                    case 105: {
                        ServiceManager.adaptionApi.requestConfigManagerHmiFuncBlockTbl(n2, -1048182528);
                        break block0;
                    }
                }
                break;
            }
        }
    }

    @Override
    protected void powerOn() {
        if (!ASLStartupv7rFactory.getStartupv7rApi().isNonCustomerSwdlIsInProgress()) {
            if (this.isTraceEnabled()) {
                this.trace().append("[TargetASLPhoneFeatures] ").append("processPowerOn").log();
            }
            try {
                this.requestDiagData(-1, -1L);
            }
            catch (GenericEventException genericEventException) {
                this.error(genericEventException);
            }
        }
    }

    private void processDiagData(EventGeneric eventGeneric) {
        if (this.isTraceEnabled()) {
            this.trace().append("[TargetASLPhoneFeatures] ").append("processDiagData (enter)").log();
        }
        int n = eventGeneric.getInt(2);
        long l = eventGeneric.getLong(3);
        boolean bl = false;
        block0 : switch (n) {
            case 28442848: {
                switch ((int)l) {
                    case 100: {
                        Adaptation adaptation = (Adaptation)eventGeneric.getObject(1);
                        this.processDiagAdaptation(adaptation);
                        break block0;
                    }
                }
                break;
            }
            case 28180695: {
                if (l != 1L) break;
                bl = true;
                Coding coding = (Coding)eventGeneric.getObject(1);
                this.processDiagCoding(coding);
                break;
            }
        }
        if (!bl && this.isTraceEnabled()) {
            this.trace().append("[TargetASLPhoneFeatures] ").append("Unrequested Diag Data received (namespace/key): (").append(n).append("/").append(l).append(")").log();
        }
        if (this.isTraceEnabled()) {
            this.trace().append("[TargetASLPhoneFeatures] ").append("processDiagData (exit)").log();
        }
    }

    private void processDiagAdaptation(Adaptation adaptation) {
        if (adaptation != null) {
            this.isTableAdaptationAlreadyRead = true;
            this.isInternalPhoneAdaptationModuleActivated = adaptation.contains(166) ? adaptation.getValue(166) == 1 : false;
            if (this.isTraceEnabled()) {
                this.trace().append("[TargetASLPhoneFeatures] ").append("is NAD module activated in adaptation ").append(this.isInternalPhoneAdaptationModuleActivated).log();
            }
            this.writeIntPhoneFeatureFlag();
        } else {
            this.error().append("[TargetASLPhoneFeatures] ").append("processDiagAdaptation adaptation data could not be read").log();
        }
    }

    private void processDiagCoding(Coding coding) {
        if (this.isTraceEnabled()) {
            this.trace().append("[TargetASLPhoneFeatures] ").append("processDiagCoding").log();
        }
        if (coding != null) {
            this.isTableCodingAlreadyRead = true;
            boolean bl = this.getDiagnosisValue(coding, 38);
            boolean bl2 = this.getDiagnosisValue(coding, 39);
            this.isNADCodedAvailable = this.getDiagnosisValue(coding, 69);
            if (this.isTraceEnabled()) {
                this.trace().append("[TargetASLPhoneFeatures] ").append("isPhoneNadOn: ").append(this.isNADCodedAvailable).append(" isMicrophoneConnected(1) ").append(bl).append(" isMicrophoneConnected(2) ").append(bl2).log();
            }
            this.isInternalPhoneCodedAvailable = this.isNADCodedAvailable && (bl || bl2);
            this.writeIntPhoneFeatureFlag();
        } else {
            this.error().append("[TargetASLPhoneFeatures] ").append("processDiagCoding Coding Data could not be read").log();
        }
    }

    private void writeIntPhoneFeatureFlag() {
        if (this.isTableCodingAlreadyRead && this.isTableAdaptationAlreadyRead) {
            boolean bl;
            boolean bl2 = false;
            boolean bl3 = false;
            boolean bl4 = bl = this.isInternalPhoneCodedAvailable && this.isInternalPhoneAdaptationModuleActivated;
            bl3 = true;
            if (!this.isInternalPhoneFeatureFlagAlreadySet) {
                if (!bl3) {
                    this.isInternalPhoneFeatureFlagAlreadySet = true;
                }
                bl2 = true;
            } else if (this.internalPhoneFeatureFlagValue != bl4) {
                bl2 = true;
            }
            if (bl2) {
                this.internalPhoneFeatureFlagValue = bl4;
                ServiceManager.configManagerDiag.setFeatureFlagValue("ASL.Configuration.isIntPhoneAvailable", bl4);
                if (this.isTraceEnabled()) {
                    this.trace().append("TargetASLPhoneFeatures.writeIntPhoneFeatureFlag ").append(this.internalPhoneFeatureFlagValue).log();
                }
            }
        }
    }

    private boolean getDiagnosisValue(Access access, int n) {
        boolean bl = access.contains(n) ? access.getBoolean(n) : false;
        return bl;
    }

    static /* synthetic */ boolean access$102(TargetASLPhoneFeatures targetASLPhoneFeatures, boolean bl) {
        targetASLPhoneFeatures.isNadDetectedInSystem = bl;
        return targetASLPhoneFeatures.isNadDetectedInSystem;
    }

    static /* synthetic */ boolean access$202(TargetASLPhoneFeatures targetASLPhoneFeatures, boolean bl) {
        targetASLPhoneFeatures.isNadActivationStateAlreadyReceived = bl;
        return targetASLPhoneFeatures.isNadActivationStateAlreadyReceived;
    }

    static /* synthetic */ void access$300(TargetASLPhoneFeatures targetASLPhoneFeatures) {
        targetASLPhoneFeatures.writeIntPhoneFeatureFlag();
    }
}

