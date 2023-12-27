/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.phone.view.internal;

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
    private final StringBuilder qualifiedLocalClassNameBuffer = LocalViewHandlerFactoryImpl.newBuffer("generated.de.vw.mib.phone.view.internal.");
    private final StringBuilder qualifiedSharedClassNameBuffer = LocalViewHandlerFactoryImpl.newBuffer("generated.de.vw.mib.global.view.internal.");

    public LocalViewHandlerFactoryImpl(SkinClassLoader skinClassLoader, PerfService perfService, ViewHandlerServices viewHandlerServices, ViewHandlerAppServices viewHandlerAppServices) {
        super(skinClassLoader, perfService, viewHandlerServices, viewHandlerAppServices);
        this.shared = LocalViewHandlerFactoryImpl.setOf(new String[]{"Gde", "Gdna", "Psgpb", "Scdac"});
        this.popups = LocalViewHandlerFactoryImpl.setOf(new String[]{"Bbpsr", "Bpsr", "Busr", "Pabai", "Pabane", "Pabbcid", "Pabbca", "Pabbcc", "Pabbclee", "Pabbge", "Pabboor", "Pabbpge", "Pabbppe", "Pabbpte", "Pabbse", "Pabbsni", "Pabbua", "Pabcge", "Pabcpe", "Pabcue", "Pabcua", "Pabdrc", "Pabend", "Pabene", "Pabpdaf", "Pabpdf_38F6", "Pabpdf_3383", "Pabpdfns", "Pabpna", "Pabse", "Papachw", "Papactw", "Papae", "Papdf", "Papee", "Papef", "Papmalew", "Papnht", "Papnne", "Papnnf", "Papni", "Papnlf", "Pappi_DEF6", "Pappi_2CC2", "Papsd_088C", "Papsd_419A", "Paptscf", "Paptwfod", "Pcbbs", "Pcbcf", "Pcbda", "Pcbde", "Pcbea", "Pcbh", "Pcbm", "Pcbpd_F765", "Pcbpda", "Pcbpd_766B", "Pcbrooa", "Pcbros", "Pcbsip", "Pcbu", "Pcpcsd", "Pcpcsed", "Pcpdpc", "Pcpdp", "Pcpe", "Pcpem", "Pcpen", "Pcpeuc", "Pcpfd_AD4F", "Pcpfd_FD35", "Pcpndo", "Pcpnu", "Pcpps", "Pcpsd2p", "Pcpsns", "Pcpti", "Pcptsu", "Pibbw", "Pibbs", "Pibcl", "Pibca", "Pibci", "Piboca", "Pibseg", "Pibscl", "Pipemac", "Pipenl", "Pipetbe", "Pipnba", "Pipnnr", "Pipnrna", "Pipnn", "Pippcf", "Pippcs", "Piptscs", "Piptwoc", "Ppwt_787C", "Ppbbpr", "Ppbbpv", "Ppbbse", "Ppbeaw", "Ppbebw", "Ppbeb", "Ppbec", "Ppbsr", "Ppppv_9402", "Ppppv_9C15", "Ppptssr", "Ppw_9F78", "Psgpb"});
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
        return new String[]{"Pmc", "Pmn"};
    }

    @Override
    public String getPopupBackgroundViewHandler() {
        return "Psgpb";
    }
}

