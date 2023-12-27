/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets.speller.hwr;

import de.vw.mib.log4mib.LogMessage;
import de.vw.mib.log4mib.Logger;
import de.vw.mib.speller.SpellerController;
import de.vw.mib.speller.hwr.HWRConfiguration;
import de.vw.mib.speller.hwr.HWREngine;
import de.vw.mib.widgets.controller.AsiaSpellerController;
import de.vw.mib.widgets.internal.ServiceManager;
import de.vw.mib.widgets.models.AsiaSpellerModel;
import de.vw.mib.widgets.models.TouchAreaModel;
import de.vw.mib.widgets.speller.hwr.HWRWrapper$HWREngineDeInitState;
import de.vw.mib.widgets.speller.hwr.HWRWrapper$HWREngineInitState;
import de.vw.mib.widgets.speller.hwr.HWRWrapper$HWREngineStartState;
import de.vw.mib.widgets.speller.hwr.HWRWrapper$HWREngineState;
import de.vw.mib.widgets.speller.hwr.HWRWrapper$HWREngineSuspendState;
import de.vw.mib.widgets.speller.hwr.HWRWrapper$HWRWrapperHolder;

public class HWRWrapper {
    private static final int LOG_CLASSIFIER;
    private static final String LOG_PREFIX;
    private static final Logger LOGGER;
    private static final int STATE_DEINIT;
    private static final int STATE_INIT;
    private static final int STATE_START;
    private static final int STATE_SUSPEND;
    private static final int NUMBER_OF_STATES;
    protected HWRConfiguration hwrConfiguration;
    protected HWREngine hwrEngine;
    protected HWRWrapper$HWREngineState hwrEngineState;
    protected HWRWrapper$HWREngineState[] hwrEngineStates;
    protected boolean isReady = false;
    protected boolean isAlreadyInUse = false;
    protected AsiaSpellerModel speller;
    protected AsiaSpellerController spellerController;
    protected SpellerController spellerService;

    public static HWRWrapper getHWR(AsiaSpellerModel asiaSpellerModel) {
        return HWRWrapper$HWRWrapperHolder.HWR.setSpellerService(ServiceManager.spellerController).setSpeller(asiaSpellerModel);
    }

    protected HWRWrapper() {
        this.setState(this.initHwrEngineStates());
    }

    private String getHwrModeText(int n) {
        switch (n) {
            case 0: {
                return "OFF";
            }
            case 12: {
                return "FREETEXT";
            }
            case 23: {
                return "LETTER_FIRST";
            }
            case 19: {
                return "NUMBER_FIRST";
            }
            case 22: {
                return "NUMBER_FIRST_HOUSE_NUM";
            }
            case 20: {
                return "NUMBER_FIRST_TEL";
            }
            case 21: {
                return "NUMBER_FIRST_ZIP";
            }
        }
        return "UNKNOWN";
    }

    protected HWRWrapper$HWREngineState getState(int n) {
        return this.hwrEngineStates[n];
    }

    protected HWRWrapper setSpeller(AsiaSpellerModel asiaSpellerModel) {
        if (this.isAlreadyInUse && this.speller != asiaSpellerModel) {
            if (this.isTraceEnabled()) {
                this.trace().append("Already used by '").append(this.speller).append("'").log();
            }
            return HWRWrapper$HWRWrapperHolder.HWR_DUMMY;
        }
        this.speller = asiaSpellerModel;
        this.spellerController = asiaSpellerModel != null ? (AsiaSpellerController)asiaSpellerModel.getController() : null;
        return this;
    }

    protected HWRWrapper setSpellerService(SpellerController spellerController) {
        this.spellerService = spellerController;
        return this;
    }

    protected void setState(HWRWrapper$HWREngineState hWRWrapper$HWREngineState) {
        if (this.hwrEngineState != null) {
            this.hwrEngineState.onLeave();
        }
        this.hwrEngineState = hWRWrapper$HWREngineState;
        if (this.hwrEngineState != null) {
            if (this.isTraceEnabled()) {
                this.trace().append("state=").append(super.getClass().getName()).log();
            }
            this.hwrEngineState.onEnter();
        }
    }

    protected void clear() {
        if (this.hwrEngine != null) {
            if (this.isTraceEnabled()) {
                this.trace().append("clear recognizer").log();
            }
            this.hwrEngine.clear();
        } else {
            this.warn().append("Unable to clear the recognizer.").log();
        }
        if (this.speller != null) {
            if (this.isTraceEnabled()) {
                this.trace().append("clear hwr area").log();
            }
            this.speller.clearHwrArea();
        } else {
            this.warn().append("Unable to clear the spellers' hwr area").log();
        }
    }

    protected void clearAndRelease() {
        this.clear();
        this.release();
    }

    protected void configure(int n) {
        this.configure(n, this.speller != null ? this.speller.get_hwrAreaRef() : null);
    }

    protected void configure(int n, TouchAreaModel touchAreaModel) {
        HWRConfiguration hWRConfiguration = this.hwrConfiguration = this.hwrEngine != null && this.hwrEngine.isConfigured() ? this.hwrEngine.getConfiguration() : new HWRConfiguration();
        if (this.hwrConfiguration != null) {
            this.hwrConfiguration.setMode(n);
            if (touchAreaModel != null) {
                this.hwrConfiguration.setTouchAreaX(touchAreaModel.getAbsX());
                this.hwrConfiguration.setTouchAreaY(touchAreaModel.getAbsY());
                this.hwrConfiguration.setTouchAreaW(touchAreaModel.get_width());
                this.hwrConfiguration.setTouchAreaH(touchAreaModel.get_height());
            }
            if (this.hwrEngine != null) {
                if (this.isTraceEnabled()) {
                    this.trace().append("Configure hwr engine: mode=").append(this.hwrConfiguration.getMode()).append(" (").append(this.getHwrModeText(this.hwrConfiguration.getMode())).append(")").append(" touchAreaX=").append(this.hwrConfiguration.getTouchAreaX()).append(" touchAreaY=").append(this.hwrConfiguration.getTouchAreaY()).append(" touchAreaW=").append(this.hwrConfiguration.getTouchAreaW()).append(" touchAreaH=").append(this.hwrConfiguration.getTouchAreaH()).log();
                }
                this.hwrEngine.setConfiguration(this.hwrConfiguration);
                this.hwrEngine.sendConfiguration();
            } else {
                this.warn().append("Unable to configure hwr engine!").log();
            }
        } else {
            this.warn().append("No hwr configuration present!").log();
        }
    }

    public HWRWrapper deInitHwrEngine() {
        this.hwrEngineState.deInit();
        return this;
    }

    public HWRWrapper initHwrEngine() {
        this.hwrEngineState.init();
        return this;
    }

    protected HWRWrapper$HWREngineState initHwrEngineStates() {
        this.hwrEngineStates = new HWRWrapper$HWREngineState[4];
        this.hwrEngineStates[0] = new HWRWrapper$HWREngineDeInitState(this);
        this.hwrEngineStates[1] = new HWRWrapper$HWREngineInitState(this);
        this.hwrEngineStates[2] = new HWRWrapper$HWREngineStartState(this);
        this.hwrEngineStates[3] = new HWRWrapper$HWREngineSuspendState(this);
        return this.hwrEngineStates[0];
    }

    protected void release() {
        if (this.hwrEngine != null) {
            if (this.isTraceEnabled()) {
                this.trace().append("release hwr engine").log();
            }
            this.hwrEngine.release();
            this.hwrEngine = null;
        } else {
            this.warn().append("Unable to release hwr engine.").log();
        }
        this.hwrConfiguration = null;
    }

    public HWRWrapper restartHwrEngine() {
        this.hwrEngineState.restart();
        return this;
    }

    public HWRWrapper resumeHwrEngine() {
        this.hwrEngineState.resume();
        return this;
    }

    public HWRWrapper startHwrEngine() {
        this.hwrEngineState.start();
        return this;
    }

    public HWRWrapper stopHwrEngine() {
        this.hwrEngineState.stop();
        return this;
    }

    public HWRWrapper suspendHwrEngine() {
        this.hwrEngineState.suspend();
        return this;
    }

    protected boolean isTraceEnabled() {
        return LOGGER.isTraceEnabled(64);
    }

    protected LogMessage trace() {
        return LOGGER.trace(64).append("[HWRWrapper]: ");
    }

    protected LogMessage warn() {
        return LOGGER.warn(64).append("[HWRWrapper]: ");
    }

    static {
        LOGGER = ServiceManager.loggerFactory.getLogger(2048);
    }
}

