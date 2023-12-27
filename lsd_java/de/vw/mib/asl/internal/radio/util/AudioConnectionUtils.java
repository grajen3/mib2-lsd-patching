/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.radio.util;

import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.radio.RadioCodingAdapter;
import de.vw.mib.asl.internal.radio.RadioUtil;
import de.vw.mib.asl.internal.radio.manager.ManagerTarget;
import de.vw.mib.genericevents.AbstractTarget;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.log4mib.Logger;

public final class AudioConnectionUtils {
    private static Logger logger = ServiceManager.logger;
    public static int mLastRequestedConnection;
    public static boolean muteReqByASL;
    private static boolean mDabLocked;

    private AudioConnectionUtils() {
    }

    public static void requestAnnouncementAudioConnection(int n, AbstractTarget abstractTarget, int n2, int n3, int n4) {
        mLastRequestedConnection = n;
        EventGeneric eventGeneric = ServiceManager.mGenericEventFactory.newEvent(34159872);
        eventGeneric.setSenderTargetId(abstractTarget.getTargetId());
        eventGeneric.setSenderEventId(n2);
        eventGeneric.setInt(0, n);
        eventGeneric.setInt(n3, n4);
        abstractTarget.sendSafe(eventGeneric);
    }

    public static void requestAudioConnection(int n, AbstractTarget abstractTarget, int n2) {
        if (logger.isTraceEnabled(128)) {
            logger.trace(128).append(RadioUtil.LOG_PREFIX_AMFM_TUNER).append("requesting audio connection Japan TI: ").append("  with connection id: ").append(n).log();
        }
        EventGeneric eventGeneric = ServiceManager.mGenericEventFactory.newEvent(34159872);
        eventGeneric.setInt(0, n);
        eventGeneric.setBoolean(1, true);
        eventGeneric.setBoolean(2, true);
        eventGeneric.setSenderEventId(n2);
        abstractTarget.sendSafe(eventGeneric);
    }

    public static void requestFadeIn(int n, AbstractTarget abstractTarget, int n2) {
        if (logger.isTraceEnabled(128)) {
            logger.trace(128).append(RadioUtil.LOG_PREFIX_AMFM_TUNER).append("requesting fade to audio connection for Japan TI: ").append("  with connection id: ").append(n).log();
        }
        EventGeneric eventGeneric = ServiceManager.mGenericEventFactory.newEvent(50937088);
        eventGeneric.setInt(0, n);
        eventGeneric.setSenderEventId(n2);
        abstractTarget.sendSafe(eventGeneric);
    }

    public static void requestVolumeLockForDabAnnouncementWithConnection(boolean bl, boolean bl2, boolean bl3, boolean bl4, AbstractTarget abstractTarget) {
        EventGeneric eventGeneric = null;
        if (!mDabLocked && bl4) {
            if (bl) {
                eventGeneric = ServiceManager.mGenericEventFactory.newEvent(185154816);
                eventGeneric.setInt(0, 34);
                abstractTarget.sendSafe(eventGeneric);
                mDabLocked = true;
            }
            if (bl2) {
                eventGeneric = ServiceManager.mGenericEventFactory.newEvent(185154816);
                eventGeneric.setInt(0, 32);
                abstractTarget.sendSafe(eventGeneric);
                mDabLocked = true;
            }
            if (bl3) {
                eventGeneric = ServiceManager.mGenericEventFactory.newEvent(185154816);
                eventGeneric.setInt(0, 35);
                abstractTarget.sendSafe(eventGeneric);
                mDabLocked = true;
            }
        } else if (mDabLocked && !bl4) {
            if (bl) {
                eventGeneric = ServiceManager.mGenericEventFactory.newEvent(201932032);
                eventGeneric.setInt(0, 34);
                abstractTarget.sendSafe(eventGeneric);
            }
            if (bl2) {
                eventGeneric = ServiceManager.mGenericEventFactory.newEvent(201932032);
                eventGeneric.setInt(0, 32);
                abstractTarget.sendSafe(eventGeneric);
            }
            if (bl3) {
                eventGeneric = ServiceManager.mGenericEventFactory.newEvent(201932032);
                eventGeneric.setInt(0, 35);
                abstractTarget.sendSafe(eventGeneric);
            }
            mDabLocked = false;
        }
    }

    public static void releaseLastAnnouncementAudioConnection(AbstractTarget abstractTarget) {
        if (mLastRequestedConnection != 0) {
            EventGeneric eventGeneric = ServiceManager.mGenericEventFactory.newEvent(67714304);
            eventGeneric.setInt(0, mLastRequestedConnection);
            abstractTarget.sendSafe(eventGeneric);
        }
    }

    public static void requestAudioConnectionForBand(int n, AbstractTarget abstractTarget, int n2) {
        int n3 = AudioConnectionUtils.getCorrespondingAudioConnection(n);
        if (logger.isTraceEnabled(128)) {
            logger.trace(128).append(RadioUtil.LOG_PREFIX_AMFM_TUNER).append("requesting audio connection for band: ").append(n).append("  with connection id: ").append(n3).log();
        }
        if (logger.isTraceEnabled(4)) {
            logger.trace(4).append(RadioUtil.LOG_PREFIX_AMFM_TUNER).append("requesting audio connection for band: ").append(n).append("  with connection id: ").append(n3).log();
        }
        EventGeneric eventGeneric = ServiceManager.mGenericEventFactory.newEvent(34159872);
        eventGeneric.setInt(0, n3);
        boolean bl = n == 0 || n == 1 || n == 2;
        eventGeneric.setBoolean(1, bl);
        eventGeneric.setBoolean(2, true);
        eventGeneric.setSenderEventId(n2);
        abstractTarget.sendSafe(eventGeneric);
    }

    public static void requestAudioConnectionSupression(AbstractTarget abstractTarget) {
        EventGeneric eventGeneric = ServiceManager.mGenericEventFactory.newEvent(34159872);
        eventGeneric.setInt(0, 9);
        abstractTarget.sendSafe(eventGeneric);
    }

    public static int getCorrespondingAudioConnection(int n) {
        int n2;
        switch (n) {
            case 0: {
                n2 = AudioConnectionUtils.getConnectionForHdRadioOrAmFm(0);
                break;
            }
            case 1: {
                n2 = AudioConnectionUtils.getConnectionForHdRadioOrAmFm(1);
                break;
            }
            case 2: {
                n2 = 26;
                break;
            }
            case 3: {
                n2 = 28;
                break;
            }
            default: {
                n2 = 0;
            }
        }
        return n2;
    }

    public static void requestMuteAndVolumeLockForBand(boolean bl, AbstractTarget abstractTarget, int n) {
        EventGeneric eventGeneric;
        if (bl) {
            eventGeneric = ServiceManager.mGenericEventFactory.newEvent(185154816);
            eventGeneric.setInt(0, AudioConnectionUtils.getConnectionForHdRadioOrAmFm(n));
            if (!ManagerTarget.mIsMuteActive) {
                EventGeneric eventGeneric2 = ServiceManager.mGenericEventFactory.newEvent(34159872);
                eventGeneric2.setInt(0, 8);
                muteReqByASL = true;
                abstractTarget.sendSafe(eventGeneric2);
            }
        } else {
            eventGeneric = ServiceManager.mGenericEventFactory.newEvent(201932032);
            eventGeneric.setInt(0, AudioConnectionUtils.getConnectionForHdRadioOrAmFm(n));
            if (muteReqByASL) {
                muteReqByASL = false;
                EventGeneric eventGeneric3 = ServiceManager.mGenericEventFactory.newEvent(67714304);
                eventGeneric3.setInt(0, 8);
                abstractTarget.sendSafe(eventGeneric3);
            }
        }
        abstractTarget.sendSafe(eventGeneric);
    }

    public static void requestMuteAndVolumeLockForRadio(boolean bl, AbstractTarget abstractTarget) {
        EventGeneric eventGeneric;
        EventGeneric eventGeneric2;
        EventGeneric eventGeneric3 = null;
        if (bl) {
            if (!RadioCodingAdapter.isAmDisabled()) {
                eventGeneric3 = ServiceManager.mGenericEventFactory.newEvent(185154816);
                eventGeneric3.setInt(0, 13);
            }
            eventGeneric2 = ServiceManager.mGenericEventFactory.newEvent(185154816);
            eventGeneric2.setInt(0, 12);
            eventGeneric = ServiceManager.mGenericEventFactory.newEvent(185154816);
            eventGeneric.setInt(0, 26);
            if (!ManagerTarget.mIsMuteActive) {
                EventGeneric eventGeneric4 = ServiceManager.mGenericEventFactory.newEvent(34159872);
                eventGeneric4.setInt(0, 8);
                muteReqByASL = true;
                abstractTarget.sendSafe(eventGeneric4);
            }
        } else {
            if (!RadioCodingAdapter.isAmDisabled()) {
                eventGeneric3 = ServiceManager.mGenericEventFactory.newEvent(201932032);
                eventGeneric3.setInt(0, 13);
            }
            eventGeneric2 = ServiceManager.mGenericEventFactory.newEvent(201932032);
            eventGeneric2.setInt(0, 12);
            eventGeneric = ServiceManager.mGenericEventFactory.newEvent(201932032);
            eventGeneric.setInt(0, 26);
            if (muteReqByASL) {
                muteReqByASL = false;
                EventGeneric eventGeneric5 = ServiceManager.mGenericEventFactory.newEvent(67714304);
                eventGeneric5.setInt(0, 8);
                abstractTarget.sendSafe(eventGeneric5);
            }
        }
        if (!RadioCodingAdapter.isAmDisabled()) {
            abstractTarget.sendSafe(eventGeneric3);
        }
        abstractTarget.sendSafe(eventGeneric2);
        abstractTarget.sendSafe(eventGeneric);
    }

    public static void requestVolumeLock(int n, boolean bl, AbstractTarget abstractTarget) {
        EventGeneric eventGeneric;
        if (bl) {
            eventGeneric = ServiceManager.mGenericEventFactory.newEvent(185154816);
            eventGeneric.setInt(0, AudioConnectionUtils.getConnectionForHdRadioOrAmFm(n));
        } else {
            eventGeneric = ServiceManager.mGenericEventFactory.newEvent(201932032);
            eventGeneric.setInt(0, AudioConnectionUtils.getConnectionForHdRadioOrAmFm(n));
        }
        abstractTarget.sendSafe(eventGeneric);
    }

    public static void requestFadeInForBand(int n, AbstractTarget abstractTarget, int n2) {
        int n3 = AudioConnectionUtils.getCorrespondingAudioConnection(n);
        if (logger.isTraceEnabled(128)) {
            logger.trace(128).append(RadioUtil.LOG_PREFIX_AMFM_TUNER).append("requesting fade to audio connection for band: ").append(n).append("  with connection id: ").append(n3).log();
        }
        EventGeneric eventGeneric = ServiceManager.mGenericEventFactory.newEvent(50937088);
        eventGeneric.setInt(0, n3);
        eventGeneric.setSenderEventId(n2);
        abstractTarget.sendSafe(eventGeneric);
    }

    private static int getConnectionForHdRadioOrAmFm(int n) {
        if (n == 0) {
            return 13;
        }
        return 12;
    }

    static {
        muteReqByASL = false;
        mDabLocked = false;
    }
}

