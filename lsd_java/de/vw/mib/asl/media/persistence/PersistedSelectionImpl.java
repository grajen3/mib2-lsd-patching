/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.media.persistence;

import de.vw.mib.asl.framework.api.framework.ASLFrameworkFactory;
import de.vw.mib.asl.framework.api.persistence.ASLPersistenceFactory;
import de.vw.mib.asl.framework.api.persistence2.AbstractPersistable;
import de.vw.mib.asl.framework.api.persistence2.HandlerFactory;
import de.vw.mib.asl.framework.api.persistence2.Persistable;
import de.vw.mib.asl.framework.api.persistence2.PersistenceModule;
import de.vw.mib.asl.framework.api.persistence2.collections.lists.PersistenceArrayList;
import de.vw.mib.asl.media.persistence.PersistedSelection;
import java.util.Iterator;
import java.util.List;

class PersistedSelectionImpl
extends AbstractPersistable
implements PersistedSelection {
    private final PersistenceModule module;
    private final PersistenceArrayList selectionPath = new PersistenceArrayList();
    private int playmode;
    private String uniqeMediaId;
    private int instanceId;
    private boolean compositeSelection;
    private int selectionScope;
    private boolean recursive;
    private boolean selected;
    private int selectionResult;
    private int selectionState;
    private long sizeAvailable;
    private long sizeSelected;
    private long entriesAvailable;
    private long entriesSelected;

    PersistedSelectionImpl(PersistenceModule persistenceModule) {
        super(ASLFrameworkFactory.getASLFrameworkAPI().getASLLogger(), ASLPersistenceFactory.getPersistenceApi());
        this.module = persistenceModule;
    }

    @Override
    public int getId() {
        return 8;
    }

    @Override
    public boolean hasUserSpecificData() {
        return false;
    }

    @Override
    public void updateRootPersistable(Persistable persistable) {
        this.setRootPersistable(persistable);
        this.selectionPath.setRootPersistable(persistable);
        Iterator iterator = this.getSelectionPath().iterator();
        while (iterator.hasNext()) {
            AbstractPersistable abstractPersistable = (AbstractPersistable)iterator.next();
            if (abstractPersistable == null) continue;
            abstractPersistable.updateRootPersistable(persistable);
        }
    }

    @Override
    public int getPlaymode() {
        return this.playmode;
    }

    @Override
    public void setPlaymode(int n) {
        this.playmode = n;
        this.markDirty();
    }

    @Override
    public String getUniqeMediaId() {
        return this.uniqeMediaId;
    }

    @Override
    public void setUniqeMediaId(String string) {
        this.uniqeMediaId = string;
        this.markDirty();
    }

    @Override
    public int getInstanceId() {
        return this.instanceId;
    }

    @Override
    public void setInstanceId(int n) {
        this.instanceId = n;
        this.markDirty();
    }

    @Override
    public boolean isCompositeSelection() {
        return this.compositeSelection;
    }

    @Override
    public void setCompositeSelection(boolean bl) {
        this.compositeSelection = bl;
        this.markDirty();
    }

    @Override
    public int getSelectionScope() {
        return this.selectionScope;
    }

    @Override
    public void setSelectionScope(int n) {
        this.selectionScope = n;
        this.markDirty();
    }

    @Override
    public List getSelectionPath() {
        return this.selectionPath;
    }

    @Override
    public boolean isRecursive() {
        return this.recursive;
    }

    @Override
    public void setRecursive(boolean bl) {
        this.recursive = bl;
        this.markDirty();
    }

    @Override
    public boolean isSelected() {
        return this.selected;
    }

    @Override
    public void setSelected(boolean bl) {
        this.selected = bl;
        this.markDirty();
    }

    @Override
    public int getSelectionResult() {
        return this.selectionResult;
    }

    @Override
    public void setSelectionResult(int n) {
        this.selectionResult = n;
        this.markDirty();
    }

    @Override
    public int getSelectionState() {
        return this.selectionState;
    }

    @Override
    public void setSelectionState(int n) {
        this.selectionState = n;
        this.markDirty();
    }

    @Override
    public long getSizeAvailable() {
        return this.sizeAvailable;
    }

    @Override
    public void setSizeAvailable(long l) {
        this.sizeAvailable = l;
        this.markDirty();
    }

    @Override
    public long getSizeSelected() {
        return this.sizeSelected;
    }

    @Override
    public void setSizeSelected(long l) {
        this.sizeSelected = l;
        this.markDirty();
    }

    @Override
    public long getEntriesAvailable() {
        return this.entriesAvailable;
    }

    @Override
    public void setEntriesAvailable(long l) {
        this.entriesAvailable = l;
        this.markDirty();
    }

    @Override
    public long getEntriesSelected() {
        return this.entriesSelected;
    }

    @Override
    public void setEntriesSelected(long l) {
        this.entriesSelected = l;
        this.markDirty();
    }

    @Override
    public void resetToDefaults() {
        HandlerFactory handlerFactory = this.module.getHandlerFactory();
        handlerFactory.createCommonHandler(this).finish();
    }
}

