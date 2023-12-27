/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.dynamicresourcedata.internal;

import de.vw.mib.dynamicresourcedata.DynamicResourceData;
import de.vw.mib.dynamicresourcedata.internal.DynamicResourceDataDescriptionImpl;
import edu.emory.mathcs.backport.java.util.Arrays;

public class DynamicResourceDataImpl
implements DynamicResourceData {
    private static final int BIN_SEARCH_MIN_COUNT;
    private final DynamicResourceDataDescriptionImpl description;
    private final Object[] data;
    private final int[] defaultOutput;

    DynamicResourceDataImpl() {
        this.description = null;
        this.data = null;
        this.defaultOutput = null;
    }

    DynamicResourceDataImpl(DynamicResourceDataDescriptionImpl dynamicResourceDataDescriptionImpl, Object[] objectArray) {
        this.description = dynamicResourceDataDescriptionImpl;
        this.data = objectArray;
        this.defaultOutput = new int[dynamicResourceDataDescriptionImpl.outputFieldIdx];
        for (int i2 = 0; i2 < this.defaultOutput.length; ++i2) {
            this.defaultOutput[i2] = dynamicResourceDataDescriptionImpl.output2null[i2 * 2 + 1];
        }
    }

    @Override
    public int[] map(int[] nArray) {
        int[] nArray2 = Arrays.copyOf(this.defaultOutput, this.defaultOutput.length);
        try {
            int n = this.getOutputIndex(nArray);
            this.fillOutput(nArray2, n);
        }
        catch (ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException) {
            StringBuffer stringBuffer = new StringBuffer(256);
            stringBuffer.append("DynamicResourceData cannot find a result tupel for resource '");
            stringBuffer.append(this.description.getResourceName());
            stringBuffer.append("' with input [");
            for (int i2 = 0; i2 < nArray.length; ++i2) {
                stringBuffer.append(nArray[i2]);
                if (i2 >= nArray.length - 1) continue;
                stringBuffer.append(", ");
            }
            stringBuffer.append("]. Returning default values.");
            this.description.logger.error(2, stringBuffer.toString());
        }
        return nArray2;
    }

    private int getOutputIndex(int[] nArray) {
        int n = 0;
        int n2 = 0;
        block0: for (int i2 = 0; i2 < nArray.length && n2 != -1; ++i2) {
            for (int i3 = 0; i3 < nArray.length && n2 != -1; ++i3) {
                if (this.description.input2any[i3 * 2] != n) continue;
                n2 = this.getValue(this.data, n * 2 + 3, n2, nArray[i3], this.description.input2any[i3 * 2 + 1]);
                ++n;
                continue block0;
            }
        }
        return n2;
    }

    private int getValue(Object[] objectArray, int n, int n2, int n3, int n4) {
        int[] nArray = (int[])objectArray[n];
        int[] nArray2 = (int[])objectArray[n + 1];
        int n5 = this.getOffset(nArray, n2, n3);
        return nArray2[n5 != -1 ? n5 : this.getOffset(nArray, n2, n4)];
    }

    private int getOffset(int[] nArray, int n, int n2) {
        block6: {
            int n3;
            if (nArray[n] <= 0) break block6;
            int n4 = n3 + nArray[n] - 1;
            if (nArray[n] < 7) {
                for (n3 = n + 1; n3 <= n4; ++n3) {
                    if (nArray[n3] != n2) continue;
                    return n3;
                }
            } else {
                while (n3 <= n4) {
                    int n5 = n3 + (n4 - n3) / 2;
                    if (n2 < nArray[n5]) {
                        n4 = n5 - 1;
                        continue;
                    }
                    if (n2 > nArray[n5]) {
                        n3 = n5 + 1;
                        continue;
                    }
                    return n5;
                }
            }
        }
        return -1;
    }

    private void fillOutput(int[] nArray, int n) {
        int n2 = 3 + ((int[])this.data[0])[2] * 2;
        int n3 = ((int[])this.data[0])[3];
        for (int i2 = 0; i2 < n3; ++i2) {
            int[] nArray2 = (int[])this.data[n2 + i2];
            for (int i3 = 0; i3 < nArray.length; ++i3) {
                if (this.description.output2null[i3 * 2] != i2) continue;
                nArray[i3] = nArray2[n];
            }
        }
    }

    @Override
    public String mapImagePath(int n) {
        int n2 = this.getValue(this.description.imageCache.data, 3, 0, n, 0);
        String string = ((String[])this.description.imageCache.data[5])[n2];
        return string;
    }
}

