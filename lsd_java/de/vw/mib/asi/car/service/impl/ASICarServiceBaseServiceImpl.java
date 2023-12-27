/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asi.car.service.impl;

import de.esolutions.fw.comm.asi.hmisync.car.service.ASIHMISyncCarService$ReplyIDs;
import de.esolutions.fw.comm.asi.hmisync.car.service.ASIHMISyncCarService$RequestIDs;
import de.esolutions.fw.comm.asi.hmisync.car.service.ASIHMISyncCarServiceReply;
import de.esolutions.fw.comm.asi.hmisync.car.service.impl.ASIHMISyncCarServiceAbstractBaseService;
import de.esolutions.fw.comm.core.method.MethodException;
import de.vw.mib.asi.ASIProperties;
import de.vw.mib.asi.car.service.ASICarService;
import de.vw.mib.asi.car.service.impl.ASICarServiceBaseServiceImpl$ListenerProxy;
import de.vw.mib.log4mib.ClassifiedLogger;
import java.util.HashSet;
import java.util.Set;

public class ASICarServiceBaseServiceImpl
extends ASIHMISyncCarServiceAbstractBaseService {
    private static final int ATTR_COUNT;
    private final ClassifiedLogger clogger;
    private final Set[] attrListeners = new Set[17];
    private final ASICarServiceBaseServiceImpl$ListenerProxy listener = new ASICarServiceBaseServiceImpl$ListenerProxy(this);
    private final ASICarService service;
    private final ASIProperties props;

    public ASICarServiceBaseServiceImpl(ASICarService aSICarService, ASIProperties aSIProperties, ClassifiedLogger classifiedLogger) {
        this.service = aSICarService;
        this.props = aSIProperties;
        this.clogger = classifiedLogger;
    }

    public void init() {
        this.initBaseAttributes();
        this.service.setASICarServiceListener(this.listener);
    }

    private void initBaseAttributes() {
        try {
            this.updateASIVersion("1.0.00");
            this.updateRequestIDs(ASIHMISyncCarService$RequestIDs.getIDs());
            this.updateReplyIDs(ASIHMISyncCarService$ReplyIDs.getIDs());
        }
        catch (MethodException methodException) {
            this.clogger.error().append("ASICarService: Could not initialize base attributes.").attachThrowable(methodException).log();
        }
    }

    private static int getMappedId(long l) {
        int n;
        switch ((int)l) {
            case 26: {
                n = 0;
                break;
            }
            case 8: {
                n = 1;
                break;
            }
            case 9: {
                n = 2;
                break;
            }
            case 10: {
                n = 3;
                break;
            }
            case 11: {
                n = 4;
                break;
            }
            case 12: {
                n = 5;
                break;
            }
            case 15: {
                n = 6;
                break;
            }
            case 16: {
                n = 7;
                break;
            }
            case 17: {
                n = 8;
                break;
            }
            case 18: {
                n = 9;
                break;
            }
            case 19: {
                n = 10;
                break;
            }
            case 20: {
                n = 11;
                break;
            }
            case 21: {
                n = 12;
                break;
            }
            case 22: {
                n = 13;
                break;
            }
            case 23: {
                n = 14;
                break;
            }
            case 24: {
                n = 15;
                break;
            }
            case 25: {
                n = 16;
                break;
            }
            default: {
                n = -1;
            }
        }
        return n;
    }

    @Override
    public synchronized void setNotification(long l, ASIHMISyncCarServiceReply aSIHMISyncCarServiceReply) {
        super.setNotification(l, aSIHMISyncCarServiceReply);
        int n = ASICarServiceBaseServiceImpl.getMappedId(l);
        if (0 <= n) {
            this.addListener(n, aSIHMISyncCarServiceReply);
        }
    }

    @Override
    public synchronized void setNotification(ASIHMISyncCarServiceReply aSIHMISyncCarServiceReply) {
        super.setNotification(aSIHMISyncCarServiceReply);
        for (int i2 = 0; i2 < 17; ++i2) {
            this.addListener(i2, aSIHMISyncCarServiceReply);
        }
    }

    @Override
    public synchronized void setNotification(long[] lArray, ASIHMISyncCarServiceReply aSIHMISyncCarServiceReply) {
        super.setNotification(lArray, aSIHMISyncCarServiceReply);
        for (int i2 = 0; i2 < lArray.length; ++i2) {
            int n = ASICarServiceBaseServiceImpl.getMappedId(lArray[i2]);
            if (0 > n) continue;
            this.addListener(n, aSIHMISyncCarServiceReply);
        }
    }

    private void addListener(int n, ASIHMISyncCarServiceReply aSIHMISyncCarServiceReply) {
        Set set = this.attrListeners[n];
        if (null == set) {
            this.attrListeners[n] = set = new HashSet();
        }
        boolean bl = set.isEmpty();
        set.add(aSIHMISyncCarServiceReply);
        if (bl) {
            this.props.setNotification(n);
        }
    }

    @Override
    public synchronized void clearNotification(long l, ASIHMISyncCarServiceReply aSIHMISyncCarServiceReply) {
        super.clearNotification(l, aSIHMISyncCarServiceReply);
        int n = ASICarServiceBaseServiceImpl.getMappedId(l);
        if (0 <= n) {
            this.removeListener(n, aSIHMISyncCarServiceReply);
        }
    }

    @Override
    public synchronized void clearNotification(ASIHMISyncCarServiceReply aSIHMISyncCarServiceReply) {
        super.clearNotification(aSIHMISyncCarServiceReply);
        for (int i2 = 0; i2 < 17; ++i2) {
            this.removeListener(i2, aSIHMISyncCarServiceReply);
        }
    }

    @Override
    public synchronized void clearNotification(long[] lArray, ASIHMISyncCarServiceReply aSIHMISyncCarServiceReply) {
        super.clearNotification(lArray, aSIHMISyncCarServiceReply);
        for (int i2 = 0; i2 < lArray.length; ++i2) {
            int n = ASICarServiceBaseServiceImpl.getMappedId(lArray[i2]);
            if (0 > n) continue;
            this.removeListener(n, aSIHMISyncCarServiceReply);
        }
    }

    private void removeListener(int n, ASIHMISyncCarServiceReply aSIHMISyncCarServiceReply) {
        boolean bl;
        Set set = this.attrListeners[n];
        boolean bl2 = bl = null != set && set.remove(aSIHMISyncCarServiceReply) && set.isEmpty();
        if (bl) {
            this.props.clearNotification(n);
        }
    }
}

