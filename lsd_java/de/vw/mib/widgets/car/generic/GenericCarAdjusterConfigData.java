/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets.car.generic;

import de.vw.mib.collections.ints.IntIntMultimap;
import de.vw.mib.collections.ints.IntObjectMap;
import de.vw.mib.collections.ints.IntObjectMap$Entry;
import de.vw.mib.collections.ints.IntObjectOptHashMap;
import de.vw.mib.graphics.Point;
import de.vw.mib.util.StringBuilder;
import de.vw.mib.widgets.SkinHelper;
import de.vw.mib.widgets.car.AbstractConfigData;
import de.vw.mib.widgets.car.generic.GenericCarAdjusterConfigData$ButtonDefinition;
import de.vw.mib.widgets.car.generic.GenericCarAdjusterConfigData$GenericCarConfigDataReader;
import de.vw.mib.widgets.car.generic.GenericCarAdjusterConfigData$GenericCarConfigDataV4Reader;
import java.io.InputStream;
import java.util.Iterator;

public class GenericCarAdjusterConfigData
extends AbstractConfigData {
    private static final short MINIMAL_VERSION;
    public static final int INVALID_ID;
    private IntIntMultimap imageDefinitions;
    private IntIntMultimap backgroundDefinitions;
    private IntObjectMap buttonDefinitions;
    private GenericCarAdjusterConfigData$GenericCarConfigDataReader reader;

    public GenericCarAdjusterConfigData(String string, int n) {
        super(new StringBuilder(256).append(SkinHelper.getDataPath(5)).append(string).append("/").append(n).append(".gca").toString(), (short)4, (short)4, 6);
    }

    @Override
    protected void deserialize(InputStream inputStream) {
        this.createReader();
        this.readHeader(inputStream);
        this.readData(inputStream);
    }

    private void createReader() {
        this.reader = new GenericCarAdjusterConfigData$GenericCarConfigDataV4Reader(this);
    }

    private void readHeader(InputStream inputStream) {
        short s = this.getShort(inputStream, 4);
        this.onConfigFileLengthChanged(s);
        inputStream.skip(0);
    }

    private void readData(InputStream inputStream) {
        this.reader.deserialize(inputStream);
    }

    void setImageDefinitions(short[][] sArray) {
        if (this.imageDefinitions == null) {
            this.imageDefinitions = new IntIntMultimap();
        } else {
            this.imageDefinitions.clear();
        }
        this.fillMultimap(this.imageDefinitions, sArray);
    }

    void setButtonDefinitions(GenericCarAdjusterConfigData$ButtonDefinition[] genericCarAdjusterConfigData$ButtonDefinitionArray) {
        if (this.buttonDefinitions == null) {
            this.buttonDefinitions = new IntObjectOptHashMap(genericCarAdjusterConfigData$ButtonDefinitionArray.length);
        } else {
            this.buttonDefinitions.clear();
        }
        for (int i2 = 0; i2 < genericCarAdjusterConfigData$ButtonDefinitionArray.length; ++i2) {
            this.buttonDefinitions.put(i2, genericCarAdjusterConfigData$ButtonDefinitionArray[i2]);
        }
    }

    void setBackgroundDefinitions(short[][] sArray) {
        if (this.backgroundDefinitions == null) {
            this.backgroundDefinitions = new IntIntMultimap();
        } else {
            this.backgroundDefinitions.clear();
        }
        this.fillMultimap(this.backgroundDefinitions, sArray);
    }

    public int getButtonDefinitionCount() {
        if (this.buttonDefinitions == null) {
            return 0;
        }
        return this.buttonDefinitions.size();
    }

    public int getImageDefinitionCount() {
        if (this.imageDefinitions == null) {
            return 0;
        }
        return this.imageDefinitions.keySet().size();
    }

    public Point[] getButtonVertices(int n) {
        if (this.buttonDefinitions == null || !this.buttonDefinitions.containsKey(n)) {
            return null;
        }
        return ((GenericCarAdjusterConfigData$ButtonDefinition)this.buttonDefinitions.get(n)).getVertices();
    }

    public int getButtonId(int n) {
        if (this.buttonDefinitions == null || !this.buttonDefinitions.containsKey(n)) {
            return -1;
        }
        return ((GenericCarAdjusterConfigData$ButtonDefinition)this.buttonDefinitions.get(n)).getId();
    }

    public int getButtonIndex(int n) {
        if (this.buttonDefinitions == null) {
            return -1;
        }
        Iterator iterator = this.buttonDefinitions.entryIterator();
        while (iterator.hasNext()) {
            IntObjectMap$Entry intObjectMap$Entry = (IntObjectMap$Entry)iterator.next();
            GenericCarAdjusterConfigData$ButtonDefinition genericCarAdjusterConfigData$ButtonDefinition = (GenericCarAdjusterConfigData$ButtonDefinition)intObjectMap$Entry.getValue();
            if (genericCarAdjusterConfigData$ButtonDefinition.getId() != n) continue;
            return intObjectMap$Entry.getKey();
        }
        return -1;
    }

    public int getCorrespondingAspectIdForButton(int n) {
        if (this.buttonDefinitions == null || !this.buttonDefinitions.containsKey(n)) {
            return -1;
        }
        return ((GenericCarAdjusterConfigData$ButtonDefinition)this.buttonDefinitions.get(n)).getAspectId();
    }

    public int getButtonImageX(int n) {
        if (this.buttonDefinitions == null || !this.buttonDefinitions.containsKey(n)) {
            return 0;
        }
        return ((GenericCarAdjusterConfigData$ButtonDefinition)this.buttonDefinitions.get(n)).getImagePosition().getX();
    }

    public int getButtonImageY(int n) {
        if (this.buttonDefinitions == null || !this.buttonDefinitions.containsKey(n)) {
            return 0;
        }
        return ((GenericCarAdjusterConfigData$ButtonDefinition)this.buttonDefinitions.get(n)).getImagePosition().getY();
    }

    public int getCorrespondingFeatureIdForImage(int n) {
        return this.imageDefinitions.getAll(n).toArray()[1];
    }

    public int getImageId(int n) {
        return this.imageDefinitions.getAll(n).toArray()[0];
    }

    public int getImagePosX(int n) {
        return this.imageDefinitions.getAll(n).toArray()[2];
    }

    public int getImagePosY(int n) {
        return this.imageDefinitions.getAll(n).toArray()[3];
    }

    public int getBackgroundDefinitionCount() {
        return this.backgroundDefinitions.keySet().size();
    }

    public int getBackgroundId(int n) {
        return this.backgroundDefinitions.getAll(n).toArray()[0];
    }

    public int getBackgroundPosX(int n) {
        return this.backgroundDefinitions.getAll(n).toArray()[2];
    }

    public int getBackgroundPosY(int n) {
        return this.backgroundDefinitions.getAll(n).toArray()[3];
    }

    public int getBackgroundScale(int n) {
        return this.backgroundDefinitions.getAll(n).toArray()[4];
    }

    public int getCorrespondingAspectIdForBackground(int n) {
        return this.backgroundDefinitions.getAll(n).toArray()[1];
    }
}

