/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.carparkingsystem.impl;

import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.carparkingsystem.PDCPLABargraph;

public class PDCPLABargraphSerializer {
    public static void putOptionalPDCPLABargraph(ISerializer iSerializer, PDCPLABargraph pDCPLABargraph) {
        boolean bl = pDCPLABargraph == null;
        iSerializer.putBool(bl);
        if (!bl) {
            int n = pDCPLABargraph.getArrowIndication();
            iSerializer.putInt32(n);
            int n2 = pDCPLABargraph.getArrowLevel();
            iSerializer.putInt32(n2);
        }
    }

    public static void putOptionalPDCPLABargraphVarArray(ISerializer iSerializer, PDCPLABargraph[] pDCPLABargraphArray) {
        boolean bl = pDCPLABargraphArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(pDCPLABargraphArray.length);
            for (int i2 = 0; i2 < pDCPLABargraphArray.length; ++i2) {
                PDCPLABargraphSerializer.putOptionalPDCPLABargraph(iSerializer, pDCPLABargraphArray[i2]);
            }
        }
    }

    public static PDCPLABargraph getOptionalPDCPLABargraph(IDeserializer iDeserializer) {
        PDCPLABargraph pDCPLABargraph = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n;
            int n2;
            pDCPLABargraph = new PDCPLABargraph();
            pDCPLABargraph.arrowIndication = n2 = iDeserializer.getInt32();
            pDCPLABargraph.arrowLevel = n = iDeserializer.getInt32();
        }
        return pDCPLABargraph;
    }

    public static PDCPLABargraph[] getOptionalPDCPLABargraphVarArray(IDeserializer iDeserializer) {
        PDCPLABargraph[] pDCPLABargraphArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            pDCPLABargraphArray = new PDCPLABargraph[n];
            for (int i2 = 0; i2 < n; ++i2) {
                pDCPLABargraphArray[i2] = PDCPLABargraphSerializer.getOptionalPDCPLABargraph(iDeserializer);
            }
        }
        return pDCPLABargraphArray;
    }
}

