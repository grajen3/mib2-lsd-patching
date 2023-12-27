/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.carkombi;

public class HUDConfiguration {
    public boolean speed;
    public boolean warning;
    public boolean gra;
    public boolean nightvision;
    public boolean roadsign;
    public boolean rgi;
    public boolean navInfo;
    public boolean infoList;
    public boolean hca;
    public boolean acc;
    public boolean telephone;
    public boolean efficiencyAssist;
    public boolean speedLimiter;
    public boolean colourDesignAuto;
    public boolean colourDesignDay;
    public boolean colourDesignNight;
    public boolean colourDefault;
    public boolean colourAlternative;

    public HUDConfiguration() {
        this.speed = false;
        this.warning = false;
        this.gra = false;
        this.nightvision = false;
        this.roadsign = false;
        this.rgi = false;
        this.navInfo = false;
        this.infoList = false;
        this.hca = false;
        this.acc = false;
        this.telephone = false;
        this.efficiencyAssist = false;
        this.speedLimiter = false;
        this.colourDesignAuto = false;
        this.colourDesignDay = false;
        this.colourDesignNight = false;
        this.colourDefault = false;
        this.colourAlternative = false;
    }

    public HUDConfiguration(boolean bl, boolean bl2, boolean bl3, boolean bl4, boolean bl5, boolean bl6, boolean bl7, boolean bl8, boolean bl9, boolean bl10, boolean bl11, boolean bl12, boolean bl13, boolean bl14, boolean bl15, boolean bl16, boolean bl17, boolean bl18) {
        this.speed = bl;
        this.warning = bl2;
        this.gra = bl3;
        this.nightvision = bl4;
        this.roadsign = bl5;
        this.rgi = bl6;
        this.navInfo = bl7;
        this.infoList = bl8;
        this.hca = bl9;
        this.acc = bl10;
        this.telephone = bl11;
        this.efficiencyAssist = bl12;
        this.speedLimiter = bl13;
        this.colourDesignAuto = bl14;
        this.colourDesignDay = bl15;
        this.colourDesignNight = bl16;
        this.colourDefault = bl17;
        this.colourAlternative = bl18;
    }

    public boolean isSpeed() {
        return this.speed;
    }

    public boolean isWarning() {
        return this.warning;
    }

    public boolean isGra() {
        return this.gra;
    }

    public boolean isNightvision() {
        return this.nightvision;
    }

    public boolean isRoadsign() {
        return this.roadsign;
    }

    public boolean isRgi() {
        return this.rgi;
    }

    public boolean isNavInfo() {
        return this.navInfo;
    }

    public boolean isInfoList() {
        return this.infoList;
    }

    public boolean isAcc() {
        return this.acc;
    }

    public boolean isHca() {
        return this.hca;
    }

    public boolean isTelephone() {
        return this.telephone;
    }

    public boolean isEfficiencyAssist() {
        return this.efficiencyAssist;
    }

    public boolean isSpeedLimiter() {
        return this.speedLimiter;
    }

    public boolean isColourDesignAuto() {
        return this.colourDesignAuto;
    }

    public boolean isColourDesignDay() {
        return this.colourDesignDay;
    }

    public boolean isColourDesignNight() {
        return this.colourDesignNight;
    }

    public boolean isColourDefault() {
        return this.colourDefault;
    }

    public boolean isColourAlternative() {
        return this.colourAlternative;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(750);
        stringBuffer.append("HUDConfiguration");
        stringBuffer.append('(');
        stringBuffer.append("speed");
        stringBuffer.append('=');
        stringBuffer.append(this.speed);
        stringBuffer.append(',');
        stringBuffer.append("warning");
        stringBuffer.append('=');
        stringBuffer.append(this.warning);
        stringBuffer.append(',');
        stringBuffer.append("gra");
        stringBuffer.append('=');
        stringBuffer.append(this.gra);
        stringBuffer.append(',');
        stringBuffer.append("nightvision");
        stringBuffer.append('=');
        stringBuffer.append(this.nightvision);
        stringBuffer.append(',');
        stringBuffer.append("roadsign");
        stringBuffer.append('=');
        stringBuffer.append(this.roadsign);
        stringBuffer.append(',');
        stringBuffer.append("rgi");
        stringBuffer.append('=');
        stringBuffer.append(this.rgi);
        stringBuffer.append(',');
        stringBuffer.append("navInfo");
        stringBuffer.append('=');
        stringBuffer.append(this.navInfo);
        stringBuffer.append(',');
        stringBuffer.append("infoList");
        stringBuffer.append('=');
        stringBuffer.append(this.infoList);
        stringBuffer.append(',');
        stringBuffer.append("hca");
        stringBuffer.append('=');
        stringBuffer.append(this.hca);
        stringBuffer.append(',');
        stringBuffer.append("acc");
        stringBuffer.append('=');
        stringBuffer.append(this.acc);
        stringBuffer.append(',');
        stringBuffer.append("telephone");
        stringBuffer.append('=');
        stringBuffer.append(this.telephone);
        stringBuffer.append(',');
        stringBuffer.append("efficiencyAssist");
        stringBuffer.append('=');
        stringBuffer.append(this.efficiencyAssist);
        stringBuffer.append(',');
        stringBuffer.append("speedLimiter");
        stringBuffer.append('=');
        stringBuffer.append(this.speedLimiter);
        stringBuffer.append(',');
        stringBuffer.append("colourDesignAuto");
        stringBuffer.append('=');
        stringBuffer.append(this.colourDesignAuto);
        stringBuffer.append(',');
        stringBuffer.append("colourDesignDay");
        stringBuffer.append('=');
        stringBuffer.append(this.colourDesignDay);
        stringBuffer.append(',');
        stringBuffer.append("colourDesignNight");
        stringBuffer.append('=');
        stringBuffer.append(this.colourDesignNight);
        stringBuffer.append(',');
        stringBuffer.append("colourDefault");
        stringBuffer.append('=');
        stringBuffer.append(this.colourDefault);
        stringBuffer.append(',');
        stringBuffer.append("colourAlternative");
        stringBuffer.append('=');
        stringBuffer.append(this.colourAlternative);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

