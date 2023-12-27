/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets.log;

import de.vw.mib.log4mib.LogMessage;
import de.vw.mib.log4mib.internal.EmptyLoggerFactory;
import de.vw.mib.widgets.controller.WidgetController;
import de.vw.mib.widgets.internal.ServiceManager;
import de.vw.mib.widgets.log.Logger;
import de.vw.mib.widgets.models.WidgetModel;

public abstract class AbstractWidgetLogger
implements Logger {
    protected static de.vw.mib.log4mib.Logger EMPTY_LOGGER = new EmptyLoggerFactory().getLogger(2048);
    protected static de.vw.mib.log4mib.Logger LOGGER = ServiceManager.loggerFactory.getLogger(2048);
    private final int logClassifier;

    protected AbstractWidgetLogger(int n) {
        this.logClassifier = n;
    }

    protected LogMessage initialWidgetControllerLog(WidgetController widgetController, LogMessage logMessage) {
        return logMessage.append("WidgetController '").append(widgetController.getWidget() != null ? widgetController.getWidget().getQualifiedName() : "<UNKNOWN_WIDGET>").append("': ");
    }

    protected LogMessage initialWidgetLog(WidgetModel widgetModel, LogMessage logMessage) {
        return logMessage.append("Widget '").append(widgetModel.getQualifiedName()).append("': ");
    }

    @Override
    public LogMessage error() {
        return LOGGER.error(this.logClassifier);
    }

    @Override
    public LogMessage error(WidgetModel widgetModel) {
        return this.initialWidgetLog(widgetModel, this.error());
    }

    @Override
    public LogMessage error(WidgetController widgetController) {
        return this.initialWidgetControllerLog(widgetController, this.error());
    }

    @Override
    public LogMessage normal() {
        return LOGGER.normal(this.logClassifier);
    }

    @Override
    public LogMessage normal(WidgetModel widgetModel) {
        return this.initialWidgetLog(widgetModel, this.normal());
    }

    @Override
    public LogMessage normal(WidgetController widgetController) {
        return this.initialWidgetControllerLog(widgetController, this.normal());
    }

    @Override
    public boolean isTraceEnabled() {
        return LOGGER.isTraceEnabled(this.logClassifier);
    }

    @Override
    public LogMessage trace() {
        if (this.isTraceEnabled()) {
            return LOGGER.trace(this.logClassifier);
        }
        return EMPTY_LOGGER.trace(this.logClassifier);
    }

    @Override
    public LogMessage trace(WidgetModel widgetModel) {
        return this.initialWidgetLog(widgetModel, this.trace());
    }

    @Override
    public LogMessage trace(WidgetController widgetController) {
        return this.initialWidgetControllerLog(widgetController, this.trace());
    }

    @Override
    public LogMessage warn() {
        return LOGGER.warn(this.logClassifier);
    }

    @Override
    public LogMessage warn(WidgetModel widgetModel) {
        return this.initialWidgetLog(widgetModel, this.warn());
    }

    @Override
    public LogMessage warn(WidgetController widgetController) {
        return this.initialWidgetControllerLog(widgetController, this.warn());
    }
}

