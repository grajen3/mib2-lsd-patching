/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.car.fpk.usecases.presets.arrays;

import de.vw.mib.asl.internal.car.fpk.commons.AppLogger;
import de.vw.mib.asl.internal.car.fpk.usecases.presets.arrays.PresetsBAPElement;
import de.vw.mib.asl.internal.car.fpk.usecases.presets.model.Preset;
import de.vw.mib.asl.internal.car.fpk.usecases.presets.service.PresetsChangeListener;
import de.vw.mib.bap.array.asg.ASGArrayList;
import de.vw.mib.bap.array.asg.ASGArrayListChangeNotifier;
import de.vw.mib.bap.datatypes.BAPArrayDataList;

public class PresetsBAPListNotifier
implements ASGArrayListChangeNotifier {
    private final PresetsChangeListener presetsChangeNotifier;

    public PresetsBAPListNotifier(PresetsChangeListener presetsChangeListener) {
        this.presetsChangeNotifier = presetsChangeListener;
    }

    @Override
    public void elementsDeleted(ASGArrayList aSGArrayList, int n, BAPArrayDataList bAPArrayDataList) {
        AppLogger.trace(this, ".elementsDeleted( .. )");
        if (!aSGArrayList.isLoading()) {
            // empty if block
        }
    }

    @Override
    public void elementsInserted(ASGArrayList aSGArrayList, int n, BAPArrayDataList bAPArrayDataList) {
        AppLogger.trace(this, ".elementsInserted( .. )");
        if (!aSGArrayList.isLoading()) {
            // empty if block
        }
    }

    @Override
    public void elementsUpdated(ASGArrayList aSGArrayList, int n, BAPArrayDataList bAPArrayDataList) {
        AppLogger.trace(this, ".elementsUpdated( .. )");
        if (!aSGArrayList.isLoading()) {
            this.onModelChanged(aSGArrayList);
        }
    }

    @Override
    public void reloaded(ASGArrayList aSGArrayList) {
        AppLogger.trace(this, ".reloaded( .. )");
        if (!aSGArrayList.isLoading()) {
            this.onModelChanged(aSGArrayList);
        }
    }

    private void onModelChanged(ASGArrayList aSGArrayList) {
        Preset[] presetArray = new Preset[aSGArrayList.getBapArrayListSize()];
        for (int i2 = 0; i2 < aSGArrayList.getBapArrayListSize(); ++i2) {
            PresetsBAPElement presetsBAPElement = (PresetsBAPElement)aSGArrayList.get(i2);
            presetArray[i2] = presetsBAPElement;
        }
        this.presetsChangeNotifier.onPresetsUpdated(presetArray);
    }
}

