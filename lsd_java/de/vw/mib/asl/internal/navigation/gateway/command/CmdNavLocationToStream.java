/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.gateway.command;

import de.vw.mib.asl.internal.navigation.gateway.Command;
import de.vw.mib.asl.internal.navigation.gateway.INavGateway;
import de.vw.mib.asl.internal.navigation.gateway.command.NavGatewayListener;
import org.dsi.ifc.global.NavLocation;

public class CmdNavLocationToStream
extends Command {
    private final int locationType;
    private final NavLocation locationToStream;
    private byte[] streamOfLocation = null;
    private boolean resultSuccess = false;

    public CmdNavLocationToStream(NavGatewayListener navGatewayListener, int n, NavLocation navLocation) {
        super(1092, 2043, navGatewayListener);
        this.locationType = n;
        this.locationToStream = navLocation;
    }

    @Override
    protected void execute(INavGateway iNavGateway) {
        iNavGateway.getDsiNavigation().locationToStream(this.getLocationToStream());
    }

    @Override
    public void locationToStreamResult(boolean bl, byte[] byArray) {
        this.setStreamOfLocation(byArray);
        this.setResultSuccess(bl);
        this.checkAnswerSum(2043);
    }

    @Override
    public void onFinish() {
        this.l.handleCommandCmdNavLocationToStream(this);
    }

    private void setStreamOfLocation(byte[] byArray) {
        this.streamOfLocation = byArray;
    }

    public byte[] getStreamOfLocation() {
        return this.streamOfLocation;
    }

    public int getLocationType() {
        return this.locationType;
    }

    private void setResultSuccess(boolean bl) {
        this.resultSuccess = bl;
    }

    public boolean isResultSuccess() {
        return this.resultSuccess;
    }

    public NavLocation getLocationToStream() {
        return this.locationToStream;
    }
}

