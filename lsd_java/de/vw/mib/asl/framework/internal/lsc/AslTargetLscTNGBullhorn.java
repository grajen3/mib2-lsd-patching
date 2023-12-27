/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.lsc;

import de.vw.mib.asl.api.system.ASLSystemAPI;
import de.vw.mib.asl.api.system.ASLSystemFactory;
import de.vw.mib.asl.api.system.factoryreset.AbstractFactoryResetParticipant;
import de.vw.mib.asl.api.system.factoryreset.FactoryResetCallback;
import de.vw.mib.asl.api.system.factoryreset.FactoryResetComponent;
import de.vw.mib.asl.api.system.factoryreset.FactoryResetComponents;
import de.vw.mib.asl.api.system.factoryreset.FactoryResetService;
import de.vw.mib.asl.framework.api.lsc.ASLLscFactory;
import de.vw.mib.asl.framework.api.persistence.IPersistableEarlyData;
import de.vw.mib.asl.framework.api.startupv7r.ASLStartupv7rFactory;
import de.vw.mib.asl.framework.internal.framework.AbstractASLTarget;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.framework.internal.impl.lsc.DiagLanguageUpdateListener;
import de.vw.mib.asl.framework.internal.impl.lsc.InitialLscTrigger;
import de.vw.mib.asl.framework.internal.impl.lsc.LacListenerRegistry;
import de.vw.mib.asl.framework.internal.impl.lsc.LanguageDiagnosisHandler;
import de.vw.mib.asl.framework.internal.impl.lsc.ListenerTools;
import de.vw.mib.asl.framework.internal.impl.lsc.LscAdapter;
import de.vw.mib.asl.framework.internal.impl.lsc.LscServicesProvider;
import de.vw.mib.asl.framework.internal.impl.lsc.SpellerLanguageManager;
import de.vw.mib.asl.framework.internal.lsc.AslTargetLscTNGBullhorn$1;
import de.vw.mib.asl.framework.internal.lsc.AslTargetLscTNGBullhorn$2;
import de.vw.mib.asl.framework.internal.lsc.AslTargetLscTNGBullhorn$3;
import de.vw.mib.asl.framework.internal.lsc.AslTargetLscTNGBullhorn$4;
import de.vw.mib.asl.framework.internal.lsc.AslTargetLscTNGBullhorn$5;
import de.vw.mib.asl.framework.internal.lsc.AslTargetLscTNGBullhorn$6;
import de.vw.mib.asl.framework.internal.lsc.AslTargetLscTNGBullhorn$7;
import de.vw.mib.asl.framework.internal.lsc.AutomaticLanguageModeInstaller;
import de.vw.mib.asl.framework.internal.lsc.BrandHandler;
import de.vw.mib.asl.framework.internal.lsc.DelegatingLscController;
import de.vw.mib.asl.framework.internal.lsc.DiagnosisHandler;
import de.vw.mib.asl.framework.internal.lsc.LanguageChangeServiceImpl;
import de.vw.mib.asl.framework.internal.lsc.LanguageHelper;
import de.vw.mib.asl.framework.internal.lsc.LscModel;
import de.vw.mib.asl.framework.internal.lsc.LscServices;
import de.vw.mib.asl.framework.internal.lsc.LscValidator;
import de.vw.mib.asl.framework.internal.lsc.OsgiServices;
import de.vw.mib.asl.framework.internal.lsc.PersistableLsc;
import de.vw.mib.asl.framework.internal.lsc.api.impl.ASLLscAPIImpl;
import de.vw.mib.asl.framework.internal.lsc.testmode.SkinIdSelector;
import de.vw.mib.collections.ints.IntIterator;
import de.vw.mib.collections.ints.IntObjectMap;
import de.vw.mib.configuration.ConfigurationManagerDiag;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.GenericEvents;
import de.vw.mib.lsctng.AslLscBullhorn;
import de.vw.mib.lsctng.LanguageChanger;
import de.vw.mib.lsctng.LscController;
import de.vw.mib.lsctng.SkinChanger;
import de.vw.mib.lsctng.SkinmodeChanger;
import generated.de.vw.mib.asl.internal.ListManager;
import java.util.Arrays;

public class AslTargetLscTNGBullhorn
extends AbstractASLTarget
implements AslLscBullhorn {
    static FactoryResetComponent ADDITIONAL_SPELLER_LANGUAGES_COMPONENT = FactoryResetComponent.createChild(FactoryResetComponents.SYSTEM, "AdditionalSpellerLanguages");
    private static final int UNKNOWN_MENU_LANGUAGE;
    public static final String LSC_TRACE_LITERAL;
    public static final int EV_NOTIFY_LSC_THAT_NAV_IS_READY2;
    public static final int EV_LSC_IS_ALLOWED_IN_STD_NOW2;
    public static final int EV_LSC_DELAYED_ERROR_POPUP;
    private static final int CAR_BRAND_INVALID;
    private static final int LANG_ERROR_LIST__INDEX_0_GUI;
    private static final int LANG_ERROR_LIST__INDEX_1_NAV_MAP;
    private static final int LANG_ERROR_LIST__INDEX_2_NAV_ANNOUNCEMENTS;
    private static final int LANG_ERROR_LIST__INDEX_3_SPEECH;
    private static final int NO_LANGUAGE_CHANGE_REQUESTED;
    public static int codedCarBrand;
    private final boolean isPqVariantDetected = System.getProperty("de.vw.mib.asl.framework.internal.lsc.isPQVariant") != null;
    private final boolean[] languagesThatWereSetBefore = new boolean[LanguageHelper.getNumberOfLanguages()];
    private final IPersistableEarlyData persistableData = ASLStartupv7rFactory.getStartupv7rApi().getPersistableEarlyData();
    private PersistableLsc persistableLsc = PersistableLsc.getInstance();
    private AutomaticLanguageModeInstaller lscAutomaticMode;
    private DelegatingLscController lscControllerReference = new DelegatingLscController(this.getTextLogger());
    private InitialLscTrigger initialLscTrigger;
    private int currentRemovedSpellerLanguageIndex = -1;
    private boolean languageChangeByUserRequestIsPending;
    private boolean skinChangePending = false;
    private final SkinIdSelector skinIdSelector;
    private boolean suppressErrorPopup = false;
    private int lastRequestedLanguageByPq = -1;
    private String lastSetLanguage = "";
    ConfigurationManagerDiag configManagerDiag = ServiceManager.configManagerDiag;
    private LacListenerRegistry lacListenerRegistry;
    private ASLSystemAPI systemApi = ASLSystemFactory.getSystemApi();
    private SpellerLanguageManager spellerLanguage;
    private boolean visibleLanguageDataReceived;
    private ASLLscAPIImpl lscApi = (ASLLscAPIImpl)ASLLscFactory.getLscApi();
    private final LscAdapter contentChanger = new LscAdapter(this.getEventDispatcher(), this.getEventFactory(), this.getTextLogger());
    private LanguageDiagnosisHandler diagLanguageUpdater;
    private LscServices services;
    private FactoryResetCallback callback;
    private final LscValidator lscValidator = new LscValidator();
    private final LscModel lscModel = new LscModel();
    private DiagnosisHandler diagnosisHandler;
    private BrandHandler brandHandler;
    static boolean initialLscWasSent;
    static /* synthetic */ Class class$de$vw$mib$lsctng$AslLscBullhorn;
    static /* synthetic */ Class class$de$vw$mib$asl$api$speechengine$SpeechEngine;
    static /* synthetic */ Class class$de$vw$mib$lsctng$LscController;

    public AslTargetLscTNGBullhorn(GenericEvents genericEvents, int n, String string) {
        super(genericEvents, n, string);
        this.lacListenerRegistry = new LacListenerRegistry(this.lscControllerReference, this.getTextLogger());
        this.spellerLanguage = new SpellerLanguageManager(ServiceManager.aslPropertyManager);
        this.skinIdSelector = new SkinIdSelector(ServiceManager.listManager, this.configManagerDiag);
    }

    public AslTargetLscTNGBullhorn(GenericEvents genericEvents, String string) {
        super(genericEvents, string);
        this.lacListenerRegistry = new LacListenerRegistry(this.lscControllerReference, this.getTextLogger());
        this.spellerLanguage = new SpellerLanguageManager(ServiceManager.aslPropertyManager);
        this.skinIdSelector = new SkinIdSelector(ServiceManager.listManager, this.configManagerDiag);
    }

    @Override
    public int getClassifier() {
        return 1024;
    }

    @Override
    public int getSubClassifier() {
        return 64;
    }

    @Override
    public int getDefaultTargetId() {
        return 5150;
    }

    @Override
    public void gotEvent(EventGeneric eventGeneric) {
        switch (eventGeneric.getReceiverEventId()) {
            case 8: {
                break;
            }
            case 106: {
                this.processAslEventPowerOn();
                break;
            }
            case 100127: {
                ServiceManager.eventDispatcher.createAndSubmitHMIEvent(528);
                break;
            }
            case 1073743190: {
                this.processHmiSetterSystemSkinLayout(eventGeneric);
                break;
            }
            case 4300038: {
                this.processDayNightMode(eventGeneric);
                break;
            }
            case 1075841837: {
                this.processHmiSetterSystemMenuLanguage(eventGeneric);
                break;
            }
            case 1073743154: {
                this.processHmiSetterSystemAdditionalSpellerLanguage(eventGeneric);
                break;
            }
            case 1073743214: {
                this.processHmiSetterSystemToggleAdditionalSpellerLanguage();
                break;
            }
            case 100126: {
                this.processLscIsAllowedInStdNow();
                break;
            }
            case 40000: {
                this.addAslListenerAndRequestInitialLanguageAgain(eventGeneric.getInt(0), eventGeneric.getInt(1), eventGeneric.getString(2), -2, -2);
                break;
            }
            case 40001: {
                this.addAslListenerAndRequestInitialLanguageAgain(eventGeneric.getInt(0), eventGeneric.getInt(1), eventGeneric.getString(2), -2, eventGeneric.getInt(3));
                break;
            }
            case 40009: {
                this.addAslListenerAndRequestInitialLanguageAgain(eventGeneric.getInt(0), eventGeneric.getInt(1), eventGeneric.getString(2), -1, -2);
                break;
            }
            case 40002: {
                this.removeAslListener(eventGeneric.getInt(0), eventGeneric.getInt(1));
                break;
            }
            case 40004: 
            case 40006: 
            case 40008: {
                this.contentChanger.handleChangeResult(eventGeneric);
                break;
            }
            case 1600001: {
                this.processInstrumentClusterPQMessageChangeLanguage(eventGeneric.getInt(0));
                break;
            }
            default: {
                this.error().append("Event could not be handled in LSCBullhorn!: ").append(eventGeneric).log();
            }
        }
    }

    public void helperMethodFillLanguagesForLACsAndGuiIntoList(IntObjectMap intObjectMap) {
        Object[] objectArray = new String[4];
        objectArray[0] = this.configManagerDiag.getCurrentGuiLanguage();
        String string = this.configManagerDiag.getCurrentGuiLanguage();
        string = string.equals("NO_LANGUAGE") ? "" : string;
        objectArray[1] = "";
        String string2 = "";
        objectArray[2] = "";
        String string3 = "";
        objectArray[3] = "";
        String string4 = "";
        IntIterator intIterator = intObjectMap.keySet().iterator();
        while (intIterator.hasNext()) {
            int n = intIterator.next();
            int n2 = ListenerTools.extractListenerType(n);
            switch (n2) {
                case 6: {
                    string2 = (String)intObjectMap.get(n);
                    string2 = string2.equals("NO_LANGUAGE") ? "" : string2;
                    objectArray[1] = string2.equals("NO_LANGUAGE") ? "" : string2;
                    break;
                }
                case 5: {
                    string4 = (String)intObjectMap.get(n);
                    String string5 = string4 = string4.equals("NO_LANGUAGE") ? "" : string4;
                    if (!this.configManagerDiag.isFeatureFlagSet(367)) {
                        if (!((String)objectArray[3]).equals("") && !((String)objectArray[3]).equals(string4)) break;
                        objectArray[3] = string4.equals("NO_LANGUAGE") ? "" : string4;
                        break;
                    }
                    objectArray[3] = string4.equals("NO_LANGUAGE") ? "" : string4;
                    break;
                }
                case 4: {
                    string3 = (String)intObjectMap.get(n);
                    String string6 = string3 = string3.equals("NO_LANGUAGE") ? "" : string3;
                    if (this.configManagerDiag.isFeatureFlagSet(367)) {
                        objectArray[2] = string3.equals("NO_LANGUAGE") ? "" : string3;
                        break;
                    }
                    objectArray[3] = string3.equals("NO_LANGUAGE") ? "" : string3;
                    break;
                }
            }
        }
        ListManager.getGenericASLList(3616).updateList(objectArray);
        if (!this.configManagerDiag.isFeatureFlagSet(367) && string4.equals(string) && !string3.equals(string4)) {
            string4 = string3;
        }
        this.systemApi.updateSystemCurrentLanguageConfiguration(0, string, string2, string3, string4);
    }

    @Override
    public void onNewLanguage(LanguageChanger languageChanger, int n, int n2, String string) {
        this.contentChanger.onNewLanguage(languageChanger, n, n2, string);
    }

    @Override
    public void onNewSkin(SkinChanger skinChanger, int n, int n2, int n3) {
        this.contentChanger.onNewSkin(skinChanger, n, n2, n3);
    }

    @Override
    public void onNewSkinmode(SkinmodeChanger skinmodeChanger, int n, int n2, int n3) {
        this.contentChanger.onNewSkinmode(skinmodeChanger, n, n2, n3);
    }

    @Override
    public void startOfLsc() {
        if (this.isTraceEnabled()) {
            this.trace().append("[AslTargetLscTNGBullhorn]").append(" Received startOfLsc()").log();
        }
        LanguageHelper.generalLanguageSkinChangeIsPending = true;
        if (!this.skinChangePending && this.languageChangeByUserRequestIsPending) {
            ServiceManager.eventDispatcher.createAndSubmitHMIEvent(379);
        }
    }

    @Override
    public void endOfLsc(IntObjectMap intObjectMap) {
        int n;
        if (this.isTraceEnabled()) {
            this.trace().append("[AslTargetLscTNGBullhorn]").append(" Received endOfLsc()").log();
        }
        this.skinChangePending = false;
        LanguageHelper.initialGuiLscDoneSoCorrectLanguageIsSetInGui = true;
        ServiceManager.aslPropertyManager.valueChangedInteger(1589, this.skinIdSelector.getActiveSkinNameIndex(this.persistableData.getLastActiveSkin(), this.configManagerDiag.getCurrentGuiLanguage()));
        if (codedCarBrand != -1) {
            int n2 = this.configManagerDiag.getSkinBrand(this.persistableData.getLastActiveSkin());
            if (n2 != codedCarBrand) {
                this.warn("********************************************");
                this.warn("CURRENT SKIN DOES NOT BELONG TO CODED BRAND");
                this.warn("TEXTUAL AND/OR PICTURE ERRORS MAY OCCUR");
                this.warn("********************************************");
            }
            this.brandHandler.updateBrand(n2);
            this.triggerObserver(949829888, null);
        }
        String[] stringArray = this.getAvailableLanguages();
        String string = this.configManagerDiag.getCurrentGuiLanguage();
        for (n = 0; n < stringArray.length; ++n) {
            if (!stringArray[n].equals(string)) continue;
            ServiceManager.aslPropertyManager.valueChangedInteger(1586, n);
        }
        ServiceManager.aslPropertyManager.valueChangedString(2219, LanguageHelper.getIsoCodeOfLanguageIndex(this.persistableData.getLastActiveLanguagePrefetch()));
        ServiceManager.aslPropertyManager.valueChangedString(1630, this.configManagerDiag.getSpfName());
        this.persistableData.setLastActiveLanguagePrefetch(LanguageHelper.getLanguageIndexOfIsoCode(this.configManagerDiag.getCurrentGuiLanguage()));
        this.persistableLsc.setPersistantLanguage(this.configManagerDiag.getCurrentGuiLanguage());
        n = LanguageHelper.getMenuLanguage(this.configManagerDiag.getCurrentGuiLanguage());
        this.languagesThatWereSetBefore[n] = true;
        this.updateLanguageAndSpellerList();
        this.writeLanguageDataToPersistableObject();
        ServiceManager.eventDispatcher.createAndSubmitHMIEvent(410);
        ServiceManager.eventDispatcher.createAndSubmitHMIEvent(409);
        ServiceManager.eventDispatcher.createAndSubmitHMIEvent(408);
        this.helperMethodFillLanguagesForLACsAndGuiIntoList(intObjectMap);
        if (this.lastSetLanguage.equals(this.configManagerDiag.getCurrentGuiLanguage()) || this.helperMethodEvaluateIfLanguageChangeWasSuccessful(intObjectMap)) {
            this.info("All ok");
        } else {
            this.error("One Lang error");
            if (!this.suppressErrorPopup) {
                this.startTimer(528941312, (long)0, false);
            }
            this.suppressErrorPopup = false;
        }
        LanguageHelper.generalLanguageSkinChangeIsPending = false;
        ServiceManager.eventMain.getServiceRegister().triggerObserver(6952960);
        if (this.lastRequestedLanguageByPq != -1) {
            this.processInstrumentClusterPQMessageChangeLanguage(this.lastRequestedLanguageByPq);
            this.lastRequestedLanguageByPq = -1;
        }
        this.lastSetLanguage = this.configManagerDiag.getCurrentGuiLanguage();
        this.languageChangeByUserRequestIsPending = false;
        if (this.callback != null) {
            this.callback.notifyResetDone();
            this.callback = null;
        }
    }

    @Override
    public void trace(String string) {
        if (this.isTraceEnabled()) {
            this.trace().append("[AslTargetLscTNGBullhorn]").append(string).log();
        }
    }

    @Override
    public void guiAvailableForViews() {
    }

    @Override
    public void speechAvailable() {
    }

    public void injectDelegatingLscController(LscController lscController) {
        this.lscControllerReference.setDelegate(lscController);
    }

    public void injectSystemApi(ASLSystemAPI aSLSystemAPI) {
        this.systemApi = aSLSystemAPI;
    }

    public void injectAslLscApi(ASLLscAPIImpl aSLLscAPIImpl) {
        this.lscApi = aSLLscAPIImpl;
    }

    public void injectSpellerManager(SpellerLanguageManager spellerLanguageManager) {
        this.spellerLanguage = spellerLanguageManager;
    }

    public void changeLanguage(String string) {
        this.lastRequestedLanguageByPq = -1;
        if (this.lscControllerReference.isInitialized()) {
            this.lscModel.setLastRequestedLanguage(string);
            this.languageChangeByUserRequestIsPending = true;
            this.suppressErrorPopup = false;
            this.info().append("[AslTargetLscTNGBullhorn]").append("Persisting language data for Instrument Cluster").log();
            this.persistableData.setLastActiveLanguagePrefetch(LanguageHelper.getLanguageIndexOfIsoCode(this.lscModel.getLastRequestedLanguage()));
            this.persistableLsc.setPersistantLanguage(this.lscModel.getLastRequestedLanguage());
            this.lscControllerReference.changeTo(this.lscModel.getLastRequestedLanguage(), this.persistableData.getLastActiveSkin(), this.persistableData.getEffectiveSkinMode());
            this.spellerLanguage.toggleSpellerLanguage(this.lscModel.getLastRequestedLanguage());
        }
    }

    void injectConfigManagerDiag(ConfigurationManagerDiag configurationManagerDiag) {
        this.configManagerDiag = configurationManagerDiag;
    }

    void injectPersistableLsc(PersistableLsc persistableLsc) {
        this.persistableLsc = persistableLsc;
    }

    void processHmiSetterSystemResetSystemSettings() {
        if (!this.lscValidator.isInvalidSkinIdInPersistableData(this.persistableData.getLastPersistedCodedSkin())) {
            this.persistableData.setSkinValues(this.persistableData.getLastPersistedCodedSkin(), -2);
        }
        if (this.isPqVariantDetected) {
            this.lscAutomaticMode.activateAutomaticLanguageMode(true);
        } else {
            this.defaultLanguageFromDiag();
        }
    }

    void updateLanguageAndSpellerList() {
        if (!this.visibleLanguageDataReceived) {
            return;
        }
        String string = this.persistableLsc.getPersistantLanguage();
        int n = LanguageHelper.getMenuLanguage(string, -1);
        if (n == -1) {
            return;
        }
        Object[] objectArray = this.getAvailableLanguages();
        this.spellerLanguage.setVariantLanguages((String[])objectArray);
        this.spellerLanguage.updateAdditionalSpellerLanguages(this.languagesThatWereSetBefore, string);
        this.systemApi.languageDataStart();
        int n2 = 0;
        ListManager.getGenericASLList(2353).updateList(objectArray);
        for (int i2 = 0; i2 < objectArray.length; ++i2) {
            Object object = objectArray[i2];
            if (n2 == objectArray.length - 1) {
                if (!string.equals(object)) break;
                this.currentRemovedSpellerLanguageIndex = i2;
                break;
            }
            if (!string.equals(object)) {
                int n3 = LanguageHelper.getMenuLanguage((String)object);
                boolean bl = this.languagesThatWereSetBefore[n3];
                this.systemApi.languageDataAdd((String)object, bl);
                ++n2;
                continue;
            }
            this.currentRemovedSpellerLanguageIndex = i2;
        }
        this.systemApi.languageDataEnd();
        this.spellerLanguage.updateSpellerProperties();
        this.spellerLanguage.updateDatapoolCurrentSpellerLanguage(string);
    }

    void doInitialLsc() {
        initialLscWasSent = true;
        this.lscModel.setLastRequestedLanguage(LanguageHelper.getIsoCodeOfLanguageIndex(this.persistableData.getLastActiveLanguagePrefetch()));
        this.diagnosisHandler.performDtcCheck();
        this.info().append("[AslTargetLscTNGBullhorn]").append("Persisting language data for Instrument Cluster").log();
        LanguageHelper.generalLanguageSkinChangeIsPending = true;
        this.lscControllerReference.initialChangeTo(this.lscModel.getLastRequestedLanguage(), this.persistableData.getLastActiveSkin(), this.persistableData.getEffectiveSkinMode());
    }

    void readLanguageDataFromPersistableObject() {
        long l = this.systemApi.getSharedSystemCommonPersistence().getBitfieldLanguagesThatWereSetBefore();
        for (int i2 = 0; i2 < this.languagesThatWereSetBefore.length; ++i2) {
            this.languagesThatWereSetBefore[i2] = AslTargetLscTNGBullhorn.getBitValue(l, i2);
        }
    }

    void writeLanguageDataToPersistableObject() {
        long l = 0L;
        for (int i2 = 0; i2 < this.languagesThatWereSetBefore.length; ++i2) {
            if (!this.languagesThatWereSetBefore[i2]) continue;
            l = AslTargetLscTNGBullhorn.setBitToHigh(l, i2);
        }
        this.systemApi.getSharedSystemCommonPersistence().setBitfieldLanguagesThatWereSetBefore(l);
    }

    void resetAndWriteLanguageDataToPersistableObject() {
        Arrays.fill(this.languagesThatWereSetBefore, false);
        this.writeLanguageDataToPersistableObject();
    }

    private void processLscIsAllowedInStdNow() {
        this.trace("Lsc is allowed for target STD.");
        this.initialLscTrigger.markLscIsAllowedInSTD();
    }

    private void processInstrumentClusterPQMessageChangeLanguage(int n) {
        this.lastRequestedLanguageByPq = n;
        if (this.lscControllerReference.isInitialized() && !LanguageHelper.generalLanguageSkinChangeIsPending) {
            String string = LanguageHelper.getIsoCodeOfMenuLanguage(this.lastRequestedLanguageByPq);
            if (!string.equals(this.lscModel.getLastRequestedLanguage())) {
                this.lscModel.setLastRequestedLanguage(string);
                this.suppressErrorPopup = false;
                this.info().append("[AslTargetLscTNGBullhorn]").append("Persisting language data coming from instrument cluster").log();
                this.persistableData.setLastActiveLanguagePrefetch(LanguageHelper.getLanguageIndexOfIsoCode(this.lscModel.getLastRequestedLanguage()));
                this.persistableLsc.setPersistantLanguage(this.lscModel.getLastRequestedLanguage());
                this.lscControllerReference.changeTo(this.lscModel.getLastRequestedLanguage(), this.persistableData.getLastActiveSkin(), this.persistableData.getEffectiveSkinMode());
            } else {
                this.info().append("[AslTargetLscTNGBullhorn]").append("Language requested by IC is already set, skipping...").log();
            }
        }
    }

    private void processAslEventPowerOn() {
        this.trace("LSCTNGBullhorn started!");
        this.services = LscServicesProvider.getLscServices();
        Object object = this.services.getAsyncServiceFactory().create(this, new Class[]{class$de$vw$mib$lsctng$AslLscBullhorn == null ? (class$de$vw$mib$lsctng$AslLscBullhorn = AslTargetLscTNGBullhorn.class$("de.vw.mib.lsctng.AslLscBullhorn")) : class$de$vw$mib$lsctng$AslLscBullhorn});
        this.services.getBundleContext().registerService((class$de$vw$mib$lsctng$AslLscBullhorn == null ? (class$de$vw$mib$lsctng$AslLscBullhorn = AslTargetLscTNGBullhorn.class$("de.vw.mib.lsctng.AslLscBullhorn")) : class$de$vw$mib$lsctng$AslLscBullhorn).getName(), object, null);
        this.brandHandler = new BrandHandler(this.services);
        boolean bl = !ASLStartupv7rFactory.getStartupv7rApi().isHighActivatorStarted();
        this.diagLanguageUpdater = new LanguageDiagnosisHandler(this.services);
        this.diagLanguageUpdater.setListener(this.onDiagLanguagesUpdated());
        this.initialLscTrigger = new InitialLscTrigger(bl, new AslTargetLscTNGBullhorn$1(this));
        this.diagnosisHandler = new DiagnosisHandler(this.services, this.persistableData, this.lscApi, this.initialLscTrigger, this.lscModel, this.lscControllerReference);
        this.registerService(1134297088, false);
        this.registerService(1201405952, false);
        this.registerService(1167851520, false);
        this.registerService(1083965440, true);
        this.registerService(1234960384, true);
        this.registerService(1100742656, true);
        this.registerService(1151074304, true);
        this.registerService(1218183168, true);
        this.registerService(1184628736, true);
        this.registerService(1117519872, true);
        ServiceManager.aslPropertyManager.valueChangedBoolean(875700224, this.isPqVariantDetected);
        this.diagnosisHandler.validatePersistedSkin();
        this.acquireLscControllerService();
        this.acquireVoiceService();
        this.addObserver(-140754688);
        this.addObserver(110969088);
        this.addObserver(23730176);
        ServiceManager.persistence.registerSharedPersistable(this.persistableLsc);
        boolean bl2 = ServiceManager.persistence.loadPersistable(1101, 0, this.persistableLsc);
        if (!bl2) {
            this.diagnosisHandler.setUseDiagnosisDataAsInitialLanguage(true);
            this.info().append("[AslTargetLscTNGBullhorn]").append("No LSC Persistable Data (NS1101KEY10) could be loaded. Using Diagnosis values instead!").log();
        } else {
            this.trace("Data from Persistable");
            byte[] byArray = this.persistableLsc.getData();
            if (this.isTraceEnabled()) {
                StringBuffer stringBuffer = new StringBuffer();
                for (int i2 = 0; i2 < byArray.length; ++i2) {
                    stringBuffer.append(byArray[i2]).append(" ");
                }
                this.trace(stringBuffer.toString());
            }
            this.info().append("[AslTargetLscTNGBullhorn]").append("Get default language from NS(1101) KEY(10):").append(this.persistableLsc.getPersistantLanguage()).log();
            if (this.persistableLsc.containsValidLscData()) {
                this.persistableData.setLastActiveLanguagePrefetch(LanguageHelper.getLanguageIndexOfIsoCode(this.persistableLsc.getPersistantLanguage()));
            } else {
                this.diagnosisHandler.setUseDiagnosisDataAsInitialLanguage(true);
                this.info().append("[AslTargetLscTNGBullhorn]").append("NS 1101 KEY 10 contained no valid data. Using Diagnostic values instead!").log();
            }
        }
        this.lscAutomaticMode = this.services.getAutomaticLanguageModeInstaller();
        this.readLanguageDataFromPersistableObject();
        this.installProfileChangeListener();
        this.registerFactoryResetParticipant();
        new LanguageChangeServiceImpl(this, this.services);
    }

    private void acquireVoiceService() {
        OsgiServices.acquireService(ServiceManager.bundleContext, class$de$vw$mib$asl$api$speechengine$SpeechEngine == null ? (class$de$vw$mib$asl$api$speechengine$SpeechEngine = AslTargetLscTNGBullhorn.class$("de.vw.mib.asl.api.speechengine.SpeechEngine")) : class$de$vw$mib$asl$api$speechengine$SpeechEngine, new AslTargetLscTNGBullhorn$2(this));
    }

    private void acquireLscControllerService() {
        OsgiServices.acquireService(ServiceManager.bundleContext, class$de$vw$mib$lsctng$LscController == null ? (class$de$vw$mib$lsctng$LscController = AslTargetLscTNGBullhorn.class$("de.vw.mib.lsctng.LscController")) : class$de$vw$mib$lsctng$LscController, new AslTargetLscTNGBullhorn$3(this));
    }

    private void defaultLanguageFromDiag() {
        String string = this.diagnosisHandler.getSystemDefaultLanguage();
        if ("".equals(string)) {
            string = "en_GB";
        }
        this.lscModel.setLastRequestedLanguage(string);
        if (this.isTraceEnabled()) {
            this.trace().append("[AslTargetLscTNGBullhorn]").append("Change Skin Layout to:").append(this.lscModel.getLastRequestedLanguage()).append("/").append(this.persistableData.getLastActiveSkin()).append("/").append(this.persistableData.getEffectiveSkinMode()).log();
        }
        this.lscControllerReference.changeTo(this.lscModel.getLastRequestedLanguage(), this.persistableData.getLastActiveSkin(), this.persistableData.getEffectiveSkinMode());
    }

    private DiagLanguageUpdateListener onDiagLanguagesUpdated() {
        return new AslTargetLscTNGBullhorn$4(this);
    }

    private void addAslListenerAndRequestInitialLanguageAgain(int n, int n2, String string, int n3, int n4) {
        boolean bl;
        boolean bl2 = this.lacListenerRegistry.addAslListener(n, n2, string, n3, n4);
        boolean bl3 = bl = bl2 && !this.languageChangeByUserRequestIsPending;
        if (bl) {
            this.suppressErrorPopup = true;
        }
    }

    private void removeAslListener(int n, int n2) {
        this.lacListenerRegistry.removeAslListener(n, n2);
    }

    private void processHmiSetterSystemMenuLanguage(EventGeneric eventGeneric) {
        this.info("LangChange by User was triggered, starting LSC");
        String string = this.retrieveLanguageFromEvent(eventGeneric);
        this.changeLanguage(string);
    }

    private String retrieveLanguageFromEvent(EventGeneric eventGeneric) {
        String[] stringArray;
        String string = "en_GB";
        int n = eventGeneric.getInt(0);
        if (n < (stringArray = this.getAvailableLanguages()).length) {
            string = stringArray[n];
        } else {
            this.error().append("[AslTargetLscTNGBullhorn]").append("Language list index selected was greater than actual list!").log();
        }
        return string;
    }

    String[] getAvailableLanguages() {
        return this.configManagerDiag.getAvailableLanguages();
    }

    private void processHmiSetterSystemSkinLayout(EventGeneric eventGeneric) {
        this.info("Skinchange was triggered, starting LSC");
        if (this.lscControllerReference.isInitialized()) {
            this.skinChangePending = true;
            int n = eventGeneric.getInt(0);
            int n2 = this.skinIdSelector.findSkinIdFromSkinNameIndex(n);
            if (n2 != -1) {
                this.persistableData.setSkinValues(n2, -2);
                if (this.isTraceEnabled()) {
                    this.trace().append("[AslTargetLscTNGBullhorn]").append("Change Skin Layout to:").append(this.lscModel.getLastRequestedLanguage()).append("/").append(this.persistableData.getLastActiveSkin()).append("/").append(this.persistableData.getEffectiveSkinMode()).log();
                }
                int n3 = this.skinIdSelector.findNewDefaultSkinId(this.persistableData.getLastActiveSkin());
                this.configManagerDiag.setDefaultSkinId(n3);
                this.lscControllerReference.changeTo(this.lscModel.getLastRequestedLanguage(), this.persistableData.getLastActiveSkin(), this.persistableData.getEffectiveSkinMode());
            } else {
                this.warn(new StringBuffer().append("Incoming skin name index ").append(n).append(" has no associated skin id!").toString());
            }
        }
    }

    private void processDayNightMode(EventGeneric eventGeneric) {
        this.info("DayNightMode was triggered, starting LSC");
        if (this.lscControllerReference.isInitialized()) {
            this.skinChangePending = true;
            boolean bl = eventGeneric.getBoolean(0);
            int n = bl ? 1 : 0;
            this.persistableData.setEffectiveSkinMode(n);
            if (!this.lscModel.getLastRequestedLanguage().equals("")) {
                this.lscControllerReference.changeTo(this.lscModel.getLastRequestedLanguage(), this.persistableData.getLastActiveSkin(), n);
            }
        }
    }

    private void processHmiSetterSystemToggleAdditionalSpellerLanguage() {
        String string = this.configManagerDiag.getCurrentGuiLanguage();
        this.spellerLanguage.toggleSpellerLanguage(string);
    }

    private void processHmiSetterSystemAdditionalSpellerLanguage(EventGeneric eventGeneric) {
        int n;
        int n2 = eventGeneric.getInt(0);
        if (n2 >= this.currentRemovedSpellerLanguageIndex) {
            ++n2;
        }
        boolean bl = !this.languagesThatWereSetBefore[n = LanguageHelper.getMenuLanguage(this.getAvailableLanguages()[n2])];
        this.languagesThatWereSetBefore[n] = bl;
        this.writeLanguageDataToPersistableObject();
        this.updateLanguageAndSpellerList();
    }

    private String helperMethodResolveListenerTypeForTrace(int n) {
        switch (n) {
            case 9: {
                return "ADDRESSBOOK";
            }
            case 2: {
                return "CONFIG_MANAGER";
            }
            case 1: {
                return "GUI";
            }
            case 10: {
                return "INSTRUMENTCLUSTER";
            }
            case 6: {
                return "NAV_GUI";
            }
            case 7: {
                return "NAV_TTS";
            }
            case 8: {
                return "PHONE";
            }
            case 5: {
                return "SPEECH_SDS";
            }
            case 4: {
                return "SPEECH_TTS";
            }
            case 3: {
                return "WIDGETS";
            }
        }
        return "UNKNOWN";
    }

    private boolean helperMethodEvaluateIfLanguageChangeWasSuccessful(IntObjectMap intObjectMap) {
        int n;
        boolean bl = true;
        IntIterator intIterator = intObjectMap.keySet().iterator();
        String string = "";
        this.info().append("last known requested Language: ").append(this.lscModel.getLastRequestedLanguage()).log();
        while (intIterator.hasNext()) {
            int n2 = intIterator.next();
            n = ListenerTools.extractListenerType(n2);
            string = (String)intObjectMap.get(n2);
            this.info().append(string).append("/").append(n2 & 0xFFFFFF03).append("[").append(this.helperMethodResolveListenerTypeForTrace(n)).append("]").log();
            if (!this.isInterestedInLanguageUpdates(string) || string.equals(this.lscModel.getLastRequestedLanguage()) || n != 6 && n != 5 && n != 4) continue;
            this.warn().append("check failed for: ").append(n2 & 0xFFFFFF03).log();
            bl = false;
        }
        if (!bl && this.lastRequestedLanguageByPq != -1) {
            this.info().append("Basic check was inconclusive, checking for last knwon PQ language").log();
            String string2 = LanguageHelper.getIsoCodeOfMenuLanguage(this.lastRequestedLanguageByPq);
            while (intIterator.hasNext()) {
                n = intIterator.next();
                int n3 = ListenerTools.extractListenerType(n);
                string = (String)intObjectMap.get(n);
                this.info().append(string).append("/").append(n & 0xFFFFFF03).append("[").append(this.helperMethodResolveListenerTypeForTrace(n3)).append("]").log();
                if (!this.isInterestedInLanguageUpdates(string) || string.equals(string2) || n3 != 6 && n3 != 5 && n3 != 4) continue;
                this.warn().append("check failed for: ").append(n & 0xFFFFFF03).log();
                bl = false;
            }
        }
        this.info().append(this.configManagerDiag.getCurrentGuiLanguage()).append("/ GUI").log();
        if (!this.configManagerDiag.getCurrentGuiLanguage().equals(this.lscModel.getLastRequestedLanguage())) {
            this.warn().append("current GUI language is not equal to last requested (").append(this.lscModel.getLastRequestedLanguage()).append(")").log();
            bl = false;
        }
        return bl;
    }

    private boolean isInterestedInLanguageUpdates(String string) {
        return !"NOT_INTERESTED".equals(string);
    }

    private void installProfileChangeListener() {
        this.systemApi.getSharedSystemCommonPersistence().addProfileChangeListener(new AslTargetLscTNGBullhorn$5(this));
    }

    private static long setBitToHigh(long l, int n) {
        long l2 = 1L << n;
        return l | l2;
    }

    private static boolean getBitValue(long l, int n) {
        return (l >> n & 1L) == 1L;
    }

    private void registerFactoryResetParticipant() {
        FactoryResetService factoryResetService = this.services.getFactoryResetService();
        factoryResetService.addParticipant(this.createSystemResetParticipant(), FactoryResetComponents.SYSTEM);
        factoryResetService.addParticipant(this.createAdditionalSpellerLanguagesParticipant(), ADDITIONAL_SPELLER_LANGUAGES_COMPONENT);
    }

    private AbstractFactoryResetParticipant createAdditionalSpellerLanguagesParticipant() {
        return new AslTargetLscTNGBullhorn$6(this);
    }

    private AbstractFactoryResetParticipant createSystemResetParticipant() {
        return new AslTargetLscTNGBullhorn$7(this);
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }

    static /* synthetic */ LscServices access$000(AslTargetLscTNGBullhorn aslTargetLscTNGBullhorn) {
        return aslTargetLscTNGBullhorn.services;
    }

    static /* synthetic */ InitialLscTrigger access$100(AslTargetLscTNGBullhorn aslTargetLscTNGBullhorn) {
        return aslTargetLscTNGBullhorn.initialLscTrigger;
    }

    static /* synthetic */ boolean access$202(AslTargetLscTNGBullhorn aslTargetLscTNGBullhorn, boolean bl) {
        aslTargetLscTNGBullhorn.visibleLanguageDataReceived = bl;
        return aslTargetLscTNGBullhorn.visibleLanguageDataReceived;
    }

    static /* synthetic */ FactoryResetCallback access$302(AslTargetLscTNGBullhorn aslTargetLscTNGBullhorn, FactoryResetCallback factoryResetCallback) {
        aslTargetLscTNGBullhorn.callback = factoryResetCallback;
        return aslTargetLscTNGBullhorn.callback;
    }

    static {
        codedCarBrand = -1;
        initialLscWasSent = false;
    }
}

