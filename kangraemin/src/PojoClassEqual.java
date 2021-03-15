import java.util.Objects;

public class PojoClassEqual extends PojoClass {
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PojoClassEqual pojoClass = (PojoClassEqual) o;
        return numberData == pojoClass.numberData && Objects.equals(textData, pojoClass.textData);
    }
}
