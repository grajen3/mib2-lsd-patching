/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets;

import de.vw.mib.widgets.PreviewLine;
import de.vw.mib.widgets.models.AbstractSpellerModel;
import de.vw.mib.widgets.models.InputFieldModel;
import de.vw.mib.widgets.speller.InputFieldChangedListener;

final class PreviewLine$InputFieldUpdateHandler
implements InputFieldChangedListener {
    private final /* synthetic */ PreviewLine this$0;

    public PreviewLine$InputFieldUpdateHandler(PreviewLine previewLine) {
        this.this$0 = previewLine;
    }

    @Override
    public void inputFieldChanged(int n) {
        if (this.this$0.is_visible() && this.this$0.areParentsVisible()) {
            InputFieldModel inputFieldModel = this.this$0.get_inputFieldRef();
            AbstractSpellerModel abstractSpellerModel = inputFieldModel.get_spellerRef();
            int n2 = this.this$0.getActiveContent();
            boolean bl = abstractSpellerModel != null && abstractSpellerModel.getEnteredText() != null && abstractSpellerModel.getEnteredText().length() > 0;
            boolean bl2 = n2 == 0 && bl;
            boolean bl3 = n2 == 1 && !bl;
            inputFieldModel.getAbsCursorArea(this.this$0.cursorArea);
            switch (n) {
                case 0: 
                case 1: {
                    if (bl2 || bl3) {
                        this.this$0.evaluateContentImmediately();
                    } else {
                        this.this$0.evaluateContent();
                    }
                    this.this$0.disableAnimations();
                    this.this$0.set_visible(!this.this$0.is_visible());
                    this.this$0.set_visible(!this.this$0.is_visible());
                    this.this$0.enableAnimations();
                    this.this$0.setArrowDestinationArea(this.this$0.cursorArea);
                    break;
                }
                case 2: {
                    this.this$0.setArrowDestinationArea(this.this$0.cursorArea);
                    break;
                }
            }
        }
    }
}

