package dev.jacbes.stest.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductEntity {

    @Id
    @Column
    @GenericGenerator(name = "increment_generator", strategy = "increment")
    @GeneratedValue(generator = "increment_generator")
    Long id;

    @Column
    String name;

    @Column
    Integer price;
}
