package shop.mtcoding.teamproject.reply;

import java.security.Timestamp;

import lombok.Getter;
import lombok.Setter;

public class ReplyRequest {

    @Getter
    @Setter
    public static class SaveDTO {
        private String comment;
        private Timestamp updateTime;
        private Integer boardIdx;
        private Integer compIdx;
        private Integer userIdx;
    }

}
