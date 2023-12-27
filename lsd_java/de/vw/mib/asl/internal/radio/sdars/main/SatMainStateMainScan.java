/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.radio.sdars.main;

import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.radio.GuiApiTunerCommon;
import de.vw.mib.asl.internal.radio.sdars.database.IAslPoolRecord;
import de.vw.mib.asl.internal.radio.sdars.helper.ChannelWalker;
import de.vw.mib.asl.internal.radio.sdars.helper.SatConfig;
import de.vw.mib.asl.internal.radio.sdars.helper.SatDb;
import de.vw.mib.asl.internal.radio.sdars.main.AbstractMainState;
import de.vw.mib.asl.internal.radio.sdars.main.SatMainTarget;
import de.vw.mib.asl.internal.radio.sdars.presets.SatPresetApi;
import de.vw.mib.collections.ints.IntOptHashSet;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.hsm.Hsm;
import de.vw.mib.genericevents.hsm.HsmState;
import org.dsi.ifc.sdars.StationInfo;

final class SatMainStateMainScan
extends AbstractMainState {
    private IntOptHashSet mSet = null;
    private ChannelWalker mWalker;
    private StationInfo[] mPresets;
    private int mPresetIndex = 0;
    private int mPresetStartIndex = 0;
    private StationInfo actualStartChannel = null;
    private StationInfo startChannel = null;
    private IntOptHashSet startSet = null;
    private boolean isScannedOtherCategory = false;
    private short startCategorynumber = 0;

    SatMainStateMainScan(SatDb satDb, SatMainTarget satMainTarget, Hsm hsm, HsmState hsmState) {
        super(satDb, satMainTarget, hsm, "stateMainScan", hsmState);
    }

    @Override
    public HsmState handle(EventGeneric eventGeneric) {
        HsmState hsmState = null;
        switch (eventGeneric.getReceiverEventId()) {
            case 2: {
                this.mPool.setString(39, this.getName());
                this.mPool.setBoolean(30, true);
                this.mPool.setBoolean(64, false);
                break;
            }
            case 3: {
                try {
                    if (this.mPool.getBoolean(61)) {
                        this.getLogHandler().simpleTrace("Abort scan due to mute condition.");
                        this.mTarget.transStateMainIdle();
                        return null;
                    }
                    this.actualStartChannel = this.mPool.getChannel(23);
                    this.startChannel = this.getValidStartChannelForScan(this.actualStartChannel);
                    this.isScannedOtherCategory = false;
                    int n = this.mDb.getPool().getInt(150);
                    switch (n) {
                        case 0: {
                            this.startCategorynumber = this.startChannel.getCategoryNumber();
                            this.mDb.getCategories().getCategoryChannelFilter().setCategory(this.startCategorynumber);
                            this.mDb.setScanStartedWithFilteredChannel(false);
                            this.mWalker = new ChannelWalker(this.mDb, "ScanWalker", this.mDb.getTreeChannelFilterArray(), false);
                            this.mWalker.setSorting(SatConfig.COMP_NO);
                            break;
                        }
                        case 1: {
                            this.mWalker = new ChannelWalker(this.mDb, "ScanWalker", this.getMainChannelWalker().getFilter(), false);
                            this.mWalker.setSorting(SatConfig.COMP_NAME);
                            break;
                        }
                        default: {
                            this.mWalker = new ChannelWalker(this.mDb, "ScanWalker", this.getMainChannelWalker().getFilter(), false);
                            this.mWalker.setSorting(SatConfig.COMP_NO);
                        }
                    }
                    this.mWalker.fill();
                    int n2 = this.mWalker.size();
                    this.mSet = new IntOptHashSet(n2);
                    this.mSet.add(this.startChannel.stationNumber);
                    this.mWalker.setCursor(this.startChannel.stationNumber);
                    this.startSet = this.mSet;
                    GuiApiTunerCommon.updateScanActive(true);
                    this.mPool.addListener(34, this.mTarget.getTargetId(), -1283063552, false);
                    this.scan();
                }
                catch (Exception exception) {
                    ServiceManager.errorHandler.handleError(exception);
                }
                break;
            }
            case 4: {
                this.isScannedOtherCategory = false;
                this.mTarget.stopTimer(-1551499008);
                this.mPool.removeListener(34, this.mTarget.getTargetId(), -1283063552);
                GuiApiTunerCommon.updateScanActive(false);
                if (this.mSet != null) {
                    this.mSet.clear();
                }
                this.mPool.setBoolean(30, false);
                this.mDb.setScanStartedWithFilteredChannel(false);
                this.mPresets = null;
                this.mWalker = null;
                break;
            }
            case 100003: {
                if (this.mPool.getBoolean(61)) {
                    this.getLogHandler().simpleTrace("Abort scan due to mute condition.");
                    this.mTarget.transStateMainIdle();
                    return null;
                }
                if (this.mWalker.getCursor().sID == this.startChannel.sID && this.startChannel.sID != this.actualStartChannel.sID) {
                    this.getTuneHandler().tuneChannel(4, this.actualStartChannel, false);
                    this.getLogHandler().simpleTrace("Abort scan due to loop finished.");
                    this.mTarget.transStateMainIdle();
                    break;
                }
                this.scan();
                break;
            }
            case 4000021: {
                int n = eventGeneric.getInt(0);
                if (n == 2) break;
                if (n == 0) {
                    this.getLogHandler().simpleTrace("Abort scan due to ASL_SOUND_AUDIOMNGMNT_UNAVAILABLE.");
                    this.mTarget.transStateMainIdle();
                    hsmState = this.myParent;
                    break;
                }
                if (n != 1) break;
                break;
            }
            case 0x4000044B: 
            case 0x4000044C: 
            case 0x4000044F: 
            case 1073742930: 
            case 1073742971: 
            case 1073742974: 
            case 0x400004E0: {
                this.mTarget.transStateMainIdle();
                hsmState = this.myParent;
                break;
            }
            case 1073743017: {
                this.getLogHandler().simpleTrace("Abort scan due to LOAD_LIST.");
                this.mTarget.transStateMainIdle();
                hsmState = this.myParent;
                break;
            }
            case 1073743055: {
                break;
            }
            case 1073743064: {
                this.mDb.setScanStartedWithFilteredChannel(false);
                this.isScannedOtherCategory = false;
                if (this.mPool.getBoolean(61)) {
                    this.mPool.setBoolean(64, true);
                }
                this.getLogHandler().simpleTrace("Abort scan due to STOP_SCAN.");
                this.mTarget.transStateMainIdle();
                break;
            }
            case 100019: {
                IAslPoolRecord iAslPoolRecord = (IAslPoolRecord)eventGeneric.getObject(0);
                if (iAslPoolRecord.getInt() == 0) break;
                this.scan();
                break;
            }
            default: {
                hsmState = this.myParent;
            }
        }
        return hsmState;
    }

    private StationInfo getValidStartChannelForScan(StationInfo stationInfo) {
        if (this.mDb.getMainChannelWalker().containsNo(stationInfo.getStationNumber())) {
            return stationInfo;
        }
        StationInfo stationInfo2 = this.mDb.getMainChannelWalker().getPreviousChannel();
        return stationInfo2;
    }

    private StationInfo getChannelFromNextCategory() {
        int n = this.mPool.getInt(0);
        StationInfo stationInfo = this.getMainChannelWalker().stepNextCategory(n);
        if (stationInfo != null) {
            this.mDb.getCategories().getCategoryChannelFilter().setCategory(stationInfo.getCategoryNumber());
            this.mWalker.setFilter(this.mDb.getTreeChannelFilterArray());
            this.mWalker.fill();
            this.isScannedOtherCategory = true;
            if (this.startCategorynumber == stationInfo.getCategoryNumber()) {
                if (this.startSet != null) {
                    this.mSet = this.startSet;
                }
            } else {
                int n2 = this.mWalker.size();
                this.mSet = new IntOptHashSet(n2);
                this.mSet.add(stationInfo.stationNumber);
            }
        }
        return stationInfo;
    }

    private void scan() {
        try {
            if (this.mPresets != null) {
                boolean bl = false;
                do {
                    ++this.mPresetIndex;
                    if (this.mPresetIndex >= this.mPresets.length) {
                        this.mPresetIndex = 0;
                    }
                    if (this.mPresetIndex == this.mPresetStartIndex) {
                        bl = true;
                    }
                    if (this.mPresets[this.mPresetIndex] == null) continue;
                    int n = this.mPresets[this.mPresetIndex].getSID();
                    StationInfo stationInfo = this.mDb.getChannels().getChannelBySID(n);
                    if (stationInfo == null || stationInfo.getSubscription() != 2) continue;
                    this.getTuneHandler().tuneChannel(4, this.mPresets[this.mPresetIndex], false);
                    SatPresetApi satPresetApi = this.mDb.getPresetApi();
                    satPresetApi.setIndex(this.mPresetIndex);
                    if (bl) continue;
                    int n2 = this.mPool.getInt(58);
                    this.mTarget.startTimer(-1551499008, (long)n2, false);
                    return;
                } while (!bl);
                this.getLogHandler().simpleTrace("Abort scan due to loop finished 1.");
                this.mTarget.transStateMainIdle();
            } else {
                int n = this.mDb.getPool().getInt(150);
                StationInfo stationInfo = this.mWalker.getNextChannel();
                if (stationInfo == null) {
                    this.getLogHandler().simpleTrace("Abort scan due to no next channel.");
                    this.mTarget.transStateMainIdle();
                } else {
                    if (n == 0 && stationInfo.getStationNumber() < this.mWalker.getCursor().stationNumber) {
                        stationInfo = this.getChannelFromNextCategory();
                    }
                    this.mWalker.setCursor(stationInfo.stationNumber);
                    if (this.mSet.contains(stationInfo.stationNumber)) {
                        if (n == 0) {
                            if (this.startCategorynumber == stationInfo.getCategoryNumber()) {
                                if (!this.isScannedOtherCategory) {
                                    stationInfo = this.getChannelFromNextCategory();
                                }
                            } else {
                                stationInfo = this.getChannelFromNextCategory();
                            }
                        } else if (this.startChannel.sID == this.actualStartChannel.sID) {
                            this.getLogHandler().simpleTrace("Abort scan due to loop finished.");
                            this.mTarget.transStateMainIdle();
                        }
                    }
                }
                if (stationInfo == null) {
                    this.getLogHandler().simpleTrace("Abort scan due to no next channel.");
                    this.mTarget.transStateMainIdle();
                } else {
                    this.getTuneHandler().tuneChannel(4, stationInfo, false);
                    this.mWalker.setCursor(stationInfo.stationNumber);
                    int n3 = this.mPool.getInt(58);
                    this.mTarget.startTimer(-1551499008, (long)n3, false);
                    if (n == 0 && this.mSet.contains(stationInfo.stationNumber) && this.startCategorynumber == stationInfo.getCategoryNumber() && this.isScannedOtherCategory && this.actualStartChannel.sID == this.startChannel.sID) {
                        this.isScannedOtherCategory = false;
                        this.getLogHandler().simpleTrace("Abort scan due to loop finished.");
                        this.mTarget.transStateMainIdle();
                    }
                }
            }
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
        }
    }
}

