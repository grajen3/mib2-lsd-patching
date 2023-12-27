/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asi.impl;

import de.esolutions.fw.comm.asi.hmisync.audio.impl.ASIHMISyncAudioService;
import de.esolutions.fw.comm.asi.hmisync.car.bc.impl.ASIHMISyncCarBordComputerService;
import de.esolutions.fw.comm.asi.hmisync.car.climate.impl.ASIHMISyncCarClimateService;
import de.esolutions.fw.comm.asi.hmisync.car.driving.impl.ASIHMISyncCarDrivingService;
import de.esolutions.fw.comm.asi.hmisync.car.impl.ASIHMISyncCarGenericService;
import de.esolutions.fw.comm.asi.hmisync.car.service.impl.ASIHMISyncCarServiceService;
import de.esolutions.fw.comm.asi.hmisync.generic.impl.ASIHMISyncGenericService;
import de.esolutions.fw.comm.asi.hmisync.headunit.impl.ASIHMISyncHeadUnitService;
import de.esolutions.fw.comm.asi.hmisync.instance.impl.ASIHMISyncInstanceService;
import de.esolutions.fw.comm.asi.hmisync.mastercontrol.impl.ASIHMISyncMasterControlService;
import de.esolutions.fw.comm.asi.hmisync.media.impl.ASIHMISyncMediaBrowserService;
import de.esolutions.fw.comm.asi.hmisync.media.impl.ASIHMISyncMediaService;
import de.esolutions.fw.comm.asi.hmisync.navigation.impl.ASIHMISyncNavigationService;
import de.esolutions.fw.comm.asi.hmisync.radio.impl.ASIHMISyncRadioService;
import de.esolutions.fw.comm.asi.hmisync.sound.impl.ASIHMISyncSoundService;
import de.esolutions.fw.comm.asi.hmisync.tv.impl.ASIHMISyncTVService;
import de.esolutions.fw.comm.core.AbstractService;
import de.esolutions.fw.comm.core.IService;
import de.vw.mib.asi.ASIProperties;
import de.vw.mib.asi.ASIService;
import de.vw.mib.asi.audio.ASIAudio;
import de.vw.mib.asi.audio.impl.ASIAudioBaseServiceImpl;
import de.vw.mib.asi.car.ASICarGeneric;
import de.vw.mib.asi.car.bc.ASICarBordComputer;
import de.vw.mib.asi.car.bc.impl.ASICarBordComputerBaseServiceImpl;
import de.vw.mib.asi.car.climate.ASICarClimate;
import de.vw.mib.asi.car.climate.impl.ASICarClimateBaseServiceImpl;
import de.vw.mib.asi.car.driving.ASICarDriving;
import de.vw.mib.asi.car.driving.impl.ASICarDrivingBaseServiceImpl;
import de.vw.mib.asi.car.impl.ASICarGenericBaseServiceImpl;
import de.vw.mib.asi.car.service.ASICarService;
import de.vw.mib.asi.car.service.impl.ASICarServiceBaseServiceImpl;
import de.vw.mib.asi.generic.ASIGeneric;
import de.vw.mib.asi.generic.impl.ASIGenericBaseServiceImpl;
import de.vw.mib.asi.headunit.ASIHeadUnit;
import de.vw.mib.asi.headunit.impl.ASIHeadUnitBaseServiceImpl;
import de.vw.mib.asi.instance.ASIInstance;
import de.vw.mib.asi.instance.impl.ASIInstanceBaseServiceImpl;
import de.vw.mib.asi.mastercontrol.ASIMasterControl;
import de.vw.mib.asi.mastercontrol.impl.ASIMasterControlBaseServiceImpl;
import de.vw.mib.asi.media.ASIMedia;
import de.vw.mib.asi.media.ASIMediaBrowser;
import de.vw.mib.asi.media.impl.ASIMediaBaseServiceImpl;
import de.vw.mib.asi.media.impl.ASIMediaBrowserBaseServiceImpl;
import de.vw.mib.asi.navigation.ASINavigation;
import de.vw.mib.asi.navigation.impl.ASINavigationBaseServiceImpl;
import de.vw.mib.asi.radio.ASIRadio;
import de.vw.mib.asi.radio.impl.ASIRadioBaseServiceImpl;
import de.vw.mib.asi.sound.ASISound;
import de.vw.mib.asi.sound.impl.ASISoundBaseServiceImpl;
import de.vw.mib.asi.tv.ASITV;
import de.vw.mib.asi.tv.impl.ASITVBaseServiceImpl;
import de.vw.mib.log4mib.ClassifiedLogger;

class ASIServiceFactory {
    private final ClassifiedLogger clogger;
    static /* synthetic */ Class class$de$vw$mib$asi$audio$ASIAudio;
    static /* synthetic */ Class class$de$vw$mib$asi$car$bc$ASICarBordComputer;
    static /* synthetic */ Class class$de$vw$mib$asi$car$climate$ASICarClimate;
    static /* synthetic */ Class class$de$vw$mib$asi$car$driving$ASICarDriving;
    static /* synthetic */ Class class$de$vw$mib$asi$car$ASICarGeneric;
    static /* synthetic */ Class class$de$vw$mib$asi$car$service$ASICarService;
    static /* synthetic */ Class class$de$vw$mib$asi$generic$ASIGeneric;
    static /* synthetic */ Class class$de$vw$mib$asi$headunit$ASIHeadUnit;
    static /* synthetic */ Class class$de$vw$mib$asi$instance$ASIInstance;
    static /* synthetic */ Class class$de$vw$mib$asi$mastercontrol$ASIMasterControl;
    static /* synthetic */ Class class$de$vw$mib$asi$media$ASIMedia;
    static /* synthetic */ Class class$de$vw$mib$asi$media$ASIMediaBrowser;
    static /* synthetic */ Class class$de$vw$mib$asi$navigation$ASINavigation;
    static /* synthetic */ Class class$de$vw$mib$asi$radio$ASIRadio;
    static /* synthetic */ Class class$de$vw$mib$asi$sound$ASISound;
    static /* synthetic */ Class class$de$vw$mib$asi$tv$ASITV;

    ASIServiceFactory(ClassifiedLogger classifiedLogger) {
        this.clogger = classifiedLogger;
    }

    IService createService(Class clazz, int n, ASIService aSIService, ASIProperties aSIProperties) {
        AbstractService abstractService;
        if (null == clazz) {
            throw new NullPointerException("serviceClass");
        }
        if ((class$de$vw$mib$asi$audio$ASIAudio == null ? (class$de$vw$mib$asi$audio$ASIAudio = ASIServiceFactory.class$("de.vw.mib.asi.audio.ASIAudio")) : class$de$vw$mib$asi$audio$ASIAudio).equals(clazz)) {
            ASIAudioBaseServiceImpl aSIAudioBaseServiceImpl = new ASIAudioBaseServiceImpl((ASIAudio)aSIService, aSIProperties, this.clogger);
            aSIAudioBaseServiceImpl.init();
            abstractService = new ASIHMISyncAudioService(n, aSIAudioBaseServiceImpl);
        } else if ((class$de$vw$mib$asi$car$bc$ASICarBordComputer == null ? (class$de$vw$mib$asi$car$bc$ASICarBordComputer = ASIServiceFactory.class$("de.vw.mib.asi.car.bc.ASICarBordComputer")) : class$de$vw$mib$asi$car$bc$ASICarBordComputer).equals(clazz)) {
            ASICarBordComputerBaseServiceImpl aSICarBordComputerBaseServiceImpl = new ASICarBordComputerBaseServiceImpl((ASICarBordComputer)aSIService, aSIProperties, this.clogger);
            aSICarBordComputerBaseServiceImpl.init();
            abstractService = new ASIHMISyncCarBordComputerService(n, aSICarBordComputerBaseServiceImpl);
        } else if ((class$de$vw$mib$asi$car$climate$ASICarClimate == null ? (class$de$vw$mib$asi$car$climate$ASICarClimate = ASIServiceFactory.class$("de.vw.mib.asi.car.climate.ASICarClimate")) : class$de$vw$mib$asi$car$climate$ASICarClimate).equals(clazz)) {
            ASICarClimateBaseServiceImpl aSICarClimateBaseServiceImpl = new ASICarClimateBaseServiceImpl((ASICarClimate)aSIService, aSIProperties, this.clogger);
            aSICarClimateBaseServiceImpl.init();
            abstractService = new ASIHMISyncCarClimateService(n, aSICarClimateBaseServiceImpl);
        } else if ((class$de$vw$mib$asi$car$driving$ASICarDriving == null ? (class$de$vw$mib$asi$car$driving$ASICarDriving = ASIServiceFactory.class$("de.vw.mib.asi.car.driving.ASICarDriving")) : class$de$vw$mib$asi$car$driving$ASICarDriving).equals(clazz)) {
            ASICarDrivingBaseServiceImpl aSICarDrivingBaseServiceImpl = new ASICarDrivingBaseServiceImpl((ASICarDriving)aSIService, aSIProperties, this.clogger);
            aSICarDrivingBaseServiceImpl.init();
            abstractService = new ASIHMISyncCarDrivingService(n, aSICarDrivingBaseServiceImpl);
        } else if ((class$de$vw$mib$asi$car$ASICarGeneric == null ? (class$de$vw$mib$asi$car$ASICarGeneric = ASIServiceFactory.class$("de.vw.mib.asi.car.ASICarGeneric")) : class$de$vw$mib$asi$car$ASICarGeneric).equals(clazz)) {
            ASICarGenericBaseServiceImpl aSICarGenericBaseServiceImpl = new ASICarGenericBaseServiceImpl((ASICarGeneric)aSIService, aSIProperties, this.clogger);
            aSICarGenericBaseServiceImpl.init();
            abstractService = new ASIHMISyncCarGenericService(n, aSICarGenericBaseServiceImpl);
        } else if ((class$de$vw$mib$asi$car$service$ASICarService == null ? (class$de$vw$mib$asi$car$service$ASICarService = ASIServiceFactory.class$("de.vw.mib.asi.car.service.ASICarService")) : class$de$vw$mib$asi$car$service$ASICarService).equals(clazz)) {
            ASICarServiceBaseServiceImpl aSICarServiceBaseServiceImpl = new ASICarServiceBaseServiceImpl((ASICarService)aSIService, aSIProperties, this.clogger);
            aSICarServiceBaseServiceImpl.init();
            abstractService = new ASIHMISyncCarServiceService(n, aSICarServiceBaseServiceImpl);
        } else if ((class$de$vw$mib$asi$generic$ASIGeneric == null ? (class$de$vw$mib$asi$generic$ASIGeneric = ASIServiceFactory.class$("de.vw.mib.asi.generic.ASIGeneric")) : class$de$vw$mib$asi$generic$ASIGeneric).equals(clazz)) {
            ASIGenericBaseServiceImpl aSIGenericBaseServiceImpl = new ASIGenericBaseServiceImpl((ASIGeneric)aSIService, aSIProperties, this.clogger);
            aSIGenericBaseServiceImpl.init();
            abstractService = new ASIHMISyncGenericService(n, aSIGenericBaseServiceImpl);
        } else if ((class$de$vw$mib$asi$headunit$ASIHeadUnit == null ? (class$de$vw$mib$asi$headunit$ASIHeadUnit = ASIServiceFactory.class$("de.vw.mib.asi.headunit.ASIHeadUnit")) : class$de$vw$mib$asi$headunit$ASIHeadUnit).equals(clazz)) {
            ASIHeadUnitBaseServiceImpl aSIHeadUnitBaseServiceImpl = new ASIHeadUnitBaseServiceImpl((ASIHeadUnit)aSIService, aSIProperties, this.clogger);
            aSIHeadUnitBaseServiceImpl.init();
            abstractService = new ASIHMISyncHeadUnitService(n, aSIHeadUnitBaseServiceImpl);
        } else if ((class$de$vw$mib$asi$instance$ASIInstance == null ? (class$de$vw$mib$asi$instance$ASIInstance = ASIServiceFactory.class$("de.vw.mib.asi.instance.ASIInstance")) : class$de$vw$mib$asi$instance$ASIInstance).equals(clazz)) {
            ASIInstanceBaseServiceImpl aSIInstanceBaseServiceImpl = new ASIInstanceBaseServiceImpl((ASIInstance)aSIService, aSIProperties, this.clogger);
            aSIInstanceBaseServiceImpl.init();
            abstractService = new ASIHMISyncInstanceService(n, aSIInstanceBaseServiceImpl);
        } else if ((class$de$vw$mib$asi$mastercontrol$ASIMasterControl == null ? (class$de$vw$mib$asi$mastercontrol$ASIMasterControl = ASIServiceFactory.class$("de.vw.mib.asi.mastercontrol.ASIMasterControl")) : class$de$vw$mib$asi$mastercontrol$ASIMasterControl).equals(clazz)) {
            ASIMasterControlBaseServiceImpl aSIMasterControlBaseServiceImpl = new ASIMasterControlBaseServiceImpl((ASIMasterControl)aSIService, aSIProperties, this.clogger);
            aSIMasterControlBaseServiceImpl.init();
            abstractService = new ASIHMISyncMasterControlService(n, aSIMasterControlBaseServiceImpl);
        } else if ((class$de$vw$mib$asi$media$ASIMedia == null ? (class$de$vw$mib$asi$media$ASIMedia = ASIServiceFactory.class$("de.vw.mib.asi.media.ASIMedia")) : class$de$vw$mib$asi$media$ASIMedia).equals(clazz)) {
            ASIMediaBaseServiceImpl aSIMediaBaseServiceImpl = new ASIMediaBaseServiceImpl((ASIMedia)aSIService, aSIProperties, this.clogger);
            aSIMediaBaseServiceImpl.init();
            abstractService = new ASIHMISyncMediaService(n, aSIMediaBaseServiceImpl);
        } else if ((class$de$vw$mib$asi$media$ASIMediaBrowser == null ? (class$de$vw$mib$asi$media$ASIMediaBrowser = ASIServiceFactory.class$("de.vw.mib.asi.media.ASIMediaBrowser")) : class$de$vw$mib$asi$media$ASIMediaBrowser).equals(clazz)) {
            ASIMediaBrowserBaseServiceImpl aSIMediaBrowserBaseServiceImpl = new ASIMediaBrowserBaseServiceImpl((ASIMediaBrowser)aSIService, aSIProperties, this.clogger);
            aSIMediaBrowserBaseServiceImpl.init();
            abstractService = new ASIHMISyncMediaBrowserService(n, aSIMediaBrowserBaseServiceImpl);
        } else if ((class$de$vw$mib$asi$navigation$ASINavigation == null ? (class$de$vw$mib$asi$navigation$ASINavigation = ASIServiceFactory.class$("de.vw.mib.asi.navigation.ASINavigation")) : class$de$vw$mib$asi$navigation$ASINavigation).equals(clazz)) {
            ASINavigationBaseServiceImpl aSINavigationBaseServiceImpl = new ASINavigationBaseServiceImpl((ASINavigation)aSIService, aSIProperties, this.clogger);
            aSINavigationBaseServiceImpl.init();
            abstractService = new ASIHMISyncNavigationService(n, aSINavigationBaseServiceImpl);
        } else if ((class$de$vw$mib$asi$radio$ASIRadio == null ? (class$de$vw$mib$asi$radio$ASIRadio = ASIServiceFactory.class$("de.vw.mib.asi.radio.ASIRadio")) : class$de$vw$mib$asi$radio$ASIRadio).equals(clazz)) {
            ASIRadioBaseServiceImpl aSIRadioBaseServiceImpl = new ASIRadioBaseServiceImpl((ASIRadio)aSIService, aSIProperties, this.clogger);
            aSIRadioBaseServiceImpl.init();
            abstractService = new ASIHMISyncRadioService(n, aSIRadioBaseServiceImpl);
        } else if ((class$de$vw$mib$asi$sound$ASISound == null ? (class$de$vw$mib$asi$sound$ASISound = ASIServiceFactory.class$("de.vw.mib.asi.sound.ASISound")) : class$de$vw$mib$asi$sound$ASISound).equals(clazz)) {
            ASISoundBaseServiceImpl aSISoundBaseServiceImpl = new ASISoundBaseServiceImpl((ASISound)aSIService, aSIProperties, this.clogger);
            aSISoundBaseServiceImpl.init();
            abstractService = new ASIHMISyncSoundService(n, aSISoundBaseServiceImpl);
        } else if ((class$de$vw$mib$asi$tv$ASITV == null ? (class$de$vw$mib$asi$tv$ASITV = ASIServiceFactory.class$("de.vw.mib.asi.tv.ASITV")) : class$de$vw$mib$asi$tv$ASITV).equals(clazz)) {
            ASITVBaseServiceImpl aSITVBaseServiceImpl = new ASITVBaseServiceImpl((ASITV)aSIService, aSIProperties, this.clogger);
            aSITVBaseServiceImpl.init();
            abstractService = new ASIHMISyncTVService(n, aSITVBaseServiceImpl);
        } else {
            throw new IllegalArgumentException(new StringBuffer().append("Unknown service class: ").append(clazz.getName()).toString());
        }
        return abstractService;
    }

    String getASIId(Class clazz) {
        if (null == clazz) {
            throw new NullPointerException("serviceClass");
        }
        String string = (class$de$vw$mib$asi$audio$ASIAudio == null ? (class$de$vw$mib$asi$audio$ASIAudio = ASIServiceFactory.class$("de.vw.mib.asi.audio.ASIAudio")) : class$de$vw$mib$asi$audio$ASIAudio).equals(clazz) ? "f10bdb8c-3351-5035-a073-26fb210dd987" : ((class$de$vw$mib$asi$car$bc$ASICarBordComputer == null ? (class$de$vw$mib$asi$car$bc$ASICarBordComputer = ASIServiceFactory.class$("de.vw.mib.asi.car.bc.ASICarBordComputer")) : class$de$vw$mib$asi$car$bc$ASICarBordComputer).equals(clazz) ? "2a6a543b-0fe6-5170-9fb4-6c05144dfe9c" : ((class$de$vw$mib$asi$car$climate$ASICarClimate == null ? (class$de$vw$mib$asi$car$climate$ASICarClimate = ASIServiceFactory.class$("de.vw.mib.asi.car.climate.ASICarClimate")) : class$de$vw$mib$asi$car$climate$ASICarClimate).equals(clazz) ? "c5ac76c2-2476-5a12-9346-cccd09428a82" : ((class$de$vw$mib$asi$car$driving$ASICarDriving == null ? (class$de$vw$mib$asi$car$driving$ASICarDriving = ASIServiceFactory.class$("de.vw.mib.asi.car.driving.ASICarDriving")) : class$de$vw$mib$asi$car$driving$ASICarDriving).equals(clazz) ? "a3a2eb6d-2c8e-59dd-b6c4-6d6508e2f15f" : ((class$de$vw$mib$asi$car$ASICarGeneric == null ? (class$de$vw$mib$asi$car$ASICarGeneric = ASIServiceFactory.class$("de.vw.mib.asi.car.ASICarGeneric")) : class$de$vw$mib$asi$car$ASICarGeneric).equals(clazz) ? "53d5f21b-54ec-5e84-8236-10ea0e3da972" : ((class$de$vw$mib$asi$car$service$ASICarService == null ? (class$de$vw$mib$asi$car$service$ASICarService = ASIServiceFactory.class$("de.vw.mib.asi.car.service.ASICarService")) : class$de$vw$mib$asi$car$service$ASICarService).equals(clazz) ? "a5b91462-5820-555c-8411-698e8ac5864d" : ((class$de$vw$mib$asi$generic$ASIGeneric == null ? (class$de$vw$mib$asi$generic$ASIGeneric = ASIServiceFactory.class$("de.vw.mib.asi.generic.ASIGeneric")) : class$de$vw$mib$asi$generic$ASIGeneric).equals(clazz) ? "acbc4ddf-b980-5af2-a38a-506f1125c975" : ((class$de$vw$mib$asi$headunit$ASIHeadUnit == null ? (class$de$vw$mib$asi$headunit$ASIHeadUnit = ASIServiceFactory.class$("de.vw.mib.asi.headunit.ASIHeadUnit")) : class$de$vw$mib$asi$headunit$ASIHeadUnit).equals(clazz) ? "c3516fb7-905b-55cc-97e2-b7c3dc5be53b" : ((class$de$vw$mib$asi$instance$ASIInstance == null ? (class$de$vw$mib$asi$instance$ASIInstance = ASIServiceFactory.class$("de.vw.mib.asi.instance.ASIInstance")) : class$de$vw$mib$asi$instance$ASIInstance).equals(clazz) ? "b0085475-d550-520a-8dc6-1d1e3293432f" : ((class$de$vw$mib$asi$mastercontrol$ASIMasterControl == null ? (class$de$vw$mib$asi$mastercontrol$ASIMasterControl = ASIServiceFactory.class$("de.vw.mib.asi.mastercontrol.ASIMasterControl")) : class$de$vw$mib$asi$mastercontrol$ASIMasterControl).equals(clazz) ? "5e04952b-b55c-5075-a09b-d930bfab035a" : ((class$de$vw$mib$asi$media$ASIMedia == null ? (class$de$vw$mib$asi$media$ASIMedia = ASIServiceFactory.class$("de.vw.mib.asi.media.ASIMedia")) : class$de$vw$mib$asi$media$ASIMedia).equals(clazz) ? "4f108b29-c4e8-5682-95cc-6d0ddd674cd8" : ((class$de$vw$mib$asi$media$ASIMediaBrowser == null ? (class$de$vw$mib$asi$media$ASIMediaBrowser = ASIServiceFactory.class$("de.vw.mib.asi.media.ASIMediaBrowser")) : class$de$vw$mib$asi$media$ASIMediaBrowser).equals(clazz) ? "8f2aa3cc-0c22-5ffa-83d3-4e78162cf3e6" : ((class$de$vw$mib$asi$navigation$ASINavigation == null ? (class$de$vw$mib$asi$navigation$ASINavigation = ASIServiceFactory.class$("de.vw.mib.asi.navigation.ASINavigation")) : class$de$vw$mib$asi$navigation$ASINavigation).equals(clazz) ? "59fbcec2-b8b2-5f69-a9e5-b65f2d9a124c" : ((class$de$vw$mib$asi$radio$ASIRadio == null ? (class$de$vw$mib$asi$radio$ASIRadio = ASIServiceFactory.class$("de.vw.mib.asi.radio.ASIRadio")) : class$de$vw$mib$asi$radio$ASIRadio).equals(clazz) ? "33f94559-8b21-58d2-8753-54f393719e53" : ((class$de$vw$mib$asi$sound$ASISound == null ? (class$de$vw$mib$asi$sound$ASISound = ASIServiceFactory.class$("de.vw.mib.asi.sound.ASISound")) : class$de$vw$mib$asi$sound$ASISound).equals(clazz) ? "2e1c96fb-d586-5fab-9cb1-92affc79ffb9" : ((class$de$vw$mib$asi$tv$ASITV == null ? (class$de$vw$mib$asi$tv$ASITV = ASIServiceFactory.class$("de.vw.mib.asi.tv.ASITV")) : class$de$vw$mib$asi$tv$ASITV).equals(clazz) ? "625d5dc3-8ed0-5a34-9759-b22cba16e480" : null)))))))))))))));
        return string;
    }

    Class getServiceClass(String string) {
        if (null == string) {
            throw new NullPointerException("asiId");
        }
        Class clazz = "f10bdb8c-3351-5035-a073-26fb210dd987".equals(string) ? (class$de$vw$mib$asi$audio$ASIAudio == null ? (class$de$vw$mib$asi$audio$ASIAudio = ASIServiceFactory.class$("de.vw.mib.asi.audio.ASIAudio")) : class$de$vw$mib$asi$audio$ASIAudio) : ("2a6a543b-0fe6-5170-9fb4-6c05144dfe9c".equals(string) ? (class$de$vw$mib$asi$car$bc$ASICarBordComputer == null ? (class$de$vw$mib$asi$car$bc$ASICarBordComputer = ASIServiceFactory.class$("de.vw.mib.asi.car.bc.ASICarBordComputer")) : class$de$vw$mib$asi$car$bc$ASICarBordComputer) : ("c5ac76c2-2476-5a12-9346-cccd09428a82".equals(string) ? (class$de$vw$mib$asi$car$climate$ASICarClimate == null ? (class$de$vw$mib$asi$car$climate$ASICarClimate = ASIServiceFactory.class$("de.vw.mib.asi.car.climate.ASICarClimate")) : class$de$vw$mib$asi$car$climate$ASICarClimate) : ("a3a2eb6d-2c8e-59dd-b6c4-6d6508e2f15f".equals(string) ? (class$de$vw$mib$asi$car$driving$ASICarDriving == null ? (class$de$vw$mib$asi$car$driving$ASICarDriving = ASIServiceFactory.class$("de.vw.mib.asi.car.driving.ASICarDriving")) : class$de$vw$mib$asi$car$driving$ASICarDriving) : ("53d5f21b-54ec-5e84-8236-10ea0e3da972".equals(string) ? (class$de$vw$mib$asi$car$ASICarGeneric == null ? (class$de$vw$mib$asi$car$ASICarGeneric = ASIServiceFactory.class$("de.vw.mib.asi.car.ASICarGeneric")) : class$de$vw$mib$asi$car$ASICarGeneric) : ("a5b91462-5820-555c-8411-698e8ac5864d".equals(string) ? (class$de$vw$mib$asi$car$service$ASICarService == null ? (class$de$vw$mib$asi$car$service$ASICarService = ASIServiceFactory.class$("de.vw.mib.asi.car.service.ASICarService")) : class$de$vw$mib$asi$car$service$ASICarService) : ("acbc4ddf-b980-5af2-a38a-506f1125c975".equals(string) ? (class$de$vw$mib$asi$generic$ASIGeneric == null ? (class$de$vw$mib$asi$generic$ASIGeneric = ASIServiceFactory.class$("de.vw.mib.asi.generic.ASIGeneric")) : class$de$vw$mib$asi$generic$ASIGeneric) : ("c3516fb7-905b-55cc-97e2-b7c3dc5be53b".equals(string) ? (class$de$vw$mib$asi$headunit$ASIHeadUnit == null ? (class$de$vw$mib$asi$headunit$ASIHeadUnit = ASIServiceFactory.class$("de.vw.mib.asi.headunit.ASIHeadUnit")) : class$de$vw$mib$asi$headunit$ASIHeadUnit) : ("b0085475-d550-520a-8dc6-1d1e3293432f".equals(string) ? (class$de$vw$mib$asi$instance$ASIInstance == null ? (class$de$vw$mib$asi$instance$ASIInstance = ASIServiceFactory.class$("de.vw.mib.asi.instance.ASIInstance")) : class$de$vw$mib$asi$instance$ASIInstance) : ("5e04952b-b55c-5075-a09b-d930bfab035a".equals(string) ? (class$de$vw$mib$asi$mastercontrol$ASIMasterControl == null ? (class$de$vw$mib$asi$mastercontrol$ASIMasterControl = ASIServiceFactory.class$("de.vw.mib.asi.mastercontrol.ASIMasterControl")) : class$de$vw$mib$asi$mastercontrol$ASIMasterControl) : ("4f108b29-c4e8-5682-95cc-6d0ddd674cd8".equals(string) ? (class$de$vw$mib$asi$media$ASIMedia == null ? (class$de$vw$mib$asi$media$ASIMedia = ASIServiceFactory.class$("de.vw.mib.asi.media.ASIMedia")) : class$de$vw$mib$asi$media$ASIMedia) : ("8f2aa3cc-0c22-5ffa-83d3-4e78162cf3e6".equals(string) ? (class$de$vw$mib$asi$media$ASIMediaBrowser == null ? (class$de$vw$mib$asi$media$ASIMediaBrowser = ASIServiceFactory.class$("de.vw.mib.asi.media.ASIMediaBrowser")) : class$de$vw$mib$asi$media$ASIMediaBrowser) : ("59fbcec2-b8b2-5f69-a9e5-b65f2d9a124c".equals(string) ? (class$de$vw$mib$asi$navigation$ASINavigation == null ? (class$de$vw$mib$asi$navigation$ASINavigation = ASIServiceFactory.class$("de.vw.mib.asi.navigation.ASINavigation")) : class$de$vw$mib$asi$navigation$ASINavigation) : ("33f94559-8b21-58d2-8753-54f393719e53".equals(string) ? (class$de$vw$mib$asi$radio$ASIRadio == null ? (class$de$vw$mib$asi$radio$ASIRadio = ASIServiceFactory.class$("de.vw.mib.asi.radio.ASIRadio")) : class$de$vw$mib$asi$radio$ASIRadio) : ("2e1c96fb-d586-5fab-9cb1-92affc79ffb9".equals(string) ? (class$de$vw$mib$asi$sound$ASISound == null ? (class$de$vw$mib$asi$sound$ASISound = ASIServiceFactory.class$("de.vw.mib.asi.sound.ASISound")) : class$de$vw$mib$asi$sound$ASISound) : ("625d5dc3-8ed0-5a34-9759-b22cba16e480".equals(string) ? (class$de$vw$mib$asi$tv$ASITV == null ? (class$de$vw$mib$asi$tv$ASITV = ASIServiceFactory.class$("de.vw.mib.asi.tv.ASITV")) : class$de$vw$mib$asi$tv$ASITV) : null)))))))))))))));
        return clazz;
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

