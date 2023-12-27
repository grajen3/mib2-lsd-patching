/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.system.input;

import de.vw.mib.asl.internal.system.input.InputDeviceRegistrator;
import de.vw.mib.asl.internal.system.input.InputDeviceRegistrator$1$1;
import de.vw.mib.input.InputManager;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import org.osgi.util.tracker.ServiceTracker;
import org.osgi.util.tracker.ServiceTrackerCustomizer;

class InputDeviceRegistrator$1
extends ServiceTracker {
    private final /* synthetic */ InputDeviceRegistrator this$0;

    InputDeviceRegistrator$1(InputDeviceRegistrator inputDeviceRegistrator, BundleContext bundleContext, String string, ServiceTrackerCustomizer serviceTrackerCustomizer) {
        this.this$0 = inputDeviceRegistrator;
        super(bundleContext, string, serviceTrackerCustomizer);
    }

    @Override
    public Object addingService(ServiceReference serviceReference) {
        InputManager inputManager = (InputManager)super.addingService(serviceReference);
        InputDeviceRegistrator.access$000(this.this$0).enqueue(this.createTask(inputManager));
        this.close();
        return inputManager;
    }

    private Runnable createTask(InputManager inputManager) {
        return new InputDeviceRegistrator$1$1(this, inputManager);
    }

    static /* synthetic */ InputDeviceRegistrator access$100(InputDeviceRegistrator$1 inputDeviceRegistrator$1) {
        return inputDeviceRegistrator$1.this$0;
    }
}

