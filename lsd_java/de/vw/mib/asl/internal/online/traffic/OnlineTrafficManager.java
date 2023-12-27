/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.online.traffic;

import de.vw.mib.asl.internal.online.traffic.OnlineTrafficController;
import de.vw.mib.asl.internal.online.traffic.states.OnlineTrafficTarget;

public class OnlineTrafficManager {
    private static OnlineTrafficTarget _target;
    private static OnlineTrafficController _controller;

    public static OnlineTrafficTarget getOnlineTrafficTarget() {
        return _target;
    }

    public static void setOnlineTrafficTarget(OnlineTrafficTarget onlineTrafficTarget) {
        _target = onlineTrafficTarget;
    }

    public static OnlineTrafficController getOnlineTrafficController() {
        if (_controller == null) {
            _controller = new OnlineTrafficController();
        }
        return _controller;
    }
}

