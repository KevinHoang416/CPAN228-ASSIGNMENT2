package com.cpan228.Assignment1.model;

import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@Table
public class Item {
    public enum Brand {
        Dior("Dior"), American_Eagle("American Eagle"), Polo("Polo"), Louis_Vuitton("Louis Vuitton");

        private String title;

        private Brand(String title) {
            this.title = title;
        }

        public String getTitle() {
            return title;
        }
    }

    @Id
    private Long id;
    @NotBlank
    private String name;
    @Min(1000)
    private int price;
    @Min(2021)
    private int year_of_creation;
    private Brand brandFrom;
    @Builder.Default
    private LocalDateTime createdAt = LocalDateTime.now();
}
