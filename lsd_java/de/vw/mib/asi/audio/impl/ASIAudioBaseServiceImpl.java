/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asi.audio.impl;

import de.esolutions.fw.comm.asi.hmisync.audio.ASIHMISyncAudio$ReplyIDs;
import de.esolutions.fw.comm.asi.hmisync.audio.ASIHMISyncAudio$RequestIDs;
import de.esolutions.fw.comm.asi.hmisync.audio.ASIHMISyncAudioReply;
import de.esolutions.fw.comm.asi.hmisync.audio.impl.ASIHMISyncAudioAbstractBaseService;
import de.esolutions.fw.comm.core.method.MethodException;
import de.vw.mib.asi.ASIException;
import de.vw.mib.asi.ASIProperties;
import de.vw.mib.asi.audio.ASIAudio;
import de.vw.mib.asi.audio.impl.ASIAudioBaseServiceImpl$ListenerProxy;
import de.vw.mib.asi.audio.impl.ASIAudioBaseServiceImpl$ResponseProxy;
import de.vw.mib.log4mib.ClassifiedLogger;
import java.util.HashSet;
import java.util.Set;

public class ASIAudioBaseServiceImpl
extends ASIHMISyncAudioAbstractBaseService {
    private static final int ATTR_COUNT;
    private final ClassifiedLogger clogger;
    private final Set[] attrListeners = new Set[7];
    private final ASIAudioBaseServiceImpl$ListenerProxy listener = new ASIAudioBaseServiceImpl$ListenerProxy(this);
    private final ASIAudio service;
    private final ASIProperties props;

    public ASIAudioBaseServiceImpl(ASIAudio aSIAudio, ASIProperties aSIProperties, ClassifiedLogger classifiedLogger) {
        this.service = aSIAudio;
        this.props = aSIProperties;
        this.clogger = classifiedLogger;
    }

    public void init() {
        this.initBaseAttributes();
        this.service.setASIAudioListener(this.listener);
    }

    private void initBaseAttributes() {
        try {
            this.updateASIVersion("2.3.00");
            this.updateRequestIDs(ASIHMISyncAudio$RequestIDs.getIDs());
            this.updateReplyIDs(ASIHMISyncAudio$ReplyIDs.getIDs());
        }
        catch (MethodException methodException) {
            this.clogger.error().append("ASIAudio: Could not initialize base attributes.").attachThrowable(methodException).log();
        }
    }

    private static int getMappedId(long l) {
        int n;
        switch ((int)l) {
            case 23: {
                n = 0;
                break;
            }
            case 24: {
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
            case 17: {
                n = 4;
                break;
            }
            case 25: {
                n = 5;
                break;
            }
            case 18: {
                n = 6;
                break;
            }
            default: {
                n = -1;
            }
        }
        return n;
    }

    @Override
    public synchronized void setNotification(long l, ASIHMISyncAudioReply aSIHMISyncAudioReply) {
        super.setNotification(l, aSIHMISyncAudioReply);
        int n = ASIAudioBaseServiceImpl.getMappedId(l);
        if (0 <= n) {
            this.addListener(n, aSIHMISyncAudioReply);
        }
    }

    @Override
    public synchronized void setNotification(ASIHMISyncAudioReply aSIHMISyncAudioReply) {
        super.setNotification(aSIHMISyncAudioReply);
        for (int i2 = 0; i2 < 7; ++i2) {
            this.addListener(i2, aSIHMISyncAudioReply);
        }
    }

    @Override
    public synchronized void setNotification(long[] lArray, ASIHMISyncAudioReply aSIHMISyncAudioReply) {
        super.setNotification(lArray, aSIHMISyncAudioReply);
        for (int i2 = 0; i2 < lArray.length; ++i2) {
            int n = ASIAudioBaseServiceImpl.getMappedId(lArray[i2]);
            if (0 > n) continue;
            this.addListener(n, aSIHMISyncAudioReply);
        }
    }

    private void addListener(int n, ASIHMISyncAudioReply aSIHMISyncAudioReply) {
        Set set = this.attrListeners[n];
        if (null == set) {
            this.attrListeners[n] = set = new HashSet();
        }
        boolean bl = set.isEmpty();
        set.add(aSIHMISyncAudioReply);
        if (bl) {
            this.props.setNotification(n);
        }
    }

    @Override
    public synchronized void clearNotification(long l, ASIHMISyncAudioReply aSIHMISyncAudioReply) {
        super.clearNotification(l, aSIHMISyncAudioReply);
        int n = ASIAudioBaseServiceImpl.getMappedId(l);
        if (0 <= n) {
            this.removeListener(n, aSIHMISyncAudioReply);
        }
    }

    @Override
    public synchronized void clearNotification(ASIHMISyncAudioReply aSIHMISyncAudioReply) {
        super.clearNotification(aSIHMISyncAudioReply);
        for (int i2 = 0; i2 < 7; ++i2) {
            this.removeListener(i2, aSIHMISyncAudioReply);
        }
    }

    @Override
    public synchronized void clearNotification(long[] lArray, ASIHMISyncAudioReply aSIHMISyncAudioReply) {
        super.clearNotification(lArray, aSIHMISyncAudioReply);
        for (int i2 = 0; i2 < lArray.length; ++i2) {
            int n = ASIAudioBaseServiceImpl.getMappedId(lArray[i2]);
            if (0 > n) continue;
            this.removeListener(n, aSIHMISyncAudioReply);
        }
    }

    private void removeListener(int n, ASIHMISyncAudioReply aSIHMISyncAudioReply) {
        boolean bl;
        Set set = this.attrListeners[n];
        boolean bl2 = bl = null != set && set.remove(aSIHMISyncAudioReply) && set.isEmpty();
        if (bl) {
            this.props.clearNotification(n);
        }
    }

    @Override
    public void setAudioContext(int n, ASIHMISyncAudioReply aSIHMISyncAudioReply) {
        try {
            this.service.setAudioContext(n, ASIAudioBaseServiceImpl$ResponseProxy.get(aSIHMISyncAudioReply));
        }
        catch (ASIException aSIException) {
            throw new MethodException(aSIException.toString());
        }
    }

    @Override
    public void forceFrontAudioContext(int n, ASIHMISyncAudioReply aSIHMISyncAudioReply) {
        try {
            this.service.forceFrontAudioContext(n, ASIAudioBaseServiceImpl$ResponseProxy.get(aSIHMISyncAudioReply));
        }
        catch (ASIException aSIException) {
            throw new MethodException(aSIException.toString());
        }
    }

    @Override
    public void requestEnableA2LS(String string, ASIHMISyncAudioReply aSIHMISyncAudioReply) {
        try {
            this.service.requestEnableA2LS(string, ASIAudioBaseServiceImpl$ResponseProxy.get(aSIHMISyncAudioReply));
        }
        catch (ASIException aSIException) {
            throw new MethodException(aSIException.toString());
        }
    }

    @Override
    public void disableA2LS(ASIHMISyncAudioReply aSIHMISyncAudioReply) {
        try {
            this.service.disableA2LS(ASIAudioBaseServiceImpl$ResponseProxy.get(aSIHMISyncAudioReply));
        }
        catch (ASIException aSIException) {
            throw new MethodException(aSIException.toString());
        }
    }

    @Override
    public void setVolume(int n, ASIHMISyncAudioReply aSIHMISyncAudioReply) {
        try {
            this.service.setVolume(n, ASIAudioBaseServiceImpl$ResponseProxy.get(aSIHMISyncAudioReply));
        }
        catch (ASIException aSIException) {
            throw new MethodException(aSIException.toString());
        }
    }

    @Override
    public void increaseVolume(int n, ASIHMISyncAudioReply aSIHMISyncAudioReply) {
        try {
            this.service.increaseVolume(n, ASIAudioBaseServiceImpl$ResponseProxy.get(aSIHMISyncAudioReply));
        }
        catch (ASIException aSIException) {
            throw new MethodException(aSIException.toString());
        }
    }

    @Override
    public void decreaseVolume(int n, ASIHMISyncAudioReply aSIHMISyncAudioReply) {
        try {
            this.service.decreaseVolume(n, ASIAudioBaseServiceImpl$ResponseProxy.get(aSIHMISyncAudioReply));
        }
        catch (ASIException aSIException) {
            throw new MethodException(aSIException.toString());
        }
    }
}

