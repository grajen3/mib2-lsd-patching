/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.online.ocu;

import de.vw.mib.asl.internal.online.ocu.common.OCUUpdateServiceSpeller;
import de.vw.mib.asl.internal.online.ocu.control.OCUUpdateServiceClampSignal;
import de.vw.mib.asl.internal.online.ocu.control.OCUUpdateServiceController;
import de.vw.mib.asl.internal.online.ocu.control.OCUUpdateServiceModelHandler;
import de.vw.mib.asl.internal.online.ocu.control.OCUUpdateServiceResetFactorySettings;
import de.vw.mib.asl.internal.online.ocu.impl.OCUUpdateServiceHandler;
import de.vw.mib.asl.internal.online.ocu.states.OCUUpdateServiceTarget;

public final class OCUUpdateServiceFactory {
    private static OCUUpdateServiceController _Controller;
    private static OCUUpdateServiceSpeller _speller;
    private static OCUUpdateServiceModelHandler _modelHandler;
    private static OCUUpdateServiceHandler _serviceHandler;
    private static OCUUpdateServiceClampSignal _clampSignal;
    private static OCUUpdateServiceResetFactorySettings _factorySettings;

    private OCUUpdateServiceFactory() {
    }

    public static OCUUpdateServiceController getController(OCUUpdateServiceTarget oCUUpdateServiceTarget) {
        if (_Controller == null && oCUUpdateServiceTarget != null) {
            _Controller = new OCUUpdateServiceController(oCUUpdateServiceTarget);
        }
        return _Controller;
    }

    public static OCUUpdateServiceHandler getServiceHandler(OCUUpdateServiceTarget oCUUpdateServiceTarget) {
        if (_serviceHandler == null && oCUUpdateServiceTarget != null) {
            _serviceHandler = new OCUUpdateServiceHandler(oCUUpdateServiceTarget);
        }
        return _serviceHandler;
    }

    public static OCUUpdateServiceSpeller getSpeller() {
        if (_speller == null) {
            _speller = new OCUUpdateServiceSpeller();
        }
        return _speller;
    }

    public static OCUUpdateServiceModelHandler getModelHandler() {
        if (_modelHandler == null) {
            _modelHandler = new OCUUpdateServiceModelHandler();
        }
        return _modelHandler;
    }

    public static OCUUpdateServiceClampSignal getClampSignalManager(OCUUpdateServiceTarget oCUUpdateServiceTarget) {
        if (_clampSignal == null && oCUUpdateServiceTarget != null) {
            _clampSignal = new OCUUpdateServiceClampSignal(oCUUpdateServiceTarget);
        }
        return _clampSignal;
    }

    public static OCUUpdateServiceResetFactorySettings getResetFactorySettings(OCUUpdateServiceTarget oCUUpdateServiceTarget) {
        if (_factorySettings == null && oCUUpdateServiceTarget != null) {
            _factorySettings = new OCUUpdateServiceResetFactorySettings(oCUUpdateServiceTarget);
        }
        return _factorySettings;
    }
}

