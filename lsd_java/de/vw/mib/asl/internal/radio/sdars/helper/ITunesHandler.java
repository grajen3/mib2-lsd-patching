/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.radio.sdars.helper;

import de.vw.mib.asl.internal.radio.sdars.database.IAslPool;
import de.vw.mib.asl.internal.radio.sdars.database.IAslPoolListener;
import de.vw.mib.asl.internal.radio.sdars.database.IAslPoolRecord;
import de.vw.mib.asl.internal.radio.sdars.database.ObjectCompare;
import de.vw.mib.asl.internal.radio.sdars.helper.SatDb;
import de.vw.mib.asl.internal.radio.tagging.TaggingApi;
import de.vw.mib.log4mib.LogMessage;
import org.dsi.ifc.sdars.RadioText;
import org.dsi.ifc.sdars.StationInfo;

public final class ITunesHandler
implements IAslPoolListener {
    private final SatDb mDb;
    private final IAslPool mPool;
    private static final RadioText EMPTY = new RadioText();
    private long mDeliveredRadioTextHash = 0L;
    private StationInfo mDeliveredStation = null;
    private static final int CHANNELID;

    public ITunesHandler(SatDb satDb) {
        this.mDb = satDb;
        this.mPool = this.mDb.getPool();
        this.mPool.addListener(84, (IAslPoolListener)this);
        this.mPool.addListener(23, (IAslPoolListener)this);
        this.mPool.addListener(14, (IAslPoolListener)this);
        this.mPool.addListener(149, (IAslPoolListener)this);
        this.mPool.addListener(147, (IAslPoolListener)this);
    }

    public void reset() {
        this.updateChannel(null);
        this.updateRadioText(null);
    }

    public void updateTagging(StationInfo stationInfo) {
        this.updateChannel(stationInfo);
        if (stationInfo != null) {
            int n = stationInfo.getSID();
            if (n == 0) {
                this.updateRadioText(null);
            } else {
                RadioText radioText = this.mDb.getRadioTextHandler().get(n);
                this.updateRadioText(radioText);
            }
        } else {
            this.updateRadioText(null);
        }
    }

    private boolean checkEnvironment() {
        boolean bl = true;
        int n = this.mPool.getInt(147);
        boolean bl2 = this.mPool.getBoolean(149);
        boolean bl3 = this.mPool.getBoolean(84);
        if (bl3 && bl2 || n != 1) {
            LogMessage logMessage = this.mDb.getLogHandler().getLogMsg();
            if (logMessage != null) {
                logMessage.append("iTagging disabled due to environment (preview=").append(bl2).append(", tunerstate=").append(n).log();
            }
            bl = false;
        }
        return bl;
    }

    private void updateRadioText(RadioText radioText) {
        long l;
        RadioText radioText2 = radioText;
        if (radioText != null && !this.checkEnvironment()) {
            radioText2 = null;
        }
        if (radioText2 == null) {
            radioText2 = EMPTY;
        }
        if (this.mDeliveredRadioTextHash != (l = ObjectCompare.calcHash(radioText2))) {
            this.mDeliveredRadioTextHash = l;
            LogMessage logMessage = this.mDb.getLogHandler().getLogMsg();
            if (logMessage != null) {
                logMessage.append("iTunesUpdate RT=");
                if (radioText2 == EMPTY) {
                    logMessage.append("null");
                } else {
                    logMessage.append(radioText2.getSID());
                    logMessage.append(" - ");
                    logMessage.append(radioText2.getLongArtistName());
                    logMessage.append(" - ");
                    logMessage.append(radioText2.getLongProgramTitle());
                    logMessage.append(" - ");
                    logMessage.append(radioText2.getITunesID());
                }
                logMessage.log();
            }
            if (radioText2 == null) {
                TaggingApi.notifyRadioTextChange(new RadioText());
            } else {
                TaggingApi.notifyRadioTextChange(radioText2);
            }
        }
    }

    private void updateChannel(StationInfo stationInfo) {
        StationInfo stationInfo2 = stationInfo;
        if (stationInfo2 == this.mDeliveredStation) {
            return;
        }
        if (stationInfo2 == null || this.mDeliveredStation == null || this.mDeliveredStation.sID != stationInfo2.sID) {
            this.mDeliveredStation = stationInfo2;
            LogMessage logMessage = this.mDb.getLogHandler().getLogMsg();
            if (logMessage != null) {
                logMessage.append("iTunesUpdate Channel=");
                if (stationInfo2 == null) {
                    logMessage.append("null");
                } else {
                    logMessage.append(stationInfo2.getStationNumber());
                    logMessage.append(" - ");
                    logMessage.append(stationInfo2.getFullLabel());
                }
                logMessage.log();
            }
            TaggingApi.notifyChannelTuned(stationInfo2);
        }
    }

    @Override
    public void notifyUpdate(IAslPool iAslPool, int n, IAslPoolRecord iAslPoolRecord) {
        switch (n) {
            case 147: {
                StationInfo stationInfo = iAslPool.getChannel(23);
                this.mDeliveredRadioTextHash = 0L;
                this.mDeliveredStation = null;
                this.updateTagging(stationInfo);
                break;
            }
            case 84: {
                boolean bl = iAslPoolRecord.getBoolean();
                if (!bl) break;
                StationInfo stationInfo = iAslPool.getChannel(23);
                this.mDeliveredRadioTextHash = 0L;
                this.mDeliveredStation = null;
                this.updateTagging(stationInfo);
                break;
            }
            case 23: {
                boolean bl = iAslPool.getBoolean(84);
                if (!bl) break;
                StationInfo stationInfo = iAslPoolRecord.getChannel();
                this.updateTagging(stationInfo);
                break;
            }
            case 14: {
                boolean bl = iAslPool.getBoolean(84);
                if (!bl) break;
                StationInfo stationInfo = iAslPool.getChannel(23);
                RadioText radioText = iAslPool.getRadioText(14);
                if (stationInfo == null || radioText == null || stationInfo.getSID() != radioText.getSID()) break;
                this.updateRadioText(radioText);
                break;
            }
            case 149: {
                if (iAslPoolRecord.getUpdateCount() <= 1) break;
                boolean bl = iAslPoolRecord.getBoolean();
                if (bl) {
                    this.reset();
                    break;
                }
                StationInfo stationInfo = iAslPool.getChannel(23);
                this.updateTagging(stationInfo);
                break;
            }
        }
    }
}

