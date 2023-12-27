/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.view.internal.treebuilder;

import de.vw.mib.log4mib.Logger;
import de.vw.mib.view.internal.treebuilder.ControllerFactory;
import de.vw.mib.view.internal.treebuilder.Dumpable;
import de.vw.mib.view.internal.treebuilder.PoolingControllerFactory$ControllerPool;
import de.vw.mib.widgets.controller.WidgetController;

public class PoolingControllerFactory
implements ControllerFactory,
Dumpable {
    public static final String DUMP_HEAD;
    private final ControllerFactory[] factories;

    public PoolingControllerFactory(ControllerFactory controllerFactory, int[] nArray) {
        this.factories = new ControllerFactory[nArray.length];
        for (int i2 = 0; i2 < this.factories.length; ++i2) {
            int n = nArray[i2];
            this.factories[i2] = n == 0 ? controllerFactory : new PoolingControllerFactory$ControllerPool(nArray[i2], controllerFactory, i2);
        }
    }

    public void fillPools(float f2) {
        for (int i2 = 0; i2 < this.factories.length; ++i2) {
            if (!(this.factories[i2] instanceof PoolingControllerFactory$ControllerPool)) continue;
            PoolingControllerFactory$ControllerPool poolingControllerFactory$ControllerPool = (PoolingControllerFactory$ControllerPool)this.factories[i2];
            int n = Math.round((float)poolingControllerFactory$ControllerPool.capacity() * f2);
            this.fillPool(poolingControllerFactory$ControllerPool, n);
        }
    }

    private void fillPool(PoolingControllerFactory$ControllerPool poolingControllerFactory$ControllerPool, int n) {
        for (int i2 = poolingControllerFactory$ControllerPool.size(); i2 <= n; ++i2) {
            poolingControllerFactory$ControllerPool.addObject();
        }
    }

    @Override
    public WidgetController getControllerInstance(int n) {
        return this.factories[n].getControllerInstance(n);
    }

    @Override
    public void releaseControllerInstance(int n, WidgetController widgetController) {
        this.factories[n].releaseControllerInstance(n, widgetController);
    }

    @Override
    public void dump(Logger logger, int n) {
        for (int i2 = 0; i2 < this.factories.length; ++i2) {
            if (!(this.factories[i2] instanceof PoolingControllerFactory$ControllerPool)) continue;
            PoolingControllerFactory$ControllerPool poolingControllerFactory$ControllerPool = (PoolingControllerFactory$ControllerPool)this.factories[i2];
            poolingControllerFactory$ControllerPool.appendDump(logger.trace(n)).log();
        }
    }
}

