/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.asl.internal;

import de.vw.mib.asl.internal.list.IllegalListAccessException;
import de.vw.mib.asl.internal.registry.ASLDevice;
import de.vw.mib.asl.internal.registry.ASLDeviceRegistry;
import de.vw.mib.genericevents.ServiceRegister;
import de.vw.mib.log4mib.ClassifiedLogger;
import generated.de.vw.mib.asl.internal.StartUpUtil$1;
import java.lang.reflect.Method;

public final class StartUpUtil {
    private static boolean devicesRegistered;
    private static boolean wrappersInitialized;
    private static ClassLoader cloader;
    private static ASLDeviceRegistry deviceRegistry;
    private static ClassifiedLogger clogger;
    private static final String METHOD_NAME_GET_INSTANCE;
    static /* synthetic */ Class class$generated$de$vw$mib$asl$internal$StartUpUtil;

    private StartUpUtil() {
    }

    public static synchronized void init(ASLDeviceRegistry aSLDeviceRegistry, ServiceRegister serviceRegister, ClassifiedLogger classifiedLogger) {
        deviceRegistry = aSLDeviceRegistry;
        clogger = classifiedLogger;
        cloader = StartUpUtil.findClassLoader();
        StartUpUtil.registerDevices(aSLDeviceRegistry);
        StartUpUtil.initASLWrappers(serviceRegister);
    }

    static ASLDeviceRegistry getRegistry() {
        if (null == deviceRegistry) {
            throw new IllegalListAccessException("Illegal premature access to lists, registry not ready");
        }
        return deviceRegistry;
    }

    private static void registerDevices(ASLDeviceRegistry aSLDeviceRegistry) {
        if (!devicesRegistered) {
            ASLDevice aSLDevice = (ASLDevice)StartUpUtil.getSingletonClassInstance("generated.de.vw.mib.asl.internal.avdc.ASLAVDCDeviceImpl");
            if (null != aSLDevice) {
                aSLDeviceRegistry.registerASLDevice(aSLDevice);
            }
            if (null != (aSLDevice = (ASLDevice)StartUpUtil.getSingletonClassInstance("generated.de.vw.mib.asl.internal.avdc.audio.ASLAVDCAudioDeviceImpl"))) {
                aSLDeviceRegistry.registerASLDevice(aSLDevice);
            }
            if (null != (aSLDevice = (ASLDevice)StartUpUtil.getSingletonClassInstance("generated.de.vw.mib.asl.internal.avdc.audio.albumbrowser.ASLAVDCAudioAlbumbrowserDeviceImpl"))) {
                aSLDeviceRegistry.registerASLDevice(aSLDevice);
            }
            if (null != (aSLDevice = (ASLDevice)StartUpUtil.getSingletonClassInstance("generated.de.vw.mib.asl.internal.avdc.audio.bap.mediabrowser.ASLAVDCAudioBapMediaBrowserDeviceImpl"))) {
                aSLDeviceRegistry.registerASLDevice(aSLDevice);
            }
            if (null != (aSLDevice = (ASLDevice)StartUpUtil.getSingletonClassInstance("generated.de.vw.mib.asl.internal.avdc.audio.browser.ASLAVDCAudioBrowserDeviceImpl"))) {
                aSLDeviceRegistry.registerASLDevice(aSLDevice);
            }
            if (null != (aSLDevice = (ASLDevice)StartUpUtil.getSingletonClassInstance("generated.de.vw.mib.asl.internal.avdc.audio.browser.search.ASLAVDCAudioBrowserSearchDeviceImpl"))) {
                aSLDeviceRegistry.registerASLDevice(aSLDevice);
            }
            if (null != (aSLDevice = (ASLDevice)StartUpUtil.getSingletonClassInstance("generated.de.vw.mib.asl.internal.avdc.video.ASLAVDCVideoDeviceImpl"))) {
                aSLDeviceRegistry.registerASLDevice(aSLDevice);
            }
            if (null != (aSLDevice = (ASLDevice)StartUpUtil.getSingletonClassInstance("generated.de.vw.mib.asl.internal.avdc.video.dvd.ASLAVDCVideoDVDDeviceImpl"))) {
                aSLDeviceRegistry.registerASLDevice(aSLDevice);
            }
            if (null != (aSLDevice = (ASLDevice)StartUpUtil.getSingletonClassInstance("generated.de.vw.mib.asl.internal.avdc.video.dvd.pml.pin.ASLAVDCVideoDVDPMLPINDeviceImpl"))) {
                aSLDeviceRegistry.registerASLDevice(aSLDevice);
            }
            if (null != (aSLDevice = (ASLDevice)StartUpUtil.getSingletonClassInstance("generated.de.vw.mib.asl.internal.androidauto.ASLAndroidAutoDeviceImpl"))) {
                aSLDeviceRegistry.registerASLDevice(aSLDevice);
            }
            if (null != (aSLDevice = (ASLDevice)StartUpUtil.getSingletonClassInstance("generated.de.vw.mib.asl.internal.androidauto.ic.ASLAndroidAutoICDeviceImpl"))) {
                aSLDeviceRegistry.registerASLDevice(aSLDevice);
            }
            if (null != (aSLDevice = (ASLDevice)StartUpUtil.getSingletonClassInstance("generated.de.vw.mib.asl.internal.background.ASLBackgroundDeviceImpl"))) {
                aSLDeviceRegistry.registerASLDevice(aSLDevice);
            }
            if (null != (aSLDevice = (ASLDevice)StartUpUtil.getSingletonClassInstance("generated.de.vw.mib.asl.internal.car.ASLCarDeviceImpl"))) {
                aSLDeviceRegistry.registerASLDevice(aSLDevice);
            }
            if (null != (aSLDevice = (ASLDevice)StartUpUtil.getSingletonClassInstance("generated.de.vw.mib.asl.internal.car.ambiencelight.ASLCarAmbienceLightDeviceImpl"))) {
                aSLDeviceRegistry.registerASLDevice(aSLDevice);
            }
            if (null != (aSLDevice = (ASLDevice)StartUpUtil.getSingletonClassInstance("generated.de.vw.mib.asl.internal.car.assistants.ASLCarAssistantsDeviceImpl"))) {
                aSLDeviceRegistry.registerASLDevice(aSLDevice);
            }
            if (null != (aSLDevice = (ASLDevice)StartUpUtil.getSingletonClassInstance("generated.de.vw.mib.asl.internal.car.bma.ASLCarBMADeviceImpl"))) {
                aSLDeviceRegistry.registerASLDevice(aSLDevice);
            }
            if (null != (aSLDevice = (ASLDevice)StartUpUtil.getSingletonClassInstance("generated.de.vw.mib.asl.internal.car.bordcomputer.ASLCarBordComputerDeviceImpl"))) {
                aSLDeviceRegistry.registerASLDevice(aSLDevice);
            }
            if (null != (aSLDevice = (ASLDevice)StartUpUtil.getSingletonClassInstance("generated.de.vw.mib.asl.internal.car.e_traction.ASLCarE_TractionDeviceImpl"))) {
                aSLDeviceRegistry.registerASLDevice(aSLDevice);
            }
            if (null != (aSLDevice = (ASLDevice)StartUpUtil.getSingletonClassInstance("generated.de.vw.mib.asl.internal.car.e_traction.newprofile.ASLCarE_TractionNewProfileDeviceImpl"))) {
                aSLDeviceRegistry.registerASLDevice(aSLDevice);
            }
            if (null != (aSLDevice = (ASLDevice)StartUpUtil.getSingletonClassInstance("generated.de.vw.mib.asl.internal.car.e_traction.renameprofile.ASLCarE_TractionRenameProfileDeviceImpl"))) {
                aSLDeviceRegistry.registerASLDevice(aSLDevice);
            }
            if (null != (aSLDevice = (ASLDevice)StartUpUtil.getSingletonClassInstance("generated.de.vw.mib.asl.internal.car.fpa.ASLCarFPADeviceImpl"))) {
                aSLDeviceRegistry.registerASLDevice(aSLDevice);
            }
            if (null != (aSLDevice = (ASLDevice)StartUpUtil.getSingletonClassInstance("generated.de.vw.mib.asl.internal.car.fpk.ASLCarFPKDeviceImpl"))) {
                aSLDeviceRegistry.registerASLDevice(aSLDevice);
            }
            if (null != (aSLDevice = (ASLDevice)StartUpUtil.getSingletonClassInstance("generated.de.vw.mib.asl.internal.car.hud.ASLCarHUDDeviceImpl"))) {
                aSLDeviceRegistry.registerASLDevice(aSLDevice);
            }
            if (null != (aSLDevice = (ASLDevice)StartUpUtil.getSingletonClassInstance("generated.de.vw.mib.asl.internal.car.light.ASLCarLightDeviceImpl"))) {
                aSLDeviceRegistry.registerASLDevice(aSLDevice);
            }
            if (null != (aSLDevice = (ASLDevice)StartUpUtil.getSingletonClassInstance("generated.de.vw.mib.asl.internal.car.mfa.ASLCarMFADeviceImpl"))) {
                aSLDeviceRegistry.registerASLDevice(aSLDevice);
            }
            if (null != (aSLDevice = (ASLDevice)StartUpUtil.getSingletonClassInstance("generated.de.vw.mib.asl.internal.car.offroad.ASLCarOffroadDeviceImpl"))) {
                aSLDeviceRegistry.registerASLDevice(aSLDevice);
            }
            if (null != (aSLDevice = (ASLDevice)StartUpUtil.getSingletonClassInstance("generated.de.vw.mib.asl.internal.car.openclose.ASLCarOpenCloseDeviceImpl"))) {
                aSLDeviceRegistry.registerASLDevice(aSLDevice);
            }
            if (null != (aSLDevice = (ASLDevice)StartUpUtil.getSingletonClassInstance("generated.de.vw.mib.asl.internal.car.parkassistence.ASLCarParkAssistenceDeviceImpl"))) {
                aSLDeviceRegistry.registerASLDevice(aSLDevice);
            }
            if (null != (aSLDevice = (ASLDevice)StartUpUtil.getSingletonClassInstance("generated.de.vw.mib.asl.internal.car.parkassistence.areaview.ASLCarParkAssistenceAreaViewDeviceImpl"))) {
                aSLDeviceRegistry.registerASLDevice(aSLDevice);
            }
            if (null != (aSLDevice = (ASLDevice)StartUpUtil.getSingletonClassInstance("generated.de.vw.mib.asl.internal.car.parkassistence.ops.ASLCarParkAssistenceOPSDeviceImpl"))) {
                aSLDeviceRegistry.registerASLDevice(aSLDevice);
            }
            if (null != (aSLDevice = (ASLDevice)StartUpUtil.getSingletonClassInstance("generated.de.vw.mib.asl.internal.car.parkassistence.pla.ASLCarParkAssistencePLADeviceImpl"))) {
                aSLDeviceRegistry.registerASLDevice(aSLDevice);
            }
            if (null != (aSLDevice = (ASLDevice)StartUpUtil.getSingletonClassInstance("generated.de.vw.mib.asl.internal.car.personal.ASLCarPersonalDeviceImpl"))) {
                aSLDeviceRegistry.registerASLDevice(aSLDevice);
            }
            if (null != (aSLDevice = (ASLDevice)StartUpUtil.getSingletonClassInstance("generated.de.vw.mib.asl.internal.car.personal.rename.ASLCarPersonalRenameDeviceImpl"))) {
                aSLDeviceRegistry.registerASLDevice(aSLDevice);
            }
            if (null != (aSLDevice = (ASLDevice)StartUpUtil.getSingletonClassInstance("generated.de.vw.mib.asl.internal.car.seats.ASLCarSeatsDeviceImpl"))) {
                aSLDeviceRegistry.registerASLDevice(aSLDevice);
            }
            if (null != (aSLDevice = (ASLDevice)StartUpUtil.getSingletonClassInstance("generated.de.vw.mib.asl.internal.car.service.ASLCarServiceDeviceImpl"))) {
                aSLDeviceRegistry.registerASLDevice(aSLDevice);
            }
            if (null != (aSLDevice = (ASLDevice)StartUpUtil.getSingletonClassInstance("generated.de.vw.mib.asl.internal.car.sight.ASLCarSightDeviceImpl"))) {
                aSLDeviceRegistry.registerASLDevice(aSLDevice);
            }
            if (null != (aSLDevice = (ASLDevice)StartUpUtil.getSingletonClassInstance("generated.de.vw.mib.asl.internal.car.sport.ASLCarSportDeviceImpl"))) {
                aSLDeviceRegistry.registerASLDevice(aSLDevice);
            }
            if (null != (aSLDevice = (ASLDevice)StartUpUtil.getSingletonClassInstance("generated.de.vw.mib.asl.internal.car.tbt.ASLCarTBTDeviceImpl"))) {
                aSLDeviceRegistry.registerASLDevice(aSLDevice);
            }
            if (null != (aSLDevice = (ASLDevice)StartUpUtil.getSingletonClassInstance("generated.de.vw.mib.asl.internal.carlife.ASLCarLifeDeviceImpl"))) {
                aSLDeviceRegistry.registerASLDevice(aSLDevice);
            }
            if (null != (aSLDevice = (ASLDevice)StartUpUtil.getSingletonClassInstance("generated.de.vw.mib.asl.internal.carlife.ic.ASLCarLifeICDeviceImpl"))) {
                aSLDeviceRegistry.registerASLDevice(aSLDevice);
            }
            if (null != (aSLDevice = (ASLDevice)StartUpUtil.getSingletonClassInstance("generated.de.vw.mib.asl.internal.carplay.ASLCarPlayDeviceImpl"))) {
                aSLDeviceRegistry.registerASLDevice(aSLDevice);
            }
            if (null != (aSLDevice = (ASLDevice)StartUpUtil.getSingletonClassInstance("generated.de.vw.mib.asl.internal.carplay.ic.ASLCarPlayICDeviceImpl"))) {
                aSLDeviceRegistry.registerASLDevice(aSLDevice);
            }
            if (null != (aSLDevice = (ASLDevice)StartUpUtil.getSingletonClassInstance("generated.de.vw.mib.asl.internal.climate.ASLClimateDeviceImpl"))) {
                aSLDeviceRegistry.registerASLDevice(aSLDevice);
            }
            if (null != (aSLDevice = (ASLDevice)StartUpUtil.getSingletonClassInstance("generated.de.vw.mib.asl.internal.climatebar.ASLClimateBarDeviceImpl"))) {
                aSLDeviceRegistry.registerASLDevice(aSLDevice);
            }
            if (null != (aSLDevice = (ASLDevice)StartUpUtil.getSingletonClassInstance("generated.de.vw.mib.asl.internal.climatesetup.ASLClimateSetupDeviceImpl"))) {
                aSLDeviceRegistry.registerASLDevice(aSLDevice);
            }
            if (null != (aSLDevice = (ASLDevice)StartUpUtil.getSingletonClassInstance("generated.de.vw.mib.asl.internal.configuration.ASLConfigurationDeviceImpl"))) {
                aSLDeviceRegistry.registerASLDevice(aSLDevice);
            }
            if (null != (aSLDevice = (ASLDevice)StartUpUtil.getSingletonClassInstance("generated.de.vw.mib.asl.internal.configuration.bap.ASLConfigurationBapDeviceImpl"))) {
                aSLDeviceRegistry.registerASLDevice(aSLDevice);
            }
            if (null != (aSLDevice = (ASLDevice)StartUpUtil.getSingletonClassInstance("generated.de.vw.mib.asl.internal.connectivity.ASLConnectivityDeviceImpl"))) {
                aSLDeviceRegistry.registerASLDevice(aSLDevice);
            }
            if (null != (aSLDevice = (ASLDevice)StartUpUtil.getSingletonClassInstance("generated.de.vw.mib.asl.internal.dateglobalwizardpage.ASLDateGlobalWizardPageDeviceImpl"))) {
                aSLDeviceRegistry.registerASLDevice(aSLDevice);
            }
            if (null != (aSLDevice = (ASLDevice)StartUpUtil.getSingletonClassInstance("generated.de.vw.mib.asl.internal.download.ASLDownloadDeviceImpl"))) {
                aSLDeviceRegistry.registerASLDevice(aSLDevice);
            }
            if (null != (aSLDevice = (ASLDevice)StartUpUtil.getSingletonClassInstance("generated.de.vw.mib.asl.internal.exboxm.ASLExBoxMDeviceImpl"))) {
                aSLDeviceRegistry.registerASLDevice(aSLDevice);
            }
            if (null != (aSLDevice = (ASLDevice)StartUpUtil.getSingletonClassInstance("generated.de.vw.mib.asl.internal.filebrowser.ASLFileBrowserDeviceImpl"))) {
                aSLDeviceRegistry.registerASLDevice(aSLDevice);
            }
            if (null != (aSLDevice = (ASLDevice)StartUpUtil.getSingletonClassInstance("generated.de.vw.mib.asl.internal.flowlistmenu.ASLFlowListMenuDeviceImpl"))) {
                aSLDeviceRegistry.registerASLDevice(aSLDevice);
            }
            if (null != (aSLDevice = (ASLDevice)StartUpUtil.getSingletonClassInstance("generated.de.vw.mib.asl.internal.globalgoodbye.ASLGlobalGoodByeDeviceImpl"))) {
                aSLDeviceRegistry.registerASLDevice(aSLDevice);
            }
            if (null != (aSLDevice = (ASLDevice)StartUpUtil.getSingletonClassInstance("generated.de.vw.mib.asl.internal.globalsetupwizard.ASLGlobalSetupWizardDeviceImpl"))) {
                aSLDeviceRegistry.registerASLDevice(aSLDevice);
            }
            if (null != (aSLDevice = (ASLDevice)StartUpUtil.getSingletonClassInstance("generated.de.vw.mib.asl.internal.gridmenu.ASLGridMenuDeviceImpl"))) {
                aSLDeviceRegistry.registerASLDevice(aSLDevice);
            }
            if (null != (aSLDevice = (ASLDevice)StartUpUtil.getSingletonClassInstance("generated.de.vw.mib.asl.internal.hmioffclock.ASLHMIOffClockDeviceImpl"))) {
                aSLDeviceRegistry.registerASLDevice(aSLDevice);
            }
            if (null != (aSLDevice = (ASLDevice)StartUpUtil.getSingletonClassInstance("generated.de.vw.mib.asl.internal.hwr.ASLHWRDeviceImpl"))) {
                aSLDeviceRegistry.registerASLDevice(aSLDevice);
            }
            if (null != (aSLDevice = (ASLDevice)StartUpUtil.getSingletonClassInstance("generated.de.vw.mib.asl.internal.homescreen.ASLHomeScreenDeviceImpl"))) {
                aSLDeviceRegistry.registerASLDevice(aSLDevice);
            }
            if (null != (aSLDevice = (ASLDevice)StartUpUtil.getSingletonClassInstance("generated.de.vw.mib.asl.internal.homescreen.info.ASLHomeScreenInfoDeviceImpl"))) {
                aSLDeviceRegistry.registerASLDevice(aSLDevice);
            }
            if (null != (aSLDevice = (ASLDevice)StartUpUtil.getSingletonClassInstance("generated.de.vw.mib.asl.internal.homebutton.ASLHomebuttonDeviceImpl"))) {
                aSLDeviceRegistry.registerASLDevice(aSLDevice);
            }
            if (null != (aSLDevice = (ASLDevice)StartUpUtil.getSingletonClassInstance("generated.de.vw.mib.asl.internal.internetbrowser.ASLInternetbrowserDeviceImpl"))) {
                aSLDeviceRegistry.registerASLDevice(aSLDevice);
            }
            if (null != (aSLDevice = (ASLDevice)StartUpUtil.getSingletonClassInstance("generated.de.vw.mib.asl.internal.mediacontrol.ASLMediaControlDeviceImpl"))) {
                aSLDeviceRegistry.registerASLDevice(aSLDevice);
            }
            if (null != (aSLDevice = (ASLDevice)StartUpUtil.getSingletonClassInstance("generated.de.vw.mib.asl.internal.mediacontrol.browser.ASLMediaControlBrowserDeviceImpl"))) {
                aSLDeviceRegistry.registerASLDevice(aSLDevice);
            }
            if (null != (aSLDevice = (ASLDevice)StartUpUtil.getSingletonClassInstance("generated.de.vw.mib.asl.internal.mediacontrol.opendevice.ASLMediaControlOpenDeviceDeviceImpl"))) {
                aSLDeviceRegistry.registerASLDevice(aSLDevice);
            }
            if (null != (aSLDevice = (ASLDevice)StartUpUtil.getSingletonClassInstance("generated.de.vw.mib.asl.internal.messages.ASLMessagesDeviceImpl"))) {
                aSLDeviceRegistry.registerASLDevice(aSLDevice);
            }
            if (null != (aSLDevice = (ASLDevice)StartUpUtil.getSingletonClassInstance("generated.de.vw.mib.asl.internal.messages.contacts.ASLMessagesContactsDeviceImpl"))) {
                aSLDeviceRegistry.registerASLDevice(aSLDevice);
            }
            if (null != (aSLDevice = (ASLDevice)StartUpUtil.getSingletonClassInstance("generated.de.vw.mib.asl.internal.messages.contacts.search.ASLMessagesContactsSearchDeviceImpl"))) {
                aSLDeviceRegistry.registerASLDevice(aSLDevice);
            }
            if (null != (aSLDevice = (ASLDevice)StartUpUtil.getSingletonClassInstance("generated.de.vw.mib.asl.internal.messages.number.ASLMessagesNumberDeviceImpl"))) {
                aSLDeviceRegistry.registerASLDevice(aSLDevice);
            }
            if (null != (aSLDevice = (ASLDevice)StartUpUtil.getSingletonClassInstance("generated.de.vw.mib.asl.internal.messages.setup.ASLMessagesSetupDeviceImpl"))) {
                aSLDeviceRegistry.registerASLDevice(aSLDevice);
            }
            if (null != (aSLDevice = (ASLDevice)StartUpUtil.getSingletonClassInstance("generated.de.vw.mib.asl.internal.messages.setup.email.ASLMessagesSetupEMailDeviceImpl"))) {
                aSLDeviceRegistry.registerASLDevice(aSLDevice);
            }
            if (null != (aSLDevice = (ASLDevice)StartUpUtil.getSingletonClassInstance("generated.de.vw.mib.asl.internal.messages.setup.servicenumber.ASLMessagesSetupServiceNumberDeviceImpl"))) {
                aSLDeviceRegistry.registerASLDevice(aSLDevice);
            }
            if (null != (aSLDevice = (ASLDevice)StartUpUtil.getSingletonClassInstance("generated.de.vw.mib.asl.internal.messages.write.ASLMessagesWriteDeviceImpl"))) {
                aSLDeviceRegistry.registerASLDevice(aSLDevice);
            }
            if (null != (aSLDevice = (ASLDevice)StartUpUtil.getSingletonClassInstance("generated.de.vw.mib.asl.internal.mirrorlink.ASLMirrorlinkDeviceImpl"))) {
                aSLDeviceRegistry.registerASLDevice(aSLDevice);
            }
            if (null != (aSLDevice = (ASLDevice)StartUpUtil.getSingletonClassInstance("generated.de.vw.mib.asl.internal.navinfotile.ASLNavInfoTileDeviceImpl"))) {
                aSLDeviceRegistry.registerASLDevice(aSLDevice);
            }
            if (null != (aSLDevice = (ASLDevice)StartUpUtil.getSingletonClassInstance("generated.de.vw.mib.asl.internal.navinfotile.maneuverviewtenitems.ASLNavInfoTileManeuverViewTenItemsDeviceImpl"))) {
                aSLDeviceRegistry.registerASLDevice(aSLDevice);
            }
            if (null != (aSLDevice = (ASLDevice)StartUpUtil.getSingletonClassInstance("generated.de.vw.mib.asl.internal.navinfotile.motorwayinfo.ASLNavInfoTileMotorwayInfoDeviceImpl"))) {
                aSLDeviceRegistry.registerASLDevice(aSLDevice);
            }
            if (null != (aSLDevice = (ASLDevice)StartUpUtil.getSingletonClassInstance("generated.de.vw.mib.asl.internal.navinfotile.overlay.ASLNavInfoTileOverlayDeviceImpl"))) {
                aSLDeviceRegistry.registerASLDevice(aSLDevice);
            }
            if (null != (aSLDevice = (ASLDevice)StartUpUtil.getSingletonClassInstance("generated.de.vw.mib.asl.internal.navinfotile.pnav.ASLNavInfoTilePnavDeviceImpl"))) {
                aSLDeviceRegistry.registerASLDevice(aSLDevice);
            }
            if (null != (aSLDevice = (ASLDevice)StartUpUtil.getSingletonClassInstance("generated.de.vw.mib.asl.internal.navinfotile.waypointmode.ASLNavInfoTileWayPointModeDeviceImpl"))) {
                aSLDeviceRegistry.registerASLDevice(aSLDevice);
            }
            if (null != (aSLDevice = (ASLDevice)StartUpUtil.getSingletonClassInstance("generated.de.vw.mib.asl.internal.navmaptile.ASLNavMapTileDeviceImpl"))) {
                aSLDeviceRegistry.registerASLDevice(aSLDevice);
            }
            if (null != (aSLDevice = (ASLDevice)StartUpUtil.getSingletonClassInstance("generated.de.vw.mib.asl.internal.navmaptile.guidance.ASLNavMapTileGuidanceDeviceImpl"))) {
                aSLDeviceRegistry.registerASLDevice(aSLDevice);
            }
            if (null != (aSLDevice = (ASLDevice)StartUpUtil.getSingletonClassInstance("generated.de.vw.mib.asl.internal.navmaptile.map.ASLNavMapTileMapDeviceImpl"))) {
                aSLDeviceRegistry.registerASLDevice(aSLDevice);
            }
            if (null != (aSLDevice = (ASLDevice)StartUpUtil.getSingletonClassInstance("generated.de.vw.mib.asl.internal.navmaptile.map.view.ASLNavMapTileMapViewDeviceImpl"))) {
                aSLDeviceRegistry.registerASLDevice(aSLDevice);
            }
            if (null != (aSLDevice = (ASLDevice)StartUpUtil.getSingletonClassInstance("generated.de.vw.mib.asl.internal.navmaptile.onlineservice.ASLNavMapTileOnlineServiceDeviceImpl"))) {
                aSLDeviceRegistry.registerASLDevice(aSLDevice);
            }
            if (null != (aSLDevice = (ASLDevice)StartUpUtil.getSingletonClassInstance("generated.de.vw.mib.asl.internal.navmaptile.setup.ASLNavMapTileSetupDeviceImpl"))) {
                aSLDeviceRegistry.registerASLDevice(aSLDevice);
            }
            if (null != (aSLDevice = (ASLDevice)StartUpUtil.getSingletonClassInstance("generated.de.vw.mib.asl.internal.navtraffictiles.ASLNavTrafficTileSDeviceImpl"))) {
                aSLDeviceRegistry.registerASLDevice(aSLDevice);
            }
            if (null != (aSLDevice = (ASLDevice)StartUpUtil.getSingletonClassInstance("generated.de.vw.mib.asl.internal.navigation.ASLNavigationDeviceImpl"))) {
                aSLDeviceRegistry.registerASLDevice(aSLDevice);
            }
            if (null != (aSLDevice = (ASLDevice)StartUpUtil.getSingletonClassInstance("generated.de.vw.mib.asl.internal.navigation.bap.ASLNavigationBapDeviceImpl"))) {
                aSLDeviceRegistry.registerASLDevice(aSLDevice);
            }
            if (null != (aSLDevice = (ASLDevice)StartUpUtil.getSingletonClassInstance("generated.de.vw.mib.asl.internal.navigation.borderchange.ASLNavigationBorderChangeDeviceImpl"))) {
                aSLDeviceRegistry.registerASLDevice(aSLDevice);
            }
            if (null != (aSLDevice = (ASLDevice)StartUpUtil.getSingletonClassInstance("generated.de.vw.mib.asl.internal.navigation.crosshairmode.ASLNavigationCrosshairModeDeviceImpl"))) {
                aSLDeviceRegistry.registerASLDevice(aSLDevice);
            }
            if (null != (aSLDevice = (ASLDevice)StartUpUtil.getSingletonClassInstance("generated.de.vw.mib.asl.internal.navigation.debug.ASLNavigationDebugDeviceImpl"))) {
                aSLDeviceRegistry.registerASLDevice(aSLDevice);
            }
            if (null != (aSLDevice = (ASLDevice)StartUpUtil.getSingletonClassInstance("generated.de.vw.mib.asl.internal.navigation.destinput.ASLNavigationDestInputDeviceImpl"))) {
                aSLDeviceRegistry.registerASLDevice(aSLDevice);
            }
            if (null != (aSLDevice = (ASLDevice)StartUpUtil.getSingletonClassInstance("generated.de.vw.mib.asl.internal.navigation.destinput.destlist.ASLNavigationDestInputDestListDeviceImpl"))) {
                aSLDeviceRegistry.registerASLDevice(aSLDevice);
            }
            if (null != (aSLDevice = (ASLDevice)StartUpUtil.getSingletonClassInstance("generated.de.vw.mib.asl.internal.navigation.destinput.gps.ASLNavigationDestInputGPSDeviceImpl"))) {
                aSLDeviceRegistry.registerASLDevice(aSLDevice);
            }
            if (null != (aSLDevice = (ASLDevice)StartUpUtil.getSingletonClassInstance("generated.de.vw.mib.asl.internal.navigation.detail.ASLNavigationDetailDeviceImpl"))) {
                aSLDeviceRegistry.registerASLDevice(aSLDevice);
            }
            if (null != (aSLDevice = (ASLDevice)StartUpUtil.getSingletonClassInstance("generated.de.vw.mib.asl.internal.navigation.dualscreen.ASLNavigationDualScreenDeviceImpl"))) {
                aSLDeviceRegistry.registerASLDevice(aSLDevice);
            }
            if (null != (aSLDevice = (ASLDevice)StartUpUtil.getSingletonClassInstance("generated.de.vw.mib.asl.internal.navigation.guidance.ASLNavigationGuidanceDeviceImpl"))) {
                aSLDeviceRegistry.registerASLDevice(aSLDevice);
            }
            if (null != (aSLDevice = (ASLDevice)StartUpUtil.getSingletonClassInstance("generated.de.vw.mib.asl.internal.navigation.homedestinput.ASLNavigationHomeDestInputDeviceImpl"))) {
                aSLDeviceRegistry.registerASLDevice(aSLDevice);
            }
            if (null != (aSLDevice = (ASLDevice)StartUpUtil.getSingletonClassInstance("generated.de.vw.mib.asl.internal.navigation.locationinput.ASLNavigationLocationInputDeviceImpl"))) {
                aSLDeviceRegistry.registerASLDevice(aSLDevice);
            }
            if (null != (aSLDevice = (ASLDevice)StartUpUtil.getSingletonClassInstance("generated.de.vw.mib.asl.internal.navigation.locationinput.inputfield.ASLNavigationLocationInputInputFieldDeviceImpl"))) {
                aSLDeviceRegistry.registerASLDevice(aSLDevice);
            }
            if (null != (aSLDevice = (ASLDevice)StartUpUtil.getSingletonClassInstance("generated.de.vw.mib.asl.internal.navigation.locationinput.inputfield.city.ASLNavigationLocationInputInputFieldCityDeviceImpl"))) {
                aSLDeviceRegistry.registerASLDevice(aSLDevice);
            }
            if (null != (aSLDevice = (ASLDevice)StartUpUtil.getSingletonClassInstance("generated.de.vw.mib.asl.internal.navigation.locationinput.inputfield.country.ASLNavigationLocationInputInputFieldCountryDeviceImpl"))) {
                aSLDeviceRegistry.registerASLDevice(aSLDevice);
            }
            if (null != (aSLDevice = (ASLDevice)StartUpUtil.getSingletonClassInstance("generated.de.vw.mib.asl.internal.navigation.locationinput.inputfield.crossing.ASLNavigationLocationInputInputFieldCrossingDeviceImpl"))) {
                aSLDeviceRegistry.registerASLDevice(aSLDevice);
            }
            if (null != (aSLDevice = (ASLDevice)StartUpUtil.getSingletonClassInstance("generated.de.vw.mib.asl.internal.navigation.locationinput.inputfield.housenumber.ASLNavigationLocationInputInputFieldHousenumberDeviceImpl"))) {
                aSLDeviceRegistry.registerASLDevice(aSLDevice);
            }
            if (null != (aSLDevice = (ASLDevice)StartUpUtil.getSingletonClassInstance("generated.de.vw.mib.asl.internal.navigation.locationinput.inputfield.mapcode.ASLNavigationLocationInputInputFieldMapcodeDeviceImpl"))) {
                aSLDeviceRegistry.registerASLDevice(aSLDevice);
            }
            if (null != (aSLDevice = (ASLDevice)StartUpUtil.getSingletonClassInstance("generated.de.vw.mib.asl.internal.navigation.locationinput.inputfield.phonenumber.ASLNavigationLocationInputInputFieldPhonenumberDeviceImpl"))) {
                aSLDeviceRegistry.registerASLDevice(aSLDevice);
            }
            if (null != (aSLDevice = (ASLDevice)StartUpUtil.getSingletonClassInstance("generated.de.vw.mib.asl.internal.navigation.locationinput.inputfield.postalcode.ASLNavigationLocationInputInputFieldPostalCodeDeviceImpl"))) {
                aSLDeviceRegistry.registerASLDevice(aSLDevice);
            }
            if (null != (aSLDevice = (ASLDevice)StartUpUtil.getSingletonClassInstance("generated.de.vw.mib.asl.internal.navigation.locationinput.inputfield.province.ASLNavigationLocationInputInputFieldProvinceDeviceImpl"))) {
                aSLDeviceRegistry.registerASLDevice(aSLDevice);
            }
            if (null != (aSLDevice = (ASLDevice)StartUpUtil.getSingletonClassInstance("generated.de.vw.mib.asl.internal.navigation.locationinput.inputfield.state.ASLNavigationLocationInputInputFieldStateDeviceImpl"))) {
                aSLDeviceRegistry.registerASLDevice(aSLDevice);
            }
            if (null != (aSLDevice = (ASLDevice)StartUpUtil.getSingletonClassInstance("generated.de.vw.mib.asl.internal.navigation.locationinput.inputfield.street.ASLNavigationLocationInputInputFieldStreetDeviceImpl"))) {
                aSLDeviceRegistry.registerASLDevice(aSLDevice);
            }
            if (null != (aSLDevice = (ASLDevice)StartUpUtil.getSingletonClassInstance("generated.de.vw.mib.asl.internal.navigation.locationinput.inputfield.streetdisambiguation.ASLNavigationLocationInputInputFieldStreetDisambiguationDeviceImpl"))) {
                aSLDeviceRegistry.registerASLDevice(aSLDevice);
            }
            if (null != (aSLDevice = (ASLDevice)StartUpUtil.getSingletonClassInstance("generated.de.vw.mib.asl.internal.navigation.locationinput.inputfield.streetwithbasenames.ASLNavigationLocationInputInputFieldStreetWithBasenamesDeviceImpl"))) {
                aSLDeviceRegistry.registerASLDevice(aSLDevice);
            }
            if (null != (aSLDevice = (ASLDevice)StartUpUtil.getSingletonClassInstance("generated.de.vw.mib.asl.internal.navigation.maneuverviewtenitems.ASLNavigationManeuverViewTenItemsDeviceImpl"))) {
                aSLDeviceRegistry.registerASLDevice(aSLDevice);
            }
            if (null != (aSLDevice = (ASLDevice)StartUpUtil.getSingletonClassInstance("generated.de.vw.mib.asl.internal.navigation.map.ASLNavigationMapDeviceImpl"))) {
                aSLDeviceRegistry.registerASLDevice(aSLDevice);
            }
            if (null != (aSLDevice = (ASLDevice)StartUpUtil.getSingletonClassInstance("generated.de.vw.mib.asl.internal.navigation.map.clickinmap.ASLNavigationMapClickInMapDeviceImpl"))) {
                aSLDeviceRegistry.registerASLDevice(aSLDevice);
            }
            if (null != (aSLDevice = (ASLDevice)StartUpUtil.getSingletonClassInstance("generated.de.vw.mib.asl.internal.navigation.map.duallistview.ASLNavigationMapDualListViewDeviceImpl"))) {
                aSLDeviceRegistry.registerASLDevice(aSLDevice);
            }
            if (null != (aSLDevice = (ASLDevice)StartUpUtil.getSingletonClassInstance("generated.de.vw.mib.asl.internal.navigation.map.maneuverview.ASLNavigationMapManeuverViewDeviceImpl"))) {
                aSLDeviceRegistry.registerASLDevice(aSLDevice);
            }
            if (null != (aSLDevice = (ASLDevice)StartUpUtil.getSingletonClassInstance("generated.de.vw.mib.asl.internal.navigation.map.rubberband.ASLNavigationMapRubberbandDeviceImpl"))) {
                aSLDeviceRegistry.registerASLDevice(aSLDevice);
            }
            if (null != (aSLDevice = (ASLDevice)StartUpUtil.getSingletonClassInstance("generated.de.vw.mib.asl.internal.navigation.map.ss.ASLNavigationMapSSDeviceImpl"))) {
                aSLDeviceRegistry.registerASLDevice(aSLDevice);
            }
            if (null != (aSLDevice = (ASLDevice)StartUpUtil.getSingletonClassInstance("generated.de.vw.mib.asl.internal.navigation.map.setup.ASLNavigationMapSetupDeviceImpl"))) {
                aSLDeviceRegistry.registerASLDevice(aSLDevice);
            }
            if (null != (aSLDevice = (ASLDevice)StartUpUtil.getSingletonClassInstance("generated.de.vw.mib.asl.internal.navigation.map.view.ASLNavigationMapViewDeviceImpl"))) {
                aSLDeviceRegistry.registerASLDevice(aSLDevice);
            }
            if (null != (aSLDevice = (ASLDevice)StartUpUtil.getSingletonClassInstance("generated.de.vw.mib.asl.internal.navigation.memory.ASLNavigationMemoryDeviceImpl"))) {
                aSLDeviceRegistry.registerASLDevice(aSLDevice);
            }
            if (null != (aSLDevice = (ASLDevice)StartUpUtil.getSingletonClassInstance("generated.de.vw.mib.asl.internal.navigation.memory.sd.ASLNavigationMemorySDDeviceImpl"))) {
                aSLDeviceRegistry.registerASLDevice(aSLDevice);
            }
            if (null != (aSLDevice = (ASLDevice)StartUpUtil.getSingletonClassInstance("generated.de.vw.mib.asl.internal.navigation.mostkombi.map.ASLNavigationMostKombiMapDeviceImpl"))) {
                aSLDeviceRegistry.registerASLDevice(aSLDevice);
            }
            if (null != (aSLDevice = (ASLDevice)StartUpUtil.getSingletonClassInstance("generated.de.vw.mib.asl.internal.navigation.motorwayinfo.ASLNavigationMotorwayInfoDeviceImpl"))) {
                aSLDeviceRegistry.registerASLDevice(aSLDevice);
            }
            if (null != (aSLDevice = (ASLDevice)StartUpUtil.getSingletonClassInstance("generated.de.vw.mib.asl.internal.navigation.onlineservice.ASLNavigationOnlineServiceDeviceImpl"))) {
                aSLDeviceRegistry.registerASLDevice(aSLDevice);
            }
            if (null != (aSLDevice = (ASLDevice)StartUpUtil.getSingletonClassInstance("generated.de.vw.mib.asl.internal.navigation.onlineservice.internetbrowser.ASLNavigationOnlineServiceInternetbrowserDeviceImpl"))) {
                aSLDeviceRegistry.registerASLDevice(aSLDevice);
            }
            if (null != (aSLDevice = (ASLDevice)StartUpUtil.getSingletonClassInstance("generated.de.vw.mib.asl.internal.navigation.overlay.ASLNavigationOverlayDeviceImpl"))) {
                aSLDeviceRegistry.registerASLDevice(aSLDevice);
            }
            if (null != (aSLDevice = (ASLDevice)StartUpUtil.getSingletonClassInstance("generated.de.vw.mib.asl.internal.navigation.overlay.setup.ASLNavigationOverlaySetupDeviceImpl"))) {
                aSLDeviceRegistry.registerASLDevice(aSLDevice);
            }
            if (null != (aSLDevice = (ASLDevice)StartUpUtil.getSingletonClassInstance("generated.de.vw.mib.asl.internal.navigation.poi.ASLNavigationPOIDeviceImpl"))) {
                aSLDeviceRegistry.registerASLDevice(aSLDevice);
            }
            if (null != (aSLDevice = (ASLDevice)StartUpUtil.getSingletonClassInstance("generated.de.vw.mib.asl.internal.navigation.poi.category.ASLNavigationPOICategoryDeviceImpl"))) {
                aSLDeviceRegistry.registerASLDevice(aSLDevice);
            }
            if (null != (aSLDevice = (ASLDevice)StartUpUtil.getSingletonClassInstance("generated.de.vw.mib.asl.internal.navigation.poi.onlineservices.ASLNavigationPOIOnlineServicesDeviceImpl"))) {
                aSLDeviceRegistry.registerASLDevice(aSLDevice);
            }
            if (null != (aSLDevice = (ASLDevice)StartUpUtil.getSingletonClassInstance("generated.de.vw.mib.asl.internal.navigation.poi.setup.ASLNavigationPOISetupDeviceImpl"))) {
                aSLDeviceRegistry.registerASLDevice(aSLDevice);
            }
            if (null != (aSLDevice = (ASLDevice)StartUpUtil.getSingletonClassInstance("generated.de.vw.mib.asl.internal.navigation.personalpoi.ASLNavigationPersonalPOIDeviceImpl"))) {
                aSLDeviceRegistry.registerASLDevice(aSLDevice);
            }
            if (null != (aSLDevice = (ASLDevice)StartUpUtil.getSingletonClassInstance("generated.de.vw.mib.asl.internal.navigation.personalpoi.category.ASLNavigationPersonalPOICategoryDeviceImpl"))) {
                aSLDeviceRegistry.registerASLDevice(aSLDevice);
            }
            if (null != (aSLDevice = (ASLDevice)StartUpUtil.getSingletonClassInstance("generated.de.vw.mib.asl.internal.navigation.pnav.ASLNavigationPnavDeviceImpl"))) {
                aSLDeviceRegistry.registerASLDevice(aSLDevice);
            }
            if (null != (aSLDevice = (ASLDevice)StartUpUtil.getSingletonClassInstance("generated.de.vw.mib.asl.internal.navigation.routeoptions.ASLNavigationRouteOptionsDeviceImpl"))) {
                aSLDeviceRegistry.registerASLDevice(aSLDevice);
            }
            if (null != (aSLDevice = (ASLDevice)StartUpUtil.getSingletonClassInstance("generated.de.vw.mib.asl.internal.navigation.setup.ASLNavigationSetupDeviceImpl"))) {
                aSLDeviceRegistry.registerASLDevice(aSLDevice);
            }
            if (null != (aSLDevice = (ASLDevice)StartUpUtil.getSingletonClassInstance("generated.de.vw.mib.asl.internal.navigation.shield.ASLNavigationShieldDeviceImpl"))) {
                aSLDeviceRegistry.registerASLDevice(aSLDevice);
            }
            if (null != (aSLDevice = (ASLDevice)StartUpUtil.getSingletonClassInstance("generated.de.vw.mib.asl.internal.navigation.speech.ASLNavigationSpeechDeviceImpl"))) {
                aSLDeviceRegistry.registerASLDevice(aSLDevice);
            }
            if (null != (aSLDevice = (ASLDevice)StartUpUtil.getSingletonClassInstance("generated.de.vw.mib.asl.internal.navigation.speech.map.ASLNavigationSpeechMapDeviceImpl"))) {
                aSLDeviceRegistry.registerASLDevice(aSLDevice);
            }
            if (null != (aSLDevice = (ASLDevice)StartUpUtil.getSingletonClassInstance("generated.de.vw.mib.asl.internal.navigation.speech.oneshot.ASLNavigationSpeechOneshotDeviceImpl"))) {
                aSLDeviceRegistry.registerASLDevice(aSLDevice);
            }
            if (null != (aSLDevice = (ASLDevice)StartUpUtil.getSingletonClassInstance("generated.de.vw.mib.asl.internal.navigation.tourmode.ASLNavigationTourModeDeviceImpl"))) {
                aSLDeviceRegistry.registerASLDevice(aSLDevice);
            }
            if (null != (aSLDevice = (ASLDevice)StartUpUtil.getSingletonClassInstance("generated.de.vw.mib.asl.internal.navigation.traffic.ASLNavigationTrafficDeviceImpl"))) {
                aSLDeviceRegistry.registerASLDevice(aSLDevice);
            }
            if (null != (aSLDevice = (ASLDevice)StartUpUtil.getSingletonClassInstance("generated.de.vw.mib.asl.internal.navigation.via.ASLNavigationViaDeviceImpl"))) {
                aSLDeviceRegistry.registerASLDevice(aSLDevice);
            }
            if (null != (aSLDevice = (ASLDevice)StartUpUtil.getSingletonClassInstance("generated.de.vw.mib.asl.internal.navigation.waypointmode.ASLNavigationWayPointModeDeviceImpl"))) {
                aSLDeviceRegistry.registerASLDevice(aSLDevice);
            }
            if (null != (aSLDevice = (ASLDevice)StartUpUtil.getSingletonClassInstance("generated.de.vw.mib.asl.internal.online.ASLOnlineDeviceImpl"))) {
                aSLDeviceRegistry.registerASLDevice(aSLDevice);
            }
            if (null != (aSLDevice = (ASLDevice)StartUpUtil.getSingletonClassInstance("generated.de.vw.mib.asl.internal.onlinelogbook.ASLOnlineLogBookDeviceImpl"))) {
                aSLDeviceRegistry.registerASLDevice(aSLDevice);
            }
            if (null != (aSLDevice = (ASLDevice)StartUpUtil.getSingletonClassInstance("generated.de.vw.mib.asl.internal.phone.ASLPhoneDeviceImpl"))) {
                aSLDeviceRegistry.registerASLDevice(aSLDevice);
            }
            if (null != (aSLDevice = (ASLDevice)StartUpUtil.getSingletonClassInstance("generated.de.vw.mib.asl.internal.phone.appconnect.ASLPhoneAppConnectDeviceImpl"))) {
                aSLDeviceRegistry.registerASLDevice(aSLDevice);
            }
            if (null != (aSLDevice = (ASLDevice)StartUpUtil.getSingletonClassInstance("generated.de.vw.mib.asl.internal.phone.bap.ASLPhoneBAPDeviceImpl"))) {
                aSLDeviceRegistry.registerASLDevice(aSLDevice);
            }
            if (null != (aSLDevice = (ASLDevice)StartUpUtil.getSingletonClassInstance("generated.de.vw.mib.asl.internal.phone.bap.contacts.ASLPhoneBAPContactsDeviceImpl"))) {
                aSLDeviceRegistry.registerASLDevice(aSLDevice);
            }
            if (null != (aSLDevice = (ASLDevice)StartUpUtil.getSingletonClassInstance("generated.de.vw.mib.asl.internal.phone.bap.contactsspeller.ASLPhoneBAPContactsSpellerDeviceImpl"))) {
                aSLDeviceRegistry.registerASLDevice(aSLDevice);
            }
            if (null != (aSLDevice = (ASLDevice)StartUpUtil.getSingletonClassInstance("generated.de.vw.mib.asl.internal.phone.bap.dialedcalls.ASLPhoneBAPDialedCallsDeviceImpl"))) {
                aSLDeviceRegistry.registerASLDevice(aSLDevice);
            }
            if (null != (aSLDevice = (ASLDevice)StartUpUtil.getSingletonClassInstance("generated.de.vw.mib.asl.internal.phone.bap.missedcalls.ASLPhoneBAPMissedCallsDeviceImpl"))) {
                aSLDeviceRegistry.registerASLDevice(aSLDevice);
            }
            if (null != (aSLDevice = (ASLDevice)StartUpUtil.getSingletonClassInstance("generated.de.vw.mib.asl.internal.phone.bap.mixedcalls.ASLPhoneBAPMixedCallsDeviceImpl"))) {
                aSLDeviceRegistry.registerASLDevice(aSLDevice);
            }
            if (null != (aSLDevice = (ASLDevice)StartUpUtil.getSingletonClassInstance("generated.de.vw.mib.asl.internal.phone.bap.receivedcalls.ASLPhoneBAPReceivedCallsDeviceImpl"))) {
                aSLDeviceRegistry.registerASLDevice(aSLDevice);
            }
            if (null != (aSLDevice = (ASLDevice)StartUpUtil.getSingletonClassInstance("generated.de.vw.mib.asl.internal.phone.bluetooth.ASLPhoneBluetoothDeviceImpl"))) {
                aSLDeviceRegistry.registerASLDevice(aSLDevice);
            }
            if (null != (aSLDevice = (ASLDevice)StartUpUtil.getSingletonClassInstance("generated.de.vw.mib.asl.internal.phone.bluetooth.pin.ASLPhoneBluetoothPINDeviceImpl"))) {
                aSLDeviceRegistry.registerASLDevice(aSLDevice);
            }
            if (null != (aSLDevice = (ASLDevice)StartUpUtil.getSingletonClassInstance("generated.de.vw.mib.asl.internal.phone.bluetooth.passkey.ASLPhoneBluetoothPasskeyDeviceImpl"))) {
                aSLDeviceRegistry.registerASLDevice(aSLDevice);
            }
            if (null != (aSLDevice = (ASLDevice)StartUpUtil.getSingletonClassInstance("generated.de.vw.mib.asl.internal.phone.bluetooth.userid.ASLPhoneBluetoothUserIDDeviceImpl"))) {
                aSLDeviceRegistry.registerASLDevice(aSLDevice);
            }
            if (null != (aSLDevice = (ASLDevice)StartUpUtil.getSingletonClassInstance("generated.de.vw.mib.asl.internal.phone.call.ASLPhoneCallDeviceImpl"))) {
                aSLDeviceRegistry.registerASLDevice(aSLDevice);
            }
            if (null != (aSLDevice = (ASLDevice)StartUpUtil.getSingletonClassInstance("generated.de.vw.mib.asl.internal.phone.call.conference.ASLPhoneCallConferenceDeviceImpl"))) {
                aSLDeviceRegistry.registerASLDevice(aSLDevice);
            }
            if (null != (aSLDevice = (ASLDevice)StartUpUtil.getSingletonClassInstance("generated.de.vw.mib.asl.internal.phone.call.deferred.ASLPhoneCallDeferredDeviceImpl"))) {
                aSLDeviceRegistry.registerASLDevice(aSLDevice);
            }
            if (null != (aSLDevice = (ASLDevice)StartUpUtil.getSingletonClassInstance("generated.de.vw.mib.asl.internal.phone.call.dial.ASLPhoneCallDialDeviceImpl"))) {
                aSLDeviceRegistry.registerASLDevice(aSLDevice);
            }
            if (null != (aSLDevice = (ASLDevice)StartUpUtil.getSingletonClassInstance("generated.de.vw.mib.asl.internal.phone.call.ocu.ASLPhoneCallOCUDeviceImpl"))) {
                aSLDeviceRegistry.registerASLDevice(aSLDevice);
            }
            if (null != (aSLDevice = (ASLDevice)StartUpUtil.getSingletonClassInstance("generated.de.vw.mib.asl.internal.phone.callstacks.ASLPhoneCallstacksDeviceImpl"))) {
                aSLDeviceRegistry.registerASLDevice(aSLDevice);
            }
            if (null != (aSLDevice = (ASLDevice)StartUpUtil.getSingletonClassInstance("generated.de.vw.mib.asl.internal.phone.callstacks.acceptedcalls.ASLPhoneCallstacksAcceptedCallsDeviceImpl"))) {
                aSLDeviceRegistry.registerASLDevice(aSLDevice);
            }
            if (null != (aSLDevice = (ASLDevice)StartUpUtil.getSingletonClassInstance("generated.de.vw.mib.asl.internal.phone.callstacks.dialedcalls.ASLPhoneCallstacksDialedCallsDeviceImpl"))) {
                aSLDeviceRegistry.registerASLDevice(aSLDevice);
            }
            if (null != (aSLDevice = (ASLDevice)StartUpUtil.getSingletonClassInstance("generated.de.vw.mib.asl.internal.phone.callstacks.missedcalls.ASLPhoneCallstacksMissedCallsDeviceImpl"))) {
                aSLDeviceRegistry.registerASLDevice(aSLDevice);
            }
            if (null != (aSLDevice = (ASLDevice)StartUpUtil.getSingletonClassInstance("generated.de.vw.mib.asl.internal.phone.callstacks.mixedcalls.ASLPhoneCallstacksMixedCallsDeviceImpl"))) {
                aSLDeviceRegistry.registerASLDevice(aSLDevice);
            }
            if (null != (aSLDevice = (ASLDevice)StartUpUtil.getSingletonClassInstance("generated.de.vw.mib.asl.internal.phone.carplay.ASLPhoneCarPlayDeviceImpl"))) {
                aSLDeviceRegistry.registerASLDevice(aSLDevice);
            }
            if (null != (aSLDevice = (ASLDevice)StartUpUtil.getSingletonClassInstance("generated.de.vw.mib.asl.internal.phone.contacts.ASLPhoneContactsDeviceImpl"))) {
                aSLDeviceRegistry.registerASLDevice(aSLDevice);
            }
            if (null != (aSLDevice = (ASLDevice)StartUpUtil.getSingletonClassInstance("generated.de.vw.mib.asl.internal.phone.contacts.search.ASLPhoneContactsSearchDeviceImpl"))) {
                aSLDeviceRegistry.registerASLDevice(aSLDevice);
            }
            if (null != (aSLDevice = (ASLDevice)StartUpUtil.getSingletonClassInstance("generated.de.vw.mib.asl.internal.phone.has.ASLPhoneHASDeviceImpl"))) {
                aSLDeviceRegistry.registerASLDevice(aSLDevice);
            }
            if (null != (aSLDevice = (ASLDevice)StartUpUtil.getSingletonClassInstance("generated.de.vw.mib.asl.internal.phone.pin.ASLPhonePINDeviceImpl"))) {
                aSLDeviceRegistry.registerASLDevice(aSLDevice);
            }
            if (null != (aSLDevice = (ASLDevice)StartUpUtil.getSingletonClassInstance("generated.de.vw.mib.asl.internal.phone.puk.ASLPhonePUKDeviceImpl"))) {
                aSLDeviceRegistry.registerASLDevice(aSLDevice);
            }
            if (null != (aSLDevice = (ASLDevice)StartUpUtil.getSingletonClassInstance("generated.de.vw.mib.asl.internal.phone.presets.ASLPhonePresetsDeviceImpl"))) {
                aSLDeviceRegistry.registerASLDevice(aSLDevice);
            }
            if (null != (aSLDevice = (ASLDevice)StartUpUtil.getSingletonClassInstance("generated.de.vw.mib.asl.internal.phone.presets.number.ASLPhonePresetsNumberDeviceImpl"))) {
                aSLDeviceRegistry.registerASLDevice(aSLDevice);
            }
            if (null != (aSLDevice = (ASLDevice)StartUpUtil.getSingletonClassInstance("generated.de.vw.mib.asl.internal.phone.selection.contacts.ASLPhoneSelectionContactsDeviceImpl"))) {
                aSLDeviceRegistry.registerASLDevice(aSLDevice);
            }
            if (null != (aSLDevice = (ASLDevice)StartUpUtil.getSingletonClassInstance("generated.de.vw.mib.asl.internal.phone.selection.media.ASLPhoneSelectionMediaDeviceImpl"))) {
                aSLDeviceRegistry.registerASLDevice(aSLDevice);
            }
            if (null != (aSLDevice = (ASLDevice)StartUpUtil.getSingletonClassInstance("generated.de.vw.mib.asl.internal.phone.selection.network.ASLPhoneSelectionNetworkDeviceImpl"))) {
                aSLDeviceRegistry.registerASLDevice(aSLDevice);
            }
            if (null != (aSLDevice = (ASLDevice)StartUpUtil.getSingletonClassInstance("generated.de.vw.mib.asl.internal.phone.selection.phone.ASLPhoneSelectionPhoneDeviceImpl"))) {
                aSLDeviceRegistry.registerASLDevice(aSLDevice);
            }
            if (null != (aSLDevice = (ASLDevice)StartUpUtil.getSingletonClassInstance("generated.de.vw.mib.asl.internal.phone.setup.bluetooth.ASLPhoneSetupBluetoothDeviceImpl"))) {
                aSLDeviceRegistry.registerASLDevice(aSLDevice);
            }
            if (null != (aSLDevice = (ASLDevice)StartUpUtil.getSingletonClassInstance("generated.de.vw.mib.asl.internal.phone.setup.bluetooth.name.ASLPhoneSetupBluetoothNameDeviceImpl"))) {
                aSLDeviceRegistry.registerASLDevice(aSLDevice);
            }
            if (null != (aSLDevice = (ASLDevice)StartUpUtil.getSingletonClassInstance("generated.de.vw.mib.asl.internal.phone.setup.call.ASLPhoneSetupCallDeviceImpl"))) {
                aSLDeviceRegistry.registerASLDevice(aSLDevice);
            }
            if (null != (aSLDevice = (ASLDevice)StartUpUtil.getSingletonClassInstance("generated.de.vw.mib.asl.internal.phone.setup.callstacks.ASLPhoneSetupCallstacksDeviceImpl"))) {
                aSLDeviceRegistry.registerASLDevice(aSLDevice);
            }
            if (null != (aSLDevice = (ASLDevice)StartUpUtil.getSingletonClassInstance("generated.de.vw.mib.asl.internal.phone.setup.profiles.ASLPhoneSetupProfilesDeviceImpl"))) {
                aSLDeviceRegistry.registerASLDevice(aSLDevice);
            }
            if (null != (aSLDevice = (ASLDevice)StartUpUtil.getSingletonClassInstance("generated.de.vw.mib.asl.internal.phone.setup.profiles.changename.ASLPhoneSetupProfilesChangeNameDeviceImpl"))) {
                aSLDeviceRegistry.registerASLDevice(aSLDevice);
            }
            if (null != (aSLDevice = (ASLDevice)StartUpUtil.getSingletonClassInstance("generated.de.vw.mib.asl.internal.phone.setup.security.ASLPhoneSetupSecurityDeviceImpl"))) {
                aSLDeviceRegistry.registerASLDevice(aSLDevice);
            }
            if (null != (aSLDevice = (ASLDevice)StartUpUtil.getSingletonClassInstance("generated.de.vw.mib.asl.internal.phone.setup.security.changename.ASLPhoneSetupSecurityChangeNameDeviceImpl"))) {
                aSLDeviceRegistry.registerASLDevice(aSLDevice);
            }
            if (null != (aSLDevice = (ASLDevice)StartUpUtil.getSingletonClassInstance("generated.de.vw.mib.asl.internal.phone.setup.security.pin.ASLPhoneSetupSecurityPINDeviceImpl"))) {
                aSLDeviceRegistry.registerASLDevice(aSLDevice);
            }
            if (null != (aSLDevice = (ASLDevice)StartUpUtil.getSingletonClassInstance("generated.de.vw.mib.asl.internal.phone.setup.settings.ASLPhoneSetupSettingsDeviceImpl"))) {
                aSLDeviceRegistry.registerASLDevice(aSLDevice);
            }
            if (null != (aSLDevice = (ASLDevice)StartUpUtil.getSingletonClassInstance("generated.de.vw.mib.asl.internal.phone.setup.settings.browser.ASLPhoneSetupSettingsBrowserDeviceImpl"))) {
                aSLDeviceRegistry.registerASLDevice(aSLDevice);
            }
            if (null != (aSLDevice = (ASLDevice)StartUpUtil.getSingletonClassInstance("generated.de.vw.mib.asl.internal.phone.setup.settings.dialprefix.ASLPhoneSetupSettingsDialPrefixDeviceImpl"))) {
                aSLDeviceRegistry.registerASLDevice(aSLDevice);
            }
            if (null != (aSLDevice = (ASLDevice)StartUpUtil.getSingletonClassInstance("generated.de.vw.mib.asl.internal.phone.setup.settings.mailbox.ASLPhoneSetupSettingsMailboxDeviceImpl"))) {
                aSLDeviceRegistry.registerASLDevice(aSLDevice);
            }
            if (null != (aSLDevice = (ASLDevice)StartUpUtil.getSingletonClassInstance("generated.de.vw.mib.asl.internal.phone.siri.ASLPhoneSiriDeviceImpl"))) {
                aSLDeviceRegistry.registerASLDevice(aSLDevice);
            }
            if (null != (aSLDevice = (ASLDevice)StartUpUtil.getSingletonClassInstance("generated.de.vw.mib.asl.internal.phone.speech.ASLPhoneSpeechDeviceImpl"))) {
                aSLDeviceRegistry.registerASLDevice(aSLDevice);
            }
            if (null != (aSLDevice = (ASLDevice)StartUpUtil.getSingletonClassInstance("generated.de.vw.mib.asl.internal.phone.wlc.ASLPhoneWLCDeviceImpl"))) {
                aSLDeviceRegistry.registerASLDevice(aSLDevice);
            }
            if (null != (aSLDevice = (ASLDevice)StartUpUtil.getSingletonClassInstance("generated.de.vw.mib.asl.internal.phoneglobalwizardpage.ASLPhoneGlobalWizardPageDeviceImpl"))) {
                aSLDeviceRegistry.registerASLDevice(aSLDevice);
            }
            if (null != (aSLDevice = (ASLDevice)StartUpUtil.getSingletonClassInstance("generated.de.vw.mib.asl.internal.phonetiles.ASLPhoneTileSDeviceImpl"))) {
                aSLDeviceRegistry.registerASLDevice(aSLDevice);
            }
            if (null != (aSLDevice = (ASLDevice)StartUpUtil.getSingletonClassInstance("generated.de.vw.mib.asl.internal.phonetiles.appconnect.ASLPhoneTileSAppConnectDeviceImpl"))) {
                aSLDeviceRegistry.registerASLDevice(aSLDevice);
            }
            if (null != (aSLDevice = (ASLDevice)StartUpUtil.getSingletonClassInstance("generated.de.vw.mib.asl.internal.phonetiles.call.ASLPhoneTileSCallDeviceImpl"))) {
                aSLDeviceRegistry.registerASLDevice(aSLDevice);
            }
            if (null != (aSLDevice = (ASLDevice)StartUpUtil.getSingletonClassInstance("generated.de.vw.mib.asl.internal.phonetiles.presets.ASLPhoneTileSPresetsDeviceImpl"))) {
                aSLDeviceRegistry.registerASLDevice(aSLDevice);
            }
            if (null != (aSLDevice = (ASLDevice)StartUpUtil.getSingletonClassInstance("generated.de.vw.mib.asl.internal.phonetiles.setup.settings.ASLPhoneTileSSetupSettingsDeviceImpl"))) {
                aSLDeviceRegistry.registerASLDevice(aSLDevice);
            }
            if (null != (aSLDevice = (ASLDevice)StartUpUtil.getSingletonClassInstance("generated.de.vw.mib.asl.internal.pictureviewer.ASLPictureViewerDeviceImpl"))) {
                aSLDeviceRegistry.registerASLDevice(aSLDevice);
            }
            if (null != (aSLDevice = (ASLDevice)StartUpUtil.getSingletonClassInstance("generated.de.vw.mib.asl.internal.radio.ASLRadioDeviceImpl"))) {
                aSLDeviceRegistry.registerASLDevice(aSLDevice);
            }
            if (null != (aSLDevice = (ASLDevice)StartUpUtil.getSingletonClassInstance("generated.de.vw.mib.asl.internal.radio.bap.ASLRadioBapDeviceImpl"))) {
                aSLDeviceRegistry.registerASLDevice(aSLDevice);
            }
            if (null != (aSLDevice = (ASLDevice)StartUpUtil.getSingletonClassInstance("generated.de.vw.mib.asl.internal.radio.sat.ASLRadioSATDeviceImpl"))) {
                aSLDeviceRegistry.registerASLDevice(aSLDevice);
            }
            if (null != (aSLDevice = (ASLDevice)StartUpUtil.getSingletonClassInstance("generated.de.vw.mib.asl.internal.radio.usl.ASLRadioUSLDeviceImpl"))) {
                aSLDeviceRegistry.registerASLDevice(aSLDevice);
            }
            if (null != (aSLDevice = (ASLDevice)StartUpUtil.getSingletonClassInstance("generated.de.vw.mib.asl.internal.swap.ASLSWaPDeviceImpl"))) {
                aSLDeviceRegistry.registerASLDevice(aSLDevice);
            }
            if (null != (aSLDevice = (ASLDevice)StartUpUtil.getSingletonClassInstance("generated.de.vw.mib.asl.internal.selectiontilel.ASLSelectionTileLDeviceImpl"))) {
                aSLDeviceRegistry.registerASLDevice(aSLDevice);
            }
            if (null != (aSLDevice = (ASLDevice)StartUpUtil.getSingletonClassInstance("generated.de.vw.mib.asl.internal.selectiontiles.ASLSelectionTileSDeviceImpl"))) {
                aSLDeviceRegistry.registerASLDevice(aSLDevice);
            }
            if (null != (aSLDevice = (ASLDevice)StartUpUtil.getSingletonClassInstance("generated.de.vw.mib.asl.internal.smartphoneintegration.ASLSmartPhoneIntegrationDeviceImpl"))) {
                aSLDeviceRegistry.registerASLDevice(aSLDevice);
            }
            if (null != (aSLDevice = (ASLDevice)StartUpUtil.getSingletonClassInstance("generated.de.vw.mib.asl.internal.sound.ASLSoundDeviceImpl"))) {
                aSLDeviceRegistry.registerASLDevice(aSLDevice);
            }
            if (null != (aSLDevice = (ASLDevice)StartUpUtil.getSingletonClassInstance("generated.de.vw.mib.asl.internal.speechgeneral.ASLSpeechGeneralDeviceImpl"))) {
                aSLDeviceRegistry.registerASLDevice(aSLDevice);
            }
            if (null != (aSLDevice = (ASLDevice)StartUpUtil.getSingletonClassInstance("generated.de.vw.mib.asl.internal.speechgeneral.list.ASLSpeechGeneralListDeviceImpl"))) {
                aSLDeviceRegistry.registerASLDevice(aSLDevice);
            }
            if (null != (aSLDevice = (ASLDevice)StartUpUtil.getSingletonClassInstance("generated.de.vw.mib.asl.internal.speechgeneral.listhandling.ASLSpeechGeneralListHandlingDeviceImpl"))) {
                aSLDeviceRegistry.registerASLDevice(aSLDevice);
            }
            if (null != (aSLDevice = (ASLDevice)StartUpUtil.getSingletonClassInstance("generated.de.vw.mib.asl.internal.speechgeneral.outofdomain.request.ASLSpeechGeneralOutOfDomainRequestDeviceImpl"))) {
                aSLDeviceRegistry.registerASLDevice(aSLDevice);
            }
            if (null != (aSLDevice = (ASLDevice)StartUpUtil.getSingletonClassInstance("generated.de.vw.mib.asl.internal.speechgeneral.outofdomain.response.ASLSpeechGeneralOutOfDomainResponseDeviceImpl"))) {
                aSLDeviceRegistry.registerASLDevice(aSLDevice);
            }
            if (null != (aSLDevice = (ASLDevice)StartUpUtil.getSingletonClassInstance("generated.de.vw.mib.asl.internal.speechgeneral.popup.ASLSpeechGeneralPopupDeviceImpl"))) {
                aSLDeviceRegistry.registerASLDevice(aSLDevice);
            }
            if (null != (aSLDevice = (ASLDevice)StartUpUtil.getSingletonClassInstance("generated.de.vw.mib.asl.internal.speechgeneral.request.ASLSpeechGeneralRequestDeviceImpl"))) {
                aSLDeviceRegistry.registerASLDevice(aSLDevice);
            }
            if (null != (aSLDevice = (ASLDevice)StartUpUtil.getSingletonClassInstance("generated.de.vw.mib.asl.internal.speechgeneral.response.ASLSpeechGeneralResponseDeviceImpl"))) {
                aSLDeviceRegistry.registerASLDevice(aSLDevice);
            }
            if (null != (aSLDevice = (ASLDevice)StartUpUtil.getSingletonClassInstance("generated.de.vw.mib.asl.internal.speechgeneral.speechstartup.ASLSpeechGeneralSpeechStartupDeviceImpl"))) {
                aSLDeviceRegistry.registerASLDevice(aSLDevice);
            }
            if (null != (aSLDevice = (ASLDevice)StartUpUtil.getSingletonClassInstance("generated.de.vw.mib.asl.internal.speechgeneral.teleprompter.ASLSpeechGeneralTeleprompterDeviceImpl"))) {
                aSLDeviceRegistry.registerASLDevice(aSLDevice);
            }
            if (null != (aSLDevice = (ASLDevice)StartUpUtil.getSingletonClassInstance("generated.de.vw.mib.asl.internal.speechheadline.ASLSpeechHeadlineDeviceImpl"))) {
                aSLDeviceRegistry.registerASLDevice(aSLDevice);
            }
            if (null != (aSLDevice = (ASLDevice)StartUpUtil.getSingletonClassInstance("generated.de.vw.mib.asl.internal.speechmedia.ASLSpeechMediaDeviceImpl"))) {
                aSLDeviceRegistry.registerASLDevice(aSLDevice);
            }
            if (null != (aSLDevice = (ASLDevice)StartUpUtil.getSingletonClassInstance("generated.de.vw.mib.asl.internal.speechmedia.listhandling.ASLSpeechMediaListHandlingDeviceImpl"))) {
                aSLDeviceRegistry.registerASLDevice(aSLDevice);
            }
            if (null != (aSLDevice = (ASLDevice)StartUpUtil.getSingletonClassInstance("generated.de.vw.mib.asl.internal.speechmedia.playsimilar.ASLSpeechMediaPlaySimilarDeviceImpl"))) {
                aSLDeviceRegistry.registerASLDevice(aSLDevice);
            }
            if (null != (aSLDevice = (ASLDevice)StartUpUtil.getSingletonClassInstance("generated.de.vw.mib.asl.internal.speechmedia.request.ASLSpeechMediaRequestDeviceImpl"))) {
                aSLDeviceRegistry.registerASLDevice(aSLDevice);
            }
            if (null != (aSLDevice = (ASLDevice)StartUpUtil.getSingletonClassInstance("generated.de.vw.mib.asl.internal.speechmedia.response.ASLSpeechMediaResponseDeviceImpl"))) {
                aSLDeviceRegistry.registerASLDevice(aSLDevice);
            }
            if (null != (aSLDevice = (ASLDevice)StartUpUtil.getSingletonClassInstance("generated.de.vw.mib.asl.internal.speechmedia.sources.ASLSpeechMediaSourcesDeviceImpl"))) {
                aSLDeviceRegistry.registerASLDevice(aSLDevice);
            }
            if (null != (aSLDevice = (ASLDevice)StartUpUtil.getSingletonClassInstance("generated.de.vw.mib.asl.internal.speechmedia.speechstartup.ASLSpeechMediaSpeechStartupDeviceImpl"))) {
                aSLDeviceRegistry.registerASLDevice(aSLDevice);
            }
            if (null != (aSLDevice = (ASLDevice)StartUpUtil.getSingletonClassInstance("generated.de.vw.mib.asl.internal.speechmedia.titles.ASLSpeechMediaTitlesDeviceImpl"))) {
                aSLDeviceRegistry.registerASLDevice(aSLDevice);
            }
            if (null != (aSLDevice = (ASLDevice)StartUpUtil.getSingletonClassInstance("generated.de.vw.mib.asl.internal.speechmedia.tracks.ASLSpeechMediaTracksDeviceImpl"))) {
                aSLDeviceRegistry.registerASLDevice(aSLDevice);
            }
            if (null != (aSLDevice = (ASLDevice)StartUpUtil.getSingletonClassInstance("generated.de.vw.mib.asl.internal.speechnavigation.ASLSpeechNavigationDeviceImpl"))) {
                aSLDeviceRegistry.registerASLDevice(aSLDevice);
            }
            if (null != (aSLDevice = (ASLDevice)StartUpUtil.getSingletonClassInstance("generated.de.vw.mib.asl.internal.speechnavigation.controller.application.ASLSpeechNavigationControllerApplicationDeviceImpl"))) {
                aSLDeviceRegistry.registerASLDevice(aSLDevice);
            }
            if (null != (aSLDevice = (ASLDevice)StartUpUtil.getSingletonClassInstance("generated.de.vw.mib.asl.internal.speechnavigation.controller.contacts.ASLSpeechNavigationControllerContactsDeviceImpl"))) {
                aSLDeviceRegistry.registerASLDevice(aSLDevice);
            }
            if (null != (aSLDevice = (ASLDevice)StartUpUtil.getSingletonClassInstance("generated.de.vw.mib.asl.internal.speechnavigation.controller.destinationdetails.ASLSpeechNavigationControllerDestinationDetailsDeviceImpl"))) {
                aSLDeviceRegistry.registerASLDevice(aSLDevice);
            }
            if (null != (aSLDevice = (ASLDevice)StartUpUtil.getSingletonClassInstance("generated.de.vw.mib.asl.internal.speechnavigation.controller.destinationinput.ASLSpeechNavigationControllerDestinationInputDeviceImpl"))) {
                aSLDeviceRegistry.registerASLDevice(aSLDevice);
            }
            if (null != (aSLDevice = (ASLDevice)StartUpUtil.getSingletonClassInstance("generated.de.vw.mib.asl.internal.speechnavigation.controller.destinationinput.chome.ASLSpeechNavigationControllerDestinationInputChomeDeviceImpl"))) {
                aSLDeviceRegistry.registerASLDevice(aSLDevice);
            }
            if (null != (aSLDevice = (ASLDevice)StartUpUtil.getSingletonClassInstance("generated.de.vw.mib.asl.internal.speechnavigation.controller.destinationinput.city.ASLSpeechNavigationControllerDestinationInputCityDeviceImpl"))) {
                aSLDeviceRegistry.registerASLDevice(aSLDevice);
            }
            if (null != (aSLDevice = (ASLDevice)StartUpUtil.getSingletonClassInstance("generated.de.vw.mib.asl.internal.speechnavigation.controller.destinationinput.country.ASLSpeechNavigationControllerDestinationInputCountryDeviceImpl"))) {
                aSLDeviceRegistry.registerASLDevice(aSLDevice);
            }
            if (null != (aSLDevice = (ASLDevice)StartUpUtil.getSingletonClassInstance("generated.de.vw.mib.asl.internal.speechnavigation.controller.destinationinput.countrystate.ASLSpeechNavigationControllerDestinationInputCountryStateDeviceImpl"))) {
                aSLDeviceRegistry.registerASLDevice(aSLDevice);
            }
            if (null != (aSLDevice = (ASLDevice)StartUpUtil.getSingletonClassInstance("generated.de.vw.mib.asl.internal.speechnavigation.controller.destinationinput.crossing.ASLSpeechNavigationControllerDestinationInputCrossingDeviceImpl"))) {
                aSLDeviceRegistry.registerASLDevice(aSLDevice);
            }
            if (null != (aSLDevice = (ASLDevice)StartUpUtil.getSingletonClassInstance("generated.de.vw.mib.asl.internal.speechnavigation.controller.destinationinput.housenumber.ASLSpeechNavigationControllerDestinationInputHousenumberDeviceImpl"))) {
                aSLDeviceRegistry.registerASLDevice(aSLDevice);
            }
            if (null != (aSLDevice = (ASLDevice)StartUpUtil.getSingletonClassInstance("generated.de.vw.mib.asl.internal.speechnavigation.controller.destinationinput.municipality.ASLSpeechNavigationControllerDestinationInputMunicipalityDeviceImpl"))) {
                aSLDeviceRegistry.registerASLDevice(aSLDevice);
            }
            if (null != (aSLDevice = (ASLDevice)StartUpUtil.getSingletonClassInstance("generated.de.vw.mib.asl.internal.speechnavigation.controller.destinationinput.oneshot.ASLSpeechNavigationControllerDestinationInputOneshotDeviceImpl"))) {
                aSLDeviceRegistry.registerASLDevice(aSLDevice);
            }
            if (null != (aSLDevice = (ASLDevice)StartUpUtil.getSingletonClassInstance("generated.de.vw.mib.asl.internal.speechnavigation.controller.destinationinput.place.ASLSpeechNavigationControllerDestinationInputPlaceDeviceImpl"))) {
                aSLDeviceRegistry.registerASLDevice(aSLDevice);
            }
            if (null != (aSLDevice = (ASLDevice)StartUpUtil.getSingletonClassInstance("generated.de.vw.mib.asl.internal.speechnavigation.controller.destinationinput.postalcode.ASLSpeechNavigationControllerDestinationInputPostalCodeDeviceImpl"))) {
                aSLDeviceRegistry.registerASLDevice(aSLDevice);
            }
            if (null != (aSLDevice = (ASLDevice)StartUpUtil.getSingletonClassInstance("generated.de.vw.mib.asl.internal.speechnavigation.controller.destinationinput.prefecture.ASLSpeechNavigationControllerDestinationInputPrefectureDeviceImpl"))) {
                aSLDeviceRegistry.registerASLDevice(aSLDevice);
            }
            if (null != (aSLDevice = (ASLDevice)StartUpUtil.getSingletonClassInstance("generated.de.vw.mib.asl.internal.speechnavigation.controller.destinationinput.state.ASLSpeechNavigationControllerDestinationInputStateDeviceImpl"))) {
                aSLDeviceRegistry.registerASLDevice(aSLDevice);
            }
            if (null != (aSLDevice = (ASLDevice)StartUpUtil.getSingletonClassInstance("generated.de.vw.mib.asl.internal.speechnavigation.controller.destinationinput.street.ASLSpeechNavigationControllerDestinationInputStreetDeviceImpl"))) {
                aSLDeviceRegistry.registerASLDevice(aSLDevice);
            }
            if (null != (aSLDevice = (ASLDevice)StartUpUtil.getSingletonClassInstance("generated.de.vw.mib.asl.internal.speechnavigation.controller.destinationinput.ward.ASLSpeechNavigationControllerDestinationInputWardDeviceImpl"))) {
                aSLDeviceRegistry.registerASLDevice(aSLDevice);
            }
            if (null != (aSLDevice = (ASLDevice)StartUpUtil.getSingletonClassInstance("generated.de.vw.mib.asl.internal.speechnavigation.controller.generic.ASLSpeechNavigationControllerGenericDeviceImpl"))) {
                aSLDeviceRegistry.registerASLDevice(aSLDevice);
            }
            if (null != (aSLDevice = (ASLDevice)StartUpUtil.getSingletonClassInstance("generated.de.vw.mib.asl.internal.speechnavigation.controller.guidance.ASLSpeechNavigationControllerGuidanceDeviceImpl"))) {
                aSLDeviceRegistry.registerASLDevice(aSLDevice);
            }
            if (null != (aSLDevice = (ASLDevice)StartUpUtil.getSingletonClassInstance("generated.de.vw.mib.asl.internal.speechnavigation.controller.homeaddress.ASLSpeechNavigationControllerHomeAddressDeviceImpl"))) {
                aSLDeviceRegistry.registerASLDevice(aSLDevice);
            }
            if (null != (aSLDevice = (ASLDevice)StartUpUtil.getSingletonClassInstance("generated.de.vw.mib.asl.internal.speechnavigation.controller.lastdestinations.ASLSpeechNavigationControllerLastDestinationsDeviceImpl"))) {
                aSLDeviceRegistry.registerASLDevice(aSLDevice);
            }
            if (null != (aSLDevice = (ASLDevice)StartUpUtil.getSingletonClassInstance("generated.de.vw.mib.asl.internal.speechnavigation.controller.navigatecontact.ASLSpeechNavigationControllerNavigateContactDeviceImpl"))) {
                aSLDeviceRegistry.registerASLDevice(aSLDevice);
            }
            if (null != (aSLDevice = (ASLDevice)StartUpUtil.getSingletonClassInstance("generated.de.vw.mib.asl.internal.speechnavigation.controller.onboardpois.ASLSpeechNavigationControllerOnboardPOIsDeviceImpl"))) {
                aSLDeviceRegistry.registerASLDevice(aSLDevice);
            }
            if (null != (aSLDevice = (ASLDevice)StartUpUtil.getSingletonClassInstance("generated.de.vw.mib.asl.internal.speechnavigation.controller.onlinepoisearch.ASLSpeechNavigationControllerOnlinePOISearchDeviceImpl"))) {
                aSLDeviceRegistry.registerASLDevice(aSLDevice);
            }
            if (null != (aSLDevice = (ASLDevice)StartUpUtil.getSingletonClassInstance("generated.de.vw.mib.asl.internal.speechnavigation.controller.poisearch.ASLSpeechNavigationControllerPOISearchDeviceImpl"))) {
                aSLDeviceRegistry.registerASLDevice(aSLDevice);
            }
            if (null != (aSLDevice = (ASLDevice)StartUpUtil.getSingletonClassInstance("generated.de.vw.mib.asl.internal.speechnavigation.controller.prerequisites.ASLSpeechNavigationControllerPrerequisitesDeviceImpl"))) {
                aSLDeviceRegistry.registerASLDevice(aSLDevice);
            }
            if (null != (aSLDevice = (ASLDevice)StartUpUtil.getSingletonClassInstance("generated.de.vw.mib.asl.internal.speechnavigation.controller.singleuserinterface.ASLSpeechNavigationControllerSingleUserInterfaceDeviceImpl"))) {
                aSLDeviceRegistry.registerASLDevice(aSLDevice);
            }
            if (null != (aSLDevice = (ASLDevice)StartUpUtil.getSingletonClassInstance("generated.de.vw.mib.asl.internal.speechnavigation.speechstartup.ASLSpeechNavigationSpeechStartupDeviceImpl"))) {
                aSLDeviceRegistry.registerASLDevice(aSLDevice);
            }
            if (null != (aSLDevice = (ASLDevice)StartUpUtil.getSingletonClassInstance("generated.de.vw.mib.asl.internal.speechphone.ASLSpeechPhoneDeviceImpl"))) {
                aSLDeviceRegistry.registerASLDevice(aSLDevice);
            }
            if (null != (aSLDevice = (ASLDevice)StartUpUtil.getSingletonClassInstance("generated.de.vw.mib.asl.internal.speechphone.contact.ASLSpeechPhoneContactDeviceImpl"))) {
                aSLDeviceRegistry.registerASLDevice(aSLDevice);
            }
            if (null != (aSLDevice = (ASLDevice)StartUpUtil.getSingletonClassInstance("generated.de.vw.mib.asl.internal.speechphone.data.contact.ASLSpeechPhoneDataContactDeviceImpl"))) {
                aSLDeviceRegistry.registerASLDevice(aSLDevice);
            }
            if (null != (aSLDevice = (ASLDevice)StartUpUtil.getSingletonClassInstance("generated.de.vw.mib.asl.internal.speechphone.data.number.ASLSpeechPhoneDataNumberDeviceImpl"))) {
                aSLDeviceRegistry.registerASLDevice(aSLDevice);
            }
            if (null != (aSLDevice = (ASLDevice)StartUpUtil.getSingletonClassInstance("generated.de.vw.mib.asl.internal.speechphone.dialnumber.ASLSpeechPhoneDialNumberDeviceImpl"))) {
                aSLDeviceRegistry.registerASLDevice(aSLDevice);
            }
            if (null != (aSLDevice = (ASLDevice)StartUpUtil.getSingletonClassInstance("generated.de.vw.mib.asl.internal.speechphone.listhandling.ASLSpeechPhoneListHandlingDeviceImpl"))) {
                aSLDeviceRegistry.registerASLDevice(aSLDevice);
            }
            if (null != (aSLDevice = (ASLDevice)StartUpUtil.getSingletonClassInstance("generated.de.vw.mib.asl.internal.speechphone.messages.ASLSpeechPhoneMessagesDeviceImpl"))) {
                aSLDeviceRegistry.registerASLDevice(aSLDevice);
            }
            if (null != (aSLDevice = (ASLDevice)StartUpUtil.getSingletonClassInstance("generated.de.vw.mib.asl.internal.speechphone.request.ASLSpeechPhoneRequestDeviceImpl"))) {
                aSLDeviceRegistry.registerASLDevice(aSLDevice);
            }
            if (null != (aSLDevice = (ASLDevice)StartUpUtil.getSingletonClassInstance("generated.de.vw.mib.asl.internal.speechphone.response.ASLSpeechPhoneResponseDeviceImpl"))) {
                aSLDeviceRegistry.registerASLDevice(aSLDevice);
            }
            if (null != (aSLDevice = (ASLDevice)StartUpUtil.getSingletonClassInstance("generated.de.vw.mib.asl.internal.speechphone.status.ASLSpeechPhoneStatusDeviceImpl"))) {
                aSLDeviceRegistry.registerASLDevice(aSLDevice);
            }
            if (null != (aSLDevice = (ASLDevice)StartUpUtil.getSingletonClassInstance("generated.de.vw.mib.asl.internal.speechphone.teleprompterhandling.ASLSpeechPhoneTeleprompterHandlingDeviceImpl"))) {
                aSLDeviceRegistry.registerASLDevice(aSLDevice);
            }
            if (null != (aSLDevice = (ASLDevice)StartUpUtil.getSingletonClassInstance("generated.de.vw.mib.asl.internal.speechsetup.ASLSpeechSetupDeviceImpl"))) {
                aSLDeviceRegistry.registerASLDevice(aSLDevice);
            }
            if (null != (aSLDevice = (ASLDevice)StartUpUtil.getSingletonClassInstance("generated.de.vw.mib.asl.internal.speechtuner.ASLSpeechTunerDeviceImpl"))) {
                aSLDeviceRegistry.registerASLDevice(aSLDevice);
            }
            if (null != (aSLDevice = (ASLDevice)StartUpUtil.getSingletonClassInstance("generated.de.vw.mib.asl.internal.speechtuner.data.frequency.ASLSpeechTunerDataFrequencyDeviceImpl"))) {
                aSLDeviceRegistry.registerASLDevice(aSLDevice);
            }
            if (null != (aSLDevice = (ASLDevice)StartUpUtil.getSingletonClassInstance("generated.de.vw.mib.asl.internal.speechtuner.data.station.ASLSpeechTunerDataStationDeviceImpl"))) {
                aSLDeviceRegistry.registerASLDevice(aSLDevice);
            }
            if (null != (aSLDevice = (ASLDevice)StartUpUtil.getSingletonClassInstance("generated.de.vw.mib.asl.internal.speechtuner.listhandling.ASLSpeechTunerListHandlingDeviceImpl"))) {
                aSLDeviceRegistry.registerASLDevice(aSLDevice);
            }
            if (null != (aSLDevice = (ASLDevice)StartUpUtil.getSingletonClassInstance("generated.de.vw.mib.asl.internal.speechtuner.request.ASLSpeechTunerRequestDeviceImpl"))) {
                aSLDeviceRegistry.registerASLDevice(aSLDevice);
            }
            if (null != (aSLDevice = (ASLDevice)StartUpUtil.getSingletonClassInstance("generated.de.vw.mib.asl.internal.speechtuner.response.ASLSpeechTunerResponseDeviceImpl"))) {
                aSLDeviceRegistry.registerASLDevice(aSLDevice);
            }
            if (null != (aSLDevice = (ASLDevice)StartUpUtil.getSingletonClassInstance("generated.de.vw.mib.asl.internal.speechtuner.teleprompterhandling.ASLSpeechTunerTeleprompterHandlingDeviceImpl"))) {
                aSLDeviceRegistry.registerASLDevice(aSLDevice);
            }
            if (null != (aSLDevice = (ASLDevice)StartUpUtil.getSingletonClassInstance("generated.de.vw.mib.asl.internal.startupanimation.ASLStartupAnimationDeviceImpl"))) {
                aSLDeviceRegistry.registerASLDevice(aSLDevice);
            }
            if (null != (aSLDevice = (ASLDevice)StartUpUtil.getSingletonClassInstance("generated.de.vw.mib.asl.internal.statusbar.ASLStatusbarDeviceImpl"))) {
                aSLDeviceRegistry.registerASLDevice(aSLDevice);
            }
            if (null != (aSLDevice = (ASLDevice)StartUpUtil.getSingletonClassInstance("generated.de.vw.mib.asl.internal.system.ASLSystemDeviceImpl"))) {
                aSLDeviceRegistry.registerASLDevice(aSLDevice);
            }
            if (null != (aSLDevice = (ASLDevice)StartUpUtil.getSingletonClassInstance("generated.de.vw.mib.asl.internal.system.backstack.ASLSystemBackstackDeviceImpl"))) {
                aSLDeviceRegistry.registerASLDevice(aSLDevice);
            }
            if (null != (aSLDevice = (ASLDevice)StartUpUtil.getSingletonClassInstance("generated.de.vw.mib.asl.internal.system.kombi.ASLSystemKombiDeviceImpl"))) {
                aSLDeviceRegistry.registerASLDevice(aSLDevice);
            }
            if (null != (aSLDevice = (ASLDevice)StartUpUtil.getSingletonClassInstance("generated.de.vw.mib.asl.internal.tvtuner.ASLTVTunerDeviceImpl"))) {
                aSLDeviceRegistry.registerASLDevice(aSLDevice);
            }
            if (null != (aSLDevice = (ASLDevice)StartUpUtil.getSingletonClassInstance("generated.de.vw.mib.asl.internal.testmode.ASLTestmodeDeviceImpl"))) {
                aSLDeviceRegistry.registerASLDevice(aSLDevice);
            }
            if (null != (aSLDevice = (ASLDevice)StartUpUtil.getSingletonClassInstance("generated.de.vw.mib.asl.internal.testmode.servicemode.ASLTestmodeServicemodeDeviceImpl"))) {
                aSLDeviceRegistry.registerASLDevice(aSLDevice);
            }
            if (null != (aSLDevice = (ASLDevice)StartUpUtil.getSingletonClassInstance("generated.de.vw.mib.asl.internal.trafficminimap.ASLTrafficMiniMapDeviceImpl"))) {
                aSLDeviceRegistry.registerASLDevice(aSLDevice);
            }
            if (null != (aSLDevice = (ASLDevice)StartUpUtil.getSingletonClassInstance("generated.de.vw.mib.asl.internal.travellink.ASLTravelLinkDeviceImpl"))) {
                aSLDeviceRegistry.registerASLDevice(aSLDevice);
            }
            if (null != (aSLDevice = (ASLDevice)StartUpUtil.getSingletonClassInstance("generated.de.vw.mib.asl.internal.ugdo.ASLUGDODeviceImpl"))) {
                aSLDeviceRegistry.registerASLDevice(aSLDevice);
            }
            if (null != (aSLDevice = (ASLDevice)StartUpUtil.getSingletonClassInstance("generated.de.vw.mib.asl.internal.vicsetc.ASLVICSETCDeviceImpl"))) {
                aSLDeviceRegistry.registerASLDevice(aSLDevice);
            }
            if (null != (aSLDevice = (ASLDevice)StartUpUtil.getSingletonClassInstance("generated.de.vw.mib.asl.internal.vicsetc.dsrc.ASLVICSETCDSRCDeviceImpl"))) {
                aSLDeviceRegistry.registerASLDevice(aSLDevice);
            }
            if (null != (aSLDevice = (ASLDevice)StartUpUtil.getSingletonClassInstance("generated.de.vw.mib.asl.internal.vicsetc.emergency.ASLVICSETCEmergencyDeviceImpl"))) {
                aSLDeviceRegistry.registerASLDevice(aSLDevice);
            }
            if (null != (aSLDevice = (ASLDevice)StartUpUtil.getSingletonClassInstance("generated.de.vw.mib.asl.internal.vicsetc.fmgraphic.ASLVICSETCFmGraphicDeviceImpl"))) {
                aSLDeviceRegistry.registerASLDevice(aSLDevice);
            }
            if (null != (aSLDevice = (ASLDevice)StartUpUtil.getSingletonClassInstance("generated.de.vw.mib.asl.internal.vicsetc.fmtext.ASLVICSETCFmTextDeviceImpl"))) {
                aSLDeviceRegistry.registerASLDevice(aSLDevice);
            }
            if (null != (aSLDevice = (ASLDevice)StartUpUtil.getSingletonClassInstance("generated.de.vw.mib.asl.internal.vicsetc.popups.ASLVICSETCPopupsDeviceImpl"))) {
                aSLDeviceRegistry.registerASLDevice(aSLDevice);
            }
            if (null != (aSLDevice = (ASLDevice)StartUpUtil.getSingletonClassInstance("generated.de.vw.mib.asl.internal.vicsetc.setup.ASLVICSETCSetupDeviceImpl"))) {
                aSLDeviceRegistry.registerASLDevice(aSLDevice);
            }
            if (null != (aSLDevice = (ASLDevice)StartUpUtil.getSingletonClassInstance("generated.de.vw.mib.asl.internal.vicsetc.shortcut.ASLVICSETCShortcutDeviceImpl"))) {
                aSLDeviceRegistry.registerASLDevice(aSLDevice);
            }
            if (null != (aSLDevice = (ASLDevice)StartUpUtil.getSingletonClassInstance("generated.de.vw.mib.asl.internal.vicsetc.speech.ASLVICSETCSpeechDeviceImpl"))) {
                aSLDeviceRegistry.registerASLDevice(aSLDevice);
            }
            if (null != (aSLDevice = (ASLDevice)StartUpUtil.getSingletonClassInstance("generated.de.vw.mib.asl.internal.vicsetc.tollcollect.ASLVICSETCTollCollectDeviceImpl"))) {
                aSLDeviceRegistry.registerASLDevice(aSLDevice);
            }
            if (null != (aSLDevice = (ASLDevice)StartUpUtil.getSingletonClassInstance("generated.de.vw.mib.asl.internal.vicsetc.venm.ASLVICSETCVENMDeviceImpl"))) {
                aSLDeviceRegistry.registerASLDevice(aSLDevice);
            }
            if (null != (aSLDevice = (ASLDevice)StartUpUtil.getSingletonClassInstance("generated.de.vw.mib.asl.internal.webradio.ASLWebRadioDeviceImpl"))) {
                aSLDeviceRegistry.registerASLDevice(aSLDevice);
            }
            if (null != (aSLDevice = (ASLDevice)StartUpUtil.getSingletonClassInstance("generated.de.vw.mib.asl.internal.webradio.trufflesearch.ASLWebRadioTruffleSearchDeviceImpl"))) {
                aSLDeviceRegistry.registerASLDevice(aSLDevice);
            }
            devicesRegistered = true;
        }
    }

    private static void initASLWrappers(ServiceRegister serviceRegister) {
        if (!wrappersInitialized) {
            ASLDeviceRegistry aSLDeviceRegistry = StartUpUtil.getRegistry();
            StartUpUtil.registerDevices(aSLDeviceRegistry);
            StartUpUtil$1 startUpUtil$1 = new StartUpUtil$1(serviceRegister);
            aSLDeviceRegistry.executeForEachASLDevice(startUpUtil$1);
            wrappersInitialized = true;
        }
    }

    private static Object getSingletonClassInstance(String string) {
        Object object;
        try {
            Class clazz = cloader.loadClass(string);
            Method method = clazz.getDeclaredMethod("getInstance", null);
            object = method.invoke(null, null);
        }
        catch (Exception exception) {
            ClassifiedLogger classifiedLogger = clogger;
            if (null != classifiedLogger) {
                classifiedLogger.error().append("StartUpUtil: Could not load class ").append(string).log();
            } else {
                System.err.println(new StringBuffer().append("StartUpUtil: Could not load class ").append(string).toString());
            }
            object = null;
        }
        return object;
    }

    private static ClassLoader findClassLoader() {
        ClassLoader classLoader = (class$generated$de$vw$mib$asl$internal$StartUpUtil == null ? (class$generated$de$vw$mib$asl$internal$StartUpUtil = StartUpUtil.class$("generated.de.vw.mib.asl.internal.StartUpUtil")) : class$generated$de$vw$mib$asl$internal$StartUpUtil).getClassLoader();
        if (null == classLoader) {
            classLoader = Thread.currentThread().getContextClassLoader();
        }
        if (null == classLoader) {
            classLoader = ClassLoader.getSystemClassLoader();
        }
        return classLoader;
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

