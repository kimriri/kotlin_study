package dataclass;

import dataclass.PojoClassEqual;

public class PojoClassEqualHashCode extends PojoClassEqual {
    @Override
    public int hashCode() {
        return textData.hashCode() * 31;
    }
}
