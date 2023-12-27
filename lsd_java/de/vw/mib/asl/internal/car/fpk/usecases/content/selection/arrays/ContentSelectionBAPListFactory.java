/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.car.fpk.usecases.content.selection.arrays;

import de.vw.mib.asl.api.car.ASLCarFactory;
import de.vw.mib.asl.internal.car.fpk.usecases.content.selection.arrays.ContentSelectionBAPElement;
import de.vw.mib.bap.array.asg.ASGArrayList;
import de.vw.mib.bap.array.asg.ASGArrayListChangeNotifier;
import de.vw.mib.bap.array.asg.ASGArrayListDelegate;
import de.vw.mib.bap.array.asg.ASGArrayListFactory;
import de.vw.mib.bap.array.asg.complete.ArrayListFactory;
import de.vw.mib.bap.array.requests.BAPGetArray;
import de.vw.mib.bap.array.requests.BAPSetGetArray;
import de.vw.mib.bap.array.timer.Timer;
import de.vw.mib.bap.array.timer.TimerNotifier;
import de.vw.mib.bap.datatypes.BAPArrayElement;

public class ContentSelectionBAPListFactory
implements ASGArrayListFactory {
    private static final int HIGH_LEVEL_RETRY_NUMBER_OF_RETRIES;
    private static final int HIGH_LEVEL_RETRY_RETRY_TIME;
    static /* synthetic */ Class class$de$vw$mib$asl$internal$car$fpk$usecases$content$selection$arrays$ContentSelectionBAPElement;

    public static ASGArrayList createList(ASGArrayListDelegate aSGArrayListDelegate, ASGArrayListChangeNotifier aSGArrayListChangeNotifier) {
        return new ArrayListFactory().createCompleteArrayList(aSGArrayListDelegate, aSGArrayListChangeNotifier, new ContentSelectionBAPListFactory(), 1, 0, true, 4, 0);
    }

    @Override
    public BAPGetArray createGetArrayRequest(ASGArrayList aSGArrayList) {
        return ASLCarFactory.getCarApi().getCarBapArrayFactory().createBapGetArray();
    }

    @Override
    public BAPSetGetArray createSetGetArrayRequest(ASGArrayList aSGArrayList) {
        return ASLCarFactory.getCarApi().getCarBapArrayFactory().createBapSetGetArray(class$de$vw$mib$asl$internal$car$fpk$usecases$content$selection$arrays$ContentSelectionBAPElement == null ? (class$de$vw$mib$asl$internal$car$fpk$usecases$content$selection$arrays$ContentSelectionBAPElement = ContentSelectionBAPListFactory.class$("de.vw.mib.asl.internal.car.fpk.usecases.content.selection.arrays.ContentSelectionBAPElement")) : class$de$vw$mib$asl$internal$car$fpk$usecases$content$selection$arrays$ContentSelectionBAPElement);
    }

    @Override
    public BAPArrayElement createEmptyElement(ASGArrayList aSGArrayList) {
        return new ContentSelectionBAPElement();
    }

    @Override
    public BAPArrayElement mergeArrayElementAttributes(ASGArrayList aSGArrayList, BAPArrayElement bAPArrayElement, BAPArrayElement bAPArrayElement2, int n) {
        if (n == 2) {
            ((ContentSelectionBAPElement)bAPArrayElement2).getDCElementContentSelectionListRAX().elementContent = ((ContentSelectionBAPElement)bAPArrayElement).getDCElementContentSelectionListRAX().elementContent;
            return bAPArrayElement2;
        }
        if (n == 1) {
            // empty if block
        }
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

