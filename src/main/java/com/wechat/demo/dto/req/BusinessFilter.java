package com.wechat.demo.dto.req;


import lombok.*;

@Data
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BusinessFilter {

    private Integer page;
    private Integer limit;
    private Integer status;
}
