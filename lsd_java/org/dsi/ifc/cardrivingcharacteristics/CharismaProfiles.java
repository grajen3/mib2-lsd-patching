/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.cardrivingcharacteristics;

public class CharismaProfiles {
    public boolean comfort;
    public boolean autonormal;
    public boolean dynamic;
    public boolean offroadallroad;
    public boolean efficiency;
    public boolean racesport;
    public boolean individual;
    public boolean range;
    public boolean lift;
    public boolean offroadlevel2;
    public boolean offroadlevel3;
    public boolean offroadlevel4;

    public CharismaProfiles() {
        this.comfort = false;
        this.autonormal = false;
        this.dynamic = false;
        this.offroadallroad = false;
        this.efficiency = false;
        this.racesport = false;
        this.individual = false;
        this.range = false;
        this.lift = false;
        this.offroadlevel2 = false;
        this.offroadlevel3 = false;
        this.offroadlevel4 = false;
    }

    public CharismaProfiles(boolean bl, boolean bl2, boolean bl3, boolean bl4, boolean bl5, boolean bl6, boolean bl7, boolean bl8, boolean bl9, boolean bl10, boolean bl11, boolean bl12) {
        this.comfort = bl;
        this.autonormal = bl2;
        this.dynamic = bl3;
        this.offroadallroad = bl4;
        this.efficiency = bl5;
        this.racesport = bl6;
        this.individual = bl7;
        this.range = bl8;
        this.lift = bl9;
        this.offroadlevel2 = bl10;
        this.offroadlevel3 = bl11;
        this.offroadlevel4 = bl12;
    }

    public boolean isComfort() {
        return this.comfort;
    }

    public boolean isAutonormal() {
        return this.autonormal;
    }

    public boolean isDynamic() {
        return this.dynamic;
    }

    public boolean isOffroadallroad() {
        return this.offroadallroad;
    }

    public boolean isEfficiency() {
        return this.efficiency;
    }

    public boolean isRacesport() {
        return this.racesport;
    }

    public boolean isIndividual() {
        return this.individual;
    }

    public boolean isRange() {
        return this.range;
    }

    public boolean isLift() {
        return this.lift;
    }

    public boolean isOffroadlevel2() {
        return this.offroadlevel2;
    }

    public boolean isOffroadlevel3() {
        return this.offroadlevel3;
    }

    public boolean isOffroadlevel4() {
        return this.offroadlevel4;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(500);
        stringBuffer.append("CharismaProfiles");
        stringBuffer.append('(');
        stringBuffer.append("comfort");
        stringBuffer.append('=');
        stringBuffer.append(this.comfort);
        stringBuffer.append(',');
        stringBuffer.append("autonormal");
        stringBuffer.append('=');
        stringBuffer.append(this.autonormal);
        stringBuffer.append(',');
        stringBuffer.append("dynamic");
        stringBuffer.append('=');
        stringBuffer.append(this.dynamic);
        stringBuffer.append(',');
        stringBuffer.append("offroadallroad");
        stringBuffer.append('=');
        stringBuffer.append(this.offroadallroad);
        stringBuffer.append(',');
        stringBuffer.append("efficiency");
        stringBuffer.append('=');
        stringBuffer.append(this.efficiency);
        stringBuffer.append(',');
        stringBuffer.append("racesport");
        stringBuffer.append('=');
        stringBuffer.append(this.racesport);
        stringBuffer.append(',');
        stringBuffer.append("individual");
        stringBuffer.append('=');
        stringBuffer.append(this.individual);
        stringBuffer.append(',');
        stringBuffer.append("range");
        stringBuffer.append('=');
        stringBuffer.append(this.range);
        stringBuffer.append(',');
        stringBuffer.append("lift");
        stringBuffer.append('=');
        stringBuffer.append(this.lift);
        stringBuffer.append(',');
        stringBuffer.append("offroadlevel2");
        stringBuffer.append('=');
        stringBuffer.append(this.offroadlevel2);
        stringBuffer.append(',');
        stringBuffer.append("offroadlevel3");
        stringBuffer.append('=');
        stringBuffer.append(this.offroadlevel3);
        stringBuffer.append(',');
        stringBuffer.append("offroadlevel4");
        stringBuffer.append('=');
        stringBuffer.append(this.offroadlevel4);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

