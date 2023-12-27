/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal;

import de.vw.mib.asl.ASLPropertyManager;
import de.vw.mib.collections.ints.IntBooleanMap;
import de.vw.mib.collections.ints.IntBooleanOptHashMap;
import de.vw.mib.collections.ints.IntIntMap;
import de.vw.mib.collections.ints.IntIntOptHashMap;
import de.vw.mib.collections.ints.IntIterator;
import de.vw.mib.collections.ints.IntLongMap;
import de.vw.mib.collections.ints.IntLongOptHashMap;
import de.vw.mib.collections.ints.IntObjectMap;
import de.vw.mib.collections.ints.IntObjectOptHashMap;
import de.vw.mib.datapool.ASLDatapool;
import de.vw.mib.properties.values.FixFormatterFieldData;
import de.vw.mib.properties.values.LabeledIconValue;
import de.vw.mib.properties.values.SpellerData;
import org.dsi.ifc.global.ResourceLocator;

public class ASLDatapoolManager
implements ASLPropertyManager {
    private ASLDatapool datapool;
    private IntBooleanMap booleanBuffer;
    private IntIntMap intBuffer;
    private IntLongMap longBuffer;
    private IntObjectMap flagVectorBuffer;
    private IntObjectMap intArrayBuffer;
    private IntObjectMap labeledIconBuffer;
    private IntObjectMap resourceLocatorBuffer;
    private IntObjectMap spellerDataBuffer;
    private IntObjectMap stringBuffer;
    private IntObjectMap stringVectorBuffer;
    private IntObjectMap fixFormatterFieldDataBuffer;

    public ASLDatapoolManager() {
    }

    public ASLDatapoolManager(ASLDatapool aSLDatapool) {
        this.datapool = aSLDatapool;
    }

    public void setDatapool(ASLDatapool aSLDatapool) {
        this.datapool = aSLDatapool;
        if (null != this.datapool) {
            this.flushBuffers();
        }
    }

    private void flushBuffers() {
        int n;
        IntIterator intIterator;
        if (this.booleanBuffer != null) {
            intIterator = this.booleanBuffer.keySet().iterator();
            while (intIterator.hasNext()) {
                n = intIterator.next();
                boolean bl = this.booleanBuffer.get(n);
                this.datapool.setBoolean(n, bl);
            }
            this.booleanBuffer.clear();
            this.booleanBuffer = null;
        }
        if (this.flagVectorBuffer != null) {
            intIterator = this.flagVectorBuffer.keySet().iterator();
            while (intIterator.hasNext()) {
                n = intIterator.next();
                boolean[] blArray = (boolean[])this.flagVectorBuffer.get(n);
                this.datapool.setFlagVector(n, blArray);
            }
            this.flagVectorBuffer.clear();
            this.flagVectorBuffer = null;
        }
        if (this.intBuffer != null) {
            intIterator = this.intBuffer.keySet().iterator();
            while (intIterator.hasNext()) {
                n = intIterator.next();
                int n2 = this.intBuffer.get(n);
                this.datapool.setInteger(n, n2);
            }
            this.intBuffer.clear();
            this.intBuffer = null;
        }
        if (this.intArrayBuffer != null) {
            intIterator = this.intArrayBuffer.keySet().iterator();
            while (intIterator.hasNext()) {
                n = intIterator.next();
                int[] nArray = (int[])this.intArrayBuffer.get(n);
                this.datapool.setIntegerArray(n, nArray);
            }
            this.intArrayBuffer.clear();
            this.intArrayBuffer = null;
        }
        if (this.labeledIconBuffer != null) {
            intIterator = this.labeledIconBuffer.keySet().iterator();
            while (intIterator.hasNext()) {
                n = intIterator.next();
                LabeledIconValue labeledIconValue = (LabeledIconValue)this.labeledIconBuffer.get(n);
                this.datapool.setLabeledIconValue(n, labeledIconValue);
            }
            this.labeledIconBuffer.clear();
            this.labeledIconBuffer = null;
        }
        if (this.longBuffer != null) {
            intIterator = this.longBuffer.keySet().iterator();
            while (intIterator.hasNext()) {
                n = intIterator.next();
                long l = this.longBuffer.get(n);
                this.datapool.setLong(n, l);
            }
            this.longBuffer.clear();
            this.longBuffer = null;
        }
        if (this.resourceLocatorBuffer != null) {
            intIterator = this.resourceLocatorBuffer.keySet().iterator();
            while (intIterator.hasNext()) {
                n = intIterator.next();
                ResourceLocator resourceLocator = (ResourceLocator)this.resourceLocatorBuffer.get(n);
                this.datapool.setResourceLocator(n, resourceLocator);
            }
            this.resourceLocatorBuffer.clear();
            this.resourceLocatorBuffer = null;
        }
        if (this.spellerDataBuffer != null) {
            intIterator = this.spellerDataBuffer.keySet().iterator();
            while (intIterator.hasNext()) {
                n = intIterator.next();
                SpellerData spellerData = (SpellerData)this.spellerDataBuffer.get(n);
                this.datapool.setSpellerData(n, spellerData);
            }
            this.spellerDataBuffer.clear();
            this.spellerDataBuffer = null;
        }
        if (this.stringBuffer != null) {
            intIterator = this.stringBuffer.keySet().iterator();
            while (intIterator.hasNext()) {
                n = intIterator.next();
                String string = (String)this.stringBuffer.get(n);
                this.datapool.setString(n, string);
            }
            this.stringBuffer.clear();
            this.stringBuffer = null;
        }
        if (this.stringVectorBuffer != null) {
            intIterator = this.stringVectorBuffer.keySet().iterator();
            while (intIterator.hasNext()) {
                n = intIterator.next();
                String[] stringArray = (String[])this.stringVectorBuffer.get(n);
                this.datapool.setStringVector(n, stringArray);
            }
            this.stringVectorBuffer.clear();
            this.stringVectorBuffer = null;
        }
        if (this.fixFormatterFieldDataBuffer != null) {
            intIterator = this.fixFormatterFieldDataBuffer.keySet().iterator();
            while (intIterator.hasNext()) {
                n = intIterator.next();
                FixFormatterFieldData fixFormatterFieldData = (FixFormatterFieldData)this.fixFormatterFieldDataBuffer.get(n);
                this.datapool.setFixFormatterFieldData(n, fixFormatterFieldData);
            }
            this.fixFormatterFieldDataBuffer.clear();
            this.fixFormatterFieldDataBuffer = null;
        }
    }

    @Override
    public void valueChangedBoolean(int n, boolean bl) {
        if (this.datapool == null) {
            if (this.booleanBuffer == null) {
                this.booleanBuffer = new IntBooleanOptHashMap();
            }
            this.booleanBuffer.put(n, bl);
        } else {
            this.datapool.setBoolean(n, bl);
        }
    }

    @Override
    public void valueChangedFlagVector(int n, boolean[] blArray) {
        if (this.datapool == null) {
            if (this.flagVectorBuffer == null) {
                this.flagVectorBuffer = new IntObjectOptHashMap();
            }
            this.flagVectorBuffer.put(n, blArray);
        } else {
            this.datapool.setFlagVector(n, blArray);
        }
    }

    @Override
    public void valueChangedInteger(int n, int n2) {
        if (this.datapool == null) {
            if (this.intBuffer == null) {
                this.intBuffer = new IntIntOptHashMap();
            }
            this.intBuffer.put(n, n2);
        } else {
            this.datapool.setInteger(n, n2);
        }
    }

    @Override
    public void valueChangedIntegerArray(int n, int[] nArray) {
        if (this.datapool == null) {
            if (this.intArrayBuffer == null) {
                this.intArrayBuffer = new IntObjectOptHashMap();
            }
            this.intArrayBuffer.put(n, nArray);
        } else {
            this.datapool.setIntegerArray(n, nArray);
        }
    }

    @Override
    public void valueChangedLabeledIcon(int n, LabeledIconValue labeledIconValue) {
        if (this.datapool == null) {
            if (this.labeledIconBuffer == null) {
                this.labeledIconBuffer = new IntObjectOptHashMap();
            }
            this.labeledIconBuffer.put(n, labeledIconValue);
        } else {
            this.datapool.setLabeledIconValue(n, labeledIconValue);
        }
    }

    @Override
    public void valueChangedLong(int n, long l) {
        if (this.datapool == null) {
            if (this.longBuffer == null) {
                this.longBuffer = new IntLongOptHashMap();
            }
            this.longBuffer.put(n, l);
        } else {
            this.datapool.setLong(n, l);
        }
    }

    @Override
    public void valueChangedResourceLocator(int n, ResourceLocator resourceLocator) {
        if (this.datapool == null) {
            if (this.resourceLocatorBuffer == null) {
                this.resourceLocatorBuffer = new IntObjectOptHashMap();
            }
            this.resourceLocatorBuffer.put(n, resourceLocator);
        } else {
            this.datapool.setResourceLocator(n, resourceLocator);
        }
    }

    @Override
    public void valueChangedSpellerData(int n, SpellerData spellerData) {
        if (this.datapool == null) {
            if (this.spellerDataBuffer == null) {
                this.spellerDataBuffer = new IntObjectOptHashMap();
            }
            this.spellerDataBuffer.put(n, spellerData);
        } else {
            this.datapool.setSpellerData(n, spellerData);
        }
    }

    @Override
    public void valueChangedString(int n, String string) {
        if (this.datapool == null) {
            if (this.stringBuffer == null) {
                this.stringBuffer = new IntObjectOptHashMap();
            }
            this.stringBuffer.put(n, string);
        } else {
            this.datapool.setString(n, string);
        }
    }

    @Override
    public void valueChangedStringVector(int n, String[] stringArray) {
        if (this.datapool == null) {
            if (this.stringVectorBuffer == null) {
                this.stringVectorBuffer = new IntObjectOptHashMap();
            }
            this.stringVectorBuffer.put(n, stringArray);
        } else {
            this.datapool.setStringVector(n, stringArray);
        }
    }

    @Override
    public void valueChangedFixFormatterFieldData(int n, FixFormatterFieldData fixFormatterFieldData) {
        if (this.datapool == null) {
            if (this.fixFormatterFieldDataBuffer == null) {
                this.fixFormatterFieldDataBuffer = new IntObjectOptHashMap();
            }
            this.fixFormatterFieldDataBuffer.put(n, fixFormatterFieldData);
        } else {
            this.datapool.setFixFormatterFieldData(n, fixFormatterFieldData);
        }
    }
}

