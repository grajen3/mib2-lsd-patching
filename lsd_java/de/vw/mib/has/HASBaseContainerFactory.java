/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.has;

import de.vw.mib.has.HASContainer;
import org.dsi.ifc.global.ResourceLocator;

public interface HASBaseContainerFactory {
    default public HASContainer createBinaryContainer(int n, byte[] byArray) {
    }

    default public HASContainer createBooleanContainer(int n, boolean bl) {
    }

    default public HASContainer createDoubleContainer(int n, double d2) {
    }

    default public HASContainer createIntContainer(int n, int n2) {
    }

    default public HASContainer createLongContainer(int n, long l) {
    }

    default public HASContainer createResourceLocatorContainer(int n, ResourceLocator resourceLocator) {
    }

    default public HASContainer createStringContainer(int n, String string) {
    }
}

