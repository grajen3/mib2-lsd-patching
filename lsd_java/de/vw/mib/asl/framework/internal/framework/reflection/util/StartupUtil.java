/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.framework.reflection.util;

import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.framework.internal.framework.dsi.DSIProxyException;
import de.vw.mib.asl.framework.internal.framework.reflection.ContainerReflectionFactory;
import de.vw.mib.asl.framework.internal.framework.reflection.dsi.DSIReflectionConfiguration;
import de.vw.mib.asl.framework.internal.framework.reflection.dsi.DSIReflectionFactory;

public final class StartupUtil {
    private static final String[] MODULE_REFLECTION_PACKAGES = new String[]{"de.vw.mib.asl.framework.internal.console.reflection.generated", "de.vw.mib.asl.framework.internal.diagnosis.reflection.generated", "de.vw.mib.asl.framework.internal.displaymanagement.reflection.generated", "de.vw.mib.asl.framework.internal.entertainmentmanager.reflection.generated", "de.vw.mib.asl.framework.internal.framework.reflection.generated", "de.vw.mib.asl.framework.internal.lsc.reflection.generated", "de.vw.mib.asl.framework.internal.persistence.reflection.generated", "de.vw.mib.asl.framework.internal.startupv7r.reflection.generated", "de.vw.mib.asl.internal.asiainput.reflection.generated", "de.vw.mib.asl.internal.car.reflection.generated", "de.vw.mib.asl.internal.car.fpk.reflection.generated", "de.vw.mib.asl.internal.carlife.reflection.generated", "de.vw.mib.asl.internal.climatesetup.reflection.generated", "de.vw.mib.asl.internal.download.reflection.generated", "de.vw.mib.asl.internal.exboxm.reflection.generated", "de.vw.mib.asl.internal.filebrowser.reflection.generated", "de.vw.mib.asl.internal.infotainmentrecorder.reflection.generated", "de.vw.mib.asl.internal.internetbrowser.reflection.generated", "de.vw.mib.asl.internal.media.reflection.generated", "de.vw.mib.asl.internal.messages.reflection.generated", "de.vw.mib.asl.internal.mirrorlink.reflection.generated", "de.vw.mib.asl.internal.navigation.reflection.generated", "de.vw.mib.asl.internal.navigation.truffel.nar.reflection.generated", "de.vw.mib.asl.internal.navigation.truffel.chn.reflection.generated", "de.vw.mib.asl.internal.navigation.bap.reflection.generated", "de.vw.mib.asl.internal.navigation.guidance.reflection.generated", "de.vw.mib.asl.internal.navigation.locationinput.reflection.generated", "de.vw.mib.asl.internal.navigation.map.reflection.generated", "de.vw.mib.asl.internal.navigation.memory.reflection.generated", "de.vw.mib.asl.internal.navigation.onlineutil.reflection.generated", "de.vw.mib.asl.internal.navigation.poi.reflection.generated", "de.vw.mib.asl.internal.navigation.splitscreen.reflection.generated", "de.vw.mib.asl.internal.navigation.startup.reflection.generated", "de.vw.mib.asl.internal.navigation.traffic.reflection.generated", "de.vw.mib.asl.internal.navigation.util.reflection.generated", "de.vw.mib.asl.internal.organizer.reflection.generated", "de.vw.mib.asl.internal.phone.reflection.generated", "de.vw.mib.asl.internal.picturestore.reflection.generated", "de.vw.mib.asl.internal.pictureviewer.reflection.generated", "de.vw.mib.asl.internal.radio.reflection.generated", "de.vw.mib.asl.internal.sound.reflection.generated", "de.vw.mib.asl.internal.speechengine.reflection.generated", "de.vw.mib.asl.internal.speechengine.impl.reflection.generated", "de.vw.mib.asl.internal.swap.reflection.generated", "de.vw.mib.asl.internal.system.reflection.generated", "de.vw.mib.asl.internal.testmode.reflection.generated", "de.vw.mib.asl.internal.tvtuner.reflection.generated", "de.vw.mib.asl.internal.has.reflection.generated", "de.vw.mib.asl.internal.online.reflection.generated", "de.vw.mib.asl.internal.online.core.reflection.generated", "de.vw.mib.asl.internal.online.destinationimport.reflection.generated", "de.vw.mib.asl.internal.online.servicebridge.reflection.generated", "de.vw.mib.asl.internal.online.uota.reflection.generated", "de.vw.mib.asl.internal.online.callcenterservice.reflection.generated", "de.vw.mib.asl.internal.online.tourimport.reflection.generated", "de.vw.mib.asl.internal.kombipictureserver.reflection.generated", "de.vw.mib.asl.internal.mostkombi.reflection.generated", "de.vw.mib.asl.internal.travellink.reflection.generated", "de.vw.mib.asl.internal.navbap.reflection.generated", "de.vw.mib.asl.internal.exlap.reflection.generated", "de.vw.mib.asl.internal.bapcommon.reflection.generated", "de.vw.mib.asl.internal.ic.mqb.pq.reflection.generated", "de.vw.mib.asl.internal.ic.mqb2.reflection.generated", "de.vw.mib.asl.internal.itunes.reflection.generated", "de.vw.mib.asl.internal.car.ugdo.reflection.generated", "de.vw.mib.asl.internal.trafficminimap.reflection.generated", "de.vw.mib.asl.internal.carplay.reflection.generated", "de.vw.mib.asl.internal.smartphoneintegration.reflection.generated", "de.vw.mib.asl.internal.androidauto.reflection.generated", "de.vw.mib.asl.internal.systemsetup.reflection.generated", "de.vw.mib.asl.internal.flowlistmenu.reflection.generated", "de.vw.mib.asl.internal.homescreen.reflection.generated", "de.vw.mib.asl.internal.homebutton.reflection.generated", "de.vw.mib.asl.internal.gridmenu.reflection.generated", "de.vw.mib.asl.internal.background.reflection.generated", "de.vw.mib.asl.internal.mediacontrol.reflection.generated", "de.vw.mib.asl.internal.vicsetc.reflection.generated", "de.vw.mib.asl.internal.navmaptile.reflection.generated", "de.vw.mib.asl.internal.selectiontiles.reflection.generated", "de.vw.mib.asl.internal.navinfotile.reflection.generated", "de.vw.mib.asl.internal.dateglobalwizardpage.reflection.generated", "de.vw.mib.asl.internal.selectiontilel.reflection.generated", "de.vw.mib.asl.internal.globalsetupwizard.reflection.generated", "de.vw.mib.asl.internal.statusbar.reflection.generated", "de.vw.mib.asl.internal.webradio.reflection.generated", "de.vw.mib.asl.internal.homescreenlight.reflection.generated", "de.vw.mib.asl.internal.offclock.reflection.generated", "de.vw.mib.asl.internal.navtraffictiles.reflection.generated", "de.vw.mib.asl.internal.onlinelogbook.reflection.generated", "de.vw.mib.asl.internal.globalgoodbye.reflection.generated"};

    public static void initialize() {
        DSIReflectionFactory dSIReflectionFactory;
        Object object;
        try {
            object = new DSIReflectionConfiguration("de.vw.mib.asl.framework.internal.dsiproxy.lr.DSIRFCC");
            dSIReflectionFactory = new DSIReflectionFactory((DSIReflectionConfiguration)object);
        }
        catch (Exception exception) {
            if (ServiceManager.loggerDSIProxy != null) {
                ServiceManager.loggerDSIProxy.error().append("Could not initialize DSI reflection").attachThrowable(exception).log();
            }
            throw new DSIProxyException("DSI reflection initialization failed", exception);
        }
        object = new ContainerReflectionFactory(dSIReflectionFactory);
        for (int i2 = 0; i2 < MODULE_REFLECTION_PACKAGES.length; ++i2) {
            ((ContainerReflectionFactory)object).registerModuleReflectionPackage(MODULE_REFLECTION_PACKAGES[i2]);
        }
        ServiceManager.reflectionFactory = object;
    }

    private StartupUtil() {
    }
}

