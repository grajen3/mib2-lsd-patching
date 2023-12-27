/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asi.headunit.impl;

import de.esolutions.fw.comm.asi.hmisync.headunit.ASIHMISyncHeadUnit$ReplyIDs;
import de.esolutions.fw.comm.asi.hmisync.headunit.ASIHMISyncHeadUnit$RequestIDs;
import de.esolutions.fw.comm.asi.hmisync.headunit.ASIHMISyncHeadUnitReply;
import de.esolutions.fw.comm.asi.hmisync.headunit.ClockDate;
import de.esolutions.fw.comm.asi.hmisync.headunit.ClockTime;
import de.esolutions.fw.comm.asi.hmisync.headunit.impl.ASIHMISyncHeadUnitAbstractBaseService;
import de.esolutions.fw.comm.core.method.MethodException;
import de.vw.mib.asi.ASIProperties;
import de.vw.mib.asi.headunit.ASIHeadUnit;
import de.vw.mib.asi.headunit.impl.ASIHeadUnitBaseServiceImpl$ListenerProxy;
import de.vw.mib.log4mib.ClassifiedLogger;
import java.util.HashSet;
import java.util.Set;

public class ASIHeadUnitBaseServiceImpl
extends ASIHMISyncHeadUnitAbstractBaseService {
    private static final int ATTR_COUNT;
    private final ClassifiedLogger clogger;
    private final Set[] attrListeners = new Set[12];
    private final ASIHeadUnitBaseServiceImpl$ListenerProxy listener = new ASIHeadUnitBaseServiceImpl$ListenerProxy(this);
    private final ASIHeadUnit service;
    private final ASIProperties props;

    public ASIHeadUnitBaseServiceImpl(ASIHeadUnit aSIHeadUnit, ASIProperties aSIProperties, ClassifiedLogger classifiedLogger) {
        this.service = aSIHeadUnit;
        this.props = aSIProperties;
        this.clogger = classifiedLogger;
    }

    public void init() {
        this.initBaseAttributes();
        this.service.setASIHeadUnitListener(this.listener);
    }

    private void initBaseAttributes() {
        try {
            this.updateASIVersion("1.2.00");
            this.updateRequestIDs(ASIHMISyncHeadUnit$RequestIDs.getIDs());
            this.updateReplyIDs(ASIHMISyncHeadUnit$ReplyIDs.getIDs());
        }
        catch (MethodException methodException) {
            this.clogger.error().append("ASIHeadUnit: Could not initialize base attributes.").attachThrowable(methodException).log();
        }
    }

    private static int getMappedId(long l) {
        int n;
        switch ((int)l) {
            case 16: {
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
            case 20: {
                n = 4;
                break;
            }
            case 11: {
                n = 5;
                break;
            }
            case 12: {
                n = 6;
                break;
            }
            case 13: {
                n = 7;
                break;
            }
            case 19: {
                n = 8;
                break;
            }
            case 14: {
                n = 9;
                break;
            }
            case 21: {
                n = 10;
                break;
            }
            case 15: {
                n = 11;
                break;
            }
            default: {
                n = -1;
            }
        }
        return n;
    }

    @Override
    public synchronized void setNotification(long l, ASIHMISyncHeadUnitReply aSIHMISyncHeadUnitReply) {
        super.setNotification(l, aSIHMISyncHeadUnitReply);
        int n = ASIHeadUnitBaseServiceImpl.getMappedId(l);
        if (0 <= n) {
            this.addListener(n, aSIHMISyncHeadUnitReply);
        }
    }

    @Override
    public synchronized void setNotification(ASIHMISyncHeadUnitReply aSIHMISyncHeadUnitReply) {
        super.setNotification(aSIHMISyncHeadUnitReply);
        for (int i2 = 0; i2 < 12; ++i2) {
            this.addListener(i2, aSIHMISyncHeadUnitReply);
        }
    }

    @Override
    public synchronized void setNotification(long[] lArray, ASIHMISyncHeadUnitReply aSIHMISyncHeadUnitReply) {
        super.setNotification(lArray, aSIHMISyncHeadUnitReply);
        for (int i2 = 0; i2 < lArray.length; ++i2) {
            int n = ASIHeadUnitBaseServiceImpl.getMappedId(lArray[i2]);
            if (0 > n) continue;
            this.addListener(n, aSIHMISyncHeadUnitReply);
        }
    }

    private void addListener(int n, ASIHMISyncHeadUnitReply aSIHMISyncHeadUnitReply) {
        Set set = this.attrListeners[n];
        if (null == set) {
            this.attrListeners[n] = set = new HashSet();
        }
        boolean bl = set.isEmpty();
        set.add(aSIHMISyncHeadUnitReply);
        if (bl) {
            this.props.setNotification(n);
        }
    }

    @Override
    public synchronized void clearNotification(long l, ASIHMISyncHeadUnitReply aSIHMISyncHeadUnitReply) {
        super.clearNotification(l, aSIHMISyncHeadUnitReply);
        int n = ASIHeadUnitBaseServiceImpl.getMappedId(l);
        if (0 <= n) {
            this.removeListener(n, aSIHMISyncHeadUnitReply);
        }
    }

    @Override
    public synchronized void clearNotification(ASIHMISyncHeadUnitReply aSIHMISyncHeadUnitReply) {
        super.clearNotification(aSIHMISyncHeadUnitReply);
        for (int i2 = 0; i2 < 12; ++i2) {
            this.removeListener(i2, aSIHMISyncHeadUnitReply);
        }
    }

    @Override
    public synchronized void clearNotification(long[] lArray, ASIHMISyncHeadUnitReply aSIHMISyncHeadUnitReply) {
        super.clearNotification(lArray, aSIHMISyncHeadUnitReply);
        for (int i2 = 0; i2 < lArray.length; ++i2) {
            int n = ASIHeadUnitBaseServiceImpl.getMappedId(lArray[i2]);
            if (0 > n) continue;
            this.removeListener(n, aSIHMISyncHeadUnitReply);
        }
    }

    private void removeListener(int n, ASIHMISyncHeadUnitReply aSIHMISyncHeadUnitReply) {
        boolean bl;
        Set set = this.attrListeners[n];
        boolean bl2 = bl = null != set && set.remove(aSIHMISyncHeadUnitReply) && set.isEmpty();
        if (bl) {
            this.props.clearNotification(n);
        }
    }

    @Override
    public ClockDate getClockDate() {
        return null;
    }

    @Override
    public ClockTime getClockTime() {
        return null;
    }
}

