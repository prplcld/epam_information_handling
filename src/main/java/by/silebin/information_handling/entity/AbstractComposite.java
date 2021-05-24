package by.silebin.information_handling.entity;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public abstract class AbstractComposite extends AbstractComponent {

    protected List<AbstractComponent> children = new ArrayList<>();

    @Override
    public void add(AbstractComponent component) {
        children.add(component);
    }

    @Override
    public void remove(AbstractComponent component) {
        children.remove(component);
    }

    @Override
    public Collection<AbstractComponent> getChildren() {
        return children;
    }

    @Override
    public int countElements() {
        return children.size();
    }
}
