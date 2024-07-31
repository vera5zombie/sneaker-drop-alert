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
public class SneakerSite {
    @Id
    private String siteId;
    private String siteName;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}

