/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.navtraffictiles.appui.internal;

import de.vw.mib.appui.cio.AbstractCioVisualizationService;
import de.vw.mib.cio.CioIntentVisualizationImpl;
import de.vw.mib.cio.framework.CioIdService;
import de.vw.mib.cio.framework.CioIntentVisualization;
import generated.de.vw.mib.global.datapool.SkinDataPool;

public class NavTrafficTileScioVisualizationService
extends AbstractCioVisualizationService {
    private static final int V_CREATE_HOSTED_APP__TILE_BACK;
    private static final int V_TILE_HEADER_BUTTON_ACTION__TILE_HEADER;
    private static final int COUNT;

    public NavTrafficTileScioVisualizationService(String string) {
        super("NavTrafficTileS", string, 2);
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
                return new CioIntentVisualizationImpl(null, this.getImageArray(SkinDataPool.getImageVector(15)), SkinDataPool.getColorVector(31), SkinDataPool.getColorVector(30), this.getI18nString(1765), null, null);
            }
            case 1: {
                return new CioIntentVisualizationImpl(null, this.getImageArray(SkinDataPool.getImageVector(56)), SkinDataPool.getColorVector(113), SkinDataPool.getColorVector(112), this.getI18nString(1765), null, null);
            }
        }
        return this.visualizationNotAvailable();
    }
}

