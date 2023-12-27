/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.hmisync.car.sportchrono.impl;

import de.esolutions.fw.comm.asi.hmisync.car.sportchrono.RecordingRange;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;

public class RecordingRangeSerializer {
    public static void putOptionalRecordingRange(ISerializer iSerializer, RecordingRange recordingRange) {
        boolean bl = recordingRange == null;
        iSerializer.putBool(bl);
        if (!bl) {
            long l = recordingRange.getRemainingRange();
            iSerializer.putInt64(l);
            short s = recordingRange.getRemainingLaps();
            iSerializer.putInt16(s);
        }
    }

    public static void putOptionalRecordingRangeVarArray(ISerializer iSerializer, RecordingRange[] recordingRangeArray) {
        boolean bl = recordingRangeArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(recordingRangeArray.length);
            for (int i2 = 0; i2 < recordingRangeArray.length; ++i2) {
                RecordingRangeSerializer.putOptionalRecordingRange(iSerializer, recordingRangeArray[i2]);
            }
        }
    }

    public static RecordingRange getOptionalRecordingRange(IDeserializer iDeserializer) {
        RecordingRange recordingRange = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            short s;
            long l;
            recordingRange = new RecordingRange();
            recordingRange.remainingRange = l = iDeserializer.getInt64();
            recordingRange.remainingLaps = s = iDeserializer.getInt16();
        }
        return recordingRange;
    }

    public static RecordingRange[] getOptionalRecordingRangeVarArray(IDeserializer iDeserializer) {
        RecordingRange[] recordingRangeArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            recordingRangeArray = new RecordingRange[n];
            for (int i2 = 0; i2 < n; ++i2) {
                recordingRangeArray[i2] = RecordingRangeSerializer.getOptionalRecordingRange(iDeserializer);
            }
        }
        return recordingRangeArray;
    }
}

