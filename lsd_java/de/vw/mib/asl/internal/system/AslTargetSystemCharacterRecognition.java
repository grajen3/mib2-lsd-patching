/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Double
 */
package de.vw.mib.asl.internal.system;

import de.vw.mib.asl.api.system.factoryreset.FactoryResetComponents;
import de.vw.mib.asl.api.system.factoryreset.FactoryResetService;
import de.vw.mib.asl.framework.api.dsiproxy.DSIProxy;
import de.vw.mib.asl.framework.api.dsiproxy.DSIProxyAdapterFactory;
import de.vw.mib.asl.framework.api.persistence.IPersistableEarlyData;
import de.vw.mib.asl.framework.api.startupv7r.ASLStartupv7rFactory;
import de.vw.mib.asl.framework.internal.framework.AbstractASLTarget;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.impl.system.SystemServicesProvider;
import de.vw.mib.asl.internal.system.AslTargetSystemCharacterRecognition$1;
import de.vw.mib.asl.internal.system.AslTargetSystemCharacterRecognition$HWREngineImpl;
import de.vw.mib.asl.internal.system.SystemServices;
import de.vw.mib.collections.ObjectObjectOptHashMap;
import de.vw.mib.configuration.ConfigurationManagerDiag;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.GenericEvents;
import de.vw.mib.genericevents.ServiceRegister;
import de.vw.mib.log4mib.LogMessage;
import de.vw.mib.speller.hwr.HWRConfiguration;
import de.vw.mib.speller.hwr.HWREngine;
import de.vw.mib.speller.hwr.HWREngineListener;
import de.vw.mib.speller.hwr.HWRManager;
import generated.de.vw.mib.asl.internal.ListManager;
import generated.de.vw.mib.asl.internal.hwr.transformer.HWRTimeoutCollector;
import java.util.Map;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.keypanel.DSIKeyPanel;

public final class AslTargetSystemCharacterRecognition
extends AbstractASLTarget
implements HWRManager {
    private static final String LOGGING_DELIM;
    private static final double SCALING;
    private static final int DEFAULT_LANGCODE;
    static final int CONFIDENCE_THRESHOLD_DEFAULT;
    static final int CHARACTER_MAXIMUM_NUMBER_DEFAULT;
    static final int STROKE_TIMER_DEFAULT;
    static final int RECOGNITION_TIMER_DEFAULT;
    private final IPersistableEarlyData persistableEarlyData = ASLStartupv7rFactory.getStartupv7rApi().getPersistableEarlyData();
    private final HWRConfiguration hwrConfiguration = new HWRConfiguration();
    private AslTargetSystemCharacterRecognition$HWREngineImpl hwrEngine;
    private DSIKeyPanel dsikeyPanel;
    private boolean setRecognizerModeRequested = false;
    private boolean setTouchAreaRequested = false;
    private String[] matchList = new String[0];
    private final Map languageMap = new ObjectObjectOptHashMap();
    private int currentLangcode = -1;
    private String currentLanguage = "NO_LANGUAGE";
    private boolean registeredAsLac;
    private boolean inputPanelReady;
    private boolean initialized;
    static /* synthetic */ Class class$org$dsi$ifc$keypanel$DSIKeyPanel;
    static /* synthetic */ Class class$org$dsi$ifc$keypanel$DSIKeyPanelListener;
    static /* synthetic */ Class class$de$vw$mib$speller$hwr$HWRManager;

    public AslTargetSystemCharacterRecognition(GenericEvents genericEvents, String string) {
        super(genericEvents, string);
        this.fillLanguageMap();
    }

    @Override
    public int getSubClassifier() {
        return 2048;
    }

    @Override
    public void gotEvent(EventGeneric eventGeneric) {
        switch (eventGeneric.getReceiverEventId()) {
            case 106: {
                this.processPowerOn();
                break;
            }
            case 4300062: {
                if (this.isTraceEnabled()) {
                    this.trace().append("[AslTargetSystemCharacterRecognition] ").append("ASLSystemServiceIds.RELOAD_PERSISTABLES received!").log();
                }
                this.initDataFromNamespaceEarly();
                break;
            }
            case 12: {
                int n = eventGeneric.getInt(0);
                this.getServiceRegister().removeServiceMonitor(n, 0, this.getTargetId());
                this.addObserver(n);
                break;
            }
            case 1073744432: {
                this.processResetRecognizer();
                break;
            }
            case 1073744652: {
                this.processSetMode(eventGeneric);
                break;
            }
            case 1073744653: {
                this.processSetTouchArea(eventGeneric);
                break;
            }
            case 1600000: {
                if (!this.registeredAsLac) {
                    this.registerLscParticipant();
                    this.registeredAsLac = true;
                }
                this.isHwrEnabled();
                this.removeObserver(6952960);
                break;
            }
            case 40003: {
                this.processLanguageChange(eventGeneric);
                break;
            }
            case 1075941828: {
                int n = eventGeneric.getInt(0);
                this.info().append("[AslTargetSystemCharacterRecognition] ").append("Selected index: ").append(n).append(" selected match: ").append(this.matchList[n]).log();
                this.processResetRecognizer();
                break;
            }
            case 1075841833: {
                boolean bl = eventGeneric.getBoolean(0);
                this.persistableEarlyData.setHWREnabled(bl);
                AslTargetSystemCharacterRecognition.writeBooleanToDatapool(1127358464, bl);
                break;
            }
        }
    }

    private boolean isHwrEnabled() {
        boolean bl = ServiceManager.configManagerDiag.isFeatureFlagSet(72);
        this.info(new StringBuffer().append("[AslTargetSystemCharacterRecognition] HWR FeatureFlag is ").append(bl).toString());
        return bl;
    }

    private void registerLscParticipant() {
        EventGeneric eventGeneric = ServiceManager.mGenericEventFactory.newEvent(1083965440);
        eventGeneric.setInt(0, this.getTargetId());
        eventGeneric.setInt(1, 0);
        eventGeneric.setString(2, "NO_LANGUAGE");
        eventGeneric.setString(3, super.getClass().getName());
        ServiceManager.eventMain.getEventDispatcher().sendSafe(eventGeneric);
    }

    private void processLanguageChange(EventGeneric eventGeneric) {
        int n = eventGeneric.getInt(0);
        this.currentLanguage = eventGeneric.getString(1).intern();
        int n2 = this.getLangCode(this.currentLanguage);
        this.answerLSC(n, true);
        if (this.currentLangcode != n2) {
            this.currentLangcode = n2;
            boolean bl = this.isHwrEnabled();
            if (this.inputPanelReady && bl) {
                this.dsikeyPanel.setRecognizerLanguage2(13, "", n2);
                this.info(new StringBuffer().append("[AslTargetSystemCharacterRecognition] LSC for HWR: ").append(this.currentLanguage).toString());
            } else if (bl) {
                this.info("[AslTargetSystemCharacterRecognition] LSC is ready. Waiting for ABT.");
            }
        }
    }

    public void dsiKeyPanelUpdateCharacterEvent2(int n, String[] stringArray, int[] nArray, int n2) {
        StringBuffer stringBuffer = new StringBuffer();
        for (int i2 = 0; i2 < stringArray.length; ++i2) {
            stringBuffer.append(stringArray[i2]);
            stringBuffer.append(" ");
        }
        String string = stringBuffer.toString();
        AslTargetSystemCharacterRecognition.writeStringToDatapool(3631, string);
        if (this.isTraceEnabled()) {
            LogMessage logMessage = this.trace().append("[AslTargetSystemCharacterRecognition] ").append("dsiKeyPanelUpdateCharacterEvent2, keyboardID: ").append(n);
            logMessage.append(" recognizedCharacters: ");
            logMessage.append(string);
            logMessage.append(" confidence: ");
            for (int i3 = 0; i3 < nArray.length; ++i3) {
                logMessage.append(nArray[i3]);
                logMessage.append(" ");
            }
            logMessage.log();
        }
        this.matchList = new String[stringArray.length];
        System.arraycopy((Object)stringArray, 0, (Object)this.matchList, 0, stringArray.length);
        ListManager.getGenericASLList(-692576000).updateList(this.matchList);
        HWREngineListener hWREngineListener = this.getListener();
        if (null != hWREngineListener) {
            hWREngineListener.updateRecognizedCharacters(stringArray);
        }
    }

    public void dsiKeyPanelUpdateRecognizerLanguage2(int n, String string, int n2, int n3) {
        if (n3 != 1) {
            return;
        }
        this.initialized = true;
        AslTargetSystemCharacterRecognition.writeStringToDatapool(-642244352, Integer.toString(n2));
        if (this.currentLangcode != n2) {
            this.error(new StringBuffer().append("[AslTargetSystemCharacterRecognition] Unexpected answer from DSIKeyPanelListener with language code ").append(n2).append(" while expected ").append(this.currentLangcode).toString());
        } else if (this.isTraceEnabled()) {
            this.trace().append("[AslTargetSystemCharacterRecognition] ").append("dsiKeyPanelUpdateRecognizerLanguage2 keyboardID: ").append(n).append(" language ").append(string).append(" langCode ").append(n2).log();
        }
    }

    public void dsiKeyPanelUpdateRecognizerMode(int n, int n2, int n3) {
        if (this.isTraceEnabled()) {
            this.trace().append("[AslTargetSystemCharacterRecognition] ").append("dsiKeyPanelUpdateRecognizerMode keyboardID: ").append(n).append(" recognizerMode ").append(n2).log();
        }
        this.setRecognizerModeRequested = false;
        if (!this.setTouchAreaRequested) {
            HWREngineListener hWREngineListener = this.getListener();
            if (this.isReadyAsl() && null != hWREngineListener) {
                hWREngineListener.updateEngineReady(true);
            }
        }
    }

    public void dsiKeyPanelUpdateTouchSensitiveArea(int n, int n2, int n3, int n4, int n5, int n6) {
        HWREngineListener hWREngineListener;
        if (this.isTraceEnabled()) {
            this.trace().append("[AslTargetSystemCharacterRecognition] ").append("dsiKeyPanelUpdateTouchSensitiveArea keyboardID: ").append(n).append(" x ").append(n2).append(" y ").append(n3).append("width ").append(n4).append(" height ").append(n5).log();
        }
        this.setTouchAreaRequested = false;
        if (!this.setRecognizerModeRequested && null != (hWREngineListener = this.getListener()) && this.isReadyAsl()) {
            hWREngineListener.updateEngineReady(true);
        }
    }

    public void dsiKeyPanelGenericSettingResponse(int n, int n2, int n3) {
        if (this.isTraceEnabled()) {
            this.trace().append("[AslTargetSystemCharacterRecognition] ").append("dsiKeyPanelGenericSettingResponse keyboardID: ").append(n).append(" key ").append(n2).append(" value ").append(n3).log();
        }
    }

    public void dsiKeyPanelUpdateInputPanelReady(int n, int n2, int n3) {
        if (n3 != 1) {
            this.warn("[AslTargetSystemCharacterRecognition] Invalid IPR message.");
            return;
        }
        if (n != 13) {
            this.info(new StringBuffer().append("[AslTargetSystemCharacterRecognition] Not supported panel with ID ").append(n).append(" is calling updateInputPanelReady. ").toString());
        }
        LogMessage logMessage = this.info().append("[AslTargetSystemCharacterRecognition] ");
        logMessage = this.inputPanelReady ? logMessage.append("dsiKeyPanelUpdateInputPanelReady Reinitalize HWR! keyboardID: ") : logMessage.append("dsiKeyPanelUpdateInputPanelReady first init. keyboardID: ");
        logMessage.append(n).append(" startupState ").append(n2).log();
        this.inputPanelReady = true;
        this.sendValidLanguageToKeyPanel();
        if (this.isTraceEnabled()) {
            this.trace().append("[AslTargetSystemCharacterRecognition] ").append("dsiKeyPanelUpdateInputPanelReady keyboardID: ").append(n).append(" startupState ").append(n2).log();
        }
        this.initializeHWR();
    }

    void sendValidLanguageToKeyPanel() {
        if (this.currentLangcode != -1) {
            this.dsikeyPanel.setRecognizerLanguage2(13, "", this.currentLangcode);
        }
    }

    @Override
    public int getDefaultTargetId() {
        return 5612;
    }

    @Override
    public synchronized HWREngine initHWREngine(HWREngineListener hWREngineListener) {
        this.hwrEngine = new AslTargetSystemCharacterRecognition$HWREngineImpl(this, hWREngineListener);
        return this.hwrEngine;
    }

    private void answerLSC(int n, boolean bl) {
        EventGeneric eventGeneric = ServiceManager.mGenericEventFactory.newEvent(1151074304);
        eventGeneric.setInt(0, n);
        eventGeneric.setBoolean(1, bl);
        eventGeneric.setString(2, this.currentLanguage);
        ServiceManager.eventMain.getEventDispatcher().sendSafe(eventGeneric);
    }

    private void clearAsl() {
        this.dsikeyPanel.clearRecognizer(13);
    }

    private HWRConfiguration getConfigurationAsl() {
        return this.hwrConfiguration;
    }

    private boolean isConfiguredAsl() {
        return this.hwrConfiguration.getTouchAreaW() != 0 && this.hwrConfiguration.getTouchAreaH() != 0;
    }

    private boolean isReadyAsl() {
        boolean bl = false;
        if (this.hwrEngine != null) {
            bl = this.initialized && this.hwrConfiguration.getMode() != 0 && this.isConfiguredAsl();
        }
        return bl;
    }

    private void releaseAsl() {
        this.hwrEngine = null;
        if (this.hwrConfiguration.getMode() != 0) {
            this.hwrConfiguration.setMode(0);
            this.sendConfigurationAsl();
        }
    }

    private void setConfigurationAsl(HWRConfiguration hWRConfiguration) {
        this.hwrConfiguration.setTouchAreaH(hWRConfiguration.getTouchAreaH());
        this.hwrConfiguration.setTouchAreaW(hWRConfiguration.getTouchAreaW());
        this.hwrConfiguration.setTouchAreaX(hWRConfiguration.getTouchAreaX());
        this.hwrConfiguration.setTouchAreaY(hWRConfiguration.getTouchAreaY());
        this.hwrConfiguration.setMode(hWRConfiguration.getMode());
    }

    private void sendConfigurationAsl() {
        if (this.hwrConfiguration.getMode() == 0) {
            this.setTouchAreaRequested = true;
            this.applyTouchSensitiveArea(0, 0, 0, 0);
        } else {
            this.setTouchAreaRequested = true;
            this.applyTouchSensitiveArea(this.hwrConfiguration.getTouchAreaX(), this.hwrConfiguration.getTouchAreaY(), this.hwrConfiguration.getTouchAreaW(), this.hwrConfiguration.getTouchAreaH());
            this.setRecognizerModeRequested = true;
            this.dsikeyPanel.setRecognizerMode(13, this.hwrConfiguration.getMode());
        }
        AslTargetSystemCharacterRecognition$HWREngineImpl aslTargetSystemCharacterRecognition$HWREngineImpl = this.hwrEngine;
        if (null != aslTargetSystemCharacterRecognition$HWREngineImpl) {
            aslTargetSystemCharacterRecognition$HWREngineImpl.getListener().updateEngineReady(false);
        }
    }

    private AslTargetSystemCharacterRecognition$HWREngineImpl getEngine() {
        return this.hwrEngine;
    }

    private HWREngineListener getListener() {
        AslTargetSystemCharacterRecognition$HWREngineImpl aslTargetSystemCharacterRecognition$HWREngineImpl = this.getEngine();
        return null != aslTargetSystemCharacterRecognition$HWREngineImpl ? aslTargetSystemCharacterRecognition$HWREngineImpl.getListener() : null;
    }

    private void processRevertSystemCharacterRecognition() {
        if (this.isTraceEnabled()) {
            this.trace().append("[AslTargetSystemCharacterRecognition] ").append("processRevertSystemCharacterRecognition").log();
        }
        this.persistableEarlyData.setHWREnabled(false);
        AslTargetSystemCharacterRecognition.writeBooleanToDatapool(1127358464, false);
    }

    private static double retrieveScaling() {
        String string = System.getProperty("de.vw.mib.asl.hwr.scaling");
        try {
            return Double.parseDouble((String)string);
        }
        catch (Exception exception) {
            return 1.0;
        }
    }

    private void applyTouchSensitiveArea(int n, int n2, int n3, int n4) {
        this.dsikeyPanel.setTouchSensitiveArea(13, (int)((double)n * SCALING), (int)((double)n2 * SCALING), (int)((double)n3 * SCALING), (int)((double)n4 * SCALING));
    }

    private void fillLanguageMap() {
        this.languageMap.put("zh_CN", new Integer(10));
        this.languageMap.put("zh_TW", new Integer(19));
        this.languageMap.put("zh_HK", new Integer(22));
    }

    private void initDataFromNamespaceEarly() {
        AslTargetSystemCharacterRecognition.writeBooleanToDatapool(1127358464, this.persistableEarlyData.getHWREnabled());
    }

    private void initDsi(SystemServices systemServices) {
        ConfigurationManagerDiag configurationManagerDiag = systemServices.getConfigManagerDiag();
        DSIProxy dSIProxy = systemServices.getDsiProxy();
        int n = configurationManagerDiag.getSystemKeyPanelInstance();
        this.dsikeyPanel = (DSIKeyPanel)dSIProxy.getService(this, class$org$dsi$ifc$keypanel$DSIKeyPanel == null ? (class$org$dsi$ifc$keypanel$DSIKeyPanel = AslTargetSystemCharacterRecognition.class$("org.dsi.ifc.keypanel.DSIKeyPanel")) : class$org$dsi$ifc$keypanel$DSIKeyPanel, n);
        DSIProxyAdapterFactory dSIProxyAdapterFactory = systemServices.getDsiProxyAdapterFactory();
        DSIListener dSIListener = dSIProxyAdapterFactory.createDSIListenerMethodAdapter(this, class$org$dsi$ifc$keypanel$DSIKeyPanelListener == null ? (class$org$dsi$ifc$keypanel$DSIKeyPanelListener = AslTargetSystemCharacterRecognition.class$("org.dsi.ifc.keypanel.DSIKeyPanelListener")) : class$org$dsi$ifc$keypanel$DSIKeyPanelListener);
        dSIProxy.addResponseListener(this, class$org$dsi$ifc$keypanel$DSIKeyPanelListener == null ? (class$org$dsi$ifc$keypanel$DSIKeyPanelListener = AslTargetSystemCharacterRecognition.class$("org.dsi.ifc.keypanel.DSIKeyPanelListener")) : class$org$dsi$ifc$keypanel$DSIKeyPanelListener, n, dSIListener);
        this.dsikeyPanel.setNotification(new int[]{21, 22, 9, 24, 26}, dSIListener);
        this.addObserver(6952960);
        this.addObserverForModelEvent(805961792);
        this.addObserverForModelEvent(202047552);
        this.addObserverForModelEvent(218824768);
        this.addObserverForModelEvent(688595008);
        this.addObserverForModelEvent(-997121728);
    }

    private int getLangCode(String string) {
        if (this.languageMap.containsKey(string)) {
            return (Integer)this.languageMap.get(string);
        }
        return 1;
    }

    private void initializeHWR() {
        this.dsikeyPanel.setGenericSetting(13, 24, 10);
        this.dsikeyPanel.setGenericSetting(13, 115, 10);
        this.dsikeyPanel.setGenericSetting(13, 113, 100);
        this.dsikeyPanel.setGenericSetting(13, 114, 500);
        if (this.hwrConfiguration.getMode() != 0) {
            if (this.isConfiguredAsl()) {
                this.applyTouchSensitiveArea(this.hwrConfiguration.getTouchAreaX(), this.hwrConfiguration.getTouchAreaY(), this.hwrConfiguration.getTouchAreaW(), this.hwrConfiguration.getTouchAreaH());
            }
            this.dsikeyPanel.setRecognizerMode(13, this.hwrConfiguration.getMode());
        }
        AslTargetSystemCharacterRecognition.writeStringToDatapool(3631, "");
        Object[] objectArray = new HWRTimeoutCollector[]{new HWRTimeoutCollector()};
        objectArray[0].hwr_timeout_recognition = 500;
        objectArray[0].hwr_timeout_stroke = 100;
        ListManager.getGenericASLList(3999).updateList(objectArray);
    }

    private void processPowerOn() {
        if (this.isTraceEnabled()) {
            this.trace().append("[AslTargetSystemCharacterRecognition] ").append("processPowerOn").log();
        }
        SystemServices systemServices = SystemServicesProvider.getSystemServices();
        this.initDsi(systemServices);
        this.initDataFromNamespaceEarly();
        systemServices.getBundleContext().registerService((class$de$vw$mib$speller$hwr$HWRManager == null ? (class$de$vw$mib$speller$hwr$HWRManager = AslTargetSystemCharacterRecognition.class$("de.vw.mib.speller.hwr.HWRManager")) : class$de$vw$mib$speller$hwr$HWRManager).getName(), (Object)this, null);
        this.registerFactoryResetParticipant(systemServices);
    }

    private void registerFactoryResetParticipant(SystemServices systemServices) {
        FactoryResetService factoryResetService = systemServices.getFactoryResetService();
        AslTargetSystemCharacterRecognition$1 aslTargetSystemCharacterRecognition$1 = new AslTargetSystemCharacterRecognition$1(this);
        factoryResetService.addParticipant(aslTargetSystemCharacterRecognition$1, FactoryResetComponents.SYSTEM);
    }

    private void addObserverForModelEvent(int n) {
        ServiceRegister serviceRegister = this.getServiceRegister();
        if (serviceRegister.existService(n)) {
            this.addObserver(n);
        } else {
            serviceRegister.addServiceMonitor(n, 0, this.getTargetId());
        }
    }

    private void processResetRecognizer() {
        AslTargetSystemCharacterRecognition.writeStringToDatapool(3631, "");
        this.matchList = new String[0];
        ListManager.getGenericASLList(-692576000).updateList(this.matchList);
        this.dsikeyPanel.clearRecognizer(13);
    }

    private void processSetMode(EventGeneric eventGeneric) {
        int n;
        int n2 = eventGeneric.getInt(0);
        switch (n2) {
            case 0: {
                n = 0;
                break;
            }
            case 1: {
                n = 12;
                break;
            }
            case 2: {
                n = 19;
                break;
            }
            case 3: {
                n = 20;
                break;
            }
            case 4: {
                n = 21;
                break;
            }
            case 5: {
                n = 22;
                break;
            }
            case 6: {
                n = 23;
                break;
            }
            default: {
                n = 0;
            }
        }
        this.hwrConfiguration.setMode(n);
        AslTargetSystemCharacterRecognition.writeStringToDatapool(-625467136, Integer.toString(n));
        if (n == 0) {
            this.applyTouchSensitiveArea(0, 0, 0, 0);
        } else {
            AslTargetSystemCharacterRecognition.writeStringToDatapool(3631, "");
            this.matchList = new String[0];
            ListManager.getGenericASLList(-692576000).updateList(this.matchList);
            if (this.hwrConfiguration.getTouchAreaW() != 0 && this.hwrConfiguration.getTouchAreaH() != 0) {
                this.applyTouchSensitiveArea(this.hwrConfiguration.getTouchAreaX(), this.hwrConfiguration.getTouchAreaY(), this.hwrConfiguration.getTouchAreaW(), this.hwrConfiguration.getTouchAreaH());
            }
            this.dsikeyPanel.setRecognizerMode(13, n);
        }
    }

    private void processSetTouchArea(EventGeneric eventGeneric) {
        this.hwrConfiguration.setTouchAreaX(eventGeneric.getInt(0));
        this.hwrConfiguration.setTouchAreaY(eventGeneric.getInt(1));
        this.hwrConfiguration.setTouchAreaW(eventGeneric.getInt(2));
        this.hwrConfiguration.setTouchAreaH(eventGeneric.getInt(3));
        if (this.hwrConfiguration.getMode() != 0) {
            this.applyTouchSensitiveArea(this.hwrConfiguration.getTouchAreaX(), this.hwrConfiguration.getTouchAreaY(), this.hwrConfiguration.getTouchAreaW(), this.hwrConfiguration.getTouchAreaH());
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

    static /* synthetic */ void access$000(AslTargetSystemCharacterRecognition aslTargetSystemCharacterRecognition) {
        aslTargetSystemCharacterRecognition.processRevertSystemCharacterRecognition();
    }

    static /* synthetic */ AslTargetSystemCharacterRecognition$HWREngineImpl access$100(AslTargetSystemCharacterRecognition aslTargetSystemCharacterRecognition) {
        return aslTargetSystemCharacterRecognition.getEngine();
    }

    static /* synthetic */ void access$200(AslTargetSystemCharacterRecognition aslTargetSystemCharacterRecognition) {
        aslTargetSystemCharacterRecognition.clearAsl();
    }

    static /* synthetic */ HWRConfiguration access$300(AslTargetSystemCharacterRecognition aslTargetSystemCharacterRecognition) {
        return aslTargetSystemCharacterRecognition.getConfigurationAsl();
    }

    static /* synthetic */ boolean access$400(AslTargetSystemCharacterRecognition aslTargetSystemCharacterRecognition) {
        return aslTargetSystemCharacterRecognition.isConfiguredAsl();
    }

    static /* synthetic */ boolean access$500(AslTargetSystemCharacterRecognition aslTargetSystemCharacterRecognition) {
        return aslTargetSystemCharacterRecognition.isReadyAsl();
    }

    static /* synthetic */ void access$600(AslTargetSystemCharacterRecognition aslTargetSystemCharacterRecognition) {
        aslTargetSystemCharacterRecognition.releaseAsl();
    }

    static /* synthetic */ void access$700(AslTargetSystemCharacterRecognition aslTargetSystemCharacterRecognition) {
        aslTargetSystemCharacterRecognition.sendConfigurationAsl();
    }

    static /* synthetic */ void access$800(AslTargetSystemCharacterRecognition aslTargetSystemCharacterRecognition, HWRConfiguration hWRConfiguration) {
        aslTargetSystemCharacterRecognition.setConfigurationAsl(hWRConfiguration);
    }

    static {
        SCALING = AslTargetSystemCharacterRecognition.retrieveScaling();
    }
}

