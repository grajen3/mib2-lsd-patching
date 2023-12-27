/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.carkombi;

import org.dsi.ifc.carkombi.DCConfiguration;
import org.dsi.ifc.global.CarViewOption;

public class DCViewOptions {
    public CarViewOption brightness;
    public CarViewOption volume;
    public CarViewOption elementContentSelectionList;
    public CarViewOption display1Setup;
    public CarViewOption display1MainSelection;
    public CarViewOption display2Setup;
    public CarViewOption display2MainSelection;
    public CarViewOption display3Setup;
    public CarViewOption display3MainSelection;
    public CarViewOption setFactoryDefault;
    public CarViewOption additionalInstrumentSetup;
    public CarViewOption additionalInstrument2Setup;
    public CarViewOption displayPresetsList;
    public CarViewOption activeDisplayPreset;
    public CarViewOption displayViewConfiguration;
    public CarViewOption displayDependency;
    public CarViewOption ledConfiguration;
    public DCConfiguration configuration;

    public DCViewOptions() {
        this.brightness = null;
        this.volume = null;
        this.elementContentSelectionList = null;
        this.display1Setup = null;
        this.display1MainSelection = null;
        this.display2Setup = null;
        this.display2MainSelection = null;
        this.display3Setup = null;
        this.display3MainSelection = null;
        this.setFactoryDefault = null;
        this.configuration = null;
        this.additionalInstrumentSetup = null;
        this.additionalInstrument2Setup = null;
        this.displayPresetsList = null;
        this.activeDisplayPreset = null;
        this.displayViewConfiguration = null;
        this.ledConfiguration = null;
        this.displayDependency = null;
    }

    public DCViewOptions(CarViewOption carViewOption, CarViewOption carViewOption2, CarViewOption carViewOption3, CarViewOption carViewOption4, CarViewOption carViewOption5, CarViewOption carViewOption6, CarViewOption carViewOption7, CarViewOption carViewOption8, CarViewOption carViewOption9, CarViewOption carViewOption10, DCConfiguration dCConfiguration) {
        this.brightness = carViewOption;
        this.volume = carViewOption2;
        this.elementContentSelectionList = carViewOption3;
        this.display1Setup = carViewOption4;
        this.display1MainSelection = carViewOption5;
        this.display2Setup = carViewOption6;
        this.display2MainSelection = carViewOption7;
        this.display3Setup = carViewOption8;
        this.display3MainSelection = carViewOption9;
        this.setFactoryDefault = carViewOption10;
        this.additionalInstrumentSetup = null;
        this.additionalInstrument2Setup = null;
        this.displayPresetsList = null;
        this.activeDisplayPreset = null;
        this.displayViewConfiguration = null;
        this.displayDependency = null;
        this.ledConfiguration = null;
        this.configuration = dCConfiguration;
    }

    public DCViewOptions(CarViewOption carViewOption, CarViewOption carViewOption2, CarViewOption carViewOption3, CarViewOption carViewOption4, CarViewOption carViewOption5, CarViewOption carViewOption6, CarViewOption carViewOption7, CarViewOption carViewOption8, CarViewOption carViewOption9, CarViewOption carViewOption10, CarViewOption carViewOption11, DCConfiguration dCConfiguration) {
        this.brightness = carViewOption;
        this.volume = carViewOption2;
        this.elementContentSelectionList = carViewOption3;
        this.display1Setup = carViewOption4;
        this.display1MainSelection = carViewOption5;
        this.display2Setup = carViewOption6;
        this.display2MainSelection = carViewOption7;
        this.display3Setup = carViewOption8;
        this.display3MainSelection = carViewOption9;
        this.setFactoryDefault = carViewOption10;
        this.additionalInstrumentSetup = carViewOption11;
        this.additionalInstrument2Setup = null;
        this.displayPresetsList = null;
        this.activeDisplayPreset = null;
        this.displayViewConfiguration = null;
        this.displayDependency = null;
        this.ledConfiguration = null;
        this.configuration = dCConfiguration;
    }

    public DCViewOptions(CarViewOption carViewOption, CarViewOption carViewOption2, CarViewOption carViewOption3, CarViewOption carViewOption4, CarViewOption carViewOption5, CarViewOption carViewOption6, CarViewOption carViewOption7, CarViewOption carViewOption8, CarViewOption carViewOption9, CarViewOption carViewOption10, CarViewOption carViewOption11, CarViewOption carViewOption12, CarViewOption carViewOption13, CarViewOption carViewOption14, CarViewOption carViewOption15, CarViewOption carViewOption16, DCConfiguration dCConfiguration) {
        this.brightness = carViewOption;
        this.volume = carViewOption2;
        this.elementContentSelectionList = carViewOption3;
        this.display1Setup = carViewOption4;
        this.display1MainSelection = carViewOption5;
        this.display2Setup = carViewOption6;
        this.display2MainSelection = carViewOption7;
        this.display3Setup = carViewOption8;
        this.display3MainSelection = carViewOption9;
        this.setFactoryDefault = carViewOption10;
        this.additionalInstrumentSetup = carViewOption11;
        this.additionalInstrument2Setup = carViewOption12;
        this.displayPresetsList = carViewOption13;
        this.activeDisplayPreset = carViewOption14;
        this.displayViewConfiguration = carViewOption15;
        this.displayDependency = carViewOption16;
        this.ledConfiguration = null;
        this.configuration = dCConfiguration;
    }

    public DCViewOptions(CarViewOption carViewOption, CarViewOption carViewOption2, CarViewOption carViewOption3, CarViewOption carViewOption4, CarViewOption carViewOption5, CarViewOption carViewOption6, CarViewOption carViewOption7, CarViewOption carViewOption8, CarViewOption carViewOption9, CarViewOption carViewOption10, CarViewOption carViewOption11, CarViewOption carViewOption12, CarViewOption carViewOption13, CarViewOption carViewOption14, CarViewOption carViewOption15, CarViewOption carViewOption16, CarViewOption carViewOption17, DCConfiguration dCConfiguration) {
        this.brightness = carViewOption;
        this.volume = carViewOption2;
        this.elementContentSelectionList = carViewOption3;
        this.display1Setup = carViewOption4;
        this.display1MainSelection = carViewOption5;
        this.display2Setup = carViewOption6;
        this.display2MainSelection = carViewOption7;
        this.display3Setup = carViewOption8;
        this.display3MainSelection = carViewOption9;
        this.setFactoryDefault = carViewOption10;
        this.additionalInstrumentSetup = carViewOption11;
        this.additionalInstrument2Setup = carViewOption12;
        this.displayPresetsList = carViewOption13;
        this.activeDisplayPreset = carViewOption14;
        this.displayViewConfiguration = carViewOption15;
        this.displayDependency = carViewOption16;
        this.ledConfiguration = carViewOption17;
        this.configuration = dCConfiguration;
    }

    public CarViewOption getBrightness() {
        return this.brightness;
    }

    public CarViewOption getVolume() {
        return this.volume;
    }

    public CarViewOption getElementContentSelectionList() {
        return this.elementContentSelectionList;
    }

    public CarViewOption getDisplay1Setup() {
        return this.display1Setup;
    }

    public CarViewOption getDisplay1MainSelection() {
        return this.display1MainSelection;
    }

    public CarViewOption getDisplay2Setup() {
        return this.display2Setup;
    }

    public CarViewOption getDisplay2MainSelection() {
        return this.display2MainSelection;
    }

    public CarViewOption getDisplay3Setup() {
        return this.display3Setup;
    }

    public CarViewOption getDisplay3MainSelection() {
        return this.display3MainSelection;
    }

    public CarViewOption getSetFactoryDefault() {
        return this.setFactoryDefault;
    }

    public CarViewOption getAdditionalInstrumentSetup() {
        return this.additionalInstrumentSetup;
    }

    public CarViewOption getAdditionalInstrument2Setup() {
        return this.additionalInstrument2Setup;
    }

    public CarViewOption getDisplayPresetsList() {
        return this.displayPresetsList;
    }

    public CarViewOption getActiveDisplayPreset() {
        return this.activeDisplayPreset;
    }

    public CarViewOption getDisplayViewConfiguration() {
        return this.displayViewConfiguration;
    }

    public CarViewOption getDisplayDependency() {
        return this.displayDependency;
    }

    public CarViewOption getLedConfiguration() {
        return this.ledConfiguration;
    }

    public DCConfiguration getConfiguration() {
        return this.configuration;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(18850);
        stringBuffer.append("DCViewOptions");
        stringBuffer.append('(');
        stringBuffer.append("brightness");
        stringBuffer.append('=');
        stringBuffer.append(this.brightness);
        stringBuffer.append(',');
        stringBuffer.append("volume");
        stringBuffer.append('=');
        stringBuffer.append(this.volume);
        stringBuffer.append(',');
        stringBuffer.append("elementContentSelectionList");
        stringBuffer.append('=');
        stringBuffer.append(this.elementContentSelectionList);
        stringBuffer.append(',');
        stringBuffer.append("display1Setup");
        stringBuffer.append('=');
        stringBuffer.append(this.display1Setup);
        stringBuffer.append(',');
        stringBuffer.append("display1MainSelection");
        stringBuffer.append('=');
        stringBuffer.append(this.display1MainSelection);
        stringBuffer.append(',');
        stringBuffer.append("display2Setup");
        stringBuffer.append('=');
        stringBuffer.append(this.display2Setup);
        stringBuffer.append(',');
        stringBuffer.append("display2MainSelection");
        stringBuffer.append('=');
        stringBuffer.append(this.display2MainSelection);
        stringBuffer.append(',');
        stringBuffer.append("display3Setup");
        stringBuffer.append('=');
        stringBuffer.append(this.display3Setup);
        stringBuffer.append(',');
        stringBuffer.append("display3MainSelection");
        stringBuffer.append('=');
        stringBuffer.append(this.display3MainSelection);
        stringBuffer.append(',');
        stringBuffer.append("setFactoryDefault");
        stringBuffer.append('=');
        stringBuffer.append(this.setFactoryDefault);
        stringBuffer.append(',');
        stringBuffer.append("additionalInstrumentSetup");
        stringBuffer.append('=');
        stringBuffer.append(this.additionalInstrumentSetup);
        stringBuffer.append(',');
        stringBuffer.append("additionalInstrument2Setup");
        stringBuffer.append('=');
        stringBuffer.append(this.additionalInstrument2Setup);
        stringBuffer.append(',');
        stringBuffer.append("displayPresetsList");
        stringBuffer.append('=');
        stringBuffer.append(this.displayPresetsList);
        stringBuffer.append(',');
        stringBuffer.append("activeDisplayPreset");
        stringBuffer.append('=');
        stringBuffer.append(this.activeDisplayPreset);
        stringBuffer.append(',');
        stringBuffer.append("displayViewConfiguration");
        stringBuffer.append('=');
        stringBuffer.append(this.displayViewConfiguration);
        stringBuffer.append(',');
        stringBuffer.append("displayDependency");
        stringBuffer.append('=');
        stringBuffer.append(this.displayDependency);
        stringBuffer.append(',');
        stringBuffer.append("ledConfiguration");
        stringBuffer.append('=');
        stringBuffer.append(this.ledConfiguration);
        stringBuffer.append(',');
        stringBuffer.append("configuration");
        stringBuffer.append('=');
        stringBuffer.append(this.configuration);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

