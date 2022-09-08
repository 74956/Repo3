package org.example.object;

import lombok.Data;

import java.util.List;
import java.util.Objects;

@Data
public class PhoneProduct extends BaseProduct {

    private String size;
    private String color;
    private String serviceProvider;

    public PhoneProduct() {
    }

    public PhoneProduct(List<String> data) {
        super(data);
        this.size = data.get(1);
        this.color = data.get(2);
        this.serviceProvider = data.get(3);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        PhoneProduct that = (PhoneProduct) o;

        if (!Objects.equals(size, that.size)) return false;
        if (!Objects.equals(color, that.color)) return false;
        return Objects.equals(serviceProvider, that.serviceProvider);
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (size != null ? size.hashCode() : 0);
        result = 31 * result + (color != null ? color.hashCode() : 0);
        result = 31 * result + (serviceProvider != null ? serviceProvider.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "PhoneProduct{" +
                ", size='" + size + '\'' +
                ", color='" + color + '\'' +
                ", serviceProvider='" + serviceProvider + '\'' +
                '}';
    }
}
