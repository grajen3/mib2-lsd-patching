/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.has.internal;

import de.vw.mib.has.HASDataElementFactory;
import org.dsi.ifc.global.ResourceLocator;
import org.dsi.ifc.has.HASDataElement;

public class HASDataElementFactoryImpl
implements HASDataElementFactory {
    @Override
    public HASDataElement createBinaryElement(int n, byte[] byArray) {
        HASDataElement hASDataElement = new HASDataElement();
        hASDataElement.elementType = 5;
        hASDataElement.elementId = n;
        hASDataElement.binaryData = byArray;
        return hASDataElement;
    }

    @Override
    public HASDataElement createBooleanElement(int n, boolean bl) {
        HASDataElement hASDataElement = new HASDataElement();
        hASDataElement.elementType = 4;
        hASDataElement.elementId = n;
        hASDataElement.numericData = bl ? 1L : 0L;
        return hASDataElement;
    }

    @Override
    public HASDataElement createDoubleElement(int n, double d2) {
        HASDataElement hASDataElement = new HASDataElement();
        hASDataElement.elementType = 3;
        hASDataElement.elementId = n;
        hASDataElement.doubleData = d2;
        return hASDataElement;
    }

    @Override
    public HASDataElement createIntElement(int n, int n2) {
        HASDataElement hASDataElement = new HASDataElement();
        hASDataElement.elementType = 0;
        hASDataElement.elementId = n;
        hASDataElement.numericData = n2;
        return hASDataElement;
    }

    @Override
    public HASDataElement createLongElement(int n, long l) {
        HASDataElement hASDataElement = new HASDataElement();
        hASDataElement.elementType = 1;
        hASDataElement.elementId = n;
        hASDataElement.numericData = l;
        return hASDataElement;
    }

    @Override
    public HASDataElement createResourceLocatorElement(int n, ResourceLocator resourceLocator) {
        HASDataElement hASDataElement = new HASDataElement();
        hASDataElement.elementType = 6;
        hASDataElement.elementId = n;
        hASDataElement.resourceLocator = resourceLocator;
        return hASDataElement;
    }

    @Override
    public HASDataElement createStringElement(int n, String string) {
        HASDataElement hASDataElement = new HASDataElement();
        hASDataElement.elementType = 2;
        hASDataElement.elementId = n;
        hASDataElement.stringData = string;
        return hASDataElement;
    }
}

