/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.view.internal.treebuilder;

import de.vw.mib.log4mib.Logger;
import de.vw.mib.view.internal.treebuilder.Dumpable;
import de.vw.mib.view.internal.treebuilder.PoolingUIFactory$UIPool;
import de.vw.mib.view.internal.treebuilder.UIFactory;
import de.vw.mib.widgets.ui.WidgetUI;

public class PoolingUIFactory
implements UIFactory,
Dumpable {
    public static final String DUMP_HEAD;
    private final UIFactory nullFactory;
    private final UIFactory[] factories;

    public PoolingUIFactory(UIFactory uIFactory, int[] nArray) {
        this.nullFactory = uIFactory;
        this.factories = new UIFactory[nArray.length];
        for (int i2 = 0; i2 < this.factories.length; ++i2) {
            int n = nArray[i2];
            this.factories[i2] = n == 0 ? uIFactory : new PoolingUIFactory$UIPool(nArray[i2], uIFactory, i2);
        }
    }

    public void fillPools(float f2) {
        for (int i2 = 0; i2 < this.factories.length; ++i2) {
            if (!(this.factories[i2] instanceof PoolingUIFactory$UIPool)) continue;
            PoolingUIFactory$UIPool poolingUIFactory$UIPool = (PoolingUIFactory$UIPool)this.factories[i2];
            int n = Math.round((float)poolingUIFactory$UIPool.capacity() * f2);
            this.fillPool(poolingUIFactory$UIPool, n);
        }
    }

    private void fillPool(PoolingUIFactory$UIPool poolingUIFactory$UIPool, int n) {
        for (int i2 = poolingUIFactory$UIPool.size(); i2 <= n; ++i2) {
            poolingUIFactory$UIPool.addObject();
        }
    }

    @Override
    public WidgetUI getUIInstance(int n) {
        return n == 0 ? this.nullFactory.getUIInstance(n) : this.factories[n].getUIInstance(n);
    }

    @Override
    public void releaseUIInstance(int n, WidgetUI widgetUI) {
        this.factories[n].releaseUIInstance(n, widgetUI);
    }

    @Override
    public void dump(Logger logger, int n) {
        for (int i2 = 0; i2 < this.factories.length; ++i2) {
            if (!(this.factories[i2] instanceof PoolingUIFactory$UIPool)) continue;
            PoolingUIFactory$UIPool poolingUIFactory$UIPool = (PoolingUIFactory$UIPool)this.factories[i2];
            poolingUIFactory$UIPool.appendDump(logger.trace(n)).log();
        }
    }
}

