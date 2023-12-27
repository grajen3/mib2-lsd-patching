/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.view.internal.treebuilder;

import de.vw.mib.log4mib.LogMessage;
import de.vw.mib.pool.PooledObject;
import de.vw.mib.pool.defaultimpl.AbstractSynchronizedObjectPool;
import de.vw.mib.view.internal.treebuilder.DumpingPoolSizeMonitor;
import de.vw.mib.view.internal.treebuilder.UIFactory;
import de.vw.mib.widgets.ui.WidgetUI;

final class PoolingUIFactory$UIPool
extends AbstractSynchronizedObjectPool
implements UIFactory {
    private final UIFactory innerFactory;
    private final int uiType;

    public PoolingUIFactory$UIPool(int n, UIFactory uIFactory, int n2) {
        super(n);
        this.innerFactory = uIFactory;
        this.uiType = n2;
        this.setPoolMonitor(new DumpingPoolSizeMonitor(this));
    }

    @Override
    protected PooledObject createObjectInternal() {
        return (PooledObject)((Object)this.innerFactory.getUIInstance(this.uiType));
    }

    @Override
    protected void dropObjectInternal(PooledObject pooledObject) {
        this.innerFactory.releaseUIInstance(this.uiType, (WidgetUI)((Object)pooledObject));
    }

    @Override
    public WidgetUI getUIInstance(int n) {
        return (WidgetUI)((Object)this.borrowObject());
    }

    @Override
    public void releaseUIInstance(int n, WidgetUI widgetUI) {
        if (widgetUI instanceof PooledObject) {
            this.releaseObject((PooledObject)((Object)widgetUI));
        } else {
            this.innerFactory.releaseUIInstance(this.uiType, widgetUI);
        }
    }

    public int capacity() {
        return this.stack.length;
    }

    public LogMessage appendDump(LogMessage logMessage) {
        logMessage.append("UIFactory pool dump");
        logMessage.append(" - uiType=").append(this.uiType);
        return ((DumpingPoolSizeMonitor)this.monitor).appendDump(logMessage);
    }
}

