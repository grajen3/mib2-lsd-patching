/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.carstatustiles.appui.internal;

import de.vw.mib.appui.cio.AbstractCioVisualizationService;
import de.vw.mib.cio.CioIntentVisualizationImpl;
import de.vw.mib.cio.framework.CioIdService;
import de.vw.mib.cio.framework.CioIntentVisualization;
import generated.de.vw.mib.global.datapool.SkinDataPool;

public class CarStatusTileScioVisualizationService
extends AbstractCioVisualizationService {
    private static final int V_CAR_STATUS_TILE_SHEADER_BUTTON_ACTION__CAR_STATUS_TILE_SHEADER1;
    private static final int V_CAR_STATUS_TILE_SHEADER_BUTTON_ACTION__CAR_STATUS_TILE_SHEADER2;
    private static final int V_CAR_STATUS_TILE_SHEADER_BUTTON_ACTION__CAR_STATUS_TILE_SHEADER3;
    private static final int V_CREATE_HOSTED_APP__CAR_STATUS_TILE_SBACK;
    private static final int COUNT;

    public CarStatusTileScioVisualizationService(String string) {
        super("CarStatusTileS", string, 4);
    }

    @Override
    protected void loadMapping(CioIdService cioIdService) {
        this.putIndexIdMapping(0, cioIdService, "CarStatusTileSHeaderButtonAction", "CarStatusTileSHeader1");
        this.putIndexIdMapping(1, cioIdService, "CarStatusTileSHeaderButtonAction", "CarStatusTileSHeader2");
        this.putIndexIdMapping(2, cioIdService, "CarStatusTileSHeaderButtonAction", "CarStatusTileSHeader3");
        this.putIndexIdMapping(3, cioIdService, "CreateHostedApp", "CarStatusTileSBack");
    }

    @Override
    protected CioIntentVisualization getVisualizationByIndex(int n) {
        switch (n) {
            case 0: {
                return new CioIntentVisualizationImpl(null, this.getImageArray(SkinDataPool.getImageVector(5)), SkinDataPool.getColorVector(11), SkinDataPool.getColorVector(10), this.getI18nString(1531), null, null);
            }
            case 1: {
                return new CioIntentVisualizationImpl(null, this.getImageArray(SkinDataPool.getImageVector(6)), SkinDataPool.getColorVector(13), SkinDataPool.getColorVector(12), this.getI18nString(1533), null, null);
            }
            case 2: {
                return new CioIntentVisualizationImpl(null, this.getImageArray(SkinDataPool.getImageVector(7)), SkinDataPool.getColorVector(15), SkinDataPool.getColorVector(14), this.getI18nString(1532), null, null);
            }
            case 3: {
                return new CioIntentVisualizationImpl(null, this.getImageArray(SkinDataPool.getImageVector(11)), SkinDataPool.getColorVector(23), SkinDataPool.getColorVector(22), this.getI18nString(1531), null, null);
            }
        }
        return this.visualizationNotAvailable();
    }
}

