package org.code.challenger.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "USER_SUBMISSION")
@Getter
@Setter
@NoArgsConstructor
public class UserSubmission {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "user_name")
    private String userName;

    private String input;

    private boolean success;

    @Column(name = "result_message")
    private String resultMessage;

    @ManyToOne
    private Task task;
}
