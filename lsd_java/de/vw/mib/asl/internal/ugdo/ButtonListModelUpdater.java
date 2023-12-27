/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.ugdo;

import de.vw.mib.asl.internal.ugdo.ButtonListContext;
import de.vw.mib.asl.internal.ugdo.transformer.UGDOCollector;
import de.vw.mib.bap.array.asg.ASGArrayList;
import de.vw.mib.bap.array.asg.ASGArrayListChangeNotifier;
import de.vw.mib.bap.datatypes.BAPArrayDataList;
import de.vw.mib.bap.datatypes.BAPArrayElement;
import generated.de.vw.mib.asl.internal.ListManager;
import java.util.ArrayList;
import java.util.Iterator;

public class ButtonListModelUpdater
implements ASGArrayListChangeNotifier {
    private ArrayList defaultButtonList;
    private ButtonListContext _context;
    private static final int MAX_BUTTON_ELEMENTS;

    public ButtonListModelUpdater(ButtonListContext buttonListContext) {
        this._context = buttonListContext;
        this.defaultButtonList = ButtonListModelUpdater.defaultUGDOButtonListRA0();
    }

    private ButtonListContext getContext() {
        return this._context;
    }

    @Override
    public void elementsDeleted(ASGArrayList aSGArrayList, int n, BAPArrayDataList bAPArrayDataList) {
        this.updateButtonList(aSGArrayList);
    }

    @Override
    public void elementsInserted(ASGArrayList aSGArrayList, int n, BAPArrayDataList bAPArrayDataList) {
        this.updateButtonList(aSGArrayList);
    }

    @Override
    public void elementsUpdated(ASGArrayList aSGArrayList, int n, BAPArrayDataList bAPArrayDataList) {
        this.updateButtonList(aSGArrayList);
    }

    @Override
    public void reloaded(ASGArrayList aSGArrayList) {
        if (!aSGArrayList.isLoading()) {
            this.updateButtonList(aSGArrayList);
        }
    }

    private static ArrayList defaultUGDOButtonListRA0() {
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < 3; ++i2) {
            UGDOCollector uGDOCollector = new UGDOCollector();
            uGDOCollector.hardKey = i2 + 1;
            uGDOCollector.softKey = i2 + 1;
            arrayList.add(uGDOCollector);
        }
        return arrayList;
    }

    protected void updateButtonList(ASGArrayList aSGArrayList) {
        Iterator iterator = aSGArrayList.getAllElements().getIterator();
        ArrayList arrayList = new ArrayList(aSGArrayList.size());
        arrayList.addAll(this.defaultButtonList);
        while (iterator.hasNext()) {
            UGDOCollector uGDOCollector = (UGDOCollector)iterator.next();
            arrayList.set(uGDOCollector.softKey - 1, uGDOCollector);
        }
        ListManager.getGenericASLList(-229037824).updateList(arrayList.toArray());
    }

    protected void updateButtonListOld(ASGArrayList aSGArrayList) {
        Iterator iterator = aSGArrayList.getAllElements().getIterator();
        ArrayList arrayList = new ArrayList(aSGArrayList.size());
        while (iterator.hasNext()) {
            BAPArrayElement bAPArrayElement = (BAPArrayElement)iterator.next();
            arrayList.add(bAPArrayElement);
        }
        ListManager.getGenericASLList(-229037824).updateList(arrayList.toArray());
    }
}

