/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechengine.config.lsc;

import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.speechengine.config.lsc.SpeechLACHandler$LACCallback;
import de.vw.mib.asl.internal.speechengine.config.lsc.VoiceServiceInternal;
import de.vw.mib.asl.internal.speechengine.config.start.SpeechConfiguratorParameters;
import de.vw.mib.asl.internal.util.AbstractClassifiedLogger;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.GenericEvents;
import de.vw.mib.genericevents.Target;
import de.vw.mib.log4mib.LogMessage;

public abstract class SpeechLACHandler
implements Target {
    public static final String EMPTY_STRING;
    protected final AbstractClassifiedLogger logger;
    private final int targetId;
    private final int lscListenerType;
    protected final String targetName;
    protected final SpeechConfiguratorParameters paras;
    protected final VoiceServiceInternal voiceServiceInternal;
    protected String currentLanguage = "NO_LANGUAGE";

    public SpeechLACHandler(VoiceServiceInternal voiceServiceInternal, SpeechConfiguratorParameters speechConfiguratorParameters, int n, int n2, String string) {
        this.voiceServiceInternal = voiceServiceInternal;
        this.paras = speechConfiguratorParameters;
        this.logger = speechConfiguratorParameters.getClassifiedLogger();
        this.targetId = n;
        this.lscListenerType = n2;
        this.targetName = string;
    }

    @Override
    public void gotEvent(EventGeneric eventGeneric) {
        int n = eventGeneric.getReceiverEventId();
        switch (n) {
            case 40003: {
                this.gotEventLSCChangeLanguage(eventGeneric);
                break;
            }
            default: {
                LogMessage logMessage = this.getTraceLogMessage();
                logMessage.append("SpeechLACHandler handleEvent default:");
                logMessage.append(n);
                logMessage.log();
            }
        }
    }

    private void gotEventLSCChangeLanguage(EventGeneric eventGeneric) {
        int n = eventGeneric.getInt(0);
        String string = eventGeneric.getString(1);
        if (this.isSwitchOff(string)) {
            this.handleSwitchOff(n, string);
        } else if (this.isLanguageAvailable(string)) {
            this.handleLanguageAvailable(string, n);
        } else {
            this.handleLanguageNotAvailable(n);
        }
    }

    private boolean isSwitchOff(String string) {
        return string.equals("NO_LANGUAGE");
    }

    private void handleSwitchOff(int n, String string) {
        LogMessage logMessage = this.getInfoLogMessage();
        logMessage.append("SpeechLACHandler was switch off from LSC:");
        logMessage.append(this.targetName);
        logMessage.log();
        this.currentLanguage = string;
        int n2 = this.paras.getMIBConfigurationManager().getCurrentSkinId();
        SpeechLACHandler$LACCallback speechLACHandler$LACCallback = new SpeechLACHandler$LACCallback(this.currentLanguage, this);
        this.switchOff(n2, n, speechLACHandler$LACCallback);
    }

    protected abstract void switchOff(int n, int n2, SpeechLACHandler$LACCallback speechLACHandler$LACCallback) {
    }

    abstract boolean isLanguageAvailable(String string) {
    }

    private void handleLanguageAvailable(String string, int n) {
        this.currentLanguage = string;
        if (this.logger.isTraceEnabled()) {
            LogMessage logMessage = this.getTraceLogMessage();
            logMessage.append("SpeechLACHandler handleEvent LSCTNG_CHANGE_LANGUAGE: ");
            logMessage.append("lscTransactionID=");
            logMessage.append(n);
            logMessage.append(" language=");
            logMessage.append(string);
            logMessage.log();
        }
        int n2 = this.paras.getMIBConfigurationManager().getCurrentSkinId();
        SpeechLACHandler$LACCallback speechLACHandler$LACCallback = new SpeechLACHandler$LACCallback(this.currentLanguage, this);
        this.switchLanguage(this.currentLanguage, n2, n, speechLACHandler$LACCallback);
    }

    protected abstract void switchLanguage(String string, int n, int n2, SpeechLACHandler$LACCallback speechLACHandler$LACCallback) {
    }

    private void handleLanguageNotAvailable(int n) {
        if (this.logger.isTraceEnabled()) {
            LogMessage logMessage = this.getTraceLogMessage();
            logMessage.append("SpeechLACHandler: Language is not available.:");
            logMessage.append(this.targetName);
            logMessage.log();
        }
        this.responseToLanguageChange(n, false, this.currentLanguage);
    }

    void registerLac() {
        Object object;
        if (this.logger.isTraceEnabled()) {
            object = this.getTraceLogMessage();
            object.append("registerLac");
            object.append(" targetName=");
            object.append(this.targetName);
            object.append(" lscListenerType=");
            object.append(this.lscListenerType);
            object.log();
        }
        object = this.getLSCRegisterLacEvent("NO_LANGUAGE");
        this.paras.getGenericEvents().getEventDispatcher().sendSafe((EventGeneric)object);
    }

    private EventGeneric getLSCRegisterLacEvent(String string) {
        EventGeneric eventGeneric = ServiceManager.mGenericEventFactory.newEvent(1083965440);
        eventGeneric.setSenderTargetId(this.targetId);
        eventGeneric.setInt(0, this.targetId);
        eventGeneric.setInt(1, this.lscListenerType);
        eventGeneric.setString(2, string);
        eventGeneric.setString(3, this.targetName);
        return eventGeneric;
    }

    void unregisterLac() {
        Object object;
        if (this.logger.isTraceEnabled()) {
            object = this.getTraceLogMessage();
            object.append("deregisterLac");
            object.append(" targetName=");
            object.append(this.targetName);
            object.append(" lscListenerType=");
            object.append(this.lscListenerType);
            object.log();
        }
        object = this.getLSCUnregisterLacEvent();
        this.paras.getGenericEvents().getEventDispatcher().sendSafe((EventGeneric)object);
    }

    private EventGeneric getLSCUnregisterLacEvent() {
        EventGeneric eventGeneric = ServiceManager.mGenericEventFactory.newEvent(1117519872);
        eventGeneric.setSenderTargetId(this.targetId);
        eventGeneric.setInt(0, this.targetId);
        eventGeneric.setInt(1, this.lscListenerType);
        return eventGeneric;
    }

    void responseToLanguageChange(int n, boolean bl, String string) {
        Object object;
        if (this.logger.isTraceEnabled()) {
            object = this.getTraceLogMessage();
            object.append("responseToLanguageChange");
            object.append(" targetName=");
            object.append(this.targetName);
            object.append(" lscTransactionID=");
            object.append(n);
            object.append(" success=");
            object.append(bl);
            object.append(" currentLanguage=");
            object.append(string);
            object.log();
        }
        object = this.getLSCLanguageChangeResultEvent(n, bl, string);
        this.paras.getGenericEvents().getEventDispatcher().sendSafe((EventGeneric)object);
    }

    private EventGeneric getLSCLanguageChangeResultEvent(int n, boolean bl, String string) {
        EventGeneric eventGeneric = ServiceManager.mGenericEventFactory.newEvent(1151074304);
        eventGeneric.setSenderTargetId(this.targetId);
        eventGeneric.setInt(0, n);
        eventGeneric.setBoolean(1, bl);
        eventGeneric.setString(2, string);
        return eventGeneric;
    }

    protected int convertVoiceType(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        throw new RuntimeException(new StringBuffer().append("Voice Type not supported: ").append(n).toString());
    }

    protected int convertVoiceId(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        throw new RuntimeException(new StringBuffer().append("VoiceId not supported: ").append(n).toString());
    }

    protected abstract Object getDialogSystemConfig() {
    }

    @Override
    public GenericEvents getMainObject() {
        return this.paras.getGenericEvents();
    }

    @Override
    public int getTargetId() {
        return this.targetId;
    }

    @Override
    public void setTargetId(int n) {
    }

    int getLscListenerType() {
        return this.lscListenerType;
    }

    protected LogMessage getTraceLogMessage() {
        return this.logger.trace().append("(").append(this.targetName).append(")");
    }

    protected LogMessage getErrorLogMessage() {
        return this.logger.error().append("(").append(this.targetName).append(")");
    }

    protected LogMessage getInfoLogMessage() {
        return this.logger.info().append("(").append(this.targetName).append(")");
    }
}

