package by.silebin.information_handling.entity;

import java.util.ArrayList;
import java.util.List;

public abstract class Composite implements Component {

    protected List<Component> children = new ArrayList<>();

    public boolean addChild(Component child) {
        return children.add(child);
    }

    public boolean removeChild(Component child) {
        return children.remove(child);
    }

    @Override
    public int countElements() {
        return children.size();
    }
}
