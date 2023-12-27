/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.global.view.internal;

import de.vw.mib.log4mib.LoggerFactory;
import de.vw.mib.view.internal.GlobalViewHandlerFactory;

public class GlobalViewHandlerFactoryImpl
extends GlobalViewHandlerFactory {
    public GlobalViewHandlerFactoryImpl(LoggerFactory loggerFactory) {
        super(loggerFactory);
    }

    @Override
    public String[] getFastAccessibleViewHandler() {
        return new String[]{"Cisl", "Fd", "Fds", "Io", "Ma", "Mbam", "Mcdm", "Mcvm", "Mns", "Mam", "Mm_FD5A", "Nmar", "Nmg", "Nmn", "Nms", "Npo", "Pmc", "Pmn", "Pvm", "Ssci", "Ssm_6301", "Ssv", "Tam_593A", "Tdm_86AD", "Tfm", "Tam_9D1A", "Tdm_97E5", "Tsmci", "Ttm", "Vdm_6A26"};
    }

    @Override
    public String[] getFastAccessiblePopupViewHandler() {
        return new String[0];
    }

    @Override
    public String getPopupBackgroundViewHandler() {
        return "Psgpb";
    }
}

