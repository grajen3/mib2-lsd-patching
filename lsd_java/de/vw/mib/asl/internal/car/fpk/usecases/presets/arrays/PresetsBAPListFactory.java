/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.car.fpk.usecases.presets.arrays;

import de.vw.mib.asl.api.car.ASLCarFactory;
import de.vw.mib.asl.internal.car.fpk.usecases.presets.arrays.PresetsBAPElement;
import de.vw.mib.asl.internal.car.fpk.usecases.presets.arrays.PresetsBAPListDelegate;
import de.vw.mib.asl.internal.car.fpk.usecases.presets.arrays.PresetsBAPListNotifier;
import de.vw.mib.bap.array.asg.ASGArrayList;
import de.vw.mib.bap.array.asg.ASGArrayListFactory;
import de.vw.mib.bap.array.asg.complete.ArrayListFactory;
import de.vw.mib.bap.array.requests.BAPGetArray;
import de.vw.mib.bap.array.requests.BAPSetGetArray;
import de.vw.mib.bap.array.timer.Timer;
import de.vw.mib.bap.array.timer.TimerNotifier;
import de.vw.mib.bap.datatypes.BAPArrayElement;

public class PresetsBAPListFactory
implements ASGArrayListFactory {
    private static final int HIGH_LEVEL_RETRY_NUMBER_OF_RETRIES;
    private static final int HIGH_LEVEL_RETRY_RETRY_TIME;
    static /* synthetic */ Class class$de$vw$mib$asl$internal$car$fpk$usecases$presets$arrays$PresetsBAPElement;

    public static ASGArrayList createList(PresetsBAPListDelegate presetsBAPListDelegate, PresetsBAPListNotifier presetsBAPListNotifier) {
        return new ArrayListFactory().createCompleteArrayList(presetsBAPListDelegate, presetsBAPListNotifier, new PresetsBAPListFactory(), 1, 0, true, 4, 0);
    }

    @Override
    public BAPGetArray createGetArrayRequest(ASGArrayList aSGArrayList) {
        return ASLCarFactory.getCarApi().getCarBapArrayFactory().createBapGetArray();
    }

    @Override
    public BAPSetGetArray createSetGetArrayRequest(ASGArrayList aSGArrayList) {
        return ASLCarFactory.getCarApi().getCarBapArrayFactory().createBapSetGetArray(class$de$vw$mib$asl$internal$car$fpk$usecases$presets$arrays$PresetsBAPElement == null ? (class$de$vw$mib$asl$internal$car$fpk$usecases$presets$arrays$PresetsBAPElement = PresetsBAPListFactory.class$("de.vw.mib.asl.internal.car.fpk.usecases.presets.arrays.PresetsBAPElement")) : class$de$vw$mib$asl$internal$car$fpk$usecases$presets$arrays$PresetsBAPElement);
    }

    @Override
    public BAPArrayElement createEmptyElement(ASGArrayList aSGArrayList) {
        return new PresetsBAPElement();
    }

    @Override
    public BAPArrayElement mergeArrayElementAttributes(ASGArrayList aSGArrayList, BAPArrayElement bAPArrayElement, BAPArrayElement bAPArrayElement2, int n) {
        return bAPArrayElement;
    }

    @Override
    public Timer createTimer(ASGArrayList aSGArrayList, TimerNotifier timerNotifier, long l) {
        return ASLCarFactory.getCarApi().getCarBapArrayFactory().createBapArrayTimer(timerNotifier, l);
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }
}

