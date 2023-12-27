/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.car.fpk.usecases.settings.service;

import de.vw.mib.asl.api.system.ASLSystemFactory;
import de.vw.mib.asl.api.system.factoryreset.AbstractFactoryResetParticipant;
import de.vw.mib.asl.api.system.factoryreset.FactoryResetComponents;
import de.vw.mib.asl.api.system.factoryreset.FactoryResetService;
import de.vw.mib.asl.internal.car.fpk.ServiceBase;
import de.vw.mib.asl.internal.car.fpk.api.CarFPKSetupAPI;
import de.vw.mib.asl.internal.car.fpk.commons.AppLogger;
import de.vw.mib.asl.internal.car.fpk.usecases.settings.service.FactorySettings;
import de.vw.mib.asl.internal.car.fpk.usecases.settings.service.FactorySettingsImpl$1;
import de.vw.mib.genericevents.EventGeneric;
import org.dsi.ifc.carkombi.DCViewOptions;

public class FactorySettingsImpl
extends ServiceBase
implements FactorySettings {
    private static final int[] ASL_EVENT_IDS = new int[]{-502595520};
    AbstractFactoryResetParticipant participant = new FactorySettingsImpl$1(this);
    private boolean oldState = false;

    public FactorySettingsImpl(CarFPKSetupAPI carFPKSetupAPI) {
        super(carFPKSetupAPI);
    }

    @Override
    public void gotEvent(EventGeneric eventGeneric) {
        int n = eventGeneric.getReceiverEventId();
        switch (n) {
            case 1073744866: {
                int n2 = eventGeneric.getInt(0);
                if (n2 != 7 && n2 != 0) break;
                this.reset();
                break;
            }
            default: {
                super.gotEvent(eventGeneric);
            }
        }
    }

    @Override
    protected void updateServiceState(DCViewOptions dCViewOptions) {
        boolean bl = this.isServiceAvailable(dCViewOptions.getSetFactoryDefault());
        if (this.oldState != bl) {
            if (bl) {
                this.listenOnModelEvents(ASL_EVENT_IDS);
                this.listenOnDSIResponses(this);
                this.registerFactoryResetParticipant();
            } else {
                this.unlistenOnModelEvents(ASL_EVENT_IDS);
                this.unlistenOnDSIResponses(this);
                this.unregisterFactoryResetParticipant();
            }
            super.updateServiceState(dCViewOptions);
            this.oldState = bl;
        }
    }

    private void registerFactoryResetParticipant() {
        try {
            FactoryResetService factoryResetService = ASLSystemFactory.getSystemApi().getFactoryResetService();
            factoryResetService.addParticipant(this.participant, FactoryResetComponents.CAR);
        }
        catch (IllegalArgumentException illegalArgumentException) {
            AppLogger.warn(this, new StringBuffer().append(".registerFactoryResetParticipant(): ").append(illegalArgumentException.getMessage()).toString());
        }
    }

    private void unregisterFactoryResetParticipant() {
        try {
            FactoryResetService factoryResetService = ASLSystemFactory.getSystemApi().getFactoryResetService();
            factoryResetService.removeParticipant(this.participant, FactoryResetComponents.CAR);
        }
        catch (Exception exception) {
            AppLogger.warn(this, new StringBuffer().append(".unregisterFactoryResetParticipant(): ").append(exception.getMessage()).toString());
        }
    }

    @Override
    public void reset() {
        AppLogger.trace(this, ".reset()");
        this.dsiCarKombi.setDCSetFactoryDefault();
    }

    public void dsiCarKombiAcknowledgeDCSetFactoryDefault(boolean bl) {
        AppLogger.trace(this, new StringBuffer().append(".dsiCarKombiAcknowledgeDCSetFactoryDefault( success = ").append(bl).append(" )").toString());
    }
}

