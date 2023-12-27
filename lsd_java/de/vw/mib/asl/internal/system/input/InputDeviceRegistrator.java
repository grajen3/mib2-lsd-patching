/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.system.input;

import de.vw.mib.asl.framework.api.dsiproxy.DSIProxy;
import de.vw.mib.asl.internal.system.SystemServices;
import de.vw.mib.asl.internal.system.input.InputDeviceRegistrator$1;
import de.vw.mib.asl.internal.system.input.ProximityInputDeviceImpl;
import de.vw.mib.asl.internal.system.input.TouchInputDeviceImpl;
import de.vw.mib.asl.internal.system.input.UserInteractionNotifier;
import de.vw.mib.asl.internal.system.util.Preconditions;
import de.vw.mib.configuration.ConfigurationManager;
import de.vw.mib.event.dispatcher.SystemEventDispatcher;
import de.vw.mib.genericevents.ThreadSwitchingTarget;
import de.vw.mib.input.InputManager;
import org.osgi.framework.BundleContext;

public class InputDeviceRegistrator {
    private final DSIProxy dsiProxy;
    private final BundleContext bundleContext;
    private final ConfigurationManager configurationManager;
    private final SystemEventDispatcher systemEventDispatcher;
    private final ThreadSwitchingTarget threadSwitcher;
    private final SystemServices systemServices;
    static /* synthetic */ Class class$de$vw$mib$input$InputManager;

    public InputDeviceRegistrator(SystemServices systemServices) {
        Preconditions.checkArgumentNotNull(systemServices, "SystemServices must be given.");
        this.systemServices = systemServices;
        this.bundleContext = systemServices.getBundleContext();
        this.dsiProxy = systemServices.getDsiProxy();
        this.configurationManager = systemServices.getConfigManagerDiag();
        this.systemEventDispatcher = systemServices.getSystemEventDispatcher();
        this.threadSwitcher = systemServices.getThreadSwitcher();
    }

    public void registerInputDevices() {
        this.trackInputManager(this.bundleContext);
    }

    private void addInputManagerListeners(InputManager inputManager) {
        inputManager.addInputManagerListener(new UserInteractionNotifier(this.systemEventDispatcher));
    }

    private void registerInputDevices(InputManager inputManager) {
        inputManager.registerInputDevice(new TouchInputDeviceImpl(this.dsiProxy, this.configurationManager, this.systemServices));
        inputManager.registerInputDevice(new ProximityInputDeviceImpl(this.dsiProxy, this.configurationManager));
    }

    private void trackInputManager(BundleContext bundleContext) {
        new InputDeviceRegistrator$1(this, bundleContext, (class$de$vw$mib$input$InputManager == null ? (class$de$vw$mib$input$InputManager = InputDeviceRegistrator.class$("de.vw.mib.input.InputManager")) : class$de$vw$mib$input$InputManager).getName(), null).open();
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }

    static /* synthetic */ ThreadSwitchingTarget access$000(InputDeviceRegistrator inputDeviceRegistrator) {
        return inputDeviceRegistrator.threadSwitcher;
    }

    static /* synthetic */ void access$200(InputDeviceRegistrator inputDeviceRegistrator, InputManager inputManager) {
        inputDeviceRegistrator.registerInputDevices(inputManager);
    }

    static /* synthetic */ void access$300(InputDeviceRegistrator inputDeviceRegistrator, InputManager inputManager) {
        inputDeviceRegistrator.addInputManagerListeners(inputManager);
    }
}

