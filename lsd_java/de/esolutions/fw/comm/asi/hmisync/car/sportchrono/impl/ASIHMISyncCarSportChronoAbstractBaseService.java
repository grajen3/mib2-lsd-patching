/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.hmisync.car.sportchrono.impl;

import de.esolutions.fw.comm.asi.hmisync.car.sportchrono.ASIHMISyncCarSportChronoReply;
import de.esolutions.fw.comm.asi.hmisync.car.sportchrono.ASIHMISyncCarSportChronoS;
import de.esolutions.fw.comm.asi.hmisync.car.sportchrono.RecordingRange;
import de.esolutions.fw.comm.asi.hmisync.car.sportchrono.SCData;
import de.esolutions.fw.comm.asi.hmisync.car.sportchrono.SCHeader;
import de.esolutions.fw.comm.asi.hmisync.car.sportchrono.SCRefLapHeader;
import de.esolutions.fw.comm.asi.hmisync.car.sportchrono.TransferState;
import de.esolutions.fw.comm.asi.hmisync.car.sportchrono.impl.ASIHMISyncCarSportChronoAbstractBaseService$AttributesBitMapProvider;
import de.esolutions.fw.comm.attributes.AttributesBaseService;
import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.method.MethodException;
import java.util.Iterator;
import java.util.List;

public abstract class ASIHMISyncCarSportChronoAbstractBaseService
implements ASIHMISyncCarSportChronoS {
    private static final CallContext context = CallContext.getContext("ABSTRACTBASESERVICE.asi.hmisync.car.sportchrono.ASIHMISyncCarSportChrono");
    private static final int attributesCount;
    private String ASIVersion;
    private boolean ASIVersion_valid = false;
    private short[] RequestIDs;
    private boolean RequestIDs_valid = false;
    private short[] ReplyIDs;
    private boolean ReplyIDs_valid = false;
    private int SCVisibilityState;
    private boolean SCVisibilityState_valid = false;
    private SCHeader ActiveRecord;
    private boolean ActiveRecord_valid = false;
    private SCData ActiveRecordData;
    private boolean ActiveRecordData_valid = false;
    private int RecordMode;
    private boolean RecordMode_valid = false;
    private SCHeader[] TrackList;
    private boolean TrackList_valid = false;
    private TransferState TransferState;
    private boolean TransferState_valid = false;
    private long RecordingTime;
    private boolean RecordingTime_valid = false;
    private RecordingRange RecordingRange;
    private boolean RecordingRange_valid = false;
    private int SelectedReferenceLapUid;
    private boolean SelectedReferenceLapUid_valid = false;
    private SCRefLapHeader[] ReferenceLapList;
    private boolean ReferenceLapList_valid = false;
    private AttributesBaseService baseService;

    public static String copyString(String string) {
        if (string != null) {
            return new String(string);
        }
        return null;
    }

    public static SCHeader copySCHeader(SCHeader sCHeader) {
        if (sCHeader == null) {
            return null;
        }
        SCHeader sCHeader2 = new SCHeader();
        sCHeader2.uid = sCHeader.uid;
        sCHeader2.numOfRecords = sCHeader.numOfRecords;
        if (sCHeader.header != null) {
            sCHeader2.header = new byte[sCHeader.header.length];
            System.arraycopy((Object)sCHeader.header, 0, (Object)sCHeader2.header, 0, sCHeader2.header.length);
        } else {
            sCHeader2.header = null;
        }
        return sCHeader2;
    }

    public static SCData copySCData(SCData sCData) {
        if (sCData == null) {
            return null;
        }
        SCData sCData2 = new SCData();
        sCData2.uid = sCData.uid;
        if (sCData.data != null) {
            sCData2.data = new byte[sCData.data.length];
            System.arraycopy((Object)sCData.data, 0, (Object)sCData2.data, 0, sCData2.data.length);
        } else {
            sCData2.data = null;
        }
        return sCData2;
    }

    public static TransferState copyTransferState(TransferState transferState) {
        if (transferState == null) {
            return null;
        }
        TransferState transferState2 = new TransferState();
        transferState2.state = transferState.state;
        transferState2.deviceId = ASIHMISyncCarSportChronoAbstractBaseService.copyString(transferState.deviceId);
        return transferState2;
    }

    public static RecordingRange copyRecordingRange(RecordingRange recordingRange) {
        if (recordingRange == null) {
            return null;
        }
        RecordingRange recordingRange2 = new RecordingRange();
        recordingRange2.remainingRange = recordingRange.remainingRange;
        recordingRange2.remainingLaps = recordingRange.remainingLaps;
        return recordingRange2;
    }

    public static SCRefLapHeader copySCRefLapHeader(SCRefLapHeader sCRefLapHeader) {
        if (sCRefLapHeader == null) {
            return null;
        }
        SCRefLapHeader sCRefLapHeader2 = new SCRefLapHeader();
        sCRefLapHeader2.uid = sCRefLapHeader.uid;
        sCRefLapHeader2.numOfRecords = sCRefLapHeader.numOfRecords;
        if (sCRefLapHeader.header != null) {
            sCRefLapHeader2.header = new byte[sCRefLapHeader.header.length];
            System.arraycopy((Object)sCRefLapHeader.header, 0, (Object)sCRefLapHeader2.header, 0, sCRefLapHeader2.header.length);
        } else {
            sCRefLapHeader2.header = null;
        }
        return sCRefLapHeader2;
    }

    public ASIHMISyncCarSportChronoAbstractBaseService() {
        ASIHMISyncCarSportChronoAbstractBaseService$AttributesBitMapProvider aSIHMISyncCarSportChronoAbstractBaseService$AttributesBitMapProvider = new ASIHMISyncCarSportChronoAbstractBaseService$AttributesBitMapProvider();
        this.baseService = new AttributesBaseService("ASIHMISyncCarSportChrono", aSIHMISyncCarSportChronoAbstractBaseService$AttributesBitMapProvider);
    }

    @Override
    public synchronized void setNotification(long l, ASIHMISyncCarSportChronoReply aSIHMISyncCarSportChronoReply) {
        this.baseService.setNotification(l, (Object)aSIHMISyncCarSportChronoReply);
        this.sendAttributeUpdate(l, aSIHMISyncCarSportChronoReply);
    }

    @Override
    public synchronized void setNotification(ASIHMISyncCarSportChronoReply aSIHMISyncCarSportChronoReply) {
        this.baseService.setNotification(aSIHMISyncCarSportChronoReply);
        this.sendAttributeUpdate(aSIHMISyncCarSportChronoReply);
    }

    @Override
    public synchronized void setNotification(long[] lArray, ASIHMISyncCarSportChronoReply aSIHMISyncCarSportChronoReply) {
        this.baseService.setNotification(lArray, (Object)aSIHMISyncCarSportChronoReply);
        this.sendAttributeUpdate(lArray, aSIHMISyncCarSportChronoReply);
    }

    @Override
    public synchronized void clearNotification(long l, ASIHMISyncCarSportChronoReply aSIHMISyncCarSportChronoReply) {
        this.baseService.clearNotification(l, (Object)aSIHMISyncCarSportChronoReply);
    }

    @Override
    public synchronized void clearNotification(ASIHMISyncCarSportChronoReply aSIHMISyncCarSportChronoReply) {
        this.baseService.clearNotification(aSIHMISyncCarSportChronoReply);
    }

    @Override
    public synchronized void clearNotification(long[] lArray, ASIHMISyncCarSportChronoReply aSIHMISyncCarSportChronoReply) {
        this.baseService.clearNotification(lArray, (Object)aSIHMISyncCarSportChronoReply);
    }

    private void sendAttributeUpdate(ASIHMISyncCarSportChronoReply aSIHMISyncCarSportChronoReply) {
        try {
            aSIHMISyncCarSportChronoReply.updateASIVersion(this.ASIVersion, this.ASIVersion_valid);
            aSIHMISyncCarSportChronoReply.updateRequestIDs(this.RequestIDs, this.RequestIDs_valid);
            aSIHMISyncCarSportChronoReply.updateReplyIDs(this.ReplyIDs, this.ReplyIDs_valid);
            aSIHMISyncCarSportChronoReply.updateSCVisibilityState(this.SCVisibilityState, this.SCVisibilityState_valid);
            aSIHMISyncCarSportChronoReply.updateActiveRecord(this.ActiveRecord, this.ActiveRecord_valid);
            aSIHMISyncCarSportChronoReply.updateActiveRecordData(this.ActiveRecordData, this.ActiveRecordData_valid);
            aSIHMISyncCarSportChronoReply.updateRecordMode(this.RecordMode, this.RecordMode_valid);
            aSIHMISyncCarSportChronoReply.updateTrackList(this.TrackList, this.TrackList_valid);
            aSIHMISyncCarSportChronoReply.updateTransferState(this.TransferState, this.TransferState_valid);
            aSIHMISyncCarSportChronoReply.updateRecordingTime(this.RecordingTime, this.RecordingTime_valid);
            aSIHMISyncCarSportChronoReply.updateRecordingRange(this.RecordingRange, this.RecordingRange_valid);
            aSIHMISyncCarSportChronoReply.updateSelectedReferenceLapUid(this.SelectedReferenceLapUid, this.SelectedReferenceLapUid_valid);
            aSIHMISyncCarSportChronoReply.updateReferenceLapList(this.ReferenceLapList, this.ReferenceLapList_valid);
        }
        catch (MethodException methodException) {
            // empty catch block
        }
    }

    private void sendAttributeUpdate(long[] lArray, ASIHMISyncCarSportChronoReply aSIHMISyncCarSportChronoReply) {
        for (int i2 = 0; i2 < lArray.length; ++i2) {
            this.sendAttributeUpdate(lArray[i2], aSIHMISyncCarSportChronoReply);
        }
    }

    private void sendAttributeUpdate(long l, ASIHMISyncCarSportChronoReply aSIHMISyncCarSportChronoReply) {
        try {
            if (l == 0) {
                aSIHMISyncCarSportChronoReply.updateASIVersion(this.ASIVersion, this.ASIVersion_valid);
            } else if (l == 0) {
                aSIHMISyncCarSportChronoReply.updateRequestIDs(this.RequestIDs, this.RequestIDs_valid);
            } else if (l == 0) {
                aSIHMISyncCarSportChronoReply.updateReplyIDs(this.ReplyIDs, this.ReplyIDs_valid);
            } else if (l == 0) {
                aSIHMISyncCarSportChronoReply.updateSCVisibilityState(this.SCVisibilityState, this.SCVisibilityState_valid);
            } else if (l == 0) {
                aSIHMISyncCarSportChronoReply.updateActiveRecord(this.ActiveRecord, this.ActiveRecord_valid);
            } else if (l == 0) {
                aSIHMISyncCarSportChronoReply.updateActiveRecordData(this.ActiveRecordData, this.ActiveRecordData_valid);
            } else if (l == 0) {
                aSIHMISyncCarSportChronoReply.updateRecordMode(this.RecordMode, this.RecordMode_valid);
            } else if (l == 0) {
                aSIHMISyncCarSportChronoReply.updateTrackList(this.TrackList, this.TrackList_valid);
            } else if (l == 0) {
                aSIHMISyncCarSportChronoReply.updateTransferState(this.TransferState, this.TransferState_valid);
            } else if (l == 0) {
                aSIHMISyncCarSportChronoReply.updateRecordingTime(this.RecordingTime, this.RecordingTime_valid);
            } else if (l == 0) {
                aSIHMISyncCarSportChronoReply.updateRecordingRange(this.RecordingRange, this.RecordingRange_valid);
            } else if (l == 0) {
                aSIHMISyncCarSportChronoReply.updateSelectedReferenceLapUid(this.SelectedReferenceLapUid, this.SelectedReferenceLapUid_valid);
            } else if (l == 0) {
                aSIHMISyncCarSportChronoReply.updateReferenceLapList(this.ReferenceLapList, this.ReferenceLapList_valid);
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
        this.ASIVersion = ASIHMISyncCarSportChronoAbstractBaseService.copyString(string);
        this.ASIVersion_valid = bl;
        List list = this.baseService.getNotifications(15);
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            ASIHMISyncCarSportChronoReply aSIHMISyncCarSportChronoReply = (ASIHMISyncCarSportChronoReply)iterator.next();
            try {
                aSIHMISyncCarSportChronoReply.updateASIVersion(string, bl);
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
        List list = this.baseService.getNotifications(20);
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            ASIHMISyncCarSportChronoReply aSIHMISyncCarSportChronoReply = (ASIHMISyncCarSportChronoReply)iterator.next();
            try {
                aSIHMISyncCarSportChronoReply.updateRequestIDs(sArray, bl);
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
        List list = this.baseService.getNotifications(19);
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            ASIHMISyncCarSportChronoReply aSIHMISyncCarSportChronoReply = (ASIHMISyncCarSportChronoReply)iterator.next();
            try {
                aSIHMISyncCarSportChronoReply.updateReplyIDs(sArray, bl);
            }
            catch (MethodException methodException) {}
        }
    }

    public void updateSCVisibilityState(int n) {
        this.updateSCVisibilityState(n, true);
    }

    public void updateSCVisibilityState(int n, boolean bl) {
        this.SCVisibilityState = n;
        this.SCVisibilityState_valid = bl;
        List list = this.baseService.getNotifications(21);
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            ASIHMISyncCarSportChronoReply aSIHMISyncCarSportChronoReply = (ASIHMISyncCarSportChronoReply)iterator.next();
            try {
                aSIHMISyncCarSportChronoReply.updateSCVisibilityState(n, bl);
            }
            catch (MethodException methodException) {}
        }
    }

    public void updateActiveRecord(SCHeader sCHeader) {
        this.updateActiveRecord(sCHeader, true);
    }

    public void updateActiveRecord(SCHeader sCHeader, boolean bl) {
        this.ActiveRecord = ASIHMISyncCarSportChronoAbstractBaseService.copySCHeader(sCHeader);
        this.ActiveRecord_valid = bl;
        List list = this.baseService.getNotifications(16);
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            ASIHMISyncCarSportChronoReply aSIHMISyncCarSportChronoReply = (ASIHMISyncCarSportChronoReply)iterator.next();
            try {
                aSIHMISyncCarSportChronoReply.updateActiveRecord(sCHeader, bl);
            }
            catch (MethodException methodException) {}
        }
    }

    public void updateActiveRecordData(SCData sCData) {
        this.updateActiveRecordData(sCData, true);
    }

    public void updateActiveRecordData(SCData sCData, boolean bl) {
        this.ActiveRecordData = ASIHMISyncCarSportChronoAbstractBaseService.copySCData(sCData);
        this.ActiveRecordData_valid = bl;
        List list = this.baseService.getNotifications(17);
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            ASIHMISyncCarSportChronoReply aSIHMISyncCarSportChronoReply = (ASIHMISyncCarSportChronoReply)iterator.next();
            try {
                aSIHMISyncCarSportChronoReply.updateActiveRecordData(sCData, bl);
            }
            catch (MethodException methodException) {}
        }
    }

    public void updateRecordMode(int n) {
        this.updateRecordMode(n, true);
    }

    public void updateRecordMode(int n, boolean bl) {
        this.RecordMode = n;
        this.RecordMode_valid = bl;
        List list = this.baseService.getNotifications(18);
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            ASIHMISyncCarSportChronoReply aSIHMISyncCarSportChronoReply = (ASIHMISyncCarSportChronoReply)iterator.next();
            try {
                aSIHMISyncCarSportChronoReply.updateRecordMode(n, bl);
            }
            catch (MethodException methodException) {}
        }
    }

    public void updateTrackList(SCHeader[] sCHeaderArray) {
        this.updateTrackList(sCHeaderArray, true);
    }

    public void updateTrackList(SCHeader[] sCHeaderArray, boolean bl) {
        if (sCHeaderArray != null) {
            this.TrackList = new SCHeader[sCHeaderArray.length];
            for (int i2 = 0; i2 < sCHeaderArray.length; ++i2) {
                this.TrackList[i2] = ASIHMISyncCarSportChronoAbstractBaseService.copySCHeader(sCHeaderArray[i2]);
            }
        } else {
            this.TrackList = null;
        }
        this.TrackList_valid = bl;
        List list = this.baseService.getNotifications(22);
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            ASIHMISyncCarSportChronoReply aSIHMISyncCarSportChronoReply = (ASIHMISyncCarSportChronoReply)iterator.next();
            try {
                aSIHMISyncCarSportChronoReply.updateTrackList(sCHeaderArray, bl);
            }
            catch (MethodException methodException) {}
        }
    }

    public void updateTransferState(TransferState transferState) {
        this.updateTransferState(transferState, true);
    }

    public void updateTransferState(TransferState transferState, boolean bl) {
        this.TransferState = ASIHMISyncCarSportChronoAbstractBaseService.copyTransferState(transferState);
        this.TransferState_valid = bl;
        List list = this.baseService.getNotifications(23);
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            ASIHMISyncCarSportChronoReply aSIHMISyncCarSportChronoReply = (ASIHMISyncCarSportChronoReply)iterator.next();
            try {
                aSIHMISyncCarSportChronoReply.updateTransferState(transferState, bl);
            }
            catch (MethodException methodException) {}
        }
    }

    public void updateRecordingTime(long l) {
        this.updateRecordingTime(l, true);
    }

    public void updateRecordingTime(long l, boolean bl) {
        this.RecordingTime = l;
        this.RecordingTime_valid = bl;
        List list = this.baseService.getNotifications(25);
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            ASIHMISyncCarSportChronoReply aSIHMISyncCarSportChronoReply = (ASIHMISyncCarSportChronoReply)iterator.next();
            try {
                aSIHMISyncCarSportChronoReply.updateRecordingTime(l, bl);
            }
            catch (MethodException methodException) {}
        }
    }

    public void updateRecordingRange(RecordingRange recordingRange) {
        this.updateRecordingRange(recordingRange, true);
    }

    public void updateRecordingRange(RecordingRange recordingRange, boolean bl) {
        this.RecordingRange = ASIHMISyncCarSportChronoAbstractBaseService.copyRecordingRange(recordingRange);
        this.RecordingRange_valid = bl;
        List list = this.baseService.getNotifications(24);
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            ASIHMISyncCarSportChronoReply aSIHMISyncCarSportChronoReply = (ASIHMISyncCarSportChronoReply)iterator.next();
            try {
                aSIHMISyncCarSportChronoReply.updateRecordingRange(recordingRange, bl);
            }
            catch (MethodException methodException) {}
        }
    }

    public void updateSelectedReferenceLapUid(int n) {
        this.updateSelectedReferenceLapUid(n, true);
    }

    public void updateSelectedReferenceLapUid(int n, boolean bl) {
        this.SelectedReferenceLapUid = n;
        this.SelectedReferenceLapUid_valid = bl;
        List list = this.baseService.getNotifications(33);
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            ASIHMISyncCarSportChronoReply aSIHMISyncCarSportChronoReply = (ASIHMISyncCarSportChronoReply)iterator.next();
            try {
                aSIHMISyncCarSportChronoReply.updateSelectedReferenceLapUid(n, bl);
            }
            catch (MethodException methodException) {}
        }
    }

    public void updateReferenceLapList(SCRefLapHeader[] sCRefLapHeaderArray) {
        this.updateReferenceLapList(sCRefLapHeaderArray, true);
    }

    public void updateReferenceLapList(SCRefLapHeader[] sCRefLapHeaderArray, boolean bl) {
        if (sCRefLapHeaderArray != null) {
            this.ReferenceLapList = new SCRefLapHeader[sCRefLapHeaderArray.length];
            for (int i2 = 0; i2 < sCRefLapHeaderArray.length; ++i2) {
                this.ReferenceLapList[i2] = ASIHMISyncCarSportChronoAbstractBaseService.copySCRefLapHeader(sCRefLapHeaderArray[i2]);
            }
        } else {
            this.ReferenceLapList = null;
        }
        this.ReferenceLapList_valid = bl;
        List list = this.baseService.getNotifications(32);
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            ASIHMISyncCarSportChronoReply aSIHMISyncCarSportChronoReply = (ASIHMISyncCarSportChronoReply)iterator.next();
            try {
                aSIHMISyncCarSportChronoReply.updateReferenceLapList(sCRefLapHeaderArray, bl);
            }
            catch (MethodException methodException) {}
        }
    }
}

