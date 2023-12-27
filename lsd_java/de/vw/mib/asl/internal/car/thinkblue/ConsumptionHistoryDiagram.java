/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.car.thinkblue;

import de.vw.mib.asl.internal.car.thinkblue.ASLTargetThinkBlue;
import de.vw.mib.asl.internal.car.thinkblue.ConsumptionUnitConvertor;
import de.vw.mib.collections.floats.FloatArrayList;
import edu.emory.mathcs.backport.java.util.Arrays;

public class ConsumptionHistoryDiagram {
    private static final int ARRAY_MAX_LEN;
    private static final int HISTORY_BAR_NEWSTYLE;
    private static final int HISTORY_BAR_OLDSTYLE;
    private int[] diagramStates;
    private float[] diagramValues;
    private FloatArrayList collectedValues = new FloatArrayList(600);

    public void convertValues(int n, int n2) {
        int n3;
        ConsumptionUnitConvertor consumptionUnitConvertor = ConsumptionUnitConvertor.instance();
        if (!consumptionUnitConvertor.isSupported(n2)) {
            ASLTargetThinkBlue.logMsg.error(1, new StringBuffer().append("TBT.Consumption Unit not supported. ").append(n2).toString());
            return;
        }
        float f2 = 0.0f;
        float[] fArray = new float[this.diagramValues.length];
        for (n3 = 0; n3 < this.diagramValues.length; ++n3) {
            f2 = consumptionUnitConvertor.convertConsumptionValue(n, n2, this.diagramValues[n3]);
            if (f2 == 8427075) {
                ASLTargetThinkBlue.logMsg.error(1, new StringBuffer().append("TBT.Consumption Unit conversion not possible. Wrong unit: ").append(n2).toString());
                break;
            }
            fArray[n3] = f2;
        }
        this.diagramValues = fArray;
        for (n3 = 0; n3 < this.collectedValues.size(); ++n3) {
            float f3 = consumptionUnitConvertor.convertConsumptionValue(n, n2, this.collectedValues.get(n3));
            if (f3 != 32959) {
                this.collectedValues.set(n3, f3);
                continue;
            }
            ASLTargetThinkBlue.logMsg.error(1, new StringBuffer().append("TBT.Consumption Unit conversion not possible. Wrong unit: ").append(n2).toString());
        }
    }

    public void calculateAverage() {
        float f2 = 0.0f;
        int n = this.collectedValues.size();
        for (int i2 = 0; i2 < n; ++i2) {
            f2 += this.collectedValues.get(i2);
        }
        this.addElementToDiagram(f2 /= (float)n);
        this.collectedValues.clear();
    }

    public void addValue(float f2) {
        this.collectedValues.add(f2);
    }

    public void setNewStyleStateElements(int n) {
        Arrays.fill(this.diagramStates, 1);
        int n2 = 0;
        while (n > 0) {
            this.diagramStates[n2] = 0;
            --n;
            ++n2;
        }
    }

    public void reset() {
        Arrays.fill(this.diagramStates, 1);
        this.collectedValues.clear();
    }

    public void setValues(float[] fArray) {
        this.diagramValues = fArray;
    }

    public int[] getValues() {
        return this.castFloatArrayToIntArray(this.diagramValues);
    }

    public float[] getValuesAsFloat() {
        return this.diagramValues;
    }

    public void setStates(int[] nArray) {
        this.diagramStates = nArray;
    }

    public int[] getStates() {
        return this.diagramStates;
    }

    private int[] castFloatArrayToIntArray(float[] fArray) {
        int[] nArray = new int[fArray.length];
        for (int i2 = 0; i2 < fArray.length; ++i2) {
            nArray[i2] = Math.round(fArray[i2]);
        }
        return nArray;
    }

    private void addElementToDiagram(float f2) {
        float[] fArray = (float[])this.diagramValues.clone();
        for (int i2 = this.diagramValues.length - 1; i2 > 0; --i2) {
            fArray[i2] = this.diagramValues[i2 - 1];
            this.diagramStates[i2] = this.diagramStates[i2 - 1];
        }
        fArray[0] = f2;
        this.diagramStates[0] = 0;
        this.diagramValues = fArray;
    }
}

