/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.radio.sdars.helper;

import de.vw.mib.asl.api.travellink.ASLTravelLinkAPI;
import de.vw.mib.asl.api.travellink.ASLTravelLinkFactory;
import de.vw.mib.asl.framework.api.framework.ASLFrameworkFactory;
import de.vw.mib.asl.internal.radio.api.impl.speech.AslRadioSiriusFacadeImpl;
import de.vw.mib.asl.internal.radio.api.impl.speech.SiriusSubscriptionStateImpl;
import de.vw.mib.asl.internal.radio.sdars.database.IAslPool;
import de.vw.mib.asl.internal.radio.sdars.database.IAslPoolListener;
import de.vw.mib.asl.internal.radio.sdars.database.IAslPoolRecord;
import de.vw.mib.asl.internal.radio.sdars.dsi.SatTunerListener;
import de.vw.mib.asl.internal.radio.sdars.helper.AudioManager;
import de.vw.mib.asl.internal.radio.sdars.helper.SatDb;
import de.vw.mib.asl.internal.radio.sdars.main.SatMainTarget;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.log4mib.LogMessage;

public final class StatusHandler
implements IAslPoolListener {
    private boolean mTimerNoSignalNoArtistRuns = false;
    private final SatDb mDb;
    private final IAslPool mPool;
    private static boolean isTrafficSubcriptionSent = false;
    private final ASLTravelLinkAPI aslTravelLinkAP;
    public static int lastTrafficSubscriptionStatus = -1;
    public static final int TIMEOUT_MUTE;
    private static boolean isSdarsSpeechServiceRegistered;
    static /* synthetic */ Class class$de$vw$mib$asl$api$radio$speech$sirius$AslRadioSiriusFacade;
    static /* synthetic */ Class class$de$vw$mib$asl$api$radio$sdars$SiriusSubscriptionState;

    public StatusHandler(SatDb satDb) {
        this.mDb = satDb;
        this.mPool = this.mDb.getPool();
        this.aslTravelLinkAP = ASLTravelLinkFactory.getTravelLinkApi();
        this.mPool.addListener(1, (IAslPoolListener)this);
        this.mPool.addListener(3, (IAslPoolListener)this);
        this.mPool.addListener(4, (IAslPoolListener)this);
        this.mPool.addListener(5, (IAslPoolListener)this);
        this.mPool.addListener(6, (IAslPoolListener)this);
        this.mPool.addListener(19, (IAslPoolListener)this);
        this.mPool.addListener(15, (IAslPoolListener)this);
        this.mPool.addListener(208, (IAslPoolListener)this);
        this.mPool.addListener(212, (IAslPoolListener)this);
    }

    public void startTimerNoSignalNoArtist() {
        SatMainTarget satMainTarget = this.mDb.getMainTarget();
        if (!this.mTimerNoSignalNoArtistRuns) {
            this.mTimerNoSignalNoArtistRuns = true;
            int n = this.mPool.getInt(59);
            satMainTarget.startTimer(-1501167360, (long)n, false);
        } else {
            satMainTarget.retriggerTimer(-1501167360);
        }
    }

    private void stopTimerNoSignalNoArtist() {
        if (this.mTimerNoSignalNoArtistRuns) {
            this.mTimerNoSignalNoArtistRuns = false;
            this.mDb.getMainTarget().stopTimer(-1501167360);
        }
        this.mPool.setBoolean(50, false);
    }

    public void notifyTimerNoSignalNoArtistArrived() {
        this.mTimerNoSignalNoArtistRuns = false;
        int n = this.mPool.getInt(1);
        if (n == 1) {
            this.mPool.setBoolean(50, true);
        }
    }

    public void notifyTimerNoAudioArrived() {
        if (SatTunerListener.isMuteTimerOn) {
            SatTunerListener.isMuteTimerOn = false;
            this.mPool.setInt(1, 1);
        }
    }

    public void updateTunerState() {
        LogMessage logMessage;
        int n;
        AudioManager audioManager = this.mDb.getAudioManager();
        boolean bl = this.mPool.getBoolean(5, true);
        int n2 = this.mPool.getInt(4);
        if (n2 != 3 && !bl) {
            this.mPool.setInt(147, 0);
            audioManager.setMuted(true);
            int n3 = 0;
            this.aslTravelLinkAP.updateSdarsTunerState(n3);
            this.mPool.setInt(208, 0);
            LogMessage logMessage2 = this.mDb.getLogHandler().getLogMsg();
            if (logMessage2 != null) {
                logMessage2.append("##-> Tuner is Not functional").log();
            }
            return;
        }
        if (n2 == 3 && !bl) {
            this.mPool.setInt(147, 2);
            this.startTimerNoSignalNoArtist();
            int n4 = 2;
            this.aslTravelLinkAP.updateSdarsTunerState(n4);
            this.mPool.setInt(208, 0);
            LogMessage logMessage3 = this.mDb.getLogHandler().getLogMsg();
            if (logMessage3 != null) {
                logMessage3.append("##-> Tuner is Initializing").log();
            }
            return;
        }
        int n5 = this.mPool.getInt(3);
        if (n5 == 1) {
            this.mPool.setInt(147, 3);
            this.startTimerNoSignalNoArtist();
            audioManager.setMuted(true);
            int n6 = 3;
            this.aslTravelLinkAP.updateSdarsTunerState(n6);
            return;
        }
        if (!SatTunerListener.isMuteTimerOn && (n = this.mPool.getInt(1)) == 1) {
            this.mPool.setInt(147, 4);
            this.startTimerNoSignalNoArtist();
            audioManager.setMuted(true);
            int n7 = 4;
            this.aslTravelLinkAP.updateSdarsTunerState(n7);
            return;
        }
        this.stopTimerNoSignalNoArtist();
        audioManager.setMuted(false);
        this.mPool.setInt(147, 1);
        this.mPool.incInt(80);
        n = 1;
        this.aslTravelLinkAP.updateSdarsTunerState(n);
        if (!isTrafficSubcriptionSent) {
            this.mPool.setInt(208, 0);
            logMessage = this.mDb.getLogHandler().getLogMsg();
            if (logMessage != null) {
                logMessage.append("##-> Tuner is fully functional").log();
            }
        }
        if (lastTrafficSubscriptionStatus != -1) {
            this.mPool.setInt(208, lastTrafficSubscriptionStatus);
            logMessage = this.mDb.getLogHandler().getLogMsg();
            if (logMessage != null) {
                logMessage.append("##-> Last traffic subscription is set: (Subscribed=2, Unsubscribed=1)").append(lastTrafficSubscriptionStatus).log();
            }
        }
        if (!isSdarsSpeechServiceRegistered) {
            isSdarsSpeechServiceRegistered = true;
            ASLFrameworkFactory.getASLFrameworkAPI().getServices().getASLComponentRegistry().registerAPI(class$de$vw$mib$asl$api$radio$speech$sirius$AslRadioSiriusFacade == null ? (class$de$vw$mib$asl$api$radio$speech$sirius$AslRadioSiriusFacade = StatusHandler.class$("de.vw.mib.asl.api.radio.speech.sirius.AslRadioSiriusFacade")) : class$de$vw$mib$asl$api$radio$speech$sirius$AslRadioSiriusFacade, new AslRadioSiriusFacadeImpl());
            ASLFrameworkFactory.getASLFrameworkAPI().getServices().getASLComponentRegistry().registerAPI(class$de$vw$mib$asl$api$radio$sdars$SiriusSubscriptionState == null ? (class$de$vw$mib$asl$api$radio$sdars$SiriusSubscriptionState = StatusHandler.class$("de.vw.mib.asl.api.radio.sdars.SiriusSubscriptionState")) : class$de$vw$mib$asl$api$radio$sdars$SiriusSubscriptionState, new SiriusSubscriptionStateImpl());
        }
    }

    private void trafficStatusUpdateToNavi() {
        int n = this.mPool.getInt(208);
        EventGeneric eventGeneric = this.mDb.newEvent();
        if (n == 2) {
            eventGeneric.setInt(0, 2);
            isTrafficSubcriptionSent = true;
        } else if (n == 1) {
            eventGeneric.setInt(0, 3);
            isTrafficSubcriptionSent = true;
        } else {
            eventGeneric.setInt(0, 4);
        }
        this.mDb.getMainTarget().triggerObserver(-711065600, eventGeneric);
        LogMessage logMessage = this.mDb.getLogHandler().getLogMsg();
        if (logMessage != null) {
            logMessage.append("##-> Traffic Subscription Status to Navi (Subscribed=2, Unsubscribed=1, NotAvailable=0): ").append(n).log();
        }
    }

    @Override
    public void notifyUpdate(IAslPool iAslPool, int n, IAslPoolRecord iAslPoolRecord) {
        switch (n) {
            case 1: 
            case 3: 
            case 4: 
            case 5: {
                this.updateTunerState();
                break;
            }
            case 208: {
                this.trafficStatusUpdateToNavi();
                break;
            }
            case 19: {
                this.mPool.setBoolean(50, false);
                break;
            }
            case 15: {
                if (!this.mPool.getBoolean(61)) break;
                this.startTimerNoSignalNoArtist();
                break;
            }
            case 212: {
                boolean bl = iAslPoolRecord.getBoolean();
                SatMainTarget satMainTarget = this.mDb.getMainTarget();
                if (bl) {
                    satMainTarget.startTimer(-1215954688, (long)0, false);
                    break;
                }
                satMainTarget.stopTimer(-1215954688);
                break;
            }
        }
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }

    static {
        isSdarsSpeechServiceRegistered = false;
    }
}

