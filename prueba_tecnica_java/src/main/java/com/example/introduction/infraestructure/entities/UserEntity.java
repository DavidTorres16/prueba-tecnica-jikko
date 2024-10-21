package com.example.introduction.infraestructure.entities;

import com.example.introduction.domain.models.BookReserve;
import com.example.introduction.domain.models.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="Member")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="userId")
    private Integer userId;

    @Column(name="age")
    private Integer age;

    @Column(name="name")
    private String name;

    @Column(name="lastName")
    private String lastName;

    @Column(name="personalId")
    private Integer personalId;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<BookReserveEntity> reservedBooks;

    public static UserEntity fromDomainModel(User user){
        return new UserEntity(user.getUserId(),
                user.getAge(),
                user.getName(),
                user.getLastName(),
                user.getPersonalId(),
                user.getReservedBooks() != null ? BookReserveEntity.fromDomainModelList(user.getReservedBooks()) : new ArrayList<>()
        );
    }

    public User toDomainModel(){
        return new User(this.userId, this.age, this.name, this.lastName, this.personalId, BookReserveEntity.toDomainModelList(this.reservedBooks));
    }

    public User toDomainModelWithoutBooks(){
        return new User(this.userId, this.age, this.name, this.lastName, this.personalId, null);
    }

}
