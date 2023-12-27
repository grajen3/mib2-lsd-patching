/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.car.fpk;

import de.vw.mib.asl.ASLPropertyManager;
import de.vw.mib.asl.framework.api.framework.ASLFrameworkFactory;
import de.vw.mib.asl.internal.car.fpk.api.CarFPKSetupAPI;
import de.vw.mib.asl.internal.car.fpk.api.impl.CarFPKSetupAPIImpl;
import de.vw.mib.asl.internal.car.fpk.commons.AppLogger;
import de.vw.mib.asl.internal.car.fpk.functions.DCViewOptionListenerImpl;
import de.vw.mib.asl.internal.car.fpk.usecases.ServiceStateListener;
import de.vw.mib.asl.internal.car.fpk.usecases.ServiceStateListener$ServiceStateResult;
import de.vw.mib.genericevents.AbstractTarget;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.GenericEvents;

public class ASLCarFPKSetupTarget
extends AbstractTarget
implements ServiceStateListener {
    CarFPKSetupAPI carFPKSetupAPI;
    DCViewOptionListenerImpl viewOptionsDevice;

    public ASLCarFPKSetupTarget(GenericEvents genericEvents, String string) {
        super(genericEvents, string);
    }

    @Override
    public int getSubClassifier() {
        return 1;
    }

    @Override
    public int getDefaultTargetId() {
        return -1689316864;
    }

    @Override
    public void gotEvent(EventGeneric eventGeneric) {
        if (this.isTraceEnabled()) {
            this.trace().append("Event for CarFPKSetup: ").append(eventGeneric.getReceiverEventId()).log();
        }
        if (106 == eventGeneric.getReceiverEventId()) {
            this.onPowerOn();
        }
    }

    private void onPowerOn() {
        AppLogger.info(this, ".onPowerOn()");
        try {
            this.carFPKSetupAPI = new CarFPKSetupAPIImpl();
            this.carFPKSetupAPI.getDisplaySetupService().subscribeServiceState(this);
        }
        catch (Exception exception) {
            AppLogger.error(this, new StringBuffer().append(".onPowerOn(), an error occured: ").append(exception.getMessage()).toString());
        }
    }

    @Override
    public void updateServiceState(ServiceStateListener$ServiceStateResult serviceStateListener$ServiceStateResult) {
        boolean bl = serviceStateListener$ServiceStateResult.isServiceAvailable();
        AppLogger.info(this, new StringBuffer().append(".updateServiceState ").append(bl).toString());
        ASLPropertyManager aSLPropertyManager = ASLFrameworkFactory.getASLFrameworkAPI().getServices().getASLPropertyManager();
        aSLPropertyManager.valueChangedBoolean(10864, bl);
        this.getViewOptionsListener().updateServiceState(serviceStateListener$ServiceStateResult);
    }

    private ServiceStateListener getViewOptionsListener() {
        if (null == this.viewOptionsDevice) {
            this.viewOptionsDevice = new DCViewOptionListenerImpl();
        }
        return this.viewOptionsDevice;
    }
}

