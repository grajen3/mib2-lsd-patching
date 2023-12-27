/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets;

import de.vw.mib.widgets.list.ListItemTransfer;
import de.vw.mib.widgets.models.ListItemModel;

final class AsiaSpeller$ListItemTransferDelegate
implements ListItemTransfer {
    private final ListItemTransfer transferViewHandler;
    private final ListItemTransfer transferSpeller;

    public AsiaSpeller$ListItemTransferDelegate(ListItemTransfer listItemTransfer, ListItemTransfer listItemTransfer2) {
        this.transferViewHandler = listItemTransfer;
        this.transferSpeller = listItemTransfer2;
    }

    public ListItemTransfer getTransferViewHandler() {
        return this.transferViewHandler;
    }

    @Override
    public boolean transferData(ListItemModel listItemModel, int n, int n2) {
        boolean bl = false;
        if (this.transferSpeller != null) {
            bl = this.transferSpeller.transferData(listItemModel, n, n2);
        }
        if (this.transferViewHandler != null) {
            bl = this.transferViewHandler.transferData(listItemModel, n, n2);
        }
        return bl;
    }
}

