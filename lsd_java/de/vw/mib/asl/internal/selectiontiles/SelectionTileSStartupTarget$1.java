/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.selectiontiles;

import de.vw.mib.asl.api.homescreen.tileselection.TileSelectionAppDescription;
import de.vw.mib.asl.internal.selectiontiles.SelectionTileSStartupTarget;

class SelectionTileSStartupTarget$1
implements TileSelectionAppDescription {
    private final /* synthetic */ SelectionTileSStartupTarget this$0;

    SelectionTileSStartupTarget$1(SelectionTileSStartupTarget selectionTileSStartupTarget) {
        this.this$0 = selectionTileSStartupTarget;
    }

    @Override
    public String getUsage() {
        return "SmallTile";
    }

    @Override
    public int getSelectionListId() {
        return -779333120;
    }

    @Override
    public int getSelectAppAslDownEventParameterIndex() {
        return 0;
    }

    @Override
    public int getSelectAppAslDownEventId() {
        return -1067101632;
    }

    @Override
    public String getTileSelectionAppUsage() {
        return "SmallSelectionTile";
    }

    @Override
    public int getSelectedListIndexDataPoolId() {
        return -762555904;
    }
}

