/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.car.fpk.usecases.presets.arrays;

import de.vw.mib.asl.internal.car.fpk.usecases.presets.model.Preset;
import de.vw.mib.bap.datatypes.ArrayHeader;
import de.vw.mib.bap.datatypes.BAPArrayElement;
import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.stream.BitStream;
import org.dsi.ifc.carkombi.DCDisplayPresetsListRecord;

public final class PresetsBAPElement
extends Preset
implements BAPArrayElement {
    private ArrayHeader arrayHeader;
    private int pos;

    public PresetsBAPElement() {
        this(new ArrayHeader());
    }

    public PresetsBAPElement(ArrayHeader arrayHeader) {
        this.arrayHeader = arrayHeader;
    }

    public PresetsBAPElement(ArrayHeader arrayHeader, DCDisplayPresetsListRecord dCDisplayPresetsListRecord) {
        super(dCDisplayPresetsListRecord);
        this.arrayHeader = arrayHeader;
        this.pos = dCDisplayPresetsListRecord.getPos();
    }

    public PresetsBAPElement(PresetsBAPElement presetsBAPElement) {
        this(presetsBAPElement.getArrayHeader(), presetsBAPElement.getModel(), presetsBAPElement.getPos());
    }

    private PresetsBAPElement(ArrayHeader arrayHeader, DCDisplayPresetsListRecord dCDisplayPresetsListRecord, int n) {
        this(arrayHeader, dCDisplayPresetsListRecord);
        this.pos = n;
    }

    @Override
    public DCDisplayPresetsListRecord getModel() {
        return super.getModel();
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

