/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.car.thinkblue.calc;

import de.vw.mib.asl.api.car.thinkblue.TBTServiceListener;
import de.vw.mib.asl.framework.api.diagnosis.config.EcoHmi;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.car.framework.services.ServiceFactory;
import de.vw.mib.asl.internal.car.thinkblue.ASLTargetThinkBlue;
import de.vw.mib.asl.internal.car.thinkblue.calc.table.ConditionsContainer;
import de.vw.mib.asl.internal.car.thinkblue.calc.table.DrivingTable;
import de.vw.mib.collections.ints.IntArrayList;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.GenericEventException;

public class BlueCalculator {
    private static final double SPEED_FACTOR_MPH;
    private static final double SPEED_FACTOR_KMPH;
    private final int speedlimit1;
    private int speedlimit2 = 83;
    private int speedlimit3 = 123;
    private int speedlimit4 = 143;
    private int speed_rating_1 = 100;
    private int speed_rating_2 = 120;
    private int speed_rating_3 = 150;
    private int speed_rating_4 = 200;
    private int foresight_speedlimit1 = 83;
    private int foresight_speedlimit2 = 123;
    private int foresight_speedlimit3 = 143;
    private int foresight_acc_limit_neg_11 = -130;
    private int foresight_acc_limit_neg_12 = -200;
    private int foresight_acc_limit_neg_13 = -240;
    private int foresight_acc_limit_neg_21 = -120;
    private int foresight_acc_limit_neg_22 = -160;
    private int foresight_acc_limit_neg_23 = -180;
    private int foresight_acc_limit_neg_31 = -40;
    private int foresight_acc_limit_neg_32 = -60;
    private int foresight_acc_limit_neg_33 = -80;
    private int foresight_acc_limit_pos_11 = 170;
    private int foresight_acc_limit_pos_12 = 200;
    private int foresight_acc_limit_pos_13 = 210;
    private int foresight_acc_limit_pos_21 = 50;
    private int foresight_acc_limit_pos_22 = 70;
    private int foresight_acc_limit_pos_23 = 90;
    private int foresight_acc_limit_pos_31 = 20;
    private int foresight_acc_limit_pos_32 = 40;
    private int foresight_acc_limit_pos_33 = 60;
    private int foresight_rating_pos_1 = 100;
    private int foresight_rating_pos_2 = 50;
    private int foresight_rating_pos_3 = 30;
    private int foresight_rating_pos_4 = 10;
    private int foresight_rating_neg_1 = 100;
    private int foresight_rating_neg_2 = 50;
    private int foresight_rating_neg_3 = 30;
    private int foresight_rating_neg_4 = 10;
    private int loadChangeLimit = 3;
    private static final int LOADCHANGE_NOT_DETECTED;
    private static final int LOADCHANGE_SIGN_POS;
    private static final int LOADCHANGE_SIGN_NEG;
    private static final int DRV_HINT_GEAR;
    private static final int DRV_HINT_FORESIGHT;
    private static final int DRV_HINT_SPEED;
    private static final int DRV_HINT_ECO;
    private static final int DRV_HINT_NONE;
    private static final int DIAG_CONVERSION_FACTOR_1;
    private static final int DIAG_CONVERSION_FACTOR_2;
    private static final int DIAG_CONVERSION_FACTOR_3;
    private int loadChangeSign = 0;
    private int LOADCHANGE_DIVISION_VALUE = 4;
    private int posLimit = 150;
    private int negLimit = -150;
    private int ecoSpeedLimit = 80;
    DrivingTable table;
    private int paramForesight;
    private int paramSpeed = 1;
    private int bpTotal;
    private boolean speedHigh;
    private int loadChange;
    private int currentStateIdx;
    private long oldTime = -1L;
    private double oldSpeed;
    private int bpPenaltyCounter;
    private int bpCounter;
    private final IntArrayList accMovingAverage = new IntArrayList(5);
    private int acc;
    private boolean speedHintSuppressed;
    private boolean updateReceived;
    private int bpAvg;
    private int bpLastCalcScore;
    private final int[] drivingHintsEnum = new int[]{0, 1, 2, 3, 4};
    private int displayedHint = 4;
    private boolean isTemporalConditionActive;
    private boolean lockTimerActive;
    private boolean lowHintsTimerActive;
    private boolean lowPrioHintAllowed = true;
    private boolean newLoadChangeInterval = true;
    private boolean isLoadChangeHintAllowed = true;
    private boolean hintIconTimeout;
    private boolean dumpHMI;
    private int currentGear;
    private int recommendedGear;
    private int maxAcceleration = 30;
    private int currentAcceleration;
    private int hintDuration;
    private int drivingBehaviorMode;
    static /* synthetic */ Class class$de$vw$mib$asl$api$car$thinkblue$TBTServiceListener;

    public BlueCalculator() {
        this.speedlimit1 = 0;
        ServiceManager.aslPropertyManager.valueChangedInteger(10431, this.maxAcceleration);
        this.getTBTServiceListener().updateMaxAcceleration(this.maxAcceleration);
        this.hintDuration = 3000;
        ServiceManager.aslPropertyManager.valueChangedInteger(10457, this.hintDuration);
        this.getTBTServiceListener().updateDisplayDurationHintIcon(this.hintDuration);
        ServiceManager.aslPropertyManager.valueChangedInteger(10422, 4);
        this.drivingBehaviorMode = 4;
        this.getTBTServiceListener().updateDrivingBehaviorMode(this.drivingBehaviorMode);
    }

    public void reset() {
        this.bpTotal = 0;
        this.bpAvg = 0;
        this.bpLastCalcScore = 0;
        this.bpCounter = 0;
        this.updateReceived = false;
        this.currentAcceleration = 0;
        ServiceManager.aslPropertyManager.valueChangedInteger(10432, this.currentAcceleration);
        this.getTBTServiceListener().updateCurrentAcceleration(this.currentAcceleration);
        this.displayedHint = 4;
        ServiceManager.aslPropertyManager.valueChangedInteger(10422, 4);
        this.drivingBehaviorMode = 4;
        this.getTBTServiceListener().updateDrivingBehaviorMode(this.drivingBehaviorMode);
        this.loadChange = 0;
        this.isLoadChangeHintAllowed = false;
    }

    public void setDrivingTable(DrivingTable drivingTable) {
        this.table = drivingTable;
    }

    public DrivingTable getCurrentDrivingTable() {
        return this.table;
    }

    public int getCurrentDrivingHint() {
        int n = -1;
        if (this.displayedHint == 0) {
            n = 2;
        } else if (this.displayedHint == 1) {
            n = 3;
        } else if (this.displayedHint == 2) {
            n = 1;
        } else if (this.displayedHint == 3) {
            n = 0;
        } else if (this.displayedHint == 4) {
            n = 4;
        }
        return n;
    }

    public void setPersistentValues(EcoHmi ecoHmi) {
        if (ecoHmi.contains(779)) {
            this.speedlimit2 = ecoHmi.getValue(779);
        }
        if (ecoHmi.contains(780)) {
            this.speedlimit3 = ecoHmi.getValue(780);
        }
        if (ecoHmi.contains(781)) {
            this.speedlimit4 = ecoHmi.getValue(781);
        }
        if (ecoHmi.contains(782)) {
            this.speed_rating_1 = ecoHmi.getValue(782) * 10;
        }
        if (ecoHmi.contains(783)) {
            this.speed_rating_2 = ecoHmi.getValue(783) * 10;
        }
        if (ecoHmi.contains(784)) {
            this.speed_rating_3 = ecoHmi.getValue(784) * 10;
        }
        if (ecoHmi.contains(785)) {
            this.speed_rating_4 = ecoHmi.getValue(785) * 10;
        }
        if (ecoHmi.contains(786)) {
            this.foresight_speedlimit1 = ecoHmi.getValue(786);
        }
        if (ecoHmi.contains(787)) {
            this.foresight_speedlimit2 = ecoHmi.getValue(787);
        }
        if (ecoHmi.contains(788)) {
            this.foresight_speedlimit3 = ecoHmi.getValue(788);
        }
        if (ecoHmi.contains(806)) {
            this.foresight_acc_limit_neg_11 = ecoHmi.getValue(806) * -10;
        }
        if (ecoHmi.contains(807)) {
            this.foresight_acc_limit_neg_12 = ecoHmi.getValue(807) * -10;
        }
        if (ecoHmi.contains(808)) {
            this.foresight_acc_limit_neg_13 = ecoHmi.getValue(808) * -10;
        }
        if (ecoHmi.contains(809)) {
            this.foresight_acc_limit_neg_21 = ecoHmi.getValue(809) * -10;
        }
        if (ecoHmi.contains(810)) {
            this.foresight_acc_limit_neg_22 = ecoHmi.getValue(810) * -10;
        }
        if (ecoHmi.contains(811)) {
            this.foresight_acc_limit_neg_23 = ecoHmi.getValue(811) * -10;
        }
        if (ecoHmi.contains(812)) {
            this.foresight_acc_limit_neg_31 = ecoHmi.getValue(812) * -10;
        }
        if (ecoHmi.contains(813)) {
            this.foresight_acc_limit_neg_32 = ecoHmi.getValue(813) * -10;
        }
        if (ecoHmi.contains(814)) {
            this.foresight_acc_limit_neg_33 = ecoHmi.getValue(814) * -10;
        }
        if (ecoHmi.contains(797)) {
            this.foresight_acc_limit_pos_11 = ecoHmi.getValue(797) * 10;
        }
        if (ecoHmi.contains(798)) {
            this.foresight_acc_limit_pos_12 = ecoHmi.getValue(798) * 10;
        }
        if (ecoHmi.contains(799)) {
            this.foresight_acc_limit_pos_13 = ecoHmi.getValue(799) * 10;
        }
        if (ecoHmi.contains(800)) {
            this.foresight_acc_limit_pos_21 = ecoHmi.getValue(800) * 10;
        }
        if (ecoHmi.contains(801)) {
            this.foresight_acc_limit_pos_22 = ecoHmi.getValue(801) * 10;
        }
        if (ecoHmi.contains(802)) {
            this.foresight_acc_limit_pos_23 = ecoHmi.getValue(802) * 10;
        }
        if (ecoHmi.contains(803)) {
            this.foresight_acc_limit_pos_31 = ecoHmi.getValue(803) * 10;
        }
        if (ecoHmi.contains(804)) {
            this.foresight_acc_limit_pos_32 = ecoHmi.getValue(804) * 10;
        }
        if (ecoHmi.contains(805)) {
            this.foresight_acc_limit_pos_33 = ecoHmi.getValue(805) * 10;
        }
        if (ecoHmi.contains(789)) {
            this.foresight_rating_pos_1 = ecoHmi.getValue(789) * 10;
        }
        if (ecoHmi.contains(790)) {
            this.foresight_rating_pos_2 = ecoHmi.getValue(790) * 10;
        }
        if (ecoHmi.contains(791)) {
            this.foresight_rating_pos_3 = ecoHmi.getValue(791) * 10;
        }
        if (ecoHmi.contains(792)) {
            this.foresight_rating_pos_4 = ecoHmi.getValue(792) * 10;
        }
        if (ecoHmi.contains(793)) {
            this.foresight_rating_neg_1 = ecoHmi.getValue(793) * 10;
        }
        if (ecoHmi.contains(794)) {
            this.foresight_rating_neg_2 = ecoHmi.getValue(794) * 10;
        }
        if (ecoHmi.contains(795)) {
            this.foresight_rating_neg_3 = ecoHmi.getValue(795) * 10;
        }
        if (ecoHmi.contains(796)) {
            this.foresight_rating_neg_4 = ecoHmi.getValue(796) * 10;
        }
        if (ecoHmi.contains(819)) {
            this.LOADCHANGE_DIVISION_VALUE = ecoHmi.getValue(819);
        }
        if (ecoHmi.contains(821)) {
            this.loadChangeLimit = ecoHmi.getValue(821);
        }
        if (ecoHmi.contains(829)) {
            this.ecoSpeedLimit = ecoHmi.getValue(829);
        }
        if (ecoHmi.contains(816)) {
            this.posLimit = ecoHmi.getValue(816) * 10;
        }
        if (ecoHmi.contains(815)) {
            this.negLimit = ecoHmi.getValue(815) * -10;
        }
        if (ecoHmi.contains(817)) {
            this.maxAcceleration = ecoHmi.getValue(817);
            ServiceManager.aslPropertyManager.valueChangedInteger(10431, this.maxAcceleration);
            this.getTBTServiceListener().updateMaxAcceleration(this.maxAcceleration);
        }
        if (ecoHmi.contains(825)) {
            this.hintDuration = ecoHmi.getValue(825) * 1000;
            ServiceManager.aslPropertyManager.valueChangedInteger(10457, this.hintDuration);
            this.getTBTServiceListener().updateDisplayDurationHintIcon(this.hintDuration);
        }
    }

    private void calculateNewBP() {
        int n = 0;
        this.updateReceived = true;
        if (this.paramSpeed == 0) {
            ASLTargetThinkBlue.logMsg.error(1, "TBT.paramSpeed value 0. Diag data error");
            this.bpCounter = 1;
            return;
        }
        n = (this.table.drivingStates[this.currentStateIdx].getW1() * this.table.drivingStates[this.currentStateIdx].getRating() + this.table.drivingStates[this.currentStateIdx].getW2() * this.paramForesight) / this.paramSpeed;
        if (n < 0) {
            n = 0;
        } else if (n > 1000) {
            n = 1000;
        }
        this.bpLastCalcScore = n;
        this.bpTotal += n;
        ++this.bpCounter;
    }

    public boolean calculateDrivingState() {
        int n;
        boolean bl = false;
        boolean bl2 = false;
        for (n = 0; n < this.table.drivingStates.length; ++n) {
            if (!this.table.evaluate(this.table.drivingStates[n].getId())) continue;
            bl2 = true;
            break;
        }
        if (!bl2) {
            ASLTargetThinkBlue.logMsg.warn(1).append("TBT.DT.DS missed.Use last: ").append(this.table.getTableId()).append(".").append(this.table.drivingStates[this.currentStateIdx].getStateName()).log();
            ASLTargetThinkBlue.logMsg.trace(1).append(ConditionsContainer.getInstance().toString()).log();
            if (this.table.drivingStates[this.currentStateIdx].getId() == 2 || this.displayedHint == 0) {
                this.displayedHint = 4;
                ServiceManager.aslPropertyManager.valueChangedInteger(10422, 4);
                this.drivingBehaviorMode = 4;
                this.getTBTServiceListener().updateDrivingBehaviorMode(this.drivingBehaviorMode);
            }
            return false;
        }
        if (this.table.getTableId() == 0) {
            if (this.table.drivingStates[n].getId() == 6 || this.table.drivingStates[n].getId() == 7 || this.table.drivingStates[n].getId() == 8) {
                if (!this.isTemporalConditionActive) {
                    this.startTemporalConditionTimer();
                    return false;
                }
            } else {
                this.isTemporalConditionActive = false;
                this.stopTemporalConditionTimer();
            }
        }
        if (this.currentStateIdx != n) {
            this.currentStateIdx = n;
            bl = true;
            this.changeDrivingState(n);
        } else {
            this.updateDrivingHint();
        }
        return bl;
    }

    private void changeDrivingState(int n) {
        this.updateDrivingHint();
        if (this.table.drivingStates[n].getId() == 0) {
            this.sendInternalEvent(112);
        } else if (this.table.drivingStates[n].getId() != 1) {
            this.sendInternalEvent(113);
        }
        this.sendInternalEvent(114);
        if (ASLTargetThinkBlue.logMsg.isTraceEnabled(1)) {
            ASLTargetThinkBlue.logMsg.trace(1).append("TBT.DT.DS changed: ").append(this.table.getTableId()).append(", ").append(this.table.drivingStates[n].getStateName()).log();
        }
    }

    public int getAvgBPAndReset() {
        if (!this.updateReceived) {
            ASLTargetThinkBlue.logMsg.warn(1, new StringBuffer().append("TBT.no update in 5s. bpAvg=").append(this.bpAvg).toString());
            this.dumpHMI();
            this.bpAvg = this.bpLastCalcScore;
        } else {
            if (this.bpCounter == 0) {
                ASLTargetThinkBlue.logMsg.error(1, "TBT.bpCounter is 0. Diag data error");
                return this.bpAvg;
            }
            this.bpAvg = this.bpTotal / this.bpCounter;
        }
        if (this.bpPenaltyCounter > 0) {
            if (this.LOADCHANGE_DIVISION_VALUE == 0) {
                ASLTargetThinkBlue.logMsg.error(1, "TBT.Load change division value 0. Diag data error");
                return this.bpAvg;
            }
            this.bpAvg /= this.LOADCHANGE_DIVISION_VALUE;
            --this.bpPenaltyCounter;
        }
        this.sendInternalEvent(114);
        this.updateReceived = false;
        this.bpTotal = 0;
        this.bpCounter = 0;
        return this.bpAvg;
    }

    private void dumpHMI() {
        if (this.dumpHMI) {
            return;
        }
        this.dumpHMI = true;
        ServiceManager.errorHandler.dump();
    }

    public void onLoadChangeTimeout() {
        ASLTargetThinkBlue.logMsg.trace(1).append("TBT.eraseLoadChangePast=").log();
        this.newLoadChangeInterval = true;
        this.isLoadChangeHintAllowed = true;
        this.lowPrioHintAllowed = true;
        this.loadChange = 0;
    }

    public void onSpeedUpdate(double d2) {
        int n = this.calculateAcceleration(d2);
        if (n != this.acc) {
            this.acc = n;
            this.updateRotor(n);
            this.sendInternalEvent(114);
        }
        this.onSpeed((int)d2);
        this.onAcc((int)d2, this.acc);
        this.calculateNewBP();
    }

    public void setSpeedHintSuppressed(boolean bl) {
        this.speedHintSuppressed = bl;
        this.lowPrioHintAllowed = !this.speedHintSuppressed;
    }

    private void sendInternalEvent(int n) {
        EventGeneric eventGeneric = ServiceManager.mGenericEventFactory.newEvent(-2091970048, -2091970048, n);
        if (n == 114) {
            eventGeneric.setString(0, this.table.drivingStates[this.currentStateIdx].getStateName());
            eventGeneric.setInt(1, this.bpAvg);
            eventGeneric.setInt(2, this.acc);
        }
        try {
            ServiceManager.eventMain.getEventDispatcher().send(eventGeneric);
        }
        catch (GenericEventException genericEventException) {
            // empty catch block
        }
    }

    public int getParamSpeed() {
        return this.paramSpeed;
    }

    public int getParamForesight() {
        return this.paramForesight;
    }

    public int getBPLastCalcScore() {
        return this.bpLastCalcScore;
    }

    public String getCurrDrivingStateName() {
        return this.table.drivingStates[this.currentStateIdx].getStateName();
    }

    public int getCurrDrivingStateId() {
        return this.table.drivingStates[this.currentStateIdx].getId();
    }

    public void setCurrDrivingState(int n) {
        for (int i2 = 0; i2 < this.table.drivingStates.length; ++i2) {
            if (n != this.table.drivingStates[i2].getId()) continue;
            this.currentStateIdx = i2;
            break;
        }
    }

    public int getAcc() {
        return this.acc;
    }

    private void onSpeed(int n) {
        int n2 = this.getParamSpeedRating(n);
        if (n2 != this.paramSpeed) {
            ASLTargetThinkBlue.logMsg.trace(1).append("TBT.paramSpeed=").append(n2).log();
            this.paramSpeed = n2;
        }
        boolean bl = this.speedHigh = n >= this.ecoSpeedLimit;
        if (!this.speedHintSuppressed && this.speedHigh) {
            this.updateDrivingHint();
        }
    }

    private void onAcc(int n, int n2) {
        int n3 = this.getParamForesignRating(n, n2);
        if (n3 != this.paramForesight) {
            ASLTargetThinkBlue.logMsg.trace(1).append("TBT.speed=").append(n).append(", acc=").append(n2).append(", paramForesight=").append(n3).log();
            this.paramForesight = n3;
        }
        if (this.newLoadChangeInterval) {
            this.calculateLoadChange(n2);
            if (this.loadChange >= this.loadChangeLimit) {
                this.newLoadChangeInterval = false;
                this.bpPenaltyCounter += 3;
                ASLTargetThinkBlue.logMsg.trace(1).append("TBT.loadChange=").append(this.loadChange).log();
                this.updateDrivingHint();
            }
        }
    }

    private int calculateAcceleration(double d2) {
        double d3 = (d2 - this.oldSpeed) / 3.6 / 0.5;
        this.oldSpeed = d2;
        int n = (int)(d3 * 100.0);
        this.accMovingAverage.add(n);
        if (this.accMovingAverage.size() >= 5) {
            d3 = 0.0;
            for (int i2 = 0; i2 < this.accMovingAverage.size(); ++i2) {
                d3 += (double)this.accMovingAverage.get(i2);
            }
            d3 /= (double)this.accMovingAverage.size();
            this.accMovingAverage.remove(0);
        } else {
            d3 = 0.0;
        }
        return (int)Math.round(d3);
    }

    private void calculateLoadChange(int n) {
        if (n > this.posLimit && (this.loadChangeSign == 0 || this.loadChangeSign == 2)) {
            this.loadChangeSign = 1;
            ++this.loadChange;
        } else if (n < this.negLimit && (this.loadChangeSign == 0 || this.loadChangeSign == 1)) {
            this.loadChangeSign = 2;
            ++this.loadChange;
        }
    }

    private int getParamSpeedRating(int n) {
        int n2 = -1;
        n2 = n >= 0 && n < this.speedlimit2 ? this.speed_rating_1 : (n >= this.speedlimit2 && n < this.speedlimit3 ? this.speed_rating_2 : (n >= this.speedlimit3 && n < this.speedlimit4 ? this.speed_rating_3 : (n >= this.speedlimit4 ? this.speed_rating_4 : this.paramSpeed)));
        return n2;
    }

    private int getParamForesignRating(int n, int n2) {
        int n3 = -1;
        if (n < this.foresight_speedlimit1) {
            if (n2 >= 0 && n2 <= this.foresight_acc_limit_pos_11) {
                n3 = this.foresight_rating_pos_1;
            } else if (n2 > this.foresight_acc_limit_pos_11 && n2 <= this.foresight_acc_limit_pos_12) {
                n3 = this.foresight_rating_pos_2;
            } else if (n2 > this.foresight_acc_limit_pos_12 && n2 <= this.foresight_acc_limit_pos_13) {
                n3 = this.foresight_rating_pos_3;
            } else if (n2 > this.foresight_acc_limit_pos_13) {
                n3 = this.foresight_rating_pos_4;
            } else if (0 > n2 && n2 >= this.foresight_acc_limit_neg_11) {
                n3 = this.foresight_rating_neg_1;
            } else if (this.foresight_acc_limit_neg_11 > n2 && n2 <= this.foresight_acc_limit_neg_12) {
                n3 = this.foresight_rating_neg_2;
            } else if (this.foresight_acc_limit_neg_12 > n2 && n2 <= this.foresight_acc_limit_neg_13) {
                n3 = this.foresight_rating_neg_3;
            } else if (n2 < this.foresight_acc_limit_pos_13) {
                n3 = this.foresight_rating_neg_4;
            }
        } else if (n >= this.foresight_speedlimit1 && n < this.foresight_speedlimit2) {
            if (n2 >= 0 && n2 <= this.foresight_acc_limit_pos_21) {
                n3 = this.foresight_rating_pos_1;
            } else if (n2 > this.foresight_acc_limit_pos_21 && n2 <= this.foresight_acc_limit_pos_22) {
                n3 = this.foresight_rating_pos_2;
            } else if (n2 > this.foresight_acc_limit_pos_22 && n2 <= this.foresight_acc_limit_pos_23) {
                n3 = this.foresight_rating_pos_3;
            } else if (n2 > this.foresight_acc_limit_pos_23) {
                n3 = this.foresight_rating_pos_4;
            } else if (0 > n2 && n2 >= this.foresight_acc_limit_neg_21) {
                n3 = this.foresight_rating_neg_1;
            } else if (this.foresight_acc_limit_neg_21 > n2 && n2 <= this.foresight_acc_limit_neg_22) {
                n3 = this.foresight_rating_neg_2;
            } else if (this.foresight_acc_limit_neg_22 > n2 && n2 <= this.foresight_acc_limit_neg_23) {
                n3 = this.foresight_rating_neg_3;
            } else if (n2 < this.foresight_acc_limit_pos_23) {
                n3 = this.foresight_rating_neg_4;
            }
        } else if (n >= this.foresight_speedlimit2 && n < this.foresight_speedlimit3) {
            if (n2 >= 0 && n2 <= this.foresight_acc_limit_pos_31) {
                n3 = this.foresight_rating_pos_1;
            } else if (n2 > this.foresight_acc_limit_pos_31 && n2 <= this.foresight_acc_limit_pos_32) {
                n3 = this.foresight_rating_pos_2;
            } else if (n2 > this.foresight_acc_limit_pos_32 && n2 <= this.foresight_acc_limit_pos_33) {
                n3 = this.foresight_rating_pos_3;
            } else if (n2 > this.foresight_acc_limit_pos_33) {
                n3 = this.foresight_rating_pos_4;
            } else if (0 > n2 && n2 >= this.foresight_acc_limit_neg_31) {
                n3 = this.foresight_rating_neg_1;
            } else if (this.foresight_acc_limit_neg_31 > n2 && n2 <= this.foresight_acc_limit_neg_32) {
                n3 = this.foresight_rating_neg_2;
            } else if (this.foresight_acc_limit_neg_32 > n2 && n2 <= this.foresight_acc_limit_neg_33) {
                n3 = this.foresight_rating_neg_3;
            } else if (n2 < this.foresight_acc_limit_pos_33) {
                n3 = this.foresight_rating_neg_4;
            }
        } else if (n >= this.foresight_speedlimit3) {
            n3 = n2 >= 0 ? this.foresight_rating_pos_4 : this.foresight_rating_neg_4;
        }
        return n3;
    }

    private void updateRotor(int n) {
        this.currentAcceleration = Math.round(n / 10);
        ServiceManager.aslPropertyManager.valueChangedInteger(10432, this.currentAcceleration);
        this.getTBTServiceListener().updateCurrentAcceleration(this.currentAcceleration);
    }

    private int updateDrivingHint() {
        boolean bl = false;
        for (int i2 = 0; i2 < this.drivingHintsEnum.length; ++i2) {
            switch (i2) {
                case 0: {
                    if (this.currentGear <= 0 || this.recommendedGear <= 0 || this.currentGear == this.recommendedGear || this.table.getTableId() == 2) break;
                    if (this.displayedHint != 0) {
                        ServiceManager.aslPropertyManager.valueChangedInteger(10422, 2);
                        this.drivingBehaviorMode = 2;
                        this.getTBTServiceListener().updateDrivingBehaviorMode(this.drivingBehaviorMode);
                        ASLTargetThinkBlue.logMsg.trace(1).append("TBT.Hint=").append(this.displayedHint).log();
                    }
                    ServiceManager.aslPropertyManager.valueChangedInteger(10420, this.currentGear);
                    this.getTBTServiceListener().updateCurrentGear(this.currentGear);
                    ServiceManager.aslPropertyManager.valueChangedInteger(10421, this.recommendedGear);
                    this.getTBTServiceListener().updateRecommendedGear(this.recommendedGear);
                    this.displayedHint = 0;
                    bl = true;
                    break;
                }
                case 1: {
                    if (!this.isLoadChangeHintAllowed || this.loadChange < this.loadChangeLimit) break;
                    if (this.displayedHint != 1) {
                        this.isLoadChangeHintAllowed = false;
                        this.hintIconTimeout = false;
                        ServiceManager.aslPropertyManager.valueChangedInteger(10422, 3);
                        this.drivingBehaviorMode = 3;
                        this.getTBTServiceListener().updateDrivingBehaviorMode(this.drivingBehaviorMode);
                        this.lowPrioHintAllowed = false;
                        ASLTargetThinkBlue.logMsg.trace(1).append("TBT.Hint=").append(this.displayedHint).log();
                    }
                    this.displayedHint = 1;
                    bl = true;
                    break;
                }
                case 2: {
                    if (!this.speedHigh || this.speedHintSuppressed || !this.lowPrioHintAllowed) break;
                    if (this.displayedHint != 2) {
                        this.hintIconTimeout = false;
                        ServiceManager.aslPropertyManager.valueChangedInteger(10422, 1);
                        this.drivingBehaviorMode = 1;
                        this.getTBTServiceListener().updateDrivingBehaviorMode(this.drivingBehaviorMode);
                        ASLTargetThinkBlue.logMsg.trace(1).append("TBT.Hint=").append(this.displayedHint).log();
                    }
                    this.displayedHint = 2;
                    bl = true;
                    break;
                }
                case 3: {
                    if (this.table.drivingStates[this.currentStateIdx].getId() != 3 && this.table.drivingStates[this.currentStateIdx].getId() != 6 && this.table.drivingStates[this.currentStateIdx].getId() != 9 && this.table.drivingStates[this.currentStateIdx].getId() != 14 && this.table.drivingStates[this.currentStateIdx].getId() != 12 || !this.lowPrioHintAllowed) break;
                    if (this.displayedHint != 3) {
                        ServiceManager.aslPropertyManager.valueChangedInteger(10422, 0);
                        this.drivingBehaviorMode = 0;
                        this.getTBTServiceListener().updateDrivingBehaviorMode(this.drivingBehaviorMode);
                        ASLTargetThinkBlue.logMsg.trace(1).append("TBT.Hint=").append(this.displayedHint).log();
                    }
                    this.displayedHint = 3;
                    bl = true;
                    break;
                }
                default: {
                    if (this.displayedHint != 0 && this.displayedHint != 3 && (this.displayedHint != 2 || !this.hintIconTimeout) && (this.displayedHint != 1 || !this.hintIconTimeout)) break;
                    ServiceManager.aslPropertyManager.valueChangedInteger(10422, 4);
                    this.drivingBehaviorMode = 4;
                    this.getTBTServiceListener().updateDrivingBehaviorMode(this.drivingBehaviorMode);
                    this.displayedHint = 4;
                    ASLTargetThinkBlue.logMsg.trace(1).append("TBT.Hint=").append(this.displayedHint).log();
                }
            }
            if (bl) break;
        }
        return this.displayedHint;
    }

    private void startTemporalConditionTimer() {
        if (!ServiceManager.eventMain.getTimerServer().isTimerActive(-2091970048, 116)) {
            if (ASLTargetThinkBlue.logMsg.isTraceEnabled(1)) {
                ASLTargetThinkBlue.logMsg.trace(1).append("TBT.startClutchOutTimer").log();
            }
            ServiceManager.eventMain.getTimerServer().sendTimedEvent(-2091970048, 116, 0, false);
        }
    }

    private void stopTemporalConditionTimer() {
        if (ServiceManager.eventMain.getTimerServer().isTimerActive(-2091970048, 116)) {
            if (ASLTargetThinkBlue.logMsg.isTraceEnabled(1)) {
                ASLTargetThinkBlue.logMsg.trace(1).append("TBT.stopClutchOutTimer").log();
            }
            ServiceManager.eventMain.getTimerServer().stopTimedEvent(-2091970048, 116);
        }
    }

    public void onStop() {
        this.displayedHint = 4;
        ServiceManager.aslPropertyManager.valueChangedInteger(10422, 4);
        this.drivingBehaviorMode = 4;
        this.getTBTServiceListener().updateDrivingBehaviorMode(this.drivingBehaviorMode);
        this.resetAccBuffer();
    }

    private void resetAccBuffer() {
        this.oldTime = -1L;
        this.oldSpeed = 6.0;
        this.accMovingAverage.clear();
        this.currentAcceleration = 0;
        ServiceManager.aslPropertyManager.valueChangedInteger(10432, this.currentAcceleration);
        this.getTBTServiceListener().updateCurrentAcceleration(this.currentAcceleration);
    }

    public void setParamForesight(int n) {
        this.paramForesight = n;
    }

    public void setParamSpeed(int n) {
        this.paramSpeed = n;
    }

    public void setTemporalCondition(boolean bl) {
        this.isTemporalConditionActive = bl;
    }

    public void hintIconTimeout() {
        this.hintIconTimeout = true;
        this.lowPrioHintAllowed = true;
        this.updateDrivingHint();
    }

    public void onSpeedUnitChange(int n) {
        this.ecoSpeedLimit = this.convertSpeedValueToUnit(this.ecoSpeedLimit, n);
        this.speedlimit2 = this.convertSpeedValueToUnit(this.speedlimit2, n);
        this.speedlimit3 = this.convertSpeedValueToUnit(this.speedlimit3, n);
        this.speedlimit4 = this.convertSpeedValueToUnit(this.speedlimit4, n);
        this.foresight_speedlimit1 = this.convertSpeedValueToUnit(this.foresight_speedlimit1, n);
        this.foresight_speedlimit2 = this.convertSpeedValueToUnit(this.foresight_speedlimit2, n);
        this.foresight_speedlimit3 = this.convertSpeedValueToUnit(this.foresight_speedlimit3, n);
    }

    private int convertSpeedValueToUnit(int n, int n2) {
        int n3 = 1;
        if (n2 == 0) {
            n3 = (int)((double)n / 0.621371);
        } else if (n2 == 1) {
            n3 = (int)((double)n / 1.609344);
        }
        return n3;
    }

    public void setGears(int n, int n2) {
        this.currentGear = n;
        this.recommendedGear = n2;
    }

    private TBTServiceListener getTBTServiceListener() {
        return (TBTServiceListener)ServiceFactory.getInstance().getServiceProviderRegistry().getServiceListener(class$de$vw$mib$asl$api$car$thinkblue$TBTServiceListener == null ? (class$de$vw$mib$asl$api$car$thinkblue$TBTServiceListener = BlueCalculator.class$("de.vw.mib.asl.api.car.thinkblue.TBTServiceListener")) : class$de$vw$mib$asl$api$car$thinkblue$TBTServiceListener);
    }

    public int getMaxAcceleration() {
        return this.maxAcceleration;
    }

    public int getRecommendedGear() {
        return this.recommendedGear;
    }

    public int getCurrentGear() {
        return this.currentGear;
    }

    public int getHintDuration() {
        return this.hintDuration;
    }

    public int getDrivingBehaviorMode() {
        return this.drivingBehaviorMode;
    }

    public int getCurrentAcceleration() {
        return this.currentAcceleration;
    }

    public void setCurrentAcceleration(int n) {
        this.currentAcceleration = n;
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

