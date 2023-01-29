package com.andes.metamon.config.jwt;

import lombok.Getter;

@Getter
public class MemberPayload {
    private Long id;

    public MemberPayload(Long id) {
        this.id = id;
    }
}
