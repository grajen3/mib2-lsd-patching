/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.appadapter.navinfotile;

import de.vw.mib.appadapter.navinfotile.NavInfoTileAdapter;
import de.vw.mib.asl.api.navinfotile.ASLNavInfoTileGuidanceAdapter;

class ASLNavInfoTileGuidanceListener
extends ASLNavInfoTileGuidanceAdapter {
    private NavInfoTileAdapter adapter;

    ASLNavInfoTileGuidanceListener(NavInfoTileAdapter navInfoTileAdapter) {
        this.adapter = navInfoTileAdapter;
    }

    @Override
    public void updateGuidanceState(int n) {
        this.adapter.updateGuidanceState(n);
    }
}

