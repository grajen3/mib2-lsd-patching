/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.dsi.trace.optimized.internal.generated.dsi.ddp20;

import de.vw.mib.dsi.trace.optimized.internal.AbstractOptimzedDSIObjectTracer;
import java.io.PrintWriter;
import org.dsi.ifc.ddp20.DisplayRequest;
import org.dsi.ifc.ddp20.DisplayStatus;
import org.dsi.ifc.ddp20.FrameInfo;
import org.dsi.ifc.ddp20.FrameRequest;
import org.dsi.ifc.ddp20.FrameUpdate;
import org.dsi.ifc.ddp20.ProjectInfo;
import org.dsi.ifc.ddp20.UpdateRequest;
import org.dsi.ifc.ddp20.VersionInfo;

public final class DSIDDP20Tracer
extends AbstractOptimzedDSIObjectTracer {
    private static final int ID_DISPLAYREQUEST;
    private static final int ID_DISPLAYSTATUS;
    private static final int ID_FRAMEINFO;
    private static final int ID_FRAMEREQUEST;
    private static final int ID_FRAMEUPDATE;
    private static final int ID_PROJECTINFO;
    private static final int ID_UPDATEREQUEST;
    private static final int ID_VERSIONINFO;
    static /* synthetic */ Class class$org$dsi$ifc$ddp20$DisplayRequest;
    static /* synthetic */ Class class$org$dsi$ifc$ddp20$DisplayStatus;
    static /* synthetic */ Class class$org$dsi$ifc$ddp20$FrameInfo;
    static /* synthetic */ Class class$org$dsi$ifc$ddp20$FrameRequest;
    static /* synthetic */ Class class$org$dsi$ifc$ddp20$FrameUpdate;
    static /* synthetic */ Class class$org$dsi$ifc$ddp20$ProjectInfo;
    static /* synthetic */ Class class$org$dsi$ifc$ddp20$UpdateRequest;
    static /* synthetic */ Class class$org$dsi$ifc$ddp20$VersionInfo;

    public DSIDDP20Tracer() {
        this.registerDSIDatacontainerID(class$org$dsi$ifc$ddp20$DisplayRequest == null ? (class$org$dsi$ifc$ddp20$DisplayRequest = DSIDDP20Tracer.class$("org.dsi.ifc.ddp20.DisplayRequest")) : class$org$dsi$ifc$ddp20$DisplayRequest, 1);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$ddp20$DisplayStatus == null ? (class$org$dsi$ifc$ddp20$DisplayStatus = DSIDDP20Tracer.class$("org.dsi.ifc.ddp20.DisplayStatus")) : class$org$dsi$ifc$ddp20$DisplayStatus, 2);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$ddp20$FrameInfo == null ? (class$org$dsi$ifc$ddp20$FrameInfo = DSIDDP20Tracer.class$("org.dsi.ifc.ddp20.FrameInfo")) : class$org$dsi$ifc$ddp20$FrameInfo, 3);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$ddp20$FrameRequest == null ? (class$org$dsi$ifc$ddp20$FrameRequest = DSIDDP20Tracer.class$("org.dsi.ifc.ddp20.FrameRequest")) : class$org$dsi$ifc$ddp20$FrameRequest, 4);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$ddp20$FrameUpdate == null ? (class$org$dsi$ifc$ddp20$FrameUpdate = DSIDDP20Tracer.class$("org.dsi.ifc.ddp20.FrameUpdate")) : class$org$dsi$ifc$ddp20$FrameUpdate, 5);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$ddp20$ProjectInfo == null ? (class$org$dsi$ifc$ddp20$ProjectInfo = DSIDDP20Tracer.class$("org.dsi.ifc.ddp20.ProjectInfo")) : class$org$dsi$ifc$ddp20$ProjectInfo, 6);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$ddp20$UpdateRequest == null ? (class$org$dsi$ifc$ddp20$UpdateRequest = DSIDDP20Tracer.class$("org.dsi.ifc.ddp20.UpdateRequest")) : class$org$dsi$ifc$ddp20$UpdateRequest, 7);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$ddp20$VersionInfo == null ? (class$org$dsi$ifc$ddp20$VersionInfo = DSIDDP20Tracer.class$("org.dsi.ifc.ddp20.VersionInfo")) : class$org$dsi$ifc$ddp20$VersionInfo, 8);
    }

    @Override
    public void traceDSIObject(PrintWriter printWriter, Object object) {
        if (printWriter == null) {
            return;
        }
        switch (this.resolveID(object)) {
            case 1: {
                this.traceDisplayRequest(printWriter, (DisplayRequest)object);
                break;
            }
            case 2: {
                this.traceDisplayStatus(printWriter, (DisplayStatus)object);
                break;
            }
            case 3: {
                this.traceFrameInfo(printWriter, (FrameInfo)object);
                break;
            }
            case 4: {
                this.traceFrameRequest(printWriter, (FrameRequest)object);
                break;
            }
            case 5: {
                this.traceFrameUpdate(printWriter, (FrameUpdate)object);
                break;
            }
            case 6: {
                this.traceProjectInfo(printWriter, (ProjectInfo)object);
                break;
            }
            case 7: {
                this.traceUpdateRequest(printWriter, (UpdateRequest)object);
                break;
            }
            case 8: {
                this.traceVersionInfo(printWriter, (VersionInfo)object);
                break;
            }
            default: {
                throw new IllegalArgumentException(new StringBuffer().append("Not a valid DSI object for tracing: ").append(object.getClass()).toString());
            }
        }
    }

    private void traceDisplayRequest(PrintWriter printWriter, DisplayRequest displayRequest) {
        if (displayRequest == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(displayRequest.numFrames);
        if (displayRequest.frameRequest == null) {
            printWriter.print(-1);
        } else {
            printWriter.print(0);
            int n = displayRequest.frameRequest.length;
            printWriter.print(n);
            for (int i2 = 0; i2 < n; ++i2) {
                this.trace(printWriter, displayRequest.frameRequest[i2]);
            }
        }
    }

    private void traceDisplayStatus(PrintWriter printWriter, DisplayStatus displayStatus) {
        if (displayStatus == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(displayStatus.contextID);
        printWriter.print(displayStatus.reason);
        printWriter.print(displayStatus.numVisible);
        if (displayStatus.frameInfo == null) {
            printWriter.print(-1);
        } else {
            printWriter.print(0);
            int n = displayStatus.frameInfo.length;
            printWriter.print(n);
            for (int i2 = 0; i2 < n; ++i2) {
                this.trace(printWriter, displayStatus.frameInfo[i2]);
            }
        }
    }

    private void traceFrameInfo(PrintWriter printWriter, FrameInfo frameInfo) {
        if (frameInfo == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(frameInfo.frameID);
        printWriter.print(frameInfo.eventFocus);
        printWriter.print(frameInfo.offset);
    }

    private void traceFrameRequest(PrintWriter printWriter, FrameRequest frameRequest) {
        if (frameRequest == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(frameRequest.frameID);
        printWriter.print(frameRequest.request);
    }

    private void traceFrameUpdate(PrintWriter printWriter, FrameUpdate frameUpdate) {
        if (frameUpdate == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(frameUpdate.frameID);
        printWriter.print(frameUpdate.offset);
    }

    private void traceProjectInfo(PrintWriter printWriter, ProjectInfo projectInfo) {
        if (projectInfo == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(projectInfo.brand);
        printWriter.print(projectInfo.classification);
        printWriter.print(projectInfo.generation);
        printWriter.print(projectInfo.derivate);
        printWriter.print(projectInfo.addition);
    }

    private void traceUpdateRequest(PrintWriter printWriter, UpdateRequest updateRequest) {
        if (updateRequest == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(updateRequest.numFrames);
        if (updateRequest.frameUpdate == null) {
            printWriter.print(-1);
        } else {
            printWriter.print(0);
            int n = updateRequest.frameUpdate.length;
            printWriter.print(n);
            for (int i2 = 0; i2 < n; ++i2) {
                this.trace(printWriter, updateRequest.frameUpdate[i2]);
            }
        }
    }

    private void traceVersionInfo(PrintWriter printWriter, VersionInfo versionInfo) {
        if (versionInfo == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(versionInfo.ident);
        printWriter.print(versionInfo.manufacturer);
        printWriter.print(versionInfo.swInfo);
        this.trace(printWriter, versionInfo.projectInfo);
        printWriter.print(versionInfo.protocolVersion);
        printWriter.print(versionInfo.characterVersion);
        printWriter.print(versionInfo.symbolVersion);
        printWriter.print(versionInfo.frameVersion);
        printWriter.print(versionInfo.bitmapVersion);
        printWriter.print(versionInfo.displayInfo);
        printWriter.print(versionInfo.windowCaching);
        printWriter.print(versionInfo.numEntriesMenu);
        printWriter.print(versionInfo.numEntriesSubmenu);
        printWriter.print(versionInfo.numEntriesPopup);
        printWriter.print(versionInfo.numLaneGuidanceBoxes);
        printWriter.print(versionInfo.numFrameIDs);
        if (versionInfo.frameIDs == null) {
            printWriter.print(-1);
        } else {
            printWriter.print(0);
            int n = versionInfo.frameIDs.length;
            printWriter.print(n);
            for (int i2 = 0; i2 < n; ++i2) {
                printWriter.print(versionInfo.frameIDs[i2]);
            }
        }
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

