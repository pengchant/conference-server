package com.justcs.form;

import io.swagger.annotations.ApiModel;

import javax.validation.constraints.NotBlank;

/**
 * 修改议题结论的实体
 */
@ApiModel(value = "修改议题结论的实体")
public class UpdateConclusionView {

    @NotBlank(message = "议题编号不能为空")
    private String conftitleid;

    @NotBlank(message = "议题结论不能为空")
    private String conclusion;

    public String getConftitleid() {
        return conftitleid;
    }

    public void setConftitleid(String conftitleid) {
        this.conftitleid = conftitleid;
    }

    public String getConclusion() {
        return conclusion;
    }

    public void setConclusion(String conclusion) {
        this.conclusion = conclusion;
    }
}
