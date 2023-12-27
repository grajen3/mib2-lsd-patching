/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asi.instance.impl;

import de.esolutions.fw.comm.asi.hmisync.instance.ASIHMISyncInstance$ReplyIDs;
import de.esolutions.fw.comm.asi.hmisync.instance.ASIHMISyncInstance$RequestIDs;
import de.esolutions.fw.comm.asi.hmisync.instance.ASIHMISyncInstanceReply;
import de.esolutions.fw.comm.asi.hmisync.instance.impl.ASIHMISyncInstanceAbstractBaseService;
import de.esolutions.fw.comm.core.method.MethodException;
import de.vw.mib.asi.ASIException;
import de.vw.mib.asi.ASIProperties;
import de.vw.mib.asi.instance.ASIInstance;
import de.vw.mib.asi.instance.impl.ASIInstanceBaseServiceImpl$ListenerProxy;
import de.vw.mib.asi.instance.impl.ASIInstanceBaseServiceImpl$ResponseProxy;
import de.vw.mib.log4mib.ClassifiedLogger;
import java.util.HashSet;
import java.util.Set;

public class ASIInstanceBaseServiceImpl
extends ASIHMISyncInstanceAbstractBaseService {
    private static final int ATTR_COUNT;
    private final ClassifiedLogger clogger;
    private final Set[] attrListeners = new Set[0];
    private final ASIInstanceBaseServiceImpl$ListenerProxy listener = new ASIInstanceBaseServiceImpl$ListenerProxy(this);
    private final ASIInstance service;
    private final ASIProperties props;

    public ASIInstanceBaseServiceImpl(ASIInstance aSIInstance, ASIProperties aSIProperties, ClassifiedLogger classifiedLogger) {
        this.service = aSIInstance;
        this.props = aSIProperties;
        this.clogger = classifiedLogger;
    }

    public void init() {
        this.initBaseAttributes();
        this.service.setASIInstanceListener(this.listener);
    }

    private void initBaseAttributes() {
        try {
            this.updateASIVersion("1.1.00");
            this.updateRequestIDs(ASIHMISyncInstance$RequestIDs.getIDs());
            this.updateReplyIDs(ASIHMISyncInstance$ReplyIDs.getIDs());
        }
        catch (MethodException methodException) {
            this.clogger.error().append("ASIInstance: Could not initialize base attributes.").attachThrowable(methodException).log();
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
    public synchronized void setNotification(long l, ASIHMISyncInstanceReply aSIHMISyncInstanceReply) {
        super.setNotification(l, aSIHMISyncInstanceReply);
        int n = ASIInstanceBaseServiceImpl.getMappedId(l);
        if (0 <= n) {
            this.addListener(n, aSIHMISyncInstanceReply);
        }
    }

    @Override
    public synchronized void setNotification(ASIHMISyncInstanceReply aSIHMISyncInstanceReply) {
        super.setNotification(aSIHMISyncInstanceReply);
        for (int i2 = 0; i2 < 0; ++i2) {
            this.addListener(i2, aSIHMISyncInstanceReply);
        }
    }

    @Override
    public synchronized void setNotification(long[] lArray, ASIHMISyncInstanceReply aSIHMISyncInstanceReply) {
        super.setNotification(lArray, aSIHMISyncInstanceReply);
        for (int i2 = 0; i2 < lArray.length; ++i2) {
            int n = ASIInstanceBaseServiceImpl.getMappedId(lArray[i2]);
            if (0 > n) continue;
            this.addListener(n, aSIHMISyncInstanceReply);
        }
    }

    private void addListener(int n, ASIHMISyncInstanceReply aSIHMISyncInstanceReply) {
        Set set = this.attrListeners[n];
        if (null == set) {
            this.attrListeners[n] = set = new HashSet();
        }
        boolean bl = set.isEmpty();
        set.add(aSIHMISyncInstanceReply);
        if (bl) {
            this.props.setNotification(n);
        }
    }

    @Override
    public synchronized void clearNotification(long l, ASIHMISyncInstanceReply aSIHMISyncInstanceReply) {
        super.clearNotification(l, aSIHMISyncInstanceReply);
        int n = ASIInstanceBaseServiceImpl.getMappedId(l);
        if (0 <= n) {
            this.removeListener(n, aSIHMISyncInstanceReply);
        }
    }

    @Override
    public synchronized void clearNotification(ASIHMISyncInstanceReply aSIHMISyncInstanceReply) {
        super.clearNotification(aSIHMISyncInstanceReply);
        for (int i2 = 0; i2 < 0; ++i2) {
            this.removeListener(i2, aSIHMISyncInstanceReply);
        }
    }

    @Override
    public synchronized void clearNotification(long[] lArray, ASIHMISyncInstanceReply aSIHMISyncInstanceReply) {
        super.clearNotification(lArray, aSIHMISyncInstanceReply);
        for (int i2 = 0; i2 < lArray.length; ++i2) {
            int n = ASIInstanceBaseServiceImpl.getMappedId(lArray[i2]);
            if (0 > n) continue;
            this.removeListener(n, aSIHMISyncInstanceReply);
        }
    }

    private void removeListener(int n, ASIHMISyncInstanceReply aSIHMISyncInstanceReply) {
        boolean bl;
        Set set = this.attrListeners[n];
        boolean bl2 = bl = null != set && set.remove(aSIHMISyncInstanceReply) && set.isEmpty();
        if (bl) {
            this.props.clearNotification(n);
        }
    }

    @Override
    public void requestInstanceId(String string, String string2, ASIHMISyncInstanceReply aSIHMISyncInstanceReply) {
        try {
            this.service.requestInstanceId(string, string2, ASIInstanceBaseServiceImpl$ResponseProxy.get(aSIHMISyncInstanceReply));
        }
        catch (ASIException aSIException) {
            throw new MethodException(aSIException.toString());
        }
    }
}

