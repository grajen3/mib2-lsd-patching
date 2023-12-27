/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asi.car.bc.impl;

import de.esolutions.fw.comm.asi.hmisync.car.bc.ASIHMISyncCarBordComputer$ReplyIDs;
import de.esolutions.fw.comm.asi.hmisync.car.bc.ASIHMISyncCarBordComputer$RequestIDs;
import de.esolutions.fw.comm.asi.hmisync.car.bc.ASIHMISyncCarBordComputerReply;
import de.esolutions.fw.comm.asi.hmisync.car.bc.impl.ASIHMISyncCarBordComputerAbstractBaseService;
import de.esolutions.fw.comm.core.method.MethodException;
import de.vw.mib.asi.ASIProperties;
import de.vw.mib.asi.car.bc.ASICarBordComputer;
import de.vw.mib.asi.car.bc.impl.ASICarBordComputerBaseServiceImpl$ListenerProxy;
import de.vw.mib.log4mib.ClassifiedLogger;
import java.util.HashSet;
import java.util.Set;

public class ASICarBordComputerBaseServiceImpl
extends ASIHMISyncCarBordComputerAbstractBaseService {
    private static final int ATTR_COUNT;
    private final ClassifiedLogger clogger;
    private final Set[] attrListeners = new Set[16];
    private final ASICarBordComputerBaseServiceImpl$ListenerProxy listener = new ASICarBordComputerBaseServiceImpl$ListenerProxy(this);
    private final ASICarBordComputer service;
    private final ASIProperties props;

    public ASICarBordComputerBaseServiceImpl(ASICarBordComputer aSICarBordComputer, ASIProperties aSIProperties, ClassifiedLogger classifiedLogger) {
        this.service = aSICarBordComputer;
        this.props = aSIProperties;
        this.clogger = classifiedLogger;
    }

    public void init() {
        this.initBaseAttributes();
        this.service.setASICarBordComputerListener(this.listener);
    }

    private void initBaseAttributes() {
        try {
            this.updateASIVersion("1.0.00");
            this.updateRequestIDs(ASIHMISyncCarBordComputer$RequestIDs.getIDs());
            this.updateReplyIDs(ASIHMISyncCarBordComputer$ReplyIDs.getIDs());
        }
        catch (MethodException methodException) {
            this.clogger.error().append("ASICarBordComputer: Could not initialize base attributes.").attachThrowable(methodException).log();
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
            case 13: {
                n = 6;
                break;
            }
            case 14: {
                n = 7;
                break;
            }
            case 15: {
                n = 8;
                break;
            }
            case 16: {
                n = 9;
                break;
            }
            case 17: {
                n = 10;
                break;
            }
            case 18: {
                n = 11;
                break;
            }
            case 19: {
                n = 12;
                break;
            }
            case 20: {
                n = 13;
                break;
            }
            case 21: {
                n = 14;
                break;
            }
            case 22: {
                n = 15;
                break;
            }
            default: {
                n = -1;
            }
        }
        return n;
    }

    @Override
    public synchronized void setNotification(long l, ASIHMISyncCarBordComputerReply aSIHMISyncCarBordComputerReply) {
        super.setNotification(l, aSIHMISyncCarBordComputerReply);
        int n = ASICarBordComputerBaseServiceImpl.getMappedId(l);
        if (0 <= n) {
            this.addListener(n, aSIHMISyncCarBordComputerReply);
        }
    }

    @Override
    public synchronized void setNotification(ASIHMISyncCarBordComputerReply aSIHMISyncCarBordComputerReply) {
        super.setNotification(aSIHMISyncCarBordComputerReply);
        for (int i2 = 0; i2 < 16; ++i2) {
            this.addListener(i2, aSIHMISyncCarBordComputerReply);
        }
    }

    @Override
    public synchronized void setNotification(long[] lArray, ASIHMISyncCarBordComputerReply aSIHMISyncCarBordComputerReply) {
        super.setNotification(lArray, aSIHMISyncCarBordComputerReply);
        for (int i2 = 0; i2 < lArray.length; ++i2) {
            int n = ASICarBordComputerBaseServiceImpl.getMappedId(lArray[i2]);
            if (0 > n) continue;
            this.addListener(n, aSIHMISyncCarBordComputerReply);
        }
    }

    private void addListener(int n, ASIHMISyncCarBordComputerReply aSIHMISyncCarBordComputerReply) {
        Set set = this.attrListeners[n];
        if (null == set) {
            this.attrListeners[n] = set = new HashSet();
        }
        boolean bl = set.isEmpty();
        set.add(aSIHMISyncCarBordComputerReply);
        if (bl) {
            this.props.setNotification(n);
        }
    }

    @Override
    public synchronized void clearNotification(long l, ASIHMISyncCarBordComputerReply aSIHMISyncCarBordComputerReply) {
        super.clearNotification(l, aSIHMISyncCarBordComputerReply);
        int n = ASICarBordComputerBaseServiceImpl.getMappedId(l);
        if (0 <= n) {
            this.removeListener(n, aSIHMISyncCarBordComputerReply);
        }
    }

    @Override
    public synchronized void clearNotification(ASIHMISyncCarBordComputerReply aSIHMISyncCarBordComputerReply) {
        super.clearNotification(aSIHMISyncCarBordComputerReply);
        for (int i2 = 0; i2 < 16; ++i2) {
            this.removeListener(i2, aSIHMISyncCarBordComputerReply);
        }
    }

    @Override
    public synchronized void clearNotification(long[] lArray, ASIHMISyncCarBordComputerReply aSIHMISyncCarBordComputerReply) {
        super.clearNotification(lArray, aSIHMISyncCarBordComputerReply);
        for (int i2 = 0; i2 < lArray.length; ++i2) {
            int n = ASICarBordComputerBaseServiceImpl.getMappedId(lArray[i2]);
            if (0 > n) continue;
            this.removeListener(n, aSIHMISyncCarBordComputerReply);
        }
    }

    private void removeListener(int n, ASIHMISyncCarBordComputerReply aSIHMISyncCarBordComputerReply) {
        boolean bl;
        Set set = this.attrListeners[n];
        boolean bl2 = bl = null != set && set.remove(aSIHMISyncCarBordComputerReply) && set.isEmpty();
        if (bl) {
            this.props.clearNotification(n);
        }
    }
}

