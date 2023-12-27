/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.drivingdatatiles.appui.internal;

import de.vw.mib.appui.cio.AbstractCioVisualizationService;
import de.vw.mib.cio.CioIntentVisualizationImpl;
import de.vw.mib.cio.framework.CioIdService;
import de.vw.mib.cio.framework.CioIntentVisualization;
import generated.de.vw.mib.global.datapool.SkinDataPool;

public class DrivingDataTileScioVisualizationService
extends AbstractCioVisualizationService {
    private static final int V_CREATE_HOSTED_APP__DRIVING_DATA_TILE_SBACK;
    private static final int V_DRIVING_DATA_TILE_SHEADER_BUTTON_ACTION__DRIVING_DATA_TILE_SHEADER1;
    private static final int V_DRIVING_DATA_TILE_SHEADER_BUTTON_ACTION__DRIVING_DATA_TILE_SHEADER2;
    private static final int V_DRIVING_DATA_TILE_SHEADER_BUTTON_ACTION__DRIVING_DATA_TILE_SHEADER3;
    private static final int V_DRIVING_DATA_TILE_SHEADER_BUTTON_ACTION__DRIVING_DATA_TILE_SHEADER3B;
    private static final int COUNT;

    public DrivingDataTileScioVisualizationService(String string) {
        super("DrivingDataTileS", string, 5);
    }

    @Override
    protected void loadMapping(CioIdService cioIdService) {
        this.putIndexIdMapping(0, cioIdService, "CreateHostedApp", "DrivingDataTileSBack");
        this.putIndexIdMapping(1, cioIdService, "DrivingDataTileSHeaderButtonAction", "DrivingDataTileSHeader1");
        this.putIndexIdMapping(2, cioIdService, "DrivingDataTileSHeaderButtonAction", "DrivingDataTileSHeader2");
        this.putIndexIdMapping(3, cioIdService, "DrivingDataTileSHeaderButtonAction", "DrivingDataTileSHeader3");
        this.putIndexIdMapping(4, cioIdService, "DrivingDataTileSHeaderButtonAction", "DrivingDataTileSHeader3b");
    }

    @Override
    protected CioIntentVisualization getVisualizationByIndex(int n) {
        switch (n) {
            case 0: {
                return new CioIntentVisualizationImpl(null, this.getImageArray(SkinDataPool.getImageVector(12)), SkinDataPool.getColorVector(25), SkinDataPool.getColorVector(24), this.getI18nString(1781), null, null);
            }
            case 1: {
                return new CioIntentVisualizationImpl(null, this.getImageArray(SkinDataPool.getImageVector(19)), SkinDataPool.getColorVector(39), SkinDataPool.getColorVector(38), this.getI18nString(1785), null, null);
            }
            case 2: {
                return new CioIntentVisualizationImpl(null, this.getImageArray(SkinDataPool.getImageVector(20)), SkinDataPool.getColorVector(41), SkinDataPool.getColorVector(40), this.getI18nString(1782), null, null);
            }
            case 3: {
                return new CioIntentVisualizationImpl(null, this.getImageArray(SkinDataPool.getImageVector(22)), SkinDataPool.getColorVector(45), SkinDataPool.getColorVector(44), this.getI18nString(1784), null, null);
            }
            case 4: {
                return new CioIntentVisualizationImpl(null, this.getImageArray(SkinDataPool.getImageVector(21)), SkinDataPool.getColorVector(43), SkinDataPool.getColorVector(42), this.getI18nString(1783), null, null);
            }
        }
        return this.visualizationNotAvailable();
    }
}

