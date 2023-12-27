/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.util.services.job;

import de.esolutions.fw.util.commons.job.DispatcherBase;
import de.esolutions.fw.util.commons.job.HistoryInterceptor;
import de.esolutions.fw.util.commons.job.IInterceptor;
import de.esolutions.fw.util.commons.job.LogInterceptor;
import de.esolutions.fw.util.commons.job.StatisticInterceptor;
import de.esolutions.fw.util.config.query.IConfigQuery;

public final class InterceptorConfig {
    private String className;
    private IConfigQuery query;

    public void parseConfig(IConfigQuery iConfigQuery) {
        this.className = iConfigQuery.getStringValue("class", this.className);
        this.query = iConfigQuery;
    }

    public String getClassName() {
        return this.className;
    }

    public IInterceptor createInterceptor(DispatcherBase dispatcherBase) {
        if (this.className.equals("History")) {
            int n = this.query.getIntegerValue("historyLen", 10);
            int n2 = this.query.getIntegerValue("jobTimeLimit", 100);
            return new HistoryInterceptor(n, n2);
        }
        if (this.className.equals("Logger")) {
            return new LogInterceptor(dispatcherBase.getName(), dispatcherBase.getLog());
        }
        if (this.className.equals("Statistic")) {
            int n = this.query.getIntegerValue("sampleRate", 1000);
            int n3 = this.query.getIntegerValue("historyLen", 0);
            return new StatisticInterceptor(dispatcherBase, dispatcherBase.getLog(), n, n3);
        }
        return null;
    }
}

