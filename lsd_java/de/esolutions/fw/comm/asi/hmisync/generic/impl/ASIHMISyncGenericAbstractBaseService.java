/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.hmisync.generic.impl;

import de.esolutions.fw.comm.asi.hmisync.generic.ASIHMISyncGenericReply;
import de.esolutions.fw.comm.asi.hmisync.generic.ASIHMISyncGenericS;
import de.esolutions.fw.comm.asi.hmisync.generic.impl.ASIHMISyncGenericAbstractBaseService$AttributesBitMapProvider;
import de.esolutions.fw.comm.attributes.AttributesBaseService;
import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.method.MethodException;
import java.util.Iterator;
import java.util.List;

public abstract class ASIHMISyncGenericAbstractBaseService
implements ASIHMISyncGenericS {
    private static final CallContext context = CallContext.getContext("ABSTRACTBASESERVICE.asi.hmisync.generic.ASIHMISyncGeneric");
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

    public ASIHMISyncGenericAbstractBaseService() {
        ASIHMISyncGenericAbstractBaseService$AttributesBitMapProvider aSIHMISyncGenericAbstractBaseService$AttributesBitMapProvider = new ASIHMISyncGenericAbstractBaseService$AttributesBitMapProvider();
        this.baseService = new AttributesBaseService("ASIHMISyncGeneric", aSIHMISyncGenericAbstractBaseService$AttributesBitMapProvider);
    }

    @Override
    public synchronized void setNotification(long l, ASIHMISyncGenericReply aSIHMISyncGenericReply) {
        this.baseService.setNotification(l, (Object)aSIHMISyncGenericReply);
        this.sendAttributeUpdate(l, aSIHMISyncGenericReply);
    }

    @Override
    public synchronized void setNotification(ASIHMISyncGenericReply aSIHMISyncGenericReply) {
        this.baseService.setNotification(aSIHMISyncGenericReply);
        this.sendAttributeUpdate(aSIHMISyncGenericReply);
    }

    @Override
    public synchronized void setNotification(long[] lArray, ASIHMISyncGenericReply aSIHMISyncGenericReply) {
        this.baseService.setNotification(lArray, (Object)aSIHMISyncGenericReply);
        this.sendAttributeUpdate(lArray, aSIHMISyncGenericReply);
    }

    @Override
    public synchronized void clearNotification(long l, ASIHMISyncGenericReply aSIHMISyncGenericReply) {
        this.baseService.clearNotification(l, (Object)aSIHMISyncGenericReply);
    }

    @Override
    public synchronized void clearNotification(ASIHMISyncGenericReply aSIHMISyncGenericReply) {
        this.baseService.clearNotification(aSIHMISyncGenericReply);
    }

    @Override
    public synchronized void clearNotification(long[] lArray, ASIHMISyncGenericReply aSIHMISyncGenericReply) {
        this.baseService.clearNotification(lArray, (Object)aSIHMISyncGenericReply);
    }

    private void sendAttributeUpdate(ASIHMISyncGenericReply aSIHMISyncGenericReply) {
        try {
            aSIHMISyncGenericReply.updateASIVersion(this.ASIVersion, this.ASIVersion_valid);
            aSIHMISyncGenericReply.updateRequestIDs(this.RequestIDs, this.RequestIDs_valid);
            aSIHMISyncGenericReply.updateReplyIDs(this.ReplyIDs, this.ReplyIDs_valid);
        }
        catch (MethodException methodException) {
            // empty catch block
        }
    }

    private void sendAttributeUpdate(long[] lArray, ASIHMISyncGenericReply aSIHMISyncGenericReply) {
        for (int i2 = 0; i2 < lArray.length; ++i2) {
            this.sendAttributeUpdate(lArray[i2], aSIHMISyncGenericReply);
        }
    }

    private void sendAttributeUpdate(long l, ASIHMISyncGenericReply aSIHMISyncGenericReply) {
        try {
            if (l == 0) {
                aSIHMISyncGenericReply.updateASIVersion(this.ASIVersion, this.ASIVersion_valid);
            } else if (l == 0) {
                aSIHMISyncGenericReply.updateRequestIDs(this.RequestIDs, this.RequestIDs_valid);
            } else if (l == 0) {
                aSIHMISyncGenericReply.updateReplyIDs(this.ReplyIDs, this.ReplyIDs_valid);
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
        this.ASIVersion = ASIHMISyncGenericAbstractBaseService.copyString(string);
        this.ASIVersion_valid = bl;
        List list = this.baseService.getNotifications(8);
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            ASIHMISyncGenericReply aSIHMISyncGenericReply = (ASIHMISyncGenericReply)iterator.next();
            try {
                aSIHMISyncGenericReply.updateASIVersion(string, bl);
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
            ASIHMISyncGenericReply aSIHMISyncGenericReply = (ASIHMISyncGenericReply)iterator.next();
            try {
                aSIHMISyncGenericReply.updateRequestIDs(sArray, bl);
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
            ASIHMISyncGenericReply aSIHMISyncGenericReply = (ASIHMISyncGenericReply)iterator.next();
            try {
                aSIHMISyncGenericReply.updateReplyIDs(sArray, bl);
            }
            catch (MethodException methodException) {}
        }
    }
}

