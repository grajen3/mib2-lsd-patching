/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asi.media.impl;

import de.esolutions.fw.comm.asi.hmisync.media.ASIHMISyncMedia$ReplyIDs;
import de.esolutions.fw.comm.asi.hmisync.media.ASIHMISyncMedia$RequestIDs;
import de.esolutions.fw.comm.asi.hmisync.media.ASIHMISyncMediaReply;
import de.esolutions.fw.comm.asi.hmisync.media.MediaBrowserSelectionData;
import de.esolutions.fw.comm.asi.hmisync.media.MediaSourceSlot;
import de.esolutions.fw.comm.asi.hmisync.media.impl.ASIHMISyncMediaAbstractBaseService;
import de.esolutions.fw.comm.core.method.MethodException;
import de.vw.mib.asi.ASIException;
import de.vw.mib.asi.ASIProperties;
import de.vw.mib.asi.media.ASIMedia;
import de.vw.mib.asi.media.impl.ASIMediaBaseServiceImpl$ListenerProxy;
import de.vw.mib.asi.media.impl.ASIMediaBaseServiceImpl$ResponseProxy;
import de.vw.mib.log4mib.ClassifiedLogger;
import java.util.HashSet;
import java.util.Set;

public class ASIMediaBaseServiceImpl
extends ASIHMISyncMediaAbstractBaseService {
    private static final int ATTR_COUNT;
    private final ClassifiedLogger clogger;
    private final Set[] attrListeners = new Set[10];
    private final ASIMediaBaseServiceImpl$ListenerProxy listener = new ASIMediaBaseServiceImpl$ListenerProxy(this);
    private final ASIMedia service;
    private final ASIProperties props;

    public ASIMediaBaseServiceImpl(ASIMedia aSIMedia, ASIProperties aSIProperties, ClassifiedLogger classifiedLogger) {
        this.service = aSIMedia;
        this.props = aSIProperties;
        this.clogger = classifiedLogger;
    }

    public void init() {
        this.initBaseAttributes();
        this.service.setASIMediaListener(this.listener);
    }

    private void initBaseAttributes() {
        try {
            this.updateASIVersion("4.4.00");
            this.updateRequestIDs(ASIHMISyncMedia$RequestIDs.getIDs());
            this.updateReplyIDs(ASIHMISyncMedia$ReplyIDs.getIDs());
        }
        catch (MethodException methodException) {
            this.clogger.error().append("ASIMedia: Could not initialize base attributes.").attachThrowable(methodException).log();
        }
    }

    private static int getMappedId(long l) {
        int n;
        switch ((int)l) {
            case 22: {
                n = 0;
                break;
            }
            case 23: {
                n = 1;
                break;
            }
            case 24: {
                n = 2;
                break;
            }
            case 25: {
                n = 3;
                break;
            }
            case 26: {
                n = 4;
                break;
            }
            case 37: {
                n = 5;
                break;
            }
            case 27: {
                n = 6;
                break;
            }
            case 28: {
                n = 7;
                break;
            }
            case 29: {
                n = 8;
                break;
            }
            case 30: {
                n = 9;
                break;
            }
            default: {
                n = -1;
            }
        }
        return n;
    }

    @Override
    public synchronized void setNotification(long l, ASIHMISyncMediaReply aSIHMISyncMediaReply) {
        super.setNotification(l, aSIHMISyncMediaReply);
        int n = ASIMediaBaseServiceImpl.getMappedId(l);
        if (0 <= n) {
            this.addListener(n, aSIHMISyncMediaReply);
        }
    }

    @Override
    public synchronized void setNotification(ASIHMISyncMediaReply aSIHMISyncMediaReply) {
        super.setNotification(aSIHMISyncMediaReply);
        for (int i2 = 0; i2 < 10; ++i2) {
            this.addListener(i2, aSIHMISyncMediaReply);
        }
    }

    @Override
    public synchronized void setNotification(long[] lArray, ASIHMISyncMediaReply aSIHMISyncMediaReply) {
        super.setNotification(lArray, aSIHMISyncMediaReply);
        for (int i2 = 0; i2 < lArray.length; ++i2) {
            int n = ASIMediaBaseServiceImpl.getMappedId(lArray[i2]);
            if (0 > n) continue;
            this.addListener(n, aSIHMISyncMediaReply);
        }
    }

    private void addListener(int n, ASIHMISyncMediaReply aSIHMISyncMediaReply) {
        Set set = this.attrListeners[n];
        if (null == set) {
            this.attrListeners[n] = set = new HashSet();
        }
        boolean bl = set.isEmpty();
        set.add(aSIHMISyncMediaReply);
        if (bl) {
            this.props.setNotification(n);
        }
    }

    @Override
    public synchronized void clearNotification(long l, ASIHMISyncMediaReply aSIHMISyncMediaReply) {
        super.clearNotification(l, aSIHMISyncMediaReply);
        int n = ASIMediaBaseServiceImpl.getMappedId(l);
        if (0 <= n) {
            this.removeListener(n, aSIHMISyncMediaReply);
        }
    }

    @Override
    public synchronized void clearNotification(ASIHMISyncMediaReply aSIHMISyncMediaReply) {
        super.clearNotification(aSIHMISyncMediaReply);
        for (int i2 = 0; i2 < 10; ++i2) {
            this.removeListener(i2, aSIHMISyncMediaReply);
        }
    }

    @Override
    public synchronized void clearNotification(long[] lArray, ASIHMISyncMediaReply aSIHMISyncMediaReply) {
        super.clearNotification(lArray, aSIHMISyncMediaReply);
        for (int i2 = 0; i2 < lArray.length; ++i2) {
            int n = ASIMediaBaseServiceImpl.getMappedId(lArray[i2]);
            if (0 > n) continue;
            this.removeListener(n, aSIHMISyncMediaReply);
        }
    }

    private void removeListener(int n, ASIHMISyncMediaReply aSIHMISyncMediaReply) {
        boolean bl;
        Set set = this.attrListeners[n];
        boolean bl2 = bl = null != set && set.remove(aSIHMISyncMediaReply) && set.isEmpty();
        if (bl) {
            this.props.clearNotification(n);
        }
    }

    @Override
    public void activate(MediaSourceSlot mediaSourceSlot, MediaBrowserSelectionData mediaBrowserSelectionData, ASIHMISyncMediaReply aSIHMISyncMediaReply) {
        try {
            this.service.activate(mediaSourceSlot, mediaBrowserSelectionData, ASIMediaBaseServiceImpl$ResponseProxy.get(aSIHMISyncMediaReply));
        }
        catch (ASIException aSIException) {
            throw new MethodException(aSIException.toString());
        }
    }

    @Override
    public void resume(ASIHMISyncMediaReply aSIHMISyncMediaReply) {
        try {
            this.service.resume(ASIMediaBaseServiceImpl$ResponseProxy.get(aSIHMISyncMediaReply));
        }
        catch (ASIException aSIException) {
            throw new MethodException(aSIException.toString());
        }
    }

    @Override
    public void pause(ASIHMISyncMediaReply aSIHMISyncMediaReply) {
        try {
            this.service.pause(ASIMediaBaseServiceImpl$ResponseProxy.get(aSIHMISyncMediaReply));
        }
        catch (ASIException aSIException) {
            throw new MethodException(aSIException.toString());
        }
    }

    @Override
    public void skip(byte by, ASIHMISyncMediaReply aSIHMISyncMediaReply) {
        try {
            this.service.skip(by, ASIMediaBaseServiceImpl$ResponseProxy.get(aSIHMISyncMediaReply));
        }
        catch (ASIException aSIException) {
            throw new MethodException(aSIException.toString());
        }
    }

    @Override
    public void seek(boolean bl, ASIHMISyncMediaReply aSIHMISyncMediaReply) {
        try {
            this.service.seek(bl, ASIMediaBaseServiceImpl$ResponseProxy.get(aSIHMISyncMediaReply));
        }
        catch (ASIException aSIException) {
            throw new MethodException(aSIException.toString());
        }
    }

    @Override
    public void stopSeek(ASIHMISyncMediaReply aSIHMISyncMediaReply) {
        try {
            this.service.stopSeek(ASIMediaBaseServiceImpl$ResponseProxy.get(aSIHMISyncMediaReply));
        }
        catch (ASIException aSIException) {
            throw new MethodException(aSIException.toString());
        }
    }

    @Override
    public void mix(boolean bl, ASIHMISyncMediaReply aSIHMISyncMediaReply) {
        try {
            this.service.mix(bl, ASIMediaBaseServiceImpl$ResponseProxy.get(aSIHMISyncMediaReply));
        }
        catch (ASIException aSIException) {
            throw new MethodException(aSIException.toString());
        }
    }

    @Override
    public void repeatTitle(boolean bl, ASIHMISyncMediaReply aSIHMISyncMediaReply) {
        try {
            this.service.repeatTitle(bl, ASIMediaBaseServiceImpl$ResponseProxy.get(aSIHMISyncMediaReply));
        }
        catch (ASIException aSIException) {
            throw new MethodException(aSIException.toString());
        }
    }

    @Override
    public void setEntry(long l, ASIHMISyncMediaReply aSIHMISyncMediaReply) {
        try {
            this.service.setEntry(l, ASIMediaBaseServiceImpl$ResponseProxy.get(aSIHMISyncMediaReply));
        }
        catch (ASIException aSIException) {
            throw new MethodException(aSIException.toString());
        }
    }

    @Override
    public void setTimePosition(int n, ASIHMISyncMediaReply aSIHMISyncMediaReply) {
        try {
            this.service.setTimePosition(n, ASIMediaBaseServiceImpl$ResponseProxy.get(aSIHMISyncMediaReply));
        }
        catch (ASIException aSIException) {
            throw new MethodException(aSIException.toString());
        }
    }

    @Override
    public void touchEvent(int n, int n2, int n3, int n4, int n5, ASIHMISyncMediaReply aSIHMISyncMediaReply) {
        try {
            this.service.touchEvent(n, n2, n3, n4, n5, ASIMediaBaseServiceImpl$ResponseProxy.get(aSIHMISyncMediaReply));
        }
        catch (ASIException aSIException) {
            throw new MethodException(aSIException.toString());
        }
    }

    @Override
    public void executeDvdVideoCommand(int n, ASIHMISyncMediaReply aSIHMISyncMediaReply) {
        try {
            this.service.executeDvdVideoCommand(n, ASIMediaBaseServiceImpl$ResponseProxy.get(aSIHMISyncMediaReply));
        }
        catch (ASIException aSIException) {
            throw new MethodException(aSIException.toString());
        }
    }

    @Override
    public void requestPlayList(int n, long l, int n2, ASIHMISyncMediaReply aSIHMISyncMediaReply) {
        try {
            this.service.requestPlayList(n, l, n2, ASIMediaBaseServiceImpl$ResponseProxy.get(aSIHMISyncMediaReply));
        }
        catch (ASIException aSIException) {
            throw new MethodException(aSIException.toString());
        }
    }

    @Override
    public void setPlaySelection(MediaBrowserSelectionData mediaBrowserSelectionData, ASIHMISyncMediaReply aSIHMISyncMediaReply) {
        try {
            this.service.setPlaySelection(mediaBrowserSelectionData, ASIMediaBaseServiceImpl$ResponseProxy.get(aSIHMISyncMediaReply));
        }
        catch (ASIException aSIException) {
            throw new MethodException(aSIException.toString());
        }
    }

    @Override
    public void playMoreFrom(long l, int n, ASIHMISyncMediaReply aSIHMISyncMediaReply) {
        try {
            this.service.playMoreFrom(l, n, ASIMediaBaseServiceImpl$ResponseProxy.get(aSIHMISyncMediaReply));
        }
        catch (ASIException aSIException) {
            throw new MethodException(aSIException.toString());
        }
    }
}

