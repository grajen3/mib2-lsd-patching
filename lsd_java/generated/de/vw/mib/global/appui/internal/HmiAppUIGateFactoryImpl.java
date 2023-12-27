/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.global.appui.internal;

import de.vw.mib.app.AppUIGate;
import de.vw.mib.app.framework.AppDefinition;
import de.vw.mib.app.framework.AppUIGateFactory;
import de.vw.mib.app.internal.AppSystemServices;
import generated.de.vw.mib.appconnecttilesmedia.appui.AppConnectTileSAppUIGate;
import generated.de.vw.mib.appzilla.appui.AppzillaAppUIGate;
import generated.de.vw.mib.audiotiles.appui.AudioTileSAppUIGate;
import generated.de.vw.mib.background.appui.BackgroundAppUIGate;
import generated.de.vw.mib.car.appui.CarAppUIGate;
import generated.de.vw.mib.carstatustiles.appui.CarStatusTileSAppUIGate;
import generated.de.vw.mib.climate.appui.ClimateAppUIGate;
import generated.de.vw.mib.climatesetup.appui.ClimateSetupAppUIGate;
import generated.de.vw.mib.connectivitynetworking.appui.ConnectivityNetworkingAppUIGate;
import generated.de.vw.mib.connectivitywlan.appui.ConnectivityWlanAppUIGate;
import generated.de.vw.mib.dateglobalwizardpage.appui.DateGlobalWizardPageAppUIGate;
import generated.de.vw.mib.drivingdatatiles.appui.DrivingDataTileSAppUIGate;
import generated.de.vw.mib.filebrowser.appui.FilebrowserAppUIGate;
import generated.de.vw.mib.flowlistmenu.appui.FlowListMenuAppUIGate;
import generated.de.vw.mib.globalgoodbye.appui.GlobalGoodByeAppUIGate;
import generated.de.vw.mib.globalsetupwizard.appui.GlobalSetupWizardAppUIGate;
import generated.de.vw.mib.hmioff.appui.HmioffAppUIGate;
import generated.de.vw.mib.hmioffclockstandby.appui.HmioffClockAppUIGate;
import generated.de.vw.mib.homescreen.appui.HomeScreenAppUIGate;
import generated.de.vw.mib.internetbrowser.appui.InternetbrowserAppUIGate;
import generated.de.vw.mib.media.appui.MediaAppUIGate;
import generated.de.vw.mib.mediacontrol.appui.MediaControlAppUIGate;
import generated.de.vw.mib.mediatiles.appui.MediaTileSAppUIGate;
import generated.de.vw.mib.message.appui.MessageAppUIGate;
import generated.de.vw.mib.mirrorlink.appui.MirrorlinkAppUIGate;
import generated.de.vw.mib.nav.appui.NavAppUIGate;
import generated.de.vw.mib.navhomeadressglobalwizardpage.appui.NavHomeAdressGlobalWizardPageAppUIGate;
import generated.de.vw.mib.navinfotile.appui.NavInfoTileAppUIGate;
import generated.de.vw.mib.navmaptile.appui.NavMapTileAppUIGate;
import generated.de.vw.mib.navtraffictiles.appui.NavTrafficTileSAppUIGate;
import generated.de.vw.mib.online.appui.OnlineAppUIGate;
import generated.de.vw.mib.onlineglobalwizardpage.appui.OnlineGlobalWizardPageAppUIGate;
import generated.de.vw.mib.onlinelogbook.appui.OnlineLogBookAppUIGate;
import generated.de.vw.mib.personalizationglobalwizardpage.appui.PersonalizationGlobalWizardPageAppUIGate;
import generated.de.vw.mib.phone.appui.PhoneAppUIGate;
import generated.de.vw.mib.phoneglobalwizardpage.appui.PhoneGlobalWizardPageAppUIGate;
import generated.de.vw.mib.phonetiles.appui.PhoneTileSAppUIGate;
import generated.de.vw.mib.pictureviewer.appui.PictureViewerAppUIGate;
import generated.de.vw.mib.pictureviewertiles.appui.PictureViewerTileSAppUIGate;
import generated.de.vw.mib.selectiontiles.appui.SelectionTileSAppUIGate;
import generated.de.vw.mib.servicemode.appui.ServiceModeAppUIGate;
import generated.de.vw.mib.setupsystem.appui.SetupSystemAppUIGate;
import generated.de.vw.mib.simpledesktop.appui.SimpledesktopAppUIGate;
import generated.de.vw.mib.simplegridmenu.appui.SimpleGridMenuAppUIGate;
import generated.de.vw.mib.smartphoneintegration.appui.SmartPhoneIntegrationAppUIGate;
import generated.de.vw.mib.sound.appui.SoundAppUIGate;
import generated.de.vw.mib.spacegestureindicator.appui.SpaceGestureIndicatorAppUIGate;
import generated.de.vw.mib.speechgeneral.appui.SpeechGeneralAppUIGate;
import generated.de.vw.mib.speechheadline.appui.SpeechHeadlineAppUIGate;
import generated.de.vw.mib.speechmedia.appui.SpeechMediaAppUIGate;
import generated.de.vw.mib.speechnavigation.appui.SpeechNavigationAppUIGate;
import generated.de.vw.mib.speechphone.appui.SpeechPhoneAppUIGate;
import generated.de.vw.mib.speechsetup.appui.SpeechSetupAppUIGate;
import generated.de.vw.mib.speechtuner.appui.SpeechTunerAppUIGate;
import generated.de.vw.mib.spellerapp.appui.SpellerAppAppUIGate;
import generated.de.vw.mib.swap.appui.SwaPAppUIGate;
import generated.de.vw.mib.swdlcustomerdownload.appui.SwdlCustomerDownloadAppUIGate;
import generated.de.vw.mib.swdlperforming.appui.SwdlPerformingAppUIGate;
import generated.de.vw.mib.systemsetup.appui.SystemSetupAppUIGate;
import generated.de.vw.mib.testmode.appui.TestModeAppUIGate;
import generated.de.vw.mib.thinkbluetiles.appui.ThinkBlueTileSAppUIGate;
import generated.de.vw.mib.tuner.appui.TunerAppUIGate;
import generated.de.vw.mib.tunerautostoreglobalwizardpage.appui.TunerAutostoreGlobalWizardPageAppUIGate;
import generated.de.vw.mib.tunertiles.appui.TunerTileSAppUIGate;
import generated.de.vw.mib.tvtuner.appui.TvtunerAppUIGate;
import generated.de.vw.mib.tvtunertiles.appui.TvtunerTileSAppUIGate;
import generated.de.vw.mib.ugdo.appui.UgdoAppUIGate;

public class HmiAppUIGateFactoryImpl
implements AppUIGateFactory {
    private final AppSystemServices appSystemServices;

    public HmiAppUIGateFactoryImpl(AppSystemServices appSystemServices) {
        this.appSystemServices = appSystemServices;
    }

    @Override
    public AppUIGate createApp(AppDefinition appDefinition) {
        int n = this.getCaseCode(appDefinition);
        switch (n) {
            case 1501064570: {
                if (!"AppConnectTileSMedia".equals(appDefinition.getAppInstanceName())) break;
                return new AppConnectTileSAppUIGate(appDefinition, this.appSystemServices);
            }
            case -2133110450: {
                if (!"Appzilla".equals(appDefinition.getAppInstanceName())) break;
                return new AppzillaAppUIGate(appDefinition, this.appSystemServices);
            }
            case 1412597582: {
                if (!"AudioTileS".equals(appDefinition.getAppInstanceName())) break;
                return new AudioTileSAppUIGate(appDefinition, this.appSystemServices);
            }
            case 866116078: {
                if (!"Background".equals(appDefinition.getAppInstanceName())) break;
                return new BackgroundAppUIGate(appDefinition, this.appSystemServices);
            }
            case -2078015878: {
                if (!"Car".equals(appDefinition.getAppInstanceName())) break;
                return new CarAppUIGate(appDefinition, this.appSystemServices);
            }
            case -818908722: {
                if (!"CarStatusTileS".equals(appDefinition.getAppInstanceName())) break;
                return new CarStatusTileSAppUIGate(appDefinition, this.appSystemServices);
            }
            case -1001694436: {
                if (!"Climate".equals(appDefinition.getAppInstanceName())) break;
                return new ClimateAppUIGate(appDefinition, this.appSystemServices);
            }
            case 760729134: {
                if (!"ClimateSetup".equals(appDefinition.getAppInstanceName())) break;
                return new ClimateSetupAppUIGate(appDefinition, this.appSystemServices);
            }
            case -593458866: {
                if (!"ConnectivityNetworking".equals(appDefinition.getAppInstanceName())) break;
                return new ConnectivityNetworkingAppUIGate(appDefinition, this.appSystemServices);
            }
            case -717865650: {
                if (!"ConnectivityWlan".equals(appDefinition.getAppInstanceName())) break;
                return new ConnectivityWlanAppUIGate(appDefinition, this.appSystemServices);
            }
            case -167333362: {
                if (!"DateGlobalWizardPage".equals(appDefinition.getAppInstanceName())) break;
                return new DateGlobalWizardPageAppUIGate(appDefinition, this.appSystemServices);
            }
            case 120457902: {
                if (!"DrivingDataTileS".equals(appDefinition.getAppInstanceName())) break;
                return new DrivingDataTileSAppUIGate(appDefinition, this.appSystemServices);
            }
            case -819791574: {
                if (!"Filebrowser".equals(appDefinition.getAppInstanceName())) break;
                return new FilebrowserAppUIGate(appDefinition, this.appSystemServices);
            }
            case 1754096910: {
                if (!"FlowListMenu".equals(appDefinition.getAppInstanceName())) break;
                return new FlowListMenuAppUIGate(appDefinition, this.appSystemServices);
            }
            case -1819082386: {
                if (!"GlobalGoodBye".equals(appDefinition.getAppInstanceName())) break;
                return new GlobalGoodByeAppUIGate(appDefinition, this.appSystemServices);
            }
            case -1408549028: {
                if (!"GlobalSetupWizard".equals(appDefinition.getAppInstanceName())) break;
                return new GlobalSetupWizardAppUIGate(appDefinition, this.appSystemServices);
            }
            case -1262446770: {
                if (!"HMIOff".equals(appDefinition.getAppInstanceName())) break;
                return new HmioffAppUIGate(appDefinition, this.appSystemServices);
            }
            case -475177531: {
                if (!"HMIOffClockDisplayOff".equals(appDefinition.getAppInstanceName())) break;
                return new generated.de.vw.mib.hmioffclockdisplayoff.appui.HmioffClockAppUIGate(appDefinition, this.appSystemServices);
            }
            case -1370508971: {
                if (!"HMIOffClockStandBy".equals(appDefinition.getAppInstanceName())) break;
                return new HmioffClockAppUIGate(appDefinition, this.appSystemServices);
            }
            case 1886343630: {
                if (!"HomeScreen".equals(appDefinition.getAppInstanceName())) break;
                return new HomeScreenAppUIGate(appDefinition, this.appSystemServices);
            }
            case 591851872: {
                if (!"Internetbrowser".equals(appDefinition.getAppInstanceName())) break;
                return new InternetbrowserAppUIGate(appDefinition, this.appSystemServices);
            }
            case 235014426: {
                if (!"Media".equals(appDefinition.getAppInstanceName())) break;
                return new MediaAppUIGate(appDefinition, this.appSystemServices);
            }
            case -1088993330: {
                if (!"MediaControl".equals(appDefinition.getAppInstanceName())) break;
                return new MediaControlAppUIGate(appDefinition, this.appSystemServices);
            }
            case 524092430: {
                if (!"MediaTileS".equals(appDefinition.getAppInstanceName())) break;
                return new MediaTileSAppUIGate(appDefinition, this.appSystemServices);
            }
            case 922118368: {
                if (!"Message".equals(appDefinition.getAppInstanceName())) break;
                return new MessageAppUIGate(appDefinition, this.appSystemServices);
            }
            case 920296718: {
                if (!"Mirrorlink".equals(appDefinition.getAppInstanceName())) break;
                return new MirrorlinkAppUIGate(appDefinition, this.appSystemServices);
            }
            case -901705320: {
                if (!"Nav".equals(appDefinition.getAppInstanceName())) break;
                return new NavAppUIGate(appDefinition, this.appSystemServices);
            }
            case 485440636: {
                if (!"NavHomeAdressGlobalWizardPage".equals(appDefinition.getAppInstanceName())) break;
                return new NavHomeAdressGlobalWizardPageAppUIGate(appDefinition, this.appSystemServices);
            }
            case 301583824: {
                if (!"NavInfoTile".equals(appDefinition.getAppInstanceName())) break;
                return new NavInfoTileAppUIGate(appDefinition, this.appSystemServices);
            }
            case 1679958094: {
                if (!"NavMapTile".equals(appDefinition.getAppInstanceName())) break;
                return new NavMapTileAppUIGate(appDefinition, this.appSystemServices);
            }
            case -1227495384: {
                if (!"NavTrafficTileS".equals(appDefinition.getAppInstanceName())) break;
                return new NavTrafficTileSAppUIGate(appDefinition, this.appSystemServices);
            }
            case -1425306034: {
                if (!"Online".equals(appDefinition.getAppInstanceName())) break;
                return new OnlineAppUIGate(appDefinition, this.appSystemServices);
            }
            case 1537569710: {
                if (!"OnlineGlobalWizardPage".equals(appDefinition.getAppInstanceName())) break;
                return new OnlineGlobalWizardPageAppUIGate(appDefinition, this.appSystemServices);
            }
            case 719122886: {
                if (!"OnlineLogBook".equals(appDefinition.getAppInstanceName())) break;
                return new OnlineLogBookAppUIGate(appDefinition, this.appSystemServices);
            }
            case 287442836: {
                if (!"PersonalizationGlobalWizardPage".equals(appDefinition.getAppInstanceName())) break;
                return new PersonalizationGlobalWizardPageAppUIGate(appDefinition, this.appSystemServices);
            }
            case -475540306: {
                if (!"Phone".equals(appDefinition.getAppInstanceName())) break;
                return new PhoneAppUIGate(appDefinition, this.appSystemServices);
            }
            case -1156757912: {
                if (!"PhoneGlobalWizardPage".equals(appDefinition.getAppInstanceName())) break;
                return new PhoneGlobalWizardPageAppUIGate(appDefinition, this.appSystemServices);
            }
            case 191469134: {
                if (!"PhoneTileS".equals(appDefinition.getAppInstanceName())) break;
                return new PhoneTileSAppUIGate(appDefinition, this.appSystemServices);
            }
            case 116254642: {
                if (!"PictureViewer".equals(appDefinition.getAppInstanceName())) break;
                return new PictureViewerAppUIGate(appDefinition, this.appSystemServices);
            }
            case -1709759858: {
                if (!"PictureViewerTileS".equals(appDefinition.getAppInstanceName())) break;
                return new PictureViewerTileSAppUIGate(appDefinition, this.appSystemServices);
            }
            case -470944474: {
                if (!"SIMPLEDESKTOP".equals(appDefinition.getAppInstanceName())) break;
                return new SimpledesktopAppUIGate(appDefinition, this.appSystemServices);
            }
            case 1867590894: {
                if (!"SWDL_CUSTOMER_DOWNLOAD".equals(appDefinition.getAppInstanceName())) break;
                return new SwdlCustomerDownloadAppUIGate(appDefinition, this.appSystemServices);
            }
            case -39182278: {
                if (!"SWDL_PERFORMING".equals(appDefinition.getAppInstanceName())) break;
                return new SwdlPerformingAppUIGate(appDefinition, this.appSystemServices);
            }
            case -165304050: {
                if (!"SWaP".equals(appDefinition.getAppInstanceName())) break;
                return new SwaPAppUIGate(appDefinition, this.appSystemServices);
            }
            case 1961400974: {
                if (!"SelectionTileS".equals(appDefinition.getAppInstanceName())) break;
                return new SelectionTileSAppUIGate(appDefinition, this.appSystemServices);
            }
            case 697771714: {
                if (!"ServiceMode".equals(appDefinition.getAppInstanceName())) break;
                return new ServiceModeAppUIGate(appDefinition, this.appSystemServices);
            }
            case -1431432470: {
                if (!"SetupSystem".equals(appDefinition.getAppInstanceName())) break;
                return new SetupSystemAppUIGate(appDefinition, this.appSystemServices);
            }
            case 561943246: {
                if (!"SimpleGridMenu".equals(appDefinition.getAppInstanceName())) break;
                return new SimpleGridMenuAppUIGate(appDefinition, this.appSystemServices);
            }
            case -1400167952: {
                if (!"SmartPhoneIntegration".equals(appDefinition.getAppInstanceName())) break;
                return new SmartPhoneIntegrationAppUIGate(appDefinition, this.appSystemServices);
            }
            case -1791365328: {
                if (!"Sound".equals(appDefinition.getAppInstanceName())) break;
                return new SoundAppUIGate(appDefinition, this.appSystemServices);
            }
            case -1009672406: {
                if (!"SpaceGestureIndicator".equals(appDefinition.getAppInstanceName())) break;
                return new SpaceGestureIndicatorAppUIGate(appDefinition, this.appSystemServices);
            }
            case -1179393250: {
                if (!"SpeechGeneral".equals(appDefinition.getAppInstanceName())) break;
                return new SpeechGeneralAppUIGate(appDefinition, this.appSystemServices);
            }
            case -887632658: {
                if (!"SpeechHeadline".equals(appDefinition.getAppInstanceName())) break;
                return new SpeechHeadlineAppUIGate(appDefinition, this.appSystemServices);
            }
            case 886995990: {
                if (!"SpeechMedia".equals(appDefinition.getAppInstanceName())) break;
                return new SpeechMediaAppUIGate(appDefinition, this.appSystemServices);
            }
            case -635656466: {
                if (!"SpeechNavigation".equals(appDefinition.getAppInstanceName())) break;
                return new SpeechNavigationAppUIGate(appDefinition, this.appSystemServices);
            }
            case -880011222: {
                if (!"SpeechPhone".equals(appDefinition.getAppInstanceName())) break;
                return new SpeechPhoneAppUIGate(appDefinition, this.appSystemServices);
            }
            case 1190654920: {
                if (!"SpeechSetup".equals(appDefinition.getAppInstanceName())) break;
                return new SpeechSetupAppUIGate(appDefinition, this.appSystemServices);
            }
            case 1423567426: {
                if (!"SpeechTuner".equals(appDefinition.getAppInstanceName())) break;
                return new SpeechTunerAppUIGate(appDefinition, this.appSystemServices);
            }
            case 1984940846: {
                if (!"SpellerApp".equals(appDefinition.getAppInstanceName())) break;
                return new SpellerAppAppUIGate(appDefinition, this.appSystemServices);
            }
            case -242479890: {
                if (!"SystemSetup".equals(appDefinition.getAppInstanceName())) break;
                return new SystemSetupAppUIGate(appDefinition, this.appSystemServices);
            }
            case 587203650: {
                if (!"TVTuner".equals(appDefinition.getAppInstanceName())) break;
                return new TvtunerAppUIGate(appDefinition, this.appSystemServices);
            }
            case 1186798670: {
                if (!"TVTunerTileS".equals(appDefinition.getAppInstanceName())) break;
                return new TvtunerTileSAppUIGate(appDefinition, this.appSystemServices);
            }
            case 769738190: {
                if (!"TestMode".equals(appDefinition.getAppInstanceName())) break;
                return new TestModeAppUIGate(appDefinition, this.appSystemServices);
            }
            case 937342606: {
                if (!"ThinkBlueTileS".equals(appDefinition.getAppInstanceName())) break;
                return new ThinkBlueTileSAppUIGate(appDefinition, this.appSystemServices);
            }
            case 330670022: {
                if (!"Tuner".equals(appDefinition.getAppInstanceName())) break;
                return new TunerAppUIGate(appDefinition, this.appSystemServices);
            }
            case -57009906: {
                if (!"TunerAutostoreGlobalWizardPage".equals(appDefinition.getAppInstanceName())) break;
                return new TunerAutostoreGlobalWizardPageAppUIGate(appDefinition, this.appSystemServices);
            }
            case -1917884978: {
                if (!"TunerTileS".equals(appDefinition.getAppInstanceName())) break;
                return new TunerTileSAppUIGate(appDefinition, this.appSystemServices);
            }
            case -1596796082: {
                if (!"UGDO".equals(appDefinition.getAppInstanceName())) break;
                return new UgdoAppUIGate(appDefinition, this.appSystemServices);
            }
        }
        return this.unsupportedApp(appDefinition);
    }

    private int getCaseCode(AppDefinition appDefinition) {
        return new StringBuffer().append(appDefinition.getAppName()).append('.').append(appDefinition.getAppInstanceName()).toString().hashCode();
    }

    private AppUIGate unsupportedApp(AppDefinition appDefinition) {
        return null;
    }
}

