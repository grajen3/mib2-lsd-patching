/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.testmode;

import de.vw.mib.asl.api.speechengine.SpeechEngine;
import de.vw.mib.asl.api.speechengine.audio.AudioAccessor;
import de.vw.mib.asl.framework.api.framework.ASLFrameworkFactory;
import de.vw.mib.asl.framework.api.lsc.ASLLscFactory;
import de.vw.mib.asl.framework.api.persistence.IPersistableEarlyData;
import de.vw.mib.asl.framework.api.startupv7r.ASLStartupv7rFactory;
import de.vw.mib.asl.framework.internal.framework.AbstractASLTarget;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.testmode.HsmTestmode;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.GenericEventException;
import de.vw.mib.genericevents.ServiceRegister;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

public class TargetGEM
extends AbstractASLTarget {
    private static final String LOGGING_DELIM;
    private final IPersistableEarlyData persistableEarlyData = ASLStartupv7rFactory.getStartupv7rApi().getPersistableEarlyData();
    static final int ACTIVATED;
    static final int DEACTIVATED;
    private boolean sdsEnableVoiceBargeIn = true;
    private boolean sdsEnablePttBargeIn = true;
    private boolean sdsHmiTtsChannel = false;
    private boolean mAuthProcedureBlocking = true;
    private boolean tvEnableTunerTestmode = false;
    private String carEcoDrivingState;
    private int carEcoVehAcc;
    private int carEcoBpAvgShort;
    private AudioAccessor audioAccessor;
    private static TargetGEM instance;
    static /* synthetic */ Class class$de$vw$mib$asl$api$speechengine$SpeechEngine;

    public TargetGEM(HsmTestmode hsmTestmode) {
        super(hsmTestmode.getMainObject(), -221178624);
    }

    @Override
    public int getSubClassifier() {
        return 64;
    }

    static TargetGEM getInstance() {
        return instance;
    }

    public static void enableTarget(HsmTestmode hsmTestmode) {
        if (instance == null) {
            try {
                instance = new TargetGEM(hsmTestmode);
            }
            catch (Exception exception) {
                hsmTestmode.error(exception);
            }
            instance.registerTarget();
        }
    }

    private void registerTarget() {
        try {
            this.register(this.getMainObject(), this.getTargetId(), this.getEventDispatcher().getRandomTaskId());
            ServiceRegister serviceRegister = this.getServiceRegister();
            if (serviceRegister.existService(738926592)) {
                this.addObserver(738926592);
            } else {
                serviceRegister.addServiceMonitor(738926592, 0, this.getTargetId());
            }
            this.triggerObserver(-39714816, null);
        }
        catch (Exception exception) {
            this.error().append("TargetGEM could not be registered ").append(exception).log();
        }
        if (this.isTraceEnabled()) {
            this.trace("TargetGEM registered", this.getTargetId());
        }
    }

    void triggerExit() {
        if (this.sdsHmiTtsChannel) {
            this.sdsHmiTtsChannel = false;
            this.setSdsHmiTtsChannel(0);
        }
    }

    @Override
    public void gotEvent(EventGeneric eventGeneric) {
        switch (eventGeneric.getReceiverEventId()) {
            case 12: {
                this.getServiceRegister().removeServiceMonitor(738926592, 0, this.getTargetId());
                this.addObserver(738926592);
                break;
            }
            case 2100012: {
                this.carEcoDrivingState = eventGeneric.getString(0);
                this.carEcoBpAvgShort = eventGeneric.getInt(1);
                this.carEcoVehAcc = eventGeneric.getInt(2);
                break;
            }
        }
    }

    String getHmiLanguage() {
        return ASLLscFactory.getLscApi().getPersistantLanguage();
    }

    int getSdsHmiTtsChannel() {
        return this.sdsHmiTtsChannel ? 1 : 0;
    }

    void setSdsHmiTtsChannel(int n) {
        this.sdsHmiTtsChannel = n == 1;
        this.audioAccessor = this.retrieveAudioAccessor();
        if (this.audioAccessor != null) {
            if (this.sdsHmiTtsChannel) {
                this.audioAccessor.requestSpeechOutputConnection();
            } else {
                this.audioAccessor.releaseSpeechOutputConnection();
            }
        }
        this.error("Cannot update SDS HMI TTS Channel since the AudioAccessor is not available");
    }

    int getSdsEnableVoiceBargeIn() {
        return this.sdsEnableVoiceBargeIn ? 1 : 0;
    }

    void setSdsEnableVoiceBargeIn(boolean bl) {
        if (this.sdsEnableVoiceBargeIn != bl) {
            this.sdsEnableVoiceBargeIn = bl;
            if (this.isTraceEnabled()) {
                this.trace().append("[TargetGEM] ").append("setSdsEnableVoiceBargeIn: ").append(bl).log();
            }
        }
    }

    int getSdsEnablePttBargeIn() {
        return this.sdsEnablePttBargeIn ? 1 : 0;
    }

    void setSdsEnablePttBargeIn(boolean bl) {
        if (this.sdsEnablePttBargeIn != bl) {
            this.sdsEnablePttBargeIn = bl;
            if (this.isTraceEnabled()) {
                this.trace().append("[TargetGEM] ").append("setSdsEnablePttBargeIn: ").append(bl).log();
            }
        }
    }

    void setBtAuthActivate(boolean bl) {
        if (bl != this.mAuthProcedureBlocking) {
            this.mAuthProcedureBlocking = bl;
            EventGeneric eventGeneric = ServiceManager.mGenericEventFactory.newEvent();
            eventGeneric.setReceiverTargetId(5610);
            eventGeneric.setReceiverEventId(261964032);
            eventGeneric.setBoolean(0, bl);
            if (this.isTraceEnabled()) {
                this.trace().append("[TargetGEM] ").append("setBtAuthActivate: ").append(bl).log();
            }
            try {
                ServiceManager.eventMain.getEventDispatcher().send(eventGeneric);
            }
            catch (GenericEventException genericEventException) {
                // empty catch block
            }
        }
    }

    int getBtAuthActivate() {
        return this.mAuthProcedureBlocking ? 1 : 0;
    }

    int getTvEnableTunerTestmode() {
        return this.tvEnableTunerTestmode ? 1 : 0;
    }

    void setTvEnableTunerTestmode(boolean bl) {
        if (bl != this.tvEnableTunerTestmode) {
            this.tvEnableTunerTestmode = bl;
            EventGeneric eventGeneric = ServiceManager.mGenericEventFactory.newEvent();
            eventGeneric.setBoolean(0, bl);
            this.triggerObserver(-1398603776, eventGeneric);
        }
    }

    int getNavOverwriteEnableOnlineFeatures() {
        return this.persistableEarlyData.getNavOverwriteEnableOnlineFunctions() ? 1 : 0;
    }

    void toggleNavOverwriteEnableOnlineFeatures() {
        boolean bl = !this.persistableEarlyData.getNavOverwriteEnableOnlineFunctions();
        this.info().append("[TargetGEM] ").append("toggleNavOverwriteEnableOnlineFeatures to ").append(bl).log();
        this.persistableEarlyData.setNavOverwriteEnableOnlineFunctions(bl);
    }

    String getCarEcoCurrentDrivingState() {
        return this.carEcoDrivingState;
    }

    int getCarEcoAvgShort() {
        return this.carEcoBpAvgShort;
    }

    int getCarEcoVehlCrtAccel() {
        return this.carEcoVehAcc;
    }

    private AudioAccessor retrieveAudioAccessor() {
        if (this.audioAccessor == null) {
            SpeechEngine speechEngine = null;
            BundleContext bundleContext = ASLFrameworkFactory.getASLFrameworkAPI().getServices().getBundleContext();
            ServiceReference serviceReference = bundleContext.getServiceReference((class$de$vw$mib$asl$api$speechengine$SpeechEngine == null ? (class$de$vw$mib$asl$api$speechengine$SpeechEngine = TargetGEM.class$("de.vw.mib.asl.api.speechengine.SpeechEngine")) : class$de$vw$mib$asl$api$speechengine$SpeechEngine).getName());
            if (serviceReference != null) {
                speechEngine = (SpeechEngine)bundleContext.getService(serviceReference);
            }
            if (speechEngine != null) {
                this.audioAccessor = speechEngine.getAudioAccessor(18);
            }
        }
        return this.audioAccessor;
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
        instance = null;
    }
}

