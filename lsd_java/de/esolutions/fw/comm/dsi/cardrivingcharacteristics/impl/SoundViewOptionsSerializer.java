/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.cardrivingcharacteristics.impl;

import de.esolutions.fw.comm.dsi.cardrivingcharacteristics.impl.SoundConfigurationSerializer;
import de.esolutions.fw.comm.dsi.global.impl.CarViewOptionSerializer;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.cardrivingcharacteristics.SoundConfiguration;
import org.dsi.ifc.cardrivingcharacteristics.SoundViewOptions;
import org.dsi.ifc.global.CarViewOption;

public class SoundViewOptionsSerializer {
    public static void putOptionalSoundViewOptions(ISerializer iSerializer, SoundViewOptions soundViewOptions) {
        boolean bl = soundViewOptions == null;
        iSerializer.putBool(bl);
        if (!bl) {
            SoundConfiguration soundConfiguration = soundViewOptions.getConfiguration();
            SoundConfigurationSerializer.putOptionalSoundConfiguration(iSerializer, soundConfiguration);
            CarViewOption carViewOption = soundViewOptions.getSetFactoryDefault();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption);
            CarViewOption carViewOption2 = soundViewOptions.getSystemOnOff();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption2);
            CarViewOption carViewOption3 = soundViewOptions.getSoundOnOff();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption3);
            CarViewOption carViewOption4 = soundViewOptions.getStyle();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption4);
        }
    }

    public static void putOptionalSoundViewOptionsVarArray(ISerializer iSerializer, SoundViewOptions[] soundViewOptionsArray) {
        boolean bl = soundViewOptionsArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(soundViewOptionsArray.length);
            for (int i2 = 0; i2 < soundViewOptionsArray.length; ++i2) {
                SoundViewOptionsSerializer.putOptionalSoundViewOptions(iSerializer, soundViewOptionsArray[i2]);
            }
        }
    }

    public static SoundViewOptions getOptionalSoundViewOptions(IDeserializer iDeserializer) {
        SoundViewOptions soundViewOptions = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            CarViewOption carViewOption;
            CarViewOption carViewOption2;
            CarViewOption carViewOption3;
            CarViewOption carViewOption4;
            SoundConfiguration soundConfiguration;
            soundViewOptions = new SoundViewOptions();
            soundViewOptions.configuration = soundConfiguration = SoundConfigurationSerializer.getOptionalSoundConfiguration(iDeserializer);
            soundViewOptions.setFactoryDefault = carViewOption4 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            soundViewOptions.systemOnOff = carViewOption3 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            soundViewOptions.soundOnOff = carViewOption2 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            soundViewOptions.style = carViewOption = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
        }
        return soundViewOptions;
    }

    public static SoundViewOptions[] getOptionalSoundViewOptionsVarArray(IDeserializer iDeserializer) {
        SoundViewOptions[] soundViewOptionsArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            soundViewOptionsArray = new SoundViewOptions[n];
            for (int i2 = 0; i2 < n; ++i2) {
                soundViewOptionsArray[i2] = SoundViewOptionsSerializer.getOptionalSoundViewOptions(iDeserializer);
            }
        }
        return soundViewOptionsArray;
    }
}

