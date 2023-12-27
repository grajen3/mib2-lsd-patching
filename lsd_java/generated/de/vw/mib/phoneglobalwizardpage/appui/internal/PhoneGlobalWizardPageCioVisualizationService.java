/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.phoneglobalwizardpage.appui.internal;

import de.vw.mib.appui.cio.AbstractCioVisualizationService;
import de.vw.mib.cio.CioIntentVisualizationImpl;
import de.vw.mib.cio.framework.CioIdService;
import de.vw.mib.cio.framework.CioIntentVisualization;
import generated.de.vw.mib.global.datapool.SkinDataPool;

public class PhoneGlobalWizardPageCioVisualizationService
extends AbstractCioVisualizationService {
    private static final int V_INIT_GLOBAL_WIZARD_PAGE__WIZARD_PAGE;
    private static final int COUNT;

    public PhoneGlobalWizardPageCioVisualizationService(String string) {
        super("PhoneGlobalWizardPage", string, 1);
    }

    @Override
    protected void loadMapping(CioIdService cioIdService) {
        this.putIndexIdMapping(0, cioIdService, "InitGlobalWizardPage", "WizardPage");
    }

    @Override
    protected CioIntentVisualization getVisualizationByIndex(int n) {
        switch (n) {
            case 0: {
                return new CioIntentVisualizationImpl(null, this.getImageArray(SkinDataPool.getImageVector(27)), SkinDataPool.getColorVector(55), SkinDataPool.getColorVector(54), this.getI18nString(5026), null, null);
            }
        }
        return this.visualizationNotAvailable();
    }
}

