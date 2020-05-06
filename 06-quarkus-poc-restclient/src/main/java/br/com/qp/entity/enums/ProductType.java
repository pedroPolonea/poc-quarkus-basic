package br.com.qp.entity.enums;

import java.util.Arrays;

public enum ProductType {
    ELECTRONICS("ELE"),
    HOME_APPLIANCES("HPP"),
    KITCHEN("KIT"),
    BATHROOM("BAT"),
    MOVIE("MOV");

    private final String tag;

    ProductType(final String tag) {
        this.tag = tag;
    }

    public static String getName(final ProductType productType) {
        for (final ProductType type : ProductType.values()) {
            if (type.equals(productType)) {
                return type.name();
            }
        }
        return null;
    }

    public static ProductType fromValue(final String value) {
        return Arrays.stream(values())
                .filter(type -> value.equalsIgnoreCase(type.name()))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Tipo " + value + " não encontrado"));
    }

    public String getTag() {
        return tag;
    }
}
