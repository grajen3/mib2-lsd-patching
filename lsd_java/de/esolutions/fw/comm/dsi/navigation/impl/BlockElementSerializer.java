/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.navigation.impl;

import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.navigation.BlockElement;

public class BlockElementSerializer {
    public static void putOptionalBlockElement(ISerializer iSerializer, BlockElement blockElement) {
        boolean bl = blockElement == null;
        iSerializer.putBool(bl);
        if (!bl) {
            long l = blockElement.getUid();
            iSerializer.putInt64(l);
            int n = blockElement.getType();
            iSerializer.putInt32(n);
            int n2 = blockElement.getDistanceToDestination();
            iSerializer.putInt32(n2);
            boolean bl2 = blockElement.isOnRoute();
            iSerializer.putBool(bl2);
            boolean bl3 = blockElement.isPersistent();
            iSerializer.putBool(bl3);
            String string = blockElement.getDescription();
            iSerializer.putOptionalString(string);
        }
    }

    public static void putOptionalBlockElementVarArray(ISerializer iSerializer, BlockElement[] blockElementArray) {
        boolean bl = blockElementArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(blockElementArray.length);
            for (int i2 = 0; i2 < blockElementArray.length; ++i2) {
                BlockElementSerializer.putOptionalBlockElement(iSerializer, blockElementArray[i2]);
            }
        }
    }

    public static BlockElement getOptionalBlockElement(IDeserializer iDeserializer) {
        BlockElement blockElement = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            String string;
            boolean bl2;
            boolean bl3;
            int n;
            int n2;
            long l;
            blockElement = new BlockElement();
            blockElement.uid = l = iDeserializer.getInt64();
            blockElement.type = n2 = iDeserializer.getInt32();
            blockElement.distanceToDestination = n = iDeserializer.getInt32();
            blockElement.onRoute = bl3 = iDeserializer.getBool();
            blockElement.persistent = bl2 = iDeserializer.getBool();
            blockElement.description = string = iDeserializer.getOptionalString();
        }
        return blockElement;
    }

    public static BlockElement[] getOptionalBlockElementVarArray(IDeserializer iDeserializer) {
        BlockElement[] blockElementArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            blockElementArray = new BlockElement[n];
            for (int i2 = 0; i2 < n; ++i2) {
                blockElementArray[i2] = BlockElementSerializer.getOptionalBlockElement(iDeserializer);
            }
        }
        return blockElementArray;
    }
}

