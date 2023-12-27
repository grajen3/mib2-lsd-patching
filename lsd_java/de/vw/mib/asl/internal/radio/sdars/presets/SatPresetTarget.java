/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.radio.sdars.presets;

import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.radio.RadioCodingAdapter;
import de.vw.mib.asl.internal.radio.RadioCurrentWaveband;
import de.vw.mib.asl.internal.radio.RadioServiceManager;
import de.vw.mib.asl.internal.radio.sdars.database.IAslPool;
import de.vw.mib.asl.internal.radio.sdars.database.IAslPoolRecord;
import de.vw.mib.asl.internal.radio.sdars.debug.SatLogHandler;
import de.vw.mib.asl.internal.radio.sdars.helper.SatConfig;
import de.vw.mib.asl.internal.radio.sdars.helper.SatDb;
import de.vw.mib.asl.internal.radio.sdars.presets.SatPreset;
import de.vw.mib.asl.internal.radio.sdars.presets.SatPresetModel;
import de.vw.mib.asl.internal.radio.tile.list.TileStationList;
import de.vw.mib.genericevents.AbstractTarget;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.Target;
import org.dsi.ifc.sdars.StationInfo;

final class SatPresetTarget
extends AbstractTarget {
    private final SatPresetModel mModel;
    private final SatDb mDb;
    private final IAslPool mPool;
    private boolean mTimerCheckPresetsAfterChannelListUpdateIsRunning = false;

    SatPresetTarget(Target target, SatPresetModel satPresetModel) {
        super(target.getMainObject());
        this.mModel = satPresetModel;
        this.mDb = this.mModel.getDb();
        this.mPool = this.mDb.getPool();
        String string = this.getEventDispatcher().getTaskId(target.getTargetId());
        this.getEventDispatcher().registerTarget(this, string);
    }

    @Override
    public int getClassifier() {
        return 1;
    }

    @Override
    public int getSubClassifier() {
        return 512;
    }

    @Override
    public void gotEvent(EventGeneric eventGeneric) {
        SatDb.logEvent("Presets", eventGeneric);
        switch (eventGeneric.getReceiverEventId()) {
            case 8: {
                this.addObserver(-553385920);
                this.addObserver(-1677459392);
                this.addObserver(-1694236608);
                this.addObserver(0x4D040040);
                this.addObserver(0x4F040040);
                this.addObserver(1375993920);
                this.addObserver(1627652160);
                this.addObserver(-2130444224);
                int n = this.getTargetId();
                this.mPool.addListener(15, n, -846790400);
                this.mPool.addListener(54, n, -813235968);
                this.mPool.addListener(34, n, -796458752);
                this.mTimerCheckPresetsAfterChannelListUpdateIsRunning = false;
                break;
            }
            case 9: {
                this.removeObserver(-553385920);
                this.removeObserver(-1677459392);
                this.removeObserver(-1694236608);
                this.removeObserver(0x4D040040);
                this.removeObserver(0x4F040040);
                this.removeObserver(1375993920);
                this.removeObserver(1627652160);
                this.removeObserver(-2130444224);
                int n = this.getTargetId();
                this.mPool.removeListener(15, n, -846790400);
                this.mPool.removeListener(54, n, -813235968);
                this.mPool.removeListener(34, n, -796458752);
                break;
            }
            case 1073743071: {
                Object object;
                if (!RadioCurrentWaveband.isSdars()) break;
                SatLogHandler satLogHandler = this.mDb.getLogHandler();
                int n = eventGeneric.getInt(0);
                if (this.mModel.checkIndex(n)) {
                    object = this.mPool.getChannel(15);
                    if (object == null) {
                        satLogHandler.simpleTrace("Unable to store channel on preset: no current channel");
                    } else if (this.mPool.getInt(34) == ((StationInfo)object).getSID()) {
                        satLogHandler.simpleTrace("Unable to store channel on preset: channel invalid");
                    } else if (((StationInfo)object).subscription == 1) {
                        satLogHandler.simpleTrace("Unable to store channel on preset: channel not subscribed");
                    } else if (((StationInfo)object).stationNumber == 0) {
                        satLogHandler.simpleTrace("Unable to store channel on preset: Zero channel");
                    } else {
                        this.mModel.storeStationOnPreset(n, (StationInfo)object);
                    }
                }
                try {
                    if (!RadioCodingAdapter.isRadioTileFeatureActivated() || null == (object = RadioServiceManager.getServiceManager().getTileStationList())) break;
                    ((TileStationList)object).initTiles();
                }
                catch (Exception exception) {
                    ServiceManager.errorHandler.handleError(exception);
                }
                break;
            }
            case 1073743004: {
                int n = eventGeneric.getInt(0);
                if (!RadioCurrentWaveband.isSdars(n)) break;
                int n2 = eventGeneric.getInt(1);
                this.mModel.deleteByIndex(n2);
                try {
                    TileStationList tileStationList;
                    if (!RadioCodingAdapter.isRadioTileFeatureActivated() || null == (tileStationList = RadioServiceManager.getServiceManager().getTileStationList())) break;
                    tileStationList.initTiles();
                }
                catch (Exception exception) {
                    ServiceManager.errorHandler.handleError(exception);
                }
                break;
            }
            case 1073743003: {
                int n;
                int n3 = eventGeneric.getInt(0);
                if (!RadioCurrentWaveband.isSdars() || n3 != 3 || !RadioCurrentWaveband.isSdars(n = eventGeneric.getInt(0))) break;
                this.mModel.deleteAllPresets();
                try {
                    TileStationList tileStationList;
                    if (!RadioCodingAdapter.isRadioTileFeatureActivated() || null == (tileStationList = RadioServiceManager.getServiceManager().getTileStationList())) break;
                    tileStationList.initTiles();
                }
                catch (Exception exception) {
                    ServiceManager.errorHandler.handleError(exception);
                }
                break;
            }
            case 0x4000044D: {
                int n = eventGeneric.getInt(0);
                this.mModel.recallPreset(n);
                this.getTimerServer().restartOrStartTimedEvent(this.getTargetId(), -863567616, 0, false);
                this.mModel.setBankIndex(n / SatConfig.mMaxPresetsPerBank);
                break;
            }
            case 100300: {
                this.mModel.enableAutoCompare();
                break;
            }
            case 0x4000044F: {
                SatPreset satPreset;
                int n;
                if (RadioServiceManager.getServiceManager().getTileStationList().isTileSVisible() || (n = this.mPool.getInt(35)) != 0 || (satPreset = this.mModel.getNextChannel()) == null) break;
                satPreset.tune(16);
                this.mModel.setBankIndex(satPreset.getIndex() / SatConfig.mMaxPresetsPerBank);
                break;
            }
            case 1073742930: {
                SatPreset satPreset;
                int n;
                if (RadioServiceManager.getServiceManager().getTileStationList().isTileSVisible() || (n = this.mPool.getInt(35)) != 0 || (satPreset = this.mModel.getPreviousChannel()) == null) break;
                satPreset.tune(17);
                this.mModel.setBankIndex(satPreset.getIndex() / SatConfig.mMaxPresetsPerBank);
                break;
            }
            case 100304: {
                SatPreset satPreset;
                IAslPoolRecord iAslPoolRecord = (IAslPoolRecord)eventGeneric.getObject(0);
                int n = iAslPoolRecord.getInt();
                if (n <= 0) break;
                int n4 = this.mPool.getInt(83);
                if (n4 == 16) {
                    SatPreset satPreset2;
                    SatPreset satPreset3 = this.mModel.getIndex();
                    if (satPreset3 == null || satPreset3.getStation().getSID() != n || (satPreset2 = this.mModel.getNextChannel()) == null || satPreset2.getStation().getSID() == n) break;
                    satPreset2.tune(16);
                    this.mModel.setBankIndex(satPreset2.getIndex() / SatConfig.mMaxPresetsPerBank);
                    break;
                }
                if (n4 == 17) {
                    SatPreset satPreset4;
                    SatPreset satPreset5 = this.mModel.getIndex();
                    if (satPreset5 == null || satPreset5.getStation().getSID() != n || (satPreset4 = this.mModel.getPreviousChannel()) == null || satPreset4.getStation().getSID() == n) break;
                    satPreset4.tune(17);
                    this.mModel.setBankIndex(satPreset4.getIndex() / SatConfig.mMaxPresetsPerBank);
                    break;
                }
                if (n4 != 1 || (satPreset = this.mModel.findStation(n)) == null || !satPreset.isValid()) break;
                this.mPool.setChannel(72, satPreset.getStation());
                break;
            }
            case 1073742945: {
                int n = eventGeneric.getInt(0);
                this.mModel.setBankIndex(n / SatConfig.mMaxPresetsPerBank);
                break;
            }
            case 1073742977: {
                if (!RadioCurrentWaveband.isSdars()) break;
                this.mModel.updateBankIndex();
                break;
            }
            case 1073743079: {
                this.mModel.autoCompare();
                this.mModel.updateHmi();
                break;
            }
            case 100301: {
                this.mModel.autoCompare();
                this.mModel.updateHmi();
                break;
            }
            case 100303: {
                this.mModel.autoCompare();
                if (this.mTimerCheckPresetsAfterChannelListUpdateIsRunning) {
                    this.retriggerTimer(-830013184);
                    break;
                }
                this.startTimer(-830013184, (long)0, false);
                break;
            }
            case 100302: {
                this.mModel.checkPresetsAfterChannelListUpdate();
                break;
            }
            default: {
                SatDb.logEvent("-Presets", eventGeneric);
            }
        }
    }
}

