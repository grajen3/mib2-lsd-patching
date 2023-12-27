/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.spellerx;

import de.vw.mib.asl.internal.navigation.spellerx.model.ModelListHandler;
import de.vw.mib.asl.internal.navigation.spellerx.util.DataHelper;
import de.vw.mib.properties.values.SpellerData;
import org.dsi.ifc.navigation.LISpellerData;

public class SpellerField {
    LISpellerData dsiState;
    SpellerData modelSpellerData;
    ModelListHandler listHandler;
    ModelListHandler previewHandler;
    String name;

    public SpellerField(String string, ModelListHandler modelListHandler, ModelListHandler modelListHandler2) {
        this.name = string;
        this.listHandler = modelListHandler;
        this.previewHandler = modelListHandler2;
    }

    public SpellerField(String string, ModelListHandler modelListHandler) {
        this.name = string;
        this.listHandler = modelListHandler;
        this.previewHandler = null;
    }

    public SpellerField(String string) {
        this.name = string;
        this.listHandler = null;
        this.previewHandler = null;
    }

    public void setDSIState(LISpellerData lISpellerData) {
        this.dsiState = lISpellerData;
    }

    public void clearDSIState() {
        this.dsiState = null;
        this.modelSpellerData = null;
    }

    public void setSpellerData(SpellerData spellerData) {
        this.modelSpellerData = spellerData;
    }

    public SpellerData getSpellerData() {
        if (this.modelSpellerData == null) {
            this.modelSpellerData = DataHelper.makeEmptySpellerData();
        }
        return this.modelSpellerData;
    }

    public boolean hasDSIState() {
        return this.dsiState != null;
    }

    public LISpellerData getDSIState() {
        return this.dsiState;
    }

    public String getName() {
        return this.name;
    }

    ModelListHandler getListHandler() {
        return this.listHandler;
    }
}

