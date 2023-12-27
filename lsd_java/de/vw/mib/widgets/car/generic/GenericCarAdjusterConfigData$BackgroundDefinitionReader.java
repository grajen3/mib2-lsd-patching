/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets.car.generic;

import de.vw.mib.widgets.car.generic.GenericCarAdjusterConfigData;
import de.vw.mib.widgets.car.generic.GenericCarAdjusterConfigData$GenericCarConfigDataReader;
import java.io.InputStream;

class GenericCarAdjusterConfigData$BackgroundDefinitionReader
implements GenericCarAdjusterConfigData$GenericCarConfigDataReader {
    private final /* synthetic */ GenericCarAdjusterConfigData this$0;

    GenericCarAdjusterConfigData$BackgroundDefinitionReader(GenericCarAdjusterConfigData genericCarAdjusterConfigData) {
        this.this$0 = genericCarAdjusterConfigData;
    }

    @Override
    public void deserialize(InputStream inputStream) {
        this.readBackgroundDefinitions(inputStream);
    }

    private void readBackgroundDefinitions(InputStream inputStream) {
        short s = this.this$0.getShort(inputStream);
        short[][] sArray = new short[s][5];
        this.this$0.fillArray(inputStream, sArray);
        this.this$0.setBackgroundDefinitions(sArray);
    }
}

