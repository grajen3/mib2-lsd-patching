/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.cio.internal;

import de.vw.mib.cio.CioCreator;
import de.vw.mib.cio.CioExecutor;
import de.vw.mib.cio.CioFactory;
import de.vw.mib.cio.CioIntent;
import de.vw.mib.cio.CioParametersCreator;
import de.vw.mib.cio.app.framework.AppFrameworkCioFactory;
import de.vw.mib.cio.app.framework.AppLifecycleCioExecutor;
import de.vw.mib.cio.app.framework.CioIntentDefinition;
import de.vw.mib.cio.app.framework.ShowContentCioExecutor;
import de.vw.mib.cio.internal.AbstractCio;
import de.vw.mib.cio.internal.AppLifecycleCioImpl;
import de.vw.mib.cio.internal.Cio;
import de.vw.mib.cio.internal.Dictionary;
import de.vw.mib.cio.internal.Factory$1;
import de.vw.mib.cio.internal.Factory$FeatureFlagObserver;
import de.vw.mib.cio.internal.ForwardingCio;
import de.vw.mib.cio.internal.IdService;
import de.vw.mib.cio.internal.IntentCreator;
import de.vw.mib.cio.internal.ParametersCreator;
import de.vw.mib.cio.internal.ScriptWidgetService;
import de.vw.mib.cio.internal.ShowContentCioImpl;
import de.vw.mib.configuration.ConfigurationManager;
import de.vw.mib.log4mib.Logger;

final class Factory
implements AppFrameworkCioFactory,
CioFactory {
    private final ConfigurationManager configurationManager;
    final Dictionary dictionary;
    private final IdService idService;
    final Logger logger;
    ScriptWidgetService scriptWidgetService;

    Factory(Logger logger, ConfigurationManager configurationManager, Dictionary dictionary, IdService idService) {
        this.logger = logger;
        this.configurationManager = configurationManager;
        this.dictionary = dictionary;
        this.idService = idService;
    }

    @Override
    public CioParametersCreator createActionParameters(CioIntent cioIntent) {
        return new ParametersCreator();
    }

    @Override
    public void createAndRegisterAppLifecycleCio(CioIntentDefinition cioIntentDefinition, CioExecutor cioExecutor, AppLifecycleCioExecutor appLifecycleCioExecutor) {
        String string = cioIntentDefinition.getAppName();
        String string2 = cioIntentDefinition.getAppInstanceName();
        String string3 = cioIntentDefinition.getCioName();
        int n = cioIntentDefinition.getFeatureFlagId();
        String string4 = cioIntentDefinition.getIntentName();
        String string5 = cioIntentDefinition.getCioIntentClassName();
        String string6 = cioIntentDefinition.getUsage();
        int n2 = cioIntentDefinition.getRank();
        String[] stringArray = cioIntentDefinition.getCioVisualizationNames();
        long[] lArray = this.getVisualizationIds(stringArray, string, string2, string3);
        long l = this.idService.getCioIntentId(string, string2, string3, string5, string4);
        AppLifecycleCioImpl appLifecycleCioImpl = new AppLifecycleCioImpl(string, string2, string3, string4, string5, string6, n2, l, lArray, appLifecycleCioExecutor, this.dictionary, this.scriptWidgetService);
        this.registerIfRequested(appLifecycleCioImpl, n, cioExecutor);
    }

    @Override
    public void createAndRegisterCio(CioIntentDefinition cioIntentDefinition, CioExecutor cioExecutor) {
        String string = cioIntentDefinition.getAppName();
        String string2 = cioIntentDefinition.getAppInstanceName();
        String string3 = cioIntentDefinition.getCioName();
        int n = cioIntentDefinition.getActionId();
        int n2 = cioIntentDefinition.getFeatureFlagId();
        String string4 = cioIntentDefinition.getIntentName();
        String string5 = cioIntentDefinition.getCioIntentClassName();
        String string6 = cioIntentDefinition.getUsage();
        int n3 = cioIntentDefinition.getRank();
        String[] stringArray = cioIntentDefinition.getCioVisualizationNames();
        long[] lArray = this.getVisualizationIds(stringArray, string, string2, string3);
        long l = this.idService.getCioIntentId(string, string2, string3, string5, string4);
        if (cioIntentDefinition.isForwardingCioIntent()) {
            String string7;
            String string8 = cioIntentDefinition.getForwardedCioIntentClassName();
            AbstractCio abstractCio = (AbstractCio)this.dictionary.getCioIntent(string8, string7 = cioIntentDefinition.getForwardedUsageName() == null || cioIntentDefinition.getForwardedUsageName().length() == 0 ? "*" : cioIntentDefinition.getForwardedUsageName());
            if (abstractCio == null) {
                this.dictionary.addCioRegistrationListener(string8, new Factory$1(this, string8, string7, string, string2, string3, string4, string5, string6, n3, l, lArray, n2, cioExecutor));
                return;
            }
            ForwardingCio forwardingCio = new ForwardingCio(string, string2, string3, string4, string5, string6, n3, l, lArray, abstractCio, this.dictionary, this.scriptWidgetService);
            this.registerIfRequested(forwardingCio, n2, cioExecutor);
        } else {
            Cio cio = new Cio(string, string2, string3, n, string4, string5, string6, n3, l, lArray, cioExecutor, this.dictionary, this.scriptWidgetService);
            this.registerIfRequested(cio, n2, cioExecutor);
        }
    }

    @Override
    public void createAndRegisterShowContentCio(CioIntentDefinition cioIntentDefinition, String string, String string2, CioExecutor cioExecutor, ShowContentCioExecutor showContentCioExecutor) {
        String string3 = cioIntentDefinition.getAppName();
        String string4 = cioIntentDefinition.getAppInstanceName();
        String string5 = cioIntentDefinition.getCioName();
        String string6 = cioIntentDefinition.getIntentName();
        String string7 = cioIntentDefinition.getCioIntentClassName();
        String string8 = string;
        int n = cioIntentDefinition.getRank();
        String[] stringArray = cioIntentDefinition.getCioVisualizationNames();
        long[] lArray = this.getVisualizationIds(stringArray, string3, string4, string5);
        long l = this.idService.getCioIntentId(string3, string4, string5, string7, string6);
        ShowContentCioImpl showContentCioImpl = new ShowContentCioImpl(string3, string4, string, string2, string5, string6, string7, string8, n, l, lArray, showContentCioExecutor, this.dictionary, this.scriptWidgetService);
        this.registerIfRequested(showContentCioImpl, cioExecutor);
    }

    @Override
    public CioCreator createCio(String string, String string2) {
        return new IntentCreator(this.logger, string, string2, this.dictionary, this.idService, this.scriptWidgetService);
    }

    @Override
    public CioCreator createForwardingCio(String string, String string2, CioIntent cioIntent) {
        return new IntentCreator(this.logger, string, string2, (AbstractCio)cioIntent, this.dictionary, this.idService, this.scriptWidgetService);
    }

    @Override
    public CioParametersCreator createPayload() {
        return new ParametersCreator();
    }

    @Override
    public void unregisterCio(CioIntentDefinition cioIntentDefinition) {
        String string;
        String string2;
        String string3;
        String string4;
        String string5 = cioIntentDefinition.getAppName();
        long l = this.idService.getCioIntentId(string5, string4 = cioIntentDefinition.getAppInstanceName(), string3 = cioIntentDefinition.getCioName(), string2 = cioIntentDefinition.getCioIntentClassName(), string = cioIntentDefinition.getIntentName());
        AbstractCio abstractCio = this.dictionary.getCioIntentById(l);
        if (abstractCio == null) {
            return;
        }
        this.dictionary.unregisterCio(abstractCio);
    }

    void registerIfRequested(AbstractCio abstractCio, CioExecutor cioExecutor) {
        if (cioExecutor == null) {
            this.dictionary.registerCio(abstractCio);
            if (this.logger.isTraceEnabled(4)) {
                this.logger.trace(4).append("cio intent ").append(abstractCio).append(" registered!").log();
            }
        } else if (!cioExecutor.onCioIntentRegistration(abstractCio)) {
            this.dictionary.registerCio(abstractCio);
            if (this.logger.isTraceEnabled(4)) {
                this.logger.trace(4).append("cio intent ").append(abstractCio).append(" registered (approved by cio executor)!").log();
            }
        } else if (this.logger.isTraceEnabled(4)) {
            this.logger.trace(4).append("cio intent ").append(abstractCio).append(" not registered (declined by cio executor)!").log();
        }
    }

    void registerIfRequested(AbstractCio abstractCio, int n, CioExecutor cioExecutor) {
        if (n == -1) {
            if (this.logger.isTraceEnabled(4)) {
                this.logger.trace(4).append("registering cio intent ").append(abstractCio).append(" (no feature flag specified)").log();
            }
            this.registerIfRequested(abstractCio, cioExecutor);
        } else {
            if (this.configurationManager.isFeatureFlagSet(n)) {
                if (this.logger.isTraceEnabled(4)) {
                    this.logger.trace(4).append("registering cio intent ").append(abstractCio).append(" (specified feature flag is true)").log();
                }
                this.registerIfRequested(abstractCio, cioExecutor);
            } else if (this.logger.isTraceEnabled(4)) {
                this.logger.trace(4).append("don't register cio intent ").append(abstractCio).append(" (specified feature flag is false)").log();
            }
            Factory$FeatureFlagObserver factory$FeatureFlagObserver = new Factory$FeatureFlagObserver(this, abstractCio, n, cioExecutor);
            this.configurationManager.addFeatureFlagValueChangeReceiver(factory$FeatureFlagObserver, n);
        }
    }

    void setScriptWidgetService(ScriptWidgetService scriptWidgetService) {
        this.scriptWidgetService = scriptWidgetService;
    }

    private long[] getVisualizationIds(String[] stringArray, String string, String string2, String string3) {
        if (stringArray == null || stringArray.length == 0) {
            return new long[]{0L};
        }
        long[] lArray = new long[stringArray.length];
        for (int i2 = 0; i2 < stringArray.length; ++i2) {
            String string4 = stringArray[i2];
            lArray[i2] = string4 == null || string4.length() == 0 ? 0L : this.idService.getCioVisualizationId(string, string2, string3, string4);
        }
        return lArray;
    }
}

