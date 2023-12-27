/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.speechrec.impl;

import de.esolutions.fw.comm.dsi.speechrec.impl.NBestSlotSerializer;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.speechrec.GraphemicGroup;
import org.dsi.ifc.speechrec.NBestSlot;

public class GraphemicGroupSerializer {
    public static void putOptionalGraphemicGroup(ISerializer iSerializer, GraphemicGroup graphemicGroup) {
        boolean bl = graphemicGroup == null;
        iSerializer.putBool(bl);
        if (!bl) {
            String string = graphemicGroup.getGroupText();
            iSerializer.putOptionalString(string);
            int n = graphemicGroup.getGraphemicGroupSize();
            iSerializer.putInt32(n);
            NBestSlot[] nBestSlotArray = graphemicGroup.getSlots();
            NBestSlotSerializer.putOptionalNBestSlotVarArray(iSerializer, nBestSlotArray);
        }
    }

    public static void putOptionalGraphemicGroupVarArray(ISerializer iSerializer, GraphemicGroup[] graphemicGroupArray) {
        boolean bl = graphemicGroupArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(graphemicGroupArray.length);
            for (int i2 = 0; i2 < graphemicGroupArray.length; ++i2) {
                GraphemicGroupSerializer.putOptionalGraphemicGroup(iSerializer, graphemicGroupArray[i2]);
            }
        }
    }

    public static GraphemicGroup getOptionalGraphemicGroup(IDeserializer iDeserializer) {
        GraphemicGroup graphemicGroup = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n;
            String string;
            graphemicGroup = new GraphemicGroup();
            graphemicGroup.groupText = string = iDeserializer.getOptionalString();
            graphemicGroup.graphemicGroupSize = n = iDeserializer.getInt32();
            NBestSlot[] nBestSlotArray = NBestSlotSerializer.getOptionalNBestSlotVarArray(iDeserializer);
            graphemicGroup.slots = nBestSlotArray;
        }
        return graphemicGroup;
    }

    public static GraphemicGroup[] getOptionalGraphemicGroupVarArray(IDeserializer iDeserializer) {
        GraphemicGroup[] graphemicGroupArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            graphemicGroupArray = new GraphemicGroup[n];
            for (int i2 = 0; i2 < n; ++i2) {
                graphemicGroupArray[i2] = GraphemicGroupSerializer.getOptionalGraphemicGroup(iDeserializer);
            }
        }
        return graphemicGroupArray;
    }
}

