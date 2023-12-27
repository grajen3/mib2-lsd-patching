/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.shield.nar;

import de.vw.mib.asl.api.navigation.util.ASLNavigationUtilFactory;
import de.vw.mib.asl.internal.navigation.gateway.Command;
import de.vw.mib.asl.internal.navigation.gateway.command.CmdTryMatchLocation;
import de.vw.mib.asl.internal.navigation.shield.nar.TargetShield;

class TargetShield$2
implements Runnable {
    private final /* synthetic */ Command val$cmd;
    private final /* synthetic */ boolean val$isHigh;
    private final /* synthetic */ TargetShield this$0;

    TargetShield$2(TargetShield targetShield, Command command, boolean bl) {
        this.this$0 = targetShield;
        this.val$cmd = command;
        this.val$isHigh = bl;
    }

    @Override
    public void run() {
        this.this$0.waitingForSearchResultsToBeResolved = false;
        if (((CmdTryMatchLocation)this.val$cmd).liTryMatchLocationResult_result == null || ((CmdTryMatchLocation)this.val$cmd).liTryMatchLocationResult_result.length == 0 || ((CmdTryMatchLocation)this.val$cmd).liTryMatchLocationResult_result[0] == null || ((CmdTryMatchLocation)this.val$cmd).liTryMatchLocationResult_result[0].location == null) {
            TargetShield.logger.makeError().append("liTryMatchLocationResult sent from southside is empty or null, SHIELD address could not be resolved").log();
            ASLNavigationUtilFactory.getNavigationUtilApi().getNaviHelper().resetNaviContext("liTryMatchLocationResult sent from southside is empty or null, SHIELD address could not be resolved");
            return;
        }
        boolean bl = true;
        if (TargetShield.selectedSearchResult.getSource() == 4 || TargetShield.selectedSearchResult.entryType == 2 || !this.val$isHigh && TargetShield.selectedSearchResult.entryType == 16) {
            bl = false;
        }
        this.this$0.handleSelectedSearchResult(((CmdTryMatchLocation)this.val$cmd).liTryMatchLocationResult_result[0].location, this.this$0.destinationDistance, this.this$0.destinationDirection, ((CmdTryMatchLocation)this.val$cmd).liTryMatchLocationResult_result[0].getMatchLevel(), bl);
    }
}

