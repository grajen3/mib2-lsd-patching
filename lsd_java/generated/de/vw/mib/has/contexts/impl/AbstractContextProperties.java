/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.has.contexts.impl;

import de.vw.mib.has.HASBaseContainerFactory;
import de.vw.mib.has.HASContainer;
import de.vw.mib.has.HASContextProperties;
import de.vw.mib.has.HASDatapool;
import org.dsi.ifc.global.ResourceLocator;

public class AbstractContextProperties
implements HASDatapool,
HASContextProperties {
    private final HASDatapool datapool;
    private final HASBaseContainerFactory baseContainerFactory;

    protected AbstractContextProperties(HASDatapool hASDatapool, HASBaseContainerFactory hASBaseContainerFactory) {
        this.datapool = hASDatapool;
        this.baseContainerFactory = hASBaseContainerFactory;
    }

    @Override
    public void updateProperty(int n, HASContainer hASContainer) {
        this.datapool.updateProperty(n, hASContainer);
    }

    protected void updateProperty(int n, int n2, byte[] byArray) {
        HASContainer hASContainer = this.baseContainerFactory.createBinaryContainer(n2, byArray);
        this.datapool.updateProperty(n, hASContainer);
    }

    protected void updateProperty(int n, int n2, boolean bl) {
        HASContainer hASContainer = this.baseContainerFactory.createBooleanContainer(n2, bl);
        this.datapool.updateProperty(n, hASContainer);
    }

    protected void updateProperty(int n, int n2, double d2) {
        HASContainer hASContainer = this.baseContainerFactory.createDoubleContainer(n2, d2);
        this.datapool.updateProperty(n, hASContainer);
    }

    protected void updateProperty(int n, int n2, int n3) {
        HASContainer hASContainer = this.baseContainerFactory.createIntContainer(n2, n3);
        this.datapool.updateProperty(n, hASContainer);
    }

    protected void updateProperty(int n, int n2, long l) {
        HASContainer hASContainer = this.baseContainerFactory.createLongContainer(n2, l);
        this.datapool.updateProperty(n, hASContainer);
    }

    protected void updateProperty(int n, int n2, ResourceLocator resourceLocator) {
        HASContainer hASContainer = this.baseContainerFactory.createResourceLocatorContainer(n2, resourceLocator);
        this.datapool.updateProperty(n, hASContainer);
    }

    protected void updateProperty(int n, int n2, String string) {
        HASContainer hASContainer = this.baseContainerFactory.createStringContainer(n2, string);
        this.datapool.updateProperty(n, hASContainer);
    }
}

