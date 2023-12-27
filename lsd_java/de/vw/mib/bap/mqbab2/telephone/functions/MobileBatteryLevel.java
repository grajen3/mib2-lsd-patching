/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbab2.telephone.functions;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.functions.BAPFunctionListener;
import de.vw.mib.bap.functions.Property;
import de.vw.mib.bap.functions.PropertyListener;
import de.vw.mib.bap.mqbab2.common.api.phone.PhoneService;
import de.vw.mib.bap.mqbab2.common.api.phone.PhoneServiceListener;
import de.vw.mib.bap.mqbab2.common.api.stages.BAPStage;
import de.vw.mib.bap.mqbab2.common.api.stages.BAPStageInitializer;
import de.vw.mib.bap.mqbab2.common.api.stages.Function;
import de.vw.mib.bap.mqbab2.generated.telephone.serializer.FSG_Setup_Status;
import de.vw.mib.bap.mqbab2.generated.telephone.serializer.MobileBatteryLevel_Status;
import de.vw.mib.bap.mqbab2.telephone.api.ASLTelephoneConstants;

public final class MobileBatteryLevel
extends Function
implements Property,
ASLTelephoneConstants,
PhoneServiceListener {
    private FSG_Setup_Status currentFsgSetupState = null;
    private static final int CHARGE_LEVEL_100;
    private static final int CHARGE_LEVEL_80;
    private static final int CHARGE_LEVEL_60;
    private static final int CHARGE_LEVEL_40;
    private static final int CHARGE_LEVEL_20;
    private static final int CHARGE_LEVEL_NO_DEVICE_CONNECTED;
    private static final int CHARGE_LEVEL_NOT_EXITS_FROM_CONNECTED_DEVICE;
    protected static final int[] PHONE_LISTENER_IDS;
    static /* synthetic */ Class class$de$vw$mib$bap$mqbab2$generated$telephone$serializer$MobileBatteryLevel_Status;

    @Override
    public BAPEntity init(BAPStageInitializer bAPStageInitializer) {
        this.getPhoneService().addPhoneServiceListener(this, PHONE_LISTENER_IDS);
        return this.computeMobileBatteryLevelStatus();
    }

    protected MobileBatteryLevel_Status dequeueBAPEntity() {
        return (MobileBatteryLevel_Status)this.context.dequeueBAPEntity(this, class$de$vw$mib$bap$mqbab2$generated$telephone$serializer$MobileBatteryLevel_Status == null ? (class$de$vw$mib$bap$mqbab2$generated$telephone$serializer$MobileBatteryLevel_Status = MobileBatteryLevel.class$("de.vw.mib.bap.mqbab2.generated.telephone.serializer.MobileBatteryLevel_Status")) : class$de$vw$mib$bap$mqbab2$generated$telephone$serializer$MobileBatteryLevel_Status);
    }

    @Override
    public void setFunctionData(BAPStage bAPStage, Object object) {
        switch (bAPStage.getFunctionId()) {
            case 14: {
                this.setCurrentFsgSetupState((FSG_Setup_Status)object);
                break;
            }
        }
    }

    @Override
    public int getFunctionId() {
        return 43;
    }

    private boolean isBatteryWarningLevelCritical() {
        return this.getPhoneService().getPhoneBatteryLevelWarning() == 1;
    }

    private int getCurrentBAPBatteryLevel() {
        int n;
        if (this.currentFsgSetupState == null || this.currentFsgSetupState.mobileConnectionType == 1 || this.currentFsgSetupState.mobileConnectionType == 0) {
            n = 255;
        } else {
            switch (this.getPhoneService().getPhoneBatteryLevel()) {
                case 1: {
                    n = 19;
                    break;
                }
                case 2: {
                    n = 39;
                    break;
                }
                case 3: {
                    n = 59;
                    break;
                }
                case 4: {
                    n = 79;
                    break;
                }
                case 5: {
                    n = 100;
                    break;
                }
                default: {
                    n = 254;
                }
            }
        }
        return n;
    }

    private MobileBatteryLevel_Status computeMobileBatteryLevelStatus() {
        MobileBatteryLevel_Status mobileBatteryLevel_Status = this.dequeueBAPEntity();
        mobileBatteryLevel_Status.chargeLevel_Mobile1 = this.getCurrentBAPBatteryLevel();
        mobileBatteryLevel_Status.warningLevel.mobile1ChargeLevelCritical = this.isBatteryWarningLevelCritical();
        mobileBatteryLevel_Status.chargeLevel_Mobile2 = 255;
        mobileBatteryLevel_Status.chargeLevel_Handset1 = 255;
        mobileBatteryLevel_Status.chargeLevel_Handset2 = 255;
        mobileBatteryLevel_Status.warningLevel.mobile2ChargeLevelCritical = false;
        mobileBatteryLevel_Status.warningLevel.handset1ChargeLevelCritical = false;
        mobileBatteryLevel_Status.warningLevel.handset2ChargeLevelCritical = false;
        return mobileBatteryLevel_Status;
    }

    private void sendMobileBatteryLevel(MobileBatteryLevel_Status mobileBatteryLevel_Status) {
        this.getDelegate().getPropertyListener(this).statusProperty(mobileBatteryLevel_Status, this);
    }

    @Override
    public void process(int n) {
        this.sendMobileBatteryLevel(this.computeMobileBatteryLevelStatus());
    }

    @Override
    public void getProperty(BAPEntity bAPEntity, PropertyListener propertyListener) {
        propertyListener.requestError(69, this);
    }

    @Override
    public void requestAcknowledge() {
    }

    @Override
    public void errorAcknowledge() {
    }

    @Override
    public void initialize(boolean bl) {
    }

    @Override
    public void uninitialize() {
        this.getPhoneService().removePhoneServiceListener(this, PHONE_LISTENER_IDS);
    }

    @Override
    public void indicationError(int n, BAPFunctionListener bAPFunctionListener) {
    }

    @Override
    public void setGetProperty(BAPEntity bAPEntity, PropertyListener propertyListener) {
        propertyListener.requestError(69, this);
    }

    @Override
    public void ackProperty(BAPEntity bAPEntity, PropertyListener propertyListener) {
        propertyListener.requestError(65, this);
    }

    protected void setCurrentFsgSetupState(FSG_Setup_Status fSG_Setup_Status) {
        this.currentFsgSetupState = fSG_Setup_Status;
        this.process(-1);
    }

    @Override
    public void processHMIEvent(int n) {
    }

    @Override
    public void updatePhoneData(PhoneService phoneService, int n) {
        this.process(-1);
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }

    static {
        PHONE_LISTENER_IDS = new int[]{-595389184, 1099};
    }
}

