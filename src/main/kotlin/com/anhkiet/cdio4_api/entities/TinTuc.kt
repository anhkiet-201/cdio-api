package com.anhkiet.cdio4_api.entities

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.FetchType
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import java.time.OffsetDateTime


@Entity
class TinTuc {

    @Id
    @Column(
        nullable = false,
        updatable = false
    )
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var idtinTuc: Int? = null

    @Column(length = 100)
    var title: String? = null

    @Column
    var createTime: OffsetDateTime? = null

    @Column(columnDefinition = "longtext")
    var contents: String? = null

    @Column(length = 225)
    var avatar: String? = null

    @Column
    var state: Int? = null

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "create_by_id")
    var createBy: TaiKhoan? = null

}
