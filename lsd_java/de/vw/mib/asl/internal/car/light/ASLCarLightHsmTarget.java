/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.car.light;

import de.vw.mib.asl.api.car.light.LightService;
import de.vw.mib.asl.api.car.light.LightServiceListener;
import de.vw.mib.asl.api.car.logger.CarLogger;
import de.vw.mib.asl.car.persistence.Car;
import de.vw.mib.asl.car.persistence.CarPersistenceServiceImpl;
import de.vw.mib.asl.carearly.persistence.CarEarly;
import de.vw.mib.asl.carearly.persistence.CarEarlyPersistenceServiceImpl;
import de.vw.mib.asl.framework.internal.framework.AbstractASLTarget;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.car.ASLCarContainer;
import de.vw.mib.asl.internal.car.ASLCarUtil;
import de.vw.mib.asl.internal.car.framework.services.ServiceFactory;
import de.vw.mib.asl.internal.car.light.arrays.colorlist.ColorListContext;
import de.vw.mib.asl.internal.car.light.arrays.colorlist.ColorListController;
import de.vw.mib.asl.internal.car.light.transformer.CarLightAmbienceColorAreaSettings_1CollectorFactory;
import de.vw.mib.asl.internal.car.light.transformer.IntLightRGBColorTransformer;
import de.vw.mib.bap.datatypes.ArrayHeader;
import de.vw.mib.configuration.SkinInformationAsyncValueSetterService;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.GenericEvents;
import de.vw.mib.genericevents.impl.ArrayUtils;
import generated.de.vw.mib.asl.internal.ListManager;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.carlight.DSICarLight;
import org.dsi.ifc.carlight.DSICarLightListener;
import org.dsi.ifc.carlight.IntLightBrightness;
import org.dsi.ifc.carlight.IntLightConfig;
import org.dsi.ifc.carlight.IntLightRGBColorListRA0;
import org.dsi.ifc.carlight.IntLightRGBColorListUpdateInfo;
import org.dsi.ifc.carlight.IntLightRGBValues;
import org.dsi.ifc.carlight.IntLightViewOptions;
import org.dsi.ifc.carlight.MotorwayBlinkingSettings;
import org.dsi.ifc.carlight.TimeState;
import org.dsi.ifc.global.CarArrayListUpdateInfo;
import org.osgi.framework.ServiceReference;

public class ASLCarLightHsmTarget
extends AbstractASLTarget
implements ColorListContext,
CarLogger,
LightService {
    private DSICarLight dsiCarLight;
    private DSICarLightListener dsiCarLightListener;
    private boolean isAmbienceLight;
    private TimeState myTimeStateComingHome;
    private TimeState myTimeStateLeavingHome;
    private Integer[] comingLeavingHomeSettings;
    private Object[] ambienceLightBrightnessSettings;
    private MotorwayBlinkingSettings motorWayBlinking;
    private int duration;
    private int blinkingTimes;
    private String SRGBColor = "#000000";
    private final boolean useOldColorImplementation;
    private boolean sentIlluminationSet4 = false;
    private boolean sentSetIntLightState = false;
    public static final int HOME_SETTINGS_COMING;
    public static final int HOME_SETTINGS_LEAVING;
    public static final int AMBIENCELIGHT_SETTINGS_STANDARD;
    public static final int AMBIENCELIGHT_SETTINGS_FOOTSPACE;
    private int COMINGHOME_DURATION_VALUE;
    private int LEAVINGHOME_DURATION_VALUE;
    private boolean AFS_ACTIVESTATE;
    private boolean AUTO_RAIN_LIGHT_ACTIVESTATE;
    private boolean COMFORTBLINKING_ACTIVESTATE;
    private boolean DAYDRIVING_LIGHT_ACTIVESTATE;
    private boolean HEADLIGHT_SYSTEM_ACTIVESTATE;
    private int INSTRUMENTLIGHT_DURATION_VALUE;
    private int HEADLAMP_DURATION_VALUE;
    private boolean MASK_HIGH_BEAM_LIGHT_ACTIVESTATE;
    private int COCKPIT_LIGHT_DURATION_VALUE;
    private int STANDARD_LIGHT_DURATION_VALUE;
    private int FOOTSPACE_LIGHT_DURATION_VALUE;
    private int CENTER_CONSOLE_LIGHT;
    private int FOOTWELL_FRONT_REAR;
    private int FOOTWELL_REAR;
    private int DOORS_FRONT_REAR;
    private int DOORS_REAR;
    private int ROOF_FRONT_REAR;
    private int FRONT;
    private int ROOF_REAR;
    private boolean currentStateTouristLight = false;
    private boolean isLeftHandTraffic = false;
    private IntLightBrightness myBrightness = new IntLightBrightness();
    private int currentLightState = -1;
    private int colorLight = 0;
    private int ALL_LIGHT_DURATION_VALUE = 0;
    private int ROOF_LIGHT_DURATION_VALUE = 0;
    private int INIT_COLOR_VALUE;
    private int COLOR_SET_BY_HMI = this.INIT_COLOR_VALUE = -1;
    private ColorListController colorListController;
    private CarEarly carEarly;
    public static final int NONE_AMBIENT_COLOR;
    private int selectedColor = 0;
    private int[] colorList = new int[]{this.selectedColor};
    public static final int[] LEVELS;
    public static final int[] MIB_SENDS_VALUE;
    public static final int[][] MIB_RECEIVES_VALUE;
    static /* synthetic */ Class class$org$dsi$ifc$carlight$DSICarLightListener;
    static /* synthetic */ Class class$org$dsi$ifc$carlight$DSICarLight;
    static /* synthetic */ Class class$de$vw$mib$configuration$SkinInformationAsyncValueSetterService;
    static /* synthetic */ Class class$de$vw$mib$asl$api$car$light$LightServiceListener;
    static /* synthetic */ Class class$de$vw$mib$asl$api$car$light$LightService;

    public ASLCarLightHsmTarget(GenericEvents genericEvents, String string) {
        super(genericEvents, string);
        this.useOldColorImplementation = false;
    }

    @Override
    public int getDefaultTargetId() {
        return -1840311808;
    }

    @Override
    public int getSubClassifier() {
        return 1;
    }

    private void registerModelEvents() {
        this.addObservers(new int[]{-385155008, -368377792, -401932224, -418709440, -334823360, -351600576, -267714496, -301268928, -318046144, -217382848, -250937280, -234160064, 772603968, 755826752, -200605632, -183828416, -284491712, -16056256, 621486080, 655040512, -66387904, -49610688, -99942336, -83165120, -167051200, -150273984, -200605632, -183828416, -133496768, -116719552, -32833472, -636747712, -653524928, 822935616, 1208811584, 789381184, 151846976, 185401408, 202178624, 0xD0D0040, 235733056, 252510272, 269287488, 168624192, 286064704, 302841920, 319619136, 336396352, 353173568, 369950784});
    }

    private void registerOnCarExtLight() {
        this.dsiCarLight.setNotification(new int[]{13, 14, 21, 15, 18, 16, 22, 28, 19, 17, 54}, (DSIListener)this.dsiCarLightListener);
        this.dsiCarLight.setNotification(new int[]{27}, (DSIListener)this.dsiCarLightListener);
    }

    private void registerOnCarIntLight() {
        this.dsiCarLight.setNotification(new int[]{29, 30, 31, 32, 33, 34, 35, 36, 46, 49, 50, 1}, (DSIListener)this.dsiCarLightListener);
        ASLCarContainer.getInstance().getDSIProxy().addResponseListener(this, class$org$dsi$ifc$carlight$DSICarLightListener == null ? (class$org$dsi$ifc$carlight$DSICarLightListener = ASLCarLightHsmTarget.class$("org.dsi.ifc.carlight.DSICarLightListener")) : class$org$dsi$ifc$carlight$DSICarLightListener, ASLCarContainer.getInstance().getAdapterFactory().createDSIListenerMethodAdapter(this, class$org$dsi$ifc$carlight$DSICarLightListener == null ? (class$org$dsi$ifc$carlight$DSICarLightListener = ASLCarLightHsmTarget.class$("org.dsi.ifc.carlight.DSICarLightListener")) : class$org$dsi$ifc$carlight$DSICarLightListener));
    }

    private void clearOnCarIntLight() {
        this.dsiCarLight.clearNotification(new int[]{29, 30, 31, 32, 33, 34, 35, 36, 46, 49, 50}, (DSIListener)this.dsiCarLightListener);
    }

    @Override
    public void gotEvent(EventGeneric eventGeneric) {
        if (this.isTraceEnabled()) {
            this.trace().append("Event received: ").append(eventGeneric.getReceiverEventId()).log();
        }
        block1 : switch (eventGeneric.getReceiverEventId()) {
            case 106: {
                try {
                    this.carEarly = CarEarlyPersistenceServiceImpl.getInstance().loadCarEarly();
                }
                catch (Exception exception) {
                    this.error(new StringBuffer().append("fail to read persistence!").append(exception.getMessage()).toString());
                }
                this.dsiCarLight = (DSICarLight)ASLCarContainer.getInstance().getDSIProxy().getService(this, class$org$dsi$ifc$carlight$DSICarLight == null ? (class$org$dsi$ifc$carlight$DSICarLight = ASLCarLightHsmTarget.class$("org.dsi.ifc.carlight.DSICarLight")) : class$org$dsi$ifc$carlight$DSICarLight);
                this.dsiCarLightListener = (DSICarLightListener)ASLCarContainer.getInstance().getAdapterFactory().createDSIListenerMethodAdapter(this, class$org$dsi$ifc$carlight$DSICarLightListener == null ? (class$org$dsi$ifc$carlight$DSICarLightListener = ASLCarLightHsmTarget.class$("org.dsi.ifc.carlight.DSICarLightListener")) : class$org$dsi$ifc$carlight$DSICarLightListener);
                this.myTimeStateComingHome = new TimeState();
                this.myTimeStateLeavingHome = new TimeState();
                this.comingLeavingHomeSettings = new Integer[2];
                this.ambienceLightBrightnessSettings = new Object[2];
                this.motorWayBlinking = new MotorwayBlinkingSettings();
                this.registerModelEvents();
                this.updateClientAmbianceLightColor();
                this.COLOR_SET_BY_HMI = CarPersistenceServiceImpl.getInstance().loadCar().getIntLightColor();
                this.registerOnCarExtLight();
                this.registerAsServiceProvider();
                this.initPrivateDPPropertyValues();
                this.isAmbienceLight = false;
                break;
            }
            case 2100005: {
                this.isLeftHandTraffic = eventGeneric.getBoolean(0);
                this.evaluateTouristLight();
                break;
            }
            case 2100007: {
                if (eventGeneric.getBoolean(0)) {
                    if (!eventGeneric.getBoolean(1)) {
                        this.dsiCarLight.clearNotification(new int[]{8, 7}, (DSIListener)this.dsiCarLightListener);
                    }
                    this.clearOnCarIntLight();
                    break;
                }
                if (eventGeneric.getBoolean(1)) {
                    this.dsiCarLight.setNotification(new int[]{8, 7}, (DSIListener)this.dsiCarLightListener);
                }
                this.registerOnCarIntLight();
                break;
            }
            case 1073744873: {
                if (this.isTraceEnabled()) {
                    this.trace().append("toggle comfort blinkingfunction. value: ").append(!this.COMFORTBLINKING_ACTIVESTATE).log();
                }
                this.toggleComfortBlinking(!this.COMFORTBLINKING_ACTIVESTATE);
                break;
            }
            case 1073744874: {
                this.setTouristLight(eventGeneric.getInt(0));
                break;
            }
            case 1073744872: {
                this.deIncreaseComingLeavingHome(eventGeneric.getInt(0), eventGeneric.getBoolean(1));
                break;
            }
            case 1073744871: {
                switch (eventGeneric.getInt(1)) {
                    case 0: {
                        this.setComingHomeDuration(eventGeneric.getInt(0));
                        break block1;
                    }
                    case 1: {
                        this.setLeavingHomeDuration(eventGeneric.getInt(0));
                        break block1;
                    }
                }
                this.error("Car Light Coming Leaving Home: selection does not implemented!");
                break;
            }
            case 1073744876: {
                this.deIncreaseAmbienceLight(eventGeneric.getInt(0), eventGeneric.getBoolean(1));
                break;
            }
            case 1073744875: {
                this.setAmbienceLight(eventGeneric.getInt(1), eventGeneric.getInt(0));
                break;
            }
            case 1073744880: {
                this.setAutoLightSensitivity(eventGeneric);
                break;
            }
            case 1073744878: {
                this.toggleASF(!this.AFS_ACTIVESTATE);
                break;
            }
            case 1073744877: {
                this.toggleDayDrivingLight(!this.DAYDRIVING_LIGHT_ACTIVESTATE);
                break;
            }
            case 1073744883: {
                this.toggleMDF(!this.MASK_HIGH_BEAM_LIGHT_ACTIVESTATE);
                break;
            }
            case 1073744881: {
                this.setInstrumentPanelDuration(eventGeneric.getInt(0));
                break;
            }
            case 1073744882: {
                this.deIncreaseInstrumentPanelLight(eventGeneric.getBoolean(0));
                break;
            }
            case 1073745197: {
                this.deIncreaseHeadlampLeveling(eventGeneric.getBoolean(0));
                break;
            }
            case 1073745198: {
                this.setheadlamprange(eventGeneric.getInt(0));
                break;
            }
            case 1073744885: {
                this.deIncreaseCockpitLight(eventGeneric.getBoolean(0));
                break;
            }
            case 1073744884: {
                this.setIntLightIllumination(ASLCarContainer.DP_ILLUMINATION_COCKPIT, eventGeneric.getInt(0));
                break;
            }
            case 1073744879: {
                this.setAutomaticLight(!this.AUTO_RAIN_LIGHT_ACTIVESTATE);
                break;
            }
            case 1073744895: {
                this.toggleHeadLightSystem(!this.HEADLIGHT_SYSTEM_ACTIVESTATE);
                break;
            }
            case 1073744892: {
                this.setIntLightIllumination(ASLCarContainer.DP_ILLUMINATION_ALL_SYNC, eventGeneric.getInt(0));
                break;
            }
            case 1073744893: {
                this.deIncreaseAmbienceLightSlider(eventGeneric.getBoolean(0), this.ALL_LIGHT_DURATION_VALUE, 10, 0, 100, ASLCarContainer.DP_ILLUMINATION_ALL_SYNC);
                break;
            }
            case 1073744890: {
                this.setIntLightIllumination(ASLCarContainer.DP_ILLUMINATION_ROOF_FRONT, eventGeneric.getInt(0));
                break;
            }
            case 1073744891: {
                this.deIncreaseAmbienceLightSlider(eventGeneric.getBoolean(0), this.ROOF_LIGHT_DURATION_VALUE, 10, 0, 100, ASLCarContainer.DP_ILLUMINATION_ROOF_FRONT);
                break;
            }
            case 1073744886: {
                this.setIntLightIllumination(ASLCarContainer.DP_ILLUMINATION_DOORS_FRONTWELL_FRONT, eventGeneric.getInt(0));
                break;
            }
            case 1073744887: {
                this.deIncreaseAmbienceLightSlider(eventGeneric.getBoolean(0), this.STANDARD_LIGHT_DURATION_VALUE, 10, 0, 100, ASLCarContainer.DP_ILLUMINATION_DOORS_FRONTWELL_FRONT);
                break;
            }
            case 1073744888: {
                this.setIntLightIllumination(ASLCarContainer.DP_ILLUMINATION_FOOTWELL_FRONT, eventGeneric.getInt(0));
                break;
            }
            case 1073744889: {
                this.deIncreaseAmbienceLightSlider(eventGeneric.getBoolean(0), this.FOOTSPACE_LIGHT_DURATION_VALUE, 10, 0, 100, ASLCarContainer.DP_ILLUMINATION_FOOTWELL_FRONT);
                break;
            }
            case 1073744894: {
                this.setIntLightColor(eventGeneric.getInt(0));
                break;
            }
            case 1073745114: {
                this.deIncreaseAmbienceLightSlider(eventGeneric.getBoolean(0), this.CENTER_CONSOLE_LIGHT, 10, 0, 100, ASLCarContainer.DP_ILLUMINATION_CENTER_CONSOLE);
                break;
            }
            case 1073745113: {
                this.setIntLightIllumination(ASLCarContainer.DP_ILLUMINATION_CENTER_CONSOLE, eventGeneric.getInt(0));
                break;
            }
            case 1073745161: {
                this.setIntLightIllumination(ASLCarContainer.DP_ILLUMINATION_FOOTWELL_FRONT_REAR, eventGeneric.getInt(0));
                break;
            }
            case 1073745162: {
                this.deIncreaseAmbienceLightSlider(eventGeneric.getBoolean(0), this.FOOTWELL_FRONT_REAR, 10, 0, 100, ASLCarContainer.DP_ILLUMINATION_FOOTWELL_FRONT_REAR);
                break;
            }
            case 1073745163: {
                this.setIntLightIllumination(ASLCarContainer.DP_ILLUMINATION_FOOTWELL_REAR, eventGeneric.getInt(0));
                break;
            }
            case 1073745169: {
                this.deIncreaseAmbienceLightSlider(eventGeneric.getBoolean(0), this.FOOTWELL_REAR, 10, 0, 100, ASLCarContainer.DP_ILLUMINATION_FOOTWELL_REAR);
                break;
            }
            case 1073745164: {
                this.setIntLightIllumination(ASLCarContainer.DP_ILLUMINATION_DOORS_FRONT_REAR, eventGeneric.getInt(0));
                break;
            }
            case 1073745170: {
                this.deIncreaseAmbienceLightSlider(eventGeneric.getBoolean(0), this.STANDARD_LIGHT_DURATION_VALUE, 10, 0, 100, ASLCarContainer.DP_ILLUMINATION_DOORS_FRONT_REAR);
                break;
            }
            case 0x40000D0D: {
                this.setIntLightIllumination(ASLCarContainer.NOT_DOORS_FOOTWELLREAR, eventGeneric.getInt(0));
                break;
            }
            case 1073745171: {
                this.deIncreaseAmbienceLightSlider(eventGeneric.getBoolean(0), this.DOORS_REAR, 10, 0, 100, ASLCarContainer.NOT_DOORS_FOOTWELLREAR);
                break;
            }
            case 1073745166: {
                this.setIntLightIllumination(ASLCarContainer.DP_ILLUMINATION_ROOF_FRONT_REAR, eventGeneric.getInt(0));
                break;
            }
            case 1073745172: {
                this.deIncreaseAmbienceLightSlider(eventGeneric.getBoolean(0), this.ROOF_FRONT_REAR, 10, 0, 100, ASLCarContainer.DP_ILLUMINATION_ROOF_FRONT_REAR);
                break;
            }
            case 1073745167: {
                this.setIntLightIllumination(ASLCarContainer.DP_ILLUMINATION_ROOF_REAR, eventGeneric.getInt(0));
                break;
            }
            case 1073745173: {
                this.deIncreaseAmbienceLightSlider(eventGeneric.getBoolean(0), this.ROOF_REAR, 10, 0, 100, ASLCarContainer.DP_ILLUMINATION_ROOF_REAR);
                break;
            }
            case 1073745168: {
                this.setIntLightIllumination(ASLCarContainer.DP_ILLUMINATION_FRONT, eventGeneric.getInt(0));
                break;
            }
            case 1073745174: {
                this.deIncreaseAmbienceLightSlider(eventGeneric.getBoolean(0), this.FRONT, 10, 0, 100, ASLCarContainer.DP_ILLUMINATION_FRONT);
                break;
            }
            case 1073745201: {
                this.setAmbianceLightState(eventGeneric.getBoolean(0));
                break;
            }
            case 1073745224: {
                this.setAmbianceLightState(eventGeneric.getInt(0));
                break;
            }
            case 1073745199: {
                this.setAmbianceLightColor(eventGeneric.getInt(0));
                break;
            }
        }
    }

    private void toggleComfortBlinking(boolean bl) {
        if (this.isTraceEnabled()) {
            this.trace().append("toggle comfort blinking. Value: ").append(bl).log();
        }
        this.motorWayBlinking.time = this.blinkingTimes;
        this.motorWayBlinking.state = bl;
        this.dsiCarLight.setExtLightMotorwayBlinking(this.motorWayBlinking);
    }

    private void setTouristLight(int n) {
        if (this.isTraceEnabled()) {
            this.trace().append("toggle tourist light. Value: ").append(n).log();
        }
        switch (n) {
            case 0: {
                if (this.isLeftHandTraffic) {
                    this.dsiCarLight.setExtLightTourist(true);
                    break;
                }
                this.dsiCarLight.setExtLightTourist(false);
                break;
            }
            case 1: {
                if (this.isLeftHandTraffic) {
                    this.dsiCarLight.setExtLightTourist(false);
                    break;
                }
                this.dsiCarLight.setExtLightTourist(true);
                break;
            }
            default: {
                this.error("[ERROR] selection does not exists in setTouristLight!");
            }
        }
    }

    private void deIncreaseComingLeavingHome(int n, boolean bl) {
        switch (n) {
            case 0: {
                this.duration = ASLCarUtil.durationTimeMinMaxValue(bl, this.COMINGHOME_DURATION_VALUE, 5, 0, 30);
                if (this.duration != -1) {
                    if (this.isTraceEnabled()) {
                        this.trace().append("modified coming leaving home light. Value: ").append(this.duration).log();
                    }
                    this.setComingHomeDuration(this.duration);
                    break;
                }
                if (!this.isTraceEnabled()) break;
                this.trace().append("Can not modified coming home light. The duration is out of the range: ").append(this.duration).log();
                break;
            }
            case 1: {
                this.duration = ASLCarUtil.durationTimeMinMaxValue(bl, this.LEAVINGHOME_DURATION_VALUE, 5, 0, 30);
                if (this.duration != -1) {
                    if (this.isTraceEnabled()) {
                        this.trace().append("modified coming leaving home light. Value: ").append(this.duration).log();
                    }
                    this.setLeavingHomeDuration(this.duration);
                    break;
                }
                if (!this.isTraceEnabled()) break;
                this.trace().append("Can not modified coming home light. The duration is out of the range: ").append(this.duration).log();
                break;
            }
            default: {
                if (!this.isTraceEnabled()) break;
                this.error("[INFO] This selections setting does not exists in \"decrease light settings\"");
            }
        }
    }

    private void deIncreaseAmbienceLight(int n, boolean bl) {
        switch (n) {
            case 0: {
                this.duration = ASLCarUtil.durationTimeMinMaxValue(bl, this.DOORS_FRONT_REAR, 10, 0, 100);
                if (this.duration != -1) {
                    if (this.isTraceEnabled()) {
                        this.trace().append("modified ambience light. Value: ").append(this.duration).log();
                    }
                    this.setIntLightIllumination(ASLCarContainer.DP_ILLUMINATION_DOORS_FRONT_REAR, this.duration);
                    break;
                }
                if (!this.isTraceEnabled()) break;
                this.trace().append("Can not modified ambience light. The duration is out of the range: ").append(this.duration).log();
                break;
            }
            case 1: {
                this.duration = this.isAmbienceLight ? ASLCarUtil.durationTimeMinMaxValue(bl, this.FOOTSPACE_LIGHT_DURATION_VALUE, 10, 0, 100) : ASLCarUtil.durationTimeMinMaxValue(bl, this.FOOTWELL_FRONT_REAR, 10, 0, 100);
                if (this.duration != -1) {
                    if (this.isTraceEnabled()) {
                        this.trace().append("modified footspace light. Value: ").append(this.duration).log();
                    }
                    if (this.isAmbienceLight) {
                        this.setIntLightIllumination(ASLCarContainer.DP_ILLUMINATION_FOOTWELL_FRONT, this.duration);
                        break;
                    }
                    this.setIntLightIllumination(ASLCarContainer.DP_ILLUMINATION_FOOTWELL_FRONT_REAR, this.duration);
                    break;
                }
                if (!this.isTraceEnabled()) break;
                this.trace().append("Can not modified ambience light. The duration is out of the range: ").append(this.duration).log();
                break;
            }
            default: {
                if (!this.isTraceEnabled()) break;
                this.error("[INFO] This selections setting does not exists in \"in/decrease light settings\"");
            }
        }
    }

    private void setComingHomeDuration(int n) {
        if (this.isTraceEnabled()) {
            this.trace().append("modified coming home duration. Value: ").append(n).log();
        }
        this.myTimeStateComingHome.time = n;
        this.dsiCarLight.setExtLightComingHome(this.myTimeStateComingHome);
    }

    private void setLeavingHomeDuration(int n) {
        if (this.isTraceEnabled()) {
            this.trace().append("modified leaving home duration. Value: ").append(n).log();
        }
        this.myTimeStateLeavingHome.time = n;
        this.dsiCarLight.setExtLightLeavingHome(this.myTimeStateLeavingHome);
    }

    private void informHMIAmbienceLight(int n, int n2) {
        this.ambienceLightBrightnessSettings[n2] = new Integer(n);
        ListManager.getGenericASLList(10146).updateList(this.ambienceLightBrightnessSettings);
    }

    private void setAutomaticLight(boolean bl) {
        if (this.isTraceEnabled()) {
            this.trace().append("modified automatic light. RainLight: ").append(bl).log();
        }
        this.dsiCarLight.setExtLightAutomaticLight(bl, false);
    }

    private void setAmbienceLight(int n, int n2) {
        switch (n) {
            case 0: {
                this.setIntLightIllumination(ASLCarContainer.DP_ILLUMINATION_DOORS_FRONT_REAR, n2);
                break;
            }
            case 1: {
                if (this.isAmbienceLight) {
                    this.setIntLightIllumination(ASLCarContainer.DP_ILLUMINATION_FOOTWELL_FRONT, n2);
                    break;
                }
                this.setIntLightIllumination(ASLCarContainer.DP_ILLUMINATION_FOOTWELL_FRONT_REAR, n2);
                break;
            }
            default: {
                this.error("Car Light Ambience: selection does not implemented!");
            }
        }
    }

    private void setAutoLightSensitivity(EventGeneric eventGeneric) {
        if (this.isTraceEnabled()) {
            this.trace().append("modified the auto light sensitivity. Value: ").append(eventGeneric.getInt(0)).log();
        }
        switch (eventGeneric.getInt(0)) {
            case 2: {
                if (this.isTraceEnabled()) {
                    this.trace().append("Setting auto light sensitivity to insensitive (2)").log();
                }
                this.dsiCarLight.setExtLightSwitchOnSensitivity(2);
                break;
            }
            case 1: {
                if (this.isTraceEnabled()) {
                    this.trace().append("Setting auto light sensitivity to normal (1)").log();
                }
                this.dsiCarLight.setExtLightSwitchOnSensitivity(1);
                break;
            }
            case 0: {
                if (this.isTraceEnabled()) {
                    this.trace().append("Setting auto light sensitivity to sensitive (0)").log();
                }
                this.dsiCarLight.setExtLightSwitchOnSensitivity(0);
                break;
            }
            default: {
                if (!this.isTraceEnabled()) break;
                this.error("[INFO]the selection does not exists in \"auto light sensitivity\"");
            }
        }
    }

    private void toggleASF(boolean bl) {
        if (this.isTraceEnabled()) {
            this.trace().append("toggle ASF: ").append(bl).log();
        }
        this.dsiCarLight.setExtLightAdaptive(bl);
    }

    private void toggleDayDrivingLight(boolean bl) {
        if (this.isTraceEnabled()) {
            this.trace().append("toggle day driving light: ").append(bl).log();
        }
        this.dsiCarLight.setExtLightDayLight(bl);
    }

    private void toggleMDF(boolean bl) {
        if (this.isTraceEnabled()) {
            this.trace().append("toggle MDF: ").append(bl).log();
        }
        this.dsiCarLight.setExtLightMaskedHighBeam(bl);
    }

    private void deIncreaseInstrumentPanelLight(boolean bl) {
    }

    private void deIncreaseHeadlampLeveling(boolean bl) {
        this.duration = this.durationTimeMinMaxValue(bl, this.HEADLAMP_DURATION_VALUE, 1, 0, 6);
        if (this.duration != -1) {
            if (this.isTraceEnabled()) {
                this.trace().append("Headlamp level Value: ").append(this.duration).log();
            }
            this.setheadlamprange(this.duration);
        } else if (this.isTraceEnabled()) {
            this.trace().append("Headlamp level Value. The duration is out of the range: ").append(this.duration).log();
        }
    }

    private int durationTimeMinMaxValue(boolean bl, int n, int n2, int n3, int n4) {
        if (bl) {
            return Math.max(n3, n - n2);
        }
        return Math.min(n4, n + n2);
    }

    private void setheadlamprange(int n) {
        for (int i2 = 0; i2 < LEVELS.length; ++i2) {
            if (n != LEVELS[i2]) continue;
            this.dsiCarLight.setExtLightHeadlightRange(MIB_SENDS_VALUE[i2]);
        }
    }

    private void setInstrumentPanelDuration(int n) {
        if (this.isTraceEnabled()) {
            this.trace().append("instrument panel duration: ").append(n).log();
        }
        this.myBrightness.brightness = (short)n;
        this.dsiCarLight.setIntLightBrightness(this.myBrightness);
    }

    private void deIncreaseCockpitLight(boolean bl) {
        this.duration = ASLCarUtil.durationTimeMinMaxValue(bl, this.COCKPIT_LIGHT_DURATION_VALUE, 10, 0, 100);
        if (this.duration != -1) {
            if (this.isTraceEnabled()) {
                this.trace().append("modified cockpit light. Value: ").append(this.duration).log();
            }
            this.setIntLightIllumination(ASLCarContainer.DP_ILLUMINATION_COCKPIT, this.duration);
        } else if (this.isTraceEnabled()) {
            this.trace().append("Can not modified instrument panel light. The duration is out of the range: ").append(this.duration).log();
        }
    }

    private void setIntLightIllumination(int n, int n2) {
        if (this.isTraceEnabled()) {
            this.trace().append("IlluminationSet: ").append(n).append(" duration: ").append(n2).log();
        }
        this.sentIlluminationSet4 = ASLCarContainer.DP_ILLUMINATION_INT_SETTINGS_4 == n;
        this.dsiCarLight.setIntLightIlluminationSet(n, n2);
    }

    private void toggleHeadLightSystem(boolean bl) {
        if (this.isTraceEnabled()) {
            this.trace().append("toggle headlight system: ").append(bl).log();
        }
        this.dsiCarLight.setExtLightHeadLightSystem(bl);
    }

    private void setIntLightColor(int n) {
        switch (n) {
            case 0: {
                this.dsiCarLight.setIntLightState(0);
                if (this.currentLightState == 0) break;
                this.sentSetIntLightState = true;
                break;
            }
            case 1: {
                this.setIntLightColour(0);
                break;
            }
            case 2: {
                this.setIntLightColour(1);
                break;
            }
            case 3: {
                this.setIntLightColour(2);
                break;
            }
            case 4: {
                this.setIntLightColour(3);
                break;
            }
            case 5: {
                this.setIntLightColour(4);
                break;
            }
            case 6: {
                this.setIntLightColour(5);
                break;
            }
        }
    }

    private void setIntLightColour(int n) {
        this.COLOR_SET_BY_HMI = n;
        if (this.currentLightState == 0) {
            this.dsiCarLight.setIntLightState(1);
            this.sentSetIntLightState = true;
        } else if (this.INIT_COLOR_VALUE < n) {
            this.dsiCarLight.setIntLightColour(n);
        }
    }

    private void deIncreaseAmbienceLightSlider(boolean bl, int n, int n2, int n3, int n4, int n5) {
        this.duration = ASLCarUtil.durationTimeMinMaxValue(bl, n, n2, n3, n4);
        if (this.duration != -1) {
            if (this.isTraceEnabled()) {
                this.trace().append("modified ambience light settings. Value: ").append(this.duration).log();
            }
            this.setIntLightIllumination(n5, this.duration);
        } else if (this.isTraceEnabled()) {
            this.trace().append("Can not modified ambienceLightSettings. The duration is out of the range: ").append(this.duration).log();
        }
    }

    public void dsiCarLightUpdateExtLightComingHome(TimeState timeState, int n) {
        if (this.isTraceEnabled()) {
            this.trace().append("DSI UPDATE: ExtLightComingHome. Values: ").append(timeState.toString()).log();
        }
        this.myTimeStateComingHome = timeState;
        this.comingLeavingHomeSettings[0] = new Integer(timeState.getTime());
        ListManager.getGenericASLList(10143).updateList(this.comingLeavingHomeSettings);
        this.COMINGHOME_DURATION_VALUE = timeState.getTime();
        if (this.isTraceEnabled()) {
            this.trace().append("listvalues: coming home ").append(this.comingLeavingHomeSettings[0]).append(" leaving home ").append(this.comingLeavingHomeSettings[1]).log();
        }
    }

    public void dsiCarLightUpdateExtLightLeavingHome(TimeState timeState, int n) {
        if (this.isTraceEnabled()) {
            this.trace().append("DSI UPDATE: ExtLightLeavingHome. Values: ").append(timeState.toString()).log();
        }
        this.myTimeStateLeavingHome = timeState;
        this.comingLeavingHomeSettings[1] = new Integer(timeState.getTime());
        ListManager.getGenericASLList(10143).updateList(this.comingLeavingHomeSettings);
        this.LEAVINGHOME_DURATION_VALUE = timeState.getTime();
        if (this.isTraceEnabled()) {
            this.trace().append("listvalues: coming home ").append(this.comingLeavingHomeSettings[0]).append(" leaving home ").append(this.comingLeavingHomeSettings[1]).log();
        }
    }

    public void dsiCarLightUpdateExtLightTourist(boolean bl, int n) {
        this.currentStateTouristLight = bl;
        this.evaluateTouristLight();
    }

    public void dsiCarLightUpdateExtLightMotorwayBlinking(MotorwayBlinkingSettings motorwayBlinkingSettings, int n) {
        this.motorWayBlinking = motorwayBlinkingSettings;
        if (this.motorWayBlinking != null) {
            if (this.isTraceEnabled()) {
                this.trace().append("DSI UPDATE: MotorwayBlinking. Values: ").append(motorwayBlinkingSettings.toString()).log();
            }
            this.COMFORTBLINKING_ACTIVESTATE = this.motorWayBlinking.isState();
            this.blinkingTimes = this.motorWayBlinking.time;
            ASLCarLightHsmTarget.writeBooleanToDatapool(10144, this.motorWayBlinking.state);
        }
    }

    public void dsiCarLightUpdateExtLightSwitchOnSensitivity(int n, int n2) {
        switch (n) {
            case 2: {
                if (this.isTraceEnabled()) {
                    this.trace().append("Setting auto light sensitivity to low").log();
                }
                ASLCarLightHsmTarget.writeIntegerToDatapool(10149, 2);
                break;
            }
            case 1: {
                if (this.isTraceEnabled()) {
                    this.trace().append("Setting auto light sensitivity to medium").log();
                }
                ASLCarLightHsmTarget.writeIntegerToDatapool(10149, 1);
                break;
            }
            case 0: {
                if (this.isTraceEnabled()) {
                    this.trace().append("Setting auto light sensitivity to high").log();
                }
                ASLCarLightHsmTarget.writeIntegerToDatapool(10149, 0);
                break;
            }
            default: {
                if (!this.isTraceEnabled()) break;
                this.trace().append("[INFO] Can not handle this update: ").append(n).append(" for setting \"auto light sensitivity\"!").log();
            }
        }
    }

    public void dsiCarLightUpdateExtLightAdaptive(boolean bl, int n) {
        if (this.isTraceEnabled()) {
            this.trace().append("DSI UPDATE: AFS. Value: ").append(bl).log();
        }
        this.AFS_ACTIVESTATE = bl;
        ASLCarLightHsmTarget.writeBooleanToDatapool(10148, this.AFS_ACTIVESTATE);
    }

    public void dsiCarLightUpdateExtLightDaylight(boolean bl, int n) {
        if (this.isTraceEnabled()) {
            this.trace().append("DSI UPDATE: Day Driving Light. Value: ").append(bl).log();
        }
        this.DAYDRIVING_LIGHT_ACTIVESTATE = bl;
        ASLCarLightHsmTarget.writeBooleanToDatapool(10147, this.DAYDRIVING_LIGHT_ACTIVESTATE);
    }

    public void dsiCarLightUpdateExtLightMaskedHighBeam(boolean bl, int n) {
        this.MASK_HIGH_BEAM_LIGHT_ACTIVESTATE = bl;
        ASLCarLightHsmTarget.writeBooleanToDatapool(10152, this.MASK_HIGH_BEAM_LIGHT_ACTIVESTATE);
    }

    public void dsiCarLightUpdateIntLightBrightness(IntLightBrightness intLightBrightness, int n) {
        this.myBrightness = intLightBrightness;
        this.INSTRUMENTLIGHT_DURATION_VALUE = this.myBrightness.getBrightness();
        ASLCarLightHsmTarget.writeIntegerToDatapool(10151, this.INSTRUMENTLIGHT_DURATION_VALUE);
    }

    public void dsiCarLightUpdateExtLightAutomaticLight(boolean bl, boolean bl2, int n) {
        this.AUTO_RAIN_LIGHT_ACTIVESTATE = bl;
        ASLCarLightHsmTarget.writeBooleanToDatapool(10150, this.AUTO_RAIN_LIGHT_ACTIVESTATE);
    }

    public void dsiCarLightUpdateIntLightIlluminationSet1(int n, int n2) {
        this.checkingUpdateIlluminationsSet(n, ASLCarContainer.DP_ILLUMINATION_INT_SETTINGS_1);
    }

    public void dsiCarLightUpdateIntLightIlluminationSet2(int n, int n2) {
        this.checkingUpdateIlluminationsSet(n, ASLCarContainer.DP_ILLUMINATION_INT_SETTINGS_2);
    }

    public void dsiCarLightUpdateIntLightIlluminationSet3(int n, int n2) {
        this.checkingUpdateIlluminationsSet(n, ASLCarContainer.DP_ILLUMINATION_INT_SETTINGS_3);
    }

    public void dsiCarLightUpdateIntLightIlluminationSet4(int n, int n2) {
        this.checkingUpdateIlluminationsSet(n, ASLCarContainer.DP_ILLUMINATION_INT_SETTINGS_4);
    }

    public void dsiCarLightUpdateIntLightIlluminationSet5(int n, int n2) {
        this.checkingUpdateIlluminationsSet(n, ASLCarContainer.DP_ILLUMINATION_INT_SETTINGS_5);
    }

    public void dsiCarLightUpdateIntLightIlluminationSet6(int n, int n2) {
        this.checkingUpdateIlluminationsSet(n, ASLCarContainer.DP_ILLUMINATION_INT_SETTINGS_6);
    }

    public void dsiCarLightUpdateIntLightIlluminationSet7(int n, int n2) {
        this.checkingUpdateIlluminationsSet(n, ASLCarContainer.DP_ILLUMINATION_INT_SETTINGS_7);
    }

    public void dsiCarLightUpdateIntLightIlluminationSet8(int n, int n2) {
        this.checkingUpdateIlluminationsSet(n, ASLCarContainer.DP_ILLUMINATION_INT_SETTINGS_8);
    }

    private void checkingUpdateIlluminationsSet(int n, int n2) {
        if (this.isTraceEnabled()) {
            this.trace().append("IlluminationSet: ").append(n2).append(" value: ").append(n).log();
        }
        if (n2 == ASLCarContainer.DP_ILLUMINATION_FOOTWELL_FRONT) {
            this.FOOTSPACE_LIGHT_DURATION_VALUE = n;
            this.informHMIAmbienceLight(this.FOOTSPACE_LIGHT_DURATION_VALUE, 1);
            this.settingUpIlluminationValues(10155, this.FOOTSPACE_LIGHT_DURATION_VALUE, ASLCarContainer.DP_ILLUMINATION_FOOTWELL_FRONT);
        }
        if (n2 == ASLCarContainer.DP_ILLUMINATION_COCKPIT) {
            this.COCKPIT_LIGHT_DURATION_VALUE = n;
            this.settingUpIlluminationValues(10153, this.COCKPIT_LIGHT_DURATION_VALUE, ASLCarContainer.DP_ILLUMINATION_COCKPIT);
        }
        if (n2 == ASLCarContainer.DP_ILLUMINATION_DOORS_FRONT_REAR) {
            this.DOORS_FRONT_REAR = n;
            this.informHMIAmbienceLight(this.DOORS_FRONT_REAR, 0);
            this.settingUpIlluminationValues(10154, this.DOORS_FRONT_REAR, ASLCarContainer.DP_ILLUMINATION_DOORS_FRONT_REAR);
        }
        if (n2 == ASLCarContainer.DP_ILLUMINATION_ALL_SYNC) {
            this.ALL_LIGHT_DURATION_VALUE = n;
            ASLCarLightHsmTarget.writeIntegerToDatapool(10157, this.ALL_LIGHT_DURATION_VALUE);
        }
        if (n2 == ASLCarContainer.DP_ILLUMINATION_ROOF_FRONT) {
            this.ROOF_LIGHT_DURATION_VALUE = n;
            this.settingUpIlluminationValues(10156, this.ROOF_LIGHT_DURATION_VALUE, ASLCarContainer.DP_ILLUMINATION_ROOF_FRONT);
        }
        if (n2 == ASLCarContainer.DP_ILLUMINATION_CENTER_CONSOLE) {
            this.CENTER_CONSOLE_LIGHT = n;
            this.settingUpIlluminationValues(10458, this.CENTER_CONSOLE_LIGHT, ASLCarContainer.DP_ILLUMINATION_CENTER_CONSOLE);
        }
        if (n2 == ASLCarContainer.DP_ILLUMINATION_FOOTWELL_FRONT_REAR) {
            this.FOOTWELL_FRONT_REAR = n;
            this.informHMIAmbienceLight(this.FOOTWELL_FRONT_REAR, 1);
            this.settingUpIlluminationValues(10155, this.FOOTWELL_FRONT_REAR, ASLCarContainer.DP_ILLUMINATION_FOOTWELL_FRONT_REAR);
        }
        if (n2 == ASLCarContainer.DP_ILLUMINATION_FOOTWELL_REAR) {
            this.FOOTWELL_REAR = n;
            this.settingBrightnessValue(this.FOOTWELL_REAR, ASLCarContainer.DP_ILLUMINATION_FOOTWELL_REAR);
        }
        if (n2 == ASLCarContainer.DP_ILLUMINATION_ROOF_REAR) {
            this.ROOF_REAR = n;
            this.settingBrightnessValue(this.ROOF_REAR, ASLCarContainer.DP_ILLUMINATION_ROOF_REAR);
        }
        if (n2 == ASLCarContainer.NOT_DOORS_FOOTWELLREAR) {
            this.DOORS_REAR = n;
            this.settingBrightnessValue(this.DOORS_REAR, ASLCarContainer.NOT_DOORS_FOOTWELLREAR);
        }
        if (n2 == ASLCarContainer.DP_ILLUMINATION_DOORS_FRONTWELL_FRONT) {
            this.STANDARD_LIGHT_DURATION_VALUE = n;
            this.settingBrightnessValue(this.STANDARD_LIGHT_DURATION_VALUE, ASLCarContainer.DP_ILLUMINATION_DOORS_FRONTWELL_FRONT);
        }
        if (n2 == ASLCarContainer.DP_ILLUMINATION_ROOF_FRONT_REAR) {
            this.ROOF_FRONT_REAR = n;
            this.settingUpIlluminationValues(10156, this.ROOF_FRONT_REAR, ASLCarContainer.DP_ILLUMINATION_ROOF_FRONT_REAR);
        }
        if (n2 == ASLCarContainer.DP_ILLUMINATION_FRONT) {
            this.FRONT = n;
            this.settingBrightnessValue(this.FRONT, ASLCarContainer.DP_ILLUMINATION_FRONT);
        }
        ListManager.getGenericASLList(10599).updateList(CarLightAmbienceColorAreaSettings_1CollectorFactory.createCarLightAmbienceColorAreaSettings_1Collector(ASLCarContainer.LIGHT_AREAR_COLLECTOR, this.currentLightState, false));
    }

    private void settingUpIlluminationValues(int n, int n2, int n3) {
        ASLCarLightHsmTarget.writeIntegerToDatapool(n, n2);
        this.settingBrightnessValue(n2, n3);
    }

    private void settingBrightnessValue(int n, int n2) {
        for (int i2 = 0; i2 < ASLCarContainer.LIGHT_AREAR_COLLECTOR.length; ++i2) {
            if (n2 != ASLCarContainer.LIGHT_AREAR_COLLECTOR[i2].getButtonId()) continue;
            ASLCarContainer.LIGHT_AREAR_COLLECTOR[i2].setBrightnessValue(n);
        }
    }

    private void settingAllBrightnessValues(int n) {
        for (int i2 = 0; i2 < ASLCarContainer.LIGHT_AREAR_COLLECTOR.length; ++i2) {
            ASLCarContainer.LIGHT_AREAR_COLLECTOR[i2].setBrightnessValue(n);
        }
    }

    public void dsiCarLightUpdateExtLightHeadLightSystem(boolean bl, int n) {
        this.HEADLIGHT_SYSTEM_ACTIVESTATE = bl;
        ASLCarLightHsmTarget.writeBooleanToDatapool(10160, this.HEADLIGHT_SYSTEM_ACTIVESTATE);
    }

    private void evaluateTouristLight() {
        if (this.isTraceEnabled()) {
            this.trace().append("DSI UPDATE: ExtLightTourist. Value: ").append(this.currentStateTouristLight).append(" isLeftHandTraffic: ").append(this.isLeftHandTraffic).log();
        }
        if (!this.isLeftHandTraffic) {
            if (this.currentStateTouristLight) {
                ASLCarLightHsmTarget.writeIntegerToDatapool(10145, 1);
            } else {
                ASLCarLightHsmTarget.writeIntegerToDatapool(10145, 0);
            }
        } else if (this.currentStateTouristLight) {
            ASLCarLightHsmTarget.writeIntegerToDatapool(10145, 0);
        } else {
            ASLCarLightHsmTarget.writeIntegerToDatapool(10145, 1);
        }
    }

    public void dsiCarLightUpdateIntLightColour(int n, int n2) {
        this.colorLight = n;
        this.checkingStateOfLightColor();
        CarPersistenceServiceImpl.getInstance().loadCar().setIntLightColor(n);
        if (this.isTraceEnabled()) {
            this.trace().append(new StringBuffer().append("update intlightcolor to HMI:").append(n).toString()).log();
        }
    }

    public void dsiCarLightUpdateIntLightState(int n, int n2) {
        this.currentLightState = n;
        if (n != 0 && this.sentSetIntLightState) {
            if (this.INIT_COLOR_VALUE < this.COLOR_SET_BY_HMI) {
                this.dsiCarLight.setIntLightColour(this.COLOR_SET_BY_HMI);
            }
            if (this.COLOR_SET_BY_HMI == this.colorLight) {
                this.checkingStateOfLightColor();
            }
        } else if (n == 0) {
            ASLCarLightHsmTarget.writeIntegerToDatapool(10158, 0);
        } else {
            this.checkingStateOfLightColor();
        }
        ASLCarLightHsmTarget.writeBooleanToDatapool(10614, n == 0);
        ListManager.getGenericASLList(10599).updateList(CarLightAmbienceColorAreaSettings_1CollectorFactory.createCarLightAmbienceColorAreaSettings_1Collector(ASLCarContainer.LIGHT_AREAR_COLLECTOR, this.currentLightState, false));
        this.sentSetIntLightState = false;
        switch (n) {
            case 1: {
                ASLCarLightHsmTarget.writeIntegerToDatapool(10869, 2);
                break;
            }
            case 2: {
                ASLCarLightHsmTarget.writeIntegerToDatapool(10869, 1);
                break;
            }
            default: {
                ASLCarLightHsmTarget.writeIntegerToDatapool(10869, 0);
            }
        }
    }

    public void dsiCarLightUpdateExtLightHeadlightRange(int n, int n2) {
        int n3 = 0;
        for (int i2 = 0; i2 < MIB_RECEIVES_VALUE.length; ++i2) {
            if (n < MIB_RECEIVES_VALUE[i2][n3] || n > MIB_RECEIVES_VALUE[i2][n3 + 1]) continue;
            ASLCarLightHsmTarget.writeIntegerToDatapool(10605, LEVELS[i2]);
            this.HEADLAMP_DURATION_VALUE = LEVELS[i2];
        }
    }

    private void checkingStateOfLightColor() {
        switch (this.colorLight) {
            case 0: {
                ASLCarLightHsmTarget.writeIntegerToDatapool(10158, 1);
                break;
            }
            case 1: {
                ASLCarLightHsmTarget.writeIntegerToDatapool(10158, 2);
                break;
            }
            case 2: {
                ASLCarLightHsmTarget.writeIntegerToDatapool(10158, 3);
                break;
            }
            case 3: {
                ASLCarLightHsmTarget.writeIntegerToDatapool(10158, 4);
                break;
            }
            case 4: {
                ASLCarLightHsmTarget.writeIntegerToDatapool(10158, 5);
                break;
            }
            case 5: {
                ASLCarLightHsmTarget.writeIntegerToDatapool(10158, 6);
                break;
            }
        }
    }

    private void updateData_ComfortBlinkingActive(boolean bl) {
        this.COMFORTBLINKING_ACTIVESTATE = bl;
        ASLCarLightHsmTarget.writeBooleanToDatapool(10144, this.COMFORTBLINKING_ACTIVESTATE);
    }

    private void updateData_AmbienceLightBrightness(int n) {
        this.DOORS_FRONT_REAR = n;
        if (this.isAmbienceLight) {
            this.FOOTSPACE_LIGHT_DURATION_VALUE = n;
        } else {
            this.FOOTWELL_FRONT_REAR = n;
        }
        this.ambienceLightBrightnessSettings[0] = new Integer(n);
        this.ambienceLightBrightnessSettings[1] = new Integer(n);
        ListManager.getGenericASLList(10146).updateList(this.ambienceLightBrightnessSettings);
    }

    private void updateData_ComingLeavingHome(int n) {
        this.COMINGHOME_DURATION_VALUE = n;
        this.LEAVINGHOME_DURATION_VALUE = n;
        this.comingLeavingHomeSettings[0] = new Integer(n);
        this.comingLeavingHomeSettings[1] = new Integer(n);
        ListManager.getGenericASLList(10143).updateList(this.comingLeavingHomeSettings);
    }

    private void initPrivateDPPropertyValues() {
        this.updateData_ComingLeavingHome(10);
        this.updateData_ComfortBlinkingActive(false);
        this.updateData_AmbienceLightBrightness(60);
        this.AFS_ACTIVESTATE = false;
        this.DAYDRIVING_LIGHT_ACTIVESTATE = false;
        this.MASK_HIGH_BEAM_LIGHT_ACTIVESTATE = false;
        this.INSTRUMENTLIGHT_DURATION_VALUE = 70;
        this.HEADLAMP_DURATION_VALUE = 3;
        this.COCKPIT_LIGHT_DURATION_VALUE = 60;
        this.AUTO_RAIN_LIGHT_ACTIVESTATE = false;
        this.HEADLIGHT_SYSTEM_ACTIVESTATE = false;
        this.ROOF_FRONT_REAR = 60;
        this.ROOF_LIGHT_DURATION_VALUE = 60;
    }

    public void dsiCarLightUpdateIntLightAmbientLightColor(IntLightRGBValues intLightRGBValues, int n) {
        int n2 = IntLightRGBColorTransformer.transform(intLightRGBValues);
        this.carEarly.setAmbienceLightColor(n2);
        this.selectedColor = n2;
        this.updateClientAmbianceLightColor();
        this.SRGBColor = new StringBuffer().append("#").append(this.colorComponent2Hex(intLightRGBValues.baseColorRed)).append(this.colorComponent2Hex(intLightRGBValues.baseColorGreen)).append(this.colorComponent2Hex(intLightRGBValues.baseColorBlue)).toString();
        this.getLightServiceListener().updateColorSRGB(this.SRGBColor);
    }

    private String colorComponent2Hex(int n) {
        String string = Integer.toHexString(Math.min(255, n)).toUpperCase();
        if (n < 16) {
            return new StringBuffer().append("0").append(string).toString();
        }
        return string;
    }

    public void dsiCarLightUpdateIntLightRGBColorListUpdateInfo(IntLightRGBColorListUpdateInfo intLightRGBColorListUpdateInfo, int n) {
        this.getColorListController().getColorListDsiListener().updateIntLightRGBColorListUpdateInfo(intLightRGBColorListUpdateInfo, n);
    }

    public void updateIntLightRGBColorListUpdateInfo(CarArrayListUpdateInfo carArrayListUpdateInfo, int[] nArray, int n) {
        IntLightRGBColorListUpdateInfo intLightRGBColorListUpdateInfo = new IntLightRGBColorListUpdateInfo(carArrayListUpdateInfo.getArrayContent(), carArrayListUpdateInfo.getRecordContent(), carArrayListUpdateInfo.getStartElement(), carArrayListUpdateInfo.getNumOfElements(), carArrayListUpdateInfo.getTransactionID());
        this.getColorListController().getColorListDsiListener().updateIntLightRGBColorListUpdateInfo(intLightRGBColorListUpdateInfo, n);
    }

    public void dsiCarLightUpdateIntLightRGBColorListTotalNumberOfElements(int n, int n2) {
        this.getColorListController().getColorListDsiListener().updateIntLightRGBColorListTotalNumberOfElements(n, n2);
    }

    public void dsiCarLightResponseIntLightRGBColorListRA0(IntLightRGBColorListUpdateInfo intLightRGBColorListUpdateInfo, IntLightRGBColorListRA0[] intLightRGBColorListRA0Array) {
        this.getColorListController().getColorListDsiListener().responseIntLightRGBColorListRA0(intLightRGBColorListUpdateInfo, intLightRGBColorListRA0Array);
    }

    public void responseIntLightRGBColorListRA0(CarArrayListUpdateInfo carArrayListUpdateInfo, IntLightRGBColorListRA0[] intLightRGBColorListRA0Array) {
        IntLightRGBColorListUpdateInfo intLightRGBColorListUpdateInfo = new IntLightRGBColorListUpdateInfo(carArrayListUpdateInfo.getArrayContent(), carArrayListUpdateInfo.getRecordContent(), carArrayListUpdateInfo.getStartElement(), carArrayListUpdateInfo.getNumOfElements(), carArrayListUpdateInfo.getTransactionID());
        this.getColorListController().getColorListDsiListener().responseIntLightRGBColorListRA0(intLightRGBColorListUpdateInfo, intLightRGBColorListRA0Array);
    }

    public void dsiCarLightResponseIntLightRGBColorListRAF(IntLightRGBColorListUpdateInfo intLightRGBColorListUpdateInfo, int[] nArray) {
        this.getColorListController().getColorListDsiListener().responseIntLightRGBColorListRAF(intLightRGBColorListUpdateInfo, nArray);
    }

    public void responseIntLightRGBColorListRAF(CarArrayListUpdateInfo carArrayListUpdateInfo, int[] nArray) {
        IntLightRGBColorListUpdateInfo intLightRGBColorListUpdateInfo = new IntLightRGBColorListUpdateInfo(carArrayListUpdateInfo.getArrayContent(), carArrayListUpdateInfo.getRecordContent(), carArrayListUpdateInfo.getStartElement(), carArrayListUpdateInfo.getNumOfElements(), carArrayListUpdateInfo.getTransactionID());
        this.getColorListController().getColorListDsiListener().responseIntLightRGBColorListRAF(intLightRGBColorListUpdateInfo, nArray);
    }

    @Override
    public ColorListController getColorListController() {
        if (this.colorListController == null) {
            this.colorListController = new ColorListController(this);
        }
        return this.colorListController;
    }

    public void requestGetArray(int n, ArrayHeader arrayHeader, int n2) {
        IntLightRGBColorListUpdateInfo intLightRGBColorListUpdateInfo = new IntLightRGBColorListUpdateInfo(n, arrayHeader.getRecordAddress(), arrayHeader.start, arrayHeader.elements, n2);
        this.dsiCarLight.requestIntLightRGBColorList(intLightRGBColorListUpdateInfo);
    }

    @Override
    public CarLogger getCarLogger() {
        return this;
    }

    @Override
    public DSICarLight getDsiCarLight() {
        return this.dsiCarLight;
    }

    private void setAmbianceLightColor(int n) {
        IntLightRGBValues intLightRGBValues = IntLightRGBColorTransformer.transform(n);
        this.dsiCarLight.setIntLightAmbientLightColor(intLightRGBValues);
        if (this.isTraceEnabled()) {
            this.trace().append(new StringBuffer().append("set ambience light color:").append(n).toString()).log();
        }
    }

    private void setAmbianceLightState(boolean bl) {
        int n = bl ? 1 : 0;
        this.dsiCarLight.setIntLightState(n);
        if (this.currentLightState != n) {
            this.sentSetIntLightState = true;
        }
    }

    private void setAmbianceLightState(int n) {
        switch (n) {
            case 1: {
                this.dsiCarLight.setIntLightState(2);
                break;
            }
            case 2: {
                this.dsiCarLight.setIntLightState(1);
                break;
            }
            default: {
                this.dsiCarLight.setIntLightState(0);
            }
        }
        if (this.currentLightState != n) {
            this.sentSetIntLightState = true;
        }
    }

    private void updateHMIColorToFramework(IntLightRGBValues intLightRGBValues) {
        try {
            this.getSkinInformationAsyncValueSetterService().setIntLightAmbientLightColor(intLightRGBValues.baseColorRed, intLightRGBValues.baseColorGreen, intLightRGBValues.baseColorBlue);
        }
        catch (Exception exception) {
            this.warn(new StringBuffer().append("fail to call SkinInformationAsyncValueSetterService with new color ").append(intLightRGBValues).append("  ").append(exception.getMessage()).toString());
        }
    }

    private SkinInformationAsyncValueSetterService getSkinInformationAsyncValueSetterService() {
        ServiceReference serviceReference = ServiceManager.bundleContext.getServiceReference((class$de$vw$mib$configuration$SkinInformationAsyncValueSetterService == null ? (class$de$vw$mib$configuration$SkinInformationAsyncValueSetterService = ASLCarLightHsmTarget.class$("de.vw.mib.configuration.SkinInformationAsyncValueSetterService")) : class$de$vw$mib$configuration$SkinInformationAsyncValueSetterService).getName());
        return (SkinInformationAsyncValueSetterService)ServiceManager.bundleContext.getService(serviceReference);
    }

    private int getColorIndex(int n, int[] nArray) {
        for (int i2 = 0; i2 < nArray.length; ++i2) {
            if (n != nArray[i2]) continue;
            return i2;
        }
        return -1;
    }

    public void updateClientAmbianceLightColor() {
        int n = 0;
        Car car = CarPersistenceServiceImpl.getInstance().loadCar();
        if (car.isAmbientLight()) {
            int n2 = this.getColorIndex(this.selectedColor, this.colorList);
            ASLCarLightHsmTarget.writeIntegerToDatapool(10613, n2);
            ASLCarLightHsmTarget.writeIntegerArrayToDatapool(10612, this.colorList);
            if (this.isTraceEnabled()) {
                this.trace().append(new StringBuffer().append("update ambience color index to HMI:").append(n2).append(" in list ").append(ArrayUtils.asString(this.colorList)).toString()).log();
            }
            n = this.selectedColor;
        }
        this.updateHMIColorToFramework(IntLightRGBColorTransformer.transform(n));
    }

    @Override
    public String getColorSRGB() {
        return this.SRGBColor;
    }

    private LightServiceListener getLightServiceListener() {
        return (LightServiceListener)ServiceFactory.getInstance().getServiceProviderRegistry().getServiceListener(class$de$vw$mib$asl$api$car$light$LightServiceListener == null ? (class$de$vw$mib$asl$api$car$light$LightServiceListener = ASLCarLightHsmTarget.class$("de.vw.mib.asl.api.car.light.LightServiceListener")) : class$de$vw$mib$asl$api$car$light$LightServiceListener);
    }

    private void registerAsServiceProvider() {
        ServiceFactory.getInstance().getServiceProviderRegistry().registerServiceProvider(class$de$vw$mib$asl$api$car$light$LightService == null ? (class$de$vw$mib$asl$api$car$light$LightService = ASLCarLightHsmTarget.class$("de.vw.mib.asl.api.car.light.LightService")) : class$de$vw$mib$asl$api$car$light$LightService, this);
    }

    public void dsiCarLightUpdateIntLightViewOptions(IntLightViewOptions intLightViewOptions, int n) {
        IntLightConfig intLightConfig = intLightViewOptions.getIntLightConfig();
        if (intLightViewOptions.getIntLightRGBColorList().getState() == 0 && intLightViewOptions.getIntLightAmbientLightColor().getState() == 0) {
            ASLCarLightHsmTarget.writeBooleanToDatapool(10819, true);
        } else {
            ASLCarLightHsmTarget.writeBooleanToDatapool(10819, false);
        }
        ASLCarLightHsmTarget.writeBooleanToDatapool(10881, intLightViewOptions.getIntLightConfig().ambienceStateAutoAvailable);
        if (0 == intLightViewOptions.getIntLightState().getState() && intLightViewOptions.getIntLightAmbientLightColor().getState() == 0) {
            this.selectedColor = 0;
            this.updateHMIColorToFramework(IntLightRGBColorTransformer.transform(this.selectedColor));
        }
        if (intLightConfig.getSetupIlluminationSet1() != 255 && intLightConfig.getSetupIlluminationSet1() == 10) {
            this.isAmbienceLight = true;
        }
        if (intLightConfig.getSetupIlluminationSet2() != 255 && intLightConfig.getSetupIlluminationSet2() == 10) {
            this.isAmbienceLight = true;
        }
        if (intLightConfig.getSetupIlluminationSet3() != 255 && intLightConfig.getSetupIlluminationSet3() == 10) {
            this.isAmbienceLight = true;
        }
        if (intLightConfig.getSetupIlluminationSet4() != 255 && intLightConfig.getSetupIlluminationSet4() == 10) {
            this.isAmbienceLight = true;
        }
        if (intLightConfig.getSetupIlluminationSet5() != 255 && intLightConfig.getSetupIlluminationSet5() == 10) {
            this.isAmbienceLight = true;
        }
        if (intLightConfig.getSetupIlluminationSet6() != 255 && intLightConfig.getSetupIlluminationSet6() == 10) {
            this.isAmbienceLight = true;
        }
        if (intLightConfig.getSetupIlluminationSet7() != 255 && intLightConfig.getSetupIlluminationSet7() == 10) {
            this.isAmbienceLight = true;
        }
        if (intLightConfig.getSetupIlluminationSet8() != 255 && intLightConfig.getSetupIlluminationSet8() == 10) {
            this.isAmbienceLight = true;
        }
    }

    public void updateRGBColorListArray(int[] nArray) {
        this.colorList = nArray;
        this.updateClientAmbianceLightColor();
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }

    static {
        LEVELS = new int[]{0, 1, 2, 3, 4, 5, 6};
        MIB_SENDS_VALUE = new int[]{100, 83, 67, 50, 33, 17, 0};
        MIB_RECEIVES_VALUE = new int[][]{{92, 100}, {75, 91}, {58, 74}, {42, 57}, {25, 41}, {8, 24}, {0, 7}};
    }
}

