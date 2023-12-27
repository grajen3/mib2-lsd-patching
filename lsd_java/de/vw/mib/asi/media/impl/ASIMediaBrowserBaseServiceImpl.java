/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asi.media.impl;

import de.esolutions.fw.comm.asi.hmisync.media.ASIHMISyncMediaBrowser$ReplyIDs;
import de.esolutions.fw.comm.asi.hmisync.media.ASIHMISyncMediaBrowser$RequestIDs;
import de.esolutions.fw.comm.asi.hmisync.media.ASIHMISyncMediaBrowserReply;
import de.esolutions.fw.comm.asi.hmisync.media.MediaEntry;
import de.esolutions.fw.comm.asi.hmisync.media.MediaSourceSlot;
import de.esolutions.fw.comm.asi.hmisync.media.impl.ASIHMISyncMediaBrowserAbstractBaseService;
import de.esolutions.fw.comm.core.method.MethodException;
import de.vw.mib.asi.ASIException;
import de.vw.mib.asi.ASIProperties;
import de.vw.mib.asi.media.ASIMediaBrowser;
import de.vw.mib.asi.media.impl.ASIMediaBrowserBaseServiceImpl$ListenerProxy;
import de.vw.mib.asi.media.impl.ASIMediaBrowserBaseServiceImpl$ResponseProxy;
import de.vw.mib.log4mib.ClassifiedLogger;
import java.util.HashSet;
import java.util.Set;

public class ASIMediaBrowserBaseServiceImpl
extends ASIHMISyncMediaBrowserAbstractBaseService {
    private static final int ATTR_COUNT;
    private final ClassifiedLogger clogger;
    private final Set[] attrListeners = new Set[6];
    private final ASIMediaBrowserBaseServiceImpl$ListenerProxy listener = new ASIMediaBrowserBaseServiceImpl$ListenerProxy(this);
    private final ASIMediaBrowser service;
    private final ASIProperties props;

    public ASIMediaBrowserBaseServiceImpl(ASIMediaBrowser aSIMediaBrowser, ASIProperties aSIProperties, ClassifiedLogger classifiedLogger) {
        this.service = aSIMediaBrowser;
        this.props = aSIProperties;
        this.clogger = classifiedLogger;
    }

    public void init() {
        this.initBaseAttributes();
        this.service.setASIMediaBrowserListener(this.listener);
    }

    private void initBaseAttributes() {
        try {
            this.updateASIVersion("2.2.00");
            this.updateRequestIDs(ASIHMISyncMediaBrowser$RequestIDs.getIDs());
            this.updateReplyIDs(ASIHMISyncMediaBrowser$ReplyIDs.getIDs());
        }
        catch (MethodException methodException) {
            this.clogger.error().append("ASIMediaBrowser: Could not initialize base attributes.").attachThrowable(methodException).log();
        }
    }

    private static int getMappedId(long l) {
        int n;
        switch ((int)l) {
            case 16: {
                n = 0;
                break;
            }
            case 17: {
                n = 1;
                break;
            }
            case 18: {
                n = 2;
                break;
            }
            case 19: {
                n = 3;
                break;
            }
            case 20: {
                n = 4;
                break;
            }
            case 21: {
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
    public synchronized void setNotification(long l, ASIHMISyncMediaBrowserReply aSIHMISyncMediaBrowserReply) {
        super.setNotification(l, aSIHMISyncMediaBrowserReply);
        int n = ASIMediaBrowserBaseServiceImpl.getMappedId(l);
        if (0 <= n) {
            this.addListener(n, aSIHMISyncMediaBrowserReply);
        }
    }

    @Override
    public synchronized void setNotification(ASIHMISyncMediaBrowserReply aSIHMISyncMediaBrowserReply) {
        super.setNotification(aSIHMISyncMediaBrowserReply);
        for (int i2 = 0; i2 < 6; ++i2) {
            this.addListener(i2, aSIHMISyncMediaBrowserReply);
        }
    }

    @Override
    public synchronized void setNotification(long[] lArray, ASIHMISyncMediaBrowserReply aSIHMISyncMediaBrowserReply) {
        super.setNotification(lArray, aSIHMISyncMediaBrowserReply);
        for (int i2 = 0; i2 < lArray.length; ++i2) {
            int n = ASIMediaBrowserBaseServiceImpl.getMappedId(lArray[i2]);
            if (0 > n) continue;
            this.addListener(n, aSIHMISyncMediaBrowserReply);
        }
    }

    private void addListener(int n, ASIHMISyncMediaBrowserReply aSIHMISyncMediaBrowserReply) {
        Set set = this.attrListeners[n];
        if (null == set) {
            this.attrListeners[n] = set = new HashSet();
        }
        boolean bl = set.isEmpty();
        set.add(aSIHMISyncMediaBrowserReply);
        if (bl) {
            this.props.setNotification(n);
        }
    }

    @Override
    public synchronized void clearNotification(long l, ASIHMISyncMediaBrowserReply aSIHMISyncMediaBrowserReply) {
        super.clearNotification(l, aSIHMISyncMediaBrowserReply);
        int n = ASIMediaBrowserBaseServiceImpl.getMappedId(l);
        if (0 <= n) {
            this.removeListener(n, aSIHMISyncMediaBrowserReply);
        }
    }

    @Override
    public synchronized void clearNotification(ASIHMISyncMediaBrowserReply aSIHMISyncMediaBrowserReply) {
        super.clearNotification(aSIHMISyncMediaBrowserReply);
        for (int i2 = 0; i2 < 6; ++i2) {
            this.removeListener(i2, aSIHMISyncMediaBrowserReply);
        }
    }

    @Override
    public synchronized void clearNotification(long[] lArray, ASIHMISyncMediaBrowserReply aSIHMISyncMediaBrowserReply) {
        super.clearNotification(lArray, aSIHMISyncMediaBrowserReply);
        for (int i2 = 0; i2 < lArray.length; ++i2) {
            int n = ASIMediaBrowserBaseServiceImpl.getMappedId(lArray[i2]);
            if (0 > n) continue;
            this.removeListener(n, aSIHMISyncMediaBrowserReply);
        }
    }

    private void removeListener(int n, ASIHMISyncMediaBrowserReply aSIHMISyncMediaBrowserReply) {
        boolean bl;
        Set set = this.attrListeners[n];
        boolean bl2 = bl = null != set && set.remove(aSIHMISyncMediaBrowserReply) && set.isEmpty();
        if (bl) {
            this.props.clearNotification(n);
        }
    }

    @Override
    public void activate(MediaSourceSlot mediaSourceSlot, ASIHMISyncMediaBrowserReply aSIHMISyncMediaBrowserReply) {
        try {
            this.service.activate(mediaSourceSlot, ASIMediaBrowserBaseServiceImpl$ResponseProxy.get(aSIHMISyncMediaBrowserReply));
        }
        catch (ASIException aSIException) {
            throw new MethodException(aSIException.toString());
        }
    }

    @Override
    public void deactivate(ASIHMISyncMediaBrowserReply aSIHMISyncMediaBrowserReply) {
        try {
            this.service.deactivate(ASIMediaBrowserBaseServiceImpl$ResponseProxy.get(aSIHMISyncMediaBrowserReply));
        }
        catch (ASIException aSIException) {
            throw new MethodException(aSIException.toString());
        }
    }

    @Override
    public void setBrowseMode(int n, ASIHMISyncMediaBrowserReply aSIHMISyncMediaBrowserReply) {
        try {
            this.service.setBrowseMode(n, ASIMediaBrowserBaseServiceImpl$ResponseProxy.get(aSIHMISyncMediaBrowserReply));
        }
        catch (ASIException aSIException) {
            throw new MethodException(aSIException.toString());
        }
    }

    @Override
    public void changeFolder(MediaEntry[] mediaEntryArray, ASIHMISyncMediaBrowserReply aSIHMISyncMediaBrowserReply) {
        try {
            this.service.changeFolder(mediaEntryArray, ASIMediaBrowserBaseServiceImpl$ResponseProxy.get(aSIHMISyncMediaBrowserReply));
        }
        catch (ASIException aSIException) {
            throw new MethodException(aSIException.toString());
        }
    }

    @Override
    public void addSelection(int n, MediaEntry mediaEntry, ASIHMISyncMediaBrowserReply aSIHMISyncMediaBrowserReply) {
        try {
            this.service.addSelection(n, mediaEntry, ASIMediaBrowserBaseServiceImpl$ResponseProxy.get(aSIHMISyncMediaBrowserReply));
        }
        catch (ASIException aSIException) {
            throw new MethodException(aSIException.toString());
        }
    }

    @Override
    public void requestList(int n, long l, int n2, int n3, ASIHMISyncMediaBrowserReply aSIHMISyncMediaBrowserReply) {
        try {
            this.service.requestList(n, l, n2, n3, ASIMediaBrowserBaseServiceImpl$ResponseProxy.get(aSIHMISyncMediaBrowserReply));
        }
        catch (ASIException aSIException) {
            throw new MethodException(aSIException.toString());
        }
    }
}

