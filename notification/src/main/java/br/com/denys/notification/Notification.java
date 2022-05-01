package br.com.denys.notification;

import jdk.jfr.Timestamp;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import java.time.LocalDateTime;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@SequenceGenerator(
        name = "notification_id_sequence",
        sequenceName = "notification_id_sequence",
        allocationSize = 1
)
@ToString
public class Notification {

    @Id
    @GeneratedValue(generator = "notification_id_sequence", strategy = GenerationType.SEQUENCE)
    private Long id;
    private String message;
    private String sender;
    @Timestamp
    private LocalDateTime sentAt;
    private String toCustomerEmail;
    private Long toCustomerId;
}
