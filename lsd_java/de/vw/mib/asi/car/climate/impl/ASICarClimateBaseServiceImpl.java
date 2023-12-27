/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asi.car.climate.impl;

import de.esolutions.fw.comm.asi.hmisync.car.climate.ASIHMISyncCarClimate$ReplyIDs;
import de.esolutions.fw.comm.asi.hmisync.car.climate.ASIHMISyncCarClimate$RequestIDs;
import de.esolutions.fw.comm.asi.hmisync.car.climate.ASIHMISyncCarClimateReply;
import de.esolutions.fw.comm.asi.hmisync.car.climate.impl.ASIHMISyncCarClimateAbstractBaseService;
import de.esolutions.fw.comm.core.method.MethodException;
import de.vw.mib.asi.ASIException;
import de.vw.mib.asi.ASIProperties;
import de.vw.mib.asi.car.climate.ASICarClimate;
import de.vw.mib.asi.car.climate.impl.ASICarClimateBaseServiceImpl$ListenerProxy;
import de.vw.mib.asi.car.climate.impl.ASICarClimateBaseServiceImpl$ResponseProxy;
import de.vw.mib.log4mib.ClassifiedLogger;
import java.util.HashSet;
import java.util.Set;

public class ASICarClimateBaseServiceImpl
extends ASIHMISyncCarClimateAbstractBaseService {
    private static final int ATTR_COUNT;
    private final ClassifiedLogger clogger;
    private final Set[] attrListeners = new Set[3];
    private final ASICarClimateBaseServiceImpl$ListenerProxy listener = new ASICarClimateBaseServiceImpl$ListenerProxy(this);
    private final ASICarClimate service;
    private final ASIProperties props;

    public ASICarClimateBaseServiceImpl(ASICarClimate aSICarClimate, ASIProperties aSIProperties, ClassifiedLogger classifiedLogger) {
        this.service = aSICarClimate;
        this.props = aSIProperties;
        this.clogger = classifiedLogger;
    }

    public void init() {
        this.initBaseAttributes();
        this.service.setASICarClimateListener(this.listener);
    }

    private void initBaseAttributes() {
        try {
            this.updateASIVersion("1.0.00");
            this.updateRequestIDs(ASIHMISyncCarClimate$RequestIDs.getIDs());
            this.updateReplyIDs(ASIHMISyncCarClimate$ReplyIDs.getIDs());
        }
        catch (MethodException methodException) {
            this.clogger.error().append("ASICarClimate: Could not initialize base attributes.").attachThrowable(methodException).log();
        }
    }

    private static int getMappedId(long l) {
        int n;
        switch ((int)l) {
            case 8: {
                n = 0;
                break;
            }
            case 9: {
                n = 1;
                break;
            }
            case 10: {
                n = 2;
                break;
            }
            default: {
                n = -1;
            }
        }
        return n;
    }

    @Override
    public synchronized void setNotification(long l, ASIHMISyncCarClimateReply aSIHMISyncCarClimateReply) {
        super.setNotification(l, aSIHMISyncCarClimateReply);
        int n = ASICarClimateBaseServiceImpl.getMappedId(l);
        if (0 <= n) {
            this.addListener(n, aSIHMISyncCarClimateReply);
        }
    }

    @Override
    public synchronized void setNotification(ASIHMISyncCarClimateReply aSIHMISyncCarClimateReply) {
        super.setNotification(aSIHMISyncCarClimateReply);
        for (int i2 = 0; i2 < 3; ++i2) {
            this.addListener(i2, aSIHMISyncCarClimateReply);
        }
    }

    @Override
    public synchronized void setNotification(long[] lArray, ASIHMISyncCarClimateReply aSIHMISyncCarClimateReply) {
        super.setNotification(lArray, aSIHMISyncCarClimateReply);
        for (int i2 = 0; i2 < lArray.length; ++i2) {
            int n = ASICarClimateBaseServiceImpl.getMappedId(lArray[i2]);
            if (0 > n) continue;
            this.addListener(n, aSIHMISyncCarClimateReply);
        }
    }

    private void addListener(int n, ASIHMISyncCarClimateReply aSIHMISyncCarClimateReply) {
        Set set = this.attrListeners[n];
        if (null == set) {
            this.attrListeners[n] = set = new HashSet();
        }
        boolean bl = set.isEmpty();
        set.add(aSIHMISyncCarClimateReply);
        if (bl) {
            this.props.setNotification(n);
        }
    }

    @Override
    public synchronized void clearNotification(long l, ASIHMISyncCarClimateReply aSIHMISyncCarClimateReply) {
        super.clearNotification(l, aSIHMISyncCarClimateReply);
        int n = ASICarClimateBaseServiceImpl.getMappedId(l);
        if (0 <= n) {
            this.removeListener(n, aSIHMISyncCarClimateReply);
        }
    }

    @Override
    public synchronized void clearNotification(ASIHMISyncCarClimateReply aSIHMISyncCarClimateReply) {
        super.clearNotification(aSIHMISyncCarClimateReply);
        for (int i2 = 0; i2 < 3; ++i2) {
            this.removeListener(i2, aSIHMISyncCarClimateReply);
        }
    }

    @Override
    public synchronized void clearNotification(long[] lArray, ASIHMISyncCarClimateReply aSIHMISyncCarClimateReply) {
        super.clearNotification(lArray, aSIHMISyncCarClimateReply);
        for (int i2 = 0; i2 < lArray.length; ++i2) {
            int n = ASICarClimateBaseServiceImpl.getMappedId(lArray[i2]);
            if (0 > n) continue;
            this.removeListener(n, aSIHMISyncCarClimateReply);
        }
    }

    private void removeListener(int n, ASIHMISyncCarClimateReply aSIHMISyncCarClimateReply) {
        boolean bl;
        Set set = this.attrListeners[n];
        boolean bl2 = bl = null != set && set.remove(aSIHMISyncCarClimateReply) && set.isEmpty();
        if (bl) {
            this.props.clearNotification(n);
        }
    }

    @Override
    public void setAirconAC(boolean bl, ASIHMISyncCarClimateReply aSIHMISyncCarClimateReply) {
        try {
            this.service.setAirconAC(bl, ASICarClimateBaseServiceImpl$ResponseProxy.get(aSIHMISyncCarClimateReply));
        }
        catch (ASIException aSIException) {
            throw new MethodException(aSIException.toString());
        }
    }
}

