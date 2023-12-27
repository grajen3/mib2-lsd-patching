/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.view.internal.treebuilder;

import de.vw.mib.log4mib.Logger;
import de.vw.mib.view.internal.treebuilder.Dumpable;
import de.vw.mib.view.internal.treebuilder.PoolingWidgetFactory$WidgetPool;
import de.vw.mib.view.internal.treebuilder.WidgetFactory;
import de.vw.mib.widgets.models.WidgetModel;

public class PoolingWidgetFactory
implements WidgetFactory,
Dumpable {
    public static final String DUMP_HEAD;
    private final WidgetFactory[] factories;

    public PoolingWidgetFactory(WidgetFactory widgetFactory, int[] nArray) {
        this.factories = new WidgetFactory[nArray.length];
        for (int i2 = 0; i2 < this.factories.length; ++i2) {
            int n = nArray[i2];
            this.factories[i2] = n == 0 ? widgetFactory : new PoolingWidgetFactory$WidgetPool(nArray[i2], widgetFactory, i2);
        }
    }

    public void fillPools(float f2) {
        for (int i2 = 0; i2 < this.factories.length; ++i2) {
            if (!(this.factories[i2] instanceof PoolingWidgetFactory$WidgetPool)) continue;
            PoolingWidgetFactory$WidgetPool poolingWidgetFactory$WidgetPool = (PoolingWidgetFactory$WidgetPool)this.factories[i2];
            int n = Math.round((float)poolingWidgetFactory$WidgetPool.capacity() * f2);
            this.fillPool(poolingWidgetFactory$WidgetPool, n);
        }
    }

    private void fillPool(PoolingWidgetFactory$WidgetPool poolingWidgetFactory$WidgetPool, int n) {
        for (int i2 = poolingWidgetFactory$WidgetPool.size(); i2 <= n; ++i2) {
            poolingWidgetFactory$WidgetPool.addObject();
        }
    }

    @Override
    public WidgetModel getWidgetInstance(int n) {
        return this.factories[n].getWidgetInstance(n);
    }

    @Override
    public void releaseWidgetInstance(int n, WidgetModel widgetModel) {
        this.factories[n].releaseWidgetInstance(n, widgetModel);
    }

    @Override
    public void dump(Logger logger, int n) {
        for (int i2 = 0; i2 < this.factories.length; ++i2) {
            if (!(this.factories[i2] instanceof PoolingWidgetFactory$WidgetPool)) continue;
            PoolingWidgetFactory$WidgetPool poolingWidgetFactory$WidgetPool = (PoolingWidgetFactory$WidgetPool)this.factories[i2];
            poolingWidgetFactory$WidgetPool.appendDump(logger.trace(n)).log();
        }
    }
}

