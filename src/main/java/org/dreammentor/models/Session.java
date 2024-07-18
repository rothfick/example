package org.dreammentor.models;


import jakarta.persistence.*;
import lombok.Data;
;

import java.time.LocalDateTime;

@Entity
@Data
public class Session {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDateTime date;
    private String status; // "PLANNED", "COMPLETED", "CANCELLED"
    private Double price;

    @ManyToOne
    private User mentor;

    @ManyToOne
    private User podopieczny;
}
