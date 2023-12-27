/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.hmisync.instance.impl;

import de.esolutions.fw.comm.asi.hmisync.instance.ASIHMISyncInstanceReply;
import de.esolutions.fw.comm.asi.hmisync.instance.ASIHMISyncInstanceS;
import de.esolutions.fw.comm.asi.hmisync.instance.impl.ASIHMISyncInstanceAbstractBaseService$AttributesBitMapProvider;
import de.esolutions.fw.comm.attributes.AttributesBaseService;
import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.method.MethodException;
import java.util.Iterator;
import java.util.List;

public abstract class ASIHMISyncInstanceAbstractBaseService
implements ASIHMISyncInstanceS {
    private static final CallContext context = CallContext.getContext("ABSTRACTBASESERVICE.asi.hmisync.instance.ASIHMISyncInstance");
    private static final int attributesCount;
    private String ASIVersion;
    private boolean ASIVersion_valid = false;
    private short[] RequestIDs;
    private boolean RequestIDs_valid = false;
    private short[] ReplyIDs;
    private boolean ReplyIDs_valid = false;
    private AttributesBaseService baseService;

    public static String copyString(String string) {
        if (string != null) {
            return new String(string);
        }
        return null;
    }

    public ASIHMISyncInstanceAbstractBaseService() {
        ASIHMISyncInstanceAbstractBaseService$AttributesBitMapProvider aSIHMISyncInstanceAbstractBaseService$AttributesBitMapProvider = new ASIHMISyncInstanceAbstractBaseService$AttributesBitMapProvider();
        this.baseService = new AttributesBaseService("ASIHMISyncInstance", aSIHMISyncInstanceAbstractBaseService$AttributesBitMapProvider);
    }

    @Override
    public synchronized void setNotification(long l, ASIHMISyncInstanceReply aSIHMISyncInstanceReply) {
        this.baseService.setNotification(l, (Object)aSIHMISyncInstanceReply);
        this.sendAttributeUpdate(l, aSIHMISyncInstanceReply);
    }

    @Override
    public synchronized void setNotification(ASIHMISyncInstanceReply aSIHMISyncInstanceReply) {
        this.baseService.setNotification(aSIHMISyncInstanceReply);
        this.sendAttributeUpdate(aSIHMISyncInstanceReply);
    }

    @Override
    public synchronized void setNotification(long[] lArray, ASIHMISyncInstanceReply aSIHMISyncInstanceReply) {
        this.baseService.setNotification(lArray, (Object)aSIHMISyncInstanceReply);
        this.sendAttributeUpdate(lArray, aSIHMISyncInstanceReply);
    }

    @Override
    public synchronized void clearNotification(long l, ASIHMISyncInstanceReply aSIHMISyncInstanceReply) {
        this.baseService.clearNotification(l, (Object)aSIHMISyncInstanceReply);
    }

    @Override
    public synchronized void clearNotification(ASIHMISyncInstanceReply aSIHMISyncInstanceReply) {
        this.baseService.clearNotification(aSIHMISyncInstanceReply);
    }

    @Override
    public synchronized void clearNotification(long[] lArray, ASIHMISyncInstanceReply aSIHMISyncInstanceReply) {
        this.baseService.clearNotification(lArray, (Object)aSIHMISyncInstanceReply);
    }

    private void sendAttributeUpdate(ASIHMISyncInstanceReply aSIHMISyncInstanceReply) {
        try {
            aSIHMISyncInstanceReply.updateASIVersion(this.ASIVersion, this.ASIVersion_valid);
            aSIHMISyncInstanceReply.updateRequestIDs(this.RequestIDs, this.RequestIDs_valid);
            aSIHMISyncInstanceReply.updateReplyIDs(this.ReplyIDs, this.ReplyIDs_valid);
        }
        catch (MethodException methodException) {
            // empty catch block
        }
    }

    private void sendAttributeUpdate(long[] lArray, ASIHMISyncInstanceReply aSIHMISyncInstanceReply) {
        for (int i2 = 0; i2 < lArray.length; ++i2) {
            this.sendAttributeUpdate(lArray[i2], aSIHMISyncInstanceReply);
        }
    }

    private void sendAttributeUpdate(long l, ASIHMISyncInstanceReply aSIHMISyncInstanceReply) {
        try {
            if (l == 0) {
                aSIHMISyncInstanceReply.updateASIVersion(this.ASIVersion, this.ASIVersion_valid);
            } else if (l == 0) {
                aSIHMISyncInstanceReply.updateRequestIDs(this.RequestIDs, this.RequestIDs_valid);
            } else if (l == 0) {
                aSIHMISyncInstanceReply.updateReplyIDs(this.ReplyIDs, this.ReplyIDs_valid);
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
        this.ASIVersion = ASIHMISyncInstanceAbstractBaseService.copyString(string);
        this.ASIVersion_valid = bl;
        List list = this.baseService.getNotifications(8);
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            ASIHMISyncInstanceReply aSIHMISyncInstanceReply = (ASIHMISyncInstanceReply)iterator.next();
            try {
                aSIHMISyncInstanceReply.updateASIVersion(string, bl);
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
            ASIHMISyncInstanceReply aSIHMISyncInstanceReply = (ASIHMISyncInstanceReply)iterator.next();
            try {
                aSIHMISyncInstanceReply.updateRequestIDs(sArray, bl);
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
            ASIHMISyncInstanceReply aSIHMISyncInstanceReply = (ASIHMISyncInstanceReply)iterator.next();
            try {
                aSIHMISyncInstanceReply.updateReplyIDs(sArray, bl);
            }
            catch (MethodException methodException) {}
        }
    }
}

