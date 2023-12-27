/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.car.light.arrays.colorlist2;

import de.vw.mib.asl.internal.car.light.arrays.asgarrays.ASGArrayListElementAdapter;
import de.vw.mib.bap.datatypes.BAPArrayElement;
import org.dsi.ifc.carlight.IntLightRGBColorListRA0;
import org.dsi.ifc.carlight.IntLightRGBValues;

final class ColorListElementAdapter
extends ASGArrayListElementAdapter
implements BAPArrayElement {
    static final int OFFSET_R;
    static final int OFFSET_G;
    static final int OFFSET_B;
    private static final int BIT_MASK;
    private int rgbValue = -1;

    ColorListElementAdapter() {
    }

    ColorListElementAdapter(ColorListElementAdapter colorListElementAdapter) {
        super(colorListElementAdapter.getArrayHeader(), colorListElementAdapter.getPos());
        this.rgbValue = colorListElementAdapter.rgbValue;
    }

    ColorListElementAdapter(int n) {
        this.setPos(n);
    }

    ColorListElementAdapter(IntLightRGBColorListRA0 intLightRGBColorListRA0) {
        this(intLightRGBColorListRA0.pos);
        IntLightRGBValues intLightRGBValues = intLightRGBColorListRA0.values;
        this.rgbValue = (intLightRGBValues.baseColorBlue & 0xFF) << 0 | (intLightRGBValues.baseColorGreen & 0xFF) << 8 | (intLightRGBValues.baseColorRed & 0xFF) << 16;
    }

    public int getRGBValue() {
        return this.rgbValue;
    }
}

