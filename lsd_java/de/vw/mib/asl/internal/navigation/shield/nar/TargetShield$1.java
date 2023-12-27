/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.shield.nar;

import de.vw.mib.asl.api.navigation.util.ASLNavigationUtilFactory;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.navigation.gateway.command.CmdTryMatchLocation;
import de.vw.mib.asl.internal.navigation.shield.nar.TargetShield;
import de.vw.mib.asl.internal.navigation.shield.transformer.ShieldCollector;
import de.vw.mib.asl.internal.navigation.slde.SldeEventHelper;
import de.vw.mib.genericevents.EventGeneric;

class TargetShield$1
implements Runnable {
    private final /* synthetic */ CmdTryMatchLocation val$cmd;
    private final /* synthetic */ ShieldCollector val$result;
    private final /* synthetic */ TargetShield this$0;

    TargetShield$1(TargetShield targetShield, CmdTryMatchLocation cmdTryMatchLocation, ShieldCollector shieldCollector) {
        this.this$0 = targetShield;
        this.val$cmd = cmdTryMatchLocation;
        this.val$result = shieldCollector;
    }

    @Override
    public void run() {
        if (this.val$cmd.liTryMatchLocationResult_result == null || this.val$cmd.liTryMatchLocationResult_result.length == 0 || this.val$cmd.liTryMatchLocationResult_result[0] == null || this.val$cmd.liTryMatchLocationResult_result[0].location == null) {
            TargetShield.logger.makeError().append("liTryMatchLocationResult sent from southside is empty or null, SHIELD address could not be resolved").log();
            ASLNavigationUtilFactory.getNavigationUtilApi().getNaviHelper().resetNaviContext("liTryMatchLocationResult sent from southside is empty or null, SHIELD address could not be resolved");
        } else {
            EventGeneric eventGeneric = SldeEventHelper.generateEvent(this.this$0.getTargetId(), 137966848);
            eventGeneric.setObject(154744064, this.val$cmd.liTryMatchLocationResult_result[0].location);
            eventGeneric.setObject(171521280, this.val$result);
            ServiceManager.eventMain.getEventDispatcher().sendSafe(eventGeneric);
        }
    }
}

