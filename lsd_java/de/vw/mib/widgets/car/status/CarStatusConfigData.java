/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets.car.status;

import de.vw.mib.graphics.Point;
import de.vw.mib.util.StringBuilder;
import de.vw.mib.widgets.SkinHelper;
import de.vw.mib.widgets.car.AbstractConfigData;
import de.vw.mib.widgets.car.status.CarStatusConfigData$FeatureInfo;
import de.vw.mib.widgets.car.status.CarStatusConfigData$FeatureInfos;
import java.io.InputStream;

public final class CarStatusConfigData
extends AbstractConfigData {
    private static final int FEATURE_ID;
    private static final int FEATURE_POS_X;
    private static final int FEATURE_POS_Y;
    private static final int ALTERNATIVE_FEATURE_ID_OFFSET;
    private static final int DEFAULT_CONFIG_FILE_LENGTH;
    private short numberOfFeatures;
    private final short[] carData = new short[4];
    private CarStatusConfigData$FeatureInfos featureInfos;

    public CarStatusConfigData() {
        super(new StringBuilder(256).append(SkinHelper.getDataPath(2)).append("carstatus.car").toString(), (short)1, 6);
    }

    @Override
    protected void deserialize(InputStream inputStream) {
        this.readHeaderData(inputStream);
        this.readCarPositionData(inputStream);
        this.readFeatureData(inputStream);
    }

    public int getFeatureCount() {
        return this.featureInfos.getFeatureCount();
    }

    public int getFeatureId(int n) {
        CarStatusConfigData$FeatureInfo carStatusConfigData$FeatureInfo = this.featureInfos.getFeatureInfoAt(n);
        return carStatusConfigData$FeatureInfo.id;
    }

    public Point getFeaturePos(int n, boolean bl) {
        CarStatusConfigData$FeatureInfo carStatusConfigData$FeatureInfo = this.featureInfos.getFeatureInfoAt(n);
        if (bl && carStatusConfigData$FeatureInfo.alternativePosition != null) {
            return carStatusConfigData$FeatureInfo.alternativePosition;
        }
        return carStatusConfigData$FeatureInfo.position;
    }

    public int getCarXPos(boolean bl) {
        if (bl) {
            return this.carData[0];
        }
        return this.carData[2];
    }

    public int getCarYPos(boolean bl) {
        if (bl) {
            return this.carData[1];
        }
        return this.carData[3];
    }

    private void readHeaderData(InputStream inputStream) {
        this.numberOfFeatures = this.getShort(inputStream, 4);
        int n = 256 + 8 * this.numberOfFeatures * 2;
        this.onConfigFileLengthChanged(n);
    }

    private void readCarPositionData(InputStream inputStream) {
        this.fillArray(inputStream, this.carData, 6);
    }

    private void readFeatureData(InputStream inputStream) {
        short[][] sArray = new short[this.numberOfFeatures][8];
        this.fillArray(inputStream, sArray, 256);
        this.featureInfos = CarStatusConfigData$FeatureInfos.createListWithMaximalSize(this.numberOfFeatures);
        for (int i2 = 0; i2 < sArray.length; ++i2) {
            this.featureInfos.addFeatureInfo(sArray[i2]);
        }
    }
}

