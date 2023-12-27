/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets.car.generic;

import de.vw.mib.widgets.car.generic.GenericCarAdjusterConfigData;
import de.vw.mib.widgets.car.generic.GenericCarAdjusterConfigData$ButtonDefinition;
import de.vw.mib.widgets.car.generic.GenericCarAdjusterConfigData$GenericCarConfigDataReader;
import java.io.InputStream;

class GenericCarAdjusterConfigData$ButtonDefinitionDefinitionReader
implements GenericCarAdjusterConfigData$GenericCarConfigDataReader {
    private final /* synthetic */ GenericCarAdjusterConfigData this$0;

    GenericCarAdjusterConfigData$ButtonDefinitionDefinitionReader(GenericCarAdjusterConfigData genericCarAdjusterConfigData) {
        this.this$0 = genericCarAdjusterConfigData;
    }

    @Override
    public void deserialize(InputStream inputStream) {
        this.readButtonDefinitions(inputStream);
    }

    private void readButtonDefinitions(InputStream inputStream) {
        short s = this.this$0.getShort(inputStream);
        GenericCarAdjusterConfigData$ButtonDefinition[] genericCarAdjusterConfigData$ButtonDefinitionArray = new GenericCarAdjusterConfigData$ButtonDefinition[s];
        short[][] sArray = new short[s][21];
        this.this$0.fillArray(inputStream, sArray);
        for (int i2 = genericCarAdjusterConfigData$ButtonDefinitionArray.length - 1; i2 >= 0; --i2) {
            genericCarAdjusterConfigData$ButtonDefinitionArray[i2] = new GenericCarAdjusterConfigData$ButtonDefinition(sArray[i2]);
        }
        this.this$0.setButtonDefinitions(genericCarAdjusterConfigData$ButtonDefinitionArray);
    }
}

