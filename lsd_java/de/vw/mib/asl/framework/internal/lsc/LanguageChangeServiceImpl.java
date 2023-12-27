/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.lsc;

import de.vw.mib.asl.framework.api.framework.component.ASLComponentRegistry;
import de.vw.mib.asl.framework.internal.lsc.AslTargetLscTNGBullhorn;
import de.vw.mib.asl.framework.internal.lsc.LanguageChangeService;
import de.vw.mib.asl.framework.internal.lsc.LscServices;
import de.vw.mib.configuration.ConfigurationManagerDiag;
import java.util.Arrays;
import java.util.List;

public class LanguageChangeServiceImpl
implements LanguageChangeService {
    private final ConfigurationManagerDiag configManagerDiag;
    private final AslTargetLscTNGBullhorn bullhorn;
    private final ASLComponentRegistry aslComponentRegistry;
    static /* synthetic */ Class class$de$vw$mib$asl$framework$internal$lsc$LanguageChangeService;

    public LanguageChangeServiceImpl(AslTargetLscTNGBullhorn aslTargetLscTNGBullhorn, LscServices lscServices) {
        this.bullhorn = aslTargetLscTNGBullhorn;
        this.configManagerDiag = lscServices.getConfigManagerDiag();
        this.aslComponentRegistry = lscServices.getAslComponentRegistry();
        this.registerServiceAtComponentRegistry();
    }

    @Override
    public void changeLanguage(String string) {
        this.checkLanguageAvailable(string);
        this.bullhorn.changeLanguage(string);
    }

    private void registerServiceAtComponentRegistry() {
        this.aslComponentRegistry.registerAPI(class$de$vw$mib$asl$framework$internal$lsc$LanguageChangeService == null ? (class$de$vw$mib$asl$framework$internal$lsc$LanguageChangeService = LanguageChangeServiceImpl.class$("de.vw.mib.asl.framework.internal.lsc.LanguageChangeService")) : class$de$vw$mib$asl$framework$internal$lsc$LanguageChangeService, this);
    }

    private String[] getAvailableLanguages() {
        return this.configManagerDiag.getAvailableLanguages();
    }

    private boolean isLanguageAvailable(String string) {
        List list = Arrays.asList(this.getAvailableLanguages());
        return list.contains(string);
    }

    private void checkLanguageAvailable(String string) {
        if (!this.isLanguageAvailable(string)) {
            throw new IllegalArgumentException(new StringBuffer().append("Language ").append(string).append(" is not available").toString());
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
}

