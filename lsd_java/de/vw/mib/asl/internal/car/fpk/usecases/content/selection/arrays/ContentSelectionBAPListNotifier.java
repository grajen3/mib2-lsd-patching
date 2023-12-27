/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.car.fpk.usecases.content.selection.arrays;

import de.vw.mib.asl.internal.car.fpk.commons.AppLogger;
import de.vw.mib.asl.internal.car.fpk.usecases.content.selection.arrays.ContentSelectionBAPElement;
import de.vw.mib.asl.internal.car.fpk.usecases.content.selection.model.ContentSelection;
import de.vw.mib.asl.internal.car.fpk.usecases.content.selection.service.ContentSelectionChangeListener;
import de.vw.mib.bap.array.asg.ASGArrayList;
import de.vw.mib.bap.array.asg.ASGArrayListChangeNotifier;
import de.vw.mib.bap.datatypes.BAPArrayDataList;

public class ContentSelectionBAPListNotifier
implements ASGArrayListChangeNotifier {
    private final ContentSelectionChangeListener contentSelectionNotifier;

    public ContentSelectionBAPListNotifier(ContentSelectionChangeListener contentSelectionChangeListener) {
        this.contentSelectionNotifier = contentSelectionChangeListener;
    }

    @Override
    public void elementsDeleted(ASGArrayList aSGArrayList, int n, BAPArrayDataList bAPArrayDataList) {
        AppLogger.error(this, ".elementsDeleted( .. )");
        if (!aSGArrayList.isLoading()) {
            // empty if block
        }
    }

    @Override
    public void elementsInserted(ASGArrayList aSGArrayList, int n, BAPArrayDataList bAPArrayDataList) {
        AppLogger.error(this, ".elementsInserted( .. )");
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
        ContentSelection[] contentSelectionArray = new ContentSelection[aSGArrayList.getBapArrayListSize()];
        for (int i2 = 0; i2 < aSGArrayList.getBapArrayListSize(); ++i2) {
            ContentSelectionBAPElement contentSelectionBAPElement = (ContentSelectionBAPElement)aSGArrayList.get(i2);
            contentSelectionArray[i2] = contentSelectionBAPElement;
        }
        this.contentSelectionNotifier.onSelectionUpdated(contentSelectionArray);
    }
}

