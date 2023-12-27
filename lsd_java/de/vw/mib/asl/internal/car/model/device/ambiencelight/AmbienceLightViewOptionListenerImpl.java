/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.car.model.device.ambiencelight;

import de.vw.mib.asl.api.car.vo.light.IntLightViewOptionsData;
import de.vw.mib.asl.api.car.vo.light.LightViewOptionAdapter;
import de.vw.mib.asl.framework.api.framework.ASLFrameworkFactory;
import de.vw.mib.asl.internal.car.model.device.ambiencelight.AmbienceLightDevice;

public class AmbienceLightViewOptionListenerImpl
extends LightViewOptionAdapter {
    private AmbienceLightDevice ambienceLightDevice;
    private boolean isCoded;

    public AmbienceLightViewOptionListenerImpl(AmbienceLightDevice ambienceLightDevice) {
        this.ambienceLightDevice = ambienceLightDevice;
    }

    @Override
    public void updateIntLightViewOptions(IntLightViewOptionsData intLightViewOptionsData, int n) {
        this.ambienceLightDevice.addMapping(0, intLightViewOptionsData.getIntLightDoorsFront(), n);
        this.ambienceLightDevice.addMapping(1, intLightViewOptionsData.getIntLightFootwellFront(), n);
        this.ambienceLightDevice.addMapping(2, intLightViewOptionsData.getIntLightCockpit(), n);
        this.ambienceLightDevice.addMapping(3, intLightViewOptionsData.getIntLightCenterConsole(), n);
        this.ambienceLightDevice.addMapping(4, intLightViewOptionsData.getIntLightRoofFront(), n);
        this.ambienceLightDevice.addMapping(5, intLightViewOptionsData.getIntLightAll(), n);
        this.ambienceLightDevice.addMapping(6, intLightViewOptionsData.getIntLightColour(), n);
        this.ambienceLightDevice.addMapping(7, intLightViewOptionsData.getIntLightFootwellFrontRear(), n);
        this.ambienceLightDevice.addMapping(8, intLightViewOptionsData.getIntLightFootwellRear(), n);
        this.ambienceLightDevice.addMapping(9, intLightViewOptionsData.getIntLightDoorsFrontRear(), n);
        this.ambienceLightDevice.addMapping(10, intLightViewOptionsData.getIntLightFootwellFrontRear(), n);
        this.ambienceLightDevice.addMapping(11, intLightViewOptionsData.getIntLightRoofFrontRear(), n);
        this.ambienceLightDevice.addMapping(12, intLightViewOptionsData.getIntLightRoofRear(), n);
        this.ambienceLightDevice.addMapping(13, intLightViewOptionsData.getIntLightFront(), n);
        this.ambienceLightDevice.addMapping(14, intLightViewOptionsData.getIntLightRGBColorList(), n);
        this.ambienceLightDevice.addMapping(15, intLightViewOptionsData.getIntLightState(), n);
        this.ambienceLightDevice.updateModel();
    }

    @Override
    public void updateAmbienceLightIsCoded() {
        this.isCoded = true;
        ASLFrameworkFactory.getASLFrameworkAPI().getASLLogger().info(1, "AmbienceVO.updateAmbienceLightIsCoded");
        this.ambienceLightDevice.carSetupMenu.updateMenu(6, 2);
    }

    @Override
    public void updateIntLightDevice(int n) {
        if (this.isCoded) {
            this.ambienceLightDevice.addMapping(0, n);
            this.ambienceLightDevice.addMapping(1, n);
            this.ambienceLightDevice.addMapping(2, n);
            this.ambienceLightDevice.addMapping(3, n);
            this.ambienceLightDevice.addMapping(4, n);
            this.ambienceLightDevice.addMapping(5, n);
            this.ambienceLightDevice.addMapping(6, n);
            this.ambienceLightDevice.addMapping(7, n);
            this.ambienceLightDevice.addMapping(8, n);
            this.ambienceLightDevice.addMapping(9, n);
            this.ambienceLightDevice.addMapping(10, n);
            this.ambienceLightDevice.addMapping(11, n);
            this.ambienceLightDevice.addMapping(12, n);
            this.ambienceLightDevice.addMapping(13, n);
            this.ambienceLightDevice.addMapping(14, n);
            this.ambienceLightDevice.updateModel();
        }
    }
}

