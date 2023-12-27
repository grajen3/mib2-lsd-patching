/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.online.view.internal;

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
    private final StringBuilder qualifiedLocalClassNameBuffer = LocalViewHandlerFactoryImpl.newBuffer("generated.de.vw.mib.online.view.internal.");
    private final StringBuilder qualifiedSharedClassNameBuffer = LocalViewHandlerFactoryImpl.newBuffer("generated.de.vw.mib.global.view.internal.");

    public LocalViewHandlerFactoryImpl(SkinClassLoader skinClassLoader, PerfService perfService, ViewHandlerServices viewHandlerServices, ViewHandlerAppServices viewHandlerAppServices) {
        super(skinClassLoader, perfService, viewHandlerServices, viewHandlerAppServices);
        this.shared = LocalViewHandlerFactoryImpl.setOf(new String[]{"Cws", "Psgpb", "Wcc", "Wccs_974F", "Wccs_259D", "Wcid", "Wcnw", "Wcns", "Wcnsa", "Wcscm", "Wcsi", "Wcsep", "Wcw", "Wcwhl", "Wocnaa", "Wocnip", "Wocnipwf", "Wocnis", "Wocnp", "Wocnpoa", "Wocnui", "Wof", "Wosll", "Wos"});
        this.popups = LocalViewHandlerFactoryImpl.setOf(new String[]{"Paospbe3", "Paospna3", "Pcorum3_4CE8", "Pcorum3_FA38", "Pcospce3", "Pcospli3", "Pcospna3", "Pcosntd", "Pcota", "Pcpu", "Pgaorumf3", "Pgcosr3", "Pgcosdnu", "Pgosdpe3", "Pgosnoua", "Pgosnud", "Pgosoie", "Pgosoucl", "Pgosoue", "Pgosouis", "Pgospune", "Pgospuneia", "Pioos3", "Piorum3", "Piospw3", "Piosods", "Pocwd3", "Pocws3", "Posaf3_D9B9", "Posapebe", "Posapee", "Posapef3", "Posapenc", "Posapenn", "Posapes3", "Posapew3", "Posf3", "Posscna3", "Posae", "Poscdr", "Posd", "Posdad", "Posde3", "Pose", "Posl", "Posspi", "Posspif", "Possps", "Pscowr", "Psgpb"});
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

