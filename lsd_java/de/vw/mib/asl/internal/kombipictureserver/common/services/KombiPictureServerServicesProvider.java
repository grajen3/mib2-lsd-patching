/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.kombipictureserver.common.services;

import de.vw.mib.asl.internal.kombipictureserver.common.services.KombiPictureServerServices;
import de.vw.mib.asl.internal.kombipictureserver.common.services.KombiPictureServerServicesImpl;

public class KombiPictureServerServicesProvider {
    private static KombiPictureServerServices services;

    public static KombiPictureServerServices getKombiPictureServerServices() {
        if (services == null) {
            services = new KombiPictureServerServicesImpl();
        }
        return services;
    }

    public static void setKombiPictureServerServices(KombiPictureServerServices kombiPictureServerServices) {
        services = kombiPictureServerServices;
    }
}

