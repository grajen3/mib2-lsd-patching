/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.media.view.internal;

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
    private final StringBuilder qualifiedLocalClassNameBuffer = LocalViewHandlerFactoryImpl.newBuffer("generated.de.vw.mib.media.view.internal.");
    private final StringBuilder qualifiedSharedClassNameBuffer = LocalViewHandlerFactoryImpl.newBuffer("generated.de.vw.mib.global.view.internal.");

    public LocalViewHandlerFactoryImpl(SkinClassLoader skinClassLoader, PerfService perfService, ViewHandlerServices viewHandlerServices, ViewHandlerAppServices viewHandlerAppServices) {
        super(skinClassLoader, perfService, viewHandlerServices, viewHandlerAppServices);
        this.shared = LocalViewHandlerFactoryImpl.setOf(new String[]{"Gde", "Gdna", "Psgpb", "Scdac"});
        this.popups = LocalViewHandlerFactoryImpl.setOf(new String[]{"Mobnpfws", "Mobmrf", "Mofna", "Mojai", "Mojcds", "Mojda", "Mojdf", "Mojdis", "Mojdsf", "Mojd", "Mojifa", "Mojifm", "Mojifp", "Mojii", "Mojmf", "Mojsic", "Mojsim", "Momnosfr", "Mopdna", "Mopgr", "Mopnr", "Mosnpf", "Mosbnadc", "Mosce", "Moscia", "Moscnd", "Moscni", "Moscnf", "Moscs", "Mosdce", "Mosdcia", "Mosdcni", "Mosmc", "Mosme", "Mosmnf", "Mosms", "Mosse_06E4", "Mossnd_8FAB", "Mossni_FEF2", "Mossnf_BA4A", "Mosss_FAC2", "Mosse_232D", "Mossnd_3200", "Mossni_290C", "Mossnf_28D0", "Mosss_20F5", "Mosue_2B0C", "Mosund_EB36", "Mosuni_19B7", "Mosunf_D671", "Mosus_3E58", "Mosue_3813", "Mosund_BD55", "Mosuni_AD9B", "Mosunf_D604", "Mosus_5C28", "Mosue_79B6", "Mosund_BD16", "Mosuni_A9C1", "Mosunf_AF6F", "Mosus_DDDE", "Mosue_9D1D", "Mosund_1A9D", "Mosuni_015B", "Mosunf_98A6", "Mosus_5750", "Movsl", "Psgpb"});
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
    public String[] getFastAccessibleViewHandler() {
        return new String[]{"Ma", "Mbam", "Mcdm", "Mcvm", "Mns", "Vdm_6A26"};
    }

    @Override
    public String getPopupBackgroundViewHandler() {
        return "Psgpb";
    }
}

