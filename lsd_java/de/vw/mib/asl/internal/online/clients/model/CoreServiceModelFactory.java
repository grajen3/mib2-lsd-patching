/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.online.clients.model;

import de.vw.mib.asl.internal.online.clients.model.control.CoreServiceModelController;
import de.vw.mib.asl.internal.online.clients.model.control.CoreServiceModelPropertyManager;
import de.vw.mib.asl.internal.online.clients.model.control.CoreServiceSpellerHandler;
import de.vw.mib.asl.internal.online.clients.model.states.CoreServiceModelTarget;

public class CoreServiceModelFactory {
    private static CoreServiceModelController _modelController;
    private static CoreServiceSpellerHandler _spellerHandler;
    private static CoreServiceModelPropertyManager _propertyManager;

    public static CoreServiceModelController getCoreServiceModelController(CoreServiceModelTarget coreServiceModelTarget) {
        if (_modelController == null && coreServiceModelTarget != null) {
            _modelController = new CoreServiceModelController(coreServiceModelTarget);
        }
        return _modelController;
    }

    public static CoreServiceSpellerHandler getSpellerHandler() {
        if (_spellerHandler == null) {
            _spellerHandler = new CoreServiceSpellerHandler();
        }
        return _spellerHandler;
    }

    public static CoreServiceModelPropertyManager getPropertyManager() {
        if (_propertyManager == null) {
            _propertyManager = new CoreServiceModelPropertyManager();
        }
        return _propertyManager;
    }
}

