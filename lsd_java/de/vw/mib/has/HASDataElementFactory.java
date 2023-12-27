/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.has;

import org.dsi.ifc.global.ResourceLocator;
import org.dsi.ifc.has.HASDataElement;

public interface HASDataElementFactory {
    default public HASDataElement createBinaryElement(int n, byte[] byArray) {
    }

    default public HASDataElement createBooleanElement(int n, boolean bl) {
    }

    default public HASDataElement createDoubleElement(int n, double d2) {
    }

    default public HASDataElement createIntElement(int n, int n2) {
    }

    default public HASDataElement createLongElement(int n, long l) {
    }

    default public HASDataElement createResourceLocatorElement(int n, ResourceLocator resourceLocator) {
    }

    default public HASDataElement createStringElement(int n, String string) {
    }
}

