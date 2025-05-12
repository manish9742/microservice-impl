package com.eapp.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Table(name="rating")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Rating {

    @Id
    @Column(name = "id")
    private String ratingId;
    @Column(name = "userid")
    private String userId;
    @Column(name = "hotelid")
    private String hotelId;
    private int rating;
    private String feedback;
}
