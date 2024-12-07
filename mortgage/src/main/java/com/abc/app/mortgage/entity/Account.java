package com.abc.app.mortgage.entity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Data
@AllArgsConstructor(staticName = "build")
@NoArgsConstructor
@Table(name = "account")
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "account_id", nullable = false)
    private Long accountId;

    @Column(name = "account_name", nullable = false, unique = true)
    private String accountName;

    @Column(name = "account_type_id")
    private Long accountTypeId;

    @Column(name = "is_active")
    private String isActive;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    private User user;

    @Column(name = "balance_amount", nullable = false, precision = 15, scale = 2)
    private BigDecimal balanceAmount;

    @Column(name = "created_dt")
    private LocalDateTime createdDate;

    @Column(name = "updated_dt")
    private LocalDateTime updatedDate;

    @Column(name = "crested_by")
    private Long createdBy;

    @Column(name = "updated_by")
    private String updatedBy;


}
