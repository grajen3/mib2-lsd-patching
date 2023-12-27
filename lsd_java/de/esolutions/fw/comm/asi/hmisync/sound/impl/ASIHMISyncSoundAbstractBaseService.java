/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.hmisync.sound.impl;

import de.esolutions.fw.comm.asi.hmisync.sound.ASIHMISyncSoundReply;
import de.esolutions.fw.comm.asi.hmisync.sound.ASIHMISyncSoundS;
import de.esolutions.fw.comm.asi.hmisync.sound.SoundRange;
import de.esolutions.fw.comm.asi.hmisync.sound.impl.ASIHMISyncSoundAbstractBaseService$AttributesBitMapProvider;
import de.esolutions.fw.comm.attributes.AttributesBaseService;
import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.method.MethodException;
import java.util.Iterator;
import java.util.List;

public abstract class ASIHMISyncSoundAbstractBaseService
implements ASIHMISyncSoundS {
    private static final CallContext context = CallContext.getContext("ABSTRACTBASESERVICE.asi.hmisync.sound.ASIHMISyncSound");
    private static final int attributesCount;
    private String ASIVersion;
    private boolean ASIVersion_valid = false;
    private short[] RequestIDs;
    private boolean RequestIDs_valid = false;
    private short[] ReplyIDs;
    private boolean ReplyIDs_valid = false;
    private int SoundState;
    private boolean SoundState_valid = false;
    private int Amplifier;
    private boolean Amplifier_valid = false;
    private SoundRange BassRange;
    private boolean BassRange_valid = false;
    private int BassValue;
    private boolean BassValue_valid = false;
    private SoundRange TrebleRange;
    private boolean TrebleRange_valid = false;
    private int TrebleValue;
    private boolean TrebleValue_valid = false;
    private SoundRange BalanceRange;
    private boolean BalanceRange_valid = false;
    private int BalanceValue;
    private boolean BalanceValue_valid = false;
    private SoundRange FaderRange;
    private boolean FaderRange_valid = false;
    private int FaderValue;
    private boolean FaderValue_valid = false;
    private SoundRange SubwooferRange;
    private boolean SubwooferRange_valid = false;
    private int SubwooferValue;
    private boolean SubwooferValue_valid = false;
    private SoundRange SurroundRange;
    private boolean SurroundRange_valid = false;
    private int SurroundValue;
    private boolean SurroundValue_valid = false;
    private SoundRange NoiseCompensationRange;
    private boolean NoiseCompensationRange_valid = false;
    private int NoiseCompensationValue;
    private boolean NoiseCompensationValue_valid = false;
    private SoundRange ThreeDModeRange;
    private boolean ThreeDModeRange_valid = false;
    private int ThreeDModeValue;
    private boolean ThreeDModeValue_valid = false;
    private int PresetPositionList;
    private boolean PresetPositionList_valid = false;
    private int PresetPosition;
    private boolean PresetPosition_valid = false;
    private int PresetEQList;
    private boolean PresetEQList_valid = false;
    private int PresetEQ;
    private boolean PresetEQ_valid = false;
    private AttributesBaseService baseService;

    public static String copyString(String string) {
        if (string != null) {
            return new String(string);
        }
        return null;
    }

    public static SoundRange copySoundRange(SoundRange soundRange) {
        if (soundRange == null) {
            return null;
        }
        SoundRange soundRange2 = new SoundRange();
        soundRange2.min = soundRange.min;
        soundRange2.max = soundRange.max;
        return soundRange2;
    }

    public ASIHMISyncSoundAbstractBaseService() {
        ASIHMISyncSoundAbstractBaseService$AttributesBitMapProvider aSIHMISyncSoundAbstractBaseService$AttributesBitMapProvider = new ASIHMISyncSoundAbstractBaseService$AttributesBitMapProvider();
        this.baseService = new AttributesBaseService("ASIHMISyncSound", aSIHMISyncSoundAbstractBaseService$AttributesBitMapProvider);
    }

    @Override
    public synchronized void setNotification(long l, ASIHMISyncSoundReply aSIHMISyncSoundReply) {
        this.baseService.setNotification(l, (Object)aSIHMISyncSoundReply);
        this.sendAttributeUpdate(l, aSIHMISyncSoundReply);
    }

    @Override
    public synchronized void setNotification(ASIHMISyncSoundReply aSIHMISyncSoundReply) {
        this.baseService.setNotification(aSIHMISyncSoundReply);
        this.sendAttributeUpdate(aSIHMISyncSoundReply);
    }

    @Override
    public synchronized void setNotification(long[] lArray, ASIHMISyncSoundReply aSIHMISyncSoundReply) {
        this.baseService.setNotification(lArray, (Object)aSIHMISyncSoundReply);
        this.sendAttributeUpdate(lArray, aSIHMISyncSoundReply);
    }

    @Override
    public synchronized void clearNotification(long l, ASIHMISyncSoundReply aSIHMISyncSoundReply) {
        this.baseService.clearNotification(l, (Object)aSIHMISyncSoundReply);
    }

    @Override
    public synchronized void clearNotification(ASIHMISyncSoundReply aSIHMISyncSoundReply) {
        this.baseService.clearNotification(aSIHMISyncSoundReply);
    }

    @Override
    public synchronized void clearNotification(long[] lArray, ASIHMISyncSoundReply aSIHMISyncSoundReply) {
        this.baseService.clearNotification(lArray, (Object)aSIHMISyncSoundReply);
    }

    private void sendAttributeUpdate(ASIHMISyncSoundReply aSIHMISyncSoundReply) {
        try {
            aSIHMISyncSoundReply.updateASIVersion(this.ASIVersion, this.ASIVersion_valid);
            aSIHMISyncSoundReply.updateRequestIDs(this.RequestIDs, this.RequestIDs_valid);
            aSIHMISyncSoundReply.updateReplyIDs(this.ReplyIDs, this.ReplyIDs_valid);
            aSIHMISyncSoundReply.updateSoundState(this.SoundState, this.SoundState_valid);
            aSIHMISyncSoundReply.updateAmplifier(this.Amplifier, this.Amplifier_valid);
            aSIHMISyncSoundReply.updateBassRange(this.BassRange, this.BassRange_valid);
            aSIHMISyncSoundReply.updateBassValue(this.BassValue, this.BassValue_valid);
            aSIHMISyncSoundReply.updateTrebleRange(this.TrebleRange, this.TrebleRange_valid);
            aSIHMISyncSoundReply.updateTrebleValue(this.TrebleValue, this.TrebleValue_valid);
            aSIHMISyncSoundReply.updateBalanceRange(this.BalanceRange, this.BalanceRange_valid);
            aSIHMISyncSoundReply.updateBalanceValue(this.BalanceValue, this.BalanceValue_valid);
            aSIHMISyncSoundReply.updateFaderRange(this.FaderRange, this.FaderRange_valid);
            aSIHMISyncSoundReply.updateFaderValue(this.FaderValue, this.FaderValue_valid);
            aSIHMISyncSoundReply.updateSubwooferRange(this.SubwooferRange, this.SubwooferRange_valid);
            aSIHMISyncSoundReply.updateSubwooferValue(this.SubwooferValue, this.SubwooferValue_valid);
            aSIHMISyncSoundReply.updateSurroundRange(this.SurroundRange, this.SurroundRange_valid);
            aSIHMISyncSoundReply.updateSurroundValue(this.SurroundValue, this.SurroundValue_valid);
            aSIHMISyncSoundReply.updateNoiseCompensationRange(this.NoiseCompensationRange, this.NoiseCompensationRange_valid);
            aSIHMISyncSoundReply.updateNoiseCompensationValue(this.NoiseCompensationValue, this.NoiseCompensationValue_valid);
            aSIHMISyncSoundReply.updateThreeDModeRange(this.ThreeDModeRange, this.ThreeDModeRange_valid);
            aSIHMISyncSoundReply.updateThreeDModeValue(this.ThreeDModeValue, this.ThreeDModeValue_valid);
            aSIHMISyncSoundReply.updatePresetPositionList(this.PresetPositionList, this.PresetPositionList_valid);
            aSIHMISyncSoundReply.updatePresetPosition(this.PresetPosition, this.PresetPosition_valid);
            aSIHMISyncSoundReply.updatePresetEQList(this.PresetEQList, this.PresetEQList_valid);
            aSIHMISyncSoundReply.updatePresetEQ(this.PresetEQ, this.PresetEQ_valid);
        }
        catch (MethodException methodException) {
            // empty catch block
        }
    }

    private void sendAttributeUpdate(long[] lArray, ASIHMISyncSoundReply aSIHMISyncSoundReply) {
        for (int i2 = 0; i2 < lArray.length; ++i2) {
            this.sendAttributeUpdate(lArray[i2], aSIHMISyncSoundReply);
        }
    }

    private void sendAttributeUpdate(long l, ASIHMISyncSoundReply aSIHMISyncSoundReply) {
        try {
            if (l == 0) {
                aSIHMISyncSoundReply.updateASIVersion(this.ASIVersion, this.ASIVersion_valid);
            } else if (l == 0) {
                aSIHMISyncSoundReply.updateRequestIDs(this.RequestIDs, this.RequestIDs_valid);
            } else if (l == 0) {
                aSIHMISyncSoundReply.updateReplyIDs(this.ReplyIDs, this.ReplyIDs_valid);
            } else if (l == 0) {
                aSIHMISyncSoundReply.updateSoundState(this.SoundState, this.SoundState_valid);
            } else if (l == 0) {
                aSIHMISyncSoundReply.updateAmplifier(this.Amplifier, this.Amplifier_valid);
            } else if (l == 0) {
                aSIHMISyncSoundReply.updateBassRange(this.BassRange, this.BassRange_valid);
            } else if (l == 0) {
                aSIHMISyncSoundReply.updateBassValue(this.BassValue, this.BassValue_valid);
            } else if (l == 0) {
                aSIHMISyncSoundReply.updateTrebleRange(this.TrebleRange, this.TrebleRange_valid);
            } else if (l == 0) {
                aSIHMISyncSoundReply.updateTrebleValue(this.TrebleValue, this.TrebleValue_valid);
            } else if (l == 0) {
                aSIHMISyncSoundReply.updateBalanceRange(this.BalanceRange, this.BalanceRange_valid);
            } else if (l == 0) {
                aSIHMISyncSoundReply.updateBalanceValue(this.BalanceValue, this.BalanceValue_valid);
            } else if (l == 0) {
                aSIHMISyncSoundReply.updateFaderRange(this.FaderRange, this.FaderRange_valid);
            } else if (l == 0) {
                aSIHMISyncSoundReply.updateFaderValue(this.FaderValue, this.FaderValue_valid);
            } else if (l == 0) {
                aSIHMISyncSoundReply.updateSubwooferRange(this.SubwooferRange, this.SubwooferRange_valid);
            } else if (l == 0) {
                aSIHMISyncSoundReply.updateSubwooferValue(this.SubwooferValue, this.SubwooferValue_valid);
            } else if (l == 0) {
                aSIHMISyncSoundReply.updateSurroundRange(this.SurroundRange, this.SurroundRange_valid);
            } else if (l == 0) {
                aSIHMISyncSoundReply.updateSurroundValue(this.SurroundValue, this.SurroundValue_valid);
            } else if (l == 0) {
                aSIHMISyncSoundReply.updateNoiseCompensationRange(this.NoiseCompensationRange, this.NoiseCompensationRange_valid);
            } else if (l == 0) {
                aSIHMISyncSoundReply.updateNoiseCompensationValue(this.NoiseCompensationValue, this.NoiseCompensationValue_valid);
            } else if (l == 0) {
                aSIHMISyncSoundReply.updateThreeDModeRange(this.ThreeDModeRange, this.ThreeDModeRange_valid);
            } else if (l == 0) {
                aSIHMISyncSoundReply.updateThreeDModeValue(this.ThreeDModeValue, this.ThreeDModeValue_valid);
            } else if (l == 0) {
                aSIHMISyncSoundReply.updatePresetPositionList(this.PresetPositionList, this.PresetPositionList_valid);
            } else if (l == 0) {
                aSIHMISyncSoundReply.updatePresetPosition(this.PresetPosition, this.PresetPosition_valid);
            } else if (l == 0) {
                aSIHMISyncSoundReply.updatePresetEQList(this.PresetEQList, this.PresetEQList_valid);
            } else if (l == 0) {
                aSIHMISyncSoundReply.updatePresetEQ(this.PresetEQ, this.PresetEQ_valid);
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
        this.ASIVersion = ASIHMISyncSoundAbstractBaseService.copyString(string);
        this.ASIVersion_valid = bl;
        List list = this.baseService.getNotifications(14);
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            ASIHMISyncSoundReply aSIHMISyncSoundReply = (ASIHMISyncSoundReply)iterator.next();
            try {
                aSIHMISyncSoundReply.updateASIVersion(string, bl);
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
        List list = this.baseService.getNotifications(27);
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            ASIHMISyncSoundReply aSIHMISyncSoundReply = (ASIHMISyncSoundReply)iterator.next();
            try {
                aSIHMISyncSoundReply.updateRequestIDs(sArray, bl);
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
        List list = this.baseService.getNotifications(26);
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            ASIHMISyncSoundReply aSIHMISyncSoundReply = (ASIHMISyncSoundReply)iterator.next();
            try {
                aSIHMISyncSoundReply.updateReplyIDs(sArray, bl);
            }
            catch (MethodException methodException) {}
        }
    }

    public void updateSoundState(int n) {
        this.updateSoundState(n, true);
    }

    public void updateSoundState(int n, boolean bl) {
        this.SoundState = n;
        this.SoundState_valid = bl;
        List list = this.baseService.getNotifications(28);
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            ASIHMISyncSoundReply aSIHMISyncSoundReply = (ASIHMISyncSoundReply)iterator.next();
            try {
                aSIHMISyncSoundReply.updateSoundState(n, bl);
            }
            catch (MethodException methodException) {}
        }
    }

    public void updateAmplifier(int n) {
        this.updateAmplifier(n, true);
    }

    public void updateAmplifier(int n, boolean bl) {
        this.Amplifier = n;
        this.Amplifier_valid = bl;
        List list = this.baseService.getNotifications(15);
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            ASIHMISyncSoundReply aSIHMISyncSoundReply = (ASIHMISyncSoundReply)iterator.next();
            try {
                aSIHMISyncSoundReply.updateAmplifier(n, bl);
            }
            catch (MethodException methodException) {}
        }
    }

    public void updateBassRange(SoundRange soundRange) {
        this.updateBassRange(soundRange, true);
    }

    public void updateBassRange(SoundRange soundRange, boolean bl) {
        this.BassRange = ASIHMISyncSoundAbstractBaseService.copySoundRange(soundRange);
        this.BassRange_valid = bl;
        List list = this.baseService.getNotifications(18);
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            ASIHMISyncSoundReply aSIHMISyncSoundReply = (ASIHMISyncSoundReply)iterator.next();
            try {
                aSIHMISyncSoundReply.updateBassRange(soundRange, bl);
            }
            catch (MethodException methodException) {}
        }
    }

    public void updateBassValue(int n) {
        this.updateBassValue(n, true);
    }

    public void updateBassValue(int n, boolean bl) {
        this.BassValue = n;
        this.BassValue_valid = bl;
        List list = this.baseService.getNotifications(19);
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            ASIHMISyncSoundReply aSIHMISyncSoundReply = (ASIHMISyncSoundReply)iterator.next();
            try {
                aSIHMISyncSoundReply.updateBassValue(n, bl);
            }
            catch (MethodException methodException) {}
        }
    }

    public void updateTrebleRange(SoundRange soundRange) {
        this.updateTrebleRange(soundRange, true);
    }

    public void updateTrebleRange(SoundRange soundRange, boolean bl) {
        this.TrebleRange = ASIHMISyncSoundAbstractBaseService.copySoundRange(soundRange);
        this.TrebleRange_valid = bl;
        List list = this.baseService.getNotifications(33);
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            ASIHMISyncSoundReply aSIHMISyncSoundReply = (ASIHMISyncSoundReply)iterator.next();
            try {
                aSIHMISyncSoundReply.updateTrebleRange(soundRange, bl);
            }
            catch (MethodException methodException) {}
        }
    }

    public void updateTrebleValue(int n) {
        this.updateTrebleValue(n, true);
    }

    public void updateTrebleValue(int n, boolean bl) {
        this.TrebleValue = n;
        this.TrebleValue_valid = bl;
        List list = this.baseService.getNotifications(34);
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            ASIHMISyncSoundReply aSIHMISyncSoundReply = (ASIHMISyncSoundReply)iterator.next();
            try {
                aSIHMISyncSoundReply.updateTrebleValue(n, bl);
            }
            catch (MethodException methodException) {}
        }
    }

    public void updateBalanceRange(SoundRange soundRange) {
        this.updateBalanceRange(soundRange, true);
    }

    public void updateBalanceRange(SoundRange soundRange, boolean bl) {
        this.BalanceRange = ASIHMISyncSoundAbstractBaseService.copySoundRange(soundRange);
        this.BalanceRange_valid = bl;
        List list = this.baseService.getNotifications(16);
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            ASIHMISyncSoundReply aSIHMISyncSoundReply = (ASIHMISyncSoundReply)iterator.next();
            try {
                aSIHMISyncSoundReply.updateBalanceRange(soundRange, bl);
            }
            catch (MethodException methodException) {}
        }
    }

    public void updateBalanceValue(int n) {
        this.updateBalanceValue(n, true);
    }

    public void updateBalanceValue(int n, boolean bl) {
        this.BalanceValue = n;
        this.BalanceValue_valid = bl;
        List list = this.baseService.getNotifications(17);
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            ASIHMISyncSoundReply aSIHMISyncSoundReply = (ASIHMISyncSoundReply)iterator.next();
            try {
                aSIHMISyncSoundReply.updateBalanceValue(n, bl);
            }
            catch (MethodException methodException) {}
        }
    }

    public void updateFaderRange(SoundRange soundRange) {
        this.updateFaderRange(soundRange, true);
    }

    public void updateFaderRange(SoundRange soundRange, boolean bl) {
        this.FaderRange = ASIHMISyncSoundAbstractBaseService.copySoundRange(soundRange);
        this.FaderRange_valid = bl;
        List list = this.baseService.getNotifications(20);
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            ASIHMISyncSoundReply aSIHMISyncSoundReply = (ASIHMISyncSoundReply)iterator.next();
            try {
                aSIHMISyncSoundReply.updateFaderRange(soundRange, bl);
            }
            catch (MethodException methodException) {}
        }
    }

    public void updateFaderValue(int n) {
        this.updateFaderValue(n, true);
    }

    public void updateFaderValue(int n, boolean bl) {
        this.FaderValue = n;
        this.FaderValue_valid = bl;
        List list = this.baseService.getNotifications(21);
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            ASIHMISyncSoundReply aSIHMISyncSoundReply = (ASIHMISyncSoundReply)iterator.next();
            try {
                aSIHMISyncSoundReply.updateFaderValue(n, bl);
            }
            catch (MethodException methodException) {}
        }
    }

    public void updateSubwooferRange(SoundRange soundRange) {
        this.updateSubwooferRange(soundRange, true);
    }

    public void updateSubwooferRange(SoundRange soundRange, boolean bl) {
        this.SubwooferRange = ASIHMISyncSoundAbstractBaseService.copySoundRange(soundRange);
        this.SubwooferRange_valid = bl;
        List list = this.baseService.getNotifications(29);
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            ASIHMISyncSoundReply aSIHMISyncSoundReply = (ASIHMISyncSoundReply)iterator.next();
            try {
                aSIHMISyncSoundReply.updateSubwooferRange(soundRange, bl);
            }
            catch (MethodException methodException) {}
        }
    }

    public void updateSubwooferValue(int n) {
        this.updateSubwooferValue(n, true);
    }

    public void updateSubwooferValue(int n, boolean bl) {
        this.SubwooferValue = n;
        this.SubwooferValue_valid = bl;
        List list = this.baseService.getNotifications(30);
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            ASIHMISyncSoundReply aSIHMISyncSoundReply = (ASIHMISyncSoundReply)iterator.next();
            try {
                aSIHMISyncSoundReply.updateSubwooferValue(n, bl);
            }
            catch (MethodException methodException) {}
        }
    }

    public void updateSurroundRange(SoundRange soundRange) {
        this.updateSurroundRange(soundRange, true);
    }

    public void updateSurroundRange(SoundRange soundRange, boolean bl) {
        this.SurroundRange = ASIHMISyncSoundAbstractBaseService.copySoundRange(soundRange);
        this.SurroundRange_valid = bl;
        List list = this.baseService.getNotifications(31);
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            ASIHMISyncSoundReply aSIHMISyncSoundReply = (ASIHMISyncSoundReply)iterator.next();
            try {
                aSIHMISyncSoundReply.updateSurroundRange(soundRange, bl);
            }
            catch (MethodException methodException) {}
        }
    }

    public void updateSurroundValue(int n) {
        this.updateSurroundValue(n, true);
    }

    public void updateSurroundValue(int n, boolean bl) {
        this.SurroundValue = n;
        this.SurroundValue_valid = bl;
        List list = this.baseService.getNotifications(32);
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            ASIHMISyncSoundReply aSIHMISyncSoundReply = (ASIHMISyncSoundReply)iterator.next();
            try {
                aSIHMISyncSoundReply.updateSurroundValue(n, bl);
            }
            catch (MethodException methodException) {}
        }
    }

    public void updateNoiseCompensationRange(SoundRange soundRange) {
        this.updateNoiseCompensationRange(soundRange, true);
    }

    public void updateNoiseCompensationRange(SoundRange soundRange, boolean bl) {
        this.NoiseCompensationRange = ASIHMISyncSoundAbstractBaseService.copySoundRange(soundRange);
        this.NoiseCompensationRange_valid = bl;
        List list = this.baseService.getNotifications(22);
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            ASIHMISyncSoundReply aSIHMISyncSoundReply = (ASIHMISyncSoundReply)iterator.next();
            try {
                aSIHMISyncSoundReply.updateNoiseCompensationRange(soundRange, bl);
            }
            catch (MethodException methodException) {}
        }
    }

    public void updateNoiseCompensationValue(int n) {
        this.updateNoiseCompensationValue(n, true);
    }

    public void updateNoiseCompensationValue(int n, boolean bl) {
        this.NoiseCompensationValue = n;
        this.NoiseCompensationValue_valid = bl;
        List list = this.baseService.getNotifications(23);
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            ASIHMISyncSoundReply aSIHMISyncSoundReply = (ASIHMISyncSoundReply)iterator.next();
            try {
                aSIHMISyncSoundReply.updateNoiseCompensationValue(n, bl);
            }
            catch (MethodException methodException) {}
        }
    }

    public void updateThreeDModeRange(SoundRange soundRange) {
        this.updateThreeDModeRange(soundRange, true);
    }

    public void updateThreeDModeRange(SoundRange soundRange, boolean bl) {
        this.ThreeDModeRange = ASIHMISyncSoundAbstractBaseService.copySoundRange(soundRange);
        this.ThreeDModeRange_valid = bl;
        List list = this.baseService.getNotifications(39);
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            ASIHMISyncSoundReply aSIHMISyncSoundReply = (ASIHMISyncSoundReply)iterator.next();
            try {
                aSIHMISyncSoundReply.updateThreeDModeRange(soundRange, bl);
            }
            catch (MethodException methodException) {}
        }
    }

    public void updateThreeDModeValue(int n) {
        this.updateThreeDModeValue(n, true);
    }

    public void updateThreeDModeValue(int n, boolean bl) {
        this.ThreeDModeValue = n;
        this.ThreeDModeValue_valid = bl;
        List list = this.baseService.getNotifications(40);
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            ASIHMISyncSoundReply aSIHMISyncSoundReply = (ASIHMISyncSoundReply)iterator.next();
            try {
                aSIHMISyncSoundReply.updateThreeDModeValue(n, bl);
            }
            catch (MethodException methodException) {}
        }
    }

    public void updatePresetPositionList(int n) {
        this.updatePresetPositionList(n, true);
    }

    public void updatePresetPositionList(int n, boolean bl) {
        this.PresetPositionList = n;
        this.PresetPositionList_valid = bl;
        List list = this.baseService.getNotifications(25);
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            ASIHMISyncSoundReply aSIHMISyncSoundReply = (ASIHMISyncSoundReply)iterator.next();
            try {
                aSIHMISyncSoundReply.updatePresetPositionList(n, bl);
            }
            catch (MethodException methodException) {}
        }
    }

    public void updatePresetPosition(int n) {
        this.updatePresetPosition(n, true);
    }

    public void updatePresetPosition(int n, boolean bl) {
        this.PresetPosition = n;
        this.PresetPosition_valid = bl;
        List list = this.baseService.getNotifications(24);
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            ASIHMISyncSoundReply aSIHMISyncSoundReply = (ASIHMISyncSoundReply)iterator.next();
            try {
                aSIHMISyncSoundReply.updatePresetPosition(n, bl);
            }
            catch (MethodException methodException) {}
        }
    }

    public void updatePresetEQList(int n) {
        this.updatePresetEQList(n, true);
    }

    public void updatePresetEQList(int n, boolean bl) {
        this.PresetEQList = n;
        this.PresetEQList_valid = bl;
        List list = this.baseService.getNotifications(38);
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            ASIHMISyncSoundReply aSIHMISyncSoundReply = (ASIHMISyncSoundReply)iterator.next();
            try {
                aSIHMISyncSoundReply.updatePresetEQList(n, bl);
            }
            catch (MethodException methodException) {}
        }
    }

    public void updatePresetEQ(int n) {
        this.updatePresetEQ(n, true);
    }

    public void updatePresetEQ(int n, boolean bl) {
        this.PresetEQ = n;
        this.PresetEQ_valid = bl;
        List list = this.baseService.getNotifications(37);
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            ASIHMISyncSoundReply aSIHMISyncSoundReply = (ASIHMISyncSoundReply)iterator.next();
            try {
                aSIHMISyncSoundReply.updatePresetEQ(n, bl);
            }
            catch (MethodException methodException) {}
        }
    }
}

