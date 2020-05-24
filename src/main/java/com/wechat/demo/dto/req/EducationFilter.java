package com.wechat.demo.dto.req;


import lombok.*;

@Data
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EducationFilter {

    private Integer page;
    private Integer limit;
    private Integer status;
}
