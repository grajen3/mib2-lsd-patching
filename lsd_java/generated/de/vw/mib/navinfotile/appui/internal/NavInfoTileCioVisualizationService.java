/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.navinfotile.appui.internal;

import de.vw.mib.appui.cio.AbstractCioVisualizationService;
import de.vw.mib.cio.CioIntentVisualizationImpl;
import de.vw.mib.cio.framework.CioIdService;
import de.vw.mib.cio.framework.CioIntentVisualization;
import generated.de.vw.mib.global.datapool.SkinDataPool;

public class NavInfoTileCioVisualizationService
extends AbstractCioVisualizationService {
    private static final int V_CREATE_HOSTED_APP__TILE_BACK;
    private static final int V_NAV_INFO_TILE_HEADER_BUTTON_ACTION__NAV_INFO_TILE_COMPASS_HEADER;
    private static final int V_NAV_INFO_TILE_HEADER_BUTTON_ACTION__NAV_INFO_TILE_MANEUVER_HEADER;
    private static final int V_NAV_INFO_TILE_HEADER_BUTTON_ACTION__NAV_INFO_TILE_NAVIGATION_HEADER;
    private static final int V_NAV_INFO_TILE_HEADER_BUTTON_ACTION__NAV_INFO_TILE_PNAVHEADER;
    private static final int V_NAV_INFO_TILE_HEADER_BUTTON_ACTION__NAV_INFO_TILE_POSITION_HEADER;
    private static final int V_NAV_INFO_TILE_HEADER_BUTTON_ACTION__NAV_INFO_TILE_WPMHEADER;
    private static final int COUNT;

    public NavInfoTileCioVisualizationService(String string) {
        super("NavInfoTile", string, 7);
    }

    @Override
    protected void loadMapping(CioIdService cioIdService) {
        this.putIndexIdMapping(0, cioIdService, "CreateHostedApp", "TileBack");
        this.putIndexIdMapping(1, cioIdService, "NavInfoTileHeaderButtonAction", "NavInfoTileCompassHeader");
        this.putIndexIdMapping(2, cioIdService, "NavInfoTileHeaderButtonAction", "NavInfoTileManeuverHeader");
        this.putIndexIdMapping(3, cioIdService, "NavInfoTileHeaderButtonAction", "NavInfoTileNavigationHeader");
        this.putIndexIdMapping(4, cioIdService, "NavInfoTileHeaderButtonAction", "NavInfoTilePNAVHeader");
        this.putIndexIdMapping(5, cioIdService, "NavInfoTileHeaderButtonAction", "NavInfoTilePositionHeader");
        this.putIndexIdMapping(6, cioIdService, "NavInfoTileHeaderButtonAction", "NavInfoTileWPMHeader");
    }

    @Override
    protected CioIntentVisualization getVisualizationByIndex(int n) {
        switch (n) {
            case 0: {
                return new CioIntentVisualizationImpl(null, this.getImageArray(SkinDataPool.getImageVector(13)), SkinDataPool.getColorVector(27), SkinDataPool.getColorVector(26), this.getI18nString(1757), null, null);
            }
            case 1: {
                return new CioIntentVisualizationImpl(null, this.getImageArray(SkinDataPool.getImageVector(46)), SkinDataPool.getColorVector(93), SkinDataPool.getColorVector(92), this.getI18nString(1758), null, null);
            }
            case 2: {
                return new CioIntentVisualizationImpl(null, this.getImageArray(SkinDataPool.getImageVector(47)), SkinDataPool.getColorVector(95), SkinDataPool.getColorVector(94), this.getI18nString(1759), null, null);
            }
            case 3: {
                return new CioIntentVisualizationImpl(null, this.getImageArray(SkinDataPool.getImageVector(48)), SkinDataPool.getColorVector(97), SkinDataPool.getColorVector(96), this.getI18nString(1760), null, null);
            }
            case 4: {
                return new CioIntentVisualizationImpl(null, this.getImageArray(SkinDataPool.getImageVector(49)), SkinDataPool.getColorVector(99), SkinDataPool.getColorVector(98), this.getI18nString(1761), null, null);
            }
            case 5: {
                return new CioIntentVisualizationImpl(null, this.getImageArray(SkinDataPool.getImageVector(50)), SkinDataPool.getColorVector(101), SkinDataPool.getColorVector(100), this.getI18nString(1762), null, null);
            }
            case 6: {
                return new CioIntentVisualizationImpl(null, this.getImageArray(SkinDataPool.getImageVector(51)), SkinDataPool.getColorVector(103), SkinDataPool.getColorVector(102), this.getI18nString(1763), null, null);
            }
        }
        return this.visualizationNotAvailable();
    }
}

