/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.media.impl;

import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.media.DatabaseSpace;

public class DatabaseSpaceSerializer {
    public static void putOptionalDatabaseSpace(ISerializer iSerializer, DatabaseSpace databaseSpace) {
        boolean bl = databaseSpace == null;
        iSerializer.putBool(bl);
        if (!bl) {
            long l = databaseSpace.getSize();
            iSerializer.putInt64(l);
            long l2 = databaseSpace.getSizeAvail();
            iSerializer.putInt64(l2);
            long l3 = databaseSpace.getMaxEntries();
            iSerializer.putInt64(l3);
            long l4 = databaseSpace.getNumEntries();
            iSerializer.putInt64(l4);
        }
    }

    public static void putOptionalDatabaseSpaceVarArray(ISerializer iSerializer, DatabaseSpace[] databaseSpaceArray) {
        boolean bl = databaseSpaceArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(databaseSpaceArray.length);
            for (int i2 = 0; i2 < databaseSpaceArray.length; ++i2) {
                DatabaseSpaceSerializer.putOptionalDatabaseSpace(iSerializer, databaseSpaceArray[i2]);
            }
        }
    }

    public static DatabaseSpace getOptionalDatabaseSpace(IDeserializer iDeserializer) {
        DatabaseSpace databaseSpace = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            long l;
            long l2;
            long l3;
            long l4;
            databaseSpace = new DatabaseSpace();
            databaseSpace.size = l4 = iDeserializer.getInt64();
            databaseSpace.sizeAvail = l3 = iDeserializer.getInt64();
            databaseSpace.maxEntries = l2 = iDeserializer.getInt64();
            databaseSpace.numEntries = l = iDeserializer.getInt64();
        }
        return databaseSpace;
    }

    public static DatabaseSpace[] getOptionalDatabaseSpaceVarArray(IDeserializer iDeserializer) {
        DatabaseSpace[] databaseSpaceArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            databaseSpaceArray = new DatabaseSpace[n];
            for (int i2 = 0; i2 < n; ++i2) {
                databaseSpaceArray[i2] = DatabaseSpaceSerializer.getOptionalDatabaseSpace(iDeserializer);
            }
        }
        return databaseSpaceArray;
    }
}

