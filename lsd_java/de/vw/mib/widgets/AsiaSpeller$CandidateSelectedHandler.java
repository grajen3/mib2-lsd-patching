/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets;

import de.vw.mib.widgets.AsiaSpeller;
import de.vw.mib.widgets.AsiaSpeller$AsiaOutEventListener;
import de.vw.mib.widgets.AsiaSpeller$PreviewLineListItemControl;
import de.vw.mib.widgets.controller.AsiaSpellerController;

final class AsiaSpeller$CandidateSelectedHandler
extends AsiaSpeller$AsiaOutEventListener {
    private final /* synthetic */ AsiaSpeller this$0;

    public AsiaSpeller$CandidateSelectedHandler(AsiaSpeller asiaSpeller, AsiaSpeller$PreviewLineListItemControl asiaSpeller$PreviewLineListItemControl) {
        this.this$0 = asiaSpeller;
        super(asiaSpeller, asiaSpeller$PreviewLineListItemControl);
    }

    @Override
    protected void onCharacterSelected(AsiaSpellerController asiaSpellerController, String string, int n) {
        asiaSpellerController.onCandidateSelected(string, n);
    }
}

