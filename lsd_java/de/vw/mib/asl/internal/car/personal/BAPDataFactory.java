/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.car.personal;

import de.vw.mib.asl.internal.car.framework.arrays.BapArrayFactory;
import de.vw.mib.asl.internal.car.personal.DriverListElement;
import de.vw.mib.bap.array.asg.ASGArrayList;
import de.vw.mib.bap.array.asg.ASGArrayListFactory;
import de.vw.mib.bap.array.requests.BAPGetArray;
import de.vw.mib.bap.array.requests.BAPSetGetArray;
import de.vw.mib.bap.array.timer.Timer;
import de.vw.mib.bap.array.timer.TimerNotifier;
import de.vw.mib.bap.datatypes.BAPArrayElement;

public class BAPDataFactory
implements ASGArrayListFactory {
    static /* synthetic */ Class class$de$vw$mib$asl$internal$car$personal$DriverListElement;

    @Override
    public BAPArrayElement createEmptyElement(ASGArrayList aSGArrayList) {
        return new DriverListElement();
    }

    @Override
    public BAPGetArray createGetArrayRequest(ASGArrayList aSGArrayList) {
        return BapArrayFactory.getInstance().createBapGetArray();
    }

    @Override
    public BAPSetGetArray createSetGetArrayRequest(ASGArrayList aSGArrayList) {
        return BapArrayFactory.getInstance().createBapSetGetArray(class$de$vw$mib$asl$internal$car$personal$DriverListElement == null ? (class$de$vw$mib$asl$internal$car$personal$DriverListElement = BAPDataFactory.class$("de.vw.mib.asl.internal.car.personal.DriverListElement")) : class$de$vw$mib$asl$internal$car$personal$DriverListElement);
    }

    @Override
    public Timer createTimer(ASGArrayList aSGArrayList, TimerNotifier timerNotifier, long l) {
        return BapArrayFactory.getInstance().createBapArrayTimer(timerNotifier, l);
    }

    @Override
    public BAPArrayElement mergeArrayElementAttributes(ASGArrayList aSGArrayList, BAPArrayElement bAPArrayElement, BAPArrayElement bAPArrayElement2, int n) {
        ((DriverListElement)bAPArrayElement2).userType = ((DriverListElement)bAPArrayElement).userType;
        ((DriverListElement)bAPArrayElement2).userProfileName = ((DriverListElement)bAPArrayElement).userProfileName;
        return bAPArrayElement2;
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

