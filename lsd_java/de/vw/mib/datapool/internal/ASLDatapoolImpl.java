/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.datapool.internal;

import de.vw.mib.collections.copyonwrite.CowArray;
import de.vw.mib.collections.ints.IntLongMap;
import de.vw.mib.collections.ints.IntLongOptHashMap;
import de.vw.mib.collections.ints.IntObjectMap;
import de.vw.mib.collections.ints.IntObjectOptHashMap;
import de.vw.mib.datapool.ASLDatapool;
import de.vw.mib.datapool.ASLDatapoolIdMap;
import de.vw.mib.datapool.ASLDatapoolObserver;
import de.vw.mib.datapool.internal.AbstractDatapool;
import de.vw.mib.graphics.image.Image;
import de.vw.mib.properties.values.FixFormatterFieldData;
import de.vw.mib.properties.values.LabeledIconValue;
import de.vw.mib.properties.values.SpellerData;
import org.dsi.ifc.global.ResourceLocator;

public final class ASLDatapoolImpl
implements ASLDatapool {
    private final AbstractDatapool datapool;
    private final ASLDatapoolIdMap idMap;
    private final IntObjectMap observersMap = new IntObjectOptHashMap();
    private final IntLongMap primitiveValues = new IntLongOptHashMap();
    private final IntObjectMap objectValues = new IntObjectOptHashMap();

    public ASLDatapoolImpl(AbstractDatapool abstractDatapool, ASLDatapoolIdMap aSLDatapoolIdMap) {
        this.datapool = abstractDatapool;
        this.idMap = aSLDatapoolIdMap;
    }

    @Override
    public boolean getBoolean(int n) {
        if (this.primitiveValues.containsKey(n)) {
            return this.primitiveValues.get(n) != 0L;
        }
        return this.datapool.getBoolean(this.getPropertyIdForBoolean(n));
    }

    @Override
    public boolean getBoolean(int n, boolean bl) {
        if (this.primitiveValues.containsKey(n)) {
            return this.primitiveValues.get(n) != 0L;
        }
        int n2 = this.idMap.getPropertyId(n);
        if (this.datapool.containsBoolean(n2)) {
            return this.datapool.getBoolean(n2);
        }
        this.datapool.setBoolean_internal(n2, bl);
        return bl;
    }

    @Override
    public FixFormatterFieldData getFixFormatterFieldData(int n) {
        if (this.objectValues.containsKey(n)) {
            return (FixFormatterFieldData)this.objectValues.get(n);
        }
        return this.datapool.getFixFormatterFieldData(this.getPropertyId(n));
    }

    @Override
    public FixFormatterFieldData getFixFormatterFieldData(int n, FixFormatterFieldData fixFormatterFieldData) {
        if (this.objectValues.containsKey(n)) {
            return (FixFormatterFieldData)this.objectValues.get(n);
        }
        int n2 = this.idMap.getPropertyId(n);
        if (this.datapool.containsObject(n2)) {
            return this.datapool.getFixFormatterFieldData(n2);
        }
        this.datapool.setObjectValue_internal(n2, fixFormatterFieldData);
        return fixFormatterFieldData;
    }

    @Override
    public boolean[] getFlagVector(int n) {
        if (this.objectValues.containsKey(n)) {
            return (boolean[])this.objectValues.get(n);
        }
        return this.datapool.getFlagVector(this.getPropertyId(n));
    }

    @Override
    public boolean[] getFlagVector(int n, boolean[] blArray) {
        if (this.objectValues.containsKey(n)) {
            return (boolean[])this.objectValues.get(n);
        }
        int n2 = this.idMap.getPropertyId(n);
        if (this.datapool.containsObject(n2)) {
            return this.datapool.getFlagVector(n2);
        }
        this.datapool.setObjectValue_internal(n2, blArray);
        return blArray;
    }

    @Override
    public float getFloat(int n) {
        if (this.primitiveValues.containsKey(n)) {
            return Float.intBitsToFloat((int)this.primitiveValues.get(n));
        }
        return this.datapool.getFloat(this.getPropertyIdForFloat(n));
    }

    @Override
    public float getFloat(int n, float f2) {
        if (this.primitiveValues.containsKey(n)) {
            return Float.intBitsToFloat((int)this.primitiveValues.get(n));
        }
        int n2 = this.idMap.getPropertyId(n);
        if (this.datapool.containsFloat(n2)) {
            return this.datapool.getFloat(n2);
        }
        this.datapool.setFloat_internal(n2, f2);
        return f2;
    }

    @Override
    public Image[] getImageVector(int n) {
        if (this.objectValues.containsKey(n)) {
            return (Image[])this.objectValues.get(n);
        }
        return this.datapool.getImageVector(this.getPropertyId(n));
    }

    @Override
    public Image[] getImageVector(int n, Image[] imageArray) {
        if (this.objectValues.containsKey(n)) {
            return (Image[])this.objectValues.get(n);
        }
        int n2 = this.idMap.getPropertyId(n);
        if (this.datapool.containsObject(n2)) {
            return this.datapool.getImageVector(n2);
        }
        this.datapool.setObjectValue_internal(n2, imageArray);
        return imageArray;
    }

    @Override
    public int getInteger(int n) {
        if (this.primitiveValues.containsKey(n)) {
            return (int)this.primitiveValues.get(n);
        }
        return this.datapool.getInteger(this.getPropertyIdForInteger(n));
    }

    @Override
    public int getInteger(int n, int n2) {
        if (this.primitiveValues.containsKey(n)) {
            return (int)this.primitiveValues.get(n);
        }
        int n3 = this.idMap.getPropertyId(n);
        if (this.datapool.containsInteger(n3)) {
            return this.datapool.getInteger(n3);
        }
        this.datapool.setInteger_internal(n3, n2);
        return n2;
    }

    @Override
    public int[] getIntegerArray(int n) {
        if (this.objectValues.containsKey(n)) {
            return (int[])this.objectValues.get(n);
        }
        return this.datapool.getIntegerArray(this.getPropertyId(n));
    }

    @Override
    public int[] getIntegerArray(int n, int[] nArray) {
        if (this.objectValues.containsKey(n)) {
            return (int[])this.objectValues.get(n);
        }
        int n2 = this.idMap.getPropertyId(n);
        if (this.datapool.containsObject(n2)) {
            return this.datapool.getIntegerArray(n2);
        }
        this.datapool.setObjectValue_internal(n2, nArray);
        return nArray;
    }

    @Override
    public int[] getIntegerVector(int n) {
        if (this.objectValues.containsKey(n)) {
            return (int[])this.objectValues.get(n);
        }
        return this.datapool.getIntegerVector(this.getPropertyId(n));
    }

    @Override
    public int[] getIntegerVector(int n, int[] nArray) {
        if (this.objectValues.containsKey(n)) {
            return (int[])this.objectValues.get(n);
        }
        int n2 = this.idMap.getPropertyId(n);
        if (this.datapool.containsObject(n2)) {
            return this.datapool.getIntegerVector(n2);
        }
        this.datapool.setObjectValue_internal(n2, nArray);
        return nArray;
    }

    @Override
    public LabeledIconValue getLabeledIconValue(int n) {
        if (this.objectValues.containsKey(n)) {
            return (LabeledIconValue)this.objectValues.get(n);
        }
        return this.datapool.getLabeledIconValue(this.getPropertyId(n));
    }

    @Override
    public LabeledIconValue getLabeledIconValue(int n, LabeledIconValue labeledIconValue) {
        if (this.objectValues.containsKey(n)) {
            return (LabeledIconValue)this.objectValues.get(n);
        }
        int n2 = this.idMap.getPropertyId(n);
        if (this.datapool.containsObject(n2)) {
            return this.datapool.getLabeledIconValue(n2);
        }
        this.datapool.setObjectValue_internal(n2, labeledIconValue);
        return labeledIconValue;
    }

    @Override
    public long getLong(int n) {
        if (this.primitiveValues.containsKey(n)) {
            return this.primitiveValues.get(n);
        }
        return this.datapool.getLong(this.getPropertyIdForLong(n));
    }

    @Override
    public long getLong(int n, long l) {
        if (this.primitiveValues.containsKey(n)) {
            return this.primitiveValues.get(n);
        }
        int n2 = this.idMap.getPropertyId(n);
        if (this.datapool.containsLong(n2)) {
            return this.datapool.getLong(n2);
        }
        this.datapool.setLong_internal(n2, l);
        return l;
    }

    @Override
    public ResourceLocator getResourceLocator(int n) {
        if (this.objectValues.containsKey(n)) {
            return (ResourceLocator)this.objectValues.get(n);
        }
        return this.datapool.getResourceLocator(this.getPropertyId(n));
    }

    @Override
    public ResourceLocator getResourceLocator(int n, ResourceLocator resourceLocator) {
        if (this.objectValues.containsKey(n)) {
            return (ResourceLocator)this.objectValues.get(n);
        }
        int n2 = this.idMap.getPropertyId(n);
        if (this.datapool.containsObject(n2)) {
            return this.datapool.getResourceLocator(n2);
        }
        this.datapool.setObjectValue_internal(n2, resourceLocator);
        return resourceLocator;
    }

    @Override
    public SpellerData getSpellerData(int n) {
        if (this.objectValues.containsKey(n)) {
            return (SpellerData)this.objectValues.get(n);
        }
        return this.datapool.getSpellerData(this.getPropertyId(n));
    }

    @Override
    public SpellerData getSpellerData(int n, SpellerData spellerData) {
        if (this.objectValues.containsKey(n)) {
            return (SpellerData)this.objectValues.get(n);
        }
        int n2 = this.idMap.getPropertyId(n);
        if (this.datapool.containsObject(n2)) {
            return this.datapool.getSpellerData(n2);
        }
        this.datapool.setObjectValue_internal(n2, spellerData);
        return spellerData;
    }

    @Override
    public String getString(int n) {
        if (this.objectValues.containsKey(n)) {
            return (String)this.objectValues.get(n);
        }
        return this.datapool.getString(this.getPropertyId(n));
    }

    @Override
    public String getString(int n, String string) {
        if (this.objectValues.containsKey(n)) {
            return (String)this.objectValues.get(n);
        }
        int n2 = this.idMap.getPropertyId(n);
        if (this.datapool.containsObject(n2)) {
            return this.datapool.getString(n2);
        }
        this.datapool.setObjectValue_internal(n2, string);
        return string;
    }

    @Override
    public String[] getStringVector(int n) {
        if (this.objectValues.containsKey(n)) {
            return (String[])this.objectValues.get(n);
        }
        return this.datapool.getStringVector(this.getPropertyId(n));
    }

    @Override
    public String[] getStringVector(int n, String[] stringArray) {
        if (this.objectValues.containsKey(n)) {
            return (String[])this.objectValues.get(n);
        }
        int n2 = this.idMap.getPropertyId(n);
        if (this.datapool.containsObject(n2)) {
            return this.datapool.getStringVector(n2);
        }
        this.datapool.setObjectValue_internal(n2, stringArray);
        return stringArray;
    }

    @Override
    public void registerObserver(int n, ASLDatapoolObserver aSLDatapoolObserver) {
        CowArray cowArray = (CowArray)this.observersMap.get(n);
        if (cowArray == null) {
            cowArray = new CowArray();
            this.observersMap.put(n, cowArray);
        }
        cowArray.add(aSLDatapoolObserver);
    }

    @Override
    public void setBoolean(int n, boolean bl) {
        this.datapool.setBoolean(this.getPropertyIdForBoolean(n), bl);
        if (this.hasObservers(n)) {
            this.primitiveValues.put(n, bl ? 1L : 0L);
            this.notifyObservers(n);
        }
    }

    @Override
    public void setFixFormatterFieldData(int n, FixFormatterFieldData fixFormatterFieldData) {
        this.datapool.setFixFormatterFieldData(this.getPropertyId(n), fixFormatterFieldData);
        if (this.hasObservers(n)) {
            this.objectValues.put(n, fixFormatterFieldData);
            this.notifyObservers(n);
        }
    }

    @Override
    public void setFlagVector(int n, boolean[] blArray) {
        this.datapool.setFlagVector(this.getPropertyId(n), blArray);
        if (this.hasObservers(n)) {
            this.objectValues.put(n, blArray);
            this.notifyObservers(n);
        }
    }

    @Override
    public void setFloat(int n, float f2) {
        this.datapool.setFloat(this.getPropertyIdForFloat(n), f2);
        if (this.hasObservers(n)) {
            this.primitiveValues.put(n, Float.floatToIntBits(f2));
            this.notifyObservers(n);
        }
    }

    @Override
    public void setImageVector(int n, Image[] imageArray) {
        this.datapool.setImageVector(this.getPropertyId(n), imageArray);
        if (this.hasObservers(n)) {
            this.objectValues.put(n, imageArray);
            this.notifyObservers(n);
        }
    }

    @Override
    public void setInteger(int n, int n2) {
        this.datapool.setInteger(this.getPropertyIdForInteger(n), n2);
        if (this.hasObservers(n)) {
            this.primitiveValues.put(n, n2);
            this.notifyObservers(n);
        }
    }

    @Override
    public void setIntegerArray(int n, int[] nArray) {
        this.datapool.setIntegerArray(this.getPropertyId(n), nArray);
        if (this.hasObservers(n)) {
            this.objectValues.put(n, nArray);
            this.notifyObservers(n);
        }
    }

    @Override
    public void setIntegerVector(int n, int[] nArray) {
        this.datapool.setIntegerVector(this.getPropertyId(n), nArray);
        if (this.hasObservers(n)) {
            this.objectValues.put(n, nArray);
            this.notifyObservers(n);
        }
    }

    @Override
    public void setLabeledIconValue(int n, LabeledIconValue labeledIconValue) {
        this.datapool.setLabeledIconValue(this.getPropertyId(n), labeledIconValue);
        if (this.hasObservers(n)) {
            this.objectValues.put(n, labeledIconValue);
            this.notifyObservers(n);
        }
    }

    @Override
    public void setLong(int n, long l) {
        this.datapool.setLong(this.getPropertyIdForLong(n), l);
        if (this.hasObservers(n)) {
            this.primitiveValues.put(n, l);
            this.notifyObservers(n);
        }
    }

    @Override
    public void setResourceLocator(int n, ResourceLocator resourceLocator) {
        this.datapool.setResourceLocator(this.getPropertyId(n), resourceLocator);
        if (this.hasObservers(n)) {
            this.objectValues.put(n, resourceLocator);
            this.notifyObservers(n);
        }
    }

    @Override
    public void setSpellerData(int n, SpellerData spellerData) {
        this.datapool.setSpellerData(this.getPropertyId(n), spellerData);
        if (this.hasObservers(n)) {
            this.objectValues.put(n, spellerData);
            this.notifyObservers(n);
        }
    }

    @Override
    public void setString(int n, String string) {
        if (string == null) {
            string = "";
        }
        this.datapool.setString(this.getPropertyId(n), string);
        if (this.hasObservers(n)) {
            this.objectValues.put(n, string);
            this.notifyObservers(n);
        }
    }

    @Override
    public void setStringVector(int n, String[] stringArray) {
        this.datapool.setStringVector(this.getPropertyId(n), stringArray);
        if (this.hasObservers(n)) {
            this.objectValues.put(n, stringArray);
            this.notifyObservers(n);
        }
    }

    @Override
    public void unregisterObserver(int n, ASLDatapoolObserver aSLDatapoolObserver) {
        CowArray cowArray = (CowArray)this.observersMap.get(n);
        if (cowArray == null) {
            return;
        }
        cowArray.remove(aSLDatapoolObserver);
        if (cowArray.size() > 0) {
            return;
        }
        this.observersMap.remove(n);
    }

    private int getPropertyIdForBoolean(int n) {
        return this.idMap.getPropertyId(n);
    }

    private int getPropertyIdForFloat(int n) {
        return this.idMap.getPropertyId(n);
    }

    private int getPropertyIdForInteger(int n) {
        return this.idMap.getPropertyId(n);
    }

    private int getPropertyIdForLong(int n) {
        return this.idMap.getPropertyId(n);
    }

    private int getPropertyId(int n) {
        return this.idMap.getPropertyId(n);
    }

    private boolean hasObservers(int n) {
        return this.observersMap.containsKey(n);
    }

    private void notifyObservers(int n) {
        CowArray cowArray = (CowArray)this.observersMap.get(n);
        if (cowArray == null) {
            return;
        }
        Object[] objectArray = cowArray.getArray();
        for (int i2 = objectArray.length - 1; i2 >= 0; --i2) {
            ((ASLDatapoolObserver)objectArray[i2]).datapoolValueChanged(n);
        }
    }
}

