/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.speechrec.impl;

import de.esolutions.fw.comm.dsi.speechrec.impl.GraphemicGroupSerializer;
import de.esolutions.fw.comm.dsi.speechrec.impl.NBestListEntrySerializer;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.speechrec.GraphemicGroup;
import org.dsi.ifc.speechrec.NBestList;
import org.dsi.ifc.speechrec.NBestListEntry;

public class NBestListSerializer {
    public static void putOptionalNBestList(ISerializer iSerializer, NBestList nBestList) {
        boolean bl = nBestList == null;
        iSerializer.putBool(bl);
        if (!bl) {
            GraphemicGroup[] graphemicGroupArray = nBestList.getGraphemicGroups();
            GraphemicGroupSerializer.putOptionalGraphemicGroupVarArray(iSerializer, graphemicGroupArray);
            NBestListEntry[] nBestListEntryArray = nBestList.getEntries();
            NBestListEntrySerializer.putOptionalNBestListEntryVarArray(iSerializer, nBestListEntryArray);
            int n = nBestList.getNBestListID();
            iSerializer.putInt32(n);
        }
    }

    public static void putOptionalNBestListVarArray(ISerializer iSerializer, NBestList[] nBestListArray) {
        boolean bl = nBestListArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(nBestListArray.length);
            for (int i2 = 0; i2 < nBestListArray.length; ++i2) {
                NBestListSerializer.putOptionalNBestList(iSerializer, nBestListArray[i2]);
            }
        }
    }

    public static NBestList getOptionalNBestList(IDeserializer iDeserializer) {
        NBestList nBestList = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n;
            nBestList = new NBestList();
            GraphemicGroup[] graphemicGroupArray = GraphemicGroupSerializer.getOptionalGraphemicGroupVarArray(iDeserializer);
            nBestList.graphemicGroups = graphemicGroupArray;
            NBestListEntry[] nBestListEntryArray = NBestListEntrySerializer.getOptionalNBestListEntryVarArray(iDeserializer);
            nBestList.entries = nBestListEntryArray;
            nBestList.nBestListID = n = iDeserializer.getInt32();
        }
        return nBestList;
    }

    public static NBestList[] getOptionalNBestListVarArray(IDeserializer iDeserializer) {
        NBestList[] nBestListArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            nBestListArray = new NBestList[n];
            for (int i2 = 0; i2 < n; ++i2) {
                nBestListArray[i2] = NBestListSerializer.getOptionalNBestList(iDeserializer);
            }
        }
        return nBestListArray;
    }
}

