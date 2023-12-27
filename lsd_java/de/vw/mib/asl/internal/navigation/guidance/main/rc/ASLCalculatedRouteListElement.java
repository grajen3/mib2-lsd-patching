/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.guidance.main.rc;

import org.dsi.ifc.navigation.CalculatedRouteListElement;

public class ASLCalculatedRouteListElement {
    private CalculatedRouteListElement calculatedRouteListElement = null;
    private int dsiCalculationIndex = 0;
    private int modelCalculationIndex = 0;
    private int calculationStateFinishedId = 0;
    private boolean isCalculated = false;
    private int calculationStateId = 0;
    private int calculationProgress = 0;
    private boolean isNotfy = true;

    public String toString() {
        return new StringBuffer().append("ASLCalculatedRouteListElement [calculatedRouteListElement=").append(this.calculatedRouteListElement).append(", dsiCalculationIndex=").append(this.dsiCalculationIndex).append(", modelCalculationIndex=").append(this.modelCalculationIndex).append(", calculationStateFinishedId=").append(this.calculationStateFinishedId).append(", isCalculated=").append(this.isCalculated).append(", calculationStateId=").append(this.calculationStateId).append(", calculationProgress=").append(this.calculationProgress).append(", isNotfy=").append(this.isNotfy).append("]").toString();
    }

    public boolean isNotify() {
        return this.isNotfy;
    }

    public void setNotify(boolean bl) {
        this.isNotfy = bl;
    }

    public CalculatedRouteListElement getCalculatedRouteListElement() {
        return this.calculatedRouteListElement;
    }

    public void setCalculatedRouteListElement(CalculatedRouteListElement calculatedRouteListElement) {
        this.calculatedRouteListElement = calculatedRouteListElement;
    }

    public int getDsiCalculationIndex() {
        return this.dsiCalculationIndex;
    }

    public void setDsiCalculationIndex(int n) {
        this.dsiCalculationIndex = n;
    }

    public int getModelCalculationIndex() {
        return this.modelCalculationIndex;
    }

    public void setModelCalculationIndex(int n) {
        this.modelCalculationIndex = n;
    }

    public int getCalculationStateFinishedId() {
        return this.calculationStateFinishedId;
    }

    public void setCalculationStateFinishedId(int n) {
        this.calculationStateFinishedId = n;
    }

    public int getCalculationStateId() {
        return this.calculationStateId;
    }

    public void setCalculationStateId(int n) {
        this.calculationStateId = n;
    }

    public int getCalculationProgress() {
        return this.calculationProgress;
    }

    public void setCalculationProgress(int n) {
        this.calculationProgress = n;
    }
}

