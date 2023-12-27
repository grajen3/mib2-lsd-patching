/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.appzilla.view.internal;

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
    private final Set popups;
    private final StringBuilder qualifiedLocalClassNameBuffer = LocalViewHandlerFactoryImpl.newBuffer("generated.de.vw.mib.appzilla.view.internal.");
    private final StringBuilder qualifiedSharedClassNameBuffer = LocalViewHandlerFactoryImpl.newBuffer("generated.de.vw.mib.global.view.internal.");

    public LocalViewHandlerFactoryImpl(SkinClassLoader skinClassLoader, PerfService perfService, ViewHandlerServices viewHandlerServices, ViewHandlerAppServices viewHandlerAppServices) {
        super(skinClassLoader, perfService, viewHandlerServices, viewHandlerAppServices);
        this.popups = LocalViewHandlerFactoryImpl.setOf(new String[]{"Pccnc3_D92A", "Pccnc3_F60A", "Pccnf3", "Pccabp", "Pcccc", "Pcccswpd", "Pccdcna3", "Pccdr3", "Pccdcc", "Pccia", "Pcciadt3", "Pcciaft3", "Pccnsu3", "Pccnps3", "Pccocsna3_8C63", "Pccppi", "Pccracs", "Pccrdt3", "Pccsr", "Pccsl3", "Pccuc", "Pccwi", "Pccwcna3", "Pccwr", "Pccwwe3", "Pcspce", "Pcspdd", "Pcspdnr", "Pcspdt", "Pcspeid", "Pcspemna", "Pcsperm", "Pcspfe", "Pcspsm", "Pcspur", "Pcsartfs2", "Pcsrtfs", "Pgbv", "Piciw", "Picaf", "Picar", "Piccf3", "Piccfwk3", "Picnd3", "Picppv", "Picpnr3", "Picprna3", "Picra3", "Picw3", "Picwnuwod3", "Picws3_2C82", "Picww33", "Picwwf3", "Picwws3", "Picws3_7EEF", "Pigsuar", "Pigsue", "Pigsuf", "Pigsufe", "Pigsur", "Pissfsr", "Pswfr", "Psapni", "Psacpa", "Psacrn", "Psagona", "Psagonae", "Psagonau", "Psaid_B2DA", "Psaleo", "Psannsiv", "Psanf", "Psarcd", "Psaslce", "Psaslle", "Psaslnns", "Psaslbs", "Psaslbw", "Psassd", "Psassdw", "Psastlwcd", "Psastlws", "Psastwcd", "Psastws", "Psatdnaco", "Psausnaco2", "Psd", "Psdp_FB7B", "Psgpb", "Psicra", "Psidc", "Pside", "Psipcr", "Psiscdl", "Psisdecd", "Psisdes_E120", "Psisdes_59E5", "Psisdeu_F9E1", "Psisdeu_0A97", "Psisdeu_54EF", "Psisdeu_6917", "Psisecd", "Psisencdi", "Psisrecd", "Psisres_2CD2", "Psisres_7B5F", "Psisreu_650C", "Psisreu_66CC", "Psisreu_69A3", "Psisreu_CA01", "Psissl_0B1B", "Psissl_33E7", "Psisul_B591", "Psisul_29AF", "Psisul_55CB", "Psisul_FFAC", "Psivp", "Psmsslld", "Psmsslls", "Pspicpa"});
    }

    @Override
    protected boolean isAppPopup(String string) {
        return this.popups.contains(string);
    }

    private boolean isShared(String string) {
        return "Psgpb".equals(string);
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

