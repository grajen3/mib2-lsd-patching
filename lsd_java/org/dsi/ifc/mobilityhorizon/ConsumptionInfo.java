/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.mobilityhorizon;

import org.dsi.ifc.mobilityhorizon.ValueUnitPair;

public class ConsumptionInfo {
    public ValueUnitPair residualEnergy;
    public ValueUnitPair consumptionMotorway;
    public ValueUnitPair consumptionHighway;
    public ValueUnitPair consumptionCountryRoad;
    public ValueUnitPair consumptionDistrictRoad;
    public ValueUnitPair consumptionLocalRoad;
    public ValueUnitPair consumptionRuralRoad;
    public ValueUnitPair consumptionUnclassifiedRoad;
    public ValueUnitPair[] reserved;

    public ConsumptionInfo(ValueUnitPair valueUnitPair, ValueUnitPair valueUnitPair2, ValueUnitPair valueUnitPair3, ValueUnitPair valueUnitPair4, ValueUnitPair valueUnitPair5, ValueUnitPair valueUnitPair6, ValueUnitPair valueUnitPair7, ValueUnitPair valueUnitPair8, ValueUnitPair[] valueUnitPairArray) {
        this.residualEnergy = valueUnitPair;
        this.consumptionMotorway = valueUnitPair2;
        this.consumptionHighway = valueUnitPair3;
        this.consumptionCountryRoad = valueUnitPair4;
        this.consumptionDistrictRoad = valueUnitPair5;
        this.consumptionLocalRoad = valueUnitPair6;
        this.consumptionRuralRoad = valueUnitPair7;
        this.consumptionUnclassifiedRoad = valueUnitPair8;
        this.reserved = valueUnitPairArray;
    }

    public ConsumptionInfo() {
        this.residualEnergy = null;
        this.consumptionMotorway = null;
        this.consumptionHighway = null;
        this.consumptionCountryRoad = null;
        this.consumptionDistrictRoad = null;
        this.consumptionLocalRoad = null;
        this.consumptionRuralRoad = null;
        this.consumptionUnclassifiedRoad = null;
        this.reserved = null;
    }

    public ValueUnitPair getResidualEnergy() {
        return this.residualEnergy;
    }

    public ValueUnitPair getConsumptionMotorway() {
        return this.consumptionMotorway;
    }

    public ValueUnitPair getConsumptionHighway() {
        return this.consumptionHighway;
    }

    public ValueUnitPair getConsumptionCountryRoad() {
        return this.consumptionCountryRoad;
    }

    public ValueUnitPair getConsumptionDistrictRoad() {
        return this.consumptionDistrictRoad;
    }

    public ValueUnitPair getConsumptionLocalRoad() {
        return this.consumptionLocalRoad;
    }

    public ValueUnitPair getConsumptionRuralRoad() {
        return this.consumptionRuralRoad;
    }

    public ValueUnitPair getConsumptionUnclassifiedRoad() {
        return this.consumptionUnclassifiedRoad;
    }

    public ValueUnitPair[] getReserved() {
        return this.reserved;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(8500);
        stringBuffer.append("ConsumptionInfo");
        stringBuffer.append('(');
        stringBuffer.append("residualEnergy");
        stringBuffer.append('=');
        stringBuffer.append(this.residualEnergy);
        stringBuffer.append(',');
        stringBuffer.append("consumptionMotorway");
        stringBuffer.append('=');
        stringBuffer.append(this.consumptionMotorway);
        stringBuffer.append(',');
        stringBuffer.append("consumptionHighway");
        stringBuffer.append('=');
        stringBuffer.append(this.consumptionHighway);
        stringBuffer.append(',');
        stringBuffer.append("consumptionCountryRoad");
        stringBuffer.append('=');
        stringBuffer.append(this.consumptionCountryRoad);
        stringBuffer.append(',');
        stringBuffer.append("consumptionDistrictRoad");
        stringBuffer.append('=');
        stringBuffer.append(this.consumptionDistrictRoad);
        stringBuffer.append(',');
        stringBuffer.append("consumptionLocalRoad");
        stringBuffer.append('=');
        stringBuffer.append(this.consumptionLocalRoad);
        stringBuffer.append(',');
        stringBuffer.append("consumptionRuralRoad");
        stringBuffer.append('=');
        stringBuffer.append(this.consumptionRuralRoad);
        stringBuffer.append(',');
        stringBuffer.append("consumptionUnclassifiedRoad");
        stringBuffer.append('=');
        stringBuffer.append(this.consumptionUnclassifiedRoad);
        stringBuffer.append(',');
        stringBuffer.append("reserved");
        stringBuffer.append('[');
        if (this.reserved != null) {
            stringBuffer.append(this.reserved.length);
        }
        stringBuffer.append(']');
        stringBuffer.append('=');
        stringBuffer.append('{');
        if (this.reserved != null) {
            int n = this.reserved.length;
            int n2 = n - 1;
            for (int i2 = 0; i2 < n; ++i2) {
                stringBuffer.append(this.reserved[i2]);
                if (i2 >= n2) continue;
                stringBuffer.append(',');
            }
        } else {
            stringBuffer.append(this.reserved);
        }
        stringBuffer.append('}');
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

