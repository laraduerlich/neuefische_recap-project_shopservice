package org.example;

import lombok.Builder;
import lombok.With;

import java.util.List;

@With
@Builder
public record Order(String id,
                    List<Product> products,
                    OrderStatus orderStatus) {
}
