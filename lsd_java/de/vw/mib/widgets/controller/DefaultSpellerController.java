/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets.controller;

import de.vw.mib.widgets.controller.AbstractSpellerController;
import de.vw.mib.widgets.models.SpellerButtonModel;
import de.vw.mib.widgets.models.SpellerModel;
import de.vw.mib.widgets.speller.LanguageModifier;
import de.vw.mib.widgets.speller.SpellerElement;

public final class DefaultSpellerController
extends AbstractSpellerController {
    @Override
    protected void resolveFire(boolean bl, SpellerButtonModel spellerButtonModel) {
        String string;
        SpellerModel spellerModel = (SpellerModel)this.getWidget();
        SpellerElement spellerElement = spellerButtonModel.getSpellerElement();
        String string2 = string = spellerElement != null ? spellerElement.getReturnFunction() : "";
        if (string.equalsIgnoreCase("FUNC_LANG")) {
            if (!bl) {
                int n = LanguageModifier.adjustIndexForAdditionalLanguage(spellerModel);
                if (n != -1) {
                    spellerModel.set_languageIndex(n);
                    spellerModel.handleLanguageFlagContainer();
                } else {
                    super.resolveFire(bl, spellerButtonModel);
                }
            } else {
                super.resolveFire(bl, spellerButtonModel);
            }
        } else {
            super.resolveFire(bl, spellerButtonModel);
        }
    }
}

