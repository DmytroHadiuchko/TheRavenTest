package theraven.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.SQLRestriction;

@Entity
@Getter
@Setter
@Table(name = "customers")
@SQLDelete(sql= "UPDATE customers SET is_active = true WHERE id=?")
@SQLRestriction(value = "is_active=false")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "full_name")
    private String fullName;
    private String email;
    private String phone;
    @Column(name = "is_active", nullable = false, columnDefinition = "TINYINT(1)")
    private boolean is_active;
    private Long created;
    private Long updated;

}
