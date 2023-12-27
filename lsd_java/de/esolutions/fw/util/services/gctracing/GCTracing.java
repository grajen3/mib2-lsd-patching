/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.microdoc.j9.GCHook
 *  com.microdoc.j9.GlobalGCEvent
 *  com.microdoc.j9.IGCListener
 */
package de.esolutions.fw.util.services.gctracing;

import com.microdoc.j9.GCHook;
import com.microdoc.j9.GlobalGCEvent;
import com.microdoc.j9.IGCListener;
import de.esolutions.fw.util.commons.Buffer;
import de.esolutions.fw.util.services.tracing.FwServicesTracing;

public class GCTracing
implements IGCListener {
    public static void activate() {
        try {
            GCTracing gCTracing = new GCTracing();
            GCHook.addListener((IGCListener)gCTracing);
            FwServicesTracing.GARBAGE_COLLECTOR.log((short)2, "garbage collector tracing started");
        }
        catch (Exception exception) {
            FwServicesTracing.GARBAGE_COLLECTOR.log((short)4, "Could not start garbage collector tracing! reason = %1", exception);
        }
    }

    public void onAbort() {
        System.out.println("JavaGC: onAbort");
        FwServicesTracing.GARBAGE_COLLECTOR.log((short)2, "onAbort");
    }

    public void onGlobalGCEnd(GlobalGCEvent globalGCEvent) {
        if (globalGCEvent != null) {
            long l = globalGCEvent.getEndTimeMs() - globalGCEvent.getStartTimeMs();
            Buffer buffer = new Buffer();
            buffer.append("JavaGC: ");
            buffer.append("onGlobalGCEND: ");
            buffer.append("getStartTimeMs=");
            buffer.append(globalGCEvent.getStartTimeMs());
            buffer.append(" ,getEndTimeMs=");
            buffer.append(globalGCEvent.getEndTimeMs());
            buffer.append(" ,timeDelta=");
            buffer.append(l);
            buffer.append("finalizerCount=");
            buffer.append(globalGCEvent.getFinalizerCount());
            buffer.append(" ,nurseryFreeBytes=");
            buffer.append(globalGCEvent.getNurseryFreeBytes());
            buffer.append(" ,nurseryTotalBytes=");
            buffer.append(globalGCEvent.getNurseryTotalBytes());
            buffer.append(" ,phantomReferenceCount=");
            buffer.append(globalGCEvent.getPhantomReferenceCount());
            buffer.append(" ,softReferenceCount=");
            buffer.append(globalGCEvent.getSoftReferenceCount());
            buffer.append(" ,tenureFreeBytes=");
            buffer.append(globalGCEvent.getTenureFreeBytes());
            buffer.append(" ,tenureTotalBytes=");
            buffer.append(globalGCEvent.getTenureTotalBytes());
            buffer.append(" ,WeakReferenceCount=");
            buffer.append(globalGCEvent.getWeakReferenceCount());
            System.out.println(buffer.toString());
            FwServicesTracing.GARBAGE_COLLECTOR.log((short)2, "onGlobalGCEnd: getStartTimeMs=%9, getEndTimeMs=%{10}, timeDelta=%{11}finalizerCount=%1, nurseryFreeBytes=%2, nurseryTotalBytes=%3, phantomReferenceCount=%4, softReferenceCount=%5, tenureFreeBytes=%6, tenureTotalBytes=%7, WeakReferenceCount=%8", new Long(globalGCEvent.getFinalizerCount()), (Object)new Long(globalGCEvent.getNurseryFreeBytes()), (Object)new Long(globalGCEvent.getNurseryTotalBytes()), (Object)new Long(globalGCEvent.getPhantomReferenceCount()), (Object)new Long(globalGCEvent.getSoftReferenceCount()), (Object)new Long(globalGCEvent.getTenureFreeBytes()), (Object)new Long(globalGCEvent.getTenureTotalBytes()), (Object)new Long(globalGCEvent.getWeakReferenceCount()), (Object)new Long(globalGCEvent.getStartTimeMs()), (Object)new Long(globalGCEvent.getEndTimeMs()), (Object)new Long(l));
        } else {
            FwServicesTracing.GARBAGE_COLLECTOR.log((short)2, "onGlobalGCEnd: event==null");
        }
    }
}

