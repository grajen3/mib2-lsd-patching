/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.selectiontilel;

import de.vw.mib.asl.api.homescreen.tileselection.TileSelectionAppDescription;
import de.vw.mib.asl.internal.selectiontilel.SelectionTileLStartupTarget;

class SelectionTileLStartupTarget$1
implements TileSelectionAppDescription {
    private final /* synthetic */ SelectionTileLStartupTarget this$0;

    SelectionTileLStartupTarget$1(SelectionTileLStartupTarget selectionTileLStartupTarget) {
        this.this$0 = selectionTileLStartupTarget;
    }

    @Override
    public String getUsage() {
        return "BigTile";
    }

    @Override
    public int getSelectionListId() {
        return 1897092096;
    }

    @Override
    public int getSelectAppAslDownEventParameterIndex() {
        return 0;
    }

    @Override
    public int getSelectAppAslDownEventId() {
        return 1626100544;
    }

    @Override
    public String getTileSelectionAppUsage() {
        return "BigSelectionTile";
    }

    @Override
    public int getSelectedListIndexDataPoolId() {
        return 1913869312;
    }
}

