/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.cardrivingcharacteristics.impl;

import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.cardrivingcharacteristics.SuspensionControleABCPreview;

public class SuspensionControleABCPreviewSerializer {
    public static void putOptionalSuspensionControleABCPreview(ISerializer iSerializer, SuspensionControleABCPreview suspensionControleABCPreview) {
        boolean bl = suspensionControleABCPreview == null;
        iSerializer.putBool(bl);
        if (!bl) {
            boolean bl2 = suspensionControleABCPreview.isState();
            iSerializer.putBool(bl2);
            int n = suspensionControleABCPreview.getObstacleLevel();
            iSerializer.putInt32(n);
        }
    }

    public static void putOptionalSuspensionControleABCPreviewVarArray(ISerializer iSerializer, SuspensionControleABCPreview[] suspensionControleABCPreviewArray) {
        boolean bl = suspensionControleABCPreviewArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(suspensionControleABCPreviewArray.length);
            for (int i2 = 0; i2 < suspensionControleABCPreviewArray.length; ++i2) {
                SuspensionControleABCPreviewSerializer.putOptionalSuspensionControleABCPreview(iSerializer, suspensionControleABCPreviewArray[i2]);
            }
        }
    }

    public static SuspensionControleABCPreview getOptionalSuspensionControleABCPreview(IDeserializer iDeserializer) {
        SuspensionControleABCPreview suspensionControleABCPreview = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n;
            boolean bl2;
            suspensionControleABCPreview = new SuspensionControleABCPreview();
            suspensionControleABCPreview.state = bl2 = iDeserializer.getBool();
            suspensionControleABCPreview.obstacleLevel = n = iDeserializer.getInt32();
        }
        return suspensionControleABCPreview;
    }

    public static SuspensionControleABCPreview[] getOptionalSuspensionControleABCPreviewVarArray(IDeserializer iDeserializer) {
        SuspensionControleABCPreview[] suspensionControleABCPreviewArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            suspensionControleABCPreviewArray = new SuspensionControleABCPreview[n];
            for (int i2 = 0; i2 < n; ++i2) {
                suspensionControleABCPreviewArray[i2] = SuspensionControleABCPreviewSerializer.getOptionalSuspensionControleABCPreview(iDeserializer);
            }
        }
        return suspensionControleABCPreviewArray;
    }
}

