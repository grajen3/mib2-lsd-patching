/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbab2.audiosd.functions;

import de.vw.mib.bap.array.timer.Timer;
import de.vw.mib.bap.array.timer.TimerNotifier;
import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.mqbab2.audiosd.functions.ReceptionList;
import de.vw.mib.bap.mqbab2.common.api.radio.RadioService;
import de.vw.mib.bap.mqbab2.common.api.radio.RadioServiceListener;
import de.vw.mib.bap.mqbab2.common.api.stages.BAPStage;
import de.vw.mib.bap.mqbab2.common.api.stages.BAPStageContext;
import de.vw.mib.bap.mqbab2.common.api.stages.BAPStageInitializer;
import de.vw.mib.bap.mqbab2.common.api.stages.Function;

class ReceptionList$ReceptionListWithCurrentStation
extends Function
implements TimerNotifier,
RadioServiceListener {
    private static final int TIMER_ACTION_DO_NOTHING;
    private static final int TIMER_ACTION_STATION_ID_BECOMES_INVALID;
    private static final int TIMER_ACTION_STATION_ID_BECOMES_VALID;
    private static final int TIMER_ACTION_FREQUENCY_CHANGE;
    private static final int TIMER_INSERT_DELETE_TIME;
    private static final int TIMER_CHANGE_TIME;
    private Timer insertDeleteTimer = null;
    private Timer changeTimer = null;
    private int lastRadioFrequency = 0;
    private boolean stationIDvalid = false;
    private final /* synthetic */ ReceptionList this$0;

    public ReceptionList$ReceptionListWithCurrentStation(ReceptionList receptionList) {
        this.this$0 = receptionList;
    }

    @Override
    public BAPEntity init(BAPStageInitializer bAPStageInitializer) {
        this.getRadioService().addRadioServiceListener(this, new int[]{1324, 1456, 1454, 2486, 1270});
        this.insertDeleteTimer = this.getTimerService().createTimer(this, 1000);
        this.changeTimer = this.getTimerService().createTimer(this, 500);
        return null;
    }

    @Override
    public int getFunctionId() {
        return 23;
    }

    @Override
    public final void setDelegate(BAPStageContext bAPStageContext) {
    }

    @Override
    public void process(int n) {
        if (this.isCorrectRadioBand()) {
            this.stationIDorFrequencyUpdate();
        }
    }

    @Override
    public void setFunctionData(BAPStage bAPStage, Object object) {
    }

    private boolean isCorrectRadioBand() {
        int n = this.getRadioService().getCurrentStationBand();
        return n == 0 || n == 1;
    }

    private boolean isStationIDvalid() {
        return this.stationIDvalid;
    }

    private void setStationIDValid(boolean bl) {
        this.stationIDvalid = bl;
    }

    private void setLastRadioFrequency(int n) {
        this.lastRadioFrequency = n;
    }

    private int getLastRadioFrequency() {
        return this.lastRadioFrequency;
    }

    protected boolean stationIDInReceptionList() {
        return this.stationIDInReceptionList(this.getRadioService().getCurrentStationIndices().getCurrentStationIndicesStationListActiveID());
    }

    private boolean stationIDInReceptionList(long l) {
        int n;
        boolean bl = this.this$0.fullReceptionList != null && l != -1L ? ((n = this.this$0.fullReceptionList.getBapPosID(l)) != 0 && n != 1 ? this.this$0.fullReceptionList.getIndexOfBapPosId(n) != -1 : false) : false;
        return bl;
    }

    private int getCurrentRadioFrequency() {
        int n;
        RadioService radioService = this.getRadioService();
        switch (radioService.getCurrentStationBand()) {
            case 0: {
                n = radioService.getCurrentAMStationInfo().getCurrentAMStationInfoFrequency();
                break;
            }
            case 1: {
                n = radioService.getCurrentFMStationInfo().getCurrentFMStationInfoFrequency();
                break;
            }
            default: {
                n = 0;
            }
        }
        return n;
    }

    private void checkStationIDState(boolean bl) {
        if (bl) {
            if (this.isStationIDvalid()) {
                if (!this.isStationTheSame()) {
                    this.currentStationChanged();
                }
            } else {
                this.stationIDbecomesValid();
            }
        } else if (this.isStationIDvalid()) {
            this.stationIDbecomesInvalid();
        } else if (!this.isStationTheSame()) {
            this.currentStationChanged();
        }
    }

    private boolean isStationTheSame() {
        return this.getCurrentRadioFrequency() == this.getLastRadioFrequency();
    }

    private void stationIDbecomesInvalid() {
        if (!this.insertDeleteTimer.isRunning()) {
            this.insertDeleteTimer.retrigger(new Integer(1));
        }
    }

    private void stationIDbecomesValid() {
        if (!this.insertDeleteTimer.isRunning()) {
            this.insertDeleteTimer.retrigger(new Integer(2));
        }
    }

    private void currentStationChanged() {
        this.changeTimer.retrigger(new Integer(3));
    }

    @Override
    public void timerFired(Timer timer) {
        int n = (Integer)timer.getUserInfo();
        switch (n) {
            case 1: 
            case 2: {
                this.stationIDbecomesValidOrInvalidTimeout();
                break;
            }
            case 3: {
                this.stationChangedTimeout();
                break;
            }
        }
    }

    private void stationIDbecomesValidOrInvalidTimeout() {
        if (this.isCorrectRadioBand()) {
            this.this$0.setAddActiveStationToReceptionList(!this.isStationIDvalid());
        }
    }

    private void stationChangedTimeout() {
        if (!this.isStationIDvalid() && this.isCorrectRadioBand() && !this.isStationTheSame()) {
            this.this$0.recomputeTheReceptionList();
        }
        this.setLastRadioFrequency(this.getCurrentRadioFrequency());
    }

    public void stationIDorFrequencyUpdate() {
        boolean bl = this.stationIDInReceptionList();
        this.checkStationIDState(bl);
        this.setStationIDValid(bl);
    }

    @Override
    public void initialize(boolean bl) {
    }

    @Override
    public void uninitialize() {
        this.insertDeleteTimer.stop();
        this.changeTimer.stop();
    }

    @Override
    public void processHMIEvent(int n) {
    }

    @Override
    public void updateRadioData(RadioService radioService, int n) {
        this.process(-1);
    }
}

