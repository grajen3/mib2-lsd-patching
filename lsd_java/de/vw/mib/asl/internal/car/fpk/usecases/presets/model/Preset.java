/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.car.fpk.usecases.presets.model;

import de.vw.mib.asl.internal.car.fpk.usecases.content.selection.model.ContentSelection;
import de.vw.mib.asl.internal.car.fpk.usecases.content.setup.model.DisplayElements;
import de.vw.mib.collections.ints.IntObjectMap;
import de.vw.mib.collections.ints.IntObjectOptHashMap;
import org.dsi.ifc.carkombi.DCDisplayPresetsListRecord;

public class Preset {
    private final DCDisplayPresetsListRecord model;
    private final DisplayElements display1Selection;
    private final DisplayElements display2Selection;
    private static final IntObjectMap TYPE_TO_NAME = new IntObjectOptHashMap(4);
    private static final IntObjectMap STATE_TO_NAME = new IntObjectOptHashMap(3);

    public Preset() {
        this(new DCDisplayPresetsListRecord());
    }

    public Preset(DCDisplayPresetsListRecord dCDisplayPresetsListRecord) {
        this.model = dCDisplayPresetsListRecord;
        this.display1Selection = new DisplayElements(1, dCDisplayPresetsListRecord.getDisplay1().getAdditionalInfo1(), dCDisplayPresetsListRecord.getDisplay1().getAdditionalInfo2());
        this.display2Selection = new DisplayElements(2, dCDisplayPresetsListRecord.getDisplay2().getAdditionalInfo1(), dCDisplayPresetsListRecord.getDisplay2().getAdditionalInfo2());
    }

    public void setModelBy(ContentSelection[] contentSelectionArray) {
        for (int i2 = 0; i2 < contentSelectionArray.length; ++i2) {
            ContentSelection contentSelection = contentSelectionArray[i2];
            if (contentSelection == null) continue;
            DisplayElements displayElements = new DisplayElements(contentSelection);
            if (contentSelection.getDisplay() == 1) {
                this.model.display1.additionalInfo1 = displayElements.getAdditionalInfo1();
                this.model.display1.additionalInfo2 = displayElements.getAdditionalInfo2();
            }
            if (contentSelection.getDisplay() != 2) continue;
            this.model.display2.additionalInfo1 = displayElements.getAdditionalInfo1();
            this.model.display2.additionalInfo2 = displayElements.getAdditionalInfo2();
        }
    }

    public DCDisplayPresetsListRecord getModel() {
        return this.model;
    }

    public String getTypeName() {
        return (String)TYPE_TO_NAME.get(this.model.getType());
    }

    public String getStateName() {
        return (String)STATE_TO_NAME.get(this.model.getState());
    }

    public DisplayElements getDisplay1Content() {
        return this.display1Selection;
    }

    public DisplayElements getDisplay2Content() {
        return this.display2Selection;
    }

    public int getTypeId() {
        switch (this.getModel().getType()) {
            case 3: {
                return 1;
            }
            case 2: {
                return 2;
            }
        }
        return 0;
    }

    public String toString() {
        return this.model == null ? "null" : this.model.toString();
    }

    static {
        STATE_TO_NAME.put(0, "empty");
        STATE_TO_NAME.put(1, "predefined");
        STATE_TO_NAME.put(2, "user defined");
        TYPE_TO_NAME.put(2, "classic");
        TYPE_TO_NAME.put(3, "driving profile");
        TYPE_TO_NAME.put(1, "individual");
        TYPE_TO_NAME.put(0, "unknown");
    }
}

