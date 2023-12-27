/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.view.internal.treebuilder;

import de.vw.mib.log4mib.LogMessage;
import de.vw.mib.pool.PooledObject;
import de.vw.mib.pool.defaultimpl.AbstractSynchronizedObjectPool;
import de.vw.mib.view.internal.treebuilder.ControllerFactory;
import de.vw.mib.view.internal.treebuilder.DumpingPoolSizeMonitor;
import de.vw.mib.widgets.controller.WidgetController;

final class PoolingControllerFactory$ControllerPool
extends AbstractSynchronizedObjectPool
implements ControllerFactory {
    private final ControllerFactory innerFactory;
    private final int controllerType;

    public PoolingControllerFactory$ControllerPool(int n, ControllerFactory controllerFactory, int n2) {
        super(n);
        this.innerFactory = controllerFactory;
        this.controllerType = n2;
        this.setPoolMonitor(new DumpingPoolSizeMonitor(this));
    }

    @Override
    protected PooledObject createObjectInternal() {
        return (PooledObject)((Object)this.innerFactory.getControllerInstance(this.controllerType));
    }

    @Override
    protected void dropObjectInternal(PooledObject pooledObject) {
        this.innerFactory.releaseControllerInstance(this.controllerType, (WidgetController)((Object)pooledObject));
    }

    @Override
    public WidgetController getControllerInstance(int n) {
        return (WidgetController)((Object)this.borrowObject());
    }

    @Override
    public void releaseControllerInstance(int n, WidgetController widgetController) {
        if (widgetController instanceof PooledObject) {
            this.releaseObject((PooledObject)((Object)widgetController));
        } else {
            this.innerFactory.releaseControllerInstance(this.controllerType, widgetController);
        }
    }

    public int capacity() {
        return this.stack.length;
    }

    public LogMessage appendDump(LogMessage logMessage) {
        logMessage.append("ControllerFactory pool dump");
        logMessage.append(" - controllerType=").append(this.controllerType);
        return ((DumpingPoolSizeMonitor)this.monitor).appendDump(logMessage);
    }
}

