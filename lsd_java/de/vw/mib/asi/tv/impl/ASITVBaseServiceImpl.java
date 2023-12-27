/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asi.tv.impl;

import de.esolutions.fw.comm.asi.hmisync.tv.ASIHMISyncTV$ReplyIDs;
import de.esolutions.fw.comm.asi.hmisync.tv.ASIHMISyncTV$RequestIDs;
import de.esolutions.fw.comm.asi.hmisync.tv.ASIHMISyncTVReply;
import de.esolutions.fw.comm.asi.hmisync.tv.impl.ASIHMISyncTVAbstractBaseService;
import de.esolutions.fw.comm.core.method.MethodException;
import de.vw.mib.asi.ASIException;
import de.vw.mib.asi.ASIProperties;
import de.vw.mib.asi.tv.ASITV;
import de.vw.mib.asi.tv.impl.ASITVBaseServiceImpl$ListenerProxy;
import de.vw.mib.asi.tv.impl.ASITVBaseServiceImpl$ResponseProxy;
import de.vw.mib.log4mib.ClassifiedLogger;
import java.util.HashSet;
import java.util.Set;

public class ASITVBaseServiceImpl
extends ASIHMISyncTVAbstractBaseService {
    private static final int ATTR_COUNT;
    private final ClassifiedLogger clogger;
    private final Set[] attrListeners = new Set[8];
    private final ASITVBaseServiceImpl$ListenerProxy listener = new ASITVBaseServiceImpl$ListenerProxy(this);
    private final ASITV service;
    private final ASIProperties props;

    public ASITVBaseServiceImpl(ASITV aSITV, ASIProperties aSIProperties, ClassifiedLogger classifiedLogger) {
        this.service = aSITV;
        this.props = aSIProperties;
        this.clogger = classifiedLogger;
    }

    public void init() {
        this.initBaseAttributes();
        this.service.setASITVListener(this.listener);
    }

    private void initBaseAttributes() {
        try {
            this.updateASIVersion("3.4.00");
            this.updateRequestIDs(ASIHMISyncTV$RequestIDs.getIDs());
            this.updateReplyIDs(ASIHMISyncTV$ReplyIDs.getIDs());
        }
        catch (MethodException methodException) {
            this.clogger.error().append("ASITV: Could not initialize base attributes.").attachThrowable(methodException).log();
        }
    }

    private static int getMappedId(long l) {
        int n;
        switch ((int)l) {
            case 21: {
                n = 0;
                break;
            }
            case 22: {
                n = 1;
                break;
            }
            case 14: {
                n = 2;
                break;
            }
            case 15: {
                n = 3;
                break;
            }
            case 16: {
                n = 4;
                break;
            }
            case 23: {
                n = 5;
                break;
            }
            case 18: {
                n = 6;
                break;
            }
            case 24: {
                n = 7;
                break;
            }
            default: {
                n = -1;
            }
        }
        return n;
    }

    @Override
    public synchronized void setNotification(long l, ASIHMISyncTVReply aSIHMISyncTVReply) {
        super.setNotification(l, aSIHMISyncTVReply);
        int n = ASITVBaseServiceImpl.getMappedId(l);
        if (0 <= n) {
            this.addListener(n, aSIHMISyncTVReply);
        }
    }

    @Override
    public synchronized void setNotification(ASIHMISyncTVReply aSIHMISyncTVReply) {
        super.setNotification(aSIHMISyncTVReply);
        for (int i2 = 0; i2 < 8; ++i2) {
            this.addListener(i2, aSIHMISyncTVReply);
        }
    }

    @Override
    public synchronized void setNotification(long[] lArray, ASIHMISyncTVReply aSIHMISyncTVReply) {
        super.setNotification(lArray, aSIHMISyncTVReply);
        for (int i2 = 0; i2 < lArray.length; ++i2) {
            int n = ASITVBaseServiceImpl.getMappedId(lArray[i2]);
            if (0 > n) continue;
            this.addListener(n, aSIHMISyncTVReply);
        }
    }

    private void addListener(int n, ASIHMISyncTVReply aSIHMISyncTVReply) {
        Set set = this.attrListeners[n];
        if (null == set) {
            this.attrListeners[n] = set = new HashSet();
        }
        boolean bl = set.isEmpty();
        set.add(aSIHMISyncTVReply);
        if (bl) {
            this.props.setNotification(n);
        }
    }

    @Override
    public synchronized void clearNotification(long l, ASIHMISyncTVReply aSIHMISyncTVReply) {
        super.clearNotification(l, aSIHMISyncTVReply);
        int n = ASITVBaseServiceImpl.getMappedId(l);
        if (0 <= n) {
            this.removeListener(n, aSIHMISyncTVReply);
        }
    }

    @Override
    public synchronized void clearNotification(ASIHMISyncTVReply aSIHMISyncTVReply) {
        super.clearNotification(aSIHMISyncTVReply);
        for (int i2 = 0; i2 < 8; ++i2) {
            this.removeListener(i2, aSIHMISyncTVReply);
        }
    }

    @Override
    public synchronized void clearNotification(long[] lArray, ASIHMISyncTVReply aSIHMISyncTVReply) {
        super.clearNotification(lArray, aSIHMISyncTVReply);
        for (int i2 = 0; i2 < lArray.length; ++i2) {
            int n = ASITVBaseServiceImpl.getMappedId(lArray[i2]);
            if (0 > n) continue;
            this.removeListener(n, aSIHMISyncTVReply);
        }
    }

    private void removeListener(int n, ASIHMISyncTVReply aSIHMISyncTVReply) {
        boolean bl;
        Set set = this.attrListeners[n];
        boolean bl2 = bl = null != set && set.remove(aSIHMISyncTVReply) && set.isEmpty();
        if (bl) {
            this.props.clearNotification(n);
        }
    }

    @Override
    public void setActiveStation(long l, ASIHMISyncTVReply aSIHMISyncTVReply) {
        try {
            this.service.setActiveStation(l, ASITVBaseServiceImpl$ResponseProxy.get(aSIHMISyncTVReply));
        }
        catch (ASIException aSIException) {
            throw new MethodException(aSIException.toString());
        }
    }

    @Override
    public void logonToTV(ASIHMISyncTVReply aSIHMISyncTVReply) {
        try {
            this.service.logonToTV(ASITVBaseServiceImpl$ResponseProxy.get(aSIHMISyncTVReply));
        }
        catch (ASIException aSIException) {
            throw new MethodException(aSIException.toString());
        }
    }

    @Override
    public void logoffFromTV(ASIHMISyncTVReply aSIHMISyncTVReply) {
        try {
            this.service.logoffFromTV(ASITVBaseServiceImpl$ResponseProxy.get(aSIHMISyncTVReply));
        }
        catch (ASIException aSIException) {
            throw new MethodException(aSIException.toString());
        }
    }

    @Override
    public void sendPressedPanelKey(byte by, ASIHMISyncTVReply aSIHMISyncTVReply) {
        try {
            this.service.sendPressedPanelKey(by, ASITVBaseServiceImpl$ResponseProxy.get(aSIHMISyncTVReply));
        }
        catch (ASIException aSIException) {
            throw new MethodException(aSIException.toString());
        }
    }

    @Override
    public void searchChannel(byte by, ASIHMISyncTVReply aSIHMISyncTVReply) {
        try {
            this.service.searchChannel(by, ASITVBaseServiceImpl$ResponseProxy.get(aSIHMISyncTVReply));
        }
        catch (ASIException aSIException) {
            throw new MethodException(aSIException.toString());
        }
    }

    @Override
    public void setTerminalMode(byte by, ASIHMISyncTVReply aSIHMISyncTVReply) {
        try {
            this.service.setTerminalMode(by, ASITVBaseServiceImpl$ResponseProxy.get(aSIHMISyncTVReply));
        }
        catch (ASIException aSIException) {
            throw new MethodException(aSIException.toString());
        }
    }
}

