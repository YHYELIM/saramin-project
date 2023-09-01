package shop.mtcoding.teamproject.reply;

import java.sql.Timestamp;

import javax.persistence.*;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
@Table(name = "reply_tb")
@Entity
public class Reply {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer index;

    private String comment;

    private Timestamp updateTime;

    private Integer userIdx;

    private Integer compIdx;

    private Integer boardIdx;

    @Builder
    public Reply(Integer index, String comment, Timestamp updateTime, Integer userIdx, Integer compIdx,
            Integer boardIdx) {
        this.index = index;
        this.comment = comment;
        this.updateTime = updateTime;
        this.userIdx = userIdx;
        this.compIdx = compIdx;
        this.boardIdx = boardIdx;
    }

}
