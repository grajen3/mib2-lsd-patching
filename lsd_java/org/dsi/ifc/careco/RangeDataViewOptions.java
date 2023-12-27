/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.careco;

import org.dsi.ifc.careco.RangeDataConfiguration;
import org.dsi.ifc.global.CarViewOption;

public class RangeDataViewOptions {
    public CarViewOption rdSetFactoryDefault;
    public CarViewOption rdConsumptionMotorway1;
    public CarViewOption rdConsumptionMotorway2;
    public CarViewOption rdConsumptionHighway1;
    public CarViewOption rdConsumptionHighway2;
    public CarViewOption rdConsumptionCountryRoad1;
    public CarViewOption rdConsumptionCountryRoad2;
    public CarViewOption rdConsumptionDistrictRoad1;
    public CarViewOption rdConsumptionDistrictRoad2;
    public CarViewOption rdConsumptionLocalRoad1;
    public CarViewOption rdConsumptionLocalRoad2;
    public CarViewOption rdConsumptionRuralRoad1;
    public CarViewOption rdConsumptionRuralRoad2;
    public CarViewOption rdConsumptionUnclassifiedRoad1;
    public CarViewOption rdConsumptionUnclassifiedRoad2;
    public CarViewOption rdMaxRange1;
    public CarViewOption rdMaxRange2;
    public CarViewOption rdResidualEnergy1;
    public CarViewOption rdResidualEnergy2;
    public RangeDataConfiguration configuration;

    public RangeDataViewOptions() {
        this.rdSetFactoryDefault = null;
        this.rdConsumptionMotorway1 = null;
        this.rdConsumptionMotorway2 = null;
        this.rdConsumptionHighway1 = null;
        this.rdConsumptionHighway2 = null;
        this.rdConsumptionCountryRoad1 = null;
        this.rdConsumptionCountryRoad2 = null;
        this.rdConsumptionDistrictRoad1 = null;
        this.rdConsumptionDistrictRoad2 = null;
        this.rdConsumptionLocalRoad1 = null;
        this.rdConsumptionLocalRoad2 = null;
        this.rdConsumptionRuralRoad1 = null;
        this.rdConsumptionRuralRoad2 = null;
        this.rdConsumptionUnclassifiedRoad1 = null;
        this.rdConsumptionUnclassifiedRoad2 = null;
        this.rdMaxRange1 = null;
        this.rdMaxRange2 = null;
        this.rdResidualEnergy1 = null;
        this.rdResidualEnergy2 = null;
        this.configuration = null;
    }

    public RangeDataViewOptions(CarViewOption carViewOption, CarViewOption carViewOption2, CarViewOption carViewOption3, CarViewOption carViewOption4, CarViewOption carViewOption5, CarViewOption carViewOption6, CarViewOption carViewOption7, CarViewOption carViewOption8, CarViewOption carViewOption9, CarViewOption carViewOption10, CarViewOption carViewOption11, CarViewOption carViewOption12, CarViewOption carViewOption13, CarViewOption carViewOption14, CarViewOption carViewOption15, CarViewOption carViewOption16, CarViewOption carViewOption17, CarViewOption carViewOption18, CarViewOption carViewOption19, RangeDataConfiguration rangeDataConfiguration) {
        this.rdSetFactoryDefault = carViewOption;
        this.rdConsumptionMotorway1 = carViewOption2;
        this.rdConsumptionMotorway2 = carViewOption3;
        this.rdConsumptionHighway1 = carViewOption4;
        this.rdConsumptionHighway2 = carViewOption5;
        this.rdConsumptionCountryRoad1 = carViewOption6;
        this.rdConsumptionCountryRoad2 = carViewOption7;
        this.rdConsumptionDistrictRoad1 = carViewOption8;
        this.rdConsumptionDistrictRoad2 = carViewOption9;
        this.rdConsumptionLocalRoad1 = carViewOption10;
        this.rdConsumptionLocalRoad2 = carViewOption11;
        this.rdConsumptionRuralRoad1 = carViewOption12;
        this.rdConsumptionRuralRoad2 = carViewOption13;
        this.rdConsumptionUnclassifiedRoad1 = carViewOption14;
        this.rdConsumptionUnclassifiedRoad2 = carViewOption15;
        this.rdMaxRange1 = carViewOption16;
        this.rdMaxRange2 = carViewOption17;
        this.rdResidualEnergy1 = carViewOption18;
        this.rdResidualEnergy2 = carViewOption19;
        this.configuration = rangeDataConfiguration;
    }

    public CarViewOption getRdSetFactoryDefault() {
        return this.rdSetFactoryDefault;
    }

    public CarViewOption getRdConsumptionMotorway1() {
        return this.rdConsumptionMotorway1;
    }

    public CarViewOption getRdConsumptionMotorway2() {
        return this.rdConsumptionMotorway2;
    }

    public CarViewOption getRdConsumptionHighway1() {
        return this.rdConsumptionHighway1;
    }

    public CarViewOption getRdConsumptionHighway2() {
        return this.rdConsumptionHighway2;
    }

    public CarViewOption getRdConsumptionCountryRoad1() {
        return this.rdConsumptionCountryRoad1;
    }

    public CarViewOption getRdConsumptionCountryRoad2() {
        return this.rdConsumptionCountryRoad2;
    }

    public CarViewOption getRdConsumptionDistrictRoad1() {
        return this.rdConsumptionDistrictRoad1;
    }

    public CarViewOption getRdConsumptionDistrictRoad2() {
        return this.rdConsumptionDistrictRoad2;
    }

    public CarViewOption getRdConsumptionLocalRoad1() {
        return this.rdConsumptionLocalRoad1;
    }

    public CarViewOption getRdConsumptionLocalRoad2() {
        return this.rdConsumptionLocalRoad2;
    }

    public CarViewOption getRdConsumptionRuralRoad1() {
        return this.rdConsumptionRuralRoad1;
    }

    public CarViewOption getRdConsumptionRuralRoad2() {
        return this.rdConsumptionRuralRoad2;
    }

    public CarViewOption getRdConsumptionUnclassifiedRoad1() {
        return this.rdConsumptionUnclassifiedRoad1;
    }

    public CarViewOption getRdConsumptionUnclassifiedRoad2() {
        return this.rdConsumptionUnclassifiedRoad2;
    }

    public CarViewOption getRdMaxRange1() {
        return this.rdMaxRange1;
    }

    public CarViewOption getRdMaxRange2() {
        return this.rdMaxRange2;
    }

    public CarViewOption getRdResidualEnergy1() {
        return this.rdResidualEnergy1;
    }

    public CarViewOption getRdResidualEnergy2() {
        return this.rdResidualEnergy2;
    }

    public RangeDataConfiguration getConfiguration() {
        return this.configuration;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(21100);
        stringBuffer.append("RangeDataViewOptions");
        stringBuffer.append('(');
        stringBuffer.append("rdSetFactoryDefault");
        stringBuffer.append('=');
        stringBuffer.append(this.rdSetFactoryDefault);
        stringBuffer.append(',');
        stringBuffer.append("rdConsumptionMotorway1");
        stringBuffer.append('=');
        stringBuffer.append(this.rdConsumptionMotorway1);
        stringBuffer.append(',');
        stringBuffer.append("rdConsumptionMotorway2");
        stringBuffer.append('=');
        stringBuffer.append(this.rdConsumptionMotorway2);
        stringBuffer.append(',');
        stringBuffer.append("rdConsumptionHighway1");
        stringBuffer.append('=');
        stringBuffer.append(this.rdConsumptionHighway1);
        stringBuffer.append(',');
        stringBuffer.append("rdConsumptionHighway2");
        stringBuffer.append('=');
        stringBuffer.append(this.rdConsumptionHighway2);
        stringBuffer.append(',');
        stringBuffer.append("rdConsumptionCountryRoad1");
        stringBuffer.append('=');
        stringBuffer.append(this.rdConsumptionCountryRoad1);
        stringBuffer.append(',');
        stringBuffer.append("rdConsumptionCountryRoad2");
        stringBuffer.append('=');
        stringBuffer.append(this.rdConsumptionCountryRoad2);
        stringBuffer.append(',');
        stringBuffer.append("rdConsumptionDistrictRoad1");
        stringBuffer.append('=');
        stringBuffer.append(this.rdConsumptionDistrictRoad1);
        stringBuffer.append(',');
        stringBuffer.append("rdConsumptionDistrictRoad2");
        stringBuffer.append('=');
        stringBuffer.append(this.rdConsumptionDistrictRoad2);
        stringBuffer.append(',');
        stringBuffer.append("rdConsumptionLocalRoad1");
        stringBuffer.append('=');
        stringBuffer.append(this.rdConsumptionLocalRoad1);
        stringBuffer.append(',');
        stringBuffer.append("rdConsumptionLocalRoad2");
        stringBuffer.append('=');
        stringBuffer.append(this.rdConsumptionLocalRoad2);
        stringBuffer.append(',');
        stringBuffer.append("rdConsumptionRuralRoad1");
        stringBuffer.append('=');
        stringBuffer.append(this.rdConsumptionRuralRoad1);
        stringBuffer.append(',');
        stringBuffer.append("rdConsumptionRuralRoad2");
        stringBuffer.append('=');
        stringBuffer.append(this.rdConsumptionRuralRoad2);
        stringBuffer.append(',');
        stringBuffer.append("rdConsumptionUnclassifiedRoad1");
        stringBuffer.append('=');
        stringBuffer.append(this.rdConsumptionUnclassifiedRoad1);
        stringBuffer.append(',');
        stringBuffer.append("rdConsumptionUnclassifiedRoad2");
        stringBuffer.append('=');
        stringBuffer.append(this.rdConsumptionUnclassifiedRoad2);
        stringBuffer.append(',');
        stringBuffer.append("rdMaxRange1");
        stringBuffer.append('=');
        stringBuffer.append(this.rdMaxRange1);
        stringBuffer.append(',');
        stringBuffer.append("rdMaxRange2");
        stringBuffer.append('=');
        stringBuffer.append(this.rdMaxRange2);
        stringBuffer.append(',');
        stringBuffer.append("rdResidualEnergy1");
        stringBuffer.append('=');
        stringBuffer.append(this.rdResidualEnergy1);
        stringBuffer.append(',');
        stringBuffer.append("rdResidualEnergy2");
        stringBuffer.append('=');
        stringBuffer.append(this.rdResidualEnergy2);
        stringBuffer.append(',');
        stringBuffer.append("configuration");
        stringBuffer.append('=');
        stringBuffer.append(this.configuration);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

