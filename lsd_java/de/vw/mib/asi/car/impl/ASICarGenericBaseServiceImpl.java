/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asi.car.impl;

import de.esolutions.fw.comm.asi.hmisync.car.ASIHMISyncCarGeneric$ReplyIDs;
import de.esolutions.fw.comm.asi.hmisync.car.ASIHMISyncCarGeneric$RequestIDs;
import de.esolutions.fw.comm.asi.hmisync.car.ASIHMISyncCarGenericReply;
import de.esolutions.fw.comm.asi.hmisync.car.impl.ASIHMISyncCarGenericAbstractBaseService;
import de.esolutions.fw.comm.core.method.MethodException;
import de.vw.mib.asi.ASIProperties;
import de.vw.mib.asi.car.ASICarGeneric;
import de.vw.mib.asi.car.impl.ASICarGenericBaseServiceImpl$ListenerProxy;
import de.vw.mib.log4mib.ClassifiedLogger;
import java.util.HashSet;
import java.util.Set;

public class ASICarGenericBaseServiceImpl
extends ASIHMISyncCarGenericAbstractBaseService {
    private static final int ATTR_COUNT;
    private final ClassifiedLogger clogger;
    private final Set[] attrListeners = new Set[0];
    private final ASICarGenericBaseServiceImpl$ListenerProxy listener = new ASICarGenericBaseServiceImpl$ListenerProxy(this);
    private final ASICarGeneric service;
    private final ASIProperties props;

    public ASICarGenericBaseServiceImpl(ASICarGeneric aSICarGeneric, ASIProperties aSIProperties, ClassifiedLogger classifiedLogger) {
        this.service = aSICarGeneric;
        this.props = aSIProperties;
        this.clogger = classifiedLogger;
    }

    public void init() {
        this.initBaseAttributes();
        this.service.setASICarGenericListener(this.listener);
    }

    private void initBaseAttributes() {
        try {
            this.updateASIVersion("1.0.00");
            this.updateRequestIDs(ASIHMISyncCarGeneric$RequestIDs.getIDs());
            this.updateReplyIDs(ASIHMISyncCarGeneric$ReplyIDs.getIDs());
        }
        catch (MethodException methodException) {
            this.clogger.error().append("ASICarGeneric: Could not initialize base attributes.").attachThrowable(methodException).log();
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
    public synchronized void setNotification(long l, ASIHMISyncCarGenericReply aSIHMISyncCarGenericReply) {
        super.setNotification(l, aSIHMISyncCarGenericReply);
        int n = ASICarGenericBaseServiceImpl.getMappedId(l);
        if (0 <= n) {
            this.addListener(n, aSIHMISyncCarGenericReply);
        }
    }

    @Override
    public synchronized void setNotification(ASIHMISyncCarGenericReply aSIHMISyncCarGenericReply) {
        super.setNotification(aSIHMISyncCarGenericReply);
        for (int i2 = 0; i2 < 0; ++i2) {
            this.addListener(i2, aSIHMISyncCarGenericReply);
        }
    }

    @Override
    public synchronized void setNotification(long[] lArray, ASIHMISyncCarGenericReply aSIHMISyncCarGenericReply) {
        super.setNotification(lArray, aSIHMISyncCarGenericReply);
        for (int i2 = 0; i2 < lArray.length; ++i2) {
            int n = ASICarGenericBaseServiceImpl.getMappedId(lArray[i2]);
            if (0 > n) continue;
            this.addListener(n, aSIHMISyncCarGenericReply);
        }
    }

    private void addListener(int n, ASIHMISyncCarGenericReply aSIHMISyncCarGenericReply) {
        Set set = this.attrListeners[n];
        if (null == set) {
            this.attrListeners[n] = set = new HashSet();
        }
        boolean bl = set.isEmpty();
        set.add(aSIHMISyncCarGenericReply);
        if (bl) {
            this.props.setNotification(n);
        }
    }

    @Override
    public synchronized void clearNotification(long l, ASIHMISyncCarGenericReply aSIHMISyncCarGenericReply) {
        super.clearNotification(l, aSIHMISyncCarGenericReply);
        int n = ASICarGenericBaseServiceImpl.getMappedId(l);
        if (0 <= n) {
            this.removeListener(n, aSIHMISyncCarGenericReply);
        }
    }

    @Override
    public synchronized void clearNotification(ASIHMISyncCarGenericReply aSIHMISyncCarGenericReply) {
        super.clearNotification(aSIHMISyncCarGenericReply);
        for (int i2 = 0; i2 < 0; ++i2) {
            this.removeListener(i2, aSIHMISyncCarGenericReply);
        }
    }

    @Override
    public synchronized void clearNotification(long[] lArray, ASIHMISyncCarGenericReply aSIHMISyncCarGenericReply) {
        super.clearNotification(lArray, aSIHMISyncCarGenericReply);
        for (int i2 = 0; i2 < lArray.length; ++i2) {
            int n = ASICarGenericBaseServiceImpl.getMappedId(lArray[i2]);
            if (0 > n) continue;
            this.removeListener(n, aSIHMISyncCarGenericReply);
        }
    }

    private void removeListener(int n, ASIHMISyncCarGenericReply aSIHMISyncCarGenericReply) {
        boolean bl;
        Set set = this.attrListeners[n];
        boolean bl2 = bl = null != set && set.remove(aSIHMISyncCarGenericReply) && set.isEmpty();
        if (bl) {
            this.props.clearNotification(n);
        }
    }
}

