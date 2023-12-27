/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechengine.config.lsc;

import de.vw.mib.asl.api.speechengine.config.voice.VoiceServiceListener;
import de.vw.mib.asl.framework.api.diagnosis.config.Access;
import de.vw.mib.asl.internal.speechengine.config.lsc.SpeechLACHandler;
import de.vw.mib.asl.internal.speechengine.config.lsc.SpeechLSCManager$1;
import de.vw.mib.asl.internal.speechengine.config.lsc.SpeechRecognizerLACHandler;
import de.vw.mib.asl.internal.speechengine.config.lsc.SpeechTTSLACHandler;
import de.vw.mib.asl.internal.speechengine.config.lsc.VoiceServiceInternal;
import de.vw.mib.asl.internal.speechengine.config.start.SpeechConfiguratorParameters;
import de.vw.mib.asl.internal.speechengine.dialogsystem.config.DialogSystemConfigListener;
import de.vw.mib.asl.internal.speechengine.dialogsystem.config.RecognizerConfig;
import de.vw.mib.asl.internal.speechengine.dialogsystem.config.TTSConfig;
import de.vw.mib.asl.internal.util.AbstractClassifiedLogger;
import de.vw.mib.asl.speech.persistence.SpeechPersistenceService;
import de.vw.mib.asl.speech.persistence.SpeechSettingsPersistable;
import de.vw.mib.collections.ObjectObjectMap;
import de.vw.mib.collections.ObjectObjectOptHashMap;
import de.vw.mib.collections.ObjectOptHashSet;
import de.vw.mib.collections.ObjectSet;
import de.vw.mib.collections.ints.IntIterator;
import de.vw.mib.collections.ints.IntOptHashSet;
import de.vw.mib.collections.ints.IntSet;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class SpeechLSCManager
implements DialogSystemConfigListener,
VoiceServiceInternal {
    protected final AbstractClassifiedLogger logger;
    private final ObjectObjectMap configLACHandlerMap;
    private final ObjectObjectMap voiceServiceListenerAsync;
    private final SpeechConfiguratorParameters paras;
    private int currentVoice = 0;
    private IntSet currentAvailableVoicesSet = new IntOptHashSet();
    private boolean currentIsVoiceChangeActive = false;
    private int systemDefaultMIBVoiceType = 0;
    private boolean systemDefaultMIBVoiceTypeSetByCoding = false;
    private final SpeechPersistenceService speechPersistenceService;

    public SpeechLSCManager(SpeechConfiguratorParameters speechConfiguratorParameters, SpeechPersistenceService speechPersistenceService) {
        this.speechPersistenceService = speechPersistenceService;
        this.logger = speechConfiguratorParameters.getClassifiedLogger();
        this.paras = speechConfiguratorParameters;
        this.voiceServiceListenerAsync = new ObjectObjectOptHashMap();
        this.configLACHandlerMap = new ObjectObjectOptHashMap();
        this.requestAdaptionLoadFurtherData(speechConfiguratorParameters);
        this.loadAndApplyPersistedVoiceType();
        this.registerAtDialogSystem(speechConfiguratorParameters);
    }

    private void registerAtDialogSystem(SpeechConfiguratorParameters speechConfiguratorParameters) {
        Object object;
        Iterator iterator = speechConfiguratorParameters.getDialogSystemConfig().getRecognizerConfigs().iterator();
        while (iterator.hasNext()) {
            object = (RecognizerConfig)iterator.next();
            this.registerRecognizerConfig((RecognizerConfig)object);
        }
        object = speechConfiguratorParameters.getDialogSystemConfig().getTTSConfigs().iterator();
        while (iterator.hasNext()) {
            TTSConfig tTSConfig = (TTSConfig)object.next();
            this.registerTTSConfig(tTSConfig);
        }
        speechConfiguratorParameters.getDialogSystemConfig().register(this);
    }

    private void requestAdaptionLoadFurtherData(SpeechConfiguratorParameters speechConfiguratorParameters) {
        speechConfiguratorParameters.getAdaptionApi().requestLoadFurtherData(new SpeechLSCManager$1(this));
    }

    @Override
    public void onNewTTSAvailabe(TTSConfig tTSConfig) {
        this.registerTTSConfig(tTSConfig);
    }

    private void registerTTSConfig(TTSConfig tTSConfig) {
        int n;
        String string;
        int n2;
        int n3 = tTSConfig.getTtsInstanceId();
        if (n3 == 0) {
            n2 = 4;
            string = "SpeechLSCTarget-SPEECH_TTS";
            n = 529602560;
        } else if (n3 == 1) {
            n2 = 7;
            string = "SpeechLSCTarget-NAV_TTS";
            n = 546379776;
        } else {
            throw new RuntimeException(new StringBuffer().append("TtsInstanceId not supported ").append(n3).toString());
        }
        if (this.isLscListenerTypePresent(n2)) {
            this.logger.error().append("registerTTSConfig: lscListenerType already exists: ").append(n2).log();
        } else {
            SpeechTTSLACHandler speechTTSLACHandler = new SpeechTTSLACHandler(this, this.paras, n, n2, string, tTSConfig);
            try {
                this.paras.getGenericEvents().getEventDispatcher().registerTarget(speechTTSLACHandler.getTargetId(), speechTTSLACHandler, this.paras.getGenericEventsTaskId(), false);
            }
            catch (Exception exception) {
                this.logger.error().append("registerTTSConfig activate failed").attachThrowable(exception).log();
            }
            this.configLACHandlerMap.put(tTSConfig, speechTTSLACHandler);
            speechTTSLACHandler.registerLac();
        }
    }

    private List getAllSpeechTTSLACHandlers() {
        ArrayList arrayList = new ArrayList();
        Iterator iterator = this.configLACHandlerMap.valueIterator();
        while (iterator.hasNext()) {
            SpeechLACHandler speechLACHandler = (SpeechLACHandler)iterator.next();
            if (!(speechLACHandler instanceof SpeechTTSLACHandler)) continue;
            arrayList.add(speechLACHandler);
        }
        return arrayList;
    }

    @Override
    public void updateVoiceChangeActive() {
        boolean bl = false;
        Iterator iterator = this.getAllSpeechTTSLACHandlers().iterator();
        while (iterator.hasNext()) {
            SpeechTTSLACHandler speechTTSLACHandler = (SpeechTTSLACHandler)iterator.next();
            if (!speechTTSLACHandler.isVoiceChangeActive()) continue;
            bl = true;
            break;
        }
        this.setAndNotifyVoiceServiceListenerVoiceChangeActive(bl);
    }

    @Override
    public void onTTSRemoved(TTSConfig tTSConfig) {
        this.onConfigRemoved(tTSConfig);
        this.updateAvailableVoices(this.getCurrentTTSLanguage());
    }

    @Override
    public void onNewRecognizerAvailabe(RecognizerConfig recognizerConfig) {
        this.registerRecognizerConfig(recognizerConfig);
    }

    private void registerRecognizerConfig(RecognizerConfig recognizerConfig) {
        int n = 5;
        String string = "SpeechLSCTarget-SPEECH_SDS";
        if (this.isLscListenerTypePresent(5)) {
            this.logger.error().append("registerRecognizerConfig: lscListenerType already exists: ").append(5).log();
        } else {
            SpeechRecognizerLACHandler speechRecognizerLACHandler = new SpeechRecognizerLACHandler(this, this.paras, 512825344, 5, "SpeechLSCTarget-SPEECH_SDS", recognizerConfig);
            try {
                this.paras.getGenericEvents().getEventDispatcher().registerTarget(speechRecognizerLACHandler.getTargetId(), speechRecognizerLACHandler, this.paras.getGenericEventsTaskId(), false);
            }
            catch (Exception exception) {
                this.logger.error().append("registerRecognizerConfig activate failed").attachThrowable(exception).log();
            }
            speechRecognizerLACHandler.registerLac();
            this.configLACHandlerMap.put(recognizerConfig, speechRecognizerLACHandler);
        }
    }

    private void onConfigRemoved(Object object) {
        if (this.configLACHandlerMap.containsKey(object)) {
            SpeechLACHandler speechLACHandler = (SpeechLACHandler)this.configLACHandlerMap.get(object);
            speechLACHandler.unregisterLac();
            this.configLACHandlerMap.remove(object);
            try {
                this.paras.getGenericEvents().getEventDispatcher().unregisterTarget(speechLACHandler.getTargetId());
            }
            catch (Exception exception) {
                this.logger.error().append("onConfigRemoved exception").log();
            }
        } else {
            this.logger.error().append("onRecognizerRemoved: RecognizerConfig to remove, was not found. ").log();
        }
    }

    @Override
    public int[] getAvailableVoices() {
        return this.currentAvailableVoicesSet.toArray();
    }

    @Override
    public int getVoice() {
        return this.currentVoice;
    }

    @Override
    public void setVoice(int n) {
        if (this.currentIsVoiceChangeActive) {
            throw new IllegalStateException("A voice is currently running.");
        }
        if (!this.isCurrentLanguageSupportingVoiceType(n)) {
            throw new IllegalArgumentException("New voice is not available.");
        }
        if (this.currentVoice == n) {
            if (this.logger.isTraceEnabled()) {
                this.logger.trace().append("setVoice(...): Voice is already set");
            }
            return;
        }
        this.setAndNotifyVoiceServiceListenerVoiceVoiceChanged(n);
        Iterator iterator = this.getAllSpeechTTSLACHandlers().iterator();
        while (iterator.hasNext()) {
            SpeechTTSLACHandler speechTTSLACHandler = (SpeechTTSLACHandler)iterator.next();
            speechTTSLACHandler.doVoiceChange(n);
        }
    }

    private boolean isCurrentLanguageSupportingVoiceType(int n) {
        return this.currentAvailableVoicesSet.contains(n);
    }

    @Override
    public boolean isVoiceChangeActive() {
        return this.currentIsVoiceChangeActive;
    }

    @Override
    public void addListener(VoiceServiceListener voiceServiceListener) {
        if (!this.voiceServiceListenerAsync.containsKey(voiceServiceListener)) {
            if (this.logger.isTraceEnabled()) {
                this.logger.trace().append("addListener(VoiceServiceListener) : ").append(super.getClass().getName()).log();
            }
            Object object = this.paras.getAsyncServiceFactory().create(voiceServiceListener);
            this.voiceServiceListenerAsync.put(voiceServiceListener, object);
        }
    }

    @Override
    public void removeListener(VoiceServiceListener voiceServiceListener) {
        if (this.voiceServiceListenerAsync.containsKey(voiceServiceListener)) {
            if (this.logger.isTraceEnabled()) {
                this.logger.trace().append("removeListener(VoiceServiceListener) : ").append(super.getClass().getName()).log();
            }
            this.voiceServiceListenerAsync.remove(voiceServiceListener);
        }
    }

    private void setAndNotifyVoiceServiceListenerVoiceChangeActive(boolean bl) {
        if (bl == this.currentIsVoiceChangeActive) {
            return;
        }
        this.currentIsVoiceChangeActive = bl;
        Iterator iterator = this.voiceServiceListenerAsync.valueIterator();
        while (iterator.hasNext()) {
            VoiceServiceListener voiceServiceListener = (VoiceServiceListener)iterator.next();
            voiceServiceListener.isVoiceChangeActive(this.currentIsVoiceChangeActive);
        }
        if (this.logger.isTraceEnabled()) {
            this.logger.trace().append("isVoiceChangeActive: ").append(this.currentIsVoiceChangeActive).log();
        }
    }

    private void setAndNotifyVoiceServiceListenerVoiceAvailableVoicesChanged(IntSet intSet) {
        if (intSet.equals(this.currentAvailableVoicesSet)) {
            return;
        }
        this.currentAvailableVoicesSet = intSet;
        int[] nArray = this.currentAvailableVoicesSet.toArray();
        Iterator iterator = this.voiceServiceListenerAsync.valueIterator();
        while (iterator.hasNext()) {
            VoiceServiceListener voiceServiceListener = (VoiceServiceListener)iterator.next();
            voiceServiceListener.availableVoicesChanged(nArray);
        }
        if (this.logger.isTraceEnabled()) {
            this.logger.trace().append("availableVoicesChanged to: ").append(this.currentAvailableVoicesSet.toString()).log();
        }
    }

    private void setAndNotifyVoiceServiceListenerVoiceVoiceChanged(int n) {
        if (this.currentVoice == n) {
            if (this.logger.isTraceEnabled()) {
                this.logger.trace().append("setAndNotifyVoiceServiceListenerVoiceVoiceChanged current == newVoice newVoice=").append(n).log();
            }
            return;
        }
        this.currentVoice = n;
        this.speechPersistenceService.loadSpeechSettingsPersistable().setCurrentVoiceType(n);
        Iterator iterator = this.voiceServiceListenerAsync.valueIterator();
        while (iterator.hasNext()) {
            VoiceServiceListener voiceServiceListener = (VoiceServiceListener)iterator.next();
            voiceServiceListener.voiceChanged(n);
        }
        if (this.logger.isTraceEnabled()) {
            this.logger.trace().append("voiceChanged to: ").append(this.currentVoice).log();
        }
    }

    @Override
    public void onRecognizerRemoved(RecognizerConfig recognizerConfig) {
        this.onConfigRemoved(recognizerConfig);
    }

    private boolean isLscListenerTypePresent(int n) {
        Iterator iterator = this.configLACHandlerMap.valueIterator();
        while (iterator.hasNext()) {
            SpeechLACHandler speechLACHandler = (SpeechLACHandler)iterator.next();
            if (speechLACHandler.getLscListenerType() != n) continue;
            return true;
        }
        return false;
    }

    @Override
    public void updateAvailableVoices(String string) {
        Object object;
        ObjectOptHashSet objectOptHashSet = new ObjectOptHashSet();
        Iterator iterator = this.getAllSpeechTTSLACHandlers().iterator();
        while (iterator.hasNext()) {
            object = (SpeechTTSLACHandler)iterator.next();
            if (!((SpeechTTSLACHandler)object).initialLanguageChangeReceived()) continue;
            IntSet intSet = ((SpeechTTSLACHandler)object).getAvailableVoices(string);
            if (intSet != null) {
                if (((SpeechTTSLACHandler)object).logger.isTraceEnabled()) {
                    ((SpeechLACHandler)object).getTraceLogMessage().append("currentAvailableVoices").append(intSet).log();
                }
            } else if (((SpeechTTSLACHandler)object).logger.isTraceEnabled()) {
                ((SpeechLACHandler)object).getTraceLogMessage().append("currentAvailableVoices was null").log();
            }
            objectOptHashSet.add(intSet);
        }
        object = this.getIntersectingSet(objectOptHashSet);
        if (this.logger.isTraceEnabled()) {
            this.logger.trace().append("updateAvailableVoices intersectingAvailableVoices").append(object);
        }
        this.setAndNotifyVoiceServiceListenerVoiceAvailableVoicesChanged((IntSet)object);
    }

    private String getCurrentTTSLanguage() {
        Iterator iterator = this.getAllSpeechTTSLACHandlers().iterator();
        if (iterator.hasNext()) {
            SpeechTTSLACHandler speechTTSLACHandler = (SpeechTTSLACHandler)iterator.next();
            if (this.logger.isTraceEnabled()) {
                this.logger.trace().append("getCurrentTTSLanguage TTS handler found language=").append(speechTTSLACHandler.currentLanguage).log();
            }
            return speechTTSLACHandler.currentLanguage;
        }
        String string = this.paras.getMIBConfigurationManager().getCurrentGuiLanguage();
        if (this.logger.isTraceEnabled()) {
            this.logger.trace().append("  no TTS registered fallback to GUI ").append(string).log();
        }
        return string;
    }

    private IntSet getIntersectingSet(ObjectSet objectSet) {
        IntOptHashSet intOptHashSet = new IntOptHashSet();
        Iterator iterator = objectSet.iterator();
        while (iterator.hasNext()) {
            IntSet intSet = (IntSet)iterator.next();
            IntIterator intIterator = intSet.iterator();
            while (intIterator.hasNext()) {
                int n = intIterator.next();
                if (intOptHashSet.contains(n) || !this.existsInAllSets(n, objectSet)) continue;
                intOptHashSet.add(n);
            }
        }
        return intOptHashSet;
    }

    private boolean existsInAllSets(int n, ObjectSet objectSet) {
        Iterator iterator = objectSet.iterator();
        while (iterator.hasNext()) {
            IntSet intSet = (IntSet)iterator.next();
            if (intSet.contains(n)) continue;
            return false;
        }
        return true;
    }

    @Override
    public void changeToDefaultVoice() {
        try {
            int n = this.retrieveDefaultVoice();
            this.setVoice(n);
        }
        catch (Exception exception) {
            // empty catch block
        }
    }

    private int retrieveDefaultVoice() {
        int n;
        if (!this.systemDefaultMIBVoiceTypeSetByCoding && this.logger.isTraceEnabled()) {
            this.logger.trace().append("retrieveDefaultVoice, voice was not loaded from coding yet").log();
        }
        if (this.currentAvailableVoicesSet.contains(this.systemDefaultMIBVoiceType)) {
            if (this.logger.isTraceEnabled()) {
                this.logger.trace().append("retrieveDefaultVoice, using system default").log();
            }
            n = this.systemDefaultMIBVoiceType;
        } else if (this.currentAvailableVoicesSet.contains(0)) {
            if (this.logger.isTraceEnabled()) {
                this.logger.trace().append("retrieveDefaultVoice, using female voice").log();
            }
            n = 0;
        } else if (!this.currentAvailableVoicesSet.isEmpty()) {
            IntIterator intIterator = this.currentAvailableVoicesSet.iterator();
            n = intIterator.next();
            if (this.logger.isTraceEnabled()) {
                this.logger.trace().append("retrieveDefaultVoice, using first available voice=").append(n).log();
            }
        } else {
            this.logger.info().append("retrieveDefaultVoice, currentAvailableVoicesSet is empty").log();
            throw new Exception();
        }
        if (this.logger.isTraceEnabled()) {
            this.logger.info().append("retrieveDefaultVoice, returning=").append(n).log();
        }
        return n;
    }

    protected void processAdaptionsResponse(Access access) {
        boolean bl = access.contains(739);
        if (bl) {
            int n = access.getValue(739);
            this.systemDefaultMIBVoiceType = this.convertDiagDefaultVoiceToVoiceType(n);
            this.systemDefaultMIBVoiceTypeSetByCoding = true;
        } else {
            this.logger.error().append("processAdaptionsResponse LoadFurtherData did not contain ID_SYSTEM_LANGUAGE_TYPE").log();
        }
    }

    private int convertDiagDefaultVoiceToVoiceType(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        return 0;
    }

    public void setTargetId(int n) {
    }

    private void loadAndApplyPersistedVoiceType() {
        int n;
        SpeechSettingsPersistable speechSettingsPersistable = this.speechPersistenceService.loadSpeechSettingsPersistable();
        this.currentVoice = n = speechSettingsPersistable.getCurrentVoiceType();
    }

    @Override
    public void doSilentMatchFromAvailableToCurrentVoice() {
        try {
            if (this.isCurrentLanguageSupportingVoiceType(this.currentVoice)) {
                if (this.logger.isTraceEnabled()) {
                    this.logger.trace().append("Available voices are supporting current voice").log();
                }
                return;
            }
            if (this.logger.isTraceEnabled()) {
                this.logger.trace().append("Available voices are not supporting current voice").append(this.currentVoice).log();
            }
            int n = this.retrieveDefaultVoice();
            this.setAndNotifyVoiceServiceListenerVoiceVoiceChanged(n);
        }
        catch (Exception exception) {
            // empty catch block
        }
    }
}

