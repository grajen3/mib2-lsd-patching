/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.has.contexts.impl;

import de.vw.mib.has.HASBaseContainerFactory;
import de.vw.mib.has.HASContainer;
import de.vw.mib.has.HASContextResults;
import org.dsi.ifc.global.ResourceLocator;

public abstract class AbstractContextResults
implements HASContextResults {
    private final HASContextResults contextResults;
    private final HASBaseContainerFactory baseContainerFactory;

    protected AbstractContextResults(HASContextResults hASContextResults, HASBaseContainerFactory hASBaseContainerFactory) {
        this.contextResults = hASContextResults;
        this.baseContainerFactory = hASBaseContainerFactory;
    }

    @Override
    public void callResult(int n, int n2, int n3, HASContainer hASContainer) {
        this.contextResults.callResult(n, n2, n3, hASContainer);
    }

    protected void callResult(int n, int n2, int n3) {
        this.contextResults.callResult(n, n2, n3, null);
    }

    protected void callResult(int n, int n2, int n3, int n4, byte[] byArray) {
        HASContainer hASContainer = this.baseContainerFactory.createBinaryContainer(n4, byArray);
        this.contextResults.callResult(n, n2, n3, hASContainer);
    }

    protected void callResult(int n, int n2, int n3, int n4, boolean bl) {
        HASContainer hASContainer = this.baseContainerFactory.createBooleanContainer(n4, bl);
        this.contextResults.callResult(n, n2, n3, hASContainer);
    }

    protected void callResult(int n, int n2, int n3, int n4, double d2) {
        HASContainer hASContainer = this.baseContainerFactory.createDoubleContainer(n4, d2);
        this.contextResults.callResult(n, n2, n3, hASContainer);
    }

    protected void callResult(int n, int n2, int n3, int n4, int n5) {
        HASContainer hASContainer = this.baseContainerFactory.createIntContainer(n4, n5);
        this.contextResults.callResult(n, n2, n3, hASContainer);
    }

    protected void callResult(int n, int n2, int n3, int n4, long l) {
        HASContainer hASContainer = this.baseContainerFactory.createLongContainer(n4, l);
        this.contextResults.callResult(n, n2, n3, hASContainer);
    }

    protected void callResult(int n, int n2, int n3, int n4, ResourceLocator resourceLocator) {
        HASContainer hASContainer = this.baseContainerFactory.createResourceLocatorContainer(n4, resourceLocator);
        this.contextResults.callResult(n, n2, n3, hASContainer);
    }

    protected void callResult(int n, int n2, int n3, int n4, String string) {
        HASContainer hASContainer = this.baseContainerFactory.createStringContainer(n4, string);
        this.contextResults.callResult(n, n2, n3, hASContainer);
    }
}

