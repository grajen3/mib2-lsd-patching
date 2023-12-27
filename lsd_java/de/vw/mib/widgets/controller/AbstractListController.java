/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets.controller;

import de.vw.mib.event.HMIEvent;
import de.vw.mib.event.TouchEvent;
import de.vw.mib.widgets.controller.AbstractWidgetController;
import de.vw.mib.widgets.controller.ListController;
import de.vw.mib.widgets.list.DefaultListSelectionStrategy;
import de.vw.mib.widgets.models.ListModel;

public abstract class AbstractListController
extends AbstractWidgetController
implements ListController {
    @Override
    protected void reset() {
        super.reset();
    }

    @Override
    public void init() {
        super.init();
    }

    protected ListModel getList() {
        return (ListModel)this.getWidget();
    }

    @Override
    public boolean consumeHMIEvent(HMIEvent hMIEvent, String string) {
        boolean bl = false;
        if ("selectNext" == string) {
            this.fire_selectNext();
            bl = true;
        } else if ("selectPrevious" == string) {
            this.fire_selectPrevious();
            bl = true;
        } else if ("press" == string) {
            this.fire_press();
            bl = true;
        } else if ("release" == string) {
            this.fire_release();
            bl = true;
        }
        return bl;
    }

    @Override
    public boolean consumeTouchEvent(TouchEvent touchEvent) {
        return false;
    }

    @Override
    public void fire_selectNext() {
        ListModel listModel = this.getList();
        if (listModel == null) {
            return;
        }
        int n = DefaultListSelectionStrategy.getNextSelectedIndex(listModel);
        if (n != listModel.get_selectedIndex()) {
            listModel.set_selectedIndex(n);
            this.fire_selectionChanged();
        }
    }

    @Override
    public void fire_selectPrevious() {
        ListModel listModel = this.getList();
        if (listModel == null) {
            return;
        }
        int n = DefaultListSelectionStrategy.getPrevSelectedIndex(listModel);
        if (n != listModel.get_selectedIndex()) {
            listModel.set_selectedIndex(n);
            this.fire_selectionChanged();
        }
    }

    @Override
    public void fire_press() {
    }

    public void fire_release() {
    }

    @Override
    public void fire_selectionChanged() {
        ListModel listModel = this.getList();
        this.fireIntegerEvent("selectionChanged", listModel.get_selectedIndex());
    }

    @Override
    public void fire_pressed() {
        this.fireHMIEvent("pressed");
    }

    @Override
    public void fire_released() {
        this.fireHMIEvent("released");
    }

    @Override
    public void revalidateSelectedIndex() {
    }
}

