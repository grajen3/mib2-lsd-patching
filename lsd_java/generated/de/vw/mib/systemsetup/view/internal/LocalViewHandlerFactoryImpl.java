/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.systemsetup.view.internal;

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
    private final StringBuilder qualifiedLocalClassNameBuffer = LocalViewHandlerFactoryImpl.newBuffer("generated.de.vw.mib.systemsetup.view.internal.");
    private final StringBuilder qualifiedSharedClassNameBuffer = LocalViewHandlerFactoryImpl.newBuffer("generated.de.vw.mib.global.view.internal.");

    public LocalViewHandlerFactoryImpl(SkinClassLoader skinClassLoader, PerfService perfService, ViewHandlerServices viewHandlerServices, ViewHandlerAppServices viewHandlerAppServices) {
        super(skinClassLoader, perfService, viewHandlerServices, viewHandlerAppServices);
        this.shared = LocalViewHandlerFactoryImpl.setOf(new String[]{"Cws", "Psgpb", "Ssd_A1E6", "Sst_1067", "Sst_B44A", "Sstd", "Ssu", "Wcc", "Wccs_974F", "Wccs_259D", "Wcid", "Wcnw", "Wcns", "Wcnsa", "Wcscm", "Wcsi", "Wcsep", "Wcw", "Wcwhl", "Wocnaa", "Wocnip", "Wocnipwf", "Wocnis", "Wocnp", "Wocnpoa", "Wocnui", "Wof", "Wosll", "Wos"});
    }

    @Override
    protected boolean isAppPopup(String string) {
        return "Psgpb".equals(string);
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
        return new String[]{"Ssci", "Ssm_6301", "Ssv"};
    }

    @Override
    public String getPopupBackgroundViewHandler() {
        return "Psgpb";
    }
}

