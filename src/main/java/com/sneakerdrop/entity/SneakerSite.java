package com.sneakerdrop.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "sneaker_site")
public class SneakerSite {
    @Id
    private String siteId;
    private String siteName;

    @ManyToOne
    @JoinColumn(name = "userId")
    private User user;
}

