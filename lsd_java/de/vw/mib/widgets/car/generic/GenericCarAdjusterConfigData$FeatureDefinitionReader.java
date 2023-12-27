/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets.car.generic;

import de.vw.mib.widgets.car.generic.GenericCarAdjusterConfigData;
import de.vw.mib.widgets.car.generic.GenericCarAdjusterConfigData$GenericCarConfigDataReader;
import java.io.InputStream;

class GenericCarAdjusterConfigData$FeatureDefinitionReader
implements GenericCarAdjusterConfigData$GenericCarConfigDataReader {
    private final /* synthetic */ GenericCarAdjusterConfigData this$0;

    GenericCarAdjusterConfigData$FeatureDefinitionReader(GenericCarAdjusterConfigData genericCarAdjusterConfigData) {
        this.this$0 = genericCarAdjusterConfigData;
    }

    @Override
    public void deserialize(InputStream inputStream) {
        this.readFeatureDefinitions(inputStream);
    }

    private void readFeatureDefinitions(InputStream inputStream) {
        this.this$0.getShort(inputStream);
    }
}

