/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.radio.sdars.main;

import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.radio.GuiApiTunerCommon;
import de.vw.mib.asl.internal.radio.RadioCodingAdapter;
import de.vw.mib.asl.internal.radio.RadioCurrentWaveband;
import de.vw.mib.asl.internal.radio.RadioServiceManager;
import de.vw.mib.asl.internal.radio.sdars.helper.SatDb;
import de.vw.mib.asl.internal.radio.sdars.main.AbstractMainState;
import de.vw.mib.asl.internal.radio.sdars.main.SatMainTarget;
import de.vw.mib.asl.internal.radio.tagging.TaggingApi;
import de.vw.mib.asl.internal.radio.tile.list.TileStationList;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.hsm.Hsm;
import de.vw.mib.genericevents.hsm.HsmState;
import org.dsi.ifc.sdars.StationInfo;

final class SatMainStateActive
extends AbstractMainState {
    private static final int MIN_TIME_WAIT_SCAN;
    private static final int TIME_FOR_NO_PREVIEW_AT_STARTUP;
    private long mTimeForStorePreview = 0L;

    SatMainStateActive(SatDb satDb, SatMainTarget satMainTarget, Hsm hsm, String string, HsmState hsmState) {
        super(satDb, satMainTarget, hsm, string, hsmState);
    }

    private boolean previewAllowed() {
        long l = this.mPool.getLong(82);
        long l2 = ServiceManager.timerManager.getSystemTimeMillis() - l;
        return l > 0L && l2 >= 0;
    }

    @Override
    public HsmState handle(EventGeneric eventGeneric) {
        HsmState hsmState = null;
        switch (eventGeneric.getReceiverEventId()) {
            case 2: {
                this.mPool.setString(39, this.getName());
                long l = this.mPool.getLong(82);
                if (l == 0L) {
                    this.mPool.setLong(82, ServiceManager.timerManager.getSystemTimeMillis());
                }
                this.getStatusHandler().updateTunerState();
                this.getHmiUpdater().updateCurrentChannel(false);
                this.mDb.getRadioTextHandler().updatePDT();
                this.mTimeForStorePreview = 0L;
                String string = this.mPool.getString(11);
                String string2 = this.mPool.getString(12);
                TaggingApi.setSXMTagInformation(string, string2);
                break;
            }
            case 3: {
                EventGeneric eventGeneric2 = this.mPool.getEvent(44);
                if (eventGeneric2 != null) {
                    this.mPool.setString(45, "Deactivate in Active.HSM_START");
                    this.mTarget.transStateInactive();
                    break;
                }
                this.mPool.setString(45, "Successfully booted SDARS");
                EventGeneric eventGeneric3 = this.mPool.getEvent(43);
                if (eventGeneric3 != null) {
                    eventGeneric3.setBlocked(false);
                    eventGeneric3.setResult(0);
                    this.mTarget.sendBack(eventGeneric3);
                    this.mPool.setEvent(43, null);
                    break;
                }
                this.mPool.setBoolean(84, true);
                this.mTarget.transStateMainIdle();
                break;
            }
            case 4: {
                this.mPool.setBoolean(84, false);
                this.mTarget.stopTimer(-1383726848);
                this.mPool.setChannel(22, null);
                break;
            }
            case 100013: {
                break;
            }
            case 100241: {
                GuiApiTunerCommon.updateCurrentBand(RadioCurrentWaveband.get());
                try {
                    TileStationList tileStationList;
                    if (RadioCodingAdapter.isRadioTileFeatureActivated() && null != (tileStationList = RadioServiceManager.getServiceManager().getTileStationList())) {
                        tileStationList.initTiles();
                    }
                }
                catch (Exception exception) {
                    ServiceManager.errorHandler.handleError(exception);
                }
                eventGeneric.setBlocked(true);
                this.mPool.setEvent(43, eventGeneric);
                this.mTarget.transActivate();
                break;
            }
            case 100240: {
                this.mTarget.transStateInactive();
                eventGeneric.setResult(0);
                break;
            }
            case 4000021: {
                int n = eventGeneric.getInt(0);
                if (n == 2) {
                    this.mTarget.restartActivation();
                    this.getAudioManager().setAudioAvailable(true);
                    break;
                }
                if (n == 0 || n != 1) break;
                break;
            }
            case 0x4000044F: {
                StationInfo stationInfo;
                if (RadioServiceManager.getServiceManager().getTileStationList().isTileSVisible()) {
                    RadioServiceManager.getServiceManager().getTileStationList().activateStationInRadioTileList(true, 1170613248, -1);
                    break;
                }
                int n = this.mPool.getInt(35);
                if (n != 1 || (stationInfo = this.getMainChannelWalker().getNextChannel()) == null) break;
                this.getTuneHandler().tuneChannel(0x4F040040, stationInfo, false);
                break;
            }
            case 1073742930: {
                StationInfo stationInfo;
                if (RadioServiceManager.getServiceManager().getTileStationList().isTileSVisible()) {
                    RadioServiceManager.getServiceManager().getTileStationList().activateStationInRadioTileList(false, 1170613248, -1);
                    break;
                }
                int n = this.mPool.getInt(35);
                if (n != 1 || (stationInfo = this.getMainChannelWalker().getPreviousChannel()) == null) break;
                this.getTuneHandler().tuneChannel(1375993920, stationInfo, false);
                break;
            }
            case 1073742971: {
                StationInfo stationInfo = this.getMainChannelWalker().getNextChannel();
                if (stationInfo == null) break;
                this.getTuneHandler().tuneChannel(2063859776, stationInfo, false);
                break;
            }
            case 1073742974: {
                StationInfo stationInfo = this.getMainChannelWalker().getPreviousChannel();
                if (stationInfo == null) break;
                this.getTuneHandler().tuneChannel(2114191424, stationInfo, false);
                break;
            }
            case 0x4000044C: {
                StationInfo stationInfo;
                int n = (int)eventGeneric.getLong(0);
                if (n < 0 || (stationInfo = this.getChannels().getChannelBySID(n)) == null) break;
                if (stationInfo.subscription == 2) {
                    this.getTuneHandler().tuneChannel(19, stationInfo, false);
                    this.mDb.sendHmiEvent(215);
                    break;
                }
                this.mDb.sendHmiEvent(214);
                break;
            }
            case 1073743055: {
                boolean bl = this.mPool.getBoolean(51);
                if (!bl) {
                    if (ServiceManager.timerManager.getSystemTimeMillis() - this.mTimeForStorePreview < 0) {
                        this.getLogHandler().simpleTrace("Do not scan, preview tune happend freshly");
                        break;
                    }
                    this.mTarget.transStateMainScan();
                    break;
                }
                this.mPool.incInt(53);
                break;
            }
            case 1073744618: {
                if (!this.previewAllowed()) break;
                this.getPreviewHandler().handleDDS(-1);
                break;
            }
            case 1073744617: {
                if (!this.previewAllowed()) break;
                this.getPreviewHandler().handleDDS(1);
                break;
            }
            case 4300068: {
                boolean bl = this.mPool.getBoolean(51);
                if (!bl) break;
                int n = eventGeneric.getInt(0);
                this.mPool.setInt(52, n);
                break;
            }
            case 1073742947: {
                if (!this.previewAllowed()) break;
                this.mPool.setBoolean(149, true);
                break;
            }
            case 1073742973: {
                StationInfo stationInfo = this.mPool.getChannel(22);
                if (stationInfo == null) break;
                this.mDb.getTuneHandler().tuneChannel(11, stationInfo, false);
                this.mPool.setChannel(22, null);
                this.mTimeForStorePreview = ServiceManager.timerManager.getSystemTimeMillis();
                break;
            }
            case 1073742942: {
                this.mPool.setChannel(22, null);
                this.mPool.setBoolean(149, false);
                break;
            }
            case 1073742949: {
                int n = eventGeneric.getInt(0);
                this.mPool.setInt(151, n);
                break;
            }
            case 0x40000450: {
                StationInfo stationInfo = this.getMainChannelWalker().getNextChannel();
                if (stationInfo == null) break;
                this.getTuneHandler().tuneChannel(2, stationInfo, false);
                break;
            }
            case 1073742931: {
                StationInfo stationInfo = this.getMainChannelWalker().getPreviousChannel();
                if (stationInfo == null) break;
                this.getTuneHandler().tuneChannel(2, stationInfo, false);
                break;
            }
            case 1073744200: {
                int n = eventGeneric.getInt(0);
                this.mDb.getStationDescriptionHandler().selectIndex(n);
                break;
            }
            case 0x4000044E: {
                int n = this.mPool.getInt(150);
                StationInfo stationInfo = this.getMainChannelWalker().stepNextCategory(n);
                if (stationInfo == null) break;
                this.getTuneHandler().tuneChannel(12, stationInfo, false);
                break;
            }
            case 1073742929: {
                int n = this.mPool.getInt(150);
                StationInfo stationInfo = this.getMainChannelWalker().stepPreviousCategory(n);
                if (stationInfo == null) break;
                this.getTuneHandler().tuneChannel(12, stationInfo, false);
                break;
            }
            case 100012: {
                StationInfo stationInfo = this.mPool.getChannel(21);
                StationInfo stationInfo2 = this.mPool.getChannel(19);
                if (stationInfo2 == null || stationInfo == null || stationInfo.sID == stationInfo2.sID) break;
                this.mPool.setChannel(15, stationInfo);
                break;
            }
            case 100017: {
                this.mPool.incInt(74);
                break;
            }
            case 100022: {
                this.mTarget.transActivate2();
                break;
            }
            default: {
                hsmState = this.myParent;
            }
        }
        return hsmState;
    }
}

