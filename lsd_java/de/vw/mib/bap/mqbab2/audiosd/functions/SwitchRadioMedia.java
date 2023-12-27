/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbab2.audiosd.functions;

import de.vw.mib.bap.array.timer.Timer;
import de.vw.mib.bap.array.timer.TimerNotifier;
import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.functions.BAPFunctionListener;
import de.vw.mib.bap.functions.Method;
import de.vw.mib.bap.functions.MethodListener;
import de.vw.mib.bap.mqbab2.audiosd.api.ASLAudioSDConstants;
import de.vw.mib.bap.mqbab2.common.api.stages.BAPStage;
import de.vw.mib.bap.mqbab2.common.api.stages.BAPStageInitializer;
import de.vw.mib.bap.mqbab2.common.api.stages.Function;
import de.vw.mib.bap.mqbab2.generated.audiosd.serializer.SwitchRadioMedia_Result;
import de.vw.mib.bap.mqbab2.generated.audiosd.serializer.SwitchRadioMedia_StartResult;

public final class SwitchRadioMedia
extends Function
implements TimerNotifier,
Method,
ASLAudioSDConstants {
    private boolean _switchRadioMediaRunning = false;
    private int _expectedAudioComponent = 0;
    private Timer timer;
    private static final int TIMER_UPDATE_TIME;
    private static final int TIMER_ACTION_TIME_OUT_ACTION_FAILED;
    static /* synthetic */ Class class$de$vw$mib$bap$mqbab2$generated$audiosd$serializer$SwitchRadioMedia_Result;

    @Override
    public BAPEntity init(BAPStageInitializer bAPStageInitializer) {
        this.timer = this.getTimerService().createTimer(this, 10000);
        return null;
    }

    protected SwitchRadioMedia_Result dequeueBAPEntity() {
        return (SwitchRadioMedia_Result)this.context.dequeueBAPEntity(this, class$de$vw$mib$bap$mqbab2$generated$audiosd$serializer$SwitchRadioMedia_Result == null ? (class$de$vw$mib$bap$mqbab2$generated$audiosd$serializer$SwitchRadioMedia_Result = SwitchRadioMedia.class$("de.vw.mib.bap.mqbab2.generated.audiosd.serializer.SwitchRadioMedia_Result")) : class$de$vw$mib$bap$mqbab2$generated$audiosd$serializer$SwitchRadioMedia_Result);
    }

    @Override
    public void setFunctionData(BAPStage bAPStage, Object object) {
        switch (bAPStage.getFunctionId()) {
            case 16: {
                this.setReportedSourceListReference((Integer)object);
                break;
            }
        }
    }

    @Override
    public int getFunctionId() {
        return 45;
    }

    @Override
    public void initialize(boolean bl) {
        this.setSwitchRadioMediaRunning(false);
    }

    @Override
    public void uninitialize() {
        this.timer.stop();
    }

    @Override
    public void process(int n) {
    }

    @Override
    public void startResult(BAPEntity bAPEntity, MethodListener methodListener) {
        if (!this.isSwitchRadioMediaRunning()) {
            SwitchRadioMedia_StartResult switchRadioMedia_StartResult = (SwitchRadioMedia_StartResult)bAPEntity;
            if (SwitchRadioMedia.checkSwitchRadioMediaStartResultParameters(switchRadioMedia_StartResult)) {
                if (this.isBapSourceAlreadyActive(switchRadioMedia_StartResult.source)) {
                    this.sendBapSwitchRadioMediaResult(0, methodListener);
                } else {
                    this.activateBapSource(switchRadioMedia_StartResult.source);
                    this.setSwitchRadioMediaRunning(true);
                    this.timer.retrigger(new Integer(0));
                    this.setExpectedAudioComponent(this.getExpectedAudioComponent(switchRadioMedia_StartResult.source));
                }
            } else {
                methodListener.requestError(65, this);
            }
        } else {
            this.sendBapSwitchRadioMediaResult(1, methodListener);
        }
    }

    @Override
    public void abortResult(BAPEntity bAPEntity, MethodListener methodListener) {
        if (this.isSwitchRadioMediaRunning()) {
            this.setSwitchRadioMediaRunning(false);
            this.sendBapSwitchRadioMediaResult(2, methodListener);
        } else {
            methodListener.requestError(80, this);
        }
    }

    @Override
    public void indicationError(int n, BAPFunctionListener bAPFunctionListener) {
    }

    @Override
    public void requestAcknowledge() {
    }

    @Override
    public void errorAcknowledge() {
    }

    protected void setReportedSourceListReference(Integer n) {
        if (this.isSwitchRadioMediaRunning()) {
            int n2 = this.getSoundService().getCurrentAudioComponent() == this.getExpectedAudioComponent() ? 0 : 1;
            this.sendBapSwitchRadioMediaResult(n2, null);
            this.setSwitchRadioMediaRunning(false);
        }
    }

    private void sendBapSwitchRadioMediaResult(int n, MethodListener methodListener) {
        SwitchRadioMedia_Result switchRadioMedia_Result = this.dequeueBAPEntity();
        switchRadioMedia_Result.switchRadioMediaResult = n;
        if (methodListener != null) {
            methodListener.result(switchRadioMedia_Result, this);
        } else {
            this.getDelegate().getMethodListener(this).result(switchRadioMedia_Result, this);
        }
    }

    private static boolean checkSwitchRadioMediaStartResultParameters(SwitchRadioMedia_StartResult switchRadioMedia_StartResult) {
        boolean bl;
        switch (switchRadioMedia_StartResult.source) {
            case 0: 
            case 1: 
            case 2: 
            case 3: {
                bl = true;
                break;
            }
            default: {
                bl = false;
            }
        }
        return bl;
    }

    private boolean isBapSourceAlreadyActive(int n) {
        boolean bl;
        int n2 = this.getSoundService().getCurrentAudioComponent();
        switch (n) {
            case 1: {
                bl = n2 == 2;
                break;
            }
            case 0: 
            case 2: 
            case 3: {
                bl = n2 == 1;
                break;
            }
            default: {
                bl = false;
            }
        }
        return bl;
    }

    private void activateBapSource(int n) {
        switch (n) {
            case 1: {
                this.getSoundService().activateRadioSource();
                break;
            }
            case 0: {
                this.getSoundService().activateMediaSource();
                break;
            }
        }
    }

    private int getExpectedAudioComponent(int n) {
        int n2;
        switch (n) {
            case 1: {
                n2 = 1;
                break;
            }
            case 0: {
                n2 = 2;
                break;
            }
            default: {
                n2 = 1;
            }
        }
        return n2;
    }

    @Override
    public void timerFired(Timer timer) {
        if (this.isSwitchRadioMediaRunning()) {
            this.sendBapSwitchRadioMediaResult(1, null);
            this.setSwitchRadioMediaRunning(false);
        }
    }

    private boolean isSwitchRadioMediaRunning() {
        return this._switchRadioMediaRunning;
    }

    private void setSwitchRadioMediaRunning(boolean bl) {
        this._switchRadioMediaRunning = bl;
    }

    private int getExpectedAudioComponent() {
        return this._expectedAudioComponent;
    }

    private void setExpectedAudioComponent(int n) {
        this._expectedAudioComponent = n;
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

