/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.radio.api.impl;

import de.vw.mib.asl.api.carplay.ASLCarplayServicesCallState;
import de.vw.mib.asl.api.carplay.ASLCarplayServicesListener;
import de.vw.mib.asl.api.carplay.ASLCarplayServicesTelephonyState;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.radio.RadioUtil;
import de.vw.mib.log4mib.Logger;

public class ASLRadioCarplayServicesListenerImpl
implements ASLCarplayServicesListener {
    private int callStateslength = 0;
    private boolean isCarPlayReady = false;
    private boolean isCarPlayActive = false;
    private Logger logger = ServiceManager.logger;

    @Override
    public void updateCarPlaTelefonyState(ASLCarplayServicesTelephonyState aSLCarplayServicesTelephonyState) {
    }

    @Override
    public void updateCarPlayActive(boolean bl) {
        this.isCarPlayActive = bl;
        if (this.logger.isTraceEnabled(128)) {
            this.logger.trace(128).append(RadioUtil.LOG_PREFIX_AMFM_ANNOUNCEMENT).append("ASLRadioCarplayServicesListenerImpl - updateCarPlayActive(): ").append(bl).log();
        }
        this.suppressTaPopUp();
    }

    @Override
    public void updateCarPlayCallStates(ASLCarplayServicesCallState[] aSLCarplayServicesCallStateArray) {
        if (aSLCarplayServicesCallStateArray != null) {
            this.callStateslength = aSLCarplayServicesCallStateArray.length;
            if (this.logger.isTraceEnabled(128)) {
                this.logger.trace(128).append(RadioUtil.LOG_PREFIX_AMFM_ANNOUNCEMENT).append("ASLRadioCarplayServicesListenerImpl - updateCarPlayCallStates(): ").append(this.callStateslength).log();
            }
            this.suppressTaPopUp();
        }
    }

    @Override
    public void updateCarPlayIsReady(boolean bl) {
        this.isCarPlayReady = bl;
        if (this.logger.isTraceEnabled(128)) {
            this.logger.trace(128).append(RadioUtil.LOG_PREFIX_AMFM_ANNOUNCEMENT).append("ASLRadioCarplayServicesListenerImpl - updateCarPlayIsReady(): ").append(bl).log();
        }
        this.suppressTaPopUp();
    }

    @Override
    public void updateCarPlayRouteGuidanceActive(boolean bl) {
    }

    private void suppressTaPopUp() {
        if (this.callStateslength > 0 && this.isCarPlayReady && this.isCarPlayActive) {
            if (this.logger.isTraceEnabled(128)) {
                this.logger.trace(128).append(RadioUtil.LOG_PREFIX_AMFM_ANNOUNCEMENT).append("ASLRadioCarplayServicesListenerImpl - suppressTAPopUp(TRUE) ").log();
            }
            ServiceManager.aslPropertyManager.valueChangedBoolean(1187390464, true);
        } else {
            if (this.logger.isTraceEnabled(128)) {
                this.logger.trace(128).append(RadioUtil.LOG_PREFIX_AMFM_ANNOUNCEMENT).append("ASLRadioCarplayServicesListenerImpl - suppressTAPopUp(FALSE) ").log();
            }
            ServiceManager.aslPropertyManager.valueChangedBoolean(1187390464, false);
        }
    }
}

