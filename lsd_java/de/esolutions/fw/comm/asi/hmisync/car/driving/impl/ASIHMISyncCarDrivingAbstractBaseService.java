/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.hmisync.car.driving.impl;

import de.esolutions.fw.comm.asi.hmisync.car.driving.ASIHMISyncCarDrivingReply;
import de.esolutions.fw.comm.asi.hmisync.car.driving.ASIHMISyncCarDrivingS;
import de.esolutions.fw.comm.asi.hmisync.car.driving.TADConfiguration;
import de.esolutions.fw.comm.asi.hmisync.car.driving.TADVehicleInfo;
import de.esolutions.fw.comm.asi.hmisync.car.driving.impl.ASIHMISyncCarDrivingAbstractBaseService$AttributesBitMapProvider;
import de.esolutions.fw.comm.attributes.AttributesBaseService;
import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.method.MethodException;
import java.util.Iterator;
import java.util.List;

public abstract class ASIHMISyncCarDrivingAbstractBaseService
implements ASIHMISyncCarDrivingS {
    private static final CallContext context = CallContext.getContext("ABSTRACTBASESERVICE.asi.hmisync.car.driving.ASIHMISyncCarDriving");
    private static final int attributesCount;
    private String ASIVersion;
    private boolean ASIVersion_valid = false;
    private short[] RequestIDs;
    private boolean RequestIDs_valid = false;
    private short[] ReplyIDs;
    private boolean ReplyIDs_valid = false;
    private TADVehicleInfo TADVehicleInfo;
    private boolean TADVehicleInfo_valid = false;
    private TADConfiguration TADConfiguration;
    private boolean TADConfiguration_valid = false;
    private float TADCurrentRollAngle;
    private boolean TADCurrentRollAngle_valid = false;
    private float TADPosMaxRollAngle;
    private boolean TADPosMaxRollAngle_valid = false;
    private float TADNegMaxRollAngle;
    private boolean TADNegMaxRollAngle_valid = false;
    private float TADCurrentPitchAngle;
    private boolean TADCurrentPitchAngle_valid = false;
    private float TADPosMaxPitch;
    private boolean TADPosMaxPitch_valid = false;
    private float TADNegMaxPitch;
    private boolean TADNegMaxPitch_valid = false;
    private int TADVisibilityState;
    private boolean TADVisibilityState_valid = false;
    private int SuspensionControlCurrentLevel;
    private boolean SuspensionControlCurrentLevel_valid = false;
    private int SuspensionControlTargetLevel;
    private boolean SuspensionControlTargetLevel_valid = false;
    private int[] SuspensionVisibilityState;
    private boolean SuspensionVisibilityState_valid = false;
    private int DriveSelectActiveProfile;
    private boolean DriveSelectActiveProfile_valid = false;
    private int DriveSelectActiveProfileVisibilityState;
    private boolean DriveSelectActiveProfileVisibilityState_valid = false;
    private AttributesBaseService baseService;

    public static String copyString(String string) {
        if (string != null) {
            return new String(string);
        }
        return null;
    }

    public static TADVehicleInfo copyTADVehicleInfo(TADVehicleInfo tADVehicleInfo) {
        if (tADVehicleInfo == null) {
            return null;
        }
        TADVehicleInfo tADVehicleInfo2 = new TADVehicleInfo();
        tADVehicleInfo2.roofLoad = tADVehicleInfo.roofLoad;
        tADVehicleInfo2.trailer = tADVehicleInfo.trailer;
        return tADVehicleInfo2;
    }

    public static TADConfiguration copyTADConfiguration(TADConfiguration tADConfiguration) {
        if (tADConfiguration == null) {
            return null;
        }
        TADConfiguration tADConfiguration2 = new TADConfiguration();
        tADConfiguration2.rollAngleMaxScale = tADConfiguration.rollAngleMaxScale;
        tADConfiguration2.rollAngleStartSoftWarning = tADConfiguration.rollAngleStartSoftWarning;
        tADConfiguration2.rollAngleStartHardWarning = tADConfiguration.rollAngleStartHardWarning;
        tADConfiguration2.pitchAngleMaxScale = tADConfiguration.pitchAngleMaxScale;
        tADConfiguration2.pitchAngleStartSoftWarning = tADConfiguration.pitchAngleStartSoftWarning;
        tADConfiguration2.pitchAngleStartHardWarning = tADConfiguration.pitchAngleStartHardWarning;
        tADConfiguration2.rollAngleInstallation = tADConfiguration.rollAngleInstallation;
        tADConfiguration2.pitchAngleInstallation = tADConfiguration.pitchAngleInstallation;
        return tADConfiguration2;
    }

    public ASIHMISyncCarDrivingAbstractBaseService() {
        ASIHMISyncCarDrivingAbstractBaseService$AttributesBitMapProvider aSIHMISyncCarDrivingAbstractBaseService$AttributesBitMapProvider = new ASIHMISyncCarDrivingAbstractBaseService$AttributesBitMapProvider();
        this.baseService = new AttributesBaseService("ASIHMISyncCarDriving", aSIHMISyncCarDrivingAbstractBaseService$AttributesBitMapProvider);
    }

    @Override
    public synchronized void setNotification(long l, ASIHMISyncCarDrivingReply aSIHMISyncCarDrivingReply) {
        this.baseService.setNotification(l, (Object)aSIHMISyncCarDrivingReply);
        this.sendAttributeUpdate(l, aSIHMISyncCarDrivingReply);
    }

    @Override
    public synchronized void setNotification(ASIHMISyncCarDrivingReply aSIHMISyncCarDrivingReply) {
        this.baseService.setNotification(aSIHMISyncCarDrivingReply);
        this.sendAttributeUpdate(aSIHMISyncCarDrivingReply);
    }

    @Override
    public synchronized void setNotification(long[] lArray, ASIHMISyncCarDrivingReply aSIHMISyncCarDrivingReply) {
        this.baseService.setNotification(lArray, (Object)aSIHMISyncCarDrivingReply);
        this.sendAttributeUpdate(lArray, aSIHMISyncCarDrivingReply);
    }

    @Override
    public synchronized void clearNotification(long l, ASIHMISyncCarDrivingReply aSIHMISyncCarDrivingReply) {
        this.baseService.clearNotification(l, (Object)aSIHMISyncCarDrivingReply);
    }

    @Override
    public synchronized void clearNotification(ASIHMISyncCarDrivingReply aSIHMISyncCarDrivingReply) {
        this.baseService.clearNotification(aSIHMISyncCarDrivingReply);
    }

    @Override
    public synchronized void clearNotification(long[] lArray, ASIHMISyncCarDrivingReply aSIHMISyncCarDrivingReply) {
        this.baseService.clearNotification(lArray, (Object)aSIHMISyncCarDrivingReply);
    }

    private void sendAttributeUpdate(ASIHMISyncCarDrivingReply aSIHMISyncCarDrivingReply) {
        try {
            aSIHMISyncCarDrivingReply.updateASIVersion(this.ASIVersion, this.ASIVersion_valid);
            aSIHMISyncCarDrivingReply.updateRequestIDs(this.RequestIDs, this.RequestIDs_valid);
            aSIHMISyncCarDrivingReply.updateReplyIDs(this.ReplyIDs, this.ReplyIDs_valid);
            aSIHMISyncCarDrivingReply.updateTADVehicleInfo(this.TADVehicleInfo, this.TADVehicleInfo_valid);
            aSIHMISyncCarDrivingReply.updateTADConfiguration(this.TADConfiguration, this.TADConfiguration_valid);
            aSIHMISyncCarDrivingReply.updateTADCurrentRollAngle(this.TADCurrentRollAngle, this.TADCurrentRollAngle_valid);
            aSIHMISyncCarDrivingReply.updateTADPosMaxRollAngle(this.TADPosMaxRollAngle, this.TADPosMaxRollAngle_valid);
            aSIHMISyncCarDrivingReply.updateTADNegMaxRollAngle(this.TADNegMaxRollAngle, this.TADNegMaxRollAngle_valid);
            aSIHMISyncCarDrivingReply.updateTADCurrentPitchAngle(this.TADCurrentPitchAngle, this.TADCurrentPitchAngle_valid);
            aSIHMISyncCarDrivingReply.updateTADPosMaxPitch(this.TADPosMaxPitch, this.TADPosMaxPitch_valid);
            aSIHMISyncCarDrivingReply.updateTADNegMaxPitch(this.TADNegMaxPitch, this.TADNegMaxPitch_valid);
            aSIHMISyncCarDrivingReply.updateTADVisibilityState(this.TADVisibilityState, this.TADVisibilityState_valid);
            aSIHMISyncCarDrivingReply.updateSuspensionControlCurrentLevel(this.SuspensionControlCurrentLevel, this.SuspensionControlCurrentLevel_valid);
            aSIHMISyncCarDrivingReply.updateSuspensionControlTargetLevel(this.SuspensionControlTargetLevel, this.SuspensionControlTargetLevel_valid);
            aSIHMISyncCarDrivingReply.updateSuspensionVisibilityState(this.SuspensionVisibilityState, this.SuspensionVisibilityState_valid);
            aSIHMISyncCarDrivingReply.updateDriveSelectActiveProfile(this.DriveSelectActiveProfile, this.DriveSelectActiveProfile_valid);
            aSIHMISyncCarDrivingReply.updateDriveSelectActiveProfileVisibilityState(this.DriveSelectActiveProfileVisibilityState, this.DriveSelectActiveProfileVisibilityState_valid);
        }
        catch (MethodException methodException) {
            // empty catch block
        }
    }

    private void sendAttributeUpdate(long[] lArray, ASIHMISyncCarDrivingReply aSIHMISyncCarDrivingReply) {
        for (int i2 = 0; i2 < lArray.length; ++i2) {
            this.sendAttributeUpdate(lArray[i2], aSIHMISyncCarDrivingReply);
        }
    }

    private void sendAttributeUpdate(long l, ASIHMISyncCarDrivingReply aSIHMISyncCarDrivingReply) {
        try {
            if (l == 0) {
                aSIHMISyncCarDrivingReply.updateASIVersion(this.ASIVersion, this.ASIVersion_valid);
            } else if (l == 0) {
                aSIHMISyncCarDrivingReply.updateRequestIDs(this.RequestIDs, this.RequestIDs_valid);
            } else if (l == 0) {
                aSIHMISyncCarDrivingReply.updateReplyIDs(this.ReplyIDs, this.ReplyIDs_valid);
            } else if (l == 0) {
                aSIHMISyncCarDrivingReply.updateTADVehicleInfo(this.TADVehicleInfo, this.TADVehicleInfo_valid);
            } else if (l == 0) {
                aSIHMISyncCarDrivingReply.updateTADConfiguration(this.TADConfiguration, this.TADConfiguration_valid);
            } else if (l == 0) {
                aSIHMISyncCarDrivingReply.updateTADCurrentRollAngle(this.TADCurrentRollAngle, this.TADCurrentRollAngle_valid);
            } else if (l == 0) {
                aSIHMISyncCarDrivingReply.updateTADPosMaxRollAngle(this.TADPosMaxRollAngle, this.TADPosMaxRollAngle_valid);
            } else if (l == 0) {
                aSIHMISyncCarDrivingReply.updateTADNegMaxRollAngle(this.TADNegMaxRollAngle, this.TADNegMaxRollAngle_valid);
            } else if (l == 0) {
                aSIHMISyncCarDrivingReply.updateTADCurrentPitchAngle(this.TADCurrentPitchAngle, this.TADCurrentPitchAngle_valid);
            } else if (l == 0) {
                aSIHMISyncCarDrivingReply.updateTADPosMaxPitch(this.TADPosMaxPitch, this.TADPosMaxPitch_valid);
            } else if (l == 0) {
                aSIHMISyncCarDrivingReply.updateTADNegMaxPitch(this.TADNegMaxPitch, this.TADNegMaxPitch_valid);
            } else if (l == 0) {
                aSIHMISyncCarDrivingReply.updateTADVisibilityState(this.TADVisibilityState, this.TADVisibilityState_valid);
            } else if (l == 0) {
                aSIHMISyncCarDrivingReply.updateSuspensionControlCurrentLevel(this.SuspensionControlCurrentLevel, this.SuspensionControlCurrentLevel_valid);
            } else if (l == 0) {
                aSIHMISyncCarDrivingReply.updateSuspensionControlTargetLevel(this.SuspensionControlTargetLevel, this.SuspensionControlTargetLevel_valid);
            } else if (l == 0) {
                aSIHMISyncCarDrivingReply.updateSuspensionVisibilityState(this.SuspensionVisibilityState, this.SuspensionVisibilityState_valid);
            } else if (l == 0) {
                aSIHMISyncCarDrivingReply.updateDriveSelectActiveProfile(this.DriveSelectActiveProfile, this.DriveSelectActiveProfile_valid);
            } else if (l == 0) {
                aSIHMISyncCarDrivingReply.updateDriveSelectActiveProfileVisibilityState(this.DriveSelectActiveProfileVisibilityState, this.DriveSelectActiveProfileVisibilityState_valid);
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
        this.ASIVersion = ASIHMISyncCarDrivingAbstractBaseService.copyString(string);
        this.ASIVersion_valid = bl;
        List list = this.baseService.getNotifications(6);
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            ASIHMISyncCarDrivingReply aSIHMISyncCarDrivingReply = (ASIHMISyncCarDrivingReply)iterator.next();
            try {
                aSIHMISyncCarDrivingReply.updateASIVersion(string, bl);
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
        List list = this.baseService.getNotifications(10);
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            ASIHMISyncCarDrivingReply aSIHMISyncCarDrivingReply = (ASIHMISyncCarDrivingReply)iterator.next();
            try {
                aSIHMISyncCarDrivingReply.updateRequestIDs(sArray, bl);
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
        List list = this.baseService.getNotifications(9);
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            ASIHMISyncCarDrivingReply aSIHMISyncCarDrivingReply = (ASIHMISyncCarDrivingReply)iterator.next();
            try {
                aSIHMISyncCarDrivingReply.updateReplyIDs(sArray, bl);
            }
            catch (MethodException methodException) {}
        }
    }

    public void updateTADVehicleInfo(TADVehicleInfo tADVehicleInfo) {
        this.updateTADVehicleInfo(tADVehicleInfo, true);
    }

    public void updateTADVehicleInfo(TADVehicleInfo tADVehicleInfo, boolean bl) {
        this.TADVehicleInfo = ASIHMISyncCarDrivingAbstractBaseService.copyTADVehicleInfo(tADVehicleInfo);
        this.TADVehicleInfo_valid = bl;
        List list = this.baseService.getNotifications(20);
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            ASIHMISyncCarDrivingReply aSIHMISyncCarDrivingReply = (ASIHMISyncCarDrivingReply)iterator.next();
            try {
                aSIHMISyncCarDrivingReply.updateTADVehicleInfo(tADVehicleInfo, bl);
            }
            catch (MethodException methodException) {}
        }
    }

    public void updateTADConfiguration(TADConfiguration tADConfiguration) {
        this.updateTADConfiguration(tADConfiguration, true);
    }

    public void updateTADConfiguration(TADConfiguration tADConfiguration, boolean bl) {
        this.TADConfiguration = ASIHMISyncCarDrivingAbstractBaseService.copyTADConfiguration(tADConfiguration);
        this.TADConfiguration_valid = bl;
        List list = this.baseService.getNotifications(22);
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            ASIHMISyncCarDrivingReply aSIHMISyncCarDrivingReply = (ASIHMISyncCarDrivingReply)iterator.next();
            try {
                aSIHMISyncCarDrivingReply.updateTADConfiguration(tADConfiguration, bl);
            }
            catch (MethodException methodException) {}
        }
    }

    public void updateTADCurrentRollAngle(float f2) {
        this.updateTADCurrentRollAngle(f2, true);
    }

    public void updateTADCurrentRollAngle(float f2, boolean bl) {
        this.TADCurrentRollAngle = f2;
        this.TADCurrentRollAngle_valid = bl;
        List list = this.baseService.getNotifications(15);
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            ASIHMISyncCarDrivingReply aSIHMISyncCarDrivingReply = (ASIHMISyncCarDrivingReply)iterator.next();
            try {
                aSIHMISyncCarDrivingReply.updateTADCurrentRollAngle(f2, bl);
            }
            catch (MethodException methodException) {}
        }
    }

    public void updateTADPosMaxRollAngle(float f2) {
        this.updateTADPosMaxRollAngle(f2, true);
    }

    public void updateTADPosMaxRollAngle(float f2, boolean bl) {
        this.TADPosMaxRollAngle = f2;
        this.TADPosMaxRollAngle_valid = bl;
        List list = this.baseService.getNotifications(19);
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            ASIHMISyncCarDrivingReply aSIHMISyncCarDrivingReply = (ASIHMISyncCarDrivingReply)iterator.next();
            try {
                aSIHMISyncCarDrivingReply.updateTADPosMaxRollAngle(f2, bl);
            }
            catch (MethodException methodException) {}
        }
    }

    public void updateTADNegMaxRollAngle(float f2) {
        this.updateTADNegMaxRollAngle(f2, true);
    }

    public void updateTADNegMaxRollAngle(float f2, boolean bl) {
        this.TADNegMaxRollAngle = f2;
        this.TADNegMaxRollAngle_valid = bl;
        List list = this.baseService.getNotifications(17);
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            ASIHMISyncCarDrivingReply aSIHMISyncCarDrivingReply = (ASIHMISyncCarDrivingReply)iterator.next();
            try {
                aSIHMISyncCarDrivingReply.updateTADNegMaxRollAngle(f2, bl);
            }
            catch (MethodException methodException) {}
        }
    }

    public void updateTADCurrentPitchAngle(float f2) {
        this.updateTADCurrentPitchAngle(f2, true);
    }

    public void updateTADCurrentPitchAngle(float f2, boolean bl) {
        this.TADCurrentPitchAngle = f2;
        this.TADCurrentPitchAngle_valid = bl;
        List list = this.baseService.getNotifications(14);
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            ASIHMISyncCarDrivingReply aSIHMISyncCarDrivingReply = (ASIHMISyncCarDrivingReply)iterator.next();
            try {
                aSIHMISyncCarDrivingReply.updateTADCurrentPitchAngle(f2, bl);
            }
            catch (MethodException methodException) {}
        }
    }

    public void updateTADPosMaxPitch(float f2) {
        this.updateTADPosMaxPitch(f2, true);
    }

    public void updateTADPosMaxPitch(float f2, boolean bl) {
        this.TADPosMaxPitch = f2;
        this.TADPosMaxPitch_valid = bl;
        List list = this.baseService.getNotifications(18);
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            ASIHMISyncCarDrivingReply aSIHMISyncCarDrivingReply = (ASIHMISyncCarDrivingReply)iterator.next();
            try {
                aSIHMISyncCarDrivingReply.updateTADPosMaxPitch(f2, bl);
            }
            catch (MethodException methodException) {}
        }
    }

    public void updateTADNegMaxPitch(float f2) {
        this.updateTADNegMaxPitch(f2, true);
    }

    public void updateTADNegMaxPitch(float f2, boolean bl) {
        this.TADNegMaxPitch = f2;
        this.TADNegMaxPitch_valid = bl;
        List list = this.baseService.getNotifications(16);
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            ASIHMISyncCarDrivingReply aSIHMISyncCarDrivingReply = (ASIHMISyncCarDrivingReply)iterator.next();
            try {
                aSIHMISyncCarDrivingReply.updateTADNegMaxPitch(f2, bl);
            }
            catch (MethodException methodException) {}
        }
    }

    public void updateTADVisibilityState(int n) {
        this.updateTADVisibilityState(n, true);
    }

    public void updateTADVisibilityState(int n, boolean bl) {
        this.TADVisibilityState = n;
        this.TADVisibilityState_valid = bl;
        List list = this.baseService.getNotifications(21);
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            ASIHMISyncCarDrivingReply aSIHMISyncCarDrivingReply = (ASIHMISyncCarDrivingReply)iterator.next();
            try {
                aSIHMISyncCarDrivingReply.updateTADVisibilityState(n, bl);
            }
            catch (MethodException methodException) {}
        }
    }

    public void updateSuspensionControlCurrentLevel(int n) {
        this.updateSuspensionControlCurrentLevel(n, true);
    }

    public void updateSuspensionControlCurrentLevel(int n, boolean bl) {
        this.SuspensionControlCurrentLevel = n;
        this.SuspensionControlCurrentLevel_valid = bl;
        List list = this.baseService.getNotifications(11);
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            ASIHMISyncCarDrivingReply aSIHMISyncCarDrivingReply = (ASIHMISyncCarDrivingReply)iterator.next();
            try {
                aSIHMISyncCarDrivingReply.updateSuspensionControlCurrentLevel(n, bl);
            }
            catch (MethodException methodException) {}
        }
    }

    public void updateSuspensionControlTargetLevel(int n) {
        this.updateSuspensionControlTargetLevel(n, true);
    }

    public void updateSuspensionControlTargetLevel(int n, boolean bl) {
        this.SuspensionControlTargetLevel = n;
        this.SuspensionControlTargetLevel_valid = bl;
        List list = this.baseService.getNotifications(12);
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            ASIHMISyncCarDrivingReply aSIHMISyncCarDrivingReply = (ASIHMISyncCarDrivingReply)iterator.next();
            try {
                aSIHMISyncCarDrivingReply.updateSuspensionControlTargetLevel(n, bl);
            }
            catch (MethodException methodException) {}
        }
    }

    public void updateSuspensionVisibilityState(int[] nArray) {
        this.updateSuspensionVisibilityState(nArray, true);
    }

    public void updateSuspensionVisibilityState(int[] nArray, boolean bl) {
        if (nArray != null) {
            this.SuspensionVisibilityState = new int[nArray.length];
            System.arraycopy((Object)nArray, 0, (Object)this.SuspensionVisibilityState, 0, nArray.length);
        } else {
            this.SuspensionVisibilityState = null;
        }
        this.SuspensionVisibilityState_valid = bl;
        List list = this.baseService.getNotifications(13);
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            ASIHMISyncCarDrivingReply aSIHMISyncCarDrivingReply = (ASIHMISyncCarDrivingReply)iterator.next();
            try {
                aSIHMISyncCarDrivingReply.updateSuspensionVisibilityState(nArray, bl);
            }
            catch (MethodException methodException) {}
        }
    }

    public void updateDriveSelectActiveProfile(int n) {
        this.updateDriveSelectActiveProfile(n, true);
    }

    public void updateDriveSelectActiveProfile(int n, boolean bl) {
        this.DriveSelectActiveProfile = n;
        this.DriveSelectActiveProfile_valid = bl;
        List list = this.baseService.getNotifications(7);
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            ASIHMISyncCarDrivingReply aSIHMISyncCarDrivingReply = (ASIHMISyncCarDrivingReply)iterator.next();
            try {
                aSIHMISyncCarDrivingReply.updateDriveSelectActiveProfile(n, bl);
            }
            catch (MethodException methodException) {}
        }
    }

    public void updateDriveSelectActiveProfileVisibilityState(int n) {
        this.updateDriveSelectActiveProfileVisibilityState(n, true);
    }

    public void updateDriveSelectActiveProfileVisibilityState(int n, boolean bl) {
        this.DriveSelectActiveProfileVisibilityState = n;
        this.DriveSelectActiveProfileVisibilityState_valid = bl;
        List list = this.baseService.getNotifications(8);
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            ASIHMISyncCarDrivingReply aSIHMISyncCarDrivingReply = (ASIHMISyncCarDrivingReply)iterator.next();
            try {
                aSIHMISyncCarDrivingReply.updateDriveSelectActiveProfileVisibilityState(n, bl);
            }
            catch (MethodException methodException) {}
        }
    }
}

