/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets.car.generic;

import de.vw.mib.widgets.car.generic.GenericCarAdjusterConfigData;
import de.vw.mib.widgets.car.generic.GenericCarAdjusterConfigData$GenericCarConfigDataReader;
import java.io.InputStream;

class GenericCarAdjusterConfigData$ImageDefinitionReader
implements GenericCarAdjusterConfigData$GenericCarConfigDataReader {
    private final /* synthetic */ GenericCarAdjusterConfigData this$0;

    GenericCarAdjusterConfigData$ImageDefinitionReader(GenericCarAdjusterConfigData genericCarAdjusterConfigData) {
        this.this$0 = genericCarAdjusterConfigData;
    }

    @Override
    public void deserialize(InputStream inputStream) {
        this.readImageDefinitions(inputStream);
    }

    private void readImageDefinitions(InputStream inputStream) {
        short s = this.this$0.getShort(inputStream);
        short[][] sArray = new short[s][4];
        this.this$0.fillArray(inputStream, sArray);
        this.this$0.setImageDefinitions(sArray);
    }
}

