/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets.car.pureair;

import de.vw.mib.util.StringBuilder;
import de.vw.mib.widgets.SkinHelper;
import de.vw.mib.widgets.car.AbstractConfigData;
import de.vw.mib.widgets.car.pureair.PureAirConstants;
import java.io.InputStream;

public final class PureAirConfigData
extends AbstractConfigData {
    private static final int DEFAULT_CONFIG_FILE_LENGTH;
    private final short[] backgroundData = new short[2];
    private short[][] featureData;
    private short numberOfFeatures;

    public PureAirConfigData() {
        super(new StringBuilder(256).append(SkinHelper.getDataPath(6)).append(PureAirConstants.FILE_NAME).toString(), (short)1, 6);
    }

    @Override
    protected void deserialize(InputStream inputStream) {
        this.readHeaderData(inputStream);
        this.readBackgroundData(inputStream);
        this.readFeatureData(inputStream);
    }

    public short[] getBackgroundData() {
        return this.backgroundData;
    }

    public short[] getFeatureData(int n) {
        if (n < PureAirConstants.FEATURE_NAMES.length) {
            return this.featureData[n];
        }
        short[] sArray = new short[]{(short)n, 0, 0};
        return sArray;
    }

    public short getFeatureCount() {
        return this.numberOfFeatures;
    }

    private void readHeaderData(InputStream inputStream) {
        this.numberOfFeatures = this.getShort(inputStream, 4);
        int n = 6 + 0 * this.numberOfFeatures * 2;
        this.onConfigFileLengthChanged(n);
    }

    private void readBackgroundData(InputStream inputStream) {
        this.fillArray(inputStream, this.backgroundData, 6);
    }

    private void readFeatureData(InputStream inputStream) {
        this.featureData = new short[this.numberOfFeatures][0];
        this.fillArray(inputStream, this.featureData, 6);
    }
}

