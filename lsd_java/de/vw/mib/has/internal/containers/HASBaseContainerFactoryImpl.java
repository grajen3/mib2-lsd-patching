/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.has.internal.containers;

import de.vw.mib.has.HASBaseContainerFactory;
import de.vw.mib.has.HASContainer;
import de.vw.mib.has.internal.containers.BinaryContainer;
import de.vw.mib.has.internal.containers.BooleanContainer;
import de.vw.mib.has.internal.containers.DoubleContainer;
import de.vw.mib.has.internal.containers.IntContainer;
import de.vw.mib.has.internal.containers.LongContainer;
import de.vw.mib.has.internal.containers.ResourceLocatorContainer;
import de.vw.mib.has.internal.containers.StringContainer;
import org.dsi.ifc.global.ResourceLocator;

public final class HASBaseContainerFactoryImpl
implements HASBaseContainerFactory {
    @Override
    public HASContainer createBinaryContainer(int n, byte[] byArray) {
        return BinaryContainer.borrow(n, byArray);
    }

    @Override
    public HASContainer createBooleanContainer(int n, boolean bl) {
        return BooleanContainer.borrow(n, bl);
    }

    @Override
    public HASContainer createDoubleContainer(int n, double d2) {
        return DoubleContainer.borrow(n, d2);
    }

    @Override
    public HASContainer createIntContainer(int n, int n2) {
        return IntContainer.borrow(n, n2);
    }

    @Override
    public HASContainer createLongContainer(int n, long l) {
        return LongContainer.borrow(n, l);
    }

    @Override
    public HASContainer createResourceLocatorContainer(int n, ResourceLocator resourceLocator) {
        return ResourceLocatorContainer.borrow(n, resourceLocator);
    }

    @Override
    public HASContainer createStringContainer(int n, String string) {
        return StringContainer.borrow(n, string);
    }
}

