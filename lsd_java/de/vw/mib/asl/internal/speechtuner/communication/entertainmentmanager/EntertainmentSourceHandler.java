/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechtuner.communication.entertainmentmanager;

import de.vw.mib.asl.framework.api.entertainmentmanager.DefaultEntertainmentManagerUpdates;
import de.vw.mib.asl.framework.api.entertainmentmanager.EntertainmentManagerService;
import de.vw.mib.asl.internal.speechtuner.utils.SpeechTunerLogger;
import de.vw.mib.asl.internal.speechtuner.utils.SpeechTunerServiceManager;
import de.vw.mib.asl.internal.speechtuner.utils.callbacks.BandChangeCallback;
import de.vw.mib.asl.internal.speechtuner.utils.callbacks.EntertainmentSourceCallback;

public class EntertainmentSourceHandler
extends DefaultEntertainmentManagerUpdates {
    private static final String LOGGER_PREFIX;
    protected SpeechTunerServiceManager serviceManager;
    protected SpeechTunerLogger logger;
    private EntertainmentManagerService entertainmentManager;
    private BandChangeCallback lastCaller;
    private EntertainmentSourceCallback lastSourceListener;
    private int currentRadioBand;
    private int currentEntertainmentSource;

    public EntertainmentSourceHandler(SpeechTunerServiceManager speechTunerServiceManager) {
        this.serviceManager = speechTunerServiceManager;
        this.logger = speechTunerServiceManager.createSpeechTunerLogger("[EntertainmentSourceHandler] ");
    }

    public void setEntertainmentManager(EntertainmentManagerService entertainmentManagerService) {
        this.entertainmentManager = entertainmentManagerService;
        entertainmentManagerService.addListener(this);
    }

    public boolean isReady() {
        return this.entertainmentManager != null;
    }

    @Override
    public void onUpdateBand(int n) {
        if (this.logger.isTraceEnabled()) {
            this.logger.trace(new StringBuffer().append("received new band: ").append(n).toString());
        }
        this.currentRadioBand = n;
        if (this.currentRadioBand == 0) {
            this.serviceManager.getModelServices().writeIntegerToDatapool(-668845568, 0);
            if (this.logger.isTraceEnabled()) {
                this.logger.trace("write new band AM to datapool");
            }
        } else if (this.currentRadioBand == 1) {
            this.serviceManager.getModelServices().writeIntegerToDatapool(-668845568, 1);
            if (this.logger.isTraceEnabled()) {
                this.logger.trace("write new band FM to datapool");
            }
        } else if (this.currentRadioBand == 2) {
            this.serviceManager.getModelServices().writeIntegerToDatapool(-668845568, 2);
            if (this.logger.isTraceEnabled()) {
                this.logger.trace("write new band DAB to datapool");
            }
        } else if (this.currentRadioBand == 3) {
            this.serviceManager.getModelServices().writeIntegerToDatapool(-668845568, 3);
            if (this.logger.isTraceEnabled()) {
                this.logger.trace("write new band Sirius to datapool");
            }
        } else {
            this.serviceManager.getModelServices().writeIntegerToDatapool(-668845568, 100);
            if (this.logger.isTraceEnabled()) {
                this.logger.trace("write unknown band to datapool");
            }
        }
        if (this.lastCaller != null) {
            if (this.logger.isTraceEnabled()) {
                this.logger.trace("inform last caller about band change response");
            }
            this.lastCaller.onBandChanged();
            this.lastCaller = null;
        }
    }

    @Override
    public void onUpdateEntertainmentSource(int n, int n2) {
        if (this.logger.isTraceEnabled()) {
            this.logger.trace(new StringBuffer().append("received new entertainment source:").append(n).toString());
        }
        this.currentEntertainmentSource = n;
        if (this.lastSourceListener != null) {
            this.lastSourceListener.onActivateRadio();
            this.lastSourceListener = null;
        }
    }

    public void changeToBand(int n, BandChangeCallback bandChangeCallback) {
        if (this.logger.isTraceEnabled()) {
            this.logger.trace(new StringBuffer().append("change to band: ").append(n).toString());
        }
        this.lastCaller = bandChangeCallback;
        this.entertainmentManager.requestBand(n);
    }

    public void changeToRadio() {
        if (this.logger.isTraceEnabled()) {
            this.logger.trace("change entertainment source to radio");
        }
        this.entertainmentManager.requestContext(1);
    }

    public boolean isRadioCurrentEntertainmentSource() {
        return this.currentEntertainmentSource == 1;
    }

    public int getCurrentBand() {
        return this.currentRadioBand;
    }

    public String getCurrentBandText() {
        if (this.currentRadioBand == 0) {
            return "AM";
        }
        if (this.currentRadioBand == 1) {
            return "FM";
        }
        if (this.currentRadioBand == 2) {
            return "DAB";
        }
        if (this.currentRadioBand == 3) {
            return "Sirius";
        }
        return "UNKNOWN";
    }

    public void registerForNextSourceChange(EntertainmentSourceCallback entertainmentSourceCallback) {
        this.lastSourceListener = entertainmentSourceCallback;
    }
}

