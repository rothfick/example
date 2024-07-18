package org.dreammentor.models;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer rating;
    private String comment;

    @ManyToOne
    private User mentor;

    @ManyToOne
    private User podopieczny;

    @ManyToOne
    private Session session;
}
