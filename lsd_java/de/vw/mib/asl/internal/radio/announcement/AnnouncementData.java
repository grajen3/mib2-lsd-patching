/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.radio.announcement;

import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.radio.RadioCodingAdapter;
import de.vw.mib.asl.internal.radio.announcement.AnnouncementFreezer;
import de.vw.mib.asl.internal.radio.announcement.AnnouncementTuner;
import de.vw.mib.asl.internal.radio.announcement.AnnouncementView;

public final class AnnouncementData {
    private static final int MASK_UNDEFINED;
    private static final int MASK_FM_TA;
    static final int MASK_FM_PTY31;
    private static final int MASK_FM_EON_TA;
    static final int MASK_DAB_ALARM;
    private static final int MASK_DAB_TRAFFIC;
    private static final int MASK_DAB_TRANSPORT;
    static final int MASK_DAB_WARNING;
    static final int MASK_DAB_NEWS;
    static final int MASK_DAB_AREA_WEATHER;
    static final int MASK_DAB_EVENT_ANNOUNCEMENT;
    static final int MASK_DAB_SPECIAL_EVENT;
    static final int MASK_DAB_PROGRAM_INFORMATION;
    static final int MASK_DAB_SPORT_REPORT;
    static final int MASK_DAB_FINANCIAL_REPORT;
    static final int MASK_DAB_RESERVED_1;
    static final int MASK_DAB_RESERVED_2;
    static final int MASK_DAB_RESERVED_3;
    static final int MASK_DAB_RESERVED_4;
    static final int MASK_DAB_RESERVED_5;
    static final int MASK_DAB_SEAMLESS_FM_TA;
    static final int MASK_NONE;
    private static final int MASK_NOTHING;
    static final int MASK_FM_TA_WITH_EON;
    static final int MASK_DAB_TA_OR_TRANSPORT;
    static final int MASK_GLOBAL_TA_AMFM_AND_DAB;
    private static final int MASK_DAB_OTHER;
    private static final int MASK_DAB_TP_AND_OTHER;
    private static final int MASK_DAB_ALL;
    private final AnnouncementFreezer mAnnouncementFreezer;
    private final AnnouncementTuner mAnnouncementTuner;
    private final AnnouncementView mAnnouncementView;
    private int mAnnouncementValue;
    private static int mAnnouncementStatus;
    private int mAnnouncementFilter;
    private boolean mScanMode;
    private boolean mInitialAutostoreMode;
    private boolean mSetupTaVolumeMode;
    private boolean mDabMuted;
    private boolean mSpeechActive;
    private boolean mPhoneActive;
    private boolean mNoAudioManagement;
    private boolean mTPOption;
    private boolean mRDSOption;
    private boolean mPTY31Option;
    private boolean mDABOtherOption;
    private boolean mDABTrafficOption;
    private boolean mDABAlarmOption;

    AnnouncementData(AnnouncementFreezer announcementFreezer, AnnouncementTuner announcementTuner, AnnouncementView announcementView) {
        this.mAnnouncementFreezer = announcementFreezer;
        this.mAnnouncementTuner = announcementTuner;
        this.mAnnouncementView = announcementView;
        this.mAnnouncementValue = 0;
        mAnnouncementStatus = 0;
        this.mAnnouncementFilter = 0;
        this.mScanMode = false;
        this.mInitialAutostoreMode = false;
        this.mSetupTaVolumeMode = false;
        this.mDabMuted = false;
        this.mSpeechActive = false;
        this.mPhoneActive = false;
        this.mNoAudioManagement = false;
        this.mTPOption = false;
        this.mRDSOption = false;
        this.mPTY31Option = false;
        this.mDABOtherOption = false;
        this.mDABTrafficOption = false;
        this.mDABAlarmOption = false;
    }

    private boolean isTemporaryDisabled() {
        return this.mScanMode || this.mInitialAutostoreMode || this.mSetupTaVolumeMode;
    }

    private void notifyFilterUpdate() {
        if (!this.isTemporaryDisabled()) {
            this.mAnnouncementFreezer.reheat();
            this.mAnnouncementTuner.setFilter(this.mAnnouncementFilter);
        } else {
            this.mAnnouncementFreezer.freeze();
            this.mAnnouncementTuner.setFilter(2048);
        }
    }

    void setScanMode(boolean bl) {
        if (this.mScanMode != bl) {
            this.mScanMode = bl;
            this.notifyFilterUpdate();
        }
    }

    void setInitialAutostoreMode(boolean bl) {
        if (this.mInitialAutostoreMode != bl) {
            this.mInitialAutostoreMode = bl;
            this.notifyFilterUpdate();
        }
    }

    void setSetupTaVolumeMode(boolean bl) {
        if (this.mSetupTaVolumeMode != bl) {
            this.mSetupTaVolumeMode = bl;
            this.notifyFilterUpdate();
        }
    }

    void setDabMuted(boolean bl) {
        this.mDabMuted = bl;
    }

    void setAudioComponent(int n) {
        this.mSpeechActive = n == 5;
        this.mPhoneActive = n == 4;
    }

    void setNoAudioManagement(boolean bl) {
        this.mNoAudioManagement = bl;
    }

    boolean isAnnouncementSuppressed() {
        return this.mSpeechActive || this.mPhoneActive || this.mNoAudioManagement;
    }

    boolean getDabMuted() {
        return this.mDabMuted;
    }

    void updateAnnouncementValue(int n) {
        this.mAnnouncementValue = n;
        mAnnouncementStatus = n != 0 ? 1 << n - 1 : 0;
    }

    void abort() {
        this.mAnnouncementTuner.abort(this.mAnnouncementValue);
    }

    private void setFilter(int n) {
        if (ServiceManager.logger.isTraceEnabled(8192)) {
            ServiceManager.logger.trace(8192).append("<AnnouncementData>setFilter:").append(n).log();
        }
        this.mAnnouncementFilter |= n;
    }

    private void clrFilter(int n) {
        this.mAnnouncementFilter &= ~n;
    }

    boolean isFMTrafficType() {
        return (mAnnouncementStatus & 0x5002000) != 0;
    }

    boolean isDABTrafficType() {
        return (mAnnouncementStatus & 0x30) != 0;
    }

    boolean isDABActive() {
        return (mAnnouncementStatus & 0x3FF8) != 0;
    }

    boolean isPTY31TypeFM() {
        return (mAnnouncementStatus & 2) != 0;
    }

    boolean isPTY31TypeDAB() {
        return (mAnnouncementStatus & 8) != 0;
    }

    boolean isDABOtherAnnouncement() {
        return (mAnnouncementStatus & 0x3FC0) != 0;
    }

    boolean isNothing() {
        return (mAnnouncementStatus & 0xFFFFF7FF) == 0;
    }

    private void updateFilter() {
        if (this.mTPOption && this.mRDSOption) {
            this.setFilter(5);
            this.setFilter(8192);
        } else {
            this.clrFilter(5);
            this.clrFilter(8192);
        }
        if (this.mPTY31Option && this.mRDSOption) {
            this.setFilter(2);
        } else {
            this.clrFilter(2);
        }
        if (this.mDABOtherOption) {
            this.setFilter(16320);
        } else {
            this.clrFilter(16320);
        }
        if (this.mDABTrafficOption && this.mRDSOption && this.mTPOption) {
            this.setFilter(48);
        } else if (this.mDABTrafficOption && !this.mRDSOption) {
            this.setFilter(48);
        } else if (this.mDABTrafficOption && !RadioCodingAdapter.isPiActivated()) {
            this.setFilter(48);
        } else {
            this.clrFilter(48);
        }
        if (this.mDABAlarmOption || this.mDABOtherOption) {
            this.setFilter(8);
        } else {
            this.clrFilter(8);
        }
        this.notifyFilterUpdate();
    }

    void updateFMAlarmAnnouncements(boolean bl) {
        if (ServiceManager.logger.isTraceEnabled(8192)) {
            ServiceManager.logger.trace(8192).append("<AnnouncementData>switchFMAlarmAnnouncements:").append(bl).log();
        }
        this.mPTY31Option = bl;
        this.updateFilter();
    }

    void updateDABAlarmAnnouncements(boolean bl) {
        if (ServiceManager.logger.isTraceEnabled(8192)) {
            ServiceManager.logger.trace(8192).append("<AnnouncementData>switchDABAlarmAnnouncements:").append(bl).log();
        }
        this.mDABAlarmOption = bl;
        this.updateFilter();
    }

    void updateDABTrafficAnnouncements(boolean bl) {
        if (ServiceManager.logger.isTraceEnabled(8192)) {
            ServiceManager.logger.trace(8192).append("<AnnouncementData>switchDABTrafficAnnouncements:").append(bl).log();
        }
        this.mDABTrafficOption = bl;
        this.updateFilter();
    }

    void updateGlobalTrafficAnnouncements(boolean bl) {
        if (ServiceManager.logger.isTraceEnabled(8192)) {
            ServiceManager.logger.trace(8192).append("<AnnouncementData>switchGlobalTrafficAnnouncements:").append(bl).log();
        }
        this.mTPOption = bl;
        this.updateFilter();
    }

    void updateRDSOption(boolean bl) {
        if (ServiceManager.logger.isTraceEnabled(8192)) {
            ServiceManager.logger.trace(8192).append("<AnnouncementData>switchRDSOption:").append(bl).log();
        }
        this.mRDSOption = bl;
        this.updateFilter();
    }

    void updateDABOtherAnnouncements(boolean bl) {
        if (ServiceManager.logger.isTraceEnabled(8192)) {
            ServiceManager.logger.trace(8192).append("<AnnouncementData>switchDABOtherAnnouncements:").append(bl).log();
        }
        this.mDABOtherOption = bl;
        this.updateFilter();
    }

    void updateStationIdentification(String string, int n, int n2) {
        this.mAnnouncementView.updateStationIdentification(string, n, n2);
    }

    void clearHmi() {
        this.mAnnouncementView.clear();
        this.mAnnouncementView.updateDabAnnouncementSyncState(0);
    }

    void notifyStatus() {
        this.mAnnouncementView.updateStatus(mAnnouncementStatus);
    }

    void updateAvailability(int n) {
        this.mAnnouncementFreezer.updateAvailability(n);
    }

    void notifyServiceState(int n) {
        this.mAnnouncementView.updateDabAnnouncementSyncState(n);
    }
}

