/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets.log;

import de.vw.mib.log4mib.LogMessage;
import de.vw.mib.widgets.controller.WidgetController;
import de.vw.mib.widgets.models.WidgetModel;

public interface Logger {
    default public LogMessage error() {
    }

    default public LogMessage error(WidgetModel widgetModel) {
    }

    default public LogMessage error(WidgetController widgetController) {
    }

    default public LogMessage normal() {
    }

    default public LogMessage normal(WidgetModel widgetModel) {
    }

    default public LogMessage normal(WidgetController widgetController) {
    }

    default public boolean isTraceEnabled() {
    }

    default public LogMessage trace() {
    }

    default public LogMessage trace(WidgetModel widgetModel) {
    }

    default public LogMessage trace(WidgetController widgetController) {
    }

    default public LogMessage warn() {
    }

    default public LogMessage warn(WidgetModel widgetModel) {
    }

    default public LogMessage warn(WidgetController widgetController) {
    }
}

