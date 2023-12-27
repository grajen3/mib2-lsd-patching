/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbab2.common.api.persistence;

import de.vw.mib.asl.instrumentcluster.persistence.InstrumentClusterPersistenceService;
import de.vw.mib.asl.instrumentcluster.persistence.InstrumentClusterPersistenceServiceImpl;
import de.vw.mib.bap.mqbab2.common.api.APIFactoryInterface;
import de.vw.mib.bap.mqbab2.common.api.persistence.PersistenceService;
import org.osgi.framework.BundleContext;

public class PersistenceAdapter
implements PersistenceService {
    private APIFactoryInterface apiFactory;
    protected BundleContext bundleContext;
    InstrumentClusterPersistenceService icPersistenceService;

    public PersistenceAdapter(BundleContext bundleContext, APIFactoryInterface aPIFactoryInterface) {
        this.apiFactory = aPIFactoryInterface;
        this.bundleContext = bundleContext;
        this.icPersistenceService = new InstrumentClusterPersistenceServiceImpl();
    }

    protected APIFactoryInterface getAPIFactory() {
        return this.apiFactory;
    }

    @Override
    public boolean isDABLongLabelsActive() {
        return this.icPersistenceService.loadAudioSD_ASGCapabilities().isUseDABLongLabel();
    }

    @Override
    public boolean isSDARSLongLabelsActive() {
        return this.icPersistenceService.loadAudioSD_ASGCapabilities().isUseSDARSLongLabel();
    }

    @Override
    public int getInstrumentClusterDisplaySize() {
        return this.icPersistenceService.loadSDSSD_ASGCapabilities().getInstrumentClusterDisplaySize();
    }

    @Override
    public void setDABLongLabelsActive(boolean bl) {
        this.icPersistenceService.loadAudioSD_ASGCapabilities().setUseDABLongLabel(bl);
    }

    @Override
    public void setSDARSLangLabelsActive(boolean bl) {
        this.icPersistenceService.loadAudioSD_ASGCapabilities().setUseSDARSLongLabel(bl);
    }

    @Override
    public void setInstrumentClusterDisplaySize(int n) {
        this.icPersistenceService.loadSDSSD_ASGCapabilities().setInstrumentClusterDisplaySize(n);
    }
}

