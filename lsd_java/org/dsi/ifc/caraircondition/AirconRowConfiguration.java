/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.caraircondition;

import org.dsi.ifc.caraircondition.AirconAirDistributionConfig;
import org.dsi.ifc.caraircondition.AirconAirFlow;
import org.dsi.ifc.caraircondition.AirconBCMeasuresConfiguration;
import org.dsi.ifc.global.CarArrayListTransmittableElements;

public class AirconRowConfiguration {
    public boolean externalDisplay;
    public boolean setupButton;
    public boolean autoMode;
    public AirconAirFlow airFlowConfigZoneLeft;
    public AirconAirFlow airFlowConfigZoneRight;
    public AirconAirDistributionConfig airDistributionConfigZoneLeft;
    public AirconAirDistributionConfig airDistributionConfigZoneRight;
    public boolean airconTempStepViaHMI;
    public AirconBCMeasuresConfiguration bcMeasureConfig;
    public int airVolumeSteps;
    public int airDistributionSteps;
    public boolean airDistributionCombined;
    public CarArrayListTransmittableElements nozzleListTransmittableElements;
    public int[] nozzleListRAConfig;

    public AirconRowConfiguration() {
        this.externalDisplay = false;
        this.setupButton = false;
        this.autoMode = false;
        this.airFlowConfigZoneLeft = null;
        this.airFlowConfigZoneRight = null;
        this.airDistributionConfigZoneLeft = null;
        this.airDistributionConfigZoneRight = null;
        this.airconTempStepViaHMI = false;
        this.bcMeasureConfig = null;
        this.airVolumeSteps = 0;
        this.airDistributionSteps = 0;
        this.airDistributionCombined = false;
        this.nozzleListTransmittableElements = null;
        this.nozzleListRAConfig = null;
    }

    public AirconRowConfiguration(boolean bl, boolean bl2, boolean bl3, AirconAirFlow airconAirFlow, AirconAirFlow airconAirFlow2, AirconAirDistributionConfig airconAirDistributionConfig, AirconAirDistributionConfig airconAirDistributionConfig2, boolean bl4, AirconBCMeasuresConfiguration airconBCMeasuresConfiguration, int n, int n2, boolean bl5, CarArrayListTransmittableElements carArrayListTransmittableElements, int[] nArray) {
        this.externalDisplay = bl;
        this.setupButton = bl2;
        this.autoMode = bl3;
        this.airFlowConfigZoneLeft = airconAirFlow;
        this.airFlowConfigZoneRight = airconAirFlow2;
        this.airDistributionConfigZoneLeft = airconAirDistributionConfig;
        this.airDistributionConfigZoneRight = airconAirDistributionConfig2;
        this.airconTempStepViaHMI = bl4;
        this.bcMeasureConfig = airconBCMeasuresConfiguration;
        this.airVolumeSteps = n;
        this.airDistributionSteps = n2;
        this.airDistributionCombined = bl5;
        this.nozzleListTransmittableElements = carArrayListTransmittableElements;
        this.nozzleListRAConfig = nArray;
    }

    public boolean isExternalDisplay() {
        return this.externalDisplay;
    }

    public boolean isSetupButton() {
        return this.setupButton;
    }

    public boolean isAutoMode() {
        return this.autoMode;
    }

    public AirconAirFlow getAirFlowConfigZoneLeft() {
        return this.airFlowConfigZoneLeft;
    }

    public AirconAirFlow getAirFlowConfigZoneRight() {
        return this.airFlowConfigZoneRight;
    }

    public AirconAirDistributionConfig getAirDistributionConfigZoneLeft() {
        return this.airDistributionConfigZoneLeft;
    }

    public AirconAirDistributionConfig getAirDistributionConfigZoneRight() {
        return this.airDistributionConfigZoneRight;
    }

    public AirconBCMeasuresConfiguration getBcMeasureConfig() {
        return this.bcMeasureConfig;
    }

    public boolean isAirconTempStepViaHMI() {
        return this.airconTempStepViaHMI;
    }

    public int getAirVolumeSteps() {
        return this.airVolumeSteps;
    }

    public int getAirDistributionSteps() {
        return this.airDistributionSteps;
    }

    public boolean isAirDistributionCombined() {
        return this.airDistributionCombined;
    }

    public CarArrayListTransmittableElements getNozzleListTransmittableElements() {
        return this.nozzleListTransmittableElements;
    }

    public int[] getNozzleListRAConfig() {
        return this.nozzleListRAConfig;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(6850);
        stringBuffer.append("AirconRowConfiguration");
        stringBuffer.append('(');
        stringBuffer.append("externalDisplay");
        stringBuffer.append('=');
        stringBuffer.append(this.externalDisplay);
        stringBuffer.append(',');
        stringBuffer.append("setupButton");
        stringBuffer.append('=');
        stringBuffer.append(this.setupButton);
        stringBuffer.append(',');
        stringBuffer.append("autoMode");
        stringBuffer.append('=');
        stringBuffer.append(this.autoMode);
        stringBuffer.append(',');
        stringBuffer.append("airFlowConfigZoneLeft");
        stringBuffer.append('=');
        stringBuffer.append(this.airFlowConfigZoneLeft);
        stringBuffer.append(',');
        stringBuffer.append("airFlowConfigZoneRight");
        stringBuffer.append('=');
        stringBuffer.append(this.airFlowConfigZoneRight);
        stringBuffer.append(',');
        stringBuffer.append("airDistributionConfigZoneLeft");
        stringBuffer.append('=');
        stringBuffer.append(this.airDistributionConfigZoneLeft);
        stringBuffer.append(',');
        stringBuffer.append("airDistributionConfigZoneRight");
        stringBuffer.append('=');
        stringBuffer.append(this.airDistributionConfigZoneRight);
        stringBuffer.append(',');
        stringBuffer.append("airconTempStepViaHMI");
        stringBuffer.append('=');
        stringBuffer.append(this.airconTempStepViaHMI);
        stringBuffer.append(',');
        stringBuffer.append("bcMeasureConfig");
        stringBuffer.append('=');
        stringBuffer.append(this.bcMeasureConfig);
        stringBuffer.append(',');
        stringBuffer.append("airVolumeSteps");
        stringBuffer.append('=');
        stringBuffer.append(this.airVolumeSteps);
        stringBuffer.append(',');
        stringBuffer.append("airDistributionSteps");
        stringBuffer.append('=');
        stringBuffer.append(this.airDistributionSteps);
        stringBuffer.append(',');
        stringBuffer.append("airDistributionCombined");
        stringBuffer.append('=');
        stringBuffer.append(this.airDistributionCombined);
        stringBuffer.append(',');
        stringBuffer.append("nozzleListTransmittableElements");
        stringBuffer.append('=');
        stringBuffer.append(this.nozzleListTransmittableElements);
        stringBuffer.append(',');
        stringBuffer.append("nozzleListRAConfig");
        stringBuffer.append('[');
        if (this.nozzleListRAConfig != null) {
            stringBuffer.append(this.nozzleListRAConfig.length);
        }
        stringBuffer.append(']');
        stringBuffer.append('=');
        stringBuffer.append('{');
        if (this.nozzleListRAConfig != null) {
            int n = this.nozzleListRAConfig.length;
            int n2 = n - 1;
            for (int i2 = 0; i2 < n; ++i2) {
                stringBuffer.append(this.nozzleListRAConfig[i2]);
                if (i2 >= n2) continue;
                stringBuffer.append(',');
            }
        } else {
            stringBuffer.append(this.nozzleListRAConfig);
        }
        stringBuffer.append('}');
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

