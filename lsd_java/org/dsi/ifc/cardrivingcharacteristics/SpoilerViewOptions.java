/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.cardrivingcharacteristics;

import org.dsi.ifc.cardrivingcharacteristics.SpoilerConfiguration;
import org.dsi.ifc.global.CarViewOption;

public class SpoilerViewOptions {
    public CarViewOption positionSelection;
    public CarViewOption position0;
    public CarViewOption position1;
    public CarViewOption position2;
    public CarViewOption position3;
    public CarViewOption position4;
    public CarViewOption position5;
    public CarViewOption state;
    public CarViewOption actuation;
    public CarViewOption messages;
    public CarViewOption setFactoryDefault;
    public CarViewOption systemOnOff;
    public SpoilerConfiguration configuration;

    public SpoilerViewOptions() {
        this.positionSelection = null;
        this.position0 = null;
        this.position1 = null;
        this.position2 = null;
        this.position3 = null;
        this.position4 = null;
        this.position5 = null;
        this.state = null;
        this.actuation = null;
        this.messages = null;
        this.setFactoryDefault = null;
        this.systemOnOff = null;
        this.configuration = null;
    }

    public SpoilerViewOptions(CarViewOption carViewOption, CarViewOption carViewOption2, CarViewOption carViewOption3, CarViewOption carViewOption4, CarViewOption carViewOption5, CarViewOption carViewOption6, CarViewOption carViewOption7, CarViewOption carViewOption8, CarViewOption carViewOption9, CarViewOption carViewOption10, CarViewOption carViewOption11, CarViewOption carViewOption12, SpoilerConfiguration spoilerConfiguration) {
        this.positionSelection = carViewOption;
        this.position0 = carViewOption2;
        this.position1 = carViewOption3;
        this.position2 = carViewOption4;
        this.position3 = carViewOption5;
        this.position4 = carViewOption6;
        this.position5 = carViewOption7;
        this.state = carViewOption8;
        this.actuation = carViewOption9;
        this.messages = carViewOption10;
        this.setFactoryDefault = carViewOption11;
        this.systemOnOff = carViewOption12;
        this.configuration = spoilerConfiguration;
    }

    public CarViewOption getPositionSelection() {
        return this.positionSelection;
    }

    public CarViewOption getPosition0() {
        return this.position0;
    }

    public CarViewOption getPosition1() {
        return this.position1;
    }

    public CarViewOption getPosition2() {
        return this.position2;
    }

    public CarViewOption getPosition3() {
        return this.position3;
    }

    public CarViewOption getPosition4() {
        return this.position4;
    }

    public CarViewOption getPosition5() {
        return this.position5;
    }

    public CarViewOption getState() {
        return this.state;
    }

    public CarViewOption getActuation() {
        return this.actuation;
    }

    public CarViewOption getMessages() {
        return this.messages;
    }

    public CarViewOption getSetFactoryDefault() {
        return this.setFactoryDefault;
    }

    public CarViewOption getSystemOnOff() {
        return this.systemOnOff;
    }

    public SpoilerConfiguration getConfiguration() {
        return this.configuration;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(13400);
        stringBuffer.append("SpoilerViewOptions");
        stringBuffer.append('(');
        stringBuffer.append("positionSelection");
        stringBuffer.append('=');
        stringBuffer.append(this.positionSelection);
        stringBuffer.append(',');
        stringBuffer.append("position0");
        stringBuffer.append('=');
        stringBuffer.append(this.position0);
        stringBuffer.append(',');
        stringBuffer.append("position1");
        stringBuffer.append('=');
        stringBuffer.append(this.position1);
        stringBuffer.append(',');
        stringBuffer.append("position2");
        stringBuffer.append('=');
        stringBuffer.append(this.position2);
        stringBuffer.append(',');
        stringBuffer.append("position3");
        stringBuffer.append('=');
        stringBuffer.append(this.position3);
        stringBuffer.append(',');
        stringBuffer.append("position4");
        stringBuffer.append('=');
        stringBuffer.append(this.position4);
        stringBuffer.append(',');
        stringBuffer.append("position5");
        stringBuffer.append('=');
        stringBuffer.append(this.position5);
        stringBuffer.append(',');
        stringBuffer.append("state");
        stringBuffer.append('=');
        stringBuffer.append(this.state);
        stringBuffer.append(',');
        stringBuffer.append("actuation");
        stringBuffer.append('=');
        stringBuffer.append(this.actuation);
        stringBuffer.append(',');
        stringBuffer.append("messages");
        stringBuffer.append('=');
        stringBuffer.append(this.messages);
        stringBuffer.append(',');
        stringBuffer.append("setFactoryDefault");
        stringBuffer.append('=');
        stringBuffer.append(this.setFactoryDefault);
        stringBuffer.append(',');
        stringBuffer.append("systemOnOff");
        stringBuffer.append('=');
        stringBuffer.append(this.systemOnOff);
        stringBuffer.append(',');
        stringBuffer.append("configuration");
        stringBuffer.append('=');
        stringBuffer.append(this.configuration);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

