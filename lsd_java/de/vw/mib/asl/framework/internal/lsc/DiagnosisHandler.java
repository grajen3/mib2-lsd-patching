/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.lsc;

import de.vw.mib.asl.framework.api.diagnosis.AdaptionApi;
import de.vw.mib.asl.framework.api.diagnosis.config.Coding;
import de.vw.mib.asl.framework.api.diagnosis.config.LoadFurtherData;
import de.vw.mib.asl.framework.api.persistence.AslPersistenceSyncApi;
import de.vw.mib.asl.framework.api.persistence.IPersistableEarlyData;
import de.vw.mib.asl.framework.internal.impl.lsc.InitialLscTrigger;
import de.vw.mib.asl.framework.internal.impl.lsc.LscLogger;
import de.vw.mib.asl.framework.internal.lsc.AslTargetLscTNGBullhorn;
import de.vw.mib.asl.framework.internal.lsc.DiagnosisHandler$1;
import de.vw.mib.asl.framework.internal.lsc.DiagnosisHandler$2;
import de.vw.mib.asl.framework.internal.lsc.LanguageHelper;
import de.vw.mib.asl.framework.internal.lsc.LscModel;
import de.vw.mib.asl.framework.internal.lsc.LscServices;
import de.vw.mib.asl.framework.internal.lsc.LscValidator;
import de.vw.mib.asl.framework.internal.lsc.api.impl.ASLLscAPIImpl;
import de.vw.mib.configuration.ConfigurationManagerDiag;
import de.vw.mib.lsctng.LscController;

public class DiagnosisHandler {
    private static final String LOG_PREFIX;
    private static final int SKIN_CODING_INVALID;
    private final LscValidator lscValidator = new LscValidator();
    private final ASLLscAPIImpl lscApi;
    private final InitialLscTrigger initialLscTrigger;
    private final LscModel lscModel;
    private final LscLogger logger;
    private final ConfigurationManagerDiag configManager;
    private final IPersistableEarlyData persistableData;
    private final AslPersistenceSyncApi persistenceSyncApi;
    private final LscController lscController;
    private boolean lastActiveSkinWasInvalid = false;
    private String systemDefaultLanguage = "";
    private boolean useDiagnosisDataAsInitialLanguage;
    private AdaptionApi adaptionApi;

    public DiagnosisHandler(LscServices lscServices, IPersistableEarlyData iPersistableEarlyData, ASLLscAPIImpl aSLLscAPIImpl, InitialLscTrigger initialLscTrigger, LscModel lscModel, LscController lscController) {
        this.persistableData = iPersistableEarlyData;
        this.lscApi = aSLLscAPIImpl;
        this.initialLscTrigger = initialLscTrigger;
        this.lscModel = lscModel;
        this.lscController = lscController;
        this.logger = lscServices.getLscLogger();
        this.configManager = lscServices.getConfigManagerDiag();
        this.persistenceSyncApi = lscServices.getPersistenceSyncApi();
        this.adaptionApi = lscServices.getAdaptionApi();
        this.adaptionApi.requestCoding(new DiagnosisHandler$1(this));
        this.adaptionApi.requestLoadFurtherData(new DiagnosisHandler$2(this));
    }

    public String getSystemDefaultLanguage() {
        return this.systemDefaultLanguage;
    }

    public void validatePersistedSkin() {
        if (this.lscValidator.isInvalidSkinIdInPersistableData(this.persistableData.getLastActiveSkin())) {
            this.info("Persistent last Skin Id was corrupt or not set, setting value to default Skin Id");
            this.lastActiveSkinWasInvalid = true;
            this.persistableData.setSkinValues(this.configManager.getDefaultSkinId(), -2);
        }
        if (this.lscValidator.isInvalidLanguageInPersistableData(this.persistableData.getLastActiveLanguagePrefetch())) {
            this.info("Persistent last Language Id was corrupt or not set, setting value to Language in NS 1101 KEY 10");
        }
    }

    public void performDtcCheck() {
        String[] stringArray = this.configManager.getAvailableLanguages();
        boolean bl = false;
        boolean bl2 = false;
        for (int i2 = 0; i2 < stringArray.length; ++i2) {
            if (this.lscModel.getLastRequestedLanguage().equals(stringArray[i2])) {
                bl = true;
            }
            if (!this.getSystemDefaultLanguage().equals(stringArray[i2])) continue;
            bl2 = true;
        }
        if (!bl2) {
            this.warn("LSC Data in DS 1.04 was invalid, writing DTC, setting to first visble for now");
            this.persistenceSyncApi.writeBoolean(906042371, 0, true);
            this.systemDefaultLanguage = "en_GB";
        }
        if (!bl) {
            this.warn("LSC Data in NS 1101 Key 10 was invalid, trying default Language from DS 1.04 instead");
            this.lscModel.setLastRequestedLanguage(this.getSystemDefaultLanguage());
            this.persistableData.setLastActiveLanguagePrefetch(LanguageHelper.getMenuLanguage(this.getSystemDefaultLanguage()));
        }
    }

    public void setUseDiagnosisDataAsInitialLanguage(boolean bl) {
        this.useDiagnosisDataAsInitialLanguage = bl;
    }

    private void updateDefaultVoiceType(LoadFurtherData loadFurtherData) {
        int n = loadFurtherData.getValue(739);
        this.lscApi.setDefaultVoice(n);
    }

    private void processDiagDataCod(Coding coding) {
        this.trace("processDiagData: NamespaceCOD.CODING_ALL");
        int n = coding.getValue(77);
        boolean bl = false;
        if (n != 0) {
            this.configManager.setDefaultSkinId(n);
            if (this.persistableData.getLastPersistedCodedSkin() != 0) {
                if (this.persistableData.getLastPersistedCodedSkin() != n || this.lastActiveSkinWasInvalid) {
                    this.persistableData.setSkinValues(n, n);
                    bl = true;
                }
            } else {
                this.persistableData.setSkinValues(n, n);
                bl = true;
            }
            if (bl) {
                if (AslTargetLscTNGBullhorn.initialLscWasSent) {
                    this.info("Skin found in coding is different from Persistence, but initial LSC done, so queuing for change...");
                    this.lscController.changeTo(this.lscModel.getLastRequestedLanguage(), this.persistableData.getLastActiveSkin(), this.persistableData.getEffectiveSkinMode());
                } else if (!AslTargetLscTNGBullhorn.initialLscWasSent) {
                    this.info("Skin found in coding is different from Persistence, setting for initial LSC");
                }
            }
        }
    }

    private void processDiagDataUpdl(LoadFurtherData loadFurtherData) {
        this.trace("processDiagData: NamespaceUPDL.LOAD_FURTHER_DATA");
        this.updateDefaultVoiceType(loadFurtherData);
        this.systemDefaultLanguage = new String(loadFurtherData.getByteArray(738));
        this.initialLscTrigger.markSystemDefaultLanguageDataReceived();
        if (this.useDiagnosisDataAsInitialLanguage) {
            int n = LanguageHelper.getLanguageIndexOfIsoCode(this.systemDefaultLanguage);
            if (n == -1) {
                this.error("INVALID DIAGNOSIS VALUE FOR 1.04 SYSTEM LANGUAGE, FURTHER ERRORS MAY OCCUR");
            } else {
                this.persistableData.setLastActiveLanguagePrefetch(n);
            }
        }
    }

    private void trace(String string) {
        this.logger.trace(new StringBuffer().append("[DiagnosisHandler] ").append(string).toString());
    }

    private void info(String string) {
        this.logger.info(new StringBuffer().append("[DiagnosisHandler] ").append(string).toString());
    }

    private void warn(String string) {
        this.logger.warn(new StringBuffer().append("[DiagnosisHandler] ").append(string).toString());
    }

    private void error(String string) {
        this.logger.error(new StringBuffer().append("[DiagnosisHandler] ").append(string).toString());
    }

    static /* synthetic */ void access$000(DiagnosisHandler diagnosisHandler, Coding coding) {
        diagnosisHandler.processDiagDataCod(coding);
    }

    static /* synthetic */ void access$100(DiagnosisHandler diagnosisHandler, String string) {
        diagnosisHandler.error(string);
    }

    static /* synthetic */ void access$200(DiagnosisHandler diagnosisHandler, LoadFurtherData loadFurtherData) {
        diagnosisHandler.processDiagDataUpdl(loadFurtherData);
    }
}

