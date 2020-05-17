package com.wechat.demo.dto.rsp;

import lombok.*;

@Data
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserInfo {
    private String token;
    private String name;
    private String role;
    private String headImg;
}
