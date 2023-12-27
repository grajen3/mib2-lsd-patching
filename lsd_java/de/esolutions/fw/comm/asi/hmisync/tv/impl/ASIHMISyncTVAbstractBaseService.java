/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.hmisync.tv.impl;

import de.esolutions.fw.comm.asi.hmisync.tv.ASIHMISyncTVReply;
import de.esolutions.fw.comm.asi.hmisync.tv.ASIHMISyncTVS;
import de.esolutions.fw.comm.asi.hmisync.tv.ActiveStationInfo;
import de.esolutions.fw.comm.asi.hmisync.tv.AudioChannel;
import de.esolutions.fw.comm.asi.hmisync.tv.KeySet;
import de.esolutions.fw.comm.asi.hmisync.tv.ParentalSettings;
import de.esolutions.fw.comm.asi.hmisync.tv.ProgramInfo;
import de.esolutions.fw.comm.asi.hmisync.tv.StationInfo;
import de.esolutions.fw.comm.asi.hmisync.tv.impl.ASIHMISyncTVAbstractBaseService$AttributesBitMapProvider;
import de.esolutions.fw.comm.attributes.AttributesBaseService;
import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.method.MethodException;
import java.util.Iterator;
import java.util.List;

public abstract class ASIHMISyncTVAbstractBaseService
implements ASIHMISyncTVS {
    private static final CallContext context = CallContext.getContext("ABSTRACTBASESERVICE.asi.hmisync.tv.ASIHMISyncTV");
    private static final int attributesCount;
    private String ASIVersion;
    private boolean ASIVersion_valid = false;
    private short[] RequestIDs;
    private boolean RequestIDs_valid = false;
    private short[] ReplyIDs;
    private boolean ReplyIDs_valid = false;
    private StationInfo[] StationInfo;
    private boolean StationInfo_valid = false;
    private ActiveStationInfo ActiveStationInfo;
    private boolean ActiveStationInfo_valid = false;
    private long ActiveTVStationState;
    private boolean ActiveTVStationState_valid = false;
    private long TunerConfig;
    private boolean TunerConfig_valid = false;
    private KeySet[] PanelKeySet;
    private boolean PanelKeySet_valid = false;
    private byte SeekStatus;
    private boolean SeekStatus_valid = false;
    private byte TerminalMode;
    private boolean TerminalMode_valid = false;
    private ParentalSettings ParentalSettings;
    private boolean ParentalSettings_valid = false;
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
        stationInfo2.name = ASIHMISyncTVAbstractBaseService.copyString(stationInfo.name);
        stationInfo2.serviceType = stationInfo.serviceType;
        stationInfo2.contentGroup = stationInfo.contentGroup;
        return stationInfo2;
    }

    public static ActiveStationInfo copyActiveStationInfo(ActiveStationInfo activeStationInfo) {
        if (activeStationInfo == null) {
            return null;
        }
        ActiveStationInfo activeStationInfo2 = new ActiveStationInfo();
        activeStationInfo2.id = activeStationInfo.id;
        activeStationInfo2.stationName = ASIHMISyncTVAbstractBaseService.copyString(activeStationInfo.stationName);
        activeStationInfo2.channelName = ASIHMISyncTVAbstractBaseService.copyString(activeStationInfo.channelName);
        if (activeStationInfo.stationConfig != null) {
            activeStationInfo2.stationConfig = new int[activeStationInfo.stationConfig.length];
            System.arraycopy((Object)activeStationInfo.stationConfig, 0, (Object)activeStationInfo2.stationConfig, 0, activeStationInfo2.stationConfig.length);
        } else {
            activeStationInfo2.stationConfig = null;
        }
        if (activeStationInfo.stationFlags != null) {
            activeStationInfo2.stationFlags = new int[activeStationInfo.stationFlags.length];
            System.arraycopy((Object)activeStationInfo.stationFlags, 0, (Object)activeStationInfo2.stationFlags, 0, activeStationInfo2.stationFlags.length);
        } else {
            activeStationInfo2.stationFlags = null;
        }
        activeStationInfo2.currentProgram = ASIHMISyncTVAbstractBaseService.copyProgramInfo(activeStationInfo.currentProgram);
        activeStationInfo2.nextProgram = ASIHMISyncTVAbstractBaseService.copyProgramInfo(activeStationInfo.nextProgram);
        if (activeStationInfo.audioChannels != null) {
            activeStationInfo2.audioChannels = new AudioChannel[activeStationInfo.audioChannels.length];
            for (int i2 = 0; i2 < activeStationInfo.audioChannels.length; ++i2) {
                activeStationInfo2.audioChannels[i2] = ASIHMISyncTVAbstractBaseService.copyAudioChannel(activeStationInfo.audioChannels[i2]);
            }
        } else {
            activeStationInfo2.audioChannels = null;
        }
        return activeStationInfo2;
    }

    public static ProgramInfo copyProgramInfo(ProgramInfo programInfo) {
        if (programInfo == null) {
            return null;
        }
        ProgramInfo programInfo2 = new ProgramInfo();
        programInfo2.name = ASIHMISyncTVAbstractBaseService.copyString(programInfo.name);
        programInfo2.startHour = programInfo.startHour;
        programInfo2.startMinute = programInfo.startMinute;
        programInfo2.startSecond = programInfo.startSecond;
        programInfo2.endHour = programInfo.endHour;
        programInfo2.endMinute = programInfo.endMinute;
        programInfo2.endSecond = programInfo.endSecond;
        return programInfo2;
    }

    public static AudioChannel copyAudioChannel(AudioChannel audioChannel) {
        if (audioChannel == null) {
            return null;
        }
        AudioChannel audioChannel2 = new AudioChannel();
        audioChannel2.id = audioChannel.id;
        audioChannel2.language = ASIHMISyncTVAbstractBaseService.copyString(audioChannel.language);
        audioChannel2.format = audioChannel.format;
        audioChannel2.description = audioChannel.description;
        return audioChannel2;
    }

    public static KeySet copyKeySet(KeySet keySet) {
        if (keySet == null) {
            return null;
        }
        KeySet keySet2 = new KeySet();
        keySet2.terminalID = keySet.terminalID;
        if (keySet.keyIDs != null) {
            keySet2.keyIDs = new byte[keySet.keyIDs.length];
            System.arraycopy((Object)keySet.keyIDs, 0, (Object)keySet2.keyIDs, 0, keySet2.keyIDs.length);
        } else {
            keySet2.keyIDs = null;
        }
        return keySet2;
    }

    public static ParentalSettings copyParentalSettings(ParentalSettings parentalSettings) {
        if (parentalSettings == null) {
            return null;
        }
        ParentalSettings parentalSettings2 = new ParentalSettings();
        parentalSettings2.isParentalManagementRequired = parentalSettings.isParentalManagementRequired;
        parentalSettings2.parentalLevel = parentalSettings.parentalLevel;
        return parentalSettings2;
    }

    public ASIHMISyncTVAbstractBaseService() {
        ASIHMISyncTVAbstractBaseService$AttributesBitMapProvider aSIHMISyncTVAbstractBaseService$AttributesBitMapProvider = new ASIHMISyncTVAbstractBaseService$AttributesBitMapProvider();
        this.baseService = new AttributesBaseService("ASIHMISyncTV", aSIHMISyncTVAbstractBaseService$AttributesBitMapProvider);
    }

    @Override
    public synchronized void setNotification(long l, ASIHMISyncTVReply aSIHMISyncTVReply) {
        this.baseService.setNotification(l, (Object)aSIHMISyncTVReply);
        this.sendAttributeUpdate(l, aSIHMISyncTVReply);
    }

    @Override
    public synchronized void setNotification(ASIHMISyncTVReply aSIHMISyncTVReply) {
        this.baseService.setNotification(aSIHMISyncTVReply);
        this.sendAttributeUpdate(aSIHMISyncTVReply);
    }

    @Override
    public synchronized void setNotification(long[] lArray, ASIHMISyncTVReply aSIHMISyncTVReply) {
        this.baseService.setNotification(lArray, (Object)aSIHMISyncTVReply);
        this.sendAttributeUpdate(lArray, aSIHMISyncTVReply);
    }

    @Override
    public synchronized void clearNotification(long l, ASIHMISyncTVReply aSIHMISyncTVReply) {
        this.baseService.clearNotification(l, (Object)aSIHMISyncTVReply);
    }

    @Override
    public synchronized void clearNotification(ASIHMISyncTVReply aSIHMISyncTVReply) {
        this.baseService.clearNotification(aSIHMISyncTVReply);
    }

    @Override
    public synchronized void clearNotification(long[] lArray, ASIHMISyncTVReply aSIHMISyncTVReply) {
        this.baseService.clearNotification(lArray, (Object)aSIHMISyncTVReply);
    }

    private void sendAttributeUpdate(ASIHMISyncTVReply aSIHMISyncTVReply) {
        try {
            aSIHMISyncTVReply.updateASIVersion(this.ASIVersion, this.ASIVersion_valid);
            aSIHMISyncTVReply.updateRequestIDs(this.RequestIDs, this.RequestIDs_valid);
            aSIHMISyncTVReply.updateReplyIDs(this.ReplyIDs, this.ReplyIDs_valid);
            aSIHMISyncTVReply.updateStationInfo(this.StationInfo, this.StationInfo_valid);
            aSIHMISyncTVReply.updateActiveStationInfo(this.ActiveStationInfo, this.ActiveStationInfo_valid);
            aSIHMISyncTVReply.updateActiveTVStationState(this.ActiveTVStationState, this.ActiveTVStationState_valid);
            aSIHMISyncTVReply.updateTunerConfig(this.TunerConfig, this.TunerConfig_valid);
            aSIHMISyncTVReply.updatePanelKeySet(this.PanelKeySet, this.PanelKeySet_valid);
            aSIHMISyncTVReply.updateSeekStatus(this.SeekStatus, this.SeekStatus_valid);
            aSIHMISyncTVReply.updateTerminalMode(this.TerminalMode, this.TerminalMode_valid);
            aSIHMISyncTVReply.updateParentalSettings(this.ParentalSettings, this.ParentalSettings_valid);
        }
        catch (MethodException methodException) {
            // empty catch block
        }
    }

    private void sendAttributeUpdate(long[] lArray, ASIHMISyncTVReply aSIHMISyncTVReply) {
        for (int i2 = 0; i2 < lArray.length; ++i2) {
            this.sendAttributeUpdate(lArray[i2], aSIHMISyncTVReply);
        }
    }

    private void sendAttributeUpdate(long l, ASIHMISyncTVReply aSIHMISyncTVReply) {
        try {
            if (l == 0) {
                aSIHMISyncTVReply.updateASIVersion(this.ASIVersion, this.ASIVersion_valid);
            } else if (l == 0) {
                aSIHMISyncTVReply.updateRequestIDs(this.RequestIDs, this.RequestIDs_valid);
            } else if (l == 0) {
                aSIHMISyncTVReply.updateReplyIDs(this.ReplyIDs, this.ReplyIDs_valid);
            } else if (l == 0) {
                aSIHMISyncTVReply.updateStationInfo(this.StationInfo, this.StationInfo_valid);
            } else if (l == 0) {
                aSIHMISyncTVReply.updateActiveStationInfo(this.ActiveStationInfo, this.ActiveStationInfo_valid);
            } else if (l == 0) {
                aSIHMISyncTVReply.updateActiveTVStationState(this.ActiveTVStationState, this.ActiveTVStationState_valid);
            } else if (l == 0) {
                aSIHMISyncTVReply.updateTunerConfig(this.TunerConfig, this.TunerConfig_valid);
            } else if (l == 0) {
                aSIHMISyncTVReply.updatePanelKeySet(this.PanelKeySet, this.PanelKeySet_valid);
            } else if (l == 0) {
                aSIHMISyncTVReply.updateSeekStatus(this.SeekStatus, this.SeekStatus_valid);
            } else if (l == 0) {
                aSIHMISyncTVReply.updateTerminalMode(this.TerminalMode, this.TerminalMode_valid);
            } else if (l == 0) {
                aSIHMISyncTVReply.updateParentalSettings(this.ParentalSettings, this.ParentalSettings_valid);
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
        this.ASIVersion = ASIHMISyncTVAbstractBaseService.copyString(string);
        this.ASIVersion_valid = bl;
        List list = this.baseService.getNotifications(12);
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            ASIHMISyncTVReply aSIHMISyncTVReply = (ASIHMISyncTVReply)iterator.next();
            try {
                aSIHMISyncTVReply.updateASIVersion(string, bl);
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
            ASIHMISyncTVReply aSIHMISyncTVReply = (ASIHMISyncTVReply)iterator.next();
            try {
                aSIHMISyncTVReply.updateRequestIDs(sArray, bl);
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
            ASIHMISyncTVReply aSIHMISyncTVReply = (ASIHMISyncTVReply)iterator.next();
            try {
                aSIHMISyncTVReply.updateReplyIDs(sArray, bl);
            }
            catch (MethodException methodException) {}
        }
    }

    public void updateStationInfo(StationInfo[] stationInfoArray) {
        this.updateStationInfo(stationInfoArray, true);
    }

    public void updateStationInfo(StationInfo[] stationInfoArray, boolean bl) {
        if (stationInfoArray != null) {
            this.StationInfo = new StationInfo[stationInfoArray.length];
            for (int i2 = 0; i2 < stationInfoArray.length; ++i2) {
                this.StationInfo[i2] = ASIHMISyncTVAbstractBaseService.copyStationInfo(stationInfoArray[i2]);
            }
        } else {
            this.StationInfo = null;
        }
        this.StationInfo_valid = bl;
        List list = this.baseService.getNotifications(23);
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            ASIHMISyncTVReply aSIHMISyncTVReply = (ASIHMISyncTVReply)iterator.next();
            try {
                aSIHMISyncTVReply.updateStationInfo(stationInfoArray, bl);
            }
            catch (MethodException methodException) {}
        }
    }

    public void updateActiveStationInfo(ActiveStationInfo activeStationInfo) {
        this.updateActiveStationInfo(activeStationInfo, true);
    }

    public void updateActiveStationInfo(ActiveStationInfo activeStationInfo, boolean bl) {
        this.ActiveStationInfo = ASIHMISyncTVAbstractBaseService.copyActiveStationInfo(activeStationInfo);
        this.ActiveStationInfo_valid = bl;
        List list = this.baseService.getNotifications(21);
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            ASIHMISyncTVReply aSIHMISyncTVReply = (ASIHMISyncTVReply)iterator.next();
            try {
                aSIHMISyncTVReply.updateActiveStationInfo(activeStationInfo, bl);
            }
            catch (MethodException methodException) {}
        }
    }

    public void updateActiveTVStationState(long l) {
        this.updateActiveTVStationState(l, true);
    }

    public void updateActiveTVStationState(long l, boolean bl) {
        this.ActiveTVStationState = l;
        this.ActiveTVStationState_valid = bl;
        List list = this.baseService.getNotifications(22);
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            ASIHMISyncTVReply aSIHMISyncTVReply = (ASIHMISyncTVReply)iterator.next();
            try {
                aSIHMISyncTVReply.updateActiveTVStationState(l, bl);
            }
            catch (MethodException methodException) {}
        }
    }

    public void updateTunerConfig(long l) {
        this.updateTunerConfig(l, true);
    }

    public void updateTunerConfig(long l, boolean bl) {
        this.TunerConfig = l;
        this.TunerConfig_valid = bl;
        List list = this.baseService.getNotifications(24);
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            ASIHMISyncTVReply aSIHMISyncTVReply = (ASIHMISyncTVReply)iterator.next();
            try {
                aSIHMISyncTVReply.updateTunerConfig(l, bl);
            }
            catch (MethodException methodException) {}
        }
    }

    public void updatePanelKeySet(KeySet[] keySetArray) {
        this.updatePanelKeySet(keySetArray, true);
    }

    public void updatePanelKeySet(KeySet[] keySetArray, boolean bl) {
        if (keySetArray != null) {
            this.PanelKeySet = new KeySet[keySetArray.length];
            for (int i2 = 0; i2 < keySetArray.length; ++i2) {
                this.PanelKeySet[i2] = ASIHMISyncTVAbstractBaseService.copyKeySet(keySetArray[i2]);
            }
        } else {
            this.PanelKeySet = null;
        }
        this.PanelKeySet_valid = bl;
        List list = this.baseService.getNotifications(14);
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            ASIHMISyncTVReply aSIHMISyncTVReply = (ASIHMISyncTVReply)iterator.next();
            try {
                aSIHMISyncTVReply.updatePanelKeySet(keySetArray, bl);
            }
            catch (MethodException methodException) {}
        }
    }

    public void updateSeekStatus(byte by) {
        this.updateSeekStatus(by, true);
    }

    public void updateSeekStatus(byte by, boolean bl) {
        this.SeekStatus = by;
        this.SeekStatus_valid = bl;
        List list = this.baseService.getNotifications(16);
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            ASIHMISyncTVReply aSIHMISyncTVReply = (ASIHMISyncTVReply)iterator.next();
            try {
                aSIHMISyncTVReply.updateSeekStatus(by, bl);
            }
            catch (MethodException methodException) {}
        }
    }

    public void updateTerminalMode(byte by) {
        this.updateTerminalMode(by, true);
    }

    public void updateTerminalMode(byte by, boolean bl) {
        this.TerminalMode = by;
        this.TerminalMode_valid = bl;
        List list = this.baseService.getNotifications(18);
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            ASIHMISyncTVReply aSIHMISyncTVReply = (ASIHMISyncTVReply)iterator.next();
            try {
                aSIHMISyncTVReply.updateTerminalMode(by, bl);
            }
            catch (MethodException methodException) {}
        }
    }

    public void updateParentalSettings(ParentalSettings parentalSettings) {
        this.updateParentalSettings(parentalSettings, true);
    }

    public void updateParentalSettings(ParentalSettings parentalSettings, boolean bl) {
        this.ParentalSettings = ASIHMISyncTVAbstractBaseService.copyParentalSettings(parentalSettings);
        this.ParentalSettings_valid = bl;
        List list = this.baseService.getNotifications(15);
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            ASIHMISyncTVReply aSIHMISyncTVReply = (ASIHMISyncTVReply)iterator.next();
            try {
                aSIHMISyncTVReply.updateParentalSettings(parentalSettings, bl);
            }
            catch (MethodException methodException) {}
        }
    }
}

