/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.startupv7r.model;

import de.vw.mib.asl.framework.internal.startupv7r.model.AbstractWorkUnit;

public class ContextWorkUnit
extends AbstractWorkUnit {
    private int[] dsiInterfacesToStart = new int[0];
    private boolean[] dsiDoNotWaitFlags = new boolean[0];
    private int[] aslTargetsToStart = new int[0];
    private String[] aslComponentQualifiedNames = new String[0];
    private String[] aslComponentNames = new String[0];
    private int[] domainToStart = new int[0];
    private int[] domainStateToReach = new int[0];
    private boolean[] domainDoNotWaitFlags = new boolean[0];
    private int listenerConstantForUpdateToHmi;
    private int[] persistenceIdsForContext = new int[0];
    private int bitmaskToCheckForSpecialExitConditions;
    private int bitmaskToCheckForSpecialEntryConditions;

    public int[] getDsiInterfacesToStart() {
        return this.dsiInterfacesToStart;
    }

    public void setDsiInterfacesToStart(int[] nArray) {
        this.dsiInterfacesToStart = nArray;
    }

    public boolean[] getDsiDoNotWaitFlags() {
        return this.dsiDoNotWaitFlags;
    }

    public void setDsiDoNotWaitFlags(boolean[] blArray) {
        this.dsiDoNotWaitFlags = blArray;
    }

    public int[] getAslTargetsToStart() {
        return this.aslTargetsToStart;
    }

    public void setAslTargetsToStart(int[] nArray) {
        this.aslTargetsToStart = nArray;
    }

    public int[] getDomainToStart() {
        return this.domainToStart;
    }

    public void setDomainToStart(int[] nArray) {
        this.domainToStart = nArray;
    }

    public int[] getDomainStateToReach() {
        return this.domainStateToReach;
    }

    public void setDomainStateToReach(int[] nArray) {
        this.domainStateToReach = nArray;
    }

    public int getListenerConstantForUpdateToHmi() {
        return this.listenerConstantForUpdateToHmi;
    }

    public void setListenerConstantForUpdateToHmi(int n) {
        this.listenerConstantForUpdateToHmi = n;
    }

    public int[] getPersistenceIdsForContext() {
        return this.persistenceIdsForContext;
    }

    public void setPersistenceIdsForContext(int[] nArray) {
        this.persistenceIdsForContext = nArray;
    }

    public int getBitmaskToCheckForSpecialExitConditions() {
        return this.bitmaskToCheckForSpecialExitConditions;
    }

    public void setBitmaskToCheckForSpecialExitConditions(int n) {
        this.bitmaskToCheckForSpecialExitConditions = n;
    }

    public int getBitmaskToCheckForSpecialEntryConditions() {
        return this.bitmaskToCheckForSpecialEntryConditions;
    }

    public void setBitmaskToCheckForSpecialEntryConditions(int n) {
        this.bitmaskToCheckForSpecialEntryConditions = n;
    }

    public boolean[] getDomainDoNotWaitFlags() {
        return this.domainDoNotWaitFlags;
    }

    public void setDomainDoNotWaitFlags(boolean[] blArray) {
        this.domainDoNotWaitFlags = blArray;
    }

    public String[] getAslComponentQualifiedNames() {
        return this.aslComponentQualifiedNames;
    }

    public void setAslComponentQualifiedNames(String[] stringArray) {
        this.aslComponentQualifiedNames = stringArray;
    }

    public String[] getAslComponentNames() {
        return this.aslComponentNames;
    }

    public void setAslComponentNames(String[] stringArray) {
        this.aslComponentNames = stringArray;
    }
}

