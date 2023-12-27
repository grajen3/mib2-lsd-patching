/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.dynamicresourcedata.internal;

import de.vw.mib.dynamicresourcedata.DynamicResourceData;
import de.vw.mib.dynamicresourcedata.DynamicResourceDataDescription;
import de.vw.mib.dynamicresourcedata.internal.DynamicResourceDataImpl;
import de.vw.mib.log4mib.Logger;
import edu.emory.mathcs.backport.java.util.Arrays;

public class DynamicResourceDataDescriptionImpl
implements DynamicResourceDataDescription {
    static final int MAIN_INDEX_HEADER;
    static final int HEADER_INDEX_MAGIC;
    static final int HEADER_INDEX_VERSION;
    static final int HEADER_INDEX_CINPUTCOUNT;
    static final int HEADER_INDEX_COUTPUTCOUNT;
    static final int MAIN_INDEX_CNAMES;
    static final int MAIN_INDEX_ANYNULL;
    static final int MAIN_INDEX_DATAOFFSET;
    private final String resourceName;
    final Logger logger;
    final Object[] objects;
    final DynamicResourceDataImpl imageCache;
    final DynamicResourceDataImpl colorCache;
    int[] input2any;
    int[] output2null;
    int inputFieldIdx;
    int outputFieldIdx;
    private final String[] registeredFields;

    DynamicResourceDataDescriptionImpl(String string, Logger logger, Object[] objectArray, DynamicResourceData dynamicResourceData, DynamicResourceData dynamicResourceData2) {
        this.resourceName = string;
        this.logger = logger;
        this.objects = objectArray;
        this.imageCache = (DynamicResourceDataImpl)dynamicResourceData;
        this.colorCache = (DynamicResourceDataImpl)dynamicResourceData2;
        this.inputFieldIdx = 0;
        this.outputFieldIdx = 0;
        int[] nArray = (int[])objectArray[0];
        this.input2any = new int[nArray[2] * 2];
        this.output2null = new int[nArray[3] * 2];
        Object[] objectArray2 = (String[])objectArray[1];
        this.registeredFields = (String[])Arrays.copyOf(objectArray2, objectArray2.length);
    }

    @Override
    public DynamicResourceDataDescription input(String string) {
        int n;
        int n2 = ((int[])this.objects[0])[2];
        String[] stringArray = (String[])this.objects[1];
        int n3 = -1;
        for (n = 0; n < n2; ++n) {
            if (!string.equals(stringArray[n])) continue;
            if (this.registeredFields[n] != null) {
                this.registeredFields[n] = null;
                n3 = ((int[])this.objects[2])[n];
                break;
            }
            n = -1;
            break;
        }
        this.input2any = this.setValue(this.input2any, this.inputFieldIdx * 2, n < n2 ? n : -1, this.inputFieldIdx * 2 + 1, n3);
        ++this.inputFieldIdx;
        return this;
    }

    @Override
    public DynamicResourceDataDescription output(String string, int n) {
        int n2;
        int n3 = ((int[])this.objects[0])[2];
        int n4 = ((int[])this.objects[0])[3];
        String[] stringArray = (String[])this.objects[1];
        int n5 = ((int[])this.objects[0])[2];
        int n6 = n;
        for (n2 = 0; n2 < n4; ++n2) {
            if (!string.equals(stringArray[n5 + n2])) continue;
            this.registeredFields[n5 + n2] = null;
            n6 = ((int[])this.objects[2])[n3 + n2];
            break;
        }
        this.output2null = this.setValue(this.output2null, this.outputFieldIdx * 2, n2 < n4 ? n2 : -1, this.outputFieldIdx * 2 + 1, n6);
        ++this.outputFieldIdx;
        return this;
    }

    private int[] setValue(int[] nArray, int n, int n2, int n3, int n4) {
        if (n >= nArray.length) {
            nArray = Arrays.copyOf(nArray, nArray.length + 2);
        }
        nArray[n] = n2;
        nArray[n3] = n4;
        return nArray;
    }

    @Override
    public DynamicResourceData create() {
        int[] nArray = (int[])this.objects[0];
        for (int i2 = 0; i2 < this.registeredFields.length; ++i2) {
            if (this.registeredFields[i2] == null) continue;
            StringBuffer stringBuffer = new StringBuffer(256);
            stringBuffer.append("DynamicResourceDataDescription requires additional ");
            stringBuffer.append(i2 < nArray[2] ? "input" : "output");
            stringBuffer.append("field ");
            stringBuffer.append(this.registeredFields[i2]);
            this.logger.error(2, stringBuffer.toString());
            return null;
        }
        StringBuffer stringBuffer = new StringBuffer(256);
        stringBuffer.append("Creating DynamicResourceData for '");
        stringBuffer.append(this.resourceName);
        stringBuffer.append("' with magic: '");
        stringBuffer.append(nArray[0]);
        stringBuffer.append("' and version: '");
        stringBuffer.append(nArray[1]);
        stringBuffer.append("'.");
        this.logger.info(2, stringBuffer.toString());
        return new DynamicResourceDataImpl(this, this.objects);
    }

    public String getResourceName() {
        return this.resourceName;
    }
}

