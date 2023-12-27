/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.cardriverassistance.impl;

import de.esolutions.fw.comm.dsi.global.impl.CarViewOptionSerializer;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.cardriverassistance.CurveAssistViewOptions;
import org.dsi.ifc.global.CarViewOption;

public class CurveAssistViewOptionsSerializer {
    public static void putOptionalCurveAssistViewOptions(ISerializer iSerializer, CurveAssistViewOptions curveAssistViewOptions) {
        boolean bl = curveAssistViewOptions == null;
        iSerializer.putBool(bl);
        if (!bl) {
            CarViewOption carViewOption = curveAssistViewOptions.getCurveAssistSystemOnOff();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption);
            CarViewOption carViewOption2 = curveAssistViewOptions.getCurveAssistSetFactoryDefault();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption2);
        }
    }

    public static void putOptionalCurveAssistViewOptionsVarArray(ISerializer iSerializer, CurveAssistViewOptions[] curveAssistViewOptionsArray) {
        boolean bl = curveAssistViewOptionsArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(curveAssistViewOptionsArray.length);
            for (int i2 = 0; i2 < curveAssistViewOptionsArray.length; ++i2) {
                CurveAssistViewOptionsSerializer.putOptionalCurveAssistViewOptions(iSerializer, curveAssistViewOptionsArray[i2]);
            }
        }
    }

    public static CurveAssistViewOptions getOptionalCurveAssistViewOptions(IDeserializer iDeserializer) {
        CurveAssistViewOptions curveAssistViewOptions = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            CarViewOption carViewOption;
            CarViewOption carViewOption2;
            curveAssistViewOptions = new CurveAssistViewOptions();
            curveAssistViewOptions.curveAssistSystemOnOff = carViewOption2 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            curveAssistViewOptions.curveAssistSetFactoryDefault = carViewOption = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
        }
        return curveAssistViewOptions;
    }

    public static CurveAssistViewOptions[] getOptionalCurveAssistViewOptionsVarArray(IDeserializer iDeserializer) {
        CurveAssistViewOptions[] curveAssistViewOptionsArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            curveAssistViewOptionsArray = new CurveAssistViewOptions[n];
            for (int i2 = 0; i2 < n; ++i2) {
                curveAssistViewOptionsArray[i2] = CurveAssistViewOptionsSerializer.getOptionalCurveAssistViewOptions(iDeserializer);
            }
        }
        return curveAssistViewOptionsArray;
    }
}

