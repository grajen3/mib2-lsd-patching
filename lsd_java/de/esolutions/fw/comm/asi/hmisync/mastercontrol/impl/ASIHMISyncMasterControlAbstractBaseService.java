/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.hmisync.mastercontrol.impl;

import de.esolutions.fw.comm.asi.hmisync.mastercontrol.ASIHMISyncMasterControlReply;
import de.esolutions.fw.comm.asi.hmisync.mastercontrol.ASIHMISyncMasterControlS;
import de.esolutions.fw.comm.asi.hmisync.mastercontrol.impl.ASIHMISyncMasterControlAbstractBaseService$AttributesBitMapProvider;
import de.esolutions.fw.comm.attributes.AttributesBaseService;
import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.method.MethodException;
import java.util.Iterator;
import java.util.List;

public abstract class ASIHMISyncMasterControlAbstractBaseService
implements ASIHMISyncMasterControlS {
    private static final CallContext context = CallContext.getContext("ABSTRACTBASESERVICE.asi.hmisync.mastercontrol.ASIHMISyncMasterControl");
    private static final int attributesCount;
    private String ASIVersion;
    private boolean ASIVersion_valid = false;
    private short[] RequestIDs;
    private boolean RequestIDs_valid = false;
    private short[] ReplyIDs;
    private boolean ReplyIDs_valid = false;
    private String HUVersion;
    private boolean HUVersion_valid = false;
    private String VIN;
    private boolean VIN_valid = false;
    private int LockState;
    private boolean LockState_valid = false;
    private int BlockState;
    private boolean BlockState_valid = false;
    private AttributesBaseService baseService;

    public static String copyString(String string) {
        if (string != null) {
            return new String(string);
        }
        return null;
    }

    public ASIHMISyncMasterControlAbstractBaseService() {
        ASIHMISyncMasterControlAbstractBaseService$AttributesBitMapProvider aSIHMISyncMasterControlAbstractBaseService$AttributesBitMapProvider = new ASIHMISyncMasterControlAbstractBaseService$AttributesBitMapProvider();
        this.baseService = new AttributesBaseService("ASIHMISyncMasterControl", aSIHMISyncMasterControlAbstractBaseService$AttributesBitMapProvider);
    }

    @Override
    public synchronized void setNotification(long l, ASIHMISyncMasterControlReply aSIHMISyncMasterControlReply) {
        this.baseService.setNotification(l, (Object)aSIHMISyncMasterControlReply);
        this.sendAttributeUpdate(l, aSIHMISyncMasterControlReply);
    }

    @Override
    public synchronized void setNotification(ASIHMISyncMasterControlReply aSIHMISyncMasterControlReply) {
        this.baseService.setNotification(aSIHMISyncMasterControlReply);
        this.sendAttributeUpdate(aSIHMISyncMasterControlReply);
    }

    @Override
    public synchronized void setNotification(long[] lArray, ASIHMISyncMasterControlReply aSIHMISyncMasterControlReply) {
        this.baseService.setNotification(lArray, (Object)aSIHMISyncMasterControlReply);
        this.sendAttributeUpdate(lArray, aSIHMISyncMasterControlReply);
    }

    @Override
    public synchronized void clearNotification(long l, ASIHMISyncMasterControlReply aSIHMISyncMasterControlReply) {
        this.baseService.clearNotification(l, (Object)aSIHMISyncMasterControlReply);
    }

    @Override
    public synchronized void clearNotification(ASIHMISyncMasterControlReply aSIHMISyncMasterControlReply) {
        this.baseService.clearNotification(aSIHMISyncMasterControlReply);
    }

    @Override
    public synchronized void clearNotification(long[] lArray, ASIHMISyncMasterControlReply aSIHMISyncMasterControlReply) {
        this.baseService.clearNotification(lArray, (Object)aSIHMISyncMasterControlReply);
    }

    private void sendAttributeUpdate(ASIHMISyncMasterControlReply aSIHMISyncMasterControlReply) {
        try {
            aSIHMISyncMasterControlReply.updateASIVersion(this.ASIVersion, this.ASIVersion_valid);
            aSIHMISyncMasterControlReply.updateRequestIDs(this.RequestIDs, this.RequestIDs_valid);
            aSIHMISyncMasterControlReply.updateReplyIDs(this.ReplyIDs, this.ReplyIDs_valid);
            aSIHMISyncMasterControlReply.updateHUVersion(this.HUVersion, this.HUVersion_valid);
            aSIHMISyncMasterControlReply.updateVIN(this.VIN, this.VIN_valid);
            aSIHMISyncMasterControlReply.updateLockState(this.LockState, this.LockState_valid);
            aSIHMISyncMasterControlReply.updateBlockState(this.BlockState, this.BlockState_valid);
        }
        catch (MethodException methodException) {
            // empty catch block
        }
    }

    private void sendAttributeUpdate(long[] lArray, ASIHMISyncMasterControlReply aSIHMISyncMasterControlReply) {
        for (int i2 = 0; i2 < lArray.length; ++i2) {
            this.sendAttributeUpdate(lArray[i2], aSIHMISyncMasterControlReply);
        }
    }

    private void sendAttributeUpdate(long l, ASIHMISyncMasterControlReply aSIHMISyncMasterControlReply) {
        try {
            if (l == 0) {
                aSIHMISyncMasterControlReply.updateASIVersion(this.ASIVersion, this.ASIVersion_valid);
            } else if (l == 0) {
                aSIHMISyncMasterControlReply.updateRequestIDs(this.RequestIDs, this.RequestIDs_valid);
            } else if (l == 0) {
                aSIHMISyncMasterControlReply.updateReplyIDs(this.ReplyIDs, this.ReplyIDs_valid);
            } else if (l == 0) {
                aSIHMISyncMasterControlReply.updateHUVersion(this.HUVersion, this.HUVersion_valid);
            } else if (l == 0) {
                aSIHMISyncMasterControlReply.updateVIN(this.VIN, this.VIN_valid);
            } else if (l == 0) {
                aSIHMISyncMasterControlReply.updateLockState(this.LockState, this.LockState_valid);
            } else if (l == 0) {
                aSIHMISyncMasterControlReply.updateBlockState(this.BlockState, this.BlockState_valid);
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
        this.ASIVersion = ASIHMISyncMasterControlAbstractBaseService.copyString(string);
        this.ASIVersion_valid = bl;
        List list = this.baseService.getNotifications(8);
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            ASIHMISyncMasterControlReply aSIHMISyncMasterControlReply = (ASIHMISyncMasterControlReply)iterator.next();
            try {
                aSIHMISyncMasterControlReply.updateASIVersion(string, bl);
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
        List list = this.baseService.getNotifications(14);
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            ASIHMISyncMasterControlReply aSIHMISyncMasterControlReply = (ASIHMISyncMasterControlReply)iterator.next();
            try {
                aSIHMISyncMasterControlReply.updateRequestIDs(sArray, bl);
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
        List list = this.baseService.getNotifications(13);
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            ASIHMISyncMasterControlReply aSIHMISyncMasterControlReply = (ASIHMISyncMasterControlReply)iterator.next();
            try {
                aSIHMISyncMasterControlReply.updateReplyIDs(sArray, bl);
            }
            catch (MethodException methodException) {}
        }
    }

    public void updateHUVersion(String string) {
        this.updateHUVersion(string, true);
    }

    public void updateHUVersion(String string, boolean bl) {
        this.HUVersion = ASIHMISyncMasterControlAbstractBaseService.copyString(string);
        this.HUVersion_valid = bl;
        List list = this.baseService.getNotifications(10);
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            ASIHMISyncMasterControlReply aSIHMISyncMasterControlReply = (ASIHMISyncMasterControlReply)iterator.next();
            try {
                aSIHMISyncMasterControlReply.updateHUVersion(string, bl);
            }
            catch (MethodException methodException) {}
        }
    }

    public void updateVIN(String string) {
        this.updateVIN(string, true);
    }

    public void updateVIN(String string, boolean bl) {
        this.VIN = ASIHMISyncMasterControlAbstractBaseService.copyString(string);
        this.VIN_valid = bl;
        List list = this.baseService.getNotifications(12);
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            ASIHMISyncMasterControlReply aSIHMISyncMasterControlReply = (ASIHMISyncMasterControlReply)iterator.next();
            try {
                aSIHMISyncMasterControlReply.updateVIN(string, bl);
            }
            catch (MethodException methodException) {}
        }
    }

    public void updateLockState(int n) {
        this.updateLockState(n, true);
    }

    public void updateLockState(int n, boolean bl) {
        this.LockState = n;
        this.LockState_valid = bl;
        List list = this.baseService.getNotifications(11);
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            ASIHMISyncMasterControlReply aSIHMISyncMasterControlReply = (ASIHMISyncMasterControlReply)iterator.next();
            try {
                aSIHMISyncMasterControlReply.updateLockState(n, bl);
            }
            catch (MethodException methodException) {}
        }
    }

    public void updateBlockState(int n) {
        this.updateBlockState(n, true);
    }

    public void updateBlockState(int n, boolean bl) {
        this.BlockState = n;
        this.BlockState_valid = bl;
        List list = this.baseService.getNotifications(9);
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            ASIHMISyncMasterControlReply aSIHMISyncMasterControlReply = (ASIHMISyncMasterControlReply)iterator.next();
            try {
                aSIHMISyncMasterControlReply.updateBlockState(n, bl);
            }
            catch (MethodException methodException) {}
        }
    }
}

