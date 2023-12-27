/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.carseat.impl;

import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.carseat.SwitcherDataBackForward;

public class SwitcherDataBackForwardSerializer {
    public static void putOptionalSwitcherDataBackForward(ISerializer iSerializer, SwitcherDataBackForward switcherDataBackForward) {
        boolean bl = switcherDataBackForward == null;
        iSerializer.putBool(bl);
        if (!bl) {
            boolean bl2 = switcherDataBackForward.isSitzlaenge();
            iSerializer.putBool(bl2);
            boolean bl3 = switcherDataBackForward.isLehnenneigung();
            iSerializer.putBool(bl3);
            boolean bl4 = switcherDataBackForward.isLordosenweite();
            iSerializer.putBool(bl4);
            boolean bl5 = switcherDataBackForward.isSitztiefe();
            iSerializer.putBool(bl5);
            boolean bl6 = switcherDataBackForward.isLehnenkopf();
            iSerializer.putBool(bl6);
            boolean bl7 = switcherDataBackForward.isLehnenwangen();
            iSerializer.putBool(bl7);
            boolean bl8 = switcherDataBackForward.isKopfstuetzenlaenge();
            iSerializer.putBool(bl8);
            boolean bl9 = switcherDataBackForward.isRseAufnahmetiefe();
            iSerializer.putBool(bl9);
        }
    }

    public static void putOptionalSwitcherDataBackForwardVarArray(ISerializer iSerializer, SwitcherDataBackForward[] switcherDataBackForwardArray) {
        boolean bl = switcherDataBackForwardArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(switcherDataBackForwardArray.length);
            for (int i2 = 0; i2 < switcherDataBackForwardArray.length; ++i2) {
                SwitcherDataBackForwardSerializer.putOptionalSwitcherDataBackForward(iSerializer, switcherDataBackForwardArray[i2]);
            }
        }
    }

    public static SwitcherDataBackForward getOptionalSwitcherDataBackForward(IDeserializer iDeserializer) {
        SwitcherDataBackForward switcherDataBackForward = null;
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
            switcherDataBackForward = new SwitcherDataBackForward();
            switcherDataBackForward.sitzlaenge = bl9 = iDeserializer.getBool();
            switcherDataBackForward.lehnenneigung = bl8 = iDeserializer.getBool();
            switcherDataBackForward.lordosenweite = bl7 = iDeserializer.getBool();
            switcherDataBackForward.sitztiefe = bl6 = iDeserializer.getBool();
            switcherDataBackForward.lehnenkopf = bl5 = iDeserializer.getBool();
            switcherDataBackForward.lehnenwangen = bl4 = iDeserializer.getBool();
            switcherDataBackForward.kopfstuetzenlaenge = bl3 = iDeserializer.getBool();
            switcherDataBackForward.rseAufnahmetiefe = bl2 = iDeserializer.getBool();
        }
        return switcherDataBackForward;
    }

    public static SwitcherDataBackForward[] getOptionalSwitcherDataBackForwardVarArray(IDeserializer iDeserializer) {
        SwitcherDataBackForward[] switcherDataBackForwardArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            switcherDataBackForwardArray = new SwitcherDataBackForward[n];
            for (int i2 = 0; i2 < n; ++i2) {
                switcherDataBackForwardArray[i2] = SwitcherDataBackForwardSerializer.getOptionalSwitcherDataBackForward(iDeserializer);
            }
        }
        return switcherDataBackForwardArray;
    }
}

