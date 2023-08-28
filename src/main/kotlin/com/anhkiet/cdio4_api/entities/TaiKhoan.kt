package com.anhkiet.cdio4_api.entities

import com.fasterxml.jackson.annotation.JsonIgnore
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.OneToMany
import java.time.LocalDate


@Entity
class TaiKhoan {

    @Id
    @Column(
        nullable = false,
        updatable = false
    )
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var idtaiKhoan: Int? = null

    @Column(length = 50)
    var username: String? = null

    @JsonIgnore
    @Column
    var password: String? = null

    @Column(length = 500)
    var avatar: String? = null

    @Column(length = 50)
    var fullName: String? = null

    @Column
    var birthday: LocalDate? = null

    @Column(length = 50)
    var adress: String? = null

    @Column(length = 50)
    var phone: String? = null

    @Column(length = 50)
    var email: String? = null

    @Column(length = 50)
    var position: String? = null

    @Column
    var state: Int? = null

    @Column(
        name = "description_acc",
        columnDefinition = "longtext"
    )
    var description: String? = null

    @OneToMany(mappedBy = "idtaiKhoan")
    var idtaiKhoanDuAns: MutableSet<DuAn>? = null

    @OneToMany(mappedBy = "idtaiKhoan")
    var idtaiKhoanHouses: MutableSet<House>? = null

    @OneToMany(mappedBy = "createBy")
    var createByTinTucs: MutableSet<TinTuc>? = null

}
