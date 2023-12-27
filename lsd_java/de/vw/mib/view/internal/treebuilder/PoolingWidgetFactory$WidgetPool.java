/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.view.internal.treebuilder;

import de.vw.mib.log4mib.LogMessage;
import de.vw.mib.pool.PooledObject;
import de.vw.mib.pool.defaultimpl.AbstractSynchronizedObjectPool;
import de.vw.mib.view.internal.treebuilder.DumpingPoolSizeMonitor;
import de.vw.mib.view.internal.treebuilder.WidgetFactory;
import de.vw.mib.widgets.models.WidgetModel;

final class PoolingWidgetFactory$WidgetPool
extends AbstractSynchronizedObjectPool
implements WidgetFactory {
    private final WidgetFactory innerFactory;
    private final int widgetType;

    public PoolingWidgetFactory$WidgetPool(int n, WidgetFactory widgetFactory, int n2) {
        super(n);
        this.innerFactory = widgetFactory;
        this.widgetType = n2;
        this.setPoolMonitor(new DumpingPoolSizeMonitor(this));
    }

    @Override
    protected PooledObject createObjectInternal() {
        return (PooledObject)((Object)this.innerFactory.getWidgetInstance(this.widgetType));
    }

    @Override
    protected void dropObjectInternal(PooledObject pooledObject) {
        this.innerFactory.releaseWidgetInstance(this.widgetType, (WidgetModel)((Object)pooledObject));
    }

    @Override
    public WidgetModel getWidgetInstance(int n) {
        return (WidgetModel)((Object)this.borrowObject());
    }

    @Override
    public void releaseWidgetInstance(int n, WidgetModel widgetModel) {
        if (widgetModel instanceof PooledObject) {
            this.releaseObject((PooledObject)((Object)widgetModel));
        } else {
            this.innerFactory.releaseWidgetInstance(this.widgetType, widgetModel);
        }
    }

    public int capacity() {
        return this.stack.length;
    }

    public LogMessage appendDump(LogMessage logMessage) {
        logMessage.append("WidgetFactory pool dump");
        logMessage.append(" - widgetType=").append(this.widgetType);
        return ((DumpingPoolSizeMonitor)this.monitor).appendDump(logMessage);
    }
}

