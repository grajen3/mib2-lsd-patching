/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asi.sound.impl;

import de.esolutions.fw.comm.asi.hmisync.sound.ASIHMISyncSound$ReplyIDs;
import de.esolutions.fw.comm.asi.hmisync.sound.ASIHMISyncSound$RequestIDs;
import de.esolutions.fw.comm.asi.hmisync.sound.ASIHMISyncSoundReply;
import de.esolutions.fw.comm.asi.hmisync.sound.impl.ASIHMISyncSoundAbstractBaseService;
import de.esolutions.fw.comm.core.method.MethodException;
import de.vw.mib.asi.ASIException;
import de.vw.mib.asi.ASIProperties;
import de.vw.mib.asi.sound.ASISound;
import de.vw.mib.asi.sound.impl.ASISoundBaseServiceImpl$ListenerProxy;
import de.vw.mib.asi.sound.impl.ASISoundBaseServiceImpl$ResponseProxy;
import de.vw.mib.log4mib.ClassifiedLogger;
import java.util.HashSet;
import java.util.Set;

public class ASISoundBaseServiceImpl
extends ASIHMISyncSoundAbstractBaseService {
    private static final int ATTR_COUNT;
    private final ClassifiedLogger clogger;
    private final Set[] attrListeners = new Set[18];
    private final ASISoundBaseServiceImpl$ListenerProxy listener = new ASISoundBaseServiceImpl$ListenerProxy(this);
    private final ASISound service;
    private final ASIProperties props;

    public ASISoundBaseServiceImpl(ASISound aSISound, ASIProperties aSIProperties, ClassifiedLogger classifiedLogger) {
        this.service = aSISound;
        this.props = aSIProperties;
        this.clogger = classifiedLogger;
    }

    public void init() {
        this.initBaseAttributes();
        this.service.setASISoundListener(this.listener);
    }

    private void initBaseAttributes() {
        try {
            this.updateASIVersion("1.0.00");
            this.updateRequestIDs(ASIHMISyncSound$RequestIDs.getIDs());
            this.updateReplyIDs(ASIHMISyncSound$ReplyIDs.getIDs());
        }
        catch (MethodException methodException) {
            this.clogger.error().append("ASISound: Could not initialize base attributes.").attachThrowable(methodException).log();
        }
    }

    private static int getMappedId(long l) {
        int n;
        switch ((int)l) {
            case 15: {
                n = 0;
                break;
            }
            case 16: {
                n = 1;
                break;
            }
            case 17: {
                n = 2;
                break;
            }
            case 18: {
                n = 3;
                break;
            }
            case 19: {
                n = 4;
                break;
            }
            case 20: {
                n = 5;
                break;
            }
            case 21: {
                n = 6;
                break;
            }
            case 22: {
                n = 7;
                break;
            }
            case 23: {
                n = 8;
                break;
            }
            case 24: {
                n = 9;
                break;
            }
            case 25: {
                n = 10;
                break;
            }
            case 28: {
                n = 11;
                break;
            }
            case 29: {
                n = 12;
                break;
            }
            case 30: {
                n = 13;
                break;
            }
            case 31: {
                n = 14;
                break;
            }
            case 32: {
                n = 15;
                break;
            }
            case 33: {
                n = 16;
                break;
            }
            case 34: {
                n = 17;
                break;
            }
            default: {
                n = -1;
            }
        }
        return n;
    }

    @Override
    public synchronized void setNotification(long l, ASIHMISyncSoundReply aSIHMISyncSoundReply) {
        super.setNotification(l, aSIHMISyncSoundReply);
        int n = ASISoundBaseServiceImpl.getMappedId(l);
        if (0 <= n) {
            this.addListener(n, aSIHMISyncSoundReply);
        }
    }

    @Override
    public synchronized void setNotification(ASIHMISyncSoundReply aSIHMISyncSoundReply) {
        super.setNotification(aSIHMISyncSoundReply);
        for (int i2 = 0; i2 < 18; ++i2) {
            this.addListener(i2, aSIHMISyncSoundReply);
        }
    }

    @Override
    public synchronized void setNotification(long[] lArray, ASIHMISyncSoundReply aSIHMISyncSoundReply) {
        super.setNotification(lArray, aSIHMISyncSoundReply);
        for (int i2 = 0; i2 < lArray.length; ++i2) {
            int n = ASISoundBaseServiceImpl.getMappedId(lArray[i2]);
            if (0 > n) continue;
            this.addListener(n, aSIHMISyncSoundReply);
        }
    }

    private void addListener(int n, ASIHMISyncSoundReply aSIHMISyncSoundReply) {
        Set set = this.attrListeners[n];
        if (null == set) {
            this.attrListeners[n] = set = new HashSet();
        }
        boolean bl = set.isEmpty();
        set.add(aSIHMISyncSoundReply);
        if (bl) {
            this.props.setNotification(n);
        }
    }

    @Override
    public synchronized void clearNotification(long l, ASIHMISyncSoundReply aSIHMISyncSoundReply) {
        super.clearNotification(l, aSIHMISyncSoundReply);
        int n = ASISoundBaseServiceImpl.getMappedId(l);
        if (0 <= n) {
            this.removeListener(n, aSIHMISyncSoundReply);
        }
    }

    @Override
    public synchronized void clearNotification(ASIHMISyncSoundReply aSIHMISyncSoundReply) {
        super.clearNotification(aSIHMISyncSoundReply);
        for (int i2 = 0; i2 < 18; ++i2) {
            this.removeListener(i2, aSIHMISyncSoundReply);
        }
    }

    @Override
    public synchronized void clearNotification(long[] lArray, ASIHMISyncSoundReply aSIHMISyncSoundReply) {
        super.clearNotification(lArray, aSIHMISyncSoundReply);
        for (int i2 = 0; i2 < lArray.length; ++i2) {
            int n = ASISoundBaseServiceImpl.getMappedId(lArray[i2]);
            if (0 > n) continue;
            this.removeListener(n, aSIHMISyncSoundReply);
        }
    }

    private void removeListener(int n, ASIHMISyncSoundReply aSIHMISyncSoundReply) {
        boolean bl;
        Set set = this.attrListeners[n];
        boolean bl2 = bl = null != set && set.remove(aSIHMISyncSoundReply) && set.isEmpty();
        if (bl) {
            this.props.clearNotification(n);
        }
    }

    @Override
    public void setBassValue(int n, ASIHMISyncSoundReply aSIHMISyncSoundReply) {
        try {
            this.service.setBassValue(n, ASISoundBaseServiceImpl$ResponseProxy.get(aSIHMISyncSoundReply));
        }
        catch (ASIException aSIException) {
            throw new MethodException(aSIException.toString());
        }
    }

    @Override
    public void setTrebleValue(int n, ASIHMISyncSoundReply aSIHMISyncSoundReply) {
        try {
            this.service.setTrebleValue(n, ASISoundBaseServiceImpl$ResponseProxy.get(aSIHMISyncSoundReply));
        }
        catch (ASIException aSIException) {
            throw new MethodException(aSIException.toString());
        }
    }

    @Override
    public void setBalanceValue(int n, ASIHMISyncSoundReply aSIHMISyncSoundReply) {
        try {
            this.service.setBalanceValue(n, ASISoundBaseServiceImpl$ResponseProxy.get(aSIHMISyncSoundReply));
        }
        catch (ASIException aSIException) {
            throw new MethodException(aSIException.toString());
        }
    }

    @Override
    public void setFaderValue(int n, ASIHMISyncSoundReply aSIHMISyncSoundReply) {
        try {
            this.service.setFaderValue(n, ASISoundBaseServiceImpl$ResponseProxy.get(aSIHMISyncSoundReply));
        }
        catch (ASIException aSIException) {
            throw new MethodException(aSIException.toString());
        }
    }

    @Override
    public void setSubwooferValue(int n, ASIHMISyncSoundReply aSIHMISyncSoundReply) {
        try {
            this.service.setSubwooferValue(n, ASISoundBaseServiceImpl$ResponseProxy.get(aSIHMISyncSoundReply));
        }
        catch (ASIException aSIException) {
            throw new MethodException(aSIException.toString());
        }
    }

    @Override
    public void setSurroundValue(int n, ASIHMISyncSoundReply aSIHMISyncSoundReply) {
        try {
            this.service.setSurroundValue(n, ASISoundBaseServiceImpl$ResponseProxy.get(aSIHMISyncSoundReply));
        }
        catch (ASIException aSIException) {
            throw new MethodException(aSIException.toString());
        }
    }

    @Override
    public void setNoiseCompensationValue(int n, ASIHMISyncSoundReply aSIHMISyncSoundReply) {
        try {
            this.service.setNoiseCompensationValue(n, ASISoundBaseServiceImpl$ResponseProxy.get(aSIHMISyncSoundReply));
        }
        catch (ASIException aSIException) {
            throw new MethodException(aSIException.toString());
        }
    }

    @Override
    public void setPresetPosition(int n, ASIHMISyncSoundReply aSIHMISyncSoundReply) {
        try {
            this.service.setPresetPosition(n, ASISoundBaseServiceImpl$ResponseProxy.get(aSIHMISyncSoundReply));
        }
        catch (ASIException aSIException) {
            throw new MethodException(aSIException.toString());
        }
    }
}

