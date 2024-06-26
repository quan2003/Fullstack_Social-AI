package com.example.mxhfullstack.response;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class NotificationFollowResponse {
    @JsonProperty("post_id")
    private Long postId;

    @JsonProperty("share_id")
    private Long shareId;

    private String avatar;
}
