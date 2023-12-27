/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.car.fpk.usecases.content.selection.arrays;

import de.vw.mib.asl.internal.car.fpk.usecases.content.selection.model.ContentSelection;
import de.vw.mib.bap.datatypes.ArrayHeader;
import de.vw.mib.bap.datatypes.BAPArrayElement;
import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.stream.BitStream;
import org.dsi.ifc.carkombi.DCElementContentSelectionListRA1;
import org.dsi.ifc.carkombi.DCElementContentSelectionListRA2;

public class ContentSelectionBAPElement
extends ContentSelection
implements BAPArrayElement {
    private ArrayHeader arrayHeader;
    private int pos;

    public ContentSelectionBAPElement() {
        this(new ArrayHeader(), -1);
    }

    public ContentSelectionBAPElement(ArrayHeader arrayHeader, int n) {
        this(arrayHeader, new DCElementContentSelectionListRA1());
        this.pos = n;
    }

    public ContentSelectionBAPElement(ArrayHeader arrayHeader, DCElementContentSelectionListRA1 dCElementContentSelectionListRA1) {
        super(dCElementContentSelectionListRA1);
        this.arrayHeader = arrayHeader;
        this.pos = dCElementContentSelectionListRA1.pos;
    }

    public ContentSelectionBAPElement(ArrayHeader arrayHeader, DCElementContentSelectionListRA2 dCElementContentSelectionListRA2) {
        super(new DCElementContentSelectionListRA1(dCElementContentSelectionListRA2.getPos(), -1, -1, -1, dCElementContentSelectionListRA2.getElementContent()));
        this.arrayHeader = arrayHeader;
        this.pos = dCElementContentSelectionListRA2.pos;
    }

    public ContentSelectionBAPElement(ContentSelectionBAPElement contentSelectionBAPElement) {
        this(contentSelectionBAPElement.getArrayHeader(), contentSelectionBAPElement.getDCElementContentSelectionListRAX());
    }

    @Override
    public DCElementContentSelectionListRA1 getDCElementContentSelectionListRAX() {
        return super.getDCElementContentSelectionListRAX();
    }

    @Override
    public boolean equalTo(BAPEntity bAPEntity) {
        return false;
    }

    @Override
    public void reset() {
    }

    @Override
    public int bitSize() {
        return 0;
    }

    @Override
    public void deserialize(BitStream bitStream) {
    }

    @Override
    public void serialize(BitStream bitStream) {
    }

    @Override
    public void setArrayHeader(ArrayHeader arrayHeader) {
        this.arrayHeader = arrayHeader;
    }

    @Override
    public ArrayHeader getArrayHeader() {
        return this.arrayHeader;
    }

    @Override
    public void setPos(int n) {
        this.pos = n;
    }

    @Override
    public int getPos() {
        return this.pos;
    }
}

