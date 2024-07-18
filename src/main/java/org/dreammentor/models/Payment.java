package org.dreammentor.models;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Data
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate paymentDate;
    private Double amount;
    private Double commission;
    private Double tax;

    @ManyToOne
    private User mentor;

    @ManyToOne
    private User podopieczny;

    @ManyToOne
    private Session session;
}
