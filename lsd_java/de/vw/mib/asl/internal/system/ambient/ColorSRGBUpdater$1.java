/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.system.ambient;

import de.vw.mib.asl.internal.system.ambient.ColorSRGBUpdater;
import de.vw.mib.asl.internal.system.ambient.SkinInformationReceiverImpl;
import de.vw.mib.asl.internal.system.has.SystemHasBridge;
import de.vw.mib.configuration.SkinInformationService;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import org.osgi.util.tracker.ServiceTracker;
import org.osgi.util.tracker.ServiceTrackerCustomizer;

class ColorSRGBUpdater$1
extends ServiceTracker {
    private final /* synthetic */ SystemHasBridge val$systemHasBridge;
    private final /* synthetic */ ColorSRGBUpdater this$0;

    ColorSRGBUpdater$1(ColorSRGBUpdater colorSRGBUpdater, BundleContext bundleContext, String string, ServiceTrackerCustomizer serviceTrackerCustomizer, SystemHasBridge systemHasBridge) {
        this.this$0 = colorSRGBUpdater;
        this.val$systemHasBridge = systemHasBridge;
        super(bundleContext, string, serviceTrackerCustomizer);
    }

    @Override
    public Object addingService(ServiceReference serviceReference) {
        SkinInformationService skinInformationService = (SkinInformationService)super.addingService(serviceReference);
        skinInformationService.addSkinInformationReceiver(new SkinInformationReceiverImpl(this.val$systemHasBridge));
        this.close();
        return skinInformationService;
    }
}

