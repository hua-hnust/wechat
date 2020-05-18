package com.wechat.demo.dto.req;

import lombok.*;

@Data
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LoginParam {
    private String code;
    private String phone;
    private String password;
}
