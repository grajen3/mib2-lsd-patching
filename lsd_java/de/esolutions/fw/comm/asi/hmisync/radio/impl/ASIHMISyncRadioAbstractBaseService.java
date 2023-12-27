/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.hmisync.radio.impl;

import de.esolutions.fw.comm.asi.hmisync.radio.ASIHMISyncRadioReply;
import de.esolutions.fw.comm.asi.hmisync.radio.ASIHMISyncRadioS;
import de.esolutions.fw.comm.asi.hmisync.radio.CurrentStation;
import de.esolutions.fw.comm.asi.hmisync.radio.StationInfo;
import de.esolutions.fw.comm.asi.hmisync.radio.WavebandInfo;
import de.esolutions.fw.comm.asi.hmisync.radio.impl.ASIHMISyncRadioAbstractBaseService$AttributesBitMapProvider;
import de.esolutions.fw.comm.attributes.AttributesBaseService;
import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.method.MethodException;
import java.util.Iterator;
import java.util.List;

public abstract class ASIHMISyncRadioAbstractBaseService
implements ASIHMISyncRadioS {
    private static final CallContext context = CallContext.getContext("ABSTRACTBASESERVICE.asi.hmisync.radio.ASIHMISyncRadio");
    private static final int attributesCount;
    private String ASIVersion;
    private boolean ASIVersion_valid = false;
    private short[] RequestIDs;
    private boolean RequestIDs_valid = false;
    private short[] ReplyIDs;
    private boolean ReplyIDs_valid = false;
    private int[] BandList;
    private boolean BandList_valid = false;
    private int ActiveBand;
    private boolean ActiveBand_valid = false;
    private StationInfo[] RadioStationList;
    private boolean RadioStationList_valid = false;
    private CurrentStation ActiveStation;
    private boolean ActiveStation_valid = false;
    private int SeekStatus;
    private boolean SeekStatus_valid = false;
    private WavebandInfo[] Wavebands;
    private boolean Wavebands_valid = false;
    private AttributesBaseService baseService;

    public static String copyString(String string) {
        if (string != null) {
            return new String(string);
        }
        return null;
    }

    public static StationInfo copyStationInfo(StationInfo stationInfo) {
        if (stationInfo == null) {
            return null;
        }
        StationInfo stationInfo2 = new StationInfo();
        stationInfo2.id = stationInfo.id;
        stationInfo2.name = ASIHMISyncRadioAbstractBaseService.copyString(stationInfo.name);
        stationInfo2.fullName = ASIHMISyncRadioAbstractBaseService.copyString(stationInfo.fullName);
        stationInfo2.audioStatus = stationInfo.audioStatus;
        stationInfo2.layer = stationInfo.layer;
        stationInfo2.stationLogo = ASIHMISyncRadioAbstractBaseService.copyString(stationInfo.stationLogo);
        stationInfo2.frequency = stationInfo.frequency;
        stationInfo2.extension = ASIHMISyncRadioAbstractBaseService.copyString(stationInfo.extension);
        return stationInfo2;
    }

    public static CurrentStation copyCurrentStation(CurrentStation currentStation) {
        if (currentStation == null) {
            return null;
        }
        CurrentStation currentStation2 = new CurrentStation();
        currentStation2.id = currentStation.id;
        currentStation2.name = ASIHMISyncRadioAbstractBaseService.copyString(currentStation.name);
        currentStation2.fullName = ASIHMISyncRadioAbstractBaseService.copyString(currentStation.fullName);
        currentStation2.artist = ASIHMISyncRadioAbstractBaseService.copyString(currentStation.artist);
        currentStation2.artistType = currentStation.artistType;
        currentStation2.title = ASIHMISyncRadioAbstractBaseService.copyString(currentStation.title);
        currentStation2.titleType = currentStation.titleType;
        currentStation2.image = ASIHMISyncRadioAbstractBaseService.copyString(currentStation.image);
        currentStation2.audioStatus = currentStation.audioStatus;
        currentStation2.layer = currentStation.layer;
        currentStation2.album = ASIHMISyncRadioAbstractBaseService.copyString(currentStation.album);
        currentStation2.radioText = ASIHMISyncRadioAbstractBaseService.copyString(currentStation.radioText);
        currentStation2.extension = ASIHMISyncRadioAbstractBaseService.copyString(currentStation.extension);
        return currentStation2;
    }

    public static WavebandInfo copyWavebandInfo(WavebandInfo wavebandInfo) {
        if (wavebandInfo == null) {
            return null;
        }
        WavebandInfo wavebandInfo2 = new WavebandInfo();
        wavebandInfo2.bandId = wavebandInfo.bandId;
        wavebandInfo2.minFrequency = wavebandInfo.minFrequency;
        wavebandInfo2.maxFrequency = wavebandInfo.maxFrequency;
        wavebandInfo2.stepWidth = wavebandInfo.stepWidth;
        return wavebandInfo2;
    }

    public ASIHMISyncRadioAbstractBaseService() {
        ASIHMISyncRadioAbstractBaseService$AttributesBitMapProvider aSIHMISyncRadioAbstractBaseService$AttributesBitMapProvider = new ASIHMISyncRadioAbstractBaseService$AttributesBitMapProvider();
        this.baseService = new AttributesBaseService("ASIHMISyncRadio", aSIHMISyncRadioAbstractBaseService$AttributesBitMapProvider);
    }

    @Override
    public synchronized void setNotification(long l, ASIHMISyncRadioReply aSIHMISyncRadioReply) {
        this.baseService.setNotification(l, (Object)aSIHMISyncRadioReply);
        this.sendAttributeUpdate(l, aSIHMISyncRadioReply);
    }

    @Override
    public synchronized void setNotification(ASIHMISyncRadioReply aSIHMISyncRadioReply) {
        this.baseService.setNotification(aSIHMISyncRadioReply);
        this.sendAttributeUpdate(aSIHMISyncRadioReply);
    }

    @Override
    public synchronized void setNotification(long[] lArray, ASIHMISyncRadioReply aSIHMISyncRadioReply) {
        this.baseService.setNotification(lArray, (Object)aSIHMISyncRadioReply);
        this.sendAttributeUpdate(lArray, aSIHMISyncRadioReply);
    }

    @Override
    public synchronized void clearNotification(long l, ASIHMISyncRadioReply aSIHMISyncRadioReply) {
        this.baseService.clearNotification(l, (Object)aSIHMISyncRadioReply);
    }

    @Override
    public synchronized void clearNotification(ASIHMISyncRadioReply aSIHMISyncRadioReply) {
        this.baseService.clearNotification(aSIHMISyncRadioReply);
    }

    @Override
    public synchronized void clearNotification(long[] lArray, ASIHMISyncRadioReply aSIHMISyncRadioReply) {
        this.baseService.clearNotification(lArray, (Object)aSIHMISyncRadioReply);
    }

    private void sendAttributeUpdate(ASIHMISyncRadioReply aSIHMISyncRadioReply) {
        try {
            aSIHMISyncRadioReply.updateASIVersion(this.ASIVersion, this.ASIVersion_valid);
            aSIHMISyncRadioReply.updateRequestIDs(this.RequestIDs, this.RequestIDs_valid);
            aSIHMISyncRadioReply.updateReplyIDs(this.ReplyIDs, this.ReplyIDs_valid);
            aSIHMISyncRadioReply.updateBandList(this.BandList, this.BandList_valid);
            aSIHMISyncRadioReply.updateActiveBand(this.ActiveBand, this.ActiveBand_valid);
            aSIHMISyncRadioReply.updateRadioStationList(this.RadioStationList, this.RadioStationList_valid);
            aSIHMISyncRadioReply.updateActiveStation(this.ActiveStation, this.ActiveStation_valid);
            aSIHMISyncRadioReply.updateSeekStatus(this.SeekStatus, this.SeekStatus_valid);
            aSIHMISyncRadioReply.updateWavebands(this.Wavebands, this.Wavebands_valid);
        }
        catch (MethodException methodException) {
            // empty catch block
        }
    }

    private void sendAttributeUpdate(long[] lArray, ASIHMISyncRadioReply aSIHMISyncRadioReply) {
        for (int i2 = 0; i2 < lArray.length; ++i2) {
            this.sendAttributeUpdate(lArray[i2], aSIHMISyncRadioReply);
        }
    }

    private void sendAttributeUpdate(long l, ASIHMISyncRadioReply aSIHMISyncRadioReply) {
        try {
            if (l == 0) {
                aSIHMISyncRadioReply.updateASIVersion(this.ASIVersion, this.ASIVersion_valid);
            } else if (l == 0) {
                aSIHMISyncRadioReply.updateRequestIDs(this.RequestIDs, this.RequestIDs_valid);
            } else if (l == 0) {
                aSIHMISyncRadioReply.updateReplyIDs(this.ReplyIDs, this.ReplyIDs_valid);
            } else if (l == 0) {
                aSIHMISyncRadioReply.updateBandList(this.BandList, this.BandList_valid);
            } else if (l == 0) {
                aSIHMISyncRadioReply.updateActiveBand(this.ActiveBand, this.ActiveBand_valid);
            } else if (l == 0) {
                aSIHMISyncRadioReply.updateRadioStationList(this.RadioStationList, this.RadioStationList_valid);
            } else if (l == 0) {
                aSIHMISyncRadioReply.updateActiveStation(this.ActiveStation, this.ActiveStation_valid);
            } else if (l == 0) {
                aSIHMISyncRadioReply.updateSeekStatus(this.SeekStatus, this.SeekStatus_valid);
            } else if (l == 0) {
                aSIHMISyncRadioReply.updateWavebands(this.Wavebands, this.Wavebands_valid);
            } else {
                System.out.println("unexpected");
            }
        }
        catch (MethodException methodException) {
            // empty catch block
        }
    }

    public void updateASIVersion(String string) {
        this.updateASIVersion(string, true);
    }

    public void updateASIVersion(String string, boolean bl) {
        this.ASIVersion = ASIHMISyncRadioAbstractBaseService.copyString(string);
        this.ASIVersion_valid = bl;
        List list = this.baseService.getNotifications(11);
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            ASIHMISyncRadioReply aSIHMISyncRadioReply = (ASIHMISyncRadioReply)iterator.next();
            try {
                aSIHMISyncRadioReply.updateASIVersion(string, bl);
            }
            catch (MethodException methodException) {}
        }
    }

    public void updateRequestIDs(short[] sArray) {
        this.updateRequestIDs(sArray, true);
    }

    public void updateRequestIDs(short[] sArray, boolean bl) {
        if (sArray != null) {
            this.RequestIDs = new short[sArray.length];
            System.arraycopy((Object)sArray, 0, (Object)this.RequestIDs, 0, sArray.length);
        } else {
            this.RequestIDs = null;
        }
        this.RequestIDs_valid = bl;
        List list = this.baseService.getNotifications(18);
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            ASIHMISyncRadioReply aSIHMISyncRadioReply = (ASIHMISyncRadioReply)iterator.next();
            try {
                aSIHMISyncRadioReply.updateRequestIDs(sArray, bl);
            }
            catch (MethodException methodException) {}
        }
    }

    public void updateReplyIDs(short[] sArray) {
        this.updateReplyIDs(sArray, true);
    }

    public void updateReplyIDs(short[] sArray, boolean bl) {
        if (sArray != null) {
            this.ReplyIDs = new short[sArray.length];
            System.arraycopy((Object)sArray, 0, (Object)this.ReplyIDs, 0, sArray.length);
        } else {
            this.ReplyIDs = null;
        }
        this.ReplyIDs_valid = bl;
        List list = this.baseService.getNotifications(17);
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            ASIHMISyncRadioReply aSIHMISyncRadioReply = (ASIHMISyncRadioReply)iterator.next();
            try {
                aSIHMISyncRadioReply.updateReplyIDs(sArray, bl);
            }
            catch (MethodException methodException) {}
        }
    }

    public void updateBandList(int[] nArray) {
        this.updateBandList(nArray, true);
    }

    public void updateBandList(int[] nArray, boolean bl) {
        if (nArray != null) {
            this.BandList = new int[nArray.length];
            System.arraycopy((Object)nArray, 0, (Object)this.BandList, 0, nArray.length);
        } else {
            this.BandList = null;
        }
        this.BandList_valid = bl;
        List list = this.baseService.getNotifications(14);
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            ASIHMISyncRadioReply aSIHMISyncRadioReply = (ASIHMISyncRadioReply)iterator.next();
            try {
                aSIHMISyncRadioReply.updateBandList(nArray, bl);
            }
            catch (MethodException methodException) {}
        }
    }

    public void updateActiveBand(int n) {
        this.updateActiveBand(n, true);
    }

    public void updateActiveBand(int n, boolean bl) {
        this.ActiveBand = n;
        this.ActiveBand_valid = bl;
        List list = this.baseService.getNotifications(12);
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            ASIHMISyncRadioReply aSIHMISyncRadioReply = (ASIHMISyncRadioReply)iterator.next();
            try {
                aSIHMISyncRadioReply.updateActiveBand(n, bl);
            }
            catch (MethodException methodException) {}
        }
    }

    public void updateRadioStationList(StationInfo[] stationInfoArray) {
        this.updateRadioStationList(stationInfoArray, true);
    }

    public void updateRadioStationList(StationInfo[] stationInfoArray, boolean bl) {
        if (stationInfoArray != null) {
            this.RadioStationList = new StationInfo[stationInfoArray.length];
            for (int i2 = 0; i2 < stationInfoArray.length; ++i2) {
                this.RadioStationList[i2] = ASIHMISyncRadioAbstractBaseService.copyStationInfo(stationInfoArray[i2]);
            }
        } else {
            this.RadioStationList = null;
        }
        this.RadioStationList_valid = bl;
        List list = this.baseService.getNotifications(22);
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            ASIHMISyncRadioReply aSIHMISyncRadioReply = (ASIHMISyncRadioReply)iterator.next();
            try {
                aSIHMISyncRadioReply.updateRadioStationList(stationInfoArray, bl);
            }
            catch (MethodException methodException) {}
        }
    }

    public void updateActiveStation(CurrentStation currentStation) {
        this.updateActiveStation(currentStation, true);
    }

    public void updateActiveStation(CurrentStation currentStation, boolean bl) {
        this.ActiveStation = ASIHMISyncRadioAbstractBaseService.copyCurrentStation(currentStation);
        this.ActiveStation_valid = bl;
        List list = this.baseService.getNotifications(21);
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            ASIHMISyncRadioReply aSIHMISyncRadioReply = (ASIHMISyncRadioReply)iterator.next();
            try {
                aSIHMISyncRadioReply.updateActiveStation(currentStation, bl);
            }
            catch (MethodException methodException) {}
        }
    }

    public void updateSeekStatus(int n) {
        this.updateSeekStatus(n, true);
    }

    public void updateSeekStatus(int n, boolean bl) {
        this.SeekStatus = n;
        this.SeekStatus_valid = bl;
        List list = this.baseService.getNotifications(16);
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            ASIHMISyncRadioReply aSIHMISyncRadioReply = (ASIHMISyncRadioReply)iterator.next();
            try {
                aSIHMISyncRadioReply.updateSeekStatus(n, bl);
            }
            catch (MethodException methodException) {}
        }
    }

    public void updateWavebands(WavebandInfo[] wavebandInfoArray) {
        this.updateWavebands(wavebandInfoArray, true);
    }

    public void updateWavebands(WavebandInfo[] wavebandInfoArray, boolean bl) {
        if (wavebandInfoArray != null) {
            this.Wavebands = new WavebandInfo[wavebandInfoArray.length];
            for (int i2 = 0; i2 < wavebandInfoArray.length; ++i2) {
                this.Wavebands[i2] = ASIHMISyncRadioAbstractBaseService.copyWavebandInfo(wavebandInfoArray[i2]);
            }
        } else {
            this.Wavebands = null;
        }
        this.Wavebands_valid = bl;
        List list = this.baseService.getNotifications(19);
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            ASIHMISyncRadioReply aSIHMISyncRadioReply = (ASIHMISyncRadioReply)iterator.next();
            try {
                aSIHMISyncRadioReply.updateWavebands(wavebandInfoArray, bl);
            }
            catch (MethodException methodException) {}
        }
    }
}

