package api.entity;

import org.springframework.stereotype.Component;

import java.util.Objects;


@Component
public class Usage extends BaseEntity implements Entity {

    public Double income = 0.0;
    public Double projected = 0.0;
    public Double actual = 0.0;
    public Double remaining = 0.0;





    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Usage usage = (Usage) o;
        return Objects.equals(income, usage.income) &&
                Objects.equals(projected, usage.projected) &&
                Objects.equals(actual, usage.actual) &&
                Objects.equals(remaining, usage.remaining);
    }

    @Override
    public int hashCode() {
        return Objects.hash(income, projected, actual, remaining);
    }

}
