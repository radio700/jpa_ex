package com.jinju.data.entity;

import java.time.LocalDateTime;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString(callSuper = true)
@Table(name = "KT_PBL_SPEC")
public class KT_PBL_SPEC {
    
    @Id
    @Column(name = "ACFTC")
    private String acftc;

    @Id
    @Column(name = "PN")
    private String pn;

    @Id
    @Column(name = "CAGE")
    private String cage;


    @Column(nullable = false)
    private String nog_kor;

    @Column(nullable = false)
    private String nog_eng;

    @Column(nullable = false)
    private String ins_usrid;

    @Column(nullable = false)
    private LocalDateTime ins_dttm;

    private String upd_usrid;

    private LocalDateTime upd_dttm;
}
