/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asi.mastercontrol.impl;

import de.esolutions.fw.comm.asi.hmisync.mastercontrol.ASIHMISyncMasterControl$ReplyIDs;
import de.esolutions.fw.comm.asi.hmisync.mastercontrol.ASIHMISyncMasterControl$RequestIDs;
import de.esolutions.fw.comm.asi.hmisync.mastercontrol.ASIHMISyncMasterControlReply;
import de.esolutions.fw.comm.asi.hmisync.mastercontrol.impl.ASIHMISyncMasterControlAbstractBaseService;
import de.esolutions.fw.comm.core.method.MethodException;
import de.vw.mib.asi.ASIProperties;
import de.vw.mib.asi.mastercontrol.ASIMasterControl;
import de.vw.mib.asi.mastercontrol.impl.ASIMasterControlBaseServiceImpl$ListenerProxy;
import de.vw.mib.log4mib.ClassifiedLogger;
import java.util.HashSet;
import java.util.Set;

public class ASIMasterControlBaseServiceImpl
extends ASIHMISyncMasterControlAbstractBaseService {
    private static final int ATTR_COUNT;
    private final ClassifiedLogger clogger;
    private final Set[] attrListeners = new Set[4];
    private final ASIMasterControlBaseServiceImpl$ListenerProxy listener = new ASIMasterControlBaseServiceImpl$ListenerProxy(this);
    private final ASIMasterControl service;
    private final ASIProperties props;

    public ASIMasterControlBaseServiceImpl(ASIMasterControl aSIMasterControl, ASIProperties aSIProperties, ClassifiedLogger classifiedLogger) {
        this.service = aSIMasterControl;
        this.props = aSIProperties;
        this.clogger = classifiedLogger;
    }

    public void init() {
        this.initBaseAttributes();
        this.service.setASIMasterControlListener(this.listener);
    }

    private void initBaseAttributes() {
        try {
            this.updateASIVersion("1.1.00");
            this.updateRequestIDs(ASIHMISyncMasterControl$RequestIDs.getIDs());
            this.updateReplyIDs(ASIHMISyncMasterControl$ReplyIDs.getIDs());
        }
        catch (MethodException methodException) {
            this.clogger.error().append("ASIMasterControl: Could not initialize base attributes.").attachThrowable(methodException).log();
        }
    }

    private static int getMappedId(long l) {
        int n;
        switch ((int)l) {
            case 9: {
                n = 0;
                break;
            }
            case 10: {
                n = 1;
                break;
            }
            case 11: {
                n = 2;
                break;
            }
            case 12: {
                n = 3;
                break;
            }
            default: {
                n = -1;
            }
        }
        return n;
    }

    @Override
    public synchronized void setNotification(long l, ASIHMISyncMasterControlReply aSIHMISyncMasterControlReply) {
        super.setNotification(l, aSIHMISyncMasterControlReply);
        int n = ASIMasterControlBaseServiceImpl.getMappedId(l);
        if (0 <= n) {
            this.addListener(n, aSIHMISyncMasterControlReply);
        }
    }

    @Override
    public synchronized void setNotification(ASIHMISyncMasterControlReply aSIHMISyncMasterControlReply) {
        super.setNotification(aSIHMISyncMasterControlReply);
        for (int i2 = 0; i2 < 4; ++i2) {
            this.addListener(i2, aSIHMISyncMasterControlReply);
        }
    }

    @Override
    public synchronized void setNotification(long[] lArray, ASIHMISyncMasterControlReply aSIHMISyncMasterControlReply) {
        super.setNotification(lArray, aSIHMISyncMasterControlReply);
        for (int i2 = 0; i2 < lArray.length; ++i2) {
            int n = ASIMasterControlBaseServiceImpl.getMappedId(lArray[i2]);
            if (0 > n) continue;
            this.addListener(n, aSIHMISyncMasterControlReply);
        }
    }

    private void addListener(int n, ASIHMISyncMasterControlReply aSIHMISyncMasterControlReply) {
        Set set = this.attrListeners[n];
        if (null == set) {
            this.attrListeners[n] = set = new HashSet();
        }
        boolean bl = set.isEmpty();
        set.add(aSIHMISyncMasterControlReply);
        if (bl) {
            this.props.setNotification(n);
        }
    }

    @Override
    public synchronized void clearNotification(long l, ASIHMISyncMasterControlReply aSIHMISyncMasterControlReply) {
        super.clearNotification(l, aSIHMISyncMasterControlReply);
        int n = ASIMasterControlBaseServiceImpl.getMappedId(l);
        if (0 <= n) {
            this.removeListener(n, aSIHMISyncMasterControlReply);
        }
    }

    @Override
    public synchronized void clearNotification(ASIHMISyncMasterControlReply aSIHMISyncMasterControlReply) {
        super.clearNotification(aSIHMISyncMasterControlReply);
        for (int i2 = 0; i2 < 4; ++i2) {
            this.removeListener(i2, aSIHMISyncMasterControlReply);
        }
    }

    @Override
    public synchronized void clearNotification(long[] lArray, ASIHMISyncMasterControlReply aSIHMISyncMasterControlReply) {
        super.clearNotification(lArray, aSIHMISyncMasterControlReply);
        for (int i2 = 0; i2 < lArray.length; ++i2) {
            int n = ASIMasterControlBaseServiceImpl.getMappedId(lArray[i2]);
            if (0 > n) continue;
            this.removeListener(n, aSIHMISyncMasterControlReply);
        }
    }

    private void removeListener(int n, ASIHMISyncMasterControlReply aSIHMISyncMasterControlReply) {
        boolean bl;
        Set set = this.attrListeners[n];
        boolean bl2 = bl = null != set && set.remove(aSIHMISyncMasterControlReply) && set.isEmpty();
        if (bl) {
            this.props.clearNotification(n);
        }
    }
}

