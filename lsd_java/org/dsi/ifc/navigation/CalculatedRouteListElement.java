/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.navigation;

import org.dsi.ifc.global.NavSegmentID;

public class CalculatedRouteListElement {
    public long distance;
    public long eta;
    public long etaWithSpeedAndFlow;
    public long ecologicalFactor;
    public long motorwayLength;
    public long tollLength;
    public long tollCostAmount;
    public int tollCostCurrency;
    public boolean hasTunnel;
    public boolean hasFerry;
    public boolean isTimeRestricted;
    public boolean hasCarTrain;
    public boolean isSeasonalRestricted;
    public boolean needsVignette;
    public NavSegmentID segmentIDList;
    public int calculationState;
    public int calculationPercentage;
    public int numberOfTmcMessages;
    public int etaWithSpeedAndFlowStatus;
    public int[] additionalRouteDataKeys;
    public String[] additionalRouteDataValues;
    public boolean hasHovLane;

    public CalculatedRouteListElement() {
        this.distance = 0L;
        this.eta = 0L;
        this.etaWithSpeedAndFlow = 0L;
        this.motorwayLength = 0L;
        this.tollLength = 0L;
        this.tollCostAmount = 0L;
        this.tollCostCurrency = 0;
        this.hasTunnel = false;
        this.hasFerry = false;
        this.isTimeRestricted = false;
        this.hasCarTrain = false;
        this.isSeasonalRestricted = false;
        this.needsVignette = false;
        this.segmentIDList = null;
        this.calculationState = 0;
        this.calculationPercentage = 0;
        this.numberOfTmcMessages = 0;
        this.additionalRouteDataKeys = null;
        this.additionalRouteDataValues = null;
        this.hasHovLane = false;
    }

    public CalculatedRouteListElement(long l, long l2, long l3, long l4, long l5, long l6, long l7, int n, boolean bl, boolean bl2, boolean bl3, boolean bl4, boolean bl5, boolean bl6, NavSegmentID navSegmentID, int n2, int n3, int n4, int n5, int[] nArray, String[] stringArray) {
        this.distance = l;
        this.eta = l2;
        this.etaWithSpeedAndFlow = l3;
        this.ecologicalFactor = l4;
        this.motorwayLength = l5;
        this.tollLength = l6;
        this.tollCostAmount = l7;
        this.tollCostCurrency = n;
        this.hasTunnel = bl;
        this.hasFerry = bl2;
        this.isTimeRestricted = bl3;
        this.hasCarTrain = bl4;
        this.isSeasonalRestricted = bl5;
        this.needsVignette = bl6;
        this.segmentIDList = navSegmentID;
        this.calculationState = n2;
        this.calculationPercentage = n3;
        this.numberOfTmcMessages = n4;
        this.etaWithSpeedAndFlowStatus = n5;
        this.additionalRouteDataKeys = nArray;
        this.additionalRouteDataValues = stringArray;
        this.hasHovLane = false;
    }

    public CalculatedRouteListElement(long l, long l2, long l3, long l4, long l5, long l6, long l7, int n, boolean bl, boolean bl2, boolean bl3, boolean bl4, boolean bl5, boolean bl6, NavSegmentID navSegmentID, int n2, int n3, int n4, int n5, int[] nArray, String[] stringArray, boolean bl7) {
        this.distance = l;
        this.eta = l2;
        this.etaWithSpeedAndFlow = l3;
        this.ecologicalFactor = l4;
        this.motorwayLength = l5;
        this.tollLength = l6;
        this.tollCostAmount = l7;
        this.tollCostCurrency = n;
        this.hasTunnel = bl;
        this.hasFerry = bl2;
        this.isTimeRestricted = bl3;
        this.hasCarTrain = bl4;
        this.isSeasonalRestricted = bl5;
        this.needsVignette = bl6;
        this.segmentIDList = navSegmentID;
        this.calculationState = n2;
        this.calculationPercentage = n3;
        this.numberOfTmcMessages = n4;
        this.etaWithSpeedAndFlowStatus = n5;
        this.additionalRouteDataKeys = nArray;
        this.additionalRouteDataValues = stringArray;
        this.hasHovLane = bl7;
    }

    public long getDistance() {
        return this.distance;
    }

    public long getEta() {
        return this.eta;
    }

    public long getEtaWithSpeedAndFlow() {
        return this.etaWithSpeedAndFlow;
    }

    public int getEtaWithSpeedAndFlowStatus() {
        return this.etaWithSpeedAndFlowStatus;
    }

    public long getEcologicalFactor() {
        return this.ecologicalFactor;
    }

    public long getMotorwayLength() {
        return this.motorwayLength;
    }

    public long getTollLength() {
        return this.tollLength;
    }

    public long getTollCostAmount() {
        return this.tollCostAmount;
    }

    public int getTollCostCurrency() {
        return this.tollCostCurrency;
    }

    public boolean isHasTunnel() {
        return this.hasTunnel;
    }

    public boolean isHasFerry() {
        return this.hasFerry;
    }

    public boolean isIsTimeRestricted() {
        return this.isTimeRestricted;
    }

    public boolean isHasCarTrain() {
        return this.hasCarTrain;
    }

    public boolean isIsSeasonalRestricted() {
        return this.isSeasonalRestricted;
    }

    public boolean isNeedsVignette() {
        return this.needsVignette;
    }

    public NavSegmentID getSegmentIDList() {
        return this.segmentIDList;
    }

    public int getCalculationState() {
        return this.calculationState;
    }

    public int getCalculationPercentage() {
        return this.calculationPercentage;
    }

    public int getNumberOfTmcMessages() {
        return this.numberOfTmcMessages;
    }

    public int[] getAdditionalRouteDataKeys() {
        return this.additionalRouteDataKeys;
    }

    public String[] getAdditionalRouteDataValues() {
        return this.additionalRouteDataValues;
    }

    public boolean isHasHovLane() {
        return this.hasHovLane;
    }

    public String toString() {
        int n;
        int n2;
        int n3;
        StringBuffer stringBuffer = new StringBuffer(2400);
        stringBuffer.append("CalculatedRouteListElement");
        stringBuffer.append('(');
        stringBuffer.append("distance");
        stringBuffer.append('=');
        stringBuffer.append(this.distance);
        stringBuffer.append(',');
        stringBuffer.append("eta");
        stringBuffer.append('=');
        stringBuffer.append(this.eta);
        stringBuffer.append(',');
        stringBuffer.append("etaWithSpeedAndFlow");
        stringBuffer.append('=');
        stringBuffer.append(this.etaWithSpeedAndFlow);
        stringBuffer.append(',');
        stringBuffer.append("ecologicalFactor");
        stringBuffer.append('=');
        stringBuffer.append(this.ecologicalFactor);
        stringBuffer.append(',');
        stringBuffer.append("motorwayLength");
        stringBuffer.append('=');
        stringBuffer.append(this.motorwayLength);
        stringBuffer.append(',');
        stringBuffer.append("tollLength");
        stringBuffer.append('=');
        stringBuffer.append(this.tollLength);
        stringBuffer.append(',');
        stringBuffer.append("tollCostAmount");
        stringBuffer.append('=');
        stringBuffer.append(this.tollCostAmount);
        stringBuffer.append(',');
        stringBuffer.append("tollCostCurrency");
        stringBuffer.append('=');
        stringBuffer.append(this.tollCostCurrency);
        stringBuffer.append(',');
        stringBuffer.append("hasTunnel");
        stringBuffer.append('=');
        stringBuffer.append(this.hasTunnel);
        stringBuffer.append(',');
        stringBuffer.append("hasFerry");
        stringBuffer.append('=');
        stringBuffer.append(this.hasFerry);
        stringBuffer.append(',');
        stringBuffer.append("isTimeRestricted");
        stringBuffer.append('=');
        stringBuffer.append(this.isTimeRestricted);
        stringBuffer.append(',');
        stringBuffer.append("hasCarTrain");
        stringBuffer.append('=');
        stringBuffer.append(this.hasCarTrain);
        stringBuffer.append(',');
        stringBuffer.append("isSeasonalRestricted");
        stringBuffer.append('=');
        stringBuffer.append(this.isSeasonalRestricted);
        stringBuffer.append(',');
        stringBuffer.append("needsVignette");
        stringBuffer.append('=');
        stringBuffer.append(this.needsVignette);
        stringBuffer.append(',');
        stringBuffer.append("segmentIDList");
        stringBuffer.append('=');
        stringBuffer.append(this.segmentIDList);
        stringBuffer.append(',');
        stringBuffer.append("calculationState");
        stringBuffer.append('=');
        stringBuffer.append(this.calculationState);
        stringBuffer.append(',');
        stringBuffer.append("calculationPercentage");
        stringBuffer.append('=');
        stringBuffer.append(this.calculationPercentage);
        stringBuffer.append(',');
        stringBuffer.append("numberOfTmcMessages");
        stringBuffer.append('=');
        stringBuffer.append(this.numberOfTmcMessages);
        stringBuffer.append(',');
        stringBuffer.append("etaWithSpeedAndFlowStatus");
        stringBuffer.append('=');
        stringBuffer.append(this.etaWithSpeedAndFlowStatus);
        stringBuffer.append(',');
        stringBuffer.append("additionalRouteDataKeys");
        stringBuffer.append('[');
        if (this.additionalRouteDataKeys != null) {
            stringBuffer.append(this.additionalRouteDataKeys.length);
        }
        stringBuffer.append(']');
        stringBuffer.append('=');
        stringBuffer.append('{');
        if (this.additionalRouteDataKeys != null) {
            n3 = this.additionalRouteDataKeys.length;
            n2 = n3 - 1;
            for (n = 0; n < n3; ++n) {
                stringBuffer.append(this.additionalRouteDataKeys[n]);
                if (n >= n2) continue;
                stringBuffer.append(',');
            }
        } else {
            stringBuffer.append(this.additionalRouteDataKeys);
        }
        stringBuffer.append('}');
        stringBuffer.append(',');
        stringBuffer.append("additionalRouteDataValues");
        stringBuffer.append('[');
        if (this.additionalRouteDataValues != null) {
            stringBuffer.append(this.additionalRouteDataValues.length);
        }
        stringBuffer.append(']');
        stringBuffer.append('=');
        stringBuffer.append('{');
        if (this.additionalRouteDataValues != null) {
            n3 = this.additionalRouteDataValues.length;
            n2 = n3 - 1;
            for (n = 0; n < n3; ++n) {
                stringBuffer.append('\"');
                stringBuffer.append(this.additionalRouteDataValues[n]);
                stringBuffer.append('\"');
                if (n >= n2) continue;
                stringBuffer.append(',');
            }
        } else {
            stringBuffer.append(this.additionalRouteDataValues);
        }
        stringBuffer.append('}');
        stringBuffer.append(',');
        stringBuffer.append("hasHovLane");
        stringBuffer.append('=');
        stringBuffer.append(this.hasHovLane);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

