/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.cardrivingcharacteristics.impl;

import de.esolutions.fw.comm.dsi.cardrivingcharacteristics.impl.SuspensionControlConfigurationSerializer;
import de.esolutions.fw.comm.dsi.global.impl.CarViewOptionSerializer;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.cardrivingcharacteristics.SuspensionControlConfiguration;
import org.dsi.ifc.cardrivingcharacteristics.SuspensionControlViewOptions;
import org.dsi.ifc.global.CarViewOption;

public class SuspensionControlViewOptionsSerializer {
    public static void putOptionalSuspensionControlViewOptions(ISerializer iSerializer, SuspensionControlViewOptions suspensionControlViewOptions) {
        boolean bl = suspensionControlViewOptions == null;
        iSerializer.putBool(bl);
        if (!bl) {
            CarViewOption carViewOption = suspensionControlViewOptions.getLiftMode();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption);
            CarViewOption carViewOption2 = suspensionControlViewOptions.getCarJackMode();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption2);
            CarViewOption carViewOption3 = suspensionControlViewOptions.getTrailerMode();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption3);
            CarViewOption carViewOption4 = suspensionControlViewOptions.getLoadingMode();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption4);
            CarViewOption carViewOption5 = suspensionControlViewOptions.getActiveProfile();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption5);
            CarViewOption carViewOption6 = suspensionControlViewOptions.getHeightInfo();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption6);
            CarViewOption carViewOption7 = suspensionControlViewOptions.getOperationMessages();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption7);
            SuspensionControlConfiguration suspensionControlConfiguration = suspensionControlViewOptions.getConfiguration();
            SuspensionControlConfigurationSerializer.putOptionalSuspensionControlConfiguration(iSerializer, suspensionControlConfiguration);
            CarViewOption carViewOption8 = suspensionControlViewOptions.getSnowChainMode();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption8);
            CarViewOption carViewOption9 = suspensionControlViewOptions.getAirsuspActiveMode();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption9);
            CarViewOption carViewOption10 = suspensionControlViewOptions.getAirsuspMode0();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption10);
            CarViewOption carViewOption11 = suspensionControlViewOptions.getAirsuspMode1();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption11);
            CarViewOption carViewOption12 = suspensionControlViewOptions.getAirsuspMode2();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption12);
            CarViewOption carViewOption13 = suspensionControlViewOptions.getAirsuspMode3();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption13);
            CarViewOption carViewOption14 = suspensionControlViewOptions.getAirsuspMode4();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption14);
            CarViewOption carViewOption15 = suspensionControlViewOptions.getAirsuspMode5();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption15);
            CarViewOption carViewOption16 = suspensionControlViewOptions.getAirsuspMode6();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption16);
            CarViewOption carViewOption17 = suspensionControlViewOptions.getAirsuspMode7();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption17);
            CarViewOption carViewOption18 = suspensionControlViewOptions.getAirsuspMode8();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption18);
            CarViewOption carViewOption19 = suspensionControlViewOptions.getAirsuspMode9();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption19);
            CarViewOption carViewOption20 = suspensionControlViewOptions.getAirsuspMode10();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption20);
            CarViewOption carViewOption21 = suspensionControlViewOptions.getAirsuspMode11();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption21);
            CarViewOption carViewOption22 = suspensionControlViewOptions.getAirsuspMode12();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption22);
            CarViewOption carViewOption23 = suspensionControlViewOptions.getAirsuspMode13();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption23);
            CarViewOption carViewOption24 = suspensionControlViewOptions.getAirsuspMode14();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption24);
            CarViewOption carViewOption25 = suspensionControlViewOptions.getAirsuspMode15();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption25);
            CarViewOption carViewOption26 = suspensionControlViewOptions.getEABCEasyEntry();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption26);
            CarViewOption carViewOption27 = suspensionControlViewOptions.getEABCPitchControl();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption27);
            CarViewOption carViewOption28 = suspensionControlViewOptions.getEABCSpecialPosition();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption28);
            CarViewOption carViewOption29 = suspensionControlViewOptions.getEABCPreView();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption29);
            CarViewOption carViewOption30 = suspensionControlViewOptions.getEABCPreViewState();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption30);
            CarViewOption carViewOption31 = suspensionControlViewOptions.getActuatorInfo();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption31);
        }
    }

    public static void putOptionalSuspensionControlViewOptionsVarArray(ISerializer iSerializer, SuspensionControlViewOptions[] suspensionControlViewOptionsArray) {
        boolean bl = suspensionControlViewOptionsArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(suspensionControlViewOptionsArray.length);
            for (int i2 = 0; i2 < suspensionControlViewOptionsArray.length; ++i2) {
                SuspensionControlViewOptionsSerializer.putOptionalSuspensionControlViewOptions(iSerializer, suspensionControlViewOptionsArray[i2]);
            }
        }
    }

    public static SuspensionControlViewOptions getOptionalSuspensionControlViewOptions(IDeserializer iDeserializer) {
        SuspensionControlViewOptions suspensionControlViewOptions = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            CarViewOption carViewOption;
            CarViewOption carViewOption2;
            CarViewOption carViewOption3;
            CarViewOption carViewOption4;
            CarViewOption carViewOption5;
            CarViewOption carViewOption6;
            CarViewOption carViewOption7;
            CarViewOption carViewOption8;
            CarViewOption carViewOption9;
            CarViewOption carViewOption10;
            CarViewOption carViewOption11;
            CarViewOption carViewOption12;
            CarViewOption carViewOption13;
            CarViewOption carViewOption14;
            CarViewOption carViewOption15;
            CarViewOption carViewOption16;
            CarViewOption carViewOption17;
            CarViewOption carViewOption18;
            CarViewOption carViewOption19;
            CarViewOption carViewOption20;
            CarViewOption carViewOption21;
            CarViewOption carViewOption22;
            CarViewOption carViewOption23;
            CarViewOption carViewOption24;
            SuspensionControlConfiguration suspensionControlConfiguration;
            CarViewOption carViewOption25;
            CarViewOption carViewOption26;
            CarViewOption carViewOption27;
            CarViewOption carViewOption28;
            CarViewOption carViewOption29;
            CarViewOption carViewOption30;
            CarViewOption carViewOption31;
            suspensionControlViewOptions = new SuspensionControlViewOptions();
            suspensionControlViewOptions.liftMode = carViewOption31 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            suspensionControlViewOptions.carJackMode = carViewOption30 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            suspensionControlViewOptions.trailerMode = carViewOption29 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            suspensionControlViewOptions.loadingMode = carViewOption28 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            suspensionControlViewOptions.activeProfile = carViewOption27 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            suspensionControlViewOptions.heightInfo = carViewOption26 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            suspensionControlViewOptions.operationMessages = carViewOption25 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            suspensionControlViewOptions.configuration = suspensionControlConfiguration = SuspensionControlConfigurationSerializer.getOptionalSuspensionControlConfiguration(iDeserializer);
            suspensionControlViewOptions.snowChainMode = carViewOption24 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            suspensionControlViewOptions.airsuspActiveMode = carViewOption23 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            suspensionControlViewOptions.airsuspMode0 = carViewOption22 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            suspensionControlViewOptions.airsuspMode1 = carViewOption21 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            suspensionControlViewOptions.airsuspMode2 = carViewOption20 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            suspensionControlViewOptions.airsuspMode3 = carViewOption19 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            suspensionControlViewOptions.airsuspMode4 = carViewOption18 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            suspensionControlViewOptions.airsuspMode5 = carViewOption17 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            suspensionControlViewOptions.airsuspMode6 = carViewOption16 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            suspensionControlViewOptions.airsuspMode7 = carViewOption15 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            suspensionControlViewOptions.airsuspMode8 = carViewOption14 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            suspensionControlViewOptions.airsuspMode9 = carViewOption13 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            suspensionControlViewOptions.airsuspMode10 = carViewOption12 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            suspensionControlViewOptions.airsuspMode11 = carViewOption11 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            suspensionControlViewOptions.airsuspMode12 = carViewOption10 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            suspensionControlViewOptions.airsuspMode13 = carViewOption9 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            suspensionControlViewOptions.airsuspMode14 = carViewOption8 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            suspensionControlViewOptions.airsuspMode15 = carViewOption7 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            suspensionControlViewOptions.eABCEasyEntry = carViewOption6 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            suspensionControlViewOptions.eABCPitchControl = carViewOption5 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            suspensionControlViewOptions.eABCSpecialPosition = carViewOption4 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            suspensionControlViewOptions.eABCPreView = carViewOption3 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            suspensionControlViewOptions.eABCPreViewState = carViewOption2 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            suspensionControlViewOptions.actuatorInfo = carViewOption = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
        }
        return suspensionControlViewOptions;
    }

    public static SuspensionControlViewOptions[] getOptionalSuspensionControlViewOptionsVarArray(IDeserializer iDeserializer) {
        SuspensionControlViewOptions[] suspensionControlViewOptionsArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            suspensionControlViewOptionsArray = new SuspensionControlViewOptions[n];
            for (int i2 = 0; i2 < n; ++i2) {
                suspensionControlViewOptionsArray[i2] = SuspensionControlViewOptionsSerializer.getOptionalSuspensionControlViewOptions(iDeserializer);
            }
        }
        return suspensionControlViewOptionsArray;
    }
}

