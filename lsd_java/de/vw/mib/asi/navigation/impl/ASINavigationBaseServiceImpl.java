/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asi.navigation.impl;

import de.esolutions.fw.comm.asi.hmisync.navigation.ASIHMISyncNavigation$ReplyIDs;
import de.esolutions.fw.comm.asi.hmisync.navigation.ASIHMISyncNavigation$RequestIDs;
import de.esolutions.fw.comm.asi.hmisync.navigation.ASIHMISyncNavigationReply;
import de.esolutions.fw.comm.asi.hmisync.navigation.DestinationInfo;
import de.esolutions.fw.comm.asi.hmisync.navigation.impl.ASIHMISyncNavigationAbstractBaseService;
import de.esolutions.fw.comm.core.method.MethodException;
import de.vw.mib.asi.ASIException;
import de.vw.mib.asi.ASIProperties;
import de.vw.mib.asi.navigation.ASINavigation;
import de.vw.mib.asi.navigation.impl.ASINavigationBaseServiceImpl$ListenerProxy;
import de.vw.mib.asi.navigation.impl.ASINavigationBaseServiceImpl$ResponseProxy;
import de.vw.mib.log4mib.ClassifiedLogger;
import java.util.HashSet;
import java.util.Set;

public class ASINavigationBaseServiceImpl
extends ASIHMISyncNavigationAbstractBaseService {
    private static final int ATTR_COUNT;
    private final ClassifiedLogger clogger;
    private final Set[] attrListeners = new Set[6];
    private final ASINavigationBaseServiceImpl$ListenerProxy listener = new ASINavigationBaseServiceImpl$ListenerProxy(this);
    private final ASINavigation service;
    private final ASIProperties props;

    public ASINavigationBaseServiceImpl(ASINavigation aSINavigation, ASIProperties aSIProperties, ClassifiedLogger classifiedLogger) {
        this.service = aSINavigation;
        this.props = aSIProperties;
        this.clogger = classifiedLogger;
    }

    public void init() {
        this.initBaseAttributes();
        this.service.setASINavigationListener(this.listener);
    }

    private void initBaseAttributes() {
        try {
            this.updateASIVersion("2.1.00");
            this.updateRequestIDs(ASIHMISyncNavigation$RequestIDs.getIDs());
            this.updateReplyIDs(ASIHMISyncNavigation$ReplyIDs.getIDs());
        }
        catch (MethodException methodException) {
            this.clogger.error().append("ASINavigation: Could not initialize base attributes.").attachThrowable(methodException).log();
        }
    }

    private static int getMappedId(long l) {
        int n;
        switch ((int)l) {
            case 11: {
                n = 0;
                break;
            }
            case 12: {
                n = 1;
                break;
            }
            case 13: {
                n = 2;
                break;
            }
            case 15: {
                n = 3;
                break;
            }
            case 17: {
                n = 4;
                break;
            }
            case 16: {
                n = 5;
                break;
            }
            default: {
                n = -1;
            }
        }
        return n;
    }

    @Override
    public synchronized void setNotification(long l, ASIHMISyncNavigationReply aSIHMISyncNavigationReply) {
        super.setNotification(l, aSIHMISyncNavigationReply);
        int n = ASINavigationBaseServiceImpl.getMappedId(l);
        if (0 <= n) {
            this.addListener(n, aSIHMISyncNavigationReply);
        }
    }

    @Override
    public synchronized void setNotification(ASIHMISyncNavigationReply aSIHMISyncNavigationReply) {
        super.setNotification(aSIHMISyncNavigationReply);
        for (int i2 = 0; i2 < 6; ++i2) {
            this.addListener(i2, aSIHMISyncNavigationReply);
        }
    }

    @Override
    public synchronized void setNotification(long[] lArray, ASIHMISyncNavigationReply aSIHMISyncNavigationReply) {
        super.setNotification(lArray, aSIHMISyncNavigationReply);
        for (int i2 = 0; i2 < lArray.length; ++i2) {
            int n = ASINavigationBaseServiceImpl.getMappedId(lArray[i2]);
            if (0 > n) continue;
            this.addListener(n, aSIHMISyncNavigationReply);
        }
    }

    private void addListener(int n, ASIHMISyncNavigationReply aSIHMISyncNavigationReply) {
        Set set = this.attrListeners[n];
        if (null == set) {
            this.attrListeners[n] = set = new HashSet();
        }
        boolean bl = set.isEmpty();
        set.add(aSIHMISyncNavigationReply);
        if (bl) {
            this.props.setNotification(n);
        }
    }

    @Override
    public synchronized void clearNotification(long l, ASIHMISyncNavigationReply aSIHMISyncNavigationReply) {
        super.clearNotification(l, aSIHMISyncNavigationReply);
        int n = ASINavigationBaseServiceImpl.getMappedId(l);
        if (0 <= n) {
            this.removeListener(n, aSIHMISyncNavigationReply);
        }
    }

    @Override
    public synchronized void clearNotification(ASIHMISyncNavigationReply aSIHMISyncNavigationReply) {
        super.clearNotification(aSIHMISyncNavigationReply);
        for (int i2 = 0; i2 < 6; ++i2) {
            this.removeListener(i2, aSIHMISyncNavigationReply);
        }
    }

    @Override
    public synchronized void clearNotification(long[] lArray, ASIHMISyncNavigationReply aSIHMISyncNavigationReply) {
        super.clearNotification(lArray, aSIHMISyncNavigationReply);
        for (int i2 = 0; i2 < lArray.length; ++i2) {
            int n = ASINavigationBaseServiceImpl.getMappedId(lArray[i2]);
            if (0 > n) continue;
            this.removeListener(n, aSIHMISyncNavigationReply);
        }
    }

    private void removeListener(int n, ASIHMISyncNavigationReply aSIHMISyncNavigationReply) {
        boolean bl;
        Set set = this.attrListeners[n];
        boolean bl2 = bl = null != set && set.remove(aSIHMISyncNavigationReply) && set.isEmpty();
        if (bl) {
            this.props.clearNotification(n);
        }
    }

    @Override
    public void startGuidanceToDestinations(DestinationInfo[] destinationInfoArray, ASIHMISyncNavigationReply aSIHMISyncNavigationReply) {
        try {
            this.service.startGuidanceToDestinations(destinationInfoArray, ASINavigationBaseServiceImpl$ResponseProxy.get(aSIHMISyncNavigationReply));
        }
        catch (ASIException aSIException) {
            throw new MethodException(aSIException.toString());
        }
    }
}

