/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.gateway.command;

import de.vw.mib.asl.internal.navigation.gateway.Command;
import de.vw.mib.asl.internal.navigation.gateway.INavGateway;
import de.vw.mib.asl.internal.navigation.gateway.command.NavGatewayListener;
import org.dsi.ifc.global.NavLocation;

public class CmdStreamToNavLocation
extends Command {
    private NavLocation locationToStream = null;
    private final byte[] streamOfLocation;
    private final int locationType;
    private boolean resultSuccess = false;

    public CmdStreamToNavLocation(NavGatewayListener navGatewayListener, int n, byte[] byArray) {
        super(1093, 2044, navGatewayListener);
        this.streamOfLocation = byArray;
        this.locationType = n;
    }

    @Override
    protected void execute(INavGateway iNavGateway) {
        iNavGateway.getDsiNavigation().streamToLocation(this.getStreamOfLocation());
    }

    @Override
    public void streamToLocationResult(boolean bl, NavLocation navLocation) {
        this.setLocationToStream(navLocation);
        this.setResultSuccess(bl);
        this.checkAnswerSum(2044);
    }

    @Override
    public void onFinish() {
        this.l.handleCommandCmdStreamToNavLocation(this);
    }

    private void setLocationToStream(NavLocation navLocation) {
        this.locationToStream = navLocation;
    }

    public NavLocation getLocationToStream() {
        return this.locationToStream;
    }

    public int getLocationType() {
        return this.locationType;
    }

    public byte[] getStreamOfLocation() {
        return this.streamOfLocation;
    }

    private void setResultSuccess(boolean bl) {
        this.resultSuccess = bl;
    }

    public boolean isResultSuccess() {
        return this.resultSuccess;
    }
}

