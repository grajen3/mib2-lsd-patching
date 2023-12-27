/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.navmaptile.appui.internal;

import de.vw.mib.appui.cio.AbstractCioVisualizationService;
import de.vw.mib.cio.CioIntentVisualizationImpl;
import de.vw.mib.cio.framework.CioIdService;
import de.vw.mib.cio.framework.CioIntentVisualization;
import generated.de.vw.mib.global.datapool.SkinDataPool;

public class NavMapTileCioVisualizationService
extends AbstractCioVisualizationService {
    private static final int V_CREATE_HOSTED_APP__TILE_BACK;
    private static final int V_TILE_HEADER_BUTTON_ACTION__TILE_HEADER;
    private static final int COUNT;

    public NavMapTileCioVisualizationService(String string) {
        super("NavMapTile", string, 2);
    }

    @Override
    protected void loadMapping(CioIdService cioIdService) {
        this.putIndexIdMapping(0, cioIdService, "CreateHostedApp", "TileBack");
        this.putIndexIdMapping(1, cioIdService, "TileHeaderButtonAction", "TileHeader");
    }

    @Override
    protected CioIntentVisualization getVisualizationByIndex(int n) {
        switch (n) {
            case 0: {
                return new CioIntentVisualizationImpl(null, this.getImageArray(SkinDataPool.getImageVector(14)), SkinDataPool.getColorVector(29), SkinDataPool.getColorVector(28), this.getI18nString(1764), null, null);
            }
            case 1: {
                return new CioIntentVisualizationImpl(null, this.getImageArray(SkinDataPool.getImageVector(55)), SkinDataPool.getColorVector(111), SkinDataPool.getColorVector(110), this.getI18nString(1764), null, null);
            }
        }
        return this.visualizationNotAvailable();
    }
}

