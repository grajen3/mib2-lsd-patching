/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.impl.lsc;

import de.vw.mib.algorithms.LinkedQuickSort;
import de.vw.mib.asl.framework.api.diagnosis.AdaptionApi;
import de.vw.mib.asl.framework.api.diagnosis.config.LoadSystemLanguages;
import de.vw.mib.asl.framework.api.persistence.AslPersistenceSyncApi;
import de.vw.mib.asl.framework.internal.impl.lsc.AbstractLscTarget;
import de.vw.mib.asl.framework.internal.impl.lsc.DiagLanguageUpdateListener;
import de.vw.mib.asl.framework.internal.impl.lsc.Preconditions;
import de.vw.mib.asl.framework.internal.lsc.LanguageComparator;
import de.vw.mib.asl.framework.internal.lsc.LscServices;
import de.vw.mib.configuration.ConfigurationManagerDiag;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.GenericEventException;
import java.util.Arrays;

public class LanguageDiagnosisHandler
extends AbstractLscTarget {
    public static final int EVENT_SYSTEM_LANGUAGES;
    private final ConfigurationManagerDiag configManagerDiag;
    private DiagLanguageUpdateListener listener;
    private final AslPersistenceSyncApi persistence;
    static /* synthetic */ Class class$de$vw$mib$asl$framework$internal$impl$lsc$LanguageDiagnosisHandler;

    public LanguageDiagnosisHandler(LscServices lscServices) {
        super(814485760, lscServices.getGenericEvents(), lscServices.getLscLogger());
        this.configManagerDiag = lscServices.getConfigManagerDiag();
        this.persistence = lscServices.getPersistenceSyncApi();
        this.requestDiagSystemLanguages(lscServices.getAdaptionApi());
    }

    private void requestDiagSystemLanguages(AdaptionApi adaptionApi) {
        try {
            adaptionApi.requestConfigManagerPersLoadSystemLanguages(this.getTargetId(), -1585053440);
        }
        catch (GenericEventException genericEventException) {
            throw new RuntimeException(genericEventException);
        }
    }

    public void setListener(DiagLanguageUpdateListener diagLanguageUpdateListener) {
        Preconditions.checkArgumentNotNull(diagLanguageUpdateListener, "Argument >listener< must not be null!");
        this.listener = diagLanguageUpdateListener;
    }

    @Override
    public void gotEvent(EventGeneric eventGeneric) {
        if (!LanguageDiagnosisHandler.isLoadSystemLanguagesEvent(eventGeneric)) {
            this.log().trace(new StringBuffer().append("Unexpected event! Expected a NamespaceUPDL.NAMESPACE event, got: ").append(eventGeneric).toString());
            return;
        }
        if (this.hasVisibleLanguagesError()) {
            this.handleLoadVisibleLanguagesError();
            return;
        }
        LoadSystemLanguages loadSystemLanguages = this.getVisibleSystemLanguages(eventGeneric);
        if (loadSystemLanguages != null) {
            this.processLoadedSystemLanguage(loadSystemLanguages);
        } else {
            this.log().trace(new StringBuffer().append("LoadSystemLanguages were null! Event:").append(eventGeneric).toString());
        }
    }

    private LoadSystemLanguages getVisibleSystemLanguages(EventGeneric eventGeneric) {
        return (LoadSystemLanguages)eventGeneric.getObject(1);
    }

    private boolean hasVisibleLanguagesError() {
        return this.persistence.readBoolean(906042371, 0, true);
    }

    private void handleLoadVisibleLanguagesError() {
        this.log().info("Falling back to Variant Defined Languages");
        String[] stringArray = this.configManagerDiag.getVariantDefinedLanguages();
        String[] stringArray2 = (String[])stringArray.clone();
        this.updateLanguages(stringArray, stringArray2);
    }

    private void processLoadedSystemLanguage(LoadSystemLanguages loadSystemLanguages) {
        try {
            this.useLoadedSystemLanguages(loadSystemLanguages);
        }
        catch (Exception exception) {
            this.log().error(" Error during evaluation of coded languages, wrong language count!", exception);
            this.useVariantLanguages();
        }
    }

    private void useLoadedSystemLanguages(LoadSystemLanguages loadSystemLanguages) {
        int n = loadSystemLanguages.getValue(609);
        if (n != 0) {
            String[] stringArray = new String[n];
            String[] stringArray2 = new String[n];
            for (int i2 = 0; i2 < n; ++i2) {
                stringArray[i2] = loadSystemLanguages.getLanguage(i2);
                stringArray2[i2] = loadSystemLanguages.getLanguage(n + i2);
            }
            this.updateLanguages(stringArray, stringArray2);
        } else {
            this.useVariantLanguages();
        }
    }

    private void useVariantLanguages() {
        this.log().error(" Visible/Fallback languages were corrupted or null, using variant defined ones instead");
        this.persistence.writeBoolean(906042371, 0, true);
        String[] stringArray = this.configManagerDiag.getVariantDefinedLanguages();
        String[] stringArray2 = this.createFallbackLanguages(stringArray);
        this.updateLanguages(stringArray, stringArray2);
    }

    private String[] createFallbackLanguages(String[] stringArray) {
        Object[] objectArray = new String[stringArray.length];
        for (int i2 = 0; i2 < stringArray.length; ++i2) {
            if (stringArray[i2].indexOf("en") == -1) continue;
            Arrays.fill(objectArray, stringArray[i2]);
            break;
        }
        return objectArray;
    }

    private void updateLanguages(String[] stringArray, String[] stringArray2) {
        LanguageDiagnosisHandler.sortLinked(stringArray, stringArray2);
        this.configManagerDiag.setSelectableLanguages(stringArray);
        this.configManagerDiag.setFallbackLanguages(stringArray2);
        if (this.listener == null) {
            String string = new StringBuffer().append("No DiagLanguageUpdateListener is set! Did you forget to call ").append(class$de$vw$mib$asl$framework$internal$impl$lsc$LanguageDiagnosisHandler == null ? (class$de$vw$mib$asl$framework$internal$impl$lsc$LanguageDiagnosisHandler = LanguageDiagnosisHandler.class$("de.vw.mib.asl.framework.internal.impl.lsc.LanguageDiagnosisHandler")) : class$de$vw$mib$asl$framework$internal$impl$lsc$LanguageDiagnosisHandler).append(".setListener(..).").toString();
            this.log().error(string, new NullPointerException());
        } else {
            this.listener.onDiagLanguagesUpdated();
        }
    }

    private static void sortLinked(String[] stringArray, String[] stringArray2) {
        LinkedQuickSort.sortLinkedArrays(stringArray, stringArray2, LanguageComparator.LANGUAGE_COMPARATOR);
    }

    private static boolean isLoadSystemLanguagesEvent(EventGeneric eventGeneric) {
        return LanguageDiagnosisHandler.isSystemLanguageEvent(eventGeneric) && LanguageDiagnosisHandler.isNamespaceUDPL(eventGeneric) && LanguageDiagnosisHandler.containsLoadedLanguages(eventGeneric);
    }

    private static boolean containsLoadedLanguages(EventGeneric eventGeneric) {
        long l = eventGeneric.getLong(3);
        return l == 0;
    }

    private static boolean isNamespaceUDPL(EventGeneric eventGeneric) {
        int n = eventGeneric.getInt(2);
        return n == 906042371;
    }

    private static boolean isSystemLanguageEvent(EventGeneric eventGeneric) {
        int n = eventGeneric.getReceiverEventId();
        return n == -1585053440;
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }
}

