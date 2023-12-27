/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.util.config.bcf;

import de.esolutions.fw.util.config.bcf.BCFStringPool;
import de.esolutions.fw.util.config.model.ConfigArray;
import de.esolutions.fw.util.config.model.ConfigDictionary;
import de.esolutions.fw.util.config.writer.IConfigExporter;
import java.util.Stack;

public class BCFConfigWriterElements
implements IConfigExporter {
    private final Stack stack = new Stack();
    private final int[] elements;
    private final int numElementPairs;
    private final int numData;
    private final BCFStringPool strPool;
    private final boolean bits32;
    int elementUsage;
    int dataUsage;
    int stringUsage;

    public BCFConfigWriterElements(int n, int n2, BCFStringPool bCFStringPool, boolean bl) {
        this.stack.push(new Integer(0));
        this.numElementPairs = n;
        this.numData = n2;
        this.strPool = bCFStringPool;
        this.bits32 = bl;
        int n3 = n * 2 + n2;
        this.elements = new int[n3];
        this.elementUsage = 2;
        this.dataUsage = 0;
        this.stringUsage = 0;
    }

    public boolean checkEnd() {
        if (this.elementUsage != this.numElementPairs * 2) {
            return false;
        }
        if (this.dataUsage != this.numData) {
            return false;
        }
        return this.stack.size() == 1;
    }

    public int[] getTotalElements() {
        return this.elements;
    }

    private int nextPos() {
        int n = (Integer)this.stack.pop();
        this.stack.push(new Integer(n + 2));
        return n;
    }

    private int pushPos(int n) {
        int n2 = this.elementUsage;
        this.stack.push(new Integer(n2));
        this.elementUsage += n * 2;
        return n2;
    }

    private void popPos() {
        this.stack.pop();
    }

    private int reserveData(int n) {
        int n2 = this.numElementPairs * 2 + this.dataUsage;
        this.dataUsage += n;
        return n2;
    }

    private int nextStringOffset() {
        int n = this.stringUsage++;
        int n2 = this.strPool.getStringOffset(n);
        return n2;
    }

    @Override
    public void beginDictionary(ConfigDictionary configDictionary, int n) {
        int n2;
        int n3 = this.nextPos();
        this.elements[n3] = 1;
        this.elements[n3 + 1] = n2 = this.reserveData(n + 2);
        int n4 = this.pushPos(n);
        this.elements[n2] = n;
        this.elements[n2 + 1] = n4 / 2;
        int n5 = n2 + 2;
        for (int i2 = 0; i2 < n; ++i2) {
            int n6;
            this.elements[n5 + i2] = n6 = this.nextStringOffset();
        }
    }

    @Override
    public void endDictionary() {
        this.popPos();
    }

    @Override
    public void beginDictEntry(int n, String string) {
    }

    @Override
    public void endDictEntry(boolean bl) {
    }

    @Override
    public void beginArray(ConfigArray configArray, int n) {
        int n2;
        int n3 = this.nextPos();
        this.elements[n3] = 2;
        this.elements[n3 + 1] = n2 = this.reserveData(2);
        int n4 = this.pushPos(n);
        this.elements[n2] = n;
        this.elements[n2 + 1] = n4 / 2;
    }

    @Override
    public void endArray() {
        this.popPos();
    }

    @Override
    public void beginArrayEntry(int n) {
    }

    @Override
    public void endArrayEntry(boolean bl) {
    }

    @Override
    public void writeString(String string) {
        int n = this.nextPos();
        this.elements[n] = 9;
        this.elements[n + 1] = this.nextStringOffset();
    }

    @Override
    public void writeInteger(int n) {
        int n2 = this.nextPos();
        boolean bl = false;
        if (!(this.bits32 || n >= Short.MIN_VALUE && n <= Short.MAX_VALUE)) {
            bl = true;
        }
        this.elements[n2] = bl ? 4 : 3;
        this.elements[n2 + 1] = bl ? this.nextStringOffset() : n;
    }

    @Override
    public void writeDouble(double d2) {
        int n = this.nextPos();
        this.elements[n] = 5;
        this.elements[n + 1] = this.nextStringOffset();
    }

    @Override
    public void writeNull() {
        int n = this.nextPos();
        this.elements[n] = 8;
        this.elements[n + 1] = 0;
    }

    @Override
    public void writeBoolean(boolean bl) {
        int n = this.nextPos();
        this.elements[n] = bl ? 6 : 7;
        this.elements[n + 1] = 0;
    }
}

