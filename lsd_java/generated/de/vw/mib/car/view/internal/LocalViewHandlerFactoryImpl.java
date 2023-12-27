/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.car.view.internal;

import de.vw.mib.perf.service.PerfService;
import de.vw.mib.skin.SkinClassLoader;
import de.vw.mib.util.StringBuilder;
import de.vw.mib.view.internal.LocalViewHandlerFactory;
import de.vw.mib.view.internal.ViewHandlerAppServices;
import de.vw.mib.view.internal.ViewHandlerServices;
import java.util.Set;

public class LocalViewHandlerFactoryImpl
extends LocalViewHandlerFactory {
    private static final String LOCAL_VIEW_PACKAGE_PREFIX;
    private static final String SHARED_VIEW_PACKAGE_PREFIX;
    private final Set shared;
    private final Set popups;
    private final StringBuilder qualifiedLocalClassNameBuffer = LocalViewHandlerFactoryImpl.newBuffer("generated.de.vw.mib.car.view.internal.");
    private final StringBuilder qualifiedSharedClassNameBuffer = LocalViewHandlerFactoryImpl.newBuffer("generated.de.vw.mib.global.view.internal.");

    public LocalViewHandlerFactoryImpl(SkinClassLoader skinClassLoader, PerfService perfService, ViewHandlerServices viewHandlerServices, ViewHandlerAppServices viewHandlerAppServices) {
        super(skinClassLoader, perfService, viewHandlerServices, viewHandlerAppServices);
        this.shared = LocalViewHandlerFactoryImpl.setOf(new String[]{"Cpd", "Cpm", "Cptp", "Cpts", "Gde", "Gdna", "Psgpb", "Scdac", "Ssd_A1E6", "Sst_1067", "Sst_B44A", "Sstd", "Ssu"});
        this.popups = LocalViewHandlerFactoryImpl.setOf(new String[]{"Pccecpda", "Pccecpdo", "Pccftrc", "Pccse", "Pccsfsr", "Pccsmrl", "Pccsmrt_F21E", "Pccsmrt_A41D", "Pccsoud", "Pccsoude", "Pccspc", "Pccspec", "Pccspka", "Pccspm", "Pccspo", "Pccspr_1EA9", "Pccspr_DC5F", "Pccsps", "Pcfsr", "Picde_F968", "Picde_C8F6", "Picdk", "Picds_0936", "Picds_C308", "Picdt", "Picdu", "Picecp", "Picecpdc", "Picecpml", "Picects", "Picec", "Piceda", "Piceew", "Piceh", "Picftrh", "Picpf", "Picsouds", "Picspecw", "Picspke", "Picspkp", "Picspks", "Picspkw", "Picsprw_CDC7", "Picsprw_D380", "Picstre", "Picstrs", "Picscs_08BD", "Picscsr", "Picvf", "Pifbs_A7B9", "Pifbs_6CD2", "Pmca_9E87", "Pmcaei", "Pmcbv", "Pmceh", "Pmcehi", "Pmcf", "Pmchei", "Pmcmo", "Pmco", "Pmcrn", "Pmcsd_8058", "Pmcsn", "Pmdm", "Pmfm", "Pmfsp7", "Pmfspx", "Pmfso", "Psgpb"});
    }

    @Override
    protected boolean isAppPopup(String string) {
        return this.popups.contains(string);
    }

    private boolean isShared(String string) {
        return this.shared.contains(string);
    }

    @Override
    protected String getQualifiedClassName(String string) {
        if (this.isShared(string)) {
            return LocalViewHandlerFactoryImpl.buildQualifiedClassName(this.qualifiedSharedClassNameBuffer, string);
        }
        return LocalViewHandlerFactoryImpl.buildQualifiedClassName(this.qualifiedLocalClassNameBuffer, string);
    }

    @Override
    public String getPopupBackgroundViewHandler() {
        return "Psgpb";
    }
}

