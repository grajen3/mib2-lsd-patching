/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.carseat.impl;

import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.carseat.SwitcherDataUpDown;

public class SwitcherDataUpDownSerializer {
    public static void putOptionalSwitcherDataUpDown(ISerializer iSerializer, SwitcherDataUpDown switcherDataUpDown) {
        boolean bl = switcherDataUpDown == null;
        iSerializer.putBool(bl);
        if (!bl) {
            boolean bl2 = switcherDataUpDown.isSitzhoehe();
            iSerializer.putBool(bl2);
            boolean bl3 = switcherDataUpDown.isKopfstuetzenhoehe();
            iSerializer.putBool(bl3);
            boolean bl4 = switcherDataUpDown.isLordosenhoehe();
            iSerializer.putBool(bl4);
            boolean bl5 = switcherDataUpDown.isGurthoehe();
            iSerializer.putBool(bl5);
            boolean bl6 = switcherDataUpDown.isSitzflaechenwangen();
            iSerializer.putBool(bl6);
            boolean bl7 = switcherDataUpDown.isSitzneigung();
            iSerializer.putBool(bl7);
            boolean bl8 = switcherDataUpDown.isFussstuetzenhoehe();
            iSerializer.putBool(bl8);
            boolean bl9 = switcherDataUpDown.isRseAufnahmehoehe();
            iSerializer.putBool(bl9);
            boolean bl10 = switcherDataUpDown.isFussmattenhoehe();
            iSerializer.putBool(bl10);
            boolean bl11 = switcherDataUpDown.isRseDisplay();
            iSerializer.putBool(bl11);
        }
    }

    public static void putOptionalSwitcherDataUpDownVarArray(ISerializer iSerializer, SwitcherDataUpDown[] switcherDataUpDownArray) {
        boolean bl = switcherDataUpDownArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(switcherDataUpDownArray.length);
            for (int i2 = 0; i2 < switcherDataUpDownArray.length; ++i2) {
                SwitcherDataUpDownSerializer.putOptionalSwitcherDataUpDown(iSerializer, switcherDataUpDownArray[i2]);
            }
        }
    }

    public static SwitcherDataUpDown getOptionalSwitcherDataUpDown(IDeserializer iDeserializer) {
        SwitcherDataUpDown switcherDataUpDown = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            boolean bl2;
            boolean bl3;
            boolean bl4;
            boolean bl5;
            boolean bl6;
            boolean bl7;
            boolean bl8;
            boolean bl9;
            boolean bl10;
            boolean bl11;
            switcherDataUpDown = new SwitcherDataUpDown();
            switcherDataUpDown.sitzhoehe = bl11 = iDeserializer.getBool();
            switcherDataUpDown.kopfstuetzenhoehe = bl10 = iDeserializer.getBool();
            switcherDataUpDown.lordosenhoehe = bl9 = iDeserializer.getBool();
            switcherDataUpDown.gurthoehe = bl8 = iDeserializer.getBool();
            switcherDataUpDown.sitzflaechenwangen = bl7 = iDeserializer.getBool();
            switcherDataUpDown.sitzneigung = bl6 = iDeserializer.getBool();
            switcherDataUpDown.fussstuetzenhoehe = bl5 = iDeserializer.getBool();
            switcherDataUpDown.rseAufnahmehoehe = bl4 = iDeserializer.getBool();
            switcherDataUpDown.fussmattenhoehe = bl3 = iDeserializer.getBool();
            switcherDataUpDown.rseDisplay = bl2 = iDeserializer.getBool();
        }
        return switcherDataUpDown;
    }

    public static SwitcherDataUpDown[] getOptionalSwitcherDataUpDownVarArray(IDeserializer iDeserializer) {
        SwitcherDataUpDown[] switcherDataUpDownArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            switcherDataUpDownArray = new SwitcherDataUpDown[n];
            for (int i2 = 0; i2 < n; ++i2) {
                switcherDataUpDownArray[i2] = SwitcherDataUpDownSerializer.getOptionalSwitcherDataUpDown(iDeserializer);
            }
        }
        return switcherDataUpDownArray;
    }
}

