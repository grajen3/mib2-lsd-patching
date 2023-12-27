/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets;

import de.vw.mib.widgets.AsiaSpeller;
import de.vw.mib.widgets.AsiaSpeller$AsiaListItemControl;
import de.vw.mib.widgets.controller.AsiaSpellerController;
import de.vw.mib.widgets.event.OutEventAdapter;

abstract class AsiaSpeller$AsiaOutEventListener
extends OutEventAdapter {
    private final AsiaSpeller$AsiaListItemControl asiaListItemControl;
    private final /* synthetic */ AsiaSpeller this$0;

    protected AsiaSpeller$AsiaOutEventListener(AsiaSpeller asiaSpeller, AsiaSpeller$AsiaListItemControl asiaSpeller$AsiaListItemControl) {
        this.this$0 = asiaSpeller;
        this.asiaListItemControl = asiaSpeller$AsiaListItemControl;
    }

    @Override
    public void outListItemEventFired(String string, int n, int n2, int n3, int n4, String string2, long l) {
        if (string.equals("buttonReleased")) {
            AsiaSpellerController asiaSpellerController;
            int n5 = n2;
            String string3 = this.asiaListItemControl.getCharacter(n5);
            if (n5 >= 0 && n5 < this.asiaListItemControl.getItemCount() && string3 != null && (asiaSpellerController = (AsiaSpellerController)this.this$0.getController()) != null) {
                this.onCharacterSelected(asiaSpellerController, string3, n5);
            }
        }
    }

    protected abstract void onCharacterSelected(AsiaSpellerController asiaSpellerController, String string, int n) {
    }
}

