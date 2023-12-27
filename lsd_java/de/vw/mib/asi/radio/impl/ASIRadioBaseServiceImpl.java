/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asi.radio.impl;

import de.esolutions.fw.comm.asi.hmisync.radio.ASIHMISyncRadio$ReplyIDs;
import de.esolutions.fw.comm.asi.hmisync.radio.ASIHMISyncRadio$RequestIDs;
import de.esolutions.fw.comm.asi.hmisync.radio.ASIHMISyncRadioReply;
import de.esolutions.fw.comm.asi.hmisync.radio.impl.ASIHMISyncRadioAbstractBaseService;
import de.esolutions.fw.comm.core.method.MethodException;
import de.vw.mib.asi.ASIException;
import de.vw.mib.asi.ASIProperties;
import de.vw.mib.asi.radio.ASIRadio;
import de.vw.mib.asi.radio.impl.ASIRadioBaseServiceImpl$ListenerProxy;
import de.vw.mib.asi.radio.impl.ASIRadioBaseServiceImpl$ResponseProxy;
import de.vw.mib.log4mib.ClassifiedLogger;
import java.util.HashSet;
import java.util.Set;

public class ASIRadioBaseServiceImpl
extends ASIHMISyncRadioAbstractBaseService {
    private static final int ATTR_COUNT;
    private final ClassifiedLogger clogger;
    private final Set[] attrListeners = new Set[5];
    private final ASIRadioBaseServiceImpl$ListenerProxy listener = new ASIRadioBaseServiceImpl$ListenerProxy(this);
    private final ASIRadio service;
    private final ASIProperties props;

    public ASIRadioBaseServiceImpl(ASIRadio aSIRadio, ASIProperties aSIProperties, ClassifiedLogger classifiedLogger) {
        this.service = aSIRadio;
        this.props = aSIProperties;
        this.clogger = classifiedLogger;
    }

    public void init() {
        this.initBaseAttributes();
        this.service.setASIRadioListener(this.listener);
    }

    private void initBaseAttributes() {
        try {
            this.updateASIVersion("3.1.00");
            this.updateRequestIDs(ASIHMISyncRadio$RequestIDs.getIDs());
            this.updateReplyIDs(ASIHMISyncRadio$ReplyIDs.getIDs());
        }
        catch (MethodException methodException) {
            this.clogger.error().append("ASIRadio: Could not initialize base attributes.").attachThrowable(methodException).log();
        }
    }

    private static int getMappedId(long l) {
        int n;
        switch ((int)l) {
            case 12: {
                n = 0;
                break;
            }
            case 13: {
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
            default: {
                n = -1;
            }
        }
        return n;
    }

    @Override
    public synchronized void setNotification(long l, ASIHMISyncRadioReply aSIHMISyncRadioReply) {
        super.setNotification(l, aSIHMISyncRadioReply);
        int n = ASIRadioBaseServiceImpl.getMappedId(l);
        if (0 <= n) {
            this.addListener(n, aSIHMISyncRadioReply);
        }
    }

    @Override
    public synchronized void setNotification(ASIHMISyncRadioReply aSIHMISyncRadioReply) {
        super.setNotification(aSIHMISyncRadioReply);
        for (int i2 = 0; i2 < 5; ++i2) {
            this.addListener(i2, aSIHMISyncRadioReply);
        }
    }

    @Override
    public synchronized void setNotification(long[] lArray, ASIHMISyncRadioReply aSIHMISyncRadioReply) {
        super.setNotification(lArray, aSIHMISyncRadioReply);
        for (int i2 = 0; i2 < lArray.length; ++i2) {
            int n = ASIRadioBaseServiceImpl.getMappedId(lArray[i2]);
            if (0 > n) continue;
            this.addListener(n, aSIHMISyncRadioReply);
        }
    }

    private void addListener(int n, ASIHMISyncRadioReply aSIHMISyncRadioReply) {
        Set set = this.attrListeners[n];
        if (null == set) {
            this.attrListeners[n] = set = new HashSet();
        }
        boolean bl = set.isEmpty();
        set.add(aSIHMISyncRadioReply);
        if (bl) {
            this.props.setNotification(n);
        }
    }

    @Override
    public synchronized void clearNotification(long l, ASIHMISyncRadioReply aSIHMISyncRadioReply) {
        super.clearNotification(l, aSIHMISyncRadioReply);
        int n = ASIRadioBaseServiceImpl.getMappedId(l);
        if (0 <= n) {
            this.removeListener(n, aSIHMISyncRadioReply);
        }
    }

    @Override
    public synchronized void clearNotification(ASIHMISyncRadioReply aSIHMISyncRadioReply) {
        super.clearNotification(aSIHMISyncRadioReply);
        for (int i2 = 0; i2 < 5; ++i2) {
            this.removeListener(i2, aSIHMISyncRadioReply);
        }
    }

    @Override
    public synchronized void clearNotification(long[] lArray, ASIHMISyncRadioReply aSIHMISyncRadioReply) {
        super.clearNotification(lArray, aSIHMISyncRadioReply);
        for (int i2 = 0; i2 < lArray.length; ++i2) {
            int n = ASIRadioBaseServiceImpl.getMappedId(lArray[i2]);
            if (0 > n) continue;
            this.removeListener(n, aSIHMISyncRadioReply);
        }
    }

    private void removeListener(int n, ASIHMISyncRadioReply aSIHMISyncRadioReply) {
        boolean bl;
        Set set = this.attrListeners[n];
        boolean bl2 = bl = null != set && set.remove(aSIHMISyncRadioReply) && set.isEmpty();
        if (bl) {
            this.props.clearNotification(n);
        }
    }

    @Override
    public void selectStation(long l, ASIHMISyncRadioReply aSIHMISyncRadioReply) {
        try {
            this.service.selectStation(l, ASIRadioBaseServiceImpl$ResponseProxy.get(aSIHMISyncRadioReply));
        }
        catch (ASIException aSIException) {
            throw new MethodException(aSIException.toString());
        }
    }

    @Override
    public void selectBand(int n, ASIHMISyncRadioReply aSIHMISyncRadioReply) {
        try {
            this.service.selectBand(n, ASIRadioBaseServiceImpl$ResponseProxy.get(aSIHMISyncRadioReply));
        }
        catch (ASIException aSIException) {
            throw new MethodException(aSIException.toString());
        }
    }

    @Override
    public void seekStation(int n, ASIHMISyncRadioReply aSIHMISyncRadioReply) {
        try {
            this.service.seekStation(n, ASIRadioBaseServiceImpl$ResponseProxy.get(aSIHMISyncRadioReply));
        }
        catch (ASIException aSIException) {
            throw new MethodException(aSIException.toString());
        }
    }

    @Override
    public void enableStationDetails(boolean bl, ASIHMISyncRadioReply aSIHMISyncRadioReply) {
        try {
            this.service.enableStationDetails(bl, ASIRadioBaseServiceImpl$ResponseProxy.get(aSIHMISyncRadioReply));
        }
        catch (ASIException aSIException) {
            throw new MethodException(aSIException.toString());
        }
    }
}

