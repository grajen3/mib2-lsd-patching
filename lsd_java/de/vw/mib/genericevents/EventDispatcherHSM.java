/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.genericevents;

import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.EventRouter;
import de.vw.mib.genericevents.EventSender;
import de.vw.mib.genericevents.Target;
import de.vw.mib.genericevents.TaskInterface;
import java.util.Collection;
import java.util.HashMap;

public interface EventDispatcherHSM
extends EventSender {
    default public void dispose() {
    }

    default public int getNextRouterId() {
    }

    default public int getNextTargetId() {
    }

    default public String getRandomTaskId() {
    }

    default public Target getTarget(int n) {
    }

    default public HashMap getTargets() {
    }

    default public TaskInterface getTask(int n) {
    }

    default public TaskInterface getTask(String string) {
    }

    default public String getTaskId(int n) {
    }

    default public Collection getTasks() {
    }

    default public boolean isQueueOverloaded() {
    }

    default public boolean isTargetRegistered(int n) {
    }

    default public void registerRouter(EventRouter eventRouter) {
    }

    default public void registerTarget(int n, Target target, String string) {
    }

    default public void registerTarget(int n, Target target, String string, boolean bl) {
    }

    default public int registerTarget(Target target) {
    }

    default public int registerTarget(Target target, String string) {
    }

    default public void registerTask(String string, TaskInterface taskInterface) {
    }

    default public void sendBack(EventGeneric eventGeneric) {
    }

    default public void sendSafe(EventGeneric eventGeneric) {
    }

    default public void unregisterRouter(EventRouter eventRouter) {
    }

    default public void unregisterTarget(int n) {
    }

    default public void unregisterTarget(int n, boolean bl) {
    }

    default public void unregisterTask(String string) {
    }
}

