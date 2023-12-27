/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.hmisync.car.climate.impl;

import de.esolutions.fw.comm.asi.hmisync.car.IntBaseType;
import de.esolutions.fw.comm.asi.hmisync.car.climate.ASIHMISyncCarClimateReply;
import de.esolutions.fw.comm.asi.hmisync.car.climate.ASIHMISyncCarClimateS;
import de.esolutions.fw.comm.asi.hmisync.car.climate.impl.ASIHMISyncCarClimateAbstractBaseService$AttributesBitMapProvider;
import de.esolutions.fw.comm.attributes.AttributesBaseService;
import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.method.MethodException;
import java.util.Iterator;
import java.util.List;

public abstract class ASIHMISyncCarClimateAbstractBaseService
implements ASIHMISyncCarClimateS {
    private static final CallContext context = CallContext.getContext("ABSTRACTBASESERVICE.asi.hmisync.car.climate.ASIHMISyncCarClimate");
    private static final int attributesCount;
    private String ASIVersion;
    private boolean ASIVersion_valid = false;
    private short[] RequestIDs;
    private boolean RequestIDs_valid = false;
    private short[] ReplyIDs;
    private boolean ReplyIDs_valid = false;
    private IntBaseType AirconTempZone1;
    private boolean AirconTempZone1_valid = false;
    private IntBaseType AirconTempZone2;
    private boolean AirconTempZone2_valid = false;
    private boolean AirconMaxAC;
    private boolean AirconMaxAC_valid = false;
    private AttributesBaseService baseService;

    public static String copyString(String string) {
        if (string != null) {
            return new String(string);
        }
        return null;
    }

    public static IntBaseType copyIntBaseType(IntBaseType intBaseType) {
        if (intBaseType == null) {
            return null;
        }
        IntBaseType intBaseType2 = new IntBaseType();
        intBaseType2.value = intBaseType.value;
        intBaseType2.unit = intBaseType.unit;
        intBaseType2.status = intBaseType.status;
        return intBaseType2;
    }

    public ASIHMISyncCarClimateAbstractBaseService() {
        ASIHMISyncCarClimateAbstractBaseService$AttributesBitMapProvider aSIHMISyncCarClimateAbstractBaseService$AttributesBitMapProvider = new ASIHMISyncCarClimateAbstractBaseService$AttributesBitMapProvider();
        this.baseService = new AttributesBaseService("ASIHMISyncCarClimate", aSIHMISyncCarClimateAbstractBaseService$AttributesBitMapProvider);
    }

    @Override
    public synchronized void setNotification(long l, ASIHMISyncCarClimateReply aSIHMISyncCarClimateReply) {
        this.baseService.setNotification(l, (Object)aSIHMISyncCarClimateReply);
        this.sendAttributeUpdate(l, aSIHMISyncCarClimateReply);
    }

    @Override
    public synchronized void setNotification(ASIHMISyncCarClimateReply aSIHMISyncCarClimateReply) {
        this.baseService.setNotification(aSIHMISyncCarClimateReply);
        this.sendAttributeUpdate(aSIHMISyncCarClimateReply);
    }

    @Override
    public synchronized void setNotification(long[] lArray, ASIHMISyncCarClimateReply aSIHMISyncCarClimateReply) {
        this.baseService.setNotification(lArray, (Object)aSIHMISyncCarClimateReply);
        this.sendAttributeUpdate(lArray, aSIHMISyncCarClimateReply);
    }

    @Override
    public synchronized void clearNotification(long l, ASIHMISyncCarClimateReply aSIHMISyncCarClimateReply) {
        this.baseService.clearNotification(l, (Object)aSIHMISyncCarClimateReply);
    }

    @Override
    public synchronized void clearNotification(ASIHMISyncCarClimateReply aSIHMISyncCarClimateReply) {
        this.baseService.clearNotification(aSIHMISyncCarClimateReply);
    }

    @Override
    public synchronized void clearNotification(long[] lArray, ASIHMISyncCarClimateReply aSIHMISyncCarClimateReply) {
        this.baseService.clearNotification(lArray, (Object)aSIHMISyncCarClimateReply);
    }

    private void sendAttributeUpdate(ASIHMISyncCarClimateReply aSIHMISyncCarClimateReply) {
        try {
            aSIHMISyncCarClimateReply.updateASIVersion(this.ASIVersion, this.ASIVersion_valid);
            aSIHMISyncCarClimateReply.updateRequestIDs(this.RequestIDs, this.RequestIDs_valid);
            aSIHMISyncCarClimateReply.updateReplyIDs(this.ReplyIDs, this.ReplyIDs_valid);
            aSIHMISyncCarClimateReply.updateAirconTempZone1(this.AirconTempZone1, this.AirconTempZone1_valid);
            aSIHMISyncCarClimateReply.updateAirconTempZone2(this.AirconTempZone2, this.AirconTempZone2_valid);
            aSIHMISyncCarClimateReply.updateAirconMaxAC(this.AirconMaxAC, this.AirconMaxAC_valid);
        }
        catch (MethodException methodException) {
            // empty catch block
        }
    }

    private void sendAttributeUpdate(long[] lArray, ASIHMISyncCarClimateReply aSIHMISyncCarClimateReply) {
        for (int i2 = 0; i2 < lArray.length; ++i2) {
            this.sendAttributeUpdate(lArray[i2], aSIHMISyncCarClimateReply);
        }
    }

    private void sendAttributeUpdate(long l, ASIHMISyncCarClimateReply aSIHMISyncCarClimateReply) {
        try {
            if (l == 0) {
                aSIHMISyncCarClimateReply.updateASIVersion(this.ASIVersion, this.ASIVersion_valid);
            } else if (l == 0) {
                aSIHMISyncCarClimateReply.updateRequestIDs(this.RequestIDs, this.RequestIDs_valid);
            } else if (l == 0) {
                aSIHMISyncCarClimateReply.updateReplyIDs(this.ReplyIDs, this.ReplyIDs_valid);
            } else if (l == 0) {
                aSIHMISyncCarClimateReply.updateAirconTempZone1(this.AirconTempZone1, this.AirconTempZone1_valid);
            } else if (l == 0) {
                aSIHMISyncCarClimateReply.updateAirconTempZone2(this.AirconTempZone2, this.AirconTempZone2_valid);
            } else if (l == 0) {
                aSIHMISyncCarClimateReply.updateAirconMaxAC(this.AirconMaxAC, this.AirconMaxAC_valid);
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
        this.ASIVersion = ASIHMISyncCarClimateAbstractBaseService.copyString(string);
        this.ASIVersion_valid = bl;
        List list = this.baseService.getNotifications(7);
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            ASIHMISyncCarClimateReply aSIHMISyncCarClimateReply = (ASIHMISyncCarClimateReply)iterator.next();
            try {
                aSIHMISyncCarClimateReply.updateASIVersion(string, bl);
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
        List list = this.baseService.getNotifications(12);
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            ASIHMISyncCarClimateReply aSIHMISyncCarClimateReply = (ASIHMISyncCarClimateReply)iterator.next();
            try {
                aSIHMISyncCarClimateReply.updateRequestIDs(sArray, bl);
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
        List list = this.baseService.getNotifications(11);
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            ASIHMISyncCarClimateReply aSIHMISyncCarClimateReply = (ASIHMISyncCarClimateReply)iterator.next();
            try {
                aSIHMISyncCarClimateReply.updateReplyIDs(sArray, bl);
            }
            catch (MethodException methodException) {}
        }
    }

    public void updateAirconTempZone1(IntBaseType intBaseType) {
        this.updateAirconTempZone1(intBaseType, true);
    }

    public void updateAirconTempZone1(IntBaseType intBaseType, boolean bl) {
        this.AirconTempZone1 = ASIHMISyncCarClimateAbstractBaseService.copyIntBaseType(intBaseType);
        this.AirconTempZone1_valid = bl;
        List list = this.baseService.getNotifications(9);
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            ASIHMISyncCarClimateReply aSIHMISyncCarClimateReply = (ASIHMISyncCarClimateReply)iterator.next();
            try {
                aSIHMISyncCarClimateReply.updateAirconTempZone1(intBaseType, bl);
            }
            catch (MethodException methodException) {}
        }
    }

    public void updateAirconTempZone2(IntBaseType intBaseType) {
        this.updateAirconTempZone2(intBaseType, true);
    }

    public void updateAirconTempZone2(IntBaseType intBaseType, boolean bl) {
        this.AirconTempZone2 = ASIHMISyncCarClimateAbstractBaseService.copyIntBaseType(intBaseType);
        this.AirconTempZone2_valid = bl;
        List list = this.baseService.getNotifications(10);
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            ASIHMISyncCarClimateReply aSIHMISyncCarClimateReply = (ASIHMISyncCarClimateReply)iterator.next();
            try {
                aSIHMISyncCarClimateReply.updateAirconTempZone2(intBaseType, bl);
            }
            catch (MethodException methodException) {}
        }
    }

    public void updateAirconMaxAC(boolean bl) {
        this.updateAirconMaxAC(bl, true);
    }

    public void updateAirconMaxAC(boolean bl, boolean bl2) {
        this.AirconMaxAC = bl;
        this.AirconMaxAC_valid = bl2;
        List list = this.baseService.getNotifications(8);
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            ASIHMISyncCarClimateReply aSIHMISyncCarClimateReply = (ASIHMISyncCarClimateReply)iterator.next();
            try {
                aSIHMISyncCarClimateReply.updateAirconMaxAC(bl, bl2);
            }
            catch (MethodException methodException) {}
        }
    }
}

