/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.car.framework.arrays;

import de.vw.mib.asl.api.car.arrays.ASLCarArrayFactory;
import de.vw.mib.asl.api.car.arrays.ASLCarBAPArrayConverter;
import de.vw.mib.asl.api.car.arrays.ArraySlider;
import de.vw.mib.asl.api.car.arrays.ArraySliderDelegate;
import de.vw.mib.asl.internal.car.framework.arrays.ArraySliderImpl;
import de.vw.mib.asl.internal.car.framework.arrays.ArrayTimer;
import de.vw.mib.asl.internal.car.framework.arrays.BAPArrayConverter;
import de.vw.mib.asl.internal.car.framework.arrays.GenericChangedArray;
import de.vw.mib.asl.internal.car.framework.arrays.GenericGetArray;
import de.vw.mib.asl.internal.car.framework.arrays.GenericSetGetArray;
import de.vw.mib.asl.internal.car.framework.arrays.GenericStatusArray;
import de.vw.mib.bap.array.requests.BAPChangedArray;
import de.vw.mib.bap.array.requests.BAPGetArray;
import de.vw.mib.bap.array.requests.BAPSetGetArray;
import de.vw.mib.bap.array.requests.BAPStatusArray;
import de.vw.mib.bap.array.timer.Timer;
import de.vw.mib.bap.array.timer.TimerNotifier;

public final class BapArrayFactory
implements ASLCarArrayFactory {
    private static BapArrayFactory _bapArrayFactory;
    private static BAPArrayConverter _bapArrayConverter;

    private BapArrayFactory() {
    }

    public static ASLCarArrayFactory getInstance() {
        if (_bapArrayFactory == null) {
            _bapArrayFactory = new BapArrayFactory();
        }
        return _bapArrayFactory;
    }

    @Override
    public Timer createBapArrayTimer(TimerNotifier timerNotifier, long l) {
        return new ArrayTimer(timerNotifier, l);
    }

    @Override
    public BAPChangedArray createBapChangedArray() {
        return new GenericChangedArray();
    }

    @Override
    public BAPGetArray createBapGetArray() {
        return new GenericGetArray();
    }

    @Override
    public BAPSetGetArray createBapSetGetArray(Class clazz) {
        return new GenericSetGetArray(clazz);
    }

    @Override
    public BAPStatusArray createBapStatusArray() {
        return new GenericStatusArray();
    }

    @Override
    public ASLCarBAPArrayConverter getBAPArrayConverter() {
        if (_bapArrayConverter == null) {
            _bapArrayConverter = new BAPArrayConverter();
        }
        return _bapArrayConverter;
    }

    @Override
    public ArraySlider createArraySlider(ArraySliderDelegate arraySliderDelegate, int n) {
        return new ArraySliderImpl(arraySliderDelegate, n);
    }
}

