/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.tvtuner.persistence;

import de.vw.mib.asl.framework.api.persistence.AbstractSharedPersistable;
import de.vw.mib.asl.framework.api.persistence.PersistenceInputStream;
import de.vw.mib.asl.framework.api.persistence.PersistenceOutputStream;
import de.vw.mib.asl.internal.tvtuner.accessor.TVTunerObjectAccessor;
import de.vw.mib.asl.internal.tvtuner.common.TVTunerConstants;
import de.vw.mib.asl.internal.tvtuner.lists.TVTunerPreset;
import java.util.Arrays;

public final class TVTunerPresetsPersistable
extends AbstractSharedPersistable {
    private static final short VERSION;
    private static final short[] SUPPORTED_VERSIONS;
    private TVTunerPreset[] presets = new TVTunerPreset[99];

    public TVTunerPresetsPersistable() {
        super(5014, 0);
        this.resetPresets();
    }

    public void savePresets(TVTunerPreset[] tVTunerPresetArray) {
        this.presets = tVTunerPresetArray;
        this.markDirty(true);
    }

    @Override
    public void clear() {
        this.resetPresets();
        this.updatePresetsToPresetHandler();
    }

    private void resetPresets() {
        Arrays.fill(this.presets, TVTunerConstants.EMPTY_PRESET);
    }

    @Override
    public void toStreamInternal(PersistenceOutputStream persistenceOutputStream) {
        for (int i2 = 0; i2 < 99; ++i2) {
            this.presets[i2].toStream(persistenceOutputStream);
        }
    }

    private void updatePresetsToPresetHandler() {
        TVTunerObjectAccessor.getPresetListHandler().updatePresetList(this.presets);
    }

    @Override
    public void fromStreamInternal(PersistenceInputStream persistenceInputStream, short s) {
        this.resetPresets();
        for (int i2 = 0; i2 < 99; ++i2) {
            this.presets[i2] = new TVTunerPreset(persistenceInputStream);
        }
        this.updatePresetsToPresetHandler();
    }

    @Override
    public void clearUnknownValues(short s) {
    }

    @Override
    public short[] getSupportedVersions() {
        return SUPPORTED_VERSIONS;
    }

    @Override
    public short getVersion() {
        return 2;
    }

    static {
        SUPPORTED_VERSIONS = new short[0];
    }
}

