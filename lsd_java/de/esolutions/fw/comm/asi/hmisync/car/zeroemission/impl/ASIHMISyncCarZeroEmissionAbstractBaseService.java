/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.hmisync.car.zeroemission.impl;

import de.esolutions.fw.comm.asi.hmisync.car.zeroemission.ASIHMISyncCarZeroEmissionReply;
import de.esolutions.fw.comm.asi.hmisync.car.zeroemission.ASIHMISyncCarZeroEmissionS;
import de.esolutions.fw.comm.asi.hmisync.car.zeroemission.ZeroEmissionEntry;
import de.esolutions.fw.comm.asi.hmisync.car.zeroemission.impl.ASIHMISyncCarZeroEmissionAbstractBaseService$AttributesBitMapProvider;
import de.esolutions.fw.comm.attributes.AttributesBaseService;
import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.method.MethodException;
import java.util.Iterator;
import java.util.List;

public abstract class ASIHMISyncCarZeroEmissionAbstractBaseService
implements ASIHMISyncCarZeroEmissionS {
    private static final CallContext context = CallContext.getContext("ABSTRACTBASESERVICE.asi.hmisync.car.zeroemission.ASIHMISyncCarZeroEmission");
    private static final int attributesCount;
    private String ASIVersion;
    private boolean ASIVersion_valid = false;
    private short[] RequestIDs;
    private boolean RequestIDs_valid = false;
    private short[] ReplyIDs;
    private boolean ReplyIDs_valid = false;
    private int ZEVisibilityState;
    private boolean ZEVisibilityState_valid = false;
    private ZeroEmissionEntry[] ZeroEmissionValues;
    private boolean ZeroEmissionValues_valid = false;
    private ZeroEmissionEntry CurrentZeroEmissionValue;
    private boolean CurrentZeroEmissionValue_valid = false;
    private AttributesBaseService baseService;

    public static String copyString(String string) {
        if (string != null) {
            return new String(string);
        }
        return null;
    }

    public static ZeroEmissionEntry copyZeroEmissionEntry(ZeroEmissionEntry zeroEmissionEntry) {
        if (zeroEmissionEntry == null) {
            return null;
        }
        ZeroEmissionEntry zeroEmissionEntry2 = new ZeroEmissionEntry();
        if (zeroEmissionEntry.values != null) {
            zeroEmissionEntry2.values = new short[zeroEmissionEntry.values.length];
            System.arraycopy((Object)zeroEmissionEntry.values, 0, (Object)zeroEmissionEntry2.values, 0, zeroEmissionEntry2.values.length);
        } else {
            zeroEmissionEntry2.values = null;
        }
        zeroEmissionEntry2.state = zeroEmissionEntry.state;
        return zeroEmissionEntry2;
    }

    public ASIHMISyncCarZeroEmissionAbstractBaseService() {
        ASIHMISyncCarZeroEmissionAbstractBaseService$AttributesBitMapProvider aSIHMISyncCarZeroEmissionAbstractBaseService$AttributesBitMapProvider = new ASIHMISyncCarZeroEmissionAbstractBaseService$AttributesBitMapProvider();
        this.baseService = new AttributesBaseService("ASIHMISyncCarZeroEmission", aSIHMISyncCarZeroEmissionAbstractBaseService$AttributesBitMapProvider);
    }

    @Override
    public synchronized void setNotification(long l, ASIHMISyncCarZeroEmissionReply aSIHMISyncCarZeroEmissionReply) {
        this.baseService.setNotification(l, (Object)aSIHMISyncCarZeroEmissionReply);
        this.sendAttributeUpdate(l, aSIHMISyncCarZeroEmissionReply);
    }

    @Override
    public synchronized void setNotification(ASIHMISyncCarZeroEmissionReply aSIHMISyncCarZeroEmissionReply) {
        this.baseService.setNotification(aSIHMISyncCarZeroEmissionReply);
        this.sendAttributeUpdate(aSIHMISyncCarZeroEmissionReply);
    }

    @Override
    public synchronized void setNotification(long[] lArray, ASIHMISyncCarZeroEmissionReply aSIHMISyncCarZeroEmissionReply) {
        this.baseService.setNotification(lArray, (Object)aSIHMISyncCarZeroEmissionReply);
        this.sendAttributeUpdate(lArray, aSIHMISyncCarZeroEmissionReply);
    }

    @Override
    public synchronized void clearNotification(long l, ASIHMISyncCarZeroEmissionReply aSIHMISyncCarZeroEmissionReply) {
        this.baseService.clearNotification(l, (Object)aSIHMISyncCarZeroEmissionReply);
    }

    @Override
    public synchronized void clearNotification(ASIHMISyncCarZeroEmissionReply aSIHMISyncCarZeroEmissionReply) {
        this.baseService.clearNotification(aSIHMISyncCarZeroEmissionReply);
    }

    @Override
    public synchronized void clearNotification(long[] lArray, ASIHMISyncCarZeroEmissionReply aSIHMISyncCarZeroEmissionReply) {
        this.baseService.clearNotification(lArray, (Object)aSIHMISyncCarZeroEmissionReply);
    }

    private void sendAttributeUpdate(ASIHMISyncCarZeroEmissionReply aSIHMISyncCarZeroEmissionReply) {
        try {
            aSIHMISyncCarZeroEmissionReply.updateASIVersion(this.ASIVersion, this.ASIVersion_valid);
            aSIHMISyncCarZeroEmissionReply.updateRequestIDs(this.RequestIDs, this.RequestIDs_valid);
            aSIHMISyncCarZeroEmissionReply.updateReplyIDs(this.ReplyIDs, this.ReplyIDs_valid);
            aSIHMISyncCarZeroEmissionReply.updateZEVisibilityState(this.ZEVisibilityState, this.ZEVisibilityState_valid);
            aSIHMISyncCarZeroEmissionReply.updateZeroEmissionValues(this.ZeroEmissionValues, this.ZeroEmissionValues_valid);
            aSIHMISyncCarZeroEmissionReply.updateCurrentZeroEmissionValue(this.CurrentZeroEmissionValue, this.CurrentZeroEmissionValue_valid);
        }
        catch (MethodException methodException) {
            // empty catch block
        }
    }

    private void sendAttributeUpdate(long[] lArray, ASIHMISyncCarZeroEmissionReply aSIHMISyncCarZeroEmissionReply) {
        for (int i2 = 0; i2 < lArray.length; ++i2) {
            this.sendAttributeUpdate(lArray[i2], aSIHMISyncCarZeroEmissionReply);
        }
    }

    private void sendAttributeUpdate(long l, ASIHMISyncCarZeroEmissionReply aSIHMISyncCarZeroEmissionReply) {
        try {
            if (l == 0) {
                aSIHMISyncCarZeroEmissionReply.updateASIVersion(this.ASIVersion, this.ASIVersion_valid);
            } else if (l == 0) {
                aSIHMISyncCarZeroEmissionReply.updateRequestIDs(this.RequestIDs, this.RequestIDs_valid);
            } else if (l == 0) {
                aSIHMISyncCarZeroEmissionReply.updateReplyIDs(this.ReplyIDs, this.ReplyIDs_valid);
            } else if (l == 0) {
                aSIHMISyncCarZeroEmissionReply.updateZEVisibilityState(this.ZEVisibilityState, this.ZEVisibilityState_valid);
            } else if (l == 0) {
                aSIHMISyncCarZeroEmissionReply.updateZeroEmissionValues(this.ZeroEmissionValues, this.ZeroEmissionValues_valid);
            } else if (l == 0) {
                aSIHMISyncCarZeroEmissionReply.updateCurrentZeroEmissionValue(this.CurrentZeroEmissionValue, this.CurrentZeroEmissionValue_valid);
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
        this.ASIVersion = ASIHMISyncCarZeroEmissionAbstractBaseService.copyString(string);
        this.ASIVersion_valid = bl;
        List list = this.baseService.getNotifications(6);
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            ASIHMISyncCarZeroEmissionReply aSIHMISyncCarZeroEmissionReply = (ASIHMISyncCarZeroEmissionReply)iterator.next();
            try {
                aSIHMISyncCarZeroEmissionReply.updateASIVersion(string, bl);
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
        List list = this.baseService.getNotifications(9);
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            ASIHMISyncCarZeroEmissionReply aSIHMISyncCarZeroEmissionReply = (ASIHMISyncCarZeroEmissionReply)iterator.next();
            try {
                aSIHMISyncCarZeroEmissionReply.updateRequestIDs(sArray, bl);
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
        List list = this.baseService.getNotifications(8);
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            ASIHMISyncCarZeroEmissionReply aSIHMISyncCarZeroEmissionReply = (ASIHMISyncCarZeroEmissionReply)iterator.next();
            try {
                aSIHMISyncCarZeroEmissionReply.updateReplyIDs(sArray, bl);
            }
            catch (MethodException methodException) {}
        }
    }

    public void updateZEVisibilityState(int n) {
        this.updateZEVisibilityState(n, true);
    }

    public void updateZEVisibilityState(int n, boolean bl) {
        this.ZEVisibilityState = n;
        this.ZEVisibilityState_valid = bl;
        List list = this.baseService.getNotifications(11);
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            ASIHMISyncCarZeroEmissionReply aSIHMISyncCarZeroEmissionReply = (ASIHMISyncCarZeroEmissionReply)iterator.next();
            try {
                aSIHMISyncCarZeroEmissionReply.updateZEVisibilityState(n, bl);
            }
            catch (MethodException methodException) {}
        }
    }

    public void updateZeroEmissionValues(ZeroEmissionEntry[] zeroEmissionEntryArray) {
        this.updateZeroEmissionValues(zeroEmissionEntryArray, true);
    }

    public void updateZeroEmissionValues(ZeroEmissionEntry[] zeroEmissionEntryArray, boolean bl) {
        if (zeroEmissionEntryArray != null) {
            this.ZeroEmissionValues = new ZeroEmissionEntry[zeroEmissionEntryArray.length];
            for (int i2 = 0; i2 < zeroEmissionEntryArray.length; ++i2) {
                this.ZeroEmissionValues[i2] = ASIHMISyncCarZeroEmissionAbstractBaseService.copyZeroEmissionEntry(zeroEmissionEntryArray[i2]);
            }
        } else {
            this.ZeroEmissionValues = null;
        }
        this.ZeroEmissionValues_valid = bl;
        List list = this.baseService.getNotifications(10);
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            ASIHMISyncCarZeroEmissionReply aSIHMISyncCarZeroEmissionReply = (ASIHMISyncCarZeroEmissionReply)iterator.next();
            try {
                aSIHMISyncCarZeroEmissionReply.updateZeroEmissionValues(zeroEmissionEntryArray, bl);
            }
            catch (MethodException methodException) {}
        }
    }

    public void updateCurrentZeroEmissionValue(ZeroEmissionEntry zeroEmissionEntry) {
        this.updateCurrentZeroEmissionValue(zeroEmissionEntry, true);
    }

    public void updateCurrentZeroEmissionValue(ZeroEmissionEntry zeroEmissionEntry, boolean bl) {
        this.CurrentZeroEmissionValue = ASIHMISyncCarZeroEmissionAbstractBaseService.copyZeroEmissionEntry(zeroEmissionEntry);
        this.CurrentZeroEmissionValue_valid = bl;
        List list = this.baseService.getNotifications(7);
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            ASIHMISyncCarZeroEmissionReply aSIHMISyncCarZeroEmissionReply = (ASIHMISyncCarZeroEmissionReply)iterator.next();
            try {
                aSIHMISyncCarZeroEmissionReply.updateCurrentZeroEmissionValue(zeroEmissionEntry, bl);
            }
            catch (MethodException methodException) {}
        }
    }
}

