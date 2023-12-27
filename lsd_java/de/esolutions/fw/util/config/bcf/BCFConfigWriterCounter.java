/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Double
 */
package de.esolutions.fw.util.config.bcf;

import de.esolutions.fw.util.config.bcf.BCFStringPool;
import de.esolutions.fw.util.config.model.ConfigArray;
import de.esolutions.fw.util.config.model.ConfigDictionary;
import de.esolutions.fw.util.config.writer.IConfigExporter;

public class BCFConfigWriterCounter
implements IConfigExporter {
    private final boolean bits32;
    private final BCFStringPool pool;
    private int numElements;
    private int numElementDatas;

    public BCFConfigWriterCounter(boolean bl, BCFStringPool bCFStringPool) {
        this.bits32 = bl;
        this.pool = bCFStringPool;
    }

    public int getNumElementsPairs() {
        return this.numElements;
    }

    public int getNumElementDatas() {
        return this.numElementDatas;
    }

    public int size() {
        return this.numElements * 2 + this.numElementDatas;
    }

    private void countString(String string) {
        this.pool.addString(string);
    }

    @Override
    public void beginDictionary(ConfigDictionary configDictionary, int n) {
        ++this.numElements;
        this.numElementDatas += 2 + n;
        String[] stringArray = configDictionary.getAllDictKeys();
        for (int i2 = 0; i2 < stringArray.length; ++i2) {
            this.countString(stringArray[i2]);
        }
    }

    @Override
    public void endDictionary() {
    }

    @Override
    public void beginDictEntry(int n, String string) {
    }

    @Override
    public void endDictEntry(boolean bl) {
    }

    @Override
    public void beginArray(ConfigArray configArray, int n) {
        ++this.numElements;
        this.numElementDatas += 2;
    }

    @Override
    public void endArray() {
    }

    @Override
    public void beginArrayEntry(int n) {
    }

    @Override
    public void endArrayEntry(boolean bl) {
    }

    @Override
    public void writeString(String string) {
        ++this.numElements;
        this.countString(string);
    }

    @Override
    public void writeInteger(int n) {
        ++this.numElements;
        if (!(this.bits32 || n >= Short.MIN_VALUE && n <= Short.MAX_VALUE)) {
            String string = Integer.toString(n);
            this.countString(string);
        }
    }

    @Override
    public void writeDouble(double d2) {
        String string = Double.toString((double)d2);
        this.countString(string);
        ++this.numElements;
    }

    @Override
    public void writeNull() {
        ++this.numElements;
    }

    @Override
    public void writeBoolean(boolean bl) {
        ++this.numElements;
    }
}

