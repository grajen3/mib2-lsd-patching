/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.car.light.arrays.colorlist;

import de.vw.mib.asl.api.car.logger.CarLogger;
import de.vw.mib.asl.internal.car.light.ASLCarLightHsmTarget;
import de.vw.mib.asl.internal.car.light.arrays.colorlist.ColorListContext;
import de.vw.mib.asl.internal.car.light.transformer.IntLightRGBColorTransformer;
import de.vw.mib.bap.array.asg.ASGArrayList;
import de.vw.mib.bap.array.asg.ASGArrayListChangeNotifier;
import de.vw.mib.bap.datatypes.BAPArrayDataList;
import de.vw.mib.bap.datatypes.BAPArrayElement;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Observer;
import java.util.Set;

public final class ColorListClientsUpdater
implements ASGArrayListChangeNotifier {
    private static HashSet clients = new HashSet();
    private ColorListContext _context;

    public ColorListClientsUpdater(ColorListContext colorListContext) {
        this._context = colorListContext;
    }

    public static void addClients(Observer observer) {
        clients.add(observer);
    }

    static Set getClients() {
        return clients;
    }

    private ColorListContext getContext() {
        return this._context;
    }

    private CarLogger getContextLoger() {
        return this.getContext().getCarLogger();
    }

    @Override
    public void elementsInserted(ASGArrayList aSGArrayList, int n, BAPArrayDataList bAPArrayDataList) {
        this._updateClients(aSGArrayList);
    }

    @Override
    public void elementsDeleted(ASGArrayList aSGArrayList, int n, BAPArrayDataList bAPArrayDataList) {
        this._updateClients(aSGArrayList);
    }

    @Override
    public void elementsUpdated(ASGArrayList aSGArrayList, int n, BAPArrayDataList bAPArrayDataList) {
        this._updateClients(aSGArrayList);
    }

    @Override
    public void reloaded(ASGArrayList aSGArrayList) {
        this._updateClients(aSGArrayList);
    }

    private void updateClientsLoadingState(boolean bl) {
    }

    private void _updateClients(ASGArrayList aSGArrayList) {
        if (!aSGArrayList.isLoading()) {
            BAPArrayElement[] bAPArrayElementArray = aSGArrayList.getAllElements().toArray();
            Object object = this.transform2HMI(bAPArrayElementArray);
            this.updatePersistence(object);
            this.updateHmiModel(object);
            Iterator iterator = clients.iterator();
            while (iterator.hasNext()) {
                Observer observer = (Observer)iterator.next();
                observer.update(null, object);
            }
        }
        this.updateClientsLoadingState(aSGArrayList.isLoading());
    }

    protected void updatePersistence(Object object) {
        int[] nArray = (int[])object;
        ((ASLCarLightHsmTarget)this.getContext()).updateRGBColorListArray(nArray);
    }

    private Object transform2HMI(BAPArrayElement[] bAPArrayElementArray) {
        return IntLightRGBColorTransformer.transform(bAPArrayElementArray);
    }

    private void updateHmiModel(Object object) {
        if (this.getContextLoger().isTraceEnabled()) {
            this.getContextLoger().trace("Car Light: informing HMI with new color list");
        }
        ASLCarLightHsmTarget aSLCarLightHsmTarget = (ASLCarLightHsmTarget)this.getContext();
        aSLCarLightHsmTarget.updateClientAmbianceLightColor();
    }
}

