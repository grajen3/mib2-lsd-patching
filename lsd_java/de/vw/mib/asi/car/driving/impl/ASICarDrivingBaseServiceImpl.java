/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asi.car.driving.impl;

import de.esolutions.fw.comm.asi.hmisync.car.driving.ASIHMISyncCarDriving$ReplyIDs;
import de.esolutions.fw.comm.asi.hmisync.car.driving.ASIHMISyncCarDriving$RequestIDs;
import de.esolutions.fw.comm.asi.hmisync.car.driving.ASIHMISyncCarDrivingReply;
import de.esolutions.fw.comm.asi.hmisync.car.driving.impl.ASIHMISyncCarDrivingAbstractBaseService;
import de.esolutions.fw.comm.core.method.MethodException;
import de.vw.mib.asi.ASIProperties;
import de.vw.mib.asi.car.driving.ASICarDriving;
import de.vw.mib.asi.car.driving.impl.ASICarDrivingBaseServiceImpl$ListenerProxy;
import de.vw.mib.log4mib.ClassifiedLogger;
import java.util.HashSet;
import java.util.Set;

public class ASICarDrivingBaseServiceImpl
extends ASIHMISyncCarDrivingAbstractBaseService {
    private static final int ATTR_COUNT;
    private final ClassifiedLogger clogger;
    private final Set[] attrListeners = new Set[14];
    private final ASICarDrivingBaseServiceImpl$ListenerProxy listener = new ASICarDrivingBaseServiceImpl$ListenerProxy(this);
    private final ASICarDriving service;
    private final ASIProperties props;

    public ASICarDrivingBaseServiceImpl(ASICarDriving aSICarDriving, ASIProperties aSIProperties, ClassifiedLogger classifiedLogger) {
        this.service = aSICarDriving;
        this.props = aSIProperties;
        this.clogger = classifiedLogger;
    }

    public void init() {
        this.initBaseAttributes();
        this.service.setASICarDrivingListener(this.listener);
    }

    private void initBaseAttributes() {
        try {
            this.updateASIVersion("1.1.00");
            this.updateRequestIDs(ASIHMISyncCarDriving$RequestIDs.getIDs());
            this.updateReplyIDs(ASIHMISyncCarDriving$ReplyIDs.getIDs());
        }
        catch (MethodException methodException) {
            this.clogger.error().append("ASICarDriving: Could not initialize base attributes.").attachThrowable(methodException).log();
        }
    }

    private static int getMappedId(long l) {
        int n;
        switch ((int)l) {
            case 7: {
                n = 0;
                break;
            }
            case 8: {
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
            case 13: {
                n = 4;
                break;
            }
            case 22: {
                n = 5;
                break;
            }
            case 14: {
                n = 6;
                break;
            }
            case 15: {
                n = 7;
                break;
            }
            case 16: {
                n = 8;
                break;
            }
            case 17: {
                n = 9;
                break;
            }
            case 18: {
                n = 10;
                break;
            }
            case 19: {
                n = 11;
                break;
            }
            case 20: {
                n = 12;
                break;
            }
            case 21: {
                n = 13;
                break;
            }
            default: {
                n = -1;
            }
        }
        return n;
    }

    @Override
    public synchronized void setNotification(long l, ASIHMISyncCarDrivingReply aSIHMISyncCarDrivingReply) {
        super.setNotification(l, aSIHMISyncCarDrivingReply);
        int n = ASICarDrivingBaseServiceImpl.getMappedId(l);
        if (0 <= n) {
            this.addListener(n, aSIHMISyncCarDrivingReply);
        }
    }

    @Override
    public synchronized void setNotification(ASIHMISyncCarDrivingReply aSIHMISyncCarDrivingReply) {
        super.setNotification(aSIHMISyncCarDrivingReply);
        for (int i2 = 0; i2 < 14; ++i2) {
            this.addListener(i2, aSIHMISyncCarDrivingReply);
        }
    }

    @Override
    public synchronized void setNotification(long[] lArray, ASIHMISyncCarDrivingReply aSIHMISyncCarDrivingReply) {
        super.setNotification(lArray, aSIHMISyncCarDrivingReply);
        for (int i2 = 0; i2 < lArray.length; ++i2) {
            int n = ASICarDrivingBaseServiceImpl.getMappedId(lArray[i2]);
            if (0 > n) continue;
            this.addListener(n, aSIHMISyncCarDrivingReply);
        }
    }

    private void addListener(int n, ASIHMISyncCarDrivingReply aSIHMISyncCarDrivingReply) {
        Set set = this.attrListeners[n];
        if (null == set) {
            this.attrListeners[n] = set = new HashSet();
        }
        boolean bl = set.isEmpty();
        set.add(aSIHMISyncCarDrivingReply);
        if (bl) {
            this.props.setNotification(n);
        }
    }

    @Override
    public synchronized void clearNotification(long l, ASIHMISyncCarDrivingReply aSIHMISyncCarDrivingReply) {
        super.clearNotification(l, aSIHMISyncCarDrivingReply);
        int n = ASICarDrivingBaseServiceImpl.getMappedId(l);
        if (0 <= n) {
            this.removeListener(n, aSIHMISyncCarDrivingReply);
        }
    }

    @Override
    public synchronized void clearNotification(ASIHMISyncCarDrivingReply aSIHMISyncCarDrivingReply) {
        super.clearNotification(aSIHMISyncCarDrivingReply);
        for (int i2 = 0; i2 < 14; ++i2) {
            this.removeListener(i2, aSIHMISyncCarDrivingReply);
        }
    }

    @Override
    public synchronized void clearNotification(long[] lArray, ASIHMISyncCarDrivingReply aSIHMISyncCarDrivingReply) {
        super.clearNotification(lArray, aSIHMISyncCarDrivingReply);
        for (int i2 = 0; i2 < lArray.length; ++i2) {
            int n = ASICarDrivingBaseServiceImpl.getMappedId(lArray[i2]);
            if (0 > n) continue;
            this.removeListener(n, aSIHMISyncCarDrivingReply);
        }
    }

    private void removeListener(int n, ASIHMISyncCarDrivingReply aSIHMISyncCarDrivingReply) {
        boolean bl;
        Set set = this.attrListeners[n];
        boolean bl2 = bl = null != set && set.remove(aSIHMISyncCarDrivingReply) && set.isEmpty();
        if (bl) {
            this.props.clearNotification(n);
        }
    }
}

