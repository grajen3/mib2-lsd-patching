/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.nav.view.internal;

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
    private final StringBuilder qualifiedLocalClassNameBuffer = LocalViewHandlerFactoryImpl.newBuffer("generated.de.vw.mib.nav.view.internal.");
    private final StringBuilder qualifiedSharedClassNameBuffer = LocalViewHandlerFactoryImpl.newBuffer("generated.de.vw.mib.global.view.internal.");

    public LocalViewHandlerFactoryImpl(SkinClassLoader skinClassLoader, PerfService perfService, ViewHandlerServices viewHandlerServices, ViewHandlerAppServices viewHandlerAppServices) {
        super(skinClassLoader, perfService, viewHandlerServices, viewHandlerAppServices);
        this.shared = LocalViewHandlerFactoryImpl.setOf(new String[]{"Cws", "Gde", "Gdna", "Psgpb", "Scdac", "Wcc", "Wccs_974F", "Wccs_259D", "Wcid", "Wcnw", "Wcns", "Wcnsa", "Wcscm", "Wcsi", "Wcsep", "Wcw", "Wcwhl", "Wocnaa", "Wocnip", "Wocnipwf", "Wocnis", "Wocnp", "Wocnpoa", "Wocnui", "Wof", "Wosll", "Wos"});
        this.popups = LocalViewHandlerFactoryImpl.setOf(new String[]{"Pancre", "Pcncrq", "Pcncad", "Pcnnipha", "Pcnrrg", "Pcnrrwg", "Pcnsgq", "Pgnri", "Pgnria", "Pgnriaw", "Pinwif_0B43", "Pinwif_C334", "Pinwir", "Pinnah", "Pinnasare", "Pinnasnhh", "Pinodie", "Pinodif", "Pinodina", "Pinodip", "Pinodis", "Pinpose", "Pinpse", "Pinpni", "Pinsde", "Pinsf", "Pncasl", "Pndmdd", "Pndmscc", "Pndmsce", "Pndmscf", "Pndmsnq", "Pndmsqmf", "Pnhs", "Pnmard", "Pnmsd", "Pnndsl", "Pnniphf", "Pnoemdc", "Pnoemdh", "Pnoie", "Pnoip", "Pnoir", "Pnomsd", "Pnospc", "Pnosdq", "Pnrwd", "Pnrwh", "Pnrgf", "Pntbc", "Pntdre", "Pntfw", "Pntfwc", "Pntfwcp", "Pntfwl", "Pntfwlp", "Pntfwp", "Pntrd1", "Pntrd2", "Pntrd3", "Pntxu", "Pntwfna", "Pntmhc", "Pntmhlaf", "Pntmhls", "Pntmhmd", "Pntmhmn", "Pntmhmsc", "Pntmhms", "Pntmhmt", "Pntmhotin", "Pntmhotinf", "Pntmhsc", "Pntmhsm", "Pntlu", "Pnw", "Pnwi", "Pnwcrgq", "Pnwescc", "Pnwesce", "Pnwescf", "Pnweq_4524", "Pnwedq", "Pnwerq", "Pnwee", "Pnwen", "Pnwep", "Pnweq_3621", "Pnwip", "Pnwmwc", "Pnwmd", "Pnwml", "Pnwrc", "Pnwrtf", "Pnwrwf", "Pnwrwl", "Pnwwf", "Pnwwfna", "Pnwwsna", "Ppnmard", "Ppnnis", "Ppncr", "Ppnwcr", "Psgpb", "Ptndmdtf", "Ptmmre"});
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
        return new String[]{"Nmar", "Nmg", "Nmn", "Nms", "Npo"};
    }

    @Override
    public String getPopupBackgroundViewHandler() {
        return "Psgpb";
    }
}

