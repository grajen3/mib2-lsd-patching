/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets;

import de.vw.mib.widgets.AsiaSpeller;
import de.vw.mib.widgets.AsiaSpeller$AsiaListItemControl;

final class AsiaSpeller$PredictionListItemControl
extends AsiaSpeller$AsiaListItemControl {
    public static final int CONTENT_NONE;
    public static final int CONTENT_PREDICTION;
    public static final int CONTENT_RECCHARS;
    public static final int CONTENT_NVC;
    private int contentType = 0;
    private final /* synthetic */ AsiaSpeller this$0;

    public AsiaSpeller$PredictionListItemControl(AsiaSpeller asiaSpeller) {
        this.this$0 = asiaSpeller;
    }

    private boolean checkContentType(String[] stringArray) {
        if (stringArray == null) {
            this.contentType = 0;
            return true;
        }
        return false;
    }

    public int getContentType() {
        return this.contentType;
    }

    public void setNextValidCharacters(String[] stringArray) {
        this.setCharacters(stringArray);
        if (!this.checkContentType(stringArray)) {
            this.contentType = 3;
        }
    }

    public void setPrediction(String[] stringArray) {
        this.setCharacters(stringArray);
        if (!this.checkContentType(stringArray)) {
            this.contentType = 1;
        }
    }

    public void setRecognizedChars(String[] stringArray) {
        this.setCharacters(stringArray);
        if (!this.checkContentType(stringArray)) {
            this.contentType = 2;
        }
    }
}

