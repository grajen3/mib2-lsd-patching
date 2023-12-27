/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.trafficminimap.control;

import de.vw.mib.asl.internal.trafficminimap.control.TrafficMiniMapController;
import de.vw.mib.asl.internal.trafficminimap.control.TrafficMiniMapInfoList;
import de.vw.mib.asl.internal.trafficminimap.model.TrafficMiniMapModelController;
import de.vw.mib.asl.internal.trafficminimap.persistence.TrafficMiniMapPersistence;
import de.vw.mib.asl.internal.trafficminimap.states.TrafficMiniMapTarget;

public class TrafficMiniMapManager {
    private static TrafficMiniMapTarget _target;
    private static TrafficMiniMapController _controller;
    private static TrafficMiniMapModelController _modelController;
    private static TrafficMiniMapInfoList _messageList;
    private static TrafficMiniMapPersistence _trafficMiniMapPersistence;

    public static TrafficMiniMapTarget getTrafficMiniMapTarget() {
        return _target;
    }

    public static void setTrafficMiniMapTarget(TrafficMiniMapTarget trafficMiniMapTarget) {
        _target = trafficMiniMapTarget;
    }

    public static TrafficMiniMapController getTrafficMiniMapController() {
        if (_controller == null && TrafficMiniMapManager.getTrafficMiniMapTarget() != null) {
            _controller = new TrafficMiniMapController(TrafficMiniMapManager.getTrafficMiniMapTarget());
        }
        return _controller;
    }

    public static TrafficMiniMapModelController getModelController() {
        if (_modelController == null) {
            _modelController = new TrafficMiniMapModelController();
        }
        return _modelController;
    }

    public static TrafficMiniMapPersistence getPersistence() {
        if (_trafficMiniMapPersistence == null) {
            _trafficMiniMapPersistence = new TrafficMiniMapPersistence();
        }
        return _trafficMiniMapPersistence;
    }

    public static TrafficMiniMapInfoList getMessageList() {
        if (_messageList == null) {
            _messageList = new TrafficMiniMapInfoList();
        }
        return _messageList;
    }
}

