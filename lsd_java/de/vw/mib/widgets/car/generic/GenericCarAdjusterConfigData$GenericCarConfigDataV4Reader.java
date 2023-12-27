/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets.car.generic;

import de.vw.mib.widgets.car.generic.GenericCarAdjusterConfigData;
import de.vw.mib.widgets.car.generic.GenericCarAdjusterConfigData$BackgroundDefinitionReader;
import de.vw.mib.widgets.car.generic.GenericCarAdjusterConfigData$ButtonDefinitionDefinitionReader;
import de.vw.mib.widgets.car.generic.GenericCarAdjusterConfigData$GenericCarConfigDataReader;
import de.vw.mib.widgets.car.generic.GenericCarAdjusterConfigData$ImageDefinitionReader;
import java.io.InputStream;

class GenericCarAdjusterConfigData$GenericCarConfigDataV4Reader
implements GenericCarAdjusterConfigData$GenericCarConfigDataReader {
    private GenericCarAdjusterConfigData$GenericCarConfigDataReader[] readerList;
    private final /* synthetic */ GenericCarAdjusterConfigData this$0;

    public GenericCarAdjusterConfigData$GenericCarConfigDataV4Reader(GenericCarAdjusterConfigData genericCarAdjusterConfigData) {
        this.this$0 = genericCarAdjusterConfigData;
        this.initReader();
    }

    protected void initReader() {
        this.readerList = new GenericCarAdjusterConfigData$GenericCarConfigDataReader[3];
        this.readerList[0] = new GenericCarAdjusterConfigData$ButtonDefinitionDefinitionReader(this.this$0);
        this.readerList[1] = new GenericCarAdjusterConfigData$ImageDefinitionReader(this.this$0);
        this.readerList[2] = new GenericCarAdjusterConfigData$BackgroundDefinitionReader(this.this$0);
    }

    @Override
    public void deserialize(InputStream inputStream) {
        for (int i2 = 0; i2 < this.readerList.length; ++i2) {
            this.readerList[i2].deserialize(inputStream);
        }
    }
}

