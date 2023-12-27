/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.car.light.arrays.colorlist2;

import de.vw.mib.asl.internal.car.light.arrays.asgarrays.ASGArrayListElementAdapterFactory;
import de.vw.mib.asl.internal.car.light.arrays.colorlist2.ColorListElementAdapter;
import de.vw.mib.bap.datatypes.BAPArrayElement;
import org.dsi.ifc.carlight.IntLightRGBColorListRA0;

class ColorListElementAdapterFactory
extends ASGArrayListElementAdapterFactory {
    private IntLightRGBColorListRA0[] ra0Data;
    private int[] rafData;
    private static final int CREATE_DEFAULT;
    private static final int CREATE_RA0;
    private static final int CREATE_RAF;
    private final int CREATION_MODE;

    ColorListElementAdapterFactory(IntLightRGBColorListRA0[] intLightRGBColorListRA0Array) {
        this.ra0Data = intLightRGBColorListRA0Array;
        this.size = this.ra0Data.length;
        this.CREATION_MODE = 1;
    }

    ColorListElementAdapterFactory(int[] nArray) {
        this.rafData = nArray;
        this.size = nArray.length;
        this.CREATION_MODE = 2;
    }

    ColorListElementAdapterFactory() {
        this.CREATION_MODE = 0;
    }

    @Override
    protected BAPArrayElement createNewElementAdapter(int n) {
        if (this.CREATION_MODE == 1) {
            return new ColorListElementAdapter(this.ra0Data[n]);
        }
        if (this.CREATION_MODE == 2) {
            return new ColorListElementAdapter(this.rafData[n]);
        }
        throw new IllegalStateException("CREATION_MODE was not set correctly!");
    }

    @Override
    protected BAPArrayElement createNewElementAdapter() {
        return new ColorListElementAdapter();
    }

    @Override
    protected BAPArrayElement createNewElementAdapter(BAPArrayElement bAPArrayElement) {
        return new ColorListElementAdapter((ColorListElementAdapter)bAPArrayElement);
    }
}

