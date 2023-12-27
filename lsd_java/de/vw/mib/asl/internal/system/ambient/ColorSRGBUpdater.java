/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.system.ambient;

import de.vw.mib.asl.internal.system.ambient.ColorSRGBUpdater$1;
import de.vw.mib.asl.internal.system.has.SystemHasBridge;
import org.osgi.framework.BundleContext;

public class ColorSRGBUpdater {
    private final BundleContext bundleContext;
    private final SystemHasBridge systemHasBridge;
    static /* synthetic */ Class class$de$vw$mib$configuration$SkinInformationService;

    public ColorSRGBUpdater(BundleContext bundleContext, SystemHasBridge systemHasBridge) {
        this.bundleContext = bundleContext;
        this.systemHasBridge = systemHasBridge;
    }

    public void registerAmbientHmiAndSrgbColor() {
        this.trackSkinInformationService(this.bundleContext, this.systemHasBridge);
    }

    private void trackSkinInformationService(BundleContext bundleContext, SystemHasBridge systemHasBridge) {
        new ColorSRGBUpdater$1(this, bundleContext, (class$de$vw$mib$configuration$SkinInformationService == null ? (class$de$vw$mib$configuration$SkinInformationService = ColorSRGBUpdater.class$("de.vw.mib.configuration.SkinInformationService")) : class$de$vw$mib$configuration$SkinInformationService).getName(), null, systemHasBridge).open();
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

