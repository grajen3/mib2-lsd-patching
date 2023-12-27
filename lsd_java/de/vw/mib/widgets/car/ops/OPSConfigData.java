/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets.car.ops;

import de.vw.mib.util.StringBuilder;
import de.vw.mib.widgets.SkinHelper;
import de.vw.mib.widgets.car.AbstractConfigData;
import java.io.InputStream;

public final class OPSConfigData
extends AbstractConfigData {
    private final short[] mirrorData = new short[4];
    private final short[] imageMetaData = new short[1];
    private final short[] trackData = new short[12];
    private final short[] areaViewData = new short[25];
    private final short[] segmentsPerSector = new short[54];
    private final short[][] segmentData = new short[96][12];
    private final short[][] additionalGraphics = new short[43][10];
    private final short[][] carSpecificImageData = new short[4][3];
    private final int[] segmentDataBoundaries = new int[54];

    public OPSConfigData(boolean bl) {
        super(new StringBuilder(256).append(SkinHelper.getDataPath(0)).append(bl ? "config_mini.ops" : "config.ops").toString(), (short)67, (short)55, 8220);
    }

    @Override
    protected void deserialize(InputStream inputStream) {
        this.readHeaderData(inputStream);
        this.readMirrorData(inputStream);
        this.readImageMetaData(inputStream);
        this.readTrackData(inputStream);
        this.readAreaViewData(inputStream);
        this.readSegmentData(inputStream);
        this.readAdditionalGraphicsData(inputStream);
        this.readCarSpecificImageData(inputStream);
    }

    public short[] getSegmentDataById(int n, int n2) {
        if (n2 >= this.segmentsPerSector[n]) {
            return null;
        }
        return this.segmentData[this.getSectorAddress(n) + n2];
    }

    public short[] getSegmentDataByDistance(int n, int n2) {
        return this.getSegmentDataByDistanceRange(n, 0, n2);
    }

    public short[] getSegmentDataByDistanceRange(int n, int n2, int n3) {
        int n4;
        for (n4 = this.getSectorAddress(n); n4 >= 0 && n4 < this.segmentData.length && this.segmentData[n4][0] == n && this.segmentData[n4][2] > n2 && this.segmentData[n4][2] < n3; ++n4) {
        }
        if (n4 < 0 || n4 >= this.segmentData.length || this.segmentData[n4][0] != n) {
            return null;
        }
        return this.segmentData[n4];
    }

    public short[] getSegmentDataWithHighestDistance(int n) {
        int n2;
        for (n2 = this.getSectorAddress(n); n2 >= 0 && n2 < this.segmentData.length && this.segmentData[n2][0] == n; ++n2) {
        }
        while (n2 >= 0 && n2 < this.segmentData.length && this.segmentData[n2][0] != n) {
            --n2;
        }
        return n2 >= 0 && n2 < this.segmentData.length ? this.segmentData[n2] : null;
    }

    public int getSegmentsPerSector(int n) {
        return this.segmentsPerSector[n];
    }

    public short[] getAdditionalGraphicsData(int n) {
        if (n < 0 || n >= 43) {
            return null;
        }
        return this.additionalGraphics[n];
    }

    public short[] getCarSpecificImageData(int n) {
        if (0 > n || 3 < n) {
            return null;
        }
        return this.carSpecificImageData[n];
    }

    public short getTrackDataValue(int n) {
        short s = -1;
        if (0 <= n && 11 >= n) {
            s = this.trackData[n];
        }
        return s;
    }

    public short getAreaViewDataValue(int n) {
        short s = -1;
        if (0 <= n && 24 >= n) {
            s = this.areaViewData[n];
        }
        return s;
    }

    public short getMirrorValue(int n) {
        if (0 <= n && 4 > n) {
            return this.mirrorData[n];
        }
        return -1;
    }

    public short getImageMetaData(int n) {
        if (0 <= n && 1 > n) {
            return this.imageMetaData[n];
        }
        return -1;
    }

    private void readHeaderData(InputStream inputStream) {
        this.fillArray(inputStream, this.segmentsPerSector, 4);
    }

    private void readMirrorData(InputStream inputStream) {
        this.fillArray(inputStream, this.mirrorData, 1028);
    }

    private void readImageMetaData(InputStream inputStream) {
        this.fillArray(inputStream, this.imageMetaData, 1036);
    }

    private void readTrackData(InputStream inputStream) {
        this.fillArray(inputStream, this.trackData, 1038);
    }

    private void readAreaViewData(InputStream inputStream) {
        this.fillArray(inputStream, this.areaViewData, 1062);
    }

    private void readSegmentData(InputStream inputStream) {
        int n = -1;
        int n2 = -1;
        inputStream.reset();
        inputStream.skip(0);
        for (int i2 = 0; i2 < this.segmentData.length; ++i2) {
            for (int i3 = 0; i3 < this.segmentData[i2].length; ++i3) {
                this.segmentData[i2][i3] = this.getShort(inputStream);
            }
            n2 = this.segmentData[i2][0];
            if (n >= n2) continue;
            this.registerSegmentDataBoundaries(this.segmentData[i2], i2);
            n = n2;
        }
    }

    private void readAdditionalGraphicsData(InputStream inputStream) {
        this.fillArray(inputStream, this.additionalGraphics, 7172);
    }

    private void readCarSpecificImageData(InputStream inputStream) {
        this.fillArray(inputStream, this.carSpecificImageData, 8196);
    }

    private int getSectorAddress(int n) {
        if (this.segmentDataBoundaries != null && n < this.segmentDataBoundaries.length) {
            return this.segmentDataBoundaries[n];
        }
        return -1;
    }

    private void registerSegmentDataBoundaries(short[] sArray, int n) {
        this.segmentDataBoundaries[sArray[0]] = n;
    }
}

