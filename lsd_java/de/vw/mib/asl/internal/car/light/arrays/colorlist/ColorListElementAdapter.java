/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.car.light.arrays.colorlist;

import de.vw.mib.asl.internal.car.light.transformer.IntLightRGBColorTransformer;
import de.vw.mib.bap.datatypes.ArrayHeader;
import de.vw.mib.bap.datatypes.BAPArrayElement;
import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.stream.BitStream;
import org.dsi.ifc.carlight.IntLightRGBColorListRA0;
import org.dsi.ifc.carlight.IntLightRGBValues;

public final class ColorListElementAdapter
implements BAPArrayElement {
    private ArrayHeader arrayHeader;
    private int pos;
    private int rgbValue = -1;

    public ColorListElementAdapter() {
        this.arrayHeader = new ArrayHeader();
    }

    public ColorListElementAdapter(ArrayHeader arrayHeader, int n) {
        this.arrayHeader = arrayHeader;
        this.pos = n;
    }

    public ColorListElementAdapter(IntLightRGBColorListRA0 intLightRGBColorListRA0, ArrayHeader arrayHeader) {
        this(arrayHeader, intLightRGBColorListRA0.pos);
        IntLightRGBValues intLightRGBValues = intLightRGBColorListRA0.values;
        this.rgbValue = IntLightRGBColorTransformer.transform(intLightRGBValues);
    }

    public ColorListElementAdapter(ColorListElementAdapter colorListElementAdapter) {
        this(colorListElementAdapter.arrayHeader, colorListElementAdapter.pos);
        this.rgbValue = colorListElementAdapter.rgbValue;
    }

    public int getRGBValue() {
        return this.rgbValue;
    }

    @Override
    public void reset() {
    }

    @Override
    public boolean equalTo(BAPEntity bAPEntity) {
        return false;
    }

    @Override
    public void serialize(BitStream bitStream) {
    }

    @Override
    public void deserialize(BitStream bitStream) {
    }

    @Override
    public int bitSize() {
        return 0;
    }

    @Override
    public void setPos(int n) {
        this.pos = n;
    }

    @Override
    public int getPos() {
        return this.pos;
    }

    @Override
    public void setArrayHeader(ArrayHeader arrayHeader) {
        this.arrayHeader = arrayHeader;
    }

    @Override
    public ArrayHeader getArrayHeader() {
        return this.arrayHeader;
    }
}

