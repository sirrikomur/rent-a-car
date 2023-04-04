package bootcamps.turkcell.rentacar.domain.entities;

import bootcamps.turkcell.rentacar.domain.enums.CarState;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "cars")
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private short modelYear;
    private String licensePlate;
    @Enumerated(EnumType.STRING)
    private CarState state;
    private double dailyRental;

    @ManyToOne
    @JoinColumn(name = "model_id")
    private Model model;
}
