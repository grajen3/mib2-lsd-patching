/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.cio.internal;

import de.vw.mib.cio.CioCreator;
import de.vw.mib.cio.CioExecutor;
import de.vw.mib.cio.CioIntent;
import de.vw.mib.cio.CioPayload;
import de.vw.mib.cio.ContentInformationObject;
import de.vw.mib.cio.internal.AbstractCio;
import de.vw.mib.cio.internal.Cio;
import de.vw.mib.cio.internal.Dictionary;
import de.vw.mib.cio.internal.ForwardingCio;
import de.vw.mib.cio.internal.IdService;
import de.vw.mib.cio.internal.ScriptWidgetService;
import de.vw.mib.log4mib.Logger;

final class IntentCreator
implements CioCreator {
    private static final int LAST_RANK;
    private static final String NO_INTENT_CLASS;
    private static final String NO_USAGE;
    private static final long NO_VISUALIZATION;
    private static final long[] NO_VISUALIZATIONS;
    private int actionId;
    private final String appInstanceName;
    private final String appName;
    private String cioName;
    private Object data;
    private final Dictionary dictionary;
    private final Logger logger;
    private final IdService idService;
    private String cioIntentName;
    private CioPayload payload;
    private final AbstractCio targetCio;
    private final ScriptWidgetService scriptWidgetService;

    IntentCreator(Logger logger, String string, String string2, Dictionary dictionary, IdService idService, ScriptWidgetService scriptWidgetService) {
        this.logger = logger;
        this.appName = string;
        this.appInstanceName = string2;
        this.targetCio = null;
        this.dictionary = dictionary;
        this.idService = idService;
        this.scriptWidgetService = scriptWidgetService;
    }

    IntentCreator(Logger logger, String string, String string2, AbstractCio abstractCio, Dictionary dictionary, IdService idService, ScriptWidgetService scriptWidgetService) {
        this.logger = logger;
        this.appName = string;
        this.appInstanceName = string2;
        this.targetCio = abstractCio;
        this.dictionary = dictionary;
        this.idService = idService;
        this.cioName = abstractCio.getCioName();
        this.cioIntentName = abstractCio.getCioIntentName();
        this.scriptWidgetService = scriptWidgetService;
    }

    @Override
    public CioCreator setActionId(int n) {
        this.actionId = n;
        return this;
    }

    @Override
    public CioCreator setCioName(String string) {
        this.cioName = string;
        return this;
    }

    @Override
    public CioCreator setCioIntentName(String string) {
        this.cioIntentName = string;
        return this;
    }

    @Override
    public CioCreator setPayload(CioPayload cioPayload) {
        this.payload = cioPayload;
        return this;
    }

    @Override
    public CioCreator setPayloadData(Object object) {
        this.data = object;
        return this;
    }

    @Override
    public CioIntent finishCallbackCioIntent(CioExecutor cioExecutor) {
        long l = this.idService.getCioIntentId(this.appName, this.appInstanceName, this.cioName, NO_INTENT_CLASS, this.cioIntentName);
        Cio cio = new Cio(this.appName, this.appInstanceName, this.cioName, this.actionId, this.cioIntentName, NO_INTENT_CLASS, NO_USAGE, -1, this.payload, this.data, l, NO_VISUALIZATIONS, cioExecutor, this.dictionary, this.scriptWidgetService);
        cio.setAvailable(true);
        if (this.logger.isTraceEnabled(4)) {
            this.logger.trace(4).append("finish callback cio: ").append(cio).log();
        }
        return cio;
    }

    @Override
    public ContentInformationObject register(String string, CioExecutor cioExecutor) {
        long l = this.idService.getCioIntentId(this.appName, this.appInstanceName, this.cioName, string, this.cioIntentName);
        AbstractCio abstractCio = this.targetCio == null ? new Cio(this.appName, this.appInstanceName, this.cioName, this.actionId, this.cioIntentName, string, NO_USAGE, -1, this.payload, this.data, l, NO_VISUALIZATIONS, cioExecutor, this.dictionary, this.scriptWidgetService) : new ForwardingCio(this.appName, this.appInstanceName, this.cioName, this.cioIntentName, string, NO_USAGE, -1, l, this.targetCio, this.dictionary, this.scriptWidgetService);
        this.dictionary.registerCio(abstractCio);
        if (this.logger.isTraceEnabled(4)) {
            this.logger.trace(4).append("finish and register cio: ").append(abstractCio).log();
        }
        return abstractCio;
    }

    @Override
    public ContentInformationObject register(String string, String string2, CioExecutor cioExecutor) {
        AbstractCio abstractCio;
        if (this.targetCio == null) {
            long l = this.idService.getCioIntentId(this.appName, this.appInstanceName, this.cioName, string, this.cioIntentName);
            abstractCio = new Cio(this.appName, this.appInstanceName, this.cioName, this.actionId, this.cioIntentName, string, string2, -1, this.payload, this.data, l, NO_VISUALIZATIONS, cioExecutor, this.dictionary, this.scriptWidgetService);
        } else {
            long l = this.idService.getCioIntentId(this.appName, this.appInstanceName, this.targetCio.getCioName(), string, this.targetCio.getCioIntentName());
            abstractCio = new ForwardingCio(this.appName, this.appInstanceName, this.cioName, this.cioIntentName, string, string2, -1, l, this.targetCio, this.dictionary, this.scriptWidgetService);
        }
        this.dictionary.registerCio(abstractCio);
        if (this.logger.isTraceEnabled(4)) {
            this.logger.trace(4).append("finish and register cio: ").append(abstractCio).log();
        }
        return abstractCio;
    }

    static {
        NO_INTENT_CLASS = CioIntent.NO_INTENT_CLASS;
        NO_USAGE = CioIntent.NO_USAGE;
        NO_VISUALIZATIONS = new long[]{0L};
    }
}

