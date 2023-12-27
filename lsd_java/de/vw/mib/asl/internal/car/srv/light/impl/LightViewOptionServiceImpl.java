/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.car.srv.light.impl;

import de.vw.mib.asl.api.car.ASLCarFactory;
import de.vw.mib.asl.api.car.vo.DeviceManagerListener;
import de.vw.mib.asl.api.car.vo.light.LightViewOptionListener;
import de.vw.mib.asl.api.car.vo.light.LightViewOptionService;
import de.vw.mib.asl.car.persistence.CarPersistenceServiceImpl;
import de.vw.mib.asl.framework.api.framework.ASLFrameworkFactory;
import de.vw.mib.asl.internal.car.ASLCarContainer;
import de.vw.mib.asl.internal.car.srv.CarEmptyTarget;
import de.vw.mib.asl.internal.car.srv.light.impl.ExtLightViewOptionsWrapper;
import de.vw.mib.asl.internal.car.srv.light.impl.IntLightViewOptionsCollector;
import de.vw.mib.collections.ObjectArrayList;
import java.util.Iterator;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.carlight.DSICarLight;
import org.dsi.ifc.carlight.DSICarLightListener;
import org.dsi.ifc.carlight.ExtLightViewOptions;
import org.dsi.ifc.carlight.IntLightConfig;
import org.dsi.ifc.carlight.IntLightMembersIlluminationSet;
import org.dsi.ifc.carlight.IntLightMembersMultiColor;
import org.dsi.ifc.carlight.IntLightViewOptions;
import org.dsi.ifc.global.CarViewOption;

public class LightViewOptionServiceImpl
extends CarEmptyTarget
implements LightViewOptionService,
DeviceManagerListener {
    public static final int INTLIGHTVIEWOPTIONS;
    public static final int EXTLIGHTVIEWOPTIONS;
    private static LightViewOptionServiceImpl instance;
    ObjectArrayList listeners = new ObjectArrayList();
    private DSICarLight dsiCarTarget;
    private DSICarLightListener viewOptionsListener;
    private IntLightViewOptionsCollector viewOptionsWrapper;
    private int deviceReason;
    private int extlightDeviceReason;
    public boolean isAmbienceLight;
    private final boolean[] colorSettings = new boolean[7];
    private static final int COLOR_SETTING_OFF;
    private static final int COLOR_SETTING_WARM_WHITE;
    private static final int COLOR_SETTING_COOL_WHITE;
    private static final int COLOR_SETTING_RED_WHITE;
    private static final int COLOR_SETTING_ORANGE;
    private static final int COLOR_SETTING_BLUE;
    private static final int COLOR_SETTING_CYAN;
    private ExtLightViewOptionsWrapper extlightVOWrapper;
    static /* synthetic */ Class class$org$dsi$ifc$carlight$DSICarLight;
    static /* synthetic */ Class class$org$dsi$ifc$carlight$DSICarLightListener;

    private LightViewOptionServiceImpl() {
        ASLCarFactory.getCarApi().getDeviceManager().addListener(this);
        this.initDSI();
    }

    public static LightViewOptionServiceImpl getInstance() {
        if (instance == null) {
            try {
                instance = new LightViewOptionServiceImpl();
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return instance;
    }

    private void initDSI() {
        this.dsiCarTarget = (DSICarLight)ASLCarContainer.getInstance().getDSIProxy().getService(this, class$org$dsi$ifc$carlight$DSICarLight == null ? (class$org$dsi$ifc$carlight$DSICarLight = LightViewOptionServiceImpl.class$("org.dsi.ifc.carlight.DSICarLight")) : class$org$dsi$ifc$carlight$DSICarLight);
        this.viewOptionsListener = (DSICarLightListener)ASLCarContainer.getInstance().getAdapterFactory().createDSIListenerMethodAdapter(this, class$org$dsi$ifc$carlight$DSICarLightListener == null ? (class$org$dsi$ifc$carlight$DSICarLightListener = LightViewOptionServiceImpl.class$("org.dsi.ifc.carlight.DSICarLightListener")) : class$org$dsi$ifc$carlight$DSICarLightListener);
    }

    public void registerViewOption(int n) {
        this.dsiCarTarget.setNotification(n, (DSIListener)this.viewOptionsListener);
    }

    @Override
    public void addListener(LightViewOptionListener lightViewOptionListener) {
        this.listeners.add(lightViewOptionListener);
    }

    @Override
    public void removeListener(LightViewOptionListener lightViewOptionListener) {
        this.listeners.removeValue(lightViewOptionListener);
    }

    public void dsiCarLightUpdateIntLightViewOptions(IntLightViewOptions intLightViewOptions, int n) {
        this.viewOptionsWrapper = new IntLightViewOptionsCollector(intLightViewOptions);
        IntLightConfig intLightConfig = intLightViewOptions.getIntLightConfig();
        this.isAmbienceLight = false;
        this.evaluateAmbienceLightSettings(intLightConfig);
        this.viewOptionsWrapper.setDisplayAmbienceSetupEntry(this.isAmbienceLight);
        CarPersistenceServiceImpl.getInstance().loadCar().setAmbientLight(this.isAmbienceLight);
        if (intLightConfig.getSetupIlluminationSet1() != 255) {
            this.illuminationSet(intLightConfig.getSetupIlluminationSet1(), intLightViewOptions.getIntLightIlluminationSet1(), ASLCarContainer.DP_ILLUMINATION_INT_SETTINGS_1, intLightViewOptions.getIntLightConfig().getMembersIlluminationSet1(), intLightViewOptions.getIntLightConfig().getMembersMultiColor());
        }
        if (intLightConfig.getSetupIlluminationSet2() != 255) {
            this.illuminationSet(intLightConfig.getSetupIlluminationSet2(), intLightViewOptions.getIntLightIlluminationSet2(), ASLCarContainer.DP_ILLUMINATION_INT_SETTINGS_2, intLightViewOptions.getIntLightConfig().getMembersIlluminationSet2(), intLightViewOptions.getIntLightConfig().getMembersMultiColor());
        }
        if (intLightConfig.getSetupIlluminationSet3() != 255) {
            this.illuminationSet(intLightConfig.getSetupIlluminationSet3(), intLightViewOptions.getIntLightIlluminationSet3(), ASLCarContainer.DP_ILLUMINATION_INT_SETTINGS_3, intLightViewOptions.getIntLightConfig().getMembersIlluminationSet3(), intLightViewOptions.getIntLightConfig().getMembersMultiColor());
        }
        if (intLightConfig.getSetupIlluminationSet4() != 255) {
            this.illuminationSet(intLightConfig.getSetupIlluminationSet4(), intLightViewOptions.getIntLightIlluminationSet4(), ASLCarContainer.DP_ILLUMINATION_INT_SETTINGS_4, intLightViewOptions.getIntLightConfig().getMembersIlluminationSet4(), intLightViewOptions.getIntLightConfig().getMembersMultiColor());
        }
        if (intLightConfig.getSetupIlluminationSet5() != 255) {
            this.illuminationSet(intLightConfig.getSetupIlluminationSet5(), intLightViewOptions.getIntLightIlluminationSet5(), ASLCarContainer.DP_ILLUMINATION_INT_SETTINGS_5, intLightViewOptions.getIntLightConfig().getMembersIlluminationSet5(), intLightViewOptions.getIntLightConfig().getMembersMultiColor());
        }
        if (intLightConfig.getSetupIlluminationSet6() != 255) {
            this.illuminationSet(intLightConfig.getSetupIlluminationSet6(), intLightViewOptions.getIntLightIlluminationSet6(), ASLCarContainer.DP_ILLUMINATION_INT_SETTINGS_6, intLightViewOptions.getIntLightConfig().getMembersIlluminationSet6(), intLightViewOptions.getIntLightConfig().getMembersMultiColor());
        }
        if (intLightConfig.getSetupIlluminationSet7() != 255) {
            this.illuminationSet(intLightConfig.getSetupIlluminationSet7(), intLightViewOptions.getIntLightIlluminationSet7(), ASLCarContainer.DP_ILLUMINATION_INT_SETTINGS_7, intLightViewOptions.getIntLightConfig().getMembersIlluminationSet7(), intLightViewOptions.getIntLightConfig().getMembersMultiColor());
        }
        if (intLightConfig.getSetupIlluminationSet8() != 255) {
            this.illuminationSet(intLightConfig.getSetupIlluminationSet8(), intLightViewOptions.getIntLightIlluminationSet8(), ASLCarContainer.DP_ILLUMINATION_INT_SETTINGS_8, intLightViewOptions.getIntLightConfig().getMembersIlluminationSet8(), intLightViewOptions.getIntLightConfig().getMembersMultiColor());
        }
        if (this.isAmbienceLight) {
            this.colorSettings[0] = intLightViewOptions.getIntLightState().getState() == 2;
            this.colorSettings[5] = intLightViewOptions.getIntLightConfig().getSetupColors().isBlue();
            this.colorSettings[2] = intLightViewOptions.getIntLightConfig().getSetupColors().isColdWhite();
            this.colorSettings[6] = intLightViewOptions.getIntLightConfig().getSetupColors().isCyan();
            this.colorSettings[4] = intLightViewOptions.getIntLightConfig().getSetupColors().isOrange();
            this.colorSettings[3] = intLightViewOptions.getIntLightConfig().getSetupColors().isRedWhite();
            this.colorSettings[1] = intLightViewOptions.getIntLightConfig().getSetupColors().isWarmWhite();
            int n2 = 0;
            for (int i2 = 0; i2 < this.colorSettings.length; ++i2) {
                if (!this.colorSettings[i2]) continue;
                ++n2;
            }
            if (n2 >= 3) {
                this.viewOptionsWrapper.setIntLightColour(intLightViewOptions.getIntLightColour());
            }
            this.evaluateViewOptionsRGBColorList(intLightViewOptions);
        }
        if (this.deviceReason == 0) {
            this.notifyListeners(0);
        }
    }

    void illuminationSet(int n, CarViewOption carViewOption, int n2, IntLightMembersIlluminationSet intLightMembersIlluminationSet, IntLightMembersMultiColor intLightMembersMultiColor) {
        switch (n) {
            case 14: {
                this.viewOptionsWrapper.setIntLightRoofFrontRear(carViewOption);
                break;
            }
            case 1: {
                this.viewOptionsWrapper.setIntLightRoofFront(carViewOption);
                break;
            }
            case 2: {
                this.viewOptionsWrapper.setIntLightRoofRear(carViewOption);
                break;
            }
            case 3: {
                this.viewOptionsWrapper.setIntLightFootwellFront(carViewOption);
                break;
            }
            case 4: {
                this.viewOptionsWrapper.setIntLightFootwellRear(carViewOption);
                break;
            }
            case 5: {
                this.viewOptionsWrapper.setIntLightFootwellFrontRear(carViewOption);
                break;
            }
            case 6: {
                this.viewOptionsWrapper.setIntLightCockpit(carViewOption);
                break;
            }
            case 7: {
                this.viewOptionsWrapper.setIntLightDoorsFrontRear(carViewOption);
                break;
            }
            case 8: {
                this.viewOptionsWrapper.setIntLightDoorsFront(carViewOption);
                break;
            }
            case 9: {
                this.viewOptionsWrapper.setIntLightNotDoorsFootwellRear(carViewOption);
                break;
            }
            case 10: {
                this.viewOptionsWrapper.setIntLightAll(carViewOption);
                break;
            }
            case 11: {
                this.viewOptionsWrapper.setIntLightFootwellFrontRear(carViewOption);
                break;
            }
            case 255: {
                break;
            }
            case 15: {
                this.viewOptionsWrapper.setIntLightCenterConsole(carViewOption);
                break;
            }
        }
    }

    private void evaluateViewOptionsRGBColorList(IntLightViewOptions intLightViewOptions) {
        CarViewOption carViewOption = intLightViewOptions.getIntLightRGBColorList();
        CarViewOption carViewOption2 = intLightViewOptions.getIntLightAmbientLightColor();
        this.viewOptionsWrapper.setIntLightRGBColorList(carViewOption);
        if (carViewOption.getState() == 2 && (carViewOption2 == null || carViewOption2.getState() != 2)) {
            this.viewOptionsWrapper.setIntLightRGBColorList(carViewOption2);
        }
    }

    private void evaluateAmbienceLightSettings(IntLightConfig intLightConfig) {
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

    private void notifyListeners(int n) {
        Iterator iterator = this.listeners.iterator();
        while (iterator.hasNext()) {
            LightViewOptionListener lightViewOptionListener = (LightViewOptionListener)iterator.next();
            if (this.viewOptionsWrapper == null) {
                lightViewOptionListener.updateIntLightDevice(n);
                if (this.deviceReason != 14) continue;
                this.deviceReason = 0;
                continue;
            }
            if (this.deviceReason == 14) {
                this.deviceReason = 0;
                return;
            }
            lightViewOptionListener.updateIntLightViewOptions(this.viewOptionsWrapper, n);
        }
    }

    @Override
    public void onDeviceAvailableReasonChange(int n, int n2) {
        switch (n) {
            case 195: {
                this.deviceReason = n2;
                if (n2 != 0) {
                    this.notifyListeners(n2);
                    break;
                }
                this.notifyListeners(0);
                break;
            }
            case 220: {
                this.extlightDeviceReason = n2;
                if (n2 != 0) {
                    this.notifyextlightListeners(n2);
                    break;
                }
                this.notifyextlightListeners(0);
                break;
            }
        }
    }

    public void dsiCarLightUpdateExtLightViewOptions(ExtLightViewOptions extLightViewOptions, int n) {
        this.extlightVOWrapper = new ExtLightViewOptionsWrapper(extLightViewOptions);
        if (!this.extlightVOWrapper.getExtLightVO().getExtLightConfig().isRainDependency()) {
            this.extlightVOWrapper.getExtLightVO().automaticLight = new CarViewOption(0, 0);
        }
        if (this.extlightDeviceReason == 0) {
            this.notifyextlightListeners(0);
        }
    }

    private void notifyextlightListeners(int n) {
        Iterator iterator = this.listeners.iterator();
        while (iterator.hasNext()) {
            LightViewOptionListener lightViewOptionListener = (LightViewOptionListener)iterator.next();
            if (this.extlightVOWrapper == null) {
                lightViewOptionListener.updateExtLightDevice(n);
                if (this.extlightDeviceReason != 14) continue;
                this.extlightDeviceReason = 0;
                continue;
            }
            if (this.extlightDeviceReason == 14) {
                this.extlightDeviceReason = 0;
                return;
            }
            lightViewOptionListener.updateExtLightViewOptions(this.extlightVOWrapper, n);
        }
    }

    public void notifyAmbienceLight() {
        ASLFrameworkFactory.getASLFrameworkAPI().getASLLogger().info(1, "LightVO.notifyAmbienceLight is coded");
        Iterator iterator = this.listeners.iterator();
        while (iterator.hasNext()) {
            LightViewOptionListener lightViewOptionListener = (LightViewOptionListener)iterator.next();
            lightViewOptionListener.updateAmbienceLightIsCoded();
        }
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

