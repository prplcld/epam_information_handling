package by.silebin.information_handling.entity;

import java.util.Collection;

public abstract class AbstractComponent {
    public abstract int countElements();
    public abstract void add(AbstractComponent component);
    public abstract void remove(AbstractComponent component);
    public abstract Collection<AbstractComponent> getChildren();
}
