/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asi.generic.impl;

import de.esolutions.fw.comm.asi.hmisync.generic.ASIHMISyncGeneric$ReplyIDs;
import de.esolutions.fw.comm.asi.hmisync.generic.ASIHMISyncGeneric$RequestIDs;
import de.esolutions.fw.comm.asi.hmisync.generic.ASIHMISyncGenericReply;
import de.esolutions.fw.comm.asi.hmisync.generic.GenericPacket;
import de.esolutions.fw.comm.asi.hmisync.generic.impl.ASIHMISyncGenericAbstractBaseService;
import de.esolutions.fw.comm.core.method.MethodException;
import de.vw.mib.asi.ASIException;
import de.vw.mib.asi.ASIProperties;
import de.vw.mib.asi.generic.ASIGeneric;
import de.vw.mib.asi.generic.impl.ASIGenericBaseServiceImpl$ListenerProxy;
import de.vw.mib.asi.generic.impl.ASIGenericBaseServiceImpl$ResponseProxy;
import de.vw.mib.log4mib.ClassifiedLogger;
import java.util.HashSet;
import java.util.Set;

public class ASIGenericBaseServiceImpl
extends ASIHMISyncGenericAbstractBaseService {
    private static final int ATTR_COUNT;
    private final ClassifiedLogger clogger;
    private final Set[] attrListeners = new Set[0];
    private final ASIGenericBaseServiceImpl$ListenerProxy listener = new ASIGenericBaseServiceImpl$ListenerProxy(this);
    private final ASIGeneric service;
    private final ASIProperties props;

    public ASIGenericBaseServiceImpl(ASIGeneric aSIGeneric, ASIProperties aSIProperties, ClassifiedLogger classifiedLogger) {
        this.service = aSIGeneric;
        this.props = aSIProperties;
        this.clogger = classifiedLogger;
    }

    public void init() {
        this.initBaseAttributes();
        this.service.setASIGenericListener(this.listener);
    }

    private void initBaseAttributes() {
        try {
            this.updateASIVersion("2.1.00");
            this.updateRequestIDs(ASIHMISyncGeneric$RequestIDs.getIDs());
            this.updateReplyIDs(ASIHMISyncGeneric$ReplyIDs.getIDs());
        }
        catch (MethodException methodException) {
            this.clogger.error().append("ASIGeneric: Could not initialize base attributes.").attachThrowable(methodException).log();
        }
    }

    private static int getMappedId(long l) {
        switch ((int)l) {
            default: 
        }
        int n = -1;
        return n;
    }

    @Override
    public synchronized void setNotification(long l, ASIHMISyncGenericReply aSIHMISyncGenericReply) {
        super.setNotification(l, aSIHMISyncGenericReply);
        int n = ASIGenericBaseServiceImpl.getMappedId(l);
        if (0 <= n) {
            this.addListener(n, aSIHMISyncGenericReply);
        }
    }

    @Override
    public synchronized void setNotification(ASIHMISyncGenericReply aSIHMISyncGenericReply) {
        super.setNotification(aSIHMISyncGenericReply);
        for (int i2 = 0; i2 < 0; ++i2) {
            this.addListener(i2, aSIHMISyncGenericReply);
        }
    }

    @Override
    public synchronized void setNotification(long[] lArray, ASIHMISyncGenericReply aSIHMISyncGenericReply) {
        super.setNotification(lArray, aSIHMISyncGenericReply);
        for (int i2 = 0; i2 < lArray.length; ++i2) {
            int n = ASIGenericBaseServiceImpl.getMappedId(lArray[i2]);
            if (0 > n) continue;
            this.addListener(n, aSIHMISyncGenericReply);
        }
    }

    private void addListener(int n, ASIHMISyncGenericReply aSIHMISyncGenericReply) {
        Set set = this.attrListeners[n];
        if (null == set) {
            this.attrListeners[n] = set = new HashSet();
        }
        boolean bl = set.isEmpty();
        set.add(aSIHMISyncGenericReply);
        if (bl) {
            this.props.setNotification(n);
        }
    }

    @Override
    public synchronized void clearNotification(long l, ASIHMISyncGenericReply aSIHMISyncGenericReply) {
        super.clearNotification(l, aSIHMISyncGenericReply);
        int n = ASIGenericBaseServiceImpl.getMappedId(l);
        if (0 <= n) {
            this.removeListener(n, aSIHMISyncGenericReply);
        }
    }

    @Override
    public synchronized void clearNotification(ASIHMISyncGenericReply aSIHMISyncGenericReply) {
        super.clearNotification(aSIHMISyncGenericReply);
        for (int i2 = 0; i2 < 0; ++i2) {
            this.removeListener(i2, aSIHMISyncGenericReply);
        }
    }

    @Override
    public synchronized void clearNotification(long[] lArray, ASIHMISyncGenericReply aSIHMISyncGenericReply) {
        super.clearNotification(lArray, aSIHMISyncGenericReply);
        for (int i2 = 0; i2 < lArray.length; ++i2) {
            int n = ASIGenericBaseServiceImpl.getMappedId(lArray[i2]);
            if (0 > n) continue;
            this.removeListener(n, aSIHMISyncGenericReply);
        }
    }

    private void removeListener(int n, ASIHMISyncGenericReply aSIHMISyncGenericReply) {
        boolean bl;
        Set set = this.attrListeners[n];
        boolean bl2 = bl = null != set && set.remove(aSIHMISyncGenericReply) && set.isEmpty();
        if (bl) {
            this.props.clearNotification(n);
        }
    }

    @Override
    public void sendDataToUnit(GenericPacket genericPacket, ASIHMISyncGenericReply aSIHMISyncGenericReply) {
        try {
            this.service.sendDataToUnit(genericPacket, ASIGenericBaseServiceImpl$ResponseProxy.get(aSIHMISyncGenericReply));
        }
        catch (ASIException aSIException) {
            throw new MethodException(aSIException.toString());
        }
    }
}

