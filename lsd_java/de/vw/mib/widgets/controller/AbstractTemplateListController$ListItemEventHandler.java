/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets.controller;

import de.vw.mib.widgets.controller.AbstractTemplateListController;
import de.vw.mib.widgets.event.OutEventAdapter;

final class AbstractTemplateListController$ListItemEventHandler
extends OutEventAdapter {
    private final AbstractTemplateListController controller;

    public AbstractTemplateListController$ListItemEventHandler(AbstractTemplateListController abstractTemplateListController) {
        this.controller = abstractTemplateListController;
    }

    @Override
    public void outListItemEventFired(String string, int n, int n2, int n3, int n4, String string2, long l) {
        if (string == "buttonPressed") {
            this.controller.getTemplateList().setPressedIndex(n);
            this.controller.fire_pressed();
        } else if (string == "buttonReleased") {
            this.controller.getTemplateList().setPressedIndex(-1);
            this.controller.fire_released();
        } else if (string == "buttonLongReleased") {
            this.controller.getTemplateList().setPressedIndex(-1);
            this.controller.fire_released();
        } else if (string == "buttonCancelled") {
            this.controller.getTemplateList().setPressedIndex(-1);
        } else if (string == "itemDragged") {
            this.controller.getTemplateList().dragItem(n);
        } else if (string == "itemDropped") {
            this.controller.getTemplateList().dropItem();
        }
    }
}

