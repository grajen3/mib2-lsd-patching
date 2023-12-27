/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.radio.dab;

import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.radio.GuiApiDab;
import de.vw.mib.asl.internal.radio.RadioDabTraceUtil;
import de.vw.mib.asl.internal.radio.RadioData;

public final class DabFrequencyTable {
    private int mBandSetting1;
    private int mBandSetting2;
    private int mCurrentScale;
    private int mCurrentMaxValue;
    private boolean mLBandOptionAvailable = true;
    private int mFrequencyTable = 0;
    public static boolean switchFreqTableRequested = false;

    public void setFrequencyTable(int n) {
        try {
            if (switchFreqTableRequested) {
                switch (n) {
                    case 1: 
                    case 2: {
                        this.changeLBandState(true);
                        break;
                    }
                    case 4: 
                    case 8: {
                        this.changeLBandState(false);
                        break;
                    }
                }
                this.notifyHmiAboutFrequencyTable();
                this.notifyHMIAboutLBandOptionState();
                this.mFrequencyTable = n;
            }
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
        }
    }

    public void initFromDiagnosis(int n, int n2) {
        try {
            this.mBandSetting1 = n;
            this.mBandSetting2 = n2;
            boolean bl = RadioData.getDabDatabase().mPersistable.getLBandOptionState();
            block1 : switch (n) {
                case 2: {
                    switch (this.mBandSetting2) {
                        case 0: {
                            this.mCurrentMaxValue = 41;
                            this.mCurrentScale = 2;
                            bl = false;
                            this.mLBandOptionAvailable = false;
                            break block1;
                        }
                        case 1: {
                            this.mLBandOptionAvailable = true;
                            if (bl) {
                                this.mCurrentMaxValue = 64;
                                this.mCurrentScale = 4;
                                break block1;
                            }
                            this.mCurrentMaxValue = 41;
                            this.mCurrentScale = 2;
                            break block1;
                        }
                    }
                    RadioDabTraceUtil.errorLogDab("Inside the default case of BAND_1_EU_BAND_III");
                    this.mLBandOptionAvailable = true;
                    if (bl) {
                        this.mCurrentMaxValue = 75;
                        this.mCurrentScale = 0;
                        break;
                    }
                    this.mCurrentMaxValue = 41;
                    this.mCurrentScale = 2;
                    break;
                }
                case 1: {
                    switch (n2) {
                        case 0: {
                            this.mLBandOptionAvailable = false;
                            this.mCurrentMaxValue = 38;
                            this.mCurrentScale = 3;
                            bl = false;
                            break block1;
                        }
                        case 1: {
                            this.mLBandOptionAvailable = true;
                            if (bl) {
                                this.mCurrentMaxValue = 61;
                                this.mCurrentScale = 5;
                                break block1;
                            }
                            this.mCurrentMaxValue = 38;
                            this.mCurrentScale = 3;
                            break block1;
                        }
                    }
                    RadioDabTraceUtil.errorLogDab("Inside the default case of BAND_1_EU_BAND_III_N");
                    this.mLBandOptionAvailable = true;
                    if (bl) {
                        this.mCurrentMaxValue = 75;
                        this.mCurrentScale = 0;
                        break;
                    }
                    this.mCurrentMaxValue = 38;
                    this.mCurrentScale = 3;
                    break;
                }
                case 0: {
                    this.mLBandOptionAvailable = false;
                    switch (n2) {
                        case 0: {
                            break block1;
                        }
                        case 1: {
                            this.mCurrentMaxValue = 23;
                            this.mCurrentScale = 1;
                            bl = false;
                            break block1;
                        }
                    }
                    RadioDabTraceUtil.errorLogDab("Inside the default case of BAND_1_OFF");
                    this.mCurrentMaxValue = 75;
                    this.mCurrentScale = 0;
                    bl = false;
                    break;
                }
                case 3: {
                    bl = false;
                    this.mLBandOptionAvailable = false;
                    switch (n2) {
                        case 0: {
                            this.mCurrentScale = 10;
                            this.mCurrentMaxValue = 23;
                            break block1;
                        }
                    }
                    RadioDabTraceUtil.errorLogDab("Inside the default case of BAND_1_CANADA_L_BAND");
                    this.mCurrentMaxValue = 75;
                    this.mCurrentScale = 0;
                    break;
                }
                case 4: {
                    bl = false;
                    this.mLBandOptionAvailable = false;
                    switch (n2) {
                        case 0: {
                            this.mCurrentScale = 9;
                            this.mCurrentMaxValue = 21;
                            break block1;
                        }
                    }
                    RadioDabTraceUtil.errorLogDab("Inside the default case of BAND_1_KOREA_BAND_III");
                    this.mCurrentMaxValue = 75;
                    this.mCurrentScale = 0;
                    break;
                }
                case 5: {
                    this.mCurrentMaxValue = 31;
                    this.mCurrentScale = 7;
                    switch (n2) {
                        case 0: {
                            bl = false;
                            this.mLBandOptionAvailable = false;
                            break;
                        }
                        case 1: {
                            this.mLBandOptionAvailable = true;
                            if (!bl) break block1;
                            this.mCurrentScale = 8;
                            this.mCurrentMaxValue += 23;
                            break;
                        }
                        default: {
                            RadioDabTraceUtil.errorLogDab("Inside the default case of BAND_1_CHINA_BAND_III");
                            this.mLBandOptionAvailable = true;
                            this.mCurrentMaxValue = 75;
                            this.mCurrentScale = 0;
                            break;
                        }
                    }
                    break;
                }
                case 7: {
                    this.mLBandOptionAvailable = false;
                    bl = false;
                    switch (n2) {
                        case 0: {
                            this.mCurrentScale = 11;
                            this.mCurrentMaxValue = 36;
                            break block1;
                        }
                    }
                    RadioDabTraceUtil.errorLogDab("Inside the default case of BAND_1_NEW_ZEALAND_BAND_III");
                    this.mCurrentMaxValue = 75;
                    this.mCurrentScale = 0;
                    break;
                }
                default: {
                    RadioDabTraceUtil.errorLogDab("Band1 not available so going to default universal scale");
                    this.mCurrentMaxValue = 75;
                    this.mCurrentScale = 0;
                    switch (this.mBandSetting2) {
                        case 0: {
                            bl = false;
                            this.mLBandOptionAvailable = false;
                            break block1;
                        }
                    }
                    this.mLBandOptionAvailable = true;
                }
            }
            this.notifyHmiAboutFrequencyTable();
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
        }
    }

    public void changeLBandState(boolean bl) {
        try {
            RadioData.getDabDatabase().mPersistable.setLBandOptionState(bl);
            switch (this.mBandSetting1) {
                case 5: {
                    this.mCurrentMaxValue = 31;
                    if (bl) {
                        this.mCurrentMaxValue += 23;
                        this.mCurrentScale = 8;
                        break;
                    }
                    this.mCurrentScale = 7;
                    break;
                }
                case 2: {
                    this.mCurrentMaxValue = 41;
                    if (bl) {
                        this.mCurrentMaxValue += 23;
                        this.mCurrentScale = 4;
                        break;
                    }
                    this.mCurrentScale = 2;
                    break;
                }
                case 1: {
                    this.mCurrentMaxValue = 38;
                    if (bl) {
                        this.mCurrentMaxValue += 23;
                        this.mCurrentScale = 5;
                        break;
                    }
                    this.mCurrentScale = 3;
                    break;
                }
                default: {
                    RadioDabTraceUtil.errorLogDab("the current band has no l band - band is changed");
                    break;
                }
            }
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
        }
    }

    public void notifyHMIAboutLBandOptionState() {
        GuiApiDab.updateLBandOptionState(RadioData.getDabDatabase().mPersistable.getLBandOptionState());
    }

    public void notifyHMIAboutLBandOption() {
        GuiApiDab.updateLBandOptionAvailable(this.mLBandOptionAvailable);
    }

    public void notifyHmiAboutFrequencyTable() {
        try {
            GuiApiDab.updateFrequencyMaxValue(this.mCurrentMaxValue);
            GuiApiDab.updateDabScale(this.mCurrentScale);
            this.notifyHMIAboutLBandOption();
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
        }
    }

    public boolean getLBandOptionState() {
        return RadioData.getDabDatabase().mPersistable.getLBandOptionState();
    }

    public boolean getLBandOptionAvailable() {
        return this.mLBandOptionAvailable;
    }

    public int getTable() {
        return this.mFrequencyTable;
    }

    public String toString() {
        String string = new StringBuffer().append("LBandOptionAvailable[").append(this.mLBandOptionAvailable).append("];").toString();
        string = new StringBuffer().append(string).append("LBandOption[").append(RadioData.getDabDatabase().mPersistable.getLBandOptionState()).append("]").toString();
        return string;
    }
}

